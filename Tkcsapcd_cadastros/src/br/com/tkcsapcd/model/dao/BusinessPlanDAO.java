/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tkcsapcd.conexao.InterfacePool;
import br.com.tkcsapcd.model.bean.BusinessPlan;
import br.com.tkcsapcd.model.util.Conexao;

public class BusinessPlanDAO implements InterfaceBusinessPlanDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public BusinessPlanDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM businessplan WHERE codigo = ?;";

			ps = con.prepareStatement(sqlExcluir);
			ps.setInt(1, codigo);//setando
			ps.executeUpdate();
			ps.close();
		} finally 
		{
			// fecha todos os recursos e devolve a conexao ao pool	        
	        if (ps != null && !ps.isClosed() ) {
	            try { ps.close(); } catch (SQLException e) { ; }
	            ps = null;
	        }
	        if (con != null && !con.isClosed() ) {
	            try { con.close(); } catch (SQLException e) { ; }
	            con = null;
	        }
		}			
	}
	
	private void setPreparedStatement(BusinessPlan businessPlan, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, businessPlan.getBusinessplan());
		ps.setString(2, businessPlan.getVersao());
		ps.setDate(3, new java.sql.Date(businessPlan.getData().getTime()));
		ps.setString(4, businessPlan.getAutor());
		ps.setString(5, businessPlan.getNotarevisao());
		ps.setString(6, businessPlan.getAprovacao());
		ps.setObject(7, businessPlan.getSituacaomercado());
		ps.setString(8, businessPlan.getSituacaoservico());
		ps.setString(9, businessPlan.getSituacaocompetividade());		
		ps.setString(10, businessPlan.getSituacaodistribuicao());
		ps.setString(11, businessPlan.getSituacaomacro());
		ps.setString(12, businessPlan.getAnaliseexterno());	
		ps.setString(13, businessPlan.getAnaliseinterno());
		ps.setString(14, businessPlan.getAnaliserelacionada());
		ps.setString(15, businessPlan.getObjetivofinanceiro());			
		ps.setString(16, businessPlan.getObjetivomarketing());
		ps.setString(17, businessPlan.getCronograma());
		ps.setString(18, businessPlan.getEstrategia());
		ps.setString(19, businessPlan.getSegmento());
		ps.setObject(20, businessPlan.getProjetoinicio().getCodigo());
		ps.setLong(21,businessPlan.getCodigo());
		
	}

	@Override
	public BusinessPlan getBusinessPlan(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM businessplan WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<BusinessPlan> resultado = getListaBusinessPlan(rs);
			
			if (resultado.size() > 0)			
				return resultado.get(0);//pegando elemento por chave (unico projeto!).			
			
			ps.close();			
		} finally 
		{
			 // fecha todos os recursos e devolve a conexao ao pool	        
			if (rs != null && !rs.isClosed() ) {
	            try { rs.close(); } catch (SQLException e) { ; }
	            rs = null;
	        }
			if (ps != null && !ps.isClosed() ) {
	            try { ps.close(); } catch (SQLException e) { ; }
	            ps = null;
	        }
	        if (con != null && !con.isClosed() ) {
	            try { con.close(); } catch (SQLException e) { ; }
	            con = null;
	        }
		}
		return null;
	}
	/*---------------------------------------------------------------------------------------------------------------------------------------*/

		//Metodo p confirma objetivo. Resulmir linhas de códigos, que pode ser usados em outros métodos. (ex: resultado = getListaCliente(rs); ou List<Cliente> resultado = getListaCliente(rs);)
		private List<BusinessPlan> getListaBusinessPlan(ResultSet rs) throws SQLException	{
				List<BusinessPlan> resultado = new ArrayList<BusinessPlan>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				BusinessPlan businessPlan = new BusinessPlan();
				
				businessPlan.setBusinessplan(rs.getString("businessplan"));
				businessPlan.setVersao(rs.getString("versao"));
				businessPlan.setData(rs.getDate("data"));
				businessPlan.setAutor(rs.getString("autor"));
				businessPlan.setNotarevisao(rs.getString("notarevisao"));
				businessPlan.setAprovacao(rs.getString("aprovacao"));		
				businessPlan.setSituacaomercado(rs.getString("situacaomercado"));
				businessPlan.setSituacaoservico(rs.getString("situacaoservico"));
				businessPlan.setSituacaocompetividade(rs.getString("situacaocompetividade"));
				businessPlan.setSituacaodistribuicao(rs.getString("situacaodistribuicao"));
				businessPlan.setSituacaomacro(rs.getString("situacaomacro"));
				businessPlan.setAnaliseexterno(rs.getString("analiseexterno"));
				businessPlan.setAnaliseinterno(rs.getString("analiseinterno"));
				businessPlan.setAnaliserelacionada(rs.getString("analiserelacionada"));					
				businessPlan.setObjetivofinanceiro(rs.getString("objetivofinanceiro"));
				businessPlan.setObjetivomarketing(rs.getString("objetivomarketing"));
				businessPlan.setCronograma(rs.getString("cronograma"));
				businessPlan.setEstrategia(rs.getString("estrategia"));					
				businessPlan.setSegmento(rs.getString("segmento"));
				businessPlan.setCodigo(rs.getLong("codigo"));
				
				//businessPlan.getProjetoinicio().setCodigo(rs.getLong("codigo"));
																
				resultado.add(businessPlan);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(BusinessPlan BusinessPlan) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{		
			String sqlAtualizar = "UPDATE businessplan SET 	businessplan = ?, versao = ?, data = ?, autor = ?, notarevisao = ?, aprovacao = ?, situacaomercado = ?, situacaoservico = ?, situacaocompetividade = ?, situacaodistribuicao = ?, situacaomacro = ?, analiseexterno = ?, analiseinterno = ?, analiserelacionada = ?, objetivofinanceiro = ?, objetivomarketing = ?, cronograma = ?, estrategia = ?, segmento = ?, projetoinicio = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(BusinessPlan, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
					
			ps.executeUpdate();//Linha muito importante, sem ela não é executado a atualização do cliente
			ps.close();	
			
		}finally{
			// fecha todos os recursos e devolve a conexao ao pool	        
	        if (ps != null && !ps.isClosed() ) {
	            try { ps.close(); } catch (SQLException e) { ; }
	            ps = null;
	        }
	        if (con != null && !con.isClosed() ) {
	            try { con.close(); } catch (SQLException e) { ; }
	            con = null;
	        }
		}		
	}
	@Override
	public void salvar(BusinessPlan businessPlan) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO businessplan(businessplan, versao, data, autor, notarevisao, aprovacao, situacaomercado, situacaoservico, situacaocompetividade, situacaodistribuicao, situacaomacro, analiseexterno, analiseinterno, analiserelacionada, objetivofinanceiro, objetivomarketing, cronograma, estrategia, segmento, projetoinicio)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);
			
			ps.setString(1, businessPlan.getBusinessplan());
			ps.setString(2, businessPlan.getVersao());
			ps.setDate(3, new java.sql.Date(businessPlan.getData().getTime()));
			ps.setString(4, businessPlan.getAutor());
			ps.setString(5, businessPlan.getNotarevisao());
			ps.setString(6, businessPlan.getAprovacao());
			ps.setObject(7, businessPlan.getSituacaomercado());
			ps.setString(8, businessPlan.getSituacaoservico());
			ps.setString(9, businessPlan.getSituacaocompetividade());		
			ps.setString(10, businessPlan.getSituacaodistribuicao());
			ps.setString(11, businessPlan.getSituacaomacro());
			ps.setString(12, businessPlan.getAnaliseexterno());	
			ps.setString(13, businessPlan.getAnaliseinterno());
			ps.setString(14, businessPlan.getAnaliserelacionada());
			ps.setString(15, businessPlan.getObjetivofinanceiro());			
			ps.setString(16, businessPlan.getObjetivomarketing());
			ps.setString(17, businessPlan.getCronograma());
			ps.setString(18, businessPlan.getEstrategia());
			ps.setString(19, businessPlan.getSegmento());
			ps.setObject(20, businessPlan.getProjetoinicio().getCodigo());
			
			ps.executeUpdate();
			ps.close();

			// Pode acontecer o q/ for, que a conexao sera executada.
		} finally {
			
			// fecha todos os recursos e devolve a conexao ao pool	        
	        if (ps != null && !ps.isClosed() ) {
	            try { ps.close(); } catch (SQLException e) { ; }
	            ps = null;
	        }
	        if (con != null && !con.isClosed() ) {
	            try { con.close(); } catch (SQLException e) { ; }
	            con = null;
	        }
		}		
	}

	@Override
	public List<BusinessPlan> getBusinessPlans() throws Exception {
		
		   List<BusinessPlan> resultado = new ArrayList<BusinessPlan>();// Montar o resultado
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			/*
			 * SELECIONAR todas as colunas [da tabela businessplan] da TABELA businessplan UNINDO A TABELA projetoinicio 
			 * ONDE a coluna projetoinicio [da tabela businessplan] É IGUAL a coluna id [da tabela projetoinicio] 
			 * ORDENADO PELO nome [da tabela businessplan] ASCENDETEMENTE
			 * */
			String sqlSelect = "SELECT * FROM businessplan INNER JOIN projetoinicio ON businessplan.projetoinicio = projetoinicio.codigo ORDER BY businessplan.autor;";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					
					BusinessPlan businessPlan = new BusinessPlan();
					
					businessPlan.setBusinessplan(rs.getString("businessplan"));
					businessPlan.setVersao(rs.getString("versao"));
					businessPlan.setData(rs.getDate("data"));
					businessPlan.setAutor(rs.getString("autor"));
					businessPlan.setNotarevisao(rs.getString("notarevisao"));
					businessPlan.setAprovacao(rs.getString("aprovacao"));		
					businessPlan.setSituacaomercado(rs.getString("situacaomercado"));
					businessPlan.setSituacaoservico(rs.getString("situacaoservico"));
					businessPlan.setSituacaocompetividade(rs.getString("situacaocompetividade"));
					businessPlan.setSituacaodistribuicao(rs.getString("situacaodistribuicao"));
					businessPlan.setSituacaomacro(rs.getString("situacaomacro"));
					businessPlan.setAnaliseexterno(rs.getString("analiseexterno"));
					businessPlan.setAnaliseinterno(rs.getString("analiseinterno"));
					businessPlan.setAnaliserelacionada(rs.getString("analiserelacionada"));					
					businessPlan.setObjetivofinanceiro(rs.getString("objetivofinanceiro"));
					businessPlan.setObjetivomarketing(rs.getString("objetivomarketing"));
					businessPlan.setCronograma(rs.getString("cronograma"));
					businessPlan.setEstrategia(rs.getString("estrategia"));					
					businessPlan.setSegmento(rs.getString("segmento"));
					businessPlan.setCodigo(rs.getLong("codigo"));
					
					businessPlan.getProjetoinicio().setCodigo(rs.getLong("codigo"));
					
					businessPlan.getProjetoinicio().setCodigoprojeto(rs.getInt("codigoprojeto"));
					businessPlan.getProjetoinicio().setProjeto(rs.getString("projeto"));					
					businessPlan.getProjetoinicio().setData(rs.getDate("data"));
					businessPlan.getProjetoinicio().setAtribuiprojeto(rs.getString("atribuiprojeto"));
					businessPlan.getProjetoinicio().setTipoprojeto(rs.getString("tipoprojeto"));
					businessPlan.getProjetoinicio().setObjetivo(rs.getString("objetivo"));
					businessPlan.getProjetoinicio().setCliente(rs.getString("cliente"));
					businessPlan.getProjetoinicio().setPrograma(rs.getString("programa"));
					businessPlan.getProjetoinicio().setArea(rs.getString("area"));
					businessPlan.getProjetoinicio().setRoi(rs.getDouble("roi"));
					businessPlan.getProjetoinicio().setDescricao(rs.getString("descricao"));
					businessPlan.getProjetoinicio().setCopia(rs.getString("copia"));
					
					resultado.add(businessPlan);// Add o projeto ao resultado.
				}			
				rs.close();
				ps.close();
		} finally{
			 // fecha todos os recursos e devolve a conexao ao pool	        
			if (rs != null && !rs.isClosed() ) {
	            try { rs.close(); } catch (SQLException e) { ; }
	            rs = null;
	        }
			if (ps != null && !ps.isClosed() ) {
	            try { ps.close(); } catch (SQLException e) { ; }
	            ps = null;
	        }
	        if (con != null && !con.isClosed() ) {
	            try { con.close(); } catch (SQLException e) { ; }
	            con = null;
	        }
		}			
		return resultado;
	}
	
}

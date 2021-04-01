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
import br.com.tkcsapcd.model.bean.PortfolioProjeto;
import br.com.tkcsapcd.model.util.Conexao;

public class PortfolioProjetoDAO implements InterfacePortfolioProjetoDAO{	
	
	@SuppressWarnings("unused")
	private static Connection con;
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public PortfolioProjetoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	
	@SuppressWarnings("static-access")
	public PortfolioProjetoDAO() throws Exception{
		con = new Conexao().getConnection();
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM portfolioprojeto WHERE codigo = ?;";

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
	private void setPreparedStatement(PortfolioProjeto portfolioProjeto, PreparedStatement ps) throws SQLException 
	{
		ps.setInt(1, portfolioProjeto.getCodigoprojeto());
		ps.setString(2, portfolioProjeto.getPrioridade());
		ps.setString(3, portfolioProjeto.getTipoprojeto());
		ps.setString(4, portfolioProjeto.getUnidadenegocio());
		ps.setString(5, portfolioProjeto.getAnalista());
		ps.setString(6, portfolioProjeto.getGerente());
		ps.setString(7, portfolioProjeto.getFase());
		ps.setString(8, portfolioProjeto.getFaseatual());		
		ps.setDate(9, new java.sql.Date(portfolioProjeto.getDatainicio().getTime() )); //transforma o java util date em java sql date	
		ps.setDate(10, new java.sql.Date(portfolioProjeto.getDatatermino().getTime() )); //transforma o java util date em java sql date	
		ps.setDate(11, new java.sql.Date(portfolioProjeto.getDataatual().getTime() )); //transforma o java util date em java sql date	
		ps.setString(12, portfolioProjeto.getParteinteressada());
		ps.setString(13, portfolioProjeto.getPlanoprojeto());
		ps.setString(14, portfolioProjeto.getDeclaracaoescopo());	
		ps.setString(15, portfolioProjeto.getDicionarioeap());
		ps.setString(16, portfolioProjeto.getCronograma());
		ps.setString(17, portfolioProjeto.getRegistrorisco());
		ps.setString(18, portfolioProjeto.getStatusreport());
		ps.setString(19, portfolioProjeto.getEscopo());
		ps.setDouble(20, portfolioProjeto.getCusto());
		ps.setString(21, portfolioProjeto.getComentario());
		ps.setString(22, portfolioProjeto.getNivel());
		ps.setObject(23, portfolioProjeto.getEntrega());		
		ps.setString(24, portfolioProjeto.getStatus());
		ps.setString(25, portfolioProjeto.getRecursos());
		ps.setString(26, portfolioProjeto.getReplanejamento());
		ps.setString(27, portfolioProjeto.getEstimativa());
		ps.setString(28, portfolioProjeto.getLinhabase());
		ps.setString(29, portfolioProjeto.getEsforco());
		ps.setString(30, portfolioProjeto.getConclusao());
		ps.setString(31, portfolioProjeto.getEtapa());
		ps.setString(32, portfolioProjeto.getEap());
		ps.setString(33, portfolioProjeto.getResponsavel());
		ps.setInt(34, portfolioProjeto.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public PortfolioProjeto getPortfolioProjeto(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM portfolioprojeto WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<PortfolioProjeto> resultado = getListaPortfolioProjeto(rs);
			
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
		private List<PortfolioProjeto> getListaPortfolioProjeto(ResultSet rs) throws SQLException	{
				List<PortfolioProjeto> resultado = new ArrayList<PortfolioProjeto>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				PortfolioProjeto portfolioProjeto = new PortfolioProjeto();
				
				portfolioProjeto.setCodigoprojeto(rs.getInt("codigoprojeto"));
				portfolioProjeto.setPrioridade(rs.getString("prioridade"));
				portfolioProjeto.setTipoprojeto(rs.getString("tipoprojeto"));
				portfolioProjeto.setUnidadenegocio(rs.getString("unidadenegocio"));
				portfolioProjeto.setAnalista(rs.getString("analista"));
				portfolioProjeto.setGerente(rs.getString("gerente"));
				portfolioProjeto.setFase(rs.getString("fase"));
				portfolioProjeto.setFaseatual(rs.getString("faseatual"));
				portfolioProjeto.setDatainicio(rs.getDate("datainicio"));
				portfolioProjeto.setDatatermino(rs.getDate("datatermino"));				
				portfolioProjeto.setDataatual(rs.getDate("dataatual"));					
				portfolioProjeto.setParteinteressada(rs.getString("parteinteressada"));
				portfolioProjeto.setPlanoprojeto(rs.getString("planoprojeto"));
				portfolioProjeto.setDeclaracaoescopo(rs.getString("declaracaoescopo"));
				portfolioProjeto.setDicionarioeap(rs.getString("dicionarioeap"));
				portfolioProjeto.setCronograma(rs.getString("cronograma"));
				portfolioProjeto.setRegistrorisco(rs.getString("registrorisco"));
				portfolioProjeto.setStatusreport(rs.getString("statusreport"));
				portfolioProjeto.setEscopo(rs.getString("escopo"));					
				portfolioProjeto.setCusto(rs.getDouble("custo"));
				portfolioProjeto.setComentario(rs.getString("comentario"));
				portfolioProjeto.setNivel(rs.getString("nivel"));
				portfolioProjeto.setEntrega(rs.getString("entrega"));	
				portfolioProjeto.setStatus(rs.getString("status"));
				portfolioProjeto.setRecursos(rs.getString("recursos"));				
				portfolioProjeto.setReplanejamento(rs.getString("replanejamento"));
				portfolioProjeto.setEstimativa(rs.getString("estimativa"));
				portfolioProjeto.setLinhabase(rs.getString("linhabase"));
				portfolioProjeto.setEsforco(rs.getString("esforco"));
				portfolioProjeto.setConclusao(rs.getString("conclusao"));
				portfolioProjeto.setEtapa(rs.getString("etapa"));
				portfolioProjeto.setEap(rs.getString("eap"));
				portfolioProjeto.setResponsavel(rs.getString("responsavel"));
				portfolioProjeto.setCodigo(rs.getInt("codigo"));
												
				resultado.add(portfolioProjeto);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(PortfolioProjeto portfolioProjeto) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE portfolioprojeto SET codigoprojeto = ?,	 prioridade = ?,	 tipoprojeto = ?,	 unidadenegocio = ?,	 analista = ?,	 gerente = ?,	 fase = ?,	 faseatual = ?,	 datainicio = ?,	 datatermino = ?,	 dataatual = ?,	 parteinteressada = ?,	 planoprojeto = ?,	 declaracaoescopo = ?,	 dicionarioeap = ?,	 cronograma = ?,	 registrorisco = ?,	 statusreport = ?,	 escopo = ?,	 custo = ?,		 comentario = ?,	 nivel = ?,	 entrega = ?,	 status = ?,	 recursos = ?,	 replanejamento = ?,	 estimativa = ?,	 linhabase = ?,	 esforco = ?,	 conclusao = ?,	 etapa = ?,	 eap = ?,	 responsavel = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(portfolioProjeto, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(PortfolioProjeto portfolioProjeto) throws Exception  {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO portfolioprojeto (codigoprojeto, prioridade, tipoprojeto, unidadenegocio, analista,	 gerente, fase,	 faseatual,	 datainicio, datatermino," +
					" dataatual, parteinteressada, planoprojeto, declaracaoescopo, dicionarioeap, cronograma, registrorisco, statusreport, escopo, custo, comentario, nivel, entrega," +
					" status, recursos, replanejamento, estimativa, linhabase, esforco, conclusao, etapa, eap, responsavel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setInt(1, portfolioProjeto.getCodigoprojeto());
			ps.setString(2, portfolioProjeto.getPrioridade());
			ps.setString(3, portfolioProjeto.getTipoprojeto());
			ps.setString(4, portfolioProjeto.getUnidadenegocio());
			ps.setString(5, portfolioProjeto.getAnalista());
			ps.setString(6, portfolioProjeto.getGerente());
			ps.setString(7, portfolioProjeto.getFase());
			ps.setString(8, portfolioProjeto.getFaseatual());		
			ps.setDate(9, new java.sql.Date(portfolioProjeto.getDatainicio().getTime() )); //transforma o java util date em java sql date	
			ps.setDate(10, new java.sql.Date(portfolioProjeto.getDatatermino().getTime() )); //transforma o java util date em java sql date	
			ps.setDate(11, new java.sql.Date(portfolioProjeto.getDataatual().getTime()));//transforma o java util date em java sql date
			ps.setString(12, portfolioProjeto.getParteinteressada());
			ps.setString(13, portfolioProjeto.getPlanoprojeto());
			ps.setString(14, portfolioProjeto.getDeclaracaoescopo());	
			ps.setString(15, portfolioProjeto.getDicionarioeap());
			ps.setString(16, portfolioProjeto.getCronograma());
			ps.setString(17, portfolioProjeto.getRegistrorisco());
			ps.setString(18, portfolioProjeto.getStatusreport());
			ps.setString(19, portfolioProjeto.getEscopo());
			ps.setDouble(20, portfolioProjeto.getCusto());
			ps.setString(21, portfolioProjeto.getComentario());
			ps.setString(22, portfolioProjeto.getNivel());
			ps.setObject(23, portfolioProjeto.getEntrega());		
			ps.setString(24, portfolioProjeto.getStatus());
			ps.setString(25, portfolioProjeto.getRecursos());
			ps.setString(26, portfolioProjeto.getReplanejamento());
			ps.setString(27, portfolioProjeto.getEstimativa());
			ps.setString(28, portfolioProjeto.getLinhabase());
			ps.setString(29, portfolioProjeto.getEsforco());
			ps.setString(30, portfolioProjeto.getConclusao());
			ps.setString(31, portfolioProjeto.getEtapa());
			ps.setString(32, portfolioProjeto.getEap());
			ps.setString(33, portfolioProjeto.getResponsavel());		
			
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
	public List<PortfolioProjeto> getPortfolioProjetos() throws Exception {		
		   List<PortfolioProjeto> resultado = new ArrayList<PortfolioProjeto>();// Montar o resultado
		   
		   Connection con=null;
		   PreparedStatement ps=null;
		   ResultSet rs =null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM portfolioprojeto";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					PortfolioProjeto portfolioProjeto = new PortfolioProjeto();
				
					portfolioProjeto.setCodigoprojeto(rs.getInt("codigoprojeto"));
					portfolioProjeto.setPrioridade(rs.getString("prioridade"));
					portfolioProjeto.setTipoprojeto(rs.getString("tipoprojeto"));
					portfolioProjeto.setUnidadenegocio(rs.getString("unidadenegocio"));
					portfolioProjeto.setAnalista(rs.getString("analista"));
					portfolioProjeto.setGerente(rs.getString("gerente"));
					portfolioProjeto.setFase(rs.getString("fase"));
					portfolioProjeto.setFaseatual(rs.getString("faseatual"));
					portfolioProjeto.setDatainicio(rs.getDate("datainicio"));
					portfolioProjeto.setDatatermino(rs.getDate("datatermino"));				
					portfolioProjeto.setDataatual(rs.getDate("dataatual"));					
					portfolioProjeto.setParteinteressada(rs.getString("parteinteressada"));
					portfolioProjeto.setPlanoprojeto(rs.getString("planoprojeto"));
					portfolioProjeto.setDeclaracaoescopo(rs.getString("declaracaoescopo"));
					portfolioProjeto.setDicionarioeap(rs.getString("dicionarioeap"));
					portfolioProjeto.setCronograma(rs.getString("cronograma"));
					portfolioProjeto.setRegistrorisco(rs.getString("registrorisco"));
					portfolioProjeto.setStatusreport(rs.getString("statusreport"));
					portfolioProjeto.setEscopo(rs.getString("escopo"));					
					portfolioProjeto.setCusto(rs.getDouble("custo"));
					portfolioProjeto.setComentario(rs.getString("comentario"));
					portfolioProjeto.setNivel(rs.getString("nivel"));
					portfolioProjeto.setEntrega(rs.getString("entrega"));	
					portfolioProjeto.setStatus(rs.getString("status"));
					portfolioProjeto.setRecursos(rs.getString("recursos"));				
					portfolioProjeto.setReplanejamento(rs.getString("replanejamento"));
					portfolioProjeto.setEstimativa(rs.getString("estimativa"));
					portfolioProjeto.setLinhabase(rs.getString("linhabase"));
					portfolioProjeto.setEsforco(rs.getString("esforco"));
					portfolioProjeto.setConclusao(rs.getString("conclusao"));
					portfolioProjeto.setEtapa(rs.getString("etapa"));
					portfolioProjeto.setEap(rs.getString("eap"));
					portfolioProjeto.setResponsavel(rs.getString("responsavel"));
					portfolioProjeto.setCodigo(rs.getInt("codigo"));
									
					resultado.add(portfolioProjeto);// Add o projeto ao resultado.
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

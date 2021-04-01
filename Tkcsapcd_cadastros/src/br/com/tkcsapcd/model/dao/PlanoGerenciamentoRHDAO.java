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
import br.com.tkcsapcd.model.bean.PlanoGerenciamentoRH;
import br.com.tkcsapcd.model.util.Conexao;

public class PlanoGerenciamentoRHDAO implements InterfacePlanoGerenciamentoRHDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public PlanoGerenciamentoRHDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM planogerenciamentorh WHERE codigo = ?;";

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
	
	private void setPreparedStatement(PlanoGerenciamentoRH planoGerenciamentoRH, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, planoGerenciamentoRH.getPlanogerenciamentorh());
		ps.setString(2, planoGerenciamentoRH.getProjeto());
		ps.setInt(3, planoGerenciamentoRH.getCodigoprojeto());
		ps.setString(4, planoGerenciamentoRH.getVersao());
		ps.setString(5, planoGerenciamentoRH.getData());
		ps.setString(6, planoGerenciamentoRH.getAutor());
		ps.setString(7, planoGerenciamentoRH.getNotarevisao());
		ps.setString(8, planoGerenciamentoRH.getAprovacao());
		ps.setObject(9, planoGerenciamentoRH.getObjetivo());
		ps.setString(10, planoGerenciamentoRH.getMetodo());
		ps.setString(11, planoGerenciamentoRH.getProcesso());		
		ps.setString(12, planoGerenciamentoRH.getDocumento());
		ps.setString(13, planoGerenciamentoRH.getFerramenta());
		ps.setString(14, planoGerenciamentoRH.getOrganograma());	
		ps.setString(15, planoGerenciamentoRH.getPapeis());
		ps.setString(16, planoGerenciamentoRH.getPlanogerenciamento());
		ps.setString(17, planoGerenciamentoRH.getMobilizacao());
		ps.setString(18, planoGerenciamentoRH.getCalendario());
		ps.setString(19, planoGerenciamentoRH.getPlanoliberacao());
		ps.setString(20, planoGerenciamentoRH.getNecessidade());
		ps.setString(21, planoGerenciamentoRH.getReconhecimento());
		ps.setString(22, planoGerenciamentoRH.getConformidade());
		ps.setObject(23, planoGerenciamentoRH.getSeguranca());
		ps.setInt(24, planoGerenciamentoRH.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public PlanoGerenciamentoRH getPlanoGerenciamentoRH(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM planogerenciamentorh WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<PlanoGerenciamentoRH> resultado = getListaPlanoGerenciamentoRH(rs);
			
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
		private List<PlanoGerenciamentoRH> getListaPlanoGerenciamentoRH(ResultSet rs) throws SQLException	{
			List<PlanoGerenciamentoRH> resultado = new ArrayList<PlanoGerenciamentoRH>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				PlanoGerenciamentoRH planoGerenciamentoRH = new PlanoGerenciamentoRH();
				
				planoGerenciamentoRH.setPlanogerenciamentorh(rs.getString("planogerenciamentorh"));
				planoGerenciamentoRH.setProjeto(rs.getString("projeto"));
				planoGerenciamentoRH.setCodigoprojeto(rs.getInt("codigoprojeto"));
				planoGerenciamentoRH.setVersao(rs.getString("versao"));
				planoGerenciamentoRH.setData(rs.getString("data"));
				planoGerenciamentoRH.setAutor(rs.getString("autor"));
				planoGerenciamentoRH.setNotarevisao(rs.getString("notarevisao"));
				planoGerenciamentoRH.setAprovacao(rs.getString("aprovacao"));
				planoGerenciamentoRH.setObjetivo(rs.getString("objetivo"));				
				planoGerenciamentoRH.setMetodo(rs.getString("metodo"));					
				planoGerenciamentoRH.setProcesso(rs.getString("processo"));
				planoGerenciamentoRH.setDocumento(rs.getString("documento"));
				planoGerenciamentoRH.setFerramenta(rs.getString("ferramenta"));
				planoGerenciamentoRH.setOrganograma(rs.getString("organograma"));
				planoGerenciamentoRH.setPapeis(rs.getString("papeis"));
				planoGerenciamentoRH.setPlanogerenciamento(rs.getString("planogerenciamento"));
				planoGerenciamentoRH.setMobilizacao(rs.getString("mobilizacao"));
				planoGerenciamentoRH.setCalendario(rs.getString("calendario"));					
				planoGerenciamentoRH.setPlanoliberacao(rs.getString("planoliberacao"));
				planoGerenciamentoRH.setNecessidade(rs.getString("necessidade"));
				planoGerenciamentoRH.setReconhecimento(rs.getString("reconhecimento"));
				planoGerenciamentoRH.setConformidade(rs.getString("conformidade"));	
				planoGerenciamentoRH.setSeguranca(rs.getString("seguranca"));
				planoGerenciamentoRH.setCodigo(rs.getInt("codigo"));
												
				resultado.add(planoGerenciamentoRH);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(PlanoGerenciamentoRH planoGerenciamentoRH) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE planogerenciamentorh SET 	planogerenciamentorh = ?, projeto = ?, codigoprojeto = ?, versao = ?, data = ?, autor = ?, notarevisao = ?, aprovacao = ?, objetivo = ?, metodo = ?, processo = ?, documento = ?, ferramenta = ?, organograma = ?, papeis = ?, planogerenciamento = ?, mobilizacao = ?, calendario = ?, planoliberacao = ?, necessidade = ?, reconhecimento = ?, conformidade = ?, seguranca = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(planoGerenciamentoRH, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(PlanoGerenciamentoRH planoGerenciamentoRH) throws Exception  {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO planogerenciamentorh(planogerenciamentorh, projeto, codigoprojeto, versao, data, autor, notarevisao, aprovacao, objetivo, metodo, processo, documento, ferramenta, organograma, papeis, planogerenciamento, mobilizacao, calendario, planoliberacao, necessidade, reconhecimento, conformidade, seguranca) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, planoGerenciamentoRH.getPlanogerenciamentorh());
			ps.setString(2, planoGerenciamentoRH.getProjeto());
			ps.setInt(3, planoGerenciamentoRH.getCodigoprojeto());
			ps.setString(4, planoGerenciamentoRH.getVersao());
			ps.setString(5, planoGerenciamentoRH.getData());
			ps.setString(6, planoGerenciamentoRH.getAutor());
			ps.setString(7, planoGerenciamentoRH.getNotarevisao());
			ps.setString(8, planoGerenciamentoRH.getAprovacao());
			ps.setObject(9, planoGerenciamentoRH.getObjetivo());
			ps.setString(10, planoGerenciamentoRH.getMetodo());
			ps.setString(11, planoGerenciamentoRH.getProcesso());		
			ps.setString(12, planoGerenciamentoRH.getDocumento());
			ps.setString(13, planoGerenciamentoRH.getFerramenta());
			ps.setString(14, planoGerenciamentoRH.getOrganograma());	
			ps.setString(15, planoGerenciamentoRH.getPapeis());
			ps.setString(16, planoGerenciamentoRH.getPlanogerenciamento());
			ps.setString(17, planoGerenciamentoRH.getMobilizacao());
			ps.setString(18, planoGerenciamentoRH.getCalendario());
			ps.setString(19, planoGerenciamentoRH.getPlanoliberacao());
			ps.setString(20, planoGerenciamentoRH.getNecessidade());
			ps.setString(21, planoGerenciamentoRH.getReconhecimento());
			ps.setString(22, planoGerenciamentoRH.getConformidade());
			ps.setObject(23, planoGerenciamentoRH.getSeguranca());
			
			
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
	public List<PlanoGerenciamentoRH> getPlanoGerenciamentoRHs() throws Exception  {
		
		   List<PlanoGerenciamentoRH> resultado = new ArrayList<PlanoGerenciamentoRH>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs =null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM planogerenciamentorh";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					PlanoGerenciamentoRH planoGerenciamentoRH = new PlanoGerenciamentoRH();
					
					planoGerenciamentoRH.setPlanogerenciamentorh(rs.getString("planogerenciamentorh"));
					planoGerenciamentoRH.setProjeto(rs.getString("projeto"));
					planoGerenciamentoRH.setCodigoprojeto(rs.getInt("codigoprojeto"));
					planoGerenciamentoRH.setVersao(rs.getString("versao"));
					planoGerenciamentoRH.setData(rs.getString("data"));
					planoGerenciamentoRH.setAutor(rs.getString("autor"));
					planoGerenciamentoRH.setNotarevisao(rs.getString("notarevisao"));
					planoGerenciamentoRH.setAprovacao(rs.getString("aprovacao"));
					planoGerenciamentoRH.setObjetivo(rs.getString("objetivo"));				
					planoGerenciamentoRH.setMetodo(rs.getString("metodo"));					
					planoGerenciamentoRH.setProcesso(rs.getString("processo"));
					planoGerenciamentoRH.setDocumento(rs.getString("documento"));
					planoGerenciamentoRH.setFerramenta(rs.getString("ferramenta"));
					planoGerenciamentoRH.setOrganograma(rs.getString("organograma"));
					planoGerenciamentoRH.setPapeis(rs.getString("papeis"));
					planoGerenciamentoRH.setPlanogerenciamento(rs.getString("planogerenciamento"));
					planoGerenciamentoRH.setMobilizacao(rs.getString("mobilizacao"));
					planoGerenciamentoRH.setCalendario(rs.getString("calendario"));					
					planoGerenciamentoRH.setPlanoliberacao(rs.getString("planoliberacao"));
					planoGerenciamentoRH.setNecessidade(rs.getString("necessidade"));
					planoGerenciamentoRH.setReconhecimento(rs.getString("reconhecimento"));
					planoGerenciamentoRH.setConformidade(rs.getString("conformidade"));	
					planoGerenciamentoRH.setSeguranca(rs.getString("seguranca"));
					planoGerenciamentoRH.setCodigo(rs.getInt("codigo"));
									
					resultado.add(planoGerenciamentoRH);// Add o projeto ao resultado.
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

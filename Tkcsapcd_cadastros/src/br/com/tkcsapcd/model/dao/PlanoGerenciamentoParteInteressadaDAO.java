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
import br.com.tkcsapcd.model.bean.PlanoGerenciamentoParteInteressada;
import br.com.tkcsapcd.model.util.Conexao;

public class PlanoGerenciamentoParteInteressadaDAO implements InterfacePlanoGerenciamentoParteInteressadaDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public PlanoGerenciamentoParteInteressadaDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM planogerenciamentoparteinteressada WHERE codigo = ?;";

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
	private void setPreparedStatement(PlanoGerenciamentoParteInteressada planoGerenciamentoParteInteressada, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, planoGerenciamentoParteInteressada.getPlanogerenciamentointeressada());
		ps.setString(2, planoGerenciamentoParteInteressada.getVersao());
		ps.setObject(3, new java.sql.Date(planoGerenciamentoParteInteressada.getData().getTime()));
		ps.setString(4, planoGerenciamentoParteInteressada.getAutor());
		ps.setString(5, planoGerenciamentoParteInteressada.getNotarevisao());
		ps.setString(6, planoGerenciamentoParteInteressada.getAprovacao());
		ps.setObject(7, planoGerenciamentoParteInteressada.getObjetivo());
		ps.setString(8, planoGerenciamentoParteInteressada.getProcesso());
		ps.setString(9, planoGerenciamentoParteInteressada.getParteinteressada());		
		ps.setString(10, planoGerenciamentoParteInteressada.getGerenciarparte());
		ps.setString(11, planoGerenciamentoParteInteressada.getControlaparte());
		ps.setString(12, planoGerenciamentoParteInteressada.getAnexo());
		ps.setObject(13, planoGerenciamentoParteInteressada.getProjetoinicio().getCodigo());
		ps.setLong(14, planoGerenciamentoParteInteressada.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public PlanoGerenciamentoParteInteressada getPlanoGerenciamentoParteInteressada(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM planogerenciamentoparteinteressada WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<PlanoGerenciamentoParteInteressada> resultado = getListaPlanoGerenciamentoParteInteressada(rs);
			
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
		private List<PlanoGerenciamentoParteInteressada> getListaPlanoGerenciamentoParteInteressada(ResultSet rs) throws SQLException	{
			List<PlanoGerenciamentoParteInteressada> resultado = new ArrayList<PlanoGerenciamentoParteInteressada>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				PlanoGerenciamentoParteInteressada planoGerenciamentoParteInteressada = new PlanoGerenciamentoParteInteressada();
				
				planoGerenciamentoParteInteressada.setPlanogerenciamentointeressada(rs.getString("planogerenciamentointeressada"));
				planoGerenciamentoParteInteressada.setVersao(rs.getString("versao"));
				planoGerenciamentoParteInteressada.setData(rs.getDate("data"));
				planoGerenciamentoParteInteressada.setAutor(rs.getString("autor"));
				planoGerenciamentoParteInteressada.setNotarevisao(rs.getString("notarevisao"));
				planoGerenciamentoParteInteressada.setAprovacao(rs.getString("aprovacao"));
				planoGerenciamentoParteInteressada.setObjetivo(rs.getString("objetivo"));				
				planoGerenciamentoParteInteressada.setProcesso(rs.getString("processo"));					
				planoGerenciamentoParteInteressada.setParteinteressada(rs.getString("parteinteressada"));
				planoGerenciamentoParteInteressada.setGerenciarparte(rs.getString("gerenciarparte"));
				planoGerenciamentoParteInteressada.setControlaparte(rs.getString("controlaparte"));
				planoGerenciamentoParteInteressada.setAnexo(rs.getString("anexo"));
				planoGerenciamentoParteInteressada.setCodigo(rs.getLong("codigo"));
												
				resultado.add(planoGerenciamentoParteInteressada);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(PlanoGerenciamentoParteInteressada planoGerenciamentoParteInteressada) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE planogerenciamentoparteinteressada SET planogerenciamentointeressada = ?, versao = ?, data = ?, autor = ?, notarevisao = ?, aprovacao = ?, objetivo = ?, processo = ?, parteinteressada = ?, gerenciarparte = ?, controlaparte = ?, anexo = ?, projetoinicio WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(planoGerenciamentoParteInteressada, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(PlanoGerenciamentoParteInteressada planoGerenciamentoParteInteressada) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO planogerenciamentoparteinteressada(planogerenciamentointeressada, versao, data, autor, notarevisao, aprovacao, objetivo, processo, parteinteressada, gerenciarparte, controlaparte, anexo, projetoinicio) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, planoGerenciamentoParteInteressada.getPlanogerenciamentointeressada());
			ps.setString(2, planoGerenciamentoParteInteressada.getVersao());
			ps.setObject(3, new java.sql.Date(planoGerenciamentoParteInteressada.getData().getTime()));
			ps.setString(4, planoGerenciamentoParteInteressada.getAutor());
			ps.setString(5, planoGerenciamentoParteInteressada.getNotarevisao());
			ps.setString(6, planoGerenciamentoParteInteressada.getAprovacao());
			ps.setObject(7, planoGerenciamentoParteInteressada.getObjetivo());
			ps.setString(8, planoGerenciamentoParteInteressada.getProcesso());
			ps.setString(9, planoGerenciamentoParteInteressada.getParteinteressada());		
			ps.setString(10, planoGerenciamentoParteInteressada.getGerenciarparte());
			ps.setString(11, planoGerenciamentoParteInteressada.getControlaparte());
			ps.setString(12, planoGerenciamentoParteInteressada.getAnexo());
			ps.setObject(13, planoGerenciamentoParteInteressada.getProjetoinicio().getCodigo());
			
			
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
	public List<PlanoGerenciamentoParteInteressada> getPlanoGerenciamentoParteInteressadas() throws Exception {
		
		   List<PlanoGerenciamentoParteInteressada> resultado = new ArrayList<PlanoGerenciamentoParteInteressada>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM planogerenciamentoparteinteressada";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					PlanoGerenciamentoParteInteressada planoGerenciamentoParteInteressada = new PlanoGerenciamentoParteInteressada();
				
					planoGerenciamentoParteInteressada.setPlanogerenciamentointeressada(rs.getString("planogerenciamentointeressada"));
					planoGerenciamentoParteInteressada.setVersao(rs.getString("versao"));
					planoGerenciamentoParteInteressada.setData(rs.getDate("data"));
					planoGerenciamentoParteInteressada.setAutor(rs.getString("autor"));
					planoGerenciamentoParteInteressada.setNotarevisao(rs.getString("notarevisao"));
					planoGerenciamentoParteInteressada.setAprovacao(rs.getString("aprovacao"));
					planoGerenciamentoParteInteressada.setObjetivo(rs.getString("objetivo"));				
					planoGerenciamentoParteInteressada.setProcesso(rs.getString("processo"));					
					planoGerenciamentoParteInteressada.setParteinteressada(rs.getString("parteinteressada"));
					planoGerenciamentoParteInteressada.setGerenciarparte(rs.getString("gerenciarparte"));
					planoGerenciamentoParteInteressada.setControlaparte(rs.getString("controlaparte"));
					planoGerenciamentoParteInteressada.setAnexo(rs.getString("anexo"));
					planoGerenciamentoParteInteressada.setCodigo(rs.getLong("codigo"));
					
					planoGerenciamentoParteInteressada.getProjetoinicio().setCodigo(rs.getLong("codigo"));
									
					resultado.add(planoGerenciamentoParteInteressada);// Add o projeto ao resultado.
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

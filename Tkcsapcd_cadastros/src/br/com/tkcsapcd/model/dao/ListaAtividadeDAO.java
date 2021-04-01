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
import br.com.tkcsapcd.model.bean.ListaAtividade;
import br.com.tkcsapcd.model.util.Conexao;

public class ListaAtividadeDAO implements InterfaceListaAtividadeDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public ListaAtividadeDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM listaatividade WHERE codigo = ?;";

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
	private void setPreparedStatement(ListaAtividade listaAtividade, PreparedStatement ps) throws SQLException 
	{		
		ps.setString(1, listaAtividade.getListaatividade());
		ps.setString(2, listaAtividade.getProjeto());
		ps.setInt(3, listaAtividade.getCodigoprojeto());
		ps.setString(4, listaAtividade.getVersao());
		ps.setString(5, listaAtividade.getData());
		ps.setString(6, listaAtividade.getAutor());
		ps.setString(7, listaAtividade.getNotarevisao());
		ps.setString(8, listaAtividade.getAprovacao());
		ps.setObject(9, listaAtividade.getObjetivo());
		ps.setString(10, listaAtividade.getEntrega());
		ps.setInt(11, listaAtividade.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public ListaAtividade getListaAtividade(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM listaatividade WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<ListaAtividade> resultado = getListaListaAtividade(rs);
			
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
		private List<ListaAtividade> getListaListaAtividade(ResultSet rs) throws SQLException	{
			List<ListaAtividade> resultado = new ArrayList<ListaAtividade>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				ListaAtividade listaAtividade = new ListaAtividade();
				
				listaAtividade.setListaatividade(rs.getString("listaatividade"));
				listaAtividade.setProjeto(rs.getString("projeto"));
				listaAtividade.setCodigoprojeto(rs.getInt("codigoprojeto"));
				listaAtividade.setVersao(rs.getString("versao"));
				listaAtividade.setData(rs.getString("data"));
				listaAtividade.setAutor(rs.getString("autor"));
				listaAtividade.setNotarevisao(rs.getString("notarevisao"));
				listaAtividade.setAprovacao(rs.getString("aprovacao"));
				listaAtividade.setObjetivo(rs.getString("objetivo"));				
				listaAtividade.setEntrega(rs.getString("entrega"));
				listaAtividade.setCodigo(rs.getInt("codigo"));
												
				resultado.add(listaAtividade);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(ListaAtividade listaAtividade) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE listaatividade SET listaatividade = ?, projeto = ?, codigoprojeto = ?, versao = ?, data = ?, autor = ?, notarevisao = ?, aprovacao = ?, objetivo = ?, entrega = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(listaAtividade, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(ListaAtividade listaAtividade) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		
		try {
						
			String sqlInsert = "INSERT INTO listaatividade(listaatividade, projeto, codigoprojeto, versao, data, autor, notarevisao, aprovacao, objetivo, entrega) VALUES (?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, listaAtividade.getListaatividade());
			ps.setString(2, listaAtividade.getProjeto());
			ps.setInt(3, listaAtividade.getCodigoprojeto());
			ps.setString(4, listaAtividade.getVersao());
			ps.setString(5, listaAtividade.getData());
			ps.setString(6, listaAtividade.getAutor());
			ps.setString(7, listaAtividade.getNotarevisao());
			ps.setString(8, listaAtividade.getAprovacao());
			ps.setObject(9, listaAtividade.getObjetivo());
			ps.setString(10, listaAtividade.getEntrega());			
			
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
	public List<ListaAtividade> getListaAtividades() throws Exception {
		
		   List<ListaAtividade> resultado = new ArrayList<ListaAtividade>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM listaatividade";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					ListaAtividade listaAtividade = new ListaAtividade();
					
					listaAtividade.setListaatividade(rs.getString("listaatividade"));
					listaAtividade.setProjeto(rs.getString("projeto"));
					listaAtividade.setCodigoprojeto(rs.getInt("codigoprojeto"));
					listaAtividade.setVersao(rs.getString("versao"));
					listaAtividade.setData(rs.getString("data"));
					listaAtividade.setAutor(rs.getString("autor"));
					listaAtividade.setNotarevisao(rs.getString("notarevisao"));
					listaAtividade.setAprovacao(rs.getString("aprovacao"));
					listaAtividade.setObjetivo(rs.getString("objetivo"));				
					listaAtividade.setEntrega(rs.getString("entrega"));
					listaAtividade.setCodigo(rs.getInt("codigo"));
									
					resultado.add(listaAtividade);// Add o projeto ao resultado.
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

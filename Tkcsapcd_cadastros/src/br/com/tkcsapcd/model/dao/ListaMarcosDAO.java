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
import br.com.tkcsapcd.model.bean.ListaMarcos;
import br.com.tkcsapcd.model.util.Conexao;

public class ListaMarcosDAO implements InterfaceListaMarcosDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public ListaMarcosDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM listamarcos WHERE codigo = ?;";

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
	private void setPreparedStatement(ListaMarcos listaMarcos, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, listaMarcos.getListamarcos());
		ps.setString(2, listaMarcos.getProjeto());
		ps.setInt(3, listaMarcos.getCodigoprojeto());
		ps.setString(4, listaMarcos.getVersao());
		ps.setString(5, listaMarcos.getData());
		ps.setString(6, listaMarcos.getAutor());
		ps.setString(7, listaMarcos.getNotarevisao());
		ps.setString(8, listaMarcos.getAprovacao());
		ps.setObject(9, listaMarcos.getObjetivo());
		ps.setString(10, listaMarcos.getFases());
		ps.setInt(11, listaMarcos.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public ListaMarcos getListaMarcos(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM listamarcos WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<ListaMarcos> resultado = getListaListaMarcos(rs);
			
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
		private List<ListaMarcos> getListaListaMarcos(ResultSet rs) throws SQLException	{
				List<ListaMarcos> resultado = new ArrayList<ListaMarcos>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				ListaMarcos listaMarcos = new ListaMarcos();
				
				listaMarcos.setListamarcos(rs.getString("listamarcos"));
				listaMarcos.setProjeto(rs.getString("projeto"));
				listaMarcos.setCodigoprojeto(rs.getInt("codigoprojeto"));
				listaMarcos.setVersao(rs.getString("versao"));
				listaMarcos.setData(rs.getString("data"));
				listaMarcos.setAutor(rs.getString("autor"));
				listaMarcos.setNotarevisao(rs.getString("notarevisao"));
				listaMarcos.setAprovacao(rs.getString("aprovacao"));
				listaMarcos.setObjetivo(rs.getString("objetivo"));				
				listaMarcos.setFases(rs.getString("fases"));
				listaMarcos.setCodigo(rs.getInt("codigo"));
												
				resultado.add(listaMarcos);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(ListaMarcos listaMarcos) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE listamarcos SET listamarcos = ?, projeto = ?, codigoprojeto = ?, versao = ?, data = ?, autor = ?, notarevisao = ?, aprovacao = ?, objetivo = ?, fases = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(listaMarcos, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(ListaMarcos listaMarcos) throws Exception  {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO listamarcos(listamarcos, projeto, codigoprojeto, versao, data, autor, notarevisao, aprovacao, objetivo, fases) VALUES (?,?,?,?,?,?,?,?,?,?)";
	
			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, listaMarcos.getListamarcos());
			ps.setString(2, listaMarcos.getProjeto());
			ps.setInt(3, listaMarcos.getCodigoprojeto());
			ps.setString(4, listaMarcos.getVersao());
			ps.setString(5, listaMarcos.getData());
			ps.setString(6, listaMarcos.getAutor());
			ps.setString(7, listaMarcos.getNotarevisao());
			ps.setString(8, listaMarcos.getAprovacao());
			ps.setObject(9, listaMarcos.getObjetivo());
			ps.setString(10, listaMarcos.getFases());
			
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
	public List<ListaMarcos> getListaMarcoss() throws Exception {		
		   List<ListaMarcos> resultado = new ArrayList<ListaMarcos>();// Montar o resultado
		   
		   Connection con=null;
		   PreparedStatement ps=null;
		   ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM listamarcos";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {					
					
					ListaMarcos listaMarcos = new ListaMarcos();
				
					listaMarcos.setListamarcos(rs.getString("listamarcos"));
					listaMarcos.setProjeto(rs.getString("projeto"));
					listaMarcos.setCodigoprojeto(rs.getInt("codigoprojeto"));
					listaMarcos.setVersao(rs.getString("versao"));
					listaMarcos.setData(rs.getString("data"));
					listaMarcos.setAutor(rs.getString("autor"));
					listaMarcos.setNotarevisao(rs.getString("notarevisao"));
					listaMarcos.setAprovacao(rs.getString("aprovacao"));
					listaMarcos.setObjetivo(rs.getString("objetivo"));				
					listaMarcos.setFases(rs.getString("fases"));
					listaMarcos.setCodigo(rs.getInt("codigo"));
									
					resultado.add(listaMarcos);// Add o projeto ao resultado.
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

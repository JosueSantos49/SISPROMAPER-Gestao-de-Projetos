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
import br.com.tkcsapcd.model.bean.Usuario;
import br.com.tkcsapcd.model.util.Conexao;

public class UsuarioDAO implements InterfaceUsuarioDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public UsuarioDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer log_codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM login WHERE log_codigo = ?;";

			ps = con.prepareStatement(sqlExcluir);
			ps.setInt(1, log_codigo);//setando
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
	private void setPreparedStatement(Usuario usuario, PreparedStatement ps) throws SQLException 
	{
		
		ps.setString(1, usuario.getLog_usuario());
		ps.setString(2, usuario.getLog_senha());
		ps.setString(3, usuario.getLog_nivelacesso());
		ps.setString(4, usuario.getLog_cpf());
		ps.setString(5, usuario.getLog_datacadastro());
		ps.setString(6, usuario.getNome());
		ps.setString(7, usuario.getId());
		ps.setString(8, usuario.getGestorimediato());
		ps.setObject(9, usuario.getDepartamento());
		ps.setString(10, usuario.getEmail());
		ps.setString(11, usuario.getTelefone());
		ps.setInt(12, usuario.getLog_codigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public Usuario getUsuario(Integer log_codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM login WHERE log_codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, log_codigo);//setando			
			rs = ps.executeQuery();
				
			List<Usuario> resultado = getListaUsuario(rs);
			
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
		private List<Usuario> getListaUsuario(ResultSet rs) throws SQLException	{
				List<Usuario> resultado = new ArrayList<Usuario>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				Usuario usuario= new Usuario();				
				
				usuario.setLog_usuario(rs.getString("log_usuario"));
				usuario.setLog_senha(rs.getString("log_senha"));
				usuario.setLog_nivelacesso(rs.getString("log_nivelacesso"));
				usuario.setLog_cpf(rs.getString("log_cpf"));
				usuario.setLog_datacadastro(rs.getString("log_datacadastro"));
				usuario.setNome(rs.getString("nome"));
				usuario.setId(rs.getString("id"));
				usuario.setGestorimediato(rs.getString("gestorimediato"));				
				usuario.setDepartamento(rs.getString("departamento"));					
				usuario.setEmail(rs.getString("email"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setLog_codigo(rs.getInt("log_codigo"));
												
				resultado.add(usuario);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(Usuario usuario) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;		
		
		try{
			String sqlAtualizar = "UPDATE login SET  log_usuario = ?, log_senha = ?, log_nivelacesso = ?, log_cpf = ?, log_datacadastro = ?, nome = ?, id = ?, gestorimediato = ?, departamento = ?, email = ?, telefone = ? WHERE log_codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(usuario, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(Usuario usuario) throws Exception  {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO login (log_usuario, log_senha, log_nivelacesso, log_cpf, log_datacadastro, nome, id, gestorimediato, departamento, email, telefone) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);	
							
			ps.setString(1, usuario.getLog_usuario());
			ps.setString(2, usuario.getLog_senha());
			ps.setString(3, usuario.getLog_nivelacesso());
			ps.setString(4, usuario.getLog_cpf());
			ps.setString(5, usuario.getLog_datacadastro());
			ps.setString(6, usuario.getNome());
			ps.setString(7, usuario.getId());
			ps.setString(8, usuario.getGestorimediato());
			ps.setObject(9, usuario.getDepartamento());
			ps.setString(10, usuario.getEmail());
			ps.setString(11, usuario.getTelefone());
			
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
	public List<Usuario> getUsuarios() throws Exception {		
		   List<Usuario> resultado = new ArrayList<Usuario>();// Montar o resultado
		   
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM login";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					
					Usuario usuario= new Usuario();				
					
					usuario.setLog_usuario(rs.getString("log_usuario"));
					usuario.setLog_senha(rs.getString("log_senha"));
					usuario.setLog_nivelacesso(rs.getString("log_nivelacesso"));
					usuario.setLog_cpf(rs.getString("log_cpf"));
					usuario.setLog_datacadastro(rs.getString("log_datacadastro"));
					usuario.setNome(rs.getString("nome"));
					usuario.setId(rs.getString("id"));
					usuario.setGestorimediato(rs.getString("gestorimediato"));				
					usuario.setDepartamento(rs.getString("departamento"));					
					usuario.setEmail(rs.getString("email"));
					usuario.setTelefone(rs.getString("telefone"));
					usuario.setLog_codigo(rs.getInt("log_codigo"));
														
					resultado.add(usuario);// Add o projeto ao resultado.
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

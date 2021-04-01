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
import br.com.tkcsapcd.model.bean.RecursosHumanos;
import br.com.tkcsapcd.model.util.Conexao;

public class RecursosHumanosDAO implements InterfaceRecursosHumanosDAO {

	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public RecursosHumanosDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}

	@Override
	public void excluir(Integer codigo) throws Exception  {
		// TODO Auto-generated method stub
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM recursoshumanos WHERE codigo = ?;";

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

	@Override
	public void atualizar(RecursosHumanos recursosHumanos) throws Exception  {
		// TODO Auto-generated method stub
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
								
		try{
			String sqlAtualizar = "UPDATE recursoshumanos SET idRecursosHumanos = ?, nome = ?, profissao = ?, area = ?, status = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(recursosHumanos, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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

	private void setPreparedStatement(RecursosHumanos recursosHumanos,	PreparedStatement ps) throws SQLException {
	
		ps.setObject(1, recursosHumanos.getIdRecursosHumanos());
		//ps.setInt(1, recursosHumanos.getIdRecursosHumanos());
		ps.setString(2, recursosHumanos.getNome());		
		ps.setString(3, recursosHumanos.getProfissao());
		ps.setString(4, recursosHumanos.getArea());
		ps.setString(5, recursosHumanos.getStatus());
		ps.setLong(6, recursosHumanos.getCodigo());//Atenção: necessário para isolar o metodo (extração). // Alterado dia 28/05/2014
	}

	@Override
	public void salvar(RecursosHumanos recursosHumanos) throws Exception {
		// TODO Auto-generated method stub
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			
			String sqlInsert = "INSERT INTO recursoshumanos(idRecursosHumanos, nome, profissao, area, status) VALUES (?, ?, ?, ?, ?)";

			ps = con.prepareStatement(sqlInsert);
			
			//ps.setInt(1, recursosHumanos.getIdRecursosHumanos());
			ps.setObject(1, recursosHumanos.getIdRecursosHumanos());
			ps.setString(2, recursosHumanos.getNome());
			ps.setString(3, recursosHumanos.getProfissao());
			ps.setString(4, recursosHumanos.getArea());
			ps.setString(5, recursosHumanos.getStatus());
			
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
	public RecursosHumanos getRecursosHumanos(Integer codigo)throws Exception {
		// TODO Auto-generated method stub
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM recursoshumanos WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<RecursosHumanos> resultado = getListaRecursosHumanos(rs);
			
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

	@Override
	public List<RecursosHumanos> getRecursosHumanoss() throws Exception {
		// TODO Auto-generated method stub
		List<RecursosHumanos> resultado = new ArrayList<RecursosHumanos>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM recursoshumanos";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					
					RecursosHumanos recursosHumanos = new RecursosHumanos();

					//recursosHumanos.setIdRecursosHumanos(rs.getInt("idRecursosHumanos"));
					recursosHumanos.setIdRecursosHumanos(rs.getString("idRecursosHumanos"));
					recursosHumanos.setNome(rs.getString("nome"));					
					recursosHumanos.setProfissao(rs.getString("profissao"));
					recursosHumanos.setArea(rs.getString("area"));
					recursosHumanos.setStatus(rs.getString("status"));
					recursosHumanos.setCodigo(rs.getLong("codigo"));
									
					resultado.add(recursosHumanos);// Add o projeto ao resultado.
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
	private List<RecursosHumanos> getListaRecursosHumanos(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		List<RecursosHumanos> resultado = new ArrayList<RecursosHumanos>();
		
		// Laço p/ preencher
		while (rs.next()) {
			
			RecursosHumanos recursosHumanos = new RecursosHumanos();
			
			//recursosHumanos.setIdRecursosHumanos(rs.getInt("idRecursosHumanos"));
			recursosHumanos.setIdRecursosHumanos(rs.getString("idRecursosHumanos"));
			recursosHumanos.setNome(rs.getString("nome"));
			recursosHumanos.setProfissao(rs.getString("profissao"));
			recursosHumanos.setArea(rs.getString("area"));
			recursosHumanos.setStatus(rs.getString("status"));
			recursosHumanos.setCodigo(rs.getLong("codigo"));
							
			resultado.add(recursosHumanos);// Add o projeto ao resultado.
		}			
		return resultado;
	
	}
	
	//Método para listar a profissão na pagina de cadastrar alocação
	public List<RecursosHumanos> getRecursosHumanosss() throws Exception {
		// TODO Auto-generated method stub
		List<RecursosHumanos> resultado = new ArrayList<RecursosHumanos>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();			
			String sqlSelect = "SELECT * FROM recursoshumanos";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					
					RecursosHumanos recursosHumanos = new RecursosHumanos();

					//recursosHumanos.setIdRecursosHumanos(rs.getInt("idRecursosHumanos"));
					recursosHumanos.setIdRecursosHumanos(rs.getString("idRecursosHumanos"));
					recursosHumanos.setNome(rs.getString("nome"));					
					recursosHumanos.setProfissao(rs.getString("profissao"));
					recursosHumanos.setArea(rs.getString("area"));
					recursosHumanos.setStatus(rs.getString("status"));
					recursosHumanos.setCodigo(rs.getLong("codigo"));
									
					resultado.add(recursosHumanos);// Add o projeto ao resultado.
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

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
import br.com.tkcsapcd.model.bean.Requerimento;
import br.com.tkcsapcd.model.util.Conexao;

public class RequerimentoDAO implements InterfaceRequerimentoDAO {
	
	@SuppressWarnings("unused")
	private InterfacePool pool;
	
	public RequerimentoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
				
		try{

			String SqlExcluir = "DELETE FROM requerimento WHERE codigo = ?;";			
			ps = con.prepareStatement(SqlExcluir);
			ps.setInt(1, codigo);
			ps.executeUpdate();
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
	/*---------------------------------------------------------------------------------------------------------------------------------------*/
	@Override
	public void salvar(Requerimento requerimento) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		
		try{
		String sqlInsert = "INSERT INTO requerimento(nome," +
				" descricao," +
				" resumo," +
				" rqfuncional," +
				" rqtecnologico," +
				" rqstatus," +
				" concordo," +//Implementado dia 28/05/2014
				" codigo) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";		
		
			ps = con.prepareStatement(sqlInsert);
			setPreparedStatement(requerimento, ps);			
			ps.executeUpdate();
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
	/*---------------------------------------------------------------------------------------------------------------------------------------*/

	private void setPreparedStatement(Requerimento requerimento, PreparedStatement ps) throws SQLException{
		
		ps.setString(1, requerimento.getNome());
		ps.setString(2, requerimento.getDescricao());
		ps.setString(3, requerimento.getResumo());
		ps.setString(4, requerimento.getRqfuncional());
		ps.setString(5, requerimento.getRqtecnologico());
		ps.setString(6, requerimento.getRqstatus());
		ps.setString(7, requerimento.getConcordo());//Implementado dia 28/05/2014
		ps.setObject(8, requerimento.getCodigo());
	}
	/*---------------------------------------------------------------------------------------------------------------------------------------*/

	@Override
	public Requerimento getRequerimento(Integer codigo) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
					
		try {
			
			String sqlSelect = "SELECT * FROM requerimento WHERE codigo = ?;";				
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando				
			rs = ps.executeQuery();
				
			List<Requerimento> resultado = getListaRequerimento(rs);
			
			if (resultado.size() > 0)			
				return resultado.get(0);//pegando elemento por chave (unico).			
			
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

	@Override
	public Requerimento getRequerimento(String login) {
		// TODO Auto-generated method stub
		return null;
	}
	/*---------------------------------------------------------------------------------------------------------------------------------------*/


	@Override
	public void atualizar(Requerimento requerimento) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
	
	try {		
		String sqlAtualizar = "UPDATE requerimento SET nome = ?," +				
				" descricao = ?," +
				" resumo = ?," +
				" rqfuncional = ?," +
				" rqtecnologico = ?," +
				" rqstatus = ?," +
				"concordo = ? WHERE codigo = ?;"; ////Implementado dia 28/05/2014
		
		ps = con.prepareStatement(sqlAtualizar);			
		setPreparedStatement(requerimento, ps);//Código isolado do metodo sqlInsert permite usar a mesma linha, facilitando!			
		ps.executeUpdate();//Linha muito importante, sem ela não é executado a atualização do cliente
		ps.close();	
		
	}finally
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
	/*---------------------------------------------------------------------------------------------------------------------------------------*/

	@Override
	public List<Requerimento> getRequerimentos() throws Exception {
		
			List<Requerimento> resultado = new ArrayList<Requerimento>();		
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs = null;
			try {
				con = Conexao.getConnection();
				
				String sqlSelect = "SELECT * FROM requerimento;";	
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.														
				
				//resultado = getListaRequerimento(rs);		
				while(rs.next()){
					
					Requerimento requerimento = new Requerimento();
					
					requerimento.setNome(rs.getString("nome"));
					requerimento.setDescricao(rs.getString("descricao"));
					requerimento.setResumo(rs.getString("resumo"));
					requerimento.setRqfuncional(rs.getString("rqfuncional"));
					requerimento.setRqtecnologico(rs.getString("rqtecnologico"));
					requerimento.setRqstatus(rs.getString("rqstatus"));
					requerimento.setConcordo(rs.getString("concordo"));//Implementado dia 28/05/2014
					requerimento.setCodigo(rs.getInt("codigo"));
					
					resultado.add(requerimento);
					}
				rs.close();
				ps.close();
			} finally {

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
	/*---------------------------------------------------------------------------------------------------------------------------------------*/

	private List<Requerimento> getListaRequerimento(ResultSet rs) throws SQLException{
		
		List<Requerimento> resultado = new ArrayList<Requerimento>();
		
		while(rs.next()){
			
			// criando objeto para cada registro no BD 
			Requerimento requerimento = new Requerimento();
			
			requerimento.setNome(rs.getString("nome"));
			requerimento.setDescricao(rs.getString("descricao"));
			requerimento.setResumo(rs.getString("resumo"));
			requerimento.setRqfuncional(rs.getString("rqfuncional"));
			requerimento.setRqtecnologico(rs.getString("rqtecnologico"));
			requerimento.setRqstatus(rs.getString("rqstatus"));
			requerimento.setConcordo(rs.getString("concordo"));//Implementado dia 28/05/2014
			requerimento.setCodigo(rs.getInt("codigo"));
			
			resultado.add(requerimento);
			}
		return resultado;
	}
	
}

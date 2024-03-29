/* 
	Autor: Josu� da Concei��o Santos
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
import br.com.tkcsapcd.model.bean.DiagramaGantt;
import br.com.tkcsapcd.model.util.Conexao;

public class DiagramaGanttDAO implements InterfaceDiagramaGanttDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public DiagramaGanttDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM diagramagantt WHERE codigo = ?;";

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
	private void setPreparedStatement(DiagramaGantt diagramaGantt, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, diagramaGantt.getTa());	
		ps.setInt(2, diagramaGantt.getCodigo());//Aten��o: necess�rio para isolar o metodo (extra��o). 
		
	}

	@Override
	public DiagramaGantt getDiagramaGantt(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM diagramagantt WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<DiagramaGantt> resultado = getListaDiagramaGantt(rs);
			
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

		//Metodo p confirma objetivo. Resulmir linhas de c�digos, que pode ser usados em outros m�todos. (ex: resultado = getListaCliente(rs); ou List<Cliente> resultado = getListaCliente(rs);)
		private List<DiagramaGantt> getListaDiagramaGantt(ResultSet rs) throws SQLException	{
				List<DiagramaGantt> resultado = new ArrayList<DiagramaGantt>();
			
			// La�o p/ preencher
			while (rs.next()) {
				
				DiagramaGantt diagramaGantt = new DiagramaGantt();
				
				diagramaGantt.setTa(rs.getString("ta"));					
				diagramaGantt.setCodigo(rs.getInt("codigo"));
												
				resultado.add(diagramaGantt);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(DiagramaGantt diagramaGantt) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE diagramagantt SET ta = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(diagramaGantt, ps);//C�digo isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
			ps.executeUpdate();//Linha muito importante, sem ela n�o � executado a atualiza��o do cliente
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
	public void salvar(DiagramaGantt diagramaGantt) throws Exception  {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO diagramagantt(ta) VALUES (?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, diagramaGantt.getTa());		
			
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
	public List<DiagramaGantt> getDiagramaGantts() throws Exception {
		
		   List<DiagramaGantt> resultado = new ArrayList<DiagramaGantt>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs =null;
		try {
			con = Conexao.getConnection();			
			String sqlSelect = "SELECT * FROM diagramagantt";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excu��o da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// La�o p/ preencher
				while (rs.next()) {
					DiagramaGantt diagramaGantt = new DiagramaGantt();
				
					diagramaGantt.setTa(rs.getString("ta"));					
					diagramaGantt.setCodigo(rs.getInt("codigo"));
									
					resultado.add(diagramaGantt);// Add o projeto ao resultado.
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

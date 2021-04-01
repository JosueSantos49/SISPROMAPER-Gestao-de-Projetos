package br.com.tkcsapcd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tkcsapcd.conexao.InterfacePool;
import br.com.tkcsapcd.model.bean.FileBeanAjuda;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.util.Conexao;

import com.mysql.jdbc.Statement;

public class FileAjudaDAO implements InterfaceFileBeanAjudaDAO{

    Connection con = null;
    Statement st = null;  // Ou PreparedStatement
    ResultSet rs = null;
    
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	
	public FileAjudaDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	
	//Criando um ArrayList para armazenar dados
	@SuppressWarnings("static-access")
	public FileAjudaDAO ()throws Exception{
		con = new Conexao().getConnection();
	}
	

	public boolean add(FileBeanAjuda filebeanajuda) throws Exception {
	        int added = 0;
	        java.sql.Connection con = ConexaoHelper.conectar();
	        PreparedStatement st=null;
	        try {
	        	
	            if (con != null) {
	                String sql = "INSERT INTO fileajuda (name, description, data) VALUES (?, ?, ?)";
	                st = con.prepareStatement(sql);
	                
	                st.setString(1, filebeanajuda.getName());
	                st.setString(2, filebeanajuda.getDescription());
	                st.setBytes(3, filebeanajuda.getData());
	                added = st.executeUpdate();
	                
	                st.close();
	                con.close();
	            }
	        }catch (SQLException e) {
	            //tratar erro
	        	e.printStackTrace();
	        	System.out.println("Erro ao tentar inserir file Ajuda: "+e);	        	
	        }finally{
				  // fecha todos os recursos e devolve a conexao ao pool			      
			      if (st != null && !st.isClosed() ) {
			          try { st.close(); } catch (SQLException e) { ; }
			          st = null;
			      }
			      if (con != null && !con.isClosed() ) {
			          try { con.close(); } catch (SQLException e) { ; }
			          con = null;
			      }
			}
	        return added > 0;
	    }

	    @SuppressWarnings({ "rawtypes", "unchecked" })
		public List list() throws Exception{
	    	   List files = new ArrayList();
	        try {
	        	Connection con = (Connection) ConexaoHelper.conectar();
	            if (con != null) {
	                String sql = "SELECT * FROM fileajuda";
	                Statement st = (Statement) con.createStatement();
	                ResultSet rs = st.executeQuery(sql);
	                System.out.println(rs);

	                while(rs.next()){
	                    FileBeanAjuda filebeanajuda = createFileBeanAjuda(rs);
	                    files.add(filebeanajuda);
	                }

	                st.close();
	                con.close();
	            }
	        } catch (SQLException e) {
	            //tratar erro
	        	e.printStackTrace();
	        	System.out.println("Erro ao Listar file ajuda: "+e);
	        	
	        }finally{
				  // fecha todos os recursos e devolve a conexao ao pool			      
			      if (st != null && !st.isClosed() ) {
			          try { st.close(); } catch (SQLException e) { ; }
			          st = null;
			      }
			      if (con != null && !con.isClosed() ) {
			          try { con.close(); } catch (SQLException e) { ; }
			          con = null;
			      }
			}

	        return files;
	    }

	    public FileBeanAjuda getFile(long id) throws Exception {
	           FileBeanAjuda filebeanajuda = null;
	        try {
	        	Connection con = (Connection) ConexaoHelper.conectar();
	            if (con != null) {
	                String sql = "SELECT * FROM fileajuda WHERE id=?";
	                PreparedStatement st = con.prepareStatement(sql);
	                st.setLong(1, id);
	                ResultSet rs = st.executeQuery();
	                if (rs.next()) {
	                    filebeanajuda = createFileBeanAjuda(rs);
	                }
	                rs.close();
	                st.close();
	                con.close();
	            }
	        } catch (SQLException e) {
	        	
	            e.printStackTrace();
	            System.out.println("Erro ao Listar file ajuda pelo ID: "+e);
	            
	        }finally{
				  // fecha todos os recursos e devolve a conexao ao pool
			      if (rs != null && !rs.isClosed() ) {
			          try { rs.close(); } catch (SQLException e) { ; }
			          rs = null;
			      }
			      if (st != null && !st.isClosed() ) {
			          try { st.close(); } catch (SQLException e) { ; }
			          st = null;
			      }
			      if (con != null && !con.isClosed() ) {
			          try { con.close(); } catch (SQLException e) { ; }
			          con = null;
			      }
			}
	        return filebeanajuda;
	    }

	    private FileBeanAjuda createFileBeanAjuda(ResultSet rs) throws SQLException {
	        
	    	FileBeanAjuda filebeanajuda = new FileBeanAjuda();
	    	
	    	filebeanajuda.setId(rs.getLong("id"));
	    	filebeanajuda.setName(rs.getString("name"));
	    	filebeanajuda.setDescription(rs.getString("description"));
	    	filebeanajuda.setData(rs.getBytes("data"));
	        
	        return filebeanajuda;
	    }

		@Override
		public void excluir(Integer id) throws Exception {
			Connection con = Conexao.getConnection();			
			PreparedStatement ps = null;
			
			try {
				String sqlExcluir = "DELETE FROM fileajuda WHERE id = ?;";

				ps = con.prepareStatement(sqlExcluir);
				ps.setInt(1, id);//setando
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

		@Override
		public FileBeanAjuda getFileBeanAjuda(Integer codigo) throws Exception  {
			
			Connection con = Conexao.getConnection();				
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				
				String sqlSelect = "SELECT * FROM fileajuda WHERE codigo = ?;";
				ps = con.prepareStatement(sqlSelect);
				ps.setInt(1, codigo);//setando			
				rs = ps.executeQuery();
					
				List<FileBeanAjuda> resultado = getListaFileBeanAjuda(rs);
				
				if (resultado.size() > 0)			
					return resultado.get(0);//pegando elemento por chave (unico projeto!).			
				
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
			return null;
		}

		private List<FileBeanAjuda> getListaFileBeanAjuda(ResultSet rs) throws SQLException {
				List<FileBeanAjuda> resultado = new ArrayList<FileBeanAjuda>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				FileBeanAjuda fileBeanajuda = new FileBeanAjuda();
				
				fileBeanajuda.setName(rs.getString("name"));
				fileBeanajuda.setDescription(rs.getString("description"));
				fileBeanajuda.setData(rs.getBytes("data"));
				fileBeanajuda.setId(rs.getLong("id"));
												
				resultado.add(fileBeanajuda);// Add o projeto ao resultado.
			}			
			return resultado;
		}

		@Override
		public List<FileBeanAjuda> getFileBeanAjudas() throws Exception  {

			List<FileBeanAjuda> resultado = new ArrayList<FileBeanAjuda>();// Montar o resultado
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs = null;
			try {
				con = Conexao.getConnection();
				
				String sqlSelect = "SELECT * FROM fileajuda";
					
					ps = con.prepareStatement(sqlSelect);
					rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
					
					//resultado = getListaProjeto(rs);					
					// Laço p/ preencher
					while (rs.next()) {
						FileBeanAjuda fileBeanajuda = new FileBeanAjuda();
					
						
						fileBeanajuda.setName(rs.getString("name"));
						fileBeanajuda.setDescription(rs.getString("description"));
						fileBeanajuda.setData(rs.getBytes("data"));
						fileBeanajuda.setId(rs.getLong("id"));
										
						resultado.add(fileBeanajuda);// Add o projeto ao resultado.
					}			
					rs.close();
					ps.close();
					
			}finally{
				  // fecha todos os recursos e devolve a conexao ao pool
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

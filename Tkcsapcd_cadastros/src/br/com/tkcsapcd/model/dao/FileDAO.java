package br.com.tkcsapcd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tkcsapcd.conexao.InterfacePool;
import br.com.tkcsapcd.model.bean.FileBean;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.util.Conexao;

import com.mysql.jdbc.Statement;

public class FileDAO implements InterfaceFileBeanDAO{

	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	
	public FileDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	
	 public FileDAO() {
		// TODO Auto-generated constructor stub
	}

	public boolean add(FileBean filebean) throws Exception {
	        int added = 0;
	        java.sql.Connection con = ConexaoHelper.conectar();
	        PreparedStatement st = null;
	        try {
	        	
	            if (con != null) {
	                String sql = "INSERT INTO file (name, description, data) VALUES (?, ?, ?)";
	                st = con.prepareStatement(sql);
	                
	                st.setString(1, filebean.getName());
	                st.setString(2, filebean.getDescription());
	                st.setBytes(3, filebean.getData());
	                added = st.executeUpdate();
	                
	                st.close();
	                con.close();
	            }
	        } catch (SQLException e) {
	            //tratar erro
	        	e.printStackTrace();
	        	System.out.println("Erro ao tentar inserir file!");
	        }finally 
			{
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
	    	 	Connection con = (Connection) ConexaoHelper.conectar();
	    	 	ResultSet rs = null;
	    	 	Statement st = null;
	        try {
	        	
	            if (con != null) {
	                String sql = "SELECT * FROM file";
	                st = (Statement) con.createStatement();
	                rs = st.executeQuery(sql);
	                System.out.println("Status Upload FileDAO: "+rs);

	                while(rs.next()){
	                    FileBean filebean = createFileBean(rs);
	                    files.add(filebean);
	                }

	                st.close();
	                con.close();
	            }
	        } catch (SQLException e) {
	            //tratar erro
	        	e.printStackTrace();
	        	System.out.println("Listar");
	        } finally 
			{
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

	        return files;
	    }

	    public FileBean getFile(long id) throws Exception {
	           FileBean filebean = null;
	           Connection con = (Connection) ConexaoHelper.conectar();
	           PreparedStatement st =null;
	           ResultSet rs = null;
	        try {
	        	
	            if (con != null) {
	                String sql = "SELECT * FROM file WHERE id=?";
	                st = con.prepareStatement(sql);
	                st.setLong(1, id);
	                
	                rs = st.executeQuery();
	                if (rs.next()) {
	                    filebean = createFileBean(rs);
	                }
	                rs.close();
	                st.close();
	                con.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("Listar pelo ID");
	        } finally 
			{
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
	        return filebean;
	    }

	    private FileBean createFileBean(ResultSet rs) throws SQLException {
	        
	    	FileBean filebean = new FileBean();
	    	
	    	filebean.setId(rs.getLong("id"));
	    	filebean.setName(rs.getString("name"));
	    	filebean.setDescription(rs.getString("description"));
	    	filebean.setData(rs.getBytes("data"));
	        
	        return filebean;
	    }

		@Override
		public void excluir(Integer id) throws Exception {
			Connection con = Conexao.getConnection();			
			PreparedStatement ps = null;
			
			try {
				String sqlExcluir = "DELETE FROM file WHERE id = ?;";

				ps = con.prepareStatement(sqlExcluir);
				ps.setInt(1, id);//setando
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
		public FileBean getFileBean(Integer codigo) throws Exception  {
			
			Connection con = Conexao.getConnection();				
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				
				String sqlSelect = "SELECT * FROM file WHERE codigo = ?;";
				ps = con.prepareStatement(sqlSelect);
				ps.setInt(1, codigo);//setando			
				rs = ps.executeQuery();
					
				List<FileBean> resultado = getListaFileBean(rs);
				
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

		private List<FileBean> getListaFileBean(ResultSet rs) throws SQLException {
				List<FileBean> resultado = new ArrayList<FileBean>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				FileBean fileBean = new FileBean();
				
				fileBean.setName(rs.getString("name"));
				fileBean.setDescription(rs.getString("description"));
				fileBean.setData(rs.getBytes("data"));
				fileBean.setId(rs.getLong("id"));
												
				resultado.add(fileBean);// Add o projeto ao resultado.
			}			
			return resultado;
		}

		@Override
		public List<FileBean> getFileBeans() throws Exception  {

			List<FileBean> resultado = new ArrayList<FileBean>();// Montar o resultado
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs =null;
			try {
				con = Conexao.getConnection();				
				String sqlSelect = "SELECT * FROM file";
					
					ps = con.prepareStatement(sqlSelect);
					rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
					
					//resultado = getListaProjeto(rs);					
					// Laço p/ preencher
					while (rs.next()) {
						FileBean fileBean = new FileBean();
					
						
						fileBean.setName(rs.getString("name"));
						fileBean.setDescription(rs.getString("description"));
						fileBean.setData(rs.getBytes("data"));
						fileBean.setId(rs.getLong("id"));
										
						resultado.add(fileBean);// Add o projeto ao resultado.
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

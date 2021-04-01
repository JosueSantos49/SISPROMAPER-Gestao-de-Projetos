package br.com.tkcsapcd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tkcsapcd.conexao.InterfacePool;
import br.com.tkcsapcd.model.bean.FileBeanProjeto;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.util.Conexao;

import com.mysql.jdbc.Statement;

public class FileProjetoDAO implements InterfaceFileBeanProjetoDAO{

    Connection con = null;
    Statement st = null;  // Ou PreparedStatement
    ResultSet rs = null;
    
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	
	public FileProjetoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	
	//Criando um ArrayList para armazenar dados
	@SuppressWarnings("static-access")
	public FileProjetoDAO ()throws Exception{
		con = new Conexao().getConnection();
	}
	
	@Override
	public void atualizar(FileBeanProjeto fileBeanProjeto) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
								
		try{
			String sqlAtualizar = "UPDATE fileprojeto SET  name = ?, description = ?, data = ?, codigoprojeto = ?, comentario = ?, dataregistro = ?, email = ? WHERE id = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(fileBeanProjeto, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	
	private void setPreparedStatement(FileBeanProjeto fileBeanProjeto, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, fileBeanProjeto.getName());
        ps.setString(2, fileBeanProjeto.getDescription());
        ps.setBytes(3, fileBeanProjeto.getData());	                
        ps.setInt(4, fileBeanProjeto.getCodigoprojeto());
        ps.setString(5, fileBeanProjeto.getComentario());	                
        ps.setDate(6, new java.sql.Date(fileBeanProjeto.getDataregistro().getTime() )); //transforma o java util date em java sql date
        ps.setString(7, fileBeanProjeto.getEmail());
		ps.setObject(8, fileBeanProjeto.getId());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	public boolean add(FileBeanProjeto filebeanprojeto) throws Exception {
	        int added = 0;
	        java.sql.Connection con = ConexaoHelper.conectar();
	        PreparedStatement st = null;
	        try {
	        	
	            if (con != null) {
	                String sql = "INSERT INTO fileprojeto (name, description, data, codigoprojeto, comentario, dataregistro, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
	                st = con.prepareStatement(sql);
	                
	                st.setString(1, filebeanprojeto.getName());
	                st.setString(2, filebeanprojeto.getDescription());
	                st.setBytes(3, filebeanprojeto.getData());	                
	                st.setInt(4, filebeanprojeto.getCodigoprojeto());
	                st.setString(5, filebeanprojeto.getComentario());	                
	                st.setDate(6, new java.sql.Date(filebeanprojeto.getDataregistro().getTime() )); //transforma o java util date em java sql date
	                st.setString(7, filebeanprojeto.getEmail());
	                
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
	    	   Connection con = (Connection) ConexaoHelper.conectar();
	    	   Statement st = null;
	    	   ResultSet rs = null;
	        try {	        	
	            if (con != null) {
	                String sql = "SELECT * FROM fileprojeto";
	                st = (Statement) con.createStatement();
	                rs = st.executeQuery(sql);
	                System.out.println(rs);

	                while(rs.next()){
	                    FileBeanProjeto filebeanprojeto = createFileBeanProjeto(rs);
	                    files.add(filebeanprojeto);
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

	    public FileBeanProjeto getFile(long id) throws Exception {
	           FileBeanProjeto filebeanprojeto = null;
	           Connection con = (Connection) ConexaoHelper.conectar();
	           PreparedStatement st = null;
	           ResultSet rs = null;
	        try {
	        	
	            if (con != null) {
	                String sql = "SELECT * FROM fileprojeto WHERE id=?";
	                st = con.prepareStatement(sql);
	                st.setLong(1, id);
	                rs = st.executeQuery();
	                if (rs.next()) {
	                    filebeanprojeto = createFileBeanProjeto(rs);
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
	        return filebeanprojeto;
	    }

	    private FileBeanProjeto createFileBeanProjeto(ResultSet rs) throws SQLException {
	        
	    	FileBeanProjeto filebeanprojeto = new FileBeanProjeto();
	    	
	    	filebeanprojeto.setId(rs.getLong("id"));
	    	filebeanprojeto.setName(rs.getString("name"));
	    	filebeanprojeto.setDescription(rs.getString("description"));
	    	filebeanprojeto.setData(rs.getBytes("data"));
	    	filebeanprojeto.setCodigoprojeto(rs.getInt("codigoprojeto"));
			filebeanprojeto.setComentario(rs.getString("comentario"));
			filebeanprojeto.setDataregistro(rs.getDate("dataregistro"));
			filebeanprojeto.setEmail(rs.getString("email"));
	        
	        return filebeanprojeto;
	    }

		@Override
		public void excluir(Integer id) throws Exception {
			Connection con = Conexao.getConnection();			
			PreparedStatement ps = null;
			
			try {
				String sqlExcluir = "DELETE FROM fileprojeto WHERE id = ?;";

				ps = con.prepareStatement(sqlExcluir);
				ps.setInt(1, id);//setando
				ps.executeUpdate();
				ps.close();
				
			}finally{
				  // fecha todos os recursos e devolve a conexao ao pool
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
		public FileBeanProjeto getFileBeanProjeto(Integer id) throws Exception  {
			
			Connection con = Conexao.getConnection();				
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				
				String sqlSelect = "SELECT * FROM fileprojeto WHERE id = ?;";
				ps = con.prepareStatement(sqlSelect);
				ps.setInt(1, id);//setando			
				rs = ps.executeQuery();
					
				List<FileBeanProjeto> resultado = getListaFileBeanProjeto(rs);
				
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

		private List<FileBeanProjeto> getListaFileBeanProjeto(ResultSet rs) throws SQLException {
				List<FileBeanProjeto> resultado = new ArrayList<FileBeanProjeto>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				FileBeanProjeto filebeanprojeto = new FileBeanProjeto();
				
				filebeanprojeto.setName(rs.getString("name"));
				filebeanprojeto.setDescription(rs.getString("description"));
				filebeanprojeto.setData(rs.getBytes("data"));
				filebeanprojeto.setCodigoprojeto(rs.getInt("codigoprojeto"));
				filebeanprojeto.setComentario(rs.getString("comentario"));
				filebeanprojeto.setDataregistro(rs.getDate("dataregistro"));
				filebeanprojeto.setEmail(rs.getString("email"));
				filebeanprojeto.setId(rs.getLong("id"));
												
				resultado.add(filebeanprojeto);// Add o projeto ao resultado.
			}			
			return resultado;
		}

		@Override
		public List<FileBeanProjeto> getFileBeanProjetos() throws Exception  {
			   List<FileBeanProjeto> resultado = new ArrayList<FileBeanProjeto>();// Montar o resultado
			   Connection con = Conexao.getConnection();
			   PreparedStatement ps=null;
			   ResultSet rs = null;
			try {
								
				String sqlSelect = "SELECT * FROM fileprojeto";
					
					ps = con.prepareStatement(sqlSelect);
					rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
					
					//resultado = getListaProjeto(rs);					
					// Laço p/ preencher
					while (rs.next()) {
						
						FileBeanProjeto filebeanprojeto = new FileBeanProjeto();
						
						filebeanprojeto.setName(rs.getString("name"));
						filebeanprojeto.setDescription(rs.getString("description"));
						filebeanprojeto.setData(rs.getBytes("data"));						
						filebeanprojeto.setCodigoprojeto(rs.getInt("codigoprojeto"));
						filebeanprojeto.setComentario("comentario");
						filebeanprojeto.setDataregistro(rs.getDate("dataregistro"));
						filebeanprojeto.setEmail(rs.getString("email"));						
						filebeanprojeto.setId(rs.getLong("id"));
										
						resultado.add(filebeanprojeto);// Add o projeto ao resultado.
					}			
					rs.close();
					ps.close();
					
			}finally{
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

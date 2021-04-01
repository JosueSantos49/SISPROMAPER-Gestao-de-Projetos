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
import br.com.tkcsapcd.model.bean.ProjetoInicio;
import br.com.tkcsapcd.model.util.Conexao;

public class ProjetoInicioDAO implements InterfaceProjetoInicioDAO{	
	
	//todos os atributos tem uma conexão
	@SuppressWarnings("unused")
	private static Connection con;
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	
	//Construtor que recebe o pool como parametro
	public ProjetoInicioDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	
	//Criando um ArrayList para armazenar as notícias
	@SuppressWarnings("static-access")
	public ProjetoInicioDAO ()throws Exception{
		con = new Conexao().getConnection();
	}

	
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM projetoinicio WHERE codigo = ?;";
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
	public void salvar(ProjetoInicio projetoInicio) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			
			//Validar teste de duplicação de registro aqui!
			//SELECT * FROM projeto WHERE codigodoprojeto = 'codigodoprojeto';
					
			String sqlInsert = "INSERT INTO projetoinicio(codigoprojeto, projeto, data, atribuiprojeto, tipoprojeto, objetivo, cliente, programa, area, roi, descricao, copia) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sqlInsert);
						
			ps.setInt(1, projetoInicio.getCodigoprojeto());
			ps.setString(2, projetoInicio.getProjeto());
			ps.setDate(3, new java.sql.Date(projetoInicio.getData().getTime()));
			ps.setString(4, projetoInicio.getAtribuiprojeto());
			ps.setString(5, projetoInicio.getTipoprojeto());
			ps.setString(6, projetoInicio.getObjetivo());
			ps.setString(7, projetoInicio.getCliente());
			ps.setString(8, projetoInicio.getPrograma());
			ps.setString(9, projetoInicio.getArea());
			ps.setObject(10, projetoInicio.getRoi());
			ps.setString(11, projetoInicio.getDescricao());
			ps.setObject(12, projetoInicio.getCopia());
			
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
	public void atualizar(ProjetoInicio projetoInicio) throws Exception  {
		
			Connection con = Conexao.getConnection();
			PreparedStatement ps=null;						
									
			try{
				String sqlAtualizar = "UPDATE projetoinicio SET codigoprojeto = ?, projeto = ?, data = ?, atribuiprojeto = ?, tipoprojeto = ?, objetivo = ?, cliente = ?, programa = ?, area = ?, roi = ?, descricao = ?, copia = ? WHERE codigo = ?;";
				ps = con.prepareStatement(sqlAtualizar);
				setPreparedStatement(projetoInicio, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	private void setPreparedStatement(ProjetoInicio projetoInicio, PreparedStatement ps) throws SQLException 
	{
		ps.setInt(1, projetoInicio.getCodigoprojeto());
		ps.setString(2, projetoInicio.getProjeto());
		ps.setDate(3, new java.sql.Date(projetoInicio.getData().getTime()));
		ps.setString(4, projetoInicio.getAtribuiprojeto());
		ps.setString(5, projetoInicio.getTipoprojeto());
		ps.setString(6, projetoInicio.getObjetivo());
		ps.setString(7, projetoInicio.getCliente());
		ps.setString(8, projetoInicio.getPrograma());
		ps.setString(9, projetoInicio.getArea());
		ps.setObject(10, projetoInicio.getRoi());
		ps.setString(11, projetoInicio.getDescricao());
		ps.setObject(12, projetoInicio.getCopia());
		ps.setLong(13, projetoInicio.getCodigo());//Atenção: necessário para isolar o metodo (extração). 		
	}

	@Override
	public ProjetoInicio getProjetoInicio(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM projetoinicio WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<ProjetoInicio> resultado = getListaProjetoInicio(rs);
			
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

		@Override
		public List<ProjetoInicio> getProjetoInicios() throws Exception {				
			   List<ProjetoInicio> resultado = new ArrayList<ProjetoInicio>();// Montar o resultado
				
			   Connection con=null;
				PreparedStatement ps=null;
				ResultSet rs =null;
				
				try {
					con = Conexao.getConnection();
					
					String sqlSelect = "SELECT * FROM projetoinicio";
						
						ps = con.prepareStatement(sqlSelect);
						rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
						
						//resultado = getListaProjeto(rs);					
						// Laço p/ preencher
						while (rs.next()) {
							
							ProjetoInicio projetoInicio = new ProjetoInicio();								
							
							projetoInicio.setCodigoprojeto(rs.getInt("codigoprojeto"));
							projetoInicio.setProjeto(rs.getString("projeto"));
							projetoInicio.setData(rs.getDate("data"));
							projetoInicio.setAtribuiprojeto(rs.getString("atribuiprojeto"));
							projetoInicio.setTipoprojeto(rs.getString("tipoprojeto"));
							projetoInicio.setObjetivo(rs.getString("objetivo"));
							projetoInicio.setCliente(rs.getString("cliente"));
							projetoInicio.setPrograma(rs.getString("programa"));
							projetoInicio.setArea(rs.getString("area"));
							projetoInicio.setRoi(rs.getDouble("roi"));
							projetoInicio.setDescricao(rs.getString("descricao"));
							projetoInicio.setCopia(rs.getString("copia"));
							projetoInicio.setCodigo(rs.getLong("codigo"));
											
							resultado.add(projetoInicio);// Add o projeto ao resultado.						
							
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
	/*---------------------------------------------------------------------------------------------------------------------------------------*/

		//Metodo p confirma objetivo. Resulmir linhas de códigos, que pode ser usados em outros métodos. (ex: resultado = getListaCliente(rs); ou List<Cliente> resultado = getListaCliente(rs);)
		private List<ProjetoInicio> getListaProjetoInicio(ResultSet rs) throws SQLException	{
				List<ProjetoInicio> resultado = new ArrayList<ProjetoInicio>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				ProjetoInicio projetoInicio = new ProjetoInicio();
				
				projetoInicio.setCodigoprojeto(rs.getInt("codigoprojeto"));
				projetoInicio.setProjeto(rs.getString("projeto"));
				projetoInicio.setData(rs.getDate("data"));
				projetoInicio.setAtribuiprojeto(rs.getString("atribuiprojeto"));
				projetoInicio.setTipoprojeto(rs.getString("tipoprojeto"));
				projetoInicio.setObjetivo(rs.getString("objetivo"));
				projetoInicio.setCliente(rs.getString("cliente"));
				projetoInicio.setPrograma(rs.getString("programa"));
				projetoInicio.setArea(rs.getString("area"));
				projetoInicio.setRoi(rs.getDouble("roi"));
				projetoInicio.setDescricao(rs.getString("descricao"));
				projetoInicio.setCopia(rs.getString("copia"));
				projetoInicio.setCodigo(rs.getLong("codigo"));
								
				resultado.add(projetoInicio);// Add o projeto ao resultado.
			}		
			
			return resultado;
		}
	
		//---------------------------------------------------------------------------------------------------------------------------------------------

		@Override		
		//Método para listar o nome projetoinicio na tela do cadastro de outras transações		
		public List<ProjetoInicio> getPProjetoInicios() throws Exception  {
			// 
			List<ProjetoInicio> resultado = new ArrayList<ProjetoInicio>();
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs = null;
			
			try {
				con = Conexao.getConnection();		
							
				String sqlSelect = "SELECT * FROM projetoinicio;";
					
					ps = con.prepareStatement(sqlSelect);
					rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
					
					//resultado = getListaDepartamentos(rs);	
					// Laço p/ preencher, enquanto o rs tiver registro, vai retornar verdadeiro e moverá o curso para o próximo(Laço p/ preencher).
					while (rs.next()) {
									
						ProjetoInicio projetoInicio = new ProjetoInicio();
													
						projetoInicio.setProjeto(rs.getString("projeto"));
						projetoInicio.setCodigo(rs.getLong("codigo"));
													
						// Add o cliente ao resultado
						resultado.add(projetoInicio);
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
		//---------------------------------------------------------------------------------------------------------------------------------------------		
}

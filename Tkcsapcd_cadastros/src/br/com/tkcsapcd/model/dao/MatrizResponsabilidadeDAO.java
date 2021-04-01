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
import br.com.tkcsapcd.model.bean.MatrizResponsabilidade;
import br.com.tkcsapcd.model.util.Conexao;

public class MatrizResponsabilidadeDAO implements InterfaceMatrizResponsabilidadeDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	//Construtor que recebe o pool como parametro
	public MatrizResponsabilidadeDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM matrizresponsabilidade WHERE codigo = ?;";
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
	public void salvar(MatrizResponsabilidade matrizResponsabilidade) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			
			//Validar teste de duplicação de registro aqui!
			//SELECT * FROM projeto WHERE codigodoprojeto = 'codigodoprojeto';
					
			String sqlInsert = "INSERT INTO matrizresponsabilidade(codigoeap, atividade, descricao, responsavel, aprovar, consultado, informado, participante) VALUES (?, ?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sqlInsert);
			
			ps.setInt(1, matrizResponsabilidade.getCodigoeap());
			ps.setString(2, matrizResponsabilidade.getAtividade());
			ps.setString(3, matrizResponsabilidade.getDescricao());
			ps.setString(4, matrizResponsabilidade.getResponsavel());
			ps.setString(5, matrizResponsabilidade.getAprovar());
			ps.setString(6, matrizResponsabilidade.getConsultado());
			ps.setString(7, matrizResponsabilidade.getInformado());
			ps.setString(8, matrizResponsabilidade.getParticipante());
						
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
	public void atualizar(MatrizResponsabilidade matrizResponsabilidade) throws Exception  {
		
			Connection con = Conexao.getConnection();
			PreparedStatement ps=null;						
									
			try{
				String sqlAtualizar = "UPDATE matrizresponsabilidade SET codigoeap = ?, atividade = ?, descricao = ?, responsavel = ?, aprovar = ?, consultado = ?, informado = ?, participante = ? WHERE codigo = ?;";
				ps = con.prepareStatement(sqlAtualizar);
				setPreparedStatement(matrizResponsabilidade, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	private void setPreparedStatement(MatrizResponsabilidade matrizResponsabilidade, PreparedStatement ps) throws SQLException 
	{
		ps.setInt(1, matrizResponsabilidade.getCodigoeap());
		ps.setString(2, matrizResponsabilidade.getAtividade());
		ps.setString(3, matrizResponsabilidade.getDescricao());
		ps.setString(4, matrizResponsabilidade.getResponsavel());
		ps.setString(5, matrizResponsabilidade.getAprovar());
		ps.setString(6, matrizResponsabilidade.getConsultado());
		ps.setString(7, matrizResponsabilidade.getInformado());
		ps.setString(8, matrizResponsabilidade.getParticipante());
		ps.setInt(9, matrizResponsabilidade.getCodigo());//Atenção: necessário para isolar o metodo (extração). // Alterado dia 28/05/2014		
	}

	@Override
	public MatrizResponsabilidade getMatrizResponsabilidade(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM matrizresponsabilidade WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<MatrizResponsabilidade> resultado = getListaMatrizResponsabilidade(rs);
			
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
	public List<MatrizResponsabilidade> getMatrizResponsabilidades() throws Exception 
	{				
				List<MatrizResponsabilidade> resultado = new ArrayList<MatrizResponsabilidade>();// Montar o resultado
				Connection con=null;
				PreparedStatement ps=null;
				ResultSet rs = null;
				try {
					con = Conexao.getConnection();
					
					String sqlSelect = "SELECT * FROM matrizresponsabilidade";
						
						ps = con.prepareStatement(sqlSelect);
						rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
						
						//resultado = getListaProjeto(rs);					
						// Laço p/ preencher
						while (rs.next()) {
							
							MatrizResponsabilidade matrizResponsabilidade = new MatrizResponsabilidade();
							
							matrizResponsabilidade.setCodigoeap(rs.getInt("codigoeap"));
							matrizResponsabilidade.setAtividade(rs.getString("atividade"));
							matrizResponsabilidade.setDescricao(rs.getString("descricao"));
							matrizResponsabilidade.setResponsavel(rs.getString("responsavel"));
							matrizResponsabilidade.setAprovar(rs.getString("aprovar"));
							matrizResponsabilidade.setConsultado(rs.getString("consultado"));
							matrizResponsabilidade.setInformado(rs.getString("informado"));
							matrizResponsabilidade.setParticipante(rs.getString("participante"));
							matrizResponsabilidade.setCodigo(rs.getInt("codigo"));
							
							
											
							resultado.add(matrizResponsabilidade);// Add o projeto ao resultado.
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
		private List<MatrizResponsabilidade> getListaMatrizResponsabilidade(ResultSet rs) throws SQLException	{
				List<MatrizResponsabilidade> resultado = new ArrayList<MatrizResponsabilidade>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				MatrizResponsabilidade matrizResponsabilidade = new MatrizResponsabilidade();
				
				matrizResponsabilidade.setCodigoeap(rs.getInt("codigoeap"));
				matrizResponsabilidade.setAtividade(rs.getString("atividade"));
				matrizResponsabilidade.setDescricao(rs.getString("descricao"));
				matrizResponsabilidade.setResponsavel(rs.getString("responsavel"));
				matrizResponsabilidade.setAprovar(rs.getString("aprovar"));
				matrizResponsabilidade.setConsultado(rs.getString("consultado"));
				matrizResponsabilidade.setInformado(rs.getString("informado"));
				matrizResponsabilidade.setParticipante(rs.getString("participante"));
				matrizResponsabilidade.setCodigo(rs.getInt("codigo"));
								
				resultado.add(matrizResponsabilidade);// Add o projeto ao resultado.
			}		
			
			return resultado;
		}
	
		//---------------------------------------------------------------------------------------------------------------------------------------------

		//@Override
		/*
		//Método para listar o nome projeto na tela do cadastro de alocação		
		public List<Projeto> getPProjetos() throws Exception  {
			// 
			List<Projeto> resultado = new ArrayList<Projeto>();
			Connection con=null;
			
			try {
				con = Conexao.getConnection();		
				PreparedStatement ps;			
				String sqlSelect = "SELECT * FROM projeto;";
					
					ps = con.prepareStatement(sqlSelect);
					ResultSet rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
					
					//resultado = getListaDepartamentos(rs);	
					// Laço p/ preencher, enquanto o rs tiver registro, vai retornar verdadeiro e moverá o curso para o próximo(Laço p/ preencher).
					while (rs.next()) {
									
						Projeto projeto = new Projeto();
													
						projeto.setTituloProjeto(rs.getString("tituloProjeto"));
						projeto.setCodigo(rs.getInt("codigo"));
													
						// Add o cliente ao resultado
						resultado.add(projeto);
					}
						rs.close();
						ps.close();
			} finally {
				con.close();
			}	
					
			return resultado;
		}
		
		//---------------------------------------------------------------------------------------------------------------------------------------------
*/
		
}

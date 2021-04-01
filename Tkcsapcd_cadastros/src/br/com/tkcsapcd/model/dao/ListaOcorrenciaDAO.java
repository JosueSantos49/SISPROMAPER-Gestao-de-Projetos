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
import br.com.tkcsapcd.model.bean.ListaOcorrencia;
import br.com.tkcsapcd.model.util.Conexao;

public class ListaOcorrenciaDAO implements InterfaceListaOcorrenciaDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	//Construtor que recebe o pool como parametro
	public ListaOcorrenciaDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM listaocorrencia WHERE codigo = ?;";
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
	public void salvar(ListaOcorrencia listaOcorrencia) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		try {
			
			//Validar teste de duplicação de registro aqui!
			//SELECT * FROM projeto WHERE codigodoprojeto = 'codigodoprojeto';
					
			String sqlInsert = "INSERT INTO listaocorrencia(data, codigoprojeto, cliente, gerente, preparado, objetivo, resumo, issue, severidade, urgencia, responsavel, dataocorrencia, conclusao) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sqlInsert);
			
			ps.setDate(1, new java.sql.Date(listaOcorrencia.getData().getTime() )); //transforma o java util date em java sql date
			ps.setInt(2, listaOcorrencia.getCodigoprojeto());
			ps.setString(3, listaOcorrencia.getCliente());
			ps.setString(4, listaOcorrencia.getGerente());
			ps.setString(5, listaOcorrencia.getPreparado());
			ps.setString(6, listaOcorrencia.getObjetivo());
			ps.setString(7, listaOcorrencia.getResumo());
			ps.setString(8, listaOcorrencia.getIssue());
			ps.setString(9, listaOcorrencia.getSeveridade());
			ps.setObject(10, listaOcorrencia.getUrgencia());
			ps.setString(11, listaOcorrencia.getResponsavel());
			ps.setDate(12, new java.sql.Date (listaOcorrencia.getDataocorrencia().getTime()));
			ps.setObject(13, listaOcorrencia.getConclusao());
						
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
	public void atualizar(ListaOcorrencia listaOcorrencia) throws Exception  {
		
			Connection con = Conexao.getConnection();
			PreparedStatement ps=null;						
									
			try{
				String sqlAtualizar = "UPDATE listaocorrencia SET data = ?, codigoprojeto = ?, cliente = ?, gerente = ?, preparado = ?, objetivo = ?, resumo = ?, issue = ?, severidade = ?, urgencia = ?, responsavel = ?, dataocorrencia = ?, conclusao = ? WHERE codigo = ?;";
				ps = con.prepareStatement(sqlAtualizar);
				setPreparedStatement(listaOcorrencia, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	private void setPreparedStatement(ListaOcorrencia listaOcorrencia, PreparedStatement ps) throws SQLException 
	{
		ps.setDate(1, new java.sql.Date(listaOcorrencia.getData().getTime() )); //transforma o java util date em java sql date
		ps.setInt(2, listaOcorrencia.getCodigoprojeto());
		ps.setString(3, listaOcorrencia.getCliente());
		ps.setString(4, listaOcorrencia.getGerente());
		ps.setString(5, listaOcorrencia.getPreparado());
		ps.setString(6, listaOcorrencia.getObjetivo());
		ps.setString(7, listaOcorrencia.getResumo());
		ps.setString(8, listaOcorrencia.getIssue());
		ps.setString(9, listaOcorrencia.getSeveridade());
		ps.setObject(10, listaOcorrencia.getUrgencia());
		ps.setString(11, listaOcorrencia.getResponsavel());
		ps.setDate(12, new java.sql.Date (listaOcorrencia.getDataocorrencia().getTime()));
		ps.setObject(13, listaOcorrencia.getConclusao());
		ps.setInt(14, listaOcorrencia.getCodigo());//Atenção: necessário para isolar o metodo (extração). // Alterado dia 28/05/2014		
	}

	@Override
	public ListaOcorrencia getListaOcorrencia(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM listaocorrencia WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<ListaOcorrencia> resultado = getListaOcorrencia(rs);
			
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
	public List<ListaOcorrencia> getListaOcorrencias() throws Exception 
	{				
				List<ListaOcorrencia> resultado = new ArrayList<ListaOcorrencia>();// Montar o resultado
				Connection con=null;
				PreparedStatement ps=null;
				ResultSet rs = null;
				try {
					con = Conexao.getConnection();
					
					String sqlSelect = "SELECT * FROM listaocorrencia";
						
						ps = con.prepareStatement(sqlSelect);
						rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
						
						//resultado = getListaProjeto(rs);					
						// Laço p/ preencher
						while (rs.next()) {
							
							ListaOcorrencia listaOcorrencia = new ListaOcorrencia();
							
							listaOcorrencia.setData(rs.getDate("data"));
							listaOcorrencia.setCodigoprojeto(rs.getInt("codigoprojeto"));
							listaOcorrencia.setCliente(rs.getString("cliente"));
							listaOcorrencia.setGerente(rs.getString("gerente"));
							listaOcorrencia.setPreparado(rs.getString("preparado"));
							listaOcorrencia.setObjetivo(rs.getString("objetivo"));
							listaOcorrencia.setResumo(rs.getString("resumo"));
							listaOcorrencia.setIssue(rs.getString("issue"));
							listaOcorrencia.setSeveridade(rs.getString("severidade"));
							listaOcorrencia.setUrgencia(rs.getString("urgencia"));
							listaOcorrencia.setResponsavel(rs.getString("responsavel"));
							listaOcorrencia.setDataocorrencia(rs.getDate("dataocorrencia"));
							listaOcorrencia.setConclusao(rs.getString("conclusao"));
							listaOcorrencia.setCodigo(rs.getInt("codigo"));
							
							//data, codigoprojeto, cliente, gerente, preparado, objetivo, resumo, issue, severidade, urgencia, responsavel, dataocorrencia, conclusao
											
							resultado.add(listaOcorrencia);// Add o projeto ao resultado.
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
		private List<ListaOcorrencia> getListaOcorrencia(ResultSet rs) throws SQLException	{
				List<ListaOcorrencia> resultado = new ArrayList<ListaOcorrencia>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				ListaOcorrencia listaOcorrencia = new ListaOcorrencia();
				
				listaOcorrencia.setData(rs.getDate("data"));
				listaOcorrencia.setCodigoprojeto(rs.getInt("codigoprojeto"));
				listaOcorrencia.setCliente(rs.getString("cliente"));
				listaOcorrencia.setGerente(rs.getString("gerente"));
				listaOcorrencia.setPreparado(rs.getString("preparado"));
				listaOcorrencia.setObjetivo(rs.getString("objetivo"));
				listaOcorrencia.setResumo(rs.getString("resumo"));
				listaOcorrencia.setIssue(rs.getString("issue"));
				listaOcorrencia.setSeveridade(rs.getString("severidade"));
				listaOcorrencia.setUrgencia(rs.getString("urgencia"));
				listaOcorrencia.setResponsavel(rs.getString("responsavel"));
				listaOcorrencia.setDataocorrencia(rs.getDate("dataocorrencia"));
				listaOcorrencia.setConclusao(rs.getString("conclusao"));
				listaOcorrencia.setCodigo(rs.getInt("codigo"));
								
				resultado.add(listaOcorrencia);// Add o projeto ao resultado.
			}		
			
			return resultado;
		}
	
		//---------------------------------------------------------------------------------------------------------------------------------------------

		//@Override
		
		//Método para listar o nome projeto na tela do cadastro de alocação		
		/*public List<Projeto> getPProjetos() throws Exception  {
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

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
import br.com.tkcsapcd.model.bean.PlanoGerenciamentoRequisito;
import br.com.tkcsapcd.model.bean.ProjetoInicio;
import br.com.tkcsapcd.model.util.Conexao;

public class PlanoGerenciamentoRequisitoDAO implements InterfacePlanoGerenciamentoRequisitoDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public PlanoGerenciamentoRequisitoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM planogerenciamentorequisito WHERE codigo = ?;";

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
	
	private void setPreparedStatement(PlanoGerenciamentoRequisito planoGerenciamentoRequisito, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, planoGerenciamentoRequisito.getPlanogerenciamentorequisito());
		ps.setString(2, planoGerenciamentoRequisito.getVersao());
		ps.setDate(3, new java.sql.Date(planoGerenciamentoRequisito.getData().getTime()));
		ps.setString(4, planoGerenciamentoRequisito.getAutor());
		ps.setString(5, planoGerenciamentoRequisito.getNotarevisao());
		ps.setString(6, planoGerenciamentoRequisito.getAprovacao());
		ps.setObject(7, planoGerenciamentoRequisito.getObjetivo());
		ps.setString(8, planoGerenciamentoRequisito.getGerenciamento());
		ps.setString(9, planoGerenciamentoRequisito.getProcesso());		
		ps.setString(10, planoGerenciamentoRequisito.getDocumento());
		ps.setString(11, planoGerenciamentoRequisito.getResponsabilidade());
		ps.setString(12, planoGerenciamentoRequisito.getConfiguracao());	
		ps.setString(13, planoGerenciamentoRequisito.getPrioridade());
		ps.setString(14, planoGerenciamentoRequisito.getColeta());
		ps.setString(15, planoGerenciamentoRequisito.getRatreabilidade());
		ps.setString(16, planoGerenciamentoRequisito.getMetrica());	
		ps.setObject(17, planoGerenciamentoRequisito.getProjetoinicio().getCodigo());
		ps.setInt(18, planoGerenciamentoRequisito.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public PlanoGerenciamentoRequisito getPlanoGerenciamentoRequisito(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM planogerenciamentorequisito WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<PlanoGerenciamentoRequisito> resultado = getListaPlanoGerenciamentoRequisito(rs);
			
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

		//Metodo p confirma objetivo. Resulmir linhas de códigos, que pode ser usados em outros métodos. 
		//(ex: resultado = getListaCliente(rs); ou List<Cliente> resultado = getListaCliente(rs);)
		private List<PlanoGerenciamentoRequisito> getListaPlanoGerenciamentoRequisito(ResultSet rs) throws SQLException	{
			List<PlanoGerenciamentoRequisito> resultado = new ArrayList<PlanoGerenciamentoRequisito>();
			
			// Laço p/ preencher
			while (rs.next()) {
				PlanoGerenciamentoRequisito planoGerenciamentoRequisito = new PlanoGerenciamentoRequisito();
				
				planoGerenciamentoRequisito.setPlanogerenciamentorequisito(rs.getString("planogerenciamentorequisito"));
				planoGerenciamentoRequisito.setVersao(rs.getString("versao"));
				planoGerenciamentoRequisito.setData(rs.getDate("data"));
				planoGerenciamentoRequisito.setAutor(rs.getString("autor"));
				planoGerenciamentoRequisito.setNotarevisao(rs.getString("notarevisao"));
				planoGerenciamentoRequisito.setAprovacao(rs.getString("aprovacao"));
				planoGerenciamentoRequisito.setObjetivo(rs.getString("objetivo"));	
				planoGerenciamentoRequisito.setGerenciamento(rs.getString("gerenciamento"));
				planoGerenciamentoRequisito.setProcesso(rs.getString("processo"));					
				planoGerenciamentoRequisito.setDocumento(rs.getString("documento"));
				planoGerenciamentoRequisito.setResponsabilidade(rs.getString("responsabilidade"));
				planoGerenciamentoRequisito.setConfiguracao(rs.getString("configuracao"));
				planoGerenciamentoRequisito.setPrioridade(rs.getString("prioridade"));
				planoGerenciamentoRequisito.setColeta(rs.getString("coleta"));
				planoGerenciamentoRequisito.setRatreabilidade(rs.getString("ratreabilidade"));
				planoGerenciamentoRequisito.setMetrica(rs.getString("metrica"));
				planoGerenciamentoRequisito.setCodigo(rs.getInt("codigo"));
				
				planoGerenciamentoRequisito.getProjetoinicio().setCodigo(rs.getLong("codigo"));
												
				resultado.add(planoGerenciamentoRequisito);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(PlanoGerenciamentoRequisito planoGerenciamentoRequisito) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE planogerenciamentorequisito SET planogerenciamentorequisito  = ?, versao  = ?, data  = ?, autor  = ?, notarevisao  = ?, aprovacao  = ?, objetivo  = ?, gerenciamento  = ?, processo  = ?, documento  = ?, responsabilidade  = ?, configuracao  = ?, prioridade  = ?, coleta  = ?, ratreabilidade  = ?, metrica = ?, projetoinicio = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(planoGerenciamentoRequisito, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(PlanoGerenciamentoRequisito planoGerenciamentoRequisito) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO planogerenciamentorequisito(planogerenciamentorequisito, versao, data, autor, notarevisao, aprovacao, objetivo, gerenciamento, processo, documento, responsabilidade, configuracao, prioridade, coleta, ratreabilidade, metrica, projetoinicio) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);		

			ps.setString(1, planoGerenciamentoRequisito.getPlanogerenciamentorequisito());
			ps.setString(2, planoGerenciamentoRequisito.getVersao());
			ps.setDate(3, new java.sql.Date(planoGerenciamentoRequisito.getData().getTime()));
			ps.setString(4, planoGerenciamentoRequisito.getAutor());
			ps.setString(5, planoGerenciamentoRequisito.getNotarevisao());
			ps.setString(6, planoGerenciamentoRequisito.getAprovacao());
			ps.setObject(7, planoGerenciamentoRequisito.getObjetivo());
			ps.setString(8, planoGerenciamentoRequisito.getGerenciamento());
			ps.setString(9, planoGerenciamentoRequisito.getProcesso());		
			ps.setString(10, planoGerenciamentoRequisito.getDocumento());
			ps.setString(11, planoGerenciamentoRequisito.getResponsabilidade());
			ps.setString(12, planoGerenciamentoRequisito.getConfiguracao());	
			ps.setString(13, planoGerenciamentoRequisito.getPrioridade());
			ps.setString(14, planoGerenciamentoRequisito.getColeta());
			ps.setString(15, planoGerenciamentoRequisito.getRatreabilidade());
			ps.setString(16, planoGerenciamentoRequisito.getMetrica());	
			ps.setObject(17, planoGerenciamentoRequisito.getProjetoinicio().getCodigo());
			
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
	public List<PlanoGerenciamentoRequisito> getPlanoGerenciamentoRequisitos() throws Exception  {
		
		   List<PlanoGerenciamentoRequisito> resultado = new ArrayList<PlanoGerenciamentoRequisito>();// Montar o resultado
		   
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs =null;
			
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM planogerenciamentorequisito";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				while (rs.next()) {
					PlanoGerenciamentoRequisito planoGerenciamentoRequisito = new PlanoGerenciamentoRequisito();
				
					planoGerenciamentoRequisito.setPlanogerenciamentorequisito(rs.getString("planogerenciamentorequisito"));
					planoGerenciamentoRequisito.setVersao(rs.getString("versao"));
					planoGerenciamentoRequisito.setData(rs.getDate("data"));
					planoGerenciamentoRequisito.setAutor(rs.getString("autor"));
					planoGerenciamentoRequisito.setNotarevisao(rs.getString("notarevisao"));
					planoGerenciamentoRequisito.setAprovacao(rs.getString("aprovacao"));
					planoGerenciamentoRequisito.setObjetivo(rs.getString("objetivo"));
					planoGerenciamentoRequisito.setGerenciamento(rs.getString("gerenciamento"));
					planoGerenciamentoRequisito.setProcesso(rs.getString("processo"));					
					planoGerenciamentoRequisito.setDocumento(rs.getString("documento"));
					planoGerenciamentoRequisito.setResponsabilidade(rs.getString("responsabilidade"));
					planoGerenciamentoRequisito.setConfiguracao(rs.getString("configuracao"));
					planoGerenciamentoRequisito.setPrioridade(rs.getString("prioridade"));
					planoGerenciamentoRequisito.setColeta(rs.getString("coleta"));
					planoGerenciamentoRequisito.setRatreabilidade(rs.getString("ratreabilidade"));
					planoGerenciamentoRequisito.setMetrica(rs.getString("metrica"));
					planoGerenciamentoRequisito.setCodigo(rs.getInt("codigo"));
					
					//planoGerenciamentoRequisito.getProjetoinicio().setProjeto(rs.getString("projeto"));//Não existe a coluna projeto na tabela planogerenciamentorequisito
					planoGerenciamentoRequisito.getProjetoinicio().setCodigo(rs.getLong("codigo"));
									
					resultado.add(planoGerenciamentoRequisito);// Add o projeto ao resultado.
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

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
import br.com.tkcsapcd.model.bean.AtributoAtividade;
import br.com.tkcsapcd.model.util.Conexao;

public class AtributoAtividadeDAO implements InterfaceAtributoAtividadeDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public AtributoAtividadeDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM atributoatividade WHERE codigo = ?;";

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
	
	private void setPreparedStatement(AtributoAtividade atributoAtividade, PreparedStatement ps) throws SQLException 
	{
		ps.setLong(1, atributoAtividade.getId());		
		ps.setString(2, atributoAtividade.getDescricao());
		ps.setString(3, atributoAtividade.getPredecessora());
		ps.setString(4, atributoAtividade.getSucessora());
		ps.setString(5, atributoAtividade.getRelacionamento());
		ps.setString(6, atributoAtividade.getAntecipacao());
		ps.setString(7, atributoAtividade.getRecurso());
		ps.setString(8, (atributoAtividade.getData()));
		ps.setString(9, atributoAtividade.getResponsavel());
		ps.setString(10, atributoAtividade.getAreageografica());
		ps.setLong(11, atributoAtividade.getOrganograma().getCodigo());
		ps.setLong(12, atributoAtividade.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public AtributoAtividade getAtributoAtividade(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM atributoatividade WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<AtributoAtividade> resultado = getListaAtributoAtividade(rs);
			
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

		//Metodo p confirma objetivo. Resulmir linhas de códigos, que pode ser usados em outros métodos. (ex: resultado = getListaCliente(rs); ou List<Cliente> resultado = getListaCliente(rs);)
		private List<AtributoAtividade> getListaAtributoAtividade(ResultSet rs) throws SQLException	{
			List<AtributoAtividade> resultado = new ArrayList<AtributoAtividade>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				AtributoAtividade atributoAtividade = new AtributoAtividade();
				
				atributoAtividade.setId(rs.getLong("id"));
				atributoAtividade.setDescricao(rs.getString("descricao"));
				atributoAtividade.setPredecessora(rs.getString("predecessora"));
				atributoAtividade.setSucessora(rs.getString("sucessora"));
				atributoAtividade.setRelacionamento(rs.getString("relacionamento"));
				atributoAtividade.setAntecipacao(rs.getString("antecipacao"));
				atributoAtividade.setRecurso(rs.getString("recurso"));
				atributoAtividade.setData(rs.getString("data"));				
				atributoAtividade.setResponsavel(rs.getString("responsavel"));	
				atributoAtividade.setAreageografica(rs.getString("areageografica"));
				atributoAtividade.setCodigo(rs.getLong("codigo"));
												
				resultado.add(atributoAtividade);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(AtributoAtividade atributoAtividade) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE atributoatividade SET id = ?, descricao = ?, predecessora = ?, sucessora = ?, relacionamento = ?, antecipacao = ?, recurso = ?, data = ?, responsavel = ?, areageografica = ?, organograma = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(atributoAtividade, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(AtributoAtividade atributoAtividade) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		try {
			String sqlInsert = "INSERT INTO atributoatividade(id, descricao, predecessora, sucessora, relacionamento, antecipacao, recurso, data, responsavel, areageografica, organograma) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setLong(1, atributoAtividade.getId());		
			ps.setString(2, atributoAtividade.getDescricao());
			ps.setString(3, atributoAtividade.getPredecessora());
			ps.setString(4, atributoAtividade.getSucessora());
			ps.setString(5, atributoAtividade.getRelacionamento());
			ps.setString(6, atributoAtividade.getAntecipacao());
			ps.setString(7, atributoAtividade.getRecurso());
			ps.setString(8, (atributoAtividade.getData()));
			ps.setString(9, atributoAtividade.getResponsavel());
			ps.setString(10, atributoAtividade.getAreageografica());
			ps.setLong(11, atributoAtividade.getOrganograma().getCodigo());			
			
			ps.executeUpdate();
			ps.close();

			// Pode acontecer o q/ for, que a conexao sera fechada.
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
	public List<AtributoAtividade> getAtributoAtividades() throws Exception {
		
		   List<AtributoAtividade> resultado = new ArrayList<AtributoAtividade>();// Montar o resultado
		   
			Connection con=null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
		try {
			
			con = Conexao.getConnection();
			
			/*
			 * SELECIONAR todas as colunas [da tabela X] da TABELA X UNINDO A TABELA Y 
			 * ONDE a coluna X [da tabela X] É IGUAL a coluna Y [da tabela Y] 
			 * ORDENADO PELO nome [da tabela X] ASCENDETEMENTE
			 * */
			
			String sqlSelect = "SELECT * FROM atributoatividade INNER JOIN organograma ON atributoatividade.organograma = organograma.codigo ORDER BY atributoatividade.responsavel;";

				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
								
				while (rs.next()) {
					AtributoAtividade atributoAtividade = new AtributoAtividade();
					
					atributoAtividade.setId(rs.getLong("id"));
					atributoAtividade.setDescricao(rs.getString("descricao"));
					atributoAtividade.setPredecessora(rs.getString("predecessora"));
					atributoAtividade.setSucessora(rs.getString("sucessora"));
					atributoAtividade.setRelacionamento(rs.getString("relacionamento"));
					atributoAtividade.setAntecipacao(rs.getString("antecipacao"));
					atributoAtividade.setRecurso(rs.getString("recurso"));
					atributoAtividade.setData(rs.getString("data"));				
					atributoAtividade.setResponsavel(rs.getString("responsavel"));	
					atributoAtividade.setAreageografica(rs.getString("areageografica"));
					atributoAtividade.setCodigo(rs.getLong("codigo"));
					
					atributoAtividade.getOrganograma().setCodigo(rs.getLong("codigo"));
					
					atributoAtividade.getOrganograma().setData(rs.getDate("data"));
					atributoAtividade.getOrganograma().setComentario(rs.getString("comentario"));
					atributoAtividade.getOrganograma().setMySavedModel(rs.getString("mySavedModel"));					
					atributoAtividade.getOrganograma().setDescricao(rs.getString("descricao"));					
					atributoAtividade.getOrganograma().getProjetoinicio().setCodigo(rs.getLong("codigo"));
									
					resultado.add(atributoAtividade);// Add o projeto ao resultado.
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

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
import br.com.tkcsapcd.model.bean.MatrizRastreabilidadeRequisito;
import br.com.tkcsapcd.model.util.Conexao;

public class MatrizRastreabilidadeRequisitoDAO implements InterfaceMatrizRastreabilidadeRequisitoDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public MatrizRastreabilidadeRequisitoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception   {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM matrizrastreabilidaderequisito WHERE codigo = ?;";

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
	private void setPreparedStatement(MatrizRastreabilidadeRequisito matrizRastreabilidadeRequisito, PreparedStatement ps) throws SQLException 
	{
		ps.setInt(1, matrizRastreabilidadeRequisito.getCodigomatriz());
		ps.setString(2, matrizRastreabilidadeRequisito.getPrioridade());
		ps.setString(3, matrizRastreabilidadeRequisito.getTipo());
		ps.setString(4, matrizRastreabilidadeRequisito.getNome());
		ps.setString(5, matrizRastreabilidadeRequisito.getDescricao());
		ps.setString(6, matrizRastreabilidadeRequisito.getJustificativa());
		ps.setString(7, matrizRastreabilidadeRequisito.getCriterio());
		ps.setString(8, matrizRastreabilidadeRequisito.getSolicitante());
		ps.setObject(9, matrizRastreabilidadeRequisito.getStatus());
		ps.setDate(10, new java.sql.Date( matrizRastreabilidadeRequisito.getData().getTime()));
		ps.setString(11, matrizRastreabilidadeRequisito.getEap());		
		ps.setInt(12, matrizRastreabilidadeRequisito.getId());
		ps.setString(13, matrizRastreabilidadeRequisito.getComentario());
		ps.setLong(14, matrizRastreabilidadeRequisito.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public MatrizRastreabilidadeRequisito getMatrizRastreabilidadeRequisito(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM matrizrastreabilidaderequisito WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<MatrizRastreabilidadeRequisito> resultado = getListaMatrizRastreabilidadeRequisito(rs);
			
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
		private List<MatrizRastreabilidadeRequisito> getListaMatrizRastreabilidadeRequisito(ResultSet rs) throws SQLException	{
			List<MatrizRastreabilidadeRequisito> resultado = new ArrayList<MatrizRastreabilidadeRequisito>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				MatrizRastreabilidadeRequisito matrizRastreabilidadeRequisito = new MatrizRastreabilidadeRequisito();
				
				matrizRastreabilidadeRequisito.setCodigomatriz(rs.getInt("codigomatriz"));
				matrizRastreabilidadeRequisito.setPrioridade(rs.getString("prioridade"));
				matrizRastreabilidadeRequisito.setTipo(rs.getString("tipo"));
				matrizRastreabilidadeRequisito.setNome(rs.getString("nome"));
				matrizRastreabilidadeRequisito.setDescricao(rs.getString("descricao"));
				matrizRastreabilidadeRequisito.setJustificativa(rs.getString("justificativa"));
				matrizRastreabilidadeRequisito.setCriterio(rs.getString("criterio"));
				matrizRastreabilidadeRequisito.setSolicitante(rs.getString("solicitante"));
				matrizRastreabilidadeRequisito.setStatus(rs.getString("status"));
				matrizRastreabilidadeRequisito.setData(rs.getDate("data"));					
				matrizRastreabilidadeRequisito.setEap(rs.getString("eap"));					
				matrizRastreabilidadeRequisito.setId(rs.getInt("id"));
				matrizRastreabilidadeRequisito.setComentario(rs.getString("comentario"));
				matrizRastreabilidadeRequisito.setCodigo(rs.getLong("codigo"));
												
				resultado.add(matrizRastreabilidadeRequisito);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(MatrizRastreabilidadeRequisito matrizRastreabilidadeRequisito) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			
			String sqlAtualizar = "UPDATE matrizrastreabilidaderequisito SET codigomatriz = ?, prioridade = ?, tipo = ?, nome = ?, descricao = ?, justificativa = ?, criterio = ?, solicitante = ?, status = ?, data = ?, eap = ?, id = ?, comentario = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(matrizRastreabilidadeRequisito, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(MatrizRastreabilidadeRequisito matrizRastreabilidadeRequisito) throws Exception  {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO matrizrastreabilidaderequisito(codigomatriz, prioridade, tipo, nome, descricao, justificativa, criterio, solicitante, status, data, eap, id, comentario) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
			
			ps.setInt(1, matrizRastreabilidadeRequisito.getCodigomatriz());
			ps.setString(2, matrizRastreabilidadeRequisito.getPrioridade());
			ps.setString(3, matrizRastreabilidadeRequisito.getTipo());
			ps.setString(4, matrizRastreabilidadeRequisito.getNome());
			ps.setString(5, matrizRastreabilidadeRequisito.getDescricao());
			ps.setString(6, matrizRastreabilidadeRequisito.getJustificativa());
			ps.setString(7, matrizRastreabilidadeRequisito.getCriterio());
			ps.setString(8, matrizRastreabilidadeRequisito.getSolicitante());
			ps.setObject(9, matrizRastreabilidadeRequisito.getStatus());
			ps.setDate(10, new java.sql.Date( matrizRastreabilidadeRequisito.getData().getTime()));
			ps.setString(11, matrizRastreabilidadeRequisito.getEap());		
			ps.setInt(12, matrizRastreabilidadeRequisito.getId());
			ps.setString(13, matrizRastreabilidadeRequisito.getComentario());
			
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
	public List<MatrizRastreabilidadeRequisito> getMatrizRastreabilidadeRequisitos() throws Exception  {
		
		   List<MatrizRastreabilidadeRequisito> resultado = new ArrayList<MatrizRastreabilidadeRequisito>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM matrizrastreabilidaderequisito";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					
					MatrizRastreabilidadeRequisito matrizRastreabilidadeRequisito = new MatrizRastreabilidadeRequisito();
				
					matrizRastreabilidadeRequisito.setCodigomatriz(rs.getInt("codigomatriz"));
					matrizRastreabilidadeRequisito.setPrioridade(rs.getString("prioridade"));
					matrizRastreabilidadeRequisito.setTipo(rs.getString("tipo"));
					matrizRastreabilidadeRequisito.setNome(rs.getString("nome"));
					matrizRastreabilidadeRequisito.setDescricao(rs.getString("descricao"));
					matrizRastreabilidadeRequisito.setJustificativa(rs.getString("justificativa"));
					matrizRastreabilidadeRequisito.setCriterio(rs.getString("criterio"));
					matrizRastreabilidadeRequisito.setSolicitante(rs.getString("solicitante"));
					matrizRastreabilidadeRequisito.setStatus(rs.getString("status"));
					matrizRastreabilidadeRequisito.setData(rs.getDate("data"));					
					matrizRastreabilidadeRequisito.setEap(rs.getString("eap"));					
					matrizRastreabilidadeRequisito.setId(rs.getInt("id"));
					matrizRastreabilidadeRequisito.setComentario(rs.getString("comentario"));
					matrizRastreabilidadeRequisito.setCodigo(rs.getLong("codigo"));
									
					resultado.add(matrizRastreabilidadeRequisito);// Add o projeto ao resultado.
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

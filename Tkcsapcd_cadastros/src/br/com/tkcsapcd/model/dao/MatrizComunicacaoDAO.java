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
import br.com.tkcsapcd.model.bean.MatrizComunicacao;
import br.com.tkcsapcd.model.util.Conexao;

public class MatrizComunicacaoDAO implements InterfaceMatrizComunicacaoDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public MatrizComunicacaoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM matrizcomunicacao WHERE codigo = ?;";

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
	
	private void setPreparedStatement(MatrizComunicacao matrizComunicacao, PreparedStatement ps) throws SQLException 
	{
		ps.setInt(1, matrizComunicacao.getCodigomatriz());
		ps.setString(2, matrizComunicacao.getPergunta1());
		ps.setString(3, matrizComunicacao.getPergunta2());
		ps.setString(4, matrizComunicacao.getPergunta3());
		ps.setString(5, matrizComunicacao.getPergunta4());
		ps.setString(6, matrizComunicacao.getPergunta5());
		ps.setString(7, matrizComunicacao.getPergunta6());
		ps.setString(8, matrizComunicacao.getPergunta7());
		ps.setObject(9, matrizComunicacao.getPergunta8());
		ps.setObject(10, matrizComunicacao.getComentario());
		ps.setInt(11, matrizComunicacao.getCodigo());//Atenção: necessário para isolar o metodo (extração).
		
	}

	@Override
	public MatrizComunicacao getMatrizComunicacao(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM matrizcomunicacao WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<MatrizComunicacao> resultado = getListaMatrizComunicacao(rs);
			
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
		private List<MatrizComunicacao> getListaMatrizComunicacao(ResultSet rs) throws SQLException	{
			List<MatrizComunicacao> resultado = new ArrayList<MatrizComunicacao>();
			
			// Laço p/ preencher
			while (rs.next()) {
				MatrizComunicacao matrizComunicacao = new MatrizComunicacao();
				
				matrizComunicacao.setCodigomatriz(rs.getInt("codigomatriz"));
				matrizComunicacao.setPergunta1(rs.getString("pergunta1"));
				matrizComunicacao.setPergunta2(rs.getString("pergunta2"));
				matrizComunicacao.setPergunta3(rs.getString("pergunta3"));
				matrizComunicacao.setPergunta4(rs.getString("pergunta4"));
				matrizComunicacao.setPergunta5(rs.getString("pergunta5"));
				matrizComunicacao.setPergunta6(rs.getString("pergunta6"));
				matrizComunicacao.setPergunta7(rs.getString("pergunta7"));
				matrizComunicacao.setPergunta8(rs.getString("pergunta8"));
				matrizComunicacao.setComentario(rs.getString("comentario"));
				matrizComunicacao.setCodigo(rs.getInt("codigo"));
												
				resultado.add(matrizComunicacao);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(MatrizComunicacao matrizComunicacao) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE matrizcomunicacao SET codigomatriz = ?, pergunta1 = ?, pergunta2 = ?, pergunta3 = ?, pergunta4 = ?, pergunta5 = ?, pergunta6 = ?, pergunta7 = ?, pergunta8 = ?, comentario = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(matrizComunicacao, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(MatrizComunicacao matrizComunicacao) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO matrizcomunicacao(codigomatriz, pergunta1, pergunta2, pergunta3, pergunta4, pergunta5, pergunta6, pergunta7, pergunta8, comentario) VALUES (?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setInt(1, matrizComunicacao.getCodigomatriz());
			ps.setString(2, matrizComunicacao.getPergunta1());
			ps.setString(3, matrizComunicacao.getPergunta2());
			ps.setString(4, matrizComunicacao.getPergunta3());
			ps.setString(5, matrizComunicacao.getPergunta4());
			ps.setString(6, matrizComunicacao.getPergunta5());
			ps.setString(7, matrizComunicacao.getPergunta6());
			ps.setString(8, matrizComunicacao.getPergunta7());
			ps.setObject(9, matrizComunicacao.getPergunta8());
			ps.setObject(10, matrizComunicacao.getComentario());
			
			
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
	public List<MatrizComunicacao> getMatrizComunicacaos() throws Exception {
		
		   List<MatrizComunicacao> resultado = new ArrayList<MatrizComunicacao>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM matrizcomunicacao";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					MatrizComunicacao matrizComunicacao = new MatrizComunicacao();
					
					matrizComunicacao.setCodigomatriz(rs.getInt("codigomatriz"));
					matrizComunicacao.setPergunta1(rs.getString("pergunta1"));
					matrizComunicacao.setPergunta2(rs.getString("pergunta2"));
					matrizComunicacao.setPergunta3(rs.getString("pergunta3"));
					matrizComunicacao.setPergunta4(rs.getString("pergunta4"));
					matrizComunicacao.setPergunta5(rs.getString("pergunta5"));
					matrizComunicacao.setPergunta6(rs.getString("pergunta6"));
					matrizComunicacao.setPergunta7(rs.getString("pergunta7"));
					matrizComunicacao.setPergunta8(rs.getString("pergunta8"));
					matrizComunicacao.setComentario(rs.getString("comentario"));
					matrizComunicacao.setCodigo(rs.getInt("codigo"));
									
					resultado.add(matrizComunicacao);// Add o projeto ao resultado.
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

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
import br.com.tkcsapcd.model.bean.PlanoGerenciamentoPessoal;
import br.com.tkcsapcd.model.util.Conexao;

public class PlanoGerenciamentoPessoalDAO implements InterfacePlanoGerenciamentoPessoalDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public PlanoGerenciamentoPessoalDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM planogerenciamentopessoal WHERE codigo = ?;";

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
	
	private void setPreparedStatement(PlanoGerenciamentoPessoal planoGerenciamentoPessoal, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, planoGerenciamentoPessoal.getPlanogerenciamentopessoal());
		ps.setString(2, planoGerenciamentoPessoal.getProjeto());
		ps.setInt(3, planoGerenciamentoPessoal.getCodigoprojeto());
		ps.setString(4, planoGerenciamentoPessoal.getVersao());
		ps.setString(5, planoGerenciamentoPessoal.getData());
		ps.setString(6, planoGerenciamentoPessoal.getAutor());
		ps.setString(7, planoGerenciamentoPessoal.getNotarevisao());
		ps.setString(8, planoGerenciamentoPessoal.getAprovacao());
		ps.setObject(9, planoGerenciamentoPessoal.getPergunta1());
		ps.setString(10, planoGerenciamentoPessoal.getPergunta2());
		ps.setString(11, planoGerenciamentoPessoal.getPergunta3());		
		ps.setString(12, planoGerenciamentoPessoal.getPergunta4());
		ps.setString(13, planoGerenciamentoPessoal.getPergunta5());
		ps.setString(14, planoGerenciamentoPessoal.getPergunta6());	
		ps.setString(15, planoGerenciamentoPessoal.getPergunta7());
		ps.setInt(16, planoGerenciamentoPessoal.getCodigo());//Atenção: necessário para isolar o metodo (extração). 		
	}

	@Override
	public PlanoGerenciamentoPessoal getPlanoGerenciamentoPessoal(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM planogerenciamentopessoal WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<PlanoGerenciamentoPessoal> resultado = getListaPlanoGerenciamentoPessoal(rs);
			
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
		private List<PlanoGerenciamentoPessoal> getListaPlanoGerenciamentoPessoal(ResultSet rs) throws SQLException	{
			List<PlanoGerenciamentoPessoal> resultado = new ArrayList<PlanoGerenciamentoPessoal>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				PlanoGerenciamentoPessoal planoGerenciamentoPessoal = new PlanoGerenciamentoPessoal();
				
				planoGerenciamentoPessoal.setPlanogerenciamentopessoal(rs.getString("planogerenciamentopessoal"));
				planoGerenciamentoPessoal.setProjeto(rs.getString("projeto"));
				planoGerenciamentoPessoal.setCodigoprojeto(rs.getInt("codigoprojeto"));
				planoGerenciamentoPessoal.setVersao(rs.getString("versao"));
				planoGerenciamentoPessoal.setData(rs.getString("data"));
				planoGerenciamentoPessoal.setAutor(rs.getString("autor"));
				planoGerenciamentoPessoal.setNotarevisao(rs.getString("notarevisao"));
				planoGerenciamentoPessoal.setAprovacao(rs.getString("aprovacao"));
				planoGerenciamentoPessoal.setPergunta1(rs.getString("pergunta1"));
				planoGerenciamentoPessoal.setPergunta2(rs.getString("pergunta2"));
				planoGerenciamentoPessoal.setPergunta3(rs.getString("pergunta3"));
				planoGerenciamentoPessoal.setPergunta4(rs.getString("pergunta4"));
				planoGerenciamentoPessoal.setPergunta5(rs.getString("pergunta5"));
				planoGerenciamentoPessoal.setPergunta6(rs.getString("pergunta6"));
				planoGerenciamentoPessoal.setPergunta7(rs.getString("pergunta7"));
				planoGerenciamentoPessoal.setCodigo(rs.getInt("codigo"));
												
				resultado.add(planoGerenciamentoPessoal);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(PlanoGerenciamentoPessoal planoGerenciamentoPessoal) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE planogerenciamentopessoal SET planogerenciamentopessoal = ?, projeto = ?, codigoprojeto = ?, versao = ?, data = ?, autor = ?, notarevisao = ?, aprovacao = ?, pergunta1 = ?, pergunta2 = ?, pergunta3 = ?, pergunta4 = ?, pergunta5 = ?, pergunta6 = ?, pergunta7 = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(planoGerenciamentoPessoal, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(PlanoGerenciamentoPessoal planoGerenciamentoPessoal) throws Exception  {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO planogerenciamentopessoal(planogerenciamentopessoal, projeto, codigoprojeto, versao, data, autor, notarevisao, aprovacao, pergunta1, pergunta2, pergunta3, pergunta4, pergunta5, pergunta6, pergunta7) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, planoGerenciamentoPessoal.getPlanogerenciamentopessoal());
			ps.setString(2, planoGerenciamentoPessoal.getProjeto());
			ps.setInt(3, planoGerenciamentoPessoal.getCodigoprojeto());
			ps.setString(4, planoGerenciamentoPessoal.getVersao());
			ps.setString(5, planoGerenciamentoPessoal.getData());
			ps.setString(6, planoGerenciamentoPessoal.getAutor());
			ps.setString(7, planoGerenciamentoPessoal.getNotarevisao());
			ps.setString(8, planoGerenciamentoPessoal.getAprovacao());
			ps.setObject(9, planoGerenciamentoPessoal.getPergunta1());
			ps.setString(10, planoGerenciamentoPessoal.getPergunta2());
			ps.setString(11, planoGerenciamentoPessoal.getPergunta3());		
			ps.setString(12, planoGerenciamentoPessoal.getPergunta4());
			ps.setString(13, planoGerenciamentoPessoal.getPergunta5());
			ps.setString(14, planoGerenciamentoPessoal.getPergunta6());	
			ps.setString(15, planoGerenciamentoPessoal.getPergunta7());			
			
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
	public List<PlanoGerenciamentoPessoal> getPlanoGerenciamentoPessoals() throws Exception {
		
		   List<PlanoGerenciamentoPessoal> resultado = new ArrayList<PlanoGerenciamentoPessoal>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM planogerenciamentopessoal";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					PlanoGerenciamentoPessoal planoGerenciamentoPessoal = new PlanoGerenciamentoPessoal();
					
					planoGerenciamentoPessoal.setPlanogerenciamentopessoal(rs.getString("planogerenciamentopessoal"));
					planoGerenciamentoPessoal.setProjeto(rs.getString("projeto"));
					planoGerenciamentoPessoal.setCodigoprojeto(rs.getInt("codigoprojeto"));
					planoGerenciamentoPessoal.setVersao(rs.getString("versao"));
					planoGerenciamentoPessoal.setData(rs.getString("data"));
					planoGerenciamentoPessoal.setAutor(rs.getString("autor"));
					planoGerenciamentoPessoal.setNotarevisao(rs.getString("notarevisao"));
					planoGerenciamentoPessoal.setAprovacao(rs.getString("aprovacao"));
					planoGerenciamentoPessoal.setPergunta1(rs.getString("pergunta1"));
					planoGerenciamentoPessoal.setPergunta2(rs.getString("pergunta2"));
					planoGerenciamentoPessoal.setPergunta3(rs.getString("pergunta3"));
					planoGerenciamentoPessoal.setPergunta4(rs.getString("pergunta4"));
					planoGerenciamentoPessoal.setPergunta5(rs.getString("pergunta5"));
					planoGerenciamentoPessoal.setPergunta6(rs.getString("pergunta6"));
					planoGerenciamentoPessoal.setPergunta7(rs.getString("pergunta7"));
					planoGerenciamentoPessoal.setCodigo(rs.getInt("codigo"));
									
					resultado.add(planoGerenciamentoPessoal);// Add o projeto ao resultado.
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

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
import br.com.tkcsapcd.model.bean.DeclaracaoTrabalho;
import br.com.tkcsapcd.model.util.Conexao;

public class DeclaracaoTrabalhoDAO implements InterfaceDeclaracaoTrabalhoDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public DeclaracaoTrabalhoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM declaracaotrabalho WHERE codigo = ?;";

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
	
	private void setPreparedStatement(DeclaracaoTrabalho declaracaoTrabalho, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, declaracaoTrabalho.getDeclaracaotrabalho());
		ps.setString(2, declaracaoTrabalho.getProjeto());
		ps.setInt(3, declaracaoTrabalho.getCodigoprojeto());
		ps.setString(4, declaracaoTrabalho.getVersao());
		ps.setString(5, declaracaoTrabalho.getData());
		ps.setString(6, declaracaoTrabalho.getAutor());
		ps.setString(7, declaracaoTrabalho.getNotarevisao());
		ps.setString(8, declaracaoTrabalho.getAprovacao());
		ps.setObject(9, declaracaoTrabalho.getObjetivo());
		ps.setString(10, declaracaoTrabalho.getEscopo());
		ps.setString(11, declaracaoTrabalho.getCronograma());		
		ps.setString(12, declaracaoTrabalho.getPadrao());
		ps.setString(13, declaracaoTrabalho.getRequisito());
		ps.setString(14, declaracaoTrabalho.getLocal());	
		ps.setString(15, declaracaoTrabalho.getPeriodo());
		ps.setString(16, declaracaoTrabalho.getRequisitoespecial());
		ps.setInt(17, declaracaoTrabalho.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public DeclaracaoTrabalho getDeclaracaoTrabalho(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM declaracaotrabalho WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<DeclaracaoTrabalho> resultado = getListaDeclaracaoTrabalho(rs);
			
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
		private List<DeclaracaoTrabalho> getListaDeclaracaoTrabalho(ResultSet rs) throws SQLException	{
			List<DeclaracaoTrabalho> resultado = new ArrayList<DeclaracaoTrabalho>();
			
			// Laço p/ preencher
			while (rs.next()) {
				DeclaracaoTrabalho declaracaoTrabalho = new DeclaracaoTrabalho();
				
				declaracaoTrabalho.setDeclaracaotrabalho(rs.getString("declaracaotrabalho"));
				declaracaoTrabalho.setProjeto(rs.getString("projeto"));
				declaracaoTrabalho.setCodigoprojeto(rs.getInt("codigoprojeto"));
				declaracaoTrabalho.setVersao(rs.getString("versao"));
				declaracaoTrabalho.setData(rs.getString("data"));
				declaracaoTrabalho.setAutor(rs.getString("autor"));
				declaracaoTrabalho.setNotarevisao(rs.getString("notarevisao"));
				declaracaoTrabalho.setAprovacao(rs.getString("aprovacao"));
				declaracaoTrabalho.setObjetivo(rs.getString("objetivo"));				
				declaracaoTrabalho.setEscopo(rs.getString("escopo"));					
				declaracaoTrabalho.setCronograma(rs.getString("cronograma"));
				declaracaoTrabalho.setPadrao(rs.getString("padrao"));
				declaracaoTrabalho.setRequisito(rs.getString("requisitoespecial"));
				declaracaoTrabalho.setLocal(rs.getString("local"));
				declaracaoTrabalho.setPeriodo(rs.getString("periodo"));
				declaracaoTrabalho.setRequisitoespecial(rs.getString("requisitoespecial"));
				declaracaoTrabalho.setCodigo(rs.getInt("codigo"));
												
				resultado.add(declaracaoTrabalho);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(DeclaracaoTrabalho declaracaoTrabalho) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;		
		try{
			String sqlAtualizar = "UPDATE declaracaotrabalho SET declaracaotrabalho = ?, projeto = ?, codigoprojeto = ?, versao = ?, data = ?, autor = ?, notarevisao = ?, aprovacao = ?, objetivo = ?, escopo = ?, cronograma = ?, padrao = ?, requisito = ?, local = ?, periodo = ?, requisitoespecial = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(declaracaoTrabalho, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(DeclaracaoTrabalho declaracaoTrabalho) throws Exception  {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO declaracaotrabalho(declaracaotrabalho, projeto, codigoprojeto, versao, data, autor, notarevisao, aprovacao, objetivo, escopo, cronograma, padrao, requisito, local, periodo, requisitoespecial) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, declaracaoTrabalho.getDeclaracaotrabalho());
			ps.setString(2, declaracaoTrabalho.getProjeto());
			ps.setInt(3, declaracaoTrabalho.getCodigoprojeto());
			ps.setString(4, declaracaoTrabalho.getVersao());
			ps.setString(5, declaracaoTrabalho.getData());
			ps.setString(6, declaracaoTrabalho.getAutor());
			ps.setString(7, declaracaoTrabalho.getNotarevisao());
			ps.setString(8, declaracaoTrabalho.getAprovacao());
			ps.setObject(9, declaracaoTrabalho.getObjetivo());
			ps.setString(10, declaracaoTrabalho.getEscopo());
			ps.setString(11, declaracaoTrabalho.getCronograma());		
			ps.setString(12, declaracaoTrabalho.getPadrao());
			ps.setString(13, declaracaoTrabalho.getRequisito());
			ps.setString(14, declaracaoTrabalho.getLocal());	
			ps.setString(15, declaracaoTrabalho.getPeriodo());
			ps.setString(16, declaracaoTrabalho.getRequisitoespecial());			
			
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
	public List<DeclaracaoTrabalho> getDeclaracaoTrabalhos() throws Exception {
		
		   List<DeclaracaoTrabalho> resultado = new ArrayList<DeclaracaoTrabalho>();// Montar o resultado
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM declaracaotrabalho";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					DeclaracaoTrabalho declaracaoTrabalho = new DeclaracaoTrabalho();
					
					declaracaoTrabalho.setDeclaracaotrabalho(rs.getString("declaracaotrabalho"));
					declaracaoTrabalho.setProjeto(rs.getString("projeto"));
					declaracaoTrabalho.setCodigoprojeto(rs.getInt("codigoprojeto"));
					declaracaoTrabalho.setVersao(rs.getString("versao"));
					declaracaoTrabalho.setData(rs.getString("data"));
					declaracaoTrabalho.setAutor(rs.getString("autor"));
					declaracaoTrabalho.setNotarevisao(rs.getString("notarevisao"));
					declaracaoTrabalho.setAprovacao(rs.getString("aprovacao"));
					declaracaoTrabalho.setObjetivo(rs.getString("objetivo"));				
					declaracaoTrabalho.setEscopo(rs.getString("escopo"));					
					declaracaoTrabalho.setCronograma(rs.getString("cronograma"));
					declaracaoTrabalho.setPadrao(rs.getString("padrao"));
					declaracaoTrabalho.setRequisito(rs.getString("requisitoespecial"));
					declaracaoTrabalho.setLocal(rs.getString("local"));
					declaracaoTrabalho.setPeriodo(rs.getString("periodo"));
					declaracaoTrabalho.setRequisitoespecial(rs.getString("requisitoespecial"));
					declaracaoTrabalho.setCodigo(rs.getInt("codigo"));
									
					resultado.add(declaracaoTrabalho);// Add o projeto ao resultado.
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

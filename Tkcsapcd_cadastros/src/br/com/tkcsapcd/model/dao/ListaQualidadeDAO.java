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
import br.com.tkcsapcd.model.bean.ListaQualidade;
import br.com.tkcsapcd.model.util.Conexao;

public class ListaQualidadeDAO implements InterfaceListaQualidadeDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public ListaQualidadeDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM listaqualidade WHERE codigo = ?;";

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
	private void setPreparedStatement(ListaQualidade listaQualidade, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, listaQualidade.getListaqualiade());
		ps.setString(2, listaQualidade.getProjeto());
		ps.setInt(3, listaQualidade.getCodigoprojeto());
		ps.setString(4, listaQualidade.getVersao());
		ps.setString(5, listaQualidade.getData());
		ps.setString(6, listaQualidade.getAutor());
		ps.setString(7, listaQualidade.getNotarevisao());
		ps.setString(8, listaQualidade.getAprovacao());
		ps.setObject(9, listaQualidade.getProduto());
		ps.setString(10, listaQualidade.getRequsito());
		ps.setString(11, listaQualidade.getCriterio());		
		ps.setString(12, listaQualidade.getMetodo());
		ps.setInt(13, listaQualidade.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public ListaQualidade getListaQualidade(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM listaqualidade WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<ListaQualidade> resultado = getListaListaQualidade(rs);
			
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
		private List<ListaQualidade> getListaListaQualidade(ResultSet rs) throws SQLException	{
			List<ListaQualidade> resultado = new ArrayList<ListaQualidade>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				ListaQualidade listaQualidade = new ListaQualidade();
				
				listaQualidade.setListaqualiade(rs.getString("listaqualiade"));
				listaQualidade.setProjeto(rs.getString("projeto"));
				listaQualidade.setCodigoprojeto(rs.getInt("codigoprojeto"));
				listaQualidade.setVersao(rs.getString("versao"));
				listaQualidade.setData(rs.getString("data"));
				listaQualidade.setAutor(rs.getString("autor"));
				listaQualidade.setNotarevisao(rs.getString("notarevisao"));
				listaQualidade.setAprovacao(rs.getString("aprovacao"));
				listaQualidade.setProduto(rs.getString("produto"));				
				listaQualidade.setRequsito(rs.getString("requsito"));					
				listaQualidade.setCriterio(rs.getString("criterio"));
				listaQualidade.setMetodo(rs.getString("metodo"));
				listaQualidade.setCodigo(rs.getInt("codigo"));
												
				resultado.add(listaQualidade);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(ListaQualidade listaQualidade) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			
			String sqlAtualizar = "UPDATE listaqualidade SET listaqualiade = ?, projeto = ?, codigoprojeto = ?, versao = ?, data = ?, autor = ?, notarevisao = ?, aprovacao = ?, produto = ?, requsito = ?, criterio = ?, metodo = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(listaQualidade, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(ListaQualidade listaQualidade) throws Exception  {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO listaqualidade(listaqualiade, projeto, codigoprojeto, versao, data, autor, notarevisao, aprovacao, produto, requsito, criterio, metodo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			

			ps.setString(1, listaQualidade.getListaqualiade());
			ps.setString(2, listaQualidade.getProjeto());
			ps.setInt(3, listaQualidade.getCodigoprojeto());
			ps.setString(4, listaQualidade.getVersao());
			ps.setString(5, listaQualidade.getData());
			ps.setString(6, listaQualidade.getAutor());
			ps.setString(7, listaQualidade.getNotarevisao());
			ps.setString(8, listaQualidade.getAprovacao());
			ps.setObject(9, listaQualidade.getProduto());
			ps.setString(10, listaQualidade.getRequsito());
			ps.setString(11, listaQualidade.getCriterio());		
			ps.setString(12, listaQualidade.getMetodo());
			
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
	public List<ListaQualidade> getListaQualidades() throws Exception {
		
		   List<ListaQualidade> resultado = new ArrayList<ListaQualidade>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();			
			String sqlSelect = "SELECT * FROM listaqualidade";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					ListaQualidade listaQualidade = new ListaQualidade();
				
					listaQualidade.setListaqualiade(rs.getString("listaqualiade"));
					listaQualidade.setProjeto(rs.getString("projeto"));
					listaQualidade.setCodigoprojeto(rs.getInt("codigoprojeto"));
					listaQualidade.setVersao(rs.getString("versao"));
					listaQualidade.setData(rs.getString("data"));
					listaQualidade.setAutor(rs.getString("autor"));
					listaQualidade.setNotarevisao(rs.getString("notarevisao"));
					listaQualidade.setAprovacao(rs.getString("aprovacao"));
					listaQualidade.setProduto(rs.getString("produto"));				
					listaQualidade.setRequsito(rs.getString("requsito"));					
					listaQualidade.setCriterio(rs.getString("criterio"));
					listaQualidade.setMetodo(rs.getString("metodo"));
					listaQualidade.setCodigo(rs.getInt("codigo"));
									
					resultado.add(listaQualidade);// Add o projeto ao resultado.
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

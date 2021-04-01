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
import br.com.tkcsapcd.model.bean.SolicitacaoProjeto;
import br.com.tkcsapcd.model.util.Conexao;

public class SolicitacaoProjetoDAO implements InterfaceSolicitacaoProjetoDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public SolicitacaoProjetoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM solicitacaoprojeto WHERE codigo = ?;";

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
	private void setPreparedStatement(SolicitacaoProjeto solicitacaoProjeto, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, solicitacaoProjeto.getSolicitacaoprojeto());
		ps.setString(2, solicitacaoProjeto.getProjeto());
		ps.setInt(3, solicitacaoProjeto.getCodigoprojeto());
		ps.setString(4, solicitacaoProjeto.getVersao());
		ps.setString(5, solicitacaoProjeto.getData());
		ps.setString(6, solicitacaoProjeto.getAutor());
		ps.setString(7, solicitacaoProjeto.getNotarevisao());
		ps.setString(8, solicitacaoProjeto.getAprovacao());
		ps.setObject(9, solicitacaoProjeto.getObjetivo());
		ps.setString(10, solicitacaoProjeto.getAtual());
		ps.setString(11, solicitacaoProjeto.getDescricao());
		ps.setInt(12, solicitacaoProjeto.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public SolicitacaoProjeto getSolicitacaoProjeto(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM solicitacaoprojeto WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<SolicitacaoProjeto> resultado = getListaSolicitacaoProjeto(rs);
			
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
		private List<SolicitacaoProjeto> getListaSolicitacaoProjeto(ResultSet rs) throws SQLException	{
			List<SolicitacaoProjeto> resultado = new ArrayList<SolicitacaoProjeto>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				SolicitacaoProjeto solicitacaoProjeto = new SolicitacaoProjeto();
				
				solicitacaoProjeto.setSolicitacaoprojeto(rs.getString("solicitacaoprojeto"));
				solicitacaoProjeto.setProjeto(rs.getString("projeto"));
				solicitacaoProjeto.setCodigoprojeto(rs.getInt("codigoprojeto"));
				solicitacaoProjeto.setVersao(rs.getString("versao"));
				solicitacaoProjeto.setData(rs.getString("data"));
				solicitacaoProjeto.setAutor(rs.getString("autor"));
				solicitacaoProjeto.setNotarevisao(rs.getString("notarevisao"));
				solicitacaoProjeto.setAprovacao(rs.getString("aprovacao"));
				solicitacaoProjeto.setObjetivo(rs.getString("objetivo"));				
				solicitacaoProjeto.setAtual(rs.getString("atual"));					
				solicitacaoProjeto.setDescricao(rs.getString("descricao"));
				solicitacaoProjeto.setCodigo(rs.getInt("codigo"));
												
				resultado.add(solicitacaoProjeto);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(SolicitacaoProjeto solicitacaoProjeto) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE solicitacaoprojeto SET solicitacaoprojeto = ?, projeto = ?, codigoprojeto = ?, versao = ?, data = ?, autor = ?, notarevisao = ?, aprovacao = ?, objetivo = ?, atual = ?, descricao = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(solicitacaoProjeto, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(SolicitacaoProjeto solicitacaoProjeto) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO solicitacaoprojeto(solicitacaoprojeto, projeto, codigoprojeto, versao, data, autor, notarevisao, aprovacao, objetivo, atual, descricao) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, solicitacaoProjeto.getSolicitacaoprojeto());
			ps.setString(2, solicitacaoProjeto.getProjeto());
			ps.setInt(3, solicitacaoProjeto.getCodigoprojeto());
			ps.setString(4, solicitacaoProjeto.getVersao());
			ps.setString(5, solicitacaoProjeto.getData());
			ps.setString(6, solicitacaoProjeto.getAutor());
			ps.setString(7, solicitacaoProjeto.getNotarevisao());
			ps.setString(8, solicitacaoProjeto.getAprovacao());
			ps.setObject(9, solicitacaoProjeto.getObjetivo());
			ps.setString(10, solicitacaoProjeto.getAtual());
			ps.setString(11, solicitacaoProjeto.getDescricao());
			
			
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
	public List<SolicitacaoProjeto> getSolicitacaoProjetos() throws Exception {
		
		   List<SolicitacaoProjeto> resultado = new ArrayList<SolicitacaoProjeto>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM solicitacaoprojeto";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					SolicitacaoProjeto solicitacaoProjeto = new SolicitacaoProjeto();
				
					solicitacaoProjeto.setSolicitacaoprojeto(rs.getString("solicitacaoprojeto"));
					solicitacaoProjeto.setProjeto(rs.getString("projeto"));
					solicitacaoProjeto.setCodigoprojeto(rs.getInt("codigoprojeto"));
					solicitacaoProjeto.setVersao(rs.getString("versao"));
					solicitacaoProjeto.setData(rs.getString("data"));
					solicitacaoProjeto.setAutor(rs.getString("autor"));
					solicitacaoProjeto.setNotarevisao(rs.getString("notarevisao"));
					solicitacaoProjeto.setAprovacao(rs.getString("aprovacao"));
					solicitacaoProjeto.setObjetivo(rs.getString("objetivo"));				
					solicitacaoProjeto.setAtual(rs.getString("atual"));					
					solicitacaoProjeto.setDescricao(rs.getString("descricao"));
					solicitacaoProjeto.setCodigo(rs.getInt("codigo"));
									
					resultado.add(solicitacaoProjeto);// Add o projeto ao resultado.
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

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
import br.com.tkcsapcd.model.bean.SolicitacaoProjetovBSC;
import br.com.tkcsapcd.model.util.Conexao;

public class SolicitacaoProjetovBSCDAO implements InterfaceSolicitacaoProjetovBSCDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public SolicitacaoProjetovBSCDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM solicitacaoprojetovbsc WHERE codigo = ?;";

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
	private void setPreparedStatement(SolicitacaoProjetovBSC solicitacaoProjetovBSC, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, solicitacaoProjetovBSC.getSolicitacaoprojetovbsc());
		ps.setString(2, solicitacaoProjetovBSC.getProjeto());
		ps.setInt(3, solicitacaoProjetovBSC.getCodigoprojeto());
		ps.setString(4, solicitacaoProjetovBSC.getVersao());
		ps.setString(5, solicitacaoProjetovBSC.getData());
		ps.setString(6, solicitacaoProjetovBSC.getAutor());
		ps.setString(7, solicitacaoProjetovBSC.getNotarevisao());
		ps.setString(8, solicitacaoProjetovBSC.getAprovacao());
		ps.setObject(9, solicitacaoProjetovBSC.getObjetivo());
		ps.setString(10, solicitacaoProjetovBSC.getDescricao());
		ps.setString(11, solicitacaoProjetovBSC.getCriterio());		
		ps.setString(12, solicitacaoProjetovBSC.getDescricaobeneficio());
		ps.setInt(13, solicitacaoProjetovBSC.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public SolicitacaoProjetovBSC getSolicitacaoProjetovBSC(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM solicitacaoprojetovbsc WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<SolicitacaoProjetovBSC> resultado = getListaSolicitacaoProjetovBSC(rs);
			
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
		private List<SolicitacaoProjetovBSC> getListaSolicitacaoProjetovBSC(ResultSet rs) throws SQLException	{
				List<SolicitacaoProjetovBSC> resultado = new ArrayList<SolicitacaoProjetovBSC>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				SolicitacaoProjetovBSC solicitacaoProjetovBSC = new SolicitacaoProjetovBSC();
				
				solicitacaoProjetovBSC.setSolicitacaoprojetovbsc(rs.getString("solicitacaoprojetovbsc"));
				solicitacaoProjetovBSC.setProjeto(rs.getString("projeto"));
				solicitacaoProjetovBSC.setCodigoprojeto(rs.getInt("codigoprojeto"));
				solicitacaoProjetovBSC.setVersao(rs.getString("versao"));
				solicitacaoProjetovBSC.setData(rs.getString("data"));
				solicitacaoProjetovBSC.setAutor(rs.getString("autor"));
				solicitacaoProjetovBSC.setNotarevisao(rs.getString("notarevisao"));
				solicitacaoProjetovBSC.setAprovacao(rs.getString("aprovacao"));
				solicitacaoProjetovBSC.setObjetivo(rs.getString("objetivo"));				
				solicitacaoProjetovBSC.setDescricao(rs.getString("descricao"));					
				solicitacaoProjetovBSC.setCriterio(rs.getString("criterio"));
				solicitacaoProjetovBSC.setDescricaobeneficio(rs.getString("descricaobeneficio"));
				solicitacaoProjetovBSC.setCodigo(rs.getInt("codigo"));
												
				resultado.add(solicitacaoProjetovBSC);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(SolicitacaoProjetovBSC solicitacaoProjetovBSC) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE solicitacaoprojetovbsc SET solicitacaoprojetovbsc = ?, projeto = ?, codigoprojeto = ?, versao = ?, data = ?, autor = ?, notarevisao = ?, aprovacao = ?, objetivo = ?, descricao = ?, criterio = ?, descricaobeneficio = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(solicitacaoProjetovBSC, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(SolicitacaoProjetovBSC solicitacaoProjetovBSC) throws Exception  {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO solicitacaoprojetovbsc(	solicitacaoprojetovbsc, projeto, codigoprojeto, versao, data, autor, notarevisao, aprovacao, objetivo, descricao, criterio, descricaobeneficio) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);		
			
			ps.setString(1, solicitacaoProjetovBSC.getSolicitacaoprojetovbsc());
			ps.setString(2, solicitacaoProjetovBSC.getProjeto());
			ps.setInt(3, solicitacaoProjetovBSC.getCodigoprojeto());
			ps.setString(4, solicitacaoProjetovBSC.getVersao());
			ps.setString(5, solicitacaoProjetovBSC.getData());
			ps.setString(6, solicitacaoProjetovBSC.getAutor());
			ps.setString(7, solicitacaoProjetovBSC.getNotarevisao());
			ps.setString(8, solicitacaoProjetovBSC.getAprovacao());
			ps.setObject(9, solicitacaoProjetovBSC.getObjetivo());
			ps.setString(10, solicitacaoProjetovBSC.getDescricao());
			ps.setString(11, solicitacaoProjetovBSC.getCriterio());		
			ps.setString(12, solicitacaoProjetovBSC.getDescricaobeneficio());
			
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
	public List<SolicitacaoProjetovBSC> getSolicitacaoProjetovBSCs() throws Exception {
		
		   List<SolicitacaoProjetovBSC> resultado = new ArrayList<SolicitacaoProjetovBSC>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM solicitacaoprojetovbsc";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					
					SolicitacaoProjetovBSC solicitacaoProjetovBSC = new SolicitacaoProjetovBSC();
				
					solicitacaoProjetovBSC.setSolicitacaoprojetovbsc(rs.getString("solicitacaoprojetovbsc"));
					solicitacaoProjetovBSC.setProjeto(rs.getString("projeto"));
					solicitacaoProjetovBSC.setCodigoprojeto(rs.getInt("codigoprojeto"));
					solicitacaoProjetovBSC.setVersao(rs.getString("versao"));
					solicitacaoProjetovBSC.setData(rs.getString("data"));
					solicitacaoProjetovBSC.setAutor(rs.getString("autor"));
					solicitacaoProjetovBSC.setNotarevisao(rs.getString("notarevisao"));
					solicitacaoProjetovBSC.setAprovacao(rs.getString("aprovacao"));
					solicitacaoProjetovBSC.setObjetivo(rs.getString("objetivo"));				
					solicitacaoProjetovBSC.setDescricao(rs.getString("descricao"));					
					solicitacaoProjetovBSC.setCriterio(rs.getString("criterio"));
					solicitacaoProjetovBSC.setDescricaobeneficio(rs.getString("descricaobeneficio"));
					solicitacaoProjetovBSC.setCodigo(rs.getInt("codigo"));
									
					resultado.add(solicitacaoProjetovBSC);// Add o projeto ao resultado.
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

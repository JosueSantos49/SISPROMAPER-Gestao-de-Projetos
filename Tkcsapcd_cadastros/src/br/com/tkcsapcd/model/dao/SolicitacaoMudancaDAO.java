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
import br.com.tkcsapcd.model.bean.SolicitacaoMudanca;
import br.com.tkcsapcd.model.util.Conexao;

public class SolicitacaoMudancaDAO implements InterfaceSolicitacaoMudancaDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public SolicitacaoMudancaDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM solicitacaomudanca WHERE codigo = ?;";

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
	private void setPreparedStatement(SolicitacaoMudanca solicitacaoMudanca, PreparedStatement ps) throws SQLException 
	{		
		ps.setString(1, solicitacaoMudanca.getSolicitacaomudanca());		
		ps.setObject(2, solicitacaoMudanca.getVersao());
		ps.setDate(3, new java.sql.Date(solicitacaoMudanca.getData().getTime()));
		ps.setString(4, solicitacaoMudanca.getAutor());
		ps.setString(5, solicitacaoMudanca.getNotarevisao());
		ps.setString(6, solicitacaoMudanca.getAprovacao());
		ps.setObject(7, solicitacaoMudanca.getSolicitante());
		ps.setString(8, solicitacaoMudanca.getPrioridade());
		ps.setString(9, solicitacaoMudanca.getDescricao());		
		ps.setString(10, solicitacaoMudanca.getJustificativa());
		ps.setString(11, solicitacaoMudanca.getClassificacao());
		ps.setObject(12, solicitacaoMudanca.getProjetoinicio().getCodigo());
		ps.setLong(13, solicitacaoMudanca.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public SolicitacaoMudanca getSolicitacaoMudanca(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM solicitacaomudanca WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<SolicitacaoMudanca> resultado = getListaSolicitacaoMudanca(rs);
			
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
		private List<SolicitacaoMudanca> getListaSolicitacaoMudanca(ResultSet rs) throws SQLException	{
			List<SolicitacaoMudanca> resultado = new ArrayList<SolicitacaoMudanca>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				SolicitacaoMudanca solicitacaoMudanca = new SolicitacaoMudanca();
				
				solicitacaoMudanca.setSolicitacaomudanca(rs.getString("solicitacaomudanca"));
				solicitacaoMudanca.setVersao(rs.getInt("versao"));
				solicitacaoMudanca.setData(rs.getDate("data"));
				solicitacaoMudanca.setAutor(rs.getString("autor"));
				solicitacaoMudanca.setNotarevisao(rs.getString("notarevisao"));
				solicitacaoMudanca.setAprovacao(rs.getString("aprovacao"));
				solicitacaoMudanca.setSolicitante(rs.getString("solicitante"));				
				solicitacaoMudanca.setPrioridade(rs.getString("prioridade"));					
				solicitacaoMudanca.setDescricao(rs.getString("descricao"));
				solicitacaoMudanca.setJustificativa(rs.getString("justificativa"));
				solicitacaoMudanca.setClassificacao(rs.getString("classificacao"));
				solicitacaoMudanca.setCodigo(rs.getLong("codigo"));
												
				resultado.add(solicitacaoMudanca);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(SolicitacaoMudanca solicitacaoMudanca) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE solicitacaomudanca SET  solicitacaomudanca = ?, versao = ?, data = ?, autor = ?, notarevisao = ?, aprovacao = ?, solicitante = ?, prioridade = ?, descricao = ?, justificativa = ?, classificacao = ?, projetoinicio = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(solicitacaoMudanca, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(SolicitacaoMudanca solicitacaoMudanca) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO solicitacaomudanca(solicitacaomudanca, versao, data, autor, notarevisao, aprovacao, solicitante, prioridade, descricao, justificativa, classificacao, projetoinicio) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, solicitacaoMudanca.getSolicitacaomudanca());		
			ps.setInt(2, solicitacaoMudanca.getVersao());
			ps.setDate(3, new java.sql.Date(solicitacaoMudanca.getData().getTime()));
			ps.setString(4, solicitacaoMudanca.getAutor());
			ps.setString(5, solicitacaoMudanca.getNotarevisao());
			ps.setString(6, solicitacaoMudanca.getAprovacao());
			ps.setObject(7, solicitacaoMudanca.getSolicitante());
			ps.setString(8, solicitacaoMudanca.getPrioridade());
			ps.setString(9, solicitacaoMudanca.getDescricao());		
			ps.setString(10, solicitacaoMudanca.getJustificativa());
			ps.setString(11, solicitacaoMudanca.getClassificacao());
			ps.setObject(12, solicitacaoMudanca.getProjetoinicio().getCodigo());		
			
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
	public List<SolicitacaoMudanca> getSolicitacaoMudancas() throws Exception {
		
		   List<SolicitacaoMudanca> resultado = new ArrayList<SolicitacaoMudanca>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM solicitacaomudanca, projetoinicio WHERE projetoinicio = projetoinicio";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					SolicitacaoMudanca solicitacaoMudanca = new SolicitacaoMudanca();
					
					solicitacaoMudanca.setSolicitacaomudanca(rs.getString("solicitacaomudanca"));
					solicitacaoMudanca.setVersao(rs.getInt("versao"));
					solicitacaoMudanca.setData(rs.getDate("data"));
					solicitacaoMudanca.setAutor(rs.getString("autor"));
					solicitacaoMudanca.setNotarevisao(rs.getString("notarevisao"));
					solicitacaoMudanca.setAprovacao(rs.getString("aprovacao"));
					solicitacaoMudanca.setSolicitante(rs.getString("solicitante"));				
					solicitacaoMudanca.setPrioridade(rs.getString("prioridade"));					
					solicitacaoMudanca.setDescricao(rs.getString("descricao"));
					solicitacaoMudanca.setJustificativa(rs.getString("justificativa"));
					solicitacaoMudanca.setClassificacao(rs.getString("classificacao"));
					solicitacaoMudanca.setCodigo(rs.getLong("codigo"));
					
					solicitacaoMudanca.getProjetoinicio().setCodigo(rs.getLong("codigo"));
					
					solicitacaoMudanca.getProjetoinicio().setCodigoprojeto(rs.getInt("codigoprojeto"));
					solicitacaoMudanca.getProjetoinicio().setProjeto(rs.getString("projeto"));					
					solicitacaoMudanca.getProjetoinicio().setData(rs.getDate("data"));
					solicitacaoMudanca.getProjetoinicio().setAtribuiprojeto(rs.getString("atribuiprojeto"));
					solicitacaoMudanca.getProjetoinicio().setTipoprojeto(rs.getString("tipoprojeto"));
					solicitacaoMudanca.getProjetoinicio().setObjetivo(rs.getString("objetivo"));
					solicitacaoMudanca.getProjetoinicio().setCliente(rs.getString("cliente"));
					solicitacaoMudanca.getProjetoinicio().setPrograma(rs.getString("programa"));
					solicitacaoMudanca.getProjetoinicio().setArea(rs.getString("area"));
					solicitacaoMudanca.getProjetoinicio().setRoi(rs.getDouble("roi"));
					solicitacaoMudanca.getProjetoinicio().setDescricao(rs.getString("descricao"));
					solicitacaoMudanca.getProjetoinicio().setCopia(rs.getString("copia"));
									
					resultado.add(solicitacaoMudanca);// Add o projeto ao resultado.
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

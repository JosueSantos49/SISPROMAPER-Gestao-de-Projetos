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
import br.com.tkcsapcd.model.bean.PlanoGerenciamentoProjeto;
import br.com.tkcsapcd.model.util.Conexao;

public class PlanoGerenciamentoProjetoDAO implements InterfacePlanoGerenciamentoProjetoDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public PlanoGerenciamentoProjetoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception   {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM planogerenciamentoprojeto WHERE codigo = ?;";

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
	

	@Override
	public PlanoGerenciamentoProjeto getPlanoGerenciamentoProjeto(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM planogerenciamentoprojeto WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<PlanoGerenciamentoProjeto> resultado = getListaPlanoGerenciamentoProjeto(rs);
			
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
		private List<PlanoGerenciamentoProjeto> getListaPlanoGerenciamentoProjeto(ResultSet rs) throws SQLException	{
			List<PlanoGerenciamentoProjeto> resultado = new ArrayList<PlanoGerenciamentoProjeto>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				PlanoGerenciamentoProjeto planoGerenciamentoProjeto = new PlanoGerenciamentoProjeto();
				
				planoGerenciamentoProjeto.setPlanogerenciamentoprojeto(rs.getString("planogerenciamentoprojeto"));
				planoGerenciamentoProjeto.setVersao(rs.getString("versao"));
				planoGerenciamentoProjeto.setData(rs.getDate("data"));
				planoGerenciamentoProjeto.setAutor(rs.getString("autor"));
				planoGerenciamentoProjeto.setNotarevisao(rs.getString("notarevisao"));
				planoGerenciamentoProjeto.setAprovacao(rs.getString("aprovacao"));
				planoGerenciamentoProjeto.setObjetivo(rs.getString("objetivo"));				
				planoGerenciamentoProjeto.setLinhabase(rs.getString("linhabase"));					
				planoGerenciamentoProjeto.setOrganizacao(rs.getString("organizacao"));
				planoGerenciamentoProjeto.setCronograma(rs.getString("cronograma"));
				planoGerenciamentoProjeto.setProgresso(rs.getString("progresso"));
				planoGerenciamentoProjeto.setRisco(rs.getString("risco"));
				planoGerenciamentoProjeto.setComunicacao(rs.getString("comunicacao"));
				planoGerenciamentoProjeto.setMudanca(rs.getString("mudanca"));
				planoGerenciamentoProjeto.setCodigo(rs.getLong("codigo"));
												
				resultado.add(planoGerenciamentoProjeto);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(PlanoGerenciamentoProjeto planoGerenciamentoProjeto) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE planogerenciamentoprojeto SET planogerenciamentoprojeto = ?, versao= ?, data= ?, autor = ?, notarevisao = ?, aprovacao = ?, objetivo = ?, linhabase = ?, organizacao = ?, cronograma = ?, progresso = ?, risco = ?, comunicacao = ?, mudanca = ?, projetoinicio = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(planoGerenciamentoProjeto, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	
	private void setPreparedStatement(PlanoGerenciamentoProjeto planoGerenciamentoProjeto, PreparedStatement ps) throws SQLException 
	{		
		ps.setString(1, planoGerenciamentoProjeto.getPlanogerenciamentoprojeto());
		ps.setString(2, planoGerenciamentoProjeto.getVersao());
		ps.setDate(3, new java.sql.Date(planoGerenciamentoProjeto.getData().getTime()));
		ps.setString(4, planoGerenciamentoProjeto.getAutor());
		ps.setString(5, planoGerenciamentoProjeto.getNotarevisao());
		ps.setString(6, planoGerenciamentoProjeto.getAprovacao());
		ps.setObject(7, planoGerenciamentoProjeto.getObjetivo());
		ps.setString(8, planoGerenciamentoProjeto.getLinhabase());
		ps.setString(9, planoGerenciamentoProjeto.getOrganizacao());		
		ps.setString(10, planoGerenciamentoProjeto.getCronograma());
		ps.setString(11, planoGerenciamentoProjeto.getProgresso());
		ps.setString(12, planoGerenciamentoProjeto.getRisco());	
		ps.setString(13, planoGerenciamentoProjeto.getComunicacao());
		ps.setString(14, planoGerenciamentoProjeto.getMudanca());
		ps.setObject(15, planoGerenciamentoProjeto.getProjetoinicio().getCodigo());
		ps.setLong(16, planoGerenciamentoProjeto.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public void salvar(PlanoGerenciamentoProjeto planoGerenciamentoProjeto) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO planogerenciamentoprojeto(planogerenciamentoprojeto, versao, data, autor, notarevisao, aprovacao, objetivo,linhabase, organizacao, cronograma, progresso,risco,comunicacao, mudanca, projetoinicio) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, planoGerenciamentoProjeto.getPlanogerenciamentoprojeto());
			ps.setString(2, planoGerenciamentoProjeto.getVersao());
			ps.setDate(3, new java.sql.Date(planoGerenciamentoProjeto.getData().getTime()));
			ps.setString(4, planoGerenciamentoProjeto.getAutor());
			ps.setString(5, planoGerenciamentoProjeto.getNotarevisao());
			ps.setString(6, planoGerenciamentoProjeto.getAprovacao());
			ps.setObject(7, planoGerenciamentoProjeto.getObjetivo());
			ps.setString(8, planoGerenciamentoProjeto.getLinhabase());
			ps.setString(9, planoGerenciamentoProjeto.getOrganizacao());		
			ps.setString(10, planoGerenciamentoProjeto.getCronograma());
			ps.setString(11, planoGerenciamentoProjeto.getProgresso());
			ps.setString(12, planoGerenciamentoProjeto.getRisco());	
			ps.setString(13, planoGerenciamentoProjeto.getComunicacao());
			ps.setString(14, planoGerenciamentoProjeto.getMudanca());				
			ps.setObject(15, planoGerenciamentoProjeto.getProjetoinicio().getCodigo());
			
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
	public List<PlanoGerenciamentoProjeto> getPlanoGerenciamentoProjetos() throws Exception  {		
		   List<PlanoGerenciamentoProjeto> resultado = new ArrayList<PlanoGerenciamentoProjeto>();// Montar o resultado
		   
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM planogerenciamentoprojeto, projetoinicio WHERE projetoinicio = projetoinicio";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					PlanoGerenciamentoProjeto planoGerenciamentoProjeto = new PlanoGerenciamentoProjeto();
				
					planoGerenciamentoProjeto.setPlanogerenciamentoprojeto(rs.getString("planogerenciamentoprojeto"));
					planoGerenciamentoProjeto.setVersao(rs.getString("versao"));
					planoGerenciamentoProjeto.setData(rs.getDate("data"));
					planoGerenciamentoProjeto.setAutor(rs.getString("autor"));
					planoGerenciamentoProjeto.setNotarevisao(rs.getString("notarevisao"));
					planoGerenciamentoProjeto.setAprovacao(rs.getString("aprovacao"));
					planoGerenciamentoProjeto.setObjetivo(rs.getString("objetivo"));				
					planoGerenciamentoProjeto.setLinhabase(rs.getString("linhabase"));					
					planoGerenciamentoProjeto.setOrganizacao(rs.getString("organizacao"));
					planoGerenciamentoProjeto.setCronograma(rs.getString("cronograma"));
					planoGerenciamentoProjeto.setProgresso(rs.getString("progresso"));
					planoGerenciamentoProjeto.setRisco(rs.getString("risco"));
					planoGerenciamentoProjeto.setComunicacao(rs.getString("comunicacao"));
					planoGerenciamentoProjeto.setMudanca(rs.getString("mudanca"));
					planoGerenciamentoProjeto.setCodigo(rs.getLong("codigo"));
					
					planoGerenciamentoProjeto.getProjetoinicio().setCodigo(rs.getLong("codigo"));
					
					planoGerenciamentoProjeto.getProjetoinicio().setCodigoprojeto(rs.getInt("codigoprojeto"));
					planoGerenciamentoProjeto.getProjetoinicio().setProjeto(rs.getString("projeto"));					
					planoGerenciamentoProjeto.getProjetoinicio().setData(rs.getDate("data"));
					planoGerenciamentoProjeto.getProjetoinicio().setAtribuiprojeto(rs.getString("atribuiprojeto"));
					planoGerenciamentoProjeto.getProjetoinicio().setTipoprojeto(rs.getString("tipoprojeto"));
					planoGerenciamentoProjeto.getProjetoinicio().setObjetivo(rs.getString("objetivo"));
					planoGerenciamentoProjeto.getProjetoinicio().setCliente(rs.getString("cliente"));
					planoGerenciamentoProjeto.getProjetoinicio().setPrograma(rs.getString("programa"));
					planoGerenciamentoProjeto.getProjetoinicio().setArea(rs.getString("area"));
					planoGerenciamentoProjeto.getProjetoinicio().setRoi(rs.getDouble("roi"));
					planoGerenciamentoProjeto.getProjetoinicio().setDescricao(rs.getString("descricao"));
					planoGerenciamentoProjeto.getProjetoinicio().setCopia(rs.getString("copia"));
									
					resultado.add(planoGerenciamentoProjeto);// Add o projeto ao resultado.
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

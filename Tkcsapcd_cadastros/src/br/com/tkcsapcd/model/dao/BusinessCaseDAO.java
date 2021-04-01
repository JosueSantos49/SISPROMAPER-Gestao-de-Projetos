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
import br.com.tkcsapcd.model.bean.BusinessCase;
import br.com.tkcsapcd.model.util.Conexao;

public class BusinessCaseDAO implements InterfaceBusinessCaseDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public BusinessCaseDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM businesscase WHERE codigo = ?;";

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
	
	private void setPreparedStatement(BusinessCase businessCase, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, businessCase.getBusinesscase());
		ps.setString(2, businessCase.getVersao());
		ps.setDate(3, new java.sql.Date(businessCase.getData().getTime()));
		ps.setString(4, businessCase.getAutor());
		ps.setString(5, businessCase.getNotarevisao());
		ps.setString(6, businessCase.getAprovacao());
		ps.setObject(7, businessCase.getObjetivodocumento());
		ps.setString(8, businessCase.getObjetivo());
		ps.setString(9, businessCase.getNecessidade());		
		ps.setString(10, businessCase.getIndicadores());
		ps.setString(11, businessCase.getPrevisao());
		ps.setString(12, businessCase.getOrganizacao());	
		ps.setString(13, businessCase.getAnalise());
		ps.setString(14, businessCase.getPartes());
		ps.setString(15, businessCase.getOrcamento());
		ps.setObject(16, businessCase.getProjetoinicio().getCodigo());
		ps.setLong(17,businessCase.getCodigo());
		
	}

	@Override
	public BusinessCase getBusinessCase(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM businesscase WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<BusinessCase> resultado = getListaBusinessCase(rs);
			
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
		private List<BusinessCase> getListaBusinessCase(ResultSet rs) throws SQLException	{
			List<BusinessCase> resultado = new ArrayList<BusinessCase>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				BusinessCase businessCase = new BusinessCase();
				
				businessCase.setBusinesscase(rs.getString("businesscase"));
				businessCase.setVersao(rs.getString("versao"));
				businessCase.setData(rs.getDate("data"));
				businessCase.setAutor(rs.getString("autor"));
				businessCase.setNotarevisao(rs.getString("notarevisao"));
				businessCase.setAprovacao(rs.getString("aprovacao"));		
				businessCase.setObjetivodocumento(rs.getString("objetivodocumento"));
				businessCase.setObjetivo(rs.getString("objetivo"));
				businessCase.setNecessidade(rs.getString("necessidade"));
				businessCase.setIndicadores(rs.getString("indicadores"));
				businessCase.setPrevisao(rs.getString("previsao"));
				businessCase.setOrganizacao(rs.getString("organizacao"));
				businessCase.setAnalise(rs.getString("analise"));
				businessCase.setPartes(rs.getString("partes"));					
				businessCase.setOrcamento(rs.getString("orcamento"));
				businessCase.setCodigo(rs.getLong("codigo"));
												
				resultado.add(businessCase);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(BusinessCase businessCase) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{		
			String sqlAtualizar = "UPDATE businesscase SET businesscase = ?, versao = ?, data = ?, autor = ?, notarevisao = ?, aprovacao = ?, objetivodocumento = ?, objetivo = ?, necessidade = ?, indicadores = ?, previsao = ?, organizacao = ?, analise = ?, partes = ?, orcamento = ?, projetoinicio = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(businessCase, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
						
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
	public void salvar(BusinessCase businessCase) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO businesscase(businesscase, versao, data, autor, notarevisao, aprovacao, objetivodocumento, objetivo, necessidade, indicadores, previsao, organizacao, analise, partes, orcamento, projetoinicio)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, businessCase.getBusinesscase());
			ps.setString(2, businessCase.getVersao());
			ps.setDate(3, new java.sql.Date(businessCase.getData().getTime()));
			ps.setString(4, businessCase.getAutor());
			ps.setString(5, businessCase.getNotarevisao());
			ps.setString(6, businessCase.getAprovacao());
			ps.setObject(7, businessCase.getObjetivodocumento());
			ps.setString(8, businessCase.getObjetivo());
			ps.setString(9, businessCase.getNecessidade());		
			ps.setString(10, businessCase.getIndicadores());
			ps.setString(11, businessCase.getPrevisao());
			ps.setString(12, businessCase.getOrganizacao());	
			ps.setString(13, businessCase.getAnalise());
			ps.setString(14, businessCase.getPartes());
			ps.setString(15, businessCase.getOrcamento());			
			ps.setObject(16, businessCase.getProjetoinicio().getCodigo());
			
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
	public List<BusinessCase> getBusinessCases() throws Exception {
		
		   List<BusinessCase> resultado = new ArrayList<BusinessCase>();// Montar o resultado
		   Connection con=null;
		   PreparedStatement ps=null;
		   ResultSet rs =null;
		try {
			con = Conexao.getConnection();			
			String sqlSelect = "SELECT * FROM businesscase";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					
					BusinessCase businessCase = new BusinessCase();
					
					businessCase.setBusinesscase(rs.getString("businesscase"));
					businessCase.setVersao(rs.getString("versao"));
					businessCase.setData(rs.getDate("data"));
					businessCase.setAutor(rs.getString("autor"));
					businessCase.setNotarevisao(rs.getString("notarevisao"));
					businessCase.setAprovacao(rs.getString("aprovacao"));	
					businessCase.setObjetivodocumento(rs.getString("objetivodocumento"));
					businessCase.setObjetivo(rs.getString("objetivo"));
					businessCase.setNecessidade(rs.getString("necessidade"));
					businessCase.setIndicadores(rs.getString("indicadores"));
					businessCase.setPrevisao(rs.getString("previsao"));
					businessCase.setOrganizacao(rs.getString("organizacao"));
					businessCase.setAnalise(rs.getString("analise"));
					businessCase.setPartes(rs.getString("partes"));					
					businessCase.setOrcamento(rs.getString("orcamento"));
					businessCase.setCodigo(rs.getLong("codigo"));
					
					businessCase.getProjetoinicio().setCodigo(rs.getLong("codigo"));
									
					resultado.add(businessCase);// Add o projeto ao resultado.
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

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
import br.com.tkcsapcd.model.bean.StatusReport;
import br.com.tkcsapcd.model.util.Conexao;

public class StatusReportDAO implements InterfaceStatusReportDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public StatusReportDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM statusreport WHERE codigo = ?;";

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
	
	private void setPreparedStatement(StatusReport statusReport, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, statusReport.getStatusreport());
		ps.setString(2, statusReport.getProjeto());
		ps.setInt(3, statusReport.getCodigoprojeto());
		ps.setString(4, statusReport.getPeriodoinicio());
		ps.setString(5, statusReport.getPeriodofim());
		ps.setString(6, statusReport.getIndicador());
		ps.setString(7, statusReport.getStatus());
		ps.setString(8, statusReport.getComentario());
		ps.setObject(9, statusReport.getEap());
		ps.setString(10, statusReport.getPeriodo());
		ps.setString(11, statusReport.getAtividadeandamento());		
		ps.setString(12, statusReport.getProximoperiodo());
		ps.setString(13, statusReport.getPontoatencao());
		ps.setString(14, statusReport.getAdicionais());
		ps.setInt(15, statusReport.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public StatusReport getStatusReport(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM statusreport WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<StatusReport> resultado = getListaStatusReport(rs);
			
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
		private List<StatusReport> getListaStatusReport(ResultSet rs) throws SQLException	{
			List<StatusReport> resultado = new ArrayList<StatusReport>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				StatusReport statusReport = new StatusReport();
				
				statusReport.setStatusreport(rs.getString("statusreport"));
				statusReport.setProjeto(rs.getString("projeto"));
				statusReport.setCodigoprojeto(rs.getInt("codigoprojeto"));
				statusReport.setPeriodoinicio(rs.getString("periodoinicio"));
				statusReport.setPeriodofim(rs.getString("periodofim"));
				statusReport.setIndicador(rs.getString("indicador"));
				statusReport.setStatus(rs.getString("status"));
				statusReport.setComentario(rs.getString("comentario"));
				statusReport.setEap(rs.getString("eap"));				
				statusReport.setPeriodo(rs.getString("proximoperiodo"));					
				statusReport.setAtividadeandamento(rs.getString("atividadeandamento"));
				statusReport.setProximoperiodo(rs.getString("proximoperiodo"));
				statusReport.setPontoatencao(rs.getString("pontoatencao"));
				statusReport.setAdicionais(rs.getString("adicionais"));
				statusReport.setCodigo(rs.getInt("codigo"));
												
				resultado.add(statusReport);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(StatusReport statusReport) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE statusreport SET statusreport = ?, projeto = ?, codigoprojeto = ?, periodoinicio = ?, periodofim = ?, indicador = ?, status = ?, comentario = ?, eap = ?, periodo = ?, atividadeandamento = ?, proximoperiodo = ?, pontoatencao = ?, adicionais = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(statusReport, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(StatusReport statusReport) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO statusreport(statusreport, projeto, codigoprojeto, periodoinicio, periodofim, indicador, status, comentario, eap, periodo, atividadeandamento, proximoperiodo, pontoatencao, adicionais) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, statusReport.getStatusreport());
			ps.setString(2, statusReport.getProjeto());
			ps.setInt(3, statusReport.getCodigoprojeto());
			ps.setString(4, statusReport.getPeriodoinicio());
			ps.setString(5, statusReport.getPeriodofim());
			ps.setString(6, statusReport.getIndicador());
			ps.setString(7, statusReport.getStatus());
			ps.setString(8, statusReport.getComentario());
			ps.setObject(9, statusReport.getEap());
			ps.setString(10, statusReport.getPeriodo());
			ps.setString(11, statusReport.getAtividadeandamento());		
			ps.setString(12, statusReport.getProximoperiodo());
			ps.setString(13, statusReport.getPontoatencao());
			ps.setString(14, statusReport.getAdicionais());
			
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
	public List<StatusReport> getStatusReports() throws Exception {
		
		   List<StatusReport> resultado = new ArrayList<StatusReport>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM statusreport";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					StatusReport statusReport = new StatusReport();
					
					statusReport.setStatusreport(rs.getString("statusreport"));
					statusReport.setProjeto(rs.getString("projeto"));
					statusReport.setCodigoprojeto(rs.getInt("codigoprojeto"));
					statusReport.setPeriodoinicio(rs.getString("periodoinicio"));
					statusReport.setPeriodofim(rs.getString("periodofim"));
					statusReport.setIndicador(rs.getString("indicador"));
					statusReport.setStatus(rs.getString("status"));
					statusReport.setComentario(rs.getString("comentario"));
					statusReport.setEap(rs.getString("eap"));				
					statusReport.setPeriodo(rs.getString("proximoperiodo"));					
					statusReport.setAtividadeandamento(rs.getString("atividadeandamento"));
					statusReport.setProximoperiodo(rs.getString("proximoperiodo"));
					statusReport.setPontoatencao(rs.getString("pontoatencao"));
					statusReport.setAdicionais(rs.getString("adicionais"));
					statusReport.setCodigo(rs.getInt("codigo"));
									
					resultado.add(statusReport);// Add o projeto ao resultado.
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

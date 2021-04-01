/* 
	Autor: Josu� da Concei��o Santos
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
import br.com.tkcsapcd.model.bean.IssuesLog;
import br.com.tkcsapcd.model.util.Conexao;

public class IssuesLogDAO implements InterfaceIssuesLogDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public IssuesLogDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM issueslog WHERE codigo = ?;";

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
	private void setPreparedStatement(IssuesLog issuesLog, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, issuesLog.getIssueslog());
		ps.setString(2, issuesLog.getProjeto());
		ps.setInt(3, issuesLog.getCodigoprojeto());
		ps.setString(4, issuesLog.getVersao());
		ps.setString(5, issuesLog.getData());
		ps.setString(6, issuesLog.getAutor());
		ps.setString(7, issuesLog.getNotarevisao());
		ps.setString(8, issuesLog.getAprovacao());
		ps.setInt(9, issuesLog.getCodigoissueslog());
		ps.setString(10, issuesLog.getSeveridade());		
		ps.setString(11, issuesLog.getDataidentificacao());
		ps.setString(12, issuesLog.getDescricao());
		ps.setString(13, issuesLog.getUrgencia());	
		ps.setString(14, issuesLog.getImpacto());
		ps.setString(15, issuesLog.getDescricaoimpacto());
		ps.setString(16, issuesLog.getDescricaoacao());
		ps.setString(17, issuesLog.getResponsavel());
		ps.setString(18, issuesLog.getPrevisao());
		ps.setString(19, issuesLog.getStatus());
		ps.setString(20, issuesLog.getComentario());
		ps.setInt(21, issuesLog.getCodigo());//Aten��o: necess�rio para isolar o metodo (extra��o). 
		
	}

	@Override
	public IssuesLog getIssuesLog(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM issueslog WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<IssuesLog> resultado = getListaIssuesLog(rs);
			
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

		//Metodo p confirma objetivo. Resulmir linhas de c�digos, que pode ser usados em outros m�todos. (ex: resultado = getListaCliente(rs); ou List<Cliente> resultado = getListaCliente(rs);)
		private List<IssuesLog> getListaIssuesLog(ResultSet rs) throws SQLException	{
			List<IssuesLog> resultado = new ArrayList<IssuesLog>();
			
			// La�o p/ preencher
			while (rs.next()) {
				
				IssuesLog issuesLog = new IssuesLog();
				
				issuesLog.setIssueslog(rs.getString("issueslog"));
				issuesLog.setProjeto(rs.getString("projeto"));
				issuesLog.setCodigoprojeto(rs.getInt("codigoprojeto"));
				issuesLog.setVersao(rs.getString("versao"));
				issuesLog.setData(rs.getString("data"));
				issuesLog.setAutor(rs.getString("autor"));
				issuesLog.setNotarevisao(rs.getString("notarevisao"));
				issuesLog.setAprovacao(rs.getString("aprovacao"));				
				issuesLog.setCodigoissueslog(rs.getInt("codigoissueslog"));					
				issuesLog.setSeveridade(rs.getString("severidade"));
				issuesLog.setDataidentificacao(rs.getString("dataidentificacao"));
				issuesLog.setDescricao(rs.getString("descricaoacao"));
				issuesLog.setUrgencia(rs.getString("urgencia"));
				issuesLog.setImpacto(rs.getString("impacto"));
				issuesLog.setDescricaoimpacto(rs.getString("descricaoimpacto"));
				issuesLog.setDescricaoacao(rs.getString("descricaoacao"));
				issuesLog.setResponsavel(rs.getString("responsavel"));					
				issuesLog.setPrevisao(rs.getString("previsao"));
				issuesLog.setStatus(rs.getString("status"));
				issuesLog.setComentario(rs.getString("comentario"));
				issuesLog.setCodigo(rs.getInt("codigo"));
												
				resultado.add(issuesLog);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(IssuesLog issuesLog) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE issueslog SET issueslog = ?, projeto = ?, codigoprojeto = ?, versao = ?, data = ?, autor = ?, notarevisao = ?, aprovacao = ?, codigoissueslog = ?, severidade = ?, dataidentificacao = ?, descricao = ?, urgencia = ?, impacto = ?, descricaoimpacto = ?, descricaoacao = ?, responsavel = ?, previsao = ?, status = ?, comentario = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(issuesLog, ps);//C�digo isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
			ps.executeUpdate();//Linha muito importante, sem ela n�o � executado a atualiza��o do cliente
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
	public void salvar(IssuesLog issuesLog) throws Exception  {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO issueslog(issueslog, projeto, codigoprojeto, versao, data, autor, notarevisao, aprovacao, codigoissueslog, severidade, dataidentificacao, descricao, urgencia, impacto, descricaoimpacto, descricaoacao, responsavel, previsao, status, comentario) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
						
			ps.setString(1, issuesLog.getIssueslog());
			ps.setString(2, issuesLog.getProjeto());
			ps.setInt(3, issuesLog.getCodigoprojeto());
			ps.setString(4, issuesLog.getVersao());
			ps.setString(5, issuesLog.getData());
			ps.setString(6, issuesLog.getAutor());
			ps.setString(7, issuesLog.getNotarevisao());
			ps.setString(8, issuesLog.getAprovacao());
			ps.setInt(9, issuesLog.getCodigoissueslog());
			ps.setString(10, issuesLog.getSeveridade());		
			ps.setString(11, issuesLog.getDataidentificacao());
			ps.setString(12, issuesLog.getDescricao());
			ps.setString(13, issuesLog.getUrgencia());	
			ps.setString(14, issuesLog.getImpacto());
			ps.setString(15, issuesLog.getDescricaoimpacto());
			ps.setString(16, issuesLog.getDescricaoacao());
			ps.setString(17, issuesLog.getResponsavel());
			ps.setString(18, issuesLog.getPrevisao());
			ps.setString(19, issuesLog.getStatus());
			ps.setString(20, issuesLog.getComentario());
			
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
	public List<IssuesLog> getIssuesLogs() throws Exception  {
		
		   List<IssuesLog> resultado = new ArrayList<IssuesLog>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM issueslog";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excu��o da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// La�o p/ preencher
				while (rs.next()) {
					
					IssuesLog issuesLog = new IssuesLog();
					
					issuesLog.setIssueslog(rs.getString("issueslog"));
					issuesLog.setProjeto(rs.getString("projeto"));
					issuesLog.setCodigoprojeto(rs.getInt("codigoprojeto"));
					issuesLog.setVersao(rs.getString("versao"));
					issuesLog.setData(rs.getString("data"));
					issuesLog.setAutor(rs.getString("autor"));
					issuesLog.setNotarevisao(rs.getString("notarevisao"));
					issuesLog.setAprovacao(rs.getString("aprovacao"));			
					issuesLog.setCodigoissueslog(rs.getInt("codigoissueslog"));					
					issuesLog.setSeveridade(rs.getString("severidade"));
					issuesLog.setDataidentificacao(rs.getString("dataidentificacao"));
					issuesLog.setDescricao(rs.getString("descricaoacao"));
					issuesLog.setUrgencia(rs.getString("urgencia"));
					issuesLog.setImpacto(rs.getString("impacto"));
					issuesLog.setDescricaoimpacto(rs.getString("descricaoimpacto"));
					issuesLog.setDescricaoacao(rs.getString("descricaoacao"));
					issuesLog.setResponsavel(rs.getString("responsavel"));					
					issuesLog.setPrevisao(rs.getString("previsao"));
					issuesLog.setStatus(rs.getString("status"));
					issuesLog.setComentario(rs.getString("comentario"));
					issuesLog.setCodigo(rs.getInt("codigo"));
									
					resultado.add(issuesLog);// Add o projeto ao resultado.
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

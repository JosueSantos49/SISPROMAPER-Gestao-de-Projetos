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
import br.com.tkcsapcd.model.bean.DiagnosticoPlanoAcao;
import br.com.tkcsapcd.model.util.Conexao;

public class DiagnosticoPlanoAcaoDAO implements InterfaceDiagnosticoPlanoAcaoDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public DiagnosticoPlanoAcaoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM diagnosticoplanoacao WHERE codigo = ?;";

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
	private void setPreparedStatement(DiagnosticoPlanoAcao diagnosticoPlanoAcao, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, diagnosticoPlanoAcao.getDiagnosticoplanoacao());
		ps.setString(2, diagnosticoPlanoAcao.getProjeto());
		ps.setInt(3, diagnosticoPlanoAcao.getCodigoprojeto());
		ps.setString(4, diagnosticoPlanoAcao.getVersao());
		ps.setString(5, diagnosticoPlanoAcao.getData());
		ps.setString(6, diagnosticoPlanoAcao.getAutor());
		ps.setString(7, diagnosticoPlanoAcao.getNotarevisao());
		ps.setString(8, diagnosticoPlanoAcao.getAprovacao());
		ps.setObject(9, diagnosticoPlanoAcao.getObjetivo());
		ps.setString(10, diagnosticoPlanoAcao.getAbordagem());
		ps.setString(11, diagnosticoPlanoAcao.getProblemas());		
		ps.setString(12, diagnosticoPlanoAcao.getPlano());
		ps.setString(13, diagnosticoPlanoAcao.getPremissa());
		ps.setString(14, diagnosticoPlanoAcao.getCriterio());	
		ps.setString(15, diagnosticoPlanoAcao.getMarcos());
		ps.setString(16, diagnosticoPlanoAcao.getOrcamento());
		ps.setString(17, diagnosticoPlanoAcao.getRisco());
		ps.setInt(18, diagnosticoPlanoAcao.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public DiagnosticoPlanoAcao getDiagnosticoPlanoAcao(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM diagnosticoplanoacao WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<DiagnosticoPlanoAcao> resultado = getListaDiagnosticoPlanoAcao(rs);
			
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
		private List<DiagnosticoPlanoAcao> getListaDiagnosticoPlanoAcao(ResultSet rs) throws SQLException	{
				List<DiagnosticoPlanoAcao> resultado = new ArrayList<DiagnosticoPlanoAcao>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				DiagnosticoPlanoAcao diagnosticoPlanoAcao = new DiagnosticoPlanoAcao();
				
				diagnosticoPlanoAcao.setDiagnosticoplanoacao(rs.getString("diagnosticoplanoacao"));
				diagnosticoPlanoAcao.setProjeto(rs.getString("projeto"));
				diagnosticoPlanoAcao.setCodigoprojeto(rs.getInt("codigoprojeto"));
				diagnosticoPlanoAcao.setVersao(rs.getString("versao"));
				diagnosticoPlanoAcao.setData(rs.getString("data"));
				diagnosticoPlanoAcao.setAutor(rs.getString("autor"));
				diagnosticoPlanoAcao.setNotarevisao(rs.getString("notarevisao"));
				diagnosticoPlanoAcao.setAprovacao(rs.getString("aprovacao"));
				diagnosticoPlanoAcao.setObjetivo(rs.getString("objetivo"));				
				diagnosticoPlanoAcao.setAbordagem(rs.getString("abordagem"));					
				diagnosticoPlanoAcao.setProblemas(rs.getString("problemas"));
				diagnosticoPlanoAcao.setPlano(rs.getString("plano"));
				diagnosticoPlanoAcao.setPremissa(rs.getString("premissa"));
				diagnosticoPlanoAcao.setCriterio(rs.getString("criterio"));
				diagnosticoPlanoAcao.setMarcos(rs.getString("marcos"));
				diagnosticoPlanoAcao.setOrcamento(rs.getString("orcamento"));
				diagnosticoPlanoAcao.setRisco(rs.getString("risco"));
				diagnosticoPlanoAcao.setCodigo(rs.getInt("codigo"));
												
				resultado.add(diagnosticoPlanoAcao);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(DiagnosticoPlanoAcao diagnosticoPlanoAcao) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE diagnosticoplanoacao SET diagnosticoplanoacao = ?, projeto = ?, codigoprojeto = ?, versao = ?, data = ?, autor = ?, notarevisao = ?, aprovacao = ?, objetivo = ?, abordagem = ?, problemas = ?, plano = ?, premissa = ?, criterio = ?, marcos = ?, orcamento = ?, risco = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(diagnosticoPlanoAcao, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(DiagnosticoPlanoAcao diagnosticoPlanoAcao) throws Exception  {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO diagnosticoplanoacao(diagnosticoplanoacao, projeto, codigoprojeto, versao, data, autor, notarevisao, aprovacao, objetivo, abordagem, problemas, plano, premissa, criterio, marcos, orcamento, risco) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
						
			ps.setString(1, diagnosticoPlanoAcao.getDiagnosticoplanoacao());
			ps.setString(2, diagnosticoPlanoAcao.getProjeto());
			ps.setInt(3, diagnosticoPlanoAcao.getCodigoprojeto());
			ps.setString(4, diagnosticoPlanoAcao.getVersao());
			ps.setString(5, diagnosticoPlanoAcao.getData());
			ps.setString(6, diagnosticoPlanoAcao.getAutor());
			ps.setString(7, diagnosticoPlanoAcao.getNotarevisao());
			ps.setString(8, diagnosticoPlanoAcao.getAprovacao());
			ps.setObject(9, diagnosticoPlanoAcao.getObjetivo());
			ps.setString(10, diagnosticoPlanoAcao.getAbordagem());
			ps.setString(11, diagnosticoPlanoAcao.getProblemas());		
			ps.setString(12, diagnosticoPlanoAcao.getPlano());
			ps.setString(13, diagnosticoPlanoAcao.getPremissa());
			ps.setString(14, diagnosticoPlanoAcao.getCriterio());	
			ps.setString(15, diagnosticoPlanoAcao.getMarcos());
			ps.setString(16, diagnosticoPlanoAcao.getOrcamento());
			ps.setString(17, diagnosticoPlanoAcao.getRisco());
			
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
	public List<DiagnosticoPlanoAcao> getDiagnosticoPlanoAcaos() throws Exception {		
		   List<DiagnosticoPlanoAcao> resultado = new ArrayList<DiagnosticoPlanoAcao>();// Montar o resultado
		   
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs =null;
		try {
			con = Conexao.getConnection();			
			String sqlSelect = "SELECT * FROM diagnosticoplanoacao";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					
					DiagnosticoPlanoAcao diagnosticoPlanoAcao = new DiagnosticoPlanoAcao();
				
					diagnosticoPlanoAcao.setDiagnosticoplanoacao(rs.getString("diagnosticoplanoacao"));
					diagnosticoPlanoAcao.setProjeto(rs.getString("projeto"));
					diagnosticoPlanoAcao.setCodigoprojeto(rs.getInt("codigoprojeto"));
					diagnosticoPlanoAcao.setVersao(rs.getString("versao"));
					diagnosticoPlanoAcao.setData(rs.getString("data"));
					diagnosticoPlanoAcao.setAutor(rs.getString("autor"));
					diagnosticoPlanoAcao.setNotarevisao(rs.getString("notarevisao"));
					diagnosticoPlanoAcao.setAprovacao(rs.getString("aprovacao"));
					diagnosticoPlanoAcao.setObjetivo(rs.getString("objetivo"));				
					diagnosticoPlanoAcao.setAbordagem(rs.getString("abordagem"));					
					diagnosticoPlanoAcao.setProblemas(rs.getString("problemas"));
					diagnosticoPlanoAcao.setPlano(rs.getString("plano"));
					diagnosticoPlanoAcao.setPremissa(rs.getString("premissa"));
					diagnosticoPlanoAcao.setCriterio(rs.getString("criterio"));
					diagnosticoPlanoAcao.setMarcos(rs.getString("marcos"));
					diagnosticoPlanoAcao.setOrcamento(rs.getString("orcamento"));
					diagnosticoPlanoAcao.setRisco(rs.getString("risco"));
					diagnosticoPlanoAcao.setCodigo(rs.getInt("codigo"));
									
					resultado.add(diagnosticoPlanoAcao);// Add o projeto ao resultado.
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

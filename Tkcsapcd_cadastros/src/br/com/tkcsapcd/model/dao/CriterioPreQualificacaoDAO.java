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
import br.com.tkcsapcd.model.bean.CriterioPreQualificacao;
import br.com.tkcsapcd.model.util.Conexao;

public class CriterioPreQualificacaoDAO implements InterfaceCriterioPreQualificacaoDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public CriterioPreQualificacaoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM criterioprequalificacao WHERE codigo = ?;";

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
	private void setPreparedStatement(CriterioPreQualificacao criterioPreQualificacao, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, criterioPreQualificacao.getRfp());
		ps.setString(2, criterioPreQualificacao.getObjetivo());
		ps.setString(3, criterioPreQualificacao.getProjeto());
		ps.setInt(4, criterioPreQualificacao.getCodigoprojeto());
		ps.setString(5, criterioPreQualificacao.getGp());
		ps.setString(6, criterioPreQualificacao.getPatrocinador());
		ps.setString(7, criterioPreQualificacao.getArea());
		ps.setString(8, criterioPreQualificacao.getParticipante());
		ps.setObject(9, criterioPreQualificacao.getAprovado());
		ps.setString(10, criterioPreQualificacao.getReprovado());
		ps.setInt(11, criterioPreQualificacao.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public CriterioPreQualificacao getCriterioPreQualificacao(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM criterioprequalificacao WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<CriterioPreQualificacao> resultado = getListaCriterioPreQualificacao(rs);
			
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
		private List<CriterioPreQualificacao> getListaCriterioPreQualificacao(ResultSet rs) throws SQLException	{
			List<CriterioPreQualificacao> resultado = new ArrayList<CriterioPreQualificacao>();
			
			// Laço p/ preencher
			while (rs.next()) {
				CriterioPreQualificacao criterioPreQualificacao = new CriterioPreQualificacao();
				
				criterioPreQualificacao.setRfp(rs.getString("rfp"));
				criterioPreQualificacao.setObjetivo(rs.getString("objetivo"));
				criterioPreQualificacao.setProjeto(rs.getString("projeto"));
				criterioPreQualificacao.setCodigoprojeto(rs.getInt("codigoprojeto"));
				criterioPreQualificacao.setGp(rs.getString("gp"));
				criterioPreQualificacao.setPatrocinador(rs.getString("patrocinador"));
				criterioPreQualificacao.setArea(rs.getString("area"));
				criterioPreQualificacao.setParticipante(rs.getString("participante"));
				criterioPreQualificacao.setAprovado(rs.getString("aprovado"));				
				criterioPreQualificacao.setReprovado(rs.getString("reprovado"));
				criterioPreQualificacao.setCodigo(rs.getInt("codigo"));
												
				resultado.add(criterioPreQualificacao);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(CriterioPreQualificacao criterioPreQualificacao) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE criterioprequalificacao SET rfp = ?, objetivo = ?, projeto = ?, codigoprojeto = ?, gp = ?, patrocinador = ?, area = ?, participante = ?, aprovado = ?, reprovado = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(criterioPreQualificacao, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(CriterioPreQualificacao criterioPreQualificacao) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {			
			
			String sqlInsert = "INSERT INTO criterioprequalificacao(rfp, objetivo, projeto, codigoprojeto, gp, patrocinador, area, participante, aprovado, reprovado) VALUES (?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, criterioPreQualificacao.getRfp());
			ps.setString(2, criterioPreQualificacao.getObjetivo());
			ps.setString(3, criterioPreQualificacao.getProjeto());
			ps.setInt(4, criterioPreQualificacao.getCodigoprojeto());
			ps.setString(5, criterioPreQualificacao.getGp());
			ps.setString(6, criterioPreQualificacao.getPatrocinador());
			ps.setString(7, criterioPreQualificacao.getArea());
			ps.setString(8, criterioPreQualificacao.getParticipante());
			ps.setObject(9, criterioPreQualificacao.getAprovado());
			ps.setString(10, criterioPreQualificacao.getReprovado());
			
			
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
	public List<CriterioPreQualificacao> getCriterioPreQualificacaos() throws Exception  {
		
		   List<CriterioPreQualificacao> resultado = new ArrayList<CriterioPreQualificacao>();// Montar o resultado
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM criterioprequalificacao";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					CriterioPreQualificacao criterioPreQualificacao = new CriterioPreQualificacao();
					
					criterioPreQualificacao.setRfp(rs.getString("rfp"));
					criterioPreQualificacao.setObjetivo(rs.getString("objetivo"));
					criterioPreQualificacao.setProjeto(rs.getString("projeto"));
					criterioPreQualificacao.setCodigoprojeto(rs.getInt("codigoprojeto"));
					criterioPreQualificacao.setGp(rs.getString("gp"));
					criterioPreQualificacao.setPatrocinador(rs.getString("patrocinador"));
					criterioPreQualificacao.setArea(rs.getString("area"));
					criterioPreQualificacao.setParticipante(rs.getString("participante"));
					criterioPreQualificacao.setAprovado(rs.getString("aprovado"));				
					criterioPreQualificacao.setReprovado(rs.getString("reprovado"));
					criterioPreQualificacao.setCodigo(rs.getInt("codigo"));
									
					resultado.add(criterioPreQualificacao);// Add o projeto ao resultado.
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

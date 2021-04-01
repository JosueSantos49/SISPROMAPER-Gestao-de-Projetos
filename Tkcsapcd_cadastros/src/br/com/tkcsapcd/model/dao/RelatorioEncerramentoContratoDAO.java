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
import br.com.tkcsapcd.model.bean.RelatorioEncerramentoContrato;
import br.com.tkcsapcd.model.util.Conexao;

public class RelatorioEncerramentoContratoDAO implements InterfaceRelatorioEncerramentoContratoDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public RelatorioEncerramentoContratoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM relatorioencerramentocontrato WHERE codigo = ?;";

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
	
	private void setPreparedStatement(RelatorioEncerramentoContrato relatorioEncerramentoContrato, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, relatorioEncerramentoContrato.getRelatorio());
		ps.setString(2, relatorioEncerramentoContrato.getProjeto());
		ps.setInt(3, relatorioEncerramentoContrato.getCodigoprojeto());
		ps.setString(4, relatorioEncerramentoContrato.getObjetivo());
		ps.setString(5, relatorioEncerramentoContrato.getIdentificacao());
		ps.setString(6, relatorioEncerramentoContrato.getEntrega());
		ps.setString(7, relatorioEncerramentoContrato.getQuestoes());
		ps.setString(8, relatorioEncerramentoContrato.getInformacoes());
		ps.setObject(9, relatorioEncerramentoContrato.getAceite());
		ps.setInt(10, relatorioEncerramentoContrato.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public RelatorioEncerramentoContrato getRelatorioEncerramentoContrato(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM relatorioencerramentocontrato WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<RelatorioEncerramentoContrato> resultado = getListaRelatorioEncerramentoContrato(rs);
			
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
		private List<RelatorioEncerramentoContrato> getListaRelatorioEncerramentoContrato(ResultSet rs) throws SQLException	{
				List<RelatorioEncerramentoContrato> resultado = new ArrayList<RelatorioEncerramentoContrato>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				
				RelatorioEncerramentoContrato relatorioEncerramentoContrato = new RelatorioEncerramentoContrato();
				
				relatorioEncerramentoContrato.setRelatorio(rs.getString("relatorio"));
				relatorioEncerramentoContrato.setProjeto(rs.getString("projeto"));
				relatorioEncerramentoContrato.setCodigoprojeto(rs.getInt("codigoprojeto"));
				relatorioEncerramentoContrato.setObjetivo(rs.getString("objetivo"));
				relatorioEncerramentoContrato.setIdentificacao(rs.getString("identificacao"));								
				relatorioEncerramentoContrato.setEntrega(rs.getString("entrega"));					
				relatorioEncerramentoContrato.setQuestoes(rs.getString("questoes"));
				relatorioEncerramentoContrato.setInformacoes(rs.getString("informacoes"));
				relatorioEncerramentoContrato.setAceite(rs.getString("aceite"));
				relatorioEncerramentoContrato.setCodigo(rs.getInt("codigo"));
												
				resultado.add(relatorioEncerramentoContrato);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(RelatorioEncerramentoContrato relatorioEncerramentoContrato) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE relatorioencerramentocontrato SET relatorio = ?, projeto = ?, codigoprojeto = ?, objetivo = ?, identificacao = ?, entrega = ?, questoes = ?, informacoes = ?, aceite = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(relatorioEncerramentoContrato, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(RelatorioEncerramentoContrato relatorioEncerramentoContrato) throws Exception  {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO relatorioencerramentocontrato(relatorio, projeto, codigoprojeto, objetivo, identificacao, entrega, questoes, informacoes, aceite) VALUES (?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, relatorioEncerramentoContrato.getRelatorio());
			ps.setString(2, relatorioEncerramentoContrato.getProjeto());
			ps.setInt(3, relatorioEncerramentoContrato.getCodigoprojeto());
			ps.setString(4, relatorioEncerramentoContrato.getObjetivo());
			ps.setString(5, relatorioEncerramentoContrato.getIdentificacao());
			ps.setString(6, relatorioEncerramentoContrato.getEntrega());
			ps.setString(7, relatorioEncerramentoContrato.getQuestoes());
			ps.setString(8, relatorioEncerramentoContrato.getInformacoes());
			ps.setObject(9, relatorioEncerramentoContrato.getAceite());		
			
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
	public List<RelatorioEncerramentoContrato> getRelatorioEncerramentoContratos() throws Exception {
		
		   List<RelatorioEncerramentoContrato> resultado = new ArrayList<RelatorioEncerramentoContrato>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM relatorioencerramentocontrato";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					RelatorioEncerramentoContrato relatorioEncerramentoContrato = new RelatorioEncerramentoContrato();
					
					relatorioEncerramentoContrato.setRelatorio(rs.getString("relatorio"));
					relatorioEncerramentoContrato.setProjeto(rs.getString("projeto"));
					relatorioEncerramentoContrato.setCodigoprojeto(rs.getInt("codigoprojeto"));
					relatorioEncerramentoContrato.setObjetivo(rs.getString("objetivo"));
					relatorioEncerramentoContrato.setIdentificacao(rs.getString("identificacao"));								
					relatorioEncerramentoContrato.setEntrega(rs.getString("entrega"));					
					relatorioEncerramentoContrato.setQuestoes(rs.getString("questoes"));
					relatorioEncerramentoContrato.setInformacoes(rs.getString("informacoes"));
					relatorioEncerramentoContrato.setAceite(rs.getString("aceite"));
					relatorioEncerramentoContrato.setCodigo(rs.getInt("codigo"));
									
					resultado.add(relatorioEncerramentoContrato);// Add o projeto ao resultado.
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

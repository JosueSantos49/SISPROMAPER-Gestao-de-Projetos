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
import br.com.tkcsapcd.model.bean.RegistroSolicitacaoMudanca;
import br.com.tkcsapcd.model.util.Conexao;

public class RegistroSolicitacaoMudancaDAO implements InterfaceRegistroSolicitacaoMudancaDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public RegistroSolicitacaoMudancaDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM registrosolicitacaomudanca WHERE codigo = ?;";

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
	private void setPreparedStatement(RegistroSolicitacaoMudanca registroSolicitacaoMudanca, PreparedStatement ps) throws SQLException 
	{		
		ps.setString(1, registroSolicitacaoMudanca.getVersao());
		ps.setDate(2, new java.sql.Date(registroSolicitacaoMudanca.getData().getTime()));
		ps.setString(3, registroSolicitacaoMudanca.getAutor());
		ps.setString(4, registroSolicitacaoMudanca.getNotarevisao());
		ps.setString(5, registroSolicitacaoMudanca.getAprovacao());
		ps.setObject(6, registroSolicitacaoMudanca.getReferencia());
		ps.setString(7, registroSolicitacaoMudanca.getPrioridade());
		ps.setString(8, registroSolicitacaoMudanca.getImpedeimplantacao());		
		ps.setString(9, registroSolicitacaoMudanca.getSolicitacao());
		ps.setDate(10, new java.sql.Date(registroSolicitacaoMudanca.getDatasolicitacao().getTime()));
		ps.setString(11, registroSolicitacaoMudanca.getDescricao());	
		ps.setString(12, registroSolicitacaoMudanca.getJustificativa());
		ps.setDouble(13, registroSolicitacaoMudanca.getEsforcoestimadohoras());
		ps.setDouble(14, registroSolicitacaoMudanca.getCustoestimado());
		ps.setDouble(15, registroSolicitacaoMudanca.getImpactoprazodias());
		ps.setString(16, registroSolicitacaoMudanca.getClassificacao());
		ps.setString(7, registroSolicitacaoMudanca.getResponsavel());
		ps.setString(18, registroSolicitacaoMudanca.getPrevisao());
		ps.setString(19, registroSolicitacaoMudanca.getStatus());
		ps.setObject(20, registroSolicitacaoMudanca.getComentarios());		
		ps.setObject(21, registroSolicitacaoMudanca.getSolicitacaomudanca().getCodigo());
		ps.setObject(22, registroSolicitacaoMudanca.getProjetoinicio().getCodigo());		
		ps.setLong(23, registroSolicitacaoMudanca.getCodigo());//Atenção: necessário para isolar o metodo (extração). 		
	}

	@Override
	public RegistroSolicitacaoMudanca getRegistroSolicitacaoMudanca(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM registrosolicitacaomudanca WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<RegistroSolicitacaoMudanca> resultado = getListaRegistroSolicitacaoMudanca(rs);
			
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
		private List<RegistroSolicitacaoMudanca> getListaRegistroSolicitacaoMudanca(ResultSet rs) throws SQLException	{
			List<RegistroSolicitacaoMudanca> resultado = new ArrayList<RegistroSolicitacaoMudanca>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				RegistroSolicitacaoMudanca registroSolicitacaoMudanca = new RegistroSolicitacaoMudanca();				
				
				registroSolicitacaoMudanca.setVersao(rs.getString("versao"));
				registroSolicitacaoMudanca.setData(rs.getDate("data"));
				registroSolicitacaoMudanca.setAutor(rs.getString("autor"));
				registroSolicitacaoMudanca.setNotarevisao(rs.getString("notarevisao"));
				registroSolicitacaoMudanca.setAprovacao(rs.getString("aprovacao"));
				registroSolicitacaoMudanca.setReferencia(rs.getDouble("referencia"));				
				registroSolicitacaoMudanca.setPrioridade(rs.getString("prioridade"));					
				registroSolicitacaoMudanca.setImpedeimplantacao(rs.getString("impedeimplantacao"));
				registroSolicitacaoMudanca.setSolicitacao(rs.getString("solicitacao"));
				registroSolicitacaoMudanca.setDatasolicitacao(rs.getDate("datasolicitacao"));
				registroSolicitacaoMudanca.setDescricao(rs.getString("descricao"));
				registroSolicitacaoMudanca.setJustificativa(rs.getString("justificativa"));
				registroSolicitacaoMudanca.setEsforcoestimadohoras(rs.getDouble("esforcoestimadohoras"));
				registroSolicitacaoMudanca.setCustoestimado(rs.getDouble("custoestimado"));
				registroSolicitacaoMudanca.setImpactoprazodias(rs.getDouble("impactoprazodias"));					
				registroSolicitacaoMudanca.setClassificacao(rs.getString("classificacao"));
				registroSolicitacaoMudanca.setResponsavel(rs.getString("responsavel"));
				registroSolicitacaoMudanca.setPrevisao(rs.getString("previsao"));
				registroSolicitacaoMudanca.setStatus(rs.getString("status"));	
				registroSolicitacaoMudanca.setComentarios(rs.getString("comentarios"));
				registroSolicitacaoMudanca.setCodigo(rs.getLong("codigo"));
												
				registroSolicitacaoMudanca.getProjetoinicio().setCodigo(rs.getLong("codigo"));
				registroSolicitacaoMudanca.getSolicitacaomudanca().setCodigo(rs.getLong("codigo"));
				
				resultado.add(registroSolicitacaoMudanca);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(RegistroSolicitacaoMudanca registroSolicitacaoMudanca) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE registrosolicitacaomudanca SET 	 solicitacaomudanca = ?, projeto = ?, codigoprojeto = ?, versao = ?, data = ?, autor = ?, notarevisao = ?, aprovacao = ?, referencia = ?, prioridade = ?,impedeimplantacao = ?, solicitacao = ?, datasolicitacao = ?, descricao = ?, justificativa = ?, esforcoestimadohoras = ?, custoestimado = ?, impactoprazodias = ?, classificacao = ?, responsavel = ?, previsao = ?, status = ?, comentarios = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(registroSolicitacaoMudanca, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(RegistroSolicitacaoMudanca registroSolicitacaoMudanca) throws Exception  {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO registrosolicitacaomudanca(versao, data, autor, notarevisao, aprovacao, referencia, prioridade,impedeimplantacao, solicitacao, datasolicitacao, descricao, justificativa, esforcoestimadohoras, custoestimado, impactoprazodias, classificacao, responsavel, previsao, status, comentarios, solicitacaomudanca) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, registroSolicitacaoMudanca.getVersao());
			ps.setDate(2, new java.sql.Date(registroSolicitacaoMudanca.getData().getTime()));
			ps.setString(3, registroSolicitacaoMudanca.getAutor());
			ps.setString(4, registroSolicitacaoMudanca.getNotarevisao());
			ps.setString(5, registroSolicitacaoMudanca.getAprovacao());
			ps.setObject(6, registroSolicitacaoMudanca.getReferencia());
			ps.setString(7, registroSolicitacaoMudanca.getPrioridade());
			ps.setString(8, registroSolicitacaoMudanca.getImpedeimplantacao());		
			ps.setString(9, registroSolicitacaoMudanca.getSolicitacao());
			ps.setDate(10, new java.sql.Date(registroSolicitacaoMudanca.getDatasolicitacao().getTime()));
			ps.setString(11, registroSolicitacaoMudanca.getDescricao());	
			ps.setString(12, registroSolicitacaoMudanca.getJustificativa());
			ps.setDouble(13, registroSolicitacaoMudanca.getEsforcoestimadohoras());
			ps.setDouble(14, registroSolicitacaoMudanca.getCustoestimado());
			ps.setDouble(15, registroSolicitacaoMudanca.getImpactoprazodias());
			ps.setString(16, registroSolicitacaoMudanca.getClassificacao());
			ps.setString(7, registroSolicitacaoMudanca.getResponsavel());
			ps.setString(18, registroSolicitacaoMudanca.getPrevisao());
			ps.setString(19, registroSolicitacaoMudanca.getStatus());
			ps.setObject(20, registroSolicitacaoMudanca.getComentarios());		
			ps.setObject(21, registroSolicitacaoMudanca.getSolicitacaomudanca().getCodigo());
			ps.setObject(22, registroSolicitacaoMudanca.getProjetoinicio().getCodigo());
			
			
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
	public List<RegistroSolicitacaoMudanca> getRegistroSolicitacaoMudancas() throws Exception  {
		
		   List<RegistroSolicitacaoMudanca> resultado = new ArrayList<RegistroSolicitacaoMudanca>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM registrosolicitacaomudanca";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					
					RegistroSolicitacaoMudanca registroSolicitacaoMudanca = new RegistroSolicitacaoMudanca();
					
					registroSolicitacaoMudanca.setVersao(rs.getString("versao"));
					registroSolicitacaoMudanca.setData(rs.getDate("data"));
					registroSolicitacaoMudanca.setAutor(rs.getString("autor"));
					registroSolicitacaoMudanca.setNotarevisao(rs.getString("notarevisao"));
					registroSolicitacaoMudanca.setAprovacao(rs.getString("aprovacao"));
					registroSolicitacaoMudanca.setReferencia(rs.getDouble("referencia"));				
					registroSolicitacaoMudanca.setPrioridade(rs.getString("prioridade"));					
					registroSolicitacaoMudanca.setImpedeimplantacao(rs.getString("impedeimplantacao"));
					registroSolicitacaoMudanca.setSolicitacao(rs.getString("solicitacao"));
					registroSolicitacaoMudanca.setDatasolicitacao(rs.getDate("datasolicitacao"));
					registroSolicitacaoMudanca.setDescricao(rs.getString("descricao"));
					registroSolicitacaoMudanca.setJustificativa(rs.getString("justificativa"));
					registroSolicitacaoMudanca.setEsforcoestimadohoras(rs.getDouble("esforcoestimadohoras"));
					registroSolicitacaoMudanca.setCustoestimado(rs.getDouble("custoestimado"));
					registroSolicitacaoMudanca.setImpactoprazodias(rs.getDouble("impactoprazodias"));					
					registroSolicitacaoMudanca.setClassificacao(rs.getString("classificacao"));
					registroSolicitacaoMudanca.setResponsavel(rs.getString("responsavel"));
					registroSolicitacaoMudanca.setPrevisao(rs.getString("previsao"));
					registroSolicitacaoMudanca.setStatus(rs.getString("status"));	
					registroSolicitacaoMudanca.setComentarios(rs.getString("comentarios"));
					registroSolicitacaoMudanca.setCodigo(rs.getLong("codigo"));
					
					registroSolicitacaoMudanca.getProjetoinicio().setCodigo(rs.getLong("codigo"));
					registroSolicitacaoMudanca.getSolicitacaomudanca().setCodigo(rs.getLong("codigo"));
									
					resultado.add(registroSolicitacaoMudanca);// Add o projeto ao resultado.
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

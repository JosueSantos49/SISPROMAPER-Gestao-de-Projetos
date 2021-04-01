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
import br.com.tkcsapcd.model.bean.PlanoGerenciamentoComunicacao;
import br.com.tkcsapcd.model.util.Conexao;

public class PlanoGerenciamentoComunicacaoDAO implements InterfacePlanoGerenciamentoComunicacaoDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public PlanoGerenciamentoComunicacaoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM planogerenciamentocomunicacao WHERE codigo = ?;";

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
	private void setPreparedStatement(PlanoGerenciamentoComunicacao planoGerenciamentoComunicacao, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, planoGerenciamentoComunicacao.getPlanogerenciamentocomunicacao());
		ps.setString(2, planoGerenciamentoComunicacao.getProjeto());
		ps.setInt(3, planoGerenciamentoComunicacao.getCodigoprojeto());
		ps.setString(4, planoGerenciamentoComunicacao.getVersao());
		ps.setString(5, planoGerenciamentoComunicacao.getData());
		ps.setString(6, planoGerenciamentoComunicacao.getAutor());
		ps.setString(7, planoGerenciamentoComunicacao.getNotarevisao());
		ps.setString(8, planoGerenciamentoComunicacao.getAprovacao());
		ps.setObject(9, planoGerenciamentoComunicacao.getObjetivo());
		ps.setString(10, planoGerenciamentoComunicacao.getProcesso());
		ps.setString(11, planoGerenciamentoComunicacao.getRequisito());		
		ps.setString(12, planoGerenciamentoComunicacao.getInformcacao());
		ps.setString(13, planoGerenciamentoComunicacao.getTecnologia());
		ps.setString(14, planoGerenciamentoComunicacao.getDiretrize());	
		ps.setString(15, planoGerenciamentoComunicacao.getComunicacao());
		ps.setString(16, planoGerenciamentoComunicacao.getGestao());
		ps.setString(17, planoGerenciamentoComunicacao.getStatus());
		ps.setString(18, planoGerenciamentoComunicacao.getGerenciareunioes());
		ps.setString(19, planoGerenciamentoComunicacao.getGerenciaquestoes());
		ps.setString(20, planoGerenciamentoComunicacao.getPlanoescalonamento());
		ps.setString(21, planoGerenciamentoComunicacao.getEventocomunicacao());
		ps.setObject(22, planoGerenciamentoComunicacao.getAnexo());
		ps.setInt(23, planoGerenciamentoComunicacao.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public PlanoGerenciamentoComunicacao getPlanoGerenciamentoComunicacao(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM planogerenciamentocomunicacao WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<PlanoGerenciamentoComunicacao> resultado = getListaPlanoGerenciamentoComunicacao(rs);
			
			if (resultado.size() > 0)			
				return resultado.get(0);//pegando elemento por chave (unico projeto!).			
			
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
		return null;
	}
	/*---------------------------------------------------------------------------------------------------------------------------------------*/

		//Metodo p confirma objetivo. Resulmir linhas de códigos, que pode ser usados em outros métodos. (ex: resultado = getListaCliente(rs); ou List<Cliente> resultado = getListaCliente(rs);)
		private List<PlanoGerenciamentoComunicacao> getListaPlanoGerenciamentoComunicacao(ResultSet rs) throws SQLException	{
			List<PlanoGerenciamentoComunicacao> resultado = new ArrayList<PlanoGerenciamentoComunicacao>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				PlanoGerenciamentoComunicacao planoGerenciamentoComunicacao = new PlanoGerenciamentoComunicacao();
				
				planoGerenciamentoComunicacao.setPlanogerenciamentocomunicacao(rs.getString("planogerenciamentocomunicacao"));
				planoGerenciamentoComunicacao.setProjeto(rs.getString("projeto"));
				planoGerenciamentoComunicacao.setCodigoprojeto(rs.getInt("codigoprojeto"));
				planoGerenciamentoComunicacao.setVersao(rs.getString("versao"));
				planoGerenciamentoComunicacao.setData(rs.getString("data"));
				planoGerenciamentoComunicacao.setAutor(rs.getString("autor"));
				planoGerenciamentoComunicacao.setNotarevisao(rs.getString("notarevisao"));
				planoGerenciamentoComunicacao.setAprovacao(rs.getString("aprovacao"));
				planoGerenciamentoComunicacao.setObjetivo(rs.getString("objetivo"));				
				planoGerenciamentoComunicacao.setProcesso(rs.getString("processo"));					
				planoGerenciamentoComunicacao.setRequisito(rs.getString("requisito"));
				planoGerenciamentoComunicacao.setInformcacao(rs.getString("informcacao"));
				planoGerenciamentoComunicacao.setTecnologia(rs.getString("tecnologia"));
				planoGerenciamentoComunicacao.setDiretrize(rs.getString("diretrize"));
				planoGerenciamentoComunicacao.setComunicacao(rs.getString("eventocomunicacao"));
				planoGerenciamentoComunicacao.setGestao(rs.getString("gestao"));
				planoGerenciamentoComunicacao.setStatus(rs.getString("status"));
				planoGerenciamentoComunicacao.setGerenciareunioes(rs.getString("gerenciareunioes"));					
				planoGerenciamentoComunicacao.setGerenciaquestoes(rs.getString("gerenciaquestoes"));
				planoGerenciamentoComunicacao.setPlanoescalonamento(rs.getString("planoescalonamento"));
				planoGerenciamentoComunicacao.setEventocomunicacao(rs.getString("eventocomunicacao"));
				planoGerenciamentoComunicacao.setAnexo(rs.getString("anexo"));
				planoGerenciamentoComunicacao.setCodigo(rs.getInt("codigo"));
												
				resultado.add(planoGerenciamentoComunicacao);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(PlanoGerenciamentoComunicacao planoGerenciamentoComunicacao) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			
			String sqlAtualizar = "UPDATE planogerenciamentocomunicacao SET planogerenciamentocomunicacao = ?, projeto = ?, codigoprojeto = ?, versao = ?, data = ?, autor = ?, notarevisao = ?, aprovacao = ?, objetivo = ?, processo = ?, requisito = ?, informcacao = ?, tecnologia = ?, diretrize = ?, comunicacao = ?, gestao = ?, status = ?, gerenciareunioes = ?, gerenciaquestoes = ?, planoescalonamento = ?, eventocomunicacao = ?, anexo = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(planoGerenciamentoComunicacao, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(PlanoGerenciamentoComunicacao planoGerenciamentoComunicacao) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO planogerenciamentocomunicacao(planogerenciamentocomunicacao, projeto, codigoprojeto, versao, data, autor, notarevisao, aprovacao, objetivo, processo, requisito, informcacao, tecnologia, diretrize, comunicacao, gestao, status, gerenciareunioes, gerenciaquestoes, planoescalonamento, eventocomunicacao, anexo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, planoGerenciamentoComunicacao.getPlanogerenciamentocomunicacao());
			ps.setString(2, planoGerenciamentoComunicacao.getProjeto());
			ps.setInt(3, planoGerenciamentoComunicacao.getCodigoprojeto());
			ps.setString(4, planoGerenciamentoComunicacao.getVersao());
			ps.setString(5, planoGerenciamentoComunicacao.getData());
			ps.setString(6, planoGerenciamentoComunicacao.getAutor());
			ps.setString(7, planoGerenciamentoComunicacao.getNotarevisao());
			ps.setString(8, planoGerenciamentoComunicacao.getAprovacao());
			ps.setObject(9, planoGerenciamentoComunicacao.getObjetivo());
			ps.setString(10, planoGerenciamentoComunicacao.getProcesso());
			ps.setString(11, planoGerenciamentoComunicacao.getRequisito());		
			ps.setString(12, planoGerenciamentoComunicacao.getInformcacao());
			ps.setString(13, planoGerenciamentoComunicacao.getTecnologia());
			ps.setString(14, planoGerenciamentoComunicacao.getDiretrize());	
			ps.setString(15, planoGerenciamentoComunicacao.getComunicacao());
			ps.setString(16, planoGerenciamentoComunicacao.getGestao());
			ps.setString(17, planoGerenciamentoComunicacao.getStatus());
			ps.setString(18, planoGerenciamentoComunicacao.getGerenciareunioes());
			ps.setString(19, planoGerenciamentoComunicacao.getGerenciaquestoes());
			ps.setString(20, planoGerenciamentoComunicacao.getPlanoescalonamento());
			ps.setString(21, planoGerenciamentoComunicacao.getEventocomunicacao());
			ps.setObject(22, planoGerenciamentoComunicacao.getAnexo());			
			
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
	public List<PlanoGerenciamentoComunicacao> getPlanoGerenciamentoComunicacaos() throws Exception {
		
		   List<PlanoGerenciamentoComunicacao> resultado = new ArrayList<PlanoGerenciamentoComunicacao>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs =null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM planogerenciamentocomunicacao";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					PlanoGerenciamentoComunicacao planoGerenciamentoComunicacao = new PlanoGerenciamentoComunicacao();
				
					planoGerenciamentoComunicacao.setPlanogerenciamentocomunicacao(rs.getString("planogerenciamentocomunicacao"));
					planoGerenciamentoComunicacao.setProjeto(rs.getString("projeto"));
					planoGerenciamentoComunicacao.setCodigoprojeto(rs.getInt("codigoprojeto"));
					planoGerenciamentoComunicacao.setVersao(rs.getString("versao"));
					planoGerenciamentoComunicacao.setData(rs.getString("data"));
					planoGerenciamentoComunicacao.setAutor(rs.getString("autor"));
					planoGerenciamentoComunicacao.setNotarevisao(rs.getString("notarevisao"));
					planoGerenciamentoComunicacao.setAprovacao(rs.getString("aprovacao"));
					planoGerenciamentoComunicacao.setObjetivo(rs.getString("objetivo"));				
					planoGerenciamentoComunicacao.setProcesso(rs.getString("processo"));					
					planoGerenciamentoComunicacao.setRequisito(rs.getString("requisito"));
					planoGerenciamentoComunicacao.setInformcacao(rs.getString("informcacao"));
					planoGerenciamentoComunicacao.setTecnologia(rs.getString("tecnologia"));
					planoGerenciamentoComunicacao.setDiretrize(rs.getString("diretrize"));
					planoGerenciamentoComunicacao.setComunicacao(rs.getString("eventocomunicacao"));
					planoGerenciamentoComunicacao.setGestao(rs.getString("gestao"));
					planoGerenciamentoComunicacao.setStatus(rs.getString("status"));
					planoGerenciamentoComunicacao.setGerenciareunioes(rs.getString("gerenciareunioes"));					
					planoGerenciamentoComunicacao.setGerenciaquestoes(rs.getString("gerenciaquestoes"));
					planoGerenciamentoComunicacao.setPlanoescalonamento(rs.getString("planoescalonamento"));
					planoGerenciamentoComunicacao.setEventocomunicacao(rs.getString("eventocomunicacao"));
					planoGerenciamentoComunicacao.setAnexo(rs.getString("anexo"));
					planoGerenciamentoComunicacao.setCodigo(rs.getInt("codigo"));
									
					resultado.add(planoGerenciamentoComunicacao);// Add o projeto ao resultado.
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

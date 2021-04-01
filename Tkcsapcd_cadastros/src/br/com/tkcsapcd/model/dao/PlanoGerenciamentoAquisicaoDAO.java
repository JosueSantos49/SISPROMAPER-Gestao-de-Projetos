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
import br.com.tkcsapcd.model.bean.PlanoGerenciamentoAquisicao;
import br.com.tkcsapcd.model.util.Conexao;

public class PlanoGerenciamentoAquisicaoDAO implements InterfacePlanoGerenciamentoAquisicaoDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public PlanoGerenciamentoAquisicaoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception   {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM planogerenciamentoaquisicao WHERE codigo = ?;";

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
	public PlanoGerenciamentoAquisicao getPlanoGerenciamentoAquisicao(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM planogerenciamentoaquisicao WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<PlanoGerenciamentoAquisicao> resultado = getListaPlanoGerenciamentoAquisicao(rs);
			
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
		private List<PlanoGerenciamentoAquisicao> getListaPlanoGerenciamentoAquisicao(ResultSet rs) throws SQLException	{
			List<PlanoGerenciamentoAquisicao> resultado = new ArrayList<PlanoGerenciamentoAquisicao>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				PlanoGerenciamentoAquisicao planoGerenciamentoAquisicao = new PlanoGerenciamentoAquisicao();
				
				planoGerenciamentoAquisicao.setPlanogerenciamentoaquisicao(rs.getString("planogerenciamentoaquisicao"));
				planoGerenciamentoAquisicao.setProjeto(rs.getString("projeto"));
				planoGerenciamentoAquisicao.setCodigoprojeto(rs.getString("codigoprojeto"));
				planoGerenciamentoAquisicao.setVersao(rs.getString("versao"));
				planoGerenciamentoAquisicao.setData(rs.getString("data"));
				planoGerenciamentoAquisicao.setAutor(rs.getString("autor"));
				planoGerenciamentoAquisicao.setNotarevisao(rs.getString("notarevisao"));
				planoGerenciamentoAquisicao.setAprovacao(rs.getString("aprovacao"));
				planoGerenciamentoAquisicao.setObjetivo(rs.getString("objetivo"));	
				planoGerenciamentoAquisicao.setMetodo(rs.getString("metodo"));	
				planoGerenciamentoAquisicao.setProcesso(rs.getString("processo"));
				planoGerenciamentoAquisicao.setDecisoes(rs.getString("decisoes"));
				planoGerenciamentoAquisicao.setDocumento(rs.getString("documento"));
				planoGerenciamentoAquisicao.setResponsabilidade(rs.getString("responsabilidade"));
				planoGerenciamentoAquisicao.setMetrica(rs.getString("metrica"));					
				planoGerenciamentoAquisicao.setPremissarestricao(rs.getString("premissarestricao"));
				planoGerenciamentoAquisicao.setRiscos(rs.getString("riscos"));
				planoGerenciamentoAquisicao.setFornecedor(rs.getString("fornecedor"));					
				planoGerenciamentoAquisicao.setConduziraquisicao(rs.getString("conduziraquisicao"));
				planoGerenciamentoAquisicao.setTipocontrato(rs.getString("tipocontrato"));
				planoGerenciamentoAquisicao.setCriterioavaliacao(rs.getString("criterioavaliacao"));
				planoGerenciamentoAquisicao.setControlaaquisicao(rs.getString("controlaaquisicao"));	
				planoGerenciamentoAquisicao.setAvalicacaofornecedor(rs.getString("avalicacaofornecedor"));
				planoGerenciamentoAquisicao.setEncerraraquisicao(rs.getString("encerraraquisicao"));
				planoGerenciamentoAquisicao.setCodigo(rs.getInt("codigo"));
												
				resultado.add(planoGerenciamentoAquisicao);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(PlanoGerenciamentoAquisicao planoGerenciamentoAquisicao) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = 	"UPDATE planogerenciamentoaquisicao SET planogerenciamentoaquisicao = ?, projeto = ?, codigoprojeto = ?, versao = ?, data = ?, autor = ?," +
									" notarevisao = ?, aprovacao = ?, objetivo = ?, metodo = ?, processo = ?, decisoes = ?, documento = ?, responsabilidade = ?, metrica = ?," +
									" premissarestricao = ?, riscos = ?, fornecedor = ?, conduziraquisicao = ?, tipocontrato = ?, criterioavaliacao = ?, controlaaquisicao = ?, avalicacaofornecedor = ?, encerraraquisicao = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(planoGerenciamentoAquisicao, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	private void setPreparedStatement(PlanoGerenciamentoAquisicao planoGerenciamentoAquisicao, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, planoGerenciamentoAquisicao.getPlanogerenciamentoaquisicao());
		ps.setString(2, planoGerenciamentoAquisicao.getProjeto());
		ps.setString(3, planoGerenciamentoAquisicao.getCodigoprojeto());
		ps.setString(4, planoGerenciamentoAquisicao.getVersao());
		ps.setString(5, planoGerenciamentoAquisicao.getData());
		ps.setString(6, planoGerenciamentoAquisicao.getAutor());
		ps.setString(7, planoGerenciamentoAquisicao.getNotarevisao());
		ps.setString(8, planoGerenciamentoAquisicao.getAprovacao());
		ps.setObject(9, planoGerenciamentoAquisicao.getObjetivo());
		ps.setString(10, planoGerenciamentoAquisicao.getMetodo());
		ps.setString(11, planoGerenciamentoAquisicao.getProcesso());		
		ps.setString(12, planoGerenciamentoAquisicao.getDecisoes());
		ps.setString(13, planoGerenciamentoAquisicao.getDocumento());
		ps.setString(14, planoGerenciamentoAquisicao.getResponsabilidade());	
		ps.setString(15, planoGerenciamentoAquisicao.getMetrica());
		ps.setString(16, planoGerenciamentoAquisicao.getPremissarestricao());
		ps.setString(17, planoGerenciamentoAquisicao.getRiscos());
		ps.setString(18, planoGerenciamentoAquisicao.getFornecedor());
		ps.setString(19, planoGerenciamentoAquisicao.getConduziraquisicao());
		ps.setString(20, planoGerenciamentoAquisicao.getTipocontrato());
		ps.setString(21, planoGerenciamentoAquisicao.getCriterioavaliacao());
		ps.setString(22, planoGerenciamentoAquisicao.getControlaaquisicao());
		ps.setString(23, planoGerenciamentoAquisicao.getAvalicacaofornecedor());
		ps.setObject(24, planoGerenciamentoAquisicao.getEncerraraquisicao());
		ps.setInt(25, planoGerenciamentoAquisicao.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public void salvar(PlanoGerenciamentoAquisicao planoGerenciamentoAquisicao) throws Exception  {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO planogerenciamentoaquisicao(planogerenciamentoaquisicao, projeto, codigoprojeto, versao, data, autor, notarevisao, aprovacao, objetivo, metodo, processo, decisoes, documento, responsabilidade, metrica, premissarestricao, riscos, fornecedor, conduziraquisicao, tipocontrato, criterioavaliacao, controlaaquisicao, avalicacaofornecedor, encerraraquisicao) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, planoGerenciamentoAquisicao.getPlanogerenciamentoaquisicao());
			ps.setString(2, planoGerenciamentoAquisicao.getProjeto());
			ps.setString(3, planoGerenciamentoAquisicao.getCodigoprojeto());
			ps.setString(4, planoGerenciamentoAquisicao.getVersao());
			ps.setString(5, planoGerenciamentoAquisicao.getData());
			ps.setString(6, planoGerenciamentoAquisicao.getAutor());
			ps.setString(7, planoGerenciamentoAquisicao.getNotarevisao());
			ps.setString(8, planoGerenciamentoAquisicao.getAprovacao());
			ps.setObject(9, planoGerenciamentoAquisicao.getObjetivo());
			ps.setString(10, planoGerenciamentoAquisicao.getMetodo());
			ps.setString(11, planoGerenciamentoAquisicao.getProcesso());		
			ps.setString(12, planoGerenciamentoAquisicao.getDecisoes());
			ps.setString(13, planoGerenciamentoAquisicao.getDocumento());
			ps.setString(14, planoGerenciamentoAquisicao.getResponsabilidade());	
			ps.setString(15, planoGerenciamentoAquisicao.getMetrica());
			ps.setString(16, planoGerenciamentoAquisicao.getPremissarestricao());
			ps.setString(17, planoGerenciamentoAquisicao.getRiscos());
			ps.setString(18, planoGerenciamentoAquisicao.getFornecedor());
			ps.setString(19, planoGerenciamentoAquisicao.getConduziraquisicao());
			ps.setString(20, planoGerenciamentoAquisicao.getTipocontrato());
			ps.setString(21, planoGerenciamentoAquisicao.getCriterioavaliacao());
			ps.setString(22, planoGerenciamentoAquisicao.getControlaaquisicao());
			ps.setString(23, planoGerenciamentoAquisicao.getAvalicacaofornecedor());
			ps.setObject(24, planoGerenciamentoAquisicao.getEncerraraquisicao());			
			
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
	public List<PlanoGerenciamentoAquisicao> getPlanoGerenciamentoAquisicaos() throws Exception  {
		
		   List<PlanoGerenciamentoAquisicao> resultado = new ArrayList<PlanoGerenciamentoAquisicao>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM planogerenciamentoaquisicao";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					PlanoGerenciamentoAquisicao planoGerenciamentoAquisicao = new PlanoGerenciamentoAquisicao();
				
					planoGerenciamentoAquisicao.setPlanogerenciamentoaquisicao(rs.getString("planogerenciamentoaquisicao"));
					planoGerenciamentoAquisicao.setProjeto(rs.getString("projeto"));
					planoGerenciamentoAquisicao.setCodigoprojeto(rs.getString("codigoprojeto"));
					planoGerenciamentoAquisicao.setVersao(rs.getString("versao"));
					planoGerenciamentoAquisicao.setData(rs.getString("data"));
					planoGerenciamentoAquisicao.setAutor(rs.getString("autor"));
					planoGerenciamentoAquisicao.setNotarevisao(rs.getString("notarevisao"));
					planoGerenciamentoAquisicao.setAprovacao(rs.getString("aprovacao"));
					planoGerenciamentoAquisicao.setObjetivo(rs.getString("objetivo"));
					planoGerenciamentoAquisicao.setMetodo(rs.getString("metodo"));
					planoGerenciamentoAquisicao.setProcesso(rs.getString("processo"));
					planoGerenciamentoAquisicao.setDecisoes(rs.getString("decisoes"));
					planoGerenciamentoAquisicao.setDocumento(rs.getString("documento"));
					planoGerenciamentoAquisicao.setResponsabilidade(rs.getString("responsabilidade"));
					planoGerenciamentoAquisicao.setMetrica(rs.getString("metrica"));					
					planoGerenciamentoAquisicao.setPremissarestricao(rs.getString("premissarestricao"));
					planoGerenciamentoAquisicao.setRiscos(rs.getString("riscos"));
					planoGerenciamentoAquisicao.setFornecedor(rs.getString("fornecedor"));					
					planoGerenciamentoAquisicao.setConduziraquisicao(rs.getString("conduziraquisicao"));
					planoGerenciamentoAquisicao.setTipocontrato(rs.getString("tipocontrato"));
					planoGerenciamentoAquisicao.setCriterioavaliacao(rs.getString("criterioavaliacao"));
					planoGerenciamentoAquisicao.setControlaaquisicao(rs.getString("controlaaquisicao"));	
					planoGerenciamentoAquisicao.setAvalicacaofornecedor(rs.getString("avalicacaofornecedor"));
					planoGerenciamentoAquisicao.setEncerraraquisicao(rs.getString("encerraraquisicao"));
					planoGerenciamentoAquisicao.setCodigo(rs.getInt("codigo"));
									
					resultado.add(planoGerenciamentoAquisicao);// Add o projeto ao resultado.
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

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
import br.com.tkcsapcd.model.bean.TransicaoProduto;
import br.com.tkcsapcd.model.util.Conexao;

public class TransicaoProdutoDAO implements InterfaceTransicaoProdutoDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public TransicaoProdutoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM transicaoproduto WHERE codigo = ?;";

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
	private void setPreparedStatement(TransicaoProduto transicaoProduto, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, transicaoProduto.getTransicaoproduto());
		ps.setString(2, transicaoProduto.getProjeto());
		ps.setInt(3, transicaoProduto.getCodigoprojeto());
		ps.setString(4, transicaoProduto.getVersao());
		ps.setString(5, transicaoProduto.getData());
		ps.setString(6, transicaoProduto.getAutor());
		ps.setString(7, transicaoProduto.getNotarevisao());
		ps.setString(8, transicaoProduto.getAprovacao());
		ps.setObject(9, transicaoProduto.getObjetivo());
		ps.setString(10, transicaoProduto.getPeriodo());
		ps.setString(11, transicaoProduto.getProcedimento());		
		ps.setString(12, transicaoProduto.getTreinamento());
		ps.setString(13, transicaoProduto.getResponsavelprojeto());
		ps.setString(14, transicaoProduto.getResponsaveloperacao());	
		ps.setString(15, transicaoProduto.getPontoaberto());
		ps.setString(16, transicaoProduto.getRecomendacao());		
		ps.setInt(17, transicaoProduto.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public TransicaoProduto getTransicaoProduto(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM transicaoproduto WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<TransicaoProduto> resultado = getListaTransicaoProduto(rs);
			
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
		private List<TransicaoProduto> getListaTransicaoProduto(ResultSet rs) throws SQLException	{
			List<TransicaoProduto> resultado = new ArrayList<TransicaoProduto>();
			
			// Laço p/ preencher
			while (rs.next()) {

				TransicaoProduto transicaoProduto = new TransicaoProduto();
			
				transicaoProduto.setTransicaoproduto(rs.getString("transicaoproduto"));
				transicaoProduto.setProjeto(rs.getString("projeto"));
				transicaoProduto.setCodigoprojeto(rs.getInt("codigoprojeto"));
				transicaoProduto.setVersao(rs.getString("versao"));
				transicaoProduto.setData(rs.getString("data"));
				transicaoProduto.setAutor(rs.getString("autor"));
				transicaoProduto.setNotarevisao(rs.getString("notarevisao"));
				transicaoProduto.setAprovacao(rs.getString("aprovacao"));
				transicaoProduto.setObjetivo(rs.getString("objetivo"));				
				transicaoProduto.setPeriodo(rs.getString("periodo"));					
				transicaoProduto.setProcedimento(rs.getString("procedimento"));
				transicaoProduto.setTreinamento(rs.getString("treinamento"));
				transicaoProduto.setResponsavelprojeto(rs.getString("responsavelprojeto"));
				transicaoProduto.setResponsaveloperacao(rs.getString("responsaveloperacao"));
				transicaoProduto.setPontoaberto(rs.getString("pontoaberto"));
				transicaoProduto.setRecomendacao(rs.getString("recomendacao"));
				transicaoProduto.setCodigo(rs.getInt("codigo"));
												
				resultado.add(transicaoProduto);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(TransicaoProduto transicaoProduto) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE transicaoproduto SET transicaoproduto = ?, projeto = ?, codigoprojeto = ?, versao = ?, data = ?, autor = ?, notarevisao = ?, aprovacao = ?, objetivo = ?, periodo = ?, procedimento = ?, treinamento = ?, responsavelprojeto = ?, responsaveloperacao = ?, pontoaberto = ?, recomendacao = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(transicaoProduto, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(TransicaoProduto transicaoProduto) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO transicaoproduto(transicaoproduto, projeto, codigoprojeto, versao, data, autor, notarevisao, aprovacao, objetivo, periodo, procedimento, treinamento, responsavelprojeto, responsaveloperacao, pontoaberto, recomendacao) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);
			
			ps.setString(1, transicaoProduto.getTransicaoproduto());
			ps.setString(2, transicaoProduto.getProjeto());
			ps.setInt(3, transicaoProduto.getCodigoprojeto());
			ps.setString(4, transicaoProduto.getVersao());
			ps.setString(5, transicaoProduto.getData());
			ps.setString(6, transicaoProduto.getAutor());
			ps.setString(7, transicaoProduto.getNotarevisao());
			ps.setString(8, transicaoProduto.getAprovacao());
			ps.setObject(9, transicaoProduto.getObjetivo());
			ps.setString(10, transicaoProduto.getPeriodo());
			ps.setString(11, transicaoProduto.getProcedimento());		
			ps.setString(12, transicaoProduto.getTreinamento());
			ps.setString(13, transicaoProduto.getResponsavelprojeto());
			ps.setString(14, transicaoProduto.getResponsaveloperacao());	
			ps.setString(15, transicaoProduto.getPontoaberto());
			ps.setString(16, transicaoProduto.getRecomendacao());
			
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
	public List<TransicaoProduto> getTransicaoProdutos() throws Exception {
		
		   List<TransicaoProduto> resultado = new ArrayList<TransicaoProduto>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM transicaoproduto";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					
					TransicaoProduto transicaoProduto = new TransicaoProduto();
				
					transicaoProduto.setTransicaoproduto(rs.getString("transicaoproduto"));
					transicaoProduto.setProjeto(rs.getString("projeto"));
					transicaoProduto.setCodigoprojeto(rs.getInt("codigoprojeto"));
					transicaoProduto.setVersao(rs.getString("versao"));
					transicaoProduto.setData(rs.getString("data"));
					transicaoProduto.setAutor(rs.getString("autor"));
					transicaoProduto.setNotarevisao(rs.getString("notarevisao"));
					transicaoProduto.setAprovacao(rs.getString("aprovacao"));
					transicaoProduto.setObjetivo(rs.getString("objetivo"));				
					transicaoProduto.setPeriodo(rs.getString("periodo"));					
					transicaoProduto.setProcedimento(rs.getString("procedimento"));
					transicaoProduto.setTreinamento(rs.getString("treinamento"));
					transicaoProduto.setResponsavelprojeto(rs.getString("responsavelprojeto"));
					transicaoProduto.setResponsaveloperacao(rs.getString("responsaveloperacao"));
					transicaoProduto.setPontoaberto(rs.getString("pontoaberto"));
					transicaoProduto.setRecomendacao(rs.getString("recomendacao"));
					transicaoProduto.setCodigo(rs.getInt("codigo"));
									
					resultado.add(transicaoProduto);// Add o projeto ao resultado.
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

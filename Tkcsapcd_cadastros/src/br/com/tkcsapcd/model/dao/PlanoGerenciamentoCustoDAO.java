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
import br.com.tkcsapcd.model.bean.PlanoGerenciamentoCusto;
import br.com.tkcsapcd.model.util.Conexao;

public class PlanoGerenciamentoCustoDAO implements InterfacePlanoGerenciamentoCustoDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public PlanoGerenciamentoCustoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM planogerenciamentocusto WHERE codigo = ?;";

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
	private void setPreparedStatement(PlanoGerenciamentoCusto planoGerenciamentoCusto, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, planoGerenciamentoCusto.getPlanogerenciamentocusto());
		ps.setString(2, planoGerenciamentoCusto.getProjeto());
		ps.setInt(3, planoGerenciamentoCusto.getCodigoprojeto());
		ps.setString(4, planoGerenciamentoCusto.getVersao());
		ps.setString(5, planoGerenciamentoCusto.getData());
		ps.setString(6, planoGerenciamentoCusto.getAutor());
		ps.setString(7, planoGerenciamentoCusto.getNotarevisao());
		ps.setString(8, planoGerenciamentoCusto.getAprovacao());
		ps.setObject(9, planoGerenciamentoCusto.getObjetivo());
		ps.setString(10, planoGerenciamentoCusto.getMetodo());
		ps.setString(11, planoGerenciamentoCusto.getProcesso());		
		ps.setString(12, planoGerenciamentoCusto.getDocumento());
		ps.setString(13, planoGerenciamentoCusto.getFerramenta());
		ps.setString(14, planoGerenciamentoCusto.getPapeis());	
		ps.setString(15, planoGerenciamentoCusto.getPlano());
		ps.setString(16, planoGerenciamentoCusto.getCusto());
		ps.setString(17, planoGerenciamentoCusto.getOrcamento());
		ps.setString(18, planoGerenciamentoCusto.getControlarcusto());
		ps.setInt(19, planoGerenciamentoCusto.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public PlanoGerenciamentoCusto getPlanoGerenciamentoCusto(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM planogerenciamentocusto WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<PlanoGerenciamentoCusto> resultado = getListaPlanoGerenciamentoCusto(rs);
			
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
		private List<PlanoGerenciamentoCusto> getListaPlanoGerenciamentoCusto(ResultSet rs) throws SQLException	{
			List<PlanoGerenciamentoCusto> resultado = new ArrayList<PlanoGerenciamentoCusto>();
			
			// Laço p/ preencher
			while (rs.next()) {

				PlanoGerenciamentoCusto planoGerenciamentoCusto = new PlanoGerenciamentoCusto();
				
				planoGerenciamentoCusto.setPlanogerenciamentocusto(rs.getString("planogerenciamentocusto"));
				planoGerenciamentoCusto.setProjeto(rs.getString("projeto"));
				planoGerenciamentoCusto.setCodigoprojeto(rs.getInt("codigoprojeto"));
				planoGerenciamentoCusto.setVersao(rs.getString("versao"));
				planoGerenciamentoCusto.setData(rs.getString("data"));
				planoGerenciamentoCusto.setAutor(rs.getString("autor"));
				planoGerenciamentoCusto.setNotarevisao(rs.getString("notarevisao"));
				planoGerenciamentoCusto.setAprovacao(rs.getString("aprovacao"));
				planoGerenciamentoCusto.setObjetivo(rs.getString("objetivo"));				
				planoGerenciamentoCusto.setMetodo(rs.getString("metodo"));					
				planoGerenciamentoCusto.setProcesso(rs.getString("processo"));
				planoGerenciamentoCusto.setDocumento(rs.getString("documento"));
				planoGerenciamentoCusto.setFerramenta(rs.getString("ferramenta"));
				planoGerenciamentoCusto.setPapeis(rs.getString("papeis"));
				planoGerenciamentoCusto.setPlano(rs.getString("plano"));
				planoGerenciamentoCusto.setCusto(rs.getString("custo"));
				planoGerenciamentoCusto.setOrcamento(rs.getString("orcamento"));
				planoGerenciamentoCusto.setControlarcusto(rs.getString("controlarcusto"));
				planoGerenciamentoCusto.setCodigo(rs.getInt("codigo"));
												
				resultado.add(planoGerenciamentoCusto);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(PlanoGerenciamentoCusto planoGerenciamentoCusto) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE planogerenciamentocusto SET 	planogerenciamentocusto = ?, projeto = ?, codigoprojeto = ?, versao = ?, data = ?, autor = ?, notarevisao = ?, aprovacao = ?, objetivo = ?, metodo = ?, processo = ?, documento = ?, ferramenta = ?, papeis = ?, plano = ?, custo = ?, orcamento = ?, controlarcusto = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(planoGerenciamentoCusto, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(PlanoGerenciamentoCusto planoGerenciamentoCusto) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO planogerenciamentocusto(planogerenciamentocusto, projeto, codigoprojeto, versao, data, autor, notarevisao, aprovacao, objetivo, metodo, processo, documento, ferramenta, papeis, plano, custo, orcamento, controlarcusto) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, planoGerenciamentoCusto.getPlanogerenciamentocusto());
			ps.setString(2, planoGerenciamentoCusto.getProjeto());
			ps.setInt(3, planoGerenciamentoCusto.getCodigoprojeto());
			ps.setString(4, planoGerenciamentoCusto.getVersao());
			ps.setString(5, planoGerenciamentoCusto.getData());
			ps.setString(6, planoGerenciamentoCusto.getAutor());
			ps.setString(7, planoGerenciamentoCusto.getNotarevisao());
			ps.setString(8, planoGerenciamentoCusto.getAprovacao());
			ps.setObject(9, planoGerenciamentoCusto.getObjetivo());
			ps.setString(10, planoGerenciamentoCusto.getMetodo());
			ps.setString(11, planoGerenciamentoCusto.getProcesso());		
			ps.setString(12, planoGerenciamentoCusto.getDocumento());
			ps.setString(13, planoGerenciamentoCusto.getFerramenta());
			ps.setString(14, planoGerenciamentoCusto.getPapeis());	
			ps.setString(15, planoGerenciamentoCusto.getPlano());
			ps.setString(16, planoGerenciamentoCusto.getCusto());
			ps.setString(17, planoGerenciamentoCusto.getOrcamento());
			ps.setString(18, planoGerenciamentoCusto.getControlarcusto());
			
			
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
	public List<PlanoGerenciamentoCusto> getPlanoGerenciamentoCustos() throws Exception  {
		
		   List<PlanoGerenciamentoCusto> resultado = new ArrayList<PlanoGerenciamentoCusto>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM planogerenciamentocusto";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {

					PlanoGerenciamentoCusto planoGerenciamentoCusto = new PlanoGerenciamentoCusto();
					
					planoGerenciamentoCusto.setPlanogerenciamentocusto(rs.getString("planogerenciamentocusto"));
					planoGerenciamentoCusto.setProjeto(rs.getString("projeto"));
					planoGerenciamentoCusto.setCodigoprojeto(rs.getInt("codigoprojeto"));
					planoGerenciamentoCusto.setVersao(rs.getString("versao"));
					planoGerenciamentoCusto.setData(rs.getString("data"));
					planoGerenciamentoCusto.setAutor(rs.getString("autor"));
					planoGerenciamentoCusto.setNotarevisao(rs.getString("notarevisao"));
					planoGerenciamentoCusto.setAprovacao(rs.getString("aprovacao"));
					planoGerenciamentoCusto.setObjetivo(rs.getString("objetivo"));				
					planoGerenciamentoCusto.setMetodo(rs.getString("metodo"));					
					planoGerenciamentoCusto.setProcesso(rs.getString("processo"));
					planoGerenciamentoCusto.setDocumento(rs.getString("documento"));
					planoGerenciamentoCusto.setFerramenta(rs.getString("ferramenta"));
					planoGerenciamentoCusto.setPapeis(rs.getString("papeis"));
					planoGerenciamentoCusto.setPlano(rs.getString("plano"));
					planoGerenciamentoCusto.setCusto(rs.getString("custo"));
					planoGerenciamentoCusto.setOrcamento(rs.getString("orcamento"));
					planoGerenciamentoCusto.setControlarcusto(rs.getString("controlarcusto"));
					planoGerenciamentoCusto.setCodigo(rs.getInt("codigo"));
									
					resultado.add(planoGerenciamentoCusto);// Add o projeto ao resultado.
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

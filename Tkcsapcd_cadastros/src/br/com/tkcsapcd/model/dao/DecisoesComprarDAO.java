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
import br.com.tkcsapcd.model.bean.DecisoesComprar;
import br.com.tkcsapcd.model.util.Conexao;

public class DecisoesComprarDAO implements InterfaceDecisoesComprarDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public DecisoesComprarDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM decisoescomprar WHERE codigo = ?;";

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
	private void setPreparedStatement(DecisoesComprar decisoesComprar, PreparedStatement ps) throws SQLException 
	{
		ps.setInt(1, decisoesComprar.getImportancia());
		ps.setInt(2, decisoesComprar.getCodigoeap());
		ps.setString(3, decisoesComprar.getItens());
		ps.setString(4, decisoesComprar.getUrgencia());
		ps.setString(5, decisoesComprar.getImpacto());
		ps.setString(6, decisoesComprar.getMotivodecisao());
		ps.setString(7, decisoesComprar.getFornecedores());
		ps.setDouble(8, decisoesComprar.getQuantidade());
		ps.setObject(9, decisoesComprar.getCusto());
		ps.setString(10, decisoesComprar.getPrevisao());
		ps.setString(11, decisoesComprar.getDocaquisicao());		
		ps.setString(12, decisoesComprar.getDescricao());
		ps.setString(13, decisoesComprar.getTipocontrato());
		ps.setString(14, decisoesComprar.getStatus());	
		ps.setString(15, decisoesComprar.getComentarios());
		ps.setInt(16, decisoesComprar.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public DecisoesComprar getDecisoesComprar(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM decisoescomprar WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<DecisoesComprar> resultado = getListaDecisoesComprar(rs);
			
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
		private List<DecisoesComprar> getListaDecisoesComprar(ResultSet rs) throws SQLException	{
				List<DecisoesComprar> resultado = new ArrayList<DecisoesComprar>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				DecisoesComprar decisoesComprar = new DecisoesComprar();
				
				decisoesComprar.setImportancia(rs.getInt("importancia"));
				decisoesComprar.setCodigoeap(rs.getInt("codigoeap"));
				decisoesComprar.setItens(rs.getString("itens"));
				decisoesComprar.setUrgencia(rs.getString("urgencia"));
				decisoesComprar.setImpacto(rs.getString("impacto"));
				decisoesComprar.setMotivodecisao(rs.getString("motivodecisao"));
				decisoesComprar.setFornecedores(rs.getString("fornecedores"));
				decisoesComprar.setQuantidade(rs.getInt("quantidade"));
				decisoesComprar.setCusto(rs.getDouble("custo"));				
				decisoesComprar.setPrevisao(rs.getString("previsao"));					
				decisoesComprar.setDocaquisicao(rs.getString("docaquisicao"));
				decisoesComprar.setDescricao(rs.getString("descricao"));
				decisoesComprar.setTipocontrato(rs.getString("tipocontrato"));
				decisoesComprar.setStatus(rs.getString("status"));
				decisoesComprar.setComentarios(rs.getString("comentarios"));
				decisoesComprar.setCodigo(rs.getInt("codigo"));
												
				resultado.add(decisoesComprar);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(DecisoesComprar decisoesComprar) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE decisoescomprar SET importancia = ?, codigoeap = ?, itens = ?, urgencia = ?, impacto = ?, motivodecisao = ?, fornecedores = ?, quantidade = ?, custo = ?, previsao = ?, docaquisicao = ?, descricao = ?, tipocontrato = ?, status = ?, comentarios  = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(decisoesComprar, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(DecisoesComprar decisoesComprar) throws Exception  {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO decisoescomprar(importancia, codigoeap, itens, urgencia, impacto, motivodecisao, fornecedores, quantidade, custo, previsao, docaquisicao, descricao, tipocontrato, status, comentarios) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
						
			ps.setInt(1, decisoesComprar.getImportancia());
			ps.setInt(2, decisoesComprar.getCodigoeap());
			ps.setString(3, decisoesComprar.getItens());
			ps.setString(4, decisoesComprar.getUrgencia());
			ps.setString(5, decisoesComprar.getImpacto());
			ps.setString(6, decisoesComprar.getMotivodecisao());
			ps.setString(7, decisoesComprar.getFornecedores());
			ps.setInt(8, decisoesComprar.getQuantidade());
			ps.setDouble(9, decisoesComprar.getCusto());
			ps.setString(10, decisoesComprar.getPrevisao());
			ps.setString(11, decisoesComprar.getDocaquisicao());		
			ps.setString(12, decisoesComprar.getDescricao());
			ps.setString(13, decisoesComprar.getTipocontrato());
			ps.setString(14, decisoesComprar.getStatus());	
			ps.setString(15, decisoesComprar.getComentarios());
			
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
	public List<DecisoesComprar> getDecisoesComprars() throws Exception {		
		   List<DecisoesComprar> resultado = new ArrayList<DecisoesComprar>();// Montar o resultado
		   
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM decisoescomprar";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					
					DecisoesComprar decisoesComprar = new DecisoesComprar();
				
					decisoesComprar.setImportancia(rs.getInt("importancia"));
					decisoesComprar.setCodigoeap(rs.getInt("codigoeap"));
					decisoesComprar.setItens(rs.getString("itens"));
					decisoesComprar.setUrgencia(rs.getString("urgencia"));
					decisoesComprar.setImpacto(rs.getString("impacto"));
					decisoesComprar.setMotivodecisao(rs.getString("motivodecisao"));
					decisoesComprar.setFornecedores(rs.getString("fornecedores"));
					decisoesComprar.setQuantidade(rs.getInt("quantidade"));
					decisoesComprar.setCusto(rs.getDouble("custo"));				
					decisoesComprar.setPrevisao(rs.getString("previsao"));					
					decisoesComprar.setDocaquisicao(rs.getString("docaquisicao"));
					decisoesComprar.setDescricao(rs.getString("descricao"));
					decisoesComprar.setTipocontrato(rs.getString("tipocontrato"));
					decisoesComprar.setStatus(rs.getString("status"));
					decisoesComprar.setComentarios(rs.getString("comentarios"));
					decisoesComprar.setCodigo(rs.getInt("codigo"));
									
					resultado.add(decisoesComprar);// Add o projeto ao resultado.
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

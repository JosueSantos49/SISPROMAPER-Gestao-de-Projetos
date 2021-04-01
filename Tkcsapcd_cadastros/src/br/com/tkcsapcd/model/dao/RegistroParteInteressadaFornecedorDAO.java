/* 
O	Autor: Josué da Conceição Santos
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
import br.com.tkcsapcd.model.bean.RegistroParteInteressadaFornecedor;
import br.com.tkcsapcd.model.util.Conexao;

public class RegistroParteInteressadaFornecedorDAO implements InterfaceRegistroParteInteressadaFornecedorDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public RegistroParteInteressadaFornecedorDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM fornecedor WHERE codigo = ?;";

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
	private void setPreparedStatement(RegistroParteInteressadaFornecedor registroParteInteressadaFornecedor, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, registroParteInteressadaFornecedor.getRegistroparteinteressada());
		ps.setString(2, registroParteInteressadaFornecedor.getProjeto());
		ps.setInt(3, registroParteInteressadaFornecedor.getCodigoprojeto());
		ps.setString(4, registroParteInteressadaFornecedor.getVersao());
		ps.setString(5, registroParteInteressadaFornecedor.getData());
		ps.setString(6, registroParteInteressadaFornecedor.getAutor());
		ps.setString(7, registroParteInteressadaFornecedor.getNotarevisao());
		ps.setString(8, registroParteInteressadaFornecedor.getAprovacao());
		ps.setObject(9, registroParteInteressadaFornecedor.getCodigofornecedor());
		ps.setString(10, registroParteInteressadaFornecedor.getRazaosocial());
		ps.setString(11, registroParteInteressadaFornecedor.getFone());		
		ps.setString(12, registroParteInteressadaFornecedor.getSite());
		ps.setString(13, registroParteInteressadaFornecedor.getContrato());
		ps.setString(14, registroParteInteressadaFornecedor.getComentario());	
		ps.setString(15, registroParteInteressadaFornecedor.getProposta());
		ps.setString(16, registroParteInteressadaFornecedor.getResponsabilidade());
		ps.setString(17, registroParteInteressadaFornecedor.getControle());
		ps.setInt(18, registroParteInteressadaFornecedor.getCodigo());//Atenção: necessário para isolar o metodo (extração). 		
	}

	@Override
	public RegistroParteInteressadaFornecedor getRegistroParteInteressadaFornecedor(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM fornecedor WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<RegistroParteInteressadaFornecedor> resultado = getListaRegistroParteInteressadaFornecedor(rs);
			
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
		private List<RegistroParteInteressadaFornecedor> getListaRegistroParteInteressadaFornecedor(ResultSet rs) throws SQLException	{
			List<RegistroParteInteressadaFornecedor> resultado = new ArrayList<RegistroParteInteressadaFornecedor>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				RegistroParteInteressadaFornecedor registroParteInteressadaFornecedor = new RegistroParteInteressadaFornecedor();
				
				registroParteInteressadaFornecedor.setRegistroparteinteressada(rs.getString("registroparteinteressada"));
				registroParteInteressadaFornecedor.setProjeto(rs.getString("projeto"));
				registroParteInteressadaFornecedor.setCodigoprojeto(rs.getInt("codigoprojeto"));
				registroParteInteressadaFornecedor.setVersao(rs.getString("versao"));
				registroParteInteressadaFornecedor.setData(rs.getString("data"));
				registroParteInteressadaFornecedor.setAutor(rs.getString("autor"));
				registroParteInteressadaFornecedor.setNotarevisao(rs.getString("notarevisao"));
				registroParteInteressadaFornecedor.setAprovacao(rs.getString("aprovacao"));
				registroParteInteressadaFornecedor.setCodigofornecedor(rs.getInt("codigofornecedor"));				
				registroParteInteressadaFornecedor.setRazaosocial(rs.getString("razaosocial"));					
				registroParteInteressadaFornecedor.setFone(rs.getString("fone"));
				registroParteInteressadaFornecedor.setSite(rs.getString("site"));
				registroParteInteressadaFornecedor.setContrato(rs.getString("contrato"));
				registroParteInteressadaFornecedor.setComentario(rs.getString("comentario"));
				registroParteInteressadaFornecedor.setProposta(rs.getString("proposta"));
				registroParteInteressadaFornecedor.setResponsabilidade(rs.getString("responsabilidade"));
				registroParteInteressadaFornecedor.setControle(rs.getString("controle"));
				registroParteInteressadaFornecedor.setCodigo(rs.getInt("codigo"));
												
				resultado.add(registroParteInteressadaFornecedor);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(RegistroParteInteressadaFornecedor registroParteInteressadaFornecedor) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE fornecedor SET registroparteinteressada = ?, projeto = ?, codigoprojeto = ?, versao = ?, data = ?, autor = ?, notarevisao = ?, aprovacao = ?, codigofornecedor = ?, razaosocial = ?, fone = ?, site = ?, contrato = ?, comentario = ?, proposta = ?, responsabilidade = ?, controle = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(registroParteInteressadaFornecedor, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(RegistroParteInteressadaFornecedor registroParteInteressadaFornecedor) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO fornecedor (registroparteinteressada, projeto, codigoprojeto, versao, data, autor, notarevisao, aprovacao, codigofornecedor, razaosocial, fone, site, contrato, comentario, proposta, responsabilidade, controle) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
		
			ps.setString(1, registroParteInteressadaFornecedor.getRegistroparteinteressada());
			ps.setString(2, registroParteInteressadaFornecedor.getProjeto());
			ps.setInt(3, registroParteInteressadaFornecedor.getCodigoprojeto());
			ps.setString(4, registroParteInteressadaFornecedor.getVersao());
			ps.setString(5, registroParteInteressadaFornecedor.getData());
			ps.setString(6, registroParteInteressadaFornecedor.getAutor());
			ps.setString(7, registroParteInteressadaFornecedor.getNotarevisao());
			ps.setString(8, registroParteInteressadaFornecedor.getAprovacao());
			ps.setObject(9, registroParteInteressadaFornecedor.getCodigofornecedor());
			ps.setString(10, registroParteInteressadaFornecedor.getRazaosocial());
			ps.setString(11, registroParteInteressadaFornecedor.getFone());		
			ps.setString(12, registroParteInteressadaFornecedor.getSite());
			ps.setString(13, registroParteInteressadaFornecedor.getContrato());
			ps.setString(14, registroParteInteressadaFornecedor.getComentario());	
			ps.setString(15, registroParteInteressadaFornecedor.getProposta());
			ps.setString(16, registroParteInteressadaFornecedor.getResponsabilidade());
			ps.setString(17, registroParteInteressadaFornecedor.getControle());
			
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
	public List<RegistroParteInteressadaFornecedor> getRegistroParteInteressadaFornecedors() throws Exception  {
		
		   List<RegistroParteInteressadaFornecedor> resultado = new ArrayList<RegistroParteInteressadaFornecedor>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM fornecedor";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					RegistroParteInteressadaFornecedor registroParteInteressadaFornecedor = new RegistroParteInteressadaFornecedor();
					
					registroParteInteressadaFornecedor.setRegistroparteinteressada(rs.getString("registroparteinteressada"));
					registroParteInteressadaFornecedor.setProjeto(rs.getString("projeto"));
					registroParteInteressadaFornecedor.setCodigoprojeto(rs.getInt("codigoprojeto"));
					registroParteInteressadaFornecedor.setVersao(rs.getString("versao"));
					registroParteInteressadaFornecedor.setData(rs.getString("data"));
					registroParteInteressadaFornecedor.setAutor(rs.getString("autor"));
					registroParteInteressadaFornecedor.setNotarevisao(rs.getString("notarevisao"));
					registroParteInteressadaFornecedor.setAprovacao(rs.getString("aprovacao"));
					registroParteInteressadaFornecedor.setCodigofornecedor(rs.getInt("codigofornecedor"));				
					registroParteInteressadaFornecedor.setRazaosocial(rs.getString("razaosocial"));					
					registroParteInteressadaFornecedor.setFone(rs.getString("fone"));
					registroParteInteressadaFornecedor.setSite(rs.getString("site"));
					registroParteInteressadaFornecedor.setContrato(rs.getString("contrato"));
					registroParteInteressadaFornecedor.setComentario(rs.getString("comentario"));
					registroParteInteressadaFornecedor.setProposta(rs.getString("proposta"));
					registroParteInteressadaFornecedor.setResponsabilidade(rs.getString("responsabilidade"));
					registroParteInteressadaFornecedor.setControle(rs.getString("controle"));
					registroParteInteressadaFornecedor.setCodigo(rs.getInt("codigo"));
									
					resultado.add(registroParteInteressadaFornecedor);// Add o projeto ao resultado.
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

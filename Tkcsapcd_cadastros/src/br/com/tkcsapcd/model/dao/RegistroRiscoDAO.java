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
import br.com.tkcsapcd.model.bean.RegistroRisco;
import br.com.tkcsapcd.model.util.Conexao;

public class RegistroRiscoDAO implements InterfaceRegistroRiscoDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public RegistroRiscoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM registrorisco WHERE codigo = ?;";

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
	
	private void setPreparedStatement(RegistroRisco registroRisco, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, registroRisco.getRegistrorisco());
		ps.setString(2, registroRisco.getReferencia());
		ps.setString(3, registroRisco.getPassos());
		ps.setString(4, registroRisco.getVersao());
		ps.setDate(5, new java.sql.Date (registroRisco.getData().getTime()));
		ps.setString(6, registroRisco.getAutor());
		ps.setString(7, registroRisco.getNotarevisao());
		ps.setInt(8, registroRisco.getSeveridade());
		ps.setObject(9, registroRisco.getDescricao());
		ps.setString(10, registroRisco.getProbabilidade());
		ps.setString(11, registroRisco.getImpacto());		
		ps.setString(12, registroRisco.getDescricaoimpacto());
		ps.setString(13, registroRisco.getCategoria());
		ps.setString(14, registroRisco.getAcao());	
		ps.setString(15, registroRisco.getDescricaoacao());
		ps.setString(16, registroRisco.getResponsavel());
		ps.setString(17, registroRisco.getPrevisao());
		ps.setString(18, registroRisco.getComentario());
		ps.setObject(19, registroRisco.getProjetoinicio().getCodigo());
		ps.setLong(20, registroRisco.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public RegistroRisco getRegistroRisco(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM registrorisco WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<RegistroRisco> resultado = getListaRegistroRisco(rs);
			
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
		private List<RegistroRisco> getListaRegistroRisco(ResultSet rs) throws SQLException	{
			List<RegistroRisco> resultado = new ArrayList<RegistroRisco>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				RegistroRisco registroRisco = new RegistroRisco();
				
				registroRisco.setRegistrorisco(rs.getString("registrorisco"));
				registroRisco.setReferencia(rs.getString("referencia"));
				registroRisco.setPassos(rs.getString("passos"));
				registroRisco.setVersao(rs.getString("versao"));
				registroRisco.setData(rs.getDate("data"));
				registroRisco.setAutor(rs.getString("autor"));
				registroRisco.setNotarevisao(rs.getString("notarevisao"));
				registroRisco.setSeveridade(rs.getInt("severidade"));
				registroRisco.setDescricao(rs.getString("descricao"));				
				registroRisco.setProbabilidade(rs.getString("probabilidade"));					
				registroRisco.setImpacto(rs.getString("impacto"));
				registroRisco.setDescricaoimpacto(rs.getString("descricaoimpacto"));
				registroRisco.setCategoria(rs.getString("categoria"));
				registroRisco.setAcao(rs.getString("acao"));
				registroRisco.setDescricaoacao(rs.getString("descricaoacao"));
				registroRisco.setResponsavel(rs.getString("responsavel"));
				registroRisco.setPrevisao(rs.getString("previsao"));
				registroRisco.setComentario(rs.getString("comentario"));
				registroRisco.setCodigo(rs.getLong("codigo"));
												
				resultado.add(registroRisco);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(RegistroRisco registroRisco) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE registrorisco SET registrorisco = ?, referencia = ?, passos = ?, versao = ?, data = ?, autor = ?, notarevisao = ?, severidade = ?, descricao = ?, probabilidade = ?, impacto = ?, descricaoimpacto = ?, categoria = ?, acao = ?, descricaoacao = ?, responsavel = ?, previsao = ?, comentario = ?, projetoinicio = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(registroRisco, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(RegistroRisco registroRisco) throws Exception  {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO registrorisco(registrorisco, referencia, passos, versao, data, autor, notarevisao, severidade, descricao, probabilidade, impacto, descricaoimpacto, categoria, acao, descricaoacao, responsavel, previsao, comentario, projetoinicio) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, registroRisco.getRegistrorisco());
			ps.setString(2, registroRisco.getReferencia());
			ps.setString(3, registroRisco.getPassos());
			ps.setString(4, registroRisco.getVersao());
			ps.setDate(5, new java.sql.Date (registroRisco.getData().getTime()));
			ps.setString(6, registroRisco.getAutor());
			ps.setString(7, registroRisco.getNotarevisao());
			ps.setInt(8, registroRisco.getSeveridade());
			ps.setObject(9, registroRisco.getDescricao());
			ps.setString(10, registroRisco.getProbabilidade());
			ps.setString(11, registroRisco.getImpacto());		
			ps.setString(12, registroRisco.getDescricaoimpacto());
			ps.setString(13, registroRisco.getCategoria());
			ps.setString(14, registroRisco.getAcao());	
			ps.setString(15, registroRisco.getDescricaoacao());
			ps.setString(16, registroRisco.getResponsavel());
			ps.setString(17, registroRisco.getPrevisao());
			ps.setString(18, registroRisco.getComentario());
			ps.setObject(19, registroRisco.getProjetoinicio().getCodigo());			
			
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
	public List<RegistroRisco> getRegistroRiscos() throws Exception  {
		
		   List<RegistroRisco> resultado = new ArrayList<RegistroRisco>();// Montar o resultado
		   
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs =null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM registrorisco";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {

					RegistroRisco registroRisco = new RegistroRisco();
				
					registroRisco.setRegistrorisco(rs.getString("registrorisco"));
					registroRisco.setReferencia(rs.getString("referencia"));
					registroRisco.setPassos(rs.getString("passos"));
					registroRisco.setVersao(rs.getString("versao"));
					registroRisco.setData(rs.getDate("data"));
					registroRisco.setAutor(rs.getString("autor"));
					registroRisco.setNotarevisao(rs.getString("notarevisao"));
					registroRisco.setSeveridade(rs.getInt("severidade"));
					registroRisco.setDescricao(rs.getString("descricao"));				
					registroRisco.setProbabilidade(rs.getString("probabilidade"));					
					registroRisco.setImpacto(rs.getString("impacto"));
					registroRisco.setDescricaoimpacto(rs.getString("descricaoimpacto"));
					registroRisco.setCategoria(rs.getString("categoria"));
					registroRisco.setAcao(rs.getString("acao"));
					registroRisco.setDescricaoacao(rs.getString("descricaoacao"));
					registroRisco.setResponsavel(rs.getString("responsavel"));
					registroRisco.setPrevisao(rs.getString("previsao"));
					registroRisco.setComentario(rs.getString("comentario"));
					registroRisco.setCodigo(rs.getLong("codigo"));
					
					registroRisco.getProjetoinicio().setCodigo(rs.getLong("codigo"));
									
					resultado.add(registroRisco);// Add o projeto ao resultado.
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

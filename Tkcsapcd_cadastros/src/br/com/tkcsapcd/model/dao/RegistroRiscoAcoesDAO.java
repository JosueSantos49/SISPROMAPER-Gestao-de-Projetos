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
import br.com.tkcsapcd.model.bean.RegistroRiscoAcoes;
import br.com.tkcsapcd.model.util.Conexao;

public class RegistroRiscoAcoesDAO implements InterfaceRegistroRiscoAcoesDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public RegistroRiscoAcoesDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM registroriscoacoes WHERE codigo = ?;";

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
	private void setPreparedStatement(RegistroRiscoAcoes registroRiscoAcoes, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, registroRiscoAcoes.getRegistroriscoacoes());
		ps.setString(2, registroRiscoAcoes.getReferencia());
		ps.setString(3, registroRiscoAcoes.getPassos());
		ps.setString(4, registroRiscoAcoes.getVersao());
		ps.setDate(5, new java.sql.Date(registroRiscoAcoes.getData().getTime()));
		ps.setString(6, registroRiscoAcoes.getAutor());
		ps.setString(7, registroRiscoAcoes.getNotarevisao());
		ps.setString(8, registroRiscoAcoes.getPrioridade());
		ps.setObject(9, registroRiscoAcoes.getDescricaorisco());
		ps.setString(10, registroRiscoAcoes.getDescricaoacao());
		ps.setString(11, registroRiscoAcoes.getResponsavel());		
		ps.setString(12, registroRiscoAcoes.getPrevisao());
		ps.setString(13, registroRiscoAcoes.getStatus());
		ps.setString(14, registroRiscoAcoes.getPrevisaooriginal());	
		ps.setString(15, registroRiscoAcoes.getComentario());
		ps.setObject(16, registroRiscoAcoes.getRegistrorisco().getCodigo());
		ps.setLong(17, registroRiscoAcoes.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public RegistroRiscoAcoes getRegistroRiscoAcoes(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM registroriscoacoes WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<RegistroRiscoAcoes> resultado = getListaRegistroRiscoAcoes(rs);
			
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
		private List<RegistroRiscoAcoes> getListaRegistroRiscoAcoes(ResultSet rs) throws SQLException	{
			List<RegistroRiscoAcoes> resultado = new ArrayList<RegistroRiscoAcoes>();
			
			// Laço p/ preencher
			while (rs.next()) {
				RegistroRiscoAcoes registroRiscoAcoes = new RegistroRiscoAcoes();
				
				registroRiscoAcoes.setRegistroriscoacoes(rs.getString("registroriscoacoes"));
				registroRiscoAcoes.setReferencia(rs.getString("referencia"));
				registroRiscoAcoes.setPassos(rs.getString("passos"));
				registroRiscoAcoes.setVersao(rs.getString("versao"));
				registroRiscoAcoes.setData(rs.getDate("data"));
				registroRiscoAcoes.setAutor(rs.getString("autor"));
				registroRiscoAcoes.setNotarevisao(rs.getString("notarevisao"));
				registroRiscoAcoes.setPrioridade(rs.getString("prioridade"));
				registroRiscoAcoes.setDescricaorisco(rs.getString("descricaorisco"));				
				registroRiscoAcoes.setDescricaoacao(rs.getString("descricaoacao"));					
				registroRiscoAcoes.setResponsavel(rs.getString("responsavel"));
				registroRiscoAcoes.setPrevisao(rs.getString("previsao"));
				registroRiscoAcoes.setStatus(rs.getString("status"));
				registroRiscoAcoes.setPrevisaooriginal(rs.getString("previsaooriginal"));
				registroRiscoAcoes.setComentario(rs.getString("descricaoacao"));
				registroRiscoAcoes.setCodigo(rs.getLong("codigo"));
												
				resultado.add(registroRiscoAcoes);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(RegistroRiscoAcoes registroRiscoAcoes) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			
			String sqlAtualizar = "UPDATE registroriscoacoes SET registroriscoacoes = ?, referencia = ?, passos = ?, versao = ?, data = ?, autor = ?, notarevisao = ?, prioridade = ?, descricaorisco = ?, descricaoacao = ?, responsavel = ?, previsao = ?, status = ?, previsaooriginal = ?, comentario  = ?, registrorisco = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(registroRiscoAcoes, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(RegistroRiscoAcoes registroRiscoAcoes) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO registroriscoacoes(registroriscoacoes, referencia, passos, versao, data, autor, notarevisao, prioridade, descricaorisco, descricaoacao, responsavel, previsao, status, previsaooriginal, comentario, registrorisco) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, registroRiscoAcoes.getRegistroriscoacoes());
			ps.setString(2, registroRiscoAcoes.getReferencia());
			ps.setString(3, registroRiscoAcoes.getPassos());
			ps.setString(4, registroRiscoAcoes.getVersao());
			ps.setDate(5, new java.sql.Date(registroRiscoAcoes.getData().getTime()));
			ps.setString(6, registroRiscoAcoes.getAutor());
			ps.setString(7, registroRiscoAcoes.getNotarevisao());
			ps.setString(8, registroRiscoAcoes.getPrioridade());
			ps.setObject(9, registroRiscoAcoes.getDescricaorisco());
			ps.setString(10, registroRiscoAcoes.getDescricaoacao());
			ps.setString(11, registroRiscoAcoes.getResponsavel());		
			ps.setString(12, registroRiscoAcoes.getPrevisao());
			ps.setString(13, registroRiscoAcoes.getStatus());
			ps.setString(14, registroRiscoAcoes.getPrevisaooriginal());	
			ps.setString(15, registroRiscoAcoes.getComentario());
			ps.setObject(16, registroRiscoAcoes.getRegistrorisco().getCodigo());
			
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
	public List<RegistroRiscoAcoes> getRegistroRiscoAcoess() throws Exception {
		
		   List<RegistroRiscoAcoes> resultado = new ArrayList<RegistroRiscoAcoes>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM registroriscoacoes";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {

					RegistroRiscoAcoes registroRiscoAcoes = new RegistroRiscoAcoes();
				
					registroRiscoAcoes.setRegistroriscoacoes(rs.getString("registroriscoacoes"));
					registroRiscoAcoes.setReferencia(rs.getString("referencia"));
					registroRiscoAcoes.setPassos(rs.getString("passos"));
					registroRiscoAcoes.setVersao(rs.getString("versao"));
					registroRiscoAcoes.setData(rs.getDate("data"));
					registroRiscoAcoes.setAutor(rs.getString("autor"));
					registroRiscoAcoes.setNotarevisao(rs.getString("notarevisao"));
					registroRiscoAcoes.setPrioridade(rs.getString("prioridade"));
					registroRiscoAcoes.setDescricaorisco(rs.getString("descricaorisco"));				
					registroRiscoAcoes.setDescricaoacao(rs.getString("descricaoacao"));					
					registroRiscoAcoes.setResponsavel(rs.getString("responsavel"));
					registroRiscoAcoes.setPrevisao(rs.getString("previsao"));
					registroRiscoAcoes.setStatus(rs.getString("status"));
					registroRiscoAcoes.setPrevisaooriginal(rs.getString("previsaooriginal"));
					registroRiscoAcoes.setComentario(rs.getString("descricaoacao"));
					registroRiscoAcoes.setCodigo(rs.getLong("codigo"));
					
					registroRiscoAcoes.getRegistrorisco().setCodigo(rs.getLong("codigo"));
									
					resultado.add(registroRiscoAcoes);// Add o projeto ao resultado.
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

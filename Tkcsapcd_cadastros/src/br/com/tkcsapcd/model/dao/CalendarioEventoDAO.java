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
import br.com.tkcsapcd.model.bean.CalendarioEvento;
import br.com.tkcsapcd.model.util.Conexao;

public class CalendarioEventoDAO implements InterfaceCalendarioEventoDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public CalendarioEventoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM calendarioevento WHERE codigo = ?;";

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

	private void setPreparedStatement(CalendarioEvento calendarioEvento, PreparedStatement ps) throws SQLException 
	{			
		ps.setInt(1, calendarioEvento.getCodigoprojeto());
		ps.setDate(2, new java.sql.Date(calendarioEvento.getData().getTime() )); //transforma o java util date em java sql date
		ps.setString(3, calendarioEvento.getIniciar());
		ps.setString(4, calendarioEvento.getDuracao());
		ps.setString(5, calendarioEvento.getLocal());
		ps.setString(6, calendarioEvento.getAssunto());
		ps.setString(7, calendarioEvento.getDescricao());
		ps.setString(8, calendarioEvento.getResponsavel());
		ps.setObject(9, calendarioEvento.getFrequencia());
		ps.setString(10, calendarioEvento.getParticipantes());
		ps.setInt(11, calendarioEvento.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public CalendarioEvento getCalendarioEvento(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM calendarioevento WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<CalendarioEvento> resultado = getListaCalendarioEvento(rs);
			
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
		private List<CalendarioEvento> getListaCalendarioEvento(ResultSet rs) throws SQLException	{
			List<CalendarioEvento> resultado = new ArrayList<CalendarioEvento>();
			
			// Laço p/ preencher
			while (rs.next()) {
								
				CalendarioEvento calendarioEvento = new CalendarioEvento();
								
				calendarioEvento.setCodigoprojeto(rs.getInt("codigoprojeto"));
				calendarioEvento.setData(rs.getDate("data"));
				calendarioEvento.setIniciar(rs.getString("iniciar"));
				calendarioEvento.setDuracao(rs.getString("duracao"));
				calendarioEvento.setLocal(rs.getString("local"));
				calendarioEvento.setAssunto(rs.getString("assunto"));
				calendarioEvento.setDescricao(rs.getString("descricao"));
				calendarioEvento.setResponsavel(rs.getString("responsavel"));				
				calendarioEvento.setFrequencia(rs.getString("frequencia"));
				calendarioEvento.setParticipantes(rs.getString("participantes"));
				calendarioEvento.setCodigo(rs.getInt("codigo"));
								
				resultado.add(calendarioEvento);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(CalendarioEvento calendarioEvento) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
								
		try{
			String sqlAtualizar = "UPDATE calendarioevento SET  codigoprojeto = ?, data = ?, iniciar = ?, duracao = ?, local = ?, assunto = ?, descricao = ?, responsavel  = ?, frequencia  = ?, participantes = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(calendarioEvento, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(CalendarioEvento calendarioEvento) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {			
			String sqlInsert = "INSERT INTO calendarioevento(codigoprojeto, data, iniciar, duracao, local, assunto, descricao, responsavel, frequencia, participantes) VALUES (?,?,?,?,?,?,?,?,?,?)";
						
			ps = con.prepareStatement(sqlInsert);			
				
			ps.setInt(1, calendarioEvento.getCodigoprojeto());
			ps.setDate(2, new java.sql.Date(calendarioEvento.getData().getTime() )); //transforma o java util date em java sql date
			ps.setString(3, calendarioEvento.getIniciar());
			ps.setString(4, calendarioEvento.getDuracao());
			ps.setString(5, calendarioEvento.getLocal());
			ps.setString(6, calendarioEvento.getAssunto());
			ps.setString(7, calendarioEvento.getDescricao());
			ps.setString(8, calendarioEvento.getResponsavel());
			ps.setObject(9, calendarioEvento.getFrequencia());
			ps.setString(10, calendarioEvento.getParticipantes());
			
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
	public List<CalendarioEvento> getCalendarioEventos() throws Exception {
		
		List<CalendarioEvento> resultado = new ArrayList<CalendarioEvento>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM calendarioevento";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					
					CalendarioEvento calendarioEvento = new CalendarioEvento();
					
					calendarioEvento.setCodigoprojeto(rs.getInt("codigoprojeto"));
					calendarioEvento.setData(rs.getDate("data"));
					calendarioEvento.setIniciar(rs.getString("iniciar"));
					calendarioEvento.setDuracao(rs.getString("duracao"));
					calendarioEvento.setLocal(rs.getString("local"));
					calendarioEvento.setAssunto(rs.getString("assunto"));
					calendarioEvento.setDescricao(rs.getString("descricao"));
					calendarioEvento.setResponsavel(rs.getString("responsavel"));				
					calendarioEvento.setFrequencia(rs.getString("frequencia"));
					calendarioEvento.setParticipantes(rs.getString("participantes"));
					calendarioEvento.setCodigo(rs.getInt("codigo"));
									
					resultado.add(calendarioEvento);// Add o projeto ao resultado.
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

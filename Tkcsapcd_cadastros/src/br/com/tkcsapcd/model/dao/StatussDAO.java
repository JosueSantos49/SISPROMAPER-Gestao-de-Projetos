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
import br.com.tkcsapcd.model.bean.Statuss;
import br.com.tkcsapcd.model.util.Conexao;

public class StatussDAO implements InterfaceStatussDAO {

	//StatussDAO solicita o pool.
	@SuppressWarnings("unused")
	private InterfacePool pool;
	
	//Construtor que recebe o pool como parametro
	public StatussDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}

	@Override
	public void excluir(Integer codigo) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;

		try {
			String sqlExcluir = "DELETE FROM statuss WHERE codigo = ?;";

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
	/*---------------------------------------------------------------------------------------------------------------------------------------*/
	@Override
	public void salvar(Statuss statuss) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		
		try {
			
			String sqlInsert = "INSERT INTO statuss(fase, percentualevolucao, percentualplanejado, datastatus, descricao, pontospositivos, pontosnegativos, tendencia, datainicio, datafim, Projeto, codigodoprojeto)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			
			ps = con.prepareStatement(sqlInsert);
			
			ps.setString(1, statuss.getFase());
			ps.setDouble(2, statuss.getPercentualevolucao());
			ps.setDouble(3, statuss.getPercentualplanejado());
			ps.setString(4, statuss.getDatastatus());
			ps.setString(5, statuss.getDescricao());
			ps.setString(6, statuss.getPontospositivos());
			ps.setString(7, statuss.getPontosnegativos());
			ps.setString(8, statuss.getTendencia());
			ps.setString(9, statuss.getDatainicio());
			ps.setString(10, statuss.getDatafim());
			ps.setString (11, statuss.getProjeto());
			ps.setInt(12, statuss.getCodigodoprojeto());
			
			ps.executeUpdate();
			ps.close();
			
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
/*---------------------------------------------------------------------------------------------------------------------------------------*/
	private void setPreparedStatement(Statuss statuss, PreparedStatement ps) throws SQLException{
		
		ps.setString(1, statuss.getFase());
		ps.setDouble(2, statuss.getPercentualevolucao());
		ps.setDouble(3, statuss.getPercentualplanejado());
		ps.setString(4, statuss.getDatastatus());
		ps.setString(5, statuss.getDescricao());
		ps.setString(6, statuss.getPontospositivos());
		ps.setString(7, statuss.getPontosnegativos());
		ps.setString(8, statuss.getTendencia());
		ps.setString(9, statuss.getDatainicio());
		ps.setString(10, statuss.getDatafim());
		ps.setString (11, statuss.getProjeto());
		ps.setInt(12, statuss.getCodigodoprojeto());
		ps.setObject(13, statuss.getCodigo());//Atenção: necessário para isolar o metodo (extração).
	}
/*---------------------------------------------------------------------------------------------------------------------------------------*/
	@Override
	public Statuss getStatuss(Integer codigo) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			String sqlSelect = "SELECT * FROM statuss WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<Statuss> resultado = getListaStatuss(rs);
			
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

	@Override
	public void atualizar(Statuss statuss) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		
		try {
			
			String sqlAtualizar = "UPDATE statuss SET fase = ?, percentualevolucao = ?, percentualplanejado = ?, datastatus = ?, descricao = ?, pontospositivos = ?, pontosnegativos = ?, tendencia = ?, datainicio = ?, datafim = ?, Projeto = ?, codigodoprojeto = ? WHERE codigo = ?;";
			
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(statuss, ps);
			ps.executeUpdate();
			ps.close();
			
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
/*---------------------------------------------------------------------------------------------------------------------------------------*/
	@Override
	public List<Statuss> getStatusss() throws Exception {
		
		List<Statuss> resultado = new ArrayList<Statuss>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();		
					
			String sqlSelect = "SELECT * FROM statuss;";
				
			ps = con.prepareStatement(sqlSelect);			
			rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaStatuss(rs);
				
				while(rs.next()){
					
					Statuss statuss = new Statuss();
					
					statuss.setFase(rs.getString("fase"));
					statuss.setPercentualevolucao(rs.getDouble("percentualevolucao"));
					statuss.setPercentualplanejado(rs.getDouble("percentualplanejado"));
					statuss.setDatastatus(rs.getString("datastatus"));
					statuss.setDescricao(rs.getString("descricao"));
					statuss.setPontospositivos(rs.getString("pontospositivos"));
					statuss.setPontosnegativos(rs.getString("pontosnegativos"));
					statuss.setTendencia(rs.getString("tendencia"));
					statuss.setDatainicio(rs.getString("datainicio"));
					statuss.setDatafim(rs.getString("datafim"));
					statuss.setProjeto(rs.getString("projeto"));
					statuss.setCodigodoprojeto(rs.getInt("codigodoprojeto"));
					statuss.setCodigo(rs.getInt("codigo"));
					
					resultado.add(statuss);
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
/*---------------------------------------------------------------------------------------------------------------------------------------*/
	
	//Metodo p confirma, objetivo resulmir linhas de códigos, que pode ser usados em outros métodos. (ex: resultado = getListaCliente(rs); ou List<Cliente> resultado = getListaCliente(rs);)
	private List<Statuss> getListaStatuss(ResultSet rs) throws SQLException{
		
		List<Statuss> resultado = new ArrayList<Statuss>();
		
		// Laço p/ preencher, enquanto o rs tiver registro, vai retornar verdadeiro e moverá o curso para o próximo(Laço p/ preencher).
		while (rs.next()){
			
			Statuss statuss = new Statuss();
			
			//Passando os valores que estão na tabela para o objeto statuss				
			statuss.setFase(rs.getString("fase"));
			statuss.setPercentualevolucao(rs.getDouble("percentualevolucao"));
			statuss.setPercentualplanejado(rs.getDouble("percentualplanejado"));
			statuss.setDatastatus(rs.getString("datastatus"));
			statuss.setDescricao(rs.getString("descricao"));
			statuss.setPontospositivos(rs.getString("pontospositivos"));
			statuss.setPontosnegativos(rs.getString("pontosnegativos"));
			statuss.setTendencia(rs.getString("tendencia"));
			statuss.setDatainicio(rs.getString("datainicio"));
			statuss.setDatafim(rs.getString("datafim"));
			statuss.setProjeto(rs.getString("projeto"));
			statuss.setCodigodoprojeto(rs.getInt("codigodoprojeto"));
			statuss.setCodigo(rs.getInt("codigo"));	
							
			resultado.add(statuss);
		}	
		return resultado;
	}
}

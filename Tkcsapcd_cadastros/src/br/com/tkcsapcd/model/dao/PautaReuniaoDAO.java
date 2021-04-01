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
import br.com.tkcsapcd.model.bean.PautaReuniao;
import br.com.tkcsapcd.model.util.Conexao;

public class PautaReuniaoDAO implements InterfacePautaReuniaoDAO {

	@SuppressWarnings("unused")
	private InterfacePool pool;

	public PautaReuniaoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}

	@Override
	public void excluir(Integer codigo) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
				
		try{

			String SqlExcluir = "DELETE FROM pautareuniao WHERE codigo = ?;";			
			ps = con.prepareStatement(SqlExcluir);
			ps.setInt(1, codigo);
			ps.executeUpdate();
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
	public void atualizar(PautaReuniao pautaReuniao) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {		
			String sqlAtualizar = "UPDATE pautareuniao SET pautareuniao = ?, projeto = ?, codigoprojeto = ?, data = ?, local = ?, participantes = ?, objetivo = ?, topico = ?, informacao = ? WHERE codigo = ?;";
			
			ps = con.prepareStatement(sqlAtualizar);			
			setPreparedStatement(pautaReuniao, ps);//Código isolado do metodo sqlInsert permite usar a mesma linha, facilitando!			
			ps.executeUpdate();//Linha muito importante, sem ela não é executado a atualização do cliente
			ps.close();	
			
		}finally
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
	public void salvar(PautaReuniao pautaReuniao) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try{
			
			String sqlInsert = "INSERT INTO pautareuniao(pautareuniao, projeto, codigoprojeto, data, local, participantes, objetivo, topico, informacao) VALUES(?,?,?,?,?,?,?,?,?)";		
			
					ps = con.prepareStatement(sqlInsert);
					
					ps.setString(1, pautaReuniao.getPautareuniao());
					ps.setString(2, pautaReuniao.getProjeto());
					ps.setInt(3, pautaReuniao.getCodigoprojeto());
					ps.setString(4, pautaReuniao.getData());
					ps.setString(5, pautaReuniao.getLocal());
					ps.setString(6, pautaReuniao.getParticipantes());
					ps.setString(7, pautaReuniao.getObjetivo());
					ps.setString(8, pautaReuniao.getTopico());
					ps.setString(9, pautaReuniao.getInformacao());	
					
					ps.executeUpdate();
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
	
	private void setPreparedStatement(PautaReuniao pautaReuniao, PreparedStatement ps) throws SQLException{
		
		ps.setString(1, pautaReuniao.getPautareuniao());
		ps.setString(2, pautaReuniao.getProjeto());
		ps.setInt(3, pautaReuniao.getCodigoprojeto());
		ps.setString(4, pautaReuniao.getData());
		ps.setString(5, pautaReuniao.getLocal());
		ps.setString(6, pautaReuniao.getParticipantes());
		ps.setString(7, pautaReuniao.getObjetivo());
		ps.setString(8, pautaReuniao.getTopico());
		ps.setString(9, pautaReuniao.getInformacao());
		ps.setObject(10, pautaReuniao.getCodigo());
	}
	
	@Override
	public PautaReuniao getPautaReuniao(Integer codigo) throws Exception  {
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
					
		try {
			
			String sqlSelect = "SELECT * FROM pautareuniao WHERE codigo = ?;";				
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando				
			rs = ps.executeQuery();
				
			List<PautaReuniao> resultado = getListaRfpRequerimento(rs);
			
			if (resultado.size() > 0)			
				return resultado.get(0);//pegando elemento por chave (unico).			
			
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

	@Override
	public PautaReuniao getPautaReuniao(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PautaReuniao> getPautaReuniaos() throws Exception {
		
		List<PautaReuniao> resultado = new ArrayList<PautaReuniao>();		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM pautareuniao;";	
			
			ps = con.prepareStatement(sqlSelect);
			rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.														
			
			//resultado = getListaRequerimento(rs);		
			while(rs.next()){
				
				// criando objeto para cada registro no BD 
				PautaReuniao pautaReuniao = new PautaReuniao();
				
				pautaReuniao.setPautareuniao(rs.getString("pautareuniao"));
				pautaReuniao.setProjeto(rs.getString("projeto"));
				pautaReuniao.setCodigoprojeto(rs.getInt("codigoprojeto"));
				pautaReuniao.setData(rs.getString("data"));
				pautaReuniao.setLocal(rs.getString("local"));
				pautaReuniao.setParticipantes(rs.getString("participantes"));
				pautaReuniao.setObjetivo(rs.getString("objetivo"));
				pautaReuniao.setTopico(rs.getString("topico"));
				pautaReuniao.setInformacao(rs.getString("informacao"));
				pautaReuniao.setCodigo(rs.getInt("codigo"));
				
				resultado.add(pautaReuniao);
				}
			rs.close();
			ps.close();
		} finally {

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

	private List<PautaReuniao> getListaRfpRequerimento(ResultSet rs) throws SQLException{
		
		List<PautaReuniao> resultado = new ArrayList<PautaReuniao>();
		
		while(rs.next()){
			
			// criando objeto para cada registro no BD 
			PautaReuniao pautaReuniao = new PautaReuniao();
			
			pautaReuniao.setPautareuniao(rs.getString("pautareuniao"));
			pautaReuniao.setProjeto(rs.getString("projeto"));
			pautaReuniao.setCodigoprojeto(rs.getInt("codigoprojeto"));
			pautaReuniao.setData(rs.getString("data"));
			pautaReuniao.setLocal(rs.getString("local"));
			pautaReuniao.setParticipantes(rs.getString("participantes"));
			pautaReuniao.setObjetivo(rs.getString("objetivo"));
			pautaReuniao.setTopico(rs.getString("topico"));
			pautaReuniao.setInformacao(rs.getString("informacao"));
			pautaReuniao.setCodigo(rs.getInt("codigo"));
			
			resultado.add(pautaReuniao);
			}
		return resultado;
	}
}

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
import br.com.tkcsapcd.model.bean.Metricas;
import br.com.tkcsapcd.model.util.Conexao;

public class MetricasDAO implements InterfaceMetricasDAO {

	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public MetricasDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}

	@Override
	public void excluir(Integer codigo) throws Exception {
		// TODO Auto-generated method stub
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM metricas WHERE codigo = ?;";

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
	public void atualizar(Metricas metricas) throws Exception  {
		// TODO Auto-generated method stub
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
								
		try{
			String sqlAtualizar = "UPDATE metricas SET idMetricas = ?, nomeMetrica = ?, indiceMetrica = ?, valorReferenciaHora = ?, valorHoraCalculadaDia = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(metricas, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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

	private void setPreparedStatement(Metricas metricas, PreparedStatement ps) throws SQLException {
		// TODO Auto-generated method stub
		ps.setString(1, metricas.getIdMetricas());
		ps.setString(2, metricas.getNomeMetrica());		
		ps.setString(3, metricas.getIndiceMetrica());
		ps.setString(4, metricas.getValorReferenciaHora());
		ps.setString(5, metricas.getValorHoraCalculadaDia());
		ps.setInt(6, metricas.getCodigo());//Atenção: necessário para isolar o metodo (extração). // Alterado dia 28/05/2014
	}

	@Override
	public void salvar(Metricas metricas) throws Exception {
		// TODO Auto-generated method stub
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
						
			String sqlInsert = "INSERT INTO metricas(idMetricas, nomeMetrica, indiceMetrica, valorReferenciaHora , valorHoraCalculadaDia) VALUES (?, ?, ?, ?, ?)";

			ps = con.prepareStatement(sqlInsert);
			
			ps.setString(1, metricas.getIdMetricas());
			ps.setString(2, metricas.getNomeMetrica());			
			ps.setString(3, metricas.getIndiceMetrica());
			ps.setString(4, metricas.getValorReferenciaHora());
			ps.setString(5, metricas.getValorHoraCalculadaDia());
			
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
	public Metricas getMetricas(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM metricas WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<Metricas> resultado = getListaMetricas(rs);
			
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

	@Override
	public List<Metricas> getMetricass() throws Exception {
		List<Metricas> resultado = new ArrayList<Metricas>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs =null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM metricas";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					
					Metricas metricas = new Metricas();

					metricas.setIdMetricas(rs.getString("idMetricas"));
					metricas.setNomeMetrica(rs.getString("nomeMetrica"));					
					metricas.setIndiceMetrica(rs.getString("indiceMetrica"));
					metricas.setValorReferenciaHora(rs.getString("valorReferenciaHora"));
					metricas.setValorHoraCalculadaDia(rs.getString("valorHoraCalculadaDia"));
					metricas.setCodigo(rs.getInt("codigo"));
									
					resultado.add(metricas);// Add o projeto ao resultado.
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
	
	private List<Metricas> getListaMetricas(ResultSet rs) throws SQLException {
		List<Metricas> resultado = new ArrayList<Metricas>();
		
		// Laço p/ preencher
		while (rs.next()) {
			
			Metricas metricas = new Metricas();

			metricas.setIdMetricas(rs.getString("idMetricas"));
			metricas.setNomeMetrica(rs.getString("nomeMetrica"));			
			metricas.setIndiceMetrica(rs.getString("indiceMetrica"));
			metricas.setValorReferenciaHora(rs.getString("valorReferenciaHora"));
			metricas.setValorHoraCalculadaDia(rs.getString("valorHoraCalculadaDia"));
			metricas.setCodigo(rs.getInt("codigo"));
							
			resultado.add(metricas);// Add o projeto ao resultado.
		}			
		return resultado;
	}	

}

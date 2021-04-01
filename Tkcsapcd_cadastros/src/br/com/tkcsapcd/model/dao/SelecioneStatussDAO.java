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
import br.com.tkcsapcd.model.bean.Selecionestatuss;
import br.com.tkcsapcd.model.util.Conexao;

public class SelecioneStatussDAO implements InterfaceSelecioneStatussDAO {
	
	@SuppressWarnings("unused")
	private InterfacePool pool;
	
	public SelecioneStatussDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}

	@Override
	public void excluir(Integer codigo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void salvar(Selecionestatuss selecionestatuss) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(Selecionestatuss selecionestatuss) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Selecionestatuss> getSelecioneStatusss() throws Exception {
		// TODO Auto-generated method stub
		List<Selecionestatuss> resultado = new ArrayList<Selecionestatuss>();
		Connection con= null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM selecionestatuss;";
			
			ps = con.prepareStatement(sqlSelect);
			rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
			
			//resultado = getListaDepartamentos(rs);	
			// Laço p/ preencher, enquanto o rs tiver registro, vai retornar verdadeiro e moverá o curso para o próximo(Laço p/ preencher).
			while(rs.next()){
				Selecionestatuss selecionestatuss = new Selecionestatuss();
				
				selecionestatuss.setNome(rs.getString("nome"));
				selecionestatuss.setSigla(rs.getString("sigla"));				
				selecionestatuss.setCodigo(rs.getInt("codigo"));
				
				resultado.add(selecionestatuss);
			}
			rs.close();
			ps.close();
		}finally{
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

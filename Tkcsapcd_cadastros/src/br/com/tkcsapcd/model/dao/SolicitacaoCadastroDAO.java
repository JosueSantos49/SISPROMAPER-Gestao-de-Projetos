/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.tkcsapcd.conexao.InterfacePool;
import br.com.tkcsapcd.model.bean.SolicitacaoCadastro;
import br.com.tkcsapcd.model.util.Conexao;

public class SolicitacaoCadastroDAO implements InterfaceSolicitaCadastro {

	@SuppressWarnings("unused")
	private InterfacePool pool;	
	public SolicitacaoCadastroDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}

	@Override
	public void salvar(SolicitacaoCadastro solicitacaoCadastro) throws Exception {

		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			
			String sqlInsert = "INSERT INTO solicitacaocadastro(nome, id, email, area, funcao, responsavel, telefone, obs, data, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			ps = con.prepareStatement(sqlInsert);
			
			ps.setString(1, solicitacaoCadastro.getNome());
			ps.setString(2, solicitacaoCadastro.getCpf());
			ps.setString(3, solicitacaoCadastro.getEmail());
			ps.setString(4, solicitacaoCadastro.getArea());
			ps.setString(5, solicitacaoCadastro.getFuncao());
			ps.setString(6, solicitacaoCadastro.getResponsavel());
			ps.setString(7, solicitacaoCadastro.getTelefone());
			ps.setString(8, solicitacaoCadastro.getObs());
			ps.setString(9, solicitacaoCadastro.getData());
			ps.setString(10, solicitacaoCadastro.getStatus());
			
			ps.executeUpdate();
			ps.close();
					
		} finally{
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

}

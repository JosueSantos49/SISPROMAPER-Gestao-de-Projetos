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
import br.com.tkcsapcd.model.bean.Alocacao;
import br.com.tkcsapcd.model.util.Conexao;

public class AlocacaoDAO implements InterfaceAlocacaoDAO {

	@SuppressWarnings("unused")
	private InterfacePool pool;
	public AlocacaoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}

	@Override
	public void excluir(Integer codigo) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM alocacao WHERE codigo = ?;";

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
	public void salvar(Alocacao alocacao) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		try {
			
			String sqlInsert = "INSERT INTO alocacao(projeto_codigo, recursoshumanos_codigo, profissao_codigo, data, data0, metrica, metrica1, metrica2, metrica3, metrica4, metrica5, metrica6, metrica7, metrica8, metrica9, metrica10, metrica11, metrica12, metrica13, metrica14, metrica15, metrica16) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?, ?, ?)";

			ps = con.prepareStatement(sqlInsert);
			
			ps.setInt(1, alocacao.getProjeto_codigo());
			ps.setString(2, alocacao.getRecursoshumanos_codigo());
			ps.setString(3, alocacao.getProfissao_codigo());
			ps.setString(4, alocacao.getData());
			ps.setString(5, alocacao.getData0());
			ps.setString(6, alocacao.getMetrica());
			ps.setString(7, alocacao.getMetrica1());
			ps.setString(8, alocacao.getMetrica2());
			ps.setString(9, alocacao.getMetrica3());
			ps.setString(10, alocacao.getMetrica4());
			ps.setString(11, alocacao.getMetrica5());
			ps.setString(12, alocacao.getMetrica6());
			ps.setString(13, alocacao.getMetrica7());
			ps.setString(14, alocacao.getMetrica8());
			ps.setString(15, alocacao.getMetrica9());
			ps.setString(16, alocacao.getMetrica10());
			ps.setString(17, alocacao.getMetrica11());
			ps.setString(18, alocacao.getMetrica12());
			ps.setString(19, alocacao.getMetrica13());
			ps.setString(20, alocacao.getMetrica14());
			ps.setString(21, alocacao.getMetrica15());
			ps.setString(22, alocacao.getMetrica16());
			
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
	public void atualizar(Alocacao alocacao) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
								
		try{
			String sqlAtualizar = "UPDATE alocacao SET projeto_codigo = ?, recursoshumanos_codigo = ?, profissao_codigo= ?, data= ?, data0= ?, metrica= ?, metrica1= ?, metrica2= ?, metrica3= ?, metrica4= ?, metrica5= ?, metrica6= ?, metrica7= ?, metrica8= ?, metrica9= ?, metrica10= ?, metrica11= ?, metrica12= ?, metrica13= ?, metrica14= ?, metrica15= ?, metrica16 = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(alocacao, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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

	private void setPreparedStatement(Alocacao alocacao, PreparedStatement ps) throws SQLException {
		
		ps.setInt(1, alocacao.getProjeto_codigo());
		ps.setString(2, alocacao.getRecursoshumanos_codigo());
		ps.setString(3, alocacao.getProfissao_codigo());
		ps.setString(4, alocacao.getData());
		ps.setString(5, alocacao.getData0());
		ps.setString(6, alocacao.getMetrica());
		ps.setString(7, alocacao.getMetrica1());
		ps.setString(8, alocacao.getMetrica2());
		ps.setString(9, alocacao.getMetrica3());
		ps.setString(10, alocacao.getMetrica4());
		ps.setString(11, alocacao.getMetrica5());
		ps.setString(12, alocacao.getMetrica6());
		ps.setString(13, alocacao.getMetrica7());
		ps.setString(14, alocacao.getMetrica8());
		ps.setString(15, alocacao.getMetrica9());
		ps.setString(16, alocacao.getMetrica10());
		ps.setString(17, alocacao.getMetrica11());
		ps.setString(18, alocacao.getMetrica12());
		ps.setString(19, alocacao.getMetrica13());
		ps.setString(20, alocacao.getMetrica14());
		ps.setString(21, alocacao.getMetrica15());
		ps.setString(22, alocacao.getMetrica16());
		ps.setInt(23, alocacao.getCodigo());
		
	}

	@Override
	public Alocacao getAlocacao(Integer codigo) throws Exception {
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM alocacao WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<Alocacao> resultado = getListaAlocacao(rs);
			
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
	public List<Alocacao> getAlocacaos() throws Exception {
		
			List<Alocacao> resultado = new ArrayList<Alocacao>();// Montar o resultado
			Connection con=null;
			PreparedStatement ps = null;
			ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM alocacao";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					
					Alocacao alocacao = new Alocacao();
					
					alocacao.setProjeto_codigo(rs.getInt("projeto_codigo"));
					alocacao.setRecursoshumanos_codigo(rs.getString("recursoshumanos_codigo"));
					alocacao.setProfissao_codigo(rs.getString("profissao_codigo"));
					alocacao.setData(rs.getString("data"));
					alocacao.setData0(rs.getString("data0"));
					alocacao.setMetrica(rs.getString("metrica"));
					alocacao.setMetrica1(rs.getString("metrica1"));
					alocacao.setMetrica2(rs.getString("metrica2"));
					alocacao.setMetrica3(rs.getString("metrica3"));
					alocacao.setMetrica4(rs.getString("metrica4"));
					alocacao.setMetrica5(rs.getString("metrica5"));
					alocacao.setMetrica6(rs.getString("metrica6"));
					alocacao.setMetrica7(rs.getString("metrica7"));
					alocacao.setMetrica8(rs.getString("metrica8"));
					alocacao.setMetrica9(rs.getString("metrica9"));
					alocacao.setMetrica10(rs.getString("metrica10"));
					alocacao.setMetrica11(rs.getString("metrica11"));
					alocacao.setMetrica12(rs.getString("metrica12"));
					alocacao.setMetrica13(rs.getString("metrica13"));
					alocacao.setMetrica14(rs.getString("metrica14"));
					alocacao.setMetrica15(rs.getString("metrica15"));
					alocacao.setMetrica16(rs.getString("metrica16"));					
					alocacao.setCodigo(rs.getInt("codigo"));
									
					resultado.add(alocacao);// Add o projeto ao resultado.
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
			//Metodo p confirma objetivo. Resulmir linhas de códigos, que pode ser usados em outros métodos. (ex: resultado = getListaCliente(rs); ou List<Cliente> resultado = getListaCliente(rs);)
			private List<Alocacao> getListaAlocacao(ResultSet rs) throws SQLException	{
				
					List<Alocacao> resultado = new ArrayList<Alocacao>();
				
				// Laço p/ preencher
				while (rs.next()) {
					
					Alocacao alocacao = new Alocacao();
					
					alocacao.setProjeto_codigo(rs.getInt("projeto_codigo"));
					alocacao.setRecursoshumanos_codigo(rs.getString("recursoshumanos_codigo"));
					alocacao.setProfissao_codigo(rs.getString("profissao_codigo"));
					alocacao.setData(rs.getString("data"));
					alocacao.setData0(rs.getString("data0"));
					alocacao.setMetrica(rs.getString("metrica"));
					alocacao.setMetrica1(rs.getString("metrica1"));
					alocacao.setMetrica2(rs.getString("metrica2"));
					alocacao.setMetrica3(rs.getString("metrica3"));
					alocacao.setMetrica4(rs.getString("metrica4"));
					alocacao.setMetrica5(rs.getString("metrica5"));
					alocacao.setMetrica6(rs.getString("metrica6"));
					alocacao.setMetrica7(rs.getString("metrica7"));
					alocacao.setMetrica8(rs.getString("metrica8"));
					alocacao.setMetrica9(rs.getString("metrica9"));
					alocacao.setMetrica10(rs.getString("metrica10"));
					alocacao.setMetrica11(rs.getString("metrica11"));
					alocacao.setMetrica12(rs.getString("metrica12"));
					alocacao.setMetrica13(rs.getString("metrica13"));
					alocacao.setMetrica14(rs.getString("metrica14"));
					alocacao.setMetrica15(rs.getString("metrica15"));
					alocacao.setMetrica16(rs.getString("metrica16"));			
					alocacao.setCodigo(rs.getInt("codigo"));
									
					resultado.add(alocacao);// Add o projeto ao resultado.
				}			
				return resultado;
			}
}

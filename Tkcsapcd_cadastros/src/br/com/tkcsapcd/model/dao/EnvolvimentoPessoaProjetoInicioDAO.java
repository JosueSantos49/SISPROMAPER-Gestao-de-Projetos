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
import br.com.tkcsapcd.model.bean.EnvolvimentoPessoaProjetoInicio;
import br.com.tkcsapcd.model.util.Conexao;

public class EnvolvimentoPessoaProjetoInicioDAO implements InterfaceEnvolvimentoPessoaProjetoInicioDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	//Construtor que recebe o pool como parametro
	public EnvolvimentoPessoaProjetoInicioDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM envolvimentopessoa WHERE codigo = ?;";
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
	public void salvar(EnvolvimentoPessoaProjetoInicio envolvimentoPessoaProjetoInicio) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
								
			String sqlInsert = "INSERT INTO envolvimentopessoa(" +
			"codigoprojeto1, organizacao1, rh1, tiporh1, periodo1, esforco1, " +
			"codigoprojeto2, organizacao2, rh2, tiporh2, periodo2, esforco2," +
			"codigoprojeto3, organizacao3, rh3, tiporh3, periodo3, esforco3," +
			"codigoprojeto4, organizacao4, rh4, tiporh4, periodo4, esforco4," +
			"codigoprojeto5, organizacao5, rh5, tiporh5, periodo5, esforco5, " +
			"codigoprojeto6, organizacao6, rh6, tiporh6, periodo6, esforco6) VALUES (" +
			"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			ps = con.prepareStatement(sqlInsert);
			
			ps.setInt(1, envolvimentoPessoaProjetoInicio.getCodigoprojeto1());
			ps.setString(2, envolvimentoPessoaProjetoInicio.getOrganizacao1());
			ps.setString(3, envolvimentoPessoaProjetoInicio.getRh1());
			ps.setString(4, envolvimentoPessoaProjetoInicio.getTiporh1());
						
			ps.setDate(5, new java.sql.Date(envolvimentoPessoaProjetoInicio.getPeriodo1().getTime() )); //transforma o java util date em java sql date
			ps.setInt(6, envolvimentoPessoaProjetoInicio.getEsforco1());
			
			ps.setInt(7, envolvimentoPessoaProjetoInicio.getCodigoprojeto2());
			ps.setString(8, envolvimentoPessoaProjetoInicio.getOrganizacao2());
			ps.setString(9, envolvimentoPessoaProjetoInicio.getRh2());
			ps.setString(10, envolvimentoPessoaProjetoInicio.getTiporh2());
			ps.setDate(11, new java.sql.Date(envolvimentoPessoaProjetoInicio.getPeriodo2().getTime() )); //transforma o java util date em java sql date
			ps.setInt(12, envolvimentoPessoaProjetoInicio.getEsforco2());
			
			ps.setInt(13, envolvimentoPessoaProjetoInicio.getCodigoprojeto3());
			ps.setString(14, envolvimentoPessoaProjetoInicio.getOrganizacao3());
			ps.setString(15, envolvimentoPessoaProjetoInicio.getRh3());
			ps.setString(16, envolvimentoPessoaProjetoInicio.getTiporh3());
			ps.setDate(17, new java.sql.Date(envolvimentoPessoaProjetoInicio.getPeriodo3().getTime() )); //transforma o java util date em java sql date
			ps.setInt(18, envolvimentoPessoaProjetoInicio.getEsforco3());
			
			ps.setInt(19, envolvimentoPessoaProjetoInicio.getCodigoprojeto4());
			ps.setString(20, envolvimentoPessoaProjetoInicio.getOrganizacao4());
			ps.setString(21, envolvimentoPessoaProjetoInicio.getRh4());
			ps.setString(22, envolvimentoPessoaProjetoInicio.getTiporh4());
			ps.setDate(23, new java.sql.Date(envolvimentoPessoaProjetoInicio.getPeriodo4().getTime() )); //transforma o java util date em java sql date
			ps.setInt(24, envolvimentoPessoaProjetoInicio.getEsforco4());
			
			ps.setInt(25, envolvimentoPessoaProjetoInicio.getCodigoprojeto5());
			ps.setString(26, envolvimentoPessoaProjetoInicio.getOrganizacao5());
			ps.setString(27, envolvimentoPessoaProjetoInicio.getRh5());
			ps.setString(28, envolvimentoPessoaProjetoInicio.getTiporh5());
			ps.setDate(29, new java.sql.Date(envolvimentoPessoaProjetoInicio.getPeriodo5().getTime() )); //transforma o java util date em java sql date
			ps.setInt(30, envolvimentoPessoaProjetoInicio.getEsforco5());
			
			ps.setInt(31, envolvimentoPessoaProjetoInicio.getCodigoprojeto6());
			ps.setString(32, envolvimentoPessoaProjetoInicio.getOrganizacao6());
			ps.setString(33, envolvimentoPessoaProjetoInicio.getRh6());
			ps.setString(34, envolvimentoPessoaProjetoInicio.getTiporh6());
			ps.setDate(35, new java.sql.Date(envolvimentoPessoaProjetoInicio.getPeriodo6().getTime() )); //transforma o java util date em java sql date
			ps.setInt(36, envolvimentoPessoaProjetoInicio.getEsforco6());			
			
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
	public void atualizar(EnvolvimentoPessoaProjetoInicio envolvimentoPessoaProjetoInicio) throws Exception  {
		
			Connection con = Conexao.getConnection();
			PreparedStatement ps=null;						
									
			try{
				String sqlAtualizar = "UPDATE envolvimentopessoa SET " +
				"codigoprojeto1 = ?, organizacao1 = ?, rh1 = ?, tiporh1 = ?, periodo1 = ?, esforco1 = ?, " +
				"codigoprojeto2 = ?, organizacao2 = ?, rh2 = ?, tiporh2 = ?, periodo2 = ?, esforco2 = ?, " +
				"codigoprojeto3 = ?, organizacao3 = ?, rh3 = ?, tiporh3 = ?, periodo3 = ?, esforco3 = ?, " +
				"codigoprojeto4 = ?, organizacao4 = ?, rh4 = ?, tiporh4 = ?, periodo4 = ?, esforco4 = ?, " +
				"codigoprojeto5 = ?, organizacao5 = ?, rh5 = ?, tiporh5 = ?, periodo5 = ?, esforco5 = ?, " +
				"codigoprojeto6 = ?, organizacao6 = ?, rh6 = ?, tiporh6 = ?, periodo6 = ?, esforco6 = ? WHERE codigo = ?;";
				
				ps = con.prepareStatement(sqlAtualizar);
				setPreparedStatement(envolvimentoPessoaProjetoInicio, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	
	private void setPreparedStatement(EnvolvimentoPessoaProjetoInicio envolvimentoPessoaProjetoInicio, PreparedStatement ps) throws SQLException 
	{
		ps.setInt(1, envolvimentoPessoaProjetoInicio.getCodigoprojeto1());
		ps.setString(2, envolvimentoPessoaProjetoInicio.getOrganizacao1());
		ps.setString(3, envolvimentoPessoaProjetoInicio.getRh1());
		ps.setString(4, envolvimentoPessoaProjetoInicio.getTiporh1());
		ps.setDate(5, new java.sql.Date(envolvimentoPessoaProjetoInicio.getPeriodo1().getTime() )); //transforma o java util date em java sql date
		ps.setInt(6, envolvimentoPessoaProjetoInicio.getEsforco1());
		
		ps.setInt(7, envolvimentoPessoaProjetoInicio.getCodigoprojeto2());
		ps.setString(8, envolvimentoPessoaProjetoInicio.getOrganizacao2());
		ps.setString(9, envolvimentoPessoaProjetoInicio.getRh2());
		ps.setString(10, envolvimentoPessoaProjetoInicio.getTiporh2());
		ps.setDate(11, new java.sql.Date(envolvimentoPessoaProjetoInicio.getPeriodo2().getTime() )); //transforma o java util date em java sql date
		ps.setInt(12, envolvimentoPessoaProjetoInicio.getEsforco2());
		
		ps.setInt(13, envolvimentoPessoaProjetoInicio.getCodigoprojeto3());
		ps.setString(14, envolvimentoPessoaProjetoInicio.getOrganizacao3());
		ps.setString(15, envolvimentoPessoaProjetoInicio.getRh3());
		ps.setString(16, envolvimentoPessoaProjetoInicio.getTiporh3());
		ps.setDate(17, new java.sql.Date(envolvimentoPessoaProjetoInicio.getPeriodo3().getTime() )); //transforma o java util date em java sql date
		ps.setInt(18, envolvimentoPessoaProjetoInicio.getEsforco3());
		
		ps.setInt(19, envolvimentoPessoaProjetoInicio.getCodigoprojeto4());
		ps.setString(20, envolvimentoPessoaProjetoInicio.getOrganizacao4());
		ps.setString(21, envolvimentoPessoaProjetoInicio.getRh4());
		ps.setString(22, envolvimentoPessoaProjetoInicio.getTiporh4());
		ps.setDate(23, new java.sql.Date(envolvimentoPessoaProjetoInicio.getPeriodo4().getTime() )); //transforma o java util date em java sql date
		ps.setInt(24, envolvimentoPessoaProjetoInicio.getEsforco4());
		
		ps.setInt(25, envolvimentoPessoaProjetoInicio.getCodigoprojeto5());
		ps.setString(26, envolvimentoPessoaProjetoInicio.getOrganizacao5());
		ps.setString(27, envolvimentoPessoaProjetoInicio.getRh5());
		ps.setString(28, envolvimentoPessoaProjetoInicio.getTiporh5());
		ps.setDate(29, new java.sql.Date(envolvimentoPessoaProjetoInicio.getPeriodo5().getTime() )); //transforma o java util date em java sql date
		ps.setInt(30, envolvimentoPessoaProjetoInicio.getEsforco5());
		
		ps.setInt(31, envolvimentoPessoaProjetoInicio.getCodigoprojeto6());
		ps.setString(32, envolvimentoPessoaProjetoInicio.getOrganizacao6());
		ps.setString(33, envolvimentoPessoaProjetoInicio.getRh6());
		ps.setString(34, envolvimentoPessoaProjetoInicio.getTiporh6());
		ps.setDate(35, new java.sql.Date(envolvimentoPessoaProjetoInicio.getPeriodo6().getTime() )); //transforma o java util date em java sql date
		ps.setInt(36, envolvimentoPessoaProjetoInicio.getEsforco6());
		ps.setInt(37, envolvimentoPessoaProjetoInicio.getCodigo());//Atenção: necessário para isolar o metodo (extração). // Alterado dia 28/05/2014		
	}

	@Override
	public EnvolvimentoPessoaProjetoInicio  getEnvolvimentoPessoaProjetoInicio (Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM envolvimentopessoa WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<EnvolvimentoPessoaProjetoInicio> resultado = getListaEnvolvimentoPessoaProjetoInicio(rs);
			
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
	public List<EnvolvimentoPessoaProjetoInicio> getEnvolvimentoPessoaProjetoInicios() throws Exception 
	{				
				List<EnvolvimentoPessoaProjetoInicio> resultado = new ArrayList<EnvolvimentoPessoaProjetoInicio>();// Montar o resultado
				Connection con=null;
				PreparedStatement ps=null;
				ResultSet rs = null;
				try {
					con = Conexao.getConnection();					
					String sqlSelect = "SELECT * FROM envolvimentopessoa";
						
						ps = con.prepareStatement(sqlSelect);
						rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
						
						//resultado = getListaProjeto(rs);					
						// Laço p/ preencher
						while (rs.next()) {
							
							EnvolvimentoPessoaProjetoInicio envolvimentoPessoaProjetoInicio = new EnvolvimentoPessoaProjetoInicio();
							
							envolvimentoPessoaProjetoInicio.setCodigoprojeto1(rs.getInt("codigoprojeto1"));
							envolvimentoPessoaProjetoInicio.setOrganizacao1(rs.getString("organizacao1"));
							envolvimentoPessoaProjetoInicio.setRh1(rs.getString("rh1"));
							envolvimentoPessoaProjetoInicio.setTiporh1(rs.getString("tiporh1"));							
							envolvimentoPessoaProjetoInicio.setPeriodo1(rs.getDate("periodo1")); 
							envolvimentoPessoaProjetoInicio.setEsforco1(rs.getInt("esforco1"));
							
							envolvimentoPessoaProjetoInicio.setCodigoprojeto2(rs.getInt("codigoprojeto2"));
							envolvimentoPessoaProjetoInicio.setOrganizacao2(rs.getString("organizacao2"));
							envolvimentoPessoaProjetoInicio.setRh2(rs.getString("rh2"));
							envolvimentoPessoaProjetoInicio.setTiporh2(rs.getString("tiporh2"));
							envolvimentoPessoaProjetoInicio.setPeriodo2(rs.getDate("periodo2")); 
							envolvimentoPessoaProjetoInicio.setEsforco2(rs.getInt("esforco2"));
							
							envolvimentoPessoaProjetoInicio.setCodigoprojeto3(rs.getInt("codigoprojeto3"));
							envolvimentoPessoaProjetoInicio.setOrganizacao3(rs.getString("organizacao3"));
							envolvimentoPessoaProjetoInicio.setRh3(rs.getString("rh3"));
							envolvimentoPessoaProjetoInicio.setTiporh3(rs.getString("tiporh3"));
							envolvimentoPessoaProjetoInicio.setPeriodo3(rs.getDate("periodo3")); 
							envolvimentoPessoaProjetoInicio.setEsforco3(rs.getInt("esforco3"));
							
							envolvimentoPessoaProjetoInicio.setCodigoprojeto4(rs.getInt("codigoprojeto4"));
							envolvimentoPessoaProjetoInicio.setOrganizacao4(rs.getString("organizacao4"));
							envolvimentoPessoaProjetoInicio.setRh4(rs.getString("rh4"));
							envolvimentoPessoaProjetoInicio.setTiporh4(rs.getString("tiporh4"));
							envolvimentoPessoaProjetoInicio.setPeriodo4(rs.getDate("periodo4")); 
							envolvimentoPessoaProjetoInicio.setEsforco4(rs.getInt("esforco4"));
							
							envolvimentoPessoaProjetoInicio.setCodigoprojeto5(rs.getInt("codigoprojeto5"));
							envolvimentoPessoaProjetoInicio.setOrganizacao5(rs.getString("organizacao5"));
							envolvimentoPessoaProjetoInicio.setRh5(rs.getString("rh5"));
							envolvimentoPessoaProjetoInicio.setTiporh5(rs.getString("tiporh5"));
							envolvimentoPessoaProjetoInicio.setPeriodo5(rs.getDate("periodo5")); 
							envolvimentoPessoaProjetoInicio.setEsforco5(rs.getInt("esforco5"));
							
							envolvimentoPessoaProjetoInicio.setCodigoprojeto6(rs.getInt("codigoprojeto6"));
							envolvimentoPessoaProjetoInicio.setOrganizacao6(rs.getString("organizacao6"));
							envolvimentoPessoaProjetoInicio.setRh6(rs.getString("rh6"));
							envolvimentoPessoaProjetoInicio.setTiporh6(rs.getString("tiporh6"));
							envolvimentoPessoaProjetoInicio.setPeriodo6(rs.getDate("periodo6")); 
							envolvimentoPessoaProjetoInicio.setEsforco6(rs.getInt("esforco6"));
							envolvimentoPessoaProjetoInicio.setCodigo(rs.getInt("codigo"));
							
							/*
							//Atenção este código abaixo tenta executar a formatação da data no myql
							 * envolvimentoPessoaProjetoInicio.setCodigoprojeto1(rs.getInt("codigoprojeto1"));
							envolvimentoPessoaProjetoInicio.setOrganizacao1(rs.getString("organizacao1"));
							envolvimentoPessoaProjetoInicio.setRh1(rs.getString("rh1"));
							envolvimentoPessoaProjetoInicio.setTiporh1(rs.getString("tiporh1"));
							
							Date periodo_1 = envolvimentoPessoaProjetoInicio.setPeriodo1(rs.getDate("periodo1")); 
							String periodo1 = new SimpleDateFormat("dd/MM/yyyy").format(periodo_1);
							envolvimentoPessoaProjetoInicio.setPeriodo1((rs.getDate(periodo1)));
							
							//envolvimentoPessoaProjetoInicio.setPeriodo1(rs.getDate("periodo1")); 
							envolvimentoPessoaProjetoInicio.setEsforco1(rs.getInt("esforco1"));
							
							envolvimentoPessoaProjetoInicio.setCodigoprojeto2(rs.getInt("codigoprojeto2"));
							envolvimentoPessoaProjetoInicio.setOrganizacao2(rs.getString("organizacao2"));
							envolvimentoPessoaProjetoInicio.setRh2(rs.getString("rh2"));
							envolvimentoPessoaProjetoInicio.setTiporh2(rs.getString("tiporh2"));
							
							Date periodo_2 = envolvimentoPessoaProjetoInicio.setPeriodo2(rs.getDate("periodo2")); 
							String periodo2 = new SimpleDateFormat("dd/MM/yyyy").format(periodo_2);
							envolvimentoPessoaProjetoInicio.setPeriodo2((rs.getDate(periodo2)));
							
							//envolvimentoPessoaProjetoInicio.setPeriodo2(rs.getDate("periodo2")); 
							envolvimentoPessoaProjetoInicio.setEsforco2(rs.getInt("esforco2"));
							
							envolvimentoPessoaProjetoInicio.setCodigoprojeto3(rs.getInt("codigoprojeto3"));
							envolvimentoPessoaProjetoInicio.setOrganizacao3(rs.getString("organizacao3"));
							envolvimentoPessoaProjetoInicio.setRh3(rs.getString("rh3"));
							envolvimentoPessoaProjetoInicio.setTiporh3(rs.getString("tiporh3"));
							
							Date periodo_3 = envolvimentoPessoaProjetoInicio.setPeriodo3(rs.getDate("periodo3")); 
							String periodo3 = new SimpleDateFormat("dd/MM/yyyy").format(periodo_3);
							envolvimentoPessoaProjetoInicio.setPeriodo3((rs.getDate(periodo3)));
							
							//envolvimentoPessoaProjetoInicio.setPeriodo3(rs.getDate("periodo3")); 
							envolvimentoPessoaProjetoInicio.setEsforco3(rs.getInt("esforco3"));
							
							envolvimentoPessoaProjetoInicio.setCodigoprojeto4(rs.getInt("codigoprojeto4"));
							envolvimentoPessoaProjetoInicio.setOrganizacao4(rs.getString("organizacao4"));
							envolvimentoPessoaProjetoInicio.setRh4(rs.getString("rh4"));
							envolvimentoPessoaProjetoInicio.setTiporh4(rs.getString("tiporh4"));
							
							Date periodo_4 = envolvimentoPessoaProjetoInicio.setPeriodo4(rs.getDate("periodo4")); 
							String periodo4 = new SimpleDateFormat("dd/MM/yyyy").format(periodo_4);
							envolvimentoPessoaProjetoInicio.setPeriodo4((rs.getDate(periodo4)));
							
							//envolvimentoPessoaProjetoInicio.setPeriodo4(rs.getDate("periodo4")); 
							envolvimentoPessoaProjetoInicio.setEsforco4(rs.getInt("esforco4"));
							
							envolvimentoPessoaProjetoInicio.setCodigoprojeto5(rs.getInt("codigoprojeto5"));
							envolvimentoPessoaProjetoInicio.setOrganizacao5(rs.getString("organizacao5"));
							envolvimentoPessoaProjetoInicio.setRh5(rs.getString("rh5"));
							envolvimentoPessoaProjetoInicio.setTiporh5(rs.getString("tiporh5"));
							
							Date periodo_5 = envolvimentoPessoaProjetoInicio.setPeriodo5(rs.getDate("periodo5")); 
							String periodo5 = new SimpleDateFormat("dd/MM/yyyy").format(periodo_5);
							envolvimentoPessoaProjetoInicio.setPeriodo5((rs.getDate(periodo5)));
							
							//envolvimentoPessoaProjetoInicio.setPeriodo5(rs.getDate("periodo5")); 
							envolvimentoPessoaProjetoInicio.setEsforco5(rs.getInt("esforco5"));
							
							envolvimentoPessoaProjetoInicio.setCodigoprojeto6(rs.getInt("codigoprojeto6"));
							envolvimentoPessoaProjetoInicio.setOrganizacao6(rs.getString("organizacao6"));
							envolvimentoPessoaProjetoInicio.setRh6(rs.getString("rh6"));
							envolvimentoPessoaProjetoInicio.setTiporh6(rs.getString("tiporh6"));
							
							Date periodo_6 = envolvimentoPessoaProjetoInicio.setPeriodo6(rs.getDate("periodo6")); 
							String periodo6 = new SimpleDateFormat("dd/MM/yyyy").format(periodo_6);
							envolvimentoPessoaProjetoInicio.setPeriodo1((rs.getDate(periodo6)));
							
							//envolvimentoPessoaProjetoInicio.setPeriodo6(rs.getDate("periodo6")); 
							envolvimentoPessoaProjetoInicio.setEsforco6(rs.getInt("esforco6"));
							envolvimentoPessoaProjetoInicio.setCodigo(rs.getInt("codigo"));*/
											
							resultado.add(envolvimentoPessoaProjetoInicio);// Add o projeto ao resultado.
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

		//Metodo p confirma objetivo. Resulmir linhas de códigos, que pode ser usados em outros métodos. (ex: resultado = getListaCliente(rs); ou List<Cliente> resultado = getListaCliente(rs);)
		private List<EnvolvimentoPessoaProjetoInicio> getListaEnvolvimentoPessoaProjetoInicio(ResultSet rs) throws SQLException	{
				List<EnvolvimentoPessoaProjetoInicio> resultado = new ArrayList<EnvolvimentoPessoaProjetoInicio>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				EnvolvimentoPessoaProjetoInicio envolvimentoPessoaProjetoInicio = new EnvolvimentoPessoaProjetoInicio();
				
				envolvimentoPessoaProjetoInicio.setCodigoprojeto1(rs.getInt("codigoprojeto1"));
				envolvimentoPessoaProjetoInicio.setOrganizacao1(rs.getString("organizacao1"));
				envolvimentoPessoaProjetoInicio.setRh1(rs.getString("rh1"));
				envolvimentoPessoaProjetoInicio.setTiporh1(rs.getString("tiporh1"));								
				envolvimentoPessoaProjetoInicio.setPeriodo1(rs.getDate("periodo1")); 
				envolvimentoPessoaProjetoInicio.setEsforco1(rs.getInt("esforco1"));
				
				envolvimentoPessoaProjetoInicio.setCodigoprojeto2(rs.getInt("codigoprojeto2"));
				envolvimentoPessoaProjetoInicio.setOrganizacao2(rs.getString("organizacao2"));
				envolvimentoPessoaProjetoInicio.setRh2(rs.getString("rh2"));
				envolvimentoPessoaProjetoInicio.setTiporh2(rs.getString("tiporh2"));
				envolvimentoPessoaProjetoInicio.setPeriodo2(rs.getDate("periodo2")); 
				envolvimentoPessoaProjetoInicio.setEsforco2(rs.getInt("esforco2"));
				
				envolvimentoPessoaProjetoInicio.setCodigoprojeto3(rs.getInt("codigoprojeto3"));
				envolvimentoPessoaProjetoInicio.setOrganizacao3(rs.getString("organizacao3"));
				envolvimentoPessoaProjetoInicio.setRh3(rs.getString("rh3"));
				envolvimentoPessoaProjetoInicio.setTiporh3(rs.getString("tiporh3"));
				envolvimentoPessoaProjetoInicio.setPeriodo3(rs.getDate("periodo3")); 
				envolvimentoPessoaProjetoInicio.setEsforco3(rs.getInt("esforco3"));
				
				envolvimentoPessoaProjetoInicio.setCodigoprojeto4(rs.getInt("codigoprojeto4"));
				envolvimentoPessoaProjetoInicio.setOrganizacao4(rs.getString("organizacao4"));
				envolvimentoPessoaProjetoInicio.setRh4(rs.getString("rh4"));
				envolvimentoPessoaProjetoInicio.setTiporh4(rs.getString("tiporh4"));
				envolvimentoPessoaProjetoInicio.setPeriodo4(rs.getDate("periodo4")); 
				envolvimentoPessoaProjetoInicio.setEsforco4(rs.getInt("esforco4"));
				
				envolvimentoPessoaProjetoInicio.setCodigoprojeto5(rs.getInt("codigoprojeto5"));
				envolvimentoPessoaProjetoInicio.setOrganizacao5(rs.getString("organizacao5"));
				envolvimentoPessoaProjetoInicio.setRh5(rs.getString("rh5"));
				envolvimentoPessoaProjetoInicio.setTiporh5(rs.getString("tiporh5"));
				envolvimentoPessoaProjetoInicio.setPeriodo5(rs.getDate("periodo5")); 
				envolvimentoPessoaProjetoInicio.setEsforco5(rs.getInt("esforco5"));
				
				envolvimentoPessoaProjetoInicio.setCodigoprojeto6(rs.getInt("codigoprojeto6"));
				envolvimentoPessoaProjetoInicio.setOrganizacao6(rs.getString("organizacao6"));
				envolvimentoPessoaProjetoInicio.setRh6(rs.getString("rh6"));
				envolvimentoPessoaProjetoInicio.setTiporh6(rs.getString("tiporh6"));
				envolvimentoPessoaProjetoInicio.setPeriodo6(rs.getDate("periodo6")); 
				envolvimentoPessoaProjetoInicio.setEsforco6(rs.getInt("esforco6"));
				envolvimentoPessoaProjetoInicio.setCodigo(rs.getInt("codigo"));
				
				/*
				//Atenção este código abaixo tenta executar a formatação da data no myql
				envolvimentoPessoaProjetoInicio.setCodigoprojeto1(rs.getInt("codigoprojeto1"));
				envolvimentoPessoaProjetoInicio.setOrganizacao1(rs.getString("organizacao1"));
				envolvimentoPessoaProjetoInicio.setRh1(rs.getString("rh1"));
				envolvimentoPessoaProjetoInicio.setTiporh1(rs.getString("tiporh1"));
				
				Date periodo_1 = envolvimentoPessoaProjetoInicio.setPeriodo1(rs.getDate("periodo1")); 
				String periodo1 = new SimpleDateFormat("dd/MM/yyyy").format(periodo_1);
				envolvimentoPessoaProjetoInicio.setPeriodo1((rs.getDate(periodo1)));
				
				//envolvimentoPessoaProjetoInicio.setPeriodo1(rs.getDate("periodo1")); 
				envolvimentoPessoaProjetoInicio.setEsforco1(rs.getInt("esforco1"));
				
				envolvimentoPessoaProjetoInicio.setCodigoprojeto2(rs.getInt("codigoprojeto2"));
				envolvimentoPessoaProjetoInicio.setOrganizacao2(rs.getString("organizacao2"));
				envolvimentoPessoaProjetoInicio.setRh2(rs.getString("rh2"));
				envolvimentoPessoaProjetoInicio.setTiporh2(rs.getString("tiporh2"));
				
				Date periodo_2 = envolvimentoPessoaProjetoInicio.setPeriodo2(rs.getDate("periodo2")); 
				String periodo2 = new SimpleDateFormat("dd/MM/yyyy").format(periodo_2);
				envolvimentoPessoaProjetoInicio.setPeriodo2((rs.getDate(periodo2)));
				
				//envolvimentoPessoaProjetoInicio.setPeriodo2(rs.getDate("periodo2")); 
				envolvimentoPessoaProjetoInicio.setEsforco2(rs.getInt("esforco2"));
				
				envolvimentoPessoaProjetoInicio.setCodigoprojeto3(rs.getInt("codigoprojeto3"));
				envolvimentoPessoaProjetoInicio.setOrganizacao3(rs.getString("organizacao3"));
				envolvimentoPessoaProjetoInicio.setRh3(rs.getString("rh3"));
				envolvimentoPessoaProjetoInicio.setTiporh3(rs.getString("tiporh3"));
				
				Date periodo_3 = envolvimentoPessoaProjetoInicio.setPeriodo3(rs.getDate("periodo3")); 
				String periodo3 = new SimpleDateFormat("dd/MM/yyyy").format(periodo_3);
				envolvimentoPessoaProjetoInicio.setPeriodo3((rs.getDate(periodo3)));
				
				//envolvimentoPessoaProjetoInicio.setPeriodo3(rs.getDate("periodo3")); 
				envolvimentoPessoaProjetoInicio.setEsforco3(rs.getInt("esforco3"));
				
				envolvimentoPessoaProjetoInicio.setCodigoprojeto4(rs.getInt("codigoprojeto4"));
				envolvimentoPessoaProjetoInicio.setOrganizacao4(rs.getString("organizacao4"));
				envolvimentoPessoaProjetoInicio.setRh4(rs.getString("rh4"));
				envolvimentoPessoaProjetoInicio.setTiporh4(rs.getString("tiporh4"));
				
				Date periodo_4 = envolvimentoPessoaProjetoInicio.setPeriodo4(rs.getDate("periodo4")); 
				String periodo4 = new SimpleDateFormat("dd/MM/yyyy").format(periodo_4);
				envolvimentoPessoaProjetoInicio.setPeriodo4((rs.getDate(periodo4)));
				
				//envolvimentoPessoaProjetoInicio.setPeriodo4(rs.getDate("periodo4")); 
				envolvimentoPessoaProjetoInicio.setEsforco4(rs.getInt("esforco4"));
				
				envolvimentoPessoaProjetoInicio.setCodigoprojeto5(rs.getInt("codigoprojeto5"));
				envolvimentoPessoaProjetoInicio.setOrganizacao5(rs.getString("organizacao5"));
				envolvimentoPessoaProjetoInicio.setRh5(rs.getString("rh5"));
				envolvimentoPessoaProjetoInicio.setTiporh5(rs.getString("tiporh5"));
				
				Date periodo_5 = envolvimentoPessoaProjetoInicio.setPeriodo5(rs.getDate("periodo5")); 
				String periodo5 = new SimpleDateFormat("dd/MM/yyyy").format(periodo_5);
				envolvimentoPessoaProjetoInicio.setPeriodo5((rs.getDate(periodo5)));
				
				//envolvimentoPessoaProjetoInicio.setPeriodo5(rs.getDate("periodo5")); 
				envolvimentoPessoaProjetoInicio.setEsforco5(rs.getInt("esforco5"));
				
				envolvimentoPessoaProjetoInicio.setCodigoprojeto6(rs.getInt("codigoprojeto6"));
				envolvimentoPessoaProjetoInicio.setOrganizacao6(rs.getString("organizacao6"));
				envolvimentoPessoaProjetoInicio.setRh6(rs.getString("rh6"));
				envolvimentoPessoaProjetoInicio.setTiporh6(rs.getString("tiporh6"));
				
				Date periodo_6 = envolvimentoPessoaProjetoInicio.setPeriodo6(rs.getDate("periodo6")); 
				String periodo6 = new SimpleDateFormat("dd/MM/yyyy").format(periodo_6);
				envolvimentoPessoaProjetoInicio.setPeriodo1((rs.getDate(periodo6)));
				
				//envolvimentoPessoaProjetoInicio.setPeriodo6(rs.getDate("periodo6")); 
				envolvimentoPessoaProjetoInicio.setEsforco6(rs.getInt("esforco6"));
				envolvimentoPessoaProjetoInicio.setCodigo(rs.getInt("codigo"));*/
								
				resultado.add(envolvimentoPessoaProjetoInicio);// Add o projeto ao resultado.
			}		
			
			return resultado;
		}
	
		//---------------------------------------------------------------------------------------------------------------------------------------------

		@Override
		
		//Método para listar o nome projeto na tela do cadastro de alocação		
		public List<EnvolvimentoPessoaProjetoInicio> getEEnvolvimentoPessoaProjetoInicios() throws Exception  {
			// 
			List<EnvolvimentoPessoaProjetoInicio> resultado = new ArrayList<EnvolvimentoPessoaProjetoInicio>();
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs = null;
			
			try {
				con = Conexao.getConnection();	
				String sqlSelect = "SELECT * FROM envolvimentopessoa;";
					
					ps = con.prepareStatement(sqlSelect);
					rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
					
					//resultado = getListaDepartamentos(rs);	
					// Laço p/ preencher, enquanto o rs tiver registro, vai retornar verdadeiro e moverá o curso para o próximo(Laço p/ preencher).
					while (rs.next()) {
									
						EnvolvimentoPessoaProjetoInicio envolvimentoPessoaProjetoInicio = new EnvolvimentoPessoaProjetoInicio();
													
						envolvimentoPessoaProjetoInicio.setCodigoprojeto1(rs.getInt("codigoprojeto1"));
						envolvimentoPessoaProjetoInicio.setOrganizacao1(rs.getString("organizacao1"));
													
						// Add o cliente ao resultado
						resultado.add(envolvimentoPessoaProjetoInicio);
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
		
		//---------------------------------------------------------------------------------------------------------------------------------------------

		
}

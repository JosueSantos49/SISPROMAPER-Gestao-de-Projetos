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
import br.com.tkcsapcd.model.bean.Cliente;
import br.com.tkcsapcd.model.util.Conexao;

public class ClienteDAO implements InterfaceClienteDAO {

	//ClienteDAO solicita o pool.
	@SuppressWarnings("unused")
	private InterfacePool pool;
	
	//Construtor que recebe o pool como parametro
	public ClienteDAO(InterfacePool pool) {
		this.pool = pool;
	}

	@Override
	public void excluir(Integer codigo) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;		
		
		try {
			String sqlExcluir = "DELETE FROM cliente WHERE codigo = ?;";
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
	public void salvar(Cliente cliente) throws Exception {
		
		Connection con = Conexao.getConnection();	
		PreparedStatement ps=null;
		try {
				
			String sqlInsert = "INSERT INTO cliente(nome," +
					" endereco," +
					" email," +
					" bairro," +
					" cidade," +
					" cep," +
					" estado," +
					" fone," +
					" celular," +
					" cpf," +
					" obs," +
					" rg," +
					" orgaorg," +
					" nascimento," +
					" desde," +
					" cnpj," +
					" insest," +
					" sexo," +
					" profissao," +
					" empresa," +
					" foneemp," +					
					" renda," +
					" referencia," +
					" foneref," +
					" auditoria) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			ps = con.prepareStatement(sqlInsert);			
			
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEndereco());
			ps.setString(3, cliente.getEmail());
			ps.setString(4, cliente.getBairro());			
			ps.setString(5, cliente.getCidade());
			ps.setString(6, cliente.getCep());
			ps.setString(7, cliente.getEstado());
			ps.setString(8, cliente.getFone());
			ps.setString(9, cliente.getCelular());
			ps.setString(10, cliente.getCpf());
			ps.setString(11, cliente.getObs());
			ps.setString(12, cliente.getRg());
			ps.setString(13, cliente.getOrgaorg());
			ps.setString(14, cliente.getNascimento());
			ps.setString(15, cliente.getDesde());
			ps.setString(16, cliente.getCnpj());
			ps.setString(17, cliente.getInsest());
			ps.setString(18, cliente.getSexo());
			ps.setString(19, cliente.getProfissao());
			ps.setString(20, cliente.getEmpresa());		
			ps.setString(21, cliente.getFoneemp());
			ps.setObject(22, cliente.getRenda());//verificar urgente esta linha	
			ps.setString(23, cliente.getReferencia());
			ps.setString(24, cliente.getFoneref());
			ps.setString(25, cliente.getAuditoria());						
			
			//setPreparedStatement(cliente, ps);//Isolamento de todo código, exemplo: ps.setString(1, cliente.getAuditoria());
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
	/*---------------------------------------------------------------------------------------------------------------------------------------*/

	@Override
	public Cliente getCliente(Integer codigo) throws Exception {
		
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;		
		try {
			
			String sqlSelect = "SELECT * FROM cliente WHERE codigo = ?;";			
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<Cliente> resultado = getListaCliente(rs);
			
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
	/*---------------------------------------------------------------------------------------------------------------------------------------*/

	@Override	
	public void atualizar(Cliente cliente) throws Exception {

		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;	

		try {	
			String sqlAtualizar = "UPDATE cliente SET nome = ?," +
					" endereco = ?," +
					" email = ?," +
					" bairro = ?," +
					" cidade = ?," +
					" cep = ?," +
					" estado = ?," +
					" fone = ?," +
					" celular = ?," +
					" cpf = ?," +
					" obs = ?, " +
					" rg = ?," +
					" orgaorg = ?," +
					" nascimento = ?," +
					" desde = ?," +
					" cnpj = ?," +
					" insest = ?," +
					" sexo = ?," +					
					" profissao = ?," +
					" empresa = ?," +
					" foneemp = ?," +
					" renda = ?," +
					" referencia = ?," +
					" foneref = ?," +
					" auditoria = ?	 WHERE codigo = ?;";
			
			ps = con.prepareStatement(sqlAtualizar);	
			
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEndereco());
			ps.setString(3, cliente.getEmail());
			ps.setString(4, cliente.getBairro());			
			ps.setString(5, cliente.getCidade());
			ps.setString(6, cliente.getCep());
			ps.setString(7, cliente.getEstado());
			ps.setString(8, cliente.getFone());
			ps.setString(9, cliente.getCelular());
			ps.setString(10, cliente.getCpf());
			ps.setString(11, cliente.getObs());
			ps.setString(12, cliente.getRg());
			ps.setString(13, cliente.getOrgaorg());
			ps.setString(14, cliente.getNascimento());
			ps.setString(15, cliente.getDesde());
			ps.setString(16, cliente.getCnpj());
			ps.setString(17, cliente.getInsest());
			ps.setString(18, cliente.getSexo());
			ps.setString(19, cliente.getProfissao());
			ps.setString(20, cliente.getEmpresa());		
			ps.setString(21, cliente.getFoneemp());
			ps.setObject(22, cliente.getRenda());//verificar urgente esta linha	
			ps.setString(23, cliente.getReferencia());
			ps.setString(24, cliente.getFoneref());
			ps.setString(25, cliente.getAuditoria());
			ps.setObject(26, cliente.getCodigo());//Atenção: necessário para isolar o metodo (extração).
			
			//setPreparedStatement(cliente, ps);//Código isolado do metodo sqlInsert permite usar a mesma linha, facilitando!
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
	/*
	 @Override	
	public void atualizar(Cliente cliente) throws SQLException {

		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;	

		try {	
			String sqlAtualizar = "UPDATE cliente SET nome = ?," +
					" sexo = ?," +
					" nascimento = ?," +
					" profissao = ?," +
					" renda = ?," +
					" rg = ?," +
					" orgaorg = ?," +
					" fone = ?," +
					" celular = ?," +
					" endereco = ?," +
					" bairro = ?," +
					" estado = ?," +
					" cidade = ?," +
					" cep = ?," +
					" cpf = ?," +
					" cnpj = ?," +
					" insest = ?," +
					" desde = ?," +
					" email = ?," +
					" empresa = ?," +
					" foneemp = ?," +
					" referencia = ?," +
					" foneref = ?," +
					" auditoria = ?," +
					" obs = ? WHERE codigo = ?;";
			
			ps = con.prepareStatement(sqlAtualizar);			
			setPreparedStatement(cliente, ps);//Código isolado do metodo sqlInsert permite usar a mesma linha, facilitando!
			ps.executeUpdate();//Linha muito importante, sem ela não é executado a atualização do cliente
			ps.close();	
			
		}finally
		{
			con.close();
		}
	}
	 */

	@Override
	public List<Cliente> getClientes() throws Exception {		
		
		List<Cliente> resultado = new ArrayList<Cliente>();// Montar o resultado
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
				
		try {		
			con = Conexao.getConnection();
							
			String sqlSelect = "SELECT * FROM cliente;";
			
			ps = con.prepareStatement(sqlSelect);
			rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
			
			//resultado = getListaCliente(rs);	
			// Laço p/ preencher
			while (rs.next()) {
				
				// criando objeto Cliente para cada registro no BD 
				Cliente cliente = new Cliente();
				
				cliente.setNome(rs.getString("nome"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setEmail(rs.getString("email"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setCep(rs.getString("cep"));
				cliente.setEstado(rs.getString("estado"));
				cliente.setFone(rs.getString("fone"));
				cliente.setCelular(rs.getString("celular"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setObs(rs.getString("obs"));
				cliente.setRg(rs.getString("rg"));
				cliente.setOrgaorg(rs.getString("orgaorg"));
				cliente.setNascimento(rs.getString("nascimento"));
				cliente.setDesde(rs.getString("desde"));
				cliente.setCnpj(rs.getString("cnpj"));
				cliente.setInsest(rs.getString("insest"));			
				cliente.setSexo(rs.getString("sexo"));				
				cliente.setProfissao(rs.getString("profissao")); 
				cliente.setEmpresa(rs.getString("empresa"));
				cliente.setFoneemp(rs.getString("foneemp"));
				cliente.setRenda(rs.getString("renda"));
				cliente.setReferencia(rs.getString("referencia"));
				cliente.setFoneref(rs.getString("foneref"));
				cliente.setAuditoria(rs.getString("auditoria"));			
				cliente.setCodigo(rs.getLong("codigo"));
								
				resultado.add(cliente);// Add o cliente ao resultado
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
/*---------------------------------------------------------------------------------------------------------------------------------------*/

	//Metodo p confirma, objetivo resulmir linhas de códigos, que pode ser usados em outros métodos. (ex: resultado = getListaCliente(rs); ou List<Cliente> resultado = getListaCliente(rs);)
	private List<Cliente> getListaCliente(ResultSet rs) throws SQLException	{		
		List<Cliente> resultado = new ArrayList<Cliente>();
		
		// Laço p/ preencher
		while (rs.next()) {
			
			// criando objeto para cada registro no BD 
			Cliente cliente = new Cliente();
			
			//Passando os valores que estão na tabela para o objeto cliente  
			cliente.setNome(rs.getString("nome"));
			cliente.setEndereco(rs.getString("endereco"));
			cliente.setEmail(rs.getString("email"));
			cliente.setBairro(rs.getString("bairro"));
			cliente.setCidade(rs.getString("cidade"));
			cliente.setCep(rs.getString("cep"));
			cliente.setEstado(rs.getString("estado"));
			cliente.setFone(rs.getString("fone"));
			cliente.setCelular(rs.getString("celular"));
			cliente.setCpf(rs.getString("cpf"));
			cliente.setObs(rs.getString("obs"));
			cliente.setRg(rs.getString("rg"));
			cliente.setOrgaorg(rs.getString("orgaorg"));
			cliente.setNascimento(rs.getString("nascimento"));
			cliente.setDesde(rs.getString("desde"));
			cliente.setCnpj(rs.getString("cnpj"));
			cliente.setInsest(rs.getString("insest"));			
			cliente.setSexo(rs.getString("sexo"));				
			cliente.setProfissao(rs.getString("profissao")); 
			cliente.setEmpresa(rs.getString("empresa"));
			cliente.setFoneemp(rs.getString("foneemp"));
			cliente.setRenda(rs.getString("renda"));
			cliente.setReferencia(rs.getString("referencia"));
			cliente.setFoneref(rs.getString("foneref"));
			cliente.setAuditoria(rs.getString("auditoria"));			
			cliente.setCodigo(rs.getLong("codigo"));
						
			resultado.add(cliente);// Add o cliente ao resultado
		}		
		return resultado;
	}
}

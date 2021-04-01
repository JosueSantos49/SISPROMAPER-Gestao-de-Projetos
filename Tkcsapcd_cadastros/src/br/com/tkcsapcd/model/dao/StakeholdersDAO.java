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
import br.com.tkcsapcd.model.bean.Stakeholders;
import br.com.tkcsapcd.model.util.Conexao;

public class StakeholdersDAO implements InterfaceStakeholdersDAO {

	//DAO solicita o pool.
	@SuppressWarnings("unused")
	private InterfacePool pool;
	
	//Construtor que recebe o pool como parametro
	public StakeholdersDAO(InterfacePool pool) {
		this.pool = pool;
	}

	@Override
	public void excluir(Integer codigo) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;		
		
		try {
			String sqlExcluir = "DELETE FROM stakeholders WHERE codigo = ?;";
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
	public void salvar(Stakeholders stakeholders) throws Exception {
		
		Connection con = Conexao.getConnection();	
		PreparedStatement ps=null;
		try {	
			String sqlInsert = "INSERT INTO stakeholders(empresa," +
					" orgao," +
					" setor," +
					" programa," +
					" projeto," +
					" gerente," +
					" funcao," +
					" aprovado," +
					" versao," +
					" dataaprovacao," +
					" referencia," +
					" nome," +
					" empresaequipe," +
					" cargocompetencia," +
					" email," +
					" telefone," +
					" endereco," +
					" obs, codigoprojeto) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			ps = con.prepareStatement(sqlInsert);			
			
			ps.setString(1, stakeholders.getEmpresa());
			ps.setString(2, stakeholders.getOrgao());
			ps.setString(3, stakeholders.getSetor());
			ps.setString(4, stakeholders.getPrograma());			
			ps.setString(5, stakeholders.getProjeto());
			ps.setString(6, stakeholders.getGerente());
			ps.setString(7, stakeholders.getFuncao());
			ps.setString(8, stakeholders.getAprovado());
			ps.setString(9, stakeholders.getVersao());
			ps.setString(10, stakeholders.getDataaprovacao());
			ps.setString(11, stakeholders.getReferencia());
			ps.setString(12, stakeholders.getNome());
			ps.setString(13, stakeholders.getEmpresaequipe());
			ps.setString(14, stakeholders.getCargocompetencia());
			ps.setString(15, stakeholders.getEmail());
			ps.setString(16, stakeholders.getTelefone());
			ps.setString(17, stakeholders.getEndereco());
			ps.setString(18, stakeholders.getObs());
			ps.setString(19, stakeholders.getCodigoprojeto());
			
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
	public Stakeholders getStakeholders(Integer codigo) throws Exception {
		
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;		
		try {
			
			String sqlSelect = "SELECT * FROM stakeholders WHERE codigo = ?;";			
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<Stakeholders> resultado = getListaStakeholders(rs);
			
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
	public void atualizar(Stakeholders stakeholders) throws Exception {

		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;	

		try {	
			String sqlAtualizar = "UPDATE stakeholders SET empresa = ?," +
					" orgao = ?," +
					" setor = ?," +
					" programa = ?," +
					" projeto = ?," +
					" gerente = ?," +
					" funcao = ?," +
					" aprovado = ?," +
					" versao = ?," +
					" dataaprovacao = ?," +
					" referencia = ?," +
					" nome = ?," +
					" empresaequipe = ?," +
					" cargocompetencia = ?," +
					" email = ?," +
					" telefone = ?," +
					" endereco = ?," +
					" obs = ?, codigoprojeto = ? WHERE codigo = ?;";
			
			ps = con.prepareStatement(sqlAtualizar);	
			
			ps.setString(1, stakeholders.getEmpresa());
			ps.setString(2, stakeholders.getOrgao());
			ps.setString(3, stakeholders.getSetor());
			ps.setString(4, stakeholders.getPrograma());			
			ps.setString(5, stakeholders.getProjeto());
			ps.setString(6, stakeholders.getGerente());
			ps.setString(7, stakeholders.getFuncao());
			ps.setString(8, stakeholders.getAprovado());
			ps.setString(9, stakeholders.getVersao());
			ps.setString(10, stakeholders.getDataaprovacao());
			ps.setString(11, stakeholders.getReferencia());
			ps.setString(12, stakeholders.getNome());
			ps.setString(13, stakeholders.getEmpresaequipe());
			ps.setString(14, stakeholders.getCargocompetencia());
			ps.setString(15, stakeholders.getEmail());
			ps.setString(16, stakeholders.getTelefone());
			ps.setString(17, stakeholders.getEndereco());
			ps.setString(18, stakeholders.getObs());
			ps.setString(19, stakeholders.getCodigoprojeto());
			ps.setObject(20, stakeholders.getCodigo());//Atenção: necessário para isolar o metodo (extração).
			
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

	@Override
	public List<Stakeholders> getStakeholderss() throws Exception {		
		
		List<Stakeholders> resultado = new ArrayList<Stakeholders>();// Montar o resultado
		Connection con = null;
		PreparedStatement ps=null;	
		ResultSet rs = null;
				
		try {		
			con = Conexao.getConnection();
						
			String sqlSelect = "SELECT * FROM stakeholders;";
			
			ps = con.prepareStatement(sqlSelect);
			rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
			
			//resultado = getListaCliente(rs);	
			// Laço p/ preencher
			while (rs.next()) {
				
				// criando objeto Cliente para cada registro no BD 
				Stakeholders stakeholders = new Stakeholders();
				
				stakeholders.setEmpresa(rs.getString("empresa"));
				stakeholders.setOrgao(rs.getString("orgao"));
				stakeholders.setSetor(rs.getString("setor"));
				stakeholders.setPrograma(rs.getString("programa"));
				stakeholders.setProjeto(rs.getString("projeto"));
				stakeholders.setGerente(rs.getString("gerente"));
				stakeholders.setFuncao(rs.getString("funcao"));
				stakeholders.setAprovado(rs.getString("aprovado"));
				stakeholders.setVersao(rs.getString("versao"));
				stakeholders.setDataaprovacao(rs.getString("dataaprovacao"));
				stakeholders.setReferencia(rs.getString("referencia"));
				stakeholders.setNome(rs.getString("nome"));
				stakeholders.setEmpresaequipe(rs.getString("empresaequipe"));
				stakeholders.setCargocompetencia(rs.getString("cargocompetencia"));
				stakeholders.setEmail(rs.getString("email"));
				stakeholders.setTelefone(rs.getString("telefone"));
				stakeholders.setEndereco(rs.getString("endereco"));
				stakeholders.setObs(rs.getString("obs"));
				stakeholders.setCodigoprojeto(rs.getString("codigoprojeto"));
				stakeholders.setCodigo(rs.getInt("codigo"));
								
				resultado.add(stakeholders);// Add o cliente ao resultado
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
	private List<Stakeholders> getListaStakeholders(ResultSet rs) throws SQLException	{		
		List<Stakeholders> resultado = new ArrayList<Stakeholders>();
		
		// Laço p/ preencher
		while (rs.next()) {
			
			// criando objeto para cada registro no BD 
			Stakeholders stakeholders = new Stakeholders();
			
			//Passando os valores que estão na tabela para o objeto cliente  
			stakeholders.setEmpresa(rs.getString("empresa"));
			stakeholders.setOrgao(rs.getString("orgao"));
			stakeholders.setSetor(rs.getString("setor"));
			stakeholders.setPrograma(rs.getString("programa"));
			stakeholders.setProjeto(rs.getString("projeto"));
			stakeholders.setGerente(rs.getString("gerente"));
			stakeholders.setFuncao(rs.getString("funcao"));
			stakeholders.setAprovado(rs.getString("aprovado"));
			stakeholders.setVersao(rs.getString("versao"));
			stakeholders.setDataaprovacao(rs.getString("dataaprovacao"));
			stakeholders.setReferencia(rs.getString("referencia"));
			stakeholders.setNome(rs.getString("nome"));
			stakeholders.setEmpresaequipe(rs.getString("empresaequipe"));
			stakeholders.setCargocompetencia(rs.getString("cargocompetencia"));
			stakeholders.setEmail(rs.getString("email"));
			stakeholders.setTelefone(rs.getString("telefone"));
			stakeholders.setEndereco(rs.getString("endereco"));
			stakeholders.setObs(rs.getString("obs"));
			stakeholders.setCodigoprojeto(rs.getString("codigoprojeto"));
			stakeholders.setCodigo(rs.getInt("codigo"));
						
			resultado.add(stakeholders);// Add o cliente ao resultado
		}		
		return resultado;
	}
}

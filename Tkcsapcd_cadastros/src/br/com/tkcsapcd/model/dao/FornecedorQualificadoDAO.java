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
import br.com.tkcsapcd.model.bean.FornecedorQualificado;
import br.com.tkcsapcd.model.util.Conexao;

public class FornecedorQualificadoDAO implements InterfaceFornecedorQualificadoDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public FornecedorQualificadoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM fornecedorqualificado WHERE codigo = ?;";

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
	private void setPreparedStatement(FornecedorQualificado fornecedorQualificado, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, fornecedorQualificado.getRazaosocial());
		ps.setInt(2, fornecedorQualificado.getTelefone());
		ps.setInt(3, fornecedorQualificado.getFax());
		ps.setString(4, fornecedorQualificado.getEndereco());
		ps.setString(5, fornecedorQualificado.getBairro());
		ps.setString(6, fornecedorQualificado.getCidade());
		ps.setString(7, fornecedorQualificado.getEstado());
		ps.setInt(8, fornecedorQualificado.getCep());
		ps.setObject(9, fornecedorQualificado.getCnpj());
		ps.setString(10, fornecedorQualificado.getInscricaoestadual());
		ps.setString(11, fornecedorQualificado.getInscricaomunicipal());		
		ps.setString(12, fornecedorQualificado.getContato());
		ps.setString(13, fornecedorQualificado.getNomefantasia());
		ps.setInt(14, fornecedorQualificado.getCelular());	
		ps.setString(15, fornecedorQualificado.getEmail());
		ps.setString(16, fornecedorQualificado.getHomepage());
		ps.setString(17, fornecedorQualificado.getProdutos());
		ps.setString(18, fornecedorQualificado.getMarcas());
		ps.setInt(19, fornecedorQualificado.getBanco());
		ps.setInt(20, fornecedorQualificado.getAgencia());
		ps.setInt(21, fornecedorQualificado.getConta());
		ps.setString(22, fornecedorQualificado.getContratosocial());
		ps.setObject(23, fornecedorQualificado.getCartaocnpj());			
		ps.setObject(24, fornecedorQualificado.getFazendafederal());
		ps.setObject(25, fornecedorQualificado.getFazendaestadual());
		ps.setObject(26, fornecedorQualificado.getFazendamunicipal());
		ps.setObject(27, fornecedorQualificado.getInss());
		ps.setObject(28, fornecedorQualificado.getFgts());
		ps.setObject(29, fornecedorQualificado.getCapacidadetecnica());
		ps.setObject(30, fornecedorQualificado.getRelacaocliente());			
		ps.setObject(31, fornecedorQualificado.getReferenciacomenrcail());
		ps.setObject(32, fornecedorQualificado.getRegistro());
		ps.setObject(33, fornecedorQualificado.getCertidaonegativa());
		ps.setInt(24, fornecedorQualificado.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public FornecedorQualificado getFornecedorQualificado(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM fornecedorqualificado WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<FornecedorQualificado> resultado = getListaFornecedorQualificado(rs);
			
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
		private List<FornecedorQualificado> getListaFornecedorQualificado(ResultSet rs) throws SQLException	{
				List<FornecedorQualificado> resultado = new ArrayList<FornecedorQualificado>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				
				FornecedorQualificado fornecedorQualificado = new FornecedorQualificado();
				
				fornecedorQualificado.setRazaosocial(rs.getString("razaosocial"));
				fornecedorQualificado.setTelefone(rs.getInt("telefone"));
				fornecedorQualificado.setFax(rs.getInt("fax"));
				fornecedorQualificado.setEndereco(rs.getString("endereco"));
				fornecedorQualificado.setBairro(rs.getString("bairro"));
				fornecedorQualificado.setCidade(rs.getString("cidade"));
				fornecedorQualificado.setEstado(rs.getString("estado"));
				fornecedorQualificado.setCep(rs.getInt("cep"));
				fornecedorQualificado.setCnpj(rs.getInt("cnpj"));				
				fornecedorQualificado.setInscricaoestadual(rs.getString("inscricaoestadual"));					
				fornecedorQualificado.setInscricaomunicipal(rs.getString("inscricaomunicipal"));
				fornecedorQualificado.setContato(rs.getString("contato"));
				fornecedorQualificado.setNomefantasia(rs.getString("nomefantasia"));
				fornecedorQualificado.setCelular(rs.getInt("celular"));
				fornecedorQualificado.setEmail(rs.getString("email"));
				fornecedorQualificado.setHomepage(rs.getString("homepage"));
				fornecedorQualificado.setProdutos(rs.getString("produtos"));
				fornecedorQualificado.setMarcas(rs.getString("marcas"));					
				fornecedorQualificado.setBanco(rs.getInt("banco"));
				fornecedorQualificado.setAgencia(rs.getInt("agencia"));
				fornecedorQualificado.setConta(rs.getInt("conta"));
				fornecedorQualificado.setContratosocial(rs.getString("contratosocial"));	
				fornecedorQualificado.setCartaocnpj(rs.getString("cartaocnpj"));
				fornecedorQualificado.setFazendafederal(rs.getString("fazendafederal"));
				fornecedorQualificado.setFazendaestadual(rs.getString("fazendaestadual"));
				fornecedorQualificado.setFazendamunicipal(rs.getString("fazendamunicipal"));
				fornecedorQualificado.setInss(rs.getString("inss"));
				fornecedorQualificado.setFgts(rs.getString("fgts"));
				fornecedorQualificado.setCapacidadetecnica(rs.getString("capacidadetecnica"));
				fornecedorQualificado.setRelacaocliente(rs.getString("relacaocliente"));
				fornecedorQualificado.setReferenciacomenrcail(rs.getString("referenciacomenrcail"));
				fornecedorQualificado.setRegistro(rs.getString("registro"));
				fornecedorQualificado.setCertidaonegativa(rs.getString("certidaonegativa"));
				
				fornecedorQualificado.setCodigo(rs.getInt("codigo"));
												
				resultado.add(fornecedorQualificado);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(FornecedorQualificado fornecedorQualificado) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE fornecedorqualificado SET razaosocial = ?, telefone = ?, fax = ?, endereco = ?, bairro = ?, cidade = ?, estado = ?, cep = ?, cnpj = ?, inscricaoestadual = ?, inscricaomunicipal = ?, contato = ?, nomefantasia  = ?, celular = ?, email = ?, homepage = ?, produtos = ?, marcas = ?, banco = ?, agencia = ?, conta = ?, contratosocial = ?, cartaocnpj = ?, fazendafederal = ?, fazendaestadual = ?, fazendamunicipal = ?, inss = ?, fgts = ?, capacidadetecnica = ?, relacaocliente = ?, referenciacomenrcail = ?, registro = ?, certidaonegativa = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(fornecedorQualificado, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(FornecedorQualificado fornecedorQualificado) throws Exception  {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO fornecedorqualificado(razaosocial, telefone, fax, endereco, bairro, cidade, estado, cep, cnpj, inscricaoestadual, inscricaomunicipal," +
			"contato, nomefantasia, celular, email,homepage, produtos, marcas, banco, agencia, conta, contratosocial, cartaocnpj, fazendafederal, fazendaestadual,fazendamunicipal," +
			" inss, fgts, capacidadetecnica, relacaocliente,referenciacomenrcail, registro,certidaonegativa) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, fornecedorQualificado.getRazaosocial());
			ps.setInt(2, fornecedorQualificado.getTelefone());
			ps.setInt(3, fornecedorQualificado.getFax());
			ps.setString(4, fornecedorQualificado.getEndereco());
			ps.setString(5, fornecedorQualificado.getBairro());
			ps.setString(6, fornecedorQualificado.getCidade());
			ps.setString(7, fornecedorQualificado.getEstado());
			ps.setInt(8, fornecedorQualificado.getCep());
			ps.setObject(9, fornecedorQualificado.getCnpj());
			ps.setString(10, fornecedorQualificado.getInscricaoestadual());
			ps.setString(11, fornecedorQualificado.getInscricaomunicipal());		
			ps.setString(12, fornecedorQualificado.getContato());
			ps.setString(13, fornecedorQualificado.getNomefantasia());
			ps.setInt(14, fornecedorQualificado.getCelular());	
			ps.setString(15, fornecedorQualificado.getEmail());
			ps.setString(16, fornecedorQualificado.getHomepage());
			ps.setString(17, fornecedorQualificado.getProdutos());
			ps.setString(18, fornecedorQualificado.getMarcas());
			ps.setInt(19, fornecedorQualificado.getBanco());
			ps.setInt(20, fornecedorQualificado.getAgencia());
			ps.setInt(21, fornecedorQualificado.getConta());
			ps.setString(22, fornecedorQualificado.getContratosocial());
			ps.setObject(23, fornecedorQualificado.getCartaocnpj());			
			ps.setObject(24, fornecedorQualificado.getFazendafederal());
			ps.setObject(25, fornecedorQualificado.getFazendaestadual());
			ps.setObject(26, fornecedorQualificado.getFazendamunicipal());
			ps.setObject(27, fornecedorQualificado.getInss());
			ps.setObject(28, fornecedorQualificado.getFgts());
			ps.setObject(29, fornecedorQualificado.getCapacidadetecnica());
			ps.setObject(30, fornecedorQualificado.getRelacaocliente());			
			ps.setObject(31, fornecedorQualificado.getReferenciacomenrcail());
			ps.setObject(32, fornecedorQualificado.getRegistro());
			ps.setObject(33, fornecedorQualificado.getCertidaonegativa());
			
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
	public List<FornecedorQualificado> getFornecedorQualificados() throws Exception {		
		   List<FornecedorQualificado> resultado = new ArrayList<FornecedorQualificado>();// Montar o resultado
		   
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();			
			String sqlSelect = "SELECT * FROM fornecedorqualificado";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					
					FornecedorQualificado fornecedorQualificado = new FornecedorQualificado();
				
					fornecedorQualificado.setRazaosocial(rs.getString("razaosocial"));
					fornecedorQualificado.setTelefone(rs.getInt("telefone"));
					fornecedorQualificado.setFax(rs.getInt("fax"));
					fornecedorQualificado.setEndereco(rs.getString("endereco"));
					fornecedorQualificado.setBairro(rs.getString("bairro"));
					fornecedorQualificado.setCidade(rs.getString("cidade"));
					fornecedorQualificado.setEstado(rs.getString("estado"));
					fornecedorQualificado.setCep(rs.getInt("cep"));
					fornecedorQualificado.setCnpj(rs.getInt("cnpj"));				
					fornecedorQualificado.setInscricaoestadual(rs.getString("inscricaoestadual"));					
					fornecedorQualificado.setInscricaomunicipal(rs.getString("inscricaomunicipal"));
					fornecedorQualificado.setContato(rs.getString("contato"));
					fornecedorQualificado.setNomefantasia(rs.getString("nomefantasia"));
					fornecedorQualificado.setCelular(rs.getInt("celular"));
					fornecedorQualificado.setEmail(rs.getString("email"));
					fornecedorQualificado.setHomepage(rs.getString("homepage"));
					fornecedorQualificado.setProdutos(rs.getString("produtos"));
					fornecedorQualificado.setMarcas(rs.getString("marcas"));					
					fornecedorQualificado.setBanco(rs.getInt("banco"));
					fornecedorQualificado.setAgencia(rs.getInt("agencia"));
					fornecedorQualificado.setConta(rs.getInt("conta"));
					fornecedorQualificado.setContratosocial(rs.getString("contratosocial"));	
					fornecedorQualificado.setCartaocnpj(rs.getString("cartaocnpj"));
					fornecedorQualificado.setFazendafederal(rs.getString("fazendafederal"));
					fornecedorQualificado.setFazendaestadual(rs.getString("fazendaestadual"));
					fornecedorQualificado.setFazendamunicipal(rs.getString("fazendamunicipal"));
					fornecedorQualificado.setInss(rs.getString("inss"));
					fornecedorQualificado.setFgts(rs.getString("fgts"));
					fornecedorQualificado.setCapacidadetecnica(rs.getString("capacidadetecnica"));
					fornecedorQualificado.setRelacaocliente(rs.getString("relacaocliente"));
					fornecedorQualificado.setReferenciacomenrcail(rs.getString("referenciacomenrcail"));
					fornecedorQualificado.setRegistro(rs.getString("registro"));
					fornecedorQualificado.setCertidaonegativa(rs.getString("certidaonegativa"));
					fornecedorQualificado.setCodigo(rs.getInt("codigo"));
									
					resultado.add(fornecedorQualificado);// Add o projeto ao resultado.
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

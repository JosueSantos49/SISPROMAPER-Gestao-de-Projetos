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
import br.com.tkcsapcd.model.bean.TabelaParteInteressada;
import br.com.tkcsapcd.model.util.Conexao;

public class TabelaParteInteressadaDAO implements InterfaceTabelaParteInteressadaDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public TabelaParteInteressadaDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM tbparteinteressada WHERE codigo = ?;";

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
	private void setPreparedStatement(TabelaParteInteressada tabelaParteInteressada, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, tabelaParteInteressada.getNomegrport());
		ps.setObject(2, tabelaParteInteressada.getCpfgrport());
		ps.setString(3, tabelaParteInteressada.getEmailgrport());
		ps.setInt(4, tabelaParteInteressada.getFonegrport());
		ps.setString(5, tabelaParteInteressada.getOutrosport());
		ps.setString(6, tabelaParteInteressada.getNomegrprograma());
		ps.setString(7, tabelaParteInteressada.getEmailgrprograma());
		ps.setObject(8, tabelaParteInteressada.getFonegrprograma());		
		ps.setString(9, tabelaParteInteressada.getNomegrprojeto());
		ps.setString(10, tabelaParteInteressada.getEmailgrprojeto());		
		ps.setString(11, tabelaParteInteressada.getFonegrprojeto());
		ps.setString(12, tabelaParteInteressada.getNomeegprojeto());
		ps.setString(13, tabelaParteInteressada.getEmaileqprojeto());	
		ps.setString(14, tabelaParteInteressada.getNomegrfuncional());
		ps.setObject(15, tabelaParteInteressada.getCpfgrfuncional());
		ps.setString(16, tabelaParteInteressada.getEmailgrfuncional());
		ps.setInt(17, tabelaParteInteressada.getFonegrfuncional());		
		ps.setString(18, tabelaParteInteressada.getNomepatrocinador());
		ps.setObject(19, tabelaParteInteressada.getCpfpatrocinador());
		ps.setObject(20, tabelaParteInteressada.getCnpjpatrocinador());
		ps.setString(21, tabelaParteInteressada.getEmailpatrocinador());
		ps.setObject(22, tabelaParteInteressada.getFonepatrocinador());		
		ps.setObject(23, tabelaParteInteressada.getInvestimento());
		ps.setObject(24, tabelaParteInteressada.getNomeequipeproj());
		ps.setObject(25, tabelaParteInteressada.getSetorequipeproj());
		ps.setString(26, tabelaParteInteressada.getNomefornecedor());
		ps.setObject(27, tabelaParteInteressada.getCpffornecedor());
		ps.setObject(28, tabelaParteInteressada.getCnpjfornecedor());
		ps.setString(29, tabelaParteInteressada.getEmailfornecedor());
		ps.setInt(30, tabelaParteInteressada.getFonefornecedor());
		ps.setDouble(31, tabelaParteInteressada.getInvestimentoforne());
		ps.setObject(32, tabelaParteInteressada.getRegistroParteInteressada().getCodigo());
		ps.setLong(33, tabelaParteInteressada.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public TabelaParteInteressada getTabelaParteInteressada(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM tbparteinteressada WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<TabelaParteInteressada> resultado = getListaTabelaParteInteressada(rs);
			
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
		private List<TabelaParteInteressada> getListaTabelaParteInteressada(ResultSet rs) throws SQLException	{
			List<TabelaParteInteressada> resultado = new ArrayList<TabelaParteInteressada>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				TabelaParteInteressada tabelaParteInteressada = new TabelaParteInteressada();
				
				tabelaParteInteressada.setNomegrport(rs.getString("nomegrport"));
				tabelaParteInteressada.setCpfgrport(rs.getString("cpfgrport"));
				tabelaParteInteressada.setEmailgrport(rs.getString("emailgrport"));
				tabelaParteInteressada.setFonegrport(rs.getInt("fonegrport"));
				tabelaParteInteressada.setOutrosport(rs.getString("outrosport"));
				tabelaParteInteressada.setNomegrprograma(rs.getString("nomegrprograma"));
				tabelaParteInteressada.setEmailgrprograma(rs.getString("emailgrprograma"));
				tabelaParteInteressada.setFonegrprograma(rs.getInt("fonegrprograma"));				
				tabelaParteInteressada.setNomegrprojeto(rs.getString("nomegrprojeto"));	
				tabelaParteInteressada.setEmailgrprojeto(rs.getString("emailgrprojeto"));
				tabelaParteInteressada.setFonegrprojeto(rs.getString("fonegrprojeto"));
				tabelaParteInteressada.setNomeegprojeto(rs.getString("nomeegprojeto"));
				tabelaParteInteressada.setEmaileqprojeto(rs.getString("emaileqprojeto"));
				tabelaParteInteressada.setNomegrfuncional(rs.getString("nomegrfuncional"));
				tabelaParteInteressada.setCpfgrfuncional(rs.getString("cpfgrfuncional"));
				tabelaParteInteressada.setEmailgrfuncional(rs.getString("emailgrfuncional"));
				tabelaParteInteressada.setFonegrfuncional(rs.getInt("fonegrfuncional"));
				tabelaParteInteressada.setNomepatrocinador(rs.getString("nomepatrocinador"));
				tabelaParteInteressada.setCpfpatrocinador(rs.getString("cpfpatrocinador"));
				tabelaParteInteressada.setCnpjpatrocinador(rs.getString("cnpjpatrocinador"));
				tabelaParteInteressada.setEmailpatrocinador(rs.getString("emailpatrocinador"));	
				tabelaParteInteressada.setFonepatrocinador(rs.getInt("fonepatrocinador"));					
				tabelaParteInteressada.setInvestimento(rs.getDouble("investimento"));
				tabelaParteInteressada.setNomeequipeproj(rs.getString("nomeequipeproj"));
				tabelaParteInteressada.setSetorequipeproj(rs.getString("setorequipeproj"));		
				tabelaParteInteressada.setNomefornecedor(rs.getString("nomefornecedor"));
				tabelaParteInteressada.setCpffornecedor(rs.getString("cpffornecedor"));
				tabelaParteInteressada.setCnpjfornecedor(rs.getString("cnpjfornecedor"));
				tabelaParteInteressada.setEmailfornecedor(rs.getString("emailfornecedor"));
				tabelaParteInteressada.setFonefornecedor(rs.getInt("fonefornecedor"));
				tabelaParteInteressada.setInvestimentoforne(rs.getDouble("investimentoforne"));				
				tabelaParteInteressada.setCodigo(rs.getLong("codigo"));
												
				resultado.add(tabelaParteInteressada);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(TabelaParteInteressada tabelaParteInteressada) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE tbparteinteressada SET nomegrport = ?,cpfgrport = ?,emailgrport = ?,fonegrport = ?,outrosport = ?,nomegrprograma = ?,emailgrprograma = ?,fonegrprograma = ?,nomegrprojeto = ?,emailgrprojeto = ?,fonegrprojeto = ?,nomeegprojeto = ?,emaileqprojeto = ?,nomegrfuncional = ?,cpfgrfuncional = ?,emailgrfuncional = ?,fonegrfuncional = ?,nomepatrocinador = ?,cpfpatrocinador = ?,cnpjpatrocinador = ?,emailpatrocinador = ?,fonepatrocinador = ?,investimento = ?,nomeequipeproj = ?,setorequipeproj = ?,nomefornecedor = ?,cpffornecedor = ?,cnpjfornecedor = ?,emailfornecedor = ?,fonefornecedor = ?,investimentoforne  = ?, registroparteinteressada = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(tabelaParteInteressada, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(TabelaParteInteressada tabelaParteInteressada) throws Exception  {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO tbparteinteressada(nomegrport,cpfgrport,emailgrport,fonegrport,outrosport,nomegrprograma,emailgrprograma,fonegrprograma,nomegrprojeto,emailgrprojeto,fonegrprojeto,nomeegprojeto,emaileqprojeto,nomegrfuncional,cpfgrfuncional,emailgrfuncional,fonegrfuncional,nomepatrocinador,cpfpatrocinador,cnpjpatrocinador,emailpatrocinador,fonepatrocinador,investimento,nomeequipeproj,setorequipeproj,nomefornecedor,cpffornecedor,cnpjfornecedor,emailfornecedor,fonefornecedor,investimentoforne, registroparteinteressada) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, tabelaParteInteressada.getNomegrport());
			ps.setObject(2, tabelaParteInteressada.getCpfgrport());
			ps.setString(3, tabelaParteInteressada.getEmailgrport());
			ps.setInt(4, tabelaParteInteressada.getFonegrport());
			ps.setString(5, tabelaParteInteressada.getOutrosport());
			ps.setString(6, tabelaParteInteressada.getNomegrprograma());
			ps.setString(7, tabelaParteInteressada.getEmailgrprograma());
			ps.setObject(8, tabelaParteInteressada.getFonegrprograma());		
			ps.setString(9, tabelaParteInteressada.getNomegrprojeto());
			ps.setString(10, tabelaParteInteressada.getEmailgrprojeto());		
			ps.setString(11, tabelaParteInteressada.getFonegrprojeto());
			ps.setString(12, tabelaParteInteressada.getNomeegprojeto());
			ps.setString(13, tabelaParteInteressada.getEmaileqprojeto());	
			ps.setString(14, tabelaParteInteressada.getNomegrfuncional());
			ps.setObject(15, tabelaParteInteressada.getCpfgrfuncional());
			ps.setString(16, tabelaParteInteressada.getEmailgrfuncional());
			ps.setInt(17, tabelaParteInteressada.getFonegrfuncional());		
			ps.setString(18, tabelaParteInteressada.getNomepatrocinador());
			ps.setObject(19, tabelaParteInteressada.getCpfpatrocinador());
			ps.setObject(20, tabelaParteInteressada.getCnpjpatrocinador());
			ps.setString(21, tabelaParteInteressada.getEmailpatrocinador());
			ps.setObject(22, tabelaParteInteressada.getFonepatrocinador());		
			ps.setObject(23, tabelaParteInteressada.getInvestimento());
			ps.setObject(24, tabelaParteInteressada.getNomeequipeproj());
			ps.setObject(25, tabelaParteInteressada.getSetorequipeproj());	
			ps.setString(26, tabelaParteInteressada.getNomefornecedor());
			ps.setObject(27, tabelaParteInteressada.getCpffornecedor());
			ps.setObject(28, tabelaParteInteressada.getCnpjfornecedor());
			ps.setString(29, tabelaParteInteressada.getEmailfornecedor());
			ps.setInt(30, tabelaParteInteressada.getFonefornecedor());
			ps.setDouble(31, tabelaParteInteressada.getInvestimentoforne());
			ps.setObject(32, tabelaParteInteressada.getRegistroParteInteressada().getCodigo());
					
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
	public List<TabelaParteInteressada> getTabelaParteInteressadas() throws Exception {
		
		   List<TabelaParteInteressada> resultado = new ArrayList<TabelaParteInteressada>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM tbparteinteressada";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					TabelaParteInteressada tabelaParteInteressada = new TabelaParteInteressada();
					
					tabelaParteInteressada.setNomegrport(rs.getString("nomegrport"));
					tabelaParteInteressada.setCpfgrport(rs.getString("cpfgrport"));
					tabelaParteInteressada.setEmailgrport(rs.getString("emailgrport"));
					tabelaParteInteressada.setFonegrport(rs.getInt("fonegrport"));
					tabelaParteInteressada.setOutrosport(rs.getString("outrosport"));
					tabelaParteInteressada.setNomegrprograma(rs.getString("nomegrprograma"));
					tabelaParteInteressada.setEmailgrprograma(rs.getString("emailgrprograma"));
					tabelaParteInteressada.setFonegrprograma(rs.getInt("fonegrprograma"));				
					tabelaParteInteressada.setNomegrprojeto(rs.getString("nomegrprojeto"));	
					tabelaParteInteressada.setEmailgrprojeto(rs.getString("emailgrprojeto"));
					tabelaParteInteressada.setFonegrprojeto(rs.getString("fonegrprojeto"));
					tabelaParteInteressada.setNomeegprojeto(rs.getString("nomeegprojeto"));
					tabelaParteInteressada.setEmaileqprojeto(rs.getString("emaileqprojeto"));
					tabelaParteInteressada.setNomegrfuncional(rs.getString("nomegrfuncional"));
					tabelaParteInteressada.setCpfgrfuncional(rs.getString("cpfgrfuncional"));
					tabelaParteInteressada.setEmailgrfuncional(rs.getString("emailgrfuncional"));
					tabelaParteInteressada.setFonegrfuncional(rs.getInt("fonegrfuncional"));
					tabelaParteInteressada.setNomepatrocinador(rs.getString("nomepatrocinador"));
					tabelaParteInteressada.setCpfpatrocinador(rs.getString("cpfpatrocinador"));
					tabelaParteInteressada.setCnpjpatrocinador(rs.getString("cnpjpatrocinador"));
					tabelaParteInteressada.setEmailpatrocinador(rs.getString("emailpatrocinador"));	
					tabelaParteInteressada.setFonepatrocinador(rs.getInt("fonepatrocinador"));					
					tabelaParteInteressada.setInvestimento(rs.getDouble("investimento"));
					tabelaParteInteressada.setNomeequipeproj(rs.getString("nomeequipeproj"));
					tabelaParteInteressada.setSetorequipeproj(rs.getString("setorequipeproj"));
					tabelaParteInteressada.setNomefornecedor(rs.getString("nomefornecedor"));
					tabelaParteInteressada.setCpffornecedor(rs.getString("cpffornecedor"));
					tabelaParteInteressada.setCnpjfornecedor(rs.getString("cnpjfornecedor"));
					tabelaParteInteressada.setEmailfornecedor(rs.getString("emailfornecedor"));
					tabelaParteInteressada.setFonefornecedor(rs.getInt("fonefornecedor"));
					tabelaParteInteressada.setInvestimentoforne(rs.getDouble("investimentoforne"));
					tabelaParteInteressada.setCodigo(rs.getLong("codigo"));
					
					tabelaParteInteressada.getRegistroParteInteressada().setCodigo(rs.getLong("codigo"));
									
					resultado.add(tabelaParteInteressada);// Add o projeto ao resultado.
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

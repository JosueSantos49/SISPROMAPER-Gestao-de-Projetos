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
import br.com.tkcsapcd.model.bean.Riscos;
import br.com.tkcsapcd.model.util.Conexao;

public class RiscosDAO implements InterfaceRiscosDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public RiscosDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM riscos WHERE codigo = ?;";

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


	private void setPreparedStatement(Riscos riscos, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, riscos.getEmpresa());
		ps.setString(2, riscos.getOrgao());
		ps.setString(3, riscos.getSetor());
		ps.setString(4, riscos.getPrograma());
		ps.setString(5, riscos.getGerente());
		ps.setString(6, riscos.getFuncao());
		ps.setString(7, riscos.getAprovado());
		ps.setObject(8, riscos.getVersao());
		ps.setObject(9, new java.sql.Date(riscos.getDataaprovacao().getTime()));
		ps.setString(10, riscos.getEtapa1());
		ps.setString(11, riscos.getEtapa2());
		ps.setString(12, riscos.getEtapa3());
		ps.setString(13, riscos.getEtapa4());
		ps.setObject(14, riscos.getProjetoinicio().getCodigo());
		ps.setLong(15, riscos.getCodigo());//Atenção: necessário para isolar o metodo (extração). // Alterado dia 28/05/2014
		
	}

	@Override
	public Riscos getRiscos(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM riscos WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<Riscos> resultado = getListaRiscos(rs);
			
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
		private List<Riscos> getListaRiscos(ResultSet rs) throws SQLException	{
			List<Riscos> resultado = new ArrayList<Riscos>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				Riscos riscos = new Riscos();
				
				riscos.setEmpresa(rs.getString("empresa"));
				riscos.setOrgao(rs.getString("orgao"));
				riscos.setSetor(rs.getString("setor"));
				riscos.setPrograma(rs.getString("programa"));
				riscos.setGerente(rs.getString("gerente"));
				riscos.setFuncao(rs.getString("funcao"));
				riscos.setAprovado(rs.getString("aprovado"));
				riscos.setVersao(rs.getString("versao"));				
				riscos.setDataaprovacao(rs.getDate("dataaprovacao"));
				riscos.setEtapa1(rs.getString("etapa1"));
				riscos.setEtapa2(rs.getString("etapa2"));
				riscos.setEtapa3(rs.getString("etapa3"));
				riscos.setEtapa4(rs.getString("etapa4"));
				riscos.setCodigo(rs.getLong("codigo"));
								
				resultado.add(riscos);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(Riscos riscos) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
								
		try{
			String sqlAtualizar = "UPDATE riscos SET  empresa = ?, orgao = ?, setor = ?, programa = ?, gerente = ?, funcao = ?, aprovado = ?, versao = ?, dataaprovacao = ?, etapa1 = ?, etapa2 = ?, etapa3 = ?, etapa4 = ?, projetoinicio = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(riscos, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(Riscos riscos) throws Exception  {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO riscos(empresa, orgao, setor, programa, gerente, funcao, aprovado, versao, dataaprovacao, etapa1, etapa2, etapa3, etapa4, projetoinicio) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, riscos.getEmpresa());
			ps.setString(2, riscos.getOrgao());
			ps.setString(3, riscos.getSetor());
			ps.setString(4, riscos.getPrograma());
			ps.setString(5, riscos.getGerente());
			ps.setString(6, riscos.getFuncao());
			ps.setString(7, riscos.getAprovado());
			ps.setObject(8, riscos.getVersao());
			ps.setObject(9, new java.sql.Date(riscos.getDataaprovacao().getTime()));
			ps.setString(10, riscos.getEtapa1());
			ps.setString(11, riscos.getEtapa2());
			ps.setString(12, riscos.getEtapa3());
			ps.setString(13, riscos.getEtapa4());
			ps.setObject(14, riscos.getProjetoinicio().getCodigo());
			
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
	public List<Riscos> getRiscoss() throws Exception {
		
		   List<Riscos> resultado = new ArrayList<Riscos>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs =null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM riscos";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					
					Riscos riscos = new Riscos();
					
					riscos.setEmpresa(rs.getString("empresa"));
					riscos.setOrgao(rs.getString("orgao"));
					riscos.setSetor(rs.getString("setor"));
					riscos.setPrograma(rs.getString("programa"));
					riscos.setGerente(rs.getString("gerente"));
					riscos.setFuncao(rs.getString("funcao"));
					riscos.setAprovado(rs.getString("aprovado"));
					riscos.setVersao(rs.getString("versao"));				
					riscos.setDataaprovacao(rs.getDate("dataaprovacao"));
					riscos.setEtapa1(rs.getString("etapa1"));
					riscos.setEtapa2(rs.getString("etapa2"));
					riscos.setEtapa3(rs.getString("etapa3"));
					riscos.setEtapa4(rs.getString("etapa4"));
					riscos.setCodigo(rs.getLong("codigo"));
					
					riscos.getProjetoinicio().setCodigo(rs.getLong("codigo"));
									
					resultado.add(riscos);// Add o projeto ao resultado.
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

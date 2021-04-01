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
import br.com.tkcsapcd.model.bean.GerenciamentoEscopo;
import br.com.tkcsapcd.model.util.Conexao;

public class GerenciamentoEscopoDAO implements InterfaceGerenciamentoEscopoDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public GerenciamentoEscopoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM gerenciamentoescopo WHERE codigo = ?;";

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


	private void setPreparedStatement(GerenciamentoEscopo gerenciamentoEscopo, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, gerenciamentoEscopo.getEmpresa());
		ps.setString(2, gerenciamentoEscopo.getOrgao());
		ps.setString(3, gerenciamentoEscopo.getSetor());
		ps.setString(4, gerenciamentoEscopo.getPrograma());
		ps.setString(5, gerenciamentoEscopo.getGerente());
		ps.setString(6, gerenciamentoEscopo.getFuncao());
		ps.setString(7, gerenciamentoEscopo.getAprovado());
		ps.setObject(8, gerenciamentoEscopo.getVersao());
		ps.setDate(9, new java.sql.Date(gerenciamentoEscopo.getDataaprovacao().getTime()));
		ps.setString(10, gerenciamentoEscopo.getObjetivo());
		ps.setString(11, gerenciamentoEscopo.getGerenciamento());
		ps.setString(12, gerenciamentoEscopo.getReunioes_equipe());
		ps.setString(13, gerenciamentoEscopo.getReunioes_planejamento());
		ps.setString(14, gerenciamentoEscopo.getReunioes_gerenciais());
		ps.setString(15, gerenciamentoEscopo.getModificacao_escopo());
		ps.setString(16, gerenciamentoEscopo.getLicoes());
		ps.setObject(17, gerenciamentoEscopo.getProjetoinicio().getCodigo());
		ps.setLong(18, gerenciamentoEscopo.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public GerenciamentoEscopo getGerenciamentoEscopo(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM gerenciamentoescopo WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<GerenciamentoEscopo> resultado = getListaGerenciamentoEscopo(rs);
			
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
		private List<GerenciamentoEscopo> getListaGerenciamentoEscopo(ResultSet rs) throws SQLException	{
				List<GerenciamentoEscopo> resultado = new ArrayList<GerenciamentoEscopo>();
			
			// Laço p/ preencher
			while (rs.next()) {
				GerenciamentoEscopo gerenciamentoEscopo = new GerenciamentoEscopo();
				
				gerenciamentoEscopo.setEmpresa(rs.getString("empresa"));
				gerenciamentoEscopo.setOrgao(rs.getString("orgao"));
				gerenciamentoEscopo.setSetor(rs.getString("setor"));
				gerenciamentoEscopo.setPrograma(rs.getString("programa"));
				gerenciamentoEscopo.setGerente(rs.getString("gerente"));
				gerenciamentoEscopo.setFuncao(rs.getString("funcao"));
				gerenciamentoEscopo.setAprovado(rs.getString("aprovado"));
				gerenciamentoEscopo.setVersao(rs.getString("versao"));				
				gerenciamentoEscopo.setDataaprovacao(rs.getDate("dataaprovacao"));
				gerenciamentoEscopo.setObjetivo(rs.getString("objetivo"));
				gerenciamentoEscopo.setGerenciamento(rs.getString("gerenciamento"));
				gerenciamentoEscopo.setReunioes_equipe(rs.getString("reunioes_equipe"));
				gerenciamentoEscopo.setReunioes_planejamento(rs.getString("reunioes_planejamento"));
				gerenciamentoEscopo.setReunioes_gerenciais(rs.getString("reunioes_gerenciais"));
				gerenciamentoEscopo.setModificacao_escopo(rs.getString("modificacao_escopo"));
				gerenciamentoEscopo.setLicoes(rs.getString("licoes"));			
				gerenciamentoEscopo.setCodigo(rs.getLong("codigo"));
								
				resultado.add(gerenciamentoEscopo);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(GerenciamentoEscopo gerenciamentoEscopo) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
								
		try{
			String sqlAtualizar = "UPDATE gerenciamentoescopo SET  empresa= ?, orgao= ?, setor= ?, programa= ?, gerente= ?, funcao= ?, aprovado= ?, versao= ?, dataaprovacao= ?, objetivo = ?, gerenciamento = ?, reunioes_equipe = ?, reunioes_planejamento = ?, reunioes_gerenciais = ?, modificacao_escopo = ?, licoes = ?, projetoinicio = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(gerenciamentoEscopo, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(GerenciamentoEscopo gerenciamentoEscopo) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO gerenciamentoescopo(empresa, orgao, setor, programa, gerente, funcao, aprovado, versao, dataaprovacao ,objetivo, gerenciamento, reunioes_equipe, reunioes_planejamento, reunioes_gerenciais,modificacao_escopo, licoes, projetoinicio) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
						
			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, gerenciamentoEscopo.getEmpresa());
			ps.setString(2, gerenciamentoEscopo.getOrgao());
			ps.setString(3, gerenciamentoEscopo.getSetor());
			ps.setString(4, gerenciamentoEscopo.getPrograma());
			ps.setString(5, gerenciamentoEscopo.getGerente());
			ps.setString(6, gerenciamentoEscopo.getFuncao());
			ps.setString(7, gerenciamentoEscopo.getAprovado());
			ps.setObject(8, gerenciamentoEscopo.getVersao());
			ps.setDate(9, new java.sql.Date(gerenciamentoEscopo.getDataaprovacao().getTime()));
			ps.setString(10, gerenciamentoEscopo.getObjetivo());
			ps.setString(11, gerenciamentoEscopo.getGerenciamento());
			ps.setString(12, gerenciamentoEscopo.getReunioes_equipe());
			ps.setString(13, gerenciamentoEscopo.getReunioes_planejamento());
			ps.setString(14, gerenciamentoEscopo.getReunioes_gerenciais());
			ps.setString(15, gerenciamentoEscopo.getModificacao_escopo());
			ps.setString(16, gerenciamentoEscopo.getLicoes());
			ps.setObject(17, gerenciamentoEscopo.getProjetoinicio().getCodigo());
			
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
	public List<GerenciamentoEscopo> getGerenciamentoEscopos() throws Exception  {
		
		List<GerenciamentoEscopo> resultado = new ArrayList<GerenciamentoEscopo>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM gerenciamentoescopo";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					
					GerenciamentoEscopo gerenciamentoEscopo = new GerenciamentoEscopo();				

					gerenciamentoEscopo.setEmpresa(rs.getString("empresa"));
					gerenciamentoEscopo.setOrgao(rs.getString("orgao"));
					gerenciamentoEscopo.setSetor(rs.getString("setor"));
					gerenciamentoEscopo.setPrograma(rs.getString("programa"));
					gerenciamentoEscopo.setGerente(rs.getString("gerente"));
					gerenciamentoEscopo.setFuncao(rs.getString("funcao"));
					gerenciamentoEscopo.setAprovado(rs.getString("aprovado"));
					gerenciamentoEscopo.setVersao(rs.getString("versao"));				
					gerenciamentoEscopo.setDataaprovacao(rs.getDate("dataaprovacao"));
					gerenciamentoEscopo.setObjetivo(rs.getString("objetivo"));
					gerenciamentoEscopo.setGerenciamento(rs.getString("gerenciamento"));
					gerenciamentoEscopo.setReunioes_equipe(rs.getString("reunioes_equipe"));
					gerenciamentoEscopo.setReunioes_planejamento(rs.getString("reunioes_planejamento"));
					gerenciamentoEscopo.setReunioes_gerenciais(rs.getString("reunioes_gerenciais"));
					gerenciamentoEscopo.setModificacao_escopo(rs.getString("modificacao_escopo"));
					gerenciamentoEscopo.setLicoes(rs.getString("licoes"));			
					gerenciamentoEscopo.setCodigo(rs.getLong("codigo"));
					
					gerenciamentoEscopo.getProjetoinicio().setCodigo(rs.getLong("codigo"));
									
					resultado.add(gerenciamentoEscopo);// Add o projeto ao resultado.
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

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
import br.com.tkcsapcd.model.bean.DeclaracaoEscopo;
import br.com.tkcsapcd.model.util.Conexao;

public class DeclaracaoEscopoDAO implements InterfaceDeclaracaoEscopoDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public DeclaracaoEscopoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception   {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM declaracaoescopo WHERE codigo = ?;";

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


	private void setPreparedStatement(DeclaracaoEscopo declaracaoEscopo, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, declaracaoEscopo.getEmpresa());
		ps.setString(2, declaracaoEscopo.getOrgao());
		ps.setString(3, declaracaoEscopo.getSetor());
		ps.setString(4, declaracaoEscopo.getPrograma());
		ps.setString(5, declaracaoEscopo.getProjeto());
		ps.setString(6, declaracaoEscopo.getGerente());
		ps.setString(7, declaracaoEscopo.getFuncao());
		ps.setString(8, declaracaoEscopo.getAprovado());
		ps.setObject(9, declaracaoEscopo.getVersao());
		ps.setString(10, declaracaoEscopo.getDataaprovacao());		
		ps.setString(11, declaracaoEscopo.getJustificativa());
		ps.setString(12, declaracaoEscopo.getObjetivo());
		ps.setString(13, declaracaoEscopo.getDescricao());
		ps.setString(14, declaracaoEscopo.getLista());
		ps.setString(15, declaracaoEscopo.getLigacao());
		ps.setString(16, declaracaoEscopo.getEstrategia());
		ps.setString(17, declaracaoEscopo.getResponsabilidade());
		ps.setString(18, declaracaoEscopo.getMacro());
		ps.setString(19, declaracaoEscopo.getPremissas());
		ps.setString(20, declaracaoEscopo.getRestricoes());
		ps.setString(21, declaracaoEscopo.getEquipe());
		ps.setString(22, declaracaoEscopo.getObs());
		ps.setObject(23, declaracaoEscopo.getCodigoprojeto());
		ps.setInt(24, declaracaoEscopo.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public DeclaracaoEscopo getDeclaracaoEscopo(Integer codigo) throws Exception  
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM declaracaoescopo WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<DeclaracaoEscopo> resultado = getListaDeclaracaoEscopo(rs);
			
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
		private List<DeclaracaoEscopo> getListaDeclaracaoEscopo(ResultSet rs) throws SQLException	{
			List<DeclaracaoEscopo> resultado = new ArrayList<DeclaracaoEscopo>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				DeclaracaoEscopo declaracaoEscopo = new DeclaracaoEscopo();
				
				declaracaoEscopo.setEmpresa(rs.getString("empresa"));
				declaracaoEscopo.setOrgao(rs.getString("orgao"));
				declaracaoEscopo.setSetor(rs.getString("setor"));
				declaracaoEscopo.setPrograma(rs.getString("programa"));
				declaracaoEscopo.setProjeto(rs.getString("projeto"));
				declaracaoEscopo.setGerente(rs.getString("gerente"));
				declaracaoEscopo.setFuncao(rs.getString("funcao"));
				declaracaoEscopo.setAprovado(rs.getString("aprovado"));
				declaracaoEscopo.setVersao(rs.getString("versao"));				
				declaracaoEscopo.setDataaprovacao(rs.getString("dataaprovacao"));					
				declaracaoEscopo.setJustificativa(rs.getString("justificativa"));
				declaracaoEscopo.setObjetivo(rs.getString("objetivo"));
				declaracaoEscopo.setDescricao(rs.getString("descricao"));
				declaracaoEscopo.setLista(rs.getString("lista"));
				declaracaoEscopo.setLigacao(rs.getString("ligacao"));
				declaracaoEscopo.setEstrategia(rs.getString("estrategia"));
				declaracaoEscopo.setResponsabilidade(rs.getString("responsabilidade"));
				declaracaoEscopo.setMacro(rs.getString("macro"));					
				declaracaoEscopo.setPremissas(rs.getString("premissas"));
				declaracaoEscopo.setRestricoes(rs.getString("restricoes"));
				declaracaoEscopo.setEquipe(rs.getString("equipe"));
				declaracaoEscopo.setObs(rs.getString("obs"));					
				declaracaoEscopo.setCodigoprojeto(rs.getString("codigoprojeto"));
				declaracaoEscopo.setCodigo(rs.getInt("codigo"));
								
				resultado.add(declaracaoEscopo);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(DeclaracaoEscopo declaracaoEscopo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
								
		try{
			String sqlAtualizar = "UPDATE declaracaoescopo SET  empresa= ?, orgao= ?, setor= ?, programa= ?, projeto= ?, gerente= ?, funcao= ?, aprovado= ?, versao= ?, dataaprovacao= ?, justificativa= ?, objetivo= ?, descricao= ?,	lista= ?, ligacao= ?, estrategia= ?, responsabilidade= ?, macro= ?, premissas= ?, restricoes= ?, equipe= ?, obs= ?, codigoprojeto = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(declaracaoEscopo, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(DeclaracaoEscopo declaracaoEscopo) throws Exception  {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO declaracaoescopo(empresa, orgao, setor, programa, projeto, gerente, funcao, aprovado, versao, dataaprovacao,justificativa, objetivo, descricao,	lista, ligacao, estrategia, responsabilidade, macro, premissas, restricoes, equipe, obs, codigoprojeto) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, declaracaoEscopo.getEmpresa());
			ps.setString(2, declaracaoEscopo.getOrgao());
			ps.setString(3, declaracaoEscopo.getSetor());
			ps.setString(4, declaracaoEscopo.getPrograma());
			ps.setString(5, declaracaoEscopo.getProjeto());
			ps.setString(6, declaracaoEscopo.getGerente());
			ps.setString(7, declaracaoEscopo.getFuncao());
			ps.setString(8, declaracaoEscopo.getAprovado());
			ps.setObject(9, declaracaoEscopo.getVersao());
			ps.setString(10, declaracaoEscopo.getDataaprovacao());		
			ps.setString(11, declaracaoEscopo.getJustificativa());
			ps.setString(12, declaracaoEscopo.getObjetivo());
			ps.setString(13, declaracaoEscopo.getDescricao());
			ps.setString(14, declaracaoEscopo.getLista());
			ps.setString(15, declaracaoEscopo.getLigacao());
			ps.setString(16, declaracaoEscopo.getEstrategia());
			ps.setString(17, declaracaoEscopo.getResponsabilidade());
			ps.setString(18, declaracaoEscopo.getMacro());
			ps.setString(19, declaracaoEscopo.getPremissas());
			ps.setString(20, declaracaoEscopo.getRestricoes());
			ps.setString(21, declaracaoEscopo.getEquipe());
			ps.setString(22, declaracaoEscopo.getObs());
			ps.setObject(23, declaracaoEscopo.getCodigoprojeto());
			
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
	public List<DeclaracaoEscopo> getDeclaracaoEscopos() throws Exception  {
		
		   List<DeclaracaoEscopo> resultado = new ArrayList<DeclaracaoEscopo>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs =null;
		try {
			con = Conexao.getConnection();			
			String sqlSelect = "SELECT * FROM declaracaoescopo";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					
					DeclaracaoEscopo declaracaoEscopo = new DeclaracaoEscopo();
				
					declaracaoEscopo.setEmpresa(rs.getString("empresa"));
					declaracaoEscopo.setOrgao(rs.getString("orgao"));
					declaracaoEscopo.setSetor(rs.getString("setor"));
					declaracaoEscopo.setPrograma(rs.getString("programa"));
					declaracaoEscopo.setProjeto(rs.getString("projeto"));
					declaracaoEscopo.setGerente(rs.getString("gerente"));
					declaracaoEscopo.setFuncao(rs.getString("funcao"));
					declaracaoEscopo.setAprovado(rs.getString("aprovado"));
					declaracaoEscopo.setVersao(rs.getString("versao"));				
					declaracaoEscopo.setDataaprovacao(rs.getString("dataaprovacao"));					
					declaracaoEscopo.setJustificativa(rs.getString("justificativa"));
					declaracaoEscopo.setObjetivo(rs.getString("objetivo"));
					declaracaoEscopo.setDescricao(rs.getString("descricao"));
					declaracaoEscopo.setLista(rs.getString("lista"));
					declaracaoEscopo.setLigacao(rs.getString("ligacao"));
					declaracaoEscopo.setEstrategia(rs.getString("estrategia"));
					declaracaoEscopo.setResponsabilidade(rs.getString("responsabilidade"));
					declaracaoEscopo.setMacro(rs.getString("macro"));					
					declaracaoEscopo.setPremissas(rs.getString("premissas"));
					declaracaoEscopo.setRestricoes(rs.getString("restricoes"));
					declaracaoEscopo.setEquipe(rs.getString("equipe"));
					declaracaoEscopo.setObs(rs.getString("obs"));					
					declaracaoEscopo.setCodigoprojeto(rs.getString("codigoprojeto"));
					declaracaoEscopo.setCodigo(rs.getInt("codigo"));
									
					resultado.add(declaracaoEscopo);// Add o projeto ao resultado.
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

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
import br.com.tkcsapcd.model.bean.ModificacaoEscopo;
import br.com.tkcsapcd.model.util.Conexao;

public class ModificacaoescopoDAO implements InterfaceModificacaoescopoDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public ModificacaoescopoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception   {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM modificacaoescopo WHERE codigo = ?;";

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

	private void setPreparedStatement(ModificacaoEscopo modificacaoEscopo, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, modificacaoEscopo.getEmpresa());
		ps.setString(2, modificacaoEscopo.getOrgao());
		ps.setString(3, modificacaoEscopo.getSetor());
		ps.setString(4, modificacaoEscopo.getPrograma());
		ps.setString(5, modificacaoEscopo.getProjeto());
		ps.setString(6, modificacaoEscopo.getGerente());
		ps.setString(7, modificacaoEscopo.getRequerido());
		ps.setString(8, modificacaoEscopo.getNumero_me());
		ps.setObject(9, modificacaoEscopo.getDataemissao());
		ps.setString(10, modificacaoEscopo.getDescricao());
		ps.setString(11, modificacaoEscopo.getMotivo());
		ps.setString(12, modificacaoEscopo.getImpacto());
		ps.setString(13, modificacaoEscopo.getEscopo());
		ps.setString(14, modificacaoEscopo.getCusto());
		ps.setString(15, modificacaoEscopo.getPrazo());
		ps.setString(16, modificacaoEscopo.getComentarios());
		ps.setString(17, modificacaoEscopo.getReferencia());
		ps.setString(18, modificacaoEscopo.getAnexo());
		ps.setString(19, modificacaoEscopo.getParecer());
		ps.setString(20, modificacaoEscopo.getAprovacao());
		ps.setObject(21, modificacaoEscopo.getCodigoprojeto());
		ps.setInt(22, modificacaoEscopo.getCodigo());//Atenção: necessário para isolar o metodo (extração). // Alterado dia 28/05/2014
		
	}

	@Override
	public ModificacaoEscopo getModificacaoEscopo(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM modificacaoescopo WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<ModificacaoEscopo> resultado = getListaModificacaoEscopos(rs);
			
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
		private List<ModificacaoEscopo> getListaModificacaoEscopos(ResultSet rs) throws SQLException	{
			List<ModificacaoEscopo> resultado = new ArrayList<ModificacaoEscopo>();
			
			// Laço p/ preencher
			while (rs.next()) {
				ModificacaoEscopo modificacaoEscopo = new ModificacaoEscopo();
				
				modificacaoEscopo.setEmpresa(rs.getString("empresa"));
				modificacaoEscopo.setOrgao(rs.getString("orgao"));
				modificacaoEscopo.setSetor(rs.getString("setor"));
				modificacaoEscopo.setPrograma(rs.getString("programa"));
				modificacaoEscopo.setProjeto(rs.getString("projeto"));
				modificacaoEscopo.setGerente(rs.getString("gerente"));
				modificacaoEscopo.setRequerido(rs.getString("requerido"));
				modificacaoEscopo.setNumero_me(rs.getString("numero_me"));
				modificacaoEscopo.setDataemissao(rs.getString("dataemissao"));				
				modificacaoEscopo.setDescricao(rs.getString("descricao"));
				modificacaoEscopo.setMotivo(rs.getString("motivo"));
				modificacaoEscopo.setImpacto(rs.getString("impacto"));
				modificacaoEscopo.setEscopo(rs.getString("escopo"));
				modificacaoEscopo.setCusto(rs.getString("custo"));
				modificacaoEscopo.setPrazo(rs.getString("prazo"));
				modificacaoEscopo.setComentarios(rs.getString("comentarios"));
				modificacaoEscopo.setReferencia(rs.getString("referencia"));				
				modificacaoEscopo.setAnexo(rs.getString("anexo"));
				modificacaoEscopo.setParecer(rs.getString("parecer"));
				modificacaoEscopo.setAprovacao(rs.getString("aprovacao"));
				modificacaoEscopo.setCodigoprojeto(rs.getString("codigoprojeto"));
				modificacaoEscopo.setCodigo(rs.getInt("codigo"));
								
				resultado.add(modificacaoEscopo);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(ModificacaoEscopo modificacaoEscopo) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
								
		try{
			String sqlAtualizar = "UPDATE modificacaoescopo SET  empresa= ?, orgao= ?, setor= ?, programa= ?, projeto= ?, gerente= ?, requerido= ?, numero_me= ?, dataemissao= ?, descricao= ?, motivo = ?, impacto= ?, escopo= ?, custo= ?, prazo= ?, comentarios= ?, referencia= ?, anexo= ?, parecer= ?, aprovacao = ?, codigoprojeto = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(modificacaoEscopo, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(ModificacaoEscopo modificacaoEscopo) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO modificacaoescopo(empresa, orgao, setor, programa, projeto, gerente, requerido, numero_me, dataemissao, descricao, motivo, impacto, escopo, custo, prazo, comentarios, referencia, anexo, parecer, aprovacao, codigoprojeto)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, modificacaoEscopo.getEmpresa());
			ps.setString(2, modificacaoEscopo.getOrgao());
			ps.setString(3, modificacaoEscopo.getSetor());
			ps.setString(4, modificacaoEscopo.getPrograma());
			ps.setString(5, modificacaoEscopo.getProjeto());
			ps.setString(6, modificacaoEscopo.getGerente());
			ps.setString(7, modificacaoEscopo.getRequerido());
			ps.setString(8, modificacaoEscopo.getNumero_me());
			ps.setObject(9, modificacaoEscopo.getDataemissao());
			ps.setString(10, modificacaoEscopo.getDescricao());
			ps.setString(11, modificacaoEscopo.getMotivo());
			ps.setString(12, modificacaoEscopo.getImpacto());
			ps.setString(13, modificacaoEscopo.getEscopo());
			ps.setString(14, modificacaoEscopo.getCusto());
			ps.setString(15, modificacaoEscopo.getPrazo());
			ps.setString(16, modificacaoEscopo.getComentarios());
			ps.setString(17, modificacaoEscopo.getReferencia());
			ps.setString(18, modificacaoEscopo.getAnexo());
			ps.setString(19, modificacaoEscopo.getParecer());
			ps.setString(20, modificacaoEscopo.getAprovacao());
			ps.setObject(21, modificacaoEscopo.getCodigoprojeto());
			
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
	public List<ModificacaoEscopo> getModificacaoEscopos() throws Exception {
		
		   List<ModificacaoEscopo> resultado = new ArrayList<ModificacaoEscopo>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM modificacaoescopo";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					
					ModificacaoEscopo modificacaoEscopo = new ModificacaoEscopo();
					
					modificacaoEscopo.setEmpresa(rs.getString("empresa"));
					modificacaoEscopo.setOrgao(rs.getString("orgao"));
					modificacaoEscopo.setSetor(rs.getString("setor"));
					modificacaoEscopo.setPrograma(rs.getString("programa"));
					modificacaoEscopo.setProjeto(rs.getString("projeto"));
					modificacaoEscopo.setGerente(rs.getString("gerente"));
					modificacaoEscopo.setRequerido(rs.getString("requerido"));
					modificacaoEscopo.setNumero_me(rs.getString("numero_me"));
					modificacaoEscopo.setDataemissao(rs.getString("dataemissao"));				
					modificacaoEscopo.setDescricao(rs.getString("descricao"));
					modificacaoEscopo.setMotivo(rs.getString("motivo"));
					modificacaoEscopo.setImpacto(rs.getString("impacto"));
					modificacaoEscopo.setEscopo(rs.getString("escopo"));
					modificacaoEscopo.setCusto(rs.getString("custo"));
					modificacaoEscopo.setPrazo(rs.getString("prazo"));
					modificacaoEscopo.setComentarios(rs.getString("comentarios"));
					modificacaoEscopo.setReferencia(rs.getString("referencia"));				
					modificacaoEscopo.setAnexo(rs.getString("anexo"));
					modificacaoEscopo.setParecer(rs.getString("parecer"));
					modificacaoEscopo.setAprovacao(rs.getString("aprovacao"));
					modificacaoEscopo.setCodigoprojeto(rs.getString("codigoprojeto"));
					modificacaoEscopo.setCodigo(rs.getInt("codigo"));
														
					resultado.add(modificacaoEscopo);// Add o projeto ao resultado.
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

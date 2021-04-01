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
import br.com.tkcsapcd.model.bean.LicoesAprendida;
import br.com.tkcsapcd.model.util.Conexao;

public class LicoesAprendidaDAO implements InterfaceLicoesAprendidaDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public LicoesAprendidaDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM licoesaprendida WHERE codigo = ?;";

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


	private void setPreparedStatement(LicoesAprendida licoesaprendida, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, licoesaprendida.getEmpresa());
		ps.setString(2, licoesaprendida.getOrgao());
		ps.setString(3, licoesaprendida.getSetor());
		ps.setString(4, licoesaprendida.getPrograma());
		ps.setString(5, licoesaprendida.getProjeto());
		ps.setString(6, licoesaprendida.getGerente());
		ps.setString(7, licoesaprendida.getFuncao());
		ps.setString(8, licoesaprendida.getAprovado());
		ps.setObject(9, licoesaprendida.getVersao());
		ps.setString(10, licoesaprendida.getDataaprovacao());		
		ps.setString(11, licoesaprendida.getPergunta1());
		ps.setString(12, licoesaprendida.getPergunta2());
		ps.setString(13, licoesaprendida.getPergunta3());
		ps.setString(14, licoesaprendida.getPergunta4());
		ps.setString(15, licoesaprendida.getPergunta5());
		ps.setString(16, licoesaprendida.getPergunta6());
		ps.setString(17, licoesaprendida.getPergunta7());
		ps.setString(18, licoesaprendida.getPergunta8());
		ps.setString(19, licoesaprendida.getPergunta9());
		ps.setString(20, licoesaprendida.getPergunta10());
		ps.setString(21, licoesaprendida.getPergunta11());
		ps.setString(22, licoesaprendida.getPergunta12());
		ps.setString(23, licoesaprendida.getPergunta13());
		ps.setString(24, licoesaprendida.getPergunta14());
		ps.setString(25, licoesaprendida.getPergunta15());
		ps.setString(26, licoesaprendida.getPergunta16());
		ps.setString(27, licoesaprendida.getPergunta17());
		ps.setObject(28, licoesaprendida.getCodigoprojeto());
		ps.setInt(29, licoesaprendida.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public LicoesAprendida getLicoesAprendida(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM licoesaprendida WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<LicoesAprendida> resultado = getListaLicoesAprendida(rs);
			
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
		private List<LicoesAprendida> getListaLicoesAprendida(ResultSet rs) throws SQLException	{
			List<LicoesAprendida> resultado = new ArrayList<LicoesAprendida>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				LicoesAprendida licoesAprendida = new LicoesAprendida();
				
				licoesAprendida.setEmpresa(rs.getString("empresa"));
				licoesAprendida.setOrgao(rs.getString("orgao"));
				licoesAprendida.setSetor(rs.getString("setor"));
				licoesAprendida.setPrograma(rs.getString("programa"));
				licoesAprendida.setProjeto(rs.getString("projeto"));
				licoesAprendida.setGerente(rs.getString("gerente"));
				licoesAprendida.setFuncao(rs.getString("funcao"));
				licoesAprendida.setAprovado(rs.getString("aprovado"));
				licoesAprendida.setVersao(rs.getString("versao"));				
				licoesAprendida.setDataaprovacao(rs.getString("dataaprovacao"));					
				licoesAprendida.setPergunta1(rs.getString("pergunta1"));
				licoesAprendida.setPergunta2(rs.getString("pergunta2"));
				licoesAprendida.setPergunta3(rs.getString("pergunta3"));
				licoesAprendida.setPergunta4(rs.getString("pergunta4"));
				licoesAprendida.setPergunta5(rs.getString("pergunta5"));
				licoesAprendida.setPergunta6(rs.getString("pergunta6"));
				licoesAprendida.setPergunta7(rs.getString("pergunta7"));
				licoesAprendida.setPergunta8(rs.getString("pergunta8"));
				licoesAprendida.setPergunta9(rs.getString("pergunta9"));
				licoesAprendida.setPergunta10(rs.getString("pergunta10"));
				licoesAprendida.setPergunta11(rs.getString("pergunta11"));
				licoesAprendida.setPergunta12(rs.getString("pergunta12"));
				licoesAprendida.setPergunta13(rs.getString("pergunta13"));
				licoesAprendida.setPergunta14(rs.getString("pergunta14"));
				licoesAprendida.setPergunta15(rs.getString("pergunta15"));
				licoesAprendida.setPergunta16(rs.getString("pergunta16"));
				licoesAprendida.setPergunta17(rs.getString("pergunta17"));
				licoesAprendida.setCodigoprojeto(rs.getString("codigoprojeto"));
				licoesAprendida.setCodigo(rs.getInt("codigo"));
								
				resultado.add(licoesAprendida);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(LicoesAprendida licoesAprendida) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
								
		try{
			String sqlAtualizar = "UPDATE licoesaprendida SET  empresa= ?, orgao= ?, setor= ?, programa= ?, projeto= ?, gerente= ?, funcao= ?, aprovado= ?, versao= ?, dataaprovacao= ?, pergunta1= ?, pergunta2= ?, pergunta3= ?, pergunta4 = ?, pergunta5 = ?, pergunta6 = ?, pergunta7 = ?, pergunta8 = ?, pergunta9 = ?, pergunta10 = ?, pergunta11 = ?, pergunta12 = ?, pergunta13 = ?, pergunta14 = ?, pergunta15 = ?, pergunta16 = ?, pergunta17 = ?, codigoprojeto = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(licoesAprendida, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(LicoesAprendida licoesaprendida) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps =null;
		try {
			String sqlInsert = "INSERT INTO licoesaprendida(empresa, orgao, setor, programa, projeto, gerente, funcao, aprovado, versao, dataaprovacao, pergunta1, pergunta2, pergunta3, pergunta4, pergunta5, pergunta6, pergunta7, pergunta8, pergunta9, pergunta10, pergunta11, pergunta12, pergunta13, pergunta14, pergunta15, pergunta16, pergunta17, codigoprojeto) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, licoesaprendida.getEmpresa());
			ps.setString(2, licoesaprendida.getOrgao());
			ps.setString(3, licoesaprendida.getSetor());
			ps.setString(4, licoesaprendida.getPrograma());
			ps.setString(5, licoesaprendida.getProjeto());
			ps.setString(6, licoesaprendida.getGerente());
			ps.setString(7, licoesaprendida.getFuncao());
			ps.setString(8, licoesaprendida.getAprovado());
			ps.setObject(9, licoesaprendida.getVersao());
			ps.setString(10, licoesaprendida.getDataaprovacao());		
			ps.setString(11, licoesaprendida.getPergunta1());
			ps.setString(12, licoesaprendida.getPergunta2());
			ps.setString(13, licoesaprendida.getPergunta3());
			ps.setString(14, licoesaprendida.getPergunta4());
			ps.setString(15, licoesaprendida.getPergunta5());
			ps.setString(16, licoesaprendida.getPergunta6());
			ps.setString(17, licoesaprendida.getPergunta7());
			ps.setString(18, licoesaprendida.getPergunta8());
			ps.setString(19, licoesaprendida.getPergunta9());
			ps.setString(20, licoesaprendida.getPergunta10());
			ps.setString(21, licoesaprendida.getPergunta11());
			ps.setString(22, licoesaprendida.getPergunta12());
			ps.setString(23, licoesaprendida.getPergunta13());
			ps.setString(24, licoesaprendida.getPergunta14());
			ps.setString(25, licoesaprendida.getPergunta15());
			ps.setString(26, licoesaprendida.getPergunta16());
			ps.setString(27, licoesaprendida.getPergunta17());
			ps.setObject(28, licoesaprendida.getCodigoprojeto());
			
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
	public List<LicoesAprendida> getLicoesAprendidas() throws Exception {
		
		   List<LicoesAprendida> resultado = new ArrayList<LicoesAprendida>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs =null;
		
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM licoesaprendida";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					
					LicoesAprendida licoesAprendida = new LicoesAprendida();
					
					licoesAprendida.setEmpresa(rs.getString("empresa"));
					licoesAprendida.setOrgao(rs.getString("orgao"));
					licoesAprendida.setSetor(rs.getString("setor"));
					licoesAprendida.setPrograma(rs.getString("programa"));
					licoesAprendida.setProjeto(rs.getString("projeto"));
					licoesAprendida.setGerente(rs.getString("gerente"));
					licoesAprendida.setFuncao(rs.getString("funcao"));
					licoesAprendida.setAprovado(rs.getString("aprovado"));
					licoesAprendida.setVersao(rs.getString("versao"));				
					licoesAprendida.setDataaprovacao(rs.getString("dataaprovacao"));					
					licoesAprendida.setPergunta1(rs.getString("pergunta1"));
					licoesAprendida.setPergunta2(rs.getString("pergunta2"));
					licoesAprendida.setPergunta3(rs.getString("pergunta3"));
					licoesAprendida.setPergunta4(rs.getString("pergunta4"));
					licoesAprendida.setPergunta5(rs.getString("pergunta5"));
					licoesAprendida.setPergunta6(rs.getString("pergunta6"));
					licoesAprendida.setPergunta7(rs.getString("pergunta7"));
					licoesAprendida.setPergunta8(rs.getString("pergunta8"));
					licoesAprendida.setPergunta9(rs.getString("pergunta9"));
					licoesAprendida.setPergunta10(rs.getString("pergunta10"));
					licoesAprendida.setPergunta11(rs.getString("pergunta11"));
					licoesAprendida.setPergunta12(rs.getString("pergunta12"));
					licoesAprendida.setPergunta13(rs.getString("pergunta13"));
					licoesAprendida.setPergunta14(rs.getString("pergunta14"));
					licoesAprendida.setPergunta15(rs.getString("pergunta15"));
					licoesAprendida.setPergunta16(rs.getString("pergunta16"));
					licoesAprendida.setPergunta17(rs.getString("pergunta17"));
					licoesAprendida.setCodigoprojeto(rs.getString("codigoprojeto"));
					licoesAprendida.setCodigo(rs.getInt("codigo"));
									
					resultado.add(licoesAprendida);// Add o projeto ao resultado.
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

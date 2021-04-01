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
import br.com.tkcsapcd.model.bean.DicionarioEAP;
import br.com.tkcsapcd.model.util.Conexao;

public class DicionarioEAPDAO implements InterfaceDicionarioEAPDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public DicionarioEAPDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM dicionarioeap WHERE codigo = ?;";

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
	private void setPreparedStatement(DicionarioEAP dicionarioEAP, PreparedStatement ps) throws SQLException 
	{		
		ps.setString(1, dicionarioEAP.getDicionarioeap());
		ps.setString(2, dicionarioEAP.getVersao());
		ps.setDate(3, new java.sql.Date(dicionarioEAP.getData().getTime()));
		ps.setString(4, dicionarioEAP.getAutor());
		ps.setString(5, dicionarioEAP.getNotarevisao());
		ps.setString(6, dicionarioEAP.getAprovacao());
		ps.setDouble(7, dicionarioEAP.getCodigoeap());
		ps.setString(8, dicionarioEAP.getEntregapacote());
		ps.setString(9, dicionarioEAP.getDescricao());		
		ps.setString(10, dicionarioEAP.getCriterioaceitacao());
		ps.setString(11, dicionarioEAP.getResponsavel());
		ps.setString(12, dicionarioEAP.getAprovado());	
		ps.setString(13, dicionarioEAP.getConsultado());
		ps.setString(14, dicionarioEAP.getInformado());	
		ps.setString(15, dicionarioEAP.getTrabalhoenvolvido());
		ps.setString(16, dicionarioEAP.getRiscos());
		ps.setString(17, dicionarioEAP.getRecusos());
		ps.setString(18, dicionarioEAP.getMacros());
		ps.setDouble(19, dicionarioEAP.getCustos());
		ps.setString(20, dicionarioEAP.getPrevisao());			
		ps.setString(21, dicionarioEAP.getInformacoes());
		ps.setString(22, dicionarioEAP.getStatus());
		ps.setString(23, dicionarioEAP.getComentarios());
		ps.setObject(24, dicionarioEAP.getProjetoinicio().getCodigo());
		ps.setObject(25, dicionarioEAP.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public DicionarioEAP getDicionarioEAP(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM dicionarioeap WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<DicionarioEAP> resultado = getListaDicionarioEAP(rs);
			
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
		private List<DicionarioEAP> getListaDicionarioEAP(ResultSet rs) throws SQLException	{
			List<DicionarioEAP> resultado = new ArrayList<DicionarioEAP>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				DicionarioEAP dicionarioEAP = new DicionarioEAP();
				
				dicionarioEAP.setDicionarioeap(rs.getString("dicionarioeap"));
				dicionarioEAP.setVersao(rs.getString("versao"));
				dicionarioEAP.setData(rs.getDate("data"));
				dicionarioEAP.setAutor(rs.getString("autor"));
				dicionarioEAP.setNotarevisao(rs.getString("notarevisao"));
				dicionarioEAP.setAprovacao(rs.getString("aprovacao"));
				dicionarioEAP.setCodigoeap(rs.getInt("codigoeap"));				
				dicionarioEAP.setEntregapacote(rs.getString("entregapacote"));					
				dicionarioEAP.setDescricao(rs.getString("descricao"));
				dicionarioEAP.setCriterioaceitacao(rs.getString("criterioaceitacao"));
				dicionarioEAP.setResponsavel(rs.getString("responsavel"));
				dicionarioEAP.setAprovado(rs.getString("aprovado"));
				dicionarioEAP.setConsultado(rs.getString("consultado"));
				dicionarioEAP.setInformado(rs.getString("informado"));
				dicionarioEAP.setTrabalhoenvolvido(rs.getString("trabalhoenvolvido"));
				dicionarioEAP.setRiscos(rs.getString("riscos"));
				dicionarioEAP.setRecusos(rs.getString("recusos"));
				dicionarioEAP.setMacros(rs.getString("macros"));
				dicionarioEAP.setCustos(rs.getDouble("custos"));
				dicionarioEAP.setPrevisao(rs.getString("previsao"));
				dicionarioEAP.setInformacoes(rs.getString("informacoes"));
				dicionarioEAP.setStatus(rs.getString("status"));
				dicionarioEAP.setComentarios(rs.getString("comentarios"));
				dicionarioEAP.setCodigo(rs.getLong("codigo"));
												
				resultado.add(dicionarioEAP);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(DicionarioEAP dicionarioEAP) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE dicionarioeap SET dicionarioeap = ?, versao = ?, data = ?, autor = ?, notarevisao = ?, aprovacao = ?, codigoeap = ?, entregapacote = ?, descricao = ?, criterioaceitacao = ?, responsavel = ?, aprovado = ?, consultado = ?, informado = ?, trabalhoenvolvido = ?, riscos = ?, recusos = ?, macros = ?, custos = ?, previsao = ?, informacoes = ?, status = ?, comentarios = ?, projetoinicio = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(dicionarioEAP, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(DicionarioEAP dicionarioEAP) throws Exception  {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO dicionarioeap(	dicionarioeap, versao, data, autor, notarevisao, aprovacao, codigoeap, entregapacote, descricao, criterioaceitacao, responsavel, aprovado, consultado, informado, trabalhoenvolvido, riscos, recusos, macros, custos, previsao, informacoes, status, comentarios, projetoinicio) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, dicionarioEAP.getDicionarioeap());
			ps.setString(2, dicionarioEAP.getVersao());
			ps.setDate(3, new java.sql.Date(dicionarioEAP.getData().getTime()));
			ps.setString(4, dicionarioEAP.getAutor());
			ps.setString(5, dicionarioEAP.getNotarevisao());
			ps.setString(6, dicionarioEAP.getAprovacao());
			ps.setDouble(7, dicionarioEAP.getCodigoeap());
			ps.setString(8, dicionarioEAP.getEntregapacote());
			ps.setString(9, dicionarioEAP.getDescricao());		
			ps.setString(10, dicionarioEAP.getCriterioaceitacao());
			ps.setString(11, dicionarioEAP.getResponsavel());
			ps.setString(12, dicionarioEAP.getAprovado());	
			ps.setString(13, dicionarioEAP.getConsultado());
			ps.setString(14, dicionarioEAP.getInformado());	
			ps.setString(15, dicionarioEAP.getTrabalhoenvolvido());
			ps.setString(16, dicionarioEAP.getRiscos());
			ps.setString(17, dicionarioEAP.getRecusos());
			ps.setString(18, dicionarioEAP.getMacros());
			ps.setDouble(19, dicionarioEAP.getCustos());
			ps.setString(20, dicionarioEAP.getPrevisao());			
			ps.setString(21, dicionarioEAP.getInformacoes());
			ps.setString(22, dicionarioEAP.getStatus());
			ps.setString(23, dicionarioEAP.getComentarios());
			ps.setObject(24, dicionarioEAP.getProjetoinicio().getCodigo());
			
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
	public List<DicionarioEAP> getDicionarioEAPs() throws Exception  {
		
		   List<DicionarioEAP> resultado = new ArrayList<DicionarioEAP>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs =null;
		try {
			con = Conexao.getConnection();			
			String sqlSelect = "SELECT * FROM dicionarioeap";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					DicionarioEAP dicionarioEAP = new DicionarioEAP();
				
					dicionarioEAP.setDicionarioeap(rs.getString("dicionarioeap"));
					dicionarioEAP.setVersao(rs.getString("versao"));
					dicionarioEAP.setData(rs.getDate("data"));
					dicionarioEAP.setAutor(rs.getString("autor"));
					dicionarioEAP.setNotarevisao(rs.getString("notarevisao"));
					dicionarioEAP.setAprovacao(rs.getString("aprovacao"));
					dicionarioEAP.setCodigoeap(rs.getInt("codigoeap"));				
					dicionarioEAP.setEntregapacote(rs.getString("entregapacote"));					
					dicionarioEAP.setDescricao(rs.getString("descricao"));
					dicionarioEAP.setCriterioaceitacao(rs.getString("criterioaceitacao"));
					dicionarioEAP.setResponsavel(rs.getString("responsavel"));
					dicionarioEAP.setAprovado(rs.getString("aprovado"));
					dicionarioEAP.setConsultado(rs.getString("consultado"));
					dicionarioEAP.setInformado(rs.getString("informado"));
					dicionarioEAP.setTrabalhoenvolvido(rs.getString("trabalhoenvolvido"));
					dicionarioEAP.setRiscos(rs.getString("riscos"));
					dicionarioEAP.setRecusos(rs.getString("recusos"));
					dicionarioEAP.setMacros(rs.getString("macros"));
					dicionarioEAP.setCustos(rs.getDouble("custos"));
					dicionarioEAP.setPrevisao(rs.getString("previsao"));
					dicionarioEAP.setInformacoes(rs.getString("informacoes"));
					dicionarioEAP.setStatus(rs.getString("status"));
					dicionarioEAP.setComentarios(rs.getString("comentarios"));
					dicionarioEAP.setCodigo(rs.getLong("codigo"));
					
					dicionarioEAP.getProjetoinicio().setCodigo(rs.getLong("codigo"));
									
					resultado.add(dicionarioEAP);// Add o projeto ao resultado.
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

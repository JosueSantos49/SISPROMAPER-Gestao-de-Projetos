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
import br.com.tkcsapcd.model.bean.AcompanhamentoProjeto;
import br.com.tkcsapcd.model.util.Conexao;

public class AcompanhamentoProjetoDAO implements InterfaceAcompanhamentoProjetoDAO {
	
	@SuppressWarnings("unused")
	private InterfacePool pool;

	public AcompanhamentoProjetoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}

	@Override
	public void excluir(Integer codigo) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
				
		try{

			String SqlExcluir = "DELETE FROM acompanhamentoprojeto WHERE codigo = ?;";			
			ps = con.prepareStatement(SqlExcluir);
			ps.setInt(1, codigo);
			ps.executeUpdate();
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
	public void atualizar(AcompanhamentoProjeto acompanhamentoProjeto) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {		
			String sqlAtualizar = "UPDATE acompanhamentoprojeto SET acompanhamentoprojeto = ?, versao = ?, data = ?, autor = ?, notarevisao = ?, aprovacao = ?, produtoservico = ?, situacaoconcluida = ?, dataplanejada = ?, dataefetiva = ?, atrasoprevisto = ?, valororcado = ?, custoreal = ?, especificacao = ?, nivel = ?, acao = ?, responsavel = ?, projetoinicio = ? WHERE codigo = ?;";
			
			ps = con.prepareStatement(sqlAtualizar);			
			setPreparedStatement(acompanhamentoProjeto, ps);//Código isolado do metodo sqlInsert permite usar a mesma linha, facilitando!			
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
	public void salvar(AcompanhamentoProjeto acompanhamentoProjeto) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		try{
			String sqlInsert = "INSERT INTO acompanhamentoprojeto (acompanhamentoprojeto, versao, data, autor, notarevisao, aprovacao, produtoservico, situacaoconcluida, dataplanejada, dataefetiva, atrasoprevisto, valororcado, custoreal, especificacao, nivel, acao, responsavel, projetoinicio) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";		
			
				ps = con.prepareStatement(sqlInsert);		
				
				ps.setString(1, acompanhamentoProjeto.getAcompanhamentoprojeto());				
				ps.setLong(2, acompanhamentoProjeto.getVersao());
				ps.setDate(3, new java.sql.Date(acompanhamentoProjeto.getData().getTime()));
				ps.setString(4, acompanhamentoProjeto.getAutor());
				ps.setString(5, acompanhamentoProjeto.getNotarevisao());
				ps.setObject(6, acompanhamentoProjeto.getAprovacao());
				ps.setString(7, acompanhamentoProjeto.getProdutoservico());
				ps.setString(8, acompanhamentoProjeto.getSituacaoconcluida());
				ps.setDate(9, new java.sql.Date(acompanhamentoProjeto.getDataplanejada().getTime()));
				ps.setDate(10, new java.sql.Date(acompanhamentoProjeto.getDataefetiva().getTime()));
				ps.setLong(11, acompanhamentoProjeto.getAtrasoprevisto());
				ps.setDouble(12, acompanhamentoProjeto.getValororcado());
				ps.setDouble(13, acompanhamentoProjeto.getCustoreal());
				ps.setString(14, acompanhamentoProjeto.getEspecificacao());
				ps.setObject(15, acompanhamentoProjeto.getNivel());
				ps.setString(16, acompanhamentoProjeto.getAcao());
				ps.setString(17, acompanhamentoProjeto.getResponsavel());
				ps.setObject(18, acompanhamentoProjeto.getProjetoinicio().getCodigo());
				
				ps.executeUpdate();
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
	
	private void setPreparedStatement(AcompanhamentoProjeto acompanhamentoProjeto, PreparedStatement ps) throws SQLException{
		
		ps.setString(1, acompanhamentoProjeto.getAcompanhamentoprojeto());				
		ps.setLong(2, acompanhamentoProjeto.getVersao());
		ps.setDate(3, new java.sql.Date(acompanhamentoProjeto.getData().getTime()));
		ps.setString(4, acompanhamentoProjeto.getAutor());
		ps.setString(5, acompanhamentoProjeto.getNotarevisao());
		ps.setObject(6, acompanhamentoProjeto.getAprovacao());
		ps.setString(7, acompanhamentoProjeto.getProdutoservico());
		ps.setString(8, acompanhamentoProjeto.getSituacaoconcluida());
		ps.setDate(9, new java.sql.Date(acompanhamentoProjeto.getDataplanejada().getTime()));
		ps.setDate(10, new java.sql.Date(acompanhamentoProjeto.getDataefetiva().getTime()));
		ps.setLong(11, acompanhamentoProjeto.getAtrasoprevisto());
		ps.setDouble(12, acompanhamentoProjeto.getValororcado());
		ps.setDouble(13, acompanhamentoProjeto.getCustoreal());
		ps.setString(14, acompanhamentoProjeto.getEspecificacao());
		ps.setObject(15, acompanhamentoProjeto.getNivel());
		ps.setString(16, acompanhamentoProjeto.getAcao());
		ps.setString(17, acompanhamentoProjeto.getResponsavel());
		ps.setObject(18, acompanhamentoProjeto.getProjetoinicio().getCodigo());
		ps.setLong(19, acompanhamentoProjeto.getCodigo());
	}
	@Override
	public AcompanhamentoProjeto getAcompanhamentoProjeto(Integer codigo) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
					
		try {
			
			String sqlSelect = "SELECT * FROM acompanhamentoprojeto WHERE codigo = ?;";				
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando				
			rs = ps.executeQuery();
				
			List<AcompanhamentoProjeto> resultado = getListaAcompanhamentoProjeto(rs);
			
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

	@Override
	public AcompanhamentoProjeto getAcompanhamentoProjeto(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AcompanhamentoProjeto> getAcompanhamentoProjetos() throws Exception {
		
			List<AcompanhamentoProjeto> resultado = new ArrayList<AcompanhamentoProjeto>();	
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM acompanhamentoprojeto, projetoinicio WHERE projetoinicio = projetoinicio";	
			
			ps = con.prepareStatement(sqlSelect);
			rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.														
			
			//resultado = getListaRequerimento(rs);		
			while(rs.next()){
				// criando objeto para cada registro no BD 
				AcompanhamentoProjeto acompanhamentoProjeto = new AcompanhamentoProjeto();
				
				acompanhamentoProjeto.setAcompanhamentoprojeto(rs.getString("acompanhamentoprojeto"));
				acompanhamentoProjeto.setVersao(rs.getLong("versao"));
				acompanhamentoProjeto.setData(rs.getDate("dataefetiva"));
				acompanhamentoProjeto.setAutor(rs.getString("autor"));
				acompanhamentoProjeto.setNotarevisao(rs.getString("notarevisao"));
				acompanhamentoProjeto.setAprovacao(rs.getString("aprovacao"));
				acompanhamentoProjeto.setProdutoservico(rs.getString("produtoservico"));
				acompanhamentoProjeto.setSituacaoconcluida(rs.getString("situacaoconcluida"));
				acompanhamentoProjeto.setDataplanejada(rs.getDate("dataplanejada"));
				acompanhamentoProjeto.setDataefetiva(rs.getDate("dataefetiva"));
				acompanhamentoProjeto.setAtrasoprevisto(rs.getLong("atrasoprevisto"));
				acompanhamentoProjeto.setValororcado(rs.getDouble("valororcado"));
				acompanhamentoProjeto.setCustoreal(rs.getDouble("custoreal"));
				acompanhamentoProjeto.setEspecificacao(rs.getString("especificacao"));
				acompanhamentoProjeto.setNivel(rs.getString("nivel"));
				acompanhamentoProjeto.setAcao(rs.getString("acao"));
				acompanhamentoProjeto.setResponsavel(rs.getString("responsavel"));
				acompanhamentoProjeto.setCodigo(rs.getLong("codigo"));
				
				acompanhamentoProjeto.getProjetoinicio().setCodigo(rs.getLong("codigo"));
				
				acompanhamentoProjeto.getProjetoinicio().setCodigoprojeto(rs.getInt("codigoprojeto"));
				acompanhamentoProjeto.getProjetoinicio().setProjeto(rs.getString("projeto"));					
				acompanhamentoProjeto.getProjetoinicio().setData(rs.getDate("data"));
				acompanhamentoProjeto.getProjetoinicio().setAtribuiprojeto(rs.getString("atribuiprojeto"));
				acompanhamentoProjeto.getProjetoinicio().setTipoprojeto(rs.getString("tipoprojeto"));
				acompanhamentoProjeto.getProjetoinicio().setObjetivo(rs.getString("objetivo"));
				acompanhamentoProjeto.getProjetoinicio().setCliente(rs.getString("cliente"));
				acompanhamentoProjeto.getProjetoinicio().setPrograma(rs.getString("programa"));
				acompanhamentoProjeto.getProjetoinicio().setArea(rs.getString("area"));
				acompanhamentoProjeto.getProjetoinicio().setRoi(rs.getDouble("roi"));
				acompanhamentoProjeto.getProjetoinicio().setDescricao(rs.getString("descricao"));
				acompanhamentoProjeto.getProjetoinicio().setCopia(rs.getString("copia"));
				
				resultado.add(acompanhamentoProjeto);
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
	
	private List<AcompanhamentoProjeto> getListaAcompanhamentoProjeto(ResultSet rs) throws SQLException{
		
		List<AcompanhamentoProjeto> resultado = new ArrayList<AcompanhamentoProjeto>();
		
		while(rs.next()){
			
			// criando objeto para cada registro no BD 
			AcompanhamentoProjeto acompanhamentoProjeto = new AcompanhamentoProjeto();
			
			acompanhamentoProjeto.setAcompanhamentoprojeto(rs.getString("acompanhamentoprojeto"));
			acompanhamentoProjeto.setVersao(rs.getLong("versao"));
			acompanhamentoProjeto.setData(rs.getDate("dataefetiva"));
			acompanhamentoProjeto.setAutor(rs.getString("autor"));
			acompanhamentoProjeto.setNotarevisao(rs.getString("notarevisao"));
			acompanhamentoProjeto.setAprovacao(rs.getString("aprovacao"));
			acompanhamentoProjeto.setProdutoservico(rs.getString("produtoservico"));
			acompanhamentoProjeto.setSituacaoconcluida(rs.getString("situacaoconcluida"));
			acompanhamentoProjeto.setDataplanejada(rs.getDate("dataplanejada"));
			acompanhamentoProjeto.setDataefetiva(rs.getDate("dataefetiva"));
			acompanhamentoProjeto.setAtrasoprevisto(rs.getLong("atrasoprevisto"));
			acompanhamentoProjeto.setValororcado(rs.getDouble("valororcado"));
			acompanhamentoProjeto.setCustoreal(rs.getDouble("custoreal"));
			acompanhamentoProjeto.setEspecificacao(rs.getString("especificacao"));
			acompanhamentoProjeto.setNivel(rs.getString("nivel"));
			acompanhamentoProjeto.setAcao(rs.getString("acao"));
			acompanhamentoProjeto.setResponsavel(rs.getString("responsavel"));
			acompanhamentoProjeto.setCodigo(rs.getLong("codigo"));
			
			resultado.add(acompanhamentoProjeto);
			}
		return resultado;
	}
}

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
import br.com.tkcsapcd.model.bean.OrcamentoProjeto;
import br.com.tkcsapcd.model.util.Conexao;

public class OrcamentoProjetoDAO implements InterfaceOrcamentoProjetoDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public OrcamentoProjetoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM orcamentoprojeto WHERE codigo = ?;";

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

	private void setPreparedStatement(OrcamentoProjeto orcamentoProjeto, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, orcamentoProjeto.getOrcamento());
		ps.setString(2, orcamentoProjeto.getProjeto());
		ps.setInt(3, orcamentoProjeto.getCodigoprojeto());
		ps.setString(4, orcamentoProjeto.getVersao());
		ps.setString(5, orcamentoProjeto.getData());
		ps.setString(6, orcamentoProjeto.getAutor());
		ps.setString(7, orcamentoProjeto.getNotarevisao());
		ps.setString(8, orcamentoProjeto.getAprovacao());
		ps.setObject(9, orcamentoProjeto.getObjetivo());
		ps.setString(10, orcamentoProjeto.getBase());
		ps.setString(11, orcamentoProjeto.getEstimativarecurso());		
		ps.setString(12, orcamentoProjeto.getEstimativaatividade());
		ps.setString(13, orcamentoProjeto.getLinha());
		ps.setString(14, orcamentoProjeto.getRequisito());	
		ps.setString(15, orcamentoProjeto.getFluxo());
		ps.setInt(16, orcamentoProjeto.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public OrcamentoProjeto getOrcamentoProjeto(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM orcamentoprojeto WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<OrcamentoProjeto> resultado = getListaOrcamentoProjeto(rs);
			
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
		private List<OrcamentoProjeto> getListaOrcamentoProjeto(ResultSet rs) throws SQLException	{
				List<OrcamentoProjeto> resultado = new ArrayList<OrcamentoProjeto>();
			
			// Laço p/ preencher
			while (rs.next()) {
				OrcamentoProjeto orcamentoProjeto = new OrcamentoProjeto();
				
				orcamentoProjeto.setOrcamento(rs.getString("orcamento"));
				orcamentoProjeto.setProjeto(rs.getString("projeto"));
				orcamentoProjeto.setCodigoprojeto(rs.getInt("codigoprojeto"));
				orcamentoProjeto.setVersao(rs.getString("versao"));
				orcamentoProjeto.setData(rs.getString("data"));
				orcamentoProjeto.setAutor(rs.getString("autor"));
				orcamentoProjeto.setNotarevisao(rs.getString("notarevisao"));
				orcamentoProjeto.setAprovacao(rs.getString("aprovacao"));
				orcamentoProjeto.setObjetivo(rs.getString("objetivo"));				
				orcamentoProjeto.setBase(rs.getString("base"));					
				orcamentoProjeto.setEstimativarecurso(rs.getString("estimativarecurso"));
				orcamentoProjeto.setEstimativaatividade(rs.getString("estimativaatividade"));
				orcamentoProjeto.setLinha(rs.getString("linha"));
				orcamentoProjeto.setRequisito(rs.getString("requisito"));
				orcamentoProjeto.setFluxo(rs.getString("fluxo"));
				orcamentoProjeto.setCodigo(rs.getInt("codigo"));
												
				resultado.add(orcamentoProjeto);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(OrcamentoProjeto orcamentoProjeto) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE orcamentoprojeto SET 	orcamento = ?, projeto = ?, codigoprojeto = ?, versao = ?, data = ?, autor = ?, notarevisao = ?, aprovacao = ?, objetivo = ?, base = ?, estimativarecurso = ?, estimativaatividade = ?, linha = ?, requisito = ?, fluxo = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(orcamentoProjeto, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(OrcamentoProjeto orcamentoProjeto) throws Exception  {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO orcamentoprojeto(orcamento, projeto, codigoprojeto, versao, data, autor, notarevisao, aprovacao, objetivo, base, estimativarecurso, estimativaatividade, linha, requisito, fluxo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, orcamentoProjeto.getOrcamento());
			ps.setString(2, orcamentoProjeto.getProjeto());
			ps.setInt(3, orcamentoProjeto.getCodigoprojeto());
			ps.setString(4, orcamentoProjeto.getVersao());
			ps.setString(5, orcamentoProjeto.getData());
			ps.setString(6, orcamentoProjeto.getAutor());
			ps.setString(7, orcamentoProjeto.getNotarevisao());
			ps.setString(8, orcamentoProjeto.getAprovacao());
			ps.setObject(9, orcamentoProjeto.getObjetivo());
			ps.setString(10, orcamentoProjeto.getBase());
			ps.setString(11, orcamentoProjeto.getEstimativarecurso());		
			ps.setString(12, orcamentoProjeto.getEstimativaatividade());
			ps.setString(13, orcamentoProjeto.getLinha());
			ps.setString(14, orcamentoProjeto.getRequisito());	
			ps.setString(15, orcamentoProjeto.getFluxo());
			
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
	public List<OrcamentoProjeto> getOrcamentoProjetos() throws Exception {		
		   List<OrcamentoProjeto> resultado = new ArrayList<OrcamentoProjeto>();// Montar o resultado
		   
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM orcamentoprojeto";
				
				 ps = con.prepareStatement(sqlSelect);
				 rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					OrcamentoProjeto orcamentoProjeto = new OrcamentoProjeto();
					
					orcamentoProjeto.setOrcamento(rs.getString("orcamento"));
					orcamentoProjeto.setProjeto(rs.getString("projeto"));
					orcamentoProjeto.setCodigoprojeto(rs.getInt("codigoprojeto"));
					orcamentoProjeto.setVersao(rs.getString("versao"));
					orcamentoProjeto.setData(rs.getString("data"));
					orcamentoProjeto.setAutor(rs.getString("autor"));
					orcamentoProjeto.setNotarevisao(rs.getString("notarevisao"));
					orcamentoProjeto.setAprovacao(rs.getString("aprovacao"));
					orcamentoProjeto.setObjetivo(rs.getString("objetivo"));				
					orcamentoProjeto.setBase(rs.getString("base"));					
					orcamentoProjeto.setEstimativarecurso(rs.getString("estimativarecurso"));
					orcamentoProjeto.setEstimativaatividade(rs.getString("estimativaatividade"));
					orcamentoProjeto.setLinha(rs.getString("linha"));
					orcamentoProjeto.setRequisito(rs.getString("requisito"));
					orcamentoProjeto.setFluxo(rs.getString("fluxo"));
					orcamentoProjeto.setCodigo(rs.getInt("codigo"));
									
					resultado.add(orcamentoProjeto);// Add o projeto ao resultado.
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

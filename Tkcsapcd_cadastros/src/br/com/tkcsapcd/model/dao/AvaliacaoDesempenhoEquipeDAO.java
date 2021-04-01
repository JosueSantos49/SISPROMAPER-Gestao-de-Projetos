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
import br.com.tkcsapcd.model.bean.AvaliacaoDesempenhoEquipe;
import br.com.tkcsapcd.model.util.Conexao;

public class AvaliacaoDesempenhoEquipeDAO implements InterfaceAvaliacaoDesempenhoEquipeDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public AvaliacaoDesempenhoEquipeDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM avaliacaodesempenhoequipe WHERE codigo = ?;";

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
	
	private void setPreparedStatement(AvaliacaoDesempenhoEquipe avaliacaoDesempenhoEquipe, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, avaliacaoDesempenhoEquipe.getAvaliacaodesempenhoequipe());
		ps.setString(2, avaliacaoDesempenhoEquipe.getProjeto());
		ps.setInt(3, avaliacaoDesempenhoEquipe.getCodigoprojeto());
		ps.setString(4, avaliacaoDesempenhoEquipe.getVersao());
		ps.setString(5, avaliacaoDesempenhoEquipe.getData());
		ps.setString(6, avaliacaoDesempenhoEquipe.getAutor());
		ps.setString(7, avaliacaoDesempenhoEquipe.getNotarevisao());
		ps.setString(8, avaliacaoDesempenhoEquipe.getAprovacao());
		ps.setString(9, avaliacaoDesempenhoEquipe.getEquipe());
		ps.setString(10, avaliacaoDesempenhoEquipe.getPeriodoinicio());		
		ps.setString(11, avaliacaoDesempenhoEquipe.getPeriodofim());
		ps.setString(12, avaliacaoDesempenhoEquipe.getObjetivo());
		ps.setString(13, avaliacaoDesempenhoEquipe.getAvaliacao());	
		ps.setString(14, avaliacaoDesempenhoEquipe.getIndicador());
		ps.setString(15, avaliacaoDesempenhoEquipe.getStatus());
		ps.setString(16, avaliacaoDesempenhoEquipe.getPontoforte());
		ps.setString(17, avaliacaoDesempenhoEquipe.getPontofraco());
		ps.setString(18, avaliacaoDesempenhoEquipe.getResultadoatingido());
		ps.setString(19, avaliacaoDesempenhoEquipe.getRetornoavaliacao());
		ps.setString(20, avaliacaoDesempenhoEquipe.getPlano());
		ps.setString(21, avaliacaoDesempenhoEquipe.getDefinicao());
		ps.setObject(22, avaliacaoDesempenhoEquipe.getNecessidade());
		ps.setInt(23, avaliacaoDesempenhoEquipe.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public AvaliacaoDesempenhoEquipe getAvaliacaoDesempenhoEquipe(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM avaliacaodesempenhoequipe WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<AvaliacaoDesempenhoEquipe> resultado = getListaAvaliacaoDesempenhoEquipe(rs);
			
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
		private List<AvaliacaoDesempenhoEquipe> getListaAvaliacaoDesempenhoEquipe(ResultSet rs) throws SQLException	{
			List<AvaliacaoDesempenhoEquipe> resultado = new ArrayList<AvaliacaoDesempenhoEquipe>();
			
			// Laço p/ preencher
			while (rs.next()) {

				AvaliacaoDesempenhoEquipe avaliacaoDesempenhoEquipe = new AvaliacaoDesempenhoEquipe();
				
				avaliacaoDesempenhoEquipe.setAvaliacaodesempenhoequipe(rs.getString("avaliacaodesempenhoequipe"));
				avaliacaoDesempenhoEquipe.setProjeto(rs.getString("projeto"));
				avaliacaoDesempenhoEquipe.setCodigoprojeto(rs.getInt("codigoprojeto"));
				avaliacaoDesempenhoEquipe.setVersao(rs.getString("versao"));
				avaliacaoDesempenhoEquipe.setData(rs.getString("data"));
				avaliacaoDesempenhoEquipe.setAutor(rs.getString("autor"));
				avaliacaoDesempenhoEquipe.setNotarevisao(rs.getString("notarevisao"));
				avaliacaoDesempenhoEquipe.setAprovacao(rs.getString("aprovacao"));
				avaliacaoDesempenhoEquipe.setEquipe(rs.getString("equipe"));				
				avaliacaoDesempenhoEquipe.setPeriodoinicio(rs.getString("periodoinicio"));					
				avaliacaoDesempenhoEquipe.setPeriodofim(rs.getString("periodofim"));
				avaliacaoDesempenhoEquipe.setObjetivo(rs.getString("objetivo"));
				avaliacaoDesempenhoEquipe.setAvaliacao(rs.getString("retornoavaliacao"));
				avaliacaoDesempenhoEquipe.setIndicador(rs.getString("indicador"));
				avaliacaoDesempenhoEquipe.setStatus(rs.getString("status"));
				avaliacaoDesempenhoEquipe.setPontofraco(rs.getString("pontofraco"));
				avaliacaoDesempenhoEquipe.setPontoforte(rs.getString("pontoforte"));
				avaliacaoDesempenhoEquipe.setResultadoatingido(rs.getString("resultadoatingido"));					
				avaliacaoDesempenhoEquipe.setRetornoavaliacao(rs.getString("retornoavaliacao"));
				avaliacaoDesempenhoEquipe.setPlano(rs.getString("plano"));
				avaliacaoDesempenhoEquipe.setDefinicao(rs.getString("definicao"));
				avaliacaoDesempenhoEquipe.setNecessidade(rs.getString("necessidade"));
				avaliacaoDesempenhoEquipe.setCodigo(rs.getInt("codigo"));
												
				resultado.add(avaliacaoDesempenhoEquipe);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(AvaliacaoDesempenhoEquipe avaliacaoDesempenhoEquipe) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			
			String sqlAtualizar = "UPDATE avaliacaodesempenhoequipe SET avaliacaodesempenhoequipe = ?, projeto = ?, codigoprojeto = ?, versao = ?, data = ?, autor = ?, notarevisao = ?, aprovacao = ?, equipe = ?, periodoinicio = ?, periodofim = ?, objetivo = ?, avaliacao = ?, indicador = ?, status = ?, pontoforte = ?, pontofraco = ?, resultadoatingido = ?, retornoavaliacao = ?, plano = ?, definicao = ?, necessidade = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(avaliacaoDesempenhoEquipe, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(AvaliacaoDesempenhoEquipe avaliacaoDesempenhoEquipe) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO avaliacaodesempenhoequipe(avaliacaodesempenhoequipe, projeto, codigoprojeto, versao, data, autor, notarevisao, aprovacao, equipe, periodoinicio, periodofim, objetivo, avaliacao, indicador, status, pontoforte, pontofraco, resultadoatingido, retornoavaliacao, plano, definicao, necessidade) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, avaliacaoDesempenhoEquipe.getAvaliacaodesempenhoequipe());
			ps.setString(2, avaliacaoDesempenhoEquipe.getProjeto());
			ps.setInt(3, avaliacaoDesempenhoEquipe.getCodigoprojeto());
			ps.setString(4, avaliacaoDesempenhoEquipe.getVersao());
			ps.setString(5, avaliacaoDesempenhoEquipe.getData());
			ps.setString(6, avaliacaoDesempenhoEquipe.getAutor());
			ps.setString(7, avaliacaoDesempenhoEquipe.getNotarevisao());
			ps.setString(8, avaliacaoDesempenhoEquipe.getAprovacao());
			ps.setString(9, avaliacaoDesempenhoEquipe.getEquipe());
			ps.setString(10, avaliacaoDesempenhoEquipe.getPeriodoinicio());		
			ps.setString(11, avaliacaoDesempenhoEquipe.getPeriodofim());
			ps.setString(12, avaliacaoDesempenhoEquipe.getObjetivo());
			ps.setString(13, avaliacaoDesempenhoEquipe.getAvaliacao());	
			ps.setString(14, avaliacaoDesempenhoEquipe.getIndicador());
			ps.setString(15, avaliacaoDesempenhoEquipe.getStatus());
			ps.setString(16, avaliacaoDesempenhoEquipe.getPontoforte());
			ps.setString(17, avaliacaoDesempenhoEquipe.getPontofraco());
			ps.setString(18, avaliacaoDesempenhoEquipe.getResultadoatingido());
			ps.setString(19, avaliacaoDesempenhoEquipe.getRetornoavaliacao());
			ps.setString(20, avaliacaoDesempenhoEquipe.getPlano());
			ps.setString(21, avaliacaoDesempenhoEquipe.getDefinicao());
			ps.setObject(22, avaliacaoDesempenhoEquipe.getNecessidade());		
			
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
	public List<AvaliacaoDesempenhoEquipe> getAvaliacaoDesempenhoEquipes() throws Exception {
		
		   List<AvaliacaoDesempenhoEquipe> resultado = new ArrayList<AvaliacaoDesempenhoEquipe>();// Montar o resultado
		   Connection con=null;
		   PreparedStatement ps=null;
		   ResultSet rs =null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM avaliacaodesempenhoequipe";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					
					AvaliacaoDesempenhoEquipe avaliacaoDesempenhoEquipe = new AvaliacaoDesempenhoEquipe();
					
					avaliacaoDesempenhoEquipe.setAvaliacaodesempenhoequipe(rs.getString("avaliacaodesempenhoequipe"));
					avaliacaoDesempenhoEquipe.setProjeto(rs.getString("projeto"));
					avaliacaoDesempenhoEquipe.setCodigoprojeto(rs.getInt("codigoprojeto"));
					avaliacaoDesempenhoEquipe.setVersao(rs.getString("versao"));
					avaliacaoDesempenhoEquipe.setData(rs.getString("data"));
					avaliacaoDesempenhoEquipe.setAutor(rs.getString("autor"));
					avaliacaoDesempenhoEquipe.setNotarevisao(rs.getString("notarevisao"));
					avaliacaoDesempenhoEquipe.setAprovacao(rs.getString("aprovacao"));
					avaliacaoDesempenhoEquipe.setEquipe(rs.getString("equipe"));				
					avaliacaoDesempenhoEquipe.setPeriodoinicio(rs.getString("periodoinicio"));					
					avaliacaoDesempenhoEquipe.setPeriodofim(rs.getString("periodofim"));
					avaliacaoDesempenhoEquipe.setObjetivo(rs.getString("objetivo"));
					avaliacaoDesempenhoEquipe.setAvaliacao(rs.getString("retornoavaliacao"));
					avaliacaoDesempenhoEquipe.setIndicador(rs.getString("indicador"));
					avaliacaoDesempenhoEquipe.setStatus(rs.getString("status"));
					avaliacaoDesempenhoEquipe.setPontofraco(rs.getString("pontofraco"));
					avaliacaoDesempenhoEquipe.setPontoforte(rs.getString("pontoforte"));
					avaliacaoDesempenhoEquipe.setResultadoatingido(rs.getString("resultadoatingido"));					
					avaliacaoDesempenhoEquipe.setRetornoavaliacao(rs.getString("retornoavaliacao"));
					avaliacaoDesempenhoEquipe.setPlano(rs.getString("plano"));
					avaliacaoDesempenhoEquipe.setDefinicao(rs.getString("definicao"));
					avaliacaoDesempenhoEquipe.setNecessidade(rs.getString("necessidade"));
					avaliacaoDesempenhoEquipe.setCodigo(rs.getInt("codigo"));
									
					resultado.add(avaliacaoDesempenhoEquipe);// Add o projeto ao resultado.
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

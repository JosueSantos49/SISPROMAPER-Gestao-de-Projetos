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
import br.com.tkcsapcd.model.bean.PlanoGerenciamentoCronograma;
import br.com.tkcsapcd.model.util.Conexao;

public class PlanoGerenciamentoConogramaDAO implements InterfacePlanoGerenciamentoCronogramaDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public PlanoGerenciamentoConogramaDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM planogerenciamentocronograma WHERE codigo = ?;";

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
	
	private void setPreparedStatement(PlanoGerenciamentoCronograma planoGerenciamentoCronograma, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, planoGerenciamentoCronograma.getPlanogerenciamentocronograma());
		ps.setString(2, planoGerenciamentoCronograma.getVersao());
		ps.setDate(3, new java.sql.Date(planoGerenciamentoCronograma.getData().getTime()));
		ps.setString(4, planoGerenciamentoCronograma.getAutor());
		ps.setString(5, planoGerenciamentoCronograma.getNotarevisao());
		ps.setString(6, planoGerenciamentoCronograma.getAprovacao());
		ps.setObject(7, planoGerenciamentoCronograma.getObjetivo());
		ps.setString(8, planoGerenciamentoCronograma.getMetodo());
		ps.setString(9, planoGerenciamentoCronograma.getProcesso());		
		ps.setString(10, planoGerenciamentoCronograma.getDocumento());
		ps.setString(11, planoGerenciamentoCronograma.getFerramenta());
		ps.setString(12, planoGerenciamentoCronograma.getPapeis());	
		ps.setString(13, planoGerenciamentoCronograma.getPlano());
		ps.setString(14, planoGerenciamentoCronograma.getAtividade());
		ps.setString(15, planoGerenciamentoCronograma.getSequenciar());
		ps.setString(16, planoGerenciamentoCronograma.getEstimarrecuso());
		ps.setString(17, planoGerenciamentoCronograma.getEstimarduracao());
		ps.setString(18, planoGerenciamentoCronograma.getDesenvolver());
		ps.setString(19, planoGerenciamentoCronograma.getControlar());
		ps.setObject(20, planoGerenciamentoCronograma.getProjetoinicio().getCodigo());
		ps.setLong(21, planoGerenciamentoCronograma.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public PlanoGerenciamentoCronograma getPlanoGerenciamentoCronograma(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM planogerenciamentocronograma WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<PlanoGerenciamentoCronograma> resultado = getListaPlanoGerenciamentoCronograma(rs);
			
			if (resultado.size() > 0)			
				return resultado.get(0);//pegando elemento por chave (unico projeto!).			
			
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
		return null;
	}
	/*---------------------------------------------------------------------------------------------------------------------------------------*/

		//Metodo p confirma objetivo. Resulmir linhas de códigos, que pode ser usados em outros métodos. (ex: resultado = getListaCliente(rs); ou List<Cliente> resultado = getListaCliente(rs);)
		private List<PlanoGerenciamentoCronograma> getListaPlanoGerenciamentoCronograma(ResultSet rs) throws SQLException	{
			List<PlanoGerenciamentoCronograma> resultado = new ArrayList<PlanoGerenciamentoCronograma>();
			
			// Laço p/ preencher
			while (rs.next()) {
				PlanoGerenciamentoCronograma planoGerenciamentoCronograma = new PlanoGerenciamentoCronograma();
				
				planoGerenciamentoCronograma.setPlanogerenciamentocronograma(rs.getString("planogerenciamentocronograma"));
				planoGerenciamentoCronograma.setVersao(rs.getString("versao"));
				planoGerenciamentoCronograma.setData(rs.getDate("data"));
				planoGerenciamentoCronograma.setAutor(rs.getString("autor"));
				planoGerenciamentoCronograma.setNotarevisao(rs.getString("notarevisao"));
				planoGerenciamentoCronograma.setAprovacao(rs.getString("aprovacao"));
				planoGerenciamentoCronograma.setObjetivo(rs.getString("objetivo"));				
				planoGerenciamentoCronograma.setMetodo(rs.getString("metodo"));					
				planoGerenciamentoCronograma.setProcesso(rs.getString("processo"));
				planoGerenciamentoCronograma.setDocumento(rs.getString("documento"));
				planoGerenciamentoCronograma.setFerramenta(rs.getString("ferramenta"));
				planoGerenciamentoCronograma.setPapeis(rs.getString("papeis"));
				planoGerenciamentoCronograma.setPlano(rs.getString("plano"));
				planoGerenciamentoCronograma.setAtividade(rs.getString("atividade"));
				planoGerenciamentoCronograma.setSequenciar(rs.getString("sequenciar"));
				planoGerenciamentoCronograma.setEstimarrecuso(rs.getString("estimarrecuso"));					
				planoGerenciamentoCronograma.setEstimarduracao(rs.getString("estimarduracao"));
				planoGerenciamentoCronograma.setDesenvolver(rs.getString("desenvolver"));
				planoGerenciamentoCronograma.setControlar(rs.getString("controlar"));
				planoGerenciamentoCronograma.setCodigo(rs.getLong("codigo"));
												
				resultado.add(planoGerenciamentoCronograma);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(PlanoGerenciamentoCronograma planoGerenciamentoCronograma) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE planogerenciamentocronograma SET 	planogerenciamentocronograma  = ?, versao  = ?, data  = ?, autor  = ?, notarevisao  = ?, aprovacao  = ?, objetivo  = ?, metodo  = ?, processo  = ?, documento  = ?, ferramenta  = ?, papeis  = ?, plano  = ?, atividade  = ?, sequenciar  = ?, estimarrecuso  = ?, estimarduracao  = ?, desenvolver  = ?, controlar = ?, projetoinicio = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(planoGerenciamentoCronograma, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(PlanoGerenciamentoCronograma planoGerenciamentoCronograma) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO planogerenciamentocronograma(planogerenciamentocronograma, versao, data, autor, notarevisao, aprovacao, objetivo, metodo, processo, documento, ferramenta, papeis, plano, atividade, sequenciar, estimarrecuso, estimarduracao, desenvolver, controlar, projetoinicio) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, planoGerenciamentoCronograma.getPlanogerenciamentocronograma());
			ps.setString(2, planoGerenciamentoCronograma.getVersao());
			ps.setDate(3, new java.sql.Date(planoGerenciamentoCronograma.getData().getTime()));
			ps.setString(4, planoGerenciamentoCronograma.getAutor());
			ps.setString(5, planoGerenciamentoCronograma.getNotarevisao());
			ps.setString(6, planoGerenciamentoCronograma.getAprovacao());
			ps.setObject(7, planoGerenciamentoCronograma.getObjetivo());
			ps.setString(8, planoGerenciamentoCronograma.getMetodo());
			ps.setString(9, planoGerenciamentoCronograma.getProcesso());		
			ps.setString(10, planoGerenciamentoCronograma.getDocumento());
			ps.setString(11, planoGerenciamentoCronograma.getFerramenta());
			ps.setString(12, planoGerenciamentoCronograma.getPapeis());	
			ps.setString(13, planoGerenciamentoCronograma.getPlano());
			ps.setString(14, planoGerenciamentoCronograma.getAtividade());
			ps.setString(15, planoGerenciamentoCronograma.getSequenciar());
			ps.setString(16, planoGerenciamentoCronograma.getEstimarrecuso());
			ps.setString(17, planoGerenciamentoCronograma.getEstimarduracao());
			ps.setString(18, planoGerenciamentoCronograma.getDesenvolver());
			ps.setString(19, planoGerenciamentoCronograma.getControlar());
			ps.setObject(20, planoGerenciamentoCronograma.getProjetoinicio().getCodigo());		
			
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
	public List<PlanoGerenciamentoCronograma> getPlanoGerenciamentoCronogramas() throws Exception {
		
		   List<PlanoGerenciamentoCronograma> resultado = new ArrayList<PlanoGerenciamentoCronograma>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs =null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM planogerenciamentocronograma INNER JOIN projetoinicio ON planogerenciamentocronograma.projetoinicio = projetoinicio.codigo ORDER BY planogerenciamentocronograma.planogerenciamentocronograma";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					PlanoGerenciamentoCronograma planoGerenciamentoCronograma = new PlanoGerenciamentoCronograma();
				
					planoGerenciamentoCronograma.setPlanogerenciamentocronograma(rs.getString("planogerenciamentocronograma"));
					planoGerenciamentoCronograma.setVersao(rs.getString("versao"));
					planoGerenciamentoCronograma.setData(rs.getDate("data"));
					planoGerenciamentoCronograma.setAutor(rs.getString("autor"));
					planoGerenciamentoCronograma.setNotarevisao(rs.getString("notarevisao"));
					planoGerenciamentoCronograma.setAprovacao(rs.getString("aprovacao"));
					planoGerenciamentoCronograma.setObjetivo(rs.getString("objetivo"));				
					planoGerenciamentoCronograma.setMetodo(rs.getString("metodo"));					
					planoGerenciamentoCronograma.setProcesso(rs.getString("processo"));
					planoGerenciamentoCronograma.setDocumento(rs.getString("documento"));
					planoGerenciamentoCronograma.setFerramenta(rs.getString("ferramenta"));
					planoGerenciamentoCronograma.setPapeis(rs.getString("papeis"));
					planoGerenciamentoCronograma.setPlano(rs.getString("plano"));
					planoGerenciamentoCronograma.setAtividade(rs.getString("atividade"));
					planoGerenciamentoCronograma.setSequenciar(rs.getString("sequenciar"));
					planoGerenciamentoCronograma.setEstimarrecuso(rs.getString("estimarrecuso"));					
					planoGerenciamentoCronograma.setEstimarduracao(rs.getString("estimarduracao"));
					planoGerenciamentoCronograma.setDesenvolver(rs.getString("desenvolver"));
					planoGerenciamentoCronograma.setControlar(rs.getString("controlar"));
					planoGerenciamentoCronograma.setCodigo(rs.getLong("codigo"));
					
					planoGerenciamentoCronograma.getProjetoinicio().setCodigo(rs.getLong("codigo"));
					
					planoGerenciamentoCronograma.getProjetoinicio().setCodigoprojeto(rs.getInt("codigoprojeto"));
					planoGerenciamentoCronograma.getProjetoinicio().setProjeto(rs.getString("projeto"));					
					planoGerenciamentoCronograma.getProjetoinicio().setData(rs.getDate("data"));
					planoGerenciamentoCronograma.getProjetoinicio().setAtribuiprojeto(rs.getString("atribuiprojeto"));
					planoGerenciamentoCronograma.getProjetoinicio().setTipoprojeto(rs.getString("tipoprojeto"));
					planoGerenciamentoCronograma.getProjetoinicio().setObjetivo(rs.getString("objetivo"));
					planoGerenciamentoCronograma.getProjetoinicio().setCliente(rs.getString("cliente"));
					planoGerenciamentoCronograma.getProjetoinicio().setPrograma(rs.getString("programa"));
					planoGerenciamentoCronograma.getProjetoinicio().setArea(rs.getString("area"));
					planoGerenciamentoCronograma.getProjetoinicio().setRoi(rs.getDouble("roi"));
					planoGerenciamentoCronograma.getProjetoinicio().setDescricao(rs.getString("descricao"));
					planoGerenciamentoCronograma.getProjetoinicio().setCopia(rs.getString("copia"));
									
					resultado.add(planoGerenciamentoCronograma);// Add o projeto ao resultado.
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

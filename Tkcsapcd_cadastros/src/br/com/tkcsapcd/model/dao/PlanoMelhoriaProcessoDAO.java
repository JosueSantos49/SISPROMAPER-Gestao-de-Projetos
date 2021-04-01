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
import br.com.tkcsapcd.model.bean.PlanoMelhoriaProcesso;
import br.com.tkcsapcd.model.util.Conexao;

public class PlanoMelhoriaProcessoDAO implements InterfacePlanoMelhoriaProcessoDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public PlanoMelhoriaProcessoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM planomelhoriaprocesso WHERE codigo = ?;";

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
	
	private void setPreparedStatement(PlanoMelhoriaProcesso planoMelhoriaProcesso, PreparedStatement ps) throws SQLException 
	{		
		ps.setString(1, planoMelhoriaProcesso.getPlanomelhoriaprocesso());
		ps.setString(2, planoMelhoriaProcesso.getProjeto());
		ps.setObject(3, planoMelhoriaProcesso.getCodigoprojeto());
		ps.setString(4, planoMelhoriaProcesso.getVersao());
		ps.setString(5, planoMelhoriaProcesso.getData());
		ps.setString(6, planoMelhoriaProcesso.getAutor());
		ps.setString(7, planoMelhoriaProcesso.getNotarevisao());
		ps.setString(8, planoMelhoriaProcesso.getObjetivo());
		ps.setString(9, planoMelhoriaProcesso.getLimite());
		ps.setString(10, planoMelhoriaProcesso.getConfiguracao());
		ps.setString(11, planoMelhoriaProcesso.getMetrica());
		ps.setString(12, planoMelhoriaProcesso.getMeta());
		ps.setString(13, planoMelhoriaProcesso.getAprovacao());
		ps.setInt(14, planoMelhoriaProcesso.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public PlanoMelhoriaProcesso getPlanoMelhoriaProcesso(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM planomelhoriaprocesso WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<PlanoMelhoriaProcesso> resultado = getListaPlanoMelhoriaProcesso(rs);
			
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
		private List<PlanoMelhoriaProcesso> getListaPlanoMelhoriaProcesso(ResultSet rs) throws SQLException	{
			List<PlanoMelhoriaProcesso> resultado = new ArrayList<PlanoMelhoriaProcesso>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				PlanoMelhoriaProcesso planoMelhoriaProcesso = new PlanoMelhoriaProcesso();
				
				planoMelhoriaProcesso.setPlanomelhoriaprocesso(rs.getString("planomelhoriaprocesso"));
				planoMelhoriaProcesso.setProjeto(rs.getString("projeto"));
				planoMelhoriaProcesso.setCodigoprojeto(rs.getInt("codigoprojeto"));
				planoMelhoriaProcesso.setVersao(rs.getString("versao"));
				planoMelhoriaProcesso.setData(rs.getString("data"));
				planoMelhoriaProcesso.setAutor(rs.getString("autor"));
				planoMelhoriaProcesso.setNotarevisao(rs.getString("notarevisao"));
				planoMelhoriaProcesso.setObjetivo(rs.getString("objetivo"));
				planoMelhoriaProcesso.setLimite(rs.getString("limite"));
				planoMelhoriaProcesso.setConfiguracao(rs.getString("configuracao"));
				planoMelhoriaProcesso.setMetrica(rs.getString("metrica"));
				planoMelhoriaProcesso.setMeta(rs.getString("meta"));
				planoMelhoriaProcesso.setAprovacao(rs.getString("aprovacao"));
				planoMelhoriaProcesso.setCodigo(rs.getInt("codigo"));
												
				resultado.add(planoMelhoriaProcesso);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(PlanoMelhoriaProcesso planoMelhoriaProcesso) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE planomelhoriaprocesso SET 	planomelhoriaprocesso = ?, projeto = ?, codigoprojeto = ?, versao = ?, data = ?, autor = ?, notarevisao = ?, objetivo = ?, limite = ?, configuracao = ?, metrica = ?, meta = ?, aprovacao = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(planoMelhoriaProcesso, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(PlanoMelhoriaProcesso planoMelhoriaProcesso) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO planomelhoriaprocesso(planomelhoriaprocesso, projeto, codigoprojeto, versao, data, autor, notarevisao, objetivo, limite, configuracao, metrica, meta, aprovacao) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, planoMelhoriaProcesso.getPlanomelhoriaprocesso());
			ps.setString(2, planoMelhoriaProcesso.getProjeto());
			ps.setObject(3, planoMelhoriaProcesso.getCodigoprojeto());
			ps.setString(4, planoMelhoriaProcesso.getVersao());
			ps.setString(5, planoMelhoriaProcesso.getData());
			ps.setString(6, planoMelhoriaProcesso.getAutor());
			ps.setString(7, planoMelhoriaProcesso.getNotarevisao());
			ps.setString(8, planoMelhoriaProcesso.getObjetivo());
			ps.setString(9, planoMelhoriaProcesso.getLimite());
			ps.setString(10, planoMelhoriaProcesso.getConfiguracao());
			ps.setString(11, planoMelhoriaProcesso.getMetrica());
			ps.setString(12, planoMelhoriaProcesso.getMeta());
			ps.setString(13, planoMelhoriaProcesso.getAprovacao());
			
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
	public List<PlanoMelhoriaProcesso> getPlanoMelhoriaProcessos() throws Exception  {
		
		   List<PlanoMelhoriaProcesso> resultado = new ArrayList<PlanoMelhoriaProcesso>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs =null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM planomelhoriaprocesso";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					
					PlanoMelhoriaProcesso planoMelhoriaProcesso = new PlanoMelhoriaProcesso();
					
					planoMelhoriaProcesso.setPlanomelhoriaprocesso(rs.getString("planomelhoriaprocesso"));
					planoMelhoriaProcesso.setProjeto(rs.getString("projeto"));
					planoMelhoriaProcesso.setCodigoprojeto(rs.getInt("codigoprojeto"));
					planoMelhoriaProcesso.setVersao(rs.getString("versao"));
					planoMelhoriaProcesso.setData(rs.getString("data"));
					planoMelhoriaProcesso.setAutor(rs.getString("autor"));
					planoMelhoriaProcesso.setNotarevisao(rs.getString("notarevisao"));
					planoMelhoriaProcesso.setObjetivo(rs.getString("objetivo"));
					planoMelhoriaProcesso.setLimite(rs.getString("limite"));
					planoMelhoriaProcesso.setConfiguracao(rs.getString("configuracao"));
					planoMelhoriaProcesso.setMetrica(rs.getString("metrica"));
					planoMelhoriaProcesso.setMeta(rs.getString("meta"));
					planoMelhoriaProcesso.setAprovacao(rs.getString("aprovacao"));
					planoMelhoriaProcesso.setCodigo(rs.getInt("codigo"));
									
					resultado.add(planoMelhoriaProcesso);// Add o projeto ao resultado.
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

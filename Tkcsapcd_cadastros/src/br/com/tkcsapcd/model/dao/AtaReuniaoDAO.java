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
import br.com.tkcsapcd.model.bean.AtaReuniao;
import br.com.tkcsapcd.model.util.Conexao;

public class AtaReuniaoDAO implements InterfaceAtaReuniaoDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public AtaReuniaoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM atareuniao WHERE codigo = ?;";

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

	private void setPreparedStatement(AtaReuniao ataReuniao, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, ataReuniao.getAta());
		ps.setDate(2, new java.sql.Date(ataReuniao.getData().getTime()));
		ps.setString(3, ataReuniao.getLocal());
		ps.setString(4, ataReuniao.getParticipante());
		ps.setString(5, ataReuniao.getObjetivo());
		ps.setString(6, ataReuniao.getTopico());
		ps.setObject(7, ataReuniao.getAcoestomadas());
		ps.setString(8, ataReuniao.getProximareuniao());
		ps.setString(9, ataReuniao.getAdicionais());
		ps.setString(10, ataReuniao.getAprovacao());
		ps.setLong(11, ataReuniao.getVersao());
		ps.setObject(12, ataReuniao.getProjetoinicio().getCodigo());
		ps.setLong(13, ataReuniao.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public AtaReuniao getAtaReuniao(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM atareuniao WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<AtaReuniao> resultado = getListaAtaReuniao(rs);
			
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
		private List<AtaReuniao> getListaAtaReuniao(ResultSet rs) throws SQLException	{
			List<AtaReuniao> resultado = new ArrayList<AtaReuniao>();
			
			// Laço p/ preencher
			while (rs.next()) {
				AtaReuniao ataReuniao = new AtaReuniao();
				
				ataReuniao.setAta(rs.getString("ata"));
				ataReuniao.setData(rs.getDate("data"));
				ataReuniao.setLocal(rs.getString("local"));
				ataReuniao.setParticipante(rs.getString("participante"));
				ataReuniao.setObjetivo(rs.getString("objetivo"));
				ataReuniao.setTopico(rs.getString("topico"));
				ataReuniao.setVersao(rs.getLong("versao"));
				ataReuniao.setAcoestomadas(rs.getString("acoestomadas"));
				ataReuniao.setProximareuniao(rs.getString("proximareuniao"));
				ataReuniao.setAcoestomadas(rs.getString("acoestomadas"));
				ataReuniao.setAdicionais(rs.getString("adicionais"));
				ataReuniao.setAprovacao(rs.getString("aprovacao"));
				ataReuniao.setCodigo(rs.getLong("codigo"));
								
				resultado.add(ataReuniao);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(AtaReuniao ataReuniao) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
								
		try{
			String sqlAtualizar = "UPDATE atareuniao SET  ata= ?, data= ?, local= ?, participante= ?, objetivo= ?, topico= ?, acoestomadas= ?, proximareuniao= ?, adicionais= ?, aprovacao = ?, versao = ?, projetoinicio = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(ataReuniao, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
			ps.executeUpdate();//Linha muito importante, sem ela não é executado a atualização
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
	public void salvar(AtaReuniao ataReuniao) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		try {			
			String sqlInsert = "INSERT INTO atareuniao(ata, data, local, participante, objetivo, topico, acoestomadas, proximareuniao, adicionais, aprovacao, versao, projetoinicio) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
						
			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, ataReuniao.getAta());
			ps.setDate(2, new java.sql.Date(ataReuniao.getData().getTime()));
			ps.setString(3, ataReuniao.getLocal());
			ps.setString(4, ataReuniao.getParticipante());
			ps.setString(5, ataReuniao.getObjetivo());
			ps.setString(6, ataReuniao.getTopico());
			ps.setObject(7, ataReuniao.getAcoestomadas());
			ps.setString(8, ataReuniao.getProximareuniao());
			ps.setString(9, ataReuniao.getAdicionais());
			ps.setString(10, ataReuniao.getAprovacao());
			ps.setLong(11, ataReuniao.getVersao());
			ps.setObject(12, ataReuniao.getProjetoinicio().getCodigo());
			
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
	public List<AtaReuniao> getAtaReuniaos() throws Exception {
		
		List<AtaReuniao> resultado = new ArrayList<AtaReuniao>();// Montar o resultado
		
		Connection con=null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM atareuniao INNER JOIN projetoinicio ON atareuniao.projetoinicio = projetoinicio.codigo ORDER BY atareuniao.ata";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					
					AtaReuniao ataReuniao = new AtaReuniao();
					
					ataReuniao.setAta(rs.getString("ata"));
					ataReuniao.setData(rs.getDate("data"));
					ataReuniao.setLocal(rs.getString("local"));
					ataReuniao.setParticipante(rs.getString("participante"));
					ataReuniao.setObjetivo(rs.getString("objetivo"));
					ataReuniao.setTopico(rs.getString("topico"));				
					ataReuniao.setAcoestomadas(rs.getString("acoestomadas"));
					ataReuniao.setProximareuniao(rs.getString("proximareuniao"));
					ataReuniao.setAcoestomadas(rs.getString("acoestomadas"));
					ataReuniao.setAdicionais(rs.getString("adicionais"));
					ataReuniao.setAprovacao(rs.getString("aprovacao"));
					ataReuniao.setVersao(rs.getLong("versao"));
					ataReuniao.setCodigo(rs.getLong("codigo"));	
					
					ataReuniao.getProjetoinicio().setCodigo(rs.getLong("codigo"));
					
					ataReuniao.getProjetoinicio().setCodigoprojeto(rs.getInt("codigoprojeto"));
					ataReuniao.getProjetoinicio().setProjeto(rs.getString("projeto"));					
					ataReuniao.getProjetoinicio().setData(rs.getDate("data"));
					ataReuniao.getProjetoinicio().setAtribuiprojeto(rs.getString("atribuiprojeto"));
					ataReuniao.getProjetoinicio().setTipoprojeto(rs.getString("tipoprojeto"));
					ataReuniao.getProjetoinicio().setObjetivo(rs.getString("objetivo"));
					ataReuniao.getProjetoinicio().setCliente(rs.getString("cliente"));
					ataReuniao.getProjetoinicio().setPrograma(rs.getString("programa"));
					ataReuniao.getProjetoinicio().setArea(rs.getString("area"));
					ataReuniao.getProjetoinicio().setRoi(rs.getDouble("roi"));
					ataReuniao.getProjetoinicio().setDescricao(rs.getString("descricao"));
					ataReuniao.getProjetoinicio().setCopia(rs.getString("copia"));
									
					resultado.add(ataReuniao);// Add o projeto ao resultado.
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

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
import br.com.tkcsapcd.model.bean.PlanoGerenciamentoQualidade;
import br.com.tkcsapcd.model.util.Conexao;

public class PlanoGerenciamentoTransicaoProdutoDAO implements InterfacePlanoGerenciamentoQualidadeDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public PlanoGerenciamentoTransicaoProdutoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM planogerenciamentoqualidade WHERE codigo = ?;";

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
	private void setPreparedStatement(PlanoGerenciamentoQualidade planoGerenciamentoQualidade, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, planoGerenciamentoQualidade.getPlanogerenciamentoqualidade());
		ps.setString(2, planoGerenciamentoQualidade.getProjeto());
		ps.setString(3, planoGerenciamentoQualidade.getCodigoprojeto());
		ps.setString(4, planoGerenciamentoQualidade.getVersao());
		ps.setString(5, planoGerenciamentoQualidade.getData());
		ps.setString(6, planoGerenciamentoQualidade.getAutor());
		ps.setString(7, planoGerenciamentoQualidade.getNotarevisao());
		ps.setString(8, planoGerenciamentoQualidade.getAprovacao());
		ps.setObject(9, planoGerenciamentoQualidade.getObjetivo());
		ps.setString(10, planoGerenciamentoQualidade.getMetodo());
		ps.setString(11, planoGerenciamentoQualidade.getProcessoqualidade());		
		ps.setString(12, planoGerenciamentoQualidade.getJustificativa());
		ps.setString(13, planoGerenciamentoQualidade.getMetrica());
		ps.setString(14, planoGerenciamentoQualidade.getFerramentaqualidade());	
		ps.setString(15, planoGerenciamentoQualidade.getEntregaprojetoaceitacao());
		ps.setString(16, planoGerenciamentoQualidade.getGarantiaqualidade());
		ps.setString(17, planoGerenciamentoQualidade.getAuditoria());
		ps.setString(18, planoGerenciamentoQualidade.getProcessomelhoria());
		ps.setString(19, planoGerenciamentoQualidade.getResponsabilidadequalidade());
		ps.setString(20, planoGerenciamentoQualidade.getLogauditoria());
		ps.setString(21, planoGerenciamentoQualidade.getControlequalidade());
		ps.setString(22, planoGerenciamentoQualidade.getProcedimentoinspecao());
		ps.setObject(23, planoGerenciamentoQualidade.getProcedimentomonitoramento());
		ps.setInt(24, planoGerenciamentoQualidade.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public PlanoGerenciamentoQualidade getPlanoGerenciamentoQualidade(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM planogerenciamentoqualidade WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<PlanoGerenciamentoQualidade> resultado = getListaPlanoGerenciamentoQualidade(rs);
			
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
		private List<PlanoGerenciamentoQualidade> getListaPlanoGerenciamentoQualidade(ResultSet rs) throws SQLException	{
			List<PlanoGerenciamentoQualidade> resultado = new ArrayList<PlanoGerenciamentoQualidade>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				PlanoGerenciamentoQualidade planoGerenciamentoQualidade = new PlanoGerenciamentoQualidade();
				
				planoGerenciamentoQualidade.setPlanogerenciamentoqualidade(rs.getString("planogerenciamentoqualidade"));
				planoGerenciamentoQualidade.setProjeto(rs.getString("projeto"));
				planoGerenciamentoQualidade.setCodigoprojeto(rs.getString("codigoprojeto"));
				planoGerenciamentoQualidade.setVersao(rs.getString("versao"));
				planoGerenciamentoQualidade.setData(rs.getString("data"));
				planoGerenciamentoQualidade.setAutor(rs.getString("autor"));
				planoGerenciamentoQualidade.setNotarevisao(rs.getString("notarevisao"));
				planoGerenciamentoQualidade.setAprovacao(rs.getString("aprovacao"));
				planoGerenciamentoQualidade.setObjetivo(rs.getString("objetivo"));				
				planoGerenciamentoQualidade.setMetodo(rs.getString("metodo"));					
				planoGerenciamentoQualidade.setProcessoqualidade(rs.getString("processoqualidade"));
				planoGerenciamentoQualidade.setObjetivo(rs.getString("objetivo"));
				planoGerenciamentoQualidade.setJustificativa(rs.getString("justificativa"));
				planoGerenciamentoQualidade.setMetrica(rs.getString("metrica"));
				planoGerenciamentoQualidade.setFerramentaqualidade(rs.getString("ferramentaqualidade"));
				planoGerenciamentoQualidade.setEntregaprojetoaceitacao(rs.getString("entregaprojetoaceitacao"));
				planoGerenciamentoQualidade.setGarantiaqualidade(rs.getString("garantiaqualidade"));
				planoGerenciamentoQualidade.setAuditoria(rs.getString("logauditoria"));					
				planoGerenciamentoQualidade.setProcessomelhoria(rs.getString("processomelhoria"));
				planoGerenciamentoQualidade.setResponsabilidadequalidade(rs.getString("responsabilidadequalidade"));
				planoGerenciamentoQualidade.setLogauditoria(rs.getString("logauditoria"));
				planoGerenciamentoQualidade.setControlequalidade(rs.getString("controlequalidade"));	
				planoGerenciamentoQualidade.setProcedimentoinspecao(rs.getString("procedimentoinspecao"));
				planoGerenciamentoQualidade.setProcedimentomonitoramento(rs.getString("procedimentomonitoramento"));
				planoGerenciamentoQualidade.setCodigo(rs.getInt("codigo"));
												
				resultado.add(planoGerenciamentoQualidade);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(PlanoGerenciamentoQualidade planoGerenciamentoQualidade) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE planogerenciamentoqualidade SET planogerenciamentoqualidade = ?, projeto = ?, codigoprojeto = ?, versao = ?, data = ?, autor = ?, notarevisao = ?, aprovacao = ?, objetivo = ?, metodo = ?, processoqualidade = ?, justificativa = ?, metrica = ?, ferramentaqualidade = ?, entregaprojetoaceitacao = ?, garantiaqualidade = ?, auditoria = ?, processomelhoria = ?, responsabilidadequalidade = ?, logauditoria = ?, controlequalidade = ?, procedimentoinspecao = ?, procedimentomonitoramento = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(planoGerenciamentoQualidade, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(PlanoGerenciamentoQualidade planoGerenciamentoQualidade) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO planogerenciamentoqualidade(planogerenciamentoqualidade, projeto, codigoprojeto, versao, data, autor, notarevisao, aprovacao, objetivo, metodo, processoqualidade, justificativa, metrica, ferramentaqualidade, entregaprojetoaceitacao, garantiaqualidade, auditoria, processomelhoria, responsabilidadequalidade, logauditoria, controlequalidade, procedimentoinspecao, procedimentomonitoramento) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, planoGerenciamentoQualidade.getPlanogerenciamentoqualidade());
			ps.setString(2, planoGerenciamentoQualidade.getProjeto());
			ps.setString(3, planoGerenciamentoQualidade.getCodigoprojeto());
			ps.setString(4, planoGerenciamentoQualidade.getVersao());
			ps.setString(5, planoGerenciamentoQualidade.getData());
			ps.setString(6, planoGerenciamentoQualidade.getAutor());
			ps.setString(7, planoGerenciamentoQualidade.getNotarevisao());
			ps.setString(8, planoGerenciamentoQualidade.getAprovacao());
			ps.setObject(9, planoGerenciamentoQualidade.getObjetivo());
			ps.setString(10, planoGerenciamentoQualidade.getMetodo());
			ps.setString(11, planoGerenciamentoQualidade.getProcessoqualidade());		
			ps.setString(12, planoGerenciamentoQualidade.getJustificativa());
			ps.setString(13, planoGerenciamentoQualidade.getMetrica());
			ps.setString(14, planoGerenciamentoQualidade.getFerramentaqualidade());	
			ps.setString(15, planoGerenciamentoQualidade.getEntregaprojetoaceitacao());
			ps.setString(16, planoGerenciamentoQualidade.getGarantiaqualidade());
			ps.setString(17, planoGerenciamentoQualidade.getAuditoria());
			ps.setString(18, planoGerenciamentoQualidade.getProcessomelhoria());
			ps.setString(19, planoGerenciamentoQualidade.getResponsabilidadequalidade());
			ps.setString(20, planoGerenciamentoQualidade.getLogauditoria());
			ps.setString(21, planoGerenciamentoQualidade.getControlequalidade());
			ps.setString(22, planoGerenciamentoQualidade.getProcedimentoinspecao());
			ps.setObject(23, planoGerenciamentoQualidade.getProcedimentomonitoramento());
			
			
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
	public List<PlanoGerenciamentoQualidade> getPlanoGerenciamentoQualidades() throws Exception {
		
		   List<PlanoGerenciamentoQualidade> resultado = new ArrayList<PlanoGerenciamentoQualidade>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs =null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM planogerenciamentoqualidade";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					PlanoGerenciamentoQualidade planoGerenciamentoQualidade = new PlanoGerenciamentoQualidade();
				
					planoGerenciamentoQualidade.setPlanogerenciamentoqualidade(rs.getString("planogerenciamentoqualidade"));
					planoGerenciamentoQualidade.setProjeto(rs.getString("projeto"));
					planoGerenciamentoQualidade.setCodigoprojeto(rs.getString("codigoprojeto"));
					planoGerenciamentoQualidade.setVersao(rs.getString("versao"));
					planoGerenciamentoQualidade.setData(rs.getString("data"));
					planoGerenciamentoQualidade.setAutor(rs.getString("autor"));
					planoGerenciamentoQualidade.setNotarevisao(rs.getString("notarevisao"));
					planoGerenciamentoQualidade.setAprovacao(rs.getString("aprovacao"));
					planoGerenciamentoQualidade.setObjetivo(rs.getString("objetivo"));				
					planoGerenciamentoQualidade.setMetodo(rs.getString("metodo"));					
					planoGerenciamentoQualidade.setProcessoqualidade(rs.getString("processoqualidade"));
					planoGerenciamentoQualidade.setObjetivo(rs.getString("objetivo"));
					planoGerenciamentoQualidade.setJustificativa(rs.getString("justificativa"));
					planoGerenciamentoQualidade.setMetrica(rs.getString("metrica"));
					planoGerenciamentoQualidade.setFerramentaqualidade(rs.getString("ferramentaqualidade"));
					planoGerenciamentoQualidade.setEntregaprojetoaceitacao(rs.getString("entregaprojetoaceitacao"));
					planoGerenciamentoQualidade.setGarantiaqualidade(rs.getString("garantiaqualidade"));
					planoGerenciamentoQualidade.setAuditoria(rs.getString("logauditoria"));					
					planoGerenciamentoQualidade.setProcessomelhoria(rs.getString("processomelhoria"));
					planoGerenciamentoQualidade.setResponsabilidadequalidade(rs.getString("responsabilidadequalidade"));
					planoGerenciamentoQualidade.setLogauditoria(rs.getString("logauditoria"));
					planoGerenciamentoQualidade.setControlequalidade(rs.getString("controlequalidade"));	
					planoGerenciamentoQualidade.setProcedimentoinspecao(rs.getString("procedimentoinspecao"));
					planoGerenciamentoQualidade.setProcedimentomonitoramento(rs.getString("procedimentomonitoramento"));
					planoGerenciamentoQualidade.setCodigo(rs.getInt("codigo"));
									
					resultado.add(planoGerenciamentoQualidade);// Add o projeto ao resultado.
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

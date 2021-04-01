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
import br.com.tkcsapcd.model.bean.ModeloContrato;
import br.com.tkcsapcd.model.util.Conexao;

public class ModeloContratoDAO implements InterfaceModeloContratoDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public ModeloContratoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM modelocontrato WHERE codigo = ?;";

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
	private void setPreparedStatement(ModeloContrato modeloContrato, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, modeloContrato.getModelocontrato());
		ps.setString(2, modeloContrato.getProjeto());
		ps.setInt(3, modeloContrato.getCodigoprojeto());
		ps.setString(4, modeloContrato.getVersao());
		ps.setDate(5, new java.sql.Date(modeloContrato.getData().getTime() )); //transforma o java util date em java sql date
		ps.setString(6, modeloContrato.getAutor());
		ps.setString(7, modeloContrato.getNotarevisao());
		ps.setString(8, modeloContrato.getAprovacao());
		ps.setObject(9, modeloContrato.getObjetivo());
		ps.setString(10, modeloContrato.getDeclaracao());
		ps.setString(11, modeloContrato.getLinha());		
		ps.setString(12, modeloContrato.getRelatorio());
		ps.setString(13, modeloContrato.getPeriodo());
		ps.setString(14, modeloContrato.getPapeis());	
		ps.setString(15, modeloContrato.getLocal());
		ps.setString(16, modeloContrato.getDefinicao());
		ps.setString(17, modeloContrato.getSuporte());
		ps.setString(18, modeloContrato.getLimitacao());
		ps.setString(19, modeloContrato.getRemuneracao());
		ps.setString(20, modeloContrato.getPenalidade());
		ps.setString(21, modeloContrato.getIncentivo());
		ps.setString(22, modeloContrato.getSeguro());
		ps.setObject(23, modeloContrato.getAprovacaocontratacao());			
		ps.setString(24, modeloContrato.getTratamento());
		ps.setString(25, modeloContrato.getMecanismo());
		ps.setInt(26, modeloContrato.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public ModeloContrato getModeloContrato(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM modelocontrato WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<ModeloContrato> resultado = getListaModeloContrato(rs);
			
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
		private List<ModeloContrato> getListaModeloContrato(ResultSet rs) throws SQLException	{
			List<ModeloContrato> resultado = new ArrayList<ModeloContrato>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				ModeloContrato modeloContrato = new ModeloContrato();
								
				modeloContrato.setModelocontrato(rs.getString("modelocontrato"));
				modeloContrato.setProjeto(rs.getString("projeto"));
				modeloContrato.setCodigoprojeto(rs.getInt("codigoprojeto"));
				modeloContrato.setVersao(rs.getString("versao"));
				modeloContrato.setData(rs.getDate("data"));
				modeloContrato.setAutor(rs.getString("autor"));
				modeloContrato.setNotarevisao(rs.getString("notarevisao"));
				modeloContrato.setAprovacao(rs.getString("aprovacao"));
				modeloContrato.setObjetivo(rs.getString("objetivo"));				
				modeloContrato.setDeclaracao(rs.getString("declaracao"));					
				modeloContrato.setLinha(rs.getString("linha"));
				modeloContrato.setRelatorio(rs.getString("relatorio"));
				modeloContrato.setPeriodo(rs.getString("periodo"));
				modeloContrato.setPapeis(rs.getString("papeis"));
				modeloContrato.setLocal(rs.getString("local"));
				modeloContrato.setDefinicao(rs.getString("definicao"));
				modeloContrato.setSuporte(rs.getString("suporte"));
				modeloContrato.setLimitacao(rs.getString("limitacao"));					
				modeloContrato.setRemuneracao(rs.getString("remuneracao"));
				modeloContrato.setPenalidade(rs.getString("penalidade"));
				modeloContrato.setIncentivo(rs.getString("incentivo"));
				modeloContrato.setSeguro(rs.getString("seguro"));	
				modeloContrato.setAprovacaocontratacao(rs.getString("aprovacaocontratacao"));
				modeloContrato.setTratamento(rs.getString("tratamento"));
				modeloContrato.setMecanismo(rs.getString("mecanismo"));
				modeloContrato.setCodigo(rs.getInt("codigo"));
												
				resultado.add(modeloContrato);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(ModeloContrato modeloContrato) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE modelocontrato SET  modelocontrato = ?,projeto = ?,codigoprojeto = ?,versao = ?,data = ?, autor = ?, notarevisao = ?,aprovacao = ?, objetivo = ?, declaracao = ?, linha = ?, relatorio = ?, periodo = ?, papeis = ?,local = ?, definicao = ?, suporte = ?, limitacao = ?, remuneracao = ?, penalidade = ?, incentivo = ?, seguro = ?, aprovacaocontratacao = ?, tratamento = ?, mecanismo = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(modeloContrato, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(ModeloContrato modeloContrato) throws Exception  {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO modelocontrato( modelocontrato,projeto,codigoprojeto,versao,data, autor, notarevisao,aprovacao, objetivo,declaracao, linha,relatorio, periodo,papeis,local,definicao,suporte, limitacao,remuneracao,penalidade,incentivo,seguro,aprovacaocontratacao,tratamento,mecanismo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);	
							
			ps.setString(1, modeloContrato.getModelocontrato());
			ps.setString(2, modeloContrato.getProjeto());
			ps.setInt(3, modeloContrato.getCodigoprojeto());
			ps.setString(4, modeloContrato.getVersao());
			ps.setDate(5, new java.sql.Date(modeloContrato.getData().getTime() )); //transforma o java util date em java sql date
			ps.setString(6, modeloContrato.getAutor());
			ps.setString(7, modeloContrato.getNotarevisao());
			ps.setString(8, modeloContrato.getAprovacao());
			ps.setObject(9, modeloContrato.getObjetivo());
			ps.setString(10, modeloContrato.getDeclaracao());
			ps.setString(11, modeloContrato.getLinha());		
			ps.setString(12, modeloContrato.getRelatorio());
			ps.setString(13, modeloContrato.getPeriodo());
			ps.setString(14, modeloContrato.getPapeis());	
			ps.setString(15, modeloContrato.getLocal());
			ps.setString(16, modeloContrato.getDefinicao());
			ps.setString(17, modeloContrato.getSuporte());
			ps.setString(18, modeloContrato.getLimitacao());
			ps.setString(19, modeloContrato.getRemuneracao());
			ps.setString(20, modeloContrato.getPenalidade());
			ps.setString(21, modeloContrato.getIncentivo());
			ps.setString(22, modeloContrato.getSeguro());
			ps.setObject(23, modeloContrato.getAprovacaocontratacao());			
			ps.setString(24, modeloContrato.getTratamento());
			ps.setString(25, modeloContrato.getMecanismo());			
			
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
	public List<ModeloContrato> getModeloContratos() throws Exception {
		
		   List<ModeloContrato> resultado = new ArrayList<ModeloContrato>();// Montar o resultado
		   Connection con=null;
		   PreparedStatement ps=null;
		   ResultSet rs = null;
		   
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM modelocontrato";
				
				ps = con.prepareStatement(sqlSelect);
				rs =  ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {

					ModeloContrato modeloContrato = new ModeloContrato();
				
					modeloContrato.setModelocontrato(rs.getString("modelocontrato"));
					modeloContrato.setProjeto(rs.getString("projeto"));
					modeloContrato.setCodigoprojeto(rs.getInt("codigoprojeto"));
					modeloContrato.setVersao(rs.getString("versao"));
					modeloContrato.setData(rs.getDate("data"));
					modeloContrato.setAutor(rs.getString("autor"));
					modeloContrato.setNotarevisao(rs.getString("notarevisao"));
					modeloContrato.setAprovacao(rs.getString("aprovacao"));
					modeloContrato.setObjetivo(rs.getString("objetivo"));				
					modeloContrato.setDeclaracao(rs.getString("declaracao"));					
					modeloContrato.setLinha(rs.getString("linha"));
					modeloContrato.setRelatorio(rs.getString("relatorio"));
					modeloContrato.setPeriodo(rs.getString("periodo"));
					modeloContrato.setPapeis(rs.getString("papeis"));
					modeloContrato.setLocal(rs.getString("local"));
					modeloContrato.setDefinicao(rs.getString("definicao"));
					modeloContrato.setSuporte(rs.getString("suporte"));
					modeloContrato.setLimitacao(rs.getString("limitacao"));					
					modeloContrato.setRemuneracao(rs.getString("remuneracao"));
					modeloContrato.setPenalidade(rs.getString("penalidade"));
					modeloContrato.setIncentivo(rs.getString("incentivo"));
					modeloContrato.setSeguro(rs.getString("seguro"));	
					modeloContrato.setAprovacaocontratacao(rs.getString("aprovacaocontratacao"));
					modeloContrato.setTratamento(rs.getString("tratamento"));
					modeloContrato.setMecanismo(rs.getString("mecanismo"));
					modeloContrato.setCodigo(rs.getInt("codigo"));
									
					resultado.add(modeloContrato);// Add o projeto ao resultado.
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

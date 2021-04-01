/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.conexao.InterfacePool;
import br.com.tkcsapcd.model.bean.TermoAberturaProjeto;
import br.com.tkcsapcd.model.util.Conexao;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class TermoAberturaProjetoDAO implements InterfaceTermoAberturaProjetoDAO{	
	
	private List<TermoAberturaProjeto> termoAberturaProjetos;
	
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	
	//Construtor que recebe o pool como parametro
	public TermoAberturaProjetoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM termoabertura WHERE codigo = ?;";
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

	@Override
	public void salvar(TermoAberturaProjeto termoAberturaProjeto) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			
			//Validar teste de duplicação de registro aqui!
			//SELECT * FROM projeto WHERE codigodoprojeto = 'codigodoprojeto';
					
			String sqlInsert = "INSERT INTO termoabertura( termoaberturaprojeto, versao, data, autor, notarevisao, aprovacao, objetivo, justificativa, smart, eap, requisito, marco, parteinteressada, restricao,permissao, risco, orcamento, concordo, projetoinicio) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sqlInsert);
			
			ps.setString(1, termoAberturaProjeto.getTermoaberturaprojeto());
			ps.setString(2, termoAberturaProjeto.getVersao());
			ps.setDate(3, new java.sql.Date(termoAberturaProjeto.getData().getTime() )); //transforma o java util date em java sql date
			ps.setString(4, termoAberturaProjeto.getAutor());
			ps.setString(5, termoAberturaProjeto.getNotarevisao());
			ps.setString(6, termoAberturaProjeto.getAprovacao());
			ps.setString(7, termoAberturaProjeto.getObjetivo());
			ps.setObject(8, termoAberturaProjeto.getJustificativa());
			ps.setString(9, termoAberturaProjeto.getSmart());
			ps.setString(10, termoAberturaProjeto.getEap());
			ps.setObject(11, termoAberturaProjeto.getRequisito());			
			ps.setObject(12, termoAberturaProjeto.getMarco());
			ps.setObject(13, termoAberturaProjeto.getParteinteressada());
			ps.setObject(14, termoAberturaProjeto.getRestricao());
			ps.setObject(15, termoAberturaProjeto.getPermissao());
			ps.setObject(16, termoAberturaProjeto.getRisco());
			ps.setObject(17, termoAberturaProjeto.getOrcamento());
			ps.setObject(18, termoAberturaProjeto.getConcordo());
			ps.setObject(19, termoAberturaProjeto.getProjetoinicio().getCodigo());
						
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
	public void atualizar(TermoAberturaProjeto termoAberturaProjeto) throws Exception  {
		
			Connection con = Conexao.getConnection();
			PreparedStatement ps=null;						
									
			try{
				String sqlAtualizar = "UPDATE termoabertura SET  termoaberturaprojeto= ?, versao= ?, data= ?, autor= ?, notarevisao= ?, aprovacao= ?, objetivo= ?, justificativa= ?, smart= ?, eap= ?, requisito= ?, marco= ?, parteinteressada= ?, restricao= ?,permissao= ?, risco= ?, orcamento= ?, concordo = ?, projetoinicio = ? WHERE codigo = ?;";
				ps = con.prepareStatement(sqlAtualizar);
				setPreparedStatement(termoAberturaProjeto, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	private void setPreparedStatement(TermoAberturaProjeto termoAberturaProjeto, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, termoAberturaProjeto.getTermoaberturaprojeto());
		ps.setString(2, termoAberturaProjeto.getVersao());
		ps.setDate(3, new java.sql.Date(termoAberturaProjeto.getData().getTime() )); //transforma o java util date em java sql date
		ps.setString(4, termoAberturaProjeto.getAutor());
		ps.setString(5, termoAberturaProjeto.getNotarevisao());
		ps.setString(6, termoAberturaProjeto.getAprovacao());
		ps.setString(7, termoAberturaProjeto.getObjetivo());
		ps.setObject(8, termoAberturaProjeto.getJustificativa());
		ps.setString(9, termoAberturaProjeto.getSmart());
		ps.setString(10, termoAberturaProjeto.getEap());
		ps.setObject(11, termoAberturaProjeto.getRequisito());			
		ps.setObject(12, termoAberturaProjeto.getMarco());
		ps.setObject(13, termoAberturaProjeto.getParteinteressada());
		ps.setObject(14, termoAberturaProjeto.getRestricao());
		ps.setObject(15, termoAberturaProjeto.getPermissao());
		ps.setObject(16, termoAberturaProjeto.getRisco());
		ps.setObject(17, termoAberturaProjeto.getOrcamento());
		ps.setObject(18, termoAberturaProjeto.getConcordo());
		ps.setObject(19, termoAberturaProjeto.getProjetoinicio().getCodigo());		
		ps.setLong(20, termoAberturaProjeto.getCodigo());//Atenção: necessário para isolar o metodo (extração). // Alterado dia 28/05/2014		
	}

	@Override
	public TermoAberturaProjeto getTermoAberturaProjeto(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM termoabertura WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<TermoAberturaProjeto> resultado = getListaTermoAberturaProjeto(rs);
			
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

		@Override
		public 	List<TermoAberturaProjeto> getTermoAberturaProjetos() throws Exception {		
				
				List<TermoAberturaProjeto> resultado = new ArrayList<TermoAberturaProjeto>();// Montar o resultado
				
				Connection con=null;
				PreparedStatement ps=null;
				ResultSet rs = null;
				
				try {
					con = Conexao.getConnection();
					
					/*
					 * SELECIONAR todas as colunas [da tabela termoabertura] da TABELA termoabertura UNINDO A TABELA projetoinicio 
					 * ONDE a coluna projetoinicio [da tabela termoabertura] É IGUAL a coluna id [da tabela projetoinicio] 
					 * ORDENADO PELO nome [da tabela termoabertura] ASCENDETEMENTE
					 * */
					
					String sqlSelect = "SELECT * FROM termoabertura INNER JOIN projetoinicio ON termoabertura.projetoinicio = projetoinicio.codigo ORDER BY termoabertura.autor";
						
						ps = con.prepareStatement(sqlSelect);
						rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
						
						//resultado = getListaProjeto(rs);					
						// Laço p/ preencher
						while (rs.next()) {							
							
							TermoAberturaProjeto termoAberturaProjeto = new TermoAberturaProjeto();
													
							termoAberturaProjeto.setTermoaberturaprojeto(rs.getString("termoaberturaprojeto"));
							termoAberturaProjeto.setVersao(rs.getString("versao"));
							termoAberturaProjeto.setData(rs.getDate("data"));
							termoAberturaProjeto.setAutor(rs.getString("autor"));
							termoAberturaProjeto.setNotarevisao(rs.getString("notarevisao"));							
							termoAberturaProjeto.setAprovacao(rs.getString("aprovacao"));
							termoAberturaProjeto.setObjetivo(rs.getString("objetivo"));
							termoAberturaProjeto.setJustificativa(rs.getString("justificativa"));
							termoAberturaProjeto.setSmart(rs.getString("smart"));
							termoAberturaProjeto.setEap(rs.getString("eap"));							
							termoAberturaProjeto.setRequisito(rs.getString("requisito"));
							termoAberturaProjeto.setMarco(rs.getString("marco"));
							termoAberturaProjeto.setParteinteressada(rs.getString("parteinteressada"));
							termoAberturaProjeto.setRestricao(rs.getString("restricao"));
							termoAberturaProjeto.setPermissao(rs.getString("permissao"));
							termoAberturaProjeto.setRisco(rs.getString("risco"));
							termoAberturaProjeto.setOrcamento(rs.getString("orcamento"));
							termoAberturaProjeto.setConcordo(rs.getString("concordo"));
							termoAberturaProjeto.setCodigo(rs.getLong("codigo"));
							
							termoAberturaProjeto.getProjetoinicio().setCodigo(rs.getLong("codigo"));
							
							termoAberturaProjeto.getProjetoinicio().setCodigoprojeto(rs.getInt("codigoprojeto"));
							termoAberturaProjeto.getProjetoinicio().setProjeto(rs.getString("projeto"));					
							termoAberturaProjeto.getProjetoinicio().setData(rs.getDate("data"));
							termoAberturaProjeto.getProjetoinicio().setAtribuiprojeto(rs.getString("atribuiprojeto"));
							termoAberturaProjeto.getProjetoinicio().setTipoprojeto(rs.getString("tipoprojeto"));
							termoAberturaProjeto.getProjetoinicio().setObjetivo(rs.getString("objetivo"));
							termoAberturaProjeto.getProjetoinicio().setCliente(rs.getString("cliente"));
							termoAberturaProjeto.getProjetoinicio().setPrograma(rs.getString("programa"));
							termoAberturaProjeto.getProjetoinicio().setArea(rs.getString("area"));
							termoAberturaProjeto.getProjetoinicio().setRoi(rs.getDouble("roi"));
							termoAberturaProjeto.getProjetoinicio().setDescricao(rs.getString("descricao"));
							termoAberturaProjeto.getProjetoinicio().setCopia(rs.getString("copia"));
																		
							resultado.add(termoAberturaProjeto);// Add o projeto ao resultado.
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
	/*---------------------------------------------------------------------------------------------------------------------------------------*/

		//Metodo p confirma objetivo. Resulmir linhas de códigos, que pode ser usados em outros métodos. (ex: resultado = getListaCliente(rs); ou List<Cliente> resultado = getListaCliente(rs);)
		private List<TermoAberturaProjeto> getListaTermoAberturaProjeto(ResultSet rs) throws SQLException	{
				List<TermoAberturaProjeto> resultado = new ArrayList<TermoAberturaProjeto>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				TermoAberturaProjeto termoAberturaProjeto = new TermoAberturaProjeto();
				
				termoAberturaProjeto.setTermoaberturaprojeto(rs.getString("termoaberturaprojeto"));
				termoAberturaProjeto.setVersao(rs.getString("versao"));
				termoAberturaProjeto.setData(rs.getDate("data"));
				termoAberturaProjeto.setAutor(rs.getString("autor"));
				termoAberturaProjeto.setNotarevisao(rs.getString("notarevisao"));							
				termoAberturaProjeto.setAprovacao(rs.getString("aprovacao"));
				termoAberturaProjeto.setObjetivo(rs.getString("objetivo"));
				termoAberturaProjeto.setJustificativa(rs.getString("justificativa"));
				termoAberturaProjeto.setSmart(rs.getString("smart"));
				termoAberturaProjeto.setEap(rs.getString("eap"));							
				termoAberturaProjeto.setRequisito(rs.getString("requisito"));
				termoAberturaProjeto.setMarco(rs.getString("marco"));
				termoAberturaProjeto.setParteinteressada(rs.getString("parteinteressada"));
				termoAberturaProjeto.setRestricao(rs.getString("restricao"));
				termoAberturaProjeto.setPermissao(rs.getString("permissao"));
				termoAberturaProjeto.setRisco(rs.getString("risco"));
				termoAberturaProjeto.setOrcamento(rs.getString("orcamento"));
				termoAberturaProjeto.setConcordo(rs.getString("concordo"));
				termoAberturaProjeto.setCodigo(rs.getLong("codigo"));
								
				resultado.add(termoAberturaProjeto);// Add o projeto ao resultado.
			}		
			
			return resultado;
		}
	
		//---------------------------------------------------------------------------------------------------------------------------------------------

		@Override		
		//Método para listar o nome projeto na tela do cadastro 	
		public 	List<TermoAberturaProjeto> getTermoAberturaPProjetos() throws Exception  {			
				List<TermoAberturaProjeto> resultado = new ArrayList<TermoAberturaProjeto>();
			
				Connection con=null;
				PreparedStatement ps=null;
				ResultSet rs = null;
			
			try {
				con = Conexao.getConnection();		
							
				String sqlSelect = "SELECT * FROM termoabertura;";
					
					ps = con.prepareStatement(sqlSelect);
					rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
					
					//resultado = getListaDepartamentos(rs);	
					// Laço p/ preencher, enquanto o rs tiver registro, vai retornar verdadeiro e moverá o curso para o próximo(Laço p/ preencher).
					while (rs.next()) {
									
						TermoAberturaProjeto termoAberturaProjeto = new TermoAberturaProjeto();
													
						//termoAberturaProjeto.setProjeto(rs.getString("projeto"));//removido devido a chave estrangeira
						termoAberturaProjeto.setCodigo(rs.getLong("codigo"));
													
						// Add o cliente ao resultado
						resultado.add(termoAberturaProjeto);
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
		
		//---------------------------------------------------------------------------------------------------------------------------------------------
		public void verPDF(ActionEvent actionEvent) throws Exception{
			
			TermoAberturaProjetoDAO termoAberturaProjetoDAO = new TermoAberturaProjetoDAO(pool);
			termoAberturaProjetos = termoAberturaProjetoDAO.getTermoAberturaProjetos();
			
			File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reports/termoabertura.jasper"));		
			
			byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), null, new JRBeanCollectionDataSource(this.termoAberturaProjetos));
			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream outStream = response.getOutputStream();
			outStream.write(bytes, 0 , bytes.length);
			outStream.flush();
			outStream.close();
				
			FacesContext.getCurrentInstance().responseComplete();
		}

		@Override
		public void relatorio() throws Exception {
			
			TermoAberturaProjetoDAO termoAberturaProjetoDAO = new TermoAberturaProjetoDAO(pool);
			termoAberturaProjetos = termoAberturaProjetoDAO.getTermoAberturaProjetos();
			
		}
		
}

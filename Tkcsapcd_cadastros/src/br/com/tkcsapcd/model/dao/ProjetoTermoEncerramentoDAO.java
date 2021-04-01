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
import br.com.tkcsapcd.model.bean.ProjetoTermoEncerramento;
import br.com.tkcsapcd.model.util.Conexao;

public class ProjetoTermoEncerramentoDAO implements InterfaceProjetoTermoEncerramentoDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	
	//Construtor que recebe o pool como parametro
	public ProjetoTermoEncerramentoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM projetotermoencerramento WHERE codigo = ?;";
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
	public void salvar(ProjetoTermoEncerramento projetoTermoEncerramento) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			
			String sqlInsert = "INSERT INTO projetotermoencerramento(nomeprojeto, datadocumento, coordenador, tipoprojeto, gestor, programa, statusconclusao, dataanaliseresultado, objetivoprojeto, justificativaprojeto, orcamentoprevisto, valorempenhado, valorpago, saldo, resultadoprevisto, peso, progresso, detalhamento, analiseefetividade, documentacaofisica, documentacaoeletronica, concideracaocoordenador, concideracaogestor, termo, codigoprojeto) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sqlInsert);
			
			ps.setString(1, projetoTermoEncerramento.getNomeprojeto());
			ps.setString(2, projetoTermoEncerramento.getDatadocumento());
			ps.setString(3, projetoTermoEncerramento.getCoordenador());
			ps.setString(4, projetoTermoEncerramento.getTipoprojeto());
			ps.setString(5, projetoTermoEncerramento.getGestor());
			ps.setString(6, projetoTermoEncerramento.getPrograma());
			ps.setString(7, projetoTermoEncerramento.getStatusconclusao());
			ps.setString(8, projetoTermoEncerramento.getDataanaliseresultado());
			ps.setString(9, projetoTermoEncerramento.getObjetivoprojeto());
			ps.setObject(10, projetoTermoEncerramento.getJustificativaprojeto());
			ps.setString(11, projetoTermoEncerramento.getOrcamentoprevisto());
			ps.setString(12, projetoTermoEncerramento.getValorempenhado());
			ps.setObject(13, projetoTermoEncerramento.getValorpago());			
			ps.setString(14, projetoTermoEncerramento.getSaldo());
			ps.setString(15, projetoTermoEncerramento.getResultadoprevisto());
			ps.setString(16, projetoTermoEncerramento.getPeso());
			ps.setString(17, projetoTermoEncerramento.getProgresso());
			ps.setString(18, projetoTermoEncerramento.getDetalhamento());
			ps.setString(19, projetoTermoEncerramento.getAnaliseefetividade());
			ps.setString(20, projetoTermoEncerramento.getDocumentacaofisica());
			ps.setObject(21, projetoTermoEncerramento.getDocumentacaoeletronica());
			ps.setString(22, projetoTermoEncerramento.getConcideracaocoordenador());
			ps.setString(23, projetoTermoEncerramento.getConcideracaogestor());
			ps.setObject(24, projetoTermoEncerramento.getTermo());
			ps.setObject(25, projetoTermoEncerramento.getCodigoprojeto());
			
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
	public void atualizar(ProjetoTermoEncerramento projetoTermoEncerramento) throws Exception  {
		
			Connection con = Conexao.getConnection();
			PreparedStatement ps=null;						
									
			try{
				String sqlAtualizar = "UPDATE projetotermoencerramento SET nomeprojeto = ?, datadocumento= ?, coordenador= ?, tipoprojeto= ?, gestor= ?, programa= ?, statusconclusao= ?, dataanaliseresultado= ?, objetivoprojeto= ?, justificativaprojeto= ?, orcamentoprevisto= ?, valorempenhado= ?, valorpago= ?, saldo= ?, resultadoprevisto= ?, peso= ?, progresso= ?, detalhamento= ?, analiseefetividade= ?, documentacaofisica= ?, documentacaoeletronica= ?, concideracaocoordenador= ?, concideracaogestor= ?, termo= ?, codigoprojeto = ? WHERE codigo = ?;";
				ps = con.prepareStatement(sqlAtualizar);
				setPreparedStatement(projetoTermoEncerramento, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	private void setPreparedStatement(ProjetoTermoEncerramento projetoTermoEncerramento, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, projetoTermoEncerramento.getNomeprojeto());
		ps.setString(2, projetoTermoEncerramento.getDatadocumento());
		ps.setString(3, projetoTermoEncerramento.getCoordenador());
		ps.setString(4, projetoTermoEncerramento.getTipoprojeto());
		ps.setString(5, projetoTermoEncerramento.getGestor());
		ps.setString(6, projetoTermoEncerramento.getPrograma());
		ps.setString(7, projetoTermoEncerramento.getStatusconclusao());
		ps.setString(8, projetoTermoEncerramento.getDataanaliseresultado());
		ps.setString(9, projetoTermoEncerramento.getObjetivoprojeto());
		ps.setObject(10, projetoTermoEncerramento.getJustificativaprojeto());
		ps.setString(11, projetoTermoEncerramento.getOrcamentoprevisto());
		ps.setString(12, projetoTermoEncerramento.getValorempenhado());
		ps.setObject(13, projetoTermoEncerramento.getValorpago());			
		ps.setString(14, projetoTermoEncerramento.getSaldo());
		ps.setString(15, projetoTermoEncerramento.getResultadoprevisto());
		ps.setString(16, projetoTermoEncerramento.getPeso());
		ps.setString(17, projetoTermoEncerramento.getProgresso());
		ps.setString(18, projetoTermoEncerramento.getDetalhamento());
		ps.setString(19, projetoTermoEncerramento.getAnaliseefetividade());
		ps.setString(20, projetoTermoEncerramento.getDocumentacaofisica());
		ps.setObject(21, projetoTermoEncerramento.getDocumentacaoeletronica());
		ps.setString(22, projetoTermoEncerramento.getConcideracaocoordenador());
		ps.setString(23, projetoTermoEncerramento.getConcideracaogestor());
		ps.setObject(24, projetoTermoEncerramento.getTermo());
		ps.setObject(25, projetoTermoEncerramento.getCodigoprojeto());
		ps.setInt(26, projetoTermoEncerramento.getCodigo());//Atenção: necessário para isolar o metodo (extração). // Alterado dia 28/05/2014		
	}

	@Override
	public ProjetoTermoEncerramento getProjetoTermoEncerramento(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM projetotermoencerramento WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<ProjetoTermoEncerramento> resultado = getListaProjetoTermoEncerramento(rs);
			
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
	public List<ProjetoTermoEncerramento> getProjetoTermoEncerramentos() throws Exception 
	{				
				List<ProjetoTermoEncerramento> resultado = new ArrayList<ProjetoTermoEncerramento>();// Montar o resultado
				Connection con=null;
				PreparedStatement ps=null;
				ResultSet rs = null;
				try {
					con = Conexao.getConnection();
					
					String sqlSelect = "SELECT * FROM projetotermoencerramento";
						
						ps = con.prepareStatement(sqlSelect);
						rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
						
						//resultado = getListaProjeto(rs);					
						// Laço p/ preencher
						while (rs.next()) {
							
							ProjetoTermoEncerramento projetoTermoEncerramento = new ProjetoTermoEncerramento();
							
							projetoTermoEncerramento.setNomeprojeto(rs.getString("nomeprojeto"));
							projetoTermoEncerramento.setDatadocumento(rs.getString("datadocumento"));
							projetoTermoEncerramento.setCoordenador(rs.getString("coordenador"));
							projetoTermoEncerramento.setTipoprojeto(rs.getString("tipoprojeto"));
							projetoTermoEncerramento.setGestor(rs.getString("gestor"));
							projetoTermoEncerramento.setPrograma(rs.getString("programa"));
							projetoTermoEncerramento.setStatusconclusao(rs.getString("statusconclusao"));
							projetoTermoEncerramento.setDataanaliseresultado(rs.getString("dataanaliseresultado"));
							projetoTermoEncerramento.setObjetivoprojeto(rs.getString("objetivoprojeto"));
							projetoTermoEncerramento.setJustificativaprojeto(rs.getString("justificativaprojeto"));
							projetoTermoEncerramento.setOrcamentoprevisto(rs.getString("orcamentoprevisto"));
							projetoTermoEncerramento.setValorempenhado(rs.getString("valorempenhado"));
							projetoTermoEncerramento.setValorpago(rs.getString("valorpago"));
							projetoTermoEncerramento.setSaldo(rs.getString("saldo"));
							projetoTermoEncerramento.setResultadoprevisto(rs.getString("resultadoprevisto"));
							projetoTermoEncerramento.setPeso(rs.getString("peso"));
							projetoTermoEncerramento.setProgresso(rs.getString("progresso"));
							projetoTermoEncerramento.setDetalhamento(rs.getString("detalhamento"));
							projetoTermoEncerramento.setAnaliseefetividade(rs.getString("analiseefetividade"));
							projetoTermoEncerramento.setDocumentacaofisica(rs.getString("documentacaofisica"));
							projetoTermoEncerramento.setDocumentacaoeletronica(rs.getString("documentacaoeletronica"));
							projetoTermoEncerramento.setConcideracaocoordenador(rs.getString("concideracaocoordenador"));
							projetoTermoEncerramento.setConcideracaogestor(rs.getString("concideracaogestor"));
							projetoTermoEncerramento.setTermo(rs.getString("termo"));
							projetoTermoEncerramento.setCodigoprojeto(rs.getString("codigoprojeto"));
							projetoTermoEncerramento.setCodigo(rs.getInt("codigo"));
											
							resultado.add(projetoTermoEncerramento);// Add o projeto ao resultado.
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
		private List<ProjetoTermoEncerramento> getListaProjetoTermoEncerramento(ResultSet rs) throws SQLException	{
			
				List<ProjetoTermoEncerramento> resultado = new ArrayList<ProjetoTermoEncerramento>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				ProjetoTermoEncerramento projetoTermoEncerramento = new ProjetoTermoEncerramento();
				
				projetoTermoEncerramento.setNomeprojeto(rs.getString("nomeprojeto"));
				projetoTermoEncerramento.setDatadocumento(rs.getString("datadocumento"));
				projetoTermoEncerramento.setCoordenador(rs.getString("coordenador"));
				projetoTermoEncerramento.setTipoprojeto(rs.getString("tipoprojeto"));
				projetoTermoEncerramento.setGestor(rs.getString("gestor"));
				projetoTermoEncerramento.setPrograma(rs.getString("programa"));
				projetoTermoEncerramento.setStatusconclusao(rs.getString("statusconclusao"));
				projetoTermoEncerramento.setDataanaliseresultado(rs.getString("dataanaliseresultado"));
				projetoTermoEncerramento.setObjetivoprojeto(rs.getString("objetivoprojeto"));
				projetoTermoEncerramento.setJustificativaprojeto(rs.getString("justificativaprojeto"));
				projetoTermoEncerramento.setOrcamentoprevisto(rs.getString("orcamentoprevisto"));
				projetoTermoEncerramento.setValorempenhado(rs.getString("valorempenhado"));
				projetoTermoEncerramento.setValorpago(rs.getString("valorpago"));
				projetoTermoEncerramento.setSaldo(rs.getString("saldo"));
				projetoTermoEncerramento.setResultadoprevisto(rs.getString("resultadoprevisto"));
				projetoTermoEncerramento.setPeso(rs.getString("peso"));
				projetoTermoEncerramento.setProgresso(rs.getString("progresso"));
				projetoTermoEncerramento.setDetalhamento(rs.getString("detalhamento"));
				projetoTermoEncerramento.setAnaliseefetividade(rs.getString("analiseefetividade"));
				projetoTermoEncerramento.setDocumentacaofisica(rs.getString("documentacaofisica"));
				projetoTermoEncerramento.setDocumentacaoeletronica(rs.getString("documentacaoeletronica"));
				projetoTermoEncerramento.setConcideracaocoordenador(rs.getString("concideracaocoordenador"));
				projetoTermoEncerramento.setConcideracaogestor(rs.getString("concideracaogestor"));
				projetoTermoEncerramento.setTermo(rs.getString("termo"));
				projetoTermoEncerramento.setCodigoprojeto(rs.getString("codigoprojeto"));
				projetoTermoEncerramento.setCodigo(rs.getInt("codigo"));
								
				resultado.add(projetoTermoEncerramento);// Add o projeto ao resultado.
			}			
			return resultado;
		}
				
		//---------------------------------------------------------------------------------------------------------------------------------------------

		/*@Override
		
		//Método para listar o nome projeto na tela do cadastro de alocação
		
		public List<ProjetoTermoEncerramento> getPProjetoTermoEncerramentos() throws SQLException {
			// 
			List<ProjetoTermoEncerramento> resultado = new ArrayList<ProjetoTermoEncerramento>();
			Connection con=null;
			
			try {
				con = Conexao.getConnection();		
				PreparedStatement ps;			
				String sqlSelect = "SELECT * FROM projetotermoencerramento;";
					
					ps = con.prepareStatement(sqlSelect);
					ResultSet rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
					
					//resultado = getListaDepartamentos(rs);	
					// Laço p/ preencher, enquanto o rs tiver registro, vai retornar verdadeiro e moverá o curso para o próximo(Laço p/ preencher).
					while (rs.next()) {
									
						ProjetoTermoEncerramento projetoTermoEncerramento = new ProjetoTermoEncerramento();
													
						projetoTermoEncerramento.setNomeprojeto(rs.getString("nomeprojeto"));
						projetoTermoEncerramento.setCodigo(rs.getInt("codigo"));
													
						// Add o cliente ao resultado
						resultado.add(projetoTermoEncerramento);
					}
						rs.close();
						ps.close();
			} finally {
				con.close();// liberar a conexão
			}	
					
			return resultado;
		}*/
		/*
				//Metodo p confirma, objetivo resulmir linhas de códigos, que pode ser usados em outros métodos. (ex: resultado = getListaCliente(rs); ou List<Cliente> resultado = getListaCliente(rs);)
				private List<ProjetoTermoEncerramento> getListaProjetoEncerramentos(ResultSet rs) throws SQLException 
				{
					List<ProjetoTermoEncerramento> resultado = new ArrayList<ProjetoTermoEncerramento>();
					
					// Laço p/ preencher, enquanto o rs tiver registro, vai retornar verdadeiro e moverá o curso para o próximo(Laço p/ preencher).
					while (rs.next()) {
						
						ProjetoTermoEncerramento projetoTermoEncerramento = new ProjetoTermoEncerramento();
						
						projetoTermoEncerramento.setNomeprojeto(rs.getString("nomeprojeto"));
						projetoTermoEncerramento.setCodigo(rs.getInt("codigo"));
										
						// Add o cliente ao resultado
						resultado.add(projetoTermoEncerramento);
					}			
					return resultado;
				}	*/			
}

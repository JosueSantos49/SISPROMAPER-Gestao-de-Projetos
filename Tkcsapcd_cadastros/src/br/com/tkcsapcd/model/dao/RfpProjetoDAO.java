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
import br.com.tkcsapcd.model.bean.RfpProjeto;
import br.com.tkcsapcd.model.util.Conexao;
	
	public class RfpProjetoDAO implements InterfaceRfpProjetoDAO {
		
		@SuppressWarnings("unused")
		private InterfacePool pool;
		public RfpProjetoDAO(InterfacePool pool) {
			super();
			this.pool = pool;
		}
/*---------------------------------------------------------------------------------------------------------------------------------------*/

		@Override
		public void excluir(Integer codigo) throws Exception {
			Connection con = Conexao.getConnection();
			PreparedStatement ps = null;
					
			try{
	
				String SqlExcluir = "DELETE FROM rfpprojeto WHERE codigo = ?;";			
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
/*---------------------------------------------------------------------------------------------------------------------------------------*/

		@Override
		public void salvar(RfpProjeto rfpProjeto) throws Exception {
			Connection con = Conexao.getConnection();		
			PreparedStatement ps=null;
			try {
				
				String sqlInsert = "INSERT INTO rfpprojeto (nomeRfpProjeto, codigoProjeto, itensProjeto, nomeempresa, historicoempresa, produtoempresa, mercadoempresa, valoresempresa, endereco, cidade, estado, numero, bairro, cep, telefone, representante, emailrepresentante, aquisicao, escopo, restricao, recurso, avaliacao, cronograma, proposta, condicaoproposta, observacao, data, codigo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
								
				ps = con.prepareStatement(sqlInsert);
				setPreparedStatement(rfpProjeto, ps);				
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
/*---------------------------------------------------------------------------------------------------------------------------------------*/
		
		private void setPreparedStatement(RfpProjeto rfpProjeto, PreparedStatement ps) throws SQLException{
				
				ps.setString(1, rfpProjeto.getNomeRfpProjeto());				
				ps.setString(2, rfpProjeto.getCodigoProjeto());
				ps.setString(3, rfpProjeto.getItensProjeto());					
				ps.setString(4, rfpProjeto.getNomeempresa());					
				ps.setString(5, rfpProjeto.getHistoricoempresa());
				ps.setString(6, rfpProjeto.getProdutoempresa());	
				ps.setString(7, rfpProjeto.getMercadoempresa());				
				ps.setString(8, rfpProjeto.getValoresempresa());				
				ps.setString(9, rfpProjeto.getEndereco());					
				ps.setString(10, rfpProjeto.getCidade());				
				ps.setString(11, rfpProjeto.getEstado());				
				ps.setString(12, rfpProjeto.getNumero());				
				ps.setString(13, rfpProjeto.getBairro());				
				ps.setString(14, rfpProjeto.getCep());				
				ps.setString(15, rfpProjeto.getTelefone());				
				ps.setString(16, rfpProjeto.getRepresentante());					
				ps.setString(17, rfpProjeto.getEmailrepresentante());
				ps.setString(18, rfpProjeto.getAquisicao());	
				ps.setString(19, rfpProjeto.getEscopo());				
				ps.setString(20, rfpProjeto.getRestricao());	
				ps.setString(21, rfpProjeto.getRecurso());				
				ps.setString(22, rfpProjeto.getAvaliacao());				
				ps.setString(23, rfpProjeto.getCronograma());
				ps.setString(24, rfpProjeto.getProposta());
				ps.setString(25, rfpProjeto.getCondicaoproposta());
				ps.setString(26, rfpProjeto.getObservacao());
				ps.setString(27, rfpProjeto.getData());	
				ps.setObject(28, rfpProjeto.getCodigo());//Atenção: necessário para isolar o metodo (extração).
			}
/*---------------------------------------------------------------------------------------------------------------------------------------*/

		@Override
		public void atualizar(RfpProjeto rfpProjeto) throws Exception {
			
			Connection con = Conexao.getConnection();
			PreparedStatement ps=null;
		
		try {		
			String sqlAtualizar = "UPDATE rfpprojeto SET nomeRfpProjeto = ?," +
														" codigoProjeto = ?," +
														" itensProjeto = ?," +														
														" nomeempresa = ?," +
														" historicoempresa = ?," +
														" produtoempresa = ?," +
														" mercadoempresa = ?," +
														" valoresempresa = ?," +
														" endereco = ?," +
														" cidade = ?," +
														" estado = ?," +
														" numero = ?," +
														" bairro = ?," +
														" cep = ?," +
														" telefone = ?," +
														" representante = ?," +
														" emailrepresentante = ?," +
														" aquisicao = ?," +
														" escopo = ?," +
														" restricao = ?," +
														" recurso = ?," +
														" avaliacao = ?," +
														" cronograma = ?," +
														" proposta = ?," +
														" condicaoproposta = ?," +
														" observacao = ?," +
														" data = ? WHERE codigo = ?;";
			
			ps = con.prepareStatement(sqlAtualizar);			
			setPreparedStatement(rfpProjeto, ps);//Código isolado do metodo sqlInsert permite usar a mesma linha, facilitando!			
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

/*---------------------------------------------------------------------------------------------------------------------------------------*/

	@Override
	public RfpProjeto getRfpProjeto(Integer codigo) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
					
		try {
			
			String sqlSelect = "SELECT * FROM rfpprojeto WHERE codigo = ?;";				
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando				
			rs = ps.executeQuery();
				
			List<RfpProjeto> resultado = getListaRfpProjeto(rs);
			
			if (resultado.size() > 0)			
				return resultado.get(0);//pegando elemento por chave (unico cliente!).			
			
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
		public RfpProjeto getRfpProjeto(String login) {
			// TODO Auto-generated method stub
			return null;
		}
	
		@Override
		public List<RfpProjeto> getRfpProjeto() throws Exception {
			
			List<RfpProjeto> resultado = new ArrayList<RfpProjeto>();// Montar o resultado
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs =null;
			try {
				con = Conexao.getConnection();				
				
				String sqlSelect = "SELECT * FROM rfpprojeto;";
					
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.														
					
					//resultado = getListaFuncionario(rs);	
					while(rs.next()){
						
						RfpProjeto rfpProjeto = new RfpProjeto();	
						
						rfpProjeto.setNomeRfpProjeto(rs.getString("nomeRfpProjeto"));
						rfpProjeto.setCodigoProjeto(rs.getString("codigoProjeto"));
						rfpProjeto.setItensProjeto(rs.getString("itensProjeto"));						
						rfpProjeto.setNomeempresa(rs.getString("nomeempresa"));
						rfpProjeto.setHistoricoempresa(rs.getString("historicoempresa"));
						rfpProjeto.setProdutoempresa(rs.getString("produtoempresa"));
						rfpProjeto.setMercadoempresa(rs.getString("mercadoempresa"));
						rfpProjeto.setValoresempresa(rs.getString("valoresempresa"));
						rfpProjeto.setEndereco(rs.getString("endereco"));
						rfpProjeto.setCidade(rs.getString("cidade"));
						rfpProjeto.setEstado(rs.getString("estado"));
						rfpProjeto.setNumero(rs.getString("numero"));
						rfpProjeto.setBairro(rs.getString("bairro"));
						rfpProjeto.setCep(rs.getString("cep"));
						rfpProjeto.setTelefone(rs.getString("telefone"));
						rfpProjeto.setRepresentante(rs.getString("representante"));
						rfpProjeto.setEmailrepresentante(rs.getString("emailrepresentante"));
						rfpProjeto.setAquisicao(rs.getString("aquisicao"));
						rfpProjeto.setEscopo(rs.getString("escopo"));
						rfpProjeto.setRestricao(rs.getString("restricao"));
						rfpProjeto.setRecurso(rs.getString("recurso"));
						rfpProjeto.setAvaliacao(rs.getString("avaliacao"));
						rfpProjeto.setCronograma(rs.getString("cronograma"));
						rfpProjeto.setProposta(rs.getString("proposta"));
						rfpProjeto.setCondicaoproposta(rs.getString("condicaoproposta"));	
						rfpProjeto.setObservacao(rs.getString("observacao"));
						rfpProjeto.setData(rs.getString("data"));
						rfpProjeto.setCodigo(rs.getInt("codigo"));			
						
						resultado.add(rfpProjeto);// Add o cliente ao resultado
					}		
					ps.close();
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
	
	private List<RfpProjeto> getListaRfpProjeto(ResultSet rs) throws SQLException{
			
			List<RfpProjeto> resultado = new ArrayList<RfpProjeto>();
			
			while(rs.next()){
				
				RfpProjeto rfpProjeto = new RfpProjeto();	
				
				rfpProjeto.setNomeRfpProjeto(rs.getString("nomeRfpProjeto"));
				rfpProjeto.setCodigoProjeto(rs.getString("codigoProjeto"));
				rfpProjeto.setItensProjeto(rs.getString("itensProjeto"));
				rfpProjeto.setNomeempresa(rs.getString("nomeempresa"));
				rfpProjeto.setHistoricoempresa(rs.getString("historicoempresa"));
				rfpProjeto.setProdutoempresa(rs.getString("produtoempresa"));
				rfpProjeto.setMercadoempresa(rs.getString("mercadoempresa"));
				rfpProjeto.setValoresempresa(rs.getString("valoresempresa"));
				rfpProjeto.setEndereco(rs.getString("endereco"));
				rfpProjeto.setCidade(rs.getString("cidade"));
				rfpProjeto.setEstado(rs.getString("estado"));
				rfpProjeto.setNumero(rs.getString("numero"));
				rfpProjeto.setBairro(rs.getString("bairro"));
				rfpProjeto.setCep(rs.getString("cep"));
				rfpProjeto.setTelefone(rs.getString("telefone"));
				rfpProjeto.setRepresentante(rs.getString("representante"));
				rfpProjeto.setEmailrepresentante(rs.getString("emailrepresentante"));
				rfpProjeto.setAquisicao(rs.getString("aquisicao"));
				rfpProjeto.setEscopo(rs.getString("escopo"));
				rfpProjeto.setRestricao(rs.getString("restricao"));
				rfpProjeto.setRecurso(rs.getString("recurso"));
				rfpProjeto.setAvaliacao(rs.getString("avaliacao"));
				rfpProjeto.setCronograma(rs.getString("cronograma"));
				rfpProjeto.setProposta(rs.getString("proposta"));
				rfpProjeto.setCondicaoproposta(rs.getString("condicaoproposta"));
				rfpProjeto.setObservacao(rs.getString("observacao"));
				rfpProjeto.setData(rs.getString("data"));
				rfpProjeto.setCodigo(rs.getInt("codigo"));			
				
				resultado.add(rfpProjeto);// Add o cliente ao resultado
			}		
			return resultado;		
		}
	
	
	}

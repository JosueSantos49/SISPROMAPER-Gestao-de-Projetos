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
import br.com.tkcsapcd.model.bean.SolicitacaoServicoTI;
import br.com.tkcsapcd.model.util.Conexao;

public class SolicitacaoServicoTIDAO implements	InterfaceSolicitacaoServicoTIDAO {

	@SuppressWarnings("unused")
	private InterfacePool pool;
	public SolicitacaoServicoTIDAO(InterfacePool pool){
		super();
		this.pool=pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM solicitacaoservicoti WHERE codigo = ?;";

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
	public void atualizar(SolicitacaoServicoTI solicitacaoServicoTI) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
								
		try{
			String sqlAtualizar = "UPDATE solicitacaoservicoti SET codigoprojeto = ?, codigosolicitaoservico = ?, area = ?, responsaveldemanda = ?, telefonecontato = ?, email = ?, id = ?, datasolicitacao = ?, nomedemanda = ?, objetivodemanda = ?, decricaoproblema = ?, desenhoprocesso = ?, funcionalidade = ?, parteenvolvida = ?, parteenvolvidarepresentante = ?, parteenvolvidaformacontato = ?, estimativacustoglobal = ?, fontefinanciamento = ?, metodolevantamentocusto = ?, numerousuarioprevisto = ?, recursos = ?, treinamentopessoal = ?, materialapoio = ?, restricaoprojeto = ?, principaisusuarios = ?, necessidadeusuario = ?, prioridade = ?, solucaoatual = ?, problemasolucaoatual = ?, solucaoproposta = ?, status = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(solicitacaoServicoTI, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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

	private void setPreparedStatement(SolicitacaoServicoTI solicitacaoServicoTI, PreparedStatement ps) throws SQLException{
		
		ps.setObject(1, solicitacaoServicoTI.getCodigoprojeto());
		ps.setObject(2, solicitacaoServicoTI.getCodigosolicitaoservico());
		ps.setString(3, solicitacaoServicoTI.getArea());			
		ps.setString(4, solicitacaoServicoTI.getResponsaveldemanda());
		ps.setString(5, solicitacaoServicoTI.getTelefonecontato());
		ps.setString(6, solicitacaoServicoTI.getEmail());
		ps.setString(7, solicitacaoServicoTI.getId());
		ps.setString(8, solicitacaoServicoTI.getDatasolicitacao());
		ps.setString(9, solicitacaoServicoTI.getNomedemanda());
		ps.setString(10, solicitacaoServicoTI.getObjetivodemanda());
		ps.setString(11, solicitacaoServicoTI.getDecricaoproblema());
		ps.setString(12, solicitacaoServicoTI.getDesenhoprocesso());
		ps.setString(13, solicitacaoServicoTI.getFuncionalidade());
		ps.setString(14, solicitacaoServicoTI.getParteenvolvida());
		ps.setString(15, solicitacaoServicoTI.getParteenvolvidarepresentante());
		ps.setString(16, solicitacaoServicoTI.getParteenvolvidaformacontato());
		ps.setString(17, solicitacaoServicoTI.getEstimativacustoglobal());
		ps.setString(18, solicitacaoServicoTI.getFontefinanciamento());
		ps.setString(19, solicitacaoServicoTI.getMetodolevantamentocusto());
		ps.setString(20, solicitacaoServicoTI.getNumerousuarioprevisto());
		ps.setString(21, solicitacaoServicoTI.getRecursos());
		ps.setString(22, solicitacaoServicoTI.getTreinamentopessoal());
		ps.setString(23, solicitacaoServicoTI.getMaterialapoio());
		ps.setString(24, solicitacaoServicoTI.getRestricaoprojeto());
		ps.setString(25, solicitacaoServicoTI.getPrincipaisusuarios());
		ps.setString(26, solicitacaoServicoTI.getNecessidadeusuario());
		ps.setString(27, solicitacaoServicoTI.getPrioridade());
		ps.setString(28, solicitacaoServicoTI.getSolucaoatual());
		ps.setString(29, solicitacaoServicoTI.getProblemasolucaoatual());
		ps.setString(30, solicitacaoServicoTI.getSolucaoproposta());
		ps.setString(31, solicitacaoServicoTI.getStatus());
		ps.setInt(32, solicitacaoServicoTI.getCodigo());

	}
	
	@Override
	public void salvar(SolicitacaoServicoTI solicitacaoServicoTI) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		
		try {
			String sql = "INSERT INTO solicitacaoservicoti (codigoprojeto, codigosolicitaoservico, area, responsaveldemanda, telefonecontato, email, id, datasolicitacao, nomedemanda, objetivodemanda, decricaoproblema, desenhoprocesso, funcionalidade, parteenvolvida, parteenvolvidarepresentante, parteenvolvidaformacontato, estimativacustoglobal, fontefinanciamento, metodolevantamentocusto, numerousuarioprevisto, recursos, treinamentopessoal, materialapoio, restricaoprojeto, principaisusuarios, necessidadeusuario, prioridade, solucaoatual, problemasolucaoatual, solucaoproposta, status)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			ps=con.prepareStatement(sql);
			
			ps.setObject(1, solicitacaoServicoTI.getCodigoprojeto());
			ps.setObject(2, solicitacaoServicoTI.getCodigosolicitaoservico());
			ps.setString(3, solicitacaoServicoTI.getArea());			
			ps.setString(4, solicitacaoServicoTI.getResponsaveldemanda());
			ps.setString(5, solicitacaoServicoTI.getTelefonecontato());
			ps.setString(6, solicitacaoServicoTI.getEmail());
			ps.setString(7, solicitacaoServicoTI.getId());
			ps.setString(8, solicitacaoServicoTI.getDatasolicitacao());
			ps.setString(9, solicitacaoServicoTI.getNomedemanda());
			ps.setString(10, solicitacaoServicoTI.getObjetivodemanda());
			ps.setString(11, solicitacaoServicoTI.getDecricaoproblema());
			ps.setString(12, solicitacaoServicoTI.getDesenhoprocesso());
			ps.setString(13, solicitacaoServicoTI.getFuncionalidade());
			ps.setString(14, solicitacaoServicoTI.getParteenvolvida());
			ps.setString(15, solicitacaoServicoTI.getParteenvolvidarepresentante());
			ps.setString(16, solicitacaoServicoTI.getParteenvolvidaformacontato());
			ps.setString(17, solicitacaoServicoTI.getEstimativacustoglobal());
			ps.setString(18, solicitacaoServicoTI.getFontefinanciamento());
			ps.setString(19, solicitacaoServicoTI.getMetodolevantamentocusto());
			ps.setString(20, solicitacaoServicoTI.getNumerousuarioprevisto());
			ps.setString(21, solicitacaoServicoTI.getRecursos());
			ps.setString(22, solicitacaoServicoTI.getTreinamentopessoal());
			ps.setString(23, solicitacaoServicoTI.getMaterialapoio());
			ps.setString(24, solicitacaoServicoTI.getRestricaoprojeto());
			ps.setString(25, solicitacaoServicoTI.getPrincipaisusuarios());
			ps.setString(26, solicitacaoServicoTI.getNecessidadeusuario());
			ps.setString(27, solicitacaoServicoTI.getPrioridade());
			ps.setString(28, solicitacaoServicoTI.getSolucaoatual());
			ps.setString(29, solicitacaoServicoTI.getProblemasolucaoatual());
			ps.setString(30, solicitacaoServicoTI.getSolucaoproposta());
			ps.setString(31, solicitacaoServicoTI.getStatus());
			
			ps.executeUpdate();
			ps.close();
			
			
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
	public SolicitacaoServicoTI getSolicitacaoServicoTI(Integer codigo) throws Exception {
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM solicitacaoservicoti WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<SolicitacaoServicoTI> resultado = getListaSolicitacaoServicoTI(rs);
			
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

	@Override
	public List<SolicitacaoServicoTI> getSolicitacaoServicoTIs() throws Exception {
		
		List<SolicitacaoServicoTI> resultado = new ArrayList<SolicitacaoServicoTI>();// montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM solicitacaoservicoti";
			
			ps = con.prepareStatement(sqlSelect);
			rs = ps.executeQuery();//receber o resultado da query
			
			while(rs.next()){
				SolicitacaoServicoTI solicitacaoServicoTI = new SolicitacaoServicoTI();
				
				solicitacaoServicoTI.setCodigoprojeto(rs.getInt("codigoprojeto"));
				solicitacaoServicoTI.setCodigosolicitaoservico(rs.getString("codigosolicitaoservico"));
				solicitacaoServicoTI.setArea(rs.getString("area"));
				solicitacaoServicoTI.setResponsaveldemanda(rs.getString("responsaveldemanda"));
				solicitacaoServicoTI.setTelefonecontato(rs.getString("telefonecontato"));
				solicitacaoServicoTI.setEmail(rs.getString("email"));
				solicitacaoServicoTI.setId(rs.getString("id"));
				solicitacaoServicoTI.setDatasolicitacao(rs.getString("datasolicitacao"));
				solicitacaoServicoTI.setNomedemanda(rs.getString("nomedemanda"));
				solicitacaoServicoTI.setObjetivodemanda(rs.getString("objetivodemanda"));
				solicitacaoServicoTI.setDecricaoproblema(rs.getString("decricaoproblema"));
				solicitacaoServicoTI.setDesenhoprocesso(rs.getString("desenhoprocesso"));
				solicitacaoServicoTI.setFuncionalidade(rs.getString("funcionalidade"));
				solicitacaoServicoTI.setParteenvolvida(rs.getString("parteenvolvida"));
				solicitacaoServicoTI.setParteenvolvidarepresentante(rs.getString("parteenvolvidarepresentante"));
				solicitacaoServicoTI.setParteenvolvidaformacontato(rs.getString("parteenvolvidaformacontato"));
				solicitacaoServicoTI.setEstimativacustoglobal(rs.getString("estimativacustoglobal"));				
				solicitacaoServicoTI.setFontefinanciamento(rs.getString("fontefinanciamento"));
				solicitacaoServicoTI.setMetodolevantamentocusto(rs.getString("metodolevantamentocusto"));
				solicitacaoServicoTI.setNumerousuarioprevisto(rs.getString("numerousuarioprevisto"));
				solicitacaoServicoTI.setRecursos(rs.getString("recursos"));
				solicitacaoServicoTI.setTreinamentopessoal(rs.getString("treinamentopessoal"));
				solicitacaoServicoTI.setMaterialapoio(rs.getString("materialapoio"));
				solicitacaoServicoTI.setRestricaoprojeto(rs.getString("restricaoprojeto"));
				solicitacaoServicoTI.setPrincipaisusuarios(rs.getString("principaisusuarios"));
				solicitacaoServicoTI.setNecessidadeusuario(rs.getString("necessidadeusuario"));
				solicitacaoServicoTI.setPrioridade(rs.getString("prioridade"));
				solicitacaoServicoTI.setSolucaoatual(rs.getString("solucaoatual"));
				solicitacaoServicoTI.setProblemasolucaoatual(rs.getString("problemasolucaoatual"));
				solicitacaoServicoTI.setSolucaoproposta(rs.getString("solucaoproposta"));
				solicitacaoServicoTI.setStatus(rs.getString("status"));
				solicitacaoServicoTI.setCodigo(rs.getInt("codigo"));
				
				resultado.add(solicitacaoServicoTI);	
				
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
	
	//Metodo p confirma objetivo. Resulmir linhas de códigos, que pode ser usados em outros métodos. (ex: resultado = getListaCliente(rs); ou List<Cliente> resultado = getListaCliente(rs);)
	private List<SolicitacaoServicoTI> getListaSolicitacaoServicoTI(ResultSet rs) throws SQLException	{
		
		List<SolicitacaoServicoTI> resultado = new ArrayList<SolicitacaoServicoTI>();// montar o resultado
		
		// Laço p/ preencher
		while (rs.next()) {
			
			SolicitacaoServicoTI solicitacaoServicoTI = new SolicitacaoServicoTI();
			
			solicitacaoServicoTI.setCodigoprojeto(rs.getInt("codigoprojeto"));
			solicitacaoServicoTI.setCodigosolicitaoservico(rs.getString("codigosolicitaoservico"));
			solicitacaoServicoTI.setArea(rs.getString("area"));
			solicitacaoServicoTI.setResponsaveldemanda(rs.getString("responsaveldemanda"));
			solicitacaoServicoTI.setTelefonecontato(rs.getString("telefonecontato"));
			solicitacaoServicoTI.setEmail(rs.getString("email"));
			solicitacaoServicoTI.setId(rs.getString("id"));
			solicitacaoServicoTI.setDatasolicitacao(rs.getString("datasolicitacao"));
			solicitacaoServicoTI.setNomedemanda(rs.getString("nomedemanda"));
			solicitacaoServicoTI.setObjetivodemanda(rs.getString("objetivodemanda"));
			solicitacaoServicoTI.setDecricaoproblema(rs.getString("decricaoproblema"));
			solicitacaoServicoTI.setDesenhoprocesso(rs.getString("desenhoprocesso"));
			solicitacaoServicoTI.setFuncionalidade(rs.getString("funcionalidade"));
			solicitacaoServicoTI.setParteenvolvida(rs.getString("parteenvolvida"));
			solicitacaoServicoTI.setParteenvolvidarepresentante(rs.getString("parteenvolvidarepresentante"));
			solicitacaoServicoTI.setParteenvolvidaformacontato(rs.getString("parteenvolvidaformacontato"));
			solicitacaoServicoTI.setEstimativacustoglobal(rs.getString("estimativacustoglobal"));				
			solicitacaoServicoTI.setFontefinanciamento(rs.getString("fontefinanciamento"));
			solicitacaoServicoTI.setMetodolevantamentocusto(rs.getString("metodolevantamentocusto"));
			solicitacaoServicoTI.setNumerousuarioprevisto(rs.getString("numerousuarioprevisto"));
			solicitacaoServicoTI.setRecursos(rs.getString("recursos"));
			solicitacaoServicoTI.setTreinamentopessoal(rs.getString("treinamentopessoal"));
			solicitacaoServicoTI.setMaterialapoio(rs.getString("materialapoio"));
			solicitacaoServicoTI.setRestricaoprojeto(rs.getString("restricaoprojeto"));
			solicitacaoServicoTI.setPrincipaisusuarios(rs.getString("principaisusuarios"));
			solicitacaoServicoTI.setNecessidadeusuario(rs.getString("necessidadeusuario"));
			solicitacaoServicoTI.setPrioridade(rs.getString("prioridade"));
			solicitacaoServicoTI.setSolucaoatual(rs.getString("solucaoatual"));
			solicitacaoServicoTI.setProblemasolucaoatual(rs.getString("problemasolucaoatual"));
			solicitacaoServicoTI.setSolucaoproposta(rs.getString("solucaoproposta"));
			solicitacaoServicoTI.setStatus(rs.getString("status"));
			solicitacaoServicoTI.setCodigo(rs.getInt("codigo"));
							
			resultado.add(solicitacaoServicoTI);
		}			
		return resultado;
	}

}

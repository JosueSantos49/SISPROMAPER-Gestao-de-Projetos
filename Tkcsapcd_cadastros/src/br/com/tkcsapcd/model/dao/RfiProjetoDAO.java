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
import br.com.tkcsapcd.model.bean.RfiProjeto;
import br.com.tkcsapcd.model.util.Conexao;

public class RfiProjetoDAO implements InterfaceRfiProjetoDAO {

	@SuppressWarnings("unused")
	private InterfacePool pool;
	public RfiProjetoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
				
		try{

			String SqlExcluir = "DELETE FROM rfiprojeto WHERE codigo = ?;";			
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

	@Override
	public void atualizar(RfiProjeto rfiProjeto) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
	
	try {	
		
		String sqlAtualizar = "UPDATE rfiprojeto SET nome=?, endereco=?, paginaweb=?, produtoservico=?, mercadocliente=?, estruturapropriedade=?, estruturaempresa=? ,anosmercado=?, localizacao=?, gestaoambiental=?, gestaoqualidade=?, gestaonegocio=?, funcionario=?, producao=?	,marketingvendas=?	,departamentoqualidade=?	,informacaofinanceira=?	,volumenegocio=?	,ultimolucroano=?	,mercadoacoes=?	,pessoacontato=?	,telefone=?	,email=? ,capacidadehoje=?	,capacidadeantecipada=?	,condicaonaoatendida=?	,produtosentregues=?	,clientereferenciacomparaveis=?	,clientereferencianaocomparaveis=?	,disponivelentrega=?	,disponibilidade=?	,suportemundial=?	,data=?, cnpj=? WHERE codigo = ?;";
			
		ps = con.prepareStatement(sqlAtualizar);			
		setPreparedStatement(rfiProjeto, ps);//Código isolado do metodo sqlInsert permite usar a mesma linha, facilitando!			
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

	@Override
	public void salvar(RfiProjeto rfiProjeto) throws Exception  {
		
		Connection con = Conexao.getConnection();		
		PreparedStatement ps=null;
		try {
			
			String sqlInsert = "INSERT INTO rfiprojeto (nome, endereco, paginaweb, produtoservico, mercadocliente, estruturapropriedade, estruturaempresa ,anosmercado, localizacao, gestaoambiental, gestaoqualidade, gestaonegocio, funcionario, producao	,marketingvendas	,departamentoqualidade	,informacaofinanceira	,volumenegocio	,ultimolucroano	,mercadoacoes	,pessoacontato	,telefone	,email	,capacidadehoje	,capacidadeantecipada	,condicaonaoatendida	,produtosentregues	,clientereferenciacomparaveis	,clientereferencianaocomparaveis	,disponivelentrega	,disponibilidade	,suportemundial	,data, cnpj, codigo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
							
			ps = con.prepareStatement(sqlInsert);
			setPreparedStatement(rfiProjeto, ps);				
			ps.executeUpdate();
			ps.close();

			// Pode acontecer o q/ for, que a conexao sera executada.
		} finally {
			//Liberar conexão
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
	
	private void setPreparedStatement(RfiProjeto rfiProjeto, PreparedStatement ps) throws SQLException{
		
		ps.setString(1, rfiProjeto.getNome());				
		ps.setString(2, rfiProjeto.getEndereco());
		ps.setString(3, rfiProjeto.getPaginaweb());					
		ps.setString(4, rfiProjeto.getProdutoservico());					
		ps.setString(5, rfiProjeto.getMercadocliente());
		ps.setString(6, rfiProjeto.getEstruturapropriedade());	
		ps.setString(7, rfiProjeto.getEstruturaempresa());				
		ps.setString(8, rfiProjeto.getAnosmercado());				
		ps.setString(9, rfiProjeto.getLocalizacao());					
		ps.setString(10, rfiProjeto.getGestaoambiental());				
		ps.setString(11, rfiProjeto.getGestaoqualidade());				
		ps.setString(12, rfiProjeto.getGestaonegocio());				
		ps.setString(13, rfiProjeto.getFuncionario());				
		ps.setString(14, rfiProjeto.getProducao());				
		ps.setString(15, rfiProjeto.getMarketingvendas());				
		ps.setString(16, rfiProjeto.getDepartamentoqualidade());					
		ps.setString(17, rfiProjeto.getInformacaofinanceira());
		ps.setString(18, rfiProjeto.getVolumenegocio());	
		ps.setString(19, rfiProjeto.getUltimolucroano());				
		ps.setString(20, rfiProjeto.getMercadoacoes());	
		ps.setString(21, rfiProjeto.getPessoacontato());				
		ps.setString(22, rfiProjeto.getTelefone());				
		ps.setString(23, rfiProjeto.getEmail());
		ps.setString(24, rfiProjeto.getCapacidadehoje());
		ps.setString(25, rfiProjeto.getCapacidadeantecipada());
		ps.setString(26, rfiProjeto.getCondicaonaoatendida());
		ps.setString(27, rfiProjeto.getProdutosentregues());	
		ps.setString(28, rfiProjeto.getClientereferenciacomparaveis());
		ps.setString(29, rfiProjeto.getClientereferencianaocomparaveis());
		ps.setString(30, rfiProjeto.getDisponivelentrega());
		ps.setString(31, rfiProjeto.getDisponibilidade());
		ps.setString(32, rfiProjeto.getSuportemundial());
		ps.setDate(33, new java.sql.Date(rfiProjeto.getData().getTime()));
		ps.setObject(34, rfiProjeto.getCnpj());
		ps.setObject(35, rfiProjeto.getCodigo());//Atenção: necessário para isolar o metodo (extração).
	}

	@Override
	public RfiProjeto getRfiProjeto(Integer codigo) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
					
		try {
			
			String sqlSelect = "SELECT * FROM rfiprojeto WHERE codigo = ?;";				
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando				
			rs = ps.executeQuery();
				
			List<RfiProjeto> resultado = getListaRfiProjeto(rs);
			
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

	@Override
	public RfiProjeto getRfiProjeto(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RfiProjeto> getRfiProjeto() throws Exception {
		
		List<RfiProjeto> resultado = new ArrayList<RfiProjeto>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();				
				
			String sqlSelect = "SELECT * FROM rfiprojeto;";
				
			ps = con.prepareStatement(sqlSelect);
			rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.														
				
				//resultado = getListaFuncionario(rs);	
				while(rs.next()){
					
					RfiProjeto rfiProjeto = new RfiProjeto();	
					
					rfiProjeto.setNome(rs.getString("nome"));
					rfiProjeto.setEndereco(rs.getString("endereco"));
					rfiProjeto.setPaginaweb(rs.getString("paginaweb"));
					rfiProjeto.setProdutoservico(rs.getString("produtoservico"));
					rfiProjeto.setMercadocliente(rs.getString("mercadocliente"));
					rfiProjeto.setEstruturapropriedade(rs.getString("estruturapropriedade"));
					rfiProjeto.setEstruturaempresa(rs.getString("estruturaempresa"));
					rfiProjeto.setAnosmercado(rs.getString("anosmercado"));
					rfiProjeto.setLocalizacao(rs.getString("localizacao"));
					rfiProjeto.setGestaoambiental(rs.getString("gestaoambiental"));
					rfiProjeto.setGestaoqualidade(rs.getString("gestaoqualidade"));
					rfiProjeto.setGestaonegocio(rs.getString("gestaonegocio"));			
					rfiProjeto.setFuncionario(rs.getString("funcionario"));
					rfiProjeto.setProducao(rs.getString("producao"));
					rfiProjeto.setMarketingvendas(rs.getString("marketingvendas"));
					rfiProjeto.setDepartamentoqualidade(rs.getString("departamentoqualidade"));
					rfiProjeto.setInformacaofinanceira(rs.getString("informacaofinanceira"));
					rfiProjeto.setVolumenegocio(rs.getString("volumenegocio"));
					rfiProjeto.setUltimolucroano(rs.getString("ultimolucroano"));
					rfiProjeto.setMercadoacoes(rs.getString("mercadoacoes"));
					rfiProjeto.setPessoacontato(rs.getString("pessoacontato"));
					rfiProjeto.setTelefone(rs.getString("telefone"));
					rfiProjeto.setEmail(rs.getString("email"));
					rfiProjeto.setCapacidadehoje(rs.getString("capacidadehoje"));
					rfiProjeto.setCapacidadeantecipada(rs.getString("capacidadeantecipada"));
					rfiProjeto.setCondicaonaoatendida(rs.getString("condicaonaoatendida"));			
					rfiProjeto.setProdutosentregues(rs.getString("produtosentregues"));
					rfiProjeto.setClientereferenciacomparaveis(rs.getString("clientereferenciacomparaveis"));
					rfiProjeto.setClientereferencianaocomparaveis(rs.getString("clientereferencianaocomparaveis"));
					rfiProjeto.setDisponivelentrega(rs.getString("disponivelentrega"));
					rfiProjeto.setDisponibilidade(rs.getString("disponibilidade"));
					rfiProjeto.setSuportemundial(rs.getString("suportemundial"));
					rfiProjeto.setData(rs.getDate("data"));
					rfiProjeto.setCnpj(rs.getLong("cnpj"));
					rfiProjeto.setCodigo(rs.getLong("codigo"));			
					
					resultado.add(rfiProjeto);// Add o cliente ao resultado
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
	
	private List<RfiProjeto> getListaRfiProjeto(ResultSet rs) throws SQLException{
		
		List<RfiProjeto> resultado = new ArrayList<RfiProjeto>();
		
		while(rs.next()){
			
			RfiProjeto rfiProjeto = new RfiProjeto();	
			
			rfiProjeto.setNome(rs.getString("nome"));
			rfiProjeto.setEndereco(rs.getString("endereco"));
			rfiProjeto.setPaginaweb(rs.getString("paginaweb"));
			rfiProjeto.setProdutoservico(rs.getString("produtoservico"));
			rfiProjeto.setMercadocliente(rs.getString("mercadocliente"));
			rfiProjeto.setEstruturapropriedade(rs.getString("estruturapropriedade"));
			rfiProjeto.setEstruturaempresa(rs.getString("estruturaempresa"));
			rfiProjeto.setAnosmercado(rs.getString("anosmercado"));
			rfiProjeto.setLocalizacao(rs.getString("localizacao"));
			rfiProjeto.setGestaoambiental(rs.getString("gestaoambiental"));
			rfiProjeto.setGestaoqualidade(rs.getString("gestaoqualidade"));
			rfiProjeto.setGestaonegocio(rs.getString("gestaonegocio"));			
			rfiProjeto.setFuncionario(rs.getString("funcionario"));
			rfiProjeto.setProducao(rs.getString("producao"));
			rfiProjeto.setMarketingvendas(rs.getString("marketingvendas"));
			rfiProjeto.setDepartamentoqualidade(rs.getString("departamentoqualidade"));
			rfiProjeto.setInformacaofinanceira(rs.getString("informacaofinanceira"));
			rfiProjeto.setVolumenegocio(rs.getString("volumenegocio"));
			rfiProjeto.setUltimolucroano(rs.getString("ultimolucroano"));
			rfiProjeto.setMercadoacoes(rs.getString("mercadoacoes"));
			rfiProjeto.setPessoacontato(rs.getString("pessoacontato"));
			rfiProjeto.setTelefone(rs.getString("telefone"));
			rfiProjeto.setEmail(rs.getString("email"));
			rfiProjeto.setCapacidadehoje(rs.getString("capacidadehoje"));
			rfiProjeto.setCapacidadeantecipada(rs.getString("capacidadeantecipada"));
			rfiProjeto.setCondicaonaoatendida(rs.getString("condicaonaoatendida"));			
			rfiProjeto.setProdutosentregues(rs.getString("produtosentregues"));
			rfiProjeto.setClientereferenciacomparaveis(rs.getString("clientereferenciacomparaveis"));
			rfiProjeto.setClientereferencianaocomparaveis(rs.getString("clientereferencianaocomparaveis"));
			rfiProjeto.setDisponivelentrega(rs.getString("disponivelentrega"));
			rfiProjeto.setDisponibilidade(rs.getString("disponibilidade"));
			rfiProjeto.setSuportemundial(rs.getString("suportemundial"));
			rfiProjeto.setData(rs.getDate("data"));
			rfiProjeto.setCodigo(rs.getLong("codigo"));			
			
			resultado.add(rfiProjeto);// Add o cliente ao resultado
		}		
		return resultado;		
	}

}

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
import br.com.tkcsapcd.model.bean.PlanoGerenciamentoRisco;
import br.com.tkcsapcd.model.util.Conexao;

public class PlanoGerenciamentoRiscoDAO implements InterfacePlanoGerenciamentoRiscoDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public PlanoGerenciamentoRiscoDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM planogerenciamentorisco WHERE codigo = ?;";

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
	private void setPreparedStatement(PlanoGerenciamentoRisco planoGerenciamentoRisco, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, planoGerenciamentoRisco.getPlanogerenciamentorisco());
		ps.setString(2, planoGerenciamentoRisco.getProjeto());
		ps.setInt(3, planoGerenciamentoRisco.getCodigoprojeto());
		ps.setString(4, planoGerenciamentoRisco.getVersao());
		ps.setString(5, planoGerenciamentoRisco.getData());
		ps.setString(6, planoGerenciamentoRisco.getAutor());
		ps.setString(7, planoGerenciamentoRisco.getNotarevisao());
		ps.setString(8, planoGerenciamentoRisco.getAprovacao());
		ps.setObject(9, planoGerenciamentoRisco.getObjetivo());
		ps.setString(10, planoGerenciamentoRisco.getGerenciamento());
		ps.setString(11, planoGerenciamentoRisco.getProcesso());		
		ps.setString(12, planoGerenciamentoRisco.getDocumento());
		ps.setString(13, planoGerenciamentoRisco.getResponsabilidade());
		ps.setString(14, planoGerenciamentoRisco.getIdentificar());	
		ps.setString(15, planoGerenciamentoRisco.getEar());
		ps.setString(16, planoGerenciamentoRisco.getRiscos());
		ps.setString(17, planoGerenciamentoRisco.getAnalisequalitativa());
		ps.setString(18, planoGerenciamentoRisco.getDefinicao());
		ps.setString(19, planoGerenciamentoRisco.getAnalisequantitativa());
		ps.setString(20, planoGerenciamentoRisco.getPlanejar());
		ps.setString(21, planoGerenciamentoRisco.getReservas());
		ps.setString(22, planoGerenciamentoRisco.getControlar());
		ps.setInt(23, planoGerenciamentoRisco.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public PlanoGerenciamentoRisco getPlanoGerenciamentoRisco(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM planogerenciamentorisco WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<PlanoGerenciamentoRisco> resultado = getListaPlanoGerenciamentoRisco(rs);
			
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
		private List<PlanoGerenciamentoRisco> getListaPlanoGerenciamentoRisco(ResultSet rs) throws SQLException	{
			List<PlanoGerenciamentoRisco> resultado = new ArrayList<PlanoGerenciamentoRisco>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				PlanoGerenciamentoRisco planoGerenciamentoRisco = new PlanoGerenciamentoRisco();
				
				planoGerenciamentoRisco.setPlanogerenciamentorisco(rs.getString("planogerenciamentorisco"));
				planoGerenciamentoRisco.setProjeto(rs.getString("projeto"));
				planoGerenciamentoRisco.setCodigoprojeto(rs.getInt("codigoprojeto"));
				planoGerenciamentoRisco.setVersao(rs.getString("versao"));
				planoGerenciamentoRisco.setData(rs.getString("data"));
				planoGerenciamentoRisco.setAutor(rs.getString("autor"));
				planoGerenciamentoRisco.setNotarevisao(rs.getString("notarevisao"));
				planoGerenciamentoRisco.setAprovacao(rs.getString("aprovacao"));
				planoGerenciamentoRisco.setObjetivo(rs.getString("objetivo"));				
				planoGerenciamentoRisco.setGerenciamento(rs.getString("gerenciamento"));					
				planoGerenciamentoRisco.setProcesso(rs.getString("processo"));
				planoGerenciamentoRisco.setDocumento(rs.getString("documento"));
				planoGerenciamentoRisco.setResponsabilidade(rs.getString("responsabilidade"));
				planoGerenciamentoRisco.setIdentificar(rs.getString("identificar"));
				planoGerenciamentoRisco.setEar(rs.getString("ear"));
				planoGerenciamentoRisco.setRiscos(rs.getString("riscos"));
				planoGerenciamentoRisco.setAnalisequalitativa(rs.getString("analisequalitativa"));
				planoGerenciamentoRisco.setDefinicao(rs.getString("definicao"));					
				planoGerenciamentoRisco.setAnalisequantitativa(rs.getString("analisequantitativa"));
				planoGerenciamentoRisco.setPlanejar(rs.getString("planejar"));
				planoGerenciamentoRisco.setReservas(rs.getString("reservas"));
				planoGerenciamentoRisco.setControlar(rs.getString("controlar"));
				planoGerenciamentoRisco.setCodigo(rs.getInt("codigo"));
												
				resultado.add(planoGerenciamentoRisco);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(PlanoGerenciamentoRisco planoGerenciamentoRisco) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE planogerenciamentorisco SET 	planogerenciamentorisco = ?, projeto = ?, codigoprojeto = ?, versao = ?, data = ?, autor = ?, notarevisao = ?, aprovacao = ?, objetivo = ?, gerenciamento = ?, processo = ?, documento = ?, responsabilidade = ?, identificar = ?, ear = ?, riscos = ?, analisequalitativa = ?, definicao = ?, analisequantitativa = ?, planejar = ?, reservas = ?, controlar = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(planoGerenciamentoRisco, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	public void salvar(PlanoGerenciamentoRisco planoGerenciamentoRisco) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO planogerenciamentorisco(planogerenciamentorisco, projeto, codigoprojeto, versao, data, autor, notarevisao, aprovacao, objetivo, gerenciamento, processo, documento, responsabilidade, identificar, ear, riscos, analisequalitativa, definicao, analisequantitativa, planejar, reservas, controlar) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, planoGerenciamentoRisco.getPlanogerenciamentorisco());
			ps.setString(2, planoGerenciamentoRisco.getProjeto());
			ps.setInt(3, planoGerenciamentoRisco.getCodigoprojeto());
			ps.setString(4, planoGerenciamentoRisco.getVersao());
			ps.setString(5, planoGerenciamentoRisco.getData());
			ps.setString(6, planoGerenciamentoRisco.getAutor());
			ps.setString(7, planoGerenciamentoRisco.getNotarevisao());
			ps.setString(8, planoGerenciamentoRisco.getAprovacao());
			ps.setObject(9, planoGerenciamentoRisco.getObjetivo());
			ps.setString(10, planoGerenciamentoRisco.getGerenciamento());
			ps.setString(11, planoGerenciamentoRisco.getProcesso());		
			ps.setString(12, planoGerenciamentoRisco.getDocumento());
			ps.setString(13, planoGerenciamentoRisco.getResponsabilidade());
			ps.setString(14, planoGerenciamentoRisco.getIdentificar());	
			ps.setString(15, planoGerenciamentoRisco.getEar());
			ps.setString(16, planoGerenciamentoRisco.getRiscos());
			ps.setString(17, planoGerenciamentoRisco.getAnalisequalitativa());
			ps.setString(18, planoGerenciamentoRisco.getDefinicao());
			ps.setString(19, planoGerenciamentoRisco.getAnalisequantitativa());
			ps.setString(20, planoGerenciamentoRisco.getPlanejar());
			ps.setString(21, planoGerenciamentoRisco.getReservas());
			ps.setString(22, planoGerenciamentoRisco.getControlar());			
			
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
	public List<PlanoGerenciamentoRisco> getPlanoGerenciamentoRiscos() throws Exception  {
		
		   List<PlanoGerenciamentoRisco> resultado = new ArrayList<PlanoGerenciamentoRisco>();// Montar o resultado
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM planogerenciamentorisco";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {

					PlanoGerenciamentoRisco planoGerenciamentoRisco = new PlanoGerenciamentoRisco();
				
					planoGerenciamentoRisco.setPlanogerenciamentorisco(rs.getString("planogerenciamentorisco"));
					planoGerenciamentoRisco.setProjeto(rs.getString("projeto"));
					planoGerenciamentoRisco.setCodigoprojeto(rs.getInt("codigoprojeto"));
					planoGerenciamentoRisco.setVersao(rs.getString("versao"));
					planoGerenciamentoRisco.setData(rs.getString("data"));
					planoGerenciamentoRisco.setAutor(rs.getString("autor"));
					planoGerenciamentoRisco.setNotarevisao(rs.getString("notarevisao"));
					planoGerenciamentoRisco.setAprovacao(rs.getString("aprovacao"));
					planoGerenciamentoRisco.setObjetivo(rs.getString("objetivo"));				
					planoGerenciamentoRisco.setGerenciamento(rs.getString("gerenciamento"));					
					planoGerenciamentoRisco.setProcesso(rs.getString("processo"));
					planoGerenciamentoRisco.setDocumento(rs.getString("documento"));
					planoGerenciamentoRisco.setResponsabilidade(rs.getString("responsabilidade"));
					planoGerenciamentoRisco.setIdentificar(rs.getString("identificar"));
					planoGerenciamentoRisco.setEar(rs.getString("ear"));
					planoGerenciamentoRisco.setRiscos(rs.getString("riscos"));
					planoGerenciamentoRisco.setAnalisequalitativa(rs.getString("analisequalitativa"));
					planoGerenciamentoRisco.setDefinicao(rs.getString("definicao"));					
					planoGerenciamentoRisco.setAnalisequantitativa(rs.getString("analisequantitativa"));
					planoGerenciamentoRisco.setPlanejar(rs.getString("planejar"));
					planoGerenciamentoRisco.setReservas(rs.getString("reservas"));
					planoGerenciamentoRisco.setControlar(rs.getString("controlar"));
					planoGerenciamentoRisco.setCodigo(rs.getInt("codigo"));
									
					resultado.add(planoGerenciamentoRisco);// Add o projeto ao resultado.
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

/* 
O	Autor: Josué da Conceição Santos
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
import br.com.tkcsapcd.model.bean.RegistroParteInteressada;
import br.com.tkcsapcd.model.util.Conexao;

public class RegistroParteInteressadaDAO implements InterfaceRegistroParteInteressadaDAO{	
	
	//todos os atributos tem uma conexão
		@SuppressWarnings("unused")
		private static Connection con;
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public RegistroParteInteressadaDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	
		//Criando um ArrayList para armazenar as notícias
		@SuppressWarnings("static-access")
		public RegistroParteInteressadaDAO()throws Exception{
			con = new Conexao().getConnection();
		}
	
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM registroparteinteressada WHERE codigo = ?;";

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
	public void salvar(RegistroParteInteressada registroParteInteressada) throws Exception  {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO registroparteinteressada(registroparteinteressada, versao, data, autor, notarevisao, aprovacao, codigoparteinteressada, importancia, parteinteressada, empresa, funcaoprojeto, email, celular, fone, requisito, responsabilidade, expectativas, poder, interesse, comentario, projetoinicio) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setString(1, registroParteInteressada.getRegistroparteinteressada());
			ps.setString(2, registroParteInteressada.getVersao());
			ps.setString(3, registroParteInteressada.getData());
			ps.setString(4, registroParteInteressada.getAutor());
			ps.setString(5, registroParteInteressada.getNotarevisao());
			ps.setString(6, registroParteInteressada.getAprovacao());
			ps.setObject(7, registroParteInteressada.getCodigoparteinteressada());
			ps.setInt(8, registroParteInteressada.getImportancia());
			ps.setString(9, registroParteInteressada.getParteinteressada());		
			ps.setString(10, registroParteInteressada.getEmpresa());
			ps.setString(11, registroParteInteressada.getFuncaoprojeto());
			ps.setString(12, registroParteInteressada.getEmail());	
			ps.setString(13, registroParteInteressada.getCelular());
			ps.setString(14, registroParteInteressada.getFone());
			ps.setString(15, registroParteInteressada.getRequisito());
			ps.setString(16, registroParteInteressada.getResponsabilidade());
			ps.setString(17, registroParteInteressada.getExpectativas());
			ps.setString(18, registroParteInteressada.getPoder());
			ps.setString(19, registroParteInteressada.getInteresse());
			ps.setString(20, registroParteInteressada.getComentario());
			ps.setObject(21, registroParteInteressada.getProjetoinicio().getCodigo());
			
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
	public void atualizar(RegistroParteInteressada registroParteInteressada) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE registroparteinteressada SET 	registroparteinteressada = ?, versao = ?, data = ?, autor = ?, notarevisao = ?, aprovacao = ?, codigoparteinteressada = ?, importancia = ?, parteinteressada = ?, empresa = ?, funcaoprojeto = ?, email = ?, celular = ?, fone = ?, requisito = ?, responsabilidade = ?, expectativas = ?, poder = ?, interesse = ?, comentario = ?, projetoinicio = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(registroParteInteressada, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
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
	
	private void setPreparedStatement(RegistroParteInteressada registroParteInteressada, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, registroParteInteressada.getRegistroparteinteressada());
		ps.setString(2, registroParteInteressada.getVersao());
		ps.setString(3, registroParteInteressada.getData());
		ps.setString(4, registroParteInteressada.getAutor());
		ps.setString(5, registroParteInteressada.getNotarevisao());
		ps.setString(6, registroParteInteressada.getAprovacao());
		ps.setObject(7, registroParteInteressada.getCodigoparteinteressada());
		ps.setInt(8, registroParteInteressada.getImportancia());
		ps.setString(9, registroParteInteressada.getParteinteressada());		
		ps.setString(10, registroParteInteressada.getEmpresa());
		ps.setString(11, registroParteInteressada.getFuncaoprojeto());
		ps.setString(12, registroParteInteressada.getEmail());	
		ps.setString(13, registroParteInteressada.getCelular());
		ps.setString(14, registroParteInteressada.getFone());
		ps.setString(15, registroParteInteressada.getRequisito());
		ps.setString(16, registroParteInteressada.getResponsabilidade());
		ps.setString(17, registroParteInteressada.getExpectativas());
		ps.setString(18, registroParteInteressada.getPoder());
		ps.setString(19, registroParteInteressada.getInteresse());
		ps.setString(20, registroParteInteressada.getComentario());
		ps.setObject(21, registroParteInteressada.getProjetoinicio().getCodigo());
		ps.setLong(22, registroParteInteressada.getCodigo());//Atenção: necessário para isolar o metodo (extração). 	
		
	}

	@Override
	public RegistroParteInteressada getRegistroParteInteressada(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM registroparteinteressada WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<RegistroParteInteressada> resultado = getListaRegistroParteInteressada(rs);
			
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
	public List<RegistroParteInteressada> getRegistroParteInteressadas() throws Exception {		
		   List<RegistroParteInteressada> resultado = new ArrayList<RegistroParteInteressada>();// Montar o resultado
		   
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs =null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM registroparteinteressada, projetoinicio WHERE projetoinicio = projetoinicio";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					RegistroParteInteressada registroParteInteressada = new RegistroParteInteressada();
					
					registroParteInteressada.setRegistroparteinteressada(rs.getString("registroparteinteressada"));
					registroParteInteressada.setVersao(rs.getString("versao"));
					registroParteInteressada.setData(rs.getString("data"));
					registroParteInteressada.setAutor(rs.getString("autor"));
					registroParteInteressada.setNotarevisao(rs.getString("notarevisao"));
					registroParteInteressada.setAprovacao(rs.getString("aprovacao"));
					registroParteInteressada.setCodigoparteinteressada(rs.getInt("codigoparteinteressada"));				
					registroParteInteressada.setImportancia(rs.getInt("importancia"));					
					registroParteInteressada.setParteinteressada(rs.getString("parteinteressada"));
					registroParteInteressada.setEmpresa(rs.getString("empresa"));
					registroParteInteressada.setFuncaoprojeto(rs.getString("funcaoprojeto"));
					registroParteInteressada.setEmail(rs.getString("email"));
					registroParteInteressada.setCelular(rs.getString("celular"));
					registroParteInteressada.setFone(rs.getString("fone"));
					registroParteInteressada.setRequisito(rs.getString("requisito"));
					registroParteInteressada.setResponsabilidade(rs.getString("responsabilidade"));					
					registroParteInteressada.setExpectativas(rs.getString("expectativas"));
					registroParteInteressada.setPoder(rs.getString("poder"));
					registroParteInteressada.setInteresse(rs.getString("interesse"));
					registroParteInteressada.setComentario(rs.getString("comentario"));
					registroParteInteressada.setCodigo(rs.getLong("codigo"));
					
					registroParteInteressada.getProjetoinicio().setCodigo(rs.getLong("codigo"));
					
					registroParteInteressada.getProjetoinicio().setCodigoprojeto(rs.getInt("codigoprojeto"));
					registroParteInteressada.getProjetoinicio().setProjeto(rs.getString("projeto"));					
					registroParteInteressada.getProjetoinicio().setData(rs.getDate("data"));
					registroParteInteressada.getProjetoinicio().setAtribuiprojeto(rs.getString("atribuiprojeto"));
					registroParteInteressada.getProjetoinicio().setTipoprojeto(rs.getString("tipoprojeto"));
					registroParteInteressada.getProjetoinicio().setObjetivo(rs.getString("objetivo"));
					registroParteInteressada.getProjetoinicio().setCliente(rs.getString("cliente"));
					registroParteInteressada.getProjetoinicio().setPrograma(rs.getString("programa"));
					registroParteInteressada.getProjetoinicio().setArea(rs.getString("area"));
					registroParteInteressada.getProjetoinicio().setRoi(rs.getDouble("roi"));
					registroParteInteressada.getProjetoinicio().setDescricao(rs.getString("descricao"));
					registroParteInteressada.getProjetoinicio().setCopia(rs.getString("copia"));
									
					resultado.add(registroParteInteressada);// Add o projeto ao resultado.
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
		private List<RegistroParteInteressada> getListaRegistroParteInteressada(ResultSet rs) throws SQLException	{
				List<RegistroParteInteressada> resultado = new ArrayList<RegistroParteInteressada>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				RegistroParteInteressada registroParteInteressada = new RegistroParteInteressada();
				
				registroParteInteressada.setRegistroparteinteressada(rs.getString("registroparteinteressada"));
				registroParteInteressada.setVersao(rs.getString("versao"));
				registroParteInteressada.setData(rs.getString("data"));
				registroParteInteressada.setAutor(rs.getString("autor"));
				registroParteInteressada.setNotarevisao(rs.getString("notarevisao"));
				registroParteInteressada.setAprovacao(rs.getString("aprovacao"));
				registroParteInteressada.setCodigoparteinteressada(rs.getInt("codigoparteinteressada"));				
				registroParteInteressada.setImportancia(rs.getInt("importancia"));					
				registroParteInteressada.setParteinteressada(rs.getString("parteinteressada"));
				registroParteInteressada.setEmpresa(rs.getString("empresa"));
				registroParteInteressada.setFuncaoprojeto(rs.getString("funcaoprojeto"));
				registroParteInteressada.setEmail(rs.getString("email"));
				registroParteInteressada.setCelular(rs.getString("celular"));
				registroParteInteressada.setFone(rs.getString("fone"));
				registroParteInteressada.setRequisito(rs.getString("requisito"));
				registroParteInteressada.setResponsabilidade(rs.getString("responsabilidade"));					
				registroParteInteressada.setExpectativas(rs.getString("expectativas"));
				registroParteInteressada.setPoder(rs.getString("poder"));
				registroParteInteressada.setInteresse(rs.getString("interesse"));
				registroParteInteressada.setComentario(rs.getString("comentario"));
				registroParteInteressada.setCodigo(rs.getLong("codigo"));
																
				resultado.add(registroParteInteressada);// Add o projeto ao resultado.
			}			
			return resultado;
		}	
		
		
	
}

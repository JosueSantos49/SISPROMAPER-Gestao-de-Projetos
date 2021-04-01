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
import br.com.tkcsapcd.model.bean.BusinessPlanDetalhe;
import br.com.tkcsapcd.model.util.Conexao;

public class BusinessPlanDetalheDAO implements InterfaceBusinessPlanDetalheDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public BusinessPlanDetalheDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM businessplandetalhe WHERE codigo = ?;";

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
	
	private void setPreparedStatement(BusinessPlanDetalhe businessPlanDetalhe, PreparedStatement ps) throws SQLException 
	{
		ps.setString(1, businessPlanDetalhe.getBusinessplan());
		ps.setString(2, businessPlanDetalhe.getProjeto());
		ps.setInt(3, businessPlanDetalhe.getCodigoprojeto());
		ps.setString(4, businessPlanDetalhe.getVersao());
		ps.setString(5, businessPlanDetalhe.getData());
		ps.setString(6, businessPlanDetalhe.getAutor());
		ps.setString(7, businessPlanDetalhe.getNotarevisao());
		ps.setString(8, businessPlanDetalhe.getAprovacao());
		ps.setObject(9, businessPlanDetalhe.getPosicionamento());
		ps.setString(10, businessPlanDetalhe.getEstrategiaproduto());
		ps.setString(11, businessPlanDetalhe.getProdutooferecido());		
		ps.setString(12, businessPlanDetalhe.getServicooferecido());
		ps.setString(13, businessPlanDetalhe.getPreco());
		ps.setString(14, businessPlanDetalhe.getDistribuicao());	
		ps.setString(15, businessPlanDetalhe.getPromocaovenda());
		ps.setString(16, businessPlanDetalhe.getTecnologia());
		ps.setString(17, businessPlanDetalhe.getAcao());			
		ps.setString(18, businessPlanDetalhe.getProjetoresultado());
		ps.setString(19, businessPlanDetalhe.getControle());
		ps.setString(20, businessPlanDetalhe.getContigencia());
		ps.setInt(21,businessPlanDetalhe.getCodigo());
		
	}

	@Override
	public BusinessPlanDetalhe getBusinessPlanDetalhe(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM businessplandetalhe WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<BusinessPlanDetalhe> resultado = getListaBusinessPlanDetalhe(rs);
			
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
		private List<BusinessPlanDetalhe> getListaBusinessPlanDetalhe(ResultSet rs) throws SQLException	{
			List<BusinessPlanDetalhe> resultado = new ArrayList<BusinessPlanDetalhe>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				BusinessPlanDetalhe businessPlanDetalhe = new BusinessPlanDetalhe();
					
				businessPlanDetalhe.setBusinessplan(rs.getString("businessplan"));
				businessPlanDetalhe.setProjeto(rs.getString("projeto"));
				businessPlanDetalhe.setCodigoprojeto(rs.getInt("codigoprojeto"));
				businessPlanDetalhe.setVersao(rs.getString("versao"));
				businessPlanDetalhe.setData(rs.getString("data"));
				businessPlanDetalhe.setAutor(rs.getString("autor"));
				businessPlanDetalhe.setNotarevisao(rs.getString("notarevisao"));
				businessPlanDetalhe.setAprovacao(rs.getString("aprovacao"));		
				businessPlanDetalhe.setPosicionamento(rs.getString("posicionamento"));
				businessPlanDetalhe.setEstrategiaproduto(rs.getString("estrategiaproduto"));
				businessPlanDetalhe.setProdutooferecido(rs.getString("produtooferecido"));
				businessPlanDetalhe.setServicooferecido(rs.getString("servicooferecido"));
				businessPlanDetalhe.setPreco(rs.getString("preco"));
				businessPlanDetalhe.setDistribuicao(rs.getString("distribuicao"));
				businessPlanDetalhe.setPromocaovenda(rs.getString("promocaovenda"));
				businessPlanDetalhe.setTecnologia(rs.getString("tecnologia"));					
				businessPlanDetalhe.setAcao(rs.getString("acao"));
				businessPlanDetalhe.setProjetoresultado(rs.getString("projetoresultado"));
				businessPlanDetalhe.setControle(rs.getString("controle"));
				businessPlanDetalhe.setContigencia(rs.getString("contigencia"));
				businessPlanDetalhe.setCodigo(rs.getInt("codigo"));
												
				resultado.add(businessPlanDetalhe);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(BusinessPlanDetalhe businessPlanDetalhe) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{		
			String sqlAtualizar = "UPDATE businessplandetalhe SET businessplan = ?, projeto = ?, codigoprojeto = ?, versao = ?, data = ?, autor = ?, notarevisao = ?, aprovacao = ?, posicionamento = ?, estrategiaproduto = ?, produtooferecido = ?, servicooferecido = ?, preco = ?, distribuicao = ?, promocaovenda = ?, tecnologia = ?, acao = ?, projetoresultado = ?, controle = ?, contigencia = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(businessPlanDetalhe, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
						
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
	public void salvar(BusinessPlanDetalhe businessPlanDetalhe) throws Exception {
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;
		try {
			String sqlInsert = "INSERT INTO businessplandetalhe(businessplan, projeto, codigoprojeto, versao, data, autor, notarevisao, aprovacao, posicionamento, estrategiaproduto, produtooferecido, servicooferecido, preco, distribuicao, promocaovenda, tecnologia, acao, projetoresultado, controle, contigencia)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sqlInsert);
			
			ps.setString(1, businessPlanDetalhe.getBusinessplan());
			ps.setString(2, businessPlanDetalhe.getProjeto());
			ps.setInt(3, businessPlanDetalhe.getCodigoprojeto());
			ps.setString(4, businessPlanDetalhe.getVersao());
			ps.setString(5, businessPlanDetalhe.getData());
			ps.setString(6, businessPlanDetalhe.getAutor());
			ps.setString(7, businessPlanDetalhe.getNotarevisao());
			ps.setString(8, businessPlanDetalhe.getAprovacao());
			ps.setObject(9, businessPlanDetalhe.getPosicionamento());
			ps.setString(10, businessPlanDetalhe.getEstrategiaproduto());
			ps.setString(11, businessPlanDetalhe.getProdutooferecido());		
			ps.setString(12, businessPlanDetalhe.getServicooferecido());
			ps.setString(13, businessPlanDetalhe.getPreco());
			ps.setString(14, businessPlanDetalhe.getDistribuicao());	
			ps.setString(15, businessPlanDetalhe.getPromocaovenda());
			ps.setString(16, businessPlanDetalhe.getTecnologia());
			ps.setString(17, businessPlanDetalhe.getAcao());			
			ps.setString(18, businessPlanDetalhe.getProjetoresultado());
			ps.setString(19, businessPlanDetalhe.getControle());
			ps.setString(20, businessPlanDetalhe.getContigencia());
			
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
	public List<BusinessPlanDetalhe> getBusinessPlanDetalhes() throws Exception {
		
		   List<BusinessPlanDetalhe> resultado = new ArrayList<BusinessPlanDetalhe>();// Montar o resultado
		   Connection con=null;
		   PreparedStatement ps=null;
		   ResultSet rs = null;
		try {
			con = Conexao.getConnection();
			
			String sqlSelect = "SELECT * FROM businessplandetalhe";
				
				ps = con.prepareStatement(sqlSelect);
				rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					
					BusinessPlanDetalhe businessPlanDetalhe = new BusinessPlanDetalhe();
					
					businessPlanDetalhe.setBusinessplan(rs.getString("businessplan"));
					businessPlanDetalhe.setProjeto(rs.getString("projeto"));
					businessPlanDetalhe.setCodigoprojeto(rs.getInt("codigoprojeto"));
					businessPlanDetalhe.setVersao(rs.getString("versao"));
					businessPlanDetalhe.setData(rs.getString("data"));
					businessPlanDetalhe.setAutor(rs.getString("autor"));
					businessPlanDetalhe.setNotarevisao(rs.getString("notarevisao"));
					businessPlanDetalhe.setAprovacao(rs.getString("aprovacao"));		
					businessPlanDetalhe.setPosicionamento(rs.getString("posicionamento"));
					businessPlanDetalhe.setEstrategiaproduto(rs.getString("estrategiaproduto"));
					businessPlanDetalhe.setProdutooferecido(rs.getString("produtooferecido"));
					businessPlanDetalhe.setServicooferecido(rs.getString("servicooferecido"));
					businessPlanDetalhe.setPreco(rs.getString("preco"));
					businessPlanDetalhe.setDistribuicao(rs.getString("distribuicao"));
					businessPlanDetalhe.setPromocaovenda(rs.getString("promocaovenda"));
					businessPlanDetalhe.setTecnologia(rs.getString("tecnologia"));					
					businessPlanDetalhe.setAcao(rs.getString("acao"));
					businessPlanDetalhe.setProjetoresultado(rs.getString("projetoresultado"));
					businessPlanDetalhe.setControle(rs.getString("controle"));
					businessPlanDetalhe.setContigencia(rs.getString("contigencia"));
					businessPlanDetalhe.setCodigo(rs.getInt("codigo"));
									
					resultado.add(businessPlanDetalhe);// Add o projeto ao resultado.
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

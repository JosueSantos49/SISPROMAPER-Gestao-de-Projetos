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
import br.com.tkcsapcd.model.bean.OrganogramaPropriedade;
import br.com.tkcsapcd.model.util.Conexao;

public class OrganogramaPropriedadeDAO implements InterfaceOrganogramaPropriedadeDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public OrganogramaPropriedadeDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM orgchartpropriedade WHERE codigo = ?;";

			ps = con.prepareStatement(sqlExcluir);
			ps.setInt(1, codigo);//setando
			ps.executeUpdate();
			ps.close();
		} finally 
		{
			con.close();
		}			
	}
	private void setPreparedStatement(OrganogramaPropriedade organogramaPropriedade, PreparedStatement ps) throws SQLException 
	{
		ps.setInt(1, organogramaPropriedade.getCodigoprojeto());
		ps.setDate(2, new java.sql.Date(organogramaPropriedade.getData().getTime() )); //transforma o java util date em java sql date
		ps.setString(3, organogramaPropriedade.getComentario());
		ps.setString(4, organogramaPropriedade.getMySavedModel());
		ps.setString(5, organogramaPropriedade.getDescricao());
		ps.setInt(6, organogramaPropriedade.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public OrganogramaPropriedade getOrganogramaPropriedade(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM orgchartpropriedade WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<OrganogramaPropriedade> resultado = getListaOrganogramaPropriedades(rs);
			
			if (resultado.size() > 0)			
				return resultado.get(0);//pegando elemento por chave (unico projeto!).			
			
			ps.close();			
		} finally 
		{
			con.close();
		}
		return null;
	}
	/*---------------------------------------------------------------------------------------------------------------------------------------*/

		//Metodo p confirma objetivo. Resulmir linhas de códigos, que pode ser usados em outros métodos. (ex: resultado = getListaCliente(rs); ou List<Cliente> resultado = getListaCliente(rs);)
		private List<OrganogramaPropriedade> getListaOrganogramaPropriedades(ResultSet rs) throws SQLException	{
				List<OrganogramaPropriedade> resultado = new ArrayList<OrganogramaPropriedade>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				OrganogramaPropriedade organogramaPropriedade  = new OrganogramaPropriedade();
				
				organogramaPropriedade.setCodigoprojeto(rs.getInt("codigoprojeto"));
				organogramaPropriedade.setData(rs.getDate("data"));
				organogramaPropriedade.setComentario(rs.getString("comentario"));
				organogramaPropriedade.setMySavedModel(rs.getString("mySavedModel"));
				organogramaPropriedade.setDescricao(rs.getString("descricao"));
				organogramaPropriedade.setCodigo(rs.getInt("codigo"));
												
				resultado.add(organogramaPropriedade);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(OrganogramaPropriedade organogramaPropriedade) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE orgchartpropriedade SET codigoprojeto = ?, data = ?, comentario = ?, mySavedModel = ?, descricao = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(organogramaPropriedade, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
			ps.executeUpdate();//Linha muito importante, sem ela não é executado a atualização do cliente
			ps.close();	
			
		}finally{
			con.close();
		}
		
	}

	@Override
	public void salvar(OrganogramaPropriedade organogramaPropriedade) throws Exception  {
		Connection con = Conexao.getConnection();
		PreparedStatement ps;
		try {
			String sqlInsert = "INSERT INTO orgchartpropriedade(codigoprojeto, data, comentario, mySavedModel, descricao) VALUES (?,?,?,?,?)";			

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setInt(1, organogramaPropriedade.getCodigoprojeto());
			ps.setDate(2, new java.sql.Date(organogramaPropriedade.getData().getTime() )); //transforma o java util date em java sql date
			ps.setString(3, organogramaPropriedade.getComentario());
			ps.setString(4, organogramaPropriedade.getMySavedModel());
			ps.setString(5, organogramaPropriedade.getDescricao());
			
			ps.executeUpdate();
			ps.close();

			// Pode acontecer o q/ for, que a conexao sera executada.
		} finally {
			
			con.close();//Liberar conexão
		}		
	}

	@Override
	public List<OrganogramaPropriedade> getOrganogramaPropriedades() throws Exception {
		
		   List<OrganogramaPropriedade> resultado = new ArrayList<OrganogramaPropriedade>();// Montar o resultado
		Connection con=null;
		try {
			con = Conexao.getConnection();
			PreparedStatement ps;
			String sqlSelect = "SELECT * FROM orgchartpropriedade";
				
				ps = con.prepareStatement(sqlSelect);
				ResultSet rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					
					OrganogramaPropriedade organogramaPropriedade  = new OrganogramaPropriedade();
					
					organogramaPropriedade.setCodigoprojeto(rs.getInt("codigoprojeto"));
					organogramaPropriedade.setData(rs.getDate("data"));
					organogramaPropriedade.setComentario(rs.getString("comentario"));
					organogramaPropriedade.setMySavedModel(rs.getString("mySavedModel"));
					organogramaPropriedade.setDescricao(rs.getString("descricao"));
					organogramaPropriedade.setCodigo(rs.getInt("codigo"));
									
					resultado.add(organogramaPropriedade);// Add o projeto ao resultado.
				}			
				rs.close();
				ps.close();
		} finally{
			con.close();// liberar a conexão
		}			
		return resultado;
	}
	
}

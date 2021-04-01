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
import br.com.tkcsapcd.model.bean.OrganogramaMapa;
import br.com.tkcsapcd.model.util.Conexao;

public class OrganogramaMapaDAO implements InterfaceOrganogramaMapaDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public OrganogramaMapaDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM orgchartmapa WHERE codigo = ?;";

			ps = con.prepareStatement(sqlExcluir);
			ps.setInt(1, codigo);//setando
			ps.executeUpdate();
			ps.close();
		} finally 
		{
			con.close();
		}			
	}
	private void setPreparedStatement(OrganogramaMapa organogramaMapa, PreparedStatement ps) throws SQLException 
	{
		ps.setInt(1, organogramaMapa.getCodigoprojeto());
		ps.setDate(2, new java.sql.Date(organogramaMapa.getData().getTime() )); //transforma o java util date em java sql date
		ps.setString(3, organogramaMapa.getComentario());
		ps.setString(4, organogramaMapa.getMySavedModel());
		ps.setString(5, organogramaMapa.getDescricao());
		ps.setInt(6, organogramaMapa.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public OrganogramaMapa getOrganogramaMapa(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM orgchartmapa WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<OrganogramaMapa> resultado = getListaOrganogramaMapa(rs);
			
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
		private List<OrganogramaMapa> getListaOrganogramaMapa(ResultSet rs) throws SQLException	{
				List<OrganogramaMapa> resultado = new ArrayList<OrganogramaMapa>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				OrganogramaMapa organogramaMapa  = new OrganogramaMapa();
				
				organogramaMapa.setCodigoprojeto(rs.getInt("codigoprojeto"));
				organogramaMapa.setData(rs.getDate("data"));
				organogramaMapa.setComentario(rs.getString("comentario"));
				organogramaMapa.setMySavedModel(rs.getString("mySavedModel"));
				organogramaMapa.setDescricao(rs.getString("descricao"));
				organogramaMapa.setCodigo(rs.getInt("codigo"));
												
				resultado.add(organogramaMapa);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(OrganogramaMapa organogramaMapa) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE orgchartmapa SET codigoprojeto = ?, data = ?, comentario = ?, mySavedModel = ?, descricao = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(organogramaMapa, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
			ps.executeUpdate();//Linha muito importante, sem ela não é executado a atualização do cliente
			ps.close();	
			
		}finally{
			con.close();
		}
		
	}

	@Override
	public void salvar(OrganogramaMapa organogramaMapa) throws Exception  {
		Connection con = Conexao.getConnection();
		PreparedStatement ps;
		try {
			String sqlInsert = "INSERT INTO orgchartmapa(codigoprojeto, data, comentario, mySavedModel, descricao) VALUES (?,?,?,?,?)";			

			ps = con.prepareStatement(sqlInsert);			
				
			ps.setInt(1, organogramaMapa.getCodigoprojeto());
			ps.setDate(2, new java.sql.Date(organogramaMapa.getData().getTime() )); //transforma o java util date em java sql date
			ps.setString(3, organogramaMapa.getComentario());
			ps.setString(4, organogramaMapa.getMySavedModel());
			ps.setString(5, organogramaMapa.getDescricao());
			
			ps.executeUpdate();
			ps.close();

			// Pode acontecer o q/ for, que a conexao sera executada.
		} finally {
			
			con.close();//Liberar conexão
		}		
	}

	@Override
	public List<OrganogramaMapa> getOrganogramaMapas() throws Exception {
		
		   List<OrganogramaMapa> resultado = new ArrayList<OrganogramaMapa>();// Montar o resultado
		Connection con=null;
		try {
			con = Conexao.getConnection();
			PreparedStatement ps;
			String sqlSelect = "SELECT * FROM orgchartmapa";
				
				ps = con.prepareStatement(sqlSelect);
				ResultSet rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					OrganogramaMapa organogramaMapa  = new OrganogramaMapa();
				
					organogramaMapa.setCodigoprojeto(rs.getInt("codigoprojeto"));
					organogramaMapa.setData(rs.getDate("data"));
					organogramaMapa.setComentario(rs.getString("comentario"));
					organogramaMapa.setMySavedModel(rs.getString("mySavedModel"));
					organogramaMapa.setDescricao(rs.getString("descricao"));
					organogramaMapa.setCodigo(rs.getInt("codigo"));
									
					resultado.add(organogramaMapa);// Add o projeto ao resultado.
				}			
				rs.close();
				ps.close();
		} finally{
			con.close();// liberar a conexão
		}			
		return resultado;
	}
	
}

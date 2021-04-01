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
import br.com.tkcsapcd.model.bean.Organograma;
import br.com.tkcsapcd.model.util.Conexao;

public class OrganogramaDAO implements InterfaceOrganogramaDAO{	
	
	@SuppressWarnings("unused")
	private InterfacePool pool;//ProjetoDAO solicita o pool.
	public OrganogramaDAO(InterfacePool pool) {
		super();
		this.pool = pool;
	}
	@Override
	public void excluir(Integer codigo) throws Exception  {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		
		try {
			String sqlExcluir = "DELETE FROM organograma WHERE codigo = ?;";

			ps = con.prepareStatement(sqlExcluir);
			ps.setInt(1, codigo);//setando
			ps.executeUpdate();
			ps.close();
		} finally 
		{
			con.close();
		}			
	}
	private void setPreparedStatement(Organograma organograma, PreparedStatement ps) throws SQLException 
	{		
		ps.setDate(1, new java.sql.Date(organograma.getData().getTime() )); //transforma o java util date em java sql date
		ps.setString(2, organograma.getComentario());
		ps.setString(3, organograma.getMySavedModel());
		ps.setString(4, organograma.getDescricao());
		ps.setObject(5, organograma.getProjetoinicio().getCodigo());
		ps.setLong(6, organograma.getCodigo());//Atenção: necessário para isolar o metodo (extração). 
		
	}

	@Override
	public Organograma getOrganograma(Integer codigo) throws Exception 
	{
		Connection con = Conexao.getConnection();				
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			String sqlSelect = "SELECT * FROM organograma WHERE codigo = ?;";
			ps = con.prepareStatement(sqlSelect);
			ps.setInt(1, codigo);//setando			
			rs = ps.executeQuery();
				
			List<Organograma> resultado = getListaOrganograma(rs);
			
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
		private List<Organograma> getListaOrganograma(ResultSet rs) throws SQLException	{
				List<Organograma> resultado = new ArrayList<Organograma>();
			
			// Laço p/ preencher
			while (rs.next()) {
				
				Organograma organograma  = new Organograma();
				
				//organograma.setCodigoprojeto(rs.getInt("codigoprojeto"));
				organograma.setData(rs.getDate("data"));
				organograma.setComentario(rs.getString("comentario"));
				organograma.setMySavedModel(rs.getString("mySavedModel"));
				organograma.setDescricao(rs.getString("descricao"));
				organograma.setCodigo(rs.getLong("codigo"));
												
				resultado.add(organograma);// Add o projeto ao resultado.
			}			
			return resultado;
		}

	@Override
	public void atualizar(Organograma organograma) throws Exception {
		
		Connection con = Conexao.getConnection();
		PreparedStatement ps=null;						
		try{
			String sqlAtualizar = "UPDATE organograma SET data = ?, comentario = ?, mySavedModel = ?, descricao = ?, projetoinicio = ? WHERE codigo = ?;";
			ps = con.prepareStatement(sqlAtualizar);
			setPreparedStatement(organograma, ps);//Código isolado do metodo sqlInsert, permite usar a mesma linha, facilitando!
			ps.executeUpdate();//Linha muito importante, sem ela não é executado a atualização do cliente
			ps.close();	
			
		}finally{
			con.close();
		}
		
	}

	@Override
	public void salvar(Organograma organograma) throws Exception  {
		Connection con = Conexao.getConnection();
		PreparedStatement ps;
		try {
			String sqlInsert = "INSERT INTO organograma(data, comentario, mySavedModel, descricao, projetoinicio) VALUES (?,?,?,?,?)";			

			ps = con.prepareStatement(sqlInsert);			
						
			ps.setDate(1, new java.sql.Date(organograma.getData().getTime() )); //transforma o java util date em java sql date
			ps.setString(2, organograma.getComentario());
			ps.setString(3, organograma.getMySavedModel());
			ps.setString(4, organograma.getDescricao());
			ps.setObject(5, organograma.getProjetoinicio().getCodigo());
			
			ps.executeUpdate();
			ps.close();

			// Pode acontecer o q/ for, que a conexao sera executada.
		} finally {
			
			con.close();//Liberar conexão
		}		
	}

	@Override
	public List<Organograma> getOrganogramas() throws Exception {
		
		   List<Organograma> resultado = new ArrayList<Organograma>();// Montar o resultado
		   Connection con=null;
		   
		try {
			con = Conexao.getConnection();
			PreparedStatement ps;
			String sqlSelect = "SELECT * FROM organograma, projetoinicio WHERE projetoinicio = projetoinicio";
				
				ps = con.prepareStatement(sqlSelect);
				ResultSet rs = ps.executeQuery();// ResultSet vai receber o resultado da excução da Query, consulta.
				
				//resultado = getListaProjeto(rs);					
				// Laço p/ preencher
				while (rs.next()) {
					Organograma organograma  = new Organograma();				
					
					organograma.setData(rs.getDate("data"));
					organograma.setComentario(rs.getString("comentario"));
					organograma.setMySavedModel(rs.getString("mySavedModel"));
					organograma.setDescricao(rs.getString("descricao"));
					organograma.setCodigo(rs.getLong("codigo"));
					
					organograma.getProjetoinicio().setCodigo(rs.getLong("codigo"));
					
					organograma.getProjetoinicio().setCodigoprojeto(rs.getInt("codigoprojeto"));
					organograma.getProjetoinicio().setProjeto(rs.getString("projeto"));					
					organograma.getProjetoinicio().setData(rs.getDate("data"));
					organograma.getProjetoinicio().setAtribuiprojeto(rs.getString("atribuiprojeto"));
					organograma.getProjetoinicio().setTipoprojeto(rs.getString("tipoprojeto"));
					organograma.getProjetoinicio().setObjetivo(rs.getString("objetivo"));
					organograma.getProjetoinicio().setCliente(rs.getString("cliente"));
					organograma.getProjetoinicio().setPrograma(rs.getString("programa"));
					organograma.getProjetoinicio().setArea(rs.getString("area"));
					organograma.getProjetoinicio().setRoi(rs.getDouble("roi"));
					organograma.getProjetoinicio().setDescricao(rs.getString("descricao"));
					organograma.getProjetoinicio().setCopia(rs.getString("copia"));
									
					resultado.add(organograma);// Add o projeto ao resultado.
				}			
				rs.close();
				ps.close();
		} finally{
			con.close();// liberar a conexão
		}			
		return resultado;
	}
	
}

package br.com.tkcsapcd.webservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.tkcsapcd.model.helper.ConexaoHelper;


public class Usuario2DAO {

	public boolean inserirUsuario(Usuario2 usuario2){		
		try {
			Connection con = ConexaoHelper.conectar();
			
			String queryInserir = "INSERT INTO usuario2 VALUES (null, ?, ?)";			
			PreparedStatement ps = con.prepareStatement(queryInserir);
			
			ps.setInt(1, usuario2.getIdade());
			ps.setString(2, usuario2.getNome());
			
			ps.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
		return true;
	}
	
	public boolean atualizarUsuario(Usuario2 usuario2){		
		try {
			Connection con = ConexaoHelper.conectar();
			
			String queryInserir = "UPDATE usuario2 SET nome = ?, idade = ? WHERE id = ?";			
			PreparedStatement ps = con.prepareStatement(queryInserir);
			
			ps.setString(1, usuario2.getNome());
			ps.setInt(2, usuario2.getIdade());
			ps.setInt(3, usuario2.getId());
			
			ps.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
		return true;
	}
	
	//Sobrecarga
	public boolean excluirUsuario(int id){
		return excluirUsuario(new Usuario2(id, "", 0));
	}
	
	public boolean excluirUsuario(Usuario2 usuario2){
		try {
			Connection con = ConexaoHelper.conectar();
			
			String queryInserir = "DELETE FROM usuario2 WHERE id = ?";			
			PreparedStatement ps = con.prepareStatement(queryInserir);
			
			ps.setInt(1, usuario2.getId());
			
			ps.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	public ArrayList<Usuario2> buscarTodosUsuarios(){
		
		ArrayList<Usuario2> lista = new ArrayList<Usuario2>();
		
		try {
			Connection con = ConexaoHelper.conectar();
			
			String queryInserir = "SELECT * FROM usuario2";			
			PreparedStatement ps = con.prepareStatement(queryInserir);			
				
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Usuario2 usuario2 = new Usuario2();
				
				usuario2.setId(rs.getInt(1));				
				usuario2.setIdade(rs.getInt(2));
				usuario2.setNome(rs.getString(3));
				
				lista.add(usuario2);				
			}
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}				
		
		return lista;
		
	}
	
	public Usuario2 buscarUsuarioPorId (int id){
		
		Usuario2 usuario2 = null;
		
		try {
			Connection con = ConexaoHelper.conectar();
			
			String queryInserir = "SELECT * FROM usuario2 WHERE id = ?";			
			PreparedStatement ps = con.prepareStatement(queryInserir);			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				usuario2 = new Usuario2();
				
				usuario2.setId(rs.getInt(1));
				usuario2.setNome(rs.getString(2));
				usuario2.setIdade(rs.getInt(3));
			}else{
				return usuario2;
			}
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}				
		return usuario2;
	}
}

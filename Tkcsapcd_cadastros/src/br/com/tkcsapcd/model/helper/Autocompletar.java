package br.com.tkcsapcd.model.helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Autocompletar {

	public ArrayList<String> getCodigoprojeto(String find){
		   ArrayList<String> resultado = new ArrayList<>();
		   PreparedStatement ps = null;
		   ResultSet rs = null;
		   
		   try{
			   
			   String sql = "select codigoprojeto from projetoinicio where codigoprojeto like ? limit 10";
			   ps = ConexaoHelper.conectar().prepareStatement(sql);
			   ps.setString(1, find+"%");
			   rs = ps.executeQuery();
			   
			   System.out.println("Autocompletar 1 execução sql rs = ps.executeQuery(): "+rs);
			   
			   while(rs.next()){
				   resultado.add(rs.getString("codigoprojeto"));
				   System.out.println("Autocompletar 2 execução do while(rs.next()): "+resultado);
			   }
			   
		   }catch(Exception e){			   
		   }finally{
			   try {
				   	if(ConexaoHelper.conectar() != null) ConexaoHelper.conectar().close();
				   	if(rs != null) rs.close();
				   	if(ps != null) ps.close();
			} catch (Exception e2) {
			}
		   }
		   return resultado;
	}

}

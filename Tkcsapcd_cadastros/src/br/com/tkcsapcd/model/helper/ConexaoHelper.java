/*	
  	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
*/
package br.com.tkcsapcd.model.helper;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConexaoHelper {

public static Connection conectar() throws Exception{
       
	InitialContext context = new InitialContext();
	DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/pool");
	
	try {
		
		return ds.getConnection();
		
	} catch (SQLException e) {
		throw new Exception(e.getMessage());
	}
	}
}





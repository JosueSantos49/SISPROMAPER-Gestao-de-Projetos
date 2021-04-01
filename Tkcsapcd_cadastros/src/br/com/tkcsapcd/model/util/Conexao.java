/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Conexao {
	
	public static Connection getConnection() throws Exception {
		
		InitialContext context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/pool");
		
		try {
			
			return ds.getConnection();
			
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
}

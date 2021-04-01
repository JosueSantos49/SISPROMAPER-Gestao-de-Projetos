/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.conexao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

public interface InterfaceDataSource {
	
	//Apenas 1 metodo. Definir conexao.
	public abstract Connection getConnection() throws SQLException, NamingException;
	
}

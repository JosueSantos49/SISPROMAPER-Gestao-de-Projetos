/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.conexao;

import java.sql.Connection;

import javax.naming.NamingException;

public interface InterfacePool {
		
		public abstract Connection getConnection() throws NamingException;//Retorna conexao para o pool
		public void liberarConnection(Connection con);//Libera a conexão
}

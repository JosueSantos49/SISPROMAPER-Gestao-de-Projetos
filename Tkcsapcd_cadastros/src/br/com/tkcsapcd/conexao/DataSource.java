/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.NamingException;

public class DataSource implements InterfaceDataSource {

	private String url;
	@SuppressWarnings("unused")
	private String driver;
	private String usuario;
	private String senha;
	
	//Construtor
	public DataSource(String url, String driver, String usuario, String senha)
	{
		super();
		this.url = url;
		this.driver = driver;
		this.usuario = usuario;
		this.senha = senha;
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Classe n�o encontrada!");
			e.printStackTrace();
		}
	}
			
	@Override
	public Connection getConnection() throws SQLException, NamingException {
				
		return DriverManager.getConnection(url, usuario, senha); //Conex�o original		
	}

}

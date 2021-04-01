/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;

import javax.naming.NamingException;

/* 
 Pool respons�vel por fazer  a gerencia das conex�es, informa quantas est�o livres.
 Determina um numero m�ximo de conex�es que o sistemas vai suportar (arquivo externo bancodedados.properties).
 */
public class Pool implements InterfacePool {

	private InterfaceDataSource dataSource;
	private ArrayBlockingQueue<Connection> conexoesLivres;// Pilhas de conex�es
	private HashMap<String, Connection> conexoesUtilizadas;
	private Integer numeroMaximoConexoes;
	private ResourceBundle config;// adiciona as config. adicionadas no arquivo
								  // mysql.properties
	// Construtor
	public Pool() {
		
		config		= ResourceBundle.getBundle("br.com.tkcsapcd.conexao.bancodedados");// Capiturar os valores do arquivo		
		dataSource 	= new DataSource(config.getString("url"),
									 config.getString("driver"), 
									 config.getString("usuario"),
									 config.getString("senha"));

		numeroMaximoConexoes = Integer.parseInt(config.getString("numeroMaximoConexoes"));//numeros maximos de conexoes
		
		//Instanciando o objeto 
		conexoesLivres 		= new ArrayBlockingQueue<Connection>(numeroMaximoConexoes, true);
		conexoesUtilizadas 	= new HashMap<String, Connection>();
	}	
	
	@Override
	public Connection getConnection() throws NamingException {
		   	
		Connection con = null;		   	
			
		try {
						
			// Pega o primeiro elemento da fila e remove.
			if (conexoesUtilizadas.size() < numeroMaximoConexoes) {
				con = conexoesLivres.poll();
				
				if (con == null)				
					
					con = dataSource.getConnection();//Original: Va no DataSource e solicita uma conexao.

				else if (con.isClosed()) {
					this.getConnection();
				}
				conexoesUtilizadas.put(con.toString(), con);// adciona conexao

			}
		} catch (SQLException e) {
			System.out.println("Problemas com o pool!");
			e.printStackTrace();
		}
		return con;
	}
	@Override
	public void liberarConnection(Connection con) {
				
			conexoesLivres.add(con); System.out.println("Linha executada: conexoesLivres!");			
			conexoesUtilizadas.remove(con.toString());	System.out.println("Linha executada: conexoesUtilizadas remove!");		

			
	}
}

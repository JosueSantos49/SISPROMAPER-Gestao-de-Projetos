/*	
  	Autor: Josue da Conceicao Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
*/
package br.com.tkcsapcd.model.helper;

/**
 *
 * @author Josue da Conceicao Santos
 */
public final class Config {
       
    //Configure seu banco de dados;
	private static final String NOME_DRIVER = "com.mysql.jdbc.Driver";
	
	private static final String HOST_PORTA = "jdbc:mysql://localhost/sispro_tkcsapcd?autoReconnect=true";
    private static final String NOME_BANCO_DADOS = "sispro_tkcsapcd";
    private static final String NOME_USUARIO_BANCO = "sispro_roottkcsa";
    private static final String SENHA_USUARIO_BANCO = "josuerj49conceicao88";
    
    //Metodos que retornam dados do banco;
    public static String getDriver(){
    	return NOME_DRIVER;
    }
    public static String getHost(){
        return HOST_PORTA;
    }
    
    public static String getNomeBanco(){
        return NOME_BANCO_DADOS;
    }
    
    public static String getUsuarioBanco(){
        return NOME_USUARIO_BANCO;
    }
    
    public static String getSenhaBanco(){
        return SENHA_USUARIO_BANCO;
    }       
    
}
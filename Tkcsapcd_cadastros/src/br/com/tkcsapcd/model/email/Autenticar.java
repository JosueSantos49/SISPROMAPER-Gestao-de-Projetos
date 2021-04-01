/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.email;

import javax.mail.*;

public class Autenticar extends Authenticator {
	private String usuario;
	private String senha;
	
	public Autenticar(){}
	
	public Autenticar(String usuario, String senha){
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public PasswordAuthentication getPasswordAuthentication(){
		return new PasswordAuthentication(usuario,senha);	
	}
}

/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Metodo que * Retorna a p�gina principal *
 * Se digitar o edere�o abaixo, ser� redirecionado para pagina prinipal do Sistema * 
 * http://localhost:8081/Tkcsapcd_cadastros/TkcsapcdController
 */
public class IniciarTkcsapcd implements InterfaceCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		/* 		 
		 * Servlet receber a requisi��o, passa p/ Helper que chama IniciarTkcsapcd,
		 * que retorna a pagina cadastro_principal 
		 * 
		 * Cadastre essa p�gina no TkcsapcdController!!!!
		 */
		return "index.jsp";
	}

}

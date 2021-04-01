/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Metodo que * Retorna a página principal *
 * Se digitar o edereço abaixo, será redirecionado para pagina prinipal do Sistema * 
 * http://localhost:8081/Tkcsapcd_cadastros/TkcsapcdController
 */
public class IniciarTkcsapcd implements InterfaceCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		/* 		 
		 * Servlet receber a requisição, passa p/ Helper que chama IniciarTkcsapcd,
		 * que retorna a pagina cadastro_principal 
		 * 
		 * Cadastre essa página no TkcsapcdController!!!!
		 */
		return "index.jsp";
	}

}

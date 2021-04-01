/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.util;

public class Valida{
	
	public static void validasessao(){
		
		String acesso=null;//sessao	
		//HttpSession session = null;
		//acesso = (String) session.getAttribute("login");
		try{			
			if (acesso==null){
				acesso = "00";
				@SuppressWarnings("unused")
				String redirectURL = "login.jsp";
				}			
		}catch (Exception e){
			System.out.println("Erro ao validar: " + e);
		}
	}
}



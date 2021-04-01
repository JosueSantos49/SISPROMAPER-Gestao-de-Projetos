/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.email.EnviaEmail;
/**
 * Servlet implementation class Enviar
 */
@WebServlet("/EnviarController")
public class EnviarController extends HttpServlet {
	private static final long serialVersionUID = 1L;       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Regra que objetiva disparar um e-mail automático como confirmação de registro.
		String de 		= request.getParameter("de");
		String para 	= request.getParameter("para");
		String assunto 	= request.getParameter("assunto");
		String mensagem = request.getParameter("mensagem");
		String lista 	= request.getParameter("lista");
		//String file		= request.getParameter("file");
				
		RequestDispatcher rd = null;
		
		EnviaEmail enviaEmail = new EnviaEmail();
		
			enviaEmail.setDe(de);
			enviaEmail.setPara(para);
			enviaEmail.setAssunto(assunto);
			enviaEmail.setMensagem(mensagem);			
			enviaEmail.setLista(lista);		
			//enviaEmail.setFile(file);
		
		boolean enviado = enviaEmail.enviar();		
		
		if(enviado)
			request.setAttribute("msg","Enviado confirmação de registro por e-mail!");
		else
			request.setAttribute("msg","Não, enviado cópia de confirmação de registro por e-mail!");				
		
		rd = request.getRequestDispatcher("/enviado.jsp");
		rd.forward(request, response);		
	}
}

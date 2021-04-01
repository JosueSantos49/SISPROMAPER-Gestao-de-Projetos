/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.command.InterfaceCommand;
import br.com.tkcsapcd.model.helper.TkcsapcdHelper;

/**
 * Servlet implementation class TkcsapcdController
 */
@WebServlet("/TkcsapcdController")
public class TkcsapcdController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;	
	private TkcsapcdHelper tkcsapcdHelper = new TkcsapcdHelper();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TkcsapcdController() {
		super();		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		// Metodo processar requisição
		try {			
			
			processarRequisicao(request, response);
					
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void processarRequisicao(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.setContentType("text/html; charset=ISO-8859-1");
		tkcsapcdHelper.setResquest(request);//Em vez de ficar criando tkcsapcdHelper, criar uma variável do servlet 
		InterfaceCommand comando = tkcsapcdHelper.getCommand();// Retorna um objeto		
		String pagina = comando.execute(request, response);// Executa, pagina de destino.		
		request.getRequestDispatcher(pagina).include(request, response);// Reriderionar
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Metodo processar requisição
		try {
			processarRequisicao(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

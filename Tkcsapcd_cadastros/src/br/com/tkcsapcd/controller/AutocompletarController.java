/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.controller;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.helper.Autocompletar;

import com.google.gson.Gson;

/**
 * Servlet implementation class AutocompletarController
 */
@WebServlet("/AutocompletarController")
public class AutocompletarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutocompletarController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {
    	
		response.setContentType("text/html; charset=ISO-8859-1");
		String find = request.getParameter("codigoprojeto").toUpperCase(); //Capiturando o valor digitado 
		System.out.println("Fin Servlet AutocompletarController valor capiturado digitado: "+find);
		ArrayList<String> resultado = new Autocompletar().getCodigoprojeto(find);		
		String json = new Gson().toJson(resultado);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
				
	}
 // independente do métopdo http, o processRequest é chamado.
    @Override  
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
    @Override  
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

}

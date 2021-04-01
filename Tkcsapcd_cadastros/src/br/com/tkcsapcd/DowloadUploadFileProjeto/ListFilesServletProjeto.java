/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.DowloadUploadFileProjeto;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.FileBeanProjeto;
import br.com.tkcsapcd.model.dao.FileProjetoDAO;

/**
 * Servlet implementation class ListFilesServlett
 */
@WebServlet("/ListFilesServletProjeto")
public class ListFilesServletProjeto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListFilesServletProjeto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=ISO-8859-1");
		try {
			
			FileProjetoDAO dao = new FileProjetoDAO();
			List<FileBeanProjeto> files = dao.list();
			request.setAttribute("items", dao.list());
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("Erro ao listar file ajuda da classe doGet ListFilesServletProjeto: "+e);
		}


		RequestDispatcher rd = request.getRequestDispatcher("list_ajuda.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.DowloadUploadFile;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.FileBeanAjuda;
import br.com.tkcsapcd.model.dao.FileAjudaDAO;

/**
 * Servlet implementation class ListFilesServlett
 */
@WebServlet("/ListFilesServletAjuda")
public class ListFilesServletAjuda extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListFilesServletAjuda() {
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
			FileAjudaDAO dao = new FileAjudaDAO();
			List<FileBeanAjuda> files = dao.list();
			request.setAttribute("items", dao.list());
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("Erro ao listar file ajuda da classe doGet ListFilesServletAjuda: "+e);
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

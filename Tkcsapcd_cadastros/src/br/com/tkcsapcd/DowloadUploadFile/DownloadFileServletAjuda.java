/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.DowloadUploadFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.conexao.InterfacePool;
import br.com.tkcsapcd.model.bean.FileBeanAjuda;
import br.com.tkcsapcd.model.dao.FileAjudaDAO;

/**
 * Servlet implementation class DownloadFileServlet
 */
@WebServlet("/DownloadFileServletAjuda")
public class DownloadFileServletAjuda extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DownloadFileServletAjuda() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=ISO-8859-1");
		InterfacePool pool = null;//ProjetoDAO solicita o pool.
				
		String idStr = request.getParameter("id");
		if (idStr == null) {
			// redirect to home or other
		}

		FileAjudaDAO dao = new FileAjudaDAO(pool);
		Long id = Long.parseLong(idStr);
		FileBeanAjuda filebeanajuda = null;
		try {
			filebeanajuda = dao.getFile(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (filebeanajuda != null) {
			ServletContext context = getServletConfig().getServletContext();
			String mimetype = context.getMimeType(filebeanajuda.getName());

			response.setContentLength(filebeanajuda.getData().length);
			response.setContentType(mimetype);
			// resp.setContentType("image/jpeg");

			response.setHeader("Content-Disposition", "attachment; filename=\""
					+ filebeanajuda.getName() + "\"");

			OutputStream out = response.getOutputStream();
			InputStream in = new ByteArrayInputStream(filebeanajuda.getData());
			byte[] buffer = new byte[4096];
			int length;
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}
			in.close();
			out.flush();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

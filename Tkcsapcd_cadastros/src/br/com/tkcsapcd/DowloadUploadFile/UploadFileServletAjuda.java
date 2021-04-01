/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.DowloadUploadFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import br.com.tkcsapcd.model.bean.FileBeanAjuda;
import br.com.tkcsapcd.model.dao.FileAjudaDAO;

/**
 * Servlet implementation class UploadFileServlett
 */
@WebServlet("/UploadFileServletAjuda")
public class UploadFileServletAjuda extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadFileServletAjuda() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@SuppressWarnings("rawtypes")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=ISO-8859-1");
		DiskFileItemFactory dfif = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(dfif);

		if (!ServletFileUpload.isMultipartContent(request)) {
			// tratar erro
		}

		try {

			List items = sfu.parseRequest(request);

			// a posicao 0 corresponde ao primeiro campo input do formulario
			// (descricao)
			FileItem descFI = (FileItem) items.get(0);
			String description = descFI.getString();

			// a posicao 1 corresponde ao segundo campo input do formulario
			// (arquivo)
			FileItem fileFI = (FileItem) items.get(1);
			byte[] bytes = read(fileFI);

			// Não é o File do Java. É um JavaBeanAjuda apresentado a seguir
			FileBeanAjuda filebeanajuda = new FileBeanAjuda();

			filebeanajuda.setDescription(description);
			filebeanajuda.setName(fileFI.getName());
			filebeanajuda.setData(bytes);

			FileAjudaDAO fdao = new FileAjudaDAO();
			fdao.add(filebeanajuda);

		} catch (FileUploadException e) {
			// tratar erro
			e.printStackTrace();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("TkcsapcdController?cmd=consultarFilebeanAjuda");
	}

	private byte[] read(FileItem fi) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		InputStream is = fi.getInputStream();
		int read = 0;
		final byte[] b = new byte[1024];

		while ((read = is.read(b)) != -1) {
			out.write(b, 0, read);
		}
		return out.toByteArray();
	}

}

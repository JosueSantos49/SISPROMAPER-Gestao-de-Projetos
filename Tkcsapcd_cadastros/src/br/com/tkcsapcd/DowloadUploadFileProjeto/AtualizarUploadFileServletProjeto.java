/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.DowloadUploadFileProjeto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import br.com.tkcsapcd.model.bean.FileBeanProjeto;
import br.com.tkcsapcd.model.dao.FileProjetoDAO;
import br.com.tkcsapcd.model.email.EnviaEmail;
import br.com.tkcsapcd.model.helper.ValidationHelper;

/**
 * Servlet implementation class UploadFileServlett
 */
@WebServlet("/AtualizarUploadFileServletProjeto")
public class AtualizarUploadFileServletProjeto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AtualizarUploadFileServletProjeto() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException {

		response.setContentType("text/html; charset=ISO-8859-1");
		DiskFileItemFactory dfif = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(dfif);

		if (!ServletFileUpload.isMultipartContent(request)) {
			// tratar erro
		}

		try {
					
			List items = sfu.parseRequest(request);
			
			// a posicao 0 corresponde a ordem de campo input do formulario (descricao)
			FileItem descFI = (FileItem) items.get(0);
			String description = descFI.getString();

			// a posicao 1 corresponde a ordem de campo input do formulario (arquivo)
			FileItem fileFI = (FileItem) items.get(1);
			byte[] bytes = read(fileFI);
			
			FileItem codprojeto = (FileItem) items.get(2);
			String codigoprojeto = codprojeto.getString();
			
			FileItem comentarios = (FileItem) items.get(3);
			String comentario = comentarios.getString();
			
			FileItem dataregistros = (FileItem) items.get(4);	
			String dataregistro_1 = dataregistros.getString();
			Date dataregistro = new SimpleDateFormat("yyyy-MM-dd").parse(dataregistro_1);
			
			FileItem emais = (FileItem) items.get(5);
			String email = emais.getString();			
			
			// Não é o File do Java. É um JavaBeanProjeto apresentado a seguir
			FileBeanProjeto filebeanprojeto = new FileBeanProjeto();
			
			filebeanprojeto.setDescription(description);//descricao
			filebeanprojeto.setName(fileFI.getName());//nome do arquivo
			filebeanprojeto.setData(bytes);	//arquivo
			filebeanprojeto.setCodigoprojeto(Integer.parseInt(codigoprojeto));
			filebeanprojeto.setComentario(comentario);			
			filebeanprojeto.setDataregistro(dataregistro);			
			filebeanprojeto.setEmail(email);
			
			FileProjetoDAO fdao = new FileProjetoDAO();	
			
			if(ValidationHelper.validar(filebeanprojeto)){	
				fdao.atualizar(filebeanprojeto);
			}else{
				throw new Exception("Valor inválido");
			}
			
			/*Regra que objetiva disparar um e-mail automático como confirmação de registro.
			 * O Metodo enviarForm() é responsável, por enviar e-mail de confirmação de envio de formulários.
			 */
					
			RequestDispatcher rd = null;
			
			EnviaEmail enviaEmail = new EnviaEmail();
			
				//enviaEmail.setDe(de);
				enviaEmail.setPara(email);
				enviaEmail.setAssunto(description);
				enviaEmail.setMensagem(comentario);			
				//enviaEmail.setLista(lista);		
				//enviaEmail.setFile(file);
			
			boolean enviado = enviaEmail.enviarForm();		
			
			if(enviado)
				request.setAttribute("msg","Enviado confirmação de registro por e-mail!");
			else
				request.setAttribute("msg","Não, enviado cópia de confirmação de registro por e-mail!");				
			
			rd = request.getRequestDispatcher("TkcsapcdController?cmd=consultarFilebeanProjeto");
			rd.forward(request, response);			
			

		} catch (FileUploadException e) {
			// tratar erro
			e.printStackTrace();
			
		} catch (Exception e) {
			request.setAttribute("mensagem", "Problema com a atualização: "+e.getMessage());
			e.printStackTrace();
		}
		request.setAttribute("titulo", "Atualização - File Projeto");
		response.sendRedirect("TkcsapcdController?cmd=consultarFilebeanProjeto");
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

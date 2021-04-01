/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import br.com.tkcsapcd.model.bean.FileBeanProjeto;
import br.com.tkcsapcd.model.dao.FileProjetoDAO;
import br.com.tkcsapcd.model.dao.InterfaceFileBeanProjetoDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarFileBeanProjeto implements InterfaceCommand {
	
	private InterfaceFileBeanProjetoDAO fileBeanProjetoDAO;
	public AtualizarFileBeanProjeto(InterfaceFileBeanProjetoDAO fileBeanProjetoDAO) {
		super();
		this.fileBeanProjetoDAO = fileBeanProjetoDAO;
	}	
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
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
						int codigoprojeto = Integer.valueOf(codprojeto.getString());
						
						FileItem comentarios = (FileItem) items.get(3);
						String comentario = comentarios.getString();
						
						FileItem dataregistros = (FileItem) items.get(4);	
						String dataregistro_1 = dataregistros.getString();
						Date dataregistro = new SimpleDateFormat("dd/MM/yyyy").parse(dataregistro_1);
						
						FileItem emais = (FileItem) items.get(5);
						String email = emais.getString();
						
						
						// Não é o File do Java. É um JavaBeanProjeto apresentado a seguir
						FileBeanProjeto filebeanprojeto = new FileBeanProjeto();
						
						//filebeanprojeto.setId(id);
						filebeanprojeto.setDescription(description);//descricao
						filebeanprojeto.setName(fileFI.getName());//nome do arquivo
						filebeanprojeto.setData(bytes);	//arquivo
						filebeanprojeto.setCodigoprojeto(codigoprojeto);
						filebeanprojeto.setComentario(comentario);			
						filebeanprojeto.setDataregistro(dataregistro);			
						filebeanprojeto.setEmail(email);
						
						FileProjetoDAO fdao = new FileProjetoDAO();
						fdao.atualizar(filebeanprojeto);
		
		if(ValidationHelper.validar(filebeanprojeto)){			
			fileBeanProjetoDAO.atualizar(filebeanprojeto);
			request.setAttribute("mensagem", "File Projeto: ("+filebeanprojeto.getCodigoprojeto()+") atualizado com sucesso!");
		}
		else{
			throw new Exception("Valor inválido");
		}	
		} catch (SQLException e) {
			
			request.setAttribute("mensagem", "Problema com a atualização: "+e.getMessage());
			e.printStackTrace();
			
		}catch (NumberFormatException e) {
			request.setAttribute("mensagem", "Valor inválido: "+e.getMessage());			
		}	
			request.setAttribute("titulo", "Atualização - File Projeto");
			return "TkcsapcdController?cmd=consultarFilebeanProjeto";//Pagina de Retorno (pagina consulta)
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

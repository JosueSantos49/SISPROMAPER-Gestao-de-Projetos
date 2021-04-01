/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceFileBeanProjetoDAO;

public class EditarFileBeanProjeto implements InterfaceCommand {

	private InterfaceFileBeanProjetoDAO fileBeanProjetoDAO;
	public EditarFileBeanProjeto(InterfaceFileBeanProjetoDAO fileBeanProjetoDAO) {
		super();
		this.fileBeanProjetoDAO = fileBeanProjetoDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception {			
			try{						
					if(request.getParameter("id") == null)
					{
						request.setAttribute("titulo", "Cadastro - File Projeto");
						return "upload_projeto.jsp";
					}
					
					//Grande jogada				
					request.setAttribute("fileBeanProjeto", fileBeanProjetoDAO.getFileBeanProjeto(Integer.valueOf(request.getParameter("id"))));
					
					} catch (NumberFormatException e) {
						
						// Se o numero não for válido
						request.setAttribute("mensagem", "Valo do código inválido:"+request.getParameter("id"));
						
					} catch (SQLException e) {
						 
						request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
						e.printStackTrace();
					}				
						//Caso funcione td corretamente. Seta o atributo
						request.setAttribute("titulo", "Atualização - File Projeto");
						return "atualiza_upload_projeto.jsp"; //
			}
	}

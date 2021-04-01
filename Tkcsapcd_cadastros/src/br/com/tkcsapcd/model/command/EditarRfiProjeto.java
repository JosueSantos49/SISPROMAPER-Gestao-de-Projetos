/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceRfiProjetoDAO;

public class EditarRfiProjeto implements InterfaceCommand {

	private InterfaceRfiProjetoDAO rfiProjetoDAO;
	
	public EditarRfiProjeto(InterfaceRfiProjetoDAO rfiProjetoDAO) {
		super();
		this.rfiProjetoDAO = rfiProjetoDAO;
	}

	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception {
	
		try {
				
				if(request.getParameter("codigo") == null)
				{
					request.setAttribute("titulo", "Cadastro - RFI Projeto");
					return "cadastro_rfiprojeto.jsp";
				}
				
				//Grande jogada
				request.setAttribute("rfiprojeto", rfiProjetoDAO.getRfiProjeto(Integer.valueOf(request.getParameter("codigo"))));
				
				}catch(NumberFormatException e){
					
					request.setAttribute("mensagem", "Valo do c�digo inv�lido:"+request.getParameter("codigo"));
							
				} catch (SQLException e) { //Aten��o por pad�o todas os Editar esta como SQLException, mas nesta linha da erro sempre!!!
					
					request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
					e.printStackTrace();				
				}
				request.setAttribute("titulo", "Atualiza��o - RFI Projeto");
				return "atualiza_rfiprojeto.jsp";
		
	}
}

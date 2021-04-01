/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceRfiProjetoDAO;

public class ConsultarRfiProjeto implements InterfaceCommand {

	private InterfaceRfiProjetoDAO rfiProjetoDAO;
		
	public ConsultarRfiProjeto(InterfaceRfiProjetoDAO rfiProjetoDAO) {
		super();
		this.rfiProjetoDAO = rfiProjetoDAO;
	}

	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response) throws SQLException {
	
				request.setAttribute("titulo", "Consultar - RFI Projeto");
		
		try {							
				request.setAttribute("rfiProjetos", rfiProjetoDAO.getRfiProjeto());
				
			} catch (Exception e) 
			{				
				request.setAttribute("mensagem", "Problema com acesso a base de dados!");//Caso aja problema, será executado MSN informando!
				e.printStackTrace();
			}				
			return "consulta_rfiprojeto.jsp";//se não ouver erro, retorne a pagina 			
		}
			//Deve cadastrar o comando no TkcsapcdHelper!!!!!

}

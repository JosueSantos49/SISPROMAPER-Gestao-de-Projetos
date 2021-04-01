/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceAcompanhamentoProjetoDAO;

public class ConsultarAcompanhamentoProjeto implements InterfaceCommand {

	private InterfaceAcompanhamentoProjetoDAO acompanhamentoProjetoDAO;
	
	public ConsultarAcompanhamentoProjeto(InterfaceAcompanhamentoProjetoDAO acompanhamentoProjetoDAO) {
		super();
		this.acompanhamentoProjetoDAO = acompanhamentoProjetoDAO;
	}

	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response) throws SQLException {
		request.setAttribute("titulo", "Consultar - ACOMPANHAMENTO DO PROJETO");
		
		try {							
				request.setAttribute("acompanhamentoProjetos", acompanhamentoProjetoDAO.getAcompanhamentoProjetos());
				
			} catch (Exception e) 
			{				
				request.setAttribute("mensagem", "Problema com acesso a base de dados!");//Caso aja problema, será executado MSN informando!
				e.printStackTrace();
			}				
			return "consulta_acompanhamento_projeto.jsp";//se não ouver erro, retorne a pagina 			
		}
			//Deve cadastrar o comando no TkcsapcdHelper!!!!!

}

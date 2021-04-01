/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceIssuesLogDAO;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;

public class EditarIssuesLog implements InterfaceCommand {

	private InterfaceIssuesLogDAO issuesLogDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	public EditarIssuesLog(InterfaceIssuesLogDAO issuesLogDAO, InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.issuesLogDAO = issuesLogDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception  {			
			try{						
				//Setando o atributo projetosInicio, para listar no select da pagina cadastro.
				request.setAttribute("projetoInicios", projetoInicioDAO.getProjetoInicios());
				
					if(request.getParameter("codigo") == null)
					{
						request.setAttribute("titulo", "Cadastro - ISSUES LOG (Registro das questões)");
						return "cadastro_issues_log.jsp";
					}
					
					//Grande jogada				
					request.setAttribute("issuesLog", issuesLogDAO.getIssuesLog(Integer.valueOf(request.getParameter("codigo"))));
					
					} catch (NumberFormatException e) {
						
						// Se o numero não for válido
						request.setAttribute("mensagem", "Valo do código inválido:"+request.getParameter("codigo"));
						
					} catch (SQLException e) {
						 
						request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
						e.printStackTrace();
					}				
						//Caso funcione td corretamente. Seta o atributo
						request.setAttribute("titulo", "Atualização - ISSUES LOG (Registro das questões)");				
						return "atualiza_issues_log.jsp";
			}
	}

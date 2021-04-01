/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;

public class EditarProjetoInicio implements InterfaceCommand {

	private InterfaceProjetoInicioDAO projetoInicioDAO;
	public EditarProjetoInicio(InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception {			
			try{						
					if(request.getParameter("codigo") == null)
					{
						request.setAttribute("titulo", "Cadastro - Novo Projeto");
						return "modal_ajax_principal.jsp";
					}
					
					//Grande jogada				
					request.setAttribute("projetoInicio", projetoInicioDAO.getProjetoInicio(Integer.valueOf(request.getParameter("codigo"))));
					
					} catch (NumberFormatException e) {
						
						// Se o numero não for válido
						request.setAttribute("mensagem", "Valo do código inválido:"+request.getParameter("codigo"));
						
					} catch (SQLException e) {
						 
						request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
						e.printStackTrace();
					}				
						//Caso funcione td corretamente. Seta o atributo
						request.setAttribute("titulo", "Atualização - Projeto");				
						//return "menu_sugerido_principal_atualiza.jsp";//Atualizar projeto
						//return "modal_ajax_principal_atualiza.jsp"; //duvida
						return "atualiza_projeto_inicio.jsp"; //duvida
			}
	}

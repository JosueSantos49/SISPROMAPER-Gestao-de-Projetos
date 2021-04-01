/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceBusinessPlanDetalheDAO;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;

public class EditarBusinessPlanDetalhe implements InterfaceCommand {

	private InterfaceBusinessPlanDetalheDAO businessPlanDetalheDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	public EditarBusinessPlanDetalhe(InterfaceBusinessPlanDetalheDAO businessPlanDetalheDAO, InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.businessPlanDetalheDAO = businessPlanDetalheDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception  {			
			try{				
				//Setando o atributo projetosInicio, para listar no select da pagina cadastro.
				request.setAttribute("projetoInicios", projetoInicioDAO.getProjetoInicios());
				
					if(request.getParameter("codigo") == null)
					{
						request.setAttribute("titulo", "Cadastro - BUSINESS PLAN DETALHES");
						return "cadastro_business_plan_detalhe.jsp";
					}
					
					//Grande jogada				
					request.setAttribute("businessPlanDetalhe", businessPlanDetalheDAO.getBusinessPlanDetalhe(Integer.valueOf(request.getParameter("codigo"))));
					
					} catch (NumberFormatException e) {
						
						// Se o numero não for válido
						request.setAttribute("mensagem", "Valo do código inválido:"+request.getParameter("codigo"));
						
					} catch (SQLException e) {
						 
						request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
						e.printStackTrace();
					}				
						//Caso funcione td corretamente. Seta o atributo
						request.setAttribute("titulo", "Atualização - BUSINESS PLAN DETALHES");				
						return "atualiza_business_plan_detalhe.jsp";
			}
	}

/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceBusinessPlanDAO;

public class ConsultarBusinessPlan implements InterfaceCommand {
	
	private InterfaceBusinessPlanDAO businessPlanDAO;
	public ConsultarBusinessPlan(InterfaceBusinessPlanDAO businessPlanDAO) {
		super();
		this.businessPlanDAO = businessPlanDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
			
				request.setAttribute("titulo", "Consultar - BUSINESS PLAN");//Processamento que ser� executado pelo comando

			try {
				/*Aten��o aqui pelo amor de DEUS
				 * 
				 * <%			
						String style ="'color: navy; text-align: center; font-size: small;'";				
						List<Statuss> statusss = (List<Statuss>) request.getAttribute("statusss");//Esta linha � braba, rsrsrsr... 20 dias para encontra um erro.
						for(Statuss statuss: statusss ){
			 		%>				 
				 * 
				 */
				request.setAttribute("businessPlans", businessPlanDAO.getBusinessPlans());//atributo recuperado no consulta_statuss.jsp
			
			}catch (Exception e) 
			{			
				request.setAttribute("mensagem", "Problema com acesso a base de dados!");//Caso aja problema, ser� executado MSN informando!
				e.printStackTrace();
			}			 
			return "consulta_business_plan.jsp";//se n�o ouver erro, retorne a pagina.
	}
	//Deve cadastrar o comando no TkcsapcdHelper!!!!!

}

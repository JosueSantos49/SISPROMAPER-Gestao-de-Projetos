/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfacePlanoGerenciamentoRequisitoDAO;
import br.com.tkcsapcd.model.dao.ProjetoInicioDAO;

public class ConsultarPlanoGerenciamentoRequisito implements InterfaceCommand {
	
	private InterfacePlanoGerenciamentoRequisitoDAO planoGerenciamentoRequisitoDAO;
	private ProjetoInicioDAO projetoInicioDAO;
	public ConsultarPlanoGerenciamentoRequisito(InterfacePlanoGerenciamentoRequisitoDAO planoGerenciamentoRequisitoDAO, ProjetoInicioDAO projetoInicioDAO) {
		super();
		this.planoGerenciamentoRequisitoDAO = planoGerenciamentoRequisitoDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
							
				request.setAttribute("titulo", "Consultar - PLANO DE GERENCIAMENTO DOS REQUISITOS");//Processamento que será executado pelo comando

			try {
				request.setAttribute("projetoInicios", projetoInicioDAO.getProjetoInicios());
				/*Atenção aqui pelo amor de DEUS
				 * 
				 * <%			
						String style ="'color: navy; text-align: center; font-size: small;'";				
						List<Statuss> statusss = (List<Statuss>) request.getAttribute("statusss");//Esta linha é braba, rsrsrsr... 20 dias para encontra um erro.
						for(Statuss statuss: statusss ){
			 		%>				 
				 * 
				 */
				request.setAttribute("planoGerenciamentoRequisitos", planoGerenciamentoRequisitoDAO.getPlanoGerenciamentoRequisitos());//atributo recuperado no consulta_statuss.jsp
			
			}catch (Exception e) 
			{			
				request.setAttribute("mensagem", "Problema com acesso a base de dados!");//Caso aja problema, será executado MSN informando!
				e.printStackTrace();
			}			 
			return "consulta_plano_gerenciamento_requisito.jsp";//se não ouver erro, retorne a pagina.
	}
	//Deve cadastrar o comando no TkcsapcdHelper!!!!!

}

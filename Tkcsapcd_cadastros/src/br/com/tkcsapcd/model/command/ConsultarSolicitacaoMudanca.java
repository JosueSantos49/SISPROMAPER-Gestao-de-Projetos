/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceSolicitacaoMudancaDAO;

public class ConsultarSolicitacaoMudanca implements InterfaceCommand {
	
	private InterfaceSolicitacaoMudancaDAO solicitacaoMudancaDAO;
	public ConsultarSolicitacaoMudanca(InterfaceSolicitacaoMudancaDAO solicitacaoMudancaDAO) {
		super();
		this.solicitacaoMudancaDAO = solicitacaoMudancaDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
			
				request.setAttribute("titulo", "Consultar - SOLICITAÇÃO MUDANÇA");//Processamento que será executado pelo comando

			try {
				/*Atenção aqui pelo amor de DEUS
				 * 
				 * <%			
						String style ="'color: navy; text-align: center; font-size: small;'";				
						List<Statuss> statusss = (List<Statuss>) request.getAttribute("statusss");//Esta linha é braba, rsrsrsr... 20 dias para encontra um erro.
						for(Statuss statuss: statusss ){
			 		%>				 
				 * 
				 */
				request.setAttribute("solicitacaoMudancas", solicitacaoMudancaDAO.getSolicitacaoMudancas());//atributo recuperado no consulta_statuss.jsp
			
			}catch (Exception e) 
			{			
				request.setAttribute("mensagem", "Problema com acesso a base de dados!");//Caso aja problema, será executado MSN informando!
				e.printStackTrace();
			}			 
			return "consulta_solicitacao_mudanca.jsp";//se não ouver erro, retorne a pagina.
	}
	//Deve cadastrar o comando no TkcsapcdHelper!!!!!

}

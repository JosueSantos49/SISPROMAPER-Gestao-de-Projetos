/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceSolicitacaoProjetovBSCDAO;

public class ConsultarSolicitacaoProjetovBSC implements InterfaceCommand {
	
	private InterfaceSolicitacaoProjetovBSCDAO solicitacaoProjetovBSCDAO;
	public ConsultarSolicitacaoProjetovBSC(InterfaceSolicitacaoProjetovBSCDAO solicitacaoProjetovBSCDAO) {
		super();
		this.solicitacaoProjetovBSCDAO = solicitacaoProjetovBSCDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
			
				request.setAttribute("titulo", "Consultar - Solicita��o do Projeto - Balanced Scorecard");//Processamento que ser� executado pelo comando

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
				request.setAttribute("solicitacaoProjetovBSCs", solicitacaoProjetovBSCDAO.getSolicitacaoProjetovBSCs());//atributo recuperado no consulta_statuss.jsp
			
			}catch (Exception e) 
			{			
				request.setAttribute("mensagem", "Problema com acesso a base de dados!");//Caso aja problema, ser� executado MSN informando!
				e.printStackTrace();
			}			 
			return "consulta_solicitacao_projeto_vbsc.jsp";//se n�o ouver erro, retorne a pagina.
	}
	//Deve cadastrar o comando no TkcsapcdHelper!!!!!

}

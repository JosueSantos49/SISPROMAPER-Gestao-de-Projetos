/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceSolicitacaoServicoTIDAO;

//M�todo registrado na InterfaceCommand
public class ConsultarSolicitacaoServicoTI implements InterfaceCommand {
	
	private InterfaceSolicitacaoServicoTIDAO solicitacaoServicoTIDAO;
	
	
	public ConsultarSolicitacaoServicoTI(InterfaceSolicitacaoServicoTIDAO solicitacaoServicoTIDAO) {
		super();
		this.solicitacaoServicoTIDAO = solicitacaoServicoTIDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)throws SQLException {	
		
			request.setAttribute("titulo", "Consultar - SSTI");//Processamento que ser� executado pelo comando

		try {
			request.setAttribute("solicitacaoServicoTIs", solicitacaoServicoTIDAO.getSolicitacaoServicoTIs());//atributo recuperado no consulta_projeto.jsp
		} catch (Exception e) 
		{			
			request.setAttribute("mensagem", "Problema com acesso a base de dados!");//Caso aja problema, ser� executado MSN informando!
			e.printStackTrace();
		}			 
			return "consulta_solicitacaoservicoti.jsp";//se n�o ouver erro, retorne a pagina.
	}
	//Deve cadastrar o comando no TkcsapcdHelper!!!!!
}

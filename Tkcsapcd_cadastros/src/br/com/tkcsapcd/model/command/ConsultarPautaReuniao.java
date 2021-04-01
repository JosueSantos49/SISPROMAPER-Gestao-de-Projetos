/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfacePautaReuniaoDAO;

public class ConsultarPautaReuniao implements InterfaceCommand {

	private InterfacePautaReuniaoDAO pautaReuniaoDAO;
	
	public ConsultarPautaReuniao(
			InterfacePautaReuniaoDAO pautaReuniaoDAO) {
		super();
		this.pautaReuniaoDAO = pautaReuniaoDAO;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		request.setAttribute("titulo", "Consultar - PAUTA DE REUNI�O");
		
		try {		
				//Aten��o nesta linha, linkando os dados do FOR da pagina consulta
				request.setAttribute("pautaReuniaos", pautaReuniaoDAO.getPautaReuniaos());
				
			} catch (Exception e) 
			{				
				request.setAttribute("mensagem", "Problema com acesso a base de dados!");//Caso aja problema, ser� executado MSN informando!
				e.printStackTrace();
			}				
			return "consulta_pauta_reuniao.jsp";//se n�o ouver erro, retorne a pagina 			
		}
			//Deve cadastrar o comando no TkcsapcdHelper!!!!!
}

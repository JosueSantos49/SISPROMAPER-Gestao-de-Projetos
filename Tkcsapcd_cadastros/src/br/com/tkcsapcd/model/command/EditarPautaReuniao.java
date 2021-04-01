/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfacePautaReuniaoDAO;

public class EditarPautaReuniao implements InterfaceCommand {

	private InterfacePautaReuniaoDAO pautaReuniaoDAO;
	
	public EditarPautaReuniao(InterfacePautaReuniaoDAO pautaReuniaoDAO) {
		super();
		this.pautaReuniaoDAO = pautaReuniaoDAO;
	}

	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response) throws SQLException {
		try {
			if(request.getParameter("codigo") == null)
			{
				request.setAttribute("titulo", "Cadastro - PAUTA DE REUNIÃO");
				return "cadastro_pauta_reuniao.jsp";
			}
	
			request.setAttribute("pautaReuniao", pautaReuniaoDAO.getPautaReuniao(Integer.valueOf(request.getParameter("codigo"))));
			}
			catch (NumberFormatException e) {
				
				// Se o numero não for válido
				request.setAttribute("mensagem", "Valo do código inválido:"+request.getParameter("codigo"));
			
			} catch (Exception e) {
				
				request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
				e.printStackTrace();
				
			}
				//Caso funcione td corretamente. Seta o atributo
				request.setAttribute("titulo", "Atualização - PAUTA DE REUNIÃO");		
				return "atualiza_pauta_reuniao.jsp";		
}

}

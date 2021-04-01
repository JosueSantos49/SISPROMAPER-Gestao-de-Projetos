/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceRecursosHumanosDAO;

public class EditarRecursosHumanos implements InterfaceCommand {

	private InterfaceRecursosHumanosDAO recursosHumanosDAO;

	public EditarRecursosHumanos(InterfaceRecursosHumanosDAO recursosHumanosDAO) {
		super();
		this.recursosHumanosDAO = recursosHumanosDAO;
	}

	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response) throws SQLException {
		try {
			if(request.getParameter("codigo") == null)
			{
				request.setAttribute("titulo", "Cadastro - Recursos Humanos");
				return "cadastro_recursohumanos.jsp";
			}
	
			request.setAttribute("recursosHumanos", recursosHumanosDAO.getRecursosHumanos(Integer.valueOf(request.getParameter("codigo"))));
			}
			catch (NumberFormatException e) {
				
				// Se o numero n�o for v�lido
				request.setAttribute("mensagem", "Valo do c�digo inv�lido:"+request.getParameter("codigo"));
			
			} catch (Exception e) {
				
				request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
				e.printStackTrace();
				
			}
				//Caso funcione td corretamente. Seta o atributo
				request.setAttribute("titulo", "Atualiza��o - Recursos Humanos");		
				return "atualiza_recursoshumanos.jsp";		
}

}

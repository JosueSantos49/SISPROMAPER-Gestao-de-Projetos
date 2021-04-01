/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceMetricasDAO;

public class EditarMetricas implements InterfaceCommand {

	private InterfaceMetricasDAO metricasDAO;	

	public EditarMetricas(InterfaceMetricasDAO metricasDAO) {
		super();
		this.metricasDAO = metricasDAO;
	}


	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response) throws SQLException {
		try {
			if(request.getParameter("codigo") == null)
			{
				request.setAttribute("titulo", "Cadastro - M�trica");
				return "cadastro_metricas.jsp";
			}
	
			request.setAttribute("metricas", metricasDAO.getMetricas(Integer.valueOf(request.getParameter("codigo"))));
			}
			catch (NumberFormatException e) {
				
				// Se o numero n�o for v�lido
				request.setAttribute("mensagem", "Valo do c�digo inv�lido:"+request.getParameter("codigo"));
			
			} catch (Exception e) {
				
				request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
				e.printStackTrace();
				
			}
				//Caso funcione td corretamente. Seta o atributo
				request.setAttribute("titulo", "Atualiza��o - M�trica");		
				return "atualiza_metricas.jsp";		
}

}

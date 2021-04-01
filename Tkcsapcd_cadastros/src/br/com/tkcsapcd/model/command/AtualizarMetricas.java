/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.Metricas;
import br.com.tkcsapcd.model.dao.InterfaceMetricasDAO;

public class AtualizarMetricas implements InterfaceCommand {

	private InterfaceMetricasDAO metricasDAO;
	public AtualizarMetricas(InterfaceMetricasDAO metricasDAO) {
		super();
		this.metricasDAO = metricasDAO;
	}

	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response) throws Exception {
		try {
			
			Metricas metricas = new Metricas();
			
			metricas.setCodigo(Integer.valueOf(request.getParameter("codigo")));
			metricas.setIdMetricas(request.getParameter("idMetricas"));
			metricas.setNomeMetrica(request.getParameter("nomeMetrica"));
			metricas.setIndiceMetrica(request.getParameter("indiceMetrica"));
			metricas.setValorReferenciaHora(request.getParameter("valorReferenciaHora"));
			metricas.setValorHoraCalculadaDia(request.getParameter("valorHoraCalculadaDia"));
			
			metricasDAO.atualizar(metricas);			
			request.setAttribute("mensagem", "M�trica: ("+metricas.getIdMetricas()+") atualizado com sucesso!");
			
			} catch (SQLException e) {
				
				request.setAttribute("mensagem", "Problema com a atualiza��o: "+e.getMessage());
				e.printStackTrace();
				
			}catch (NumberFormatException e) {
				request.setAttribute("mensagem", "Valor inv�lido: "+e.getMessage());			
			}	
			request.setAttribute("titulo", "Atualiza��o - M�trica");
			return "TkcsapcdController?cmd=consultarMetricas";//Pagina de Retorno (pagina consulta funcionario)

	}


}

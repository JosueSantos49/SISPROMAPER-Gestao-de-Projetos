/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.StatusReport;
import br.com.tkcsapcd.model.dao.InterfaceStatusReportDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarStatusReport implements InterfaceCommand {

	private InterfaceStatusReportDAO statusReportDAO;
	public AtualizarStatusReport(InterfaceStatusReportDAO statusReportDAO) {
		super();
		this.statusReportDAO = statusReportDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request					
					StatusReport statusReport = new StatusReport();
					
					statusReport.setCodigo(Integer.valueOf(request.getParameter("codigo")));
					statusReport.setStatusreport(request.getParameter("statusreport"));
					statusReport.setProjeto(request.getParameter("projeto"));
					statusReport.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
					statusReport.setPeriodoinicio(request.getParameter("periodoinicio"));
					statusReport.setPeriodofim(request.getParameter("periodofim"));
					statusReport.setIndicador(request.getParameter("indicador"));
					statusReport.setStatus(request.getParameter("status"));
					statusReport.setComentario(request.getParameter("comentario"));
					statusReport.setEap(request.getParameter("eap"));				
					statusReport.setPeriodo(request.getParameter("proximoperiodo"));					
					statusReport.setAtividadeandamento(request.getParameter("atividadeandamento"));
					statusReport.setProximoperiodo(request.getParameter("proximoperiodo"));
					statusReport.setPontoatencao(request.getParameter("pontoatencao"));
					statusReport.setAdicionais(request.getParameter("adicionais"));
		
		if(ValidationHelper.validar(statusReport)){			
			statusReportDAO.atualizar(statusReport);
			request.setAttribute("mensagem", "STATUS REPORT: ("+statusReport.getCodigoprojeto()+") atualizado com sucesso!");
		}
		else{
			throw new Exception("Valor inválido");
		}	
		} catch (SQLException e) {
			
			request.setAttribute("mensagem", "Problema com a atualização: "+e.getMessage());
			e.printStackTrace();
			
		}catch (NumberFormatException e) {
			request.setAttribute("mensagem", "Valor inválido: "+e.getMessage());			
		}	
			request.setAttribute("titulo", "Atualização - STATUS REPORT");
			return "TkcsapcdController?cmd=consultarStatusReport";//Pagina de Retorno (pagina consulta)
	}

}

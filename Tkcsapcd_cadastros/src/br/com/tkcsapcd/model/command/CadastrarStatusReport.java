/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.StatusReport;
import br.com.tkcsapcd.model.dao.InterfaceStatusReportDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarStatusReport implements InterfaceCommand {

	private InterfaceStatusReportDAO statusReportDAO;
	public CadastrarStatusReport(InterfaceStatusReportDAO statusReportDAO) {
		super();
		this.statusReportDAO = statusReportDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			StatusReport statusReport = new StatusReport();
			
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
				
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM statusreport WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("codigoprojeto");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+statusReport.getCodigoprojeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarStatusReport";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					statusReportDAO.salvar(statusReport);
					request.setAttribute("mensagem", "STATUS REPORT: ("+statusReport.getCodigoprojeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					statusReportDAO.salvar(statusReport);
					request.setAttribute("mensagem", "STATUS REPORT: ("+statusReport.getCodigoprojeto()+") cadastrado com sucesso!");			
			}
			else{
				throw new Exception("Valor inválido");
			}
			} catch (SQLException e) {
				
				request.setAttribute("mensagem", "Problemas com a gravação: "+e.getMessage());
				e.printStackTrace();
				
			}catch (NumberFormatException e){
				
				request.setAttribute("mensagem", "Valor inválido: "+e.getMessage());
				e.printStackTrace();
			}
				request.setAttribute("titulo", "Cadastro - STATUS REPORT");
				return "TkcsapcdController?cmd=editarStatusReport";//devolver p/ editar cadastro		
	}
}

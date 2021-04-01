/* 
	Autor: Josu� da Concei��o Santos
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

import br.com.tkcsapcd.model.bean.Metricas;
import br.com.tkcsapcd.model.dao.InterfaceMetricasDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarMetricas implements InterfaceCommand {

	private InterfaceMetricasDAO metricasDAO;
	public CadastrarMetricas(InterfaceMetricasDAO metricasDAO) {
		super();
		this.metricasDAO = metricasDAO;
	}



	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response) throws Exception {
		try {
			Metricas metricas = new Metricas();
			
			metricas.setIdMetricas(request.getParameter("idMetricas"));
			metricas.setNomeMetrica(request.getParameter("nomeMetrica"));
			metricas.setIndiceMetrica(request.getParameter("indiceMetrica"));
			metricas.setValorReferenciaHora(request.getParameter("valorReferenciaHora"));
			metricas.setValorHoraCalculadaDia(request.getParameter("valorHoraCalculadaDia"));			
			
			if(ValidationHelper.validar(metricas)){
				
				Connection con = ConexaoHelper.conectar();
				
				PreparedStatement stmt = con.prepareStatement("SELECT * FROM metricas WHERE idMetricas = '"+request.getParameter("idMetricas")+"'");// pega a conex�o e o Statement
				ResultSet rs = stmt.executeQuery();// executa um select
				
				while(rs.next()){
					
					Integer idMetricas = rs.getInt("idMetricas");
					
					if(idMetricas >= 1){
						System.out.println("O c�digo � igual!");
												 
						PrintWriter out = response.getWriter();
						response.setContentType("text/html; charset=ISO-8859-1");
						out.println("<script type=\"text/javascript\">");  
						out.println("alert('J� existe um registro com o ID ("+metricas.getIdMetricas()+"), informado!');");  
						out.println("</script>");
						
						return "TkcsapcdController?cmd=editarMetricas";//Devolver para o editar
					}else{
						System.out.println("Aviso 1: O c�digo n�o � igual!");
						metricasDAO.salvar(metricas);
						request.setAttribute("mensagem", "M�trica: ("+metricas.getIdMetricas()+") cadastrado com sucesso!");
					}
						stmt.close();
						rs.close();
						con.close();
				}
						System.out.println("Aviso 2: O c�digo n�o � igual!");
						metricasDAO.salvar(metricas);
						request.setAttribute("mensagem", "M�trica: ("+metricas.getIdMetricas()+") cadastrado com sucesso!");			
				}
				else{
					throw new Exception("Valor inv�lido");
				}
			} catch (SQLException e) {
				
				request.setAttribute("mensagem", "Problema com a grava��o: "+e.getMessage());
				e.printStackTrace();
				
			}catch (NumberFormatException e) {
				
				request.setAttribute("mensagem", "Valor inv�lido: "+e.getMessage());
				e.printStackTrace();
			}
			request.setAttribute("titulo", "Cadastro - M�trica");		
			return "TkcsapcdController?cmd=editarMetricas";//Devolver para o editar
		}


}

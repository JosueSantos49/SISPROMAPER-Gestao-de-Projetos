/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceBusinessPlanDAO;

public class ExcluirBusinessPlan implements InterfaceCommand {
	
	private InterfaceBusinessPlanDAO businessPlanDAO;
	public ExcluirBusinessPlan(InterfaceBusinessPlanDAO businessPlanDAO) {
		super();
		this.businessPlanDAO = businessPlanDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// 
		try {
			
			businessPlanDAO.excluir(Integer.valueOf(request.getParameter("codigo")));
			//request.setAttribute("mensagem", "Cliente excluido com sucesso!");
			
		} catch (NumberFormatException e) {
			
			request.setAttribute("mensagem", "Código inválido"+request.getParameter("codigo"));
			e.printStackTrace();
			
		}catch(SQLException e){
			
			request.setAttribute("mensagem", "Problemas com a base de dados!");
			e.printStackTrace();
			
		}
			request.setAttribute("titulo","Consulta - BUSINESS PLAN");
			return "TkcsapcdController?cmd=consultarBusinessPlan";
			//Cadastre esse comando no helper!		
	}

}

/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfacePlanoGerenciamentoRiscoDAO;

public class ExcluirPlanoGerenciamentoRisco implements InterfaceCommand {
	
	private InterfacePlanoGerenciamentoRiscoDAO planoGerenciamentoRiscoDAO;
	public ExcluirPlanoGerenciamentoRisco(InterfacePlanoGerenciamentoRiscoDAO planoGerenciamentoRiscoDAO) {
		super();
		this.planoGerenciamentoRiscoDAO = planoGerenciamentoRiscoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)throws Exception{
		// 
		try {
			
			planoGerenciamentoRiscoDAO.excluir(Integer.valueOf(request.getParameter("codigo")));
			request.setAttribute("mensagem", "Excluido com sucesso!");
			
		} catch (NumberFormatException e) {
			
			request.setAttribute("mensagem", "Código inválido"+request.getParameter("codigo"));
			e.printStackTrace();
			
		}catch(SQLException e){
			
			request.setAttribute("mensagem", "Problemas com a base de dados!");
			e.printStackTrace();
			
		}
			request.setAttribute("titulo","Consulta - PLANO DE GERENCIAMENTO DOS RISCOS");
			return "TkcsapcdController?cmd=consultarPlanoGerenciamentoRisco";
			//Cadastre esse comando no helper!		
	}

}

/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfacePlanoGerenciamentoRequisitoDAO;

public class ExcluirPlanoGerenciamentoRequisito implements InterfaceCommand {
	
	private InterfacePlanoGerenciamentoRequisitoDAO planoGerenciamentoRequisitoDAO;
	public ExcluirPlanoGerenciamentoRequisito(InterfacePlanoGerenciamentoRequisitoDAO planoGerenciamentoRequisitoDAO) {
		super();
		this.planoGerenciamentoRequisitoDAO = planoGerenciamentoRequisitoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)throws Exception{
		// 
		try {
			
			planoGerenciamentoRequisitoDAO.excluir(Integer.valueOf(request.getParameter("codigo")));
			request.setAttribute("mensagem", "Excluido com sucesso!");
			
		} catch (NumberFormatException e) {
			
			request.setAttribute("mensagem", "Código inválido"+request.getParameter("codigo"));
			e.printStackTrace();
			
		}catch(SQLException e){
			
			request.setAttribute("mensagem", "Problemas com a base de dados!");
			e.printStackTrace();
			
		}
			request.setAttribute("titulo","Consulta - PLANO DE GERENCIAMENTO DOS REQUISITOS");
			return "TkcsapcdController?cmd=consultarPlanoGerenciamentoRequisito";
			//Cadastre esse comando no helper!		
	}

}

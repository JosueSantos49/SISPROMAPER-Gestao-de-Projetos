/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfacePortfolioProjetoDAO;

public class ExcluirPortfolioProjeto implements InterfaceCommand {
	
	private InterfacePortfolioProjetoDAO portfolioProjetoDAO;
	public ExcluirPortfolioProjeto(InterfacePortfolioProjetoDAO portfolioProjetoDAO) {
		super();
		this.portfolioProjetoDAO = portfolioProjetoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)throws Exception{
		// 
		try {
			
			portfolioProjetoDAO.excluir(Integer.valueOf(request.getParameter("codigo")));
			request.setAttribute("mensagem", "Excluido com sucesso!");
			
		} catch (NumberFormatException e) {
			
			request.setAttribute("mensagem", "C�digo inv�lido"+request.getParameter("codigo"));
			e.printStackTrace();
			
		}catch(SQLException e){
			
			request.setAttribute("mensagem", "Problemas com a base de dados!");
			e.printStackTrace();
			
		}
			request.setAttribute("titulo","Consulta - Portf�lio de Projeto");
			return "TkcsapcdController?cmd=consultarPortfolioProjeto";
			//Cadastre esse comando no helper!		
	}

}

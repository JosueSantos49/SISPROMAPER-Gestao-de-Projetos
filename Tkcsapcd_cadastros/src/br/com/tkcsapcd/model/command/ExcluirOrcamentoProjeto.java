/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceOrcamentoProjetoDAO;

public class ExcluirOrcamentoProjeto implements InterfaceCommand {
	
	private InterfaceOrcamentoProjetoDAO orcamentoProjetoDAO;
	public ExcluirOrcamentoProjeto(InterfaceOrcamentoProjetoDAO orcamentoProjetoDAO) {
		super();
		this.orcamentoProjetoDAO = orcamentoProjetoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// 
		try {
			
			orcamentoProjetoDAO.excluir(Integer.valueOf(request.getParameter("codigo")));
			//request.setAttribute("mensagem", "Cliente excluido com sucesso!");
			
		} catch (NumberFormatException e) {
			
			request.setAttribute("mensagem", "Código inválido"+request.getParameter("codigo"));
			e.printStackTrace();
			
		}catch(SQLException e){
			
			request.setAttribute("mensagem", "Problemas com a base de dados!");
			e.printStackTrace();
			
		}
			request.setAttribute("titulo","Consulta - Orçamento do projeto");
			return "TkcsapcdController?cmd=consultarOrcamentoProjeto";
			//Cadastre esse comando no helper!		
	}

}

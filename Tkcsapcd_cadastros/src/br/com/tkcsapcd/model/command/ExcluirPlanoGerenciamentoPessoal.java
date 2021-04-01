/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfacePlanoGerenciamentoPessoalDAO;

public class ExcluirPlanoGerenciamentoPessoal implements InterfaceCommand {
	
	private InterfacePlanoGerenciamentoPessoalDAO planoGerenciamentoPessoalDAO;
	public ExcluirPlanoGerenciamentoPessoal(InterfacePlanoGerenciamentoPessoalDAO planoGerenciamentoPessoalDAO) {
		super();
		this.planoGerenciamentoPessoalDAO = planoGerenciamentoPessoalDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)throws Exception{
		// 
		try {
			
			planoGerenciamentoPessoalDAO.excluir(Integer.valueOf(request.getParameter("codigo")));
			request.setAttribute("mensagem", "Excluido com sucesso!");
			
		} catch (NumberFormatException e) {
			
			request.setAttribute("mensagem", "Código inválido"+request.getParameter("codigo"));
			e.printStackTrace();
			
		}catch(SQLException e){
			
			request.setAttribute("mensagem", "Problemas com a base de dados!");
			e.printStackTrace();
			
		}
			request.setAttribute("titulo","Consulta - PLANO DE GERENCIAMENTO DO PESSOAL");
			return "TkcsapcdController?cmd=consultarPlanoGerenciamentoPessoal";
			//Cadastre esse comando no helper!		
	}

}

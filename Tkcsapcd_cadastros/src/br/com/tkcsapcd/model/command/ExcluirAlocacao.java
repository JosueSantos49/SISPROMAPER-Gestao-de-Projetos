/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceAlocacaoDAO;

public class ExcluirAlocacao implements InterfaceCommand {
	
	private InterfaceAlocacaoDAO alocacaoDAO;
	public ExcluirAlocacao(InterfaceAlocacaoDAO alocacaoDAO) {
		super();
		this.alocacaoDAO = alocacaoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)throws Exception {
		// 
		try {
			
			alocacaoDAO.excluir(Integer.valueOf(request.getParameter("codigo")));
			//request.setAttribute("mensagem", "Cliente excluido com sucesso!");
			
		} catch (NumberFormatException e) {
			
			request.setAttribute("mensagem", "C�digo inv�lido"+request.getParameter("codigo"));
			e.printStackTrace();
			
		}catch(SQLException e){
			
			request.setAttribute("mensagem", "Problemas com a base de dados!");
			e.printStackTrace();
			
		}
			request.setAttribute("titulo","Consulta - Aloca��o");
			return "TkcsapcdController?cmd=consultarAlocacao";
			//Cadastre esse comando no helper!		
	}

}

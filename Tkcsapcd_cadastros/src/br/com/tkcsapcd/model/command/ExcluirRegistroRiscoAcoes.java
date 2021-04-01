/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceRegistroRiscoAcoesDAO;

public class ExcluirRegistroRiscoAcoes implements InterfaceCommand {
	
	private InterfaceRegistroRiscoAcoesDAO resgistroRiscoAcoesDAO;
	public ExcluirRegistroRiscoAcoes(InterfaceRegistroRiscoAcoesDAO resgistroRiscoAcoesDAO) {
		super();
		this.resgistroRiscoAcoesDAO = resgistroRiscoAcoesDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// 
		try {
			
			resgistroRiscoAcoesDAO.excluir(Integer.valueOf(request.getParameter("codigo")));
			//request.setAttribute("mensagem", "Cliente excluido com sucesso!");
			
		} catch (NumberFormatException e) {
			
			request.setAttribute("mensagem", "C�digo inv�lido"+request.getParameter("codigo"));
			e.printStackTrace();
			
		}catch(SQLException e){
			
			request.setAttribute("mensagem", "Problemas com a base de dados!");
			e.printStackTrace();
			
		}
			request.setAttribute("titulo","Consulta - REGISTRO DOS RiscoAcoesS");
			return "TkcsapcdController?cmd=consultarRegistroRiscoAcoes";
			//Cadastre esse comando no helper!		
	}

}

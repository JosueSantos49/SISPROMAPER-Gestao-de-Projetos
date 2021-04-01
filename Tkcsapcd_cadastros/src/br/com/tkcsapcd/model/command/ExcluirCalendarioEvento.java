/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceCalendarioEventoDAO;

public class ExcluirCalendarioEvento implements InterfaceCommand {
	
	private InterfaceCalendarioEventoDAO calendarioEventoDAO;
	public ExcluirCalendarioEvento(InterfaceCalendarioEventoDAO calendarioEventoDAO) {
		super();
		this.calendarioEventoDAO = calendarioEventoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)throws Exception{
		// 
		try {
			
			calendarioEventoDAO.excluir(Integer.valueOf(request.getParameter("codigo")));
			//request.setAttribute("mensagem", "Cliente excluido com sucesso!");
			
		} catch (NumberFormatException e) {
			
			request.setAttribute("mensagem", "Código inválido"+request.getParameter("codigo"));
			e.printStackTrace();
			
		}catch(SQLException e){
			
			request.setAttribute("mensagem", "Problemas com a base de dados!");
			e.printStackTrace();
			
		}
			request.setAttribute("titulo","Consulta - Calendário Evento");
			return "TkcsapcdController?cmd=consultarCalendarioEvento";
			//Cadastre esse comando no helper!		
	}

}

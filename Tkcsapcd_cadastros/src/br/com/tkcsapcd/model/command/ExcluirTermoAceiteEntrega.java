/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceTermoAceiteEntregaDAO;

public class ExcluirTermoAceiteEntrega implements InterfaceCommand {
	
	private InterfaceTermoAceiteEntregaDAO termoAceiteEntregaDAO;
	public ExcluirTermoAceiteEntrega(InterfaceTermoAceiteEntregaDAO termoAceiteEntregaDAO) {
		super();
		this.termoAceiteEntregaDAO = termoAceiteEntregaDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// 
		try {
			
			termoAceiteEntregaDAO.excluir(Integer.valueOf(request.getParameter("codigo")));
			request.setAttribute("mensagem", "Excluido com sucesso!");
			
		} catch (NumberFormatException e) {
			
			request.setAttribute("mensagem", "Código inválido"+request.getParameter("codigo"));
			e.printStackTrace();
			
		}catch(SQLException e){
			
			request.setAttribute("mensagem", "Problemas com a base de dados!");
			e.printStackTrace();
			
		}
			request.setAttribute("titulo","Consulta - TERMO DE ACEITE DA ENTREGA");
			return "TkcsapcdController?cmd=consultarTermoAceiteEntrega";
			//Cadastre esse comando no helper!		
	}

}

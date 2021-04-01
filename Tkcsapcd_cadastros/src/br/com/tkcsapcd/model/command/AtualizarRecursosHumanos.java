/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.RecursosHumanos;
import br.com.tkcsapcd.model.dao.InterfaceRecursosHumanosDAO;

public class AtualizarRecursosHumanos implements InterfaceCommand {

	private InterfaceRecursosHumanosDAO recursosHumanosDAO;

	public AtualizarRecursosHumanos(
			InterfaceRecursosHumanosDAO recursosHumanosDAO) {
		super();
		this.recursosHumanosDAO = recursosHumanosDAO;
	}

	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response) throws Exception {
		try {
			RecursosHumanos recursosHumanos = new RecursosHumanos();
			
			recursosHumanos.setCodigo(Long.valueOf(request.getParameter("codigo")));
			recursosHumanos.setIdRecursosHumanos(request.getParameter("idRecursosHumanos"));
			//recursosHumanos.setIdRecursosHumanos(Integer.valueOf((request.getParameter("idRecursosHumanos"))));
			recursosHumanos.setNome(request.getParameter("nome"));
			recursosHumanos.setProfissao(request.getParameter("profissao"));
			recursosHumanos.setArea(request.getParameter("area"));
			recursosHumanos.setStatus(request.getParameter("status"));
			
			recursosHumanosDAO.atualizar(recursosHumanos);			
			request.setAttribute("mensagem", "Recursos Humannos: ("+recursosHumanos.getIdRecursosHumanos()+") atualizado com sucesso!");
			
			} catch (SQLException e) {
				
				request.setAttribute("mensagem", "Problema com a atualização: "+e.getMessage());
				e.printStackTrace();
				
			}catch (NumberFormatException e) {
				request.setAttribute("mensagem", "Valor inválido: "+e.getMessage());			
			}	
			request.setAttribute("titulo", "Atualização - Recursos Humanos");
			return "TkcsapcdController?cmd=consultarRecursosHumanos";//Pagina de Retorno (pagina consulta funcionario)

	}


}

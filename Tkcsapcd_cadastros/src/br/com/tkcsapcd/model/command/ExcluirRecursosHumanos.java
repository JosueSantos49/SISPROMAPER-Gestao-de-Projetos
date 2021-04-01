/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceRecursosHumanosDAO;

public class ExcluirRecursosHumanos implements InterfaceCommand {

	private InterfaceRecursosHumanosDAO recursosHumanosDAO;
	

	public ExcluirRecursosHumanos(InterfaceRecursosHumanosDAO recursosHumanosDAO) {
		super();
		this.recursosHumanosDAO = recursosHumanosDAO;
	}


	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response) throws Exception {
		try {
			recursosHumanosDAO.excluir(Integer.valueOf(request.getParameter("codigo")));
			request.setAttribute("mensagem", "Recursos Humanos excluído com sucesso!");
			
		} catch (NumberFormatException e) {
			
			request.setAttribute("mensagem", "Código inválido: "+request.getParameter("codigo"));
			e.printStackTrace();
			
		}catch (SQLException e) {//Atenção por padão todas os Editar esta como SQLException, mas nesta linha da erro sempre!!!
			
			request.setAttribute("mensagem", "Problemas com a base de dados!");
			e.printStackTrace();
		}
			request.setAttribute("titulo","Consulta - Recursos Humanos");
			return "TkcsapcdController?cmd=consultarRecursosHumanos";
			//Cadastre esse comando no helper!
}


}

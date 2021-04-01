/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceAcompanhamentoProjetoDAO;

public class ExcluirAcompanhamentoProjeto implements InterfaceCommand {

	private InterfaceAcompanhamentoProjetoDAO acompanhamentoProjetoDAO;
	
	public ExcluirAcompanhamentoProjeto(InterfaceAcompanhamentoProjetoDAO acompanhamentoProjetoDAO) {
		super();
		this.acompanhamentoProjetoDAO = acompanhamentoProjetoDAO;
	}

	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response) throws Exception  {
		try {
			acompanhamentoProjetoDAO.excluir(Integer.valueOf(request.getParameter("codigo")));
			request.setAttribute("mensagem", "ACOMPANHAMENTO DO PROJETO exclu�do.");
			
		} catch (NumberFormatException e) {
			
			request.setAttribute("mensagem", "C�digo inv�lido: "+request.getParameter("codigo"));
			e.printStackTrace();
			
		}catch (SQLException e) {//Aten��o por pad�o todas os Editar esta como SQLException, mas nesta linha da erro sempre!!!
			
			request.setAttribute("mensagem", "Problemas com a base de dados!");
			e.printStackTrace();
		}
			request.setAttribute("titulo","Consulta - ACOMPANHAMENTO DO PROJETO");
			return "TkcsapcdController?cmd=consultarAcompanhamentoProjeto";
			//Cadastre esse comando no helper!
}


}

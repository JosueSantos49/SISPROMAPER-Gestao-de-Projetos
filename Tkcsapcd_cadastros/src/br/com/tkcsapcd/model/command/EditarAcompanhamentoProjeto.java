/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceAcompanhamentoProjetoDAO;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;

public class EditarAcompanhamentoProjeto implements InterfaceCommand {

	private InterfaceAcompanhamentoProjetoDAO acompanhamentoProjetoDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	
	public EditarAcompanhamentoProjeto(InterfaceAcompanhamentoProjetoDAO acompanhamentoProjetoDAO, InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.acompanhamentoProjetoDAO = acompanhamentoProjetoDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}

	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response) throws SQLException {
		try {
			
			//Setando o atributo projetosInicio, para listar no select da pagina cadastro.
			request.setAttribute("projetoInicios", projetoInicioDAO.getProjetoInicios());
			
			if(request.getParameter("codigo") == null)
			{
				request.setAttribute("titulo", "Cadastro - ACOMPANHAMENTO DO PROJETO");
				return "cadastro_acompanhamento_projeto.jsp";
			}
	
			request.setAttribute("acompanhamentoProjeto", acompanhamentoProjetoDAO.getAcompanhamentoProjeto(Integer.valueOf(request.getParameter("codigo"))));
			}
			catch (NumberFormatException e) {
				
				// Se o numero não for válido
				request.setAttribute("mensagem", "Valo do código inválido:"+request.getParameter("codigo"));
			
			} catch (Exception e) {
				
				request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
				e.printStackTrace();
				
			}
				//Caso funcione td corretamente. Seta o atributo
				request.setAttribute("titulo", "Atualização - ACOMPANHAMENTO DO PROJETO");		
				return "atualiza_acompanhamento_projeto.jsp";		
}

}

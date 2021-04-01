/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.dao.InterfaceStatussDAO;

public class EditarStatuss implements InterfaceCommand {
	
	private InterfaceStatussDAO statussDAO; 
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	public EditarStatuss(InterfaceStatussDAO statussDAO, InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.statussDAO = statussDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response) throws Exception {
		try {
			
			//Setando o atributo projetosInicio, para listar no select da pagina cadastro.
			request.setAttribute("projetoInicios", projetoInicioDAO.getProjetoInicios());
			
			if(request.getParameter("codigo") == null)
			{
				request.setAttribute("titulo", "Cadastro - Status do Projeto");
				return"cadastro_statuss.jsp";
			}
				request.setAttribute("statuss", statussDAO.getStatuss(Integer.valueOf(request.getParameter("codigo"))));
			
			}catch(NumberFormatException e){
				// Se o numero não for válido
				request.setAttribute("mensagem", "Valo do código inválido:"+request.getParameter("codigo"));
			}catch (SQLException e) {
	
				request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
			}				
				//Caso funcione td corretamente. Seta o atributo
				request.setAttribute("titulo", "Atualização - Status");				
				return "atualiza_statuss.jsp";
	}

}

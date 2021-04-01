/* 
Autor: Josué da Conceição Santos
E-mail: conceicaojosue@outlook.com.br
Ano: 2015
*/package br.com.tkcsapcd.model.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceRequerimentoDAO;

public class EditarRequerimento implements InterfaceCommand {

	private InterfaceRequerimentoDAO requerimentoDAO;
	
	public EditarRequerimento(InterfaceRequerimentoDAO requerimentoDAO) {
		super();
		this.requerimentoDAO = requerimentoDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response){
			
		try {
				if(request.getParameter("codigo") == null)
				{
					request.setAttribute("titulo", "Cadastro - Requerimento");
					return "cadastro_requerimento.jsp";
				}
		
				request.setAttribute("requerimento", requerimentoDAO.getRequerimento(Integer.valueOf(request.getParameter("codigo"))));
				}
				catch (NumberFormatException e) {
					
					// Se o numero não for válido
					request.setAttribute("mensagem", "Valo do código inválido:"+request.getParameter("codigo"));
				
				} catch (Exception e) {
					
					request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
					e.printStackTrace();
					
				}
					//Caso funcione td corretamente. Seta o atributo
					request.setAttribute("titulo", "Atualização - Requerimento");		
					return "atualiza_requerimento.jsp";		
	}

}

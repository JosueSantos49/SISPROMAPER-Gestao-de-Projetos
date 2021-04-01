/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceRfpProjetoDAO;

public class EditarRfpProjeto implements InterfaceCommand {

	private InterfaceRfpProjetoDAO rfpProjetoDAO;
	
	public EditarRfpProjeto(InterfaceRfpProjetoDAO rfpProjetoDAO) {
		super();
		this.rfpProjetoDAO = rfpProjetoDAO;
	}

	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception {
	
		try {
				
				if(request.getParameter("codigo") == null)
				{
					request.setAttribute("titulo", "Cadastro - RFP Projeto");
					return "cadastro_rfpprojeto.jsp";
				}
				
				//Grande jogada
				request.setAttribute("rfpprojeto", rfpProjetoDAO.getRfpProjeto(Integer.valueOf(request.getParameter("codigo"))));
				
				}catch(NumberFormatException e){
					
					request.setAttribute("mensagem", "Valo do código inválido:"+request.getParameter("codigo"));
							
				} catch (SQLException e) { //Atenção por padão todas os Editar esta como SQLException, mas nesta linha da erro sempre!!!
					
					request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
					e.printStackTrace();				
				}
				request.setAttribute("titulo", "Atualização - RFP Projeto");
				return "atualiza_rfpprojeto.jsp";
		
	}
}

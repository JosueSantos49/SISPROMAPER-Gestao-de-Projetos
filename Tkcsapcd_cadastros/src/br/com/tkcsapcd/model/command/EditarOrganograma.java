/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceOrganogramaDAO;

public class EditarOrganograma implements InterfaceCommand {

	private InterfaceOrganogramaDAO organogramaDAO;
	public EditarOrganograma(InterfaceOrganogramaDAO organogramaDAO) {
		super();
		this.organogramaDAO = organogramaDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception  {			
			try{						
					if(request.getParameter("codigo") == null)
					{
						request.setAttribute("titulo", "Cadastro - Organograma");
						return "cadastro_organograma.jsp";
					}
					
					//Grande jogada				
					request.setAttribute("organograma", organogramaDAO.getOrganograma(Integer.valueOf(request.getParameter("codigo"))));
					
					} catch (NumberFormatException e) {
						
						// Se o numero n�o for v�lido
						request.setAttribute("mensagem", "Valo do c�digo inv�lido:"+request.getParameter("codigo"));
						
					} catch (SQLException e) {
						 
						request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
						e.printStackTrace();
					}				
						//Caso funcione td corretamente. Seta o atributo
						request.setAttribute("titulo", "Atualiza��o - Organograma");				
						return "atualiza_organograma.jsp";
			}
	}

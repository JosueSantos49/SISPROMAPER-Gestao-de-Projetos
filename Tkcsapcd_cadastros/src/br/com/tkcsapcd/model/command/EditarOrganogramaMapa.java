/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceOrganogramaMapaDAO;

public class EditarOrganogramaMapa implements InterfaceCommand {

	private InterfaceOrganogramaMapaDAO organogramaMapaDAO;
	public EditarOrganogramaMapa(InterfaceOrganogramaMapaDAO organogramaMapaDAO) {
		super();
		this.organogramaMapaDAO = organogramaMapaDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception  {			
			try{						
					if(request.getParameter("codigo") == null)
					{
						request.setAttribute("titulo", "Cadastro - Organograma Mapa");
						return "cadastro_organograma_mapa.jsp";
					}
					
					//Grande jogada				
					request.setAttribute("organogramaMapa", organogramaMapaDAO.getOrganogramaMapa(Integer.valueOf(request.getParameter("codigo"))));
					
					} catch (NumberFormatException e) {
						
						// Se o numero não for válido
						request.setAttribute("mensagem", "Valo do código inválido:"+request.getParameter("codigo"));
						
					} catch (SQLException e) {
						 
						request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
						e.printStackTrace();
					}				
						//Caso funcione td corretamente. Seta o atributo
						request.setAttribute("titulo", "Atualização - Organograma Mapa");				
						return "atualiza_organograma_mapa.jsp";
			}
	}

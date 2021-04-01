/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceListaMarcosDAO;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;

public class EditarListaMarcos implements InterfaceCommand {

	private InterfaceListaMarcosDAO listaMarcosDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	public EditarListaMarcos(InterfaceListaMarcosDAO listaMarcosDAO, InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.listaMarcosDAO = listaMarcosDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception {			
			try{			
				//Setando o atributo projetosInicio, para listar no select da pagina cadastro.
				request.setAttribute("projetoInicios", projetoInicioDAO.getProjetoInicios());
				
					if(request.getParameter("codigo") == null)
					{
						request.setAttribute("titulo", "Cadastro - Lista dos Marcos");
						return "cadastro_lista_marcos.jsp";
					}
					
					//Grande jogada				
					request.setAttribute("listaMarcos", listaMarcosDAO.getListaMarcos(Integer.valueOf(request.getParameter("codigo"))));
					
					} catch (NumberFormatException e) {
						
						// Se o numero não for válido
						request.setAttribute("mensagem", "Valo do código inválido:"+request.getParameter("codigo"));
						
					} catch (SQLException e) {
						 
						request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
						e.printStackTrace();
					}				
						//Caso funcione td corretamente. Seta o atributo
						request.setAttribute("titulo", "Atualização - Lista dos Marcos");				
						return "atualiza_lista_marcos.jsp";
			}
	}

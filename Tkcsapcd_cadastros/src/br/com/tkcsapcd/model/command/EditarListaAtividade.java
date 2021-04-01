/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceListaAtividadeDAO;

public class EditarListaAtividade implements InterfaceCommand {

	private InterfaceListaAtividadeDAO listaAtividadeDAO;
	public EditarListaAtividade(InterfaceListaAtividadeDAO listaAtividadeDAO) {
		super();
		this.listaAtividadeDAO = listaAtividadeDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception  {			
			try{						
					if(request.getParameter("codigo") == null)
					{
						request.setAttribute("titulo", "Cadastro - LISTA DAS ATIVIDADES");
						return "cadastro_lista_atividade.jsp";
					}
					
					//Grande jogada				
					request.setAttribute("listaAtividade", listaAtividadeDAO.getListaAtividade(Integer.valueOf(request.getParameter("codigo"))));
					
					} catch (NumberFormatException e) {
						
						// Se o numero não for válido
						request.setAttribute("mensagem", "Valo do código inválido:"+request.getParameter("codigo"));
						
					} catch (SQLException e) {
						 
						request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
						e.printStackTrace();
					}				
						//Caso funcione td corretamente. Seta o atributo
						request.setAttribute("titulo", "Atualização - LISTA DAS ATIVIDADES");				
						return "atualiza_lista_atividade.jsp";
			}
	}

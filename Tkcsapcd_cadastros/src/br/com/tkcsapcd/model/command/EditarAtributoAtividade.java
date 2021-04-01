/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceAtributoAtividadeDAO;
import br.com.tkcsapcd.model.dao.InterfaceOrganogramaDAO;

public class EditarAtributoAtividade implements InterfaceCommand {

	private InterfaceAtributoAtividadeDAO atributoAtividadeDAO;
	private InterfaceOrganogramaDAO organogramaDAO;
	public EditarAtributoAtividade(InterfaceAtributoAtividadeDAO atributoAtividadeDAO, InterfaceOrganogramaDAO organogramaDAO) {
		super();
		this.atributoAtividadeDAO = atributoAtividadeDAO;
		this.organogramaDAO = organogramaDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception {			
			try{
				//Setando o atributo, para listar no select da pagina cadastro.
				request.setAttribute("organogramas", organogramaDAO.getOrganogramas());
				
					if(request.getParameter("codigo") == null)
					{
						request.setAttribute("titulo", "Cadastro - Atributos das Atividades");
						return "cadastro_atributo_atividade.jsp";
					}
					
					//Grande jogada				
					request.setAttribute("atributoAtividade", atributoAtividadeDAO.getAtributoAtividade(Integer.valueOf(request.getParameter("codigo"))));
					
					} catch (NumberFormatException e) {
						
						// Se o numero n�o for v�lido
						request.setAttribute("mensagem", "Valo do c�digo inv�lido:"+request.getParameter("codigo"));
						
					} catch (SQLException e) {
						 
						request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
						e.printStackTrace();
					}				
						//Caso funcione td corretamente. Seta o atributo
						request.setAttribute("titulo", "Atualiza��o - Atributos das Atividades");				
						return "atualiza_atributo_atividade.jsp";
			}
	}

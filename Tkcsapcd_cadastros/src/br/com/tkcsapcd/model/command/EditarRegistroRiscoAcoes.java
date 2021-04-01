/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceRegistroRiscoAcoesDAO;
import br.com.tkcsapcd.model.dao.InterfaceRegistroRiscoDAO;

public class EditarRegistroRiscoAcoes implements InterfaceCommand {

	private InterfaceRegistroRiscoAcoesDAO registroRiscoAcoesDAO;
	private InterfaceRegistroRiscoDAO registroRiscoDAO;
	public EditarRegistroRiscoAcoes(InterfaceRegistroRiscoAcoesDAO registroRiscoAcoesDAO, InterfaceRegistroRiscoDAO registroRiscoDAO) {
		super();
		this.registroRiscoAcoesDAO = registroRiscoAcoesDAO;
		this.registroRiscoDAO = registroRiscoDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception {			
			try{			
					//Setando o atributo, para listar no select da pagina cadastro.
					request.setAttribute("registroRiscos", registroRiscoDAO.getRegistroRiscos());
				
					if(request.getParameter("codigo") == null)
					{
						request.setAttribute("titulo", "Cadastro - REGISTRO DOS RISCOS AÇÕES");
						return "cadastro_registro_risco_acoes.jsp";
					}
					
					//Grande jogada				
					request.setAttribute("registroRiscoAcoes", registroRiscoAcoesDAO.getRegistroRiscoAcoes(Integer.valueOf(request.getParameter("codigo"))));
					
					} catch (NumberFormatException e) {
						
						// Se o numero não for válido
						request.setAttribute("mensagem", "Valo do código inválido:"+request.getParameter("codigo"));
						
					} catch (SQLException e) {
						 
						request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
						e.printStackTrace();
					}				
						//Caso funcione td corretamente. Seta o atributo
						request.setAttribute("titulo", "Atualização - REGISTRO DOS RISCOS AÇÕES");				
						return "atualiza_registro_risco_acoes.jsp";
			}
	}

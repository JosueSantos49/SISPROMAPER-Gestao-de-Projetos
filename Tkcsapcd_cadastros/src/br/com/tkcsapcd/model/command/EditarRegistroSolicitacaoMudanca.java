/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.dao.InterfaceRegistroSolicitacaoMudancaDAO;

public class EditarRegistroSolicitacaoMudanca implements InterfaceCommand {

	private InterfaceRegistroSolicitacaoMudancaDAO registroSolicitacaoMudancaDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	public EditarRegistroSolicitacaoMudanca(InterfaceRegistroSolicitacaoMudancaDAO registroSolicitacaoMudancaDAO, InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.registroSolicitacaoMudancaDAO = registroSolicitacaoMudancaDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception {			
			try{						
				//Setando o atributo projetosInicio, para listar no select da pagina cadastro.
				request.setAttribute("projetoInicios", projetoInicioDAO.getProjetoInicios());
				
					if(request.getParameter("codigo") == null)
					{
						request.setAttribute("titulo", "Cadastro - REGISTRO SOLICITA��O DE MUDAN�A");
						return "cadastro_registro_solicitacao_mudanca.jsp";
					}
					
					//Grande jogada				
					request.setAttribute("registroSolicitacaoMudanca", registroSolicitacaoMudancaDAO.getRegistroSolicitacaoMudanca(Integer.valueOf(request.getParameter("codigo"))));
					
					} catch (NumberFormatException e) {
						
						// Se o numero n�o for v�lido
						request.setAttribute("mensagem", "Valo do c�digo inv�lido:"+request.getParameter("codigo"));
						
					} catch (SQLException e) {
						 
						request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
						e.printStackTrace();
					}				
						//Caso funcione td corretamente. Seta o atributo
						request.setAttribute("titulo", "Atualiza��o - REGISTRO SOLICITA��O DE MUDAN�A");				
						return "atualiza_registro_solicitacao_mudanca.jsp";
			}
	}

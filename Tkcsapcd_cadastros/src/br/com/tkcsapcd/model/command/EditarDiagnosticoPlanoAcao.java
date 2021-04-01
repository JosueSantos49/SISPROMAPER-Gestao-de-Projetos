/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceDiagnosticoPlanoAcaoDAO;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;

public class EditarDiagnosticoPlanoAcao implements InterfaceCommand {

	private InterfaceDiagnosticoPlanoAcaoDAO diagnosticoPlanoAcaoDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	public EditarDiagnosticoPlanoAcao(InterfaceDiagnosticoPlanoAcaoDAO diagnosticoPlanoAcaoDAO, InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.diagnosticoPlanoAcaoDAO = diagnosticoPlanoAcaoDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception {			
			try{						
				//Setando o atributo projetosInicio, para listar no select da pagina cadastro.
				request.setAttribute("projetoInicios", projetoInicioDAO.getProjetoInicios());
				
					if(request.getParameter("codigo") == null)
					{
						request.setAttribute("titulo", "Cadastro - Diagn�stico e Plano de A��o");
						return "cadastro_diagnostico_plano_acao.jsp";
					}
					
					//Grande jogada				
					request.setAttribute("diagnosticoPlanoAcao", diagnosticoPlanoAcaoDAO.getDiagnosticoPlanoAcao(Integer.valueOf(request.getParameter("codigo"))));
					
					} catch (NumberFormatException e) {
						
						// Se o numero n�o for v�lido
						request.setAttribute("mensagem", "Valo do c�digo inv�lido:"+request.getParameter("codigo"));
						
					} catch (SQLException e) {
						 
						request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
						e.printStackTrace();
					}				
						//Caso funcione td corretamente. Seta o atributo
						request.setAttribute("titulo", "Atualiza��o - Diagn�stico e Plano de A��o");				
						return "atualiza_diagnostico_plano_acao.jsp";
			}
	}

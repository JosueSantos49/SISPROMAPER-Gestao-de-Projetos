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
import br.com.tkcsapcd.model.dao.InterfaceProjetoTermoEncerramentoDAO;

public class EditarProjetoTermoEncerramento implements InterfaceCommand {

	private InterfaceProjetoTermoEncerramentoDAO projetoTermoEncerramentoDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	
	public EditarProjetoTermoEncerramento(InterfaceProjetoTermoEncerramentoDAO projetoTermoEncerramentoDAO, InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.projetoTermoEncerramentoDAO = projetoTermoEncerramentoDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception {			
			try{			
				//Setando o atributo projetosInicio, para listar no select da pagina cadastro.
				request.setAttribute("projetoInicios", projetoInicioDAO.getProjetoInicios());
				
					if(request.getParameter("codigo") == null)
					{
						request.setAttribute("titulo", "Cadastro - Termo de Encerramento do Projeto");
						return "cadastro_termoencerramentoprojeto.jsp";
					}
					
					//Grande jogada				
					request.setAttribute("projetotermoencerramento", projetoTermoEncerramentoDAO.getProjetoTermoEncerramento(Integer.valueOf(request.getParameter("codigo"))));
					
					} catch (NumberFormatException e) {
						
						// Se o numero n�o for v�lido
						request.setAttribute("mensagem", "Valo do c�digo inv�lido:"+request.getParameter("codigo"));
						
					} catch (SQLException e) {
						 
						request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
						e.printStackTrace();
					}				
						//Caso funcione td corretamente. Seta o atributo
						request.setAttribute("titulo", "Atualiza��o - Termo de Encerramento do Projeto");				
						return "atualiza_termoencerramentoprojeto.jsp";
			}
	}

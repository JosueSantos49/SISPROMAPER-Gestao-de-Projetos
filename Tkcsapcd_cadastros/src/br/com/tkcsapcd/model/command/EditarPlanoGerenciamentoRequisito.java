/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfacePlanoGerenciamentoRequisitoDAO;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;

public class EditarPlanoGerenciamentoRequisito implements InterfaceCommand {

	private InterfacePlanoGerenciamentoRequisitoDAO planoGerenciamentoRequisitoDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	public EditarPlanoGerenciamentoRequisito(InterfacePlanoGerenciamentoRequisitoDAO planoGerenciamentoRequisitoDAO, InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.planoGerenciamentoRequisitoDAO = planoGerenciamentoRequisitoDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception  {			
			try{
					//Setando o atributo projetos, para listar so select da pagina cadastro e atualizar.
					request.setAttribute("projetoInicios", projetoInicioDAO.getProjetoInicios());
				
					if(request.getParameter("codigo") == null)
					{
						request.setAttribute("titulo", "Cadastro - PLANO DE GERENCIAMENTO DOS REQUISITOS");
						return "cadastro_plano_gerenciamento_requisito.jsp";
					}
					
					//Grande jogada				
					request.setAttribute("planoGerenciamentoRequisito", planoGerenciamentoRequisitoDAO.getPlanoGerenciamentoRequisito(Integer.valueOf(request.getParameter("codigo"))));
					
					} catch (NumberFormatException e) {
						
						// Se o numero não for válido
						request.setAttribute("mensagem", "Valo do código inválido:"+request.getParameter("codigo"));
						
					} catch (SQLException e) {
						 
						request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
						e.printStackTrace();
					}				
						//Caso funcione td corretamente. Seta o atributo
						request.setAttribute("titulo", "Atualização - PLANO DE GERENCIAMENTO DOS REQUISITOS");				
						return "atualiza_plano_gerenciamento_requisito.jsp";
			}
	}

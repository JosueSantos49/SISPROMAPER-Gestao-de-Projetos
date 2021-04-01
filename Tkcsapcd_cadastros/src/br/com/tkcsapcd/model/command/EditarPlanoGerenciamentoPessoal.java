/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfacePlanoGerenciamentoPessoalDAO;

public class EditarPlanoGerenciamentoPessoal implements InterfaceCommand {

	private InterfacePlanoGerenciamentoPessoalDAO planoGerenciamentoPessoalDAO;
	public EditarPlanoGerenciamentoPessoal(InterfacePlanoGerenciamentoPessoalDAO planoGerenciamentoPessoalDAO) {
		super();
		this.planoGerenciamentoPessoalDAO = planoGerenciamentoPessoalDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception {			
			try{						
					if(request.getParameter("codigo") == null)
					{
						request.setAttribute("titulo", "Cadastro - PLANO DE GERENCIAMENTO DO PESSOAL");
						return "cadastro_plano_gerenciamento_pessoal.jsp";
					}
					
					//Grande jogada				
					request.setAttribute("planoGerenciamentoPessoal", planoGerenciamentoPessoalDAO.getPlanoGerenciamentoPessoal(Integer.valueOf(request.getParameter("codigo"))));
					
					} catch (NumberFormatException e) {
						
						// Se o numero não for válido
						request.setAttribute("mensagem", "Valo do código inválido:"+request.getParameter("codigo"));
						
					} catch (SQLException e) {
						 
						request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
						e.printStackTrace();
					}				
						//Caso funcione td corretamente. Seta o atributo
						request.setAttribute("titulo", "Atualização - PLANO DE GERENCIAMENTO DO PESSOAL");				
						return "atualiza_plano_gerenciamento_pessoal.jsp";
			}
	}

/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceEnvolvimentoPessoaProjetoInicioDAO;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.dao.InterfaceRecursosHumanosDAO;

public class EditarEnvolvimentoPessoaProjetoInicio implements InterfaceCommand {

	private InterfaceEnvolvimentoPessoaProjetoInicioDAO envolvimentoPessoaProjetoInicioDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	private InterfaceRecursosHumanosDAO recursosHumanosDAO;
	public EditarEnvolvimentoPessoaProjetoInicio(InterfaceEnvolvimentoPessoaProjetoInicioDAO envolvimentoPessoaProjetoInicioDAO, InterfaceProjetoInicioDAO projetoInicioDAO, InterfaceRecursosHumanosDAO recursosHumanosDAO) {
		super();
		this.envolvimentoPessoaProjetoInicioDAO = envolvimentoPessoaProjetoInicioDAO;
		this.projetoInicioDAO = projetoInicioDAO;
		this.recursosHumanosDAO = recursosHumanosDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception {			
			try{						
				//Setando o atributo projetosInicio, para listar no select da pagina cadastro.
				request.setAttribute("projetoInicios", projetoInicioDAO.getProjetoInicios());
				request.setAttribute("recursosHumanoss", recursosHumanosDAO.getRecursosHumanoss());
				
					if(request.getParameter("codigo") == null)
					{
						request.setAttribute("titulo", "Cadastro - Envolvimento Pessoa Projeto");
						return "cadastro_envolvimento_pessoa_projeto.jsp";
					}
					
					//Grande jogada				
					request.setAttribute("envolvimentoPessoaProjetoInicio", envolvimentoPessoaProjetoInicioDAO.getEnvolvimentoPessoaProjetoInicio(Integer.valueOf(request.getParameter("codigo"))));
					
					} catch (NumberFormatException e) {
						
						// Se o numero não for válido
						request.setAttribute("mensagem", "Valo do código inválido:"+request.getParameter("codigo"));
						
					} catch (SQLException e) {
						 
						request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
						e.printStackTrace();
					}				
						//Caso funcione td corretamente. Seta o atributo
						request.setAttribute("titulo", "Atualização - Envolvimento Pessoa Projeto");	
						//return "TkcsapcdController?cmd=consultarProjetoInicio"; //testando 
						return "atualiza_envolvimento_pessoa_projeto.jsp"; //formatação certa
			}
	}

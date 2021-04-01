/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceAlocacaoDAO;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.dao.InterfaceRecursosHumanosDAO;

public class EditarAlocacao implements InterfaceCommand {

	private InterfaceAlocacaoDAO alocacaoDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	private InterfaceRecursosHumanosDAO recursosHumanosDAO;

	//Deve ser cadastrado no helpe
	public EditarAlocacao(InterfaceAlocacaoDAO alocacaoDAO,
			InterfaceProjetoInicioDAO projetoInicioDAO,
			InterfaceRecursosHumanosDAO recursosHumanosDAO) {
		super();
		this.alocacaoDAO = alocacaoDAO;
		this.projetoInicioDAO = projetoInicioDAO;
		this.recursosHumanosDAO = recursosHumanosDAO;
	}

	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception {	
		
			try{	
					//Setando o atributo projetos e recursoshumanos, para listar so select da pagina cadastro e atualizar.
					request.setAttribute("projetoInicios", projetoInicioDAO.getProjetoInicios());
					request.setAttribute("recursosHumanoss", recursosHumanosDAO.getRecursosHumanoss());
					
					if(request.getParameter("codigo") == null)
					{
						request.setAttribute("titulo", "Cadastro - Alocação");
						return "cadastro_alocacao.jsp";
					}
					
					//Grande jogada				
					request.setAttribute("alocacao", alocacaoDAO.getAlocacao(Integer.valueOf(request.getParameter("codigo"))));
					
					} catch (NumberFormatException e) {
						
						// Se o numero não for válido
						request.setAttribute("mensagem", "Valo do código inválido:"+request.getParameter("codigo"));
						
					} catch (SQLException e) {
						 
						request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
						e.printStackTrace();
					}				
						//Caso funcione td corretamente. Seta o atributo
						request.setAttribute("titulo", "Atualização - Alocação");				
						return "atualiza_alocacao.jsp";
			}
	}

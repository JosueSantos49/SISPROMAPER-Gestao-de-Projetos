/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.dao.InterfaceSolicitacaoServicoTIDAO;

public class EditarSolicitacaoServicoTI implements InterfaceCommand {

	private InterfaceSolicitacaoServicoTIDAO solicitacaoServicoTIDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;

	//Deve ser cadastrado no helpe
	public EditarSolicitacaoServicoTI(InterfaceSolicitacaoServicoTIDAO solicitacaoServicoTIDAO,
			InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.solicitacaoServicoTIDAO = solicitacaoServicoTIDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}

	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception {	
		
			try{	
					//Setando o atributo projetos e recursoshumanos, para listar so select da pagina cadastro e atualizar.
					request.setAttribute("projetoInicios", projetoInicioDAO.getProjetoInicios());
					
					if(request.getParameter("codigo") == null)
					{
						request.setAttribute("titulo", "Cadastro - SSTI");
						return "cadastro_solicitacaoservicoti.jsp";
					}
					
					//Grande jogada				
					request.setAttribute("solicitacaoServicoTI", solicitacaoServicoTIDAO.getSolicitacaoServicoTI(Integer.valueOf(request.getParameter("codigo"))));
					
					} catch (NumberFormatException e) {
						
						// Se o numero não for válido
						request.setAttribute("mensagem", "Valo do código inválido:"+request.getParameter("codigo"));
						
					} catch (SQLException e) {
						 
						request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
						e.printStackTrace();
					}				
						//Caso funcione td corretamente. Seta o atributo
						request.setAttribute("titulo", "Atualização - SSTI");				
						return "atualiza_solicitacaoservicoti.jsp";
			}
	}

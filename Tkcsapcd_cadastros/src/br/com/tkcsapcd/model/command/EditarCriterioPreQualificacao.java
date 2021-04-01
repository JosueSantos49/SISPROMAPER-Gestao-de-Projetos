/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceCriterioPreQualificacaoDAO;

public class EditarCriterioPreQualificacao implements InterfaceCommand {

	private InterfaceCriterioPreQualificacaoDAO criterioPreQualificacaoDAO;
	public EditarCriterioPreQualificacao(InterfaceCriterioPreQualificacaoDAO criterioPreQualificacaoDAO) {
		super();
		this.criterioPreQualificacaoDAO = criterioPreQualificacaoDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception  {			
			try{						
					if(request.getParameter("codigo") == null)
					{
						request.setAttribute("titulo", "Cadastro - SELE��O DE FONTE (PR� QUALIFICA��O)");
						return "cadastro_criterio_pre_qualificacao.jsp";
					}
					
					//Grande jogada				
					request.setAttribute("criterioPreQualificacao", criterioPreQualificacaoDAO.getCriterioPreQualificacao(Integer.valueOf(request.getParameter("codigo"))));
					
					} catch (NumberFormatException e) {
						
						// Se o numero n�o for v�lido
						request.setAttribute("mensagem", "Valo do c�digo inv�lido:"+request.getParameter("codigo"));
						
					} catch (SQLException e) {
						 
						request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
						e.printStackTrace();
					}				
						//Caso funcione td corretamente. Seta o atributo
						request.setAttribute("titulo", "Atualiza��o - PLANO DE GERENCIAMENTO DA QUALIDADE");				
						return "atualiza_criterio_pre_qualificacao.jsp";
			}
	}

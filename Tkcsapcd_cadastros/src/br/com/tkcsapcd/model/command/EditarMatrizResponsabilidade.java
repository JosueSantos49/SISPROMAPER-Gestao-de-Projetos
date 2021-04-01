/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceMatrizResponsabilidadeDAO;

public class EditarMatrizResponsabilidade implements InterfaceCommand {

	private InterfaceMatrizResponsabilidadeDAO matrizResponsabilidadeDAO;
	
	public EditarMatrizResponsabilidade(InterfaceMatrizResponsabilidadeDAO matrizResponsabilidadeDAO) {
		super();
		this.matrizResponsabilidadeDAO = matrizResponsabilidadeDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception {			
			try{						
				//Setando o atributo projetosInicio, para listar no select da pagina cadastro.
				request.setAttribute("matrizResponsabilidades", matrizResponsabilidadeDAO.getMatrizResponsabilidades());
				
				
					if(request.getParameter("codigo") == null)
					{
						request.setAttribute("titulo", "Cadastro - Matriz de Responsabilidade RACI");
						return "cadastro_matriz_reponsabilidade.jsp";
					}
					
					//Grande jogada				
					request.setAttribute("matrizResponsabilidade", matrizResponsabilidadeDAO.getMatrizResponsabilidade(Integer.valueOf(request.getParameter("codigo"))));
					
					} catch (NumberFormatException e) {
						
						// Se o numero não for válido
						request.setAttribute("mensagem", "Valo do código inválido:"+request.getParameter("codigo"));
						
					} catch (SQLException e) {
						 
						request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
						e.printStackTrace();
					}				
						//Caso funcione td corretamente. Seta o atributo
						request.setAttribute("titulo", "Atualização - Matriz de Responsabilidade RACI");
						//return "cadastro_matriz_reponsabilidade.jsp";
						return "atualiza_matriz_reponsabilidade.jsp"; //formatação certa
			}
	}

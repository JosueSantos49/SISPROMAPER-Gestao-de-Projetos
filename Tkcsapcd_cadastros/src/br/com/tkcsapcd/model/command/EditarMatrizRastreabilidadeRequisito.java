/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceMatrizRastreabilidadeRequisitoDAO;

public class EditarMatrizRastreabilidadeRequisito implements InterfaceCommand {

	private InterfaceMatrizRastreabilidadeRequisitoDAO matrizRastreabilidadeRequisitoDAO;
	public EditarMatrizRastreabilidadeRequisito(InterfaceMatrizRastreabilidadeRequisitoDAO matrizRastreabilidadeRequisitoDAO) {
		super();
		this.matrizRastreabilidadeRequisitoDAO = matrizRastreabilidadeRequisitoDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception  {			
			try{						
					if(request.getParameter("codigo") == null)
					{
						request.setAttribute("titulo", "Cadastro - MATRIZ DE RASTREABILIDADE DOS REQUISITOS");
						return "cadastro_matriz_rastreabilidade_requisito.jsp";
					}
					
					//Grande jogada				
					request.setAttribute("matrizRastreabilidadeRequisito", matrizRastreabilidadeRequisitoDAO.getMatrizRastreabilidadeRequisito(Integer.valueOf(request.getParameter("codigo"))));
					
					} catch (NumberFormatException e) {
						
						// Se o numero não for válido
						request.setAttribute("mensagem", "Valo do código inválido:"+request.getParameter("codigo"));
						
					} catch (SQLException e) {
						 
						request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
						e.printStackTrace();
					}				
						//Caso funcione td corretamente. Seta o atributo
						request.setAttribute("titulo", "Atualização - MATRIZ DE RASTREABILIDADE DOS REQUISITOS");				
						return "atualiza_matriz_rastreabilidade_requisito.jsp";
			}
	}

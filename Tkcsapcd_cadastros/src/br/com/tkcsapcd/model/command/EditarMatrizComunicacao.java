/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceMatrizComunicacaoDAO;

public class EditarMatrizComunicacao implements InterfaceCommand {

	private InterfaceMatrizComunicacaoDAO matrizComunicacaoDAO;
	public EditarMatrizComunicacao(InterfaceMatrizComunicacaoDAO matrizComunicacaoDAO) {
		super();
		this.matrizComunicacaoDAO = matrizComunicacaoDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception  {			
			try{						
					if(request.getParameter("codigo") == null)
					{
						request.setAttribute("titulo", "Cadastro - MATRIZ DAS COMUNICA��ES");
						return "cadastro_matriz_comunicacao.jsp";
					}
					
					//Grande jogada				
					request.setAttribute("matrizComunicacao", matrizComunicacaoDAO.getMatrizComunicacao(Integer.valueOf(request.getParameter("codigo"))));
					
					} catch (NumberFormatException e) {
						
						// Se o numero n�o for v�lido
						request.setAttribute("mensagem", "Valo do c�digo inv�lido:"+request.getParameter("codigo"));
						
					} catch (SQLException e) {
						 
						request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
						e.printStackTrace();
					}				
						//Caso funcione td corretamente. Seta o atributo
						request.setAttribute("titulo", "Atualiza��o - MATRIZ DAS COMUNICA��ES");				
						return "atualiza_matriz_comunicacao.jsp";
			}
	}

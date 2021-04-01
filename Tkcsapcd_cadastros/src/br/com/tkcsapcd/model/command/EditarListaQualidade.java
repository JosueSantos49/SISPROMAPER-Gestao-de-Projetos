/* 
O	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceListaQualidadeDAO;

public class EditarListaQualidade implements InterfaceCommand {

	private InterfaceListaQualidadeDAO listaQualidadeDAO;
	public EditarListaQualidade(InterfaceListaQualidadeDAO listaQualidadeDAO) {
		super();
		this.listaQualidadeDAO = listaQualidadeDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception  {			
			try{						
					if(request.getParameter("codigo") == null)
					{
						request.setAttribute("titulo", "Cadastro - Lista de Verifica��o da Qualidade");
						return "cadastro_lista_qualidade.jsp";
					}
					
					//Grande jogada				
					request.setAttribute("listaQualidade", listaQualidadeDAO.getListaQualidade(Integer.valueOf(request.getParameter("codigo"))));
					
					} catch (NumberFormatException e) {
						
						// Se o numero n�o for v�lido
						request.setAttribute("mensagem", "Valo do c�digo inv�lido:"+request.getParameter("codigo"));
						
					} catch (SQLException e) {
						 
						request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
						e.printStackTrace();
					}				
						//Caso funcione td corretamente. Seta o atributo
						request.setAttribute("titulo", "Atualiza��o - Lista de Verifica��o da Qualidade");				
						return "atualiza_lista_qualidade.jsp";
			}
	}

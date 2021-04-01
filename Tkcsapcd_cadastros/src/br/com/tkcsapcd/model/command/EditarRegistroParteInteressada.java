/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceRegistroParteInteressadaDAO;

public class EditarRegistroParteInteressada implements InterfaceCommand {

	private InterfaceRegistroParteInteressadaDAO registroParteInteressadaDAO;
	public EditarRegistroParteInteressada(InterfaceRegistroParteInteressadaDAO registroParteInteressadaDAO) {
		super();
		this.registroParteInteressadaDAO = registroParteInteressadaDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception {			
			try{						
					if(request.getParameter("codigo") == null)
					{
						request.setAttribute("titulo", "Cadastro - REGISTRO DAS PARTES INTERESSADAS");
						return "cadastro_registro_parte_interessada.jsp";
					}
					
					//Grande jogada				
					request.setAttribute("registroParteInteressada", registroParteInteressadaDAO.getRegistroParteInteressada(Integer.valueOf(request.getParameter("codigo"))));
					
					} catch (NumberFormatException e) {
						
						// Se o numero não for válido
						request.setAttribute("mensagem", "Valo do código inválido:"+request.getParameter("codigo"));
						
					} catch (SQLException e) {
						 
						request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
						e.printStackTrace();
					}				
						//Caso funcione td corretamente. Seta o atributo
						request.setAttribute("titulo", "Atualização - REGISTRO DAS PARTES INTERESSADAS");				
						return "atualiza_registro_parte_interessada.jsp";
			}
	}

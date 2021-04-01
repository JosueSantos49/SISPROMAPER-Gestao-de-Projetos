/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceUsuarioDAO;

public class EditarUsuario implements InterfaceCommand {

	private InterfaceUsuarioDAO usuarioDAO;
	public EditarUsuario(InterfaceUsuarioDAO usuarioDAO) {
		super();
		this.usuarioDAO = usuarioDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception  {			
			try{						
					if(request.getParameter("log_codigo") == null)
					{
						request.setAttribute("titulo", "Cadastro - Usuário");
						return "cadastro_usuarios.jsp";
					}
					
					//Grande jogada				
					request.setAttribute("usuario", usuarioDAO.getUsuario(Integer.valueOf(request.getParameter("log_codigo"))));
					
					} catch (NumberFormatException e) {
						
						// Se o numero não for válido
						request.setAttribute("mensagem", "Valo do código inválido:"+request.getParameter("log_codigo"));
						
					} catch (SQLException e) {
						 
						request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
						e.printStackTrace();
					}				
						//Caso funcione td corretamente. Seta o atributo
						request.setAttribute("titulo", "Atualização - Usuário");				
						return "atualiza_usuarios.jsp";
			}
	}

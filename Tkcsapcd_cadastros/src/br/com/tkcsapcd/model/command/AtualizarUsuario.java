/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.Usuario;
import br.com.tkcsapcd.model.dao.InterfaceUsuarioDAO;
import br.com.tkcsapcd.model.helper.Hash;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//M�todo registrado na InterfaceCommand
public class AtualizarUsuario implements InterfaceCommand {

	private InterfaceUsuarioDAO usuarioDAO;
	public AtualizarUsuario(InterfaceUsuarioDAO usuarioDAO) {
		super();
		this.usuarioDAO = usuarioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request					
					Usuario usuario= new Usuario();	
					
					usuario.setLog_codigo(Integer.valueOf(request.getParameter("log_codigo")));//Necessario, para essa citua��o
					usuario.setLog_usuario(request.getParameter("log_usuario"));
					usuario.setLog_senha(Hash.cripografar(request.getParameter("log_senha")));
					usuario.setLog_nivelacesso(request.getParameter("log_nivelacesso"));
					usuario.setLog_cpf(request.getParameter("log_cpf"));
					usuario.setLog_datacadastro(request.getParameter("log_datacadastro"));
					usuario.setNome(request.getParameter("nome"));
					usuario.setId(request.getParameter("id"));
					usuario.setGestorimediato(request.getParameter("gestorimediato"));				
					usuario.setDepartamento(request.getParameter("departamento"));					
					usuario.setEmail(request.getParameter("email"));
					usuario.setTelefone(request.getParameter("telefone"));
		
		if(ValidationHelper.validar(usuario)){			
			usuarioDAO.atualizar(usuario);
			request.setAttribute("mensagem", "Usu�rio: ("+usuario.getLog_codigo()+") atualizado com sucesso!");
		}
		else{
			throw new Exception("Valor inv�lido");
		}	
		} catch (SQLException e) {
			
			request.setAttribute("mensagem", "Problema com a atualiza��o: "+e.getMessage());
			e.printStackTrace();
			
		}catch (NumberFormatException e) {
			request.setAttribute("mensagem", "Valor inv�lido: "+e.getMessage());			
		}	
			request.setAttribute("titulo", "Atualiza��o - Usu�rio");
			return "TkcsapcdController?cmd=consultarUsuario";//Pagina de Retorno (pagina consulta)
	}

}

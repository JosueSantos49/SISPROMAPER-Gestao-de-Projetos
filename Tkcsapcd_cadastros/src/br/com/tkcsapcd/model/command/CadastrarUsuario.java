/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.Usuario;
import br.com.tkcsapcd.model.dao.InterfaceUsuarioDAO;
import br.com.tkcsapcd.model.email.EnviaEmail;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.Hash;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarUsuario implements InterfaceCommand {

	private InterfaceUsuarioDAO usuarioDAO;
	public CadastrarUsuario(InterfaceUsuarioDAO usuarioDAO) {
		super();
		this.usuarioDAO = usuarioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			Usuario usuario= new Usuario();	
			
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
			
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM login WHERE log_cpf = '"+request.getParameter("log_cpf")+"'");// pega a conex�o e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer log_cpf = rs.getInt("log_cpf");
				
				if(log_cpf >= 1){
					System.out.println("O c�digo � igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('J� existe um registro com o CPF ("+usuario.getLog_cpf()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarUsuario";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O CFP n�o � igual!");
					usuarioDAO.salvar(usuario);
					request.setAttribute("mensagem", "Usu�rio: ("+usuario.getLog_cpf()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O c�digo n�o � igual!");
					usuarioDAO.salvar(usuario);
					request.setAttribute("mensagem", "Usu�rio: ("+usuario.getLog_cpf()+") cadastrado com sucesso!");
					
					//Regra que objetiva disparar um e-mail autom�tico como confirma��o de registro.
					//String de 		= request.getParameter("de");
					String para 	= request.getParameter("email"); //Enviar e-mail de confirma��o de registro
					//String assunto 	= request.getParameter("assunto");
					//String mensagem = request.getParameter("mensagem");
					//String lista 	= request.getParameter("lista");
					//String file		= request.getParameter("file");
							
					RequestDispatcher rd = null;
					
					EnviaEmail enviaEmail = new EnviaEmail();
					
						//enviaEmail.setDe(de);
						enviaEmail.setPara(para);
						//enviaEmail.setAssunto(assunto);
						//enviaEmail.setMensagem(mensagem);			
						//enviaEmail.setLista(lista);		
						//enviaEmail.setFile(file);
					
					boolean enviado = enviaEmail.enviarUsuario();		
					
					if(enviado)
						request.setAttribute("msg","Enviado confirma��o de registro por e-mail!");
					else
						request.setAttribute("msg","N�o, enviado c�pia de confirma��o de registro por e-mail!");			
					
					rd = request.getRequestDispatcher("TkcsapcdController?cmd=editarUsuario");
					rd.forward(request, response);
					
			}
			else{
				throw new Exception("Valor inv�lido");
			}
			} catch (SQLException e) {
				
				request.setAttribute("mensagem", "Problemas com a grava��o: "+e.getMessage());
				e.printStackTrace();
				
			}catch (NumberFormatException e){
				
				request.setAttribute("mensagem", "Valor inv�lido: "+e.getMessage());
				e.printStackTrace();
			}
				request.setAttribute("titulo", "Cadastro - Usu�rio");
				return "TkcsapcdController?cmd=editarUsuario";//devolver p/ editar cadastro		
	}
}

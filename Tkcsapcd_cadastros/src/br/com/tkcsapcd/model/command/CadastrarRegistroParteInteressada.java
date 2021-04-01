/* 
	Autor: Josué da Conceição Santos
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

import br.com.tkcsapcd.model.bean.RegistroParteInteressada;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.dao.InterfaceRegistroParteInteressadaDAO;
import br.com.tkcsapcd.model.email.EnviaEmail;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarRegistroParteInteressada implements InterfaceCommand {

	private InterfaceRegistroParteInteressadaDAO registroParteInteressadaDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	public CadastrarRegistroParteInteressada(InterfaceRegistroParteInteressadaDAO registroParteInteressadaDAO, InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.registroParteInteressadaDAO = registroParteInteressadaDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request			
			RegistroParteInteressada registroParteInteressada = new RegistroParteInteressada();
			
			registroParteInteressada.setRegistroparteinteressada(request.getParameter("registroparteinteressada"));
			registroParteInteressada.setVersao(request.getParameter("versao"));
			registroParteInteressada.setData(request.getParameter("data"));
			registroParteInteressada.setAutor(request.getParameter("autor"));
			registroParteInteressada.setNotarevisao(request.getParameter("notarevisao"));
			registroParteInteressada.setAprovacao(request.getParameter("aprovacao"));
			registroParteInteressada.setCodigoparteinteressada(Integer.valueOf(request.getParameter("codigoparteinteressada")));				
			registroParteInteressada.setImportancia(Integer.valueOf(request.getParameter("importancia")));					
			registroParteInteressada.setParteinteressada(request.getParameter("parteinteressada"));
			registroParteInteressada.setEmpresa(request.getParameter("empresa"));
			registroParteInteressada.setFuncaoprojeto(request.getParameter("funcaoprojeto"));
			registroParteInteressada.setEmail(request.getParameter("email"));
			registroParteInteressada.setCelular(request.getParameter("celular"));
			registroParteInteressada.setFone(request.getParameter("fone"));
			registroParteInteressada.setRequisito(request.getParameter("requisito"));
			registroParteInteressada.setResponsabilidade(request.getParameter("responsabilidade"));					
			registroParteInteressada.setExpectativas(request.getParameter("expectativas"));
			registroParteInteressada.setPoder(request.getParameter("poder"));
			registroParteInteressada.setInteresse(request.getParameter("interesse"));
			registroParteInteressada.setComentario(request.getParameter("comentario"));
			
			Integer projetoinicio = Integer.valueOf(request.getParameter("projetoinicio"));										
			registroParteInteressada.setProjetoinicio(projetoInicioDAO.getProjetoInicio(projetoinicio));
			
			if(ValidationHelper.validar(registroParteInteressada)){
				
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM registroparteinteressada WHERE projetoinicio = '"+request.getParameter("projetoinicio")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("projetoinicio");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+registroParteInteressada.getProjetoinicio().getProjeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarRegistroParteInteressada";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					registroParteInteressadaDAO.salvar(registroParteInteressada);
					request.setAttribute("mensagem", "REGISTRO DAS PARTES INTERESSADAS: ("+registroParteInteressada.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					registroParteInteressadaDAO.salvar(registroParteInteressada);
					request.setAttribute("mensagem", "REGISTRO DAS PARTES INTERESSADAS: ("+registroParteInteressada.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");	
					
					/*Regra que objetiva disparar um e-mail automático como confirmação de registro.
					 * O Metodo enviarForm() é responsável, por enviar e-mail de confirmação de envio de formulários.
					 */
					
					//String de 		= request.getParameter("de");
					String para 	= request.getParameter("para");
					String assunto 	= request.getParameter("projetoinicio");
					String mensagem = request.getParameter("registroparteinteressada");
					//String lista 	= request.getParameter("lista");
					//String file		= request.getParameter("file");
							
					RequestDispatcher rd = null;
					
					EnviaEmail enviaEmail = new EnviaEmail();
					
						//enviaEmail.setDe(de);
						enviaEmail.setPara(para);
						enviaEmail.setAssunto(assunto);
						enviaEmail.setMensagem(mensagem);			
						//enviaEmail.setLista(lista);		
						//enviaEmail.setFile(file);
					
					boolean enviado = enviaEmail.enviarForm();
					
					if(enviado)
						request.setAttribute("msg","Enviado confirmação de registro por e-mail!");
					else
						request.setAttribute("msg","Não, enviado cópia de confirmação de registro por e-mail!");
					rd = request.getRequestDispatcher("TkcsapcdController?cmd=editarRegistroParteInteressada");
					rd.forward(request,response);
			}
			else{
				throw new Exception("Valor inválido");
			}
			} catch (SQLException e) {
				
				request.setAttribute("mensagem", "Problemas com a gravação: "+e.getMessage());
				e.printStackTrace();
				
			}catch (NumberFormatException e){
				
				request.setAttribute("mensagem", "Valor inválido: "+e.getMessage());
				e.printStackTrace();
			}
				request.setAttribute("titulo", "Cadastro - REGISTRO DAS PARTES INTERESSADAS");
				return "TkcsapcdController?cmd=editarRegistroParteInteressada";//devolver p/ editar cadastro		
	}
}

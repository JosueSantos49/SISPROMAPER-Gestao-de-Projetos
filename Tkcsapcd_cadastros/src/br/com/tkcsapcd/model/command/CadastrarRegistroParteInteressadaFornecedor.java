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

import br.com.tkcsapcd.model.bean.RegistroParteInteressadaFornecedor;
import br.com.tkcsapcd.model.dao.InterfaceRegistroParteInteressadaFornecedorDAO;
import br.com.tkcsapcd.model.email.EnviaEmail;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarRegistroParteInteressadaFornecedor implements InterfaceCommand {

	private InterfaceRegistroParteInteressadaFornecedorDAO registroParteInteressadaFornecedorDAO;
	public CadastrarRegistroParteInteressadaFornecedor(InterfaceRegistroParteInteressadaFornecedorDAO registroParteInteressadaFornecedorDAO) {
		super();
		this.registroParteInteressadaFornecedorDAO = registroParteInteressadaFornecedorDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request			
			RegistroParteInteressadaFornecedor registroParteInteressadaFornecedor = new RegistroParteInteressadaFornecedor();
			
			registroParteInteressadaFornecedor.setRegistroparteinteressada(request.getParameter("registroparteinteressada"));
			registroParteInteressadaFornecedor.setProjeto(request.getParameter("projeto"));
			registroParteInteressadaFornecedor.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			registroParteInteressadaFornecedor.setVersao(request.getParameter("versao"));
			registroParteInteressadaFornecedor.setData(request.getParameter("data"));
			registroParteInteressadaFornecedor.setAutor(request.getParameter("autor"));
			registroParteInteressadaFornecedor.setNotarevisao(request.getParameter("notarevisao"));
			registroParteInteressadaFornecedor.setAprovacao(request.getParameter("aprovacao"));
			registroParteInteressadaFornecedor.setCodigofornecedor(Integer.valueOf(request.getParameter("codigofornecedor")));				
			registroParteInteressadaFornecedor.setRazaosocial(request.getParameter("razaosocial"));					
			registroParteInteressadaFornecedor.setFone(request.getParameter("fone"));
			registroParteInteressadaFornecedor.setSite(request.getParameter("site"));
			registroParteInteressadaFornecedor.setContrato(request.getParameter("contrato"));
			registroParteInteressadaFornecedor.setComentario(request.getParameter("comentario"));
			registroParteInteressadaFornecedor.setProposta(request.getParameter("proposta"));
			registroParteInteressadaFornecedor.setResponsabilidade(request.getParameter("responsabilidade"));
			registroParteInteressadaFornecedor.setControle(request.getParameter("controle"));
			
			if(ValidationHelper.validar(registroParteInteressadaFornecedor)){
			
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM fornecedor WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("codigoprojeto");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+registroParteInteressadaFornecedor.getCodigoprojeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarRegistroParteInteressadaFornecedor";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					registroParteInteressadaFornecedorDAO.salvar(registroParteInteressadaFornecedor);
					request.setAttribute("mensagem", "REGISTRO DAS PARTES INTERESSADAS: ("+registroParteInteressadaFornecedor.getCodigoprojeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					registroParteInteressadaFornecedorDAO.salvar(registroParteInteressadaFornecedor);
					request.setAttribute("mensagem", "REGISTRO DAS PARTES INTERESSADAS: ("+registroParteInteressadaFornecedor.getCodigoprojeto()+") cadastrado com sucesso!");			
					
					/*Regra que objetiva disparar um e-mail automático como confirmação de registro.
					 * O Metodo enviarForm() é responsável, por enviar e-mail de confirmação de envio de formulários.
					 */
					
					//String de 		= request.getParameter("de");
					String para 	= request.getParameter("para");
					String assunto 	= request.getParameter("codigoprojeto");
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
					
					rd = request.getRequestDispatcher("TkcsapcdController?cmd=editarRegistroParteInteressadaFornecedor");
					rd.forward(request, response);
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
				request.setAttribute("titulo", "Cadastro - REGISTRO DAS PARTES INTERESSADA FORNECEDOR");
				return "TkcsapcdController?cmd=editarRegistroParteInteressadaFornecedor";//devolver p/ editar cadastro		
	}
}

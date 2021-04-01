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
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.OrganogramaPropriedade;
import br.com.tkcsapcd.model.dao.InterfaceOrganogramaPropriedadeDAO;
import br.com.tkcsapcd.model.email.EnviaEmail;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarOrganogramaPropriedade implements InterfaceCommand {

	private InterfaceOrganogramaPropriedadeDAO organogramaPropriedadeDAO;
	public CadastrarOrganogramaPropriedade(InterfaceOrganogramaPropriedadeDAO organogramaPropriedadeDAO) {
		super();
		this.organogramaPropriedadeDAO = organogramaPropriedadeDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			OrganogramaPropriedade organogramaPropriedade  = new OrganogramaPropriedade();
			
			organogramaPropriedade.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			
			String data_1 = request.getParameter("data"); 
			Date data =  new SimpleDateFormat("dd/MM/yyyy").parse(data_1);
			organogramaPropriedade.setData(data);
			
			organogramaPropriedade.setComentario(request.getParameter("comentario"));
			organogramaPropriedade.setMySavedModel(request.getParameter("mySavedModel"));
			organogramaPropriedade.setDescricao(request.getParameter("descricao"));
			
			if(ValidationHelper.validar(organogramaPropriedade)){
			
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM orgchartpropriedade WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conex�o e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("codigoprojeto");
				
				if(codigoprojeto >= 1){
					System.out.println("O c�digo � igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('J� existe um registro com o c�digo do projeto ("+organogramaPropriedade.getCodigoprojeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarOrganogramaPropriedade";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O c�digo n�o � igual!");
					organogramaPropriedadeDAO.salvar(organogramaPropriedade);
					request.setAttribute("mensagem", "Organograma Propriedade: ("+organogramaPropriedade.getCodigoprojeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O c�digo n�o � igual!");
					organogramaPropriedadeDAO.salvar(organogramaPropriedade);
					request.setAttribute("mensagem", "Organograma Propriedade: ("+organogramaPropriedade.getCodigoprojeto()+") cadastrado com sucesso!");	
					
					/*Regra que objetiva disparar um e-mail autom�tico como confirma��o de registro.
					 * O Metodo enviarForm() � respons�vel, por enviar e-mail de confirma��o de envio de formul�rios.
					 */
					
					//String de 		= request.getParameter("de");
					String para 	= request.getParameter("para");
					String assunto 	= request.getParameter("descricao");
					String mensagem = request.getParameter("comentario");
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
						request.setAttribute("msg","Enviado confirma��o de registro por e-mail!");
					else
						request.setAttribute("msg","N�o, enviado c�pia de confirma��o de registro por e-mail!");				
					
					rd = request.getRequestDispatcher("TkcsapcdController?cmd=editarOrganogramaPropriedade");
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
				request.setAttribute("titulo", "Cadastro - Organograma Propriedade");
				return "TkcsapcdController?cmd=editarOrganogramaPropriedade";//devolver p/ editar cadastro		
	}
}

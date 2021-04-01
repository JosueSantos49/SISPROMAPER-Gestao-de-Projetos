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

import br.com.tkcsapcd.model.bean.Organograma;
import br.com.tkcsapcd.model.dao.InterfaceOrganogramaDAO;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.email.EnviaEmail;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarOrganograma implements InterfaceCommand {

	private InterfaceOrganogramaDAO organogramaDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	
	public CadastrarOrganograma(InterfaceOrganogramaDAO organogramaDAO, InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.organogramaDAO = organogramaDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			Organograma organograma  = new Organograma();
						
			String data_1 = request.getParameter("data"); 
			Date data =  new SimpleDateFormat("dd/MM/yyyy").parse(data_1);
			organograma.setData(data);
			
			organograma.setComentario(request.getParameter("comentario"));
			organograma.setMySavedModel(request.getParameter("mySavedModel"));
			organograma.setDescricao(request.getParameter("descricao"));
			
			Integer projetoinicio = Integer.valueOf(request.getParameter("projetoinicio"));										
			organograma.setProjetoinicio(projetoInicioDAO.getProjetoInicio(projetoinicio));
			
			if(ValidationHelper.validar(organograma)){
			
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM organograma WHERE projetoinicio = '"+request.getParameter("projetoinicio")+"'");// pega a conex�o e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("projetoinicio");
				
				if(codigoprojeto >= 1){
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('J� existe um registro com o c�digo do projeto ("+organograma.getProjetoinicio().getProjeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarOrganograma";//devolver p/ editar cadastro
				}else{
					organogramaDAO.salvar(organograma);
					request.setAttribute("mensagem", "Organograma: ("+organograma.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					organogramaDAO.salvar(organograma);
					request.setAttribute("mensagem", "Organograma: ("+organograma.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");	
					
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
					
					rd = request.getRequestDispatcher("TkcsapcdController?cmd=editarOrganograma");
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
				request.setAttribute("titulo", "Cadastro - Organograma");
				return "TkcsapcdController?cmd=editarOrganograma";//devolver p/ editar cadastro		
	}
}

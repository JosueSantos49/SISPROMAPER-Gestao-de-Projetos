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
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.ProjetoInicio;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.email.EnviaEmail;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarProjetoInicio implements InterfaceCommand {

	private InterfaceProjetoInicioDAO projetoInicioDAO;	
	public CadastrarProjetoInicio(InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			ProjetoInicio projetoInicio = new ProjetoInicio();								
			
			projetoInicio.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			projetoInicio.setProjeto(request.getParameter("projeto"));
			
			/*Funciona corretamente com Inputy
			 * String data_1 = request.getParameter("data"); 
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(data_1);
			projetoInicio.setData(data);*/			
			
			Date data = new Date(); 
			projetoInicio.setData(data);
			System.out.println("Teste campo data: "+data);
			
			projetoInicio.setAtribuiprojeto(request.getParameter("atribuiprojeto"));
			projetoInicio.setTipoprojeto(request.getParameter("tipoprojeto"));
			projetoInicio.setObjetivo(request.getParameter("objetivo"));
			projetoInicio.setCliente(request.getParameter("cliente"));
			projetoInicio.setPrograma(request.getParameter("programa"));
			projetoInicio.setArea(request.getParameter("area"));
			
			projetoInicio.setRoi(request.getParameter("roi").equals("") ? null : Double.valueOf(request.getParameter("roi")));
			
			projetoInicio.setDescricao(request.getParameter("descricao"));
			projetoInicio.setCopia(request.getParameter("copia"));
									
			if(ValidationHelper.validar(projetoInicio)){
				
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM projetoinicio WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigodoprojeto = rs.getInt("codigoprojeto");
				
				if(codigodoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+projetoInicio.getCodigoprojeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=consultarProjetoInicio";	
				}else{
					
					projetoInicioDAO.salvar(projetoInicio);
					request.setAttribute("mensagem", "Novo: ("+projetoInicio.getCodigoprojeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					
					projetoInicioDAO.salvar(projetoInicio);
					request.setAttribute("mensagem", "Novo Projeto: ("+projetoInicio.getCodigoprojeto()+") cadastrado com sucesso!");	
					
					/*Regra que objetiva disparar um e-mail automático como confirmação de registro.
					 * O Metodo enviarForm() é responsável, por enviar e-mail de confirmação de envio de formulários.
					 */
					String projeto 			= request.getParameter("projeto");
					String objetivo 		= request.getParameter("objetivo");	
					String copia			= request.getParameter("copia");									
					
					RequestDispatcher rd = null;					
					EnviaEmail email = new EnviaEmail();
					
					email.setProjeto(projeto);
					email.setObjetivo(objetivo);
					email.setCopia(copia);					
					
					boolean enviado = email.enviarProjetoInicio();
					
					if(enviado)
						request.setAttribute("msg","Enviado confirmação de registro por e-mail!");
					else
						request.setAttribute("msg","Não, enviado cópia de confirmação de registro por e-mail!");
					rd = request.getRequestDispatcher("TkcsapcdController?cmd=consultarProjetoInicio");
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
				request.setAttribute("titulo", "Cadastro - Novo Projeto");
				return "TkcsapcdController?cmd=consultarProjetoInicio";
				//return "TkcsapcdController?cmd=editarProjetoInicio";//devolver p/ editar cadastro		
	}
}

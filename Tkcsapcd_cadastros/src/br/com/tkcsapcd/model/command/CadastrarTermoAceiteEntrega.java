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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.TermoAceiteEntrega;
import br.com.tkcsapcd.model.dao.InterfaceTermoAceiteEntregaDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarTermoAceiteEntrega implements InterfaceCommand {
	
	private InterfaceTermoAceiteEntregaDAO termoAceiteEntregaDAO;
	public CadastrarTermoAceiteEntrega(InterfaceTermoAceiteEntregaDAO termoAceiteEntregaDAO) {
		super();
		this.termoAceiteEntregaDAO = termoAceiteEntregaDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			TermoAceiteEntrega termoAceiteEntrega = new TermoAceiteEntrega();
			
			termoAceiteEntrega.setTermo(request.getParameter("termo"));
			termoAceiteEntrega.setProjeto(request.getParameter("projeto"));
			termoAceiteEntrega.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			termoAceiteEntrega.setObjetivo(request.getParameter("objetivo"));
			termoAceiteEntrega.setEntrega(request.getParameter("entrega"));
			termoAceiteEntrega.setQuestao(request.getParameter("questao"));
			termoAceiteEntrega.setInformacao(request.getParameter("informacao"));
			termoAceiteEntrega.setAceite(request.getParameter("aceite"));
			
			if(ValidationHelper.validar(termoAceiteEntrega)){
								
				Connection con = ConexaoHelper.conectar();								
				/*
				 Select todos os registros da tabela, onde o codigo digidato no campo do form for igual registro, j� presente na tabela. 
				 Objetivo evitar registro duplicado. Se na tabela j� tiver um registro com o c�digo, n�o deixar cadastrar otro registro com o mesmo c�digo.	
				*/
				PreparedStatement stmt = con.prepareStatement("SELECT * FROM termoaceiteentrega WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conex�o e o Statement
				ResultSet rs = stmt.executeQuery();// executa um select
				
				while(rs.next()){
					
					Integer codigoprojeto = rs.getInt("codigoprojeto");
					
					if(codigoprojeto >= 1){
						System.out.println("O c�digo � igual!");
												 
						PrintWriter out = response.getWriter();
						response.setContentType("text/html; charset=UTF-8");
						out.println("<script type=\"text/javascript\">");  
						out.println("alert('J�, existe um registro cadastrado com esse c�digo!');");  
						out.println("</script>");
						
						out.println("alert('J� existe um registro com o c�digo do projeto ("+termoAceiteEntrega.getCodigoprojeto()+"), informado!');");
						return "TkcsapcdController?cmd=editarTermoAceiteEntrega";
					}else{
						System.out.println("O c�digo n�o � igual!");
						termoAceiteEntregaDAO.salvar(termoAceiteEntrega);				
						request.setAttribute("mensagem", "TERMO DE ACEITE DA ENTREGA: ("+termoAceiteEntrega.getCodigoprojeto()+") cadastrado com sucesso!");					
					}					
				}
						System.out.println("O c�digo n�o � igual!");
						termoAceiteEntregaDAO.salvar(termoAceiteEntrega);				
						request.setAttribute("mensagem", "TERMO DE ACEITE DA ENTREGA: ("+termoAceiteEntrega.getCodigoprojeto()+") cadastrado com sucesso!");							
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
				request.setAttribute("titulo", "Cadastro - TERMO DE ACEITE DA ENTREGA");
				return "TkcsapcdController?cmd=editarTermoAceiteEntrega";//devolver p/ editar cadastro		
	}
}

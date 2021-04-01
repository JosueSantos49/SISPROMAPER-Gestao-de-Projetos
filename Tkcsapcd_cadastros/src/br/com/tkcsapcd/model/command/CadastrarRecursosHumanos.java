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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.RecursosHumanos;
import br.com.tkcsapcd.model.dao.InterfaceRecursosHumanosDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarRecursosHumanos implements InterfaceCommand {

	private InterfaceRecursosHumanosDAO recursosHumanosDAO;
	public CadastrarRecursosHumanos(
			InterfaceRecursosHumanosDAO recursosHumanosDAO) {
		super();
		this.recursosHumanosDAO = recursosHumanosDAO;
	}

	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response) throws Exception {
		try {
			RecursosHumanos recursosHumanos = new RecursosHumanos();
			
			recursosHumanos.setIdRecursosHumanos(request.getParameter("idRecursosHumanos"));
			recursosHumanos.setNome(request.getParameter("nome"));
			recursosHumanos.setProfissao(request.getParameter("profissao"));
			recursosHumanos.setArea(request.getParameter("area"));
			recursosHumanos.setStatus(request.getParameter("status"));
			
			if(ValidationHelper.validar(recursosHumanos)){
				
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM recursoshumanos WHERE idRecursosHumanos = '"+request.getParameter("idRecursosHumanos")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer idRecursosHumanos = rs.getInt("idRecursosHumanos");
				
				if(idRecursosHumanos >= 1){
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o ID ("+recursosHumanos.getIdRecursosHumanos()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarRecursosHumanos";//Devolver para o editar
				}else{
					recursosHumanosDAO.salvar(recursosHumanos);
					request.setAttribute("mensagem", "Recursos Humanos: ("+recursosHumanos.getIdRecursosHumanos()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					recursosHumanosDAO.salvar(recursosHumanos);
					request.setAttribute("mensagem", "Recursos Humanos: ("+recursosHumanos.getIdRecursosHumanos()+") cadastrado com sucesso!");			
			}
			else{
				throw new Exception("Valor Inválido");
			}
			} catch (SQLException e) {
				
				request.setAttribute("mensagem", "Problema com a gravação: "+e.getMessage());
				e.printStackTrace();
				
			}catch (NumberFormatException e) {
				
				request.setAttribute("mensagem", "Recursos Humanos: "+e.getMessage());
				e.printStackTrace();
			}
			request.setAttribute("titulo", "Cadastro - Recursos Humanos");		
			return "TkcsapcdController?cmd=editarRecursosHumanos";//Devolver para o editar
		}


}

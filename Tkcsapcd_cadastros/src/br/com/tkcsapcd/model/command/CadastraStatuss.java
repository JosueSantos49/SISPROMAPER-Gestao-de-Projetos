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

import br.com.tkcsapcd.model.bean.Statuss;
import br.com.tkcsapcd.model.dao.InterfaceStatussDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastraStatuss implements InterfaceCommand {
	
	private InterfaceStatussDAO statussDAO;
	public CadastraStatuss(InterfaceStatussDAO statussDAO) {
		super();
		this.statussDAO = statussDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)throws Exception {
		try {
			Statuss statuss = new Statuss();
			
			statuss.setFase(request.getParameter("fase"));
			statuss.setPercentualevolucao(request.getParameter("percentualevolucao").equals("") ? null : Double.valueOf(request.getParameter("percentualevolucao")));
			statuss.setPercentualplanejado(request.getParameter("percentualplanejado").equals("") ? null : Double.valueOf(request.getParameter("percentualplanejado")));
			statuss.setDatastatus(request.getParameter("datastatus"));
			statuss.setDescricao(request.getParameter("descricao"));
			statuss.setPontospositivos(request.getParameter("pontospositivos"));
			statuss.setPontosnegativos(request.getParameter("pontosnegativos"));
			statuss.setTendencia(request.getParameter("tendencia"));
			statuss.setDatainicio(request.getParameter("datainicio"));
			statuss.setDatafim(request.getParameter("datafim"));
			statuss.setProjeto(request.getParameter("projeto"));
			statuss.setCodigodoprojeto(Integer.valueOf(request.getParameter("codigodoprojeto")));
			
			if(ValidationHelper.validar(statuss)){
				
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM statuss WHERE codigodoprojeto = '"+request.getParameter("codigodoprojeto")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigodoprojeto = rs.getInt("codigodoprojeto");
				
				if(codigodoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+statuss.getCodigodoprojeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarStatuss";//Devolver para o editar
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					statussDAO.salvar(statuss);
					request.setAttribute("mensagem", "Status: ("+statuss.getCodigodoprojeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					statussDAO.salvar(statuss);
					request.setAttribute("mensagem", "Status: ("+statuss.getCodigodoprojeto()+") cadastrado com sucesso!");			
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
			request.setAttribute("titulo", "Cadastro - Status");
			return "TkcsapcdController?cmd=editarStatuss";//Devolver para o editar	
	}

}

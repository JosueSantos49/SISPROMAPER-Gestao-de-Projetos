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

import br.com.tkcsapcd.model.bean.SolicitacaoProjeto;
import br.com.tkcsapcd.model.dao.InterfaceSolicitacaoProjetoDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarSolicitacaoProjeto implements InterfaceCommand {

	private InterfaceSolicitacaoProjetoDAO solicitacaoProjetoDAO;
	public CadastrarSolicitacaoProjeto(InterfaceSolicitacaoProjetoDAO solicitacaoProjetoDAO) {
		super();
		this.solicitacaoProjetoDAO = solicitacaoProjetoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			SolicitacaoProjeto solicitacaoProjeto = new SolicitacaoProjeto();
			
			solicitacaoProjeto.setSolicitacaoprojeto(request.getParameter("solicitacaoprojeto"));
			solicitacaoProjeto.setProjeto(request.getParameter("projeto"));
			solicitacaoProjeto.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			solicitacaoProjeto.setVersao(request.getParameter("versao"));
			solicitacaoProjeto.setData(request.getParameter("data"));
			solicitacaoProjeto.setAutor(request.getParameter("autor"));
			solicitacaoProjeto.setNotarevisao(request.getParameter("notarevisao"));
			solicitacaoProjeto.setAprovacao(request.getParameter("aprovacao"));
			solicitacaoProjeto.setObjetivo(request.getParameter("objetivo"));				
			solicitacaoProjeto.setAtual(request.getParameter("atual"));					
			solicitacaoProjeto.setDescricao(request.getParameter("descricao"));
			
			if(ValidationHelper.validar(solicitacaoProjeto)){
				
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM solicitacaoprojeto WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conex�o e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("codigoprojeto");
				
				if(codigoprojeto >= 1){
					System.out.println("O c�digo � igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('J� existe um registro com o c�digo do projeto ("+solicitacaoProjeto.getCodigoprojeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarSolicitacaoProjeto";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O c�digo n�o � igual!");
					solicitacaoProjetoDAO.salvar(solicitacaoProjeto);
					request.setAttribute("mensagem", "SOLICITA��O DO PROJETO: ("+solicitacaoProjeto.getCodigoprojeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O c�digo n�o � igual!");
					solicitacaoProjetoDAO.salvar(solicitacaoProjeto);
					request.setAttribute("mensagem", "SOLICITA��O DO PROJETO: ("+solicitacaoProjeto.getCodigoprojeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - SOLICITA��O DO PROJETO");
				return "TkcsapcdController?cmd=editarSolicitacaoProjeto";//devolver p/ editar cadastro		
	}
}

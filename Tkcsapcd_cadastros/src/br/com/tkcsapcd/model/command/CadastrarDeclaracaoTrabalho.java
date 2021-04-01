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

import br.com.tkcsapcd.model.bean.DeclaracaoTrabalho;
import br.com.tkcsapcd.model.dao.InterfaceDeclaracaoTrabalhoDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarDeclaracaoTrabalho implements InterfaceCommand {

	private InterfaceDeclaracaoTrabalhoDAO declaracaoTrabalhoDAO;
	public CadastrarDeclaracaoTrabalho(InterfaceDeclaracaoTrabalhoDAO declaracaoTrabalhoDAO) {
		super();
		this.declaracaoTrabalhoDAO = declaracaoTrabalhoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			DeclaracaoTrabalho declaracaoTrabalho = new DeclaracaoTrabalho();
			
			declaracaoTrabalho.setDeclaracaotrabalho(request.getParameter("declaracaotrabalho"));
			declaracaoTrabalho.setProjeto(request.getParameter("projeto"));
			declaracaoTrabalho.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			declaracaoTrabalho.setVersao(request.getParameter("versao"));
			declaracaoTrabalho.setData(request.getParameter("data"));
			declaracaoTrabalho.setAutor(request.getParameter("autor"));
			declaracaoTrabalho.setNotarevisao(request.getParameter("notarevisao"));
			declaracaoTrabalho.setAprovacao(request.getParameter("aprovacao"));
			declaracaoTrabalho.setObjetivo(request.getParameter("objetivo"));				
			declaracaoTrabalho.setEscopo(request.getParameter("escopo"));					
			declaracaoTrabalho.setCronograma(request.getParameter("cronograma"));
			declaracaoTrabalho.setPadrao(request.getParameter("padrao"));
			declaracaoTrabalho.setRequisito(request.getParameter("requisitoespecial"));
			declaracaoTrabalho.setLocal(request.getParameter("local"));
			declaracaoTrabalho.setPeriodo(request.getParameter("periodo"));
			declaracaoTrabalho.setRequisitoespecial(request.getParameter("requisitoespecial"));
			
			if(ValidationHelper.validar(declaracaoTrabalho)){
			
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM declaracaotrabalho WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("codigoprojeto");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+declaracaoTrabalho.getCodigoprojeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarDeclaracaoTrabalho";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					declaracaoTrabalhoDAO.salvar(declaracaoTrabalho);
					request.setAttribute("mensagem", "DECLARAÇÃO DE TRABALHO: ("+declaracaoTrabalho.getCodigoprojeto()+") cadastrado com sucesso!");
				}
				stmt.close();
				rs.close();
				con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					declaracaoTrabalhoDAO.salvar(declaracaoTrabalho);
					request.setAttribute("mensagem", "DECLARAÇÃO DE TRABALHO: ("+declaracaoTrabalho.getCodigoprojeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - DECLARAÇÃO DE TRABALHO");
				return "TkcsapcdController?cmd=editarDeclaracaoTrabalho";//devolver p/ editar cadastro		
	}
}

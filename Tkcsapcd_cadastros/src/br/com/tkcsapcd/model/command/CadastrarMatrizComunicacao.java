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

import br.com.tkcsapcd.model.bean.MatrizComunicacao;
import br.com.tkcsapcd.model.dao.InterfaceMatrizComunicacaoDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarMatrizComunicacao implements InterfaceCommand {

	private InterfaceMatrizComunicacaoDAO matrizComunicacaoDAO;
	public CadastrarMatrizComunicacao(InterfaceMatrizComunicacaoDAO matrizComunicacaoDAO) {
		super();
		this.matrizComunicacaoDAO = matrizComunicacaoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			MatrizComunicacao matrizComunicacao = new MatrizComunicacao();
			
			matrizComunicacao.setCodigomatriz(Integer.valueOf(request.getParameter("codigomatriz")));
			matrizComunicacao.setPergunta1(request.getParameter("pergunta1"));
			matrizComunicacao.setPergunta2(request.getParameter("pergunta2"));
			matrizComunicacao.setPergunta3(request.getParameter("pergunta3"));
			matrizComunicacao.setPergunta4(request.getParameter("pergunta4"));
			matrizComunicacao.setPergunta5(request.getParameter("pergunta5"));
			matrizComunicacao.setPergunta6(request.getParameter("pergunta6"));
			matrizComunicacao.setPergunta7(request.getParameter("pergunta7"));
			matrizComunicacao.setPergunta8(request.getParameter("pergunta8"));
			matrizComunicacao.setComentario(request.getParameter("comentario"));
			
			if(ValidationHelper.validar(matrizComunicacao)){
				
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM matrizcomunicacao WHERE codigomatriz = '"+request.getParameter("codigomatriz")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigomatriz = rs.getInt("codigomatriz");
				
				if(codigomatriz >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código da matriz ("+matrizComunicacao.getCodigomatriz()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarMatrizComunicacao";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					matrizComunicacaoDAO.salvar(matrizComunicacao);
					request.setAttribute("mensagem", "MATRIZ DAS COMUNICAÇÕES: ("+matrizComunicacao.getCodigomatriz()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					matrizComunicacaoDAO.salvar(matrizComunicacao);
					request.setAttribute("mensagem", "MATRIZ DAS COMUNICAÇÕES: ("+matrizComunicacao.getCodigomatriz()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - MATRIZ DAS COMUNICAÇÕES");
				return "TkcsapcdController?cmd=editarMatrizComunicacao";//devolver p/ editar cadastro		
	}
}

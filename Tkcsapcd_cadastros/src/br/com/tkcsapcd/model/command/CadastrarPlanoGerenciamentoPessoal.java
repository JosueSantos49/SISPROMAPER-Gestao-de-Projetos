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

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoPessoal;
import br.com.tkcsapcd.model.dao.InterfacePlanoGerenciamentoPessoalDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarPlanoGerenciamentoPessoal implements InterfaceCommand {

	private InterfacePlanoGerenciamentoPessoalDAO planoGerenciamentoPessoalDAO;
	public CadastrarPlanoGerenciamentoPessoal(InterfacePlanoGerenciamentoPessoalDAO planoGerenciamentoPessoalDAO) {
		super();
		this.planoGerenciamentoPessoalDAO = planoGerenciamentoPessoalDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			PlanoGerenciamentoPessoal planoGerenciamentoPessoal = new PlanoGerenciamentoPessoal();
			
			planoGerenciamentoPessoal.setPlanogerenciamentopessoal(request.getParameter("planogerenciamentopessoal"));
			planoGerenciamentoPessoal.setProjeto(request.getParameter("projeto"));
			planoGerenciamentoPessoal.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			planoGerenciamentoPessoal.setVersao(request.getParameter("versao"));
			planoGerenciamentoPessoal.setData(request.getParameter("data"));
			planoGerenciamentoPessoal.setAutor(request.getParameter("autor"));
			planoGerenciamentoPessoal.setNotarevisao(request.getParameter("notarevisao"));
			planoGerenciamentoPessoal.setAprovacao(request.getParameter("aprovacao"));
			planoGerenciamentoPessoal.setPergunta1(request.getParameter("pergunta1"));
			planoGerenciamentoPessoal.setPergunta2(request.getParameter("pergunta2"));
			planoGerenciamentoPessoal.setPergunta3(request.getParameter("pergunta3"));
			planoGerenciamentoPessoal.setPergunta4(request.getParameter("pergunta4"));
			planoGerenciamentoPessoal.setPergunta5(request.getParameter("pergunta5"));
			planoGerenciamentoPessoal.setPergunta6(request.getParameter("pergunta6"));
			planoGerenciamentoPessoal.setPergunta7(request.getParameter("pergunta7"));
			
			if(ValidationHelper.validar(planoGerenciamentoPessoal)){
			
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM planogerenciamentopessoal WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("codigoprojeto");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+planoGerenciamentoPessoal.getCodigoprojeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarPlanoGerenciamentoPessoal";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					planoGerenciamentoPessoalDAO.salvar(planoGerenciamentoPessoal);
					request.setAttribute("mensagem", "PLANO DE GERENCIAMENTO DO PESSOAL: ("+planoGerenciamentoPessoal.getCodigoprojeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
			planoGerenciamentoPessoalDAO.salvar(planoGerenciamentoPessoal);
			request.setAttribute("mensagem", "PLANO DE GERENCIAMENTO DO PESSOAL: ("+planoGerenciamentoPessoal.getCodigoprojeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - PLANO DE GERENCIAMENTO DO PESSOAL");
				return "TkcsapcdController?cmd=editarPlanoGerenciamentoPessoal";//devolver p/ editar cadastro		
	}
}

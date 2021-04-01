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

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.SolicitacaoCadastro;
import br.com.tkcsapcd.model.dao.InterfaceSolicitaCadastro;
import br.com.tkcsapcd.model.email.EnviaEmail;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarSolicitacaoCadastro implements InterfaceCommand {

	private InterfaceSolicitaCadastro solicitacaoCadastroDAO;
	public CadastrarSolicitacaoCadastro(
			InterfaceSolicitaCadastro solicitacaoCadastroDAO) {
		super();
		this.solicitacaoCadastroDAO = solicitacaoCadastroDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, NumberFormatException {

		try {
			SolicitacaoCadastro solicitacaoCadastro = new SolicitacaoCadastro();
			
			solicitacaoCadastro.setNome(request.getParameter("nome"));
			solicitacaoCadastro.setCpf(request.getParameter("id"));
			solicitacaoCadastro.setEmail(request.getParameter("email"));
			solicitacaoCadastro.setArea(request.getParameter("area"));
			solicitacaoCadastro.setFuncao(request.getParameter("funcao"));
			solicitacaoCadastro.setResponsavel(request.getParameter("responsavel"));
			solicitacaoCadastro.setTelefone(request.getParameter("telefone"));
			solicitacaoCadastro.setObs(request.getParameter("obs"));
			solicitacaoCadastro.setData(request.getParameter("data"));
			solicitacaoCadastro.setStatus(request.getParameter("status"));
		
		if(ValidationHelper.validar(solicitacaoCadastro)){	
			
		Connection con = ConexaoHelper.conectar();
		
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM solicitacaocadastro WHERE id = '"+request.getParameter("id")+"'");// pega a conex�o e o Statement
		ResultSet rs = stmt.executeQuery();// executa um select
		
		while(rs.next()){
			
			Integer id = rs.getInt("id");
			
			if(id >= 1){
				System.out.println("O c�digo � igual!");
										 
				PrintWriter out = response.getWriter();
				response.setContentType("text/html; charset=ISO-8859-1");
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('J� existe um registro com o ID ("+solicitacaoCadastro.getId()+"), informado!');");  
				out.println("</script>");
				
				return "solicitacao_cadastro.jsp";
			}else{
				System.out.println("Aviso 1: O c�digo n�o � igual!");
				solicitacaoCadastroDAO.salvar(solicitacaoCadastro);
				request.setAttribute("mensagem", "Solicita��o (ID): "+solicitacaoCadastro.getCpf()+" cadastrada com sucesso. "+solicitacaoCadastro.getNome()+", a solicita��o de acesso ao Sispromaper ser� analizada, e em breve entraremos em contato.");
			}
				stmt.close();
				rs.close();
				con.close();
		}
				System.out.println("Aviso 2: O c�digo n�o � igual!");
				solicitacaoCadastroDAO.salvar(solicitacaoCadastro);
				request.setAttribute("mensagem", "Solicita��o (ID): "+solicitacaoCadastro.getCpf()+" cadastrada com sucesso. "+solicitacaoCadastro.getNome()+", a solicita��o de acesso ao SCP ser� analizada e em breve entraremos em contato.");			
				
				//Regra de envio de e-mail com Javamail. Enviando confirma��o de cadastro.
				String email			= request.getParameter("email");
				String status 			= request.getParameter("status");
				String obs 				= request.getParameter("obs");	
				String copia			= "conceicaojosue@outlook.com.br";	//Aqui pode ser regatado qualquer e-mail digitado pelo user. Add e-mail do suporte								
				
				RequestDispatcher rd = null;	
				EnviaEmail email2 = new EnviaEmail();
				
				email2.setEmail(email); //envia e-mail de confirma��o para o pr�prio solicitante. 1 destinat�rio
				email2.setStatus(status);
				email2.setObs(obs);
				email2.setCopia(copia); //ser� enviado confirma��o de cadastro para o e-mail do suporte.					
				
				boolean enviado = email2.enviarSolicitacaoCadastro();
				
				if(enviado)
					request.setAttribute("msg","Enviado confirma��o de registro por e-mail!");
				else
					request.setAttribute("msg","N�o, enviado c�pia de confirma��o de registro por e-mail!");
				rd = request.getRequestDispatcher("solicitacao_cadastro.jsp");
				rd.forward(request,response);
		}
		else{
			throw new Exception("Valor Inv�lido");
		}
		} catch (Exception e) {
			
			request.setAttribute("mensagem", "Problema com a grava��o: "+e.getMessage());
			e.printStackTrace();
		}
		request.setAttribute("titulo", "Cadastro - Solicita��o Cadastro");
		return "solicitacao_cadastro.jsp";
	}

}

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

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoComunicacao;
import br.com.tkcsapcd.model.dao.InterfacePlanoGerenciamentoComunicacaoDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarPlanoGerenciamentoComunicacao implements InterfaceCommand {

	private InterfacePlanoGerenciamentoComunicacaoDAO planoGerenciamentoComunicacaoDAO;
	public CadastrarPlanoGerenciamentoComunicacao(InterfacePlanoGerenciamentoComunicacaoDAO planoGerenciamentoComunicacaoDAO) {
		super();
		this.planoGerenciamentoComunicacaoDAO = planoGerenciamentoComunicacaoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			PlanoGerenciamentoComunicacao planoGerenciamentoComunicacao = new PlanoGerenciamentoComunicacao();
			
			planoGerenciamentoComunicacao.setPlanogerenciamentocomunicacao(request.getParameter("planogerenciamentocomunicacao"));
			planoGerenciamentoComunicacao.setProjeto(request.getParameter("projeto"));
			planoGerenciamentoComunicacao.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			planoGerenciamentoComunicacao.setVersao(request.getParameter("versao"));
			planoGerenciamentoComunicacao.setData(request.getParameter("data"));
			planoGerenciamentoComunicacao.setAutor(request.getParameter("autor"));
			planoGerenciamentoComunicacao.setNotarevisao(request.getParameter("notarevisao"));
			planoGerenciamentoComunicacao.setAprovacao(request.getParameter("aprovacao"));
			planoGerenciamentoComunicacao.setObjetivo(request.getParameter("objetivo"));				
			planoGerenciamentoComunicacao.setProcesso(request.getParameter("processo"));					
			planoGerenciamentoComunicacao.setRequisito(request.getParameter("requisito"));
			planoGerenciamentoComunicacao.setInformcacao(request.getParameter("informcacao"));
			planoGerenciamentoComunicacao.setTecnologia(request.getParameter("tecnologia"));
			planoGerenciamentoComunicacao.setDiretrize(request.getParameter("diretrize"));
			planoGerenciamentoComunicacao.setComunicacao(request.getParameter("eventocomunicacao"));
			planoGerenciamentoComunicacao.setGestao(request.getParameter("gestao"));
			planoGerenciamentoComunicacao.setStatus(request.getParameter("status"));
			planoGerenciamentoComunicacao.setGerenciareunioes(request.getParameter("gerenciareunioes"));					
			planoGerenciamentoComunicacao.setGerenciaquestoes(request.getParameter("gerenciaquestoes"));
			planoGerenciamentoComunicacao.setPlanoescalonamento(request.getParameter("planoescalonamento"));
			planoGerenciamentoComunicacao.setEventocomunicacao(request.getParameter("eventocomunicacao"));
			planoGerenciamentoComunicacao.setAnexo(request.getParameter("anexo"));
			
			if(ValidationHelper.validar(planoGerenciamentoComunicacao)){
			
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM planogerenciamentocomunicacao WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("codigoprojeto");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+planoGerenciamentoComunicacao.getCodigoprojeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarPlanoGerenciamentoComunicacao";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					planoGerenciamentoComunicacaoDAO.salvar(planoGerenciamentoComunicacao);
					request.setAttribute("mensagem", "PLANO DE GERENCIAMENTO DAS COMUNICAÇÕES: ("+planoGerenciamentoComunicacao.getCodigoprojeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					planoGerenciamentoComunicacaoDAO.salvar(planoGerenciamentoComunicacao);
					request.setAttribute("mensagem", "PLANO DE GERENCIAMENTO DAS COMUNICAÇÕES: ("+planoGerenciamentoComunicacao.getCodigoprojeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - PLANO DE GERENCIAMENTO DAS COMUNICAÇÕES");
				return "TkcsapcdController?cmd=editarPlanoGerenciamentoComunicacao";//devolver p/ editar cadastro		
	}
}

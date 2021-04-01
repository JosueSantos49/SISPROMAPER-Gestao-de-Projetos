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
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoProjeto;
import br.com.tkcsapcd.model.dao.InterfacePlanoGerenciamentoProjetoDAO;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarPlanoGerenciamentoProjeto implements InterfaceCommand {

	private InterfacePlanoGerenciamentoProjetoDAO planoGerenciamentoProjetoDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	public CadastrarPlanoGerenciamentoProjeto(InterfacePlanoGerenciamentoProjetoDAO planoGerenciamentoProjetoDAO, InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.planoGerenciamentoProjetoDAO = planoGerenciamentoProjetoDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			PlanoGerenciamentoProjeto planoGerenciamentoProjeto = new PlanoGerenciamentoProjeto();
			
			planoGerenciamentoProjeto.setPlanogerenciamentoprojeto(request.getParameter("planogerenciamentoprojeto"));
			planoGerenciamentoProjeto.setVersao(request.getParameter("versao"));
			
			String data_1 = request.getParameter("data"); 
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(data_1);
			planoGerenciamentoProjeto.setData(data);
			
			planoGerenciamentoProjeto.setAutor(request.getParameter("autor"));
			planoGerenciamentoProjeto.setNotarevisao(request.getParameter("notarevisao"));
			planoGerenciamentoProjeto.setAprovacao(request.getParameter("aprovacao"));
			planoGerenciamentoProjeto.setObjetivo(request.getParameter("objetivo"));				
			planoGerenciamentoProjeto.setLinhabase(request.getParameter("linhabase"));					
			planoGerenciamentoProjeto.setOrganizacao(request.getParameter("organizacao"));
			planoGerenciamentoProjeto.setCronograma(request.getParameter("cronograma"));
			planoGerenciamentoProjeto.setProgresso(request.getParameter("progresso"));
			planoGerenciamentoProjeto.setRisco(request.getParameter("risco"));
			planoGerenciamentoProjeto.setComunicacao(request.getParameter("comunicacao"));
			planoGerenciamentoProjeto.setMudanca(request.getParameter("mudanca"));
			
			Integer projetoinicio = Integer.valueOf(request.getParameter("projetoinicio"));										
			planoGerenciamentoProjeto.setProjetoinicio(projetoInicioDAO.getProjetoInicio(projetoinicio));
			
			if(ValidationHelper.validar(planoGerenciamentoProjeto)){
				
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM planogerenciamentoprojeto WHERE projetoinicio = '"+request.getParameter("projetoinicio")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("projetoinicio");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+planoGerenciamentoProjeto.getProjetoinicio().getProjeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					planoGerenciamentoProjetoDAO.salvar(planoGerenciamentoProjeto);
					request.setAttribute("mensagem", "PLANO DE GERENCIAMENTO DO PROJETO: ("+planoGerenciamentoProjeto.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					planoGerenciamentoProjetoDAO.salvar(planoGerenciamentoProjeto);
					request.setAttribute("mensagem", "PLANO DE GERENCIAMENTO DO PROJETO: ("+planoGerenciamentoProjeto.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - PLANO DE GERENCIAMENTO DO PROJETO");
				return "TkcsapcdController?cmd=editarPlanoGerenciamentoProjeto";//devolver p/ editar cadastro		
	}
}

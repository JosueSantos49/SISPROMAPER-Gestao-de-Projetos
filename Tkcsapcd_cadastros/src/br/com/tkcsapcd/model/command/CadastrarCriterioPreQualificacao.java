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

import br.com.tkcsapcd.model.bean.CriterioPreQualificacao;
import br.com.tkcsapcd.model.dao.InterfaceCriterioPreQualificacaoDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarCriterioPreQualificacao implements InterfaceCommand {

	private InterfaceCriterioPreQualificacaoDAO criterioPreQualificacaoDAO;
	public CadastrarCriterioPreQualificacao(InterfaceCriterioPreQualificacaoDAO criterioPreQualificacaoDAO) {
		super();
		this.criterioPreQualificacaoDAO = criterioPreQualificacaoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			CriterioPreQualificacao criterioPreQualificacao = new CriterioPreQualificacao();
			
			criterioPreQualificacao.setRfp(request.getParameter("rfp"));
			criterioPreQualificacao.setObjetivo(request.getParameter("objetivo"));
			criterioPreQualificacao.setProjeto(request.getParameter("projeto"));
			criterioPreQualificacao.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			criterioPreQualificacao.setGp(request.getParameter("gp"));
			criterioPreQualificacao.setPatrocinador(request.getParameter("patrocinador"));
			criterioPreQualificacao.setArea(request.getParameter("area"));
			criterioPreQualificacao.setParticipante(request.getParameter("participante"));
			criterioPreQualificacao.setAprovado(request.getParameter("aprovado"));				
			criterioPreQualificacao.setReprovado(request.getParameter("reprovado"));
			
			if(ValidationHelper.validar(criterioPreQualificacao)){
			
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM criterioPreQualificacao WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("codigoprojeto");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+criterioPreQualificacao.getCodigoprojeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarCriterioPreQualificacao";//devolver p/ editar cadastro	
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					criterioPreQualificacaoDAO.salvar(criterioPreQualificacao);
					request.setAttribute("mensagem", "SELEÇÃO DE FONTE (PRÉ QUALIFICAÇÃO): ("+criterioPreQualificacao.getCodigoprojeto()+") cadastrado com sucesso!");
				}
				stmt.close();
				rs.close();
				con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					criterioPreQualificacaoDAO.salvar(criterioPreQualificacao);
					request.setAttribute("mensagem", "SELEÇÃO DE FONTE (PRÉ QUALIFICAÇÃO): ("+criterioPreQualificacao.getCodigoprojeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - SELEÇÃO DE FONTE (PRÉ QUALIFICAÇÃO)");
				return "TkcsapcdController?cmd=editarCriterioPreQualificacao";//devolver p/ editar cadastro		
	}
}

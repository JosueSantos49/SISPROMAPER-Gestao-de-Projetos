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

import br.com.tkcsapcd.model.bean.DiagnosticoPlanoAcao;
import br.com.tkcsapcd.model.dao.InterfaceDiagnosticoPlanoAcaoDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarDiagnosticoPlanoAcao implements InterfaceCommand {

	private InterfaceDiagnosticoPlanoAcaoDAO diagnosticoPlanoAcaoDAO;
	public CadastrarDiagnosticoPlanoAcao(InterfaceDiagnosticoPlanoAcaoDAO diagnosticoPlanoAcaoDAO) {
		super();
		this.diagnosticoPlanoAcaoDAO = diagnosticoPlanoAcaoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			DiagnosticoPlanoAcao diagnosticoPlanoAcao = new DiagnosticoPlanoAcao();
			
			diagnosticoPlanoAcao.setDiagnosticoplanoacao(request.getParameter("diagnosticoplanoacao"));
			diagnosticoPlanoAcao.setProjeto(request.getParameter("projeto"));
			diagnosticoPlanoAcao.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			diagnosticoPlanoAcao.setVersao(request.getParameter("versao"));
			diagnosticoPlanoAcao.setData(request.getParameter("data"));
			diagnosticoPlanoAcao.setAutor(request.getParameter("autor"));
			diagnosticoPlanoAcao.setNotarevisao(request.getParameter("notarevisao"));
			diagnosticoPlanoAcao.setAprovacao(request.getParameter("aprovacao"));
			diagnosticoPlanoAcao.setObjetivo(request.getParameter("objetivo"));				
			diagnosticoPlanoAcao.setAbordagem(request.getParameter("abordagem"));					
			diagnosticoPlanoAcao.setProblemas(request.getParameter("problemas"));
			diagnosticoPlanoAcao.setPlano(request.getParameter("plano"));
			diagnosticoPlanoAcao.setPremissa(request.getParameter("premissa"));
			diagnosticoPlanoAcao.setCriterio(request.getParameter("criterio"));
			diagnosticoPlanoAcao.setMarcos(request.getParameter("marcos"));
			diagnosticoPlanoAcao.setOrcamento(request.getParameter("orcamento"));
			diagnosticoPlanoAcao.setRisco(request.getParameter("risco"));
			
			if(ValidationHelper.validar(diagnosticoPlanoAcao)){
						
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM diagnosticoplanoacao WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("codigoprojeto");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+diagnosticoPlanoAcao.getCodigoprojeto()+"), informada!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarDiagnosticoPlanoAcao";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					diagnosticoPlanoAcaoDAO.salvar(diagnosticoPlanoAcao);
					request.setAttribute("mensagem", "Diagnóstico e Plano de Ação: ("+diagnosticoPlanoAcao.getCodigoprojeto()+") cadastrado com sucesso!");
				}
				stmt.close();
				rs.close();
				con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					diagnosticoPlanoAcaoDAO.salvar(diagnosticoPlanoAcao);
					request.setAttribute("mensagem", "Diagnóstico e Plano de Ação: ("+diagnosticoPlanoAcao.getCodigoprojeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - Diagnóstico e Plano de Ação");
				return "TkcsapcdController?cmd=editarDiagnosticoPlanoAcao";//devolver p/ editar cadastro		
	}
}

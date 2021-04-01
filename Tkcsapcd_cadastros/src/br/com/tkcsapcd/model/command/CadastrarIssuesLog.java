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

import br.com.tkcsapcd.model.bean.IssuesLog;
import br.com.tkcsapcd.model.dao.InterfaceIssuesLogDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarIssuesLog implements InterfaceCommand {

	private InterfaceIssuesLogDAO issuesLogDAO;
	public CadastrarIssuesLog(InterfaceIssuesLogDAO issuesLogDAO) {
		super();
		this.issuesLogDAO = issuesLogDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			IssuesLog issuesLog = new IssuesLog();
			
			issuesLog.setIssueslog(request.getParameter("issueslog"));
			issuesLog.setProjeto(request.getParameter("projeto"));
			issuesLog.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			issuesLog.setVersao(request.getParameter("versao"));
			issuesLog.setData(request.getParameter("data"));
			issuesLog.setAutor(request.getParameter("autor"));
			issuesLog.setNotarevisao(request.getParameter("notarevisao"));
			issuesLog.setAprovacao(request.getParameter("aprovacao"));			
			issuesLog.setCodigoissueslog(Integer.valueOf(request.getParameter("codigoissueslog")));					
			issuesLog.setSeveridade(request.getParameter("severidade"));
			issuesLog.setDataidentificacao(request.getParameter("dataidentificacao"));
			issuesLog.setDescricao(request.getParameter("descricaoacao"));
			issuesLog.setUrgencia(request.getParameter("urgencia"));
			issuesLog.setImpacto(request.getParameter("impacto"));
			issuesLog.setDescricaoimpacto(request.getParameter("descricaoimpacto"));
			issuesLog.setDescricaoacao(request.getParameter("descricaoacao"));
			issuesLog.setResponsavel(request.getParameter("responsavel"));					
			issuesLog.setPrevisao(request.getParameter("previsao"));
			issuesLog.setStatus(request.getParameter("status"));
			issuesLog.setComentario(request.getParameter("comentario"));
			
			if(ValidationHelper.validar(issuesLog)){
			
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM issueslog WHERE codigoissueslog = '"+request.getParameter("codigoissueslog")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoissueslog = rs.getInt("codigoissueslog");
				
				if(codigoissueslog >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do Issues Log - Registro das questões ("+issuesLog.getCodigoissueslog()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarIssuesLog";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					issuesLogDAO.salvar(issuesLog);
					request.setAttribute("mensagem", "ISSUES LOG (Registro das questões): ("+issuesLog.getCodigoissueslog()+") cadastrado com sucesso!");
				}
				stmt.close();
				rs.close();
				con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					issuesLogDAO.salvar(issuesLog);
					request.setAttribute("mensagem", "ISSUES LOG (Registro das questões): ("+issuesLog.getCodigoissueslog()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - ISSUES LOG (Registro das questões)");
				return "TkcsapcdController?cmd=editarIssuesLog";//devolver p/ editar cadastro		
	}
}

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

import br.com.tkcsapcd.model.bean.SolicitacaoProjetovBSC;
import br.com.tkcsapcd.model.dao.InterfaceSolicitacaoProjetovBSCDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarSolicitacaoProjetovBSC implements InterfaceCommand {

	private InterfaceSolicitacaoProjetovBSCDAO solicitacaoProjetovBSCDAO;
	public CadastrarSolicitacaoProjetovBSC(InterfaceSolicitacaoProjetovBSCDAO solicitacaoProjetovBSCDAO) {
		super();
		this.solicitacaoProjetovBSCDAO = solicitacaoProjetovBSCDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			SolicitacaoProjetovBSC solicitacaoProjetovBSC = new SolicitacaoProjetovBSC();

			solicitacaoProjetovBSC.setSolicitacaoprojetovbsc(request.getParameter("solicitacaoprojetovbsc"));
			solicitacaoProjetovBSC.setProjeto(request.getParameter("projeto"));
			solicitacaoProjetovBSC.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			solicitacaoProjetovBSC.setVersao(request.getParameter("versao"));
			solicitacaoProjetovBSC.setData(request.getParameter("data"));
			solicitacaoProjetovBSC.setAutor(request.getParameter("autor"));
			solicitacaoProjetovBSC.setNotarevisao(request.getParameter("notarevisao"));
			solicitacaoProjetovBSC.setAprovacao(request.getParameter("aprovacao"));
			solicitacaoProjetovBSC.setObjetivo(request.getParameter("objetivo"));				
			solicitacaoProjetovBSC.setDescricao(request.getParameter("descricao"));					
			solicitacaoProjetovBSC.setCriterio(request.getParameter("criterio"));
			solicitacaoProjetovBSC.setDescricaobeneficio(request.getParameter("descricaobeneficio"));
			
			if(ValidationHelper.validar(solicitacaoProjetovBSC)){
						
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM solicitacaoprojetovbsc WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("codigoprojeto");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+solicitacaoProjetovBSC.getCodigoprojeto()+"), informada!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarSolicitacaoProjetovBSC";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					solicitacaoProjetovBSCDAO.salvar(solicitacaoProjetovBSC);
					request.setAttribute("mensagem", "Solicitação do Projeto - Balanced Scorecard: ("+solicitacaoProjetovBSC.getCodigoprojeto()+") cadastrado com sucesso!");
				}
				stmt.close();
				rs.close();
				con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					solicitacaoProjetovBSCDAO.salvar(solicitacaoProjetovBSC);
					request.setAttribute("mensagem", "Solicitação do Projeto - Balanced Scorecard: ("+solicitacaoProjetovBSC.getCodigoprojeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - Solicitação do Projeto - Balanced Scorecard");
				return "TkcsapcdController?cmd=editarSolicitacaoProjetovBSC";//devolver p/ editar cadastro		
	}
}

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

import br.com.tkcsapcd.model.bean.SolicitacaoMudanca;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.dao.InterfaceSolicitacaoMudancaDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarSolicitacaoMudanca implements InterfaceCommand {

	private InterfaceSolicitacaoMudancaDAO solicitacaoMudancaDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	
	public CadastrarSolicitacaoMudanca(InterfaceSolicitacaoMudancaDAO solicitacaoMudancaDAO,
			InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.solicitacaoMudancaDAO = solicitacaoMudancaDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			SolicitacaoMudanca solicitacaoMudanca = new SolicitacaoMudanca();
			
			solicitacaoMudanca.setSolicitacaomudanca(request.getParameter("solicitacaomudanca"));
			solicitacaoMudanca.setVersao(Integer.valueOf(request.getParameter("versao")));

			String data_1 = request.getParameter("data"); 
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(data_1);
			solicitacaoMudanca.setData(data);
			
			solicitacaoMudanca.setAutor(request.getParameter("autor"));
			solicitacaoMudanca.setNotarevisao(request.getParameter("notarevisao"));
			solicitacaoMudanca.setAprovacao(request.getParameter("aprovacao"));
			solicitacaoMudanca.setSolicitante(request.getParameter("solicitante"));				
			solicitacaoMudanca.setPrioridade(request.getParameter("prioridade"));					
			solicitacaoMudanca.setDescricao(request.getParameter("descricao"));
			solicitacaoMudanca.setJustificativa(request.getParameter("justificativa"));
			solicitacaoMudanca.setClassificacao(request.getParameter("classificacao"));
			
			Integer projetoinicio = Integer.valueOf(request.getParameter("projetoinicio"));										
			solicitacaoMudanca.setProjetoinicio(projetoInicioDAO.getProjetoInicio(projetoinicio));
			
			if(ValidationHelper.validar(solicitacaoMudanca)){
				
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM solicitacaomudanca WHERE versao = '"+request.getParameter("versao")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("versao");
				
				if(codigoprojeto >= 1){
					System.out.println("\n Já existe um registro com o valor informado: " + codigoprojeto);
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com a versão ("+solicitacaoMudanca.getVersao()+"), informada!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarSolicitacaoMudanca";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					solicitacaoMudancaDAO.salvar(solicitacaoMudanca);
					request.setAttribute("mensagem", "SOLICITAÇÃO DE MUDANÇA: ("+solicitacaoMudanca.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
				
					solicitacaoMudancaDAO.salvar(solicitacaoMudanca);
					request.setAttribute("mensagem", "SOLICITAÇÃO DE MUDANÇA: ("+solicitacaoMudanca.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - SOLICITAÇÃO DE MUDANÇA");
				return "TkcsapcdController?cmd=editarSolicitacaoMudanca";//devolver p/ editar cadastro		
	}
}

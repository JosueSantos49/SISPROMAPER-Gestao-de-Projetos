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

import br.com.tkcsapcd.model.bean.RegistroSolicitacaoMudanca;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.dao.InterfaceRegistroSolicitacaoMudancaDAO;
import br.com.tkcsapcd.model.dao.InterfaceSolicitacaoMudancaDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarRegistroSolicitacaoMudanca implements InterfaceCommand {

	private InterfaceRegistroSolicitacaoMudancaDAO registroSolicitacaoMudancaDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	private InterfaceSolicitacaoMudancaDAO solicitacaoMudancaDAO;
	
	public CadastrarRegistroSolicitacaoMudanca(InterfaceRegistroSolicitacaoMudancaDAO registroSolicitacaoMudancaDAO,
			InterfaceProjetoInicioDAO projetoInicioDAO,
			InterfaceSolicitacaoMudancaDAO solicitacaoMudancaDAO) {
		super();
		this.registroSolicitacaoMudancaDAO = registroSolicitacaoMudancaDAO;
		this.solicitacaoMudancaDAO =  solicitacaoMudancaDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			RegistroSolicitacaoMudanca registroSolicitacaoMudanca = new RegistroSolicitacaoMudanca();
			
			registroSolicitacaoMudanca.setVersao(request.getParameter("versao"));
			
			String data_1 = request.getParameter("data"); 
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(data_1);
			registroSolicitacaoMudanca.setData(data);
			
			registroSolicitacaoMudanca.setAutor(request.getParameter("autor"));
			registroSolicitacaoMudanca.setNotarevisao(request.getParameter("notarevisao"));
			registroSolicitacaoMudanca.setAprovacao(request.getParameter("aprovacao"));
			registroSolicitacaoMudanca.setReferencia(request.getParameter("referencia").equals("") ? null : Double.valueOf(request.getParameter("referencia")));				
			registroSolicitacaoMudanca.setPrioridade(request.getParameter("prioridade"));					
			registroSolicitacaoMudanca.setImpedeimplantacao(request.getParameter("impedeimplantacao"));
			registroSolicitacaoMudanca.setSolicitacao(request.getParameter("solicitacao"));
			
			String data_2 = request.getParameter("datasolicitacao"); 
			Date datasolicitacao = new SimpleDateFormat("yyyy-MM-dd").parse(data_2);
			registroSolicitacaoMudanca.setDatasolicitacao(datasolicitacao);					
			
			registroSolicitacaoMudanca.setDescricao(request.getParameter("descricao"));
			registroSolicitacaoMudanca.setJustificativa(request.getParameter("justificativa"));
			registroSolicitacaoMudanca.setEsforcoestimadohoras(request.getParameter("esforcoestimadohoras").equals("") ? null : Double.valueOf(request.getParameter("esforcoestimadohoras")));
			registroSolicitacaoMudanca.setCustoestimado(request.getParameter("custoestimado").equals("") ? null : Double.valueOf(request.getParameter("custoestimado")));
			registroSolicitacaoMudanca.setImpactoprazodias(request.getParameter("impactoprazodias").equals("") ? null : Double.valueOf(request.getParameter("impactoprazodias")));					
			registroSolicitacaoMudanca.setClassificacao(request.getParameter("classificacao"));
			registroSolicitacaoMudanca.setResponsavel(request.getParameter("responsavel"));
			registroSolicitacaoMudanca.setPrevisao(request.getParameter("previsao"));
			registroSolicitacaoMudanca.setStatus(request.getParameter("status"));	
			registroSolicitacaoMudanca.setComentarios(request.getParameter("comentarios"));
			
			Integer projetoinicio = Integer.valueOf(request.getParameter("projetoinicio"));										
			registroSolicitacaoMudanca.setProjetoinicio(projetoInicioDAO.getProjetoInicio(projetoinicio));
			
			Integer solicitacaomudanca = Integer.valueOf(request.getParameter("solicitacaomudanca"));										
			registroSolicitacaoMudanca.setSolicitacaomudanca(solicitacaoMudancaDAO.getSolicitacaoMudanca(solicitacaomudanca));
			
			if(ValidationHelper.validar(registroSolicitacaoMudanca)){
				
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM registrosolicitacaomudanca WHERE projetoinicio = '"+request.getParameter("projetoinicio")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Long codigoprojeto = rs.getLong("projetoinicio");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+registroSolicitacaoMudanca.getProjetoinicio().getProjeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarRegistroSolicitacaoMudanca";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					registroSolicitacaoMudancaDAO.salvar(registroSolicitacaoMudanca);
					request.setAttribute("mensagem", "REGISTRO SOLICITAÇÃO DE MUDANÇA: ("+registroSolicitacaoMudanca.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					registroSolicitacaoMudancaDAO.salvar(registroSolicitacaoMudanca);
					request.setAttribute("mensagem", "REGISTRO SOLICITAÇÃO DE MUDANÇA: ("+registroSolicitacaoMudanca.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - REGISTRO SOLICITAÇÃO DE MUDANÇA");
				return "TkcsapcdController?cmd=editarRegistroSolicitacaoMudanca";//devolver p/ editar cadastro		
	}
}

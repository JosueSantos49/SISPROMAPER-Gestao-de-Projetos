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

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoRequisito;
import br.com.tkcsapcd.model.dao.InterfacePlanoGerenciamentoRequisitoDAO;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarPlanoGerenciamentoRequisito implements InterfaceCommand {

	private InterfacePlanoGerenciamentoRequisitoDAO planoGerenciamentoRequisitoDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	public CadastrarPlanoGerenciamentoRequisito(InterfacePlanoGerenciamentoRequisitoDAO planoGerenciamentoRequisitoDAO, InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.planoGerenciamentoRequisitoDAO = planoGerenciamentoRequisitoDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			PlanoGerenciamentoRequisito planoGerenciamentoRequisito = new PlanoGerenciamentoRequisito();
			
			planoGerenciamentoRequisito.setPlanogerenciamentorequisito(request.getParameter("planogerenciamentorequisito"));
			planoGerenciamentoRequisito.setVersao(request.getParameter("versao"));
			
			String data_1 = request.getParameter("data"); 
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(data_1);
			planoGerenciamentoRequisito.setData(data);
			
			planoGerenciamentoRequisito.setAutor(request.getParameter("autor"));
			planoGerenciamentoRequisito.setNotarevisao(request.getParameter("notarevisao"));
			planoGerenciamentoRequisito.setAprovacao(request.getParameter("aprovacao"));
			planoGerenciamentoRequisito.setObjetivo(request.getParameter("objetivo"));
			planoGerenciamentoRequisito.setGerenciamento(request.getParameter("gerenciamento"));
			planoGerenciamentoRequisito.setProcesso(request.getParameter("processo"));					
			planoGerenciamentoRequisito.setDocumento(request.getParameter("documento"));
			planoGerenciamentoRequisito.setResponsabilidade(request.getParameter("responsabilidade"));
			planoGerenciamentoRequisito.setConfiguracao(request.getParameter("configuracao"));
			planoGerenciamentoRequisito.setPrioridade(request.getParameter("prioridade"));
			planoGerenciamentoRequisito.setColeta(request.getParameter("coleta"));
			planoGerenciamentoRequisito.setRatreabilidade(request.getParameter("ratreabilidade"));
			planoGerenciamentoRequisito.setMetrica(request.getParameter("metrica"));
			
			Integer projetoinicio = Integer.valueOf(request.getParameter("projetoinicio"));										
			planoGerenciamentoRequisito.setProjetoinicio(projetoInicioDAO.getProjetoInicio(projetoinicio));
			
			if(ValidationHelper.validar(planoGerenciamentoRequisito)){
			
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM planogerenciamentorequisito WHERE projetoinicio = '"+request.getParameter("projetoinicio")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("projetoinicio");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+planoGerenciamentoRequisito.getProjetoinicio().getProjeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarPlanoGerenciamentoRequisito";//devolver p/ editar cadastro	
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					planoGerenciamentoRequisitoDAO.salvar(planoGerenciamentoRequisito);
					request.setAttribute("mensagem", "PLANO DE GERENCIAMENTO DOS REQUISITOS: ("+planoGerenciamentoRequisito.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					planoGerenciamentoRequisitoDAO.salvar(planoGerenciamentoRequisito);
					request.setAttribute("mensagem", "PLANO DE GERENCIAMENTO DOS REQUISITOS: ("+planoGerenciamentoRequisito.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - PLANO DE GERENCIAMENTO DOS REQUISITOS");
				return "TkcsapcdController?cmd=editarPlanoGerenciamentoRequisito";//devolver p/ editar cadastro		
	}
}

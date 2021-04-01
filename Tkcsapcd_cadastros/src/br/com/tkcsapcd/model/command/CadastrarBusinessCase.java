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

import br.com.tkcsapcd.model.bean.BusinessCase;
import br.com.tkcsapcd.model.dao.InterfaceBusinessCaseDAO;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarBusinessCase implements InterfaceCommand {

	private InterfaceBusinessCaseDAO businessCaseDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	public CadastrarBusinessCase(InterfaceBusinessCaseDAO businessCaseDAO, InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.businessCaseDAO = businessCaseDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			BusinessCase businessCase = new BusinessCase();
			
			businessCase.setBusinesscase(request.getParameter("businesscase"));
			businessCase.setVersao(request.getParameter("versao"));

			String data_1 = request.getParameter("data"); 
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(data_1);
			businessCase.setData(data);
			
			businessCase.setAutor(request.getParameter("autor"));
			businessCase.setNotarevisao(request.getParameter("notarevisao"));
			businessCase.setAprovacao(request.getParameter("aprovacao"));		
			businessCase.setObjetivodocumento(request.getParameter("objetivodocumento"));
			businessCase.setObjetivo(request.getParameter("objetivo"));
			businessCase.setNecessidade(request.getParameter("necessidade"));
			businessCase.setIndicadores(request.getParameter("indicadores"));
			businessCase.setPrevisao(request.getParameter("previsao"));
			businessCase.setOrganizacao(request.getParameter("organizacao"));
			businessCase.setAnalise(request.getParameter("analise"));
			businessCase.setPartes(request.getParameter("partes"));					
			businessCase.setOrcamento(request.getParameter("orcamento"));
			
			Integer projetoinicio = Integer.valueOf(request.getParameter("projetoinicio"));										
			businessCase.setProjetoinicio(projetoInicioDAO.getProjetoInicio(projetoinicio));
			
			if(ValidationHelper.validar(businessCase)){
						
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM businesscase WHERE projetoinicio = '"+request.getParameter("projetoinicio")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("projetoinicio");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+businessCase.getProjetoinicio().getProjeto()+"), informada!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarBusinessCase";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					businessCaseDAO.salvar(businessCase);
					request.setAttribute("mensagem", "BUSINESS CASE: ("+businessCase.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");
				}
				stmt.close();
				rs.close();
				con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					businessCaseDAO.salvar(businessCase);
					request.setAttribute("mensagem", "BUSINESS CASE: ("+businessCase.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - BUSINESS CASE");
				return "TkcsapcdController?cmd=editarBusinessCase";//devolver p/ editar cadastro		
	}
}

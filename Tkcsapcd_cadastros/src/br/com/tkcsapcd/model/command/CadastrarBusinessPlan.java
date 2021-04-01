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

import br.com.tkcsapcd.model.bean.BusinessPlan;
import br.com.tkcsapcd.model.dao.InterfaceBusinessPlanDAO;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarBusinessPlan implements InterfaceCommand {

	private InterfaceBusinessPlanDAO BusinessPlanDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	
	public CadastrarBusinessPlan(InterfaceBusinessPlanDAO BusinessPlanDAO, InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.BusinessPlanDAO = BusinessPlanDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			BusinessPlan businessPlan = new BusinessPlan();
						
			businessPlan.setBusinessplan(request.getParameter("businessplan"));
			businessPlan.setVersao(request.getParameter("versao"));
			
			String data_1 = request.getParameter("data"); 
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(data_1);
			businessPlan.setData(data);
			
			businessPlan.setAutor(request.getParameter("autor"));
			businessPlan.setNotarevisao(request.getParameter("notarevisao"));
			businessPlan.setAprovacao(request.getParameter("aprovacao"));		
			businessPlan.setSituacaomercado(request.getParameter("situacaomercado"));
			businessPlan.setSituacaoservico(request.getParameter("situacaoservico"));
			businessPlan.setSituacaocompetividade(request.getParameter("situacaocompetividade"));
			businessPlan.setSituacaodistribuicao(request.getParameter("situacaodistribuicao"));
			businessPlan.setSituacaomacro(request.getParameter("situacaomacro"));
			businessPlan.setAnaliseexterno(request.getParameter("analiseexterno"));
			businessPlan.setAnaliseinterno(request.getParameter("analiseinterno"));
			businessPlan.setAnaliserelacionada(request.getParameter("analiserelacionada"));					
			businessPlan.setObjetivofinanceiro(request.getParameter("objetivofinanceiro"));
			businessPlan.setObjetivomarketing(request.getParameter("objetivomarketing"));
			businessPlan.setCronograma(request.getParameter("cronograma"));
			businessPlan.setEstrategia(request.getParameter("estrategia"));					
			businessPlan.setSegmento(request.getParameter("segmento"));
			
			Integer projetoinicio = Integer.valueOf(request.getParameter("projetoinicio"));										
			businessPlan.setProjetoinicio(projetoInicioDAO.getProjetoInicio(projetoinicio));
			
			if(ValidationHelper.validar(businessPlan)){
			
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM businessplan WHERE projetoinicio = '"+request.getParameter("projetoinicio")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Long codigoprojeto = rs.getLong("projetoinicio");
				
				if(codigoprojeto >= 1){
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+businessPlan.getProjetoinicio().getProjeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarBusinessPlan";//devolver p/ editar cadastro
				}else{
					BusinessPlanDAO.salvar(businessPlan);
					request.setAttribute("mensagem", "BUSINESS PLAN: ("+businessPlan.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");
				}
				stmt.close();
				rs.close();
				con.close();
			}
					BusinessPlanDAO.salvar(businessPlan);
					request.setAttribute("mensagem", "BUSINESS PLAN: ("+businessPlan.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - BUSINESS PLAN");
				return "TkcsapcdController?cmd=editarBusinessPlan";//devolver p/ editar cadastro		
	}
}

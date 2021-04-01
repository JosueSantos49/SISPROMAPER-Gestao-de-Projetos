/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceDeclaracaoEscopoDAO;
import br.com.tkcsapcd.model.dao.InterfaceDicionarioEAPDAO;
import br.com.tkcsapcd.model.dao.InterfacePlanoGerenciamentoProjetoDAO;
import br.com.tkcsapcd.model.dao.InterfacePortfolioProjetoDAO;
import br.com.tkcsapcd.model.dao.InterfaceRegistroParteInteressadaDAO;
import br.com.tkcsapcd.model.dao.InterfaceRegistroRiscoDAO;
import br.com.tkcsapcd.model.dao.InterfaceStatusReportDAO;

public class EditarPortfolioProjeto implements InterfaceCommand {

	private InterfacePortfolioProjetoDAO portfolioProjetoDAO;
	private InterfaceRegistroParteInteressadaDAO registroParteInteressadaDAO;
	private InterfacePlanoGerenciamentoProjetoDAO planoGerenciamentoProjetoDAO;
	private InterfaceDeclaracaoEscopoDAO declaracaoEscopoDAO;
	private InterfaceDicionarioEAPDAO dicionarioEAPDAO;
	private InterfaceRegistroRiscoDAO registroRiscoDAO;
	private InterfaceStatusReportDAO statusReportDAO;	
	
	public EditarPortfolioProjeto(InterfacePortfolioProjetoDAO portfolioProjetoDAO, 
			InterfaceRegistroParteInteressadaDAO registroParteInteressadaDAO,			
			InterfacePlanoGerenciamentoProjetoDAO planoGerenciamentoProjetoDAO, 
			InterfaceDeclaracaoEscopoDAO declaracaoEscopoDAO,
			InterfaceDicionarioEAPDAO dicionarioEAPDAO,
			InterfaceRegistroRiscoDAO registroRiscoDAO,
			InterfaceStatusReportDAO statusReportDAO) {
		super();
		this.portfolioProjetoDAO = portfolioProjetoDAO;
		this.registroParteInteressadaDAO = registroParteInteressadaDAO;
		this.planoGerenciamentoProjetoDAO = planoGerenciamentoProjetoDAO;
		this.declaracaoEscopoDAO = declaracaoEscopoDAO;
		this.dicionarioEAPDAO = dicionarioEAPDAO;
		this.registroRiscoDAO = registroRiscoDAO;
		this.statusReportDAO = statusReportDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception  {			
			try{			
					
					//Setando o atributo, para listar so select da pagina cadastro
					request.setAttribute("registroParteInteressadas", registroParteInteressadaDAO.getRegistroParteInteressadas());
					request.setAttribute("planoGerenciamentoProjetos", planoGerenciamentoProjetoDAO.getPlanoGerenciamentoProjetos());
					request.setAttribute("declaracaoEscopos", declaracaoEscopoDAO.getDeclaracaoEscopos());
					request.setAttribute("dicionarioEAPs", dicionarioEAPDAO.getDicionarioEAPs());
					request.setAttribute("registroRiscos", registroRiscoDAO.getRegistroRiscos());
					request.setAttribute("statusReports", statusReportDAO.getStatusReports());
					
					if(request.getParameter("codigo") == null)
					{
						request.setAttribute("titulo", "Cadastro - Portfólio de Projeto");
						return "cadastro_portfolio_projeto.jsp";
					}
					
					//Grande jogada				
					request.setAttribute("portfolioProjeto", portfolioProjetoDAO.getPortfolioProjeto(Integer.valueOf(request.getParameter("codigo"))));
					
					} catch (NumberFormatException e) {
						
						// Se o numero não for válido
						request.setAttribute("mensagem", "Valo do código inválido:"+request.getParameter("codigo"));
						
					} catch (SQLException e) {
						 
						request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
						e.printStackTrace();
					}				
						//Caso funcione td corretamente. Seta o atributo
						request.setAttribute("titulo", "Atualização - Portfólio de Projeto");				
						return "atualiza_portfolio_projeto.jsp";
			}
	}

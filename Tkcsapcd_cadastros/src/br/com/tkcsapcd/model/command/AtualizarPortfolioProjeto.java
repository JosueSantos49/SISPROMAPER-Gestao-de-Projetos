/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.PortfolioProjeto;
import br.com.tkcsapcd.model.dao.InterfacePortfolioProjetoDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarPortfolioProjeto implements InterfaceCommand {

	private InterfacePortfolioProjetoDAO portfolioProjetoDAO;
	public AtualizarPortfolioProjeto(InterfacePortfolioProjetoDAO portfolioProjetoDAO) {
		super();
		this.portfolioProjetoDAO = portfolioProjetoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request						
					PortfolioProjeto portfolioProjeto = new PortfolioProjeto();
					
					portfolioProjeto.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					portfolioProjeto.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
					portfolioProjeto.setPrioridade(request.getParameter("prioridade"));
					portfolioProjeto.setTipoprojeto(request.getParameter("tipoprojeto"));
					portfolioProjeto.setUnidadenegocio(request.getParameter("unidadenegocio"));
					portfolioProjeto.setAnalista(request.getParameter("analista"));
					portfolioProjeto.setGerente(request.getParameter("gerente"));
					portfolioProjeto.setFase(request.getParameter("fase"));
					portfolioProjeto.setFaseatual(request.getParameter("faseatual"));
					
					String datainicio_1 = request.getParameter("datainicio"); 
					Date datainicio =  new SimpleDateFormat("yyyy-MM-dd").parse(datainicio_1);
					portfolioProjeto.setDatainicio(datainicio);
					
					String datatermino_1 = request.getParameter("datatermino"); 
					Date datatermino =  new SimpleDateFormat("yyyy-MM-dd").parse(datatermino_1);
					portfolioProjeto.setDatatermino(datatermino);
					
					String dataatual_1 = request.getParameter("dataatual"); 
					Date dataatual =  new SimpleDateFormat("yyyy-MM-dd").parse(dataatual_1);
					portfolioProjeto.setDataatual(dataatual);
								
					portfolioProjeto.setParteinteressada(request.getParameter("parteinteressada"));
					portfolioProjeto.setPlanoprojeto(request.getParameter("planoprojeto"));
					portfolioProjeto.setDeclaracaoescopo(request.getParameter("declaracaoescopo"));
					portfolioProjeto.setDicionarioeap(request.getParameter("dicionarioeap"));
					portfolioProjeto.setCronograma(request.getParameter("cronograma"));
					portfolioProjeto.setRegistrorisco(request.getParameter("registrorisco"));
					portfolioProjeto.setStatusreport(request.getParameter("statusreport"));
					portfolioProjeto.setEscopo(request.getParameter("escopo"));					
					portfolioProjeto.setCusto(Double.parseDouble(request.getParameter("custo")));
					portfolioProjeto.setComentario(request.getParameter("comentario"));
					portfolioProjeto.setNivel(request.getParameter("nivel"));
					portfolioProjeto.setEntrega(request.getParameter("entrega"));	
					portfolioProjeto.setStatus(request.getParameter("status"));
					portfolioProjeto.setRecursos(request.getParameter("recursos"));				
					portfolioProjeto.setReplanejamento(request.getParameter("replanejamento"));
					portfolioProjeto.setEstimativa(request.getParameter("estimativa"));
					portfolioProjeto.setLinhabase(request.getParameter("linhabase"));
					portfolioProjeto.setEsforco(request.getParameter("esforco"));
					portfolioProjeto.setConclusao(request.getParameter("conclusao"));
					portfolioProjeto.setEtapa(request.getParameter("etapa"));
					portfolioProjeto.setEap(request.getParameter("eap"));
					portfolioProjeto.setResponsavel(request.getParameter("responsavel"));
		
		if(ValidationHelper.validar(portfolioProjeto)){			
			portfolioProjetoDAO.atualizar(portfolioProjeto);
			request.setAttribute("mensagem", "Portfólio de Projeto: ("+portfolioProjeto.getCodigoprojeto()+") atualizado com sucesso!");
		}
		else{
			throw new Exception("Valor inválido");
		}	
		} catch (SQLException e) {
			
			request.setAttribute("mensagem", "Problema com a atualização: "+e.getMessage());
			e.printStackTrace();
			
		}catch (NumberFormatException e) {
			request.setAttribute("mensagem", "Valor inválido: "+e.getMessage());			
		}	
			request.setAttribute("titulo", "Atualização - Portfólio de Projeto");
			return "TkcsapcdController?cmd=consultarPortfolioProjeto";//Pagina de Retorno (pagina consulta)
	}

}

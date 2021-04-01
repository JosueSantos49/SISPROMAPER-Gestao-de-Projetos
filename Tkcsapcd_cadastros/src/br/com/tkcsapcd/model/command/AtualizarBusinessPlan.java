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

import br.com.tkcsapcd.model.bean.BusinessPlan;
import br.com.tkcsapcd.model.dao.InterfaceBusinessPlanDAO;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarBusinessPlan implements InterfaceCommand {

	private InterfaceBusinessPlanDAO BusinessPlanDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	
	public AtualizarBusinessPlan(InterfaceBusinessPlanDAO BusinessPlanDAO, InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.BusinessPlanDAO = BusinessPlanDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request										
					BusinessPlan businessPlan = new BusinessPlan();
					
					businessPlan.setCodigo(Long.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					businessPlan.setBusinessplan(request.getParameter("businessplan"));
					businessPlan.setVersao(request.getParameter("versao"));
					
					String data_1 = request.getParameter("data"); 
					Date data = new SimpleDateFormat("yyyy-MM-dd").parse(data_1);
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
			BusinessPlanDAO.atualizar(businessPlan);
			request.setAttribute("mensagem", "BUSINESS PLAN: ("+businessPlan.getProjetoinicio().getProjeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - BUSINESS PLAN");
			return "TkcsapcdController?cmd=consultarBusinessPlan";//Pagina de Retorno (pagina consulta)
	}

}

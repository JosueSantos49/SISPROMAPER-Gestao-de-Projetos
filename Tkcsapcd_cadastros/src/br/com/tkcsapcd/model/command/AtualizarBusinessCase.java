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

import br.com.tkcsapcd.model.bean.BusinessCase;
import br.com.tkcsapcd.model.dao.InterfaceBusinessCaseDAO;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarBusinessCase implements InterfaceCommand {

	private InterfaceBusinessCaseDAO businessCaseDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	public AtualizarBusinessCase(InterfaceBusinessCaseDAO businessCaseDAO, InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.businessCaseDAO = businessCaseDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request										
					BusinessCase businessCase = new BusinessCase();
					
					businessCase.setCodigo(Long.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					businessCase.setBusinesscase(request.getParameter("businesscase"));
					businessCase.setVersao(request.getParameter("versao"));
					
					String data_1 = request.getParameter("data"); 
					Date data = new SimpleDateFormat("yyyy-MM-dd").parse(data_1);
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
			businessCaseDAO.atualizar(businessCase);
			request.setAttribute("mensagem", "BUSINESS CASE: ("+businessCase.getProjetoinicio().getProjeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - BUSINESS CASE");
			return "TkcsapcdController?cmd=consultarBusinessCase";//Pagina de Retorno (pagina consulta)
	}

}

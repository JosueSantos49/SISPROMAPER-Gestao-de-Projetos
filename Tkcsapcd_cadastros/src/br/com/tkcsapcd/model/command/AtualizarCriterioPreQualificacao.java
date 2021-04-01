/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.CriterioPreQualificacao;
import br.com.tkcsapcd.model.dao.InterfaceCriterioPreQualificacaoDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//M�todo registrado na InterfaceCommand
public class AtualizarCriterioPreQualificacao implements InterfaceCommand {

	private InterfaceCriterioPreQualificacaoDAO criterioPreQualificacaoDAO;
	public AtualizarCriterioPreQualificacao(InterfaceCriterioPreQualificacaoDAO criterioPreQualificacaoDAO) {
		super();
		this.criterioPreQualificacaoDAO = criterioPreQualificacaoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request					
					CriterioPreQualificacao criterioPreQualificacao = new CriterioPreQualificacao();
					
					criterioPreQualificacao.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa citua��o					
					criterioPreQualificacao.setRfp(request.getParameter("rfp"));
					criterioPreQualificacao.setObjetivo(request.getParameter("objetivo"));
					criterioPreQualificacao.setProjeto(request.getParameter("projeto"));
					criterioPreQualificacao.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
					criterioPreQualificacao.setGp(request.getParameter("gp"));
					criterioPreQualificacao.setPatrocinador(request.getParameter("patrocinador"));
					criterioPreQualificacao.setArea(request.getParameter("area"));
					criterioPreQualificacao.setParticipante(request.getParameter("participante"));
					criterioPreQualificacao.setAprovado(request.getParameter("aprovado"));				
					criterioPreQualificacao.setReprovado(request.getParameter("reprovado"));
		
		if(ValidationHelper.validar(criterioPreQualificacao)){			
			criterioPreQualificacaoDAO.atualizar(criterioPreQualificacao);
			request.setAttribute("mensagem", "SELE��O DE FONTE (PR� QUALIFICA��O): ("+criterioPreQualificacao.getCodigoprojeto()+") atualizado com sucesso!");
		}
		else{
			throw new Exception("Valor inv�lido");
		}	
		} catch (SQLException e) {
			
			request.setAttribute("mensagem", "Problema com a atualiza��o: "+e.getMessage());
			e.printStackTrace();
			
		}catch (NumberFormatException e) {
			request.setAttribute("mensagem", "Valor inv�lido: "+e.getMessage());			
		}	
			request.setAttribute("titulo", "Atualiza��o - SELE��O DE FONTE (PR� QUALIFICA��O)");
			return "TkcsapcdController?cmd=consultarCriterioPreQualificacao";//Pagina de Retorno (pagina consulta)
	}

}

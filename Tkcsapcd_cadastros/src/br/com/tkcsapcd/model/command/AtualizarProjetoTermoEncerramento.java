/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.ProjetoTermoEncerramento;
import br.com.tkcsapcd.model.dao.InterfaceProjetoTermoEncerramentoDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarProjetoTermoEncerramento implements InterfaceCommand {

	private InterfaceProjetoTermoEncerramentoDAO projetoTermoEncerramentoDAO;
	
	public AtualizarProjetoTermoEncerramento(InterfaceProjetoTermoEncerramentoDAO projetoTermoEncerramentoDAO) {
		super();
		this.projetoTermoEncerramentoDAO = projetoTermoEncerramentoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {	
					//  Preencher o Bean com os valores do request
					ProjetoTermoEncerramento projetoTermoEncerramento = new ProjetoTermoEncerramento();
					
					projetoTermoEncerramento.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação					
					projetoTermoEncerramento.setCodigoprojeto(request.getParameter("codigoprojeto"));
					projetoTermoEncerramento.setDatadocumento(request.getParameter("datadocumento"));
					projetoTermoEncerramento.setCoordenador(request.getParameter("coordenador"));
					projetoTermoEncerramento.setTipoprojeto(request.getParameter("tipoprojeto"));
					projetoTermoEncerramento.setGestor(request.getParameter("gestor"));
					projetoTermoEncerramento.setPrograma(request.getParameter("programa"));
					projetoTermoEncerramento.setStatusconclusao(request.getParameter("statusconclusao"));
					projetoTermoEncerramento.setDataanaliseresultado(request.getParameter("dataanaliseresultado"));
					projetoTermoEncerramento.setObjetivoprojeto(request.getParameter("objetivoprojeto"));
					projetoTermoEncerramento.setJustificativaprojeto(request.getParameter("justificativaprojeto"));
					projetoTermoEncerramento.setOrcamentoprevisto(request.getParameter("orcamentoprevisto"));
					projetoTermoEncerramento.setValorempenhado(request.getParameter("valorempenhado"));
					projetoTermoEncerramento.setValorpago(request.getParameter("valorpago"));
					projetoTermoEncerramento.setSaldo(request.getParameter("saldo"));
					projetoTermoEncerramento.setResultadoprevisto(request.getParameter("resultadoprevisto"));
					projetoTermoEncerramento.setPeso(request.getParameter("peso"));
					projetoTermoEncerramento.setProgresso(request.getParameter("progresso"));
					projetoTermoEncerramento.setDetalhamento(request.getParameter("detalhamento"));
					projetoTermoEncerramento.setAnaliseefetividade(request.getParameter("analiseefetividade"));
					projetoTermoEncerramento.setDocumentacaofisica(request.getParameter("documentacaofisica"));
					projetoTermoEncerramento.setDocumentacaoeletronica(request.getParameter("documentacaoeletronica"));			
					projetoTermoEncerramento.setConcideracaocoordenador(request.getParameter("concideracaocoordenador"));
					projetoTermoEncerramento.setConcideracaogestor(request.getParameter("concideracaogestor"));
					projetoTermoEncerramento.setTermo(request.getParameter("termo"));
					projetoTermoEncerramento.setNomeprojeto(request.getParameter("nomeprojeto"));
			
			if(ValidationHelper.validar(projetoTermoEncerramento)){
				projetoTermoEncerramentoDAO.atualizar(projetoTermoEncerramento);
				request.setAttribute("mensagem", "Termo de Encerramento do Projeto: ("+projetoTermoEncerramento.getCodigoprojeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - Termo de Encerramento do Projeto");
			return "TkcsapcdController?cmd=consultarProjetoTermoEncerramento";//Pagina de Retorno (pagina consulta cliente)
	}

}

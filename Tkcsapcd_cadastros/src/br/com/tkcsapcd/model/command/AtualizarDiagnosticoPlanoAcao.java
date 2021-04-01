/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.DiagnosticoPlanoAcao;
import br.com.tkcsapcd.model.dao.InterfaceDiagnosticoPlanoAcaoDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//M�todo registrado na InterfaceCommand
public class AtualizarDiagnosticoPlanoAcao implements InterfaceCommand {

	private InterfaceDiagnosticoPlanoAcaoDAO diagnosticoPlanoAcaoDAO;
	public AtualizarDiagnosticoPlanoAcao(InterfaceDiagnosticoPlanoAcaoDAO diagnosticoPlanoAcaoDAO) {
		super();
		this.diagnosticoPlanoAcaoDAO = diagnosticoPlanoAcaoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request
					DiagnosticoPlanoAcao diagnosticoPlanoAcao = new DiagnosticoPlanoAcao();
					
					diagnosticoPlanoAcao.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa citua��o
					diagnosticoPlanoAcao.setDiagnosticoplanoacao(request.getParameter("diagnosticoplanoacao"));
					diagnosticoPlanoAcao.setProjeto(request.getParameter("projeto"));
					diagnosticoPlanoAcao.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
					diagnosticoPlanoAcao.setVersao(request.getParameter("versao"));
					diagnosticoPlanoAcao.setData(request.getParameter("data"));
					diagnosticoPlanoAcao.setAutor(request.getParameter("autor"));
					diagnosticoPlanoAcao.setNotarevisao(request.getParameter("notarevisao"));
					diagnosticoPlanoAcao.setAprovacao(request.getParameter("aprovacao"));
					diagnosticoPlanoAcao.setObjetivo(request.getParameter("objetivo"));				
					diagnosticoPlanoAcao.setAbordagem(request.getParameter("abordagem"));					
					diagnosticoPlanoAcao.setProblemas(request.getParameter("problemas"));
					diagnosticoPlanoAcao.setPlano(request.getParameter("plano"));
					diagnosticoPlanoAcao.setPremissa(request.getParameter("premissa"));
					diagnosticoPlanoAcao.setCriterio(request.getParameter("criterio"));
					diagnosticoPlanoAcao.setMarcos(request.getParameter("marcos"));
					diagnosticoPlanoAcao.setOrcamento(request.getParameter("orcamento"));
					diagnosticoPlanoAcao.setRisco(request.getParameter("risco"));
		
		if(ValidationHelper.validar(diagnosticoPlanoAcao)){			
			diagnosticoPlanoAcaoDAO.atualizar(diagnosticoPlanoAcao);
			request.setAttribute("mensagem", "Diagn�stico e Plano de A��o: ("+diagnosticoPlanoAcao.getCodigoprojeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualiza��o - Diagn�stico e Plano de A��o");
			return "TkcsapcdController?cmd=consultarDiagnosticoPlanoAcao";//Pagina de Retorno (pagina consulta)
	}

}

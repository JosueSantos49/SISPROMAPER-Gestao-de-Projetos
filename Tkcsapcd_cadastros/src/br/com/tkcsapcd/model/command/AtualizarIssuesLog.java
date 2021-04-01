/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.IssuesLog;
import br.com.tkcsapcd.model.dao.InterfaceIssuesLogDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//M�todo registrado na InterfaceCommand
public class AtualizarIssuesLog implements InterfaceCommand {

	private InterfaceIssuesLogDAO issuesLogDAO;
	public AtualizarIssuesLog(InterfaceIssuesLogDAO issuesLogDAO) {
		super();
		this.issuesLogDAO = issuesLogDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request					
					IssuesLog issuesLog = new IssuesLog();
					
					issuesLog.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa citua��o
					issuesLog.setIssueslog(request.getParameter("issueslog"));
					issuesLog.setProjeto(request.getParameter("projeto"));
					issuesLog.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
					issuesLog.setVersao(request.getParameter("versao"));
					issuesLog.setData(request.getParameter("data"));
					issuesLog.setAutor(request.getParameter("autor"));
					issuesLog.setNotarevisao(request.getParameter("notarevisao"));
					issuesLog.setAprovacao(request.getParameter("aprovacao"));			
					issuesLog.setCodigoissueslog(Integer.valueOf(request.getParameter("codigoissueslog")));					
					issuesLog.setSeveridade(request.getParameter("severidade"));
					issuesLog.setDataidentificacao(request.getParameter("dataidentificacao"));
					issuesLog.setDescricao(request.getParameter("descricaoacao"));
					issuesLog.setUrgencia(request.getParameter("urgencia"));
					issuesLog.setImpacto(request.getParameter("impacto"));
					issuesLog.setDescricaoimpacto(request.getParameter("descricaoimpacto"));
					issuesLog.setDescricaoacao(request.getParameter("descricaoacao"));
					issuesLog.setResponsavel(request.getParameter("responsavel"));					
					issuesLog.setPrevisao(request.getParameter("previsao"));
					issuesLog.setStatus(request.getParameter("status"));
					issuesLog.setComentario(request.getParameter("comentario"));
		
		if(ValidationHelper.validar(issuesLog)){			
			issuesLogDAO.atualizar(issuesLog);
			request.setAttribute("mensagem", "ISSUES LOG (Registro das quest�es): ("+issuesLog.getCodigoprojeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualiza��o - ISSUES LOG (Registro das quest�es)");
			return "TkcsapcdController?cmd=consultarIssuesLog";//Pagina de Retorno (pagina consulta)
	}

}

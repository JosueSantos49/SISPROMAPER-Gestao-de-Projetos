/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.SolicitacaoProjetovBSC;
import br.com.tkcsapcd.model.dao.InterfaceSolicitacaoProjetovBSCDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarSolicitacaoProjetovBSC implements InterfaceCommand {

	private InterfaceSolicitacaoProjetovBSCDAO solicitacaoProjetovBSCDAO;
	public AtualizarSolicitacaoProjetovBSC(InterfaceSolicitacaoProjetovBSCDAO solicitacaoProjetovBSCDAO) {
		super();
		this.solicitacaoProjetovBSCDAO = solicitacaoProjetovBSCDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request		
					SolicitacaoProjetovBSC solicitacaoProjetovBSC = new SolicitacaoProjetovBSC();
					
					solicitacaoProjetovBSC.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					solicitacaoProjetovBSC.setSolicitacaoprojetovbsc(request.getParameter("solicitacaoprojetovbsc"));
					solicitacaoProjetovBSC.setProjeto(request.getParameter("projeto"));
					solicitacaoProjetovBSC.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
					solicitacaoProjetovBSC.setVersao(request.getParameter("versao"));
					solicitacaoProjetovBSC.setData(request.getParameter("data"));
					solicitacaoProjetovBSC.setAutor(request.getParameter("autor"));
					solicitacaoProjetovBSC.setNotarevisao(request.getParameter("notarevisao"));
					solicitacaoProjetovBSC.setAprovacao(request.getParameter("aprovacao"));
					solicitacaoProjetovBSC.setObjetivo(request.getParameter("objetivo"));				
					solicitacaoProjetovBSC.setDescricao(request.getParameter("descricao"));					
					solicitacaoProjetovBSC.setCriterio(request.getParameter("criterio"));
					solicitacaoProjetovBSC.setDescricaobeneficio(request.getParameter("descricaobeneficio"));
		
		if(ValidationHelper.validar(solicitacaoProjetovBSC)){			
			solicitacaoProjetovBSCDAO.atualizar(solicitacaoProjetovBSC);
			request.setAttribute("mensagem", "Solicitação do Projeto - Balanced Scorecard: ("+solicitacaoProjetovBSC.getCodigoprojeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - Solicitação do Projeto - Balanced Scorecard");
			return "TkcsapcdController?cmd=consultarSolicitacaoProjetovBSC";//Pagina de Retorno (pagina consulta)
	}

}

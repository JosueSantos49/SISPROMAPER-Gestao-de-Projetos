/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.SolicitacaoServicoTI;
import br.com.tkcsapcd.model.dao.InterfaceSolicitacaoServicoTIDAO;

//Método registrado na InterfaceCommand
public class AtualizarSolicitacaoServicoTI implements InterfaceCommand {

	private InterfaceSolicitacaoServicoTIDAO solicitacaoServicoTIDAO;
	public AtualizarSolicitacaoServicoTI(InterfaceSolicitacaoServicoTIDAO solicitacaoServicoTIDAO) {
		super();
		this.solicitacaoServicoTIDAO = solicitacaoServicoTIDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {		
			SolicitacaoServicoTI solicitacaoServicoTI = new SolicitacaoServicoTI();
			
			solicitacaoServicoTI.setCodigo(Integer.valueOf(request.getParameter("codigo")));
			solicitacaoServicoTI.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			solicitacaoServicoTI.setCodigosolicitaoservico(request.getParameter("codigosolicitaoservico"));			
			solicitacaoServicoTI.setArea(request.getParameter("area"));
			solicitacaoServicoTI.setResponsaveldemanda(request.getParameter("responsaveldemanda"));
			solicitacaoServicoTI.setTelefonecontato(request.getParameter("telefonecontato"));
			solicitacaoServicoTI.setEmail(request.getParameter("email"));
			solicitacaoServicoTI.setId(request.getParameter("id"));
			solicitacaoServicoTI.setDatasolicitacao(request.getParameter("datasolicitacao"));
			solicitacaoServicoTI.setNomedemanda(request.getParameter("nomedemanda"));
			solicitacaoServicoTI.setObjetivodemanda(request.getParameter("objetivodemanda"));
			solicitacaoServicoTI.setDecricaoproblema(request.getParameter("decricaoproblema"));
			solicitacaoServicoTI.setDesenhoprocesso(request.getParameter("desenhoprocesso"));
			solicitacaoServicoTI.setFuncionalidade(request.getParameter("funcionalidade"));
			solicitacaoServicoTI.setParteenvolvida(request.getParameter("parteenvolvida"));
			solicitacaoServicoTI.setParteenvolvidarepresentante(request.getParameter("parteenvolvidarepresentante"));
			solicitacaoServicoTI.setParteenvolvidaformacontato(request.getParameter("parteenvolvidaformacontato"));
			solicitacaoServicoTI.setEstimativacustoglobal(request.getParameter("estimativacustoglobal"));
			solicitacaoServicoTI.setFontefinanciamento(request.getParameter("fontefinanciamento"));
			solicitacaoServicoTI.setMetodolevantamentocusto(request.getParameter("metodolevantamentocusto"));
			solicitacaoServicoTI.setNumerousuarioprevisto(request.getParameter("numerousuarioprevisto"));
			solicitacaoServicoTI.setRecursos(request.getParameter("recursos"));
			solicitacaoServicoTI.setTreinamentopessoal(request.getParameter("treinamentopessoal"));
			solicitacaoServicoTI.setMaterialapoio(request.getParameter("materialapoio"));
			solicitacaoServicoTI.setRestricaoprojeto(request.getParameter("restricaoprojeto"));
			solicitacaoServicoTI.setPrincipaisusuarios(request.getParameter("principaisusuarios"));
			solicitacaoServicoTI.setNecessidadeusuario(request.getParameter("necessidadeusuario"));
			solicitacaoServicoTI.setPrioridade(request.getParameter("prioridade"));
			solicitacaoServicoTI.setSolucaoatual(request.getParameter("solucaoatual"));
			solicitacaoServicoTI.setProblemasolucaoatual(request.getParameter("problemasolucaoatual"));
			solicitacaoServicoTI.setSolucaoproposta(request.getParameter("solucaoproposta"));
			solicitacaoServicoTI.setStatus(request.getParameter("status"));
			
			solicitacaoServicoTIDAO.atualizar(solicitacaoServicoTI);
			request.setAttribute("mensagem", "SSTI-(Código do Projeto): "+solicitacaoServicoTI.getCodigoprojeto()+", atualizada com sucesso!" );
			
			} catch (SQLException e) {
						
				request.setAttribute("mensagem", "Problema com a atualização: "+e.getMessage());
				
			e.printStackTrace();
			
			}catch (NumberFormatException e) {
				request.setAttribute("mensagem", "Valor inválido: "+e.getMessage());			
			}	
			request.setAttribute("titulo", "Atualização - SSTI");
			return "TkcsapcdController?cmd=consultarSolicitacaoServicoTI";
	}

}

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

import br.com.tkcsapcd.model.bean.RegistroSolicitacaoMudanca;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.dao.InterfaceRegistroSolicitacaoMudancaDAO;
import br.com.tkcsapcd.model.dao.InterfaceSolicitacaoMudancaDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarRegistroSolicitacaoMudanca implements InterfaceCommand {

	private InterfaceRegistroSolicitacaoMudancaDAO registroSolicitacaoMudancaDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	private InterfaceSolicitacaoMudancaDAO solicitacaoMudancaDAO;
		
	public AtualizarRegistroSolicitacaoMudanca(InterfaceRegistroSolicitacaoMudancaDAO registroSolicitacaoMudancaDAO, 
			InterfaceProjetoInicioDAO projetoInicioDAO,
			InterfaceSolicitacaoMudancaDAO solicitacaoMudancaDAO) {
		super();
		this.registroSolicitacaoMudancaDAO = registroSolicitacaoMudancaDAO;
		this.projetoInicioDAO = projetoInicioDAO;
		this.solicitacaoMudancaDAO =  solicitacaoMudancaDAO;		
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request								
					RegistroSolicitacaoMudanca registroSolicitacaoMudanca = new RegistroSolicitacaoMudanca();
					
					registroSolicitacaoMudanca.setCodigo(Long.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					registroSolicitacaoMudanca.setVersao(request.getParameter("versao"));
					
					String data_1 = request.getParameter("data"); 
					Date data = new SimpleDateFormat("yyyy-MM-dd").parse(data_1);
					registroSolicitacaoMudanca.setData(data);
					
					registroSolicitacaoMudanca.setAutor(request.getParameter("autor"));
					registroSolicitacaoMudanca.setNotarevisao(request.getParameter("notarevisao"));
					registroSolicitacaoMudanca.setAprovacao(request.getParameter("aprovacao"));
					registroSolicitacaoMudanca.setReferencia(request.getParameter("referencia").equals("") ? null : Double.valueOf(request.getParameter("referencia")));				
					registroSolicitacaoMudanca.setPrioridade(request.getParameter("prioridade"));					
					registroSolicitacaoMudanca.setImpedeimplantacao(request.getParameter("impedeimplantacao"));
					registroSolicitacaoMudanca.setSolicitacao(request.getParameter("solicitacao"));
					
					String data_2 = request.getParameter("datasolicitacao"); 
					Date datasolicitacao = new SimpleDateFormat("yyyy-MM-dd").parse(data_2);
					registroSolicitacaoMudanca.setDatasolicitacao(datasolicitacao);					
					
					registroSolicitacaoMudanca.setDescricao(request.getParameter("descricao"));
					registroSolicitacaoMudanca.setJustificativa(request.getParameter("justificativa"));
					registroSolicitacaoMudanca.setEsforcoestimadohoras(request.getParameter("esforcoestimadohoras").equals("") ? null : Double.valueOf(request.getParameter("esforcoestimadohoras")));
					registroSolicitacaoMudanca.setCustoestimado(request.getParameter("custoestimado").equals("") ? null : Double.valueOf(request.getParameter("custoestimado")));
					registroSolicitacaoMudanca.setImpactoprazodias(request.getParameter("impactoprazodias").equals("") ? null : Double.valueOf(request.getParameter("impactoprazodias")));					
					registroSolicitacaoMudanca.setClassificacao(request.getParameter("classificacao"));
					registroSolicitacaoMudanca.setResponsavel(request.getParameter("responsavel"));
					registroSolicitacaoMudanca.setPrevisao(request.getParameter("previsao"));
					registroSolicitacaoMudanca.setStatus(request.getParameter("status"));	
					registroSolicitacaoMudanca.setComentarios(request.getParameter("comentarios"));
					
					Integer projetoinicio = Integer.valueOf(request.getParameter("projetoinicio"));										
					registroSolicitacaoMudanca.setProjetoinicio(projetoInicioDAO.getProjetoInicio(projetoinicio));
					
					Integer solicitacaomudanca = Integer.valueOf(request.getParameter("solicitacaomudanca"));										
					registroSolicitacaoMudanca.setSolicitacaomudanca(solicitacaoMudancaDAO.getSolicitacaoMudanca(solicitacaomudanca));
		
		if(ValidationHelper.validar(registroSolicitacaoMudanca)){			
			registroSolicitacaoMudancaDAO.atualizar(registroSolicitacaoMudanca);
			request.setAttribute("mensagem", "REGISTRO SOLICITAÇÃO DE MUDANÇA: ("+registroSolicitacaoMudanca.getProjetoinicio().getProjeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - REGISTRO SOLICITAÇÃO DE MUDANÇA");
			return "TkcsapcdController?cmd=consultarRegistroSolicitacaoMudanca";//Pagina de Retorno (pagina consulta)
	}

}

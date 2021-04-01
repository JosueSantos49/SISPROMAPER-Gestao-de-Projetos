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

import br.com.tkcsapcd.model.bean.SolicitacaoMudanca;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.dao.InterfaceSolicitacaoMudancaDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarSolicitacaoMudanca implements InterfaceCommand {

	private InterfaceSolicitacaoMudancaDAO solicitacaoMudancaDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	
	public AtualizarSolicitacaoMudanca(InterfaceSolicitacaoMudancaDAO solicitacaoMudancaDAO,
			InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.solicitacaoMudancaDAO = solicitacaoMudancaDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request
					SolicitacaoMudanca solicitacaoMudanca = new SolicitacaoMudanca();
					
					solicitacaoMudanca.setCodigo(Long.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					solicitacaoMudanca.setSolicitacaomudanca(request.getParameter("solicitacaomudanca"));
					solicitacaoMudanca.setVersao(Integer.valueOf(request.getParameter("versao")));
					
					String data_1 = request.getParameter("data"); 
					Date data = new SimpleDateFormat("yyyy-MM-dd").parse(data_1);
					solicitacaoMudanca.setData(data);
					
					solicitacaoMudanca.setAutor(request.getParameter("autor"));
					solicitacaoMudanca.setNotarevisao(request.getParameter("notarevisao"));
					solicitacaoMudanca.setAprovacao(request.getParameter("aprovacao"));
					solicitacaoMudanca.setSolicitante(request.getParameter("solicitante"));				
					solicitacaoMudanca.setPrioridade(request.getParameter("prioridade"));					
					solicitacaoMudanca.setDescricao(request.getParameter("descricao"));
					solicitacaoMudanca.setJustificativa(request.getParameter("justificativa"));
					solicitacaoMudanca.setClassificacao(request.getParameter("classificacao"));
					
					Integer projetoinicio = Integer.valueOf(request.getParameter("projetoinicio"));										
					solicitacaoMudanca.setProjetoinicio(projetoInicioDAO.getProjetoInicio(projetoinicio));
		
		if(ValidationHelper.validar(solicitacaoMudanca)){			
			solicitacaoMudancaDAO.atualizar(solicitacaoMudanca);
			request.setAttribute("mensagem", "SOLICITAÇÃO DE MUDANÇA: ("+solicitacaoMudanca.getProjetoinicio().getProjeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - SOLICITAÇÃO DE MUDANÇA");
			return "TkcsapcdController?cmd=consultarSolicitacaoMudanca";//Pagina de Retorno (pagina consulta)
	}

}

/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.SolicitacaoProjeto;
import br.com.tkcsapcd.model.dao.InterfaceSolicitacaoProjetoDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarSolicitacaoProjeto implements InterfaceCommand {

	private InterfaceSolicitacaoProjetoDAO solicitacaoProjetoDAO;
	public AtualizarSolicitacaoProjeto(InterfaceSolicitacaoProjetoDAO solicitacaoProjetoDAO) {
		super();
		this.solicitacaoProjetoDAO = solicitacaoProjetoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request					
					SolicitacaoProjeto solicitacaoProjeto = new SolicitacaoProjeto();
					
					solicitacaoProjeto.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					solicitacaoProjeto.setSolicitacaoprojeto(request.getParameter("solicitacaoprojeto"));
					solicitacaoProjeto.setProjeto(request.getParameter("projeto"));
					solicitacaoProjeto.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
					solicitacaoProjeto.setVersao(request.getParameter("versao"));
					solicitacaoProjeto.setData(request.getParameter("data"));
					solicitacaoProjeto.setAutor(request.getParameter("autor"));
					solicitacaoProjeto.setNotarevisao(request.getParameter("notarevisao"));
					solicitacaoProjeto.setAprovacao(request.getParameter("aprovacao"));
					solicitacaoProjeto.setObjetivo(request.getParameter("objetivo"));				
					solicitacaoProjeto.setAtual(request.getParameter("atual"));					
					solicitacaoProjeto.setDescricao(request.getParameter("descricao"));
		
		if(ValidationHelper.validar(solicitacaoProjeto)){			
			solicitacaoProjetoDAO.atualizar(solicitacaoProjeto);
			request.setAttribute("mensagem", "SOLICITAÇÃO DO PROJETO: ("+solicitacaoProjeto.getCodigoprojeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - SOLICITAÇÃO DO PROJETO");
			return "TkcsapcdController?cmd=consultarSolicitacaoProjeto";//Pagina de Retorno (pagina consulta)
	}

}

/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.RfpProjeto;
import br.com.tkcsapcd.model.dao.InterfaceRfpProjetoDAO;

public class AtualizarRfpProjeto implements InterfaceCommand {

	private InterfaceRfpProjetoDAO rfpProjetoDAO;
	
	public AtualizarRfpProjeto(InterfaceRfpProjetoDAO rfpProjetoDAO) {
		super();
		this.rfpProjetoDAO = rfpProjetoDAO;
	}

	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response) throws Exception {
		
		try {
			RfpProjeto rfpProjeto = new RfpProjeto();// Codigo de processamento
			
			rfpProjeto.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
			rfpProjeto.setNomeRfpProjeto(request.getParameter("nomeRfpProjeto"));
			rfpProjeto.setCodigoProjeto(request.getParameter("codigoProjeto"));
			rfpProjeto.setItensProjeto(request.getParameter("itensProjeto"));			
			rfpProjeto.setNomeempresa(request.getParameter("nomeempresa"));
			rfpProjeto.setHistoricoempresa(request.getParameter("historicoempresa"));
			rfpProjeto.setProdutoempresa(request.getParameter("produtoempresa"));
			rfpProjeto.setMercadoempresa(request.getParameter("mercadoempresa"));
			rfpProjeto.setValoresempresa(request.getParameter("valoresempresa"));
			rfpProjeto.setEndereco(request.getParameter("endereco"));
			rfpProjeto.setCidade(request.getParameter("cidade"));
			rfpProjeto.setEstado(request.getParameter("estado"));
			rfpProjeto.setNumero(request.getParameter("numero"));
			rfpProjeto.setBairro(request.getParameter("bairro"));
			rfpProjeto.setCep(request.getParameter("cep"));
			rfpProjeto.setTelefone(request.getParameter("telefone"));
			rfpProjeto.setRepresentante(request.getParameter("representante"));
			rfpProjeto.setEmailrepresentante(request.getParameter("emailrepresentante"));
			rfpProjeto.setAquisicao(request.getParameter("aquisicao"));
			rfpProjeto.setEscopo(request.getParameter("escopo"));
			rfpProjeto.setRestricao(request.getParameter("restricao"));
			rfpProjeto.setRecurso(request.getParameter("recurso"));
			rfpProjeto.setAvaliacao(request.getParameter("avaliacao"));
			rfpProjeto.setCronograma(request.getParameter("cronograma"));
			rfpProjeto.setProposta(request.getParameter("proposta"));
			rfpProjeto.setCondicaoproposta(request.getParameter("condicaoproposta"));
			rfpProjeto.setObservacao(request.getParameter("observacao"));
			rfpProjeto.setData(request.getParameter("data"));
		
			
			rfpProjetoDAO.atualizar(rfpProjeto);
			request.setAttribute("mensagem", "FRP-Projeto: ("+rfpProjeto.getCodigoProjeto()+") atualizado com sucesso!");
			
			}		
			catch (SQLException e) {
				
				request.setAttribute("mensagem", "Problema com a atualização: "+e.getMessage());
				e.printStackTrace();				
			}
			catch (NumberFormatException e) {
				request.setAttribute("mensagem", "Valor inválido: "+e.getMessage());
			}
			request.setAttribute("titulo", "Atualização - RFP Projeto");
			return "TkcsapcdController?cmd=consultarRfpProjeto";//Pagina de Retorno (pagina consulta funcionario)
		}
	

}

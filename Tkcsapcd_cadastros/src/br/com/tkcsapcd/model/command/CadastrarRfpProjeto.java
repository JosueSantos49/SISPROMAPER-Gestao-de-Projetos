/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.RfpProjeto;
import br.com.tkcsapcd.model.dao.InterfaceRfpProjetoDAO;
import br.com.tkcsapcd.model.email.EnviaEmail;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarRfpProjeto implements InterfaceCommand {
	
	public CadastrarRfpProjeto(InterfaceRfpProjetoDAO rfpProjetoDAO) {
		super();
		this.rfpProjetoDAO = rfpProjetoDAO;
	}
	private InterfaceRfpProjetoDAO rfpProjetoDAO;
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response) throws Exception {
		try {
			// Preencher o Bean com os valores do request
			RfpProjeto rfpProjeto = new RfpProjeto();	
			
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
			
			if(ValidationHelper.validar(rfpProjeto)){
				rfpProjetoDAO.salvar(rfpProjeto);
				request.setAttribute("mensagem","RFP-Projeto: ("+rfpProjeto.getNomeRfpProjeto()+") cadastrado com sucesso!");
				
				//Regra de envio de e-mail Javamail. Confirmação de registro
				//String de 		= request.getParameter("de");
				String para 	= request.getParameter("emailrepresentante");
				//String assunto 	= request.getParameter("assunto");
				//String mensagem = request.getParameter("mensagem");
				//String lista 	= request.getParameter("lista");
						
				RequestDispatcher rd = null;
				
				EnviaEmail enviaEmail = new EnviaEmail();
				
					//enviaEmail.setDe(de);
					enviaEmail.setPara(para);
					//enviaEmail.setAssunto(assunto);
					//enviaEmail.setMensagem(mensagem);			
					//enviaEmail.setLista(lista);		
				
				boolean enviado = enviaEmail.enviarRFP();		
				
				if(enviado)
					request.setAttribute("msg", "E-mail enviado com sucesso!");	
				else
					request.setAttribute("msg", "E-mail não enviado!");				
				
				rd = request.getRequestDispatcher("TkcsapcdController?cmd=editarRfpProjeto");
				rd.forward(request, response);	
				
			}
			else{
				throw new Exception("Valor Inválido");
			}
		} catch (SQLException e) {
			
			request.setAttribute("mensagem","Problemas com a gravação: " + e.getMessage());
			e.printStackTrace();
			
		} catch (NumberFormatException e) {
			
			request.setAttribute("mensagem","Valor inválido: " + e.getMessage());
			e.printStackTrace();
		}
			request.setAttribute("titulo", "Cadastro - RFP Projeto");
			return "TkcsapcdController?cmd=editarRfpProjeto";// devolver para o editar
	}

}

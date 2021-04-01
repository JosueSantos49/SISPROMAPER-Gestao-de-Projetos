/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoAquisicao;
import br.com.tkcsapcd.model.dao.InterfacePlanoGerenciamentoAquisicaoDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarPlanoGerenciamentoAquisicao implements InterfaceCommand {

	private InterfacePlanoGerenciamentoAquisicaoDAO planoGerenciamentoAquisicaoDAO;
	public AtualizarPlanoGerenciamentoAquisicao(InterfacePlanoGerenciamentoAquisicaoDAO planoGerenciamentoAquisicaoDAO) {
		super();
		this.planoGerenciamentoAquisicaoDAO = planoGerenciamentoAquisicaoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request	
					PlanoGerenciamentoAquisicao planoGerenciamentoAquisicao = new PlanoGerenciamentoAquisicao();
					
					planoGerenciamentoAquisicao.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação				
					planoGerenciamentoAquisicao.setPlanogerenciamentoaquisicao(request.getParameter("planogerenciamentoaquisicao"));
					planoGerenciamentoAquisicao.setProjeto(request.getParameter("projeto"));
					planoGerenciamentoAquisicao.setCodigoprojeto(request.getParameter("codigoprojeto"));
					planoGerenciamentoAquisicao.setVersao(request.getParameter("versao"));
					planoGerenciamentoAquisicao.setData(request.getParameter("data"));
					planoGerenciamentoAquisicao.setAutor(request.getParameter("autor"));
					planoGerenciamentoAquisicao.setNotarevisao(request.getParameter("notarevisao"));
					planoGerenciamentoAquisicao.setAprovacao(request.getParameter("aprovacao"));
					planoGerenciamentoAquisicao.setObjetivo(request.getParameter("objetivo"));	
					planoGerenciamentoAquisicao.setMetodo(request.getParameter("metodo"));
					planoGerenciamentoAquisicao.setProcesso(request.getParameter("processo"));
					planoGerenciamentoAquisicao.setDecisoes(request.getParameter("decisoes"));
					planoGerenciamentoAquisicao.setDocumento(request.getParameter("documento"));
					planoGerenciamentoAquisicao.setResponsabilidade(request.getParameter("responsabilidade"));
					planoGerenciamentoAquisicao.setMetrica(request.getParameter("metrica"));					
					planoGerenciamentoAquisicao.setPremissarestricao(request.getParameter("premissarestricao"));
					planoGerenciamentoAquisicao.setRiscos(request.getParameter("riscos"));
					planoGerenciamentoAquisicao.setFornecedor(request.getParameter("fornecedor"));					
					planoGerenciamentoAquisicao.setConduziraquisicao(request.getParameter("conduziraquisicao"));
					planoGerenciamentoAquisicao.setTipocontrato(request.getParameter("tipocontrato"));
					planoGerenciamentoAquisicao.setCriterioavaliacao(request.getParameter("criterioavaliacao"));
					planoGerenciamentoAquisicao.setControlaaquisicao(request.getParameter("controlaaquisicao"));	
					planoGerenciamentoAquisicao.setAvalicacaofornecedor(request.getParameter("avalicacaofornecedor"));
					planoGerenciamentoAquisicao.setEncerraraquisicao(request.getParameter("encerraraquisicao"));
		
		if(ValidationHelper.validar(planoGerenciamentoAquisicao)){			
			planoGerenciamentoAquisicaoDAO.atualizar(planoGerenciamentoAquisicao);
			request.setAttribute("mensagem", "PLANO DE GERENCIAMENTO DA AQUISIÇÕES: ("+planoGerenciamentoAquisicao.getCodigoprojeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - PLANO DE GERENCIAMENTO DA AQUISIÇÕES");
			return "TkcsapcdController?cmd=consultarPlanoGerenciamentoAquisicao";//Pagina de Retorno (pagina consulta)
	}

}

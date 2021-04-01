/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoComunicacao;
import br.com.tkcsapcd.model.dao.InterfacePlanoGerenciamentoComunicacaoDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//M�todo registrado na InterfaceCommand
public class AtualizarPlanoGerenciamentoComunicacao implements InterfaceCommand {

	private InterfacePlanoGerenciamentoComunicacaoDAO planoGerenciamentoComunicacaoDAO;
	public AtualizarPlanoGerenciamentoComunicacao(InterfacePlanoGerenciamentoComunicacaoDAO planoGerenciamentoComunicacaoDAO) {
		super();
		this.planoGerenciamentoComunicacaoDAO = planoGerenciamentoComunicacaoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request					
					PlanoGerenciamentoComunicacao planoGerenciamentoComunicacao = new PlanoGerenciamentoComunicacao();
					
					planoGerenciamentoComunicacao.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa citua��o
					planoGerenciamentoComunicacao.setPlanogerenciamentocomunicacao(request.getParameter("planogerenciamentocomunicacao"));
					planoGerenciamentoComunicacao.setProjeto(request.getParameter("projeto"));
					planoGerenciamentoComunicacao.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
					planoGerenciamentoComunicacao.setVersao(request.getParameter("versao"));
					planoGerenciamentoComunicacao.setData(request.getParameter("data"));
					planoGerenciamentoComunicacao.setAutor(request.getParameter("autor"));
					planoGerenciamentoComunicacao.setNotarevisao(request.getParameter("notarevisao"));
					planoGerenciamentoComunicacao.setAprovacao(request.getParameter("aprovacao"));
					planoGerenciamentoComunicacao.setObjetivo(request.getParameter("objetivo"));				
					planoGerenciamentoComunicacao.setProcesso(request.getParameter("processo"));					
					planoGerenciamentoComunicacao.setRequisito(request.getParameter("requisito"));
					planoGerenciamentoComunicacao.setInformcacao(request.getParameter("informcacao"));
					planoGerenciamentoComunicacao.setTecnologia(request.getParameter("tecnologia"));
					planoGerenciamentoComunicacao.setDiretrize(request.getParameter("diretrize"));
					planoGerenciamentoComunicacao.setComunicacao(request.getParameter("eventocomunicacao"));
					planoGerenciamentoComunicacao.setGestao(request.getParameter("gestao"));
					planoGerenciamentoComunicacao.setStatus(request.getParameter("status"));
					planoGerenciamentoComunicacao.setGerenciareunioes(request.getParameter("gerenciareunioes"));					
					planoGerenciamentoComunicacao.setGerenciaquestoes(request.getParameter("gerenciaquestoes"));
					planoGerenciamentoComunicacao.setPlanoescalonamento(request.getParameter("planoescalonamento"));
					planoGerenciamentoComunicacao.setEventocomunicacao(request.getParameter("eventocomunicacao"));
					planoGerenciamentoComunicacao.setAnexo(request.getParameter("anexo"));
		
		if(ValidationHelper.validar(planoGerenciamentoComunicacao)){			
			planoGerenciamentoComunicacaoDAO.atualizar(planoGerenciamentoComunicacao);
			request.setAttribute("mensagem", "PLANO DE GERENCIAMENTO DAS COMUNICA��ES: ("+planoGerenciamentoComunicacao.getCodigoprojeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualiza��o - PLANO DE GERENCIAMENTO DAS COMUNICA��ES");
			return "TkcsapcdController?cmd=consultarPlanoGerenciamentoComunicacao";//Pagina de Retorno (pagina consulta)
	}

}

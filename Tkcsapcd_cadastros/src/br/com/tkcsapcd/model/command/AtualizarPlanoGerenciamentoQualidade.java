/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoQualidade;
import br.com.tkcsapcd.model.dao.InterfacePlanoGerenciamentoQualidadeDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarPlanoGerenciamentoQualidade implements InterfaceCommand {

	private InterfacePlanoGerenciamentoQualidadeDAO planoGerenciamentoQualidadeDAO;
	public AtualizarPlanoGerenciamentoQualidade(InterfacePlanoGerenciamentoQualidadeDAO planoGerenciamentoQualidadeDAO) {
		super();
		this.planoGerenciamentoQualidadeDAO = planoGerenciamentoQualidadeDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request					
					PlanoGerenciamentoQualidade planoGerenciamentoQualidade = new PlanoGerenciamentoQualidade();
					
					planoGerenciamentoQualidade.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					planoGerenciamentoQualidade.setPlanogerenciamentoqualidade(request.getParameter("planogerenciamentoqualidade"));
					planoGerenciamentoQualidade.setProjeto(request.getParameter("projeto"));
					planoGerenciamentoQualidade.setCodigoprojeto(request.getParameter("codigoprojeto"));
					planoGerenciamentoQualidade.setVersao(request.getParameter("versao"));
					planoGerenciamentoQualidade.setData(request.getParameter("data"));
					planoGerenciamentoQualidade.setAutor(request.getParameter("autor"));
					planoGerenciamentoQualidade.setNotarevisao(request.getParameter("notarevisao"));
					planoGerenciamentoQualidade.setAprovacao(request.getParameter("aprovacao"));
					planoGerenciamentoQualidade.setObjetivo(request.getParameter("objetivo"));				
					planoGerenciamentoQualidade.setMetodo(request.getParameter("metodo"));					
					planoGerenciamentoQualidade.setProcessoqualidade(request.getParameter("processoqualidade"));
					planoGerenciamentoQualidade.setObjetivo(request.getParameter("objetivo"));
					planoGerenciamentoQualidade.setJustificativa(request.getParameter("justificativa"));
					planoGerenciamentoQualidade.setMetrica(request.getParameter("metrica"));
					planoGerenciamentoQualidade.setFerramentaqualidade(request.getParameter("ferramentaqualidade"));
					planoGerenciamentoQualidade.setEntregaprojetoaceitacao(request.getParameter("entregaprojetoaceitacao"));
					planoGerenciamentoQualidade.setGarantiaqualidade(request.getParameter("garantiaqualidade"));
					planoGerenciamentoQualidade.setAuditoria(request.getParameter("logauditoria"));					
					planoGerenciamentoQualidade.setProcessomelhoria(request.getParameter("processomelhoria"));
					planoGerenciamentoQualidade.setResponsabilidadequalidade(request.getParameter("responsabilidadequalidade"));
					planoGerenciamentoQualidade.setLogauditoria(request.getParameter("logauditoria"));
					planoGerenciamentoQualidade.setControlequalidade(request.getParameter("controlequalidade"));	
					planoGerenciamentoQualidade.setProcedimentoinspecao(request.getParameter("procedimentoinspecao"));
					planoGerenciamentoQualidade.setProcedimentomonitoramento(request.getParameter("procedimentomonitoramento"));
		
		if(ValidationHelper.validar(planoGerenciamentoQualidade)){			
			planoGerenciamentoQualidadeDAO.atualizar(planoGerenciamentoQualidade);
			request.setAttribute("mensagem", "PLANO DE GERENCIAMENTO DA QUALIDADE: ("+planoGerenciamentoQualidade.getCodigoprojeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - PLANO DE GERENCIAMENTO DA QUALIDADE");
			return "TkcsapcdController?cmd=consultarPlanoGerenciamentoQualidade";//Pagina de Retorno (pagina consulta)
	}

}

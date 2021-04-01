/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.RelatorioEncerramentoContrato;
import br.com.tkcsapcd.model.dao.InterfaceRelatorioEncerramentoContratoDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//M�todo registrado na InterfaceCommand
public class AtualizarRelatorioEncerramentoContrato implements InterfaceCommand {

	private InterfaceRelatorioEncerramentoContratoDAO relatorioEncerramentoContratoDAO;
	public AtualizarRelatorioEncerramentoContrato(InterfaceRelatorioEncerramentoContratoDAO relatorioEncerramentoContratoDAO) {
		super();
		this.relatorioEncerramentoContratoDAO = relatorioEncerramentoContratoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request		
					RelatorioEncerramentoContrato relatorioEncerramentoContrato = new RelatorioEncerramentoContrato();
					
					relatorioEncerramentoContrato.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa citua��o
					relatorioEncerramentoContrato.setRelatorio(request.getParameter("relatorio"));
					relatorioEncerramentoContrato.setProjeto(request.getParameter("projeto"));
					relatorioEncerramentoContrato.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
					relatorioEncerramentoContrato.setObjetivo(request.getParameter("objetivo"));
					relatorioEncerramentoContrato.setIdentificacao(request.getParameter("identificacao"));								
					relatorioEncerramentoContrato.setEntrega(request.getParameter("entrega"));					
					relatorioEncerramentoContrato.setQuestoes(request.getParameter("questoes"));
					relatorioEncerramentoContrato.setInformacoes(request.getParameter("informacoes"));
					relatorioEncerramentoContrato.setAceite(request.getParameter("aceite"));
		
		if(ValidationHelper.validar(relatorioEncerramentoContrato)){			
			relatorioEncerramentoContratoDAO.atualizar(relatorioEncerramentoContrato);
			request.setAttribute("mensagem", "Relat�rio de Encerramento do Contrato: ("+relatorioEncerramentoContrato.getCodigoprojeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualiza��o - Relat�rio de Encerramento do Contrato");
			return "TkcsapcdController?cmd=consultarRelatorioEncerramentoContrato";//Pagina de Retorno (pagina consulta)
	}

}

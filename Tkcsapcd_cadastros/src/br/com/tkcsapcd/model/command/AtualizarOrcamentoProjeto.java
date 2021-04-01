/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.OrcamentoProjeto;
import br.com.tkcsapcd.model.dao.InterfaceOrcamentoProjetoDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//M�todo registrado na InterfaceCommand
public class AtualizarOrcamentoProjeto implements InterfaceCommand {

	private InterfaceOrcamentoProjetoDAO orcamentoProjetoDAO;
	public AtualizarOrcamentoProjeto(InterfaceOrcamentoProjetoDAO orcamentoProjetoDAO) {
		super();
		this.orcamentoProjetoDAO = orcamentoProjetoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request		
					OrcamentoProjeto orcamentoProjeto = new OrcamentoProjeto();
					
					orcamentoProjeto.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa citua��o
					orcamentoProjeto.setOrcamento(request.getParameter("orcamento"));
					orcamentoProjeto.setProjeto(request.getParameter("projeto"));
					orcamentoProjeto.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
					orcamentoProjeto.setVersao(request.getParameter("versao"));
					orcamentoProjeto.setData(request.getParameter("data"));
					orcamentoProjeto.setAutor(request.getParameter("autor"));
					orcamentoProjeto.setNotarevisao(request.getParameter("notarevisao"));
					orcamentoProjeto.setAprovacao(request.getParameter("aprovacao"));
					orcamentoProjeto.setObjetivo(request.getParameter("objetivo"));				
					orcamentoProjeto.setBase(request.getParameter("base"));					
					orcamentoProjeto.setEstimativarecurso(request.getParameter("estimativarecurso"));
					orcamentoProjeto.setEstimativaatividade(request.getParameter("estimativaatividade"));
					orcamentoProjeto.setLinha(request.getParameter("linha"));
					orcamentoProjeto.setRequisito(request.getParameter("requisito"));
					orcamentoProjeto.setFluxo(request.getParameter("fluxo"));
		
		if(ValidationHelper.validar(orcamentoProjeto)){			
			orcamentoProjetoDAO.atualizar(orcamentoProjeto);
			request.setAttribute("mensagem", "Or�amento do projeto: ("+orcamentoProjeto.getCodigoprojeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualiza��o - Or�amento do projeto");
			return "TkcsapcdController?cmd=consultarOrcamentoProjeto";//Pagina de Retorno (pagina consulta)
	}

}

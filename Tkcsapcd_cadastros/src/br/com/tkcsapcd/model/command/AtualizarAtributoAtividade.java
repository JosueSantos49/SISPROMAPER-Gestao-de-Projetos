/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.AtributoAtividade;
import br.com.tkcsapcd.model.dao.InterfaceAtributoAtividadeDAO;
import br.com.tkcsapcd.model.dao.InterfaceOrganogramaDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarAtributoAtividade implements InterfaceCommand {

	private InterfaceAtributoAtividadeDAO atributoAtividadeDAO;
	private InterfaceOrganogramaDAO organogramaDAO;
	
	public AtualizarAtributoAtividade(InterfaceAtributoAtividadeDAO atributoAtividadeDAO, InterfaceOrganogramaDAO organogramaDAO) {
		super();
		this.atributoAtividadeDAO = atributoAtividadeDAO;
		this.organogramaDAO = organogramaDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request					
					AtributoAtividade atributoAtividade = new AtributoAtividade();
					
					atributoAtividade.setCodigo(Long.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					atributoAtividade.setId(Long.valueOf(request.getParameter("id")));					
					atributoAtividade.setDescricao(request.getParameter("descricao"));
					atributoAtividade.setPredecessora(request.getParameter("predecessora"));
					atributoAtividade.setSucessora(request.getParameter("sucessora"));
					atributoAtividade.setRelacionamento(request.getParameter("relacionamento"));
					atributoAtividade.setAntecipacao(request.getParameter("antecipacao"));
					atributoAtividade.setRecurso(request.getParameter("recurso"));
					atributoAtividade.setData(request.getParameter("data"));					
					atributoAtividade.setResponsavel(request.getParameter("responsavel"));		
					atributoAtividade.setAreageografica(request.getParameter("areageografica"));
					
					Integer organograma = Integer.valueOf(request.getParameter("organograma"));										
					atributoAtividade.setOrganograma(organogramaDAO.getOrganograma(organograma));
		
		if(ValidationHelper.validar(atributoAtividade)){			
			atributoAtividadeDAO.atualizar(atributoAtividade);
			request.setAttribute("mensagem", "Atributos das Atividades: ("+atributoAtividade.getOrganograma().getDescricao()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - Atributos das Atividades");
			return "TkcsapcdController?cmd=consultarAtributoAtividade";//Pagina de Retorno (pagina consulta)
	}

}

/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.ListaAtividade;
import br.com.tkcsapcd.model.dao.InterfaceListaAtividadeDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//M�todo registrado na InterfaceCommand
public class AtualizarListaAtividade implements InterfaceCommand {

	private InterfaceListaAtividadeDAO listaAtividadeDAO;
	public AtualizarListaAtividade(InterfaceListaAtividadeDAO listaAtividadeDAO) {
		super();
		this.listaAtividadeDAO = listaAtividadeDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request					
					ListaAtividade listaAtividade = new ListaAtividade();
					
					listaAtividade.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa citua��o			
					listaAtividade.setListaatividade(request.getParameter("listaatividade"));
					listaAtividade.setProjeto(request.getParameter("projeto"));
					listaAtividade.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
					listaAtividade.setVersao(request.getParameter("versao"));
					listaAtividade.setData(request.getParameter("data"));
					listaAtividade.setAutor(request.getParameter("autor"));
					listaAtividade.setNotarevisao(request.getParameter("notarevisao"));
					listaAtividade.setAprovacao(request.getParameter("aprovacao"));
					listaAtividade.setObjetivo(request.getParameter("objetivo"));				
					listaAtividade.setEntrega(request.getParameter("entrega"));
		
		if(ValidationHelper.validar(listaAtividade)){			
			listaAtividadeDAO.atualizar(listaAtividade);
			request.setAttribute("mensagem", "LISTA DAS ATIVIDADES: ("+listaAtividade.getCodigoprojeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualiza��o - LISTA DAS ATIVIDADES");
			return "TkcsapcdController?cmd=consultarListaAtividade";//Pagina de Retorno (pagina consulta)
	}

}

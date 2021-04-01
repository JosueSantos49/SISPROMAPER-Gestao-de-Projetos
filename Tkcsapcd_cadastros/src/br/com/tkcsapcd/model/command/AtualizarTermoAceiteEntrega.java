/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.TermoAceiteEntrega;
import br.com.tkcsapcd.model.dao.InterfaceTermoAceiteEntregaDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarTermoAceiteEntrega implements InterfaceCommand {

	private InterfaceTermoAceiteEntregaDAO termoAceiteEntregaDAO;
	public AtualizarTermoAceiteEntrega(InterfaceTermoAceiteEntregaDAO termoAceiteEntregaDAO) {
		super();
		this.termoAceiteEntregaDAO = termoAceiteEntregaDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request					
					TermoAceiteEntrega termoAceiteEntrega = new TermoAceiteEntrega();
					
					termoAceiteEntrega.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					termoAceiteEntrega.setTermo(request.getParameter("termo"));
					termoAceiteEntrega.setProjeto(request.getParameter("projeto"));
					termoAceiteEntrega.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
					termoAceiteEntrega.setObjetivo(request.getParameter("objetivo"));
					termoAceiteEntrega.setEntrega(request.getParameter("entrega"));
					termoAceiteEntrega.setQuestao(request.getParameter("questao"));
					termoAceiteEntrega.setInformacao(request.getParameter("informacao"));
					termoAceiteEntrega.setAceite(request.getParameter("aceite"));
		
		if(ValidationHelper.validar(termoAceiteEntrega)){			
			termoAceiteEntregaDAO.atualizar(termoAceiteEntrega);
			request.setAttribute("mensagem", "TERMO DE ACEITE DA ENTREGA: ("+termoAceiteEntrega.getCodigoprojeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - TERMO DE ACEITE DA ENTREGA");
			return "TkcsapcdController?cmd=consultarTermoAceiteEntrega";//Pagina de Retorno (pagina consulta)
	}

}

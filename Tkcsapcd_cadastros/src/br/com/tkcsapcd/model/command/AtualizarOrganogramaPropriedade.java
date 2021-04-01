/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.OrganogramaPropriedade;
import br.com.tkcsapcd.model.dao.InterfaceOrganogramaPropriedadeDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarOrganogramaPropriedade implements InterfaceCommand {

	private InterfaceOrganogramaPropriedadeDAO organogramaPropriedadeDAO;
	public AtualizarOrganogramaPropriedade(InterfaceOrganogramaPropriedadeDAO organogramaPropriedadeDAO) {
		super();
		this.organogramaPropriedadeDAO = organogramaPropriedadeDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request		
					OrganogramaPropriedade organogramaPropriedade  = new OrganogramaPropriedade();
					
					organogramaPropriedade.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					organogramaPropriedade.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
					
					String data_1 = request.getParameter("data"); 
					Date data =  new SimpleDateFormat("yyyy-MM-dd").parse(data_1);
					organogramaPropriedade.setData(data);
					
					organogramaPropriedade.setComentario(request.getParameter("comentario"));
					organogramaPropriedade.setMySavedModel(request.getParameter("mySavedModel"));
					organogramaPropriedade.setDescricao(request.getParameter("descricao"));
		
		if(ValidationHelper.validar(organogramaPropriedade)){			
			organogramaPropriedadeDAO.atualizar(organogramaPropriedade);
			request.setAttribute("mensagem", "Organograma Propriedade: ("+organogramaPropriedade.getCodigoprojeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - Organograma Propriedade");
			return "TkcsapcdController?cmd=consultarOrganogramaPropriedade";//Pagina de Retorno (pagina consulta)
	}

}

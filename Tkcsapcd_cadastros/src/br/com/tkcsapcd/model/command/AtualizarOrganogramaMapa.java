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

import br.com.tkcsapcd.model.bean.OrganogramaMapa;
import br.com.tkcsapcd.model.dao.InterfaceOrganogramaMapaDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarOrganogramaMapa implements InterfaceCommand {

	private InterfaceOrganogramaMapaDAO organogramaMapaDAO;
	public AtualizarOrganogramaMapa(InterfaceOrganogramaMapaDAO organogramaMapaDAO) {
		super();
		this.organogramaMapaDAO = organogramaMapaDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request		
					OrganogramaMapa organogramaMapa  = new OrganogramaMapa();
					
					organogramaMapa.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					organogramaMapa.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
					
					String data_1 = request.getParameter("data"); 
					Date data =  new SimpleDateFormat("yyyy-MM-dd").parse(data_1);
					organogramaMapa.setData(data);
					
					organogramaMapa.setComentario(request.getParameter("comentario"));
					organogramaMapa.setMySavedModel(request.getParameter("mySavedModel"));
					organogramaMapa.setDescricao(request.getParameter("descricao"));
		
		if(ValidationHelper.validar(organogramaMapa)){			
			organogramaMapaDAO.atualizar(organogramaMapa);
			request.setAttribute("mensagem", "Organograma Mapa: ("+organogramaMapa.getCodigoprojeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - Organograma Mapa");
			return "TkcsapcdController?cmd=consultarOrganogramaMapa";//Pagina de Retorno (pagina consulta)
	}

}

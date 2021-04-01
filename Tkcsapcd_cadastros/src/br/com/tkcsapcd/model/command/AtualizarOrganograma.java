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

import br.com.tkcsapcd.model.bean.Organograma;
import br.com.tkcsapcd.model.dao.InterfaceOrganogramaDAO;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarOrganograma implements InterfaceCommand {

	private InterfaceOrganogramaDAO organogramaDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	public AtualizarOrganograma(InterfaceOrganogramaDAO organogramaDAO, InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.organogramaDAO = organogramaDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request		
					Organograma organograma  = new Organograma();
					
					organograma.setCodigo(Long.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					
					String data_1 = request.getParameter("data"); 
					Date data =  new SimpleDateFormat("yyyy-MM-dd").parse(data_1);
					organograma.setData(data);
					
					organograma.setComentario(request.getParameter("comentario"));
					organograma.setMySavedModel(request.getParameter("mySavedModel"));
					organograma.setDescricao(request.getParameter("descricao"));
					
					Integer projetoinicio = Integer.valueOf(request.getParameter("projetoinicio"));										
					organograma.setProjetoinicio(projetoInicioDAO.getProjetoInicio(projetoinicio));
		
		if(ValidationHelper.validar(organograma)){			
			organogramaDAO.atualizar(organograma);
			request.setAttribute("mensagem", "Organograma: ("+organograma.getProjetoinicio().getProjeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - Organograma");
			return "TkcsapcdController?cmd=consultarOrganograma";//Pagina de Retorno (pagina consulta)
	}

}

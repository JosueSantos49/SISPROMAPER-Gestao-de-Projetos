/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.DiagramaGantt;
import br.com.tkcsapcd.model.dao.InterfaceDiagramaGanttDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarDiagramaGantt implements InterfaceCommand {

	private InterfaceDiagramaGanttDAO diagramaGanttDAO;
	public AtualizarDiagramaGantt(InterfaceDiagramaGanttDAO diagramaGanttDAO) {
		super();
		this.diagramaGanttDAO = diagramaGanttDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request										
					
					DiagramaGantt diagramaGantt = new DiagramaGantt();
					
					diagramaGantt.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação					
					diagramaGantt.setTa(request.getParameter("ta"));
		
		if(ValidationHelper.validar(diagramaGantt)){			
			diagramaGanttDAO.atualizar(diagramaGantt);
			request.setAttribute("mensagem", "Diagrama Gantt: ("+diagramaGantt.getCodigo()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - Diagrama Gantt");
			return "TkcsapcdController?cmd=consultarDiagramaGantt";//Pagina de Retorno (pagina consulta)
	}

}

/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.Requerimento;
import br.com.tkcsapcd.model.dao.InterfaceRequerimentoDAO;

public class AtualizarRequerimento implements InterfaceCommand {

	private InterfaceRequerimentoDAO requerimentoDAO;
	
	public AtualizarRequerimento(InterfaceRequerimentoDAO requerimentoDAO) {
		super();
		this.requerimentoDAO = requerimentoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			Requerimento requerimento = new Requerimento();
			
			requerimento.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
			requerimento.setNome(request.getParameter("nome"));
			requerimento.setDescricao(request.getParameter("descricao"));
			requerimento.setResumo(request.getParameter("resumo"));
			requerimento.setRqfuncional(request.getParameter("rqfuncional"));
			requerimento.setRqtecnologico(request.getParameter("rqtecnologico"));
			requerimento.setRqstatus(request.getParameter("rqstatus"));
			requerimento.setConcordo(request.getParameter("concordo"));//Implementado dia 28/05/2014
			
			requerimentoDAO.atualizar(requerimento);			
			request.setAttribute("mensagem", "Requerimento: ("+requerimento.getNome()+") atualizado com sucesso!");
			
			} catch (SQLException e) {
				
				request.setAttribute("mensagem", "Problema com a atualização: "+e.getMessage());
				e.printStackTrace();
				
			}catch (NumberFormatException e) {
				request.setAttribute("mensagem", "Valor inválido: "+e.getMessage());			
			}	
			request.setAttribute("titulo", "Atualização - Requerimento");
			return "TkcsapcdController?cmd=consultarRequerimento";//Pagina de Retorno (pagina consulta funcionario)

	}

}

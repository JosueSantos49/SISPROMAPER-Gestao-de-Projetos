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
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastraRequerimento implements InterfaceCommand {

	private InterfaceRequerimentoDAO requerimentoDAO;
	
	public CadastraRequerimento(InterfaceRequerimentoDAO requerimentoDAO) {
		super();
		this.requerimentoDAO = requerimentoDAO;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {
		Requerimento requerimento = new Requerimento();
		
		requerimento.setNome(request.getParameter("nome"));
		requerimento.setDescricao(request.getParameter("descricao"));
		requerimento.setResumo(request.getParameter("resumo"));
		requerimento.setRqfuncional(request.getParameter("rqfuncional"));
		requerimento.setRqtecnologico(request.getParameter("rqtecnologico"));
		requerimento.setRqstatus(request.getParameter("rqstatus"));
		requerimento.setConcordo(request.getParameter("concordo"));//Implementado dia 28/05/2014
		
		if(ValidationHelper.validar(requerimentoDAO)){
			requerimentoDAO.salvar(requerimento);
			request.setAttribute("mensagem", "Requerimento: ("+requerimento.getNome()+") cadastrado com sucesso!");
		}
		else{
			throw new Exception("Valor inválido");
		}
		} catch (SQLException e) {
			
			request.setAttribute("mensagem", "Problema com a gravação: "+e.getMessage());
			e.printStackTrace();
			
		}catch (NumberFormatException e) {
			
			request.setAttribute("mensagem", "Valor inválido: "+e.getMessage());
			e.printStackTrace();
		}
		request.setAttribute("titulo", "Cadastro - Requerimento");		
		return "TkcsapcdController?cmd=editarRequerimento";//Devolver para o editar
	}

}

/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceRfpProjetoDAO;

public class ExcluirRfpProjeto implements InterfaceCommand {
	
	private InterfaceRfpProjetoDAO rfpProjetoDAO;
	public ExcluirRfpProjeto(InterfaceRfpProjetoDAO rfpProjetoDAO) {
		super();
		this.rfpProjetoDAO = rfpProjetoDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response) throws Exception{
		try {
				rfpProjetoDAO.excluir(Integer.valueOf(request.getParameter("codigo")));
				request.setAttribute("mensagem", "RFP Projeto excluído com sucesso!");
				
			} catch (NumberFormatException e) {
				
				request.setAttribute("mensagem", "Código inválido: "+request.getParameter("codigo"));
				e.printStackTrace();
				
			}catch (SQLException e) {//Atenção por padão todas os Editar esta como SQLException, mas nesta linha da erro sempre!!!
				
				request.setAttribute("mensagem", "Problemas com a base de dados!");
				e.printStackTrace();
			}
				request.setAttribute("titulo","Consulta - RFP Projeto");
				return "TkcsapcdController?cmd=consultarRfpProjeto";
				//Cadastre esse comando no helper!
	}

}

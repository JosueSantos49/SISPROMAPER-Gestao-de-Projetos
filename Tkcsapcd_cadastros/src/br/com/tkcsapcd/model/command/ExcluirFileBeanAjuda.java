/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceFileBeanAjudaDAO;

public class ExcluirFileBeanAjuda implements InterfaceCommand {
	
	private InterfaceFileBeanAjudaDAO fileBeanAjudaDAO;
	public ExcluirFileBeanAjuda(InterfaceFileBeanAjudaDAO fileBeanAjudaDAO) {
		super();
		this.fileBeanAjudaDAO = fileBeanAjudaDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)throws Exception{
		// 
		try {
			
			fileBeanAjudaDAO.excluir(Integer.valueOf(request.getParameter("codigo")));
			request.setAttribute("mensagem", "File Ajuda excluido com sucesso!");
			
		} catch (NumberFormatException e) {
			
			request.setAttribute("mensagem", "Código inválido"+request.getParameter("codigo"));
			e.printStackTrace();
			
		}catch(SQLException e){
			
			request.setAttribute("mensagem", "Problemas com a base de dados!");
			e.printStackTrace();
			
		}
			request.setAttribute("titulo","Consulta - File Ajuda");
			return "TkcsapcdController?cmd=consultarFilebeanAjuda";
			//Cadastre esse comando no helper!		
	}

}

/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceAtributoAtividadeDAO;

public class ExcluirAtributoAtividade implements InterfaceCommand {
	
	private InterfaceAtributoAtividadeDAO atributoAtividadeDAO;
	public ExcluirAtributoAtividade(InterfaceAtributoAtividadeDAO atributoAtividadeDAO) {
		super();
		this.atributoAtividadeDAO = atributoAtividadeDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// 
		try {
			
			atributoAtividadeDAO.excluir(Integer.valueOf(request.getParameter("codigo")));
			//request.setAttribute("mensagem", "Cliente excluido com sucesso!");
			
		} catch (NumberFormatException e) {
			
			request.setAttribute("mensagem", "Código inválido"+request.getParameter("codigo"));
			e.printStackTrace();
			
		}catch(SQLException e){
			
			request.setAttribute("mensagem", "Problemas com a base de dados!");
			e.printStackTrace();
			
		}
			request.setAttribute("titulo","Consulta - ATRIBUTOS DAS ATIVIDADES");
			return "TkcsapcdController?cmd=consultarAtributoAtividade";
			//Cadastre esse comando no helper!		
	}

}

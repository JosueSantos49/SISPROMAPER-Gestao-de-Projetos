/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceDeclaracaoEscopoDAO;

public class ExcluirDeclaracaoEscopo implements InterfaceCommand {
	
	private InterfaceDeclaracaoEscopoDAO declaracaoEscopoDAO;	
	public ExcluirDeclaracaoEscopo(InterfaceDeclaracaoEscopoDAO declaracaoEscopoDAO) {
		super();
		this.declaracaoEscopoDAO = declaracaoEscopoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)throws Exception{
		// 
		try {
			
			declaracaoEscopoDAO.excluir(Integer.valueOf(request.getParameter("codigo")));
			//request.setAttribute("mensagem", "Cliente excluido com sucesso!");
			
		} catch (NumberFormatException e) {
			
			request.setAttribute("mensagem", "Código inválido"+request.getParameter("codigo"));
			e.printStackTrace();
			
		}catch(SQLException e){
			
			request.setAttribute("mensagem", "Problemas com a base de dados!");
			e.printStackTrace();
			
		}
			request.setAttribute("titulo","Consulta - Declaração do Escopo");
			return "TkcsapcdController?cmd=consultarDeclaracaoescopo";
			//Cadastre esse comando no helper!		
	}

}

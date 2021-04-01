/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceDicionarioEAPDAO;

public class ExcluirDicionarioEAP implements InterfaceCommand {
	
	private InterfaceDicionarioEAPDAO dicionarioEAPDAO;
	public ExcluirDicionarioEAP(InterfaceDicionarioEAPDAO dicionarioEAPDAO) {
		super();
		this.dicionarioEAPDAO = dicionarioEAPDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)throws Exception{
		// 
		try {
			
			dicionarioEAPDAO.excluir(Integer.valueOf(request.getParameter("codigo")));
			//request.setAttribute("mensagem", "Cliente excluido com sucesso!");
			
		} catch (NumberFormatException e) {
			
			request.setAttribute("mensagem", "Código inválido"+request.getParameter("codigo"));
			e.printStackTrace();
			
		}catch(SQLException e){
			
			request.setAttribute("mensagem", "Problemas com a base de dados!");
			e.printStackTrace();
			
		}
			request.setAttribute("titulo","Consulta - DICIONÁRIO DA EAP");
			return "TkcsapcdController?cmd=consultarDicionarioEAP";
			//Cadastre esse comando no helper!		
	}

}

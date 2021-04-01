/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceRfqDAO;

public class ExcluirRfq implements InterfaceCommand {
	
	private InterfaceRfqDAO rfqDAO;
	public ExcluirRfq(InterfaceRfqDAO rfqDAO) {
		super();
		this.rfqDAO = rfqDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)throws Exception{
		// 
		try {
			
			rfqDAO.excluir(Integer.valueOf(request.getParameter("codigo")));
			request.setAttribute("mensagem", "Excluido com sucesso!");
			
		} catch (NumberFormatException e) {
			
			request.setAttribute("mensagem", "C�digo inv�lido"+request.getParameter("codigo"));
			e.printStackTrace();
			
		}catch(SQLException e){
			
			request.setAttribute("mensagem", "Problemas com a base de dados!");
			e.printStackTrace();
			
		}
			request.setAttribute("titulo","Consulta - Pedido de Cota��o");
			return "TkcsapcdController?cmd=consultarRfq";
			//Cadastre esse comando no helper!		
	}

}

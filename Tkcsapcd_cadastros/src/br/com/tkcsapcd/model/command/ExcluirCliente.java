/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceClienteDAO;

public class ExcluirCliente implements InterfaceCommand {

	private InterfaceClienteDAO clienteDAO;	
	public ExcluirCliente(InterfaceClienteDAO clienteDAO) {
		super();
		this.clienteDAO = clienteDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// C�digo de processamento
		try {
			
			clienteDAO.excluir(Integer.valueOf(request.getParameter("codigo")));
			request.setAttribute("mensagem", "Cliente exclu�do.");
			
		} catch (NumberFormatException e) {
			
			request.setAttribute("mensagem", "C�digo inv�lido: "+request.getParameter("codigo"));
			e.printStackTrace();
			
		} catch (SQLException e) {
			
			request.setAttribute("mensagem", "Problemas com a base de dados!");
			e.printStackTrace();
		}
			request.setAttribute("titulo","Consulta - Cliente");
			return "TkcsapcdController?cmd=consultarCliente";
			//Cadastre esse comando no helper!
	}

}

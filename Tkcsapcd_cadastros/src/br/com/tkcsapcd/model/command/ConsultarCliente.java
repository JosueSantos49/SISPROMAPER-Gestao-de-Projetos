/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceClienteDAO;

//Método registrado na InterfaceCommand
public class ConsultarCliente implements InterfaceCommand {

	private InterfaceClienteDAO clienteDao;//atributo, que sera setado no cronstrutor da classe
	public ConsultarCliente(InterfaceClienteDAO clienteDao) {
		super();
		this.clienteDao = clienteDao;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)throws SQLException	{
		
			request.setAttribute("titulo", "Consultar - Cliente");//Processamento que será executado pelo comando	

		try {
			//clientes sendo resgatado do for consultaCliente
			request.setAttribute("clientes", clienteDao.getClientes());
			
		} catch (Exception e) 
		{			
			request.setAttribute("mensagem", "Problema com acesso a base de dados!");//Caso aja problema, será executado MSN informando!
			e.printStackTrace();
		}
		//se não ouver erro, retorne a pagina 
		return "consulta_cliente.jsp";
	}
	//Deve cadastrar o comando no TkcsapcdHelper!!!!!
}

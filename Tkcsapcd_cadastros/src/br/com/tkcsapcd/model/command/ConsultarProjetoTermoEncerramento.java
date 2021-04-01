/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceProjetoTermoEncerramentoDAO;

//Método registrado na InterfaceCommand
public class ConsultarProjetoTermoEncerramento implements InterfaceCommand {
	
	private InterfaceProjetoTermoEncerramentoDAO projetoTermoEncerramentoDAO;//atributo, que sera setado no cronstrutor da classe		
	public ConsultarProjetoTermoEncerramento(InterfaceProjetoTermoEncerramentoDAO projetoTermoEncerramentoDAO) {
		super();
		this.projetoTermoEncerramentoDAO = projetoTermoEncerramentoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)throws SQLException {	
		
			request.setAttribute("titulo", "Consultar - Termo de Encerramento do Projeto");//Processamento que será executado pelo comando

		try {
			request.setAttribute("projetoTermoEncerramentos", projetoTermoEncerramentoDAO.getProjetoTermoEncerramentos());//atributo recuperado no consulta_projeto.jsp
		} catch (Exception e) 
		{			
			request.setAttribute("mensagem", "Problema com acesso a base de dados!");//Caso aja problema, será executado MSN informando!
			e.printStackTrace();
		}			 
			return "consulta_projetoTermoEncerramento.jsp";//se não ouver erro, retorne a pagina.
	}
	//Deve cadastrar o comando no TkcsapcdHelper!!!!!
}

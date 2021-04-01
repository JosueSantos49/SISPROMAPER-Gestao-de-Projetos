/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceMatrizResponsabilidadeDAO;

//Método registrado na InterfaceCommand
public class ConsultarMatrizResponsabilidade implements InterfaceCommand {
	
	private InterfaceMatrizResponsabilidadeDAO matrizResponsabilidadeDAO;//atributo, que sera setado no cronstrutor da classe		
	public ConsultarMatrizResponsabilidade(InterfaceMatrizResponsabilidadeDAO matrizResponsabilidadeDAO) {
		super();
		this.matrizResponsabilidadeDAO = matrizResponsabilidadeDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)throws SQLException {	
		
			request.setAttribute("titulo", "Consultar - Matriz de Responsabilidade RACI");//Processamento que será executado pelo comando

		try {
			request.setAttribute("matrizResponsabilidades", matrizResponsabilidadeDAO.getMatrizResponsabilidades());//atributo recuperado no consulta_projeto.jsp
		} catch (Exception e) 
		{			
			request.setAttribute("mensagem", "Problema com acesso a base de dados!");//Caso aja problema, será executado MSN informando!
			e.printStackTrace();
		}			 
			return "consulta_matriz_responsabilidade.jsp";//se não ouver erro, retorne a pagina.
	}
	//Deve cadastrar o comando no TkcsapcdHelper!!!!!
}

/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceListaOcorrenciaDAO;

//Método registrado na InterfaceCommand
public class ConsultarListaOcorrencia implements InterfaceCommand {
	
	private InterfaceListaOcorrenciaDAO listaOcorrenciaDAO;		
	public ConsultarListaOcorrencia(InterfaceListaOcorrenciaDAO listaOcorrenciaDAO) {
		super();
		this.listaOcorrenciaDAO = listaOcorrenciaDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)throws SQLException {	
		
			request.setAttribute("titulo", "Consultar - Lista Ocorrencia");//Processamento que será executado pelo comando

		try {
			request.setAttribute("listaOcorrencias", listaOcorrenciaDAO.getListaOcorrencias());//atributo recuperado no consulta_projeto.jsp
		} catch (Exception e) 
		{			
			request.setAttribute("mensagem", "Problema com acesso a base de dados!");//Caso aja problema, será executado MSN informando!
			e.printStackTrace();
		}			 
			return "consulta_lista_ocorrencia.jsp";//se não ouver erro, retorne a pagina.
	}
	//Deve cadastrar o comando no TkcsapcdHelper!!!!!
}

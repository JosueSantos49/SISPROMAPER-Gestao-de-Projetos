/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Invoca todos os metodos,que serão executados
public interface InterfaceCommand {
	/*
	 * Apenas 1 metodo, que executa. Recebendo 2 parametros.
	 */
	public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, Exception;

}

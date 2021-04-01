/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.CalendarioEvento;

public interface InterfaceCalendarioEventoDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException, Exception ;
	public abstract void atualizar(CalendarioEvento calendarioEvento) throws SQLException, NamingException, Exception ;
	public abstract void salvar(CalendarioEvento calendarioEvento) throws SQLException, NamingException, Exception ;
	public abstract CalendarioEvento getCalendarioEvento (Integer codigo) throws SQLException, NamingException, Exception ;
	public abstract List<CalendarioEvento> getCalendarioEventos() throws SQLException, NamingException, Exception;

	//List<ProjetoInicio> getPProjetoInicios() throws SQLException, NamingException, Exception;
	
}

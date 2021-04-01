/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.RecursosHumanos;

public interface InterfaceRecursosHumanosDAO {
	
	public abstract void excluir(Integer codigo) throws SQLException, NamingException, Exception;
	public abstract void atualizar(RecursosHumanos recursosHumanos) throws SQLException, NamingException , Exception;
	public abstract void salvar(RecursosHumanos recursosHumanos) throws SQLException, NamingException, Exception ;
	public abstract RecursosHumanos getRecursosHumanos(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<RecursosHumanos> getRecursosHumanoss() throws SQLException, NamingException , Exception;
}

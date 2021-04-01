/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.Statuss;

public interface InterfaceStatussDAO {
	
	public abstract void excluir(Integer codigo) throws SQLException, NamingException, Exception;
	public abstract void atualizar(Statuss statuss) throws SQLException, NamingException, Exception;
	public abstract void salvar(Statuss statuss) throws SQLException, NamingException, Exception;
	public abstract Statuss getStatuss(Integer codigo) throws SQLException, NamingException, Exception;
	public abstract List<Statuss> getStatusss() throws SQLException, NamingException, Exception;
}

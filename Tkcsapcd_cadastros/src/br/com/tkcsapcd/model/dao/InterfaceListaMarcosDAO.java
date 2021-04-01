/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.ListaMarcos;

public interface InterfaceListaMarcosDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(ListaMarcos listaMarcos) throws SQLException, NamingException , Exception;
	public abstract void salvar(ListaMarcos listaMarcos) throws SQLException, NamingException , Exception;
	public abstract ListaMarcos getListaMarcos(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<ListaMarcos> getListaMarcoss() throws SQLException, NamingException, Exception;
		
}

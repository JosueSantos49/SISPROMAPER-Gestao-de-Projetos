/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.ListaQualidade;

public interface InterfaceListaQualidadeDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(ListaQualidade listaQualidade) throws SQLException, NamingException , Exception;
	public abstract void salvar(ListaQualidade listaQualidade) throws SQLException, NamingException , Exception;
	public abstract ListaQualidade getListaQualidade(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<ListaQualidade> getListaQualidades() throws SQLException, NamingException, Exception;
		
}

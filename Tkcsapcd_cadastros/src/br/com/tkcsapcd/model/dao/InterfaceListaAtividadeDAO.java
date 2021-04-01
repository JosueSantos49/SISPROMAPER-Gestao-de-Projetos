/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.ListaAtividade;

public interface InterfaceListaAtividadeDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException, Exception;
	public abstract void atualizar(ListaAtividade listaAtividade) throws SQLException, NamingException , Exception;
	public abstract void salvar(ListaAtividade listaAtividade) throws SQLException, NamingException, Exception ;
	public abstract ListaAtividade getListaAtividade(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<ListaAtividade> getListaAtividades() throws SQLException, NamingException, Exception;
		
}

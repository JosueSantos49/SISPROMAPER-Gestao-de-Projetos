/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.OrganogramaMapa;

public interface InterfaceOrganogramaMapaDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(OrganogramaMapa organogramaMapa) throws SQLException, NamingException , Exception;
	public abstract void salvar(OrganogramaMapa organogramaMapa) throws SQLException, NamingException , Exception;
	public abstract OrganogramaMapa getOrganogramaMapa(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<OrganogramaMapa> getOrganogramaMapas() throws SQLException, NamingException, Exception;
		
}

/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.OrganogramaPropriedade;

public interface InterfaceOrganogramaPropriedadeDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(OrganogramaPropriedade organogramaPropriedade) throws SQLException, NamingException , Exception;
	public abstract void salvar(OrganogramaPropriedade organogramaPropriedade) throws SQLException, NamingException , Exception;
	public abstract OrganogramaPropriedade getOrganogramaPropriedade(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<OrganogramaPropriedade> getOrganogramaPropriedades() throws SQLException, NamingException, Exception;
		
}

/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.BusinessCase;

public interface InterfaceBusinessCaseDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException, Exception;
	public abstract void atualizar(BusinessCase businessCase) throws SQLException, NamingException, Exception;
	public abstract void salvar(BusinessCase businessCase) throws SQLException, NamingException, Exception;
	public abstract BusinessCase getBusinessCase(Integer codigo) throws SQLException, NamingException, Exception;
	public abstract List<BusinessCase> getBusinessCases() throws SQLException, NamingException, Exception;
		
}

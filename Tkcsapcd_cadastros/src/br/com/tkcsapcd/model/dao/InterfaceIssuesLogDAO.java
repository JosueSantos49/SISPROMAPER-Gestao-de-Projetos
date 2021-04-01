/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.IssuesLog;

public interface InterfaceIssuesLogDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(IssuesLog issuesLog) throws SQLException, NamingException , Exception;
	public abstract void salvar(IssuesLog issuesLog) throws SQLException, NamingException , Exception;
	public abstract IssuesLog getIssuesLog(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<IssuesLog> getIssuesLogs() throws SQLException, NamingException, Exception;
		
}

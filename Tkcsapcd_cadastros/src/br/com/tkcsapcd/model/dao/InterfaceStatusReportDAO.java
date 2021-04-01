/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.StatusReport;

public interface InterfaceStatusReportDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException, Exception;
	public abstract void atualizar(StatusReport statusReport) throws SQLException, NamingException, Exception;
	public abstract void salvar(StatusReport statusReport) throws SQLException, NamingException, Exception;
	public abstract StatusReport getStatusReport(Integer codigo) throws SQLException, NamingException, Exception;
	public abstract List<StatusReport> getStatusReports() throws SQLException, NamingException, Exception;
		
}

/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.FileBean;

public interface InterfaceFileBeanDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract FileBean getFileBean(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<FileBean> getFileBeans() throws SQLException, NamingException, Exception;
		
}

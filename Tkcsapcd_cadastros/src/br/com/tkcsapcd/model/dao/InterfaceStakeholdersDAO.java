/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.Stakeholders;

public interface InterfaceStakeholdersDAO {

		public abstract void excluir(Integer codigo) throws SQLException, NamingException, Exception;
		public abstract void atualizar(Stakeholders stakeholders) throws SQLException, NamingException, Exception;
		public abstract void salvar(Stakeholders stakeholders) throws SQLException, NamingException, Exception;
		public abstract Stakeholders getStakeholders(Integer codigo) throws SQLException, NamingException, Exception;
		public abstract List<Stakeholders> getStakeholderss() throws SQLException, NamingException, Exception;
}

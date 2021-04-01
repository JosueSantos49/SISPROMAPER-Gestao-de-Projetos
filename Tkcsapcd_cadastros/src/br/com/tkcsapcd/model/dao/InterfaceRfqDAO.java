/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.Rfq;

public interface InterfaceRfqDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(Rfq rfq) throws SQLException, NamingException , Exception;
	public abstract void salvar(Rfq rfq) throws SQLException, NamingException , Exception;
	public abstract Rfq getRfq(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<Rfq> getRfqs() throws SQLException, NamingException, Exception;
		
}

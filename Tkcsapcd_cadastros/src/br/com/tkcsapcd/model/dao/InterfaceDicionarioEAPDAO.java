/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.DicionarioEAP;

public interface InterfaceDicionarioEAPDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(DicionarioEAP dicionarioEAP) throws SQLException, NamingException , Exception;
	public abstract void salvar(DicionarioEAP dicionarioEAP) throws SQLException, NamingException , Exception;
	public abstract DicionarioEAP getDicionarioEAP(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<DicionarioEAP> getDicionarioEAPs() throws SQLException, NamingException, Exception;
		
}

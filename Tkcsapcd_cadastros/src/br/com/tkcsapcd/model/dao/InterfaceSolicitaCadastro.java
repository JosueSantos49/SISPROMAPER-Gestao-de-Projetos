/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.SolicitacaoCadastro;

public interface InterfaceSolicitaCadastro {

	public abstract void salvar(SolicitacaoCadastro solicitacaoCadastro) throws SQLException, NamingException, Exception;
}

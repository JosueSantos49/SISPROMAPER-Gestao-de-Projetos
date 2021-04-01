/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.DeclaracaoEscopo;

public interface InterfaceDeclaracaoEscopoDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(DeclaracaoEscopo declaracaoEscopo) throws SQLException, NamingException , Exception;
	public abstract void salvar(DeclaracaoEscopo declaracaoEscopo) throws SQLException, NamingException , Exception;
	public abstract DeclaracaoEscopo getDeclaracaoEscopo(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<DeclaracaoEscopo> getDeclaracaoEscopos() throws SQLException, NamingException, Exception;
		
}

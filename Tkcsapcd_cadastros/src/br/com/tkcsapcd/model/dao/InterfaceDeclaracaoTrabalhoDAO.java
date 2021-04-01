/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.DeclaracaoTrabalho;

public interface InterfaceDeclaracaoTrabalhoDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(DeclaracaoTrabalho declaracaoTrabalho) throws SQLException, NamingException , Exception;
	public abstract void salvar(DeclaracaoTrabalho declaracaoTrabalho) throws SQLException, NamingException , Exception;
	public abstract DeclaracaoTrabalho getDeclaracaoTrabalho(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<DeclaracaoTrabalho> getDeclaracaoTrabalhos() throws SQLException, NamingException, Exception;
		
}

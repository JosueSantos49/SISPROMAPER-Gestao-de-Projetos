/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoPessoal;

public interface InterfacePlanoGerenciamentoPessoalDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(PlanoGerenciamentoPessoal planoGerenciamentoPessoal) throws SQLException, NamingException , Exception;
	public abstract void salvar(PlanoGerenciamentoPessoal planoGerenciamentoPessoal) throws SQLException, NamingException , Exception;
	public abstract PlanoGerenciamentoPessoal getPlanoGerenciamentoPessoal(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<PlanoGerenciamentoPessoal> getPlanoGerenciamentoPessoals() throws SQLException, NamingException, Exception;
		
}

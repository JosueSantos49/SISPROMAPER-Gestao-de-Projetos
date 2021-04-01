/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoCusto;

public interface InterfacePlanoGerenciamentoCustoDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(PlanoGerenciamentoCusto planoGerenciamentoCusto) throws SQLException, NamingException , Exception;
	public abstract void salvar(PlanoGerenciamentoCusto planoGerenciamentoCusto) throws SQLException, NamingException , Exception;
	public abstract PlanoGerenciamentoCusto getPlanoGerenciamentoCusto(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<PlanoGerenciamentoCusto> getPlanoGerenciamentoCustos() throws SQLException, NamingException, Exception;
		
}

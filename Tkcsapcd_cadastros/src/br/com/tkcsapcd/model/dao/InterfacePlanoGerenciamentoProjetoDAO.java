/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoProjeto;

public interface InterfacePlanoGerenciamentoProjetoDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(PlanoGerenciamentoProjeto planoGerenciamentoProjeto) throws SQLException, NamingException , Exception;
	public abstract void salvar(PlanoGerenciamentoProjeto planoGerenciamentoProjeto) throws SQLException, NamingException , Exception;
	public abstract PlanoGerenciamentoProjeto getPlanoGerenciamentoProjeto(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<PlanoGerenciamentoProjeto> getPlanoGerenciamentoProjetos() throws SQLException, NamingException, Exception;
		
}

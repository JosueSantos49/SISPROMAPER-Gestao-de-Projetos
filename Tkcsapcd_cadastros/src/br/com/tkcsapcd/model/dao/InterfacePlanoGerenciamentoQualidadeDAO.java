/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoQualidade;

public interface InterfacePlanoGerenciamentoQualidadeDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(PlanoGerenciamentoQualidade planoGerenciamentoQualidade) throws SQLException, NamingException , Exception;
	public abstract void salvar(PlanoGerenciamentoQualidade planoGerenciamentoQualidade) throws SQLException, NamingException , Exception;
	public abstract PlanoGerenciamentoQualidade getPlanoGerenciamentoQualidade(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<PlanoGerenciamentoQualidade> getPlanoGerenciamentoQualidades() throws SQLException, NamingException, Exception;
		
}

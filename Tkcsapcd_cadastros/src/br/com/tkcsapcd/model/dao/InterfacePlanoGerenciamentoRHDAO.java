/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoRH;

public interface InterfacePlanoGerenciamentoRHDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(PlanoGerenciamentoRH planoGerenciamentoRH) throws SQLException, NamingException , Exception;
	public abstract void salvar(PlanoGerenciamentoRH planoGerenciamentoRH) throws SQLException, NamingException , Exception;
	public abstract PlanoGerenciamentoRH getPlanoGerenciamentoRH(Integer codigo) throws SQLException, NamingException, Exception ;
	public abstract List<PlanoGerenciamentoRH> getPlanoGerenciamentoRHs() throws SQLException, NamingException, Exception;
		
}

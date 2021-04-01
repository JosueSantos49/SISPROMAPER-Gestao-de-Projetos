/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoRisco;

public interface InterfacePlanoGerenciamentoRiscoDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(PlanoGerenciamentoRisco planoGerenciamentoRisco) throws SQLException, NamingException , Exception;
	public abstract void salvar(PlanoGerenciamentoRisco planoGerenciamentoRisco) throws SQLException, NamingException , Exception;
	public abstract PlanoGerenciamentoRisco getPlanoGerenciamentoRisco(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<PlanoGerenciamentoRisco> getPlanoGerenciamentoRiscos() throws SQLException, NamingException, Exception;
		
}

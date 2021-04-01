/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoAquisicao;

public interface InterfacePlanoGerenciamentoAquisicaoDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(PlanoGerenciamentoAquisicao planoGerenciamentoAquisicao) throws SQLException, NamingException , Exception;
	public abstract void salvar(PlanoGerenciamentoAquisicao planoGerenciamentoAquisicao) throws SQLException, NamingException , Exception;
	public abstract PlanoGerenciamentoAquisicao getPlanoGerenciamentoAquisicao(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<PlanoGerenciamentoAquisicao> getPlanoGerenciamentoAquisicaos() throws SQLException, NamingException, Exception;
		
}

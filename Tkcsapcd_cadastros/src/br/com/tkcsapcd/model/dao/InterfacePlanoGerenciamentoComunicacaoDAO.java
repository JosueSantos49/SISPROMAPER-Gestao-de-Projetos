/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoComunicacao;

public interface InterfacePlanoGerenciamentoComunicacaoDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(PlanoGerenciamentoComunicacao planoGerenciamentoComunicacao) throws SQLException, NamingException , Exception;
	public abstract void salvar(PlanoGerenciamentoComunicacao planoGerenciamentoComunicacao) throws SQLException, NamingException , Exception;
	public abstract PlanoGerenciamentoComunicacao getPlanoGerenciamentoComunicacao(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<PlanoGerenciamentoComunicacao> getPlanoGerenciamentoComunicacaos() throws SQLException, NamingException, Exception;
		
}

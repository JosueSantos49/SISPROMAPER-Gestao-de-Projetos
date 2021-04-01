/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoParteInteressada;

public interface InterfacePlanoGerenciamentoParteInteressadaDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(PlanoGerenciamentoParteInteressada planoGerenciamentoParteInteressada) throws SQLException, NamingException , Exception;
	public abstract void salvar(PlanoGerenciamentoParteInteressada planoGerenciamentoParteInteressada) throws SQLException, NamingException , Exception;
	public abstract PlanoGerenciamentoParteInteressada getPlanoGerenciamentoParteInteressada(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<PlanoGerenciamentoParteInteressada> getPlanoGerenciamentoParteInteressadas() throws SQLException, NamingException, Exception;
		
}

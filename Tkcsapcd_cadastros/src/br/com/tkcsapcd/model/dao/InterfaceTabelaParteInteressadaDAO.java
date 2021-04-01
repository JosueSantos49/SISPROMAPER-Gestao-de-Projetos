/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.TabelaParteInteressada;

public interface InterfaceTabelaParteInteressadaDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(TabelaParteInteressada tabelaParteInteressada) throws SQLException, NamingException , Exception;
	public abstract void salvar(TabelaParteInteressada tabelaParteInteressada) throws SQLException, NamingException , Exception;
	public abstract TabelaParteInteressada getTabelaParteInteressada(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<TabelaParteInteressada> getTabelaParteInteressadas() throws SQLException, NamingException, Exception;
		
}

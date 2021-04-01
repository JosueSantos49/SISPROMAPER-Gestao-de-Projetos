/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.PortfolioProjeto;

public interface InterfacePortfolioProjetoDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(PortfolioProjeto portfolioProjeto) throws SQLException, NamingException , Exception;
	public abstract void salvar(PortfolioProjeto portfolioProjeto) throws SQLException, NamingException , Exception;
	public abstract PortfolioProjeto getPortfolioProjeto(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<PortfolioProjeto> getPortfolioProjetos() throws SQLException, NamingException, Exception;
		
}

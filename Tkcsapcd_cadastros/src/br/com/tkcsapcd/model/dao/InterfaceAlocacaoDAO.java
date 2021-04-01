/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.Alocacao;

public interface InterfaceAlocacaoDAO {

	public abstract void excluir(Integer codigo) throws SQLException, NamingException, Exception;
	public abstract void salvar(Alocacao alocacao) throws SQLException, NamingException, Exception;
	public abstract void atualizar(Alocacao alocacao) throws SQLException, NamingException, Exception;
	public abstract Alocacao getAlocacao(Integer codigo) throws SQLException, NamingException, Exception;
	public abstract List<Alocacao> getAlocacaos() throws SQLException, NamingException, Exception;
}

/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.AcompanhamentoProjeto;

public interface InterfaceAcompanhamentoProjetoDAO {

	public abstract void excluir(Integer codigo) throws SQLException, NamingException, Exception;
	public abstract void atualizar(AcompanhamentoProjeto acompanhamentoProjeto) throws SQLException, NamingException, Exception;
	public abstract void salvar(AcompanhamentoProjeto acompanhamentoProjeto) throws SQLException, NamingException, Exception;
	public abstract AcompanhamentoProjeto getAcompanhamentoProjeto(Integer codigo) throws SQLException, NamingException, Exception;
	public abstract AcompanhamentoProjeto getAcompanhamentoProjeto(String login);
	public abstract List<AcompanhamentoProjeto> getAcompanhamentoProjetos() throws SQLException, NamingException, Exception;
}

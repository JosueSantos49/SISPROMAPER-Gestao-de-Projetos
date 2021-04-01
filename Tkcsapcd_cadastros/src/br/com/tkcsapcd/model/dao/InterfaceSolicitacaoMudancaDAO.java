/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.SolicitacaoMudanca;

public interface InterfaceSolicitacaoMudancaDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException, Exception;
	public abstract void atualizar(SolicitacaoMudanca solicitacaoMudanca) throws SQLException, NamingException, Exception;
	public abstract void salvar(SolicitacaoMudanca solicitacaoMudanca) throws SQLException, NamingException, Exception;
	public abstract SolicitacaoMudanca getSolicitacaoMudanca(Integer codigo) throws SQLException, NamingException, Exception;
	public abstract List<SolicitacaoMudanca> getSolicitacaoMudancas() throws SQLException, NamingException, Exception;
		
}

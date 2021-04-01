/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.RegistroSolicitacaoMudanca;

public interface InterfaceRegistroSolicitacaoMudancaDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(RegistroSolicitacaoMudanca registroSolicitacaoMudanca) throws SQLException, NamingException , Exception;
	public abstract void salvar(RegistroSolicitacaoMudanca registroSolicitacaoMudanca) throws SQLException, NamingException , Exception;
	public abstract RegistroSolicitacaoMudanca getRegistroSolicitacaoMudanca(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<RegistroSolicitacaoMudanca> getRegistroSolicitacaoMudancas() throws SQLException, NamingException, Exception;
		
}

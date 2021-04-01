/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.GerenciamentoEscopo;

public interface InterfaceGerenciamentoEscopoDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException, Exception ;
	public abstract void atualizar(GerenciamentoEscopo gerenciamentoEscopo) throws SQLException, NamingException , Exception;
	public abstract void salvar(GerenciamentoEscopo gerenciamentoEscopo) throws SQLException, NamingException , Exception;
	public abstract GerenciamentoEscopo getGerenciamentoEscopo(Integer codigo) throws SQLException, NamingException, Exception ;
	public abstract List<GerenciamentoEscopo> getGerenciamentoEscopos() throws SQLException, NamingException, Exception;
		
}

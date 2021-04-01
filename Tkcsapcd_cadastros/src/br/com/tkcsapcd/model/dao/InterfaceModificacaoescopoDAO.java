/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.ModificacaoEscopo;

public interface InterfaceModificacaoescopoDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(ModificacaoEscopo modificacaoEscopo) throws SQLException, NamingException , Exception;
	public abstract void salvar(ModificacaoEscopo modificacaoEscopo) throws SQLException, NamingException , Exception;
	public abstract ModificacaoEscopo getModificacaoEscopo(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<ModificacaoEscopo> getModificacaoEscopos() throws SQLException, NamingException, Exception;
		
}

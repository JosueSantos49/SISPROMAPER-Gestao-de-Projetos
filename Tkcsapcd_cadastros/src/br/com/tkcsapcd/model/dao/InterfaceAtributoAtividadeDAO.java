/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.AtributoAtividade;

public interface InterfaceAtributoAtividadeDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException, Exception;
	public abstract void atualizar(AtributoAtividade atributoAtividade) throws SQLException, NamingException, Exception;
	public abstract void salvar(AtributoAtividade atributoAtividade) throws SQLException, NamingException, Exception;
	public abstract AtributoAtividade getAtributoAtividade(Integer codigo) throws SQLException, NamingException, Exception;
	public abstract List<AtributoAtividade> getAtributoAtividades() throws SQLException, NamingException, Exception;
		
}

/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.TermoAceiteEntrega;

public interface InterfaceTermoAceiteEntregaDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException, Exception;
	public abstract void atualizar(TermoAceiteEntrega termoAceiteEntrega) throws SQLException, NamingException, Exception;
	public abstract void salvar(TermoAceiteEntrega termoAceiteEntrega) throws SQLException, NamingException, Exception;
	public abstract TermoAceiteEntrega getTermoAceiteEntrega(Integer codigo) throws SQLException, NamingException, Exception;
	public abstract List<TermoAceiteEntrega> getTermoAceiteEntregas() throws SQLException, NamingException, Exception;
		
}

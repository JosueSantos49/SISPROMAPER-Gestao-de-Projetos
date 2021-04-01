/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.RegistroRisco;

public interface InterfaceRegistroRiscoDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(RegistroRisco registroRisco) throws SQLException, NamingException , Exception;
	public abstract void salvar(RegistroRisco registroRisco) throws SQLException, NamingException , Exception;
	public abstract RegistroRisco getRegistroRisco(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<RegistroRisco> getRegistroRiscos() throws SQLException, NamingException, Exception;
		
}

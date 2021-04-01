/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.RegistroRiscoAcoes;

public interface InterfaceRegistroRiscoAcoesDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(RegistroRiscoAcoes registroRiscoAcoes) throws SQLException, NamingException , Exception;
	public abstract void salvar(RegistroRiscoAcoes registroRiscoAcoes) throws SQLException, NamingException , Exception;
	public abstract RegistroRiscoAcoes getRegistroRiscoAcoes(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<RegistroRiscoAcoes> getRegistroRiscoAcoess() throws SQLException, NamingException, Exception;
		
}

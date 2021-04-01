/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.Riscos;

public interface InterfaceRiscosDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(Riscos riscos) throws SQLException, NamingException , Exception;
	public abstract void salvar(Riscos riscos) throws SQLException, NamingException , Exception;
	public abstract Riscos getRiscos(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<Riscos> getRiscoss() throws SQLException, NamingException, Exception;
		
}

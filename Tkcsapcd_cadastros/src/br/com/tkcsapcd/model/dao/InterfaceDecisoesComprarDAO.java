/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.DecisoesComprar;

public interface InterfaceDecisoesComprarDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(DecisoesComprar decisoesComprar) throws SQLException, NamingException , Exception;
	public abstract void salvar(DecisoesComprar decisoesComprar) throws SQLException, NamingException, Exception ;
	public abstract DecisoesComprar getDecisoesComprar(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<DecisoesComprar> getDecisoesComprars() throws SQLException, NamingException, Exception;
		
}

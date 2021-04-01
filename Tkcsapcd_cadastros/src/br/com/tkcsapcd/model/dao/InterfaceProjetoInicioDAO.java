/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.ProjetoInicio;;

public interface InterfaceProjetoInicioDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException, Exception ;
	public abstract void atualizar(ProjetoInicio projetoInicio) throws SQLException, NamingException, Exception ;
	public abstract void salvar(ProjetoInicio projetoInicio) throws SQLException, NamingException, Exception ;
	public abstract ProjetoInicio getProjetoInicio (Integer codigo) throws SQLException, NamingException, Exception ;
	public abstract List<ProjetoInicio> getProjetoInicios() throws SQLException, NamingException, Exception;

	List<ProjetoInicio> getPProjetoInicios() throws SQLException, NamingException, Exception;
	
}

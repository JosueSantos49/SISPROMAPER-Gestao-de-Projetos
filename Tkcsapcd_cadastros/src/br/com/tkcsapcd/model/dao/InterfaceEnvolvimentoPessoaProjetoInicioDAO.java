/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.EnvolvimentoPessoaProjetoInicio;

public interface InterfaceEnvolvimentoPessoaProjetoInicioDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException, Exception ;
	public abstract void atualizar(EnvolvimentoPessoaProjetoInicio envolvimentoPessoaProjetoInicio) throws SQLException, NamingException, Exception ;
	public abstract void salvar(EnvolvimentoPessoaProjetoInicio envolvimentoPessoaProjetoInicio) throws SQLException, NamingException, Exception ;
	public abstract EnvolvimentoPessoaProjetoInicio getEnvolvimentoPessoaProjetoInicio (Integer codigo) throws SQLException, NamingException, Exception ;
	public abstract List<EnvolvimentoPessoaProjetoInicio> getEnvolvimentoPessoaProjetoInicios() throws SQLException, NamingException, Exception;

	List<EnvolvimentoPessoaProjetoInicio> getEEnvolvimentoPessoaProjetoInicios() throws SQLException, NamingException, Exception;
	
}

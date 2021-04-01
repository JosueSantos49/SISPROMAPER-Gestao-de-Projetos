/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.Usuario;

public interface InterfaceUsuarioDAO {
		
	public abstract void excluir(Integer log_codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(Usuario usuario) throws SQLException, NamingException , Exception;
	public abstract void salvar(Usuario usuario) throws SQLException, NamingException , Exception;
	public abstract Usuario getUsuario(Integer log_codigo) throws SQLException, NamingException , Exception;
	public abstract List<Usuario> getUsuarios() throws SQLException, NamingException, Exception;
		
}

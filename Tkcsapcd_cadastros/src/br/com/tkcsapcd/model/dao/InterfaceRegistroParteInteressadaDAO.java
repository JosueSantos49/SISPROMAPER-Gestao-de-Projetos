/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.RegistroParteInteressada;

public interface InterfaceRegistroParteInteressadaDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(RegistroParteInteressada registroParteInteressada) throws SQLException, NamingException , Exception;
	public abstract void salvar(RegistroParteInteressada registroParteInteressada) throws SQLException, NamingException , Exception;
	public abstract RegistroParteInteressada getRegistroParteInteressada(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<RegistroParteInteressada> getRegistroParteInteressadas() throws SQLException, NamingException, Exception;
	
		
}

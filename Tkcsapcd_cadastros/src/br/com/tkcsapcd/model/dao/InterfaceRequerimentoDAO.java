/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.Requerimento;

public interface InterfaceRequerimentoDAO {
	
	Requerimento getRequerimento(Integer codigo) throws SQLException, NamingException , Exception;
	Requerimento getRequerimento(String login);
	void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	void atualizar(Requerimento requerimento) throws SQLException, NamingException , Exception;
	void salvar(Requerimento requerimento) throws SQLException, NamingException , Exception;
	List<Requerimento> getRequerimentos() throws SQLException, NamingException, Exception;
}

/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.Selecionestatuss;

public interface InterfaceSelecioneStatussDAO {
	void excluir(Integer codigo);
	void salvar(Selecionestatuss selecionestatuss);
	void atualizar(Selecionestatuss selecionestatuss);
	List<Selecionestatuss> getSelecioneStatusss() throws SQLException, NamingException, Exception;
}

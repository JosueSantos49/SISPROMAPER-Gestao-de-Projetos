/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.FileBeanProjeto;

public interface InterfaceFileBeanProjetoDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(FileBeanProjeto fileBeanProjeto) throws SQLException, NamingException, Exception;
	public abstract FileBeanProjeto getFileBeanProjeto(Integer id) throws SQLException, NamingException , Exception;
	public abstract List<FileBeanProjeto> getFileBeanProjetos() throws SQLException, NamingException, Exception;
		
}

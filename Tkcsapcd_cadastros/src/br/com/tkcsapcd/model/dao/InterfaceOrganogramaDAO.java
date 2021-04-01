/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.Organograma;

public interface InterfaceOrganogramaDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(Organograma organograma) throws SQLException, NamingException , Exception;
	public abstract void salvar(Organograma organograma) throws SQLException, NamingException , Exception;
	public abstract Organograma getOrganograma(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<Organograma> getOrganogramas() throws SQLException, NamingException, Exception;
		
}

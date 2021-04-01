/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoCronograma;

public interface InterfacePlanoGerenciamentoCronogramaDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(PlanoGerenciamentoCronograma planoGerenciamentoCronograma) throws SQLException, NamingException , Exception;
	public abstract void salvar(PlanoGerenciamentoCronograma planoGerenciamentoCronograma) throws SQLException, NamingException , Exception;
	public abstract PlanoGerenciamentoCronograma getPlanoGerenciamentoCronograma(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<PlanoGerenciamentoCronograma> getPlanoGerenciamentoCronogramas() throws SQLException, NamingException, Exception;
		
}

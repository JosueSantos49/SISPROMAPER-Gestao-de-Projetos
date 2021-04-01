/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.TermoAberturaProjeto;

public interface InterfaceTermoAberturaProjetoDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException, Exception ;
	public abstract void atualizar(TermoAberturaProjeto termoAberturaProjeto) throws SQLException, NamingException, Exception ;
	public abstract void salvar(TermoAberturaProjeto TermoAberturaProjeto) throws SQLException, NamingException, Exception ;
	public abstract TermoAberturaProjeto getTermoAberturaProjeto (Integer codigo) throws SQLException, NamingException, Exception ;
	public abstract List<TermoAberturaProjeto> getTermoAberturaProjetos() throws SQLException, NamingException, Exception;

	List<TermoAberturaProjeto> getTermoAberturaPProjetos() throws SQLException, NamingException, Exception;
	
	public void relatorio() throws Exception;
	
}

/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.ProjetoTermoEncerramento;

public interface InterfaceProjetoTermoEncerramentoDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(ProjetoTermoEncerramento projetoTermoEncerramento) throws SQLException, NamingException , Exception;
	public abstract void salvar(ProjetoTermoEncerramento projetoTermoEncerramento) throws SQLException, NamingException , Exception;
	public abstract ProjetoTermoEncerramento getProjetoTermoEncerramento (Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<ProjetoTermoEncerramento> getProjetoTermoEncerramentos() throws SQLException, NamingException, Exception;
	//List<ProjetoTermoEncerramento> getPProjetoTermoEncerramentos() throws SQLException;
	
}

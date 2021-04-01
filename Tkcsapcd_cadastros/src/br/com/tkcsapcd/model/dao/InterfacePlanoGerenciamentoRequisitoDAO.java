/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoRequisito;
import br.com.tkcsapcd.model.bean.ProjetoInicio;

public interface InterfacePlanoGerenciamentoRequisitoDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(PlanoGerenciamentoRequisito planoGerenciamentoRequisito) throws SQLException, NamingException , Exception;
	public abstract void salvar(PlanoGerenciamentoRequisito planoGerenciamentoRequisito) throws SQLException, NamingException , Exception;
	public abstract PlanoGerenciamentoRequisito getPlanoGerenciamentoRequisito(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<PlanoGerenciamentoRequisito> getPlanoGerenciamentoRequisitos() throws SQLException, NamingException, Exception;
	List<ProjetoInicio> getPProjetoInicios() throws Exception;
		
}

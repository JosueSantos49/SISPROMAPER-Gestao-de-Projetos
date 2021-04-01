/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.OrcamentoProjeto;

public interface InterfaceOrcamentoProjetoDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(OrcamentoProjeto orcamentoProjeto) throws SQLException, NamingException , Exception;
	public abstract void salvar(OrcamentoProjeto orcamentoProjeto) throws SQLException, NamingException , Exception;
	public abstract OrcamentoProjeto getOrcamentoProjeto(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<OrcamentoProjeto> getOrcamentoProjetos() throws SQLException, NamingException, Exception;
		
}

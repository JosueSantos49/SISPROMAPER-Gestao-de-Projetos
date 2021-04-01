/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.CriterioPreQualificacao;

public interface InterfaceCriterioPreQualificacaoDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(CriterioPreQualificacao criterioPreQualificacao) throws SQLException, NamingException , Exception;
	public abstract void salvar(CriterioPreQualificacao criterioPreQualificacao) throws SQLException, NamingException , Exception;
	public abstract CriterioPreQualificacao getCriterioPreQualificacao(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<CriterioPreQualificacao> getCriterioPreQualificacaos() throws SQLException, NamingException, Exception;
		
}

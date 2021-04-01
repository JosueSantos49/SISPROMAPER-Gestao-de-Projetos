/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.SolicitacaoProjeto;

public interface InterfaceSolicitacaoProjetoDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException, Exception;
	public abstract void atualizar(SolicitacaoProjeto solicitacaoProjeto) throws SQLException, NamingException, Exception;
	public abstract void salvar(SolicitacaoProjeto solicitacaoProjeto) throws SQLException, NamingException, Exception;
	public abstract SolicitacaoProjeto getSolicitacaoProjeto(Integer codigo) throws SQLException, NamingException, Exception;
	public abstract List<SolicitacaoProjeto> getSolicitacaoProjetos() throws SQLException, NamingException, Exception;
		
}

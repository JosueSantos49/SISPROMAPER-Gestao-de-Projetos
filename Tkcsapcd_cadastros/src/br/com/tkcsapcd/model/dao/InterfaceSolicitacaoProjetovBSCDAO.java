/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.SolicitacaoProjetovBSC;

public interface InterfaceSolicitacaoProjetovBSCDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(SolicitacaoProjetovBSC solicitacaoProjetovBSC) throws SQLException, NamingException , Exception;
	public abstract void salvar(SolicitacaoProjetovBSC solicitacaoProjetovBSC) throws SQLException, NamingException , Exception;
	public abstract SolicitacaoProjetovBSC getSolicitacaoProjetovBSC(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<SolicitacaoProjetovBSC> getSolicitacaoProjetovBSCs() throws SQLException, NamingException, Exception;
		
}

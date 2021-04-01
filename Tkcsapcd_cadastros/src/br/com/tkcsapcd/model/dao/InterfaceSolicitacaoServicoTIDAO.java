/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.SolicitacaoServicoTI;

public interface InterfaceSolicitacaoServicoTIDAO {

	public abstract void excluir (Integer codigo)throws SQLException, NamingException, Exception;
	public abstract void atualizar (SolicitacaoServicoTI solicitacaoServicoTI)throws SQLException, NamingException, Exception;
	public abstract void salvar (SolicitacaoServicoTI solicitacaoServicoTI) throws SQLException, NamingException, Exception;
	public abstract SolicitacaoServicoTI getSolicitacaoServicoTI (Integer codigo)throws SQLException, NamingException, Exception;
	public abstract List<SolicitacaoServicoTI> getSolicitacaoServicoTIs() throws SQLException, NamingException, Exception;
	
}

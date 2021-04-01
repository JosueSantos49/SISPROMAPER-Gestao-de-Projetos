/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.BusinessPlanDetalhe;

public interface InterfaceBusinessPlanDetalheDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException, Exception;
	public abstract void atualizar(BusinessPlanDetalhe businessPlanDetalhe) throws SQLException, NamingException, Exception;
	public abstract void salvar(BusinessPlanDetalhe businessPlanDetalhe) throws SQLException, NamingException, Exception;
	public abstract BusinessPlanDetalhe getBusinessPlanDetalhe(Integer codigo) throws SQLException, NamingException, Exception;
	public abstract List<BusinessPlanDetalhe> getBusinessPlanDetalhes() throws SQLException, NamingException, Exception;
		
}

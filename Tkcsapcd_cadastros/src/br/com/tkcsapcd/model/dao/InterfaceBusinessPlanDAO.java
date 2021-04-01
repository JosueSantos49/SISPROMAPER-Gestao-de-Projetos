/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.BusinessPlan;

public interface InterfaceBusinessPlanDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException, Exception;
	public abstract void atualizar(BusinessPlan businessPlan) throws SQLException, NamingException, Exception;
	public abstract void salvar(BusinessPlan businessPlan) throws SQLException, NamingException, Exception;
	public abstract BusinessPlan getBusinessPlan(Integer codigo) throws SQLException, NamingException, Exception;
	public abstract List<BusinessPlan> getBusinessPlans() throws SQLException, NamingException, Exception;
		
}

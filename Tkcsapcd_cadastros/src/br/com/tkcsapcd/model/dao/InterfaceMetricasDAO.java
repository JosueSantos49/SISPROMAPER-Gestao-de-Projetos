/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.Metricas;

public interface InterfaceMetricasDAO {
	
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(Metricas metricas) throws SQLException, NamingException , Exception;
	public abstract void salvar(Metricas metricas) throws SQLException, NamingException , Exception;
	public abstract Metricas getMetricas(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<Metricas> getMetricass() throws SQLException, NamingException, Exception;
}

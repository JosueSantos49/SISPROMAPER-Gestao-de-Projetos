/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.RfpProjeto;

public interface InterfaceRfpProjetoDAO {
	
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(RfpProjeto rfpProjeto) throws SQLException, NamingException , Exception;
	public abstract void salvar(RfpProjeto rfpProjeto) throws SQLException, NamingException , Exception;
	public abstract RfpProjeto getRfpProjeto(Integer codigo) throws SQLException, NamingException, Exception ;
	public abstract RfpProjeto getRfpProjeto(String login);
	public abstract List<RfpProjeto> getRfpProjeto() throws SQLException, NamingException, Exception;
}

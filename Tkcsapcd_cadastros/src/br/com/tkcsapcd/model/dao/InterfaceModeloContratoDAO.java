/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.ModeloContrato;

public interface InterfaceModeloContratoDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(ModeloContrato modeloContrato) throws SQLException, NamingException , Exception;
	public abstract void salvar(ModeloContrato modeloContrato) throws SQLException, NamingException , Exception;
	public abstract ModeloContrato getModeloContrato(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<ModeloContrato> getModeloContratos() throws SQLException, NamingException, Exception;
		
}

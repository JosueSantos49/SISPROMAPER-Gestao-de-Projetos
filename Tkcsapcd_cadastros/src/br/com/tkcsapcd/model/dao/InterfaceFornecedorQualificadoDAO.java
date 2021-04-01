/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.FornecedorQualificado;

public interface InterfaceFornecedorQualificadoDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(FornecedorQualificado fornecedorQualificado) throws SQLException, NamingException , Exception;
	public abstract void salvar(FornecedorQualificado fornecedorQualificado) throws SQLException, NamingException , Exception;
	public abstract FornecedorQualificado getFornecedorQualificado(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<FornecedorQualificado> getFornecedorQualificados() throws SQLException, NamingException, Exception;
		
}

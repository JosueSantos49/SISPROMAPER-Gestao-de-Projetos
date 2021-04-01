/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.RegistroParteInteressadaFornecedor;

public interface InterfaceRegistroParteInteressadaFornecedorDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException, Exception ;
	public abstract void atualizar(RegistroParteInteressadaFornecedor registroParteInteressadaFornecedor) throws SQLException, NamingException , Exception;
	public abstract void salvar(RegistroParteInteressadaFornecedor registroParteInteressadaFornecedor) throws SQLException, NamingException , Exception;
	public abstract RegistroParteInteressadaFornecedor getRegistroParteInteressadaFornecedor(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<RegistroParteInteressadaFornecedor> getRegistroParteInteressadaFornecedors() throws SQLException, NamingException, Exception;
		
}

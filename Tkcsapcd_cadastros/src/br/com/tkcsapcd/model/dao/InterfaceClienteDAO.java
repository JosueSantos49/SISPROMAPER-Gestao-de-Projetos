/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.Cliente;

public interface InterfaceClienteDAO {

		public abstract void excluir(Integer codigo) throws SQLException, NamingException, Exception;
		public abstract void atualizar(Cliente cliente) throws SQLException, NamingException, Exception;
		public abstract void salvar(Cliente cliente) throws SQLException, NamingException, Exception;
		public abstract Cliente getCliente(Integer codigo) throws SQLException, NamingException, Exception;
		public abstract List<Cliente> getClientes() throws SQLException, NamingException, Exception;
}

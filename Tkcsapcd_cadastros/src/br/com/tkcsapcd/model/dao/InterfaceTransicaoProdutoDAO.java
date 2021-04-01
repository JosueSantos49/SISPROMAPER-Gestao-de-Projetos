/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.TransicaoProduto;

public interface InterfaceTransicaoProdutoDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException, Exception;
	public abstract void atualizar(TransicaoProduto transicaoProduto) throws SQLException, NamingException, Exception;
	public abstract void salvar(TransicaoProduto transicaoProduto) throws SQLException, NamingException, Exception;
	public abstract TransicaoProduto getTransicaoProduto(Integer codigo) throws SQLException, NamingException, Exception;
	public abstract List<TransicaoProduto> getTransicaoProdutos() throws SQLException, NamingException, Exception;
		
}

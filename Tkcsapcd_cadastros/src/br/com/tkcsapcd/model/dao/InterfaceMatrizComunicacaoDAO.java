/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.MatrizComunicacao;

public interface InterfaceMatrizComunicacaoDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(MatrizComunicacao matrizComunicacao) throws SQLException, NamingException , Exception;
	public abstract void salvar(MatrizComunicacao matrizComunicacao) throws SQLException, NamingException , Exception;
	public abstract MatrizComunicacao getMatrizComunicacao(Integer codigo) throws SQLException, NamingException, Exception ;
	public abstract List<MatrizComunicacao> getMatrizComunicacaos() throws SQLException, NamingException, Exception;
		
}

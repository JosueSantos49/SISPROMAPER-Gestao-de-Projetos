/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.MatrizResponsabilidade;

public interface InterfaceMatrizResponsabilidadeDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException, Exception ;
	public abstract void atualizar(MatrizResponsabilidade matrizResponsabilidade) throws SQLException, NamingException, Exception ;
	public abstract void salvar(MatrizResponsabilidade matrizResponsabilidade) throws SQLException, NamingException, Exception ;
	public abstract MatrizResponsabilidade getMatrizResponsabilidade (Integer codigo) throws SQLException, NamingException, Exception ;
	public abstract List<MatrizResponsabilidade> getMatrizResponsabilidades() throws SQLException, NamingException, Exception;

	//List<MatrizResponsabilidade> getMMatrizResponsabilidades() throws SQLException, NamingException, Exception;
	
}

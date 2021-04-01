/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.MatrizRastreabilidadeRequisito;

public interface InterfaceMatrizRastreabilidadeRequisitoDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException, Exception;
	public abstract void atualizar(MatrizRastreabilidadeRequisito matrizRastreabilidadeRequisito) throws SQLException, NamingException , Exception;
	public abstract void salvar(MatrizRastreabilidadeRequisito matrizRastreabilidadeRequisito) throws SQLException, NamingException , Exception;
	public abstract MatrizRastreabilidadeRequisito getMatrizRastreabilidadeRequisito(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<MatrizRastreabilidadeRequisito> getMatrizRastreabilidadeRequisitos() throws SQLException, NamingException, Exception;
		
}

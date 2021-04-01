/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.ListaOcorrencia;

public interface InterfaceListaOcorrenciaDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException, Exception ;
	public abstract void atualizar(ListaOcorrencia listaOcorrencia) throws SQLException, NamingException, Exception ;
	public abstract void salvar(ListaOcorrencia listaOcorrencia) throws SQLException, NamingException, Exception ;
	public abstract ListaOcorrencia getListaOcorrencia (Integer codigo) throws SQLException, NamingException, Exception ;
	public abstract List<ListaOcorrencia> getListaOcorrencias() throws SQLException, NamingException, Exception;

	//List<ListaOcorrencia> getLListaOcorrencias() throws SQLException, NamingException, Exception;
	
}

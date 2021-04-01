/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.LicoesAprendida;

public interface InterfaceLicoesAprendidaDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(LicoesAprendida licoesAprendida) throws SQLException, NamingException , Exception;
	public abstract void salvar(LicoesAprendida licoesAprendida) throws SQLException, NamingException , Exception;
	public abstract LicoesAprendida getLicoesAprendida(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<LicoesAprendida> getLicoesAprendidas() throws SQLException, NamingException, Exception;
		
}

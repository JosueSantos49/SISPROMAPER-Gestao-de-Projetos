/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.AtaReuniao;

public interface InterfaceAtaReuniaoDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException, Exception;
	public abstract void atualizar(AtaReuniao ataReuniao) throws SQLException, NamingException, Exception;
	public abstract void salvar(AtaReuniao ataReuniao) throws SQLException, NamingException, Exception;
	public abstract AtaReuniao getAtaReuniao(Integer codigo) throws SQLException, NamingException, Exception;
	public abstract List<AtaReuniao> getAtaReuniaos() throws SQLException, NamingException, Exception;
		
}

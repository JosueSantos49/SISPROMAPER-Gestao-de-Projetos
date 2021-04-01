/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.PautaReuniao;

public interface InterfacePautaReuniaoDAO {
	
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(PautaReuniao pautaReuniao) throws SQLException, NamingException , Exception;
	public abstract void salvar(PautaReuniao pautaReuniao) throws SQLException, NamingException , Exception;
	public abstract PautaReuniao getPautaReuniao(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract PautaReuniao getPautaReuniao(String login);
	public abstract List<PautaReuniao> getPautaReuniaos() throws SQLException, NamingException, Exception;
}

/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.DiagnosticoPlanoAcao;

public interface InterfaceDiagnosticoPlanoAcaoDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(DiagnosticoPlanoAcao diagnosticoPlanoAcao) throws SQLException, NamingException , Exception;
	public abstract void salvar(DiagnosticoPlanoAcao diagnosticoPlanoAcao) throws SQLException, NamingException , Exception;
	public abstract DiagnosticoPlanoAcao getDiagnosticoPlanoAcao(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<DiagnosticoPlanoAcao> getDiagnosticoPlanoAcaos() throws SQLException, NamingException, Exception;
		
}

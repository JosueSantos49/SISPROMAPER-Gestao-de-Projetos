/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.PlanoMelhoriaProcesso;

public interface InterfacePlanoMelhoriaProcessoDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception, Exception, Exception;
	public abstract void atualizar(PlanoMelhoriaProcesso planoMelhoriaProcesso) throws SQLException, NamingException , Exception, Exception, Exception;
	public abstract void salvar(PlanoMelhoriaProcesso planoMelhoriaProcesso) throws SQLException, NamingException , Exception, Exception, Exception;
	public abstract PlanoMelhoriaProcesso getPlanoMelhoriaProcesso(Integer codigo) throws SQLException, NamingException , Exception, Exception, Exception;
	public abstract List<PlanoMelhoriaProcesso> getPlanoMelhoriaProcessos() throws SQLException, NamingException, Exception, Exception, Exception;
		
}

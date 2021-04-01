/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.RelatorioEncerramentoContrato;

public interface InterfaceRelatorioEncerramentoContratoDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(RelatorioEncerramentoContrato relatorioEncerramentoContrato) throws SQLException, NamingException , Exception;
	public abstract void salvar(RelatorioEncerramentoContrato relatorioEncerramentoContrato) throws SQLException, NamingException , Exception;
	public abstract RelatorioEncerramentoContrato getRelatorioEncerramentoContrato(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<RelatorioEncerramentoContrato> getRelatorioEncerramentoContratos() throws SQLException, NamingException, Exception;
		
}

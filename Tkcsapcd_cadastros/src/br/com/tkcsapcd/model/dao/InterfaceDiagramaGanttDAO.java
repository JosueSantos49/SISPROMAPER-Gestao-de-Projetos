/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.DiagramaGantt;

public interface InterfaceDiagramaGanttDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(DiagramaGantt diagramaGantt) throws SQLException, NamingException , Exception;
	public abstract void salvar(DiagramaGantt diagramaGantt) throws SQLException, NamingException , Exception;
	public abstract DiagramaGantt getDiagramaGantt(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract List<DiagramaGantt> getDiagramaGantts() throws SQLException, NamingException, Exception;
		
}

/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.AvaliacaoDesempenhoEquipe;

public interface InterfaceAvaliacaoDesempenhoEquipeDAO {
		
	public abstract void excluir(Integer codigo) throws SQLException, NamingException, Exception;
	public abstract void atualizar(AvaliacaoDesempenhoEquipe avaliacaoDesempenhoEquipe) throws SQLException, NamingException, Exception;
	public abstract void salvar(AvaliacaoDesempenhoEquipe avaliacaoDesempenhoEquipe) throws SQLException, NamingException, Exception;
	public abstract AvaliacaoDesempenhoEquipe getAvaliacaoDesempenhoEquipe(Integer codigo) throws SQLException, NamingException, Exception;
	public abstract List<AvaliacaoDesempenhoEquipe> getAvaliacaoDesempenhoEquipes() throws SQLException, NamingException, Exception;
		
}

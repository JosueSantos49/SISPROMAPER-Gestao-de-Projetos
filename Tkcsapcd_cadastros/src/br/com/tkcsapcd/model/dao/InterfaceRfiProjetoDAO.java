package br.com.tkcsapcd.model.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import br.com.tkcsapcd.model.bean.RfiProjeto;

public interface InterfaceRfiProjetoDAO{

	public abstract void excluir(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract void atualizar(RfiProjeto rfiProjeto) throws SQLException, NamingException , Exception;
	public abstract void salvar(RfiProjeto rfiProjeto) throws SQLException, NamingException , Exception;
	public abstract RfiProjeto getRfiProjeto(Integer codigo) throws SQLException, NamingException , Exception;
	public abstract RfiProjeto getRfiProjeto(String login);
	public abstract List<RfiProjeto> getRfiProjeto() throws SQLException, NamingException, Exception;
}

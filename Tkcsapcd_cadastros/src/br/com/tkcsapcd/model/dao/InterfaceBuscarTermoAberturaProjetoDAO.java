package br.com.tkcsapcd.model.dao;

import java.util.List;

import br.com.tkcsapcd.model.bean.TermoAberturaProjeto;

public interface InterfaceBuscarTermoAberturaProjetoDAO {

	public abstract List<TermoAberturaProjeto> getBuscarTermoAberturaProjeto() throws Exception;
}

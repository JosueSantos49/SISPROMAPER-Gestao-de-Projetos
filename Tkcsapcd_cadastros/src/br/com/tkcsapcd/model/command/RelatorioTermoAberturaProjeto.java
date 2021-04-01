package br.com.tkcsapcd.model.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.TermoAberturaProjetoDAO;

public class RelatorioTermoAberturaProjeto implements InterfaceCommand{

	public RelatorioTermoAberturaProjeto(TermoAberturaProjetoDAO termoAberturaProjetoDAO) {
		
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, Exception {
		
		return null;
	}

	
}

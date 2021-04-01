/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceEnvolvimentoPessoaProjetoInicioDAO;

//Método registrado na InterfaceCommand
public class ConsultarEnvolvimentoPessoaProjetoInicio implements InterfaceCommand {
	
	private InterfaceEnvolvimentoPessoaProjetoInicioDAO envolvimentoPessoaProjetoInicioDAO;//atributo, que sera setado no cronstrutor da classe		
	public ConsultarEnvolvimentoPessoaProjetoInicio(InterfaceEnvolvimentoPessoaProjetoInicioDAO envolvimentoPessoaProjetoInicioDAO) {
		super();
		this.envolvimentoPessoaProjetoInicioDAO = envolvimentoPessoaProjetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)throws SQLException {	
		
			request.setAttribute("titulo", "Consultar - Projeto");//Processamento que será executado pelo comando

		try {
			request.setAttribute("envolvimentoPessoaProjetoInicios", envolvimentoPessoaProjetoInicioDAO.getEnvolvimentoPessoaProjetoInicios());//atributo recuperado no consulta_projeto.jsp
		} catch (Exception e) 
		{			
			request.setAttribute("mensagem", "Problema com acesso a base de dados!");//Caso aja problema, será executado MSN informando!
			e.printStackTrace();
		}			 
			return "consulta_envolvimento_pessoa_projeto_inicio.jsp";//se não ouver erro, retorne a pagina.
	}
	//Deve cadastrar o comando no TkcsapcdHelper!!!!!
}

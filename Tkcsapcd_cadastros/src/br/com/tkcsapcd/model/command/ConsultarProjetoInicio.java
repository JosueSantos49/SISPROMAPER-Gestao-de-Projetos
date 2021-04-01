/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;

//Método registrado na InterfaceCommand
public class ConsultarProjetoInicio implements InterfaceCommand {
	
	private InterfaceProjetoInicioDAO projetoInicioDAO;//atributo, que sera setado no cronstrutor da classe		
	public ConsultarProjetoInicio(InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)throws SQLException {	
		
			request.setAttribute("titulo", "Consultar - Novo Projeto");//Processamento que será executado pelo comando

		try {
			request.setAttribute("projetoInicios", projetoInicioDAO.getProjetoInicios());//atributo recuperado no consulta_projeto.jsp
		} catch (Exception e) 
		{			
			request.setAttribute("mensagem", "Problema com acesso a base de dados!"+e);//Caso aja problema, será executado MSN informando!
			e.printStackTrace();
		}			 
			return "consulta_projeto_inicio.jsp";//se não ouver erro, retorne a pagina.
			//return "cadastro_envolvimento_pessoa_projeto.jsp";
	}
	//Deve cadastrar o comando no TkcsapcdHelper!!!!!
}

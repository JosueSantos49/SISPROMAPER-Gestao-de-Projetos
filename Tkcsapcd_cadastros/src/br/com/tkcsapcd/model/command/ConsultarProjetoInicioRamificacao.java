/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
//class respons�vel pela configura��o da ramifica��o no cad. projeto	
//M�todo registrado na InterfaceCommand
public class ConsultarProjetoInicioRamificacao implements InterfaceCommand {
	
	private InterfaceProjetoInicioDAO projetoInicioDAO;//atributo, que sera setado no cronstrutor da classe		
	public ConsultarProjetoInicioRamificacao(InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)throws SQLException {	
		
			request.setAttribute("titulo", "Consultar - Novo Projeto");//Processamento que ser� executado pelo comando

		try {
			request.setAttribute("projetoInicios", projetoInicioDAO.getProjetoInicios());//atributo recuperado no consulta_projeto.jsp
		} catch (Exception e) 
		{			
			request.setAttribute("mensagem", "Problema com acesso a base de dados!");//Caso aja problema, ser� executado MSN informando!
			e.printStackTrace();
		}			 
			return "consultar_projeto_Inicio_ramificacao.jsp";//se n�o ouver erro, retorne a pagina.
	}
	//Deve cadastrar o comando no TkcsapcdHelper!!!!!
}

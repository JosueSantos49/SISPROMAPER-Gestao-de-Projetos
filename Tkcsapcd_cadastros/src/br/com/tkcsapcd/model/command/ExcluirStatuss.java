/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceStatussDAO;

public class ExcluirStatuss implements InterfaceCommand {
	
	private InterfaceStatussDAO statussDAO;
	
	public ExcluirStatuss(InterfaceStatussDAO statussDAO) {
		super();
		this.statussDAO = statussDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{	
			
			statussDAO.excluir(Integer.valueOf(request.getParameter("codigo")));
			request.setAttribute("mensagem", "Excluido com sucesso!");
			
			} catch (NumberFormatException e) {
				
				// Se o numero n�o for v�lido
				request.setAttribute("mensagem", "Valo do c�digo inv�lido:"+request.getParameter("codigo"));				
				e.printStackTrace();
				
			}	catch (SQLException e) {
				 
				request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
				e.printStackTrace();
			}				
				//Caso funcione td corretamente. Seta o atributo
				request.setAttribute("titulo", "Atualiza��o - Status");	
				return "TkcsapcdController?cmd=consultarStatuss";
				//Cadastre esse comando no helper!
	}
}

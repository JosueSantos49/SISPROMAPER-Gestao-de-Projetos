/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceTransicaoProdutoDAO;

public class EditarTransicaoProduto implements InterfaceCommand {

	private InterfaceTransicaoProdutoDAO transicaoProdutoDAO;
	public EditarTransicaoProduto(InterfaceTransicaoProdutoDAO transicaoProdutoDAO) {
		super();
		this.transicaoProdutoDAO = transicaoProdutoDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception {			
			try{						
					if(request.getParameter("codigo") == null)
					{
						request.setAttribute("titulo", "Cadastro - TRANSI��O DO PRODUTO");
						return "cadastro_transicao_produto.jsp";
					}
					
					//Grande jogada				
					request.setAttribute("transicaoProduto", transicaoProdutoDAO.getTransicaoProduto(Integer.valueOf(request.getParameter("codigo"))));
					
					} catch (NumberFormatException e) {
						
						// Se o numero n�o for v�lido
						request.setAttribute("mensagem", "Valo do c�digo inv�lido:"+request.getParameter("codigo"));
						
					} catch (SQLException e) {
						 
						request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
						e.printStackTrace();
					}				
						//Caso funcione td corretamente. Seta o atributo
						request.setAttribute("titulo", "Atualiza��o - TRANSI��O DO PRODUTO");				
						return "atualiza_transicao_produto.jsp";
			}
	}

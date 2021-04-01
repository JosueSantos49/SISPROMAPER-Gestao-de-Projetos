/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceRegistroParteInteressadaDAO;
import br.com.tkcsapcd.model.dao.InterfaceTabelaParteInteressadaDAO;

public class EditarTabelaParteInteressada implements InterfaceCommand {

	private InterfaceTabelaParteInteressadaDAO tabelaParteInteressadaDAO;
	private InterfaceRegistroParteInteressadaDAO registroParteInteressadaDAO;
	
	public EditarTabelaParteInteressada(InterfaceTabelaParteInteressadaDAO tabelaParteInteressadaDAO, InterfaceRegistroParteInteressadaDAO registroParteInteressadaDAO) {
		super();
		this.tabelaParteInteressadaDAO = tabelaParteInteressadaDAO;
		this.registroParteInteressadaDAO= registroParteInteressadaDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception  {			
			
		try{						
			//Setando o atributo, para listar no select.
			request.setAttribute("registroParteInteressadas", registroParteInteressadaDAO.getRegistroParteInteressadas());
			
				if(request.getParameter("codigo") == null)
					{
						request.setAttribute("titulo", "Cadastro - Tabela Parte Interessadas");
						return "cadastro_tabela_parte_interessada.jsp";
					}
					
					//Grande jogada				
					request.setAttribute("tabelaParteInteressada", tabelaParteInteressadaDAO.getTabelaParteInteressada(Integer.valueOf(request.getParameter("codigo"))));
					
					} catch (NumberFormatException e) {
						
						// Se o numero não for válido
						request.setAttribute("mensagem", "Valo do código inválido:"+request.getParameter("codigo"));
						
					} catch (SQLException e) {
						 
						request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
						e.printStackTrace();
					}				
						//Caso funcione td corretamente. Seta o atributo
						request.setAttribute("titulo", "Atualização - Tabela Parte Interessadas");				
						return "atualiza_tabela_parte_interessada.jsp";
			}
	}

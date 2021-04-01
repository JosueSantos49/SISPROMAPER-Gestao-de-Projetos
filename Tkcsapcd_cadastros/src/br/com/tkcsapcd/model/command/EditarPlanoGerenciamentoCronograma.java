/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfacePlanoGerenciamentoCronogramaDAO;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;

public class EditarPlanoGerenciamentoCronograma implements InterfaceCommand {

	private InterfacePlanoGerenciamentoCronogramaDAO planoGerenciamentoCronogramaDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	
	public EditarPlanoGerenciamentoCronograma(InterfacePlanoGerenciamentoCronogramaDAO planoGerenciamentoCronogramaDAO,
			InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.planoGerenciamentoCronogramaDAO = planoGerenciamentoCronogramaDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception  {			
			try{		
				//Setando o atributo, para listar no select da pagina cadastro.
				request.setAttribute("projetoInicios", projetoInicioDAO.getProjetoInicios());
				
					if(request.getParameter("codigo") == null)
					{
						request.setAttribute("titulo", "Cadastro - PLANO DE GERENCIAMENTO DO CRONOGRAMA");
						return "cadastro_plano_gerenciamento_cronograma.jsp";
					}
					
					//Grande jogada				
					request.setAttribute("planoGerenciamentoCronograma", planoGerenciamentoCronogramaDAO.getPlanoGerenciamentoCronograma(Integer.valueOf(request.getParameter("codigo"))));
					
					} catch (NumberFormatException e) {
						
						// Se o numero não for válido
						request.setAttribute("mensagem", "Valo do código inválido:"+request.getParameter("codigo"));
						
					} catch (SQLException e) {
						 
						request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
						e.printStackTrace();
					}				
						//Caso funcione td corretamente. Seta o atributo
						request.setAttribute("titulo", "Atualização - PLANO DE GERENCIAMENTO DO CRONOGRAMA");				
						return "atualiza_plano_gerenciamento_cronograma.jsp";
			}
	}

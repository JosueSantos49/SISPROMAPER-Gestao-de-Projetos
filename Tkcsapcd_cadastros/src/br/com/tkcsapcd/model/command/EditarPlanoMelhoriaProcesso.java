/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfacePlanoMelhoriaProcessoDAO;

public class EditarPlanoMelhoriaProcesso implements InterfaceCommand {

	private InterfacePlanoMelhoriaProcessoDAO planoMelhoriaProcessoDAO;
	public EditarPlanoMelhoriaProcesso(InterfacePlanoMelhoriaProcessoDAO planoMelhoriaProcessoDAO) {
		super();
		this.planoMelhoriaProcessoDAO = planoMelhoriaProcessoDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception  {			
			try{						
					if(request.getParameter("codigo") == null)
					{
						request.setAttribute("titulo", "Cadastro - PLANO DE MELHORIA DO PROCESSO");
						return "cadastro_plano_melhoria_processo.jsp";
					}
					
					//Grande jogada				
					request.setAttribute("planoMelhoriaProcesso", planoMelhoriaProcessoDAO.getPlanoMelhoriaProcesso(Integer.valueOf(request.getParameter("codigo"))));
					
					} catch (NumberFormatException e) {
						
						// Se o numero não for válido
						request.setAttribute("mensagem", "Valo do código inválido:"+request.getParameter("codigo"));
						
					} catch (SQLException e) {
						 
						request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
						e.printStackTrace();
					}				
						//Caso funcione td corretamente. Seta o atributo
						request.setAttribute("titulo", "Atualização - PLANO DE MELHORIA DO PROCESSO");				
						return "atualiza_plano_melhoria_processo.jsp";
			}
	}

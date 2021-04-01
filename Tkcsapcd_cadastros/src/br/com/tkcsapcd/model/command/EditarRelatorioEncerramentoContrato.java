/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.dao.InterfaceRelatorioEncerramentoContratoDAO;

public class EditarRelatorioEncerramentoContrato implements InterfaceCommand {

	private InterfaceRelatorioEncerramentoContratoDAO relatorioEncerramentoContratoDAO;
	public EditarRelatorioEncerramentoContrato(InterfaceRelatorioEncerramentoContratoDAO relatorioEncerramentoContratoDAO) {
		super();
		this.relatorioEncerramentoContratoDAO = relatorioEncerramentoContratoDAO;
	}
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response)throws Exception {			
			try{						
					if(request.getParameter("codigo") == null)
					{
						request.setAttribute("titulo", "Cadastro - Relatório de Encerramento do Contrato");
						return "cadastro_relatorio_encerramento_contrato.jsp";
					}
					
					//Grande jogada				
					request.setAttribute("relatorioEncerramentoContrato", relatorioEncerramentoContratoDAO.getRelatorioEncerramentoContrato(Integer.valueOf(request.getParameter("codigo"))));
					
					} catch (NumberFormatException e) {
						
						// Se o numero não for válido
						request.setAttribute("mensagem", "Valo do código inválido:"+request.getParameter("codigo"));
						
					} catch (SQLException e) {
						 
						request.setAttribute("mensagem", "Problema com acesso a basde de dados: "+e.getMessage());
						e.printStackTrace();
					}				
						//Caso funcione td corretamente. Seta o atributo
						request.setAttribute("titulo", "Atualização - Relatório de Encerramento do Contrato");				
						return "atualiza_relatorio_encerramento_contrato.jsp";
			}
	}

/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.PautaReuniao;
import br.com.tkcsapcd.model.dao.InterfacePautaReuniaoDAO;

public class AtualizarPautaReuniao implements InterfaceCommand {

	private InterfacePautaReuniaoDAO pautaReuniaoDAO;
	
	public AtualizarPautaReuniao(InterfacePautaReuniaoDAO pautaReuniaoDAO) {
		super();
		this.pautaReuniaoDAO = pautaReuniaoDAO;
	}

	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response) throws Exception {
		try {
			PautaReuniao pautaReuniao = new PautaReuniao();
			
			pautaReuniao.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa citua��o
			pautaReuniao.setPautareuniao(request.getParameter("pautareuniao"));
			pautaReuniao.setProjeto(request.getParameter("projeto"));
			pautaReuniao.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			pautaReuniao.setData(request.getParameter("data"));
			pautaReuniao.setLocal(request.getParameter("local"));
			pautaReuniao.setParticipantes(request.getParameter("participantes"));
			pautaReuniao.setObjetivo(request.getParameter("objetivo"));
			pautaReuniao.setTopico(request.getParameter("topico"));
			pautaReuniao.setInformacao(request.getParameter("informacao"));
			
			pautaReuniaoDAO.atualizar(pautaReuniao);			
			request.setAttribute("mensagem", "PAUTA DE REUNI�O:("+pautaReuniao.getCodigoprojeto()+")atualizado com sucesso!");
			
			} catch (SQLException e) {
				
				request.setAttribute("mensagem", "Problema com a atualiza��o: "+e.getMessage());
				e.printStackTrace();
				
			}catch (NumberFormatException e) {
				request.setAttribute("mensagem", "Valor inv�lido: "+e.getMessage());			
			}	
			request.setAttribute("titulo", "Atualiza��o - PAUTA DE REUNI�O");
			return "TkcsapcdController?cmd=consultarPautaReuniao";//Pagina de Retorno (pagina consulta funcionario)

	}


}

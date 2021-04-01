/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.Statuss;
import br.com.tkcsapcd.model.dao.InterfaceStatussDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class AtualizarStatuss implements InterfaceCommand {

	private InterfaceStatussDAO statussDAO;
	public AtualizarStatuss(InterfaceStatussDAO statussDAO) {
		super();
		this.statussDAO = statussDAO;
	}
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			Statuss statuss = new Statuss();
			
			statuss.setCodigo(Integer.valueOf(request.getParameter("codigo")));
			statuss.setFase(request.getParameter("fase"));
			statuss.setPercentualevolucao(request.getParameter("percentualevolucao").equals("") ? null : Double.valueOf(request.getParameter("percentualevolucao")));
			statuss.setPercentualplanejado(request.getParameter("percentualplanejado").equals("") ? null : Double.valueOf(request.getParameter("percentualplanejado")));
			statuss.setDatastatus(request.getParameter("datastatus"));
			statuss.setDescricao(request.getParameter("descricao"));
			statuss.setPontospositivos(request.getParameter("pontospositivos"));
			statuss.setPontosnegativos(request.getParameter("pontosnegativos"));
			statuss.setTendencia(request.getParameter("tendencia"));
			statuss.setDatainicio(request.getParameter("datainicio"));
			statuss.setDatafim(request.getParameter("datafim"));
			statuss.setProjeto(request.getParameter("projeto"));
			statuss.setCodigodoprojeto(Integer.valueOf(request.getParameter("codigodoprojeto")));
			
			if(ValidationHelper.validar(statuss)){
				statussDAO.atualizar(statuss);
				request.setAttribute("mensagem", "C�d. Status Projeto: ("+statuss.getCodigodoprojeto()+") atualizado com sucesso!");
			}
			else{
				throw new Exception("Valor inv�lido");
			}
			} catch (SQLException e) {
				
				request.setAttribute("mensagem", "Problema com a atualiza��o: "+e.getMessage());
				e.printStackTrace();
				
			}catch (NumberFormatException e) {
				request.setAttribute("mensagem", "Valor inv�lido: "+e.getMessage());			
			}	
				request.setAttribute("titulo", "Atualiza��o - Status do Projeto");
				return "TkcsapcdController?cmd=consultarStatuss";//Pagina de Retorno (pagina consulta cliente)
			}
}

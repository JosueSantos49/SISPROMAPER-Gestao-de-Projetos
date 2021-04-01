/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.Alocacao;
import br.com.tkcsapcd.model.dao.InterfaceAlocacaoDAO;

//Método registrado na InterfaceCommand
public class AtualizarAlocacao implements InterfaceCommand {

	private InterfaceAlocacaoDAO alocacaoDAO;
	public AtualizarAlocacao(InterfaceAlocacaoDAO alocacaoDAO) {
		super();
		this.alocacaoDAO = alocacaoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
			Alocacao alocacao = new Alocacao();
			
			alocacao.setCodigo(Integer.valueOf(request.getParameter("codigo")));
			alocacao.setProjeto_codigo(Integer.valueOf(request.getParameter("projeto_codigo")));
			alocacao.setRecursoshumanos_codigo(request.getParameter("recursoshumanos_codigo"));
			alocacao.setProfissao_codigo(request.getParameter("profissao_codigo"));
			alocacao.setData(request.getParameter("data"));
			alocacao.setData0(request.getParameter("data0"));
			alocacao.setMetrica(request.getParameter("metrica"));
			alocacao.setMetrica1(request.getParameter("metrica1"));
			alocacao.setMetrica2(request.getParameter("metrica2"));
			alocacao.setMetrica3(request.getParameter("metrica3"));
			alocacao.setMetrica4(request.getParameter("metrica4"));
			alocacao.setMetrica5(request.getParameter("metrica5"));
			alocacao.setMetrica6(request.getParameter("metrica6"));
			alocacao.setMetrica7(request.getParameter("metrica7"));
			alocacao.setMetrica8(request.getParameter("metrica8"));
			alocacao.setMetrica9(request.getParameter("metrica9"));
			alocacao.setMetrica10(request.getParameter("metrica10"));
			alocacao.setMetrica11(request.getParameter("metrica11"));
			alocacao.setMetrica12(request.getParameter("metrica12"));
			alocacao.setMetrica13(request.getParameter("metrica13"));
			alocacao.setMetrica14(request.getParameter("metrica14"));
			alocacao.setMetrica15(request.getParameter("metrica15"));
			alocacao.setMetrica16(request.getParameter("metrica16"));
			
			alocacaoDAO.atualizar(alocacao);
			request.setAttribute("mensagem", "Alocação: "+alocacao.getProjeto_codigo()+" atualizado com sucesso!");
			
		} catch (SQLException e) {
			
			request.setAttribute("mensagem", "Problema com a atualização: "+e.getMessage());
			e.printStackTrace();
			
		}catch (NumberFormatException e) {
			request.setAttribute("mensagem", "Valor inválido: "+e.getMessage());			
		}	
			request.setAttribute("titulo", "Atualização - Alocação");
			return "TkcsapcdController?cmd=consultarAlocacao";
	}

}

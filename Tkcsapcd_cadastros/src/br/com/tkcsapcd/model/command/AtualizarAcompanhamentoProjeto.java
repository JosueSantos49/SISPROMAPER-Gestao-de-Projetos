/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.AcompanhamentoProjeto;
import br.com.tkcsapcd.model.dao.InterfaceAcompanhamentoProjetoDAO;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class AtualizarAcompanhamentoProjeto implements InterfaceCommand {

	private InterfaceAcompanhamentoProjetoDAO acompanhamentoProjetoDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	
	public AtualizarAcompanhamentoProjeto(InterfaceAcompanhamentoProjetoDAO acompanhamentoProjetoDAO,
			InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.acompanhamentoProjetoDAO = acompanhamentoProjetoDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}

	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response) throws Exception {
		try {
			AcompanhamentoProjeto acompanhamentoProjeto = new AcompanhamentoProjeto();
			
			acompanhamentoProjeto.setCodigo(Long.valueOf(request.getParameter("codigo")));			
			acompanhamentoProjeto.setAcompanhamentoprojeto(request.getParameter("acompanhamentoprojeto"));
			acompanhamentoProjeto.setVersao(Long.valueOf(request.getParameter("versao")));
			
			String data_1 = request.getParameter("data"); 
			Date data = new SimpleDateFormat("yyyy-MM-dd").parse(data_1);
			acompanhamentoProjeto.setData(data);
			
			acompanhamentoProjeto.setAutor(request.getParameter("autor"));
			acompanhamentoProjeto.setNotarevisao(request.getParameter("notarevisao"));
			acompanhamentoProjeto.setAprovacao(request.getParameter("aprovacao"));
			acompanhamentoProjeto.setProdutoservico(request.getParameter("produtoservico"));
			acompanhamentoProjeto.setSituacaoconcluida(request.getParameter("situacaoconcluida"));
			
			String data_2 = request.getParameter("dataplanejada"); 
			Date dataplanejada = new SimpleDateFormat("yyyy-MM-dd").parse(data_2);
			acompanhamentoProjeto.setDataplanejada(dataplanejada);
			
			String data_3 = request.getParameter("dataefetiva"); 
			Date dataefetiva = new SimpleDateFormat("yyyy-MM-dd").parse(data_3);
			acompanhamentoProjeto.setDataefetiva(dataefetiva);
			
			acompanhamentoProjeto.setAtrasoprevisto(Long.valueOf(request.getParameter("atrasoprevisto")));
			acompanhamentoProjeto.setValororcado(request.getParameter("valororcado").equals("") ? null : Double.valueOf(request.getParameter("valororcado")));
			acompanhamentoProjeto.setCustoreal(request.getParameter("custoreal").equals("") ? null : Double.valueOf(request.getParameter("custoreal")));
			acompanhamentoProjeto.setEspecificacao(request.getParameter("especificacao"));
			acompanhamentoProjeto.setNivel(request.getParameter("nivel"));
			acompanhamentoProjeto.setAcao(request.getParameter("acao"));
			acompanhamentoProjeto.setResponsavel(request.getParameter("responsavel"));
			
			Integer projetoinicio = Integer.valueOf(request.getParameter("projetoinicio"));										
			acompanhamentoProjeto.setProjetoinicio(projetoInicioDAO.getProjetoInicio(projetoinicio));
						
			if(ValidationHelper.validar(acompanhamentoProjeto)){	
				acompanhamentoProjetoDAO.atualizar(acompanhamentoProjeto);			
				request.setAttribute("mensagem", "Acompanhamento do Projeto: ("+acompanhamentoProjeto.getProjetoinicio().getProjeto()+") atualizado com sucesso!");
			}
			else{
				throw new Exception("Valor inválido");
			}
			} catch (SQLException e) {
				
				request.setAttribute("mensagem", "Problema com a atualização: "+e.getMessage());
				e.printStackTrace();
				
			}catch (NumberFormatException e) {
				request.setAttribute("mensagem", "Valor inválido: "+e.getMessage());			
			}	
			request.setAttribute("titulo", "Atualização - Acompanhamento do Projeto");
			return "TkcsapcdController?cmd=consultarAcompanhamentoProjeto";//Pagina de Retorno (pagina consulta funcionario)
	}


}

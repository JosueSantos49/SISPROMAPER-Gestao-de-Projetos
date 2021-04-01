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

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoProjeto;
import br.com.tkcsapcd.model.dao.InterfacePlanoGerenciamentoProjetoDAO;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarPlanoGerenciamentoProjeto implements InterfaceCommand {

	private InterfacePlanoGerenciamentoProjetoDAO planoGerenciamentoProjetoDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	public AtualizarPlanoGerenciamentoProjeto(InterfacePlanoGerenciamentoProjetoDAO planoGerenciamentoProjetoDAO, InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.planoGerenciamentoProjetoDAO = planoGerenciamentoProjetoDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request					
					PlanoGerenciamentoProjeto planoGerenciamentoProjeto = new PlanoGerenciamentoProjeto();
					
					planoGerenciamentoProjeto.setCodigo(Long.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação				
					planoGerenciamentoProjeto.setPlanogerenciamentoprojeto(request.getParameter("planogerenciamentoprojeto"));
					planoGerenciamentoProjeto.setVersao(request.getParameter("versao"));
					
					String data_1 = request.getParameter("data"); 
					Date data = new SimpleDateFormat("yyyy-MM-dd").parse(data_1);
					planoGerenciamentoProjeto.setData(data);
					
					planoGerenciamentoProjeto.setAutor(request.getParameter("autor"));
					planoGerenciamentoProjeto.setNotarevisao(request.getParameter("notarevisao"));
					planoGerenciamentoProjeto.setAprovacao(request.getParameter("aprovacao"));
					planoGerenciamentoProjeto.setObjetivo(request.getParameter("objetivo"));				
					planoGerenciamentoProjeto.setLinhabase(request.getParameter("linhabase"));					
					planoGerenciamentoProjeto.setOrganizacao(request.getParameter("organizacao"));
					planoGerenciamentoProjeto.setCronograma(request.getParameter("cronograma"));
					planoGerenciamentoProjeto.setProgresso(request.getParameter("progresso"));
					planoGerenciamentoProjeto.setRisco(request.getParameter("risco"));
					planoGerenciamentoProjeto.setComunicacao(request.getParameter("comunicacao"));
					planoGerenciamentoProjeto.setMudanca(request.getParameter("mudanca"));
					
					Integer projetoinicio = Integer.valueOf(request.getParameter("projetoinicio"));										
					planoGerenciamentoProjeto.setProjetoinicio(projetoInicioDAO.getProjetoInicio(projetoinicio));
		
		if(ValidationHelper.validar(planoGerenciamentoProjeto)){			
			planoGerenciamentoProjetoDAO.atualizar(planoGerenciamentoProjeto);
			request.setAttribute("mensagem", "PLANO DE GERENCIAMENTO DO PROJETO: ("+planoGerenciamentoProjeto.getProjetoinicio().getProjeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - PLANO DE GERENCIAMENTO DO PROJETO");
			return "TkcsapcdController?cmd=consultarPlanoGerenciamentoProjeto";//Pagina de Retorno (pagina consulta)
	}

}

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

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoRequisito;
import br.com.tkcsapcd.model.dao.InterfacePlanoGerenciamentoRequisitoDAO;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarPlanoGerenciamentoRequisito implements InterfaceCommand {

	private InterfacePlanoGerenciamentoRequisitoDAO planoGerenciamentoRequisitoDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	
	public AtualizarPlanoGerenciamentoRequisito(InterfacePlanoGerenciamentoRequisitoDAO planoGerenciamentoRequisitoDAO, InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.planoGerenciamentoRequisitoDAO = planoGerenciamentoRequisitoDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request					
					PlanoGerenciamentoRequisito planoGerenciamentoRequisito = new PlanoGerenciamentoRequisito();
					
					planoGerenciamentoRequisito.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					planoGerenciamentoRequisito.setPlanogerenciamentorequisito(request.getParameter("planogerenciamentorequisito"));
					planoGerenciamentoRequisito.setVersao(request.getParameter("versao"));
					
					String data_1 = request.getParameter("data"); 
					Date data = new SimpleDateFormat("yyyy-MM-dd").parse(data_1);
					planoGerenciamentoRequisito.setData(data);
					
					planoGerenciamentoRequisito.setAutor(request.getParameter("autor"));
					planoGerenciamentoRequisito.setNotarevisao(request.getParameter("notarevisao"));
					planoGerenciamentoRequisito.setAprovacao(request.getParameter("aprovacao"));
					planoGerenciamentoRequisito.setObjetivo(request.getParameter("objetivo"));
					planoGerenciamentoRequisito.setGerenciamento(request.getParameter("gerenciamento"));
					planoGerenciamentoRequisito.setProcesso(request.getParameter("processo"));					
					planoGerenciamentoRequisito.setDocumento(request.getParameter("documento"));
					planoGerenciamentoRequisito.setResponsabilidade(request.getParameter("responsabilidade"));
					planoGerenciamentoRequisito.setConfiguracao(request.getParameter("configuracao"));
					planoGerenciamentoRequisito.setPrioridade(request.getParameter("prioridade"));
					planoGerenciamentoRequisito.setColeta(request.getParameter("coleta"));
					planoGerenciamentoRequisito.setRatreabilidade(request.getParameter("ratreabilidade"));
					planoGerenciamentoRequisito.setMetrica(request.getParameter("metrica"));
					
					Integer projetoinicio = Integer.valueOf(request.getParameter("projetoinicio"));										
					planoGerenciamentoRequisito.setProjetoinicio(projetoInicioDAO.getProjetoInicio(projetoinicio));
		
		if(ValidationHelper.validar(planoGerenciamentoRequisito)){			
			planoGerenciamentoRequisitoDAO.atualizar(planoGerenciamentoRequisito);
			request.setAttribute("mensagem", "PLANO DE GERENCIAMENTO DOS REQUISITOS: ("+planoGerenciamentoRequisito.getProjetoinicio().getProjeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - PLANO DE GERENCIAMENTO DOS REQUISITOS");
			return "TkcsapcdController?cmd=consultarPlanoGerenciamentoRequisito";//Pagina de Retorno (pagina consulta)
	}

}

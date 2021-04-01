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

import br.com.tkcsapcd.model.bean.GerenciamentoEscopo;
import br.com.tkcsapcd.model.dao.InterfaceGerenciamentoEscopoDAO;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarGerenciamentoEscopo implements InterfaceCommand {

	private InterfaceGerenciamentoEscopoDAO gerenciamentoEscopoDAO;	
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	public AtualizarGerenciamentoEscopo(InterfaceGerenciamentoEscopoDAO gerenciamentoEscopoDAO, InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.gerenciamentoEscopoDAO = gerenciamentoEscopoDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request
					GerenciamentoEscopo gerenciamentoEscopo = new GerenciamentoEscopo();
					
					gerenciamentoEscopo.setCodigo(Long.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					gerenciamentoEscopo.setEmpresa(request.getParameter("empresa"));
					gerenciamentoEscopo.setOrgao(request.getParameter("orgao"));
					gerenciamentoEscopo.setSetor(request.getParameter("setor"));
					gerenciamentoEscopo.setPrograma(request.getParameter("programa"));
					gerenciamentoEscopo.setGerente(request.getParameter("gerente"));
					gerenciamentoEscopo.setFuncao(request.getParameter("funcao"));
					gerenciamentoEscopo.setAprovado(request.getParameter("aprovado"));
					gerenciamentoEscopo.setVersao(request.getParameter("versao"));	
					
					String data_1 = request.getParameter("dataaprovacao"); 
					Date dataaprovacao = new SimpleDateFormat("yyyy-MM-dd").parse(data_1);
					gerenciamentoEscopo.setDataaprovacao(dataaprovacao);
					
					gerenciamentoEscopo.setObjetivo(request.getParameter("objetivo"));
					gerenciamentoEscopo.setGerenciamento(request.getParameter("gerenciamento"));
					gerenciamentoEscopo.setReunioes_equipe(request.getParameter("reunioes_equipe"));
					gerenciamentoEscopo.setReunioes_planejamento(request.getParameter("reunioes_planejamento"));
					gerenciamentoEscopo.setReunioes_gerenciais(request.getParameter("reunioes_gerenciais"));
					gerenciamentoEscopo.setModificacao_escopo(request.getParameter("modificacao_escopo"));
					gerenciamentoEscopo.setLicoes(request.getParameter("licoes"));	
					
					Integer projetoinicio = Integer.valueOf(request.getParameter("projetoinicio"));										
					gerenciamentoEscopo.setProjetoinicio(projetoInicioDAO.getProjetoInicio(projetoinicio));
		
		if(ValidationHelper.validar(gerenciamentoEscopo)){			
			gerenciamentoEscopoDAO.atualizar(gerenciamentoEscopo);
			request.setAttribute("mensagem", "Gerenciamento do Escopo: ("+gerenciamentoEscopo.getProjetoinicio().getProjeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - Gerenciamento do Escopo");
			return "TkcsapcdController?cmd=consultarGerenciamentoEscopo";//Pagina de Retorno (pagina consulta)
	}

}

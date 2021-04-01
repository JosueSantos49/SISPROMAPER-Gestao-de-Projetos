/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.DeclaracaoEscopo;
import br.com.tkcsapcd.model.dao.InterfaceDeclaracaoEscopoDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarDeclaracaoEscopo implements InterfaceCommand {

	private InterfaceDeclaracaoEscopoDAO declaracaoEscopoDAO;	
	public AtualizarDeclaracaoEscopo(InterfaceDeclaracaoEscopoDAO declaracaoEscopoDAO) {
		super();
		this.declaracaoEscopoDAO = declaracaoEscopoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request
					DeclaracaoEscopo declaracaoEscopo = new DeclaracaoEscopo();
					
					declaracaoEscopo.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					declaracaoEscopo.setEmpresa(request.getParameter("empresa"));
					declaracaoEscopo.setOrgao(request.getParameter("orgao"));
					declaracaoEscopo.setSetor(request.getParameter("setor"));
					declaracaoEscopo.setPrograma(request.getParameter("programa"));
					declaracaoEscopo.setProjeto(request.getParameter("projeto"));
					declaracaoEscopo.setGerente(request.getParameter("gerente"));
					declaracaoEscopo.setFuncao(request.getParameter("funcao"));
					declaracaoEscopo.setAprovado(request.getParameter("aprovado"));
					declaracaoEscopo.setVersao(request.getParameter("versao"));				
					declaracaoEscopo.setDataaprovacao(request.getParameter("dataaprovacao"));					
					declaracaoEscopo.setJustificativa(request.getParameter("justificativa"));
					declaracaoEscopo.setObjetivo(request.getParameter("objetivo"));
					declaracaoEscopo.setDescricao(request.getParameter("descricao"));
					declaracaoEscopo.setLista(request.getParameter("lista"));
					declaracaoEscopo.setLigacao(request.getParameter("ligacao"));
					declaracaoEscopo.setEstrategia(request.getParameter("estrategia"));
					declaracaoEscopo.setResponsabilidade(request.getParameter("responsabilidade"));
					declaracaoEscopo.setMacro(request.getParameter("macro"));					
					declaracaoEscopo.setPremissas(request.getParameter("premissas"));
					declaracaoEscopo.setRestricoes(request.getParameter("restricoes"));
					declaracaoEscopo.setEquipe(request.getParameter("equipe"));
					declaracaoEscopo.setObs(request.getParameter("obs"));					
					declaracaoEscopo.setCodigoprojeto(request.getParameter("codigoprojeto"));
		
		if(ValidationHelper.validar(declaracaoEscopo)){			
			declaracaoEscopoDAO.atualizar(declaracaoEscopo);
			request.setAttribute("mensagem", "Declaração do Escopo: ("+declaracaoEscopo.getCodigoprojeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - Declaração do Escopo");
			return "TkcsapcdController?cmd=consultarDeclaracaoescopo";//Pagina de Retorno (pagina consulta)
	}

}

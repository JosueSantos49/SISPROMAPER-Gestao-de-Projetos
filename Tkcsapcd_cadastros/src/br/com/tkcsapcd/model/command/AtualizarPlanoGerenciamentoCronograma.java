/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoCronograma;
import br.com.tkcsapcd.model.dao.InterfacePlanoGerenciamentoCronogramaDAO;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarPlanoGerenciamentoCronograma implements InterfaceCommand {

	private InterfacePlanoGerenciamentoCronogramaDAO planoGerenciamentoCronogramaDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	
	public AtualizarPlanoGerenciamentoCronograma(InterfacePlanoGerenciamentoCronogramaDAO planoGerenciamentoCronogramaDAO,
			InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.planoGerenciamentoCronogramaDAO = planoGerenciamentoCronogramaDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request					
					PlanoGerenciamentoCronograma planoGerenciamentoCronograma = new PlanoGerenciamentoCronograma();
					
					planoGerenciamentoCronograma.setCodigo(Long.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					planoGerenciamentoCronograma.setPlanogerenciamentocronograma(request.getParameter("planogerenciamentocronograma"));
					planoGerenciamentoCronograma.setVersao(request.getParameter("versao"));
					
					Date data = new Date();
					planoGerenciamentoCronograma.setData(data);
					
					planoGerenciamentoCronograma.setAutor(request.getParameter("autor"));
					planoGerenciamentoCronograma.setNotarevisao(request.getParameter("notarevisao"));
					planoGerenciamentoCronograma.setAprovacao(request.getParameter("aprovacao"));
					planoGerenciamentoCronograma.setObjetivo(request.getParameter("objetivo"));				
					planoGerenciamentoCronograma.setMetodo(request.getParameter("metodo"));					
					planoGerenciamentoCronograma.setProcesso(request.getParameter("processo"));
					planoGerenciamentoCronograma.setDocumento(request.getParameter("documento"));
					planoGerenciamentoCronograma.setFerramenta(request.getParameter("ferramenta"));
					planoGerenciamentoCronograma.setPapeis(request.getParameter("papeis"));
					planoGerenciamentoCronograma.setPlano(request.getParameter("plano"));
					planoGerenciamentoCronograma.setAtividade(request.getParameter("atividade"));
					planoGerenciamentoCronograma.setSequenciar(request.getParameter("sequenciar"));
					planoGerenciamentoCronograma.setEstimarrecuso(request.getParameter("estimarrecuso"));					
					planoGerenciamentoCronograma.setEstimarduracao(request.getParameter("estimarduracao"));
					planoGerenciamentoCronograma.setDesenvolver(request.getParameter("desenvolver"));
					planoGerenciamentoCronograma.setControlar(request.getParameter("controlar"));
					
					Integer projetoinicio = Integer.valueOf(request.getParameter("projetoinicio"));										
					planoGerenciamentoCronograma.setProjetoinicio(projetoInicioDAO.getProjetoInicio(projetoinicio));
		
		if(ValidationHelper.validar(planoGerenciamentoCronograma)){			
			planoGerenciamentoCronogramaDAO.atualizar(planoGerenciamentoCronograma);
			request.setAttribute("mensagem", "Plano de Gerenciamento do Cronograma: ("+planoGerenciamentoCronograma.getProjetoinicio().getCodigoprojeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - Plano de Gerenciamento do Cronograma");
			return "TkcsapcdController?cmd=consultarPlanoGerenciamentoCronograma";//Pagina de Retorno (pagina consulta)
	}

}

/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.AvaliacaoDesempenhoEquipe;
import br.com.tkcsapcd.model.dao.InterfaceAvaliacaoDesempenhoEquipeDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarAvaliacaoDesempenhoEquipe implements InterfaceCommand {

	private InterfaceAvaliacaoDesempenhoEquipeDAO avaliacaoDesempenhoEquipeDAO;
	public AtualizarAvaliacaoDesempenhoEquipe(InterfaceAvaliacaoDesempenhoEquipeDAO avaliacaoDesempenhoEquipeDAO) {
		super();
		this.avaliacaoDesempenhoEquipeDAO = avaliacaoDesempenhoEquipeDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request					
					AvaliacaoDesempenhoEquipe avaliacaoDesempenhoEquipe = new AvaliacaoDesempenhoEquipe();
					
					avaliacaoDesempenhoEquipe.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					avaliacaoDesempenhoEquipe.setAvaliacaodesempenhoequipe(request.getParameter("avaliacaodesempenhoequipe"));
					avaliacaoDesempenhoEquipe.setProjeto(request.getParameter("projeto"));
					avaliacaoDesempenhoEquipe.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
					avaliacaoDesempenhoEquipe.setVersao(request.getParameter("versao"));
					avaliacaoDesempenhoEquipe.setData(request.getParameter("data"));
					avaliacaoDesempenhoEquipe.setAutor(request.getParameter("autor"));
					avaliacaoDesempenhoEquipe.setNotarevisao(request.getParameter("notarevisao"));
					avaliacaoDesempenhoEquipe.setAprovacao(request.getParameter("aprovacao"));
					avaliacaoDesempenhoEquipe.setEquipe(request.getParameter("equipe"));				
					avaliacaoDesempenhoEquipe.setPeriodoinicio(request.getParameter("periodoinicio"));					
					avaliacaoDesempenhoEquipe.setPeriodofim(request.getParameter("periodofim"));
					avaliacaoDesempenhoEquipe.setObjetivo(request.getParameter("objetivo"));
					avaliacaoDesempenhoEquipe.setAvaliacao(request.getParameter("retornoavaliacao"));
					avaliacaoDesempenhoEquipe.setIndicador(request.getParameter("indicador"));
					avaliacaoDesempenhoEquipe.setStatus(request.getParameter("status"));
					avaliacaoDesempenhoEquipe.setPontofraco(request.getParameter("pontofraco"));
					avaliacaoDesempenhoEquipe.setPontoforte(request.getParameter("pontoforte"));
					avaliacaoDesempenhoEquipe.setResultadoatingido(request.getParameter("resultadoatingido"));					
					avaliacaoDesempenhoEquipe.setRetornoavaliacao(request.getParameter("retornoavaliacao"));
					avaliacaoDesempenhoEquipe.setPlano(request.getParameter("plano"));
					avaliacaoDesempenhoEquipe.setDefinicao(request.getParameter("definicao"));
					avaliacaoDesempenhoEquipe.setNecessidade(request.getParameter("necessidade"));
		
		if(ValidationHelper.validar(avaliacaoDesempenhoEquipe)){			
			avaliacaoDesempenhoEquipeDAO.atualizar(avaliacaoDesempenhoEquipe);
			request.setAttribute("mensagem", "AVALIAÇÃO DO DESEMPENHO DA EQUIPE: ("+avaliacaoDesempenhoEquipe.getCodigoprojeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - AVALIAÇÃO DO DESEMPENHO DA EQUIPE");
			return "TkcsapcdController?cmd=consultarAvaliacaoDesempenhoEquipe";//Pagina de Retorno (pagina consulta)
	}

}

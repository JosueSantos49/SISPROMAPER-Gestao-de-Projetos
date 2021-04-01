/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.BusinessPlanDetalhe;
import br.com.tkcsapcd.model.dao.InterfaceBusinessPlanDetalheDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarBusinessPlanDetalhe implements InterfaceCommand {

	private InterfaceBusinessPlanDetalheDAO businessPlanDetalheDAO;
	public AtualizarBusinessPlanDetalhe(InterfaceBusinessPlanDetalheDAO businessPlanDetalheDAO) {
		super();
		this.businessPlanDetalheDAO = businessPlanDetalheDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request		
					BusinessPlanDetalhe businessPlanDetalhe = new BusinessPlanDetalhe();
					
					businessPlanDetalhe.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					businessPlanDetalhe.setBusinessplan(request.getParameter("businessplan"));
					businessPlanDetalhe.setProjeto(request.getParameter("projeto"));
					businessPlanDetalhe.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
					businessPlanDetalhe.setVersao(request.getParameter("versao"));
					businessPlanDetalhe.setData(request.getParameter("data"));
					businessPlanDetalhe.setAutor(request.getParameter("autor"));
					businessPlanDetalhe.setNotarevisao(request.getParameter("notarevisao"));
					businessPlanDetalhe.setAprovacao(request.getParameter("aprovacao"));		
					businessPlanDetalhe.setPosicionamento(request.getParameter("posicionamento"));
					businessPlanDetalhe.setEstrategiaproduto(request.getParameter("estrategiaproduto"));
					businessPlanDetalhe.setProdutooferecido(request.getParameter("produtooferecido"));
					businessPlanDetalhe.setServicooferecido(request.getParameter("servicooferecido"));
					businessPlanDetalhe.setPreco(request.getParameter("preco"));
					businessPlanDetalhe.setDistribuicao(request.getParameter("distribuicao"));
					businessPlanDetalhe.setPromocaovenda(request.getParameter("promocaovenda"));
					businessPlanDetalhe.setTecnologia(request.getParameter("tecnologia"));					
					businessPlanDetalhe.setAcao(request.getParameter("acao"));
					businessPlanDetalhe.setProjetoresultado(request.getParameter("projetoresultado"));
					businessPlanDetalhe.setControle(request.getParameter("controle"));
					businessPlanDetalhe.setContigencia(request.getParameter("contigencia"));
		
		if(ValidationHelper.validar(businessPlanDetalhe)){			
			businessPlanDetalheDAO.atualizar(businessPlanDetalhe);
			request.setAttribute("mensagem", "BUSINESS PLAN DETALHES: ("+businessPlanDetalhe.getCodigoprojeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - BUSINESS PLAN DETALHES");
			return "TkcsapcdController?cmd=consultarBusinessPlanDetalhe";//Pagina de Retorno (pagina consulta)
	}

}

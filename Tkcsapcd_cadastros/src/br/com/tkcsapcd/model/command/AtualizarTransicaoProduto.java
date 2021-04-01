/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.TransicaoProduto;
import br.com.tkcsapcd.model.dao.InterfaceTransicaoProdutoDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarTransicaoProduto implements InterfaceCommand {

	private InterfaceTransicaoProdutoDAO transicaoProdutoDAO;
	public AtualizarTransicaoProduto(InterfaceTransicaoProdutoDAO transicaoProdutoDAO) {
		super();
		this.transicaoProdutoDAO = transicaoProdutoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request					
					TransicaoProduto transicaoProduto = new TransicaoProduto();
					
					transicaoProduto.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					transicaoProduto.setTransicaoproduto(request.getParameter("transicaoproduto"));
					transicaoProduto.setProjeto(request.getParameter("projeto"));
					transicaoProduto.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
					transicaoProduto.setVersao(request.getParameter("versao"));
					transicaoProduto.setData(request.getParameter("data"));
					transicaoProduto.setAutor(request.getParameter("autor"));
					transicaoProduto.setNotarevisao(request.getParameter("notarevisao"));
					transicaoProduto.setAprovacao(request.getParameter("aprovacao"));
					transicaoProduto.setObjetivo(request.getParameter("objetivo"));				
					transicaoProduto.setPeriodo(request.getParameter("periodo"));					
					transicaoProduto.setProcedimento(request.getParameter("procedimento"));
					transicaoProduto.setTreinamento(request.getParameter("treinamento"));
					transicaoProduto.setResponsavelprojeto(request.getParameter("responsavelprojeto"));
					transicaoProduto.setResponsaveloperacao(request.getParameter("responsaveloperacao"));
					transicaoProduto.setPontoaberto(request.getParameter("pontoaberto"));
					transicaoProduto.setRecomendacao(request.getParameter("recomendacao"));
		
		if(ValidationHelper.validar(transicaoProduto)){			
			transicaoProdutoDAO.atualizar(transicaoProduto);
			request.setAttribute("mensagem", "TRANSIÇÃO DO PRODUTO: ("+transicaoProduto.getCodigoprojeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - TRANSIÇÃO DO PRODUTO");
			return "TkcsapcdController?cmd=consultarTransicaoProduto";//Pagina de Retorno (pagina consulta)
	}

}

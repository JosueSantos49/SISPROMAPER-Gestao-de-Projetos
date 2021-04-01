/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.ListaQualidade;
import br.com.tkcsapcd.model.dao.InterfaceListaQualidadeDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarListaQualidade implements InterfaceCommand {

	private InterfaceListaQualidadeDAO listaQualidadeDAO;
	public AtualizarListaQualidade(InterfaceListaQualidadeDAO listaQualidadeDAO) {
		super();
		this.listaQualidadeDAO = listaQualidadeDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request					
					ListaQualidade listaQualidade = new ListaQualidade();
					
					listaQualidade.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					listaQualidade.setListaqualiade(request.getParameter("listaqualiade"));
					listaQualidade.setProjeto(request.getParameter("projeto"));
					listaQualidade.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
					listaQualidade.setVersao(request.getParameter("versao"));
					listaQualidade.setData(request.getParameter("data"));
					listaQualidade.setAutor(request.getParameter("autor"));
					listaQualidade.setNotarevisao(request.getParameter("notarevisao"));
					listaQualidade.setAprovacao(request.getParameter("aprovacao"));
					listaQualidade.setProduto(request.getParameter("produto"));				
					listaQualidade.setRequsito(request.getParameter("requsito"));					
					listaQualidade.setCriterio(request.getParameter("criterio"));
					listaQualidade.setMetodo(request.getParameter("metodo"));
		
		if(ValidationHelper.validar(listaQualidade)){			
			listaQualidadeDAO.atualizar(listaQualidade);
			request.setAttribute("mensagem", "Lista de Verificação da Qualidade: ("+listaQualidade.getCodigoprojeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - Lista de Verificação da Qualidade");
			return "TkcsapcdController?cmd=consultarListaQualidade";//Pagina de Retorno (pagina consulta)
	}

}

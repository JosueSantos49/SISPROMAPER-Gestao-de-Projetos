/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.ListaMarcos;
import br.com.tkcsapcd.model.dao.InterfaceListaMarcosDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;

//Método registrado na InterfaceCommand
public class AtualizarListaMarcos implements InterfaceCommand {

	private InterfaceListaMarcosDAO listaMarcosDAO;
	public AtualizarListaMarcos(InterfaceListaMarcosDAO listaMarcosDAO) {
		super();
		this.listaMarcosDAO = listaMarcosDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request
					ListaMarcos listaMarcos = new ListaMarcos();
					
					listaMarcos.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					listaMarcos.setListamarcos(request.getParameter("listamarcos"));
					listaMarcos.setProjeto(request.getParameter("projeto"));
					listaMarcos.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
					listaMarcos.setVersao(request.getParameter("versao"));
					listaMarcos.setData(request.getParameter("data"));
					listaMarcos.setAutor(request.getParameter("autor"));
					listaMarcos.setNotarevisao(request.getParameter("notarevisao"));
					listaMarcos.setAprovacao(request.getParameter("aprovacao"));
					listaMarcos.setObjetivo(request.getParameter("objetivo"));				
					listaMarcos.setFases(request.getParameter("fases"));
		
		if(ValidationHelper.validar(listaMarcos)){			
			listaMarcosDAO.atualizar(listaMarcos);
			request.setAttribute("mensagem", "Lista dos Marcos: ("+listaMarcos.getCodigoprojeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - Lista dos Marcos");
			return "TkcsapcdController?cmd=consultarListaMarcos";//Pagina de Retorno (pagina consulta)
	}

}

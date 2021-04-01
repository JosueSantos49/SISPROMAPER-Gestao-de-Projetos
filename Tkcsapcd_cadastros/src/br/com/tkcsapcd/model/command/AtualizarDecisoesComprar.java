/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.DecisoesComprar;
import br.com.tkcsapcd.model.dao.InterfaceDecisoesComprarDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//M�todo registrado na InterfaceCommand
public class AtualizarDecisoesComprar implements InterfaceCommand {

	private InterfaceDecisoesComprarDAO decisoesComprarDAO;
	public AtualizarDecisoesComprar(InterfaceDecisoesComprarDAO decisoesComprarDAO) {
		super();
		this.decisoesComprarDAO = decisoesComprarDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request	
					DecisoesComprar decisoesComprar = new DecisoesComprar();
					
					decisoesComprar.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa citua��o
					decisoesComprar.setImportancia(Integer.valueOf(request.getParameter("importancia")));
					decisoesComprar.setCodigoeap(Integer.valueOf(request.getParameter("codigoeap")));
					decisoesComprar.setItens(request.getParameter("itens"));
					decisoesComprar.setUrgencia(request.getParameter("urgencia"));
					decisoesComprar.setImpacto(request.getParameter("impacto"));
					decisoesComprar.setMotivodecisao(request.getParameter("motivodecisao"));
					decisoesComprar.setFornecedores(request.getParameter("fornecedores"));
					decisoesComprar.setQuantidade(Integer.valueOf(request.getParameter("quantidade")));
					decisoesComprar.setCusto(request.getParameter("custo").equals("") ? null : Double.valueOf(request.getParameter("custo")));
					decisoesComprar.setPrevisao(request.getParameter("previsao"));					
					decisoesComprar.setDocaquisicao(request.getParameter("docaquisicao"));
					decisoesComprar.setDescricao(request.getParameter("descricao"));
					decisoesComprar.setTipocontrato(request.getParameter("tipocontrato"));
					decisoesComprar.setStatus(request.getParameter("status"));
					decisoesComprar.setComentarios(request.getParameter("comentarios"));
		
		if(ValidationHelper.validar(decisoesComprar)){			
			decisoesComprarDAO.atualizar(decisoesComprar);
			request.setAttribute("mensagem", "Decis�es de Comprar: ("+decisoesComprar.getCodigoeap()+") atualizado com sucesso!");
		}
		else{
			throw new Exception("Valor inv�lido");
		}	
		} catch (SQLException e) {
			
			request.setAttribute("mensagem", "Problema com a atualiza��o: "+e.getMessage());
			e.printStackTrace();
			
		}catch (NumberFormatException e) {
			request.setAttribute("mensagem", "Valor inv�lido: "+e.getMessage());			
		}	
			request.setAttribute("titulo", "Atualiza��o - Decis�es de Comprar");
			return "TkcsapcdController?cmd=consultarDecisoesComprar";//Pagina de Retorno (pagina consulta)
	}

}

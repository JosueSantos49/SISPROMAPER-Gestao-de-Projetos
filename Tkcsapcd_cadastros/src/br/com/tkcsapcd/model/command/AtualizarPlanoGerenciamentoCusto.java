/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoCusto;
import br.com.tkcsapcd.model.dao.InterfacePlanoGerenciamentoCustoDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarPlanoGerenciamentoCusto implements InterfaceCommand {

	private InterfacePlanoGerenciamentoCustoDAO planoGerenciamentoCustoDAO;
	public AtualizarPlanoGerenciamentoCusto(InterfacePlanoGerenciamentoCustoDAO planoGerenciamentoCustoDAO) {
		super();
		this.planoGerenciamentoCustoDAO = planoGerenciamentoCustoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request					
			PlanoGerenciamentoCusto planoGerenciamentoCusto = new PlanoGerenciamentoCusto();
			
			planoGerenciamentoCusto.setCodigo(Integer.valueOf(request.getParameter("codigo")));
			planoGerenciamentoCusto.setPlanogerenciamentocusto(request.getParameter("planogerenciamentocusto"));
			planoGerenciamentoCusto.setProjeto(request.getParameter("projeto"));
			planoGerenciamentoCusto.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			planoGerenciamentoCusto.setVersao(request.getParameter("versao"));
			planoGerenciamentoCusto.setData(request.getParameter("data"));
			planoGerenciamentoCusto.setAutor(request.getParameter("autor"));
			planoGerenciamentoCusto.setNotarevisao(request.getParameter("notarevisao"));
			planoGerenciamentoCusto.setAprovacao(request.getParameter("aprovacao"));
			planoGerenciamentoCusto.setObjetivo(request.getParameter("objetivo"));				
			planoGerenciamentoCusto.setMetodo(request.getParameter("metodo"));					
			planoGerenciamentoCusto.setProcesso(request.getParameter("processo"));
			planoGerenciamentoCusto.setDocumento(request.getParameter("documento"));
			planoGerenciamentoCusto.setFerramenta(request.getParameter("ferramenta"));
			planoGerenciamentoCusto.setPapeis(request.getParameter("papeis"));
			planoGerenciamentoCusto.setPlano(request.getParameter("plano"));
			planoGerenciamentoCusto.setCusto(request.getParameter("custo"));
			planoGerenciamentoCusto.setOrcamento(request.getParameter("orcamento"));
			planoGerenciamentoCusto.setControlarcusto(request.getParameter("controlarcusto"));
		
		if(ValidationHelper.validar(planoGerenciamentoCusto)){			
			planoGerenciamentoCustoDAO.atualizar(planoGerenciamentoCusto);
			request.setAttribute("mensagem", "PLANO DE GERENCIAMENTO DOS CUSTOS: ("+planoGerenciamentoCusto.getCodigoprojeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - PLANO DE GERENCIAMENTO DOS CUSTOS");
			return "TkcsapcdController?cmd=consultarPlanoGerenciamentoCusto";//Pagina de Retorno (pagina consulta)
	}

}

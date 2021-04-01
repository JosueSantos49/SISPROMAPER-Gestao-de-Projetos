/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoPessoal;
import br.com.tkcsapcd.model.dao.InterfacePlanoGerenciamentoPessoalDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarPlanoGerenciamentoPessoal implements InterfaceCommand {

	private InterfacePlanoGerenciamentoPessoalDAO planoGerenciamentoPessoalDAO;
	public AtualizarPlanoGerenciamentoPessoal(InterfacePlanoGerenciamentoPessoalDAO planoGerenciamentoPessoalDAO) {
		super();
		this.planoGerenciamentoPessoalDAO = planoGerenciamentoPessoalDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request					
					PlanoGerenciamentoPessoal planoGerenciamentoPessoal = new PlanoGerenciamentoPessoal();
					
					planoGerenciamentoPessoal.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					planoGerenciamentoPessoal.setPlanogerenciamentopessoal(request.getParameter("planogerenciamentopessoal"));
					planoGerenciamentoPessoal.setProjeto(request.getParameter("projeto"));
					planoGerenciamentoPessoal.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
					planoGerenciamentoPessoal.setVersao(request.getParameter("versao"));
					planoGerenciamentoPessoal.setData(request.getParameter("data"));
					planoGerenciamentoPessoal.setAutor(request.getParameter("autor"));
					planoGerenciamentoPessoal.setNotarevisao(request.getParameter("notarevisao"));
					planoGerenciamentoPessoal.setAprovacao(request.getParameter("aprovacao"));
					planoGerenciamentoPessoal.setPergunta1(request.getParameter("pergunta1"));
					planoGerenciamentoPessoal.setPergunta2(request.getParameter("pergunta2"));
					planoGerenciamentoPessoal.setPergunta3(request.getParameter("pergunta3"));
					planoGerenciamentoPessoal.setPergunta4(request.getParameter("pergunta4"));
					planoGerenciamentoPessoal.setPergunta5(request.getParameter("pergunta5"));
					planoGerenciamentoPessoal.setPergunta6(request.getParameter("pergunta6"));
					planoGerenciamentoPessoal.setPergunta7(request.getParameter("pergunta7"));
		
		if(ValidationHelper.validar(planoGerenciamentoPessoal)){			
			planoGerenciamentoPessoalDAO.atualizar(planoGerenciamentoPessoal);
			request.setAttribute("mensagem", "PLANO DE GERENCIAMENTO DO PESSOAL: ("+planoGerenciamentoPessoal.getCodigoprojeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - PLANO DE GERENCIAMENTO DO PESSOAL");
			return "TkcsapcdController?cmd=consultarPlanoGerenciamentoPessoal";//Pagina de Retorno (pagina consulta)
	}

}

/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.MatrizComunicacao;
import br.com.tkcsapcd.model.dao.InterfaceMatrizComunicacaoDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//M�todo registrado na InterfaceCommand
public class AtualizarMatrizComunicacao implements InterfaceCommand {

	private InterfaceMatrizComunicacaoDAO matrizComunicacaoDAO;
	public AtualizarMatrizComunicacao(InterfaceMatrizComunicacaoDAO matrizComunicacaoDAO) {
		super();
		this.matrizComunicacaoDAO = matrizComunicacaoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request					
					MatrizComunicacao matrizComunicacao = new MatrizComunicacao();
					
					matrizComunicacao.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa citua��o
					matrizComunicacao.setCodigomatriz(Integer.valueOf(request.getParameter("codigomatriz")));
					matrizComunicacao.setPergunta1(request.getParameter("pergunta1"));
					matrizComunicacao.setPergunta2(request.getParameter("pergunta2"));
					matrizComunicacao.setPergunta3(request.getParameter("pergunta3"));
					matrizComunicacao.setPergunta4(request.getParameter("pergunta4"));
					matrizComunicacao.setPergunta5(request.getParameter("pergunta5"));
					matrizComunicacao.setPergunta6(request.getParameter("pergunta6"));
					matrizComunicacao.setPergunta7(request.getParameter("pergunta7"));
					matrizComunicacao.setPergunta8(request.getParameter("pergunta8"));
					matrizComunicacao.setComentario(request.getParameter("comentario"));
		
		if(ValidationHelper.validar(matrizComunicacao)){			
			matrizComunicacaoDAO.atualizar(matrizComunicacao);
			request.setAttribute("mensagem", "MATRIZ DAS COMUNICA��ES: ("+matrizComunicacao.getCodigomatriz()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualiza��o - MATRIZ DAS COMUNICA��ES");
			return "TkcsapcdController?cmd=consultarMatrizComunicacao";//Pagina de Retorno (pagina consulta)
	}

}

/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.DeclaracaoTrabalho;
import br.com.tkcsapcd.model.dao.InterfaceDeclaracaoTrabalhoDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarDeclaracaoTrabalho implements InterfaceCommand {

	private InterfaceDeclaracaoTrabalhoDAO declaracaoTrabalhoDAO;
	public AtualizarDeclaracaoTrabalho(InterfaceDeclaracaoTrabalhoDAO declaracaoTrabalhoDAO) {
		super();
		this.declaracaoTrabalhoDAO = declaracaoTrabalhoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request					
					DeclaracaoTrabalho declaracaoTrabalho = new DeclaracaoTrabalho();
					
					declaracaoTrabalho.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					declaracaoTrabalho.setDeclaracaotrabalho(request.getParameter("declaracaotrabalho"));
					declaracaoTrabalho.setProjeto(request.getParameter("projeto"));
					declaracaoTrabalho.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
					declaracaoTrabalho.setVersao(request.getParameter("versao"));
					declaracaoTrabalho.setData(request.getParameter("data"));
					declaracaoTrabalho.setAutor(request.getParameter("autor"));
					declaracaoTrabalho.setNotarevisao(request.getParameter("notarevisao"));
					declaracaoTrabalho.setAprovacao(request.getParameter("aprovacao"));
					declaracaoTrabalho.setObjetivo(request.getParameter("objetivo"));				
					declaracaoTrabalho.setEscopo(request.getParameter("escopo"));					
					declaracaoTrabalho.setCronograma(request.getParameter("cronograma"));
					declaracaoTrabalho.setPadrao(request.getParameter("padrao"));
					declaracaoTrabalho.setRequisito(request.getParameter("requisitoespecial"));
					declaracaoTrabalho.setLocal(request.getParameter("local"));
					declaracaoTrabalho.setPeriodo(request.getParameter("periodo"));
					declaracaoTrabalho.setRequisitoespecial(request.getParameter("requisitoespecial"));
		
		if(ValidationHelper.validar(declaracaoTrabalho)){			
			declaracaoTrabalhoDAO.atualizar(declaracaoTrabalho);
			request.setAttribute("mensagem", "DECLARAÇÃO DE TRABALHO: ("+declaracaoTrabalho.getCodigoprojeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - DECLARAÇÃO DE TRABALHO");
			return "TkcsapcdController?cmd=consultarDeclaracaoTrabalho";//Pagina de Retorno (pagina consulta)
	}

}

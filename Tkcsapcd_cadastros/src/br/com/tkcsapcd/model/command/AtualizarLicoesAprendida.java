/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.LicoesAprendida;
import br.com.tkcsapcd.model.dao.InterfaceLicoesAprendidaDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//M�todo registrado na InterfaceCommand
public class AtualizarLicoesAprendida implements InterfaceCommand {

	private InterfaceLicoesAprendidaDAO licoesAprendidaDAO;	
	public AtualizarLicoesAprendida(InterfaceLicoesAprendidaDAO licoesAprendidaDAO) {
		super();
		this.licoesAprendidaDAO = licoesAprendidaDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request
					LicoesAprendida licoesAprendida = new LicoesAprendida();
					
					licoesAprendida.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa citua��o
					licoesAprendida.setEmpresa(request.getParameter("empresa"));
					licoesAprendida.setOrgao(request.getParameter("orgao"));
					licoesAprendida.setSetor(request.getParameter("setor"));
					licoesAprendida.setPrograma(request.getParameter("programa"));
					licoesAprendida.setProjeto(request.getParameter("projeto"));
					licoesAprendida.setGerente(request.getParameter("gerente"));
					licoesAprendida.setFuncao(request.getParameter("funcao"));
					licoesAprendida.setAprovado(request.getParameter("aprovado"));
					licoesAprendida.setVersao(request.getParameter("versao"));				
					licoesAprendida.setDataaprovacao(request.getParameter("dataaprovacao"));					
					licoesAprendida.setPergunta1(request.getParameter("pergunta1"));
					licoesAprendida.setPergunta2(request.getParameter("pergunta2"));
					licoesAprendida.setPergunta3(request.getParameter("pergunta3"));
					licoesAprendida.setPergunta4(request.getParameter("pergunta4"));
					licoesAprendida.setPergunta5(request.getParameter("pergunta5"));
					licoesAprendida.setPergunta6(request.getParameter("pergunta6"));
					licoesAprendida.setPergunta7(request.getParameter("pergunta7"));
					licoesAprendida.setPergunta8(request.getParameter("pergunta8"));
					licoesAprendida.setPergunta9(request.getParameter("pergunta9"));
					licoesAprendida.setPergunta10(request.getParameter("pergunta10"));
					licoesAprendida.setPergunta11(request.getParameter("pergunta11"));
					licoesAprendida.setPergunta12(request.getParameter("pergunta12"));
					licoesAprendida.setPergunta13(request.getParameter("pergunta13"));
					licoesAprendida.setPergunta14(request.getParameter("pergunta14"));
					licoesAprendida.setPergunta15(request.getParameter("pergunta15"));
					licoesAprendida.setPergunta16(request.getParameter("pergunta16"));
					licoesAprendida.setPergunta17(request.getParameter("pergunta17"));
					licoesAprendida.setCodigoprojeto(request.getParameter("codigoprojeto"));
		
		if(ValidationHelper.validar(licoesAprendida)){			
			licoesAprendidaDAO.atualizar(licoesAprendida);
			request.setAttribute("mensagem", "Li��es Aprendidas: ("+licoesAprendida.getCodigoprojeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualiza��o - Li��es Aprendidas");
			return "TkcsapcdController?cmd=consultarLicoesAprendida";//Pagina de Retorno (pagina consulta)
	}

}

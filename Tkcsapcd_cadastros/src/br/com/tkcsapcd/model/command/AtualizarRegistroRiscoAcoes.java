/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.RegistroRiscoAcoes;
import br.com.tkcsapcd.model.dao.InterfaceRegistroRiscoAcoesDAO;
import br.com.tkcsapcd.model.dao.InterfaceRegistroRiscoDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarRegistroRiscoAcoes implements InterfaceCommand {

	private InterfaceRegistroRiscoAcoesDAO resgistroRiscoAcoesDAO;
	private InterfaceRegistroRiscoDAO registroRiscoDAO;
	public AtualizarRegistroRiscoAcoes(InterfaceRegistroRiscoAcoesDAO resgistroRiscoAcoesDAO, InterfaceRegistroRiscoDAO registroRiscoDAO) {
		super();
		this.resgistroRiscoAcoesDAO = resgistroRiscoAcoesDAO;
		this.registroRiscoDAO = registroRiscoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request					
					RegistroRiscoAcoes registroRiscoAcoes = new RegistroRiscoAcoes();
					
					registroRiscoAcoes.setCodigo(Long.valueOf(request.getParameter("codigo")));
					registroRiscoAcoes.setRegistroriscoacoes(request.getParameter("registroriscoacoes"));
					registroRiscoAcoes.setReferencia(request.getParameter("referencia"));
					registroRiscoAcoes.setPassos(request.getParameter("passos"));
					registroRiscoAcoes.setVersao(request.getParameter("versao"));

					String data_1 = request.getParameter("data"); 
					Date data = new SimpleDateFormat("yyyy-MM-dd").parse(data_1);
					registroRiscoAcoes.setData(data);
					
					registroRiscoAcoes.setAutor(request.getParameter("autor"));
					registroRiscoAcoes.setNotarevisao(request.getParameter("notarevisao"));
					registroRiscoAcoes.setPrioridade(request.getParameter("prioridade"));
					registroRiscoAcoes.setDescricaorisco(request.getParameter("descricaorisco"));				
					registroRiscoAcoes.setDescricaoacao(request.getParameter("descricaoacao"));					
					registroRiscoAcoes.setResponsavel(request.getParameter("responsavel"));
					registroRiscoAcoes.setPrevisao(request.getParameter("previsao"));
					registroRiscoAcoes.setStatus(request.getParameter("status"));
					registroRiscoAcoes.setPrevisaooriginal(request.getParameter("previsaooriginal"));
					registroRiscoAcoes.setComentario(request.getParameter("descricaoacao"));
					
					Integer registrorisco = Integer.valueOf(request.getParameter("registrorisco"));			
					registroRiscoAcoes.setRegistrorisco(registroRiscoDAO.getRegistroRisco(registrorisco));
		
		if(ValidationHelper.validar(registroRiscoAcoes)){			
			resgistroRiscoAcoesDAO.atualizar(registroRiscoAcoes);
			request.setAttribute("mensagem", "REGISTRO DOS RISCOS AÇÕES: ("+registroRiscoAcoes.getRegistrorisco().getRegistrorisco()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - REGISTRO DOS RISCOS AÇÕES");
			return "TkcsapcdController?cmd=consultarRegistroRiscoAcoes";//Pagina de Retorno (pagina consulta)
	}

}

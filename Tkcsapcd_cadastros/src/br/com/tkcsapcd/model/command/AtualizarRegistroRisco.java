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

import br.com.tkcsapcd.model.bean.RegistroRisco;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.dao.InterfaceRegistroRiscoDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarRegistroRisco implements InterfaceCommand {

	private InterfaceRegistroRiscoDAO resgistroRiscoDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	public AtualizarRegistroRisco(InterfaceRegistroRiscoDAO resgistroRiscoDAO, InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.resgistroRiscoDAO = resgistroRiscoDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request					
					RegistroRisco registroRisco = new RegistroRisco();
					
					registroRisco.setCodigo(Long.valueOf(request.getParameter("codigo")));
					registroRisco.setRegistrorisco(request.getParameter("registrorisco"));
					registroRisco.setReferencia(request.getParameter("referencia"));
					registroRisco.setPassos(request.getParameter("passos"));
					registroRisco.setVersao(request.getParameter("versao"));
					
					String data_1 = request.getParameter("data"); 
					Date data = new SimpleDateFormat("yyyy-MM-dd").parse(data_1);
					registroRisco.setData(data);
					
					registroRisco.setAutor(request.getParameter("autor"));
					registroRisco.setNotarevisao(request.getParameter("notarevisao"));
					registroRisco.setSeveridade(Integer.valueOf(request.getParameter("severidade")));
					registroRisco.setDescricao(request.getParameter("descricao"));				
					registroRisco.setProbabilidade(request.getParameter("probabilidade"));					
					registroRisco.setImpacto(request.getParameter("impacto"));
					registroRisco.setDescricaoimpacto(request.getParameter("descricaoimpacto"));
					registroRisco.setCategoria(request.getParameter("categoria"));
					registroRisco.setAcao(request.getParameter("acao"));
					registroRisco.setDescricaoacao(request.getParameter("descricaoacao"));
					registroRisco.setResponsavel(request.getParameter("responsavel"));
					registroRisco.setPrevisao(request.getParameter("previsao"));
					registroRisco.setComentario(request.getParameter("comentario"));
					
					Integer projetoinicio = Integer.valueOf(request.getParameter("projetoinicio"));										
					registroRisco.setProjetoinicio(projetoInicioDAO.getProjetoInicio(projetoinicio));
		
		if(ValidationHelper.validar(registroRisco)){			
			resgistroRiscoDAO.atualizar(registroRisco);
			request.setAttribute("mensagem", "REGISTRO DOS RISCOS: ("+registroRisco.getProjetoinicio().getProjeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - REGISTRO DOS RISCOS");
			return "TkcsapcdController?cmd=consultarRegistroRisco";//Pagina de Retorno (pagina consulta)
	}

}

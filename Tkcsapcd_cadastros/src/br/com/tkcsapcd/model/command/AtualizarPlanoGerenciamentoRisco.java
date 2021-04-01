/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoRisco;
import br.com.tkcsapcd.model.dao.InterfacePlanoGerenciamentoRiscoDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarPlanoGerenciamentoRisco implements InterfaceCommand {

	private InterfacePlanoGerenciamentoRiscoDAO planoGerenciamentoRiscoDAO;
	public AtualizarPlanoGerenciamentoRisco(InterfacePlanoGerenciamentoRiscoDAO planoGerenciamentoRiscoDAO) {
		super();
		this.planoGerenciamentoRiscoDAO = planoGerenciamentoRiscoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request					
					PlanoGerenciamentoRisco planoGerenciamentoRisco = new PlanoGerenciamentoRisco();
					
					planoGerenciamentoRisco.setCodigo(Integer.valueOf(request.getParameter("codigo")));
					planoGerenciamentoRisco.setPlanogerenciamentorisco(request.getParameter("planogerenciamentorisco"));
					planoGerenciamentoRisco.setProjeto(request.getParameter("projeto"));
					planoGerenciamentoRisco.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
					planoGerenciamentoRisco.setVersao(request.getParameter("versao"));
					planoGerenciamentoRisco.setData(request.getParameter("data"));
					planoGerenciamentoRisco.setAutor(request.getParameter("autor"));
					planoGerenciamentoRisco.setNotarevisao(request.getParameter("notarevisao"));
					planoGerenciamentoRisco.setAprovacao(request.getParameter("aprovacao"));
					planoGerenciamentoRisco.setObjetivo(request.getParameter("objetivo"));				
					planoGerenciamentoRisco.setGerenciamento(request.getParameter("gerenciamento"));					
					planoGerenciamentoRisco.setProcesso(request.getParameter("processo"));
					planoGerenciamentoRisco.setDocumento(request.getParameter("documento"));
					planoGerenciamentoRisco.setResponsabilidade(request.getParameter("responsabilidade"));
					planoGerenciamentoRisco.setIdentificar(request.getParameter("identificar"));
					planoGerenciamentoRisco.setEar(request.getParameter("ear"));
					planoGerenciamentoRisco.setRiscos(request.getParameter("riscos"));
					planoGerenciamentoRisco.setAnalisequalitativa(request.getParameter("analisequalitativa"));
					planoGerenciamentoRisco.setDefinicao(request.getParameter("definicao"));					
					planoGerenciamentoRisco.setAnalisequantitativa(request.getParameter("analisequantitativa"));
					planoGerenciamentoRisco.setPlanejar(request.getParameter("planejar"));
					planoGerenciamentoRisco.setReservas(request.getParameter("reservas"));
					planoGerenciamentoRisco.setControlar(request.getParameter("controlar"));
		
		if(ValidationHelper.validar(planoGerenciamentoRisco)){			
			planoGerenciamentoRiscoDAO.atualizar(planoGerenciamentoRisco);
			request.setAttribute("mensagem", "PLANO DE GERENCIAMENTO DOS RISCOS: ("+planoGerenciamentoRisco.getCodigoprojeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - PLANO DE GERENCIAMENTO DOS RISCOS");
			return "TkcsapcdController?cmd=consultarPlanoGerenciamentoRisco";//Pagina de Retorno (pagina consulta)
	}

}

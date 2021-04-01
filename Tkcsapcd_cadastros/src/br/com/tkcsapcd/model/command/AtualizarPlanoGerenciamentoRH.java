/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoRH;
import br.com.tkcsapcd.model.dao.InterfacePlanoGerenciamentoRHDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarPlanoGerenciamentoRH implements InterfaceCommand {

	private InterfacePlanoGerenciamentoRHDAO planoGerenciamentoRHDAO;
	public AtualizarPlanoGerenciamentoRH(InterfacePlanoGerenciamentoRHDAO planoGerenciamentoRHDAO) {
		super();
		this.planoGerenciamentoRHDAO = planoGerenciamentoRHDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request					
					PlanoGerenciamentoRH planoGerenciamentoRH = new PlanoGerenciamentoRH();
					
					planoGerenciamentoRH.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação					
					planoGerenciamentoRH.setPlanogerenciamentorh(request.getParameter("planogerenciamentorh"));
					planoGerenciamentoRH.setProjeto(request.getParameter("projeto"));
					planoGerenciamentoRH.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
					planoGerenciamentoRH.setVersao(request.getParameter("versao"));
					planoGerenciamentoRH.setData(request.getParameter("data"));
					planoGerenciamentoRH.setAutor(request.getParameter("autor"));
					planoGerenciamentoRH.setNotarevisao(request.getParameter("notarevisao"));
					planoGerenciamentoRH.setAprovacao(request.getParameter("aprovacao"));
					planoGerenciamentoRH.setObjetivo(request.getParameter("objetivo"));				
					planoGerenciamentoRH.setMetodo(request.getParameter("metodo"));					
					planoGerenciamentoRH.setProcesso(request.getParameter("processo"));
					planoGerenciamentoRH.setDocumento(request.getParameter("documento"));
					planoGerenciamentoRH.setFerramenta(request.getParameter("ferramenta"));
					planoGerenciamentoRH.setOrganograma(request.getParameter("organograma"));
					planoGerenciamentoRH.setPapeis(request.getParameter("papeis"));
					planoGerenciamentoRH.setPlanogerenciamento(request.getParameter("planogerenciamento"));
					planoGerenciamentoRH.setMobilizacao(request.getParameter("mobilizacao"));
					planoGerenciamentoRH.setCalendario(request.getParameter("calendario"));					
					planoGerenciamentoRH.setPlanoliberacao(request.getParameter("planoliberacao"));
					planoGerenciamentoRH.setNecessidade(request.getParameter("necessidade"));
					planoGerenciamentoRH.setReconhecimento(request.getParameter("reconhecimento"));
					planoGerenciamentoRH.setConformidade(request.getParameter("conformidade"));	
					planoGerenciamentoRH.setSeguranca(request.getParameter("seguranca"));
		
		if(ValidationHelper.validar(planoGerenciamentoRH)){			
			planoGerenciamentoRHDAO.atualizar(planoGerenciamentoRH);
			request.setAttribute("mensagem", "PLANO DE GERENCIAMENTO DA RH: ("+planoGerenciamentoRH.getCodigoprojeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - PLANO DE GERENCIAMENTO DA RH");
			return "TkcsapcdController?cmd=consultarPlanoGerenciamentoRH";//Pagina de Retorno (pagina consulta)
	}

}

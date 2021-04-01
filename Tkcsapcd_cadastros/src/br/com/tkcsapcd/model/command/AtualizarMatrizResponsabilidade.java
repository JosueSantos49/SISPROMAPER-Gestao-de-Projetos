/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.MatrizResponsabilidade;
import br.com.tkcsapcd.model.dao.InterfaceMatrizResponsabilidadeDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarMatrizResponsabilidade implements InterfaceCommand {

	private InterfaceMatrizResponsabilidadeDAO matrizResponsabilidadeDAO;
	
	public AtualizarMatrizResponsabilidade(InterfaceMatrizResponsabilidadeDAO matrizResponsabilidadeDAO) {
		super();
		this.matrizResponsabilidadeDAO = matrizResponsabilidadeDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
			MatrizResponsabilidade matrizResponsabilidade = new MatrizResponsabilidade();// Codigo de processamento

			matrizResponsabilidade.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
			matrizResponsabilidade.setCodigoeap(Integer.valueOf(request.getParameter("codigoeap")));
			matrizResponsabilidade.setAtividade(request.getParameter("atividade"));
			matrizResponsabilidade.setDescricao(request.getParameter("descricao"));
			matrizResponsabilidade.setResponsavel(request.getParameter("responsavel"));
			matrizResponsabilidade.setAprovar(request.getParameter("aprovar"));
			matrizResponsabilidade.setConsultado(request.getParameter("consultado"));
			matrizResponsabilidade.setInformado(request.getParameter("informado"));
			matrizResponsabilidade.setParticipante(request.getParameter("participante"));
			
		if(ValidationHelper.validar(matrizResponsabilidade)){		
			matrizResponsabilidadeDAO.atualizar(matrizResponsabilidade);
			request.setAttribute("mensagem", "Matriz de Responsabilidade RACI: ("+matrizResponsabilidade.getCodigoeap()+") atualizado com sucesso!");
		}else{
				throw new Exception("Valor inválido");
		}	
		} catch (SQLException e) {
			
			request.setAttribute("mensagem", "Problema com a atualização: "+e.getMessage());
			e.printStackTrace();
			
		}catch (NumberFormatException e) {
			request.setAttribute("mensagem", "Valor inválido: "+e.getMessage());			
		}	
			request.setAttribute("titulo", "Atualização - Matriz de Responsabilidade RACI");
			return "TkcsapcdController?cmd=consultarMatrizResponsabilidade";//Pagina de Retorno (pagina consulta cliente)
	}

}

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

import br.com.tkcsapcd.model.bean.MatrizRastreabilidadeRequisito;
import br.com.tkcsapcd.model.dao.InterfaceMatrizRastreabilidadeRequisitoDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarMatrizRastreabilidadeRequisito implements InterfaceCommand {

	private InterfaceMatrizRastreabilidadeRequisitoDAO matrizRastreabilidadeRequisitoDAO;
	public AtualizarMatrizRastreabilidadeRequisito(InterfaceMatrizRastreabilidadeRequisitoDAO matrizRastreabilidadeRequisitoDAO) {
		super();
		this.matrizRastreabilidadeRequisitoDAO = matrizRastreabilidadeRequisitoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request					
					MatrizRastreabilidadeRequisito matrizRastreabilidadeRequisito = new MatrizRastreabilidadeRequisito();
					
					matrizRastreabilidadeRequisito.setCodigo(Long.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					matrizRastreabilidadeRequisito.setCodigomatriz(Integer.valueOf(request.getParameter("codigomatriz")));
					matrizRastreabilidadeRequisito.setPrioridade(request.getParameter("prioridade"));
					matrizRastreabilidadeRequisito.setTipo(request.getParameter("tipo"));
					matrizRastreabilidadeRequisito.setNome(request.getParameter("nome"));
					matrizRastreabilidadeRequisito.setDescricao(request.getParameter("descricao"));
					matrizRastreabilidadeRequisito.setJustificativa(request.getParameter("justificativa"));
					matrizRastreabilidadeRequisito.setCriterio(request.getParameter("criterio"));
					matrizRastreabilidadeRequisito.setSolicitante(request.getParameter("solicitante"));
					matrizRastreabilidadeRequisito.setStatus(request.getParameter("status"));
					
					String data_1 = request.getParameter("data"); 
					Date data = new SimpleDateFormat("yyyy-MM-dd").parse(data_1);
					matrizRastreabilidadeRequisito.setData(data);
					
					matrizRastreabilidadeRequisito.setEap(request.getParameter("eap"));					
					matrizRastreabilidadeRequisito.setId(Integer.valueOf(request.getParameter("id")));
					matrizRastreabilidadeRequisito.setComentario(request.getParameter("comentario"));
		
		if(ValidationHelper.validar(matrizRastreabilidadeRequisito)){			
			matrizRastreabilidadeRequisitoDAO.atualizar(matrizRastreabilidadeRequisito);
			request.setAttribute("mensagem", "MATRIZ DE RASTREABILIDADE DOS REQUISITOS: ("+matrizRastreabilidadeRequisito.getCodigomatriz()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - MATRIZ DE RASTREABILIDADE DOS REQUISITOS");
			return "TkcsapcdController?cmd=consultarMatrizRastreabilidadeRequisito";//Pagina de Retorno (pagina consulta)
	}

}

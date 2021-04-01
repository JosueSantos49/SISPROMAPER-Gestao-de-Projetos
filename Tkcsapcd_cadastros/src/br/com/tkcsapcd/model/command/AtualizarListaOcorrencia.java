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

import br.com.tkcsapcd.model.bean.ListaOcorrencia;
import br.com.tkcsapcd.model.dao.InterfaceListaOcorrenciaDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarListaOcorrencia implements InterfaceCommand {

	private InterfaceListaOcorrenciaDAO listaOcorrenciaDAO;	
	public AtualizarListaOcorrencia(InterfaceListaOcorrenciaDAO listaOcorrenciaDAO) {
		super();
		this.listaOcorrenciaDAO = listaOcorrenciaDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
			ListaOcorrencia listaOcorrencia = new ListaOcorrencia();// Codigo de processamento

			listaOcorrencia.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
			
			String data1 = request.getParameter("data"); 
			Date data = new SimpleDateFormat("yyyy-MM-dd").parse(data1);
			listaOcorrencia.setData(data);
			
			listaOcorrencia.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			listaOcorrencia.setCliente(request.getParameter("cliente"));
			listaOcorrencia.setGerente(request.getParameter("gerente"));
			listaOcorrencia.setPreparado(request.getParameter("preparado"));
			listaOcorrencia.setObjetivo(request.getParameter("objetivo"));
			listaOcorrencia.setResumo(request.getParameter("resumo"));
			listaOcorrencia.setIssue(request.getParameter("issue"));
			listaOcorrencia.setSeveridade(request.getParameter("severidade"));
			listaOcorrencia.setUrgencia(request.getParameter("urgencia"));
			listaOcorrencia.setResponsavel(request.getParameter("responsavel"));
			
			String dataocorrencia1 = request.getParameter("dataocorrencia");
			Date dataocorrencia = new SimpleDateFormat("yyyy-MM-dd").parse(dataocorrencia1);
			listaOcorrencia.setDataocorrencia(dataocorrencia);
			
			listaOcorrencia.setConclusao(request.getParameter("conclusao"));
			
					
		if(ValidationHelper.validar(listaOcorrencia)){		
			listaOcorrenciaDAO.atualizar(listaOcorrencia);
			request.setAttribute("mensagem", "Lista Ocorrencia: ("+listaOcorrencia.getCodigoprojeto()+") atualizado com sucesso!");
		}else{
				throw new Exception("Valor inválido");
		}	
		} catch (SQLException e) {
			
			request.setAttribute("mensagem", "Problema com a atualização: "+e.getMessage());
			e.printStackTrace();
			
		}catch (NumberFormatException e) {
			request.setAttribute("mensagem", "Valor inválido: "+e.getMessage());			
		}	
			request.setAttribute("titulo", "Atualização - Lista Ocorrencia");
			return "TkcsapcdController?cmd=consultarListaOcorrencia";//Pagina de Retorno (pagina consulta cliente)
	}

}

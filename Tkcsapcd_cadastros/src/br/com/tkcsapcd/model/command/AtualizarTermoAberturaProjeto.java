/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.TermoAberturaProjeto;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.dao.InterfaceTermoAberturaProjetoDAO;
import br.com.tkcsapcd.model.email.EnviaEmail;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarTermoAberturaProjeto implements InterfaceCommand {

	private InterfaceTermoAberturaProjetoDAO termoAberturaProjetoDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	public AtualizarTermoAberturaProjeto(InterfaceTermoAberturaProjetoDAO termoAberturaProjetoDAO, InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.termoAberturaProjetoDAO = termoAberturaProjetoDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
			TermoAberturaProjeto termoAberturaProjeto = new TermoAberturaProjeto();// Codigo de processamento
			
			termoAberturaProjeto.setCodigo(Long.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
			termoAberturaProjeto.setTermoaberturaprojeto(request.getParameter("termoaberturaprojeto"));
			termoAberturaProjeto.setVersao(request.getParameter("versao"));
			
			String data_1 = request.getParameter("data"); 
			Date data = new SimpleDateFormat("yyyy-MM-dd").parse(data_1);
			termoAberturaProjeto.setData(data);
			
			termoAberturaProjeto.setAutor(request.getParameter("autor"));
			termoAberturaProjeto.setNotarevisao(request.getParameter("notarevisao"));							
			termoAberturaProjeto.setAprovacao(request.getParameter("aprovacao"));
			termoAberturaProjeto.setObjetivo(request.getParameter("objetivo"));
			termoAberturaProjeto.setJustificativa(request.getParameter("justificativa"));
			termoAberturaProjeto.setSmart(request.getParameter("smart"));
			termoAberturaProjeto.setEap(request.getParameter("eap"));							
			termoAberturaProjeto.setRequisito(request.getParameter("requisito"));
			termoAberturaProjeto.setMarco(request.getParameter("marco"));
			termoAberturaProjeto.setParteinteressada(request.getParameter("parteinteressada"));
			termoAberturaProjeto.setRestricao(request.getParameter("restricao"));
			termoAberturaProjeto.setPermissao(request.getParameter("permissao"));
			termoAberturaProjeto.setRisco(request.getParameter("risco"));
			termoAberturaProjeto.setOrcamento(request.getParameter("orcamento"));
			termoAberturaProjeto.setConcordo(request.getParameter("concordo"));
			
			Integer projetoinicio = Integer.valueOf(request.getParameter("projetoinicio"));										
			termoAberturaProjeto.setProjetoinicio(projetoInicioDAO.getProjetoInicio(projetoinicio));
				
		if(ValidationHelper.validar(termoAberturaProjeto)){		
			termoAberturaProjetoDAO.atualizar(termoAberturaProjeto);
			request.setAttribute("mensagem", "Termo de Abertura do Projeto: ("+termoAberturaProjeto.getProjetoinicio().getProjeto()+") atualizado com sucesso!");
			
			/*Regra que objetiva disparar um e-mail automático como confirmação de registro.
			 * O Metodo enviarForm() é responsável, por enviar e-mail de confirmação de envio de formulários.
			 */
			
			//String de 		= request.getParameter("de");
			String para 	= request.getParameter("para");
			String assunto 	= request.getParameter("projetoinicio");
			String mensagem = request.getParameter("objetivo");
			//String lista 	= request.getParameter("lista");
			//String file		= request.getParameter("file");
					
			RequestDispatcher rd = null;
			
			EnviaEmail enviaEmail = new EnviaEmail();
			
				//enviaEmail.setDe(de);
				enviaEmail.setPara(para);
				enviaEmail.setAssunto(assunto);
				enviaEmail.setMensagem(mensagem);			
				//enviaEmail.setLista(lista);		
				//enviaEmail.setFile(file);
			
			boolean enviado = enviaEmail.enviarForm();		
			
			if(enviado)
				request.setAttribute("msg","Enviado confirmação de registro por e-mail!");
			else
				request.setAttribute("msg","Não, enviado cópia de confirmação de registro por e-mail!");				
			
			rd = request.getRequestDispatcher("TkcsapcdController?cmd=consultarTermoAberturaProjeto");
			rd.forward(request, response);
			
		}else{
				throw new Exception("Valor inválido");
		}	
		} catch (SQLException e) {
			
			request.setAttribute("mensagem", "Problema com a atualização: "+e.getMessage());
			e.printStackTrace();
			
		}catch (NumberFormatException e) {
			request.setAttribute("mensagem", "Valor inválido: "+e.getMessage());			
		}	
			request.setAttribute("titulo", "Atualização - Termo de Abertura do Projeto");
			return "TkcsapcdController?cmd=consultarTermoAberturaProjeto";//Pagina de Retorno (pagina consulta cliente)
	}

}

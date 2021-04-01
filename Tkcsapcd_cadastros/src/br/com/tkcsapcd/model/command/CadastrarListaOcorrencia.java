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

public class CadastrarListaOcorrencia implements InterfaceCommand {

	private InterfaceListaOcorrenciaDAO listaOcorrenciaDAO;		
	public CadastrarListaOcorrencia(InterfaceListaOcorrenciaDAO listaOcorrenciaDAO) {
		super();
		this.listaOcorrenciaDAO = listaOcorrenciaDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			ListaOcorrencia listaOcorrencia = new ListaOcorrencia();// Codigo de processamento
			
			String data1 = request.getParameter("data"); 
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(data1);
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
			Date dataocorrencia = new SimpleDateFormat("dd/MM/yyyy").parse(dataocorrencia1);
			listaOcorrencia.setDataocorrencia(dataocorrencia);
			
			listaOcorrencia.setConclusao(request.getParameter("conclusao"));
			
			if(ValidationHelper.validar(listaOcorrencia)){
			/*	
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM listaocorrencia WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("codigoprojeto");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+listaOcorrencia.getCodigoprojeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarProjeto";//devolver p/ editar cadastro	
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					listaOcorrenciaDAO.salvar(listaOcorrencia);
					request.setAttribute("mensagem", "Lista Ocorrencia: ("+listaOcorrencia.getCodigoprojeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}*/
					System.out.println("Aviso 2: O código não é igual!");
					listaOcorrenciaDAO.salvar(listaOcorrencia);
					request.setAttribute("mensagem", "Lista Ocorrencia: ("+listaOcorrencia.getCodigoprojeto()+") cadastrado com sucesso!");			
			}
			else{
				throw new Exception("Valor inválido");
			}
			} catch (SQLException e) {
				
				request.setAttribute("mensagem", "Problemas com a gravação: "+e.getMessage());
				e.printStackTrace();
				
			}catch (NumberFormatException e){
				
				request.setAttribute("mensagem", "Valor inválido: "+e.getMessage());
				e.printStackTrace();
			}
				request.setAttribute("titulo", "Cadastro - Lista Ocorrencia");
				return "TkcsapcdController?cmd=editarListaOcorrencia";//devolver p/ editar cadastro		
	}
}

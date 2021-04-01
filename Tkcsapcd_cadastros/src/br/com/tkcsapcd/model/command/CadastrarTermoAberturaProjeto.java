/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarTermoAberturaProjeto implements InterfaceCommand {
		
	private InterfaceTermoAberturaProjetoDAO termoAberturaProjetoDAO;	
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	public CadastrarTermoAberturaProjeto(InterfaceTermoAberturaProjetoDAO termoAberturaProjetoDAO, InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.termoAberturaProjetoDAO = termoAberturaProjetoDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		
		try {
						
			//  Preencher o Bean com os valores do request
			TermoAberturaProjeto termoAberturaProjeto = new TermoAberturaProjeto();			
						
			termoAberturaProjeto.setTermoaberturaprojeto(request.getParameter("termoaberturaprojeto"));
			termoAberturaProjeto.setVersao(request.getParameter("versao"));
			
			String data_1 = request.getParameter("data"); 
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(data_1);
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
				Connection con = ConexaoHelper.conectar();
				PreparedStatement stmt = con.prepareStatement("SELECT * FROM termoabertura WHERE projetoinicio = '"+request.getParameter("projetoinicio")+"'");// pega a conex�o e o Statement
				ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Long codigodoprojeto = rs.getLong("projetoinicio");
				
				if(codigodoprojeto >= 1){											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('J� existe um registro com o c�digo do projeto ("+termoAberturaProjeto.getProjetoinicio().getProjeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarTermoAberturaProjeto";//devolver p/ editar cadastro	
				}else{
					termoAberturaProjetoDAO.salvar(termoAberturaProjeto);
					request.setAttribute("mensagem", "Termo de Abertura do Projeto: ("+termoAberturaProjeto.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}					
					termoAberturaProjetoDAO.salvar(termoAberturaProjeto);
					request.setAttribute("mensagem", "Termo de Abertura do Projeto: ("+termoAberturaProjeto.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");	
					
					/*Regra que objetiva disparar um e-mail autom�tico como confirma��o de registro.
					 * O Metodo enviarForm() � respons�vel, por enviar e-mail de confirma��o de envio de formul�rios.
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
						request.setAttribute("msg","Enviado confirma��o de registro por e-mail!");
					else
						request.setAttribute("msg","N�o, enviado c�pia de confirma��o de registro por e-mail!");				
					
					rd = request.getRequestDispatcher("TkcsapcdController?cmd=editarTermoAberturaProjeto");
					rd.forward(request, response);
					
			}
			else{
				throw new Exception("Valor inv�lido");
			}
			} catch (SQLException e) {
				
				request.setAttribute("mensagem", "Problemas com a grava��o: "+e.getMessage());
				e.printStackTrace();
				
			}catch (NumberFormatException e){
				
				request.setAttribute("mensagem", "Valor inv�lido: "+e.getMessage());
				e.printStackTrace();
			}
				request.setAttribute("titulo", "Cadastro - Termo de Abertura do Projeto");
				return "TkcsapcdController?cmd=editarTermoAberturaProjeto";//devolver p/ editar cadastro		
	}	
}

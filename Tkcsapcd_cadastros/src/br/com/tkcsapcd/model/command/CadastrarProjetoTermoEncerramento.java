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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.ProjetoTermoEncerramento;
import br.com.tkcsapcd.model.dao.InterfaceProjetoTermoEncerramentoDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarProjetoTermoEncerramento implements InterfaceCommand {

	private InterfaceProjetoTermoEncerramentoDAO projetoTermoEncerramentoDAO;	
	
	public CadastrarProjetoTermoEncerramento(InterfaceProjetoTermoEncerramentoDAO projetoTermoEncerramentoDAO) {
		super();
		this.projetoTermoEncerramentoDAO = projetoTermoEncerramentoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			ProjetoTermoEncerramento projetoTermoEncerramento = new ProjetoTermoEncerramento();
			
			projetoTermoEncerramento.setNomeprojeto(request.getParameter("nomeprojeto"));			
			projetoTermoEncerramento.setDatadocumento(request.getParameter("datadocumento"));
			projetoTermoEncerramento.setCoordenador(request.getParameter("coordenador"));
			projetoTermoEncerramento.setTipoprojeto(request.getParameter("tipoprojeto"));
			projetoTermoEncerramento.setGestor(request.getParameter("gestor"));
			projetoTermoEncerramento.setPrograma(request.getParameter("programa"));
			projetoTermoEncerramento.setStatusconclusao(request.getParameter("statusconclusao"));
			projetoTermoEncerramento.setDataanaliseresultado(request.getParameter("dataanaliseresultado"));
			projetoTermoEncerramento.setObjetivoprojeto(request.getParameter("objetivoprojeto"));
			projetoTermoEncerramento.setJustificativaprojeto(request.getParameter("justificativaprojeto"));
			projetoTermoEncerramento.setOrcamentoprevisto(request.getParameter("orcamentoprevisto"));
			projetoTermoEncerramento.setValorempenhado(request.getParameter("valorempenhado"));
			projetoTermoEncerramento.setValorpago(request.getParameter("valorpago"));
			projetoTermoEncerramento.setSaldo(request.getParameter("saldo"));
			projetoTermoEncerramento.setResultadoprevisto(request.getParameter("resultadoprevisto"));
			projetoTermoEncerramento.setPeso(request.getParameter("peso"));
			projetoTermoEncerramento.setProgresso(request.getParameter("progresso"));
			projetoTermoEncerramento.setDetalhamento(request.getParameter("detalhamento"));
			projetoTermoEncerramento.setAnaliseefetividade(request.getParameter("analiseefetividade"));
			projetoTermoEncerramento.setDocumentacaofisica(request.getParameter("documentacaofisica"));
			projetoTermoEncerramento.setDocumentacaoeletronica(request.getParameter("documentacaoeletronica"));			
			projetoTermoEncerramento.setConcideracaocoordenador(request.getParameter("concideracaocoordenador"));
			projetoTermoEncerramento.setConcideracaogestor(request.getParameter("concideracaogestor"));
			projetoTermoEncerramento.setTermo(request.getParameter("termo"));
			projetoTermoEncerramento.setCodigoprojeto(request.getParameter("codigoprojeto"));
			
			if(ValidationHelper.validar(projetoTermoEncerramento)){
				
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM projetotermoencerramento WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conex�o e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("codigoprojeto");
				
				if(codigoprojeto >= 1){
					System.out.println("O c�digo � igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('J� existe um registro com o c�digo do projeto ("+projetoTermoEncerramento.getCodigoprojeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarProjetoTermoEncerramento";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O c�digo n�o � igual!");
					projetoTermoEncerramentoDAO.salvar(projetoTermoEncerramento);
					request.setAttribute("mensagem", "Termo de Encerramento do Projeto: ("+projetoTermoEncerramento.getCodigoprojeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O c�digo n�o � igual!");
					projetoTermoEncerramentoDAO.salvar(projetoTermoEncerramento);
					request.setAttribute("mensagem", "Termo de Encerramento do Projeto: ("+projetoTermoEncerramento.getCodigoprojeto()+") cadastrado com sucesso!");
					
					/*Regra que objetiva disparar um e-mail autom�tico como confirma��o de registro.
					 * O Metodo enviarForm() � respons�vel, por enviar e-mail de confirma��o de envio de formul�rios.
					 */
					
					/*//String de 		= request.getParameter("de");
					String para 	= request.getParameter("para");
					String assunto 	= request.getParameter("nomeprojeto");
					String mensagem = request.getParameter("objetivoprojeto");
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
					
					rd = request.getRequestDispatcher("TkcsapcdController?cmd=editarProjetoTermoEncerramento");
					rd.forward(request, response);*/
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
				request.setAttribute("titulo", "Cadastro - Termo de Encerramento do Projeto");
				return "TkcsapcdController?cmd=editarProjetoTermoEncerramento";//devolver p/ editar cadastro		
	}
}

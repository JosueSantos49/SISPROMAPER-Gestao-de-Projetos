/* 
	Autor: Josué da Conceição Santos
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.PortfolioProjeto;
import br.com.tkcsapcd.model.dao.InterfacePortfolioProjetoDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarPortfolioProjeto implements InterfaceCommand {

	private InterfacePortfolioProjetoDAO portfolioProjetoDAO;
	public CadastrarPortfolioProjeto(InterfacePortfolioProjetoDAO portfolioProjetoDAO) {
		super();
		this.portfolioProjetoDAO = portfolioProjetoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request			
			PortfolioProjeto portfolioProjeto = new PortfolioProjeto();
			
			portfolioProjeto.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			portfolioProjeto.setPrioridade(request.getParameter("prioridade"));
			portfolioProjeto.setTipoprojeto(request.getParameter("tipoprojeto"));
			portfolioProjeto.setUnidadenegocio(request.getParameter("unidadenegocio"));
			portfolioProjeto.setAnalista(request.getParameter("analista"));
			portfolioProjeto.setGerente(request.getParameter("gerente"));
			portfolioProjeto.setFase(request.getParameter("fase"));
			portfolioProjeto.setFaseatual(request.getParameter("faseatual"));
			
			String datainicio_1 = request.getParameter("datainicio"); 
			Date datainicio =  new SimpleDateFormat("dd/MM/yyyy").parse(datainicio_1);
			portfolioProjeto.setDatainicio(datainicio);
			
			String datatermino_1 = request.getParameter("datatermino"); 
			Date datatermino =  new SimpleDateFormat("dd/MM/yyyy").parse(datatermino_1);
			portfolioProjeto.setDatatermino(datatermino);
			
			String dataatual_1 = request.getParameter("dataatual"); 
			Date dataatual =  new SimpleDateFormat("dd/MM/yyyy").parse(dataatual_1);
			portfolioProjeto.setDataatual(dataatual);
						
			portfolioProjeto.setParteinteressada(request.getParameter("parteinteressada"));
			portfolioProjeto.setPlanoprojeto(request.getParameter("planoprojeto"));
			portfolioProjeto.setDeclaracaoescopo(request.getParameter("declaracaoescopo"));
			portfolioProjeto.setDicionarioeap(request.getParameter("dicionarioeap"));
			portfolioProjeto.setCronograma(request.getParameter("cronograma"));
			portfolioProjeto.setRegistrorisco(request.getParameter("registrorisco"));
			portfolioProjeto.setStatusreport(request.getParameter("statusreport"));
			portfolioProjeto.setEscopo(request.getParameter("escopo"));					
			portfolioProjeto.setCusto(Double.parseDouble(request.getParameter("custo")));
			portfolioProjeto.setComentario(request.getParameter("comentario"));
			portfolioProjeto.setNivel(request.getParameter("nivel"));
			portfolioProjeto.setEntrega(request.getParameter("entrega"));	
			portfolioProjeto.setStatus(request.getParameter("status"));
			portfolioProjeto.setRecursos(request.getParameter("recursos"));				
			portfolioProjeto.setReplanejamento(request.getParameter("replanejamento"));
			portfolioProjeto.setEstimativa(request.getParameter("estimativa"));
			portfolioProjeto.setLinhabase(request.getParameter("linhabase"));
			portfolioProjeto.setEsforco(request.getParameter("esforco"));
			portfolioProjeto.setConclusao(request.getParameter("conclusao"));
			portfolioProjeto.setEtapa(request.getParameter("etapa"));
			portfolioProjeto.setEap(request.getParameter("eap"));
			portfolioProjeto.setResponsavel(request.getParameter("responsavel"));
			
			if(ValidationHelper.validar(portfolioProjeto)){
			
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM portfolioprojeto WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("codigoprojeto");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+portfolioProjeto.getCodigoprojeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarPortfolioProjeto";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					portfolioProjetoDAO.salvar(portfolioProjeto);
					request.setAttribute("mensagem", "Portfólio de Projeto: ("+portfolioProjeto.getCodigoprojeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					portfolioProjetoDAO.salvar(portfolioProjeto);
					request.setAttribute("mensagem", "Portfólio de Projeto: ("+portfolioProjeto.getCodigoprojeto()+") cadastrado com sucesso!");			
					
					/*Regra que objetiva disparar um e-mail automático como confirmação de registro.
					 * O Metodo enviarForm() é responsável, por enviar e-mail de confirmação de envio de formulários.
					 
					
					//String de 		= request.getParameter("de");
					String para 	= request.getParameter("para");
					String assunto 	= request.getParameter("tipoprojeto");
					String mensagem = request.getParameter("cronograma");
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
					
					rd = request.getRequestDispatcher("TkcsapcdController?cmd=editarPortfolioProjeto");
					rd.forward(request, response);*/
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
				request.setAttribute("titulo", "Cadastro - Portfólio de Projeto");
				return "TkcsapcdController?cmd=editarPortfolioProjeto";//devolver p/ editar cadastro		
	}
}

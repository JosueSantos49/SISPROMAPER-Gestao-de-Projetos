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

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.TabelaParteInteressada;
import br.com.tkcsapcd.model.dao.InterfaceRegistroParteInteressadaDAO;
import br.com.tkcsapcd.model.dao.InterfaceTabelaParteInteressadaDAO;
import br.com.tkcsapcd.model.email.EnviaEmail;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarTabelaParteInteressada implements InterfaceCommand {

	private InterfaceTabelaParteInteressadaDAO tabelaParteInteressadaDAO;
	private InterfaceRegistroParteInteressadaDAO registroParteInteressadaDAO;
	
	public CadastrarTabelaParteInteressada(InterfaceTabelaParteInteressadaDAO tabelaParteInteressadaDAO, InterfaceRegistroParteInteressadaDAO registroParteInteressadaDAO) {
		super();
		this.tabelaParteInteressadaDAO = tabelaParteInteressadaDAO;
		this.registroParteInteressadaDAO = registroParteInteressadaDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			TabelaParteInteressada tabelaParteInteressada = new TabelaParteInteressada();
			
			tabelaParteInteressada.setNomegrport(request.getParameter("nomegrport"));
			tabelaParteInteressada.setCpfgrport(request.getParameter("cpfgrport"));
			tabelaParteInteressada.setEmailgrport(request.getParameter("emailgrport"));
			tabelaParteInteressada.setFonegrport(Integer.valueOf(request.getParameter("fonegrport")));
			tabelaParteInteressada.setOutrosport(request.getParameter("outrosport"));
			tabelaParteInteressada.setNomegrprograma(request.getParameter("nomegrprograma"));
			tabelaParteInteressada.setEmailgrprograma(request.getParameter("emailgrprograma"));
			tabelaParteInteressada.setFonegrprograma(Integer.valueOf(request.getParameter("fonegrprograma")));				
			tabelaParteInteressada.setNomegrprojeto(request.getParameter("nomegrprojeto"));	
			tabelaParteInteressada.setEmailgrprojeto(request.getParameter("emailgrprojeto"));
			tabelaParteInteressada.setFonegrprojeto(request.getParameter("fonegrprojeto"));
			tabelaParteInteressada.setNomeegprojeto(request.getParameter("nomeegprojeto"));
			tabelaParteInteressada.setEmaileqprojeto(request.getParameter("emaileqprojeto"));
			tabelaParteInteressada.setNomegrfuncional(request.getParameter("nomegrfuncional"));
			tabelaParteInteressada.setCpfgrfuncional(request.getParameter("cpfgrfuncional"));
			tabelaParteInteressada.setEmailgrfuncional(request.getParameter("emailgrfuncional"));
			tabelaParteInteressada.setFonegrfuncional(Integer.valueOf(request.getParameter("fonegrfuncional")));
			tabelaParteInteressada.setNomepatrocinador(request.getParameter("nomepatrocinador"));
			tabelaParteInteressada.setCpfpatrocinador(request.getParameter("cpfpatrocinador"));
			tabelaParteInteressada.setCnpjpatrocinador(request.getParameter("cnpjpatrocinador"));
			tabelaParteInteressada.setEmailpatrocinador(request.getParameter("emailpatrocinador"));	
			tabelaParteInteressada.setFonepatrocinador(Integer.valueOf(request.getParameter("fonepatrocinador")));					
			tabelaParteInteressada.setInvestimento(Double.parseDouble(request.getParameter("investimento")));
			tabelaParteInteressada.setNomeequipeproj(request.getParameter("nomeequipeproj"));
			tabelaParteInteressada.setSetorequipeproj(request.getParameter("setorequipeproj"));
			tabelaParteInteressada.setNomefornecedor(request.getParameter("nomefornecedor"));
			tabelaParteInteressada.setCpffornecedor(request.getParameter("cpffornecedor"));
			tabelaParteInteressada.setCnpjfornecedor(request.getParameter("cnpjfornecedor"));
			tabelaParteInteressada.setEmailfornecedor(request.getParameter("emailfornecedor"));
			tabelaParteInteressada.setFonefornecedor(Integer.valueOf(request.getParameter("fonefornecedor")));
			tabelaParteInteressada.setInvestimentoforne(Double.parseDouble(request.getParameter("investimentoforne")));
			
			Integer registroparteinteressada = Integer.valueOf(request.getParameter("registroparteinteressada"));										
			tabelaParteInteressada.setRegistroParteInteressada(registroParteInteressadaDAO.getRegistroParteInteressada(registroparteinteressada));
			
			if(ValidationHelper.validar(tabelaParteInteressada)){
			response.setContentType("text/html; charset=ISO-8859-1");
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM tbparteinteressada WHERE registroparteinteressada = '"+request.getParameter("registroparteinteressada")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("registroparteinteressada");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+tabelaParteInteressada.getRegistroParteInteressada().getRegistroparteinteressada()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarTabelaParteInteressada";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					tabelaParteInteressadaDAO.salvar(tabelaParteInteressada);
					request.setAttribute("mensagem", "Tabela Parte Interessadas: ("+tabelaParteInteressada.getRegistroParteInteressada().getRegistroparteinteressada()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					tabelaParteInteressadaDAO.salvar(tabelaParteInteressada);
					request.setAttribute("mensagem", "Tabela Parte Interessadas: ("+tabelaParteInteressada.getRegistroParteInteressada().getRegistroparteinteressada()+") cadastrado com sucesso!");			
			
					/*Regra que objetiva disparar um e-mail automático como confirmação de registro.
					 * O Metodo enviarForm() é responsável, por enviar e-mail de confirmação de envio de formulários.
					 */
					
					//String de 		= request.getParameter("de");
					String para 	= request.getParameter("emailgrport");
					String assunto 	= request.getParameter("registroParteInteressada");
					String mensagem = request.getParameter("outrosport");
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
					
					rd = request.getRequestDispatcher("TkcsapcdController?cmd=consultarTabelaParteInteressada");
					rd.forward(request, response);
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
				request.setAttribute("titulo", "Cadastro - Tabela Parte Interessadas");
				return "TkcsapcdController?cmd=consultarTabelaParteInteressada";//devolver p/ editar cadastro		
	}
}

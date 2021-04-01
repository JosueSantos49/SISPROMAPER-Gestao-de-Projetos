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

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.SolicitacaoServicoTI;
import br.com.tkcsapcd.model.dao.InterfaceSolicitacaoServicoTIDAO;
import br.com.tkcsapcd.model.email.EnviaEmail;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarSolicitacaoServicoTI implements InterfaceCommand {

	private InterfaceSolicitacaoServicoTIDAO solicitacaoServicoTIDAO;
	public CadastrarSolicitacaoServicoTI(InterfaceSolicitacaoServicoTIDAO solicitacaoServicoTIDAO){
		super();
		this.solicitacaoServicoTIDAO=solicitacaoServicoTIDAO;
	}
	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) throws Exception {

		try {
			
			SolicitacaoServicoTI solicitacaoServicoTI = new SolicitacaoServicoTI();
			
			solicitacaoServicoTI.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			solicitacaoServicoTI.setCodigosolicitaoservico(request.getParameter("codigosolicitaoservico"));			
			solicitacaoServicoTI.setArea(request.getParameter("area"));
			solicitacaoServicoTI.setResponsaveldemanda(request.getParameter("responsaveldemanda"));
			solicitacaoServicoTI.setTelefonecontato(request.getParameter("telefonecontato"));
			solicitacaoServicoTI.setEmail(request.getParameter("email"));
			solicitacaoServicoTI.setId(request.getParameter("id"));
			solicitacaoServicoTI.setDatasolicitacao(request.getParameter("datasolicitacao"));
			solicitacaoServicoTI.setNomedemanda(request.getParameter("nomedemanda"));
			solicitacaoServicoTI.setObjetivodemanda(request.getParameter("objetivodemanda"));
			solicitacaoServicoTI.setDecricaoproblema(request.getParameter("decricaoproblema"));
			solicitacaoServicoTI.setDesenhoprocesso(request.getParameter("desenhoprocesso"));
			solicitacaoServicoTI.setFuncionalidade(request.getParameter("funcionalidade"));
			solicitacaoServicoTI.setParteenvolvida(request.getParameter("parteenvolvida"));
			solicitacaoServicoTI.setParteenvolvidarepresentante(request.getParameter("parteenvolvidarepresentante"));
			solicitacaoServicoTI.setParteenvolvidaformacontato(request.getParameter("parteenvolvidaformacontato"));
			solicitacaoServicoTI.setEstimativacustoglobal(request.getParameter("estimativacustoglobal"));
			solicitacaoServicoTI.setFontefinanciamento(request.getParameter("fontefinanciamento"));
			solicitacaoServicoTI.setMetodolevantamentocusto(request.getParameter("metodolevantamentocusto"));
			solicitacaoServicoTI.setNumerousuarioprevisto(request.getParameter("numerousuarioprevisto"));
			solicitacaoServicoTI.setRecursos(request.getParameter("recursos"));
			solicitacaoServicoTI.setTreinamentopessoal(request.getParameter("treinamentopessoal"));
			solicitacaoServicoTI.setMaterialapoio(request.getParameter("materialapoio"));
			solicitacaoServicoTI.setRestricaoprojeto(request.getParameter("restricaoprojeto"));
			solicitacaoServicoTI.setPrincipaisusuarios(request.getParameter("principaisusuarios"));
			solicitacaoServicoTI.setNecessidadeusuario(request.getParameter("necessidadeusuario"));
			solicitacaoServicoTI.setPrioridade(request.getParameter("prioridade"));
			solicitacaoServicoTI.setSolucaoatual(request.getParameter("solucaoatual"));
			solicitacaoServicoTI.setProblemasolucaoatual(request.getParameter("problemasolucaoatual"));
			solicitacaoServicoTI.setSolucaoproposta(request.getParameter("solucaoproposta"));
			solicitacaoServicoTI.setStatus(request.getParameter("status"));
						
			if(ValidationHelper.validar(solicitacaoServicoTI)){
				
				Connection con = ConexaoHelper.conectar();
				
				PreparedStatement stmt = con.prepareStatement("SELECT * FROM solicitacaoservicoti WHERE codigosolicitaoservico = '"+request.getParameter("codigosolicitaoservico")+"'");// pega a conex�o e o Statement
				ResultSet rs = stmt.executeQuery();// executa um select
				
				while(rs.next()){
					
					Integer codigosolicitaoservico = rs.getInt("codigosolicitaoservico");
					
					if(codigosolicitaoservico >= 1){
						System.out.println("O c�digo � igual!");
												 
						PrintWriter out = response.getWriter();
						response.setContentType("text/html; charset=ISO-8859-1");
						out.println("<script type=\"text/javascript\">");  
						out.println("alert('J� existe um registro com o c�digo da SSTI ("+solicitacaoServicoTI.getCodigosolicitaoservico()+"), informado!');");  
						out.println("</script>");
						
						return "TkcsapcdController?cmd=editarSolicitacaoServicoTI";
					}else{
						System.out.println("Aviso 1: O c�digo n�o � igual!");
						solicitacaoServicoTIDAO.salvar(solicitacaoServicoTI);
						request.setAttribute("mensagem", "SSTI-(C�digo do Projeto): "+solicitacaoServicoTI.getCodigoprojeto()+", cadastrada com sucesso!" );
					}
						stmt.close();
						rs.close();
						con.close();
				}
						System.out.println("Aviso 2: O c�digo n�o � igual!");
						solicitacaoServicoTIDAO.salvar(solicitacaoServicoTI);
						request.setAttribute("mensagem", "SSTI-(C�digo do Projeto): "+solicitacaoServicoTI.getCodigoprojeto()+", cadastrada com sucesso!" );	
						
						//Regra de envio de e-mail com Javamail. Enviando confirma��o de cadastro.
						String assunto 			= request.getParameter("codigoprojeto");
						//String mensagem 		= request.getParameter("nomedemanda");	
						String copia			= request.getParameter("email");	//Aqui pode ser regatado qualquer e-mail digitado pelo user								
						
						RequestDispatcher rd = null;	
						EnviaEmail email = new EnviaEmail();
						
						email.setAssunto(assunto);
						//email.setMensagem(mensagem);
						email.setCopia(copia); 					
						
						boolean enviado = email.enviarSolicitacaoServicoTI();
						
						if(enviado)
							request.setAttribute("msg","Enviado confirma��o de registro por e-mail!");
						else
							request.setAttribute("msg","N�o, enviado c�pia de confirma��o de registro por e-mail!");
						rd = request.getRequestDispatcher("TkcsapcdController?cmd=editarSolicitacaoServicoTI");
						rd.forward(request,response);
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
			request.setAttribute("titulo", "Cadastro - Cadastrar Solicita��o de Servi�o TI.");
			return "TkcsapcdController?cmd=editarSolicitacaoServicoTI";
	}

}

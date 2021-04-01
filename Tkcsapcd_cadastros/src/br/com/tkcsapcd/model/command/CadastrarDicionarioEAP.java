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

import br.com.tkcsapcd.model.bean.DicionarioEAP;
import br.com.tkcsapcd.model.dao.InterfaceDicionarioEAPDAO;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarDicionarioEAP implements InterfaceCommand {

	private InterfaceDicionarioEAPDAO dicionarioEAPDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	public CadastrarDicionarioEAP(InterfaceDicionarioEAPDAO dicionarioEAPDAO, InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.dicionarioEAPDAO = dicionarioEAPDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			DicionarioEAP dicionarioEAP = new DicionarioEAP();
			
			dicionarioEAP.setDicionarioeap(request.getParameter("dicionarioeap"));
			dicionarioEAP.setVersao(request.getParameter("versao"));
			
			String data_1 = request.getParameter("data"); 
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(data_1);
			dicionarioEAP.setData(data);
			
			dicionarioEAP.setAutor(request.getParameter("autor"));
			dicionarioEAP.setNotarevisao(request.getParameter("notarevisao"));
			dicionarioEAP.setAprovacao(request.getParameter("aprovacao"));
			dicionarioEAP.setCodigoeap(Integer.valueOf(request.getParameter("codigoeap")));			
			dicionarioEAP.setEntregapacote(request.getParameter("entregapacote"));					
			dicionarioEAP.setDescricao(request.getParameter("descricao"));
			dicionarioEAP.setCriterioaceitacao(request.getParameter("criterioaceitacao"));
			dicionarioEAP.setResponsavel(request.getParameter("responsavel"));
			dicionarioEAP.setAprovado(request.getParameter("aprovado"));
			dicionarioEAP.setConsultado(request.getParameter("consultado"));
			dicionarioEAP.setInformado(request.getParameter("informado"));
			dicionarioEAP.setTrabalhoenvolvido(request.getParameter("trabalhoenvolvido"));
			dicionarioEAP.setRiscos(request.getParameter("riscos"));
			dicionarioEAP.setRecusos(request.getParameter("recusos"));
			dicionarioEAP.setMacros(request.getParameter("macros"));
			dicionarioEAP.setCustos(request.getParameter("custos").equals("") ? null : Double.valueOf(request.getParameter("custos")));
			dicionarioEAP.setPrevisao(request.getParameter("previsao"));
			dicionarioEAP.setInformacoes(request.getParameter("informacoes"));
			dicionarioEAP.setStatus(request.getParameter("status"));
			dicionarioEAP.setComentarios(request.getParameter("comentarios"));
			
			Integer projetoinicio = Integer.valueOf(request.getParameter("projetoinicio"));										
			dicionarioEAP.setProjetoinicio(projetoInicioDAO.getProjetoInicio(projetoinicio));
			
			if(ValidationHelper.validar(dicionarioEAP)){
			
			Connection con = ConexaoHelper.conectar();
				
				PreparedStatement stmt = con.prepareStatement("SELECT * FROM dicionarioeap WHERE projetoinicio = '"+request.getParameter("projetoinicio")+"'");// pega a conexão e o Statement
				ResultSet rs = stmt.executeQuery();// executa um select
				
				while(rs.next()){
					
					Long codigoeap = rs.getLong("projetoinicio");
					
					if(codigoeap >= 1){
						System.out.println("O código é igual!");
												 
						PrintWriter out = response.getWriter();
						response.setContentType("text/html; charset=ISO-8859-1");
						out.println("<script type=\"text/javascript\">");  
						out.println("alert('Já existe um registro com o código da EAP ("+dicionarioEAP.getProjetoinicio().getProjeto()+"), informado!');");  
						out.println("</script>");
						
						return "TkcsapcdController?cmd=editarDicionarioEAP";//devolver p/ editar cadastro
					}else{
						System.out.println("Aviso 1: O código não é igual!");
						dicionarioEAPDAO.salvar(dicionarioEAP);
						request.setAttribute("mensagem", "DICIONÁRIO DA EAP: ("+dicionarioEAP.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");
					}
					stmt.close();
					rs.close();
					con.close();
				}
						System.out.println("Aviso 2: O código não é igual!");
						dicionarioEAPDAO.salvar(dicionarioEAP);
						request.setAttribute("mensagem", "DICIONÁRIO DA EAP: ("+dicionarioEAP.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - DICIONÁRIO DA EAP");
				return "TkcsapcdController?cmd=editarDicionarioEAP";//devolver p/ editar cadastro		
	}
}

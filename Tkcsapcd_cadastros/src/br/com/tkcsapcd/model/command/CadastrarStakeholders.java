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

import br.com.tkcsapcd.model.bean.Stakeholders;
import br.com.tkcsapcd.model.dao.InterfaceStakeholdersDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarStakeholders implements InterfaceCommand {

	private InterfaceStakeholdersDAO stakeholdersDAO;	
	public CadastrarStakeholders(InterfaceStakeholdersDAO stakeholdersDAO) {
		super();
		this.stakeholdersDAO = stakeholdersDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			Stakeholders stakeholders = new Stakeholders();
			
			stakeholders.setEmpresa(request.getParameter("empresa"));
			stakeholders.setOrgao(request.getParameter("orgao"));
			stakeholders.setSetor(request.getParameter("setor"));
			stakeholders.setPrograma(request.getParameter("programa"));
			stakeholders.setProjeto(request.getParameter("projeto"));
			stakeholders.setGerente(request.getParameter("gerente"));
			stakeholders.setFuncao(request.getParameter("funcao"));
			stakeholders.setAprovado(request.getParameter("aprovado"));
			stakeholders.setVersao(request.getParameter("versao"));
			stakeholders.setDataaprovacao(request.getParameter("dataaprovacao"));
			stakeholders.setReferencia(request.getParameter("referencia"));
			stakeholders.setNome(request.getParameter("nome"));
			stakeholders.setEmpresaequipe(request.getParameter("empresaequipe"));
			stakeholders.setCargocompetencia(request.getParameter("cargocompetencia"));
			stakeholders.setEmail(request.getParameter("email"));
			stakeholders.setTelefone(request.getParameter("telefone"));
			stakeholders.setEndereco(request.getParameter("endereco"));
			stakeholders.setObs(request.getParameter("obs"));
			stakeholders.setCodigoprojeto(request.getParameter("codigoprojeto"));
			
			if(ValidationHelper.validar(stakeholders)){
				
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM stakeholders WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conex�o e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("codigoprojeto");
				
				if(codigoprojeto >= 1){
					System.out.println("O c�digo � igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('J� existe um registro com o c�digo do projeto ("+stakeholders.getCodigoprojeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarStakeholders";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O c�digo n�o � igual!");
					stakeholdersDAO.salvar(stakeholders);
					request.setAttribute("mensagem", "Stakeholders: ("+stakeholders.getCodigoprojeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O c�digo n�o � igual!");
					stakeholdersDAO.salvar(stakeholders);
					request.setAttribute("mensagem", "Stakeholders: ("+stakeholders.getCodigoprojeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - Stakeholders");
				return "TkcsapcdController?cmd=editarStakeholders";//devolver p/ editar cadastro		
	}
}

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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoRH;
import br.com.tkcsapcd.model.dao.InterfacePlanoGerenciamentoRHDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarPlanoGerenciamentoRH implements InterfaceCommand {

	private InterfacePlanoGerenciamentoRHDAO planoGerenciamentoRHDAO;
	public CadastrarPlanoGerenciamentoRH(InterfacePlanoGerenciamentoRHDAO planoGerenciamentoRHDAO) {
		super();
		this.planoGerenciamentoRHDAO = planoGerenciamentoRHDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			PlanoGerenciamentoRH planoGerenciamentoRH = new PlanoGerenciamentoRH();
			
			planoGerenciamentoRH.setPlanogerenciamentorh(request.getParameter("planogerenciamentorh"));
			planoGerenciamentoRH.setProjeto(request.getParameter("projeto"));
			planoGerenciamentoRH.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			planoGerenciamentoRH.setVersao(request.getParameter("versao"));
			planoGerenciamentoRH.setData(request.getParameter("data"));
			planoGerenciamentoRH.setAutor(request.getParameter("autor"));
			planoGerenciamentoRH.setNotarevisao(request.getParameter("notarevisao"));
			planoGerenciamentoRH.setAprovacao(request.getParameter("aprovacao"));
			planoGerenciamentoRH.setObjetivo(request.getParameter("objetivo"));				
			planoGerenciamentoRH.setMetodo(request.getParameter("metodo"));					
			planoGerenciamentoRH.setProcesso(request.getParameter("processo"));
			planoGerenciamentoRH.setDocumento(request.getParameter("documento"));
			planoGerenciamentoRH.setFerramenta(request.getParameter("ferramenta"));
			planoGerenciamentoRH.setOrganograma(request.getParameter("organograma"));
			planoGerenciamentoRH.setPapeis(request.getParameter("papeis"));
			planoGerenciamentoRH.setPlanogerenciamento(request.getParameter("planogerenciamento"));
			planoGerenciamentoRH.setMobilizacao(request.getParameter("mobilizacao"));
			planoGerenciamentoRH.setCalendario(request.getParameter("calendario"));					
			planoGerenciamentoRH.setPlanoliberacao(request.getParameter("planoliberacao"));
			planoGerenciamentoRH.setNecessidade(request.getParameter("necessidade"));
			planoGerenciamentoRH.setReconhecimento(request.getParameter("reconhecimento"));
			planoGerenciamentoRH.setConformidade(request.getParameter("conformidade"));	
			planoGerenciamentoRH.setSeguranca(request.getParameter("seguranca"));
			
			if(ValidationHelper.validar(planoGerenciamentoRH)){
				
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM planogerenciamentorh WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("codigoprojeto");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+planoGerenciamentoRH.getCodigoprojeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarPlanoGerenciamentoRH";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					planoGerenciamentoRHDAO.salvar(planoGerenciamentoRH);
					request.setAttribute("mensagem", "PLANO DE GERENCIAMENTO DA RH: ("+planoGerenciamentoRH.getCodigoprojeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					planoGerenciamentoRHDAO.salvar(planoGerenciamentoRH);
					request.setAttribute("mensagem", "PLANO DE GERENCIAMENTO DA RH: ("+planoGerenciamentoRH.getCodigoprojeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - PLANO DE GERENCIAMENTO DA RH");
				return "TkcsapcdController?cmd=editarPlanoGerenciamentoRH";//devolver p/ editar cadastro		
	}
}

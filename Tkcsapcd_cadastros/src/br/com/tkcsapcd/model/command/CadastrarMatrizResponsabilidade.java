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

import br.com.tkcsapcd.model.bean.MatrizResponsabilidade;
import br.com.tkcsapcd.model.dao.InterfaceMatrizResponsabilidadeDAO;
import br.com.tkcsapcd.model.dao.MatrizResponsabilidadeDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarMatrizResponsabilidade implements InterfaceCommand {

	private InterfaceMatrizResponsabilidadeDAO matrizResponsabilidadeDAO;	
	public CadastrarMatrizResponsabilidade(MatrizResponsabilidadeDAO matrizResponsabilidadeDAO) {
		super();
		this.matrizResponsabilidadeDAO = matrizResponsabilidadeDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			MatrizResponsabilidade matrizResponsabilidade = new MatrizResponsabilidade();// Codigo de processamento

			matrizResponsabilidade.setCodigoeap(Integer.valueOf(request.getParameter("codigoeap")));
			matrizResponsabilidade.setAtividade(request.getParameter("atividade"));
			matrizResponsabilidade.setDescricao(request.getParameter("descricao"));
			matrizResponsabilidade.setResponsavel(request.getParameter("responsavel"));
			matrizResponsabilidade.setAprovar(request.getParameter("aprovar"));
			matrizResponsabilidade.setConsultado(request.getParameter("consultado"));
			matrizResponsabilidade.setInformado(request.getParameter("informado"));
			matrizResponsabilidade.setParticipante(request.getParameter("participante"));
			
			if(ValidationHelper.validar(matrizResponsabilidade)){
			
			
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM matrizresponsabilidade WHERE codigoeap = '"+request.getParameter("codigoeap")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoeap = rs.getInt("codigoeap");
				
				if(codigoeap >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código da EAP ("+matrizResponsabilidade.getCodigoeap()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarMatrizResponsabilidade";//devolver p/ editar cadastro	
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					matrizResponsabilidadeDAO.salvar(matrizResponsabilidade);
					request.setAttribute("mensagem", "Matriz de Responsabilidade RACI: ("+matrizResponsabilidade.getCodigoeap()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					matrizResponsabilidadeDAO.salvar(matrizResponsabilidade);
					request.setAttribute("mensagem", "Matriz de Responsabilidade RACI: ("+matrizResponsabilidade.getCodigoeap()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - Matriz de Responsabilidade RACI");
				return "TkcsapcdController?cmd=editarMatrizResponsabilidade";//devolver p/ editar cadastro		
	}
}

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

import br.com.tkcsapcd.model.bean.ListaQualidade;
import br.com.tkcsapcd.model.dao.InterfaceListaQualidadeDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarListaQualidade implements InterfaceCommand {

	private InterfaceListaQualidadeDAO listaQualidadeDAO;
	public CadastrarListaQualidade(InterfaceListaQualidadeDAO listaQualidadeDAO) {
		super();
		this.listaQualidadeDAO = listaQualidadeDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			ListaQualidade listaQualidade = new ListaQualidade();
			
			listaQualidade.setListaqualiade(request.getParameter("listaqualiade"));
			listaQualidade.setProjeto(request.getParameter("projeto"));
			listaQualidade.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			listaQualidade.setVersao(request.getParameter("versao"));
			listaQualidade.setData(request.getParameter("data"));
			listaQualidade.setAutor(request.getParameter("autor"));
			listaQualidade.setNotarevisao(request.getParameter("notarevisao"));
			listaQualidade.setAprovacao(request.getParameter("aprovacao"));
			listaQualidade.setProduto(request.getParameter("produto"));				
			listaQualidade.setRequsito(request.getParameter("requsito"));					
			listaQualidade.setCriterio(request.getParameter("criterio"));
			listaQualidade.setMetodo(request.getParameter("metodo"));
			
			if(ValidationHelper.validar(listaQualidade)){				
			
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM listaqualidade WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("codigoprojeto");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+listaQualidade.getCodigoprojeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarListaQualidade";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					listaQualidadeDAO.salvar(listaQualidade);
					request.setAttribute("mensagem", "Lista de Verificação da Qualidade: ("+listaQualidade.getCodigoprojeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					listaQualidadeDAO.salvar(listaQualidade);
					request.setAttribute("mensagem", "Lista de Verificação da Qualidade: ("+listaQualidade.getCodigoprojeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - Lista de Verificação da Qualidade");
				return "TkcsapcdController?cmd=editarListaQualidade";//devolver p/ editar cadastro		
	}
}

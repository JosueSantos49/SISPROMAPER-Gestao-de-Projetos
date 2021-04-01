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

import br.com.tkcsapcd.model.bean.ListaMarcos;
import br.com.tkcsapcd.model.dao.InterfaceListaMarcosDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarListaMarcos implements InterfaceCommand {

	private InterfaceListaMarcosDAO listaMarcosDAO;
	public CadastrarListaMarcos(InterfaceListaMarcosDAO listaMarcosDAO) {
		super();
		this.listaMarcosDAO = listaMarcosDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			ListaMarcos listaMarcos = new ListaMarcos();
			
			listaMarcos.setListamarcos(request.getParameter("listamarcos"));
			listaMarcos.setProjeto(request.getParameter("projeto"));
			listaMarcos.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			listaMarcos.setVersao(request.getParameter("versao"));
			listaMarcos.setData(request.getParameter("data"));
			listaMarcos.setAutor(request.getParameter("autor"));
			listaMarcos.setNotarevisao(request.getParameter("notarevisao"));
			listaMarcos.setAprovacao(request.getParameter("aprovacao"));
			listaMarcos.setObjetivo(request.getParameter("objetivo"));				
			listaMarcos.setFases(request.getParameter("fases"));
			
			if(ValidationHelper.validar(listaMarcos)){
						
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM listamarcos WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("codigoprojeto");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+listaMarcos.getCodigoprojeto()+"), informada!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarListaMarcos";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					listaMarcosDAO.salvar(listaMarcos);
					request.setAttribute("mensagem", "Lista dos Marcos: ("+listaMarcos.getCodigoprojeto()+") cadastrado com sucesso!");
				}
				stmt.close();
				rs.close();
				con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					listaMarcosDAO.salvar(listaMarcos);
					request.setAttribute("mensagem", "Lista dos Marcos: ("+listaMarcos.getCodigoprojeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - Lista dos Marcos");
				return "TkcsapcdController?cmd=editarListaMarcos";//devolver p/ editar cadastro		
	}
}

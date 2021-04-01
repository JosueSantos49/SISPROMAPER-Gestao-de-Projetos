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

import br.com.tkcsapcd.model.bean.ListaAtividade;
import br.com.tkcsapcd.model.dao.InterfaceListaAtividadeDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarListaAtividade implements InterfaceCommand {

	private InterfaceListaAtividadeDAO listaAtividadeDAO;
	public CadastrarListaAtividade(InterfaceListaAtividadeDAO listaAtividadeDAO) {
		super();
		this.listaAtividadeDAO = listaAtividadeDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			ListaAtividade listaAtividade = new ListaAtividade();
			
			listaAtividade.setListaatividade(request.getParameter("listaatividade"));
			listaAtividade.setProjeto(request.getParameter("projeto"));
			listaAtividade.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			listaAtividade.setVersao(request.getParameter("versao"));
			listaAtividade.setData(request.getParameter("data"));
			listaAtividade.setAutor(request.getParameter("autor"));
			listaAtividade.setNotarevisao(request.getParameter("notarevisao"));
			listaAtividade.setAprovacao(request.getParameter("aprovacao"));
			listaAtividade.setObjetivo(request.getParameter("objetivo"));				
			listaAtividade.setEntrega(request.getParameter("entrega"));
			
			if(ValidationHelper.validar(listaAtividade)){
				
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM listaatividade WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("codigoprojeto");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+listaAtividade.getCodigoprojeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarListaAtividade";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					listaAtividadeDAO.salvar(listaAtividade);
					request.setAttribute("mensagem", "LISTA DAS ATIVIDADES: ("+listaAtividade.getCodigoprojeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					listaAtividadeDAO.salvar(listaAtividade);
					request.setAttribute("mensagem", "LISTA DAS ATIVIDADES: ("+listaAtividade.getCodigoprojeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - LISTA DAS ATIVIDADES");
				return "TkcsapcdController?cmd=editarListaAtividade";//devolver p/ editar cadastro		
	}
}

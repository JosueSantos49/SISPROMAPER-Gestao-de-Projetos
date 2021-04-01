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

import br.com.tkcsapcd.model.bean.LicoesAprendida;
import br.com.tkcsapcd.model.dao.InterfaceLicoesAprendidaDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarLicoesAprendida implements InterfaceCommand {

	private InterfaceLicoesAprendidaDAO licoesAprendidaDAO;
	public CadastrarLicoesAprendida(InterfaceLicoesAprendidaDAO licoesAprendidaDAO) {
		super();
		this.licoesAprendidaDAO = licoesAprendidaDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
		//  Preencher o Bean com os valores do request
			LicoesAprendida licoesAprendida = new LicoesAprendida();

			licoesAprendida.setEmpresa(request.getParameter("empresa"));
			licoesAprendida.setOrgao(request.getParameter("orgao"));
			licoesAprendida.setSetor(request.getParameter("setor"));
			licoesAprendida.setPrograma(request.getParameter("programa"));
			licoesAprendida.setProjeto(request.getParameter("projeto"));
			licoesAprendida.setGerente(request.getParameter("gerente"));
			licoesAprendida.setFuncao(request.getParameter("funcao"));
			licoesAprendida.setAprovado(request.getParameter("aprovado"));
			licoesAprendida.setVersao(request.getParameter("versao"));				
			licoesAprendida.setDataaprovacao(request.getParameter("dataaprovacao"));					
			licoesAprendida.setPergunta1(request.getParameter("pergunta1"));
			licoesAprendida.setPergunta2(request.getParameter("pergunta2"));
			licoesAprendida.setPergunta3(request.getParameter("pergunta3"));
			licoesAprendida.setPergunta4(request.getParameter("pergunta4"));
			licoesAprendida.setPergunta5(request.getParameter("pergunta5"));
			licoesAprendida.setPergunta6(request.getParameter("pergunta6"));
			licoesAprendida.setPergunta7(request.getParameter("pergunta7"));
			licoesAprendida.setPergunta8(request.getParameter("pergunta8"));
			licoesAprendida.setPergunta9(request.getParameter("pergunta9"));
			licoesAprendida.setPergunta10(request.getParameter("pergunta10"));
			licoesAprendida.setPergunta11(request.getParameter("pergunta11"));
			licoesAprendida.setPergunta12(request.getParameter("pergunta12"));
			licoesAprendida.setPergunta13(request.getParameter("pergunta13"));
			licoesAprendida.setPergunta14(request.getParameter("pergunta14"));
			licoesAprendida.setPergunta15(request.getParameter("pergunta15"));
			licoesAprendida.setPergunta16(request.getParameter("pergunta16"));
			licoesAprendida.setPergunta17(request.getParameter("pergunta17"));
			licoesAprendida.setCodigoprojeto(request.getParameter("codigoprojeto"));
			
			if(ValidationHelper.validar(licoesAprendida)){
							
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM licoesaprendida WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("codigoprojeto");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+licoesAprendida.getCodigoprojeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarLicoesAprendida";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					licoesAprendidaDAO.salvar(licoesAprendida);
					request.setAttribute("mensagem", "Lições Aprendidas: ("+licoesAprendida.getCodigoprojeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					licoesAprendidaDAO.salvar(licoesAprendida);
					request.setAttribute("mensagem", "Lições Aprendidas: ("+licoesAprendida.getCodigoprojeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - Lições Aprendidas");
				return "TkcsapcdController?cmd=editarLicoesAprendida";//devolver p/ editar cadastro		
	}
}

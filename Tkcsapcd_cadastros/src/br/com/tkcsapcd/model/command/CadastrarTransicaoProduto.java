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

import br.com.tkcsapcd.model.bean.TransicaoProduto;
import br.com.tkcsapcd.model.dao.InterfaceTransicaoProdutoDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarTransicaoProduto implements InterfaceCommand {

	private InterfaceTransicaoProdutoDAO transicaoProdutoDAO;
	public CadastrarTransicaoProduto(InterfaceTransicaoProdutoDAO transicaoProdutoDAO) {
		super();
		this.transicaoProdutoDAO = transicaoProdutoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			TransicaoProduto transicaoProduto = new TransicaoProduto();
			
			transicaoProduto.setTransicaoproduto(request.getParameter("transicaoproduto"));
			transicaoProduto.setProjeto(request.getParameter("projeto"));
			transicaoProduto.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			transicaoProduto.setVersao(request.getParameter("versao"));
			transicaoProduto.setData(request.getParameter("data"));
			transicaoProduto.setAutor(request.getParameter("autor"));
			transicaoProduto.setNotarevisao(request.getParameter("notarevisao"));
			transicaoProduto.setAprovacao(request.getParameter("aprovacao"));
			transicaoProduto.setObjetivo(request.getParameter("objetivo"));				
			transicaoProduto.setPeriodo(request.getParameter("periodo"));					
			transicaoProduto.setProcedimento(request.getParameter("procedimento"));
			transicaoProduto.setTreinamento(request.getParameter("treinamento"));
			transicaoProduto.setResponsavelprojeto(request.getParameter("responsavelprojeto"));
			transicaoProduto.setResponsaveloperacao(request.getParameter("responsaveloperacao"));
			transicaoProduto.setPontoaberto(request.getParameter("pontoaberto"));
			transicaoProduto.setRecomendacao(request.getParameter("recomendacao"));
			
			if(ValidationHelper.validar(transicaoProduto)){
				
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM transicaoproduto WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("codigoprojeto");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+transicaoProduto.getCodigoprojeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarTransicaoProduto";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					transicaoProdutoDAO.salvar(transicaoProduto);
					request.setAttribute("mensagem", "TRANSIÇÃO DO PRODUTO: ("+transicaoProduto.getCodigoprojeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					transicaoProdutoDAO.salvar(transicaoProduto);
					request.setAttribute("mensagem", "TRANSIÇÃO DO PRODUTO: ("+transicaoProduto.getCodigoprojeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - TRANSIÇÃO DO PRODUTO");
				return "TkcsapcdController?cmd=editarTransicaoProduto";//devolver p/ editar cadastro		
	}
}

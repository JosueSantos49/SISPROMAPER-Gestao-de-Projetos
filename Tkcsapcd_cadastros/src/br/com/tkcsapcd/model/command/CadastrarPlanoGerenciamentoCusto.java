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

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoCusto;
import br.com.tkcsapcd.model.dao.InterfacePlanoGerenciamentoCustoDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarPlanoGerenciamentoCusto implements InterfaceCommand {

	private InterfacePlanoGerenciamentoCustoDAO planoGerenciamentoCustoDAO;
	public CadastrarPlanoGerenciamentoCusto(InterfacePlanoGerenciamentoCustoDAO planoGerenciamentoCustoDAO) {
		super();
		this.planoGerenciamentoCustoDAO = planoGerenciamentoCustoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			PlanoGerenciamentoCusto planoGerenciamentoCusto = new PlanoGerenciamentoCusto();
			
			planoGerenciamentoCusto.setPlanogerenciamentocusto(request.getParameter("planogerenciamentocusto"));
			planoGerenciamentoCusto.setProjeto(request.getParameter("projeto"));
			planoGerenciamentoCusto.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			planoGerenciamentoCusto.setVersao(request.getParameter("versao"));
			planoGerenciamentoCusto.setData(request.getParameter("data"));
			planoGerenciamentoCusto.setAutor(request.getParameter("autor"));
			planoGerenciamentoCusto.setNotarevisao(request.getParameter("notarevisao"));
			planoGerenciamentoCusto.setAprovacao(request.getParameter("aprovacao"));
			planoGerenciamentoCusto.setObjetivo(request.getParameter("objetivo"));				
			planoGerenciamentoCusto.setMetodo(request.getParameter("metodo"));					
			planoGerenciamentoCusto.setProcesso(request.getParameter("processo"));
			planoGerenciamentoCusto.setDocumento(request.getParameter("documento"));
			planoGerenciamentoCusto.setFerramenta(request.getParameter("ferramenta"));
			planoGerenciamentoCusto.setPapeis(request.getParameter("papeis"));
			planoGerenciamentoCusto.setPlano(request.getParameter("plano"));
			planoGerenciamentoCusto.setCusto(request.getParameter("custo"));
			planoGerenciamentoCusto.setOrcamento(request.getParameter("orcamento"));
			planoGerenciamentoCusto.setControlarcusto(request.getParameter("controlarcusto"));
			
			if(ValidationHelper.validar(planoGerenciamentoCusto)){
							
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM planogerenciamentocusto WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("codigoprojeto");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+planoGerenciamentoCusto.getCodigoprojeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarPlanoGerenciamentoCusto";//devolver p/ editar cadastro	
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					planoGerenciamentoCustoDAO.salvar(planoGerenciamentoCusto);
					request.setAttribute("mensagem", "PLANO DE GERENCIAMENTO DOS CUSTOS: ("+planoGerenciamentoCusto.getCodigoprojeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					planoGerenciamentoCustoDAO.salvar(planoGerenciamentoCusto);
					request.setAttribute("mensagem", "PLANO DE GERENCIAMENTO DOS CUSTOS: ("+planoGerenciamentoCusto.getCodigoprojeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - PLANO DE GERENCIAMENTO DOS CUSTOS");
				return "TkcsapcdController?cmd=editarPlanoGerenciamentoCusto";//devolver p/ editar cadastro		
	}
}

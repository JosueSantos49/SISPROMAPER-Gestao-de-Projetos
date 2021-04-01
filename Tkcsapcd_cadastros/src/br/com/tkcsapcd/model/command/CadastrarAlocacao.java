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

import br.com.tkcsapcd.model.bean.Alocacao;
import br.com.tkcsapcd.model.dao.InterfaceAlocacaoDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarAlocacao implements InterfaceCommand {

	private InterfaceAlocacaoDAO alocacaoDAO;
	public CadastrarAlocacao(InterfaceAlocacaoDAO alocacaoDAO) {
		super();
		this.alocacaoDAO = alocacaoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			Alocacao alocacao = new Alocacao();
			
			alocacao.setProjeto_codigo(Integer.valueOf(request.getParameter("projeto_codigo")));
			alocacao.setRecursoshumanos_codigo(request.getParameter("recursoshumanos_codigo"));
			alocacao.setProfissao_codigo(request.getParameter("profissao_codigo"));			
			alocacao.setData(request.getParameter("data"));
			alocacao.setData0(request.getParameter("data0"));
			alocacao.setMetrica(request.getParameter("metrica"));
			alocacao.setMetrica1(request.getParameter("metrica1"));
			alocacao.setMetrica2(request.getParameter("metrica2"));
			alocacao.setMetrica3(request.getParameter("metrica3"));
			alocacao.setMetrica4(request.getParameter("metrica4"));
			alocacao.setMetrica5(request.getParameter("metrica5"));
			alocacao.setMetrica6(request.getParameter("metrica6"));
			alocacao.setMetrica7(request.getParameter("metrica7"));
			alocacao.setMetrica8(request.getParameter("metrica8"));
			alocacao.setMetrica9(request.getParameter("metrica9"));
			alocacao.setMetrica10(request.getParameter("metrica10"));
			alocacao.setMetrica11(request.getParameter("metrica11"));
			alocacao.setMetrica12(request.getParameter("metrica12"));
			alocacao.setMetrica13(request.getParameter("metrica13"));
			alocacao.setMetrica14(request.getParameter("metrica14"));
			alocacao.setMetrica15(request.getParameter("metrica15"));
			alocacao.setMetrica16(request.getParameter("metrica16"));
			
			if(ValidationHelper.validar(alocacao)){
						
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM alocacao WHERE projeto_codigo = '"+request.getParameter("projeto_codigo")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer projeto_codigo = rs.getInt("projeto_codigo");
				
				if(projeto_codigo >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+alocacao.getProjeto_codigo()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarAlocacao";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					alocacaoDAO.salvar(alocacao);
					request.setAttribute("mensagem", "Alocação do Projeto: "+alocacao.getProjeto_codigo()+" cadastrado com sucesso!");
				}
				stmt.close();
				rs.close();
				con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					alocacaoDAO.salvar(alocacao);
					request.setAttribute("mensagem", "Alocação do Projeto: "+alocacao.getProjeto_codigo()+" cadastrado com sucesso!");			
		}
			else{
				throw new Exception("Dados Inválidos");
			}
			
		} catch (SQLException e) {
			
			request.setAttribute("mensagem", "Problemas com a gravação: "+e.getMessage());
			e.printStackTrace();
			
		}catch (NumberFormatException e){
			
			request.setAttribute("mensagem", "Valor inválido: "+e.getMessage());
			e.printStackTrace();
		}
			request.setAttribute("titulo", "Cadastro - Alocação");
			return "TkcsapcdController?cmd=editarAlocacao";//devolver p/ editar cadastro		
	}
}

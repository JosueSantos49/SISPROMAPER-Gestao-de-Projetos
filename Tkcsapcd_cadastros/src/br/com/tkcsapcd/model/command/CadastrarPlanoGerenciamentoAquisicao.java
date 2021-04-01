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

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoAquisicao;
import br.com.tkcsapcd.model.dao.InterfacePlanoGerenciamentoAquisicaoDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarPlanoGerenciamentoAquisicao implements InterfaceCommand {

	private InterfacePlanoGerenciamentoAquisicaoDAO planoGerenciamentoAquisicaoDAO;
	public CadastrarPlanoGerenciamentoAquisicao(InterfacePlanoGerenciamentoAquisicaoDAO planoGerenciamentoAquisicaoDAO) {
		super();
		this.planoGerenciamentoAquisicaoDAO = planoGerenciamentoAquisicaoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			PlanoGerenciamentoAquisicao planoGerenciamentoAquisicao = new PlanoGerenciamentoAquisicao();
		
			planoGerenciamentoAquisicao.setPlanogerenciamentoaquisicao(request.getParameter("planogerenciamentoaquisicao"));
			planoGerenciamentoAquisicao.setProjeto(request.getParameter("projeto"));
			planoGerenciamentoAquisicao.setCodigoprojeto(request.getParameter("codigoprojeto"));
			planoGerenciamentoAquisicao.setVersao(request.getParameter("versao"));
			planoGerenciamentoAquisicao.setData(request.getParameter("data"));
			planoGerenciamentoAquisicao.setAutor(request.getParameter("autor"));
			planoGerenciamentoAquisicao.setNotarevisao(request.getParameter("notarevisao"));
			planoGerenciamentoAquisicao.setAprovacao(request.getParameter("aprovacao"));
			planoGerenciamentoAquisicao.setObjetivo(request.getParameter("objetivo"));	
			planoGerenciamentoAquisicao.setMetodo(request.getParameter("metodo"));
			planoGerenciamentoAquisicao.setProcesso(request.getParameter("processo"));
			planoGerenciamentoAquisicao.setDecisoes(request.getParameter("decisoes"));
			planoGerenciamentoAquisicao.setDocumento(request.getParameter("documento"));
			planoGerenciamentoAquisicao.setResponsabilidade(request.getParameter("responsabilidade"));
			planoGerenciamentoAquisicao.setMetrica(request.getParameter("metrica"));					
			planoGerenciamentoAquisicao.setPremissarestricao(request.getParameter("premissarestricao"));
			planoGerenciamentoAquisicao.setRiscos(request.getParameter("riscos"));
			planoGerenciamentoAquisicao.setFornecedor(request.getParameter("fornecedor"));					
			planoGerenciamentoAquisicao.setConduziraquisicao(request.getParameter("conduziraquisicao"));
			planoGerenciamentoAquisicao.setTipocontrato(request.getParameter("tipocontrato"));
			planoGerenciamentoAquisicao.setCriterioavaliacao(request.getParameter("criterioavaliacao"));
			planoGerenciamentoAquisicao.setControlaaquisicao(request.getParameter("controlaaquisicao"));	
			planoGerenciamentoAquisicao.setAvalicacaofornecedor(request.getParameter("avalicacaofornecedor"));
			planoGerenciamentoAquisicao.setEncerraraquisicao(request.getParameter("encerraraquisicao"));
			
			if(ValidationHelper.validar(planoGerenciamentoAquisicao)){
			
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM planogerenciamentoaquisicao WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("codigoprojeto");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+planoGerenciamentoAquisicao.getCodigoprojeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarPlanoGerenciamentoAquisicao";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					planoGerenciamentoAquisicaoDAO.salvar(planoGerenciamentoAquisicao);
					request.setAttribute("mensagem", "PLANO DE GERENCIAMENTO DA AQUISIÇÕES: ("+planoGerenciamentoAquisicao.getCodigoprojeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					planoGerenciamentoAquisicaoDAO.salvar(planoGerenciamentoAquisicao);
					request.setAttribute("mensagem", "PLANO DE GERENCIAMENTO DA AQUISIÇÕES: ("+planoGerenciamentoAquisicao.getCodigoprojeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - PLANO DE GERENCIAMENTO DA AQUISIÇÕES");
				return "TkcsapcdController?cmd=editarPlanoGerenciamentoAquisicao";//devolver p/ editar cadastro		
	}
}

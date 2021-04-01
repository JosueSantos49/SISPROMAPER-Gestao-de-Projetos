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

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoQualidade;
import br.com.tkcsapcd.model.dao.InterfacePlanoGerenciamentoQualidadeDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarPlanoGerenciamentoQualidade implements InterfaceCommand {

	private InterfacePlanoGerenciamentoQualidadeDAO planoGerenciamentoQualidadeDAO;
	public CadastrarPlanoGerenciamentoQualidade(InterfacePlanoGerenciamentoQualidadeDAO planoGerenciamentoQualidadeDAO) {
		super();
		this.planoGerenciamentoQualidadeDAO = planoGerenciamentoQualidadeDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			PlanoGerenciamentoQualidade planoGerenciamentoQualidade = new PlanoGerenciamentoQualidade();
			
			planoGerenciamentoQualidade.setPlanogerenciamentoqualidade(request.getParameter("planogerenciamentoqualidade"));
			planoGerenciamentoQualidade.setProjeto(request.getParameter("projeto"));
			planoGerenciamentoQualidade.setCodigoprojeto(request.getParameter("codigoprojeto"));
			planoGerenciamentoQualidade.setVersao(request.getParameter("versao"));
			planoGerenciamentoQualidade.setData(request.getParameter("data"));
			planoGerenciamentoQualidade.setAutor(request.getParameter("autor"));
			planoGerenciamentoQualidade.setNotarevisao(request.getParameter("notarevisao"));
			planoGerenciamentoQualidade.setAprovacao(request.getParameter("aprovacao"));
			planoGerenciamentoQualidade.setObjetivo(request.getParameter("objetivo"));				
			planoGerenciamentoQualidade.setMetodo(request.getParameter("metodo"));					
			planoGerenciamentoQualidade.setProcessoqualidade(request.getParameter("processoqualidade"));
			planoGerenciamentoQualidade.setObjetivo(request.getParameter("objetivo"));
			planoGerenciamentoQualidade.setJustificativa(request.getParameter("justificativa"));
			planoGerenciamentoQualidade.setMetrica(request.getParameter("metrica"));
			planoGerenciamentoQualidade.setFerramentaqualidade(request.getParameter("ferramentaqualidade"));
			planoGerenciamentoQualidade.setEntregaprojetoaceitacao(request.getParameter("entregaprojetoaceitacao"));
			planoGerenciamentoQualidade.setGarantiaqualidade(request.getParameter("garantiaqualidade"));
			planoGerenciamentoQualidade.setAuditoria(request.getParameter("logauditoria"));					
			planoGerenciamentoQualidade.setProcessomelhoria(request.getParameter("processomelhoria"));
			planoGerenciamentoQualidade.setResponsabilidadequalidade(request.getParameter("responsabilidadequalidade"));
			planoGerenciamentoQualidade.setLogauditoria(request.getParameter("logauditoria"));
			planoGerenciamentoQualidade.setControlequalidade(request.getParameter("controlequalidade"));	
			planoGerenciamentoQualidade.setProcedimentoinspecao(request.getParameter("procedimentoinspecao"));
			planoGerenciamentoQualidade.setProcedimentomonitoramento(request.getParameter("procedimentomonitoramento"));
			
			if(ValidationHelper.validar(planoGerenciamentoQualidade)){
			
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM planogerenciamentoqualidade WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("codigoprojeto");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+planoGerenciamentoQualidade.getCodigoprojeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarPlanoGerenciamentoQualidade";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					planoGerenciamentoQualidadeDAO.salvar(planoGerenciamentoQualidade);
					request.setAttribute("mensagem", "PLANO DE GERENCIAMENTO DA QUALIDADE: ("+planoGerenciamentoQualidade.getCodigoprojeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					planoGerenciamentoQualidadeDAO.salvar(planoGerenciamentoQualidade);
					request.setAttribute("mensagem", "PLANO DE GERENCIAMENTO DA QUALIDADE: ("+planoGerenciamentoQualidade.getCodigoprojeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - PLANO DE GERENCIAMENTO DA QUALIDADE");
				return "TkcsapcdController?cmd=editarPlanoGerenciamentoQualidade";//devolver p/ editar cadastro		
	}
}

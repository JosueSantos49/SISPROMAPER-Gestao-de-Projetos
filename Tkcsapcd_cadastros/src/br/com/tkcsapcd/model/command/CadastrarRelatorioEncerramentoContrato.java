/* 
	Autor: Josu� da Concei��o Santos
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

import br.com.tkcsapcd.model.bean.RelatorioEncerramentoContrato;

import br.com.tkcsapcd.model.dao.InterfaceRelatorioEncerramentoContratoDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarRelatorioEncerramentoContrato implements InterfaceCommand {

	private InterfaceRelatorioEncerramentoContratoDAO relatorioEncerramentoContratoDAO;
	public CadastrarRelatorioEncerramentoContrato(InterfaceRelatorioEncerramentoContratoDAO relatorioEncerramentoContratoDAO) {
		super();
		this.relatorioEncerramentoContratoDAO = relatorioEncerramentoContratoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			RelatorioEncerramentoContrato relatorioEncerramentoContrato = new RelatorioEncerramentoContrato();
			
			relatorioEncerramentoContrato.setRelatorio(request.getParameter("relatorio"));
			relatorioEncerramentoContrato.setProjeto(request.getParameter("projeto"));
			relatorioEncerramentoContrato.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			relatorioEncerramentoContrato.setObjetivo(request.getParameter("objetivo"));
			relatorioEncerramentoContrato.setIdentificacao(request.getParameter("identificacao"));								
			relatorioEncerramentoContrato.setEntrega(request.getParameter("entrega"));					
			relatorioEncerramentoContrato.setQuestoes(request.getParameter("questoes"));
			relatorioEncerramentoContrato.setInformacoes(request.getParameter("informacoes"));
			relatorioEncerramentoContrato.setAceite(request.getParameter("aceite"));
			
			if(ValidationHelper.validar(relatorioEncerramentoContrato)){
						
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM relatorioencerramentocontrato WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conex�o e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("codigoprojeto");
				
				if(codigoprojeto >= 1){
					System.out.println("O c�digo � igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('J� existe um registro com o c�digo do projeto ("+relatorioEncerramentoContrato.getCodigoprojeto()+"), informada!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarRelatorioEncerramentoContrato";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O c�digo n�o � igual!");
					relatorioEncerramentoContratoDAO.salvar(relatorioEncerramentoContrato);
					request.setAttribute("mensagem", "Relat�rio de Encerramento do Contrato: ("+relatorioEncerramentoContrato.getCodigoprojeto()+") cadastrado com sucesso!");
				}
				stmt.close();
				rs.close();
				con.close();
			}
					System.out.println("Aviso 2: O c�digo n�o � igual!");
					relatorioEncerramentoContratoDAO.salvar(relatorioEncerramentoContrato);
					request.setAttribute("mensagem", "Relat�rio de Encerramento do Contrato: ("+relatorioEncerramentoContrato.getCodigoprojeto()+") cadastrado com sucesso!");			
		}
			else{
				throw new Exception("Valor inv�lido");
			}
			} catch (SQLException e) {
				
				request.setAttribute("mensagem", "Problemas com a grava��o: "+e.getMessage());
				e.printStackTrace();
				
			}catch (NumberFormatException e){
				
				request.setAttribute("mensagem", "Valor inv�lido: "+e.getMessage());
				e.printStackTrace();
			}
				request.setAttribute("titulo", "Cadastro - Relat�rio de Encerramento do Contrato");
				return "TkcsapcdController?cmd=editarRelatorioEncerramentoContrato";//devolver p/ editar cadastro		
	}
}

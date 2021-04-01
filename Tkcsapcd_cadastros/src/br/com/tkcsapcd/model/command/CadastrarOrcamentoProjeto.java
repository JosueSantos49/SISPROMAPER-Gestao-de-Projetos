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

import br.com.tkcsapcd.model.bean.OrcamentoProjeto;
import br.com.tkcsapcd.model.dao.InterfaceOrcamentoProjetoDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarOrcamentoProjeto implements InterfaceCommand {

	private InterfaceOrcamentoProjetoDAO orcamentoProjetoDAO;
	public CadastrarOrcamentoProjeto(InterfaceOrcamentoProjetoDAO orcamentoProjetoDAO) {
		super();
		this.orcamentoProjetoDAO = orcamentoProjetoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			OrcamentoProjeto orcamentoProjeto = new OrcamentoProjeto();
			
			orcamentoProjeto.setOrcamento(request.getParameter("orcamento"));
			orcamentoProjeto.setProjeto(request.getParameter("projeto"));
			orcamentoProjeto.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			orcamentoProjeto.setVersao(request.getParameter("versao"));
			orcamentoProjeto.setData(request.getParameter("data"));
			orcamentoProjeto.setAutor(request.getParameter("autor"));
			orcamentoProjeto.setNotarevisao(request.getParameter("notarevisao"));
			orcamentoProjeto.setAprovacao(request.getParameter("aprovacao"));
			orcamentoProjeto.setObjetivo(request.getParameter("objetivo"));				
			orcamentoProjeto.setBase(request.getParameter("base"));					
			orcamentoProjeto.setEstimativarecurso(request.getParameter("estimativarecurso"));
			orcamentoProjeto.setEstimativaatividade(request.getParameter("estimativaatividade"));
			orcamentoProjeto.setLinha(request.getParameter("linha"));
			orcamentoProjeto.setRequisito(request.getParameter("requisito"));
			orcamentoProjeto.setFluxo(request.getParameter("fluxo"));
			
			if(ValidationHelper.validar(orcamentoProjeto)){
						
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM orcamentoprojeto WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conex�o e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("codigoprojeto");
				
				if(codigoprojeto >= 1){
					System.out.println("O c�digo � igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('J� existe um registro com o c�digo do projeto ("+orcamentoProjeto.getCodigoprojeto()+"), informada!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarOrcamentoProjeto";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O c�digo n�o � igual!");
					orcamentoProjetoDAO.salvar(orcamentoProjeto);
					request.setAttribute("mensagem", "Or�amento do projeto: ("+orcamentoProjeto.getCodigoprojeto()+") cadastrado com sucesso!");
				}
				stmt.close();
				rs.close();
				con.close();
			}
					System.out.println("Aviso 2: O c�digo n�o � igual!");
					orcamentoProjetoDAO.salvar(orcamentoProjeto);
					request.setAttribute("mensagem", "Or�amento do projeto: ("+orcamentoProjeto.getCodigoprojeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - Or�amento do projeto");
				return "TkcsapcdController?cmd=editarOrcamentoProjeto";//devolver p/ editar cadastro		
	}
}

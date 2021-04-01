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

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoRisco;
import br.com.tkcsapcd.model.dao.InterfacePlanoGerenciamentoRiscoDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarPlanoGerenciamentoRisco implements InterfaceCommand {

	private InterfacePlanoGerenciamentoRiscoDAO planoGerenciamentoRiscoDAO;
	public CadastrarPlanoGerenciamentoRisco(InterfacePlanoGerenciamentoRiscoDAO planoGerenciamentoRiscoDAO) {
		super();
		this.planoGerenciamentoRiscoDAO = planoGerenciamentoRiscoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			PlanoGerenciamentoRisco planoGerenciamentoRisco = new PlanoGerenciamentoRisco();
			
			planoGerenciamentoRisco.setPlanogerenciamentorisco(request.getParameter("planogerenciamentorisco"));
			planoGerenciamentoRisco.setProjeto(request.getParameter("projeto"));
			planoGerenciamentoRisco.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			planoGerenciamentoRisco.setVersao(request.getParameter("versao"));
			planoGerenciamentoRisco.setData(request.getParameter("data"));
			planoGerenciamentoRisco.setAutor(request.getParameter("autor"));
			planoGerenciamentoRisco.setNotarevisao(request.getParameter("notarevisao"));
			planoGerenciamentoRisco.setAprovacao(request.getParameter("aprovacao"));
			planoGerenciamentoRisco.setObjetivo(request.getParameter("objetivo"));				
			planoGerenciamentoRisco.setGerenciamento(request.getParameter("gerenciamento"));					
			planoGerenciamentoRisco.setProcesso(request.getParameter("processo"));
			planoGerenciamentoRisco.setDocumento(request.getParameter("documento"));
			planoGerenciamentoRisco.setResponsabilidade(request.getParameter("responsabilidade"));
			planoGerenciamentoRisco.setIdentificar(request.getParameter("identificar"));
			planoGerenciamentoRisco.setEar(request.getParameter("ear"));
			planoGerenciamentoRisco.setRiscos(request.getParameter("riscos"));
			planoGerenciamentoRisco.setAnalisequalitativa(request.getParameter("analisequalitativa"));
			planoGerenciamentoRisco.setDefinicao(request.getParameter("definicao"));					
			planoGerenciamentoRisco.setAnalisequantitativa(request.getParameter("analisequantitativa"));
			planoGerenciamentoRisco.setPlanejar(request.getParameter("planejar"));
			planoGerenciamentoRisco.setReservas(request.getParameter("reservas"));
			planoGerenciamentoRisco.setControlar(request.getParameter("controlar"));
			
			if(ValidationHelper.validar(planoGerenciamentoRisco)){
				
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM planogerenciamentorisco WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("codigoprojeto");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+planoGerenciamentoRisco.getCodigoprojeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarPlanoGerenciamentoRisco";//devolver p/ editar cadastro	
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					planoGerenciamentoRiscoDAO.salvar(planoGerenciamentoRisco);
					request.setAttribute("mensagem", "PLANO DE GERENCIAMENTO DOS RISCOS: ("+planoGerenciamentoRisco.getCodigoprojeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					planoGerenciamentoRiscoDAO.salvar(planoGerenciamentoRisco);
					request.setAttribute("mensagem", "PLANO DE GERENCIAMENTO DOS RISCOS: ("+planoGerenciamentoRisco.getCodigoprojeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - PLANO DE GERENCIAMENTO DOS RISCOS");
				return "TkcsapcdController?cmd=editarPlanoGerenciamentoRisco";//devolver p/ editar cadastro		
	}
}

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
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoParteInteressada;
import br.com.tkcsapcd.model.dao.InterfacePlanoGerenciamentoParteInteressadaDAO;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarPlanoGerenciamentoParteInteressada implements InterfaceCommand {

	private InterfacePlanoGerenciamentoParteInteressadaDAO planoGerenciamentoParteInteressadaDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	public CadastrarPlanoGerenciamentoParteInteressada(InterfacePlanoGerenciamentoParteInteressadaDAO planoGerenciamentoParteInteressadaDAO,
			InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.planoGerenciamentoParteInteressadaDAO = planoGerenciamentoParteInteressadaDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			PlanoGerenciamentoParteInteressada planoGerenciamentoParteInteressada = new PlanoGerenciamentoParteInteressada();
			
			planoGerenciamentoParteInteressada.setPlanogerenciamentointeressada(request.getParameter("planogerenciamentointeressada"));
			planoGerenciamentoParteInteressada.setVersao(request.getParameter("versao"));
			
			String data_1 = request.getParameter("data"); 
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(data_1);
			planoGerenciamentoParteInteressada.setData(data);
			
			planoGerenciamentoParteInteressada.setAutor(request.getParameter("autor"));
			planoGerenciamentoParteInteressada.setNotarevisao(request.getParameter("notarevisao"));
			planoGerenciamentoParteInteressada.setAprovacao(request.getParameter("aprovacao"));
			planoGerenciamentoParteInteressada.setObjetivo(request.getParameter("objetivo"));				
			planoGerenciamentoParteInteressada.setProcesso(request.getParameter("processo"));					
			planoGerenciamentoParteInteressada.setParteinteressada(request.getParameter("parteinteressada"));
			planoGerenciamentoParteInteressada.setGerenciarparte(request.getParameter("gerenciarparte"));
			planoGerenciamentoParteInteressada.setControlaparte(request.getParameter("controlaparte"));
			planoGerenciamentoParteInteressada.setAnexo(request.getParameter("anexo"));
			
			Integer projetoinicio = Integer.valueOf(request.getParameter("projetoinicio"));										
			planoGerenciamentoParteInteressada.setProjetoinicio(projetoInicioDAO.getProjetoInicio(projetoinicio));
			
			if(ValidationHelper.validar(planoGerenciamentoParteInteressada)){
				
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM planogerenciamentoparteinteressada WHERE projetoinicio = '"+request.getParameter("projetoinicio")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("projetoinicio");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+planoGerenciamentoParteInteressada.getProjetoinicio().getProjeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarPlanoGerenciamentoParteInteressada";//devolver p/ editar cadastro	
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					planoGerenciamentoParteInteressadaDAO.salvar(planoGerenciamentoParteInteressada);
					request.setAttribute("mensagem", "PLANO DE GERENCIAMENTO DAS PARTES INTERESSADAS: ("+planoGerenciamentoParteInteressada.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					planoGerenciamentoParteInteressadaDAO.salvar(planoGerenciamentoParteInteressada);
					request.setAttribute("mensagem", "PLANO DE GERENCIAMENTO DAS PARTES INTERESSADAS: ("+planoGerenciamentoParteInteressada.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - PLANO DE GERENCIAMENTO DAS PARTES INTERESSADAS");
				return "TkcsapcdController?cmd=editarPlanoGerenciamentoParteInteressada";//devolver p/ editar cadastro		
	}
}

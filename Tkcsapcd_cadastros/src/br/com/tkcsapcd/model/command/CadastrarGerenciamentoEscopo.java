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

import br.com.tkcsapcd.model.bean.GerenciamentoEscopo;
import br.com.tkcsapcd.model.dao.InterfaceGerenciamentoEscopoDAO;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarGerenciamentoEscopo implements InterfaceCommand {

	private InterfaceGerenciamentoEscopoDAO gerenciamentoEscopoDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	public CadastrarGerenciamentoEscopo(InterfaceGerenciamentoEscopoDAO gerenciamentoEscopoDAO,
			InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.gerenciamentoEscopoDAO = gerenciamentoEscopoDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			GerenciamentoEscopo gerenciamentoEscopo = new GerenciamentoEscopo();
			
			gerenciamentoEscopo.setEmpresa(request.getParameter("empresa"));
			gerenciamentoEscopo.setOrgao(request.getParameter("orgao"));
			gerenciamentoEscopo.setSetor(request.getParameter("setor"));
			gerenciamentoEscopo.setPrograma(request.getParameter("programa"));
			gerenciamentoEscopo.setGerente(request.getParameter("gerente"));
			gerenciamentoEscopo.setFuncao(request.getParameter("funcao"));
			gerenciamentoEscopo.setAprovado(request.getParameter("aprovado"));
			gerenciamentoEscopo.setVersao(request.getParameter("versao"));
			
			String data_1 = request.getParameter("dataaprovacao"); 
			Date dataaprovacao = new SimpleDateFormat("dd/MM/yyyy").parse(data_1);
			gerenciamentoEscopo.setDataaprovacao(dataaprovacao);
			
			gerenciamentoEscopo.setObjetivo(request.getParameter("objetivo"));
			gerenciamentoEscopo.setGerenciamento(request.getParameter("gerenciamento"));
			gerenciamentoEscopo.setReunioes_equipe(request.getParameter("reunioes_equipe"));
			gerenciamentoEscopo.setReunioes_planejamento(request.getParameter("reunioes_planejamento"));
			gerenciamentoEscopo.setReunioes_gerenciais(request.getParameter("reunioes_gerenciais"));
			gerenciamentoEscopo.setModificacao_escopo(request.getParameter("modificacao_escopo"));
			gerenciamentoEscopo.setLicoes(request.getParameter("licoes"));			
			
			Integer projetoinicio = Integer.valueOf(request.getParameter("projetoinicio"));										
			gerenciamentoEscopo.setProjetoinicio(projetoInicioDAO.getProjetoInicio(projetoinicio));
			
			if(ValidationHelper.validar(gerenciamentoEscopo)){
						
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM gerenciamentoescopo WHERE projetoinicio = '"+request.getParameter("projetoinicio")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("projetoinicio");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+gerenciamentoEscopo.getProjetoinicio().getProjeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarGerenciamentoEscopo";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					gerenciamentoEscopoDAO.salvar(gerenciamentoEscopo);
					request.setAttribute("mensagem", "Gerenciamento do Escopo: ("+gerenciamentoEscopo.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");
				}
				stmt.close();
				rs.close();
				con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					gerenciamentoEscopoDAO.salvar(gerenciamentoEscopo);
					request.setAttribute("mensagem", "Gerenciamento do Escopo: ("+gerenciamentoEscopo.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - Declaração do Escopo");
				return "TkcsapcdController?cmd=editarGerenciamentoEscopo";//devolver p/ editar cadastro		
	}
}

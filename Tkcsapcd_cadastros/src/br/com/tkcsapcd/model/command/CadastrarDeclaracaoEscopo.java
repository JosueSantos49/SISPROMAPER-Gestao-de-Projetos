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

import br.com.tkcsapcd.model.bean.DeclaracaoEscopo;
import br.com.tkcsapcd.model.dao.InterfaceDeclaracaoEscopoDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarDeclaracaoEscopo implements InterfaceCommand {

	private InterfaceDeclaracaoEscopoDAO declaracaoEscopoDAO;
	public CadastrarDeclaracaoEscopo(InterfaceDeclaracaoEscopoDAO declaracaoEscopoDAO) {
		super();
		this.declaracaoEscopoDAO = declaracaoEscopoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			DeclaracaoEscopo declaracaoEscopo = new DeclaracaoEscopo();
			
			declaracaoEscopo.setEmpresa(request.getParameter("empresa"));
			declaracaoEscopo.setOrgao(request.getParameter("orgao"));
			declaracaoEscopo.setSetor(request.getParameter("setor"));
			declaracaoEscopo.setPrograma(request.getParameter("programa"));
			declaracaoEscopo.setProjeto(request.getParameter("projeto"));
			declaracaoEscopo.setGerente(request.getParameter("gerente"));
			declaracaoEscopo.setFuncao(request.getParameter("funcao"));
			declaracaoEscopo.setAprovado(request.getParameter("aprovado"));
			declaracaoEscopo.setVersao(request.getParameter("versao"));				
			declaracaoEscopo.setDataaprovacao(request.getParameter("dataaprovacao"));					
			declaracaoEscopo.setJustificativa(request.getParameter("justificativa"));
			declaracaoEscopo.setObjetivo(request.getParameter("objetivo"));
			declaracaoEscopo.setDescricao(request.getParameter("descricao"));
			declaracaoEscopo.setLista(request.getParameter("lista"));
			declaracaoEscopo.setLigacao(request.getParameter("ligacao"));
			declaracaoEscopo.setEstrategia(request.getParameter("estrategia"));
			declaracaoEscopo.setResponsabilidade(request.getParameter("responsabilidade"));
			declaracaoEscopo.setMacro(request.getParameter("macro"));					
			declaracaoEscopo.setPremissas(request.getParameter("premissas"));
			declaracaoEscopo.setRestricoes(request.getParameter("restricoes"));
			declaracaoEscopo.setEquipe(request.getParameter("equipe"));
			declaracaoEscopo.setObs(request.getParameter("obs"));					
			declaracaoEscopo.setCodigoprojeto(request.getParameter("codigoprojeto"));
			
			if(ValidationHelper.validar(declaracaoEscopo)){
			
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM declaracaoescopo WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("codigoprojeto");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+declaracaoEscopo.getCodigoprojeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarDeclaracaoescopo";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					declaracaoEscopoDAO.salvar(declaracaoEscopo);
					request.setAttribute("mensagem", "Declaração do Escopo: ("+declaracaoEscopo.getCodigoprojeto()+") cadastrado com sucesso!");
				}
				stmt.close();
				rs.close();
				con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					declaracaoEscopoDAO.salvar(declaracaoEscopo);
					request.setAttribute("mensagem", "Declaração do Escopo: ("+declaracaoEscopo.getCodigoprojeto()+") cadastrado com sucesso!");			
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
				return "TkcsapcdController?cmd=editarDeclaracaoescopo";//devolver p/ editar cadastro		
	}
}

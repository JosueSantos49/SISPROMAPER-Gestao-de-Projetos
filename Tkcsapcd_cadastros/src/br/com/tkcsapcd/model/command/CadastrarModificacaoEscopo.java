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

import br.com.tkcsapcd.model.bean.ModificacaoEscopo;
import br.com.tkcsapcd.model.dao.InterfaceModificacaoescopoDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarModificacaoEscopo implements InterfaceCommand {

	private InterfaceModificacaoescopoDAO modificacaoescopoDAO;
	public CadastrarModificacaoEscopo(InterfaceModificacaoescopoDAO modificacaoescopoDAO) {
		super();
		this.modificacaoescopoDAO = modificacaoescopoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			ModificacaoEscopo modificacaoEscopo = new ModificacaoEscopo();
			
			modificacaoEscopo.setEmpresa(request.getParameter("empresa"));
			modificacaoEscopo.setOrgao(request.getParameter("orgao"));
			modificacaoEscopo.setSetor(request.getParameter("setor"));
			modificacaoEscopo.setPrograma(request.getParameter("programa"));
			modificacaoEscopo.setProjeto(request.getParameter("projeto"));
			modificacaoEscopo.setGerente(request.getParameter("gerente"));
			modificacaoEscopo.setRequerido(request.getParameter("requerido"));
			modificacaoEscopo.setNumero_me(request.getParameter("numero_me"));
			modificacaoEscopo.setDataemissao(request.getParameter("dataemissao"));				
			modificacaoEscopo.setDescricao(request.getParameter("descricao"));
			modificacaoEscopo.setMotivo(request.getParameter("motivo"));
			modificacaoEscopo.setImpacto(request.getParameter("impacto"));
			modificacaoEscopo.setEscopo(request.getParameter("escopo"));
			modificacaoEscopo.setCusto(request.getParameter("custo"));
			modificacaoEscopo.setPrazo(request.getParameter("prazo"));
			modificacaoEscopo.setComentarios(request.getParameter("comentarios"));
			modificacaoEscopo.setReferencia(request.getParameter("referencia"));				
			modificacaoEscopo.setAnexo(request.getParameter("anexo"));
			modificacaoEscopo.setParecer(request.getParameter("parecer"));
			modificacaoEscopo.setAprovacao(request.getParameter("aprovacao"));
			modificacaoEscopo.setCodigoprojeto(request.getParameter("codigoprojeto"));
			
			if(ValidationHelper.validar(modificacaoEscopo)){
				
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM modificacaoescopo WHERE numero_me = '"+request.getParameter("numero_me")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer numero_me = rs.getInt("numero_me");
				
				if(numero_me >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o ME Nº ("+modificacaoEscopo.getNumero_me()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarModificacaoEscopo";//devolver p/ editar cadastro	
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					modificacaoescopoDAO.salvar(modificacaoEscopo);
					request.setAttribute("mensagem", "SOLICITAÇÃO DE MODIFICAÇÃO DE ESCOPO - ME: ("+modificacaoEscopo.getNumero_me()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					modificacaoescopoDAO.salvar(modificacaoEscopo);
					request.setAttribute("mensagem", "SOLICITAÇÃO DE MODIFICAÇÃO DE ESCOPO - ME: ("+modificacaoEscopo.getNumero_me()+") cadastrado com sucesso!");			
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
				return "TkcsapcdController?cmd=editarModificacaoEscopo";//devolver p/ editar cadastro		
	}
}

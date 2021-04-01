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

import br.com.tkcsapcd.model.bean.AcompanhamentoProjeto;
import br.com.tkcsapcd.model.dao.InterfaceAcompanhamentoProjetoDAO;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarAcompanhamentoProjeto implements InterfaceCommand {

	private InterfaceAcompanhamentoProjetoDAO acompanhamentoProjetoDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	
	public CadastrarAcompanhamentoProjeto(InterfaceAcompanhamentoProjetoDAO acompanhamentoProjetoDAO,
			InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.acompanhamentoProjetoDAO = acompanhamentoProjetoDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}

	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response) throws Exception {
		try {
			AcompanhamentoProjeto acompanhamentoProjeto = new AcompanhamentoProjeto();
						
			acompanhamentoProjeto.setAcompanhamentoprojeto(request.getParameter("acompanhamentoprojeto"));
			acompanhamentoProjeto.setVersao(Long.valueOf(request.getParameter("versao")));
			
			String data_1 = request.getParameter("data"); 
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(data_1);
			acompanhamentoProjeto.setData(data);
			
			acompanhamentoProjeto.setAutor(request.getParameter("autor"));
			acompanhamentoProjeto.setNotarevisao(request.getParameter("notarevisao"));
			acompanhamentoProjeto.setAprovacao(request.getParameter("aprovacao"));
			acompanhamentoProjeto.setProdutoservico(request.getParameter("produtoservico"));
			acompanhamentoProjeto.setSituacaoconcluida(request.getParameter("situacaoconcluida"));
			
			String data_2 = request.getParameter("dataplanejada"); 
			Date dataplanejada = new SimpleDateFormat("dd/MM/yyyy").parse(data_2);
			acompanhamentoProjeto.setDataplanejada(dataplanejada);
			
			String data_3 = request.getParameter("dataefetiva"); 
			Date dataefetiva = new SimpleDateFormat("dd/MM/yyyy").parse(data_3);
			acompanhamentoProjeto.setDataefetiva(dataefetiva);
			
			acompanhamentoProjeto.setAtrasoprevisto(Long.valueOf(request.getParameter("atrasoprevisto")));
			acompanhamentoProjeto.setValororcado(request.getParameter("valororcado").equals("") ? null : Double.valueOf(request.getParameter("valororcado")));
			acompanhamentoProjeto.setCustoreal(request.getParameter("custoreal").equals("") ? null : Double.valueOf(request.getParameter("custoreal")));
			acompanhamentoProjeto.setEspecificacao(request.getParameter("especificacao"));
			acompanhamentoProjeto.setNivel(request.getParameter("nivel"));
			acompanhamentoProjeto.setAcao(request.getParameter("acao"));
			acompanhamentoProjeto.setResponsavel(request.getParameter("responsavel"));
			
			Integer projetoinicio = Integer.valueOf(request.getParameter("projetoinicio"));										
			acompanhamentoProjeto.setProjetoinicio(projetoInicioDAO.getProjetoInicio(projetoinicio));
			
			if(ValidationHelper.validar(acompanhamentoProjeto)){	
				
				Connection con = ConexaoHelper.conectar();
				
				PreparedStatement stmt = con.prepareStatement("SELECT * FROM acompanhamentoprojeto WHERE projetoinicio = '"+request.getParameter("projetoinicio")+"'");// pega a conexão e o Statement
				ResultSet rs = stmt.executeQuery();// executa um select
				
				while(rs.next()){
					
					Integer codigoprojeto = rs.getInt("projetoinicio");
					
					if(codigoprojeto >= 1){
												 
						PrintWriter out = response.getWriter();
						response.setContentType("text/html; charset=ISO-8859-1");
						out.println("<script type=\"text/javascript\">");  
						out.println("alert('Já existe um registro com o código do projeto ("+acompanhamentoProjeto.getProjetoinicio().getProjeto()+"), informado!');");  
						out.println("</script>");
						
						return "TkcsapcdController?cmd=editarAcompanhamentoProjeto";//Devolver para o editar
					}else{
						acompanhamentoProjetoDAO.salvar(acompanhamentoProjeto);
						request.setAttribute("mensagem", "Acompanhamento do Projeto: ("+acompanhamentoProjeto.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");
					}
					stmt.close();
					rs.close();
					con.close();
				}
						acompanhamentoProjetoDAO.salvar(acompanhamentoProjeto);
						request.setAttribute("mensagem", "Acompanhamento do Projeto: ("+acompanhamentoProjeto.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");			
			}
			else{
				throw new Exception("Valor inválido");
			}
			} catch (SQLException e) {
				
				request.setAttribute("mensagem", "Problema com a gravação: "+e.getMessage());
				e.printStackTrace();
				
			}catch (NumberFormatException e) {
				
				request.setAttribute("mensagem", "Valor inválido: "+e.getMessage());
				e.printStackTrace();
			}
			request.setAttribute("titulo", "Cadastro - Acompanhamento do Projeto");		
			return "TkcsapcdController?cmd=editarAcompanhamentoProjeto";//Devolver para o editar
		}


}

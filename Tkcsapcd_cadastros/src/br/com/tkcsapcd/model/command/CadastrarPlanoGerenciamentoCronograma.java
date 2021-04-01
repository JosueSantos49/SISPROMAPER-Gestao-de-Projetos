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
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.PlanoGerenciamentoCronograma;
import br.com.tkcsapcd.model.dao.InterfacePlanoGerenciamentoCronogramaDAO;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarPlanoGerenciamentoCronograma implements InterfaceCommand {

	private InterfacePlanoGerenciamentoCronogramaDAO planoGerenciamentoCronogramaDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	
	public CadastrarPlanoGerenciamentoCronograma(InterfacePlanoGerenciamentoCronogramaDAO planoGerenciamentoCronogramaDAO,
			InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.planoGerenciamentoCronogramaDAO = planoGerenciamentoCronogramaDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			PlanoGerenciamentoCronograma planoGerenciamentoCronograma = new PlanoGerenciamentoCronograma();
			
			planoGerenciamentoCronograma.setPlanogerenciamentocronograma(request.getParameter("planogerenciamentocronograma"));
			planoGerenciamentoCronograma.setVersao(request.getParameter("versao"));
			
			Date data = new Date();
			planoGerenciamentoCronograma.setData(data);
			
			planoGerenciamentoCronograma.setAutor(request.getParameter("autor"));
			planoGerenciamentoCronograma.setNotarevisao(request.getParameter("notarevisao"));
			planoGerenciamentoCronograma.setAprovacao(request.getParameter("aprovacao"));
			planoGerenciamentoCronograma.setObjetivo(request.getParameter("objetivo"));				
			planoGerenciamentoCronograma.setMetodo(request.getParameter("metodo"));					
			planoGerenciamentoCronograma.setProcesso(request.getParameter("processo"));
			planoGerenciamentoCronograma.setDocumento(request.getParameter("documento"));
			planoGerenciamentoCronograma.setFerramenta(request.getParameter("ferramenta"));
			planoGerenciamentoCronograma.setPapeis(request.getParameter("papeis"));
			planoGerenciamentoCronograma.setPlano(request.getParameter("plano"));
			planoGerenciamentoCronograma.setAtividade(request.getParameter("atividade"));
			planoGerenciamentoCronograma.setSequenciar(request.getParameter("sequenciar"));
			planoGerenciamentoCronograma.setEstimarrecuso(request.getParameter("estimarrecuso"));					
			planoGerenciamentoCronograma.setEstimarduracao(request.getParameter("estimarduracao"));
			planoGerenciamentoCronograma.setDesenvolver(request.getParameter("desenvolver"));
			planoGerenciamentoCronograma.setControlar(request.getParameter("controlar"));
			
			Integer projetoinicio = Integer.valueOf(request.getParameter("projetoinicio"));										
			planoGerenciamentoCronograma.setProjetoinicio(projetoInicioDAO.getProjetoInicio(projetoinicio));
			
			if(ValidationHelper.validar(planoGerenciamentoCronograma)){
			
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM planogerenciamentocronograma WHERE projetoinicio = '"+request.getParameter("projetoinicio")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("projetoinicio");
				
				if(codigoprojeto >= 1){
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+planoGerenciamentoCronograma.getProjetoinicio().getCodigoprojeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarPlanoGerenciamentoCronograma";//devolver p/ editar cadastro
				}else{
					
					planoGerenciamentoCronogramaDAO.salvar(planoGerenciamentoCronograma);
					request.setAttribute("mensagem", "Plano de Gerenciamento do Cronograma: ("+planoGerenciamentoCronograma.getProjetoinicio().getCodigoprojeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					
					planoGerenciamentoCronogramaDAO.salvar(planoGerenciamentoCronograma);
					request.setAttribute("mensagem", "Plano de Gerenciamento do Cronograma: ("+planoGerenciamentoCronograma.getProjetoinicio().getCodigoprojeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - ");
				return "TkcsapcdController?cmd=editarPlanoGerenciamentoCronograma";//devolver p/ editar cadastro		
	}
}

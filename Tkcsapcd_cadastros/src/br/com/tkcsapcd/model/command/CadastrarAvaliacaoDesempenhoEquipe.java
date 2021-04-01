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

import br.com.tkcsapcd.model.bean.AvaliacaoDesempenhoEquipe;
import br.com.tkcsapcd.model.dao.InterfaceAvaliacaoDesempenhoEquipeDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarAvaliacaoDesempenhoEquipe implements InterfaceCommand {

	private InterfaceAvaliacaoDesempenhoEquipeDAO avaliacaoDesempenhoEquipeDAO;
	public CadastrarAvaliacaoDesempenhoEquipe(InterfaceAvaliacaoDesempenhoEquipeDAO avaliacaoDesempenhoEquipeDAO) {
		super();
		this.avaliacaoDesempenhoEquipeDAO = avaliacaoDesempenhoEquipeDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			AvaliacaoDesempenhoEquipe avaliacaoDesempenhoEquipe = new AvaliacaoDesempenhoEquipe();
					
			avaliacaoDesempenhoEquipe.setAvaliacaodesempenhoequipe(request.getParameter("avaliacaodesempenhoequipe"));
			avaliacaoDesempenhoEquipe.setProjeto(request.getParameter("projeto"));
			avaliacaoDesempenhoEquipe.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			avaliacaoDesempenhoEquipe.setVersao(request.getParameter("versao"));
			avaliacaoDesempenhoEquipe.setData(request.getParameter("data"));
			avaliacaoDesempenhoEquipe.setAutor(request.getParameter("autor"));
			avaliacaoDesempenhoEquipe.setNotarevisao(request.getParameter("notarevisao"));
			avaliacaoDesempenhoEquipe.setAprovacao(request.getParameter("aprovacao"));
			avaliacaoDesempenhoEquipe.setEquipe(request.getParameter("equipe"));				
			avaliacaoDesempenhoEquipe.setPeriodoinicio(request.getParameter("periodoinicio"));					
			avaliacaoDesempenhoEquipe.setPeriodofim(request.getParameter("periodofim"));
			avaliacaoDesempenhoEquipe.setObjetivo(request.getParameter("objetivo"));
			avaliacaoDesempenhoEquipe.setAvaliacao(request.getParameter("retornoavaliacao"));
			avaliacaoDesempenhoEquipe.setIndicador(request.getParameter("indicador"));
			avaliacaoDesempenhoEquipe.setStatus(request.getParameter("status"));
			avaliacaoDesempenhoEquipe.setPontofraco(request.getParameter("pontofraco"));
			avaliacaoDesempenhoEquipe.setPontoforte(request.getParameter("pontoforte"));
			avaliacaoDesempenhoEquipe.setResultadoatingido(request.getParameter("resultadoatingido"));					
			avaliacaoDesempenhoEquipe.setRetornoavaliacao(request.getParameter("retornoavaliacao"));
			avaliacaoDesempenhoEquipe.setPlano(request.getParameter("plano"));
			avaliacaoDesempenhoEquipe.setDefinicao(request.getParameter("definicao"));
			avaliacaoDesempenhoEquipe.setNecessidade(request.getParameter("necessidade"));
			
			if(ValidationHelper.validar(avaliacaoDesempenhoEquipe)){
						
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM avaliacaodesempenhoequipe WHERE data = '"+request.getParameter("data")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer data = rs.getInt("data");
				
				if(data >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com a data ("+avaliacaoDesempenhoEquipe.getData()+"), informada!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarAvaliacaoDesempenhoEquipe";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					avaliacaoDesempenhoEquipeDAO.salvar(avaliacaoDesempenhoEquipe);
					request.setAttribute("mensagem", "AVALIAÇÃO DO DESEMPENHO DA EQUIPE: ("+avaliacaoDesempenhoEquipe.getCodigoprojeto()+") cadastrado com sucesso!");
				}
				stmt.close();
				rs.close();
				con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					avaliacaoDesempenhoEquipeDAO.salvar(avaliacaoDesempenhoEquipe);
					request.setAttribute("mensagem", "AVALIAÇÃO DO DESEMPENHO DA EQUIPE: ("+avaliacaoDesempenhoEquipe.getCodigoprojeto()+") cadastrado com sucesso!");		
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
				request.setAttribute("titulo", "Cadastro - AVALIAÇÃO DO DESEMPENHO DA EQUIPE");
				return "TkcsapcdController?cmd=editarAvaliacaoDesempenhoEquipe";//devolver p/ editar cadastro		
	}
}

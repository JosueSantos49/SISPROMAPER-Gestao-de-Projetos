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

import br.com.tkcsapcd.model.bean.BusinessPlanDetalhe;
import br.com.tkcsapcd.model.dao.InterfaceBusinessPlanDetalheDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarBusinessPlanDetalhe implements InterfaceCommand {

	private InterfaceBusinessPlanDetalheDAO businessPlanDetalheDAO;
	public CadastrarBusinessPlanDetalhe(InterfaceBusinessPlanDetalheDAO businessPlanDetalheDAO) {
		super();
		this.businessPlanDetalheDAO = businessPlanDetalheDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request						
			BusinessPlanDetalhe businessPlanDetalhe = new BusinessPlanDetalhe();
			
			businessPlanDetalhe.setBusinessplan(request.getParameter("businessplan"));
			businessPlanDetalhe.setProjeto(request.getParameter("projeto"));
			businessPlanDetalhe.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			businessPlanDetalhe.setVersao(request.getParameter("versao"));
			businessPlanDetalhe.setData(request.getParameter("data"));
			businessPlanDetalhe.setAutor(request.getParameter("autor"));
			businessPlanDetalhe.setNotarevisao(request.getParameter("notarevisao"));
			businessPlanDetalhe.setAprovacao(request.getParameter("aprovacao"));		
			businessPlanDetalhe.setPosicionamento(request.getParameter("posicionamento"));
			businessPlanDetalhe.setEstrategiaproduto(request.getParameter("estrategiaproduto"));
			businessPlanDetalhe.setProdutooferecido(request.getParameter("produtooferecido"));
			businessPlanDetalhe.setServicooferecido(request.getParameter("servicooferecido"));
			businessPlanDetalhe.setPreco(request.getParameter("preco"));
			businessPlanDetalhe.setDistribuicao(request.getParameter("distribuicao"));
			businessPlanDetalhe.setPromocaovenda(request.getParameter("promocaovenda"));
			businessPlanDetalhe.setTecnologia(request.getParameter("tecnologia"));					
			businessPlanDetalhe.setAcao(request.getParameter("acao"));
			businessPlanDetalhe.setProjetoresultado(request.getParameter("projetoresultado"));
			businessPlanDetalhe.setControle(request.getParameter("controle"));
			businessPlanDetalhe.setContigencia(request.getParameter("contigencia"));
			
			if(ValidationHelper.validar(businessPlanDetalhe)){
						
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM businessplandetalhe WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conex�o e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("codigoprojeto");
				
				if(codigoprojeto >= 1){
					System.out.println("O c�digo � igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('J� existe um registro com o c�digo do projeto ("+businessPlanDetalhe.getCodigoprojeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarBusinessPlanDetalhe";//devolver p/ editar cadastro	
				}else{
					System.out.println("Aviso 1: O c�digo n�o � igual!");
					businessPlanDetalheDAO.salvar(businessPlanDetalhe);
					request.setAttribute("mensagem", "BUSINESS PLAN DETALHES: ("+businessPlanDetalhe.getCodigoprojeto()+") cadastrado com sucesso!");
				}
				stmt.close();
				rs.close();
				con.close();
			}
					System.out.println("Aviso 2: O c�digo n�o � igual!");
					businessPlanDetalheDAO.salvar(businessPlanDetalhe);
					request.setAttribute("mensagem", "BUSINESS PLAN DETALHES: ("+businessPlanDetalhe.getCodigoprojeto()+") cadastrado com sucesso!");		
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
				request.setAttribute("titulo", "Cadastro - BUSINESS PLAN DETALHES");
				return "TkcsapcdController?cmd=editarBusinessPlanDetalhe";//devolver p/ editar cadastro		
	}
}

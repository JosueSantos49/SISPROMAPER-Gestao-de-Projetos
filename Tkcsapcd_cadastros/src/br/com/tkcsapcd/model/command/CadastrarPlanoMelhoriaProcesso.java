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

import br.com.tkcsapcd.model.bean.PlanoMelhoriaProcesso;
import br.com.tkcsapcd.model.dao.InterfacePlanoMelhoriaProcessoDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarPlanoMelhoriaProcesso implements InterfaceCommand {

	private InterfacePlanoMelhoriaProcessoDAO planoMelhoriaProcessoDAO;
	public CadastrarPlanoMelhoriaProcesso(InterfacePlanoMelhoriaProcessoDAO planoMelhoriaProcessoDAO) {
		super();
		this.planoMelhoriaProcessoDAO = planoMelhoriaProcessoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			PlanoMelhoriaProcesso planoMelhoriaProcesso = new PlanoMelhoriaProcesso();		
		
			planoMelhoriaProcesso.setPlanomelhoriaprocesso(request.getParameter("planomelhoriaprocesso"));
			planoMelhoriaProcesso.setProjeto(request.getParameter("projeto"));
			planoMelhoriaProcesso.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			planoMelhoriaProcesso.setVersao(request.getParameter("versao"));
			planoMelhoriaProcesso.setData(request.getParameter("data"));
			planoMelhoriaProcesso.setAutor(request.getParameter("autor"));
			planoMelhoriaProcesso.setNotarevisao(request.getParameter("notarevisao"));
			planoMelhoriaProcesso.setObjetivo(request.getParameter("objetivo"));
			planoMelhoriaProcesso.setLimite(request.getParameter("limite"));
			planoMelhoriaProcesso.setConfiguracao(request.getParameter("configuracao"));
			planoMelhoriaProcesso.setMetrica(request.getParameter("metrica"));
			planoMelhoriaProcesso.setMeta(request.getParameter("meta"));
			planoMelhoriaProcesso.setAprovacao(request.getParameter("aprovacao"));
			
			if(ValidationHelper.validar(planoMelhoriaProcesso)){
				
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM planomelhoriaprocesso WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("codigoprojeto");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+planoMelhoriaProcesso.getCodigoprojeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarPlanoMelhoriaProcesso";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					planoMelhoriaProcessoDAO.salvar(planoMelhoriaProcesso);
					request.setAttribute("mensagem", "PLANO DE MELHORIA DO PROCESSO: ("+planoMelhoriaProcesso.getCodigoprojeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					planoMelhoriaProcessoDAO.salvar(planoMelhoriaProcesso);
					request.setAttribute("mensagem", "PLANO DE MELHORIA DO PROCESSO: ("+planoMelhoriaProcesso.getCodigoprojeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - PLANO DE MELHORIA DO PROCESSO");
				return "TkcsapcdController?cmd=editarPlanoMelhoriaProcesso";//devolver p/ editar cadastro		
	}
}

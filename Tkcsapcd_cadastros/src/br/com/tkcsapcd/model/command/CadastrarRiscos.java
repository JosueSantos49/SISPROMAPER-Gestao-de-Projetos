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

import br.com.tkcsapcd.model.bean.Riscos;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.dao.InterfaceRiscosDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarRiscos implements InterfaceCommand {

	private InterfaceRiscosDAO riscosDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	public CadastrarRiscos(InterfaceRiscosDAO riscosDAO, InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.riscosDAO = riscosDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			Riscos riscos = new Riscos();
			
			riscos.setEmpresa(request.getParameter("empresa"));
			riscos.setOrgao(request.getParameter("orgao"));
			riscos.setSetor(request.getParameter("setor"));
			riscos.setPrograma(request.getParameter("programa"));
			riscos.setGerente(request.getParameter("gerente"));
			riscos.setFuncao(request.getParameter("funcao"));
			riscos.setAprovado(request.getParameter("aprovado"));
			riscos.setVersao(request.getParameter("versao"));
			
			String data_1 = request.getParameter("dataaprovacao"); 
			Date dataaprovacao = new SimpleDateFormat("dd/MM/yyyy").parse(data_1);
			riscos.setDataaprovacao(dataaprovacao);
			
			riscos.setEtapa1(request.getParameter("etapa1"));
			riscos.setEtapa2(request.getParameter("etapa2"));
			riscos.setEtapa3(request.getParameter("etapa3"));
			riscos.setEtapa4(request.getParameter("etapa4"));
			
			Integer projetoinicio = Integer.valueOf(request.getParameter("projetoinicio"));										
			riscos.setProjetoinicio(projetoInicioDAO.getProjetoInicio(projetoinicio));
			
			if(ValidationHelper.validar(riscos)){
				
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM riscos WHERE projetoinicio = '"+request.getParameter("projetoinicio")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Long codigoprojeto = rs.getLong("projetoinicio");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+riscos.getProjetoinicio().getProjeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarRiscos";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					riscosDAO.salvar(riscos);
					request.setAttribute("mensagem", "Gerenciamento de Riscos: ("+riscos.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					riscosDAO.salvar(riscos);
					request.setAttribute("mensagem", "Gerenciamento de Riscos: ("+riscos.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - Gerenciamento de Riscos");
				return "TkcsapcdController?cmd=editarRiscos";//devolver p/ editar cadastro		
	}
}

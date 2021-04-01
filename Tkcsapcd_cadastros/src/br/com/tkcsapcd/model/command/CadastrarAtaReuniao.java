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

import br.com.tkcsapcd.model.bean.AtaReuniao;
import br.com.tkcsapcd.model.dao.InterfaceAtaReuniaoDAO;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarAtaReuniao implements InterfaceCommand {

	private InterfaceAtaReuniaoDAO ataReuniaoDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	
	public CadastrarAtaReuniao(InterfaceAtaReuniaoDAO ataReuniaoDAO, InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.ataReuniaoDAO = ataReuniaoDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			AtaReuniao ataReuniao = new AtaReuniao();
			
			ataReuniao.setAta(request.getParameter("ata"));
			
			String data_1 = request.getParameter("data"); 
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(data_1);
			ataReuniao.setData(data);
			
			ataReuniao.setLocal(request.getParameter("local"));
			ataReuniao.setParticipante(request.getParameter("participante"));
			ataReuniao.setObjetivo(request.getParameter("objetivo"));
			ataReuniao.setTopico(request.getParameter("topico"));				
			ataReuniao.setAcoestomadas(request.getParameter("acoestomadas"));
			ataReuniao.setProximareuniao(request.getParameter("proximareuniao"));
			ataReuniao.setAcoestomadas(request.getParameter("acoestomadas"));
			ataReuniao.setAdicionais(request.getParameter("adicionais"));
			ataReuniao.setAprovacao(request.getParameter("aprovacao"));
			ataReuniao.setVersao(Long.valueOf(request.getParameter("versao")));
			
			Integer projetoinicio = Integer.valueOf(request.getParameter("projetoinicio"));										
			ataReuniao.setProjetoinicio(projetoInicioDAO.getProjetoInicio(projetoinicio));
			
			if(ValidationHelper.validar(ataReuniao)){			
					
				Connection con = ConexaoHelper.conectar();
				PreparedStatement stmt = con.prepareStatement("SELECT * FROM atareuniao WHERE versao = '"+request.getParameter("versao")+"'");// pega a conexão e o Statement
				ResultSet rs = stmt.executeQuery();// executa um select
				
				while(rs.next()){
					
					Long codigodoprojeto = rs.getLong("versao");
					
					if(codigodoprojeto >= 1){				
						
						PrintWriter out = response.getWriter();
						response.setContentType("text/html; charset=ISO-8859-1");
						out.println("<script type=\"text/javascript\">");  
						out.println("alert('Já existe uma versão com o código ("+ataReuniao.getProjetoinicio().getProjeto()+"), informado!');");  
						out.println("</script>");
						
						return "TkcsapcdController?cmd=editarAtaReuniao";//devolver p/ editar cadastro	
					}else{
						ataReuniaoDAO.salvar(ataReuniao);
						request.setAttribute("mensagem", "Ata de Reunião: ("+ataReuniao.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");
					}
						stmt.close();
						rs.close();
						con.close();
				}
				
				ataReuniaoDAO.salvar(ataReuniao);
				request.setAttribute("mensagem", "Ata de Reunião: ("+ataReuniao.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");					
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
				request.setAttribute("titulo", "Cadastro - Ata de Reunião");
				return "TkcsapcdController?cmd=editarAtaReuniao";//devolver p/ editar cadastro		
	}
}

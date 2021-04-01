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

import br.com.tkcsapcd.model.bean.RegistroRiscoAcoes;
import br.com.tkcsapcd.model.dao.InterfaceRegistroRiscoAcoesDAO;
import br.com.tkcsapcd.model.dao.InterfaceRegistroRiscoDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarRegistroRiscoAcoes implements InterfaceCommand {

	private InterfaceRegistroRiscoAcoesDAO registroRiscoAcoesDAO;
	private InterfaceRegistroRiscoDAO registroRiscoDAO;
	public CadastrarRegistroRiscoAcoes(InterfaceRegistroRiscoAcoesDAO registroRiscoAcoesDAO, InterfaceRegistroRiscoDAO registroRiscoDAO) {
		super();
		this.registroRiscoAcoesDAO = registroRiscoAcoesDAO;
		this.registroRiscoDAO = registroRiscoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			RegistroRiscoAcoes registroRiscoAcoes = new RegistroRiscoAcoes();
			
			registroRiscoAcoes.setRegistroriscoacoes(request.getParameter("registroriscoacoes"));
			registroRiscoAcoes.setReferencia(request.getParameter("referencia"));
			registroRiscoAcoes.setPassos(request.getParameter("passos"));
			registroRiscoAcoes.setVersao(request.getParameter("versao"));

			String data_1 = request.getParameter("data"); 
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(data_1);
			registroRiscoAcoes.setData(data);
			
			registroRiscoAcoes.setAutor(request.getParameter("autor"));
			registroRiscoAcoes.setNotarevisao(request.getParameter("notarevisao"));
			registroRiscoAcoes.setPrioridade(request.getParameter("prioridade"));
			registroRiscoAcoes.setDescricaorisco(request.getParameter("descricaorisco"));				
			registroRiscoAcoes.setDescricaoacao(request.getParameter("descricaoacao"));					
			registroRiscoAcoes.setResponsavel(request.getParameter("responsavel"));
			registroRiscoAcoes.setPrevisao(request.getParameter("previsao"));
			registroRiscoAcoes.setStatus(request.getParameter("status"));
			registroRiscoAcoes.setPrevisaooriginal(request.getParameter("previsaooriginal"));
			registroRiscoAcoes.setComentario(request.getParameter("descricaoacao"));
			
			Integer registrorisco = Integer.valueOf(request.getParameter("registrorisco"));			
			registroRiscoAcoes.setRegistrorisco(registroRiscoDAO.getRegistroRisco(registrorisco));
			
			if(ValidationHelper.validar(registroRiscoAcoes)){
				
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM registroriscoacoes WHERE registrorisco = '"+request.getParameter("registrorisco")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("registrorisco");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+registroRiscoAcoes.getRegistrorisco().getRegistrorisco()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarRegistroRiscoAcoes";//devolver p/ editar cadastro	
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					registroRiscoAcoesDAO.salvar(registroRiscoAcoes);
					request.setAttribute("mensagem", "REGISTRO DOS RISCOS AÇÕES: ("+registroRiscoAcoes.getRegistrorisco().getRegistrorisco()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					registroRiscoAcoesDAO.salvar(registroRiscoAcoes);
					request.setAttribute("mensagem", "REGISTRO DOS RISCOS AÇÕES: ("+registroRiscoAcoes.getRegistrorisco().getRegistrorisco()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - REGISTRO DOS RISCOS AÇÕES");
				return "TkcsapcdController?cmd=editarRegistroRiscoAcoes";//devolver p/ editar cadastro		
	}
}

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

import br.com.tkcsapcd.model.bean.RegistroRisco;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.dao.InterfaceRegistroRiscoDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarRegistroRisco implements InterfaceCommand {

	private InterfaceRegistroRiscoDAO registroRiscoDAO;
	private InterfaceProjetoInicioDAO projetoInicioDAO;
	public CadastrarRegistroRisco(InterfaceRegistroRiscoDAO registroRiscoDAO, InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.registroRiscoDAO = registroRiscoDAO;
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			RegistroRisco registroRisco = new RegistroRisco();
			
			registroRisco.setRegistrorisco(request.getParameter("registrorisco"));
			registroRisco.setReferencia(request.getParameter("referencia"));
			registroRisco.setPassos(request.getParameter("passos"));			
			registroRisco.setVersao(request.getParameter("versao"));
			
			String data_1 = request.getParameter("data"); 
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(data_1);
			registroRisco.setData(data);
			
			registroRisco.setAutor(request.getParameter("autor"));
			registroRisco.setNotarevisao(request.getParameter("notarevisao"));
			registroRisco.setSeveridade(Integer.valueOf(request.getParameter("severidade")));
			registroRisco.setDescricao(request.getParameter("descricao"));				
			registroRisco.setProbabilidade(request.getParameter("probabilidade"));					
			registroRisco.setImpacto(request.getParameter("impacto"));
			registroRisco.setDescricaoimpacto(request.getParameter("descricaoimpacto"));
			registroRisco.setCategoria(request.getParameter("categoria"));
			registroRisco.setAcao(request.getParameter("acao"));
			registroRisco.setDescricaoacao(request.getParameter("descricaoacao"));
			registroRisco.setResponsavel(request.getParameter("responsavel"));
			registroRisco.setPrevisao(request.getParameter("previsao"));
			registroRisco.setComentario(request.getParameter("comentario"));
			
			Integer projetoinicio = Integer.valueOf(request.getParameter("projetoinicio"));										
			registroRisco.setProjetoinicio(projetoInicioDAO.getProjetoInicio(projetoinicio));
			
			if(ValidationHelper.validar(registroRisco)){
				
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM registrorisco WHERE projetoinicio = '"+request.getParameter("projetoinicio")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("projetoinicio");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+registroRisco.getProjetoinicio().getProjeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarRegistroRisco";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					registroRiscoDAO.salvar(registroRisco);
					request.setAttribute("mensagem", "REGISTRO DOS RISCOS: ("+registroRisco.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					registroRiscoDAO.salvar(registroRisco);
					request.setAttribute("mensagem", "REGISTRO DOS RISCOS: ("+registroRisco.getProjetoinicio().getProjeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - REGISTRO DOS RISCOS");
				return "TkcsapcdController?cmd=editarRegistroRisco";//devolver p/ editar cadastro		
	}
}

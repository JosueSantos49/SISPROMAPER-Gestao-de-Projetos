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

import br.com.tkcsapcd.model.bean.AtributoAtividade;
import br.com.tkcsapcd.model.dao.InterfaceAtributoAtividadeDAO;
import br.com.tkcsapcd.model.dao.InterfaceOrganogramaDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarAtributoAtividade implements InterfaceCommand {

	private InterfaceAtributoAtividadeDAO atributoAtividadeDAO;
	private InterfaceOrganogramaDAO organogramaDAO;
	
	public CadastrarAtributoAtividade(InterfaceAtributoAtividadeDAO atributoAtividadeDAO, InterfaceOrganogramaDAO organogramaDAO) {
		super();
		this.atributoAtividadeDAO = atributoAtividadeDAO;
		this.organogramaDAO = organogramaDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			AtributoAtividade atributoAtividade = new AtributoAtividade();
			
			atributoAtividade.setId(Long.valueOf(request.getParameter("id")));
			atributoAtividade.setDescricao(request.getParameter("descricao"));
			atributoAtividade.setPredecessora(request.getParameter("predecessora"));
			atributoAtividade.setSucessora(request.getParameter("sucessora"));
			atributoAtividade.setRelacionamento(request.getParameter("relacionamento"));
			atributoAtividade.setAntecipacao(request.getParameter("antecipacao"));
			atributoAtividade.setRecurso(request.getParameter("recurso"));						
			atributoAtividade.setData(request.getParameter("data"));			
			atributoAtividade.setResponsavel(request.getParameter("responsavel"));
			atributoAtividade.setAreageografica(request.getParameter("areageografica"));
			
			Integer organograma = Integer.valueOf(request.getParameter("organograma"));										
			atributoAtividade.setOrganograma(organogramaDAO.getOrganograma(organograma));
			
			if(ValidationHelper.validar(atributoAtividade)){
			
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM atributoatividade WHERE id = '"+request.getParameter("id")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer id = rs.getInt("id");
				
				if(id >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o ID ("+atributoAtividade.getOrganograma().getDescricao()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarAtributoAtividade";//devolver p/ editar cadastro	
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					atributoAtividadeDAO.salvar(atributoAtividade);
					request.setAttribute("mensagem", "Atributos das Atividades: ("+atributoAtividade.getOrganograma().getDescricao()+") cadastrado com sucesso!");
				}
				stmt.close();
				rs.close();
				con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					atributoAtividadeDAO.salvar(atributoAtividade);
					request.setAttribute("mensagem", "Atributos das Atividades: ("+atributoAtividade.getOrganograma().getDescricao()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - Atributos das Atividades");
				return "TkcsapcdController?cmd=editarAtributoAtividade";//devolver p/ editar cadastro		
	}
}

/* 
	Autor: Josu� da Concei��o Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.DiagramaGantt;
import br.com.tkcsapcd.model.dao.InterfaceDiagramaGanttDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarDiagramaGantt implements InterfaceCommand {

	private InterfaceDiagramaGanttDAO diagramaGanttDAO;
	public CadastrarDiagramaGantt(InterfaceDiagramaGanttDAO diagramaGanttDAO) {
		super();
		this.diagramaGanttDAO = diagramaGanttDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			DiagramaGantt diagramaGantt = new DiagramaGantt();
			
			diagramaGantt.setTa(request.getParameter("ta"));
			
			if(ValidationHelper.validar(diagramaGantt)){
			
			/*Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM diagramagantt WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conex�o e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("codigoprojeto");
				
				if(codigoprojeto >= 1){
					System.out.println("O c�digo � igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('J� existe um registro com o c�digo do projeto ("+planoGerenciamentoQualidade.getCodigoprojeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarPlanoGerenciamentoQualidade";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O c�digo n�o � igual!");
					planoGerenciamentoQualidadeDAO.salvar(planoGerenciamentoQualidade);
					request.setAttribute("mensagem", "PLANO DE GERENCIAMENTO DA QUALIDADE: ("+planoGerenciamentoQualidade.getCodigoprojeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}*/
					System.out.println("Aviso 2: O c�digo n�o � igual!");
					diagramaGanttDAO.salvar(diagramaGantt);
					request.setAttribute("mensagem", "Diagrama Gantt cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - Diagrama Gantt");
				return "TkcsapcdController?cmd=editarDiagramaGantt";//devolver p/ editar cadastro		
	}
}

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

import br.com.tkcsapcd.model.bean.MatrizRastreabilidadeRequisito;
import br.com.tkcsapcd.model.dao.InterfaceMatrizRastreabilidadeRequisitoDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarMatrizRastreabilidadeRequisito implements InterfaceCommand {

	private InterfaceMatrizRastreabilidadeRequisitoDAO matrizRastreabilidadeRequisitoDAO;
	public CadastrarMatrizRastreabilidadeRequisito(InterfaceMatrizRastreabilidadeRequisitoDAO matrizRastreabilidadeRequisitoDAO) {
		super();
		this.matrizRastreabilidadeRequisitoDAO = matrizRastreabilidadeRequisitoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			MatrizRastreabilidadeRequisito matrizRastreabilidadeRequisito = new MatrizRastreabilidadeRequisito();
			
			matrizRastreabilidadeRequisito.setCodigomatriz(Integer.valueOf(request.getParameter("codigomatriz")));
			matrizRastreabilidadeRequisito.setPrioridade(request.getParameter("prioridade"));
			matrizRastreabilidadeRequisito.setTipo(request.getParameter("tipo"));
			matrizRastreabilidadeRequisito.setNome(request.getParameter("nome"));
			matrizRastreabilidadeRequisito.setDescricao(request.getParameter("descricao"));
			matrizRastreabilidadeRequisito.setJustificativa(request.getParameter("justificativa"));
			matrizRastreabilidadeRequisito.setCriterio(request.getParameter("criterio"));
			matrizRastreabilidadeRequisito.setSolicitante(request.getParameter("solicitante"));
			matrizRastreabilidadeRequisito.setStatus(request.getParameter("status"));
			
			String data_1 = request.getParameter("data"); 
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(data_1);
			matrizRastreabilidadeRequisito.setData(data);
			
			matrizRastreabilidadeRequisito.setEap(request.getParameter("eap"));				
			matrizRastreabilidadeRequisito.setId(Integer.valueOf(request.getParameter("id")));
			matrizRastreabilidadeRequisito.setComentario(request.getParameter("comentario"));
			
			if(ValidationHelper.validar(matrizRastreabilidadeRequisito)){
				
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM matrizrastreabilidaderequisito WHERE codigomatriz = '"+request.getParameter("codigomatriz")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigomatriz = rs.getInt("codigomatriz");
				
				if(codigomatriz >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código da matriz ("+matrizRastreabilidadeRequisito.getCodigomatriz()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarMatrizRastreabilidadeRequisito";//devolver p/ editar cadastro	
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					matrizRastreabilidadeRequisitoDAO.salvar(matrizRastreabilidadeRequisito);
					request.setAttribute("mensagem", "MATRIZ DE RASTREABILIDADE DOS REQUISITOS: ("+matrizRastreabilidadeRequisito.getCodigomatriz()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					matrizRastreabilidadeRequisitoDAO.salvar(matrizRastreabilidadeRequisito);
					request.setAttribute("mensagem", "MATRIZ DE RASTREABILIDADE DOS REQUISITOS: ("+matrizRastreabilidadeRequisito.getCodigomatriz()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - MATRIZ DE RASTREABILIDADE DOS REQUISITOS");
				return "TkcsapcdController?cmd=editarMatrizRastreabilidadeRequisito";//devolver p/ editar cadastro		
	}
}

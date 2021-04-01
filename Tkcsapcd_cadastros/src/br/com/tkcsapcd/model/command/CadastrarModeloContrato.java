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

import br.com.tkcsapcd.model.bean.ModeloContrato;
import br.com.tkcsapcd.model.dao.InterfaceModeloContratoDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarModeloContrato implements InterfaceCommand {

	private InterfaceModeloContratoDAO modeloContratoDAO;
	public CadastrarModeloContrato(InterfaceModeloContratoDAO modeloContratoDAO) {
		super();
		this.modeloContratoDAO = modeloContratoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			ModeloContrato modeloContrato = new ModeloContrato();
			
			modeloContrato.setModelocontrato(request.getParameter("modelocontrato"));
			modeloContrato.setProjeto(request.getParameter("projeto"));
			modeloContrato.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			modeloContrato.setVersao(request.getParameter("versao"));
			
			String data_1 = request.getParameter("data"); 
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(data_1);
			modeloContrato.setData(data);
			
			modeloContrato.setAutor(request.getParameter("autor"));
			modeloContrato.setNotarevisao(request.getParameter("notarevisao"));
			modeloContrato.setAprovacao(request.getParameter("aprovacao"));
			modeloContrato.setObjetivo(request.getParameter("objetivo"));				
			modeloContrato.setDeclaracao(request.getParameter("declaracao"));					
			modeloContrato.setLinha(request.getParameter("linha"));
			modeloContrato.setRelatorio(request.getParameter("relatorio"));
			modeloContrato.setPeriodo(request.getParameter("periodo"));
			modeloContrato.setPapeis(request.getParameter("papeis"));
			modeloContrato.setLocal(request.getParameter("local"));
			modeloContrato.setDefinicao(request.getParameter("definicao"));
			modeloContrato.setSuporte(request.getParameter("suporte"));
			modeloContrato.setLimitacao(request.getParameter("limitacao"));					
			modeloContrato.setRemuneracao(request.getParameter("remuneracao"));
			modeloContrato.setPenalidade(request.getParameter("penalidade"));
			modeloContrato.setIncentivo(request.getParameter("incentivo"));
			modeloContrato.setSeguro(request.getParameter("seguro"));	
			modeloContrato.setAprovacaocontratacao(request.getParameter("aprovacaocontratacao"));
			modeloContrato.setTratamento(request.getParameter("tratamento"));
			modeloContrato.setMecanismo(request.getParameter("mecanismo"));
			
			
			if(ValidationHelper.validar(modeloContrato)){
			
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM modelocontrato WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoprojeto = rs.getInt("codigoprojeto");
				
				if(codigoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+modeloContrato.getCodigoprojeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarModeloContrato";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					modeloContratoDAO.salvar(modeloContrato);
					request.setAttribute("mensagem", "Adjudicação do contrato de aquisição: ("+modeloContrato.getCodigoprojeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					modeloContratoDAO.salvar(modeloContrato);
					request.setAttribute("mensagem", "Adjudicação do contrato de aquisição: ("+modeloContrato.getCodigoprojeto()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - Adjudicação do contrato de aquisição");
				return "TkcsapcdController?cmd=editarModeloContrato";//devolver p/ editar cadastro		
	}
}

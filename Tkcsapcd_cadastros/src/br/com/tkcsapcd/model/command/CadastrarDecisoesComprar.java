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

import br.com.tkcsapcd.model.bean.DecisoesComprar;
import br.com.tkcsapcd.model.dao.InterfaceDecisoesComprarDAO;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarDecisoesComprar implements InterfaceCommand {

	private InterfaceDecisoesComprarDAO decisoesComprarDAO;
	public CadastrarDecisoesComprar(InterfaceDecisoesComprarDAO decisoesComprarDAO) {
		super();
		this.decisoesComprarDAO = decisoesComprarDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			DecisoesComprar decisoesComprar = new DecisoesComprar();
			
			decisoesComprar.setImportancia(Integer.valueOf(request.getParameter("importancia")));
			decisoesComprar.setCodigoeap(Integer.valueOf(request.getParameter("codigoeap")));
			decisoesComprar.setItens(request.getParameter("itens"));
			decisoesComprar.setUrgencia(request.getParameter("urgencia"));
			decisoesComprar.setImpacto(request.getParameter("impacto"));
			decisoesComprar.setMotivodecisao(request.getParameter("motivodecisao"));
			decisoesComprar.setFornecedores(request.getParameter("fornecedores"));
			decisoesComprar.setQuantidade(Integer.valueOf(request.getParameter("quantidade")));
			decisoesComprar.setCusto(request.getParameter("custo").equals("") ? null : Double.valueOf(request.getParameter("custo")));
			decisoesComprar.setPrevisao(request.getParameter("previsao"));					
			decisoesComprar.setDocaquisicao(request.getParameter("docaquisicao"));
			decisoesComprar.setDescricao(request.getParameter("descricao"));
			decisoesComprar.setTipocontrato(request.getParameter("tipocontrato"));
			decisoesComprar.setStatus(request.getParameter("status"));
			decisoesComprar.setComentarios(request.getParameter("comentarios"));
			
			if(ValidationHelper.validar(decisoesComprar)){
						
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM decisoescomprar WHERE codigoeap = '"+request.getParameter("codigoeap")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigoeap = rs.getInt("codigoeap");
				
				if(codigoeap >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código da EAP ("+decisoesComprar.getCodigoeap()+"), informada!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarDecisoesComprar";//devolver p/ editar cadastro
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					decisoesComprarDAO.salvar(decisoesComprar);
					request.setAttribute("mensagem", "Decisões de Comprar: ("+decisoesComprar.getCodigoeap()+") cadastrado com sucesso!");
				}
				stmt.close();
				rs.close();
				con.close();
			}
					System.out.println("Aviso 2: O código não é igual!");
					decisoesComprarDAO.salvar(decisoesComprar);
					request.setAttribute("mensagem", "Decisões de Comprar: ("+decisoesComprar.getCodigoeap()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - Decisões de Comprar");
				return "TkcsapcdController?cmd=editarDecisoesComprar";//devolver p/ editar cadastro		
	}
}

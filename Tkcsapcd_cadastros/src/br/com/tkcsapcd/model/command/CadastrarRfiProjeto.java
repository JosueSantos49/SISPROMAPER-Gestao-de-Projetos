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

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.RfiProjeto;
import br.com.tkcsapcd.model.dao.InterfaceRfiProjetoDAO;
import br.com.tkcsapcd.model.email.EnviaEmail;
import br.com.tkcsapcd.model.helper.ConexaoHelper;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarRfiProjeto implements InterfaceCommand {
	
	public CadastrarRfiProjeto(InterfaceRfiProjetoDAO rfiProjetoDAO) {
		super();
		this.rfiProjetoDAO = rfiProjetoDAO;
	}
	private InterfaceRfiProjetoDAO rfiProjetoDAO;
	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response) throws Exception {
		try {
			// Preencher o Bean com os valores do request
			RfiProjeto rfiProjeto = new RfiProjeto();	
			
			rfiProjeto.setNome(request.getParameter("nome"));
			rfiProjeto.setEndereco(request.getParameter("endereco"));
			rfiProjeto.setPaginaweb(request.getParameter("paginaweb"));
			rfiProjeto.setProdutoservico(request.getParameter("produtoservico"));
			rfiProjeto.setMercadocliente(request.getParameter("mercadocliente"));
			rfiProjeto.setEstruturapropriedade(request.getParameter("estruturapropriedade"));
			rfiProjeto.setEstruturaempresa(request.getParameter("estruturaempresa"));
			rfiProjeto.setAnosmercado(request.getParameter("anosmercado"));
			rfiProjeto.setLocalizacao(request.getParameter("localizacao"));
			rfiProjeto.setGestaoambiental(request.getParameter("gestaoambiental"));
			rfiProjeto.setGestaoqualidade(request.getParameter("gestaoqualidade"));
			rfiProjeto.setGestaonegocio(request.getParameter("gestaonegocio"));			
			rfiProjeto.setFuncionario(request.getParameter("funcionario"));
			rfiProjeto.setProducao(request.getParameter("producao"));
			rfiProjeto.setMarketingvendas(request.getParameter("marketingvendas"));
			rfiProjeto.setDepartamentoqualidade(request.getParameter("departamentoqualidade"));
			rfiProjeto.setInformacaofinanceira(request.getParameter("informacaofinanceira"));
			rfiProjeto.setVolumenegocio(request.getParameter("volumenegocio"));
			rfiProjeto.setUltimolucroano(request.getParameter("ultimolucroano"));
			rfiProjeto.setMercadoacoes(request.getParameter("mercadoacoes"));
			rfiProjeto.setPessoacontato(request.getParameter("pessoacontato"));
			rfiProjeto.setTelefone(request.getParameter("telefone"));
			rfiProjeto.setEmail(request.getParameter("email"));
			rfiProjeto.setCapacidadehoje(request.getParameter("capacidadehoje"));
			rfiProjeto.setCapacidadeantecipada(request.getParameter("capacidadeantecipada"));
			rfiProjeto.setCondicaonaoatendida(request.getParameter("condicaonaoatendida"));			
			rfiProjeto.setProdutosentregues(request.getParameter("produtosentregues"));
			rfiProjeto.setClientereferenciacomparaveis(request.getParameter("clientereferenciacomparaveis"));
			rfiProjeto.setClientereferencianaocomparaveis(request.getParameter("clientereferencianaocomparaveis"));
			rfiProjeto.setDisponivelentrega(request.getParameter("disponivelentrega"));
			rfiProjeto.setDisponibilidade(request.getParameter("disponibilidade"));
			rfiProjeto.setSuportemundial(request.getParameter("suportemundial"));

			String data_1 = request.getParameter("data"); 
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(data_1);
			rfiProjeto.setData(data);
			
			rfiProjeto.setCnpj(Long.valueOf(request.getParameter("cnpj")));
			
			if(ValidationHelper.validar(rfiProjeto)){
				
				Connection con = ConexaoHelper.conectar();
				PreparedStatement stmt = con.prepareStatement("SELECT * FROM rfiprojeto WHERE cnpj = '"+request.getParameter("cnpj")+"'");// pega a conexão e o Statement
				ResultSet rs = stmt.executeQuery();// executa um select
				
				while(rs.next()){
					
					Long codigodoprojeto = rs.getLong("cnpj");
					
					if(codigodoprojeto >= 1){
												 
						PrintWriter out = response.getWriter();
						response.setContentType("text/html; charset=ISO-8859-1");
						out.println("<script type=\"text/javascript\">");  
						out.println("alert('Já existe um registro com o CNPJ ("+rfiProjeto.getCnpj()+"), informado!');");  
						out.println("</script>");
						
						return "cadastro_rfiprojeto.jsp";//devolver p/ editar cadastro	
					}else{
						rfiProjetoDAO.salvar(rfiProjeto);
						request.setAttribute("mensagem","RFI-Projeto: ("+rfiProjeto.getNome()+") cadastrado com sucesso!");
					}
						stmt.close();
						rs.close();
						con.close();
				}
				
				rfiProjetoDAO.salvar(rfiProjeto);
				request.setAttribute("mensagem","RFI-Projeto: ("+rfiProjeto.getNome()+") cadastrado com sucesso!");
				
				//Regra de envio de e-mail Javamail. Confirmação de registro
				//String de 		= request.getParameter("de");
				String para 	= request.getParameter("email");
				//String assunto 	= request.getParameter("assunto");
				//String mensagem = request.getParameter("mensagem");
				//String lista 	= request.getParameter("lista");
						
				RequestDispatcher rd = null;
				
				EnviaEmail enviaEmail = new EnviaEmail();
				
					//enviaEmail.setDe(de);
					enviaEmail.setPara(para);
					//enviaEmail.setAssunto(assunto);
					//enviaEmail.setMensagem(mensagem);			
					//enviaEmail.setLista(lista);		
				
				boolean enviado = enviaEmail.enviarRFP();		
				
				if(enviado)
					request.setAttribute("msg", "E-mail enviado com sucesso!");	
				else
					request.setAttribute("msg", "E-mail não enviado!");				
				
				rd = request.getRequestDispatcher("TkcsapcdController?cmd=editarRfiProjeto");
				rd.forward(request, response);
				
			}
			else{
				throw new Exception("Valor Inválido");
			}
			
		} catch (SQLException e) {
			
			request.setAttribute("mensagem","Problemas com a gravação: " + e.getMessage());
			e.printStackTrace();
			
		} catch (NumberFormatException e) {
			
			request.setAttribute("mensagem","Valor inválido: " + e.getMessage());
			e.printStackTrace();
		}
			request.setAttribute("titulo", "Cadastro - RFI Projeto");
			return "TkcsapcdController?cmd=editarRfiProjeto";// devolver para o editar
	}

}

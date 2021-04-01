/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.EnvolvimentoPessoaProjetoInicio;
import br.com.tkcsapcd.model.dao.InterfaceEnvolvimentoPessoaProjetoInicioDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarEnvolvimentoPessoaProjetoInicio implements InterfaceCommand {

	private InterfaceEnvolvimentoPessoaProjetoInicioDAO envolvimentoPessoaProjetoInicioDAO;	
	public CadastrarEnvolvimentoPessoaProjetoInicio(InterfaceEnvolvimentoPessoaProjetoInicioDAO envolvimentoPessoaProjetoInicioDAO) {
		super();
		this.envolvimentoPessoaProjetoInicioDAO = envolvimentoPessoaProjetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			//  Preencher o Bean com os valores do request
			EnvolvimentoPessoaProjetoInicio envolvimentoPessoaProjetoInicio = new EnvolvimentoPessoaProjetoInicio();
			//Date periodo_1 = new Date();
			
			//inicio 1
			envolvimentoPessoaProjetoInicio.setCodigoprojeto1(Integer.valueOf(request.getParameter("codigoprojeto1")));
			envolvimentoPessoaProjetoInicio.setOrganizacao1(request.getParameter("organizacao1"));
			envolvimentoPessoaProjetoInicio.setRh1(request.getParameter("rh1"));
			envolvimentoPessoaProjetoInicio.setTiporh1(request.getParameter("tiporh1"));
			
			String periodo_1 = request.getParameter("periodo1");
			Date periodo1 = new SimpleDateFormat("dd/MM/yyyy").parse(periodo_1);			
			/*
			//Atenção este código abaixo tenta executar a formatação da data no myql
			 * SimpleDateFormat periodo01 = new SimpleDateFormat("dd/MM/yyyy");
			periodo01.format(periodo1);			
			String str = periodo01.format(periodo1);			
			System.out.println("Status 1: "+str);*/		
			envolvimentoPessoaProjetoInicio.setPeriodo1(periodo1); 			
				
			envolvimentoPessoaProjetoInicio.setEsforco1(Integer.valueOf(request.getParameter("esforco1")));
			//fim 1
			
			//inicio 2
			envolvimentoPessoaProjetoInicio.setCodigoprojeto2(Integer.valueOf(request.getParameter("codigoprojeto2")));
			envolvimentoPessoaProjetoInicio.setOrganizacao2(request.getParameter("organizacao2"));
			envolvimentoPessoaProjetoInicio.setRh2(request.getParameter("rh2"));
			envolvimentoPessoaProjetoInicio.setTiporh2(request.getParameter("tiporh2"));
			
			String periodo_2 = request.getParameter("periodo2"); 
			Date periodo2 =  new SimpleDateFormat("dd/MM/yyyy").parse(periodo_2);
			envolvimentoPessoaProjetoInicio.setPeriodo2(periodo2);
			
			envolvimentoPessoaProjetoInicio.setEsforco2(Integer.valueOf(request.getParameter("esforco2")));
			//fim 2
			
			//inicio 3
			envolvimentoPessoaProjetoInicio.setCodigoprojeto3(Integer.valueOf(request.getParameter("codigoprojeto3")));
			envolvimentoPessoaProjetoInicio.setOrganizacao3(request.getParameter("organizacao3"));
			envolvimentoPessoaProjetoInicio.setRh3(request.getParameter("rh3"));
			envolvimentoPessoaProjetoInicio.setTiporh3(request.getParameter("tiporh3"));
			
			String periodo_3 = request.getParameter("periodo3"); 
			Date periodo3 = new SimpleDateFormat("dd/MM/yyyy").parse(periodo_3);
			envolvimentoPessoaProjetoInicio.setPeriodo3(periodo3); 
			
			envolvimentoPessoaProjetoInicio.setEsforco3(Integer.valueOf(request.getParameter("esforco3")));
			//fim 3
			
			//inicio 4
			envolvimentoPessoaProjetoInicio.setCodigoprojeto4(Integer.valueOf(request.getParameter("codigoprojeto4")));
			envolvimentoPessoaProjetoInicio.setOrganizacao4(request.getParameter("organizacao4"));
			envolvimentoPessoaProjetoInicio.setRh4(request.getParameter("rh4"));
			envolvimentoPessoaProjetoInicio.setTiporh4(request.getParameter("tiporh4"));

			String periodo_4 = request.getParameter("periodo4"); 
			Date periodo4 = new SimpleDateFormat("dd/MM/yyyy").parse(periodo_4);
			envolvimentoPessoaProjetoInicio.setPeriodo4(periodo4);
			
			envolvimentoPessoaProjetoInicio.setEsforco4(Integer.valueOf(request.getParameter("esforco4")));
			//fim 4
			
			//inicio 5
			envolvimentoPessoaProjetoInicio.setCodigoprojeto5(Integer.valueOf(request.getParameter("codigoprojeto5")));
			envolvimentoPessoaProjetoInicio.setOrganizacao5(request.getParameter("organizacao5"));
			envolvimentoPessoaProjetoInicio.setRh5(request.getParameter("rh5"));
			envolvimentoPessoaProjetoInicio.setTiporh5(request.getParameter("tiporh5"));

			String periodo_5 = request.getParameter("periodo5"); 
			Date periodo5 = new SimpleDateFormat("dd/MM/yyyy").parse(periodo_5);
			envolvimentoPessoaProjetoInicio.setPeriodo5(periodo5);
			
			envolvimentoPessoaProjetoInicio.setEsforco5(Integer.valueOf(request.getParameter("esforco5")));
			
			//fim 5
			
			//inicio 6
			envolvimentoPessoaProjetoInicio.setCodigoprojeto6(Integer.valueOf(request.getParameter("codigoprojeto6")));
			envolvimentoPessoaProjetoInicio.setOrganizacao6(request.getParameter("organizacao6"));
			envolvimentoPessoaProjetoInicio.setRh6(request.getParameter("rh6"));
			envolvimentoPessoaProjetoInicio.setTiporh6(request.getParameter("tiporh6"));

			String periodo_6 = request.getParameter("periodo6"); 
			Date periodo6 = new SimpleDateFormat("dd/MM/yyyy").parse(periodo_6);
			envolvimentoPessoaProjetoInicio.setPeriodo6(periodo6);
			
			envolvimentoPessoaProjetoInicio.setEsforco6(Integer.valueOf(request.getParameter("esforco6")));
			//fim 6
						
			if(ValidationHelper.validar(envolvimentoPessoaProjetoInicio)){
			/*	
			Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM envolvimentopessoa WHERE codigoprojeto1 = '"+request.getParameter("codigoprojeto1")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
				Integer codigoprojeto1 = rs.getInt("codigoprojeto1");
				
				if(codigoprojeto1 >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+envolvimentoPessoaProjetoInicio.getCodigoprojeto1()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=editarEnvolvimentoPessoaProjetoInicio";
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					envolvimentoPessoaProjetoInicioDAO.salvar(envolvimentoPessoaProjetoInicio);
					request.setAttribute("mensagem", "Envolvimento Pessoa Projeto: ("+envolvimentoPessoaProjetoInicio.getCodigoprojeto1()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}*/
					System.out.println("Aviso 2: O código não é igual!");
					envolvimentoPessoaProjetoInicioDAO.salvar(envolvimentoPessoaProjetoInicio);
					request.setAttribute("mensagem", "Envolvimento Pessoa Projeto: ("+envolvimentoPessoaProjetoInicio.getCodigoprojeto1()+") cadastrado com sucesso!");			
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
				request.setAttribute("titulo", "Cadastro - Envolvimento Pessoa Projeto");
				return "TkcsapcdController?cmd=editarEnvolvimentoPessoaProjetoInicio";//devolver p/ editar cadastro		
	}
}

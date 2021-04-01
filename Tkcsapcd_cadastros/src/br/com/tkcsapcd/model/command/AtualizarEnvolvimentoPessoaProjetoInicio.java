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
//Método registrado na InterfaceCommand
public class AtualizarEnvolvimentoPessoaProjetoInicio implements InterfaceCommand {

	private InterfaceEnvolvimentoPessoaProjetoInicioDAO envolvimentoPessoaProjetoInicioDAO;
	
	public AtualizarEnvolvimentoPessoaProjetoInicio(InterfaceEnvolvimentoPessoaProjetoInicioDAO envolvimentoPessoaProjetoInicioDAO) {
		super();
		this.envolvimentoPessoaProjetoInicioDAO = envolvimentoPessoaProjetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {				
					
					//  Preencher o Bean com os valores do request
					EnvolvimentoPessoaProjetoInicio envolvimentoPessoaProjetoInicio = new EnvolvimentoPessoaProjetoInicio();			
					
					envolvimentoPessoaProjetoInicio.setCodigo(Integer.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					
					//inicio 1
					envolvimentoPessoaProjetoInicio.setCodigoprojeto1(Integer.valueOf(request.getParameter("codigoprojeto1")));
					envolvimentoPessoaProjetoInicio.setOrganizacao1(request.getParameter("organizacao1"));
					envolvimentoPessoaProjetoInicio.setRh1(request.getParameter("rh1"));
					envolvimentoPessoaProjetoInicio.setTiporh1(request.getParameter("tiporh1"));
					
					String periodo_1 = request.getParameter("periodo1"); 
					Date periodo1 = new SimpleDateFormat("yyyy-MM-dd").parse(periodo_1);
					envolvimentoPessoaProjetoInicio.setPeriodo1(periodo1);			
					
					envolvimentoPessoaProjetoInicio.setEsforco1(Integer.valueOf(request.getParameter("esforco1")));
					//fim 1
					
					//inicio 2
					envolvimentoPessoaProjetoInicio.setCodigoprojeto2(Integer.valueOf(request.getParameter("codigoprojeto2")));
					envolvimentoPessoaProjetoInicio.setOrganizacao2(request.getParameter("organizacao2"));
					envolvimentoPessoaProjetoInicio.setRh2(request.getParameter("rh2"));
					envolvimentoPessoaProjetoInicio.setTiporh2(request.getParameter("tiporh2"));
					
					String periodo_2 = request.getParameter("periodo2"); 
					Date periodo2 = new SimpleDateFormat("yyyy-MM-dd").parse(periodo_2);
					envolvimentoPessoaProjetoInicio.setPeriodo2(periodo2);
					
					envolvimentoPessoaProjetoInicio.setEsforco2(Integer.valueOf(request.getParameter("esforco2")));
					//fim 2
					
					//inicio 3
					envolvimentoPessoaProjetoInicio.setCodigoprojeto3(Integer.valueOf(request.getParameter("codigoprojeto3")));
					envolvimentoPessoaProjetoInicio.setOrganizacao3(request.getParameter("organizacao3"));
					envolvimentoPessoaProjetoInicio.setRh3(request.getParameter("rh3"));
					envolvimentoPessoaProjetoInicio.setTiporh3(request.getParameter("tiporh3"));
					
					String periodo_3 = request.getParameter("periodo3"); 
					Date periodo3 = new SimpleDateFormat("yyyy-MM-dd").parse(periodo_3);
					envolvimentoPessoaProjetoInicio.setPeriodo3(periodo3); 
					
					envolvimentoPessoaProjetoInicio.setEsforco3(Integer.valueOf(request.getParameter("esforco3")));
					//fim 3
					
					//inicio 4
					envolvimentoPessoaProjetoInicio.setCodigoprojeto4(Integer.valueOf(request.getParameter("codigoprojeto4")));
					envolvimentoPessoaProjetoInicio.setOrganizacao4(request.getParameter("organizacao4"));
					envolvimentoPessoaProjetoInicio.setRh4(request.getParameter("rh4"));
					envolvimentoPessoaProjetoInicio.setTiporh4(request.getParameter("tiporh4"));

					String periodo_4 = request.getParameter("periodo4"); 
					Date periodo4 = new SimpleDateFormat("yyyy-MM-dd").parse(periodo_4);
					envolvimentoPessoaProjetoInicio.setPeriodo4(periodo4);
					
					envolvimentoPessoaProjetoInicio.setEsforco4(Integer.valueOf(request.getParameter("esforco4")));
					//fim 4
					
					//inicio 5
					envolvimentoPessoaProjetoInicio.setCodigoprojeto5(Integer.valueOf(request.getParameter("codigoprojeto5")));
					envolvimentoPessoaProjetoInicio.setOrganizacao5(request.getParameter("organizacao5"));
					envolvimentoPessoaProjetoInicio.setRh5(request.getParameter("rh5"));
					envolvimentoPessoaProjetoInicio.setTiporh5(request.getParameter("tiporh5"));

					String periodo_5 = request.getParameter("periodo5"); 
					Date periodo5 = new SimpleDateFormat("yyyy-MM-dd").parse(periodo_5);
					envolvimentoPessoaProjetoInicio.setPeriodo5(periodo5);
					
					envolvimentoPessoaProjetoInicio.setEsforco5(Integer.valueOf(request.getParameter("esforco5")));
					
					//fim 5
					
					//inicio 6
					envolvimentoPessoaProjetoInicio.setCodigoprojeto6(Integer.valueOf(request.getParameter("codigoprojeto6")));
					envolvimentoPessoaProjetoInicio.setOrganizacao6(request.getParameter("organizacao6"));
					envolvimentoPessoaProjetoInicio.setRh6(request.getParameter("rh6"));
					envolvimentoPessoaProjetoInicio.setTiporh6(request.getParameter("tiporh6"));

					String periodo_6 = request.getParameter("periodo6"); 
					Date periodo6 = new SimpleDateFormat("yyyy-MM-dd").parse(periodo_6);
					envolvimentoPessoaProjetoInicio.setPeriodo6(periodo6);
					
					envolvimentoPessoaProjetoInicio.setEsforco6(Integer.valueOf(request.getParameter("esforco6")));
					//fim 6
		
		if(ValidationHelper.validar(envolvimentoPessoaProjetoInicio)){		
			envolvimentoPessoaProjetoInicioDAO.atualizar(envolvimentoPessoaProjetoInicio);
			request.setAttribute("mensagem", "Envolvimento Pessoa Projeto: ("+envolvimentoPessoaProjetoInicio.getCodigoprojeto1()+") atualizado com sucesso!");
		}else{
				throw new Exception("Valor inválido");
		}	
		} catch (SQLException e) {
			
			request.setAttribute("mensagem", "Problema com a atualização: "+e.getMessage());
			e.printStackTrace();
			
		}catch (NumberFormatException e) {
			request.setAttribute("mensagem", "Valor inválido: "+e.getMessage());			
		}	
			request.setAttribute("titulo", "Atualização - Envolvimento Pessoa Projeto");
			return "TkcsapcdController?cmd=consultarEnvolvimentoPessoaProjetoInicio";//Pagina de Retorno (pagina consulta cliente)
	}

}

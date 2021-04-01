/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.command;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tkcsapcd.model.bean.ProjetoInicio;
import br.com.tkcsapcd.model.dao.InterfaceProjetoInicioDAO;
import br.com.tkcsapcd.model.email.EnviaEmail;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarProjetoInicio implements InterfaceCommand {

	private InterfaceProjetoInicioDAO projetoInicioDAO;
	
	public AtualizarProjetoInicio(InterfaceProjetoInicioDAO projetoInicioDAO) {
		super();
		this.projetoInicioDAO = projetoInicioDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {	
			ProjetoInicio projetoInicio = new ProjetoInicio();// Codigo de processamento

			projetoInicio.setCodigo(Long.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
			projetoInicio.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			projetoInicio.setProjeto(request.getParameter("projeto"));
			
			String data_1 = request.getParameter("data"); 
			Date data = new SimpleDateFormat("yyyy-MM-dd").parse(data_1);
			projetoInicio.setData(data);
			
			projetoInicio.setAtribuiprojeto(request.getParameter("atribuiprojeto"));
			projetoInicio.setTipoprojeto(request.getParameter("tipoprojeto"));
			projetoInicio.setObjetivo(request.getParameter("objetivo"));
			projetoInicio.setCliente(request.getParameter("cliente"));
			projetoInicio.setPrograma(request.getParameter("programa"));
			projetoInicio.setArea(request.getParameter("area"));
			
			projetoInicio.setRoi(request.getParameter("roi").equals("") ? null : Double.valueOf(request.getParameter("roi")));
			
			projetoInicio.setDescricao(request.getParameter("descricao"));
			projetoInicio.setCopia(request.getParameter("copia"));
		
		if(ValidationHelper.validar(projetoInicio)){		
			projetoInicioDAO.atualizar(projetoInicio);
			request.setAttribute("mensagem", "Projeto: ("+projetoInicio.getCodigoprojeto()+") atualizado com sucesso!");
			
			/*Regra que objetiva disparar um e-mail automático como confirmação de registro.
			 * O Metodo enviarForm() é responsável, por enviar e-mail de confirmação de envio de formulários.
			 */
			String projeto 			= request.getParameter("projeto");
			String objetivo 		= request.getParameter("objetivo");	
			String copia			= request.getParameter("copia");									
			
			RequestDispatcher rd = null;					
			EnviaEmail email = new EnviaEmail();
			
			email.setProjeto(projeto);
			email.setObjetivo(objetivo);
			email.setCopia(copia);					
			
			boolean enviado = email.enviarProjetoInicio();
			
			if(enviado)
				request.setAttribute("msg","Enviado confirmação de registro por e-mail!");
			else
				request.setAttribute("msg","Não, enviado cópia de confirmação de registro por e-mail!");
			rd = request.getRequestDispatcher("TkcsapcdController?cmd=consultarProjetoInicio");
			rd.forward(request,response);
			
		}else{
				throw new Exception("Valor inválido");
		}	
		} catch (SQLException e) {
			
			request.setAttribute("mensagem", "Problema com a atualização: "+e.getMessage());
			e.printStackTrace();
			
		}catch (NumberFormatException e) {
			request.setAttribute("mensagem", "Valor inválido: "+e.getMessage());			
		}	
			request.setAttribute("titulo", "Atualização - Projeto");
			return "TkcsapcdController?cmd=consultarProjetoInicio";//Pagina de Retorno (pagina consulta)
	}

}

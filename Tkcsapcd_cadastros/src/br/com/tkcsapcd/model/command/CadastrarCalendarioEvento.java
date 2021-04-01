/* 
	Autor: Josu� da Concei��o Santos
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

import br.com.tkcsapcd.model.bean.CalendarioEvento;
import br.com.tkcsapcd.model.dao.InterfaceCalendarioEventoDAO;
import br.com.tkcsapcd.model.email.EnviaEmail;
import br.com.tkcsapcd.model.helper.ValidationHelper;

public class CadastrarCalendarioEvento implements InterfaceCommand {

	private InterfaceCalendarioEventoDAO calendarioEventoDAO;	
	public CadastrarCalendarioEvento(InterfaceCalendarioEventoDAO calendarioEventoDAO) {
		super();
		this.calendarioEventoDAO = calendarioEventoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception{
		try {
			
			//  Preencher o Bean com os valores do request
			CalendarioEvento calendarioEvento = new CalendarioEvento();							
			
			calendarioEvento.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			
			String data_1 = request.getParameter("data"); 
			Date data =  new SimpleDateFormat("dd/MM/yyyy").parse(data_1);
			calendarioEvento.setData(data);
			
			calendarioEvento.setIniciar(request.getParameter("iniciar"));
			calendarioEvento.setDuracao(request.getParameter("duracao"));
			calendarioEvento.setLocal(request.getParameter("local"));
			calendarioEvento.setAssunto(request.getParameter("assunto"));
			calendarioEvento.setDescricao(request.getParameter("descricao"));
			calendarioEvento.setResponsavel(request.getParameter("responsavel"));
			calendarioEvento.setFrequencia(request.getParameter("frequencia"));
			calendarioEvento.setParticipantes(request.getParameter("participantes"));
			
			if(ValidationHelper.validar(calendarioEvento)){
				
			/*Connection con = ConexaoHelper.conectar();
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM calendarioevento WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conex�o e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigodoprojeto = rs.getInt("codigoprojeto");
				
				if(codigodoprojeto >= 1){
					System.out.println("O c�digo � igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('J� existe um registro com o c�digo do projeto ("+calendarioEvento.getCodigoprojeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=consultarCalendarioEvento";	
				}else{
					System.out.println("Aviso 1: O c�digo n�o � igual!");
					calendarioEventoDAO.salvar(calendarioEvento);
					request.setAttribute("mensagem", "Calend�rio Evento: ("+calendarioEvento.getCodigoprojeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
			*/
					System.out.println("Aviso 2: O c�digo n�o � igual!");
					calendarioEventoDAO.salvar(calendarioEvento);
					request.setAttribute("mensagem", "Calend�rio Evento: ("+calendarioEvento.getCodigoprojeto()+") cadastrado com sucesso!");	
					
					/*Regra que objetiva disparar um e-mail autom�tico como confirma��o de registro.
					 * O Metodo enviarForm() � respons�vel, por enviar e-mail de confirma��o de envio de formul�rios.
					 */
					String assunto 			= request.getParameter("assunto");
					String participantes 	= request.getParameter("participantes");//adicionar somente um e-mail no campo de c�pia. Tentei colocar ";" entre os e-mails e deu erro. Este suposto e-mail pode ser do "Grupo do departamento"
					String descricao 		= request.getParameter("descricao");					
					
					RequestDispatcher rd = null;
					
					EnviaEmail email = new EnviaEmail();
					
					email.setAssunto(assunto);
					email.setParticipantes(participantes);
					email.setDescricao(descricao);
					
					boolean enviado = email.enviarEventoParticipante();
					
					if(enviado)
						request.setAttribute("msg","Enviado c�pia de evento para paerticipante!");
					else
						request.setAttribute("msg","N�o, enviado c�pia de evento para paerticipante!");
					rd = request.getRequestDispatcher("TkcsapcdController?cmd=consultarCalendarioEvento");
					rd.forward(request,response);
					
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
				request.setAttribute("titulo", "Cadastro - Calend�rio Evento");
				return "TkcsapcdController?cmd=consultarCalendarioEvento";
				//return "cadastro_calendario_evento.jsp";
				//return "TkcsapcdController?cmd=editarProjetoInicio";//devolver p/ editar cadastro		
	}
}

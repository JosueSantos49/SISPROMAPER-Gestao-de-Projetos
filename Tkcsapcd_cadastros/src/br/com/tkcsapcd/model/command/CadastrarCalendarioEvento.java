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
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM calendarioevento WHERE codigoprojeto = '"+request.getParameter("codigoprojeto")+"'");// pega a conexão e o Statement
			ResultSet rs = stmt.executeQuery();// executa um select
			
			while(rs.next()){
				
				Integer codigodoprojeto = rs.getInt("codigoprojeto");
				
				if(codigodoprojeto >= 1){
					System.out.println("O código é igual!");
											 
					PrintWriter out = response.getWriter();
					response.setContentType("text/html; charset=ISO-8859-1");
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('Já existe um registro com o código do projeto ("+calendarioEvento.getCodigoprojeto()+"), informado!');");  
					out.println("</script>");
					
					return "TkcsapcdController?cmd=consultarCalendarioEvento";	
				}else{
					System.out.println("Aviso 1: O código não é igual!");
					calendarioEventoDAO.salvar(calendarioEvento);
					request.setAttribute("mensagem", "Calendário Evento: ("+calendarioEvento.getCodigoprojeto()+") cadastrado com sucesso!");
				}
					stmt.close();
					rs.close();
					con.close();
			}
			*/
					System.out.println("Aviso 2: O código não é igual!");
					calendarioEventoDAO.salvar(calendarioEvento);
					request.setAttribute("mensagem", "Calendário Evento: ("+calendarioEvento.getCodigoprojeto()+") cadastrado com sucesso!");	
					
					/*Regra que objetiva disparar um e-mail automático como confirmação de registro.
					 * O Metodo enviarForm() é responsável, por enviar e-mail de confirmação de envio de formulários.
					 */
					String assunto 			= request.getParameter("assunto");
					String participantes 	= request.getParameter("participantes");//adicionar somente um e-mail no campo de cópia. Tentei colocar ";" entre os e-mails e deu erro. Este suposto e-mail pode ser do "Grupo do departamento"
					String descricao 		= request.getParameter("descricao");					
					
					RequestDispatcher rd = null;
					
					EnviaEmail email = new EnviaEmail();
					
					email.setAssunto(assunto);
					email.setParticipantes(participantes);
					email.setDescricao(descricao);
					
					boolean enviado = email.enviarEventoParticipante();
					
					if(enviado)
						request.setAttribute("msg","Enviado cópia de evento para paerticipante!");
					else
						request.setAttribute("msg","Não, enviado cópia de evento para paerticipante!");
					rd = request.getRequestDispatcher("TkcsapcdController?cmd=consultarCalendarioEvento");
					rd.forward(request,response);
					
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
				request.setAttribute("titulo", "Cadastro - Calendário Evento");
				return "TkcsapcdController?cmd=consultarCalendarioEvento";
				//return "cadastro_calendario_evento.jsp";
				//return "TkcsapcdController?cmd=editarProjetoInicio";//devolver p/ editar cadastro		
	}
}

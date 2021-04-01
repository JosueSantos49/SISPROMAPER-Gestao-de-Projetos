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

import br.com.tkcsapcd.model.bean.Rfq;
import br.com.tkcsapcd.model.dao.InterfaceRfqDAO;
import br.com.tkcsapcd.model.email.EnviaEmail;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarRfq implements InterfaceCommand {

	private InterfaceRfqDAO rfqDAO;
	public AtualizarRfq(InterfaceRfqDAO rfqDAO) {
		super();
		this.rfqDAO = rfqDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request					
					Rfq rfq = new Rfq();
					
					rfq.setCodigo(Long.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação
					String data_1 = request.getParameter("data"); 
					Date data =  new SimpleDateFormat("yyyy-MM-dd").parse(data_1);
					rfq.setData(data);
					
					rfq.setNumerorfq(Integer.valueOf(request.getParameter("numerorfq")));
					rfq.setPrazoentrega(request.getParameter("prazoentrega"));
					rfq.setContatocomercial(request.getParameter("contatocomercial"));
					rfq.setContatotecnico(request.getParameter("contatotecnico"));
					
					String datalimite_1 = request.getParameter("datalimite"); 
					Date datalimite =  new SimpleDateFormat("yyyy-MM-dd").parse(datalimite_1);
					rfq.setDatalimite(datalimite);
								
					rfq.setTermopagamento(request.getParameter("termopagamento"));
					rfq.setTempogarantia(request.getParameter("tempogarantia"));
					rfq.setOutracondicao(request.getParameter("outracondicao"));				
					rfq.setEmpresa(request.getParameter("empresa"));					
					rfq.setEndereco(request.getParameter("endereco"));
					rfq.setCidade(request.getParameter("cidade"));
					rfq.setEstado(request.getParameter("estado"));
					rfq.setTelefone(request.getParameter("telefone"));	
					
					rfq.setCodigoitem1(Integer.parseInt(request.getParameter("codigoitem1")));
					rfq.setCodigoitem2(Integer.parseInt(request.getParameter("codigoitem2")));
					rfq.setCodigoitem3(Integer.parseInt(request.getParameter("codigoitem3")));
					rfq.setCodigoitem4(Integer.parseInt(request.getParameter("codigoitem4")));
					rfq.setCodigoitem5(Integer.parseInt(request.getParameter("codigoitem5")));
					rfq.setCodigoitem6(Integer.parseInt(request.getParameter("codigoitem6")));
					rfq.setCodigoitem7(Integer.parseInt(request.getParameter("codigoitem7")));
					rfq.setCodigoitem8(Integer.parseInt(request.getParameter("codigoitem8")));
					rfq.setCodigoitem9(Integer.parseInt(request.getParameter("codigoitem9")));
					rfq.setCodigoitem10(Integer.parseInt(request.getParameter("codigoitem10")));
					rfq.setCodigoitem11(Integer.parseInt(request.getParameter("codigoitem11")));
					rfq.setCodigoitem12(Integer.parseInt(request.getParameter("codigoitem12")));
					rfq.setCodigoitem13(Integer.parseInt(request.getParameter("codigoitem13")));
					rfq.setCodigoitem14(Integer.parseInt(request.getParameter("codigoitem14")));
					rfq.setCodigoitem15(Integer.parseInt(request.getParameter("codigoitem15")));
					rfq.setCodigoitem16(Integer.parseInt(request.getParameter("codigoitem16")));
					rfq.setCodigoitem17(Integer.parseInt(request.getParameter("codigoitem17")));
					rfq.setCodigoitem18(Integer.parseInt(request.getParameter("codigoitem18")));
					rfq.setCodigoitem19(Integer.parseInt(request.getParameter("codigoitem19")));
					rfq.setCodigoitem20(Integer.parseInt(request.getParameter("codigoitem20")));	
					
					rfq.setDescricao1(request.getParameter("descricao1"));
					rfq.setDescricao2(request.getParameter("descricao2"));
					rfq.setDescricao3(request.getParameter("descricao3"));
					rfq.setDescricao4(request.getParameter("descricao4"));
					rfq.setDescricao5(request.getParameter("descricao5"));
					rfq.setDescricao6(request.getParameter("descricao6"));
					rfq.setDescricao7(request.getParameter("descricao7"));
					rfq.setDescricao8(request.getParameter("descricao8"));
					rfq.setDescricao9(request.getParameter("descricao9"));
					rfq.setDescricao10(request.getParameter("descricao10"));
					rfq.setDescricao11(request.getParameter("descricao11"));
					rfq.setDescricao12(request.getParameter("descricao12"));
					rfq.setDescricao13(request.getParameter("descricao13"));
					rfq.setDescricao14(request.getParameter("descricao14"));
					rfq.setDescricao15(request.getParameter("descricao15"));
					rfq.setDescricao16(request.getParameter("descricao16"));
					rfq.setDescricao17(request.getParameter("descricao17"));
					rfq.setDescricao18(request.getParameter("descricao18"));
					rfq.setDescricao19(request.getParameter("descricao19"));
					rfq.setDescricao20(request.getParameter("descricao20"));
					
					rfq.setQtd1(Integer.parseInt(request.getParameter("qtd1")));
					rfq.setQtd2(Integer.parseInt(request.getParameter("qtd2")));
					rfq.setQtd3(Integer.parseInt(request.getParameter("qtd3")));
					rfq.setQtd4(Integer.parseInt(request.getParameter("qtd4")));
					rfq.setQtd5(Integer.parseInt(request.getParameter("qtd5")));
					rfq.setQtd6(Integer.parseInt(request.getParameter("qtd6")));
					rfq.setQtd7(Integer.parseInt(request.getParameter("qtd7")));
					rfq.setQtd8(Integer.parseInt(request.getParameter("qtd8")));
					rfq.setQtd9(Integer.parseInt(request.getParameter("qtd9")));
					rfq.setQtd10(Integer.parseInt(request.getParameter("qtd10")));
					rfq.setQtd11(Integer.parseInt(request.getParameter("qtd11")));
					rfq.setQtd12(Integer.parseInt(request.getParameter("qtd12")));
					rfq.setQtd13(Integer.parseInt(request.getParameter("qtd13")));
					rfq.setQtd14(Integer.parseInt(request.getParameter("qtd14")));
					rfq.setQtd15(Integer.parseInt(request.getParameter("qtd15")));
					rfq.setQtd16(Integer.parseInt(request.getParameter("qtd16")));
					rfq.setQtd17(Integer.parseInt(request.getParameter("qtd17")));
					rfq.setQtd18(Integer.parseInt(request.getParameter("qtd18")));
					rfq.setQtd19(Integer.parseInt(request.getParameter("qtd19")));
					rfq.setQtd20(Integer.parseInt(request.getParameter("qtd20")));
					
					rfq.setPuitem1(request.getParameter("puitem1").equals("") ? null : Double.valueOf(request.getParameter("puitem1")));
					rfq.setPuitem2(request.getParameter("puitem2").equals("") ? null : Double.valueOf(request.getParameter("puitem2")));
					rfq.setPuitem3(request.getParameter("puitem3").equals("") ? null : Double.valueOf(request.getParameter("puitem3")));
					rfq.setPuitem4(request.getParameter("puitem4").equals("") ? null : Double.valueOf(request.getParameter("puitem4")));
					rfq.setPuitem5(request.getParameter("puitem5").equals("") ? null : Double.valueOf(request.getParameter("puitem5")));
					rfq.setPuitem6(request.getParameter("puitem6").equals("") ? null : Double.valueOf(request.getParameter("puitem6")));
					rfq.setPuitem7(request.getParameter("puitem7").equals("") ? null : Double.valueOf(request.getParameter("puitem7")));
					rfq.setPuitem8(request.getParameter("puitem8").equals("") ? null : Double.valueOf(request.getParameter("puitem8")));
					rfq.setPuitem9(request.getParameter("puitem9").equals("") ? null : Double.valueOf(request.getParameter("puitem9")));
					rfq.setPuitem10(request.getParameter("puitem10").equals("") ? null : Double.valueOf(request.getParameter("puitem10")));
					rfq.setPuitem11(request.getParameter("puitem11").equals("") ? null : Double.valueOf(request.getParameter("puitem11")));
					rfq.setPuitem12(request.getParameter("puitem12").equals("") ? null : Double.valueOf(request.getParameter("puitem12")));
					rfq.setPuitem13(request.getParameter("puitem13").equals("") ? null : Double.valueOf(request.getParameter("puitem13")));
					rfq.setPuitem14(request.getParameter("puitem14").equals("") ? null : Double.valueOf(request.getParameter("puitem14")));
					rfq.setPuitem15(request.getParameter("puitem15").equals("") ? null : Double.valueOf(request.getParameter("puitem15")));
					rfq.setPuitem16(request.getParameter("puitem16").equals("") ? null : Double.valueOf(request.getParameter("puitem16")));
					rfq.setPuitem17(request.getParameter("puitem17").equals("") ? null : Double.valueOf(request.getParameter("puitem17")));
					rfq.setPuitem18(request.getParameter("puitem18").equals("") ? null : Double.valueOf(request.getParameter("puitem18")));
					rfq.setPuitem19(request.getParameter("puitem19").equals("") ? null : Double.valueOf(request.getParameter("puitem19")));
					rfq.setPuitem20(request.getParameter("puitem20").equals("") ? null : Double.valueOf(request.getParameter("puitem20")));
					
					//acompanhamentoProjeto.setValororcado(request.getParameter("valororcado").equals("") ? null : Double.valueOf(request.getParameter("valororcado")));
					
					/*
					 * Regra de negócio: quantidade de item multiplicado por preço unitário. Soma de todos resultados, caso aja frete soma de subtotal + frete.
					 * */			
					
					Double puitem1 = (Double.valueOf(request.getParameter("puitem1")));
					Integer qtd1 = (Integer.valueOf(request.getParameter("qtd1")));
					Double rsitem1 = puitem1 * qtd1;
					
					Double puitem2 = (Double.valueOf(request.getParameter("puitem2")));
					Integer qtd2 = (Integer.valueOf(request.getParameter("qtd2")));
					Double rsitem2 = puitem2 * qtd2;
					
					Double puitem3 = (Double.valueOf(request.getParameter("puitem3")));
					Integer qtd3 = (Integer.valueOf(request.getParameter("qtd3")));
					Double rsitem3 = puitem3 * qtd3;
					
					Double puitem4 = (Double.valueOf(request.getParameter("puitem4")));
					Integer qtd4 = (Integer.valueOf(request.getParameter("qtd4")));
					Double rsitem4 = puitem4 * qtd4;
					
					Double puitem5 = (Double.valueOf(request.getParameter("puitem5")));
					Integer qtd5 = (Integer.valueOf(request.getParameter("qtd5")));
					Double rsitem5 = puitem5 * qtd5;
					
					Double puitem6 = (Double.valueOf(request.getParameter("puitem6")));
					Integer qtd6 = (Integer.valueOf(request.getParameter("qtd6")));
					Double rsitem6 = puitem6 * qtd6;
					
					Double puitem7 = (Double.valueOf(request.getParameter("puitem7")));
					Integer qtd7 = (Integer.valueOf(request.getParameter("qtd7")));
					Double rsitem7 = puitem7 * qtd7;
					
					Double puitem8 = (Double.valueOf(request.getParameter("puitem8")));
					Integer qtd8 = (Integer.valueOf(request.getParameter("qtd8")));
					Double rsitem8 = puitem8 * qtd8;
					
					Double puitem9 = (Double.valueOf(request.getParameter("puitem9")));
					Integer qtd9 = (Integer.valueOf(request.getParameter("qtd9")));
					Double rsitem9 = puitem9 * qtd9;
					
					Double puitem10 = (Double.valueOf(request.getParameter("puitem10")));
					Integer qtd10 = (Integer.valueOf(request.getParameter("qtd10")));
					Double rsitem10 = puitem10 * qtd10;
					
					Double puitem11 = (Double.valueOf(request.getParameter("puitem11")));
					Integer qtd11 = (Integer.valueOf(request.getParameter("qtd11")));
					Double rsitem11 = puitem11 * qtd11;
					
					Double puitem12 = (Double.valueOf(request.getParameter("puitem12")));
					Integer qtd12 = (Integer.valueOf(request.getParameter("qtd12")));
					Double rsitem12 = puitem12 * qtd12;
					
					Double puitem13 = (Double.valueOf(request.getParameter("puitem13")));
					Integer qtd13 = (Integer.valueOf(request.getParameter("qtd13")));
					Double rsitem13 = puitem13 * qtd13;
					
					Double puitem14 = (Double.valueOf(request.getParameter("puitem14")));
					Integer qtd14 = (Integer.valueOf(request.getParameter("qtd14")));
					Double rsitem14 = puitem14 * qtd14;
					
					Double puitem15 = (Double.valueOf(request.getParameter("puitem15")));
					Integer qtd15 = (Integer.valueOf(request.getParameter("qtd15")));
					Double rsitem15 = puitem15 * qtd15;
					
					Double puitem16 = (Double.valueOf(request.getParameter("puitem16")));
					Integer qtd16 = (Integer.valueOf(request.getParameter("qtd16")));
					Double rsitem16 = puitem16 * qtd16;
					
					Double puitem17 = (Double.valueOf(request.getParameter("puitem17")));
					Integer qtd17 = (Integer.valueOf(request.getParameter("qtd17")));
					Double rsitem17 = puitem17 * qtd17;
					
					Double puitem18 = (Double.valueOf(request.getParameter("puitem18")));
					Integer qtd18 = (Integer.valueOf(request.getParameter("qtd18")));
					Double rsitem18 = puitem18 * qtd18;
					
					Double puitem19 = (Double.valueOf(request.getParameter("puitem19")));
					Integer qtd19 = (Integer.valueOf(request.getParameter("qtd19")));
					Double rsitem19 = puitem19 * qtd19;
					
					Double puitem20 = (Double.valueOf(request.getParameter("puitem20")));
					Integer qtd20 = (Integer.valueOf(request.getParameter("qtd20")));
					Double rsitem20 = puitem20 * qtd20;
					
					Integer frete = (Integer.valueOf(request.getParameter("frete")));
					
					Double subtotal = (rsitem1 + rsitem2 + rsitem3 + rsitem4 + rsitem5 + rsitem6 + rsitem7 + rsitem8 + rsitem9 + rsitem10 + rsitem11 + rsitem12 + rsitem13 + rsitem14 + rsitem15 + rsitem16 + rsitem17 + rsitem18 + rsitem19 + rsitem20);
					Double total = (subtotal + frete);
					rfq.setTotal(total); //Setando  o resultado final da contação
					rfq.setFrete(Double.parseDouble(request.getParameter("frete")));
		
		if(ValidationHelper.validar(rfq)){		
			
			rfqDAO.atualizar(rfq);
			request.setAttribute("mensagem", "Pedido de Cotação: ("+rfq.getNumerorfq()+") atualizado com sucesso!");
			
			/*Regra que objetiva disparar um e-mail automático como confirmação de registro.
			 * O Metodo enviarForm() é responsável, por enviar e-mail de confirmação de envio de formulários.
			 */
			
			//String de 		= request.getParameter("de");
			String para 	= request.getParameter("para");
			String assunto 	= request.getParameter("numerorfq");
			String mensagem = request.getParameter("outracondicao");
			//String lista 	= request.getParameter("lista");
			//String file		= request.getParameter("file");
					
			RequestDispatcher rd = null;
			
			EnviaEmail enviaEmail = new EnviaEmail();
			
				//enviaEmail.setDe(de);
				enviaEmail.setPara(para);
				enviaEmail.setAssunto(assunto);
				enviaEmail.setMensagem(mensagem);			
				//enviaEmail.setLista(lista);		
				//enviaEmail.setFile(file);
			
			boolean enviado = enviaEmail.enviarForm();		
			
			if(enviado)
				request.setAttribute("msg","Enviado confirmação de registro por e-mail!");
			else
				request.setAttribute("msg","Não, enviado cópia de confirmação de registro por e-mail!");				
			
			rd = request.getRequestDispatcher("TkcsapcdController?cmd=consultarRfq");
			rd.forward(request, response);
		}
		else{
			throw new Exception("Valor inválido");
		}	
		} catch (SQLException e) {
			
			request.setAttribute("mensagem", "Problema com a atualização: "+e.getMessage());
			e.printStackTrace();
			
		}catch (NumberFormatException e) {
			request.setAttribute("mensagem", "Valor inválido: "+e.getMessage());			
		}	
			request.setAttribute("titulo", "Atualização - Pedido de Cotação");
			return "TkcsapcdController?cmd=consultarRfq";//Pagina de Retorno (pagina consulta)
	}

}

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

import br.com.tkcsapcd.model.bean.ModeloContrato;
import br.com.tkcsapcd.model.dao.InterfaceModeloContratoDAO;
import br.com.tkcsapcd.model.helper.ValidationHelper;
//Método registrado na InterfaceCommand
public class AtualizarModeloContrato implements InterfaceCommand {

	private InterfaceModeloContratoDAO modeloContratoDAO;
	public AtualizarModeloContrato(InterfaceModeloContratoDAO modeloContratoDAO) {
		super();
		this.modeloContratoDAO = modeloContratoDAO;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {			
					//  Preencher o Bean com os valores do request					
			ModeloContrato modeloContrato = new ModeloContrato();
			
			modeloContrato.setCodigo(Integer.valueOf(request.getParameter("codigo")));
			modeloContrato.setModelocontrato(request.getParameter("modelocontrato"));
			modeloContrato.setProjeto(request.getParameter("projeto"));
			modeloContrato.setCodigoprojeto(Integer.valueOf(request.getParameter("codigoprojeto")));
			modeloContrato.setVersao(request.getParameter("versao"));
			
			String data_1 = request.getParameter("data"); 
			Date data = new SimpleDateFormat("yyyy-MM-dd").parse(data_1);
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
			modeloContratoDAO.atualizar(modeloContrato);
			request.setAttribute("mensagem", "Adjudicação do contrato de aquisição: ("+modeloContrato.getCodigoprojeto()+") atualizado com sucesso!");
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
			request.setAttribute("titulo", "Atualização - Adjudicação do contrato de aquisição");
			return "TkcsapcdController?cmd=consultarModeloContrato";//Pagina de Retorno (pagina consulta)
	}

}

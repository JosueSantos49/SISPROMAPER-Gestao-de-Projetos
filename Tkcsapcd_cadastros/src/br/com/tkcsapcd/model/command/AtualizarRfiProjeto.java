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

import br.com.tkcsapcd.model.bean.RfiProjeto;
import br.com.tkcsapcd.model.dao.InterfaceRfiProjetoDAO;

public class AtualizarRfiProjeto implements InterfaceCommand {

	private InterfaceRfiProjetoDAO rfiProjetoDAO;
	
	public AtualizarRfiProjeto(InterfaceRfiProjetoDAO rfiProjetoDAO) {
		super();
		this.rfiProjetoDAO = rfiProjetoDAO;
	}

	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response) throws Exception {
		
		try {
			// Preencher o Bean com os valores do request
						RfiProjeto rfiProjeto = new RfiProjeto();	
						
						rfiProjeto.setCodigo(Long.valueOf(request.getParameter("codigo")));//Necessario, para essa cituação						
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
						Date data = new SimpleDateFormat("yyyy-MM-dd").parse(data_1);
						rfiProjeto.setData(data);
						
						rfiProjeto.setCnpj(Long.valueOf(request.getParameter("cnpj")));
			
			rfiProjetoDAO.atualizar(rfiProjeto);
			request.setAttribute("mensagem", "FRI-Projeto: ("+rfiProjeto.getNome()+") atualizado com sucesso!");
			
			}		
			catch (SQLException e) {
				
				request.setAttribute("mensagem", "Problema com a atualização: "+e.getMessage());
				e.printStackTrace();				
			}
			catch (NumberFormatException e) {
				request.setAttribute("mensagem", "Valor inválido: "+e.getMessage());
			}
			request.setAttribute("titulo", "Atualização - RFI Projeto");
			return "TkcsapcdController?cmd=consultarRfiProjeto";//Pagina de Retorno (pagina consulta funcionario)
		}
	

}

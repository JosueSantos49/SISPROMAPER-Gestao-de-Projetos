/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.helper;

import br.com.tkcsapcd.model.bean.AcompanhamentoProjeto;
import br.com.tkcsapcd.model.bean.Alocacao;
import br.com.tkcsapcd.model.bean.AtaReuniao;
import br.com.tkcsapcd.model.bean.AtributoAtividade;
import br.com.tkcsapcd.model.bean.AvaliacaoDesempenhoEquipe;
import br.com.tkcsapcd.model.bean.BusinessCase;
import br.com.tkcsapcd.model.bean.BusinessPlan;
import br.com.tkcsapcd.model.bean.Cliente;
import br.com.tkcsapcd.model.bean.CriterioPreQualificacao;
import br.com.tkcsapcd.model.bean.DecisoesComprar;
import br.com.tkcsapcd.model.bean.DeclaracaoEscopo;
import br.com.tkcsapcd.model.bean.DeclaracaoTrabalho;
import br.com.tkcsapcd.model.bean.DiagnosticoPlanoAcao;
import br.com.tkcsapcd.model.bean.DicionarioEAP;
import br.com.tkcsapcd.model.bean.GerenciamentoEscopo;
import br.com.tkcsapcd.model.bean.IssuesLog;
import br.com.tkcsapcd.model.bean.LicoesAprendida;
import br.com.tkcsapcd.model.bean.ListaAtividade;
import br.com.tkcsapcd.model.bean.ListaMarcos;
import br.com.tkcsapcd.model.bean.ListaQualidade;
import br.com.tkcsapcd.model.bean.MatrizComunicacao;
import br.com.tkcsapcd.model.bean.MatrizRastreabilidadeRequisito;
import br.com.tkcsapcd.model.bean.Metricas;
import br.com.tkcsapcd.model.bean.ModificacaoEscopo;
import br.com.tkcsapcd.model.bean.OrcamentoProjeto;
import br.com.tkcsapcd.model.bean.PlanoGerenciamentoAquisicao;
import br.com.tkcsapcd.model.bean.PlanoGerenciamentoComunicacao;
import br.com.tkcsapcd.model.bean.PlanoGerenciamentoCronograma;
import br.com.tkcsapcd.model.bean.PlanoGerenciamentoCusto;
import br.com.tkcsapcd.model.bean.PlanoGerenciamentoParteInteressada;
import br.com.tkcsapcd.model.bean.PlanoGerenciamentoPessoal;
import br.com.tkcsapcd.model.bean.PlanoGerenciamentoProjeto;
import br.com.tkcsapcd.model.bean.PlanoGerenciamentoQualidade;
import br.com.tkcsapcd.model.bean.PlanoGerenciamentoRequisito;
import br.com.tkcsapcd.model.bean.PlanoGerenciamentoRisco;
import br.com.tkcsapcd.model.bean.PlanoMelhoriaProcesso;
import br.com.tkcsapcd.model.bean.ProjetoTermoEncerramento;
import br.com.tkcsapcd.model.bean.RecursosHumanos;
import br.com.tkcsapcd.model.bean.RegistroParteInteressada;
import br.com.tkcsapcd.model.bean.RegistroParteInteressadaFornecedor;
import br.com.tkcsapcd.model.bean.RegistroRisco;
import br.com.tkcsapcd.model.bean.RegistroRiscoAcoes;
import br.com.tkcsapcd.model.bean.RegistroSolicitacaoMudanca;
import br.com.tkcsapcd.model.bean.RelatorioEncerramentoContrato;
import br.com.tkcsapcd.model.bean.Requerimento;
import br.com.tkcsapcd.model.bean.RfiProjeto;
import br.com.tkcsapcd.model.bean.RfpProjeto;
import br.com.tkcsapcd.model.bean.Riscos;
import br.com.tkcsapcd.model.bean.SolicitacaoCadastro;
import br.com.tkcsapcd.model.bean.SolicitacaoMudanca;
import br.com.tkcsapcd.model.bean.SolicitacaoProjeto;
import br.com.tkcsapcd.model.bean.SolicitacaoProjetovBSC;
import br.com.tkcsapcd.model.bean.SolicitacaoServicoTI;
import br.com.tkcsapcd.model.bean.Stakeholders;
import br.com.tkcsapcd.model.bean.StatusReport;
import br.com.tkcsapcd.model.bean.Statuss;
import br.com.tkcsapcd.model.bean.TermoAberturaProjeto;
import br.com.tkcsapcd.model.bean.TermoAceiteEntrega;
import br.com.tkcsapcd.model.bean.TransicaoProduto;
import br.com.tkcsapcd.model.bean.Usuario;

public class ValidationHelper {
	
	/*Desccobrir qual é o tipo de objeto avaliação e dadofixo*/	
	public static boolean validar(Object objeto) {
			
		if(objeto instanceof AtaReuniao){
			//Confirmando os campos obrigatórios
			if( 
					((AtaReuniao) objeto).getAta().trim().equals("")		||
					((AtaReuniao) objeto).getLocal().trim().equals("")			||
					((AtaReuniao) objeto).getAprovacao().trim().equals("")							
					
			)						
				return false;
		}
		if(objeto instanceof Usuario){
			//Confirmando os campos obrigatórios
			if( 
					((Usuario) objeto).getLog_usuario().trim().equals("")		||
					((Usuario) objeto).getLog_senha().trim().equals("")			||
					((Usuario) objeto).getLog_nivelacesso().trim().equals("")	||
					((Usuario) objeto).getLog_cpf().trim().equals("")			||
					((Usuario) objeto).getLog_datacadastro().trim().equals("")	||
					((Usuario) objeto).getNome().trim().equals("")				||
					((Usuario) objeto).getId().trim().equals("")				||
					((Usuario) objeto).getGestorimediato().trim().equals("")	||
					((Usuario) objeto).getDepartamento().trim().equals("")		||
					((Usuario) objeto).getEmail().trim().equals("")				||
					((Usuario) objeto).getTelefone().trim().equals("")							
					
			)						
				return false;
		}
		
		if(objeto instanceof Alocacao){
			//Confirmando os campos obrigatórios
			if( 
					((Alocacao) objeto).getData().trim().equals("")			||
					((Alocacao) objeto).getData0().trim().equals("")								
					
			)						
				return false;
		}
		else if(objeto instanceof Statuss){
			
			if(
				  ((Statuss) objeto).getFase().trim().equals("") 						||
				  //((Statuss) objeto).getPercentualevolucao().equals("") 				||
				  //((Statuss) objeto).getPercentualplanejado().equals("") 				||
				  ((Statuss) objeto).getDatastatus().trim().equals("") 					||
				  ((Statuss) objeto).getDescricao().trim().equals("") 					||
				  ((Statuss) objeto).getPontospositivos().trim().equals("") 			||
				  ((Statuss) objeto).getPontosnegativos().trim().equals("") 			||
				  ((Statuss) objeto).getTendencia().trim().equals("") 					||
				  ((Statuss) objeto).getDatainicio().trim().equals("") 					||
				  ((Statuss) objeto).getDatafim().trim().equals("") 					||
				  ((Statuss) objeto).getProjeto().trim().equals("") 					||
				  ((Statuss) objeto).getCodigodoprojeto().equals("")
				  )
				return false;			
		}
		else if(objeto instanceof AcompanhamentoProjeto){
			
			if(
				  ((AcompanhamentoProjeto) objeto).getAcompanhamentoprojeto().trim().equals("") ||
				  ((AcompanhamentoProjeto) objeto).getProjetoinicio().equals("") 				||
				  ((AcompanhamentoProjeto) objeto).getVersao().equals("") 				||
				  ((AcompanhamentoProjeto) objeto).getData().equals("") 					||
				  ((AcompanhamentoProjeto) objeto).getAutor().trim().equals("") 				||
				  ((AcompanhamentoProjeto) objeto).getNotarevisao().trim().equals("") 			||
				  ((AcompanhamentoProjeto) objeto).getAprovacao().trim().equals("") 			||
				  ((AcompanhamentoProjeto) objeto).getProdutoservico().trim().equals("") 		||
				  ((AcompanhamentoProjeto) objeto).getSituacaoconcluida().trim().equals("") 	||
				  ((AcompanhamentoProjeto) objeto).getDataplanejada().equals("") 		||
				  ((AcompanhamentoProjeto) objeto).getDataefetiva().equals("") 			||
				  ((AcompanhamentoProjeto) objeto).getAtrasoprevisto().equals("") 		||
				  ((AcompanhamentoProjeto) objeto).getEspecificacao().trim().equals("") 		||
				  ((AcompanhamentoProjeto) objeto).getNivel().trim().equals("") 				||
				  ((AcompanhamentoProjeto) objeto).getAcao().trim().equals("") 					||
				  ((AcompanhamentoProjeto) objeto).getResponsavel().trim().equals("")
				  )
				return false;			
		}
		else if(objeto instanceof Cliente){
			if(
					((Cliente) objeto).getNome().trim().equals("") 			||
					((Cliente) objeto).getSexo().trim().equals("") 			||
					((Cliente) objeto).getNascimento().trim().equals("") 	||
					((Cliente) objeto).getProfissao().trim().equals("") 	||
					((Cliente) objeto).getRenda().trim().equals("") 		||
					((Cliente) objeto).getRg().trim().equals("") 			||
					((Cliente) objeto).getOrgaorg().trim().equals("") 		||
					((Cliente) objeto).getEndereco().trim().equals("") 		||
					((Cliente) objeto).getBairro().trim().equals("") 		||
					((Cliente) objeto).getEstado().trim().equals("") 		||
					((Cliente) objeto).getCidade().trim().equals("") 		||
					((Cliente) objeto).getCep().trim().equals("") 			||
					((Cliente) objeto).getCpf().trim().equals("")			||					
					((Cliente) objeto).getCnpj().trim().equals("") 			||
					((Cliente) objeto).getDesde().trim().equals("") 		||
					((Cliente) objeto).getEmail().trim().equals("") 		||
					((Cliente) objeto).getEmpresa().trim().equals("") 			
					
					)
				return false;
		}
		else if(objeto instanceof Requerimento){
			if(
					((Requerimento) objeto).getNome().trim().equals("") 			||
					((Requerimento) objeto).getDescricao().trim().equals("") 		||
					((Requerimento) objeto).getResumo().trim().equals("") 			||
					((Requerimento) objeto).getRqfuncional().trim().equals("") 		||
					((Requerimento) objeto).getRqtecnologico().trim().equals("") 	||
					((Requerimento) objeto).getRqstatus().trim().equals("") 		||
					((Requerimento) objeto).getConcordo().trim().equals("") 
					
					)
				return false;
		}
		
		else if(objeto instanceof Metricas){
			if(
					((Metricas) objeto).getIdMetricas().trim().equals("")			 	||
					((Metricas) objeto).getNomeMetrica().trim().equals("") 				||
					((Metricas) objeto).getIndiceMetrica().trim().equals("") 			||
					((Metricas) objeto).getValorReferenciaHora().trim().equals("") 		||
					((Metricas) objeto).getValorHoraCalculadaDia().trim().equals("") 
					
					)
				return false;
		}
		else if(objeto instanceof TermoAberturaProjeto){
			if(
					((TermoAberturaProjeto) objeto).getTermoaberturaprojeto().equals("") 	||
					//((TermoAberturaProjeto) objeto).getProjeto().equals("") 				||
					((TermoAberturaProjeto) objeto).getProjetoinicio().getCodigo().equals("") 			||
					((TermoAberturaProjeto) objeto).getVersao().equals("") 					||
					((TermoAberturaProjeto) objeto).getData().equals("") 					||
					((TermoAberturaProjeto) objeto).getAutor().equals("") 					||
					((TermoAberturaProjeto) objeto).getNotarevisao().equals("") 			||
					((TermoAberturaProjeto) objeto).getAprovacao().equals("") 				||
					((TermoAberturaProjeto) objeto).getObjetivo().equals("") 				||
					((TermoAberturaProjeto) objeto).getJustificativa().equals("") 			||
					((TermoAberturaProjeto) objeto).getSmart().equals("") 					||
					((TermoAberturaProjeto) objeto).getEap().equals("") 					||
					((TermoAberturaProjeto) objeto).getRequisito().equals("")				||
					((TermoAberturaProjeto) objeto).getMarco().equals("")					||
					((TermoAberturaProjeto) objeto).getParteinteressada().equals("")		||
					((TermoAberturaProjeto) objeto).getRestricao().equals("")				||
					((TermoAberturaProjeto) objeto).getPermissao().equals("")				||
					((TermoAberturaProjeto) objeto).getRisco().equals("")					||
					((TermoAberturaProjeto) objeto).getOrcamento().equals("")				||
					((TermoAberturaProjeto) objeto).getConcordo().equals("")
					)
				return false;
		}
		else if(objeto instanceof ProjetoTermoEncerramento){
			if(
					((ProjetoTermoEncerramento) objeto).getNomeprojeto().equals("") 			||
					((ProjetoTermoEncerramento) objeto).getDatadocumento().equals("") 			||
					((ProjetoTermoEncerramento) objeto).getCoordenador().equals("") 			||
					((ProjetoTermoEncerramento) objeto).getTipoprojeto().equals("") 			||
					((ProjetoTermoEncerramento) objeto).getGestor().equals("") 					||
					((ProjetoTermoEncerramento) objeto).getPrograma().equals("") 				||
					((ProjetoTermoEncerramento) objeto).getStatusconclusao().equals("") 		||
					((ProjetoTermoEncerramento) objeto).getDataanaliseresultado().equals("") 	||
					((ProjetoTermoEncerramento) objeto).getObjetivoprojeto().equals("") 		||
					((ProjetoTermoEncerramento) objeto).getJustificativaprojeto().equals("") 	||
					((ProjetoTermoEncerramento) objeto).getOrcamentoprevisto().equals("") 		||
					((ProjetoTermoEncerramento) objeto).getValorempenhado().equals("") 			||
					((ProjetoTermoEncerramento) objeto).getValorpago().equals("")				|| 
					((ProjetoTermoEncerramento) objeto).getSaldo().equals("") 					||
					((ProjetoTermoEncerramento) objeto).getResultadoprevisto().equals("") 		||
					((ProjetoTermoEncerramento) objeto).getPeso().equals("") 					||
					((ProjetoTermoEncerramento) objeto).getProgresso().equals("") 				||
					((ProjetoTermoEncerramento) objeto).getDetalhamento().equals("") 			||
					((ProjetoTermoEncerramento) objeto).getAnaliseefetividade().equals("") 		||
					((ProjetoTermoEncerramento) objeto).getDocumentacaofisica().equals("")		||
					((ProjetoTermoEncerramento) objeto).getDocumentacaoeletronica().equals("")	||
					((ProjetoTermoEncerramento) objeto).getConcideracaocoordenador().equals("")	||
					((ProjetoTermoEncerramento) objeto).getConcideracaogestor().equals("")		||					
					((ProjetoTermoEncerramento) objeto).getTermo().equals("") 					||
					((ProjetoTermoEncerramento) objeto).getCodigoprojeto().equals("")		
					)
				return false;
		}		
		else if(objeto instanceof RecursosHumanos){
			if(
					((RecursosHumanos) objeto).getIdRecursosHumanos().equals("") 	||
					((RecursosHumanos) objeto).getNome().equals("")					||
					((RecursosHumanos) objeto).getProfissao().equals("") 			||
					((RecursosHumanos) objeto).getArea().equals("")					||
					((RecursosHumanos) objeto).getStatus().equals("") 	
					)
				return false;
		}
		else if(objeto instanceof RfiProjeto){
			if(
					((RfiProjeto) objeto).getNome().trim().equals("") 					||		
					((RfiProjeto) objeto).getEndereco().trim().equals("") 				||	
					((RfiProjeto) objeto).getPaginaweb().trim().equals("") 				||		
					((RfiProjeto) objeto).getAnosmercado().trim().equals("") 			||
					((RfiProjeto) objeto).getTelefone().trim().equals("") 				||		
					((RfiProjeto) objeto).getEmail().trim().equals("") 					||
					((RfiProjeto) objeto).getLocalizacao().trim().equals("") 			||		
					((RfiProjeto) objeto).getProdutoservico().trim().equals("") 		||
					((RfiProjeto) objeto).getMercadocliente().trim().equals("") 		||		
					((RfiProjeto) objeto).getEstruturapropriedade().trim().equals("") 	||					
					((RfiProjeto) objeto).getEstruturaempresa().trim().equals("") 		||		
					((RfiProjeto) objeto).getGestaoambiental().trim().equals("") 		||	
					((RfiProjeto) objeto).getUltimolucroano().trim().equals("") 		||		
					((RfiProjeto) objeto).getGestaoqualidade().trim().equals("") 		||
					((RfiProjeto) objeto).getGestaonegocio().trim().equals("") 			||		
					((RfiProjeto) objeto).getFuncionario().trim().equals("") 			||
					((RfiProjeto) objeto).getProducao().trim().equals("") 				||		
					((RfiProjeto) objeto).getMarketingvendas().trim().equals("") 		||
					((RfiProjeto) objeto).getDepartamentoqualidade().trim().equals("") 	||		
					((RfiProjeto) objeto).getInformacaofinanceira().trim().equals("") 	||
					((RfiProjeto) objeto).getMercadoacoes().trim().equals("") 			||		
					((RfiProjeto) objeto).getPessoacontato().trim().equals("") 			||	
					((RfiProjeto) objeto).getCapacidadehoje().trim().equals("") 		||		
					((RfiProjeto) objeto).getCapacidadeantecipada().trim().equals("") 	||
					((RfiProjeto) objeto).getCondicaonaoatendida().trim().equals("") 	||		
					((RfiProjeto) objeto).getProdutosentregues().trim().equals("") 		||
					((RfiProjeto) objeto).getClientereferenciacomparaveis().trim().equals("")			||		
					((RfiProjeto) objeto).getClientereferencianaocomparaveis().trim().equals("") 		||
					((RfiProjeto) objeto).getDisponibilidade().trim().equals("") 		||		
					((RfiProjeto) objeto).getSuportemundial().trim().equals("") 		||
					((RfiProjeto) objeto).getData().equals("") 	
					
					)
				return false;
		}
		else if(objeto instanceof RfpProjeto){
			if(
					
					((RfpProjeto) objeto).getCodigoProjeto().trim().equals("") 			||
					((RfpProjeto) objeto).getItensProjeto().trim().equals("")			||	
					((RfpProjeto) objeto).getNomeRfpProjeto().trim().equals("") 		||
					((RfpProjeto) objeto).getNomeempresa().trim().equals("")			||
					((RfpProjeto) objeto).getTelefone().trim().equals("") 				||
					((RfpProjeto) objeto).getEmailrepresentante().trim().equals("")		||
					((RfpProjeto) objeto).getEndereco().trim().equals("") 				||
					((RfpProjeto) objeto).getEstado().trim().equals("")					||
					((RfpProjeto) objeto).getCidade().trim().equals("") 				||
					((RfpProjeto) objeto).getNumero().trim().equals("")					||
					((RfpProjeto) objeto).getBairro().trim().equals("") 				||
					((RfpProjeto) objeto).getData().trim().equals("")					||
					((RfpProjeto) objeto).getCep().trim().equals("") 					||
					((RfpProjeto) objeto).getRepresentante().trim().equals("")			||
					((RfpProjeto) objeto).getHistoricoempresa().trim().equals("") 		||
					((RfpProjeto) objeto).getProdutoempresa().trim().equals("")			||
					((RfpProjeto) objeto).getMercadoempresa().trim().equals("") 		||
					((RfpProjeto) objeto).getValoresempresa().trim().equals("")			||
					((RfpProjeto) objeto).getAquisicao().trim().equals("") 				||
					((RfpProjeto) objeto).getEscopo().trim().equals("")					||
					((RfpProjeto) objeto).getRestricao().trim().equals("") 				||
					((RfpProjeto) objeto).getRecurso().trim().equals("")				||
					((RfpProjeto) objeto).getAvaliacao().trim().equals("") 				||
					((RfpProjeto) objeto).getCronograma().trim().equals("")				||
					((RfpProjeto) objeto).getProposta().trim().equals("") 				||
					((RfpProjeto) objeto).getCondicaoproposta().trim().equals("")		||
					((RfpProjeto) objeto).getObservacao().trim().equals("") 		
					)
				return false;
		}
		else if(objeto instanceof SolicitacaoCadastro){
			if(
					((SolicitacaoCadastro) objeto).getNome().trim().equals("") 			||
					((SolicitacaoCadastro) objeto).getEmail().trim().equals("") 		||
					((SolicitacaoCadastro) objeto).getId().trim().equals("") 			||
					((SolicitacaoCadastro) objeto).getArea().trim().equals("") 			||
					((SolicitacaoCadastro) objeto).getFuncao().trim().equals("") 		||
					((SolicitacaoCadastro) objeto).getResponsavel().trim().equals("")	||
					((SolicitacaoCadastro) objeto).getTelefone().trim().equals("") 		||
					((SolicitacaoCadastro) objeto).getData().trim().equals("") 			||
					((SolicitacaoCadastro) objeto).getStatus().trim().equals("") 		||
					((SolicitacaoCadastro) objeto).getObs().trim().equals("")	
				)
				return false;
		}
		
		else if(objeto instanceof SolicitacaoServicoTI){
			if(
					((SolicitacaoServicoTI) objeto).getCodigoprojeto().equals("") 						||
					((SolicitacaoServicoTI) objeto).getCodigosolicitaoservico().trim().equals("") 		||
					((SolicitacaoServicoTI) objeto).getArea().trim().equals("") 						||
					((SolicitacaoServicoTI) objeto).getResponsaveldemanda().trim().equals("") 			||
					((SolicitacaoServicoTI) objeto).getTelefonecontato().trim().equals("") 				||
					((SolicitacaoServicoTI) objeto).getEmail().trim().equals("") 						||
					((SolicitacaoServicoTI) objeto).getDatasolicitacao().trim().equals("") 				||
					((SolicitacaoServicoTI) objeto).getId().trim().equals("") 							||
					((SolicitacaoServicoTI) objeto).getNomedemanda().trim().equals("") 					||
					((SolicitacaoServicoTI) objeto).getObjetivodemanda().trim().equals("") 				||
					((SolicitacaoServicoTI) objeto).getDecricaoproblema().trim().equals("") 			||
					((SolicitacaoServicoTI) objeto).getDesenhoprocesso().trim().equals("") 				||
					((SolicitacaoServicoTI) objeto).getFuncionalidade().trim().equals("") 				||
					((SolicitacaoServicoTI) objeto).getParteenvolvida().trim().equals("") 				||
					((SolicitacaoServicoTI) objeto).getParteenvolvidaformacontato().trim().equals("") 	||
					((SolicitacaoServicoTI) objeto).getParteenvolvidaformacontato().trim().equals("") 	||
					((SolicitacaoServicoTI) objeto).getRecursos().trim().equals("") 					||
					((SolicitacaoServicoTI) objeto).getEstimativacustoglobal().trim().equals("") 		||
					((SolicitacaoServicoTI) objeto).getFontefinanciamento().trim().equals("") 			||
					((SolicitacaoServicoTI) objeto).getMetodolevantamentocusto().trim().equals("") 		||
					((SolicitacaoServicoTI) objeto).getNumerousuarioprevisto().trim().equals("") 		||
					((SolicitacaoServicoTI) objeto).getTreinamentopessoal().trim().equals("") 			||
					((SolicitacaoServicoTI) objeto).getMaterialapoio().trim().equals("") 				||					
					((SolicitacaoServicoTI) objeto).getRestricaoprojeto().trim().equals("") 			||
					((SolicitacaoServicoTI) objeto).getPrincipaisusuarios().trim().equals("") 			||
					((SolicitacaoServicoTI) objeto).getNecessidadeusuario().trim().equals("") 			||
					((SolicitacaoServicoTI) objeto).getPrioridade().trim().equals("") 					||
					((SolicitacaoServicoTI) objeto).getSolucaoatual().trim().equals("") 				||
					((SolicitacaoServicoTI) objeto).getProblemasolucaoatual().trim().equals("") 		||
					((SolicitacaoServicoTI) objeto).getSolucaoproposta().trim().equals("") 				||
					((SolicitacaoServicoTI) objeto).getStatus().trim().equals("") 		
			)
			return false;
			}			
		else if(objeto instanceof Stakeholders){
			if(
					((Stakeholders) objeto).getEmpresa().equals("")					||
					((Stakeholders) objeto).getOrgao().trim().equals("") 			||
					((Stakeholders) objeto).getSetor().trim().equals("") 			||
					((Stakeholders) objeto).getPrograma().trim().equals("") 		||
					((Stakeholders) objeto).getProjeto().trim().equals("") 			||
					((Stakeholders) objeto).getGerente().trim().equals("") 			||					
					((Stakeholders) objeto).getFuncao().trim().equals("") 			||
					((Stakeholders) objeto).getAprovado().trim().equals("") 		||
					((Stakeholders) objeto).getVersao().trim().equals("") 			||					
					((Stakeholders) objeto).getDataaprovacao().equals("")			||
					((Stakeholders) objeto).getReferencia().trim().equals("")	 	||
					((Stakeholders) objeto).getNome().trim().equals("") 			||
					((Stakeholders) objeto).getEmpresaequipe().trim().equals("")	||
					((Stakeholders) objeto).getCargocompetencia().trim().equals("")	||
					((Stakeholders) objeto).getEmail().trim().equals("") 			||					
					((Stakeholders) objeto).getTelefone().trim().equals("") 		||
					((Stakeholders) objeto).getEndereco().trim().equals("") 		
					//((Stakeholders) objeto).getVersao().trim().equals("") 
					)
				return false;
		}
		else if(objeto instanceof Riscos){
			if(
					((Riscos) objeto).getEmpresa().equals("")				||
					((Riscos) objeto).getOrgao().trim().equals("") 			||
					((Riscos) objeto).getSetor().trim().equals("") 			||
					((Riscos) objeto).getPrograma().trim().equals("") 		||
					((Riscos) objeto).getProjetoinicio().equals("") 		||				
					((Riscos) objeto).getGerente().trim().equals("") 		||
					((Riscos) objeto).getFuncao().trim().equals("") 		||
					((Riscos) objeto).getAprovado().equals("")				||
					((Riscos) objeto).getVersao().trim().equals("") 		||
					((Riscos) objeto).getDataaprovacao().equals("") 	||
					((Riscos) objeto).getEtapa1().trim().equals("") 		||
					((Riscos) objeto).getEtapa2().trim().equals("") 		||
					((Riscos) objeto).getEtapa3().trim().equals("") 		||					
					((Riscos) objeto).getEtapa4().trim().equals("")		
					)
				return false;
		}
		else if(objeto instanceof DeclaracaoEscopo){
			if(
					((DeclaracaoEscopo) objeto).getEmpresa().equals("")					||
					((DeclaracaoEscopo) objeto).getOrgao().trim().equals("") 			||
					((DeclaracaoEscopo) objeto).getSetor().trim().equals("") 			||
					((DeclaracaoEscopo) objeto).getPrograma().trim().equals("") 		||
					((DeclaracaoEscopo) objeto).getProjeto().trim().equals("") 			||
					((DeclaracaoEscopo) objeto).getCodigoprojeto().trim().equals("") 	||					
					((DeclaracaoEscopo) objeto).getGerente().trim().equals("") 			||
					((DeclaracaoEscopo) objeto).getFuncao().trim().equals("") 			||
					((DeclaracaoEscopo) objeto).getAprovado().equals("")				||
					((DeclaracaoEscopo) objeto).getVersao().trim().equals("") 			||
					((DeclaracaoEscopo) objeto).getDataaprovacao().trim().equals("") 	||
					((DeclaracaoEscopo) objeto).getJustificativa().trim().equals("") 	||
					((DeclaracaoEscopo) objeto).getObjetivo().trim().equals("") 		||
					((DeclaracaoEscopo) objeto).getDescricao().trim().equals("") 		||
					((DeclaracaoEscopo) objeto).getLista().trim().equals("") 			||
					((DeclaracaoEscopo) objeto).getLigacao().trim().equals("") 			||
					((DeclaracaoEscopo) objeto).getEstrategia().trim().equals("") 		||
					((DeclaracaoEscopo) objeto).getResponsabilidade().trim().equals("") ||
					((DeclaracaoEscopo) objeto).getMacro().trim().equals("") 		    ||
					((DeclaracaoEscopo) objeto).getPremissas().trim().equals("") 		||
					((DeclaracaoEscopo) objeto).getRestricoes().trim().equals("") 		||
					((DeclaracaoEscopo) objeto).getEquipe().trim().equals("") 		    ||
					((DeclaracaoEscopo) objeto).getCodigoprojeto().trim().equals("")
					
					)
				return false;
		}
		else if(objeto instanceof GerenciamentoEscopo){
			if(
					((GerenciamentoEscopo) objeto).getEmpresa().equals("")						||
					((GerenciamentoEscopo) objeto).getOrgao().trim().equals("") 				||
					((GerenciamentoEscopo) objeto).getSetor().trim().equals("") 				||
					((GerenciamentoEscopo) objeto).getPrograma().trim().equals("") 				||
					((GerenciamentoEscopo) objeto).getProjetoinicio().equals("") 				||		
					((GerenciamentoEscopo) objeto).getGerente().trim().equals("") 				||
					((GerenciamentoEscopo) objeto).getFuncao().trim().equals("") 				||
					((GerenciamentoEscopo) objeto).getAprovado().equals("")						||
					((GerenciamentoEscopo) objeto).getVersao().trim().equals("") 				||
					((GerenciamentoEscopo) objeto).getDataaprovacao().equals("") 		||
					((GerenciamentoEscopo) objeto).getObjetivo().trim().equals("") 				||
					((GerenciamentoEscopo) objeto).getGerenciamento().trim().equals("") 		||
					((GerenciamentoEscopo) objeto).getReunioes_equipe().trim().equals("") 		||
					((GerenciamentoEscopo) objeto).getReunioes_planejamento().trim().equals("") ||
					((GerenciamentoEscopo) objeto).getReunioes_gerenciais().trim().equals("") 	||
					((GerenciamentoEscopo) objeto).getModificacao_escopo().trim().equals("") 	||
					((GerenciamentoEscopo) objeto).getLicoes().trim().equals("") 		    
					
					)
				return false;
		}
		else if(objeto instanceof ModificacaoEscopo){
			if(
					((ModificacaoEscopo) objeto).getEmpresa().equals("")				||
					((ModificacaoEscopo) objeto).getOrgao().trim().equals("") 			||
					((ModificacaoEscopo) objeto).getSetor().trim().equals("") 			||
					((ModificacaoEscopo) objeto).getPrograma().trim().equals("") 		||
					((ModificacaoEscopo) objeto).getProjeto().trim().equals("") 		||
					((ModificacaoEscopo) objeto).getCodigoprojeto().trim().equals("") 	||					
					((ModificacaoEscopo) objeto).getGerente().trim().equals("") 		||
					((ModificacaoEscopo) objeto).getRequerido().trim().equals("") 		||
					((ModificacaoEscopo) objeto).getNumero_me().equals("")				||
					((ModificacaoEscopo) objeto).getDataemissao().trim().equals("") 	||
					((ModificacaoEscopo) objeto).getDescricao().trim().equals("") 		||
					((ModificacaoEscopo) objeto).getMotivo().trim().equals("")	 		||
					((ModificacaoEscopo) objeto).getImpacto().trim().equals("") 		||
					((ModificacaoEscopo) objeto).getEscopo().trim().equals("") 			||
					((ModificacaoEscopo) objeto).getCusto().trim().equals("") 			||
					((ModificacaoEscopo) objeto).getPrazo().trim().equals("") 			||
					((ModificacaoEscopo) objeto).getComentarios().trim().equals("") 	||
					((ModificacaoEscopo) objeto).getReferencia().trim().equals("") 		||
					((ModificacaoEscopo) objeto).getAnexo().trim().equals("") 		    ||
					((ModificacaoEscopo) objeto).getParecer().trim().equals("") 		||
					((ModificacaoEscopo) objeto).getAprovacao().trim().equals("") 		||
					((ModificacaoEscopo) objeto).getCodigoprojeto().trim().equals("")
					
					)
				return false;
		}
		else if(objeto instanceof LicoesAprendida){
			if(
					((LicoesAprendida) objeto).getEmpresa().equals("")					||
					((LicoesAprendida) objeto).getOrgao().trim().equals("") 			||
					((LicoesAprendida) objeto).getSetor().trim().equals("") 			||
					((LicoesAprendida) objeto).getPrograma().trim().equals("") 			||
					((LicoesAprendida) objeto).getProjeto().trim().equals("") 			||
					((LicoesAprendida) objeto).getCodigoprojeto().trim().equals("") 	||					
					((LicoesAprendida) objeto).getGerente().trim().equals("") 			||
					((LicoesAprendida) objeto).getFuncao().trim().equals("") 			||
					((LicoesAprendida) objeto).getAprovado().equals("")					||
					((LicoesAprendida) objeto).getVersao().trim().equals("") 			||
					((LicoesAprendida) objeto).getPergunta1().trim().equals("") 		||
					((LicoesAprendida) objeto).getPergunta2().trim().equals("") 		||
					((LicoesAprendida) objeto).getPergunta3().trim().equals("") 		||
					((LicoesAprendida) objeto).getPergunta4().trim().equals("") 		||
					((LicoesAprendida) objeto).getPergunta5().trim().equals("") 		||
					((LicoesAprendida) objeto).getPergunta6().trim().equals("") 		||
					((LicoesAprendida) objeto).getPergunta7().trim().equals("") 		||
					((LicoesAprendida) objeto).getPergunta8().trim().equals("") 		||
					((LicoesAprendida) objeto).getPergunta9().trim().equals("") 		||
					((LicoesAprendida) objeto).getPergunta10().trim().equals("") 		||
					((LicoesAprendida) objeto).getPergunta11().trim().equals("") 		||
					((LicoesAprendida) objeto).getPergunta12().trim().equals("") 		||
					((LicoesAprendida) objeto).getPergunta13().trim().equals("") 		||
					((LicoesAprendida) objeto).getPergunta14().trim().equals("") 		||
					((LicoesAprendida) objeto).getPergunta15().trim().equals("") 		||
					((LicoesAprendida) objeto).getPergunta16().trim().equals("") 		||
					((LicoesAprendida) objeto).getPergunta1().trim().equals("") 		
					
					)
				return false;
		}
		else if(objeto instanceof PlanoGerenciamentoQualidade){
			if(
					((PlanoGerenciamentoQualidade) objeto).getPlanogerenciamentoqualidade().equals("")		||
					((PlanoGerenciamentoQualidade) objeto).getProjeto().trim().equals("") 					||
					((PlanoGerenciamentoQualidade) objeto).getCodigoprojeto().trim().equals("") 			||
					((PlanoGerenciamentoQualidade) objeto).getVersao().trim().equals("") 					||
					((PlanoGerenciamentoQualidade) objeto).getData().trim().equals("") 						||
					((PlanoGerenciamentoQualidade) objeto).getAutor().trim().equals("") 					||					
					((PlanoGerenciamentoQualidade) objeto).getNotarevisao().trim().equals("") 				||
					((PlanoGerenciamentoQualidade) objeto).getAprovacao().trim().equals("") 				||
					((PlanoGerenciamentoQualidade) objeto).getObjetivo().equals("")							||
					((PlanoGerenciamentoQualidade) objeto).getMetodo().trim().equals("") 					||
					((PlanoGerenciamentoQualidade) objeto).getProcessoqualidade().trim().equals("") 		||
					((PlanoGerenciamentoQualidade) objeto).getJustificativa().trim().equals("") 			||
					((PlanoGerenciamentoQualidade) objeto).getMetrica().trim().equals("") 					||
					((PlanoGerenciamentoQualidade) objeto).getFerramentaqualidade().trim().equals("") 		||
					((PlanoGerenciamentoQualidade) objeto).getEntregaprojetoaceitacao().trim().equals("") 	||
					((PlanoGerenciamentoQualidade) objeto).getGarantiaqualidade().trim().equals("") 		||
					((PlanoGerenciamentoQualidade) objeto).getAuditoria().trim().equals("") 				||
					((PlanoGerenciamentoQualidade) objeto).getProcessomelhoria().trim().equals("") 			||
					((PlanoGerenciamentoQualidade) objeto).getResponsabilidadequalidade().trim().equals("") ||
					((PlanoGerenciamentoQualidade) objeto).getLogauditoria().trim().equals("") 				||
					((PlanoGerenciamentoQualidade) objeto).getControlequalidade().trim().equals("") 		||
					((PlanoGerenciamentoQualidade) objeto).getProcedimentoinspecao().trim().equals("") 		||
					((PlanoGerenciamentoQualidade) objeto).getProcedimentomonitoramento().trim().equals("")
					)
				return false;
		}		
		else if(objeto instanceof PlanoGerenciamentoAquisicao){
			if(
					((PlanoGerenciamentoAquisicao) objeto).getPlanogerenciamentoaquisicao().equals("")		||
					((PlanoGerenciamentoAquisicao) objeto).getProjeto().trim().equals("") 					||
					((PlanoGerenciamentoAquisicao) objeto).getCodigoprojeto().trim().equals("") 			||
					((PlanoGerenciamentoAquisicao) objeto).getVersao().trim().equals("") 					||
					((PlanoGerenciamentoAquisicao) objeto).getData().trim().equals("") 						||
					((PlanoGerenciamentoAquisicao) objeto).getAutor().trim().equals("") 					||					
					((PlanoGerenciamentoAquisicao) objeto).getNotarevisao().trim().equals("") 				||
					((PlanoGerenciamentoAquisicao) objeto).getAprovacao().trim().equals("") 				||
					((PlanoGerenciamentoAquisicao) objeto).getObjetivo().equals("")							||
					((PlanoGerenciamentoAquisicao) objeto).getMetodo().trim().equals("") 					||
					((PlanoGerenciamentoAquisicao) objeto).getProcesso().trim().equals("") 					||
					((PlanoGerenciamentoAquisicao) objeto).getDecisoes().trim().equals("") 					||
					((PlanoGerenciamentoAquisicao) objeto).getDocumento().trim().equals("") 				||
					((PlanoGerenciamentoAquisicao) objeto).getResponsabilidade().trim().equals("") 			||
					((PlanoGerenciamentoAquisicao) objeto).getMetrica().trim().equals("") 					||
					((PlanoGerenciamentoAquisicao) objeto).getPremissarestricao().trim().equals("") 		||
					((PlanoGerenciamentoAquisicao) objeto).getRiscos().trim().equals("") 					||
					((PlanoGerenciamentoAquisicao) objeto).getFornecedor().trim().equals("") 				||
					((PlanoGerenciamentoAquisicao) objeto).getConduziraquisicao().trim().equals("") 		||
					((PlanoGerenciamentoAquisicao) objeto).getTipocontrato().trim().equals("") 				||
					((PlanoGerenciamentoAquisicao) objeto).getCriterioavaliacao().trim().equals("") 		||
					((PlanoGerenciamentoAquisicao) objeto).getControlaaquisicao().trim().equals("")			||
					((PlanoGerenciamentoAquisicao) objeto).getAvalicacaofornecedor().trim().equals("") 		||
					((PlanoGerenciamentoAquisicao) objeto).getEncerraraquisicao().trim().equals("")
					)
				return false;
		}
		else if(objeto instanceof PlanoGerenciamentoProjeto){
			if(
					((PlanoGerenciamentoProjeto) objeto).getPlanogerenciamentoprojeto().equals("")		||
					((PlanoGerenciamentoProjeto) objeto).getProjetoinicio().getCodigo().equals("") 				||
					((PlanoGerenciamentoProjeto) objeto).getVersao().trim().equals("") 					||
					((PlanoGerenciamentoProjeto) objeto).getData().equals("") 					||
					((PlanoGerenciamentoProjeto) objeto).getAutor().trim().equals("") 					||					
					((PlanoGerenciamentoProjeto) objeto).getNotarevisao().trim().equals("") 			||
					((PlanoGerenciamentoProjeto) objeto).getAprovacao().trim().equals("") 				||
					((PlanoGerenciamentoProjeto) objeto).getObjetivo().equals("")						||
					((PlanoGerenciamentoProjeto) objeto).getLinhabase().trim().equals("") 				||
					((PlanoGerenciamentoProjeto) objeto).getOrganizacao().trim().equals("") 			||
					((PlanoGerenciamentoProjeto) objeto).getCronograma().trim().equals("") 				||
					((PlanoGerenciamentoProjeto) objeto).getProgresso().trim().equals("") 				||
					((PlanoGerenciamentoProjeto) objeto).getRisco().trim().equals("") 					||
					((PlanoGerenciamentoProjeto) objeto).getComunicacao().trim().equals("") 			||
					((PlanoGerenciamentoProjeto) objeto).getMudanca().trim().equals("") 		
					)
				return false;
		}
		else if(objeto instanceof SolicitacaoMudanca){
			if(
					((SolicitacaoMudanca) objeto).getSolicitacaomudanca().equals("")		||
					((SolicitacaoMudanca) objeto).getProjetoinicio().equals("") 	||
					((SolicitacaoMudanca) objeto).getVersao().equals("") 			||
					((SolicitacaoMudanca) objeto).getData().equals("") 				||
					((SolicitacaoMudanca) objeto).getAutor().trim().equals("") 				||					
					((SolicitacaoMudanca) objeto).getNotarevisao().trim().equals("") 		||
					((SolicitacaoMudanca) objeto).getAprovacao().trim().equals("") 			||
					((SolicitacaoMudanca) objeto).getSolicitante().equals("")				||
					((SolicitacaoMudanca) objeto).getPrioridade().trim().equals("") 		||
					((SolicitacaoMudanca) objeto).getDescricao().trim().equals("") 			||
					((SolicitacaoMudanca) objeto).getJustificativa().trim().equals("")		||
					((SolicitacaoMudanca) objeto).getClassificacao().trim().equals("")		
					)
				return false;
		}
		else if(objeto instanceof RegistroSolicitacaoMudanca){
			if(
					((RegistroSolicitacaoMudanca) objeto).getSolicitacaomudanca().equals("")			||
					((RegistroSolicitacaoMudanca) objeto).getProjetoinicio().equals("") 				||
					((RegistroSolicitacaoMudanca) objeto).getSolicitacaomudanca().equals("") 			||
					((RegistroSolicitacaoMudanca) objeto).getVersao().trim().equals("") 				||
					((RegistroSolicitacaoMudanca) objeto).getData().equals("") 					||
					((RegistroSolicitacaoMudanca) objeto).getAutor().trim().equals("") 					||					
					((RegistroSolicitacaoMudanca) objeto).getNotarevisao().trim().equals("") 			||
					((RegistroSolicitacaoMudanca) objeto).getAprovacao().trim().equals("") 				||
					((RegistroSolicitacaoMudanca) objeto).getPrioridade().trim().equals("") 			||
					((RegistroSolicitacaoMudanca) objeto).getImpedeimplantacao().trim().equals("") 		||
					((RegistroSolicitacaoMudanca) objeto).getSolicitacao().trim().equals("")			||
					((RegistroSolicitacaoMudanca) objeto).getDatasolicitacao().equals("") 		||
					((RegistroSolicitacaoMudanca) objeto).getDescricao().trim().equals("") 				||
					((RegistroSolicitacaoMudanca) objeto).getJustificativa().trim().equals("")			||			
					((RegistroSolicitacaoMudanca) objeto).getClassificacao().trim().equals("") 			||
					((RegistroSolicitacaoMudanca) objeto).getResponsavel().trim().equals("") 			||
					((RegistroSolicitacaoMudanca) objeto).getPrevisao().trim().equals("")				||
					((RegistroSolicitacaoMudanca) objeto).getStatus().trim().equals("")					||
					((RegistroSolicitacaoMudanca) objeto).getComentarios().trim().equals("")
					)
				return false;
		}
		else if(objeto instanceof DicionarioEAP){
			if(
					((DicionarioEAP) objeto).getDicionarioeap().equals("")				||
					((DicionarioEAP) objeto).getProjetoinicio().equals("") 			||
					((DicionarioEAP) objeto).getVersao().trim().equals("") 				||
					((DicionarioEAP) objeto).getData().equals("") 				||
					((DicionarioEAP) objeto).getAutor().trim().equals("") 				||					
					((DicionarioEAP) objeto).getNotarevisao().trim().equals("") 		||
					((DicionarioEAP) objeto).getAprovacao().trim().equals("") 			||
					((DicionarioEAP) objeto).getEntregapacote().trim().equals("") 		||
					((DicionarioEAP) objeto).getDescricao().trim().equals("") 			||
					((DicionarioEAP) objeto).getCriterioaceitacao().trim().equals("")	||
					((DicionarioEAP) objeto).getResponsavel().trim().equals("") 		||
					((DicionarioEAP) objeto).getAprovado().trim().equals("") 			||
					((DicionarioEAP) objeto).getConsultado().trim().equals("")			||
					((DicionarioEAP) objeto).getInformado().trim().equals("") 			||
					((DicionarioEAP) objeto).getTrabalhoenvolvido().trim().equals("") 	||
					((DicionarioEAP) objeto).getRiscos().trim().equals("")				||					
					((DicionarioEAP) objeto).getRecusos().trim().equals("") 			||
					((DicionarioEAP) objeto).getMacros().trim().equals("") 				||
					((DicionarioEAP) objeto).getPrevisao().trim().equals("")			||
					((DicionarioEAP) objeto).getInformacoes().trim().equals("")			||
					((DicionarioEAP) objeto).getStatus().trim().equals("")				||
					((DicionarioEAP) objeto).getComentarios().trim().equals("")					
					)
				return false;
		}
		else if(objeto instanceof TermoAceiteEntrega ){
			if(
					((TermoAceiteEntrega) objeto).getTermo().equals("")					||
					((TermoAceiteEntrega) objeto).getProjeto().trim().equals("") 		||
					((TermoAceiteEntrega) objeto).getCodigoprojeto().equals("")			||
					((TermoAceiteEntrega) objeto).getObjetivo().trim().equals("") 		||
					((TermoAceiteEntrega) objeto).getEntrega().trim().equals("") 		||
					((TermoAceiteEntrega) objeto).getQuestao().trim().equals("") 		||					
					((TermoAceiteEntrega) objeto).getInformacao().trim().equals("")		||
					((TermoAceiteEntrega) objeto).getAceite().trim().equals("")		
					)
				return false;
		}
		else if(objeto instanceof PlanoMelhoriaProcesso ){
			if(
					((PlanoMelhoriaProcesso) objeto).getPlanomelhoriaprocesso().equals("")	||
					((PlanoMelhoriaProcesso) objeto).getProjeto().trim().equals("") 		||
					((PlanoMelhoriaProcesso) objeto).getCodigoprojeto().equals("")			||
					((PlanoMelhoriaProcesso) objeto).getVersao().trim().equals("") 			||
					((PlanoMelhoriaProcesso) objeto).getData().trim().equals("") 			||
					((PlanoMelhoriaProcesso) objeto).getAutor().trim().equals("") 			||					
					((PlanoMelhoriaProcesso) objeto).getNotarevisao().trim().equals("")		||
					((PlanoMelhoriaProcesso) objeto).getObjetivo().trim().equals("")		||
					((PlanoMelhoriaProcesso) objeto).getLimite().trim().equals("")			||
					((PlanoMelhoriaProcesso) objeto).getConfiguracao().trim().equals("")	||
					((PlanoMelhoriaProcesso) objeto).getMetrica().trim().equals("")			||
					((PlanoMelhoriaProcesso) objeto).getMeta().trim().equals("")			||
					((PlanoMelhoriaProcesso) objeto).getAprovacao().trim().equals("")		
					)
				return false;
		}
		else if(objeto instanceof PlanoGerenciamentoRisco ){
			if(
					((PlanoGerenciamentoRisco) objeto).getPlanogerenciamentorisco().equals("")		||
					((PlanoGerenciamentoRisco) objeto).getProjeto().trim().equals("") 				||
					((PlanoGerenciamentoRisco) objeto).getCodigoprojeto().equals("")				||
					((PlanoGerenciamentoRisco) objeto).getVersao().trim().equals("") 				||
					((PlanoGerenciamentoRisco) objeto).getData().trim().equals("") 					||
					((PlanoGerenciamentoRisco) objeto).getAutor().trim().equals("") 				||					
					((PlanoGerenciamentoRisco) objeto).getNotarevisao().trim().equals("")			||
					((PlanoGerenciamentoRisco) objeto).getObjetivo().trim().equals("")				||
					((PlanoGerenciamentoRisco) objeto).getGerenciamento().trim().equals("")			||
					((PlanoGerenciamentoRisco) objeto).getProcesso().trim().equals("")				||
					((PlanoGerenciamentoRisco) objeto).getDocumento().trim().equals("")				||
					((PlanoGerenciamentoRisco) objeto).getResponsabilidade().trim().equals("")		||					
					((PlanoGerenciamentoRisco) objeto).getIdentificar().trim().equals("") 			||					
					((PlanoGerenciamentoRisco) objeto).getEar().trim().equals("")					||
					((PlanoGerenciamentoRisco) objeto).getRiscos().trim().equals("")				||
					((PlanoGerenciamentoRisco) objeto).getAnalisequalitativa().trim().equals("")	||
					((PlanoGerenciamentoRisco) objeto).getAnalisequantitativa().trim().equals("")	||
					((PlanoGerenciamentoRisco) objeto).getPlanejar().trim().equals("")				||
					((PlanoGerenciamentoRisco) objeto).getReservas().trim().equals("")				||
					((PlanoGerenciamentoRisco) objeto).getControlar().trim().equals("")				||					
					((PlanoGerenciamentoRisco) objeto).getAprovacao().trim().equals("")		
					)
				return false;
		}
		else if(objeto instanceof PlanoGerenciamentoCusto ){
			if(
					((PlanoGerenciamentoCusto) objeto).getPlanogerenciamentocusto().equals("")	||
					((PlanoGerenciamentoCusto) objeto).getProjeto().trim().equals("") 			||
					((PlanoGerenciamentoCusto) objeto).getCodigoprojeto().equals("")			||
					((PlanoGerenciamentoCusto) objeto).getVersao().trim().equals("") 			||
					((PlanoGerenciamentoCusto) objeto).getData().trim().equals("") 				||
					((PlanoGerenciamentoCusto) objeto).getAutor().trim().equals("") 			||					
					((PlanoGerenciamentoCusto) objeto).getNotarevisao().trim().equals("")		||
					((PlanoGerenciamentoCusto) objeto).getAprovacao().trim().equals("")			||
					((PlanoGerenciamentoCusto) objeto).getObjetivo().trim().equals("")			||
					((PlanoGerenciamentoCusto) objeto).getMetodo().trim().equals("")			||
					((PlanoGerenciamentoCusto) objeto).getProcesso().trim().equals("")			||
					((PlanoGerenciamentoCusto) objeto).getDocumento().trim().equals("")			||
					((PlanoGerenciamentoCusto) objeto).getFerramenta().trim().equals("")		||
					((PlanoGerenciamentoCusto) objeto).getPapeis().trim().equals("")			||
					((PlanoGerenciamentoCusto) objeto).getPlano().trim().equals("")				||
					((PlanoGerenciamentoCusto) objeto).getCusto().trim().equals("")				||
					((PlanoGerenciamentoCusto) objeto).getOrcamento().trim().equals("")			||
					((PlanoGerenciamentoCusto) objeto).getControlarcusto().trim().equals("")
					)
				return false;
		}
		else if(objeto instanceof BusinessCase ){
			if(
					((BusinessCase) objeto).getBusinesscase().equals("")			||
					//((BusinessCase) objeto).getProjeto().trim().equals("") 			||
					((BusinessCase) objeto).getVersao().trim().equals("") 			||
					((BusinessCase) objeto).getData().equals("") 			||
					((BusinessCase) objeto).getAutor().trim().equals("") 			||					
					((BusinessCase) objeto).getNotarevisao().trim().equals("")		||
					((BusinessCase) objeto).getAprovacao().trim().equals("")		||
					((BusinessCase) objeto).getObjetivodocumento().trim().equals("")||
					((BusinessCase) objeto).getObjetivo().trim().equals("")			||
					((BusinessCase) objeto).getNecessidade().trim().equals("")		||
					((BusinessCase) objeto).getIndicadores().trim().equals("")		||
					((BusinessCase) objeto).getPrevisao().trim().equals("")			||
					((BusinessCase) objeto).getOrganizacao().trim().equals("")		||
					((BusinessCase) objeto).getAnalise().trim().equals("")			||
					((BusinessCase) objeto).getPartes().trim().equals("")			||
					((BusinessCase) objeto).getOrcamento().trim().equals("")
					)
				return false;
		}
		else if(objeto instanceof SolicitacaoProjeto ){
			if(
					((SolicitacaoProjeto) objeto).getSolicitacaoprojeto().equals("")	||
					((SolicitacaoProjeto) objeto).getProjeto().trim().equals("") 		||
					((SolicitacaoProjeto) objeto).getCodigoprojeto().equals("")			||
					((SolicitacaoProjeto) objeto).getVersao().trim().equals("") 		||
					((SolicitacaoProjeto) objeto).getData().trim().equals("") 			||
					((SolicitacaoProjeto) objeto).getAutor().trim().equals("") 			||					
					((SolicitacaoProjeto) objeto).getNotarevisao().trim().equals("")	||
					((SolicitacaoProjeto) objeto).getObjetivo().trim().equals("")		||
					((SolicitacaoProjeto) objeto).getAtual().trim().equals("")			||
					((SolicitacaoProjeto) objeto).getDescricao().trim().equals("")		||
					((SolicitacaoProjeto) objeto).getAprovacao().trim().equals("")		
					)
				return false;
		}	
		else if(objeto instanceof RegistroParteInteressada ){
			if(
					((RegistroParteInteressada) objeto).getRegistroparteinteressada().equals("")||
					((RegistroParteInteressada) objeto).getProjetoinicio().equals("") 			||
					((RegistroParteInteressada) objeto).getVersao().trim().equals("") 			||
					((RegistroParteInteressada) objeto).getData().trim().equals("") 			||
					((RegistroParteInteressada) objeto).getAutor().trim().equals("") 			||					
					((RegistroParteInteressada) objeto).getNotarevisao().trim().equals("")		||
					((RegistroParteInteressada) objeto).getAprovacao().trim().equals("")		||
					((RegistroParteInteressada) objeto).getCodigoparteinteressada().equals("")	||
					((RegistroParteInteressada) objeto).getImportancia().equals("")				||
					((RegistroParteInteressada) objeto).getParteinteressada().trim().equals("")	||
					((RegistroParteInteressada) objeto).getEmpresa().trim().equals("")			||
					((RegistroParteInteressada) objeto).getFuncaoprojeto().trim().equals("")	||
					((RegistroParteInteressada) objeto).getEmail().trim().equals("")			||
					((RegistroParteInteressada) objeto).getCelular().trim().equals("")			||
					((RegistroParteInteressada) objeto).getFone().trim().equals("")				||
					((RegistroParteInteressada) objeto).getRequisito().trim().equals("")		||
					((RegistroParteInteressada) objeto).getResponsabilidade().trim().equals("")	||
					((RegistroParteInteressada) objeto).getExpectativas().trim().equals("")		||
					((RegistroParteInteressada) objeto).getPoder().trim().equals("")			||
					((RegistroParteInteressada) objeto).getInteresse().trim().equals("")		||	
					((RegistroParteInteressada) objeto).getComentario().trim().equals("")
					)
				return false;
		}
		
		else if(objeto instanceof BusinessPlan ){
			if(
					((BusinessPlan) objeto).getBusinessplan().equals("")				||
					((BusinessPlan) objeto).getProjetoinicio().equals("")			||
					((BusinessPlan) objeto).getVersao().trim().equals("") 				||
					((BusinessPlan) objeto).getData().equals("") 				||
					((BusinessPlan) objeto).getAutor().trim().equals("") 				||					
					((BusinessPlan) objeto).getNotarevisao().trim().equals("")			||
					((BusinessPlan) objeto).getAprovacao().trim().equals("")			||
					((BusinessPlan) objeto).getSituacaomercado().equals("")				||
					((BusinessPlan) objeto).getSituacaoservico().equals("")				||
					((BusinessPlan) objeto).getSituacaocompetividade().trim().equals("")||
					((BusinessPlan) objeto).getSituacaodistribuicao().trim().equals("")	||
					((BusinessPlan) objeto).getSituacaomacro().trim().equals("")		||
					((BusinessPlan) objeto).getAnaliseexterno().trim().equals("")		||
					((BusinessPlan) objeto).getAnaliseinterno().trim().equals("")		||
					((BusinessPlan) objeto).getAnaliserelacionada().trim().equals("")	||
					((BusinessPlan) objeto).getObjetivofinanceiro().trim().equals("")	||
					((BusinessPlan) objeto).getObjetivomarketing().trim().equals("")	||
					((BusinessPlan) objeto).getCronograma().trim().equals("")			||
					((BusinessPlan) objeto).getEstrategia().trim().equals("")			||
					((BusinessPlan) objeto).getSegmento().trim().equals("")		
					)
				return false;
		}
		else if(objeto instanceof RegistroParteInteressadaFornecedor ){
			if(
					((RegistroParteInteressadaFornecedor) objeto).getRegistroparteinteressada().equals("")	||
					((RegistroParteInteressadaFornecedor) objeto).getProjeto().trim().equals("") 			||
					((RegistroParteInteressadaFornecedor) objeto).getCodigoprojeto().equals("")				||
					((RegistroParteInteressadaFornecedor) objeto).getVersao().trim().equals("") 			||
					((RegistroParteInteressadaFornecedor) objeto).getData().trim().equals("") 				||
					((RegistroParteInteressadaFornecedor) objeto).getAutor().trim().equals("") 				||					
					((RegistroParteInteressadaFornecedor) objeto).getNotarevisao().trim().equals("")		||
					((RegistroParteInteressadaFornecedor) objeto).getAprovacao().trim().equals("")			||
					((RegistroParteInteressadaFornecedor) objeto).getCodigofornecedor().equals("")			||
					((RegistroParteInteressadaFornecedor) objeto).getRazaosocial().equals("")				||
					((RegistroParteInteressadaFornecedor) objeto).getFone().trim().equals("")				||
					((RegistroParteInteressadaFornecedor) objeto).getSite().trim().equals("")				||
					((RegistroParteInteressadaFornecedor) objeto).getContrato().trim().equals("")			||
					((RegistroParteInteressadaFornecedor) objeto).getProposta().trim().equals("")			||
					((RegistroParteInteressadaFornecedor) objeto).getResponsabilidade().trim().equals("")	||
					((RegistroParteInteressadaFornecedor) objeto).getControle().trim().equals("")	
					)
				return false;
		}
		else if(objeto instanceof PlanoGerenciamentoComunicacao ){
			if(					
					((PlanoGerenciamentoComunicacao) objeto).getPlanogerenciamentocomunicacao().equals("")	||
					((PlanoGerenciamentoComunicacao) objeto).getProjeto().trim().equals("") 				||
					((PlanoGerenciamentoComunicacao) objeto).getCodigoprojeto().equals("")					||
					((PlanoGerenciamentoComunicacao) objeto).getVersao().trim().equals("") 					||
					((PlanoGerenciamentoComunicacao) objeto).getData().trim().equals("") 					||
					((PlanoGerenciamentoComunicacao) objeto).getAutor().trim().equals("") 					||					
					((PlanoGerenciamentoComunicacao) objeto).getNotarevisao().trim().equals("")				||
					((PlanoGerenciamentoComunicacao) objeto).getAprovacao().trim().equals("")				||
					((PlanoGerenciamentoComunicacao) objeto).getObjetivo().equals("")						||
					((PlanoGerenciamentoComunicacao) objeto).getProcesso().equals("")						||
					((PlanoGerenciamentoComunicacao) objeto).getRequisito().trim().equals("")				||
					((PlanoGerenciamentoComunicacao) objeto).getInformcacao().trim().equals("")				||
					((PlanoGerenciamentoComunicacao) objeto).getTecnologia().trim().equals("")				||
					((PlanoGerenciamentoComunicacao) objeto).getDiretrize().trim().equals("")				||
					((PlanoGerenciamentoComunicacao) objeto).getComunicacao().trim().equals("")				||
					((PlanoGerenciamentoComunicacao) objeto).getGestao().equals("")							||
					((PlanoGerenciamentoComunicacao) objeto).getStatus().trim().equals("")					||
					((PlanoGerenciamentoComunicacao) objeto).getGerenciareunioes().trim().equals("")		||
					((PlanoGerenciamentoComunicacao) objeto).getGerenciaquestoes().trim().equals("")		||
					((PlanoGerenciamentoComunicacao) objeto).getPlanoescalonamento().trim().equals("")		||
					((PlanoGerenciamentoComunicacao) objeto).getEventocomunicacao().trim().equals("")		||
					((PlanoGerenciamentoComunicacao) objeto).getAnexo().trim().equals("")	
					)
				return false;
		}
		else if(objeto instanceof PlanoGerenciamentoParteInteressada ){
			if(					
					((PlanoGerenciamentoParteInteressada) objeto).getPlanogerenciamentointeressada().equals("")	||
					((PlanoGerenciamentoParteInteressada) objeto).getProjetoinicio().equals("")					||
					((PlanoGerenciamentoParteInteressada) objeto).getVersao().trim().equals("") 				||
					((PlanoGerenciamentoParteInteressada) objeto).getData().equals("") 					||
					((PlanoGerenciamentoParteInteressada) objeto).getAutor().trim().equals("") 					||					
					((PlanoGerenciamentoParteInteressada) objeto).getNotarevisao().trim().equals("")			||
					((PlanoGerenciamentoParteInteressada) objeto).getAprovacao().trim().equals("")				||
					((PlanoGerenciamentoParteInteressada) objeto).getObjetivo().equals("")						||
					((PlanoGerenciamentoParteInteressada) objeto).getProcesso().equals("")						||
					((PlanoGerenciamentoParteInteressada) objeto).getParteinteressada().trim().equals("")		||
					((PlanoGerenciamentoParteInteressada) objeto).getGerenciarparte().trim().equals("")			||
					((PlanoGerenciamentoParteInteressada) objeto).getControlaparte().trim().equals("")			||
					((PlanoGerenciamentoParteInteressada) objeto).getAnexo().trim().equals("")
					)
				return false;
		}
		else if(objeto instanceof PlanoGerenciamentoCronograma ){
			if(					
					((PlanoGerenciamentoCronograma) objeto).getPlanogerenciamentocronograma().equals("")	||
					((PlanoGerenciamentoCronograma) objeto).getProjetoinicio().equals("") 					||
					((PlanoGerenciamentoCronograma) objeto).getVersao().trim().equals("") 					||
					((PlanoGerenciamentoCronograma) objeto).getData().equals("") 					||
					((PlanoGerenciamentoCronograma) objeto).getAutor().trim().equals("") 					||					
					((PlanoGerenciamentoCronograma) objeto).getNotarevisao().trim().equals("")				||
					((PlanoGerenciamentoCronograma) objeto).getAprovacao().trim().equals("")				||
					((PlanoGerenciamentoCronograma) objeto).getObjetivo().equals("")						||
					((PlanoGerenciamentoCronograma) objeto).getMetodo().equals("")							||
					((PlanoGerenciamentoCronograma) objeto).getProcesso().trim().equals("")					||
					((PlanoGerenciamentoCronograma) objeto).getDocumento().trim().equals("")				||
					((PlanoGerenciamentoCronograma) objeto).getFerramenta().trim().equals("")				||
					((PlanoGerenciamentoCronograma) objeto).getPapeis().trim().equals("")					||
					((PlanoGerenciamentoCronograma) objeto).getPlano().trim().equals("")					||
					((PlanoGerenciamentoCronograma) objeto).getAtividade().equals("")						||
					((PlanoGerenciamentoCronograma) objeto).getSequenciar().trim().equals("")				||
					((PlanoGerenciamentoCronograma) objeto).getEstimarrecuso().trim().equals("")			||
					((PlanoGerenciamentoCronograma) objeto).getEstimarduracao().trim().equals("")			||
					((PlanoGerenciamentoCronograma) objeto).getDesenvolver().trim().equals("")				||
					((PlanoGerenciamentoCronograma) objeto).getControlar().trim().equals("")		
					)
				return false;
		}
		else if(objeto instanceof PlanoGerenciamentoRequisito ){
			if(					
					((PlanoGerenciamentoRequisito) objeto).getPlanogerenciamentorequisito().equals("")	||
					((PlanoGerenciamentoRequisito) objeto).getVersao().trim().equals("") 				||
					((PlanoGerenciamentoRequisito) objeto).getData().equals("") 					||
					((PlanoGerenciamentoRequisito) objeto).getAutor().trim().equals("") 				||					
					((PlanoGerenciamentoRequisito) objeto).getNotarevisao().trim().equals("")			||
					((PlanoGerenciamentoRequisito) objeto).getAprovacao().trim().equals("")				||
					((PlanoGerenciamentoRequisito) objeto).getObjetivo().equals("")						||
					((PlanoGerenciamentoRequisito) objeto).getGerenciamento().equals("")				||
					((PlanoGerenciamentoRequisito) objeto).getProcesso().trim().equals("")				||
					((PlanoGerenciamentoRequisito) objeto).getDocumento().trim().equals("")				||
					((PlanoGerenciamentoRequisito) objeto).getResponsabilidade().trim().equals("")		||
					((PlanoGerenciamentoRequisito) objeto).getConfiguracao().trim().equals("")			||
					((PlanoGerenciamentoRequisito) objeto).getPrioridade().trim().equals("")			||
					((PlanoGerenciamentoRequisito) objeto).getColeta().trim().equals("")				||
					((PlanoGerenciamentoRequisito) objeto).getRatreabilidade().trim().equals("")		||
					((PlanoGerenciamentoRequisito) objeto).getMetrica().trim().equals("")				||
					((PlanoGerenciamentoRequisito) objeto).getProjetoinicio().equals("") 					

					)
				return false;
		}
		else if(objeto instanceof MatrizComunicacao ){
			if(					
					((MatrizComunicacao) objeto).getCodigomatriz().equals("")	||
					((MatrizComunicacao) objeto).getPergunta1().trim().equals("") 				||
					((MatrizComunicacao) objeto).getPergunta2().trim().equals("") 				||
					((MatrizComunicacao) objeto).getPergunta3().trim().equals("") 				||
					((MatrizComunicacao) objeto).getPergunta4().trim().equals("") 				||
					((MatrizComunicacao) objeto).getPergunta5().trim().equals("") 				||
					((MatrizComunicacao) objeto).getPergunta6().trim().equals("") 				||
					((MatrizComunicacao) objeto).getPergunta7().trim().equals("") 				||
					((MatrizComunicacao) objeto).getPergunta8().trim().equals("") 				||
					((MatrizComunicacao) objeto).getComentario().trim().equals("") 	
					
					)
				return false;
		}
		else if(objeto instanceof DeclaracaoTrabalho ){
			if(					
					((DeclaracaoTrabalho) objeto).getDeclaracaotrabalho().equals("")		||
					((DeclaracaoTrabalho) objeto).getProjeto().trim().equals("") 			||
					((DeclaracaoTrabalho) objeto).getCodigoprojeto().equals("")				||
					((DeclaracaoTrabalho) objeto).getVersao().trim().equals("") 			||
					((DeclaracaoTrabalho) objeto).getData().trim().equals("") 				||
					((DeclaracaoTrabalho) objeto).getAutor().trim().equals("") 				||					
					((DeclaracaoTrabalho) objeto).getNotarevisao().trim().equals("")		||
					((DeclaracaoTrabalho) objeto).getAprovacao().trim().equals("")			||
					((DeclaracaoTrabalho) objeto).getObjetivo().equals("")					||
					((DeclaracaoTrabalho) objeto).getEscopo().equals("")					||
					((DeclaracaoTrabalho) objeto).getCronograma().trim().equals("")			||
					((DeclaracaoTrabalho) objeto).getPadrao().trim().equals("")				||
					((DeclaracaoTrabalho) objeto).getRequisito().trim().equals("")			||
					((DeclaracaoTrabalho) objeto).getLocal().trim().equals("")				||
					((DeclaracaoTrabalho) objeto).getPeriodo().trim().equals("")			||
					((DeclaracaoTrabalho) objeto).getRequisitoespecial().trim().equals("")
					)
				return false;
		}
		else if(objeto instanceof StatusReport ){
			if(					
					((StatusReport) objeto).getStatusreport().equals("")				||
					((StatusReport) objeto).getProjeto().trim().equals("") 				||
					((StatusReport) objeto).getCodigoprojeto().equals("")				||
					((StatusReport) objeto).getPeriodoinicio().trim().equals("") 		||
					((StatusReport) objeto).getPeriodofim().trim().equals("") 			||
					((StatusReport) objeto).getIndicador().trim().equals("") 			||					
					((StatusReport) objeto).getStatus().trim().equals("")				||
					((StatusReport) objeto).getComentario().trim().equals("")			||
					((StatusReport) objeto).getEap().equals("")							||
					((StatusReport) objeto).getPeriodo().equals("")						||
					((StatusReport) objeto).getAtividadeandamento().trim().equals("")	||
					((StatusReport) objeto).getProximoperiodo().trim().equals("")		||
					((StatusReport) objeto).getPontoatencao().trim().equals("")			||
					((StatusReport) objeto).getAdicionais().trim().equals("")
					)
				return false;
		}
		else if(objeto instanceof CriterioPreQualificacao ){
			if(					
					((CriterioPreQualificacao) objeto).getRfp().equals("")						||
					((CriterioPreQualificacao) objeto).getProjeto().trim().equals("") 			||
					((CriterioPreQualificacao) objeto).getCodigoprojeto().equals("")			||
					((CriterioPreQualificacao) objeto).getGp().trim().equals("") 				||
					((CriterioPreQualificacao) objeto).getPatrocinador().trim().equals("") 		||
					((CriterioPreQualificacao) objeto).getArea().trim().equals("") 				||					
					((CriterioPreQualificacao) objeto).getParticipante().trim().equals("")		||
					((CriterioPreQualificacao) objeto).getAprovado().trim().equals("")			||
					((CriterioPreQualificacao) objeto).getReprovado().equals("")
					)
				return false;
		}
		else if(objeto instanceof TransicaoProduto ){
			if(					
					((TransicaoProduto) objeto).getTransicaoproduto().equals("")			||
					((TransicaoProduto) objeto).getProjeto().trim().equals("") 				||
					((TransicaoProduto) objeto).getCodigoprojeto().equals("")				||
					((TransicaoProduto) objeto).getVersao().trim().equals("") 				||
					((TransicaoProduto) objeto).getData().trim().equals("") 				||
					((TransicaoProduto) objeto).getAutor().trim().equals("") 				||					
					((TransicaoProduto) objeto).getNotarevisao().trim().equals("")			||
					((TransicaoProduto) objeto).getAprovacao().trim().equals("")			||
					((TransicaoProduto) objeto).getObjetivo().equals("")					||
					((TransicaoProduto) objeto).getPeriodo().equals("")						||
					((TransicaoProduto) objeto).getProcedimento().trim().equals("")			||
					((TransicaoProduto) objeto).getTreinamento().trim().equals("")			||
					((TransicaoProduto) objeto).getResponsavelprojeto().trim().equals("")	||
					((TransicaoProduto) objeto).getResponsaveloperacao().trim().equals("")	||
					((TransicaoProduto) objeto).getPontoaberto().trim().equals("")			||
					((TransicaoProduto) objeto).getRecomendacao().trim().equals("")
					)
				return false;
		}
		else if(objeto instanceof ListaQualidade ){
			if(					
					((ListaQualidade) objeto).getListaqualiade().equals("")				||
					((ListaQualidade) objeto).getProjeto().trim().equals("") 			||
					((ListaQualidade) objeto).getCodigoprojeto().equals("")				||
					((ListaQualidade) objeto).getVersao().trim().equals("") 			||
					((ListaQualidade) objeto).getData().trim().equals("") 				||
					((ListaQualidade) objeto).getAutor().trim().equals("") 				||					
					((ListaQualidade) objeto).getNotarevisao().trim().equals("")		||
					((ListaQualidade) objeto).getAprovacao().trim().equals("")			||
					((ListaQualidade) objeto).getProduto().equals("")					||
					((ListaQualidade) objeto).getRequsito().equals("")					||
					((ListaQualidade) objeto).getCriterio().trim().equals("")			||
					((ListaQualidade) objeto).getMetodo().trim().equals("")
					)
				return false;
		}
		else if(objeto instanceof PlanoGerenciamentoPessoal ){
			if(					
					((PlanoGerenciamentoPessoal) objeto).getPlanogerenciamentopessoal().equals("")  ||
					((PlanoGerenciamentoPessoal) objeto).getProjeto().trim().equals("") 			||
					((PlanoGerenciamentoPessoal) objeto).getCodigoprojeto().equals("")				||
					((PlanoGerenciamentoPessoal) objeto).getVersao().trim().equals("") 				||
					((PlanoGerenciamentoPessoal) objeto).getData().trim().equals("") 				||
					((PlanoGerenciamentoPessoal) objeto).getAutor().trim().equals("") 				||					
					((PlanoGerenciamentoPessoal) objeto).getNotarevisao().trim().equals("")			||
					((PlanoGerenciamentoPessoal) objeto).getAprovacao().trim().equals("")			||
					((PlanoGerenciamentoPessoal) objeto).getPergunta1().equals("")					||
					((PlanoGerenciamentoPessoal) objeto).getPergunta2().equals("")					||
					((PlanoGerenciamentoPessoal) objeto).getPergunta3().trim().equals("")			||
					((PlanoGerenciamentoPessoal) objeto).getPergunta4().trim().equals("")			||
					((PlanoGerenciamentoPessoal) objeto).getPergunta5().trim().equals("")			||
					((PlanoGerenciamentoPessoal) objeto).getPergunta6().trim().equals("")			||
					((PlanoGerenciamentoPessoal) objeto).getPergunta7().trim().equals("")
					)
				return false;
		}
		
		else if(objeto instanceof RegistroRisco ){
			if(					
					((RegistroRisco) objeto).getRegistrorisco().equals("")  			||
					((RegistroRisco) objeto).getProjetoinicio().equals("")				||
					((RegistroRisco) objeto).getVersao().trim().equals("") 				||
					((RegistroRisco) objeto).getData().equals("") 				||
					((RegistroRisco) objeto).getAutor().trim().equals("") 				||					
					((RegistroRisco) objeto).getNotarevisao().trim().equals("")			||
					((RegistroRisco) objeto).getSeveridade().equals("")					||
					((RegistroRisco) objeto).getDescricao().equals("")					||
					((RegistroRisco) objeto).getProbabilidade().equals("")				||
					((RegistroRisco) objeto).getImpacto().trim().equals("")				||
					((RegistroRisco) objeto).getDescricaoimpacto().trim().equals("")	||
					((RegistroRisco) objeto).getCategoria().trim().equals("")			||
					((RegistroRisco) objeto).getAcao().trim().equals("")				||
					((RegistroRisco) objeto).getDescricaoacao().trim().equals("")		||
					((RegistroRisco) objeto).getResponsavel().trim().equals("")			||
					((RegistroRisco) objeto).getPrevisao().trim().equals("")			||
					((RegistroRisco) objeto).getComentario().trim().equals("")
					)
				return false;
		}
		else if(objeto instanceof RegistroRiscoAcoes ){
			if(					
					((RegistroRiscoAcoes) objeto).getRegistroriscoacoes().equals("")  		||
					((RegistroRiscoAcoes) objeto).getRegistrorisco().equals("")				||
					((RegistroRiscoAcoes) objeto).getReferencia().trim().equals("") 		||
					((RegistroRiscoAcoes) objeto).getPassos().trim().equals("") 			||
					((RegistroRiscoAcoes) objeto).getVersao().trim().equals("") 			||
					((RegistroRiscoAcoes) objeto).getData().equals("") 				||
					((RegistroRiscoAcoes) objeto).getAutor().trim().equals("") 				||					
					((RegistroRiscoAcoes) objeto).getNotarevisao().trim().equals("")		||
					((RegistroRiscoAcoes) objeto).getPrioridade().equals("")				||
					((RegistroRiscoAcoes) objeto).getDescricaorisco().equals("")			||
					((RegistroRiscoAcoes) objeto).getDescricaoacao().equals("")				||
					((RegistroRiscoAcoes) objeto).getResponsavel().trim().equals("")		||
					((RegistroRiscoAcoes) objeto).getPrevisao().trim().equals("")			||
					((RegistroRiscoAcoes) objeto).getStatus().trim().equals("")				||
					((RegistroRiscoAcoes) objeto).getPrevisaooriginal().trim().equals("")	||
					((RegistroRiscoAcoes) objeto).getComentario().trim().equals("")
					)
				return false;
		}
		else if(objeto instanceof MatrizRastreabilidadeRequisito ){
			if(					
					((MatrizRastreabilidadeRequisito) objeto).getCodigomatriz().equals("")			||
					((MatrizRastreabilidadeRequisito) objeto).getPrioridade().trim().equals("") 	||
					((MatrizRastreabilidadeRequisito) objeto).getTipo().equals("")					||
					((MatrizRastreabilidadeRequisito) objeto).getNome().trim().equals("") 			||
					((MatrizRastreabilidadeRequisito) objeto).getDescricao().trim().equals("") 		||
					((MatrizRastreabilidadeRequisito) objeto).getJustificativa().trim().equals("") 	||					
					((MatrizRastreabilidadeRequisito) objeto).getCriterio().trim().equals("")		||
					((MatrizRastreabilidadeRequisito) objeto).getSolicitante().trim().equals("")	||
					((MatrizRastreabilidadeRequisito) objeto).getStatus().equals("")				||
					((MatrizRastreabilidadeRequisito) objeto).getData().equals("")					||
					((MatrizRastreabilidadeRequisito) objeto).getEap().trim().equals("")			||
					((MatrizRastreabilidadeRequisito) objeto).getId().equals("")			||
					((MatrizRastreabilidadeRequisito) objeto).getComentario().trim().equals("")
					)
				return false;
		}
		else if(objeto instanceof ListaAtividade ){
			if(					
					((ListaAtividade) objeto).getListaatividade().equals("")			||
					((ListaAtividade) objeto).getProjeto().trim().equals("") 			||
					((ListaAtividade) objeto).getCodigoprojeto().equals("")				||
					((ListaAtividade) objeto).getVersao().trim().equals("") 			||
					((ListaAtividade) objeto).getData().trim().equals("") 				||
					((ListaAtividade) objeto).getAutor().trim().equals("") 				||					
					((ListaAtividade) objeto).getNotarevisao().trim().equals("")		||
					((ListaAtividade) objeto).getAprovacao().trim().equals("")			||
					((ListaAtividade) objeto).getObjetivo().equals("")					||
					((ListaAtividade) objeto).getEntrega().equals("")
					)
				return false;
		}
		else if(objeto instanceof AtributoAtividade ){
			if(					
					((AtributoAtividade) objeto).getId().equals("")						||
					((AtributoAtividade) objeto).getOrganograma().equals("") 				||
					((AtributoAtividade) objeto).getDescricao().trim().equals("")		||
					((AtributoAtividade) objeto).getPredecessora().trim().equals("") 	||
					((AtributoAtividade) objeto).getSucessora().trim().equals("") 		||
					((AtributoAtividade) objeto).getRelacionamento().trim().equals("")	||					
					((AtributoAtividade) objeto).getAntecipacao().trim().equals("")		||
					((AtributoAtividade) objeto).getRecurso().trim().equals("")			||
					((AtributoAtividade) objeto).getData().equals("")					||
					((AtributoAtividade) objeto).getResponsavel().equals("")
					)
				return false;
		}
		else if(objeto instanceof AvaliacaoDesempenhoEquipe ){
			if(			
					((AvaliacaoDesempenhoEquipe) objeto).getAvaliacaodesempenhoequipe().trim().equals("")	||
					((AvaliacaoDesempenhoEquipe) objeto).getProjeto().trim().equals("") 					||
					((AvaliacaoDesempenhoEquipe) objeto).getCodigoprojeto().equals("")						||
					((AvaliacaoDesempenhoEquipe) objeto).getVersao().trim().equals("") 						||
					((AvaliacaoDesempenhoEquipe) objeto).getData().trim().equals("") 						||
					((AvaliacaoDesempenhoEquipe) objeto).getAutor().trim().equals("") 						||					
					((AvaliacaoDesempenhoEquipe) objeto).getNotarevisao().trim().equals("")					||
					((AvaliacaoDesempenhoEquipe) objeto).getAprovacao().trim().equals("")					||
					((AvaliacaoDesempenhoEquipe) objeto).getObjetivo().equals("")							||
					((AvaliacaoDesempenhoEquipe) objeto).getEquipe().trim().equals("")						||
					((AvaliacaoDesempenhoEquipe) objeto).getPeriodoinicio().trim().equals("") 				||
					((AvaliacaoDesempenhoEquipe) objeto).getPeriodofim().equals("")							||
					((AvaliacaoDesempenhoEquipe) objeto).getObjetivo().trim().equals("") 					||
					((AvaliacaoDesempenhoEquipe) objeto).getAvaliacao().trim().equals("") 					||
					((AvaliacaoDesempenhoEquipe) objeto).getIndicador().trim().equals("") 					||					
					((AvaliacaoDesempenhoEquipe) objeto).getStatus().trim().equals("")						||
					((AvaliacaoDesempenhoEquipe) objeto).getPontoforte().trim().equals("")					||
					((AvaliacaoDesempenhoEquipe) objeto).getPontofraco().equals("")							||
					((AvaliacaoDesempenhoEquipe) objeto).getResultadoatingido().equals("")					||
					((AvaliacaoDesempenhoEquipe) objeto).getRetornoavaliacao().trim().equals("")			||
					((AvaliacaoDesempenhoEquipe) objeto).getPlano().trim().equals("")||
					((AvaliacaoDesempenhoEquipe) objeto).getDefinicao().trim().equals("")||
					((AvaliacaoDesempenhoEquipe) objeto).getNecessidade().trim().equals("")
					)
				return false;
		}
		else if(objeto instanceof IssuesLog ){
			if(			
					((IssuesLog) objeto).getIssueslog().trim().equals("")			||
					((IssuesLog) objeto).getProjeto().trim().equals("") 			||
					((IssuesLog) objeto).getCodigoprojeto().equals("")				||
					((IssuesLog) objeto).getVersao().trim().equals("") 				||
					((IssuesLog) objeto).getData().trim().equals("") 				||
					((IssuesLog) objeto).getAutor().trim().equals("") 				||					
					((IssuesLog) objeto).getNotarevisao().trim().equals("")			||
					((IssuesLog) objeto).getAprovacao().trim().equals("")			||
					((IssuesLog) objeto).getCodigoissueslog().equals("")			||
					((IssuesLog) objeto).getSeveridade().trim().equals("") 			||
					((IssuesLog) objeto).getDataidentificacao().equals("")			||
					((IssuesLog) objeto).getDescricao().trim().equals("") 			||
					((IssuesLog) objeto).getUrgencia().trim().equals("") 			||
					((IssuesLog) objeto).getImpacto().trim().equals("") 			||					
					((IssuesLog) objeto).getDescricaoimpacto().trim().equals("")	||
					((IssuesLog) objeto).getDescricaoacao().trim().equals("")		||
					((IssuesLog) objeto).getResponsavel().equals("")				||
					((IssuesLog) objeto).getPrevisao().equals("")					||
					((IssuesLog) objeto).getStatus().trim().equals("")				||
					((IssuesLog) objeto).getComentario().trim().equals("")
					)
				return false;
		}
		else if(objeto instanceof DecisoesComprar ){
			if(			
					((DecisoesComprar) objeto).getImportancia().equals("")			||
					((DecisoesComprar) objeto).getCodigoeap().equals("") 			||
					((DecisoesComprar) objeto).getItens().equals("")				||
					((DecisoesComprar) objeto).getUrgencia().trim().equals("") 		||
					((DecisoesComprar) objeto).getImpacto().trim().equals("") 		||
					((DecisoesComprar) objeto).getMotivodecisao().trim().equals("") ||					
					((DecisoesComprar) objeto).getFornecedores().trim().equals("")	||
					((DecisoesComprar) objeto).getQuantidade().equals("")			||
					//((DecisoesComprar) objeto).getCusto().equals("")				||
					((DecisoesComprar) objeto).getPrevisao().trim().equals("") 		||
					((DecisoesComprar) objeto).getDocaquisicao().equals("")			||
					((DecisoesComprar) objeto).getDescricao().trim().equals("") 	||
					((DecisoesComprar) objeto).getTipocontrato().trim().equals("") 	||
					((DecisoesComprar) objeto).getStatus().trim().equals("") 		||					
					((DecisoesComprar) objeto).getComentarios().trim().equals("")
					)
				return false;
		}
		else if(objeto instanceof DiagnosticoPlanoAcao ){
			if(			
					((DiagnosticoPlanoAcao) objeto).getDiagnosticoplanoacao().equals("")||
					((DiagnosticoPlanoAcao) objeto).getProjeto().equals("") 			||
					((DiagnosticoPlanoAcao) objeto).getCodigoprojeto().equals("")		||
					((DiagnosticoPlanoAcao) objeto).getVersao().trim().equals("") 		||
					((DiagnosticoPlanoAcao) objeto).getData().trim().equals("") 		||
					((DiagnosticoPlanoAcao) objeto).getAutor().trim().equals("") 		||					
					((DiagnosticoPlanoAcao) objeto).getNotarevisao().trim().equals("")	||
					((DiagnosticoPlanoAcao) objeto).getAprovacao().equals("")			||
					((DiagnosticoPlanoAcao) objeto).getObjetivo().equals("")			||
					((DiagnosticoPlanoAcao) objeto).getAbordagem().trim().equals("") 	||
					((DiagnosticoPlanoAcao) objeto).getProblemas().equals("")			||
					((DiagnosticoPlanoAcao) objeto).getPlano().trim().equals("") 		||
					((DiagnosticoPlanoAcao) objeto).getPremissa().trim().equals("") 	||
					((DiagnosticoPlanoAcao) objeto).getCriterio().trim().equals("") 	||	
					((DiagnosticoPlanoAcao) objeto).getMarcos().equals("")				||
					((DiagnosticoPlanoAcao) objeto).getOrcamento().trim().equals("") 	||
					((DiagnosticoPlanoAcao) objeto).getRisco().trim().equals("") 	
					)
				return false;
		}
		else if(objeto instanceof ListaMarcos ){
			if(			
					((ListaMarcos) objeto).getListamarcos().equals("")			||
					((ListaMarcos) objeto).getProjeto().equals("") 				||
					((ListaMarcos) objeto).getCodigoprojeto().equals("")		||
					((ListaMarcos) objeto).getVersao().trim().equals("") 		||
					((ListaMarcos) objeto).getData().trim().equals("") 			||
					((ListaMarcos) objeto).getAutor().trim().equals("") 		||					
					((ListaMarcos) objeto).getNotarevisao().trim().equals("")	||
					((ListaMarcos) objeto).getAprovacao().equals("")			||
					((ListaMarcos) objeto).getObjetivo().equals("")				||
					((ListaMarcos) objeto).getFases().trim().equals("") 	
					)
				return false;
		}
		else if(objeto instanceof OrcamentoProjeto ){
			if(			
					((OrcamentoProjeto) objeto).getOrcamento().equals("")			||
					((OrcamentoProjeto) objeto).getProjeto().equals("") 			||
					((OrcamentoProjeto) objeto).getCodigoprojeto().equals("")		||
					((OrcamentoProjeto) objeto).getVersao().trim().equals("") 		||
					((OrcamentoProjeto) objeto).getData().trim().equals("") 		||
					((OrcamentoProjeto) objeto).getAutor().trim().equals("") 		||					
					((OrcamentoProjeto) objeto).getNotarevisao().trim().equals("")	||
					((OrcamentoProjeto) objeto).getAprovacao().equals("")			||
					((OrcamentoProjeto) objeto).getObjetivo().equals("")			||
					((OrcamentoProjeto) objeto).getBase().equals("")				||
					((OrcamentoProjeto) objeto).getEstimativarecurso().equals("")	||
					((OrcamentoProjeto) objeto).getEstimativaatividade().equals("")	||
					((OrcamentoProjeto) objeto).getLinha().equals("")				||
					((OrcamentoProjeto) objeto).getRequisito().equals("")			||
					((OrcamentoProjeto) objeto).getFluxo().equals("") 	
					)
				return false;
		}
		else if(objeto instanceof RelatorioEncerramentoContrato ){
			if(			
					((RelatorioEncerramentoContrato) objeto).getRelatorio().equals("")				||
					((RelatorioEncerramentoContrato) objeto).getProjeto().equals("") 				||
					((RelatorioEncerramentoContrato) objeto).getCodigoprojeto().equals("")			||
					((RelatorioEncerramentoContrato) objeto).getObjetivo().trim().equals("") 		||
					((RelatorioEncerramentoContrato) objeto).getIdentificacao().trim().equals("") 	||
					((RelatorioEncerramentoContrato) objeto).getEntrega().trim().equals("") 		||					
					((RelatorioEncerramentoContrato) objeto).getQuestoes().trim().equals("")		||
					((RelatorioEncerramentoContrato) objeto).getInformacoes().equals("")			||
					((RelatorioEncerramentoContrato) objeto).getAceite().equals("")
					)
				return false;
		}
		else if(objeto instanceof SolicitacaoProjetovBSC ){
			if(			
					((SolicitacaoProjetovBSC) objeto).getSolicitacaoprojetovbsc().equals("")||
					((SolicitacaoProjetovBSC) objeto).getProjeto().equals("") 				||
					((SolicitacaoProjetovBSC) objeto).getCodigoprojeto().equals("")			||
					((SolicitacaoProjetovBSC) objeto).getVersao().trim().equals("") 		||
					((SolicitacaoProjetovBSC) objeto).getData().trim().equals("") 			||
					((SolicitacaoProjetovBSC) objeto).getAutor().trim().equals("") 			||					
					((SolicitacaoProjetovBSC) objeto).getNotarevisao().trim().equals("")	||
					((SolicitacaoProjetovBSC) objeto).getAprovacao().equals("")				||
					((SolicitacaoProjetovBSC) objeto).getObjetivo().equals("")				||
					((SolicitacaoProjetovBSC) objeto).getDescricao().equals("")				||
					((SolicitacaoProjetovBSC) objeto).getCriterio().equals("")				||
					((SolicitacaoProjetovBSC) objeto).getDescricaobeneficio().equals("")
					)
				return false;
		}
		return true;
	}
	
	
}


/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.helper;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import br.com.tkcsapcd.conexao.InterfacePool;
import br.com.tkcsapcd.conexao.Pool;
import br.com.tkcsapcd.model.command.*;
import br.com.tkcsapcd.model.dao.AcompanhamentoProjetoDAO;
import br.com.tkcsapcd.model.dao.AlocacaoDAO;
import br.com.tkcsapcd.model.dao.AtaReuniaoDAO;
import br.com.tkcsapcd.model.dao.AtributoAtividadeDAO;
import br.com.tkcsapcd.model.dao.AvaliacaoDesempenhoEquipeDAO;
import br.com.tkcsapcd.model.dao.BusinessCaseDAO;
import br.com.tkcsapcd.model.dao.BusinessPlanDAO;
import br.com.tkcsapcd.model.dao.BusinessPlanDetalheDAO;
import br.com.tkcsapcd.model.dao.CalendarioEventoDAO;
import br.com.tkcsapcd.model.dao.ClienteDAO;
import br.com.tkcsapcd.model.dao.CriterioPreQualificacaoDAO;
import br.com.tkcsapcd.model.dao.DecisoesComprarDAO;
import br.com.tkcsapcd.model.dao.DeclaracaoEscopoDAO;
import br.com.tkcsapcd.model.dao.DeclaracaoTrabalhoDAO;
import br.com.tkcsapcd.model.dao.DiagnosticoPlanoAcaoDAO;
import br.com.tkcsapcd.model.dao.DiagramaGanttDAO;
import br.com.tkcsapcd.model.dao.DicionarioEAPDAO;
import br.com.tkcsapcd.model.dao.EnvolvimentoPessoaProjetoInicioDAO;
import br.com.tkcsapcd.model.dao.FileAjudaDAO;
import br.com.tkcsapcd.model.dao.FileDAO;
import br.com.tkcsapcd.model.dao.FileProjetoDAO;
import br.com.tkcsapcd.model.dao.FornecedorQualificadoDAO;
import br.com.tkcsapcd.model.dao.GerenciamentoEscopoDAO;
import br.com.tkcsapcd.model.dao.IssuesLogDAO;
import br.com.tkcsapcd.model.dao.LicoesAprendidaDAO;
import br.com.tkcsapcd.model.dao.ListaAtividadeDAO;
import br.com.tkcsapcd.model.dao.ListaMarcosDAO;
import br.com.tkcsapcd.model.dao.ListaOcorrenciaDAO;
import br.com.tkcsapcd.model.dao.ListaQualidadeDAO;
import br.com.tkcsapcd.model.dao.MatrizComunicacaoDAO;
import br.com.tkcsapcd.model.dao.MatrizRastreabilidadeRequisitoDAO;
import br.com.tkcsapcd.model.dao.MatrizResponsabilidadeDAO;
import br.com.tkcsapcd.model.dao.MetricasDAO;
import br.com.tkcsapcd.model.dao.ModeloContratoDAO;
import br.com.tkcsapcd.model.dao.ModificacaoescopoDAO;
import br.com.tkcsapcd.model.dao.OrcamentoProjetoDAO;
import br.com.tkcsapcd.model.dao.OrganogramaDAO;
import br.com.tkcsapcd.model.dao.OrganogramaMapaDAO;
import br.com.tkcsapcd.model.dao.OrganogramaPropriedadeDAO;
import br.com.tkcsapcd.model.dao.PautaReuniaoDAO;
import br.com.tkcsapcd.model.dao.PlanoGerenciamentoAquisicaoDAO;
import br.com.tkcsapcd.model.dao.PlanoGerenciamentoComunicacaoDAO;
import br.com.tkcsapcd.model.dao.PlanoGerenciamentoConogramaDAO;
import br.com.tkcsapcd.model.dao.PlanoGerenciamentoCustoDAO;
import br.com.tkcsapcd.model.dao.PlanoGerenciamentoParteInteressadaDAO;
import br.com.tkcsapcd.model.dao.PlanoGerenciamentoPessoalDAO;
import br.com.tkcsapcd.model.dao.PlanoGerenciamentoProjetoDAO;
import br.com.tkcsapcd.model.dao.PlanoGerenciamentoQualidadeDAO;
import br.com.tkcsapcd.model.dao.PlanoGerenciamentoRHDAO;
import br.com.tkcsapcd.model.dao.PlanoGerenciamentoRequisitoDAO;
import br.com.tkcsapcd.model.dao.PlanoGerenciamentoRiscoDAO;
import br.com.tkcsapcd.model.dao.PlanoMelhoriaProcessoDAO;
import br.com.tkcsapcd.model.dao.PortfolioProjetoDAO;
import br.com.tkcsapcd.model.dao.ProjetoInicioDAO;
import br.com.tkcsapcd.model.dao.ProjetoTermoEncerramentoDAO;
import br.com.tkcsapcd.model.dao.RecursosHumanosDAO;
import br.com.tkcsapcd.model.dao.RegistroParteInteressadaDAO;
import br.com.tkcsapcd.model.dao.RegistroParteInteressadaFornecedorDAO;
import br.com.tkcsapcd.model.dao.RegistroRiscoAcoesDAO;
import br.com.tkcsapcd.model.dao.RegistroRiscoDAO;
import br.com.tkcsapcd.model.dao.RegistroSolicitacaoMudancaDAO;
import br.com.tkcsapcd.model.dao.RelatorioEncerramentoContratoDAO;
import br.com.tkcsapcd.model.dao.RequerimentoDAO;
import br.com.tkcsapcd.model.dao.RfiProjetoDAO;
import br.com.tkcsapcd.model.dao.RfpProjetoDAO;
import br.com.tkcsapcd.model.dao.RfqDAO;
import br.com.tkcsapcd.model.dao.RiscosDAO;
import br.com.tkcsapcd.model.dao.SolicitacaoCadastroDAO;
import br.com.tkcsapcd.model.dao.SolicitacaoMudancaDAO;
import br.com.tkcsapcd.model.dao.SolicitacaoProjetoDAO;
import br.com.tkcsapcd.model.dao.SolicitacaoProjetovBSCDAO;
import br.com.tkcsapcd.model.dao.SolicitacaoServicoTIDAO;
import br.com.tkcsapcd.model.dao.StakeholdersDAO;
import br.com.tkcsapcd.model.dao.StatusReportDAO;
import br.com.tkcsapcd.model.dao.StatussDAO;
import br.com.tkcsapcd.model.dao.TabelaParteInteressadaDAO;
import br.com.tkcsapcd.model.dao.TermoAberturaProjetoDAO;
import br.com.tkcsapcd.model.dao.TermoAceiteEntregaDAO;
import br.com.tkcsapcd.model.dao.TransicaoProdutoDAO;
import br.com.tkcsapcd.model.dao.UsuarioDAO;

/*
 * Controles das regras. Também controlar as requisições do HTTP.
 	Todos os metodos devem ser cadastrar o comando no TkcsapcdHelper!!!!!
 */
public class TkcsapcdHelper 
{
	private HashMap<String, InterfaceCommand> mapaComandos;//Mapa de comandos	
	private HttpServletRequest resquest;//Atributo
	
	public void setResquest(HttpServletRequest resquest) {
		this.resquest = resquest;
	}

	private InterfacePool pool;	
	//Contrutor
	public TkcsapcdHelper() 
	{
		this.pool = new Pool();
						
		//Mesma ação colocada no cadastro_cliente.jsp (cadastrarCliente)
		mapaComandos = new HashMap<String, InterfaceCommand>();

		mapaComandos.put("cadastrarCliente", new CadastrarCliente(new ClienteDAO(pool))); //clienteDAO() pede uma variável pool
		mapaComandos.put("consultarCliente", new ConsultarCliente(new ClienteDAO(pool)));
		mapaComandos.put("atualizarCliente", new AtualizarCliente(new ClienteDAO(pool)));
		mapaComandos.put("editarCliente", new EditarCliente(new ClienteDAO(pool)));
		mapaComandos.put("excluirCliente", new ExcluirCliente(new ClienteDAO(pool)));
		
		mapaComandos.put("cadastrarTermoAberturaProjeto", new CadastrarTermoAberturaProjeto(new TermoAberturaProjetoDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("consultarTermoAberturaProjeto", new ConsultarTermoAberturaProjeto(new TermoAberturaProjetoDAO(pool)));		
		mapaComandos.put("atualizarTermoAberturaProjeto", new AtualizarTermoAberturaProjeto(new TermoAberturaProjetoDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("editarTermoAberturaProjeto", new EditarTermoAberturaProjeto(new TermoAberturaProjetoDAO(pool), new ProjetoInicioDAO(pool)));				
		mapaComandos.put("excluirTermoAberturaProjeto", new ExcluirTermoAberturaProjeto(new TermoAberturaProjetoDAO(pool)));
		mapaComandos.put("relatorioTermoAberturaProjeto", new RelatorioTermoAberturaProjeto(new TermoAberturaProjetoDAO(pool)));
		
		mapaComandos.put("cadastrarProjetoTermoEncerramento", new CadastrarProjetoTermoEncerramento(new ProjetoTermoEncerramentoDAO(pool)));
		mapaComandos.put("consultarProjetoTermoEncerramento", new ConsultarProjetoTermoEncerramento(new ProjetoTermoEncerramentoDAO(pool)));				
		mapaComandos.put("atualizarProjetoTermoEncerramento", new AtualizarProjetoTermoEncerramento(new ProjetoTermoEncerramentoDAO(pool)));
		mapaComandos.put("editarProjetoTermoEncerramento", new EditarProjetoTermoEncerramento(new ProjetoTermoEncerramentoDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("excluirProjetoTermoEncerramento", new ExcluirProjetoTermoEncerramento(new ProjetoTermoEncerramentoDAO(pool)));
				
		mapaComandos.put("cadastrarStatuss", new CadastraStatuss(new StatussDAO(pool)));
		mapaComandos.put("consultarStatuss", new ConsultaStatuss(new StatussDAO(pool)));
		mapaComandos.put("atualizarStatuss", new AtualizarStatuss(new StatussDAO(pool)));
		mapaComandos.put("editarStatuss", new EditarStatuss(new StatussDAO(pool), new ProjetoInicioDAO(pool) ));
		mapaComandos.put("excluirStatuss", new ExcluirStatuss(new StatussDAO(pool)));

		mapaComandos.put("cadastrarRequerimento", new CadastraRequerimento(new RequerimentoDAO(pool)));
		mapaComandos.put("consultarRequerimento", new ConsultarRequerimento(new RequerimentoDAO(pool)));
		mapaComandos.put("editarRequerimento", new EditarRequerimento(new RequerimentoDAO(pool)));
		mapaComandos.put("atualizarRequerimento", new AtualizarRequerimento(new RequerimentoDAO(pool)));
		mapaComandos.put("excluirRequerimento", new ExcluirRequerimento(new RequerimentoDAO(pool)));
		
		mapaComandos.put("cadastrarRfpProjeto", new CadastrarRfpProjeto(new RfpProjetoDAO(pool)));
		mapaComandos.put("consultarRfpProjeto", new ConsultarRfpProjeto(new RfpProjetoDAO(pool)));
		mapaComandos.put("editarRfpProjeto", new EditarRfpProjeto(new RfpProjetoDAO(pool)));
		mapaComandos.put("atualizarFfpProjeto", new AtualizarRfpProjeto(new RfpProjetoDAO(pool)));
		mapaComandos.put("excluirRfpProjeto", new ExcluirRfpProjeto(new RfpProjetoDAO(pool)));
		
		mapaComandos.put("cadastrarRfiProjeto", new CadastrarRfiProjeto(new RfiProjetoDAO(pool)));
		mapaComandos.put("consultarRfiProjeto", new ConsultarRfiProjeto(new RfiProjetoDAO(pool)));
		mapaComandos.put("editarRfiProjeto", new EditarRfiProjeto(new RfiProjetoDAO(pool)));
		mapaComandos.put("atualizarFfiProjeto", new AtualizarRfiProjeto(new RfiProjetoDAO(pool)));
		mapaComandos.put("excluirRfiProjeto", new ExcluirRfiProjeto(new RfiProjetoDAO(pool)));
		
		mapaComandos.put("cadastrarPautaReuniao", new CadastrarPautaReuniao(new PautaReuniaoDAO(pool)));
		mapaComandos.put("consultarPautaReuniao", new ConsultarPautaReuniao(new PautaReuniaoDAO(pool)));
		mapaComandos.put("editarPautaReuniao", new EditarPautaReuniao(new PautaReuniaoDAO(pool)));
		mapaComandos.put("atualizarPautaReuniao", new AtualizarPautaReuniao(new PautaReuniaoDAO(pool)));
		mapaComandos.put("excluirPautaReuniao", new ExcluirPautaReuniao(new PautaReuniaoDAO(pool)));
		
		mapaComandos.put("cadastrarAcompanhamentoProjeto", new CadastrarAcompanhamentoProjeto(new AcompanhamentoProjetoDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("consultarAcompanhamentoProjeto", new ConsultarAcompanhamentoProjeto(new AcompanhamentoProjetoDAO(pool)));
		mapaComandos.put("editarAcompanhamentoProjeto", new EditarAcompanhamentoProjeto(new AcompanhamentoProjetoDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("atualizarAcompanhamentoProjeto", new AtualizarAcompanhamentoProjeto(new AcompanhamentoProjetoDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("excluirAcompanhamentoProjeto", new ExcluirAcompanhamentoProjeto(new AcompanhamentoProjetoDAO(pool)));
		
		mapaComandos.put("cadastrarMetricas", new CadastrarMetricas(new MetricasDAO(pool)));
		mapaComandos.put("consultarMetricas", new ConsultarMetrica(new MetricasDAO(pool)));
		mapaComandos.put("editarMetricas", new EditarMetricas(new MetricasDAO(pool)));
		mapaComandos.put("atualizarMetricas", new AtualizarMetricas(new MetricasDAO(pool)));
		mapaComandos.put("excluirMetricas", new ExcluirMetricas(new MetricasDAO(pool)));
		
		mapaComandos.put("cadastrarRecursosHumanos", new CadastrarRecursosHumanos(new RecursosHumanosDAO(pool)));
		mapaComandos.put("consultarRecursosHumanos", new ConsultarRecursosHumanos(new RecursosHumanosDAO(pool)));
		mapaComandos.put("editarRecursosHumanos", new EditarRecursosHumanos(new RecursosHumanosDAO(pool)));
		mapaComandos.put("atualizarRecursosHumanos", new AtualizarRecursosHumanos(new RecursosHumanosDAO(pool)));
		mapaComandos.put("excluirRecursosHumanos", new ExcluirRecursosHumanos(new RecursosHumanosDAO(pool)));
				
		mapaComandos.put("cadastrarAlocacao", new CadastrarAlocacao(new AlocacaoDAO(pool)));
		mapaComandos.put("consultarAlocacao", new ConsultarAlocacao(new AlocacaoDAO(pool)));		
		mapaComandos.put("editarAlocacao", new EditarAlocacao(new AlocacaoDAO(pool), new ProjetoInicioDAO(pool), new RecursosHumanosDAO(pool)));
		mapaComandos.put("atualizarAlocacao", new AtualizarAlocacao(new AlocacaoDAO(pool)));
		mapaComandos.put("excluirAlocacao", new ExcluirAlocacao(new AlocacaoDAO(pool)));
		
		mapaComandos.put("cadastrarSolicitacaoCadastro", new CadastrarSolicitacaoCadastro(new SolicitacaoCadastroDAO(pool)));
		
		mapaComandos.put("cadastrarSolicitacaoServicoTI", new CadastrarSolicitacaoServicoTI(new SolicitacaoServicoTIDAO(pool)));
		mapaComandos.put("consultarSolicitacaoServicoTI", new ConsultarSolicitacaoServicoTI(new SolicitacaoServicoTIDAO(pool)));
		mapaComandos.put("editarSolicitacaoServicoTI", new EditarSolicitacaoServicoTI(new SolicitacaoServicoTIDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("atualizarSolicitacaoServicoTI", new AtualizarSolicitacaoServicoTI(new SolicitacaoServicoTIDAO(pool)));
		mapaComandos.put("consultarSolicitacaoServicoTI", new ConsultarSolicitacaoServicoTI(new SolicitacaoServicoTIDAO(pool)));
		mapaComandos.put("excluirSolicitacaoServicoTI", new ExcluirSolicitacaoServicoTI(new SolicitacaoServicoTIDAO(pool)));
		
		mapaComandos.put("cadastrarStakeholders", new CadastrarStakeholders(new StakeholdersDAO(pool)));
		mapaComandos.put("consultarStakeholders", new ConsultarStakeholders(new StakeholdersDAO(pool)));
		mapaComandos.put("editarStakeholders", new EditarStakeholders(new StakeholdersDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("atualizarStakeholders", new AtualizarStakeholders(new StakeholdersDAO(pool)));
		mapaComandos.put("excluirStakeholders", new ExcluirStakeholders(new StakeholdersDAO(pool)));
		
		mapaComandos.put("cadastrarRiscos", new CadastrarRiscos(new RiscosDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("consultarRiscos", new ConsultarRiscos(new RiscosDAO(pool)));
		mapaComandos.put("editarRiscos", new EditarRiscos(new RiscosDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("atualizarRiscos", new AtualizarRiscos(new RiscosDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("excluirRiscos", new ExcluirRiscos(new RiscosDAO(pool)));
		
		mapaComandos.put("cadastrarDeclaracaoescopo", new CadastrarDeclaracaoEscopo(new DeclaracaoEscopoDAO(pool)));
		mapaComandos.put("consultarDeclaracaoescopo", new ConsultarDeclaracaoEscopo(new DeclaracaoEscopoDAO(pool)));
		mapaComandos.put("editarDeclaracaoescopo", new EditarDeclaracaoEscopo(new DeclaracaoEscopoDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("atualizarDeclaracaoescopo", new AtualizarDeclaracaoEscopo(new DeclaracaoEscopoDAO(pool)));
		mapaComandos.put("excluirDeclaracaoescopo", new ExcluirDeclaracaoEscopo(new DeclaracaoEscopoDAO(pool)));
		
		mapaComandos.put("cadastrarGerenciamentoEscopo", new CadastrarGerenciamentoEscopo(new GerenciamentoEscopoDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("consultarGerenciamentoEscopo", new ConsultarGerenciamentoEscopo(new GerenciamentoEscopoDAO(pool)));
		mapaComandos.put("editarGerenciamentoEscopo", new EditarGerenciamentoEscopo(new GerenciamentoEscopoDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("atualizarGerenciamentoEscopo", new AtualizarGerenciamentoEscopo(new GerenciamentoEscopoDAO(pool), new ProjetoInicioDAO(pool)));		
		mapaComandos.put("excluirGerenciamentoEscopo", new ExcluirGerenciamentoEscopo(new GerenciamentoEscopoDAO(pool)));
		
		mapaComandos.put("cadastrarModificacaoEscopo", new CadastrarModificacaoEscopo(new ModificacaoescopoDAO(pool)));
		mapaComandos.put("consultarModificacaoEscopo", new ConsultarModificacaoEscopo(new ModificacaoescopoDAO(pool)));
		mapaComandos.put("editarModificacaoEscopo", new EditarModificacaoEscopo(new ModificacaoescopoDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("atualizarModificacaoEscopo", new AtualizarModificacaoEscopo(new ModificacaoescopoDAO(pool)));
		mapaComandos.put("excluirModificacaoEscopo", new ExcluirModificacaoEscopo(new ModificacaoescopoDAO(pool)));
		
		mapaComandos.put("cadastrarLicoesAprendida", new CadastrarLicoesAprendida(new LicoesAprendidaDAO(pool)));
		mapaComandos.put("consultarLicoesAprendida", new ConsultarLicoesAprendida(new LicoesAprendidaDAO(pool)));
		mapaComandos.put("editarLicoesAprendida", new EditarLicoesAprendida(new LicoesAprendidaDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("atualizarLicoesAprendida", new AtualizarLicoesAprendida(new LicoesAprendidaDAO(pool)));
		mapaComandos.put("excluirLicoesAprendida", new ExcluirLicoesAprendida(new LicoesAprendidaDAO(pool)));
		
		mapaComandos.put("cadastrarPlanoGerenciamentoQualidade", new CadastrarPlanoGerenciamentoQualidade(new PlanoGerenciamentoQualidadeDAO(pool)));
		mapaComandos.put("consultarPlanoGerenciamentoQualidade", new ConsultarPlanoGerenciamentoQualidade(new PlanoGerenciamentoQualidadeDAO(pool)));
		mapaComandos.put("editarPlanoGerenciamentoQualidade", new EditarPlanoGerenciamentoQualidade(new PlanoGerenciamentoQualidadeDAO(pool)));
		mapaComandos.put("atualizarPlanoGerenciamentoQualidade", new AtualizarPlanoGerenciamentoQualidade(new PlanoGerenciamentoQualidadeDAO(pool)));
		mapaComandos.put("excluirPlanoGerenciamentoQualidade", new ExcluirPlanoGerenciamentoQualidade(new PlanoGerenciamentoQualidadeDAO(pool)));
		
		mapaComandos.put("cadastrarPlanoGerenciamentoAquisicao", new CadastrarPlanoGerenciamentoAquisicao(new PlanoGerenciamentoAquisicaoDAO(pool)));
		mapaComandos.put("consultarPlanoGerenciamentoAquisicao", new ConsultarPlanoGerenciamentoAquisicao(new PlanoGerenciamentoAquisicaoDAO(pool)));
		mapaComandos.put("editarPlanoGerenciamentoAquisicao", new EditarPlanoGerenciamentoAquisicao(new PlanoGerenciamentoAquisicaoDAO(pool)));
		mapaComandos.put("atualizarPlanoGerenciamentoAquisicao", new AtualizarPlanoGerenciamentoAquisicao(new PlanoGerenciamentoAquisicaoDAO(pool)));
		mapaComandos.put("excluirPlanoGerenciamentoAquisicao", new ExcluirPlanoGerenciamentoAquisicao(new PlanoGerenciamentoAquisicaoDAO(pool)));
		
		mapaComandos.put("cadastrarAtaReuniao", new CadastrarAtaReuniao(new AtaReuniaoDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("consultarAtaReuniao", new ConsultarAtaReuniao(new AtaReuniaoDAO(pool)));
		mapaComandos.put("editarAtaReuniao", new EditarAtaReuniao(new AtaReuniaoDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("atualizarAtaReuniao", new AtualizarAtaReuniao(new AtaReuniaoDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("excluirAtaReuniao", new ExcluirAtaReuniao(new AtaReuniaoDAO(pool)));
		
		mapaComandos.put("cadastrarPlanoGerenciamentoProjeto", new CadastrarPlanoGerenciamentoProjeto(new PlanoGerenciamentoProjetoDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("consultarPlanoGerenciamentoProjeto", new ConsultarPlanoGerenciamentoProjeto(new PlanoGerenciamentoProjetoDAO(pool)));
		mapaComandos.put("editarPlanoGerenciamentoProjeto", new EditarPlanoGerenciamentoProjeto(new PlanoGerenciamentoProjetoDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("atualizarPlanoGerenciamentoProjeto", new AtualizarPlanoGerenciamentoProjeto(new PlanoGerenciamentoProjetoDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("excluirPlanoGerenciamentoProjeto", new ExcluirPlanoGerenciamentoProjeto(new PlanoGerenciamentoProjetoDAO(pool)));
		
		mapaComandos.put("cadastrarSolicitacaoMudanca", new CadastrarSolicitacaoMudanca(new SolicitacaoMudancaDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("consultarSolicitacaoMudanca", new ConsultarSolicitacaoMudanca(new SolicitacaoMudancaDAO(pool)));
		mapaComandos.put("editarSolicitacaoMudanca", new EditarSolicitacaoMudanca(new SolicitacaoMudancaDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("atualizarSolicitacaoMudanca", new AtualizarSolicitacaoMudanca(new SolicitacaoMudancaDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("excluirSolicitacaoMudanca", new ExcluirSolicitacaoMudanca(new SolicitacaoMudancaDAO(pool)));
		
		mapaComandos.put("cadastrarRegistroSolicitacaoMudanca", new CadastrarRegistroSolicitacaoMudanca(new RegistroSolicitacaoMudancaDAO(pool), new ProjetoInicioDAO(pool), new SolicitacaoMudancaDAO(pool)));
		mapaComandos.put("consultarRegistroSolicitacaoMudanca", new ConsultarRegistroSolicitacaoMudanca(new RegistroSolicitacaoMudancaDAO(pool)));
		mapaComandos.put("editarRegistroSolicitacaoMudanca", new EditarRegistroSolicitacaoMudanca(new RegistroSolicitacaoMudancaDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("atualizarRegistroSolicitacaoMudanca", new AtualizarRegistroSolicitacaoMudanca(new RegistroSolicitacaoMudancaDAO(pool), new ProjetoInicioDAO(pool), new SolicitacaoMudancaDAO(pool)));
		mapaComandos.put("excluirRegistroSolicitacaoMudanca", new ExcluirRegistroSolicitacaoMudanca(new RegistroSolicitacaoMudancaDAO(pool)));
		
		mapaComandos.put("cadastrarDicionarioEAP", new CadastrarDicionarioEAP(new DicionarioEAPDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("consultarDicionarioEAP", new ConsultarDicionarioEAP(new DicionarioEAPDAO(pool)));
		mapaComandos.put("editarDicionarioEAP", new EditarDicionarioEAP(new DicionarioEAPDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("atualizarDicionarioEAP", new AtualizarDicionarioEAP(new DicionarioEAPDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("excluirDicionarioEAP", new ExcluirDicionarioEAP(new DicionarioEAPDAO(pool)));
		
		mapaComandos.put("cadastrarTermoAceiteEntrega", new CadastrarTermoAceiteEntrega(new TermoAceiteEntregaDAO(pool)));
		mapaComandos.put("consultarTermoAceiteEntrega", new ConsultarTermoAceiteEntrega(new TermoAceiteEntregaDAO(pool)));
		mapaComandos.put("editarTermoAceiteEntrega", new EditarTermoAceiteEntrega(new TermoAceiteEntregaDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("atualizarTermoAceiteEntrega", new AtualizarTermoAceiteEntrega(new TermoAceiteEntregaDAO(pool)));
		mapaComandos.put("excluirTermoAceiteEntrega", new ExcluirTermoAceiteEntrega(new TermoAceiteEntregaDAO(pool)));
		
		mapaComandos.put("cadastrarPlanoMelhoriaProcesso", new CadastrarPlanoMelhoriaProcesso(new PlanoMelhoriaProcessoDAO(pool)));
		mapaComandos.put("consultarPlanoMelhoriaProcesso", new ConsultarPlanoMelhoriaProcesso(new PlanoMelhoriaProcessoDAO(pool)));
		mapaComandos.put("editarPlanoMelhoriaProcesso", new EditarPlanoMelhoriaProcesso(new PlanoMelhoriaProcessoDAO(pool)));
		mapaComandos.put("atualizarPlanoMelhoriaProcesso", new AtualizarPlanoMelhoriaProcesso(new PlanoMelhoriaProcessoDAO(pool)));
		mapaComandos.put("excluirPlanoMelhoriaProcesso", new ExcluirPlanoMelhoriaProcesso(new PlanoMelhoriaProcessoDAO(pool)));
		
		mapaComandos.put("cadastrarPlanoGerenciamentoRisco", new CadastrarPlanoGerenciamentoRisco(new PlanoGerenciamentoRiscoDAO(pool)));
		mapaComandos.put("consultarPlanoGerenciamentoRisco", new ConsultarPlanoGerenciamentoRisco(new PlanoGerenciamentoRiscoDAO(pool)));
		mapaComandos.put("editarPlanoGerenciamentoRisco", new EditarPlanoGerenciamentoRisco(new PlanoGerenciamentoRiscoDAO(pool)));
		mapaComandos.put("atualizarPlanoGerenciamentoRisco", new AtualizarPlanoGerenciamentoRisco(new PlanoGerenciamentoRiscoDAO(pool)));
		mapaComandos.put("excluirPlanoGerenciamentoRisco", new ExcluirPlanoGerenciamentoRisco(new PlanoGerenciamentoRiscoDAO(pool)));
		
		mapaComandos.put("cadastrarPlanoGerenciamentoCusto", new CadastrarPlanoGerenciamentoCusto(new PlanoGerenciamentoCustoDAO(pool)));
		mapaComandos.put("consultarPlanoGerenciamentoCusto", new ConsultarPlanoGerenciamentoCusto(new PlanoGerenciamentoCustoDAO(pool)));
		mapaComandos.put("editarPlanoGerenciamentoCusto", new EditarPlanoGerenciamentoCusto(new PlanoGerenciamentoCustoDAO(pool)));
		mapaComandos.put("atualizarPlanoGerenciamentoCusto", new AtualizarPlanoGerenciamentoCusto(new PlanoGerenciamentoCustoDAO(pool)));
		mapaComandos.put("excluirPlanoGerenciamentoCusto", new ExcluirPlanoGerenciamentoCusto(new PlanoGerenciamentoCustoDAO(pool)));
		
		mapaComandos.put("cadastrarPlanoGerenciamentoRH", new CadastrarPlanoGerenciamentoRH(new PlanoGerenciamentoRHDAO(pool)));
		mapaComandos.put("consultarPlanoGerenciamentoRH", new ConsultarPlanoGerenciamentoRH(new PlanoGerenciamentoRHDAO(pool)));
		mapaComandos.put("editarPlanoGerenciamentoRH", new EditarPlanoGerenciamentoRH(new PlanoGerenciamentoRHDAO(pool)));
		mapaComandos.put("atualizarPlanoGerenciamentoRH", new AtualizarPlanoGerenciamentoRH(new PlanoGerenciamentoRHDAO(pool)));
		mapaComandos.put("excluirPlanoGerenciamentoRH", new ExcluirPlanoGerenciamentoRH(new PlanoGerenciamentoRHDAO(pool)));
		
		mapaComandos.put("cadastrarBusinessCase", new CadastrarBusinessCase(new BusinessCaseDAO(pool),new ProjetoInicioDAO(pool)));
		mapaComandos.put("consultarBusinessCase", new ConsultarBusinessCase(new BusinessCaseDAO(pool)));
		mapaComandos.put("editarBusinessCase", new EditarBusinessCase(new BusinessCaseDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("atualizarBusinessCase", new AtualizarBusinessCase(new BusinessCaseDAO(pool),new ProjetoInicioDAO(pool)));
		mapaComandos.put("excluirBusinessCase", new ExcluirBusinessCase(new BusinessCaseDAO(pool)));
		
		mapaComandos.put("cadastrarSolicitacaoProjeto", new CadastrarSolicitacaoProjeto(new SolicitacaoProjetoDAO(pool)));
		mapaComandos.put("consultarSolicitacaoProjeto", new ConsultarSolicitacaoProjeto(new SolicitacaoProjetoDAO(pool)));
		mapaComandos.put("editarSolicitacaoProjeto", new EditarSolicitacaoProjeto(new SolicitacaoProjetoDAO(pool)));
		mapaComandos.put("atualizarSolicitacaoProjeto", new AtualizarSolicitacaoProjeto(new SolicitacaoProjetoDAO(pool)));
		mapaComandos.put("excluirSolicitacaoProjeto", new ExcluirSolicitacaoProjeto(new SolicitacaoProjetoDAO(pool)));
		
		mapaComandos.put("cadastrarRegistroParteInteressada", new CadastrarRegistroParteInteressada(new RegistroParteInteressadaDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("consultarRegistroParteInteressada", new ConsultarRegistroParteInteressada(new RegistroParteInteressadaDAO(pool)));
		mapaComandos.put("editarRegistroParteInteressada", new EditarRegistroParteInteressada(new RegistroParteInteressadaDAO(pool)));
		mapaComandos.put("atualizarRegistroParteInteressada", new AtualizarRegistroParteInteressada(new RegistroParteInteressadaDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("excluirRegistroParteInteressada", new ExcluirRegistroParteInteressada(new RegistroParteInteressadaDAO(pool)));
		
		mapaComandos.put("cadastrarBusinessPlan", new CadastrarBusinessPlan(new BusinessPlanDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("consultarBusinessPlan", new ConsultarBusinessPlan(new BusinessPlanDAO(pool)));
		mapaComandos.put("editarBusinessPlan", new EditarBusinessPlan(new BusinessPlanDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("atualizarBusinessPlan", new AtualizarBusinessPlan(new BusinessPlanDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("excluirBusinessPlan", new ExcluirBusinessPlan(new BusinessPlanDAO(pool)));
		
		mapaComandos.put("cadastrarBusinessPlanDetalhe", new CadastrarBusinessPlanDetalhe(new BusinessPlanDetalheDAO(pool)));
		mapaComandos.put("consultarBusinessPlanDetalhe", new ConsultarBusinessPlanDetalhe(new BusinessPlanDetalheDAO(pool)));
		mapaComandos.put("editarBusinessPlanDetalhe", new EditarBusinessPlanDetalhe(new BusinessPlanDetalheDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("atualizarBusinessPlanDetalhe", new AtualizarBusinessPlanDetalhe(new BusinessPlanDetalheDAO(pool)));
		mapaComandos.put("excluirBusinessPlanDetalhe", new ExcluirBusinessPlanDetalhe(new BusinessPlanDetalheDAO(pool)));
		
		mapaComandos.put("cadastrarRegistroParteInteressadaFornecedor", new CadastrarRegistroParteInteressadaFornecedor(new RegistroParteInteressadaFornecedorDAO(pool)));
		mapaComandos.put("consultarRegistroParteInteressadaFornecedor", new ConsultarRegistroParteInteressadaFornecedor(new RegistroParteInteressadaFornecedorDAO(pool)));
		mapaComandos.put("editarRegistroParteInteressadaFornecedor", new EditarRegistroParteInteressadaFornecedor(new RegistroParteInteressadaFornecedorDAO(pool)));
		mapaComandos.put("atualizarRegistroParteInteressadaFornecedor", new AtualizarRegistroParteInteressadaFornecedor(new RegistroParteInteressadaFornecedorDAO(pool)));
		mapaComandos.put("excluirRegistroParteInteressadaFornecedor", new ExcluirRegistroParteInteressadaFornecedor(new RegistroParteInteressadaFornecedorDAO(pool)));
		
		mapaComandos.put("cadastrarPlanoGerenciamentoComunicacao", new CadastrarPlanoGerenciamentoComunicacao(new PlanoGerenciamentoComunicacaoDAO(pool)));
		mapaComandos.put("consultarPlanoGerenciamentoComunicacao", new ConsultarPlanoGerenciamentoComunicacao(new PlanoGerenciamentoComunicacaoDAO(pool)));
		mapaComandos.put("editarPlanoGerenciamentoComunicacao", new EditarPlanoGerenciamentoComunicacao(new PlanoGerenciamentoComunicacaoDAO(pool)));
		mapaComandos.put("atualizarPlanoGerenciamentoComunicacao", new AtualizarPlanoGerenciamentoComunicacao(new PlanoGerenciamentoComunicacaoDAO(pool)));
		mapaComandos.put("excluirPlanoGerenciamentoComunicacao", new ExcluirPlanoGerenciamentoComunicacao(new PlanoGerenciamentoComunicacaoDAO(pool)));
		
		mapaComandos.put("cadastrarPlanoGerenciamentoParteInteressada", new CadastrarPlanoGerenciamentoParteInteressada(new PlanoGerenciamentoParteInteressadaDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("consultarPlanoGerenciamentoParteInteressada", new ConsultarPlanoGerenciamentoParteInteressada(new PlanoGerenciamentoParteInteressadaDAO(pool)));
		mapaComandos.put("editarPlanoGerenciamentoParteInteressada", new EditarPlanoGerenciamentoParteInteressada(new PlanoGerenciamentoParteInteressadaDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("atualizarPlanoGerenciamentoParteInteressada", new AtualizarPlanoGerenciamentoParteInteressada(new PlanoGerenciamentoParteInteressadaDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("excluirPlanoGerenciamentoParteInteressada", new ExcluirPlanoGerenciamentoParteInteressada(new PlanoGerenciamentoParteInteressadaDAO(pool)));
		
		mapaComandos.put("cadastrarPlanoGerenciamentoCronograma", new CadastrarPlanoGerenciamentoCronograma(new PlanoGerenciamentoConogramaDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("consultarPlanoGerenciamentoCronograma", new ConsultarPlanoGerenciamentoCronograma(new PlanoGerenciamentoConogramaDAO(pool)));
		mapaComandos.put("editarPlanoGerenciamentoCronograma", new EditarPlanoGerenciamentoCronograma(new PlanoGerenciamentoConogramaDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("atualizarPlanoGerenciamentoCronograma", new AtualizarPlanoGerenciamentoCronograma(new PlanoGerenciamentoConogramaDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("excluirPlanoGerenciamentoCronograma", new ExcluirPlanoGerenciamentoCronograma(new PlanoGerenciamentoConogramaDAO(pool)));
		
		mapaComandos.put("cadastrarPlanoGerenciamentoRequisito", new CadastrarPlanoGerenciamentoRequisito(new PlanoGerenciamentoRequisitoDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("consultarPlanoGerenciamentoRequisito", new ConsultarPlanoGerenciamentoRequisito(new PlanoGerenciamentoRequisitoDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("editarPlanoGerenciamentoRequisito", new EditarPlanoGerenciamentoRequisito(new PlanoGerenciamentoRequisitoDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("atualizarPlanoGerenciamentoRequisito", new AtualizarPlanoGerenciamentoRequisito(new PlanoGerenciamentoRequisitoDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("excluirPlanoGerenciamentoRequisito", new ExcluirPlanoGerenciamentoRequisito(new PlanoGerenciamentoRequisitoDAO(pool)));
		
		mapaComandos.put("cadastrarDeclaracaoTrabalho", new CadastrarDeclaracaoTrabalho(new DeclaracaoTrabalhoDAO(pool)));
		mapaComandos.put("consultarDeclaracaoTrabalho", new ConsultarDeclaracaoTrabalho(new DeclaracaoTrabalhoDAO(pool)));
		mapaComandos.put("editarDeclaracaoTrabalho", new EditarDeclaracaoTrabalho(new DeclaracaoTrabalhoDAO(pool)));
		mapaComandos.put("atualizarDeclaracaoTrabalho", new AtualizarDeclaracaoTrabalho(new DeclaracaoTrabalhoDAO(pool)));
		mapaComandos.put("excluirDeclaracaoTrabalho", new ExcluirDeclaracaoTrabalho(new DeclaracaoTrabalhoDAO(pool)));
		
		mapaComandos.put("cadastrarMatrizComunicacao", new CadastrarMatrizComunicacao(new MatrizComunicacaoDAO(pool)));
		mapaComandos.put("consultarMatrizComunicacao", new ConsultarMatrizComunicacao(new MatrizComunicacaoDAO(pool)));
		mapaComandos.put("editarMatrizComunicacao", new EditarMatrizComunicacao(new MatrizComunicacaoDAO(pool)));
		mapaComandos.put("atualizarMatrizComunicacao", new AtualizarMatrizComunicacao(new MatrizComunicacaoDAO(pool)));
		mapaComandos.put("excluirMatrizComunicacao", new ExcluirMatrizComunicacao(new MatrizComunicacaoDAO(pool)));
		
		mapaComandos.put("cadastrarStatusReport", new CadastrarStatusReport(new StatusReportDAO(pool)));
		mapaComandos.put("consultarStatusReport", new ConsultarStatusReport(new StatusReportDAO(pool)));
		mapaComandos.put("editarStatusReport", new EditarStatusReport(new StatusReportDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("atualizarStatusReport", new AtualizarStatusReport(new StatusReportDAO(pool)));
		mapaComandos.put("excluirStatusReport", new ExcluirStatusReport(new StatusReportDAO(pool)));
		
		mapaComandos.put("cadastrarCriterioPreQualificacao", new CadastrarCriterioPreQualificacao(new CriterioPreQualificacaoDAO(pool)));
		mapaComandos.put("consultarCriterioPreQualificacao", new ConsultarCriterioPreQualificacao(new CriterioPreQualificacaoDAO(pool)));
		mapaComandos.put("editarCriterioPreQualificacao", new EditarCriterioPreQualificacao(new CriterioPreQualificacaoDAO(pool)));
		mapaComandos.put("atualizarCriterioPreQualificacao", new AtualizarCriterioPreQualificacao(new CriterioPreQualificacaoDAO(pool)));
		mapaComandos.put("excluirCriterioPreQualificacao", new ExcluirCriterioPreQualificacao(new CriterioPreQualificacaoDAO(pool)));
		
		mapaComandos.put("cadastrarTransicaoProduto", new CadastrarTransicaoProduto(new TransicaoProdutoDAO(pool)));
		mapaComandos.put("consultarTransicaoProduto", new ConsultarTransicaoProduto(new TransicaoProdutoDAO(pool)));
		mapaComandos.put("editarTransicaoProduto", new EditarTransicaoProduto(new TransicaoProdutoDAO(pool)));
		mapaComandos.put("atualizarTransicaoProduto", new AtualizarTransicaoProduto(new TransicaoProdutoDAO(pool)));
		mapaComandos.put("excluirTransicaoProduto", new ExcluirTransicaoProduto(new TransicaoProdutoDAO(pool)));
		
		mapaComandos.put("cadastrarListaQualidade", new CadastrarListaQualidade(new ListaQualidadeDAO(pool)));
		mapaComandos.put("consultarListaQualidade", new ConsultarListaQualidade(new ListaQualidadeDAO(pool)));
		mapaComandos.put("editarListaQualidade", new EditarListaQualidade(new ListaQualidadeDAO(pool)));
		mapaComandos.put("atualizarListaQualidade", new AtualizarListaQualidade(new ListaQualidadeDAO(pool)));
		mapaComandos.put("excluirListaQualidade", new ExcluirListaQualidade(new ListaQualidadeDAO(pool)));
		
		mapaComandos.put("cadastrarPlanoGerenciamentoPessoal", new CadastrarPlanoGerenciamentoPessoal(new PlanoGerenciamentoPessoalDAO(pool)));
		mapaComandos.put("consultarPlanoGerenciamentoPessoal", new ConsultarPlanoGerenciamentoPessoal(new PlanoGerenciamentoPessoalDAO(pool)));
		mapaComandos.put("editarPlanoGerenciamentoPessoal", new EditarPlanoGerenciamentoPessoal(new PlanoGerenciamentoPessoalDAO(pool)));
		mapaComandos.put("atualizarPlanoGerenciamentoPessoal", new AtualizarPlanoGerenciamentoPessoal(new PlanoGerenciamentoPessoalDAO(pool)));
		mapaComandos.put("excluirPlanoGerenciamentoPessoal", new ExcluirPlanoGerenciamentoPessoal(new PlanoGerenciamentoPessoalDAO(pool)));
		
		mapaComandos.put("cadastrarRegistroRisco", new CadastrarRegistroRisco(new RegistroRiscoDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("consultarRegistroRisco", new ConsultarRegistroRisco(new RegistroRiscoDAO(pool)));
		mapaComandos.put("editarRegistroRisco", new EditarRegistroRisco(new RegistroRiscoDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("atualizarRegistroRisco", new AtualizarRegistroRisco(new RegistroRiscoDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("excluirRegistroRisco", new ExcluirRegistroRisco(new RegistroRiscoDAO(pool)));
		
		mapaComandos.put("cadastrarRegistroRiscoAcoes", new CadastrarRegistroRiscoAcoes(new RegistroRiscoAcoesDAO(pool), new RegistroRiscoDAO(pool)));
		mapaComandos.put("consultarRegistroRiscoAcoes", new ConsultarRegistroRiscoAcoes(new RegistroRiscoAcoesDAO(pool)));
		mapaComandos.put("editarRegistroRiscoAcoes", new EditarRegistroRiscoAcoes(new RegistroRiscoAcoesDAO(pool), new RegistroRiscoDAO(pool)));
		mapaComandos.put("atualizarRegistroRiscoAcoes", new AtualizarRegistroRiscoAcoes(new RegistroRiscoAcoesDAO(pool), new RegistroRiscoDAO(pool)));
		mapaComandos.put("excluirRegistroRiscoAcoes", new ExcluirRegistroRiscoAcoes(new RegistroRiscoAcoesDAO(pool)));
		
		mapaComandos.put("cadastrarMatrizRastreabilidadeRequisito", new CadastrarMatrizRastreabilidadeRequisito(new MatrizRastreabilidadeRequisitoDAO(pool)));
		mapaComandos.put("consultarMatrizRastreabilidadeRequisito", new ConsultarMatrizRastreabilidadeRequisito(new MatrizRastreabilidadeRequisitoDAO(pool)));
		mapaComandos.put("editarMatrizRastreabilidadeRequisito", new EditarMatrizRastreabilidadeRequisito(new MatrizRastreabilidadeRequisitoDAO(pool)));
		mapaComandos.put("atualizarMatrizRastreabilidadeRequisito", new AtualizarMatrizRastreabilidadeRequisito(new MatrizRastreabilidadeRequisitoDAO(pool)));
		mapaComandos.put("excluirMatrizRastreabilidadeRequisito", new ExcluirMatrizRastreabilidadeRequisito(new MatrizRastreabilidadeRequisitoDAO(pool)));
		
		mapaComandos.put("cadastrarListaAtividade", new CadastrarListaAtividade(new ListaAtividadeDAO(pool)));
		mapaComandos.put("consultarListaAtividade", new ConsultarListaAtividade(new ListaAtividadeDAO(pool)));
		mapaComandos.put("editarListaAtividade", new EditarListaAtividade(new ListaAtividadeDAO(pool)));
		mapaComandos.put("atualizarListaAtividade", new AtualizarListaAtividade(new ListaAtividadeDAO(pool)));
		mapaComandos.put("excluirListaAtividade", new ExcluirListaAtividade(new ListaAtividadeDAO(pool)));
		
		mapaComandos.put("cadastrarAtributoAtividade", new CadastrarAtributoAtividade(new AtributoAtividadeDAO(pool), new OrganogramaDAO(pool)));
		mapaComandos.put("consultarAtributoAtividade", new ConsultarAtributoAtividade(new AtributoAtividadeDAO(pool)));
		mapaComandos.put("editarAtributoAtividade", new EditarAtributoAtividade(new AtributoAtividadeDAO(pool), new OrganogramaDAO(pool)));
		mapaComandos.put("atualizarAtributoAtividade", new AtualizarAtributoAtividade(new AtributoAtividadeDAO(pool), new OrganogramaDAO(pool)));
		mapaComandos.put("excluirAtributoAtividade", new ExcluirAtributoAtividade(new AtributoAtividadeDAO(pool)));
		
		mapaComandos.put("cadastrarAvaliacaoDesempenhoEquipe", new CadastrarAvaliacaoDesempenhoEquipe(new AvaliacaoDesempenhoEquipeDAO(pool)));
		mapaComandos.put("consultarAvaliacaoDesempenhoEquipe", new ConsultarAvaliacaoDesempenhoEquipe(new AvaliacaoDesempenhoEquipeDAO(pool)));
		mapaComandos.put("editarAvaliacaoDesempenhoEquipe", new EditarAvaliacaoDesempenhoEquipe(new AvaliacaoDesempenhoEquipeDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("atualizarAvaliacaoDesempenhoEquipe", new AtualizarAvaliacaoDesempenhoEquipe(new AvaliacaoDesempenhoEquipeDAO(pool)));
		mapaComandos.put("excluirAvaliacaoDesempenhoEquipe", new ExcluirAvaliacaoDesempenhoEquipe(new AvaliacaoDesempenhoEquipeDAO(pool)));
		
		mapaComandos.put("cadastrarIssuesLog", new CadastrarIssuesLog(new IssuesLogDAO(pool)));
		mapaComandos.put("consultarIssuesLog", new ConsultarIssuesLog(new IssuesLogDAO(pool)));
		mapaComandos.put("editarIssuesLog", new EditarIssuesLog(new IssuesLogDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("atualizarIssuesLog", new AtualizarIssuesLog(new IssuesLogDAO(pool)));
		mapaComandos.put("excluirIssuesLog", new ExcluirIssuesLog(new IssuesLogDAO(pool)));
						
		mapaComandos.put("cadastrarDecisoesComprar", new CadastrarDecisoesComprar(new DecisoesComprarDAO(pool)));
		mapaComandos.put("consultarDecisoesComprar", new ConsultarDecisoesComprar(new DecisoesComprarDAO(pool)));
		mapaComandos.put("editarDecisoesComprar", new EditarDecisoesComprar(new DecisoesComprarDAO(pool)));
		mapaComandos.put("atualizarDecisoesComprar", new AtualizarDecisoesComprar(new DecisoesComprarDAO(pool)));
		mapaComandos.put("excluirDecisoesComprar", new ExcluirDecisoesComprar(new DecisoesComprarDAO(pool)));
		
		mapaComandos.put("cadastrarDiagnosticoPlanoAcao", new CadastrarDiagnosticoPlanoAcao(new DiagnosticoPlanoAcaoDAO(pool)));
		mapaComandos.put("consultarDiagnosticoPlanoAcao", new ConsultarDiagnosticoPlanoAcao(new DiagnosticoPlanoAcaoDAO(pool)));
		mapaComandos.put("editarDiagnosticoPlanoAcao", new EditarDiagnosticoPlanoAcao(new DiagnosticoPlanoAcaoDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("atualizarDiagnosticoPlanoAcao", new AtualizarDiagnosticoPlanoAcao(new DiagnosticoPlanoAcaoDAO(pool)));
		mapaComandos.put("excluirDiagnosticoPlanoAcao", new ExcluirDiagnosticoPlanoAcao(new DiagnosticoPlanoAcaoDAO(pool)));
		
		mapaComandos.put("cadastrarListaMarcos", new CadastrarListaMarcos(new ListaMarcosDAO(pool)));
		mapaComandos.put("consultarListaMarcos", new ConsultarListaMarcos(new ListaMarcosDAO(pool)));
		mapaComandos.put("editarListaMarcos", new EditarListaMarcos(new ListaMarcosDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("atualizarListaMarcos", new AtualizarListaMarcos(new ListaMarcosDAO(pool)));
		mapaComandos.put("excluirListaMarcos", new ExcluirListaMarcos(new ListaMarcosDAO(pool)));
		
		mapaComandos.put("cadastrarOrcamentoProjeto", new CadastrarOrcamentoProjeto(new OrcamentoProjetoDAO(pool)));
		mapaComandos.put("consultarOrcamentoProjeto", new ConsultarOrcamentoProjeto(new OrcamentoProjetoDAO(pool)));
		mapaComandos.put("editarOrcamentoProjeto", new EditarOrcamentoProjeto(new OrcamentoProjetoDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("atualizarOrcamentoProjeto", new AtualizarOrcamentoProjeto(new OrcamentoProjetoDAO(pool)));
		mapaComandos.put("excluirOrcamentoProjeto", new ExcluirOrcamentoProjeto(new OrcamentoProjetoDAO(pool)));
		
		mapaComandos.put("cadastrarRelatorioEncerramentoContrato", new CadastrarRelatorioEncerramentoContrato(new RelatorioEncerramentoContratoDAO(pool)));
		mapaComandos.put("consultarRelatorioEncerramentoContrato", new ConsultarRelatorioEncerramentoContrato(new RelatorioEncerramentoContratoDAO(pool)));
		mapaComandos.put("editarRelatorioEncerramentoContrato", new EditarRelatorioEncerramentoContrato(new RelatorioEncerramentoContratoDAO(pool)));
		mapaComandos.put("atualizarRelatorioEncerramentoContrato", new AtualizarRelatorioEncerramentoContrato(new RelatorioEncerramentoContratoDAO(pool)));
		mapaComandos.put("excluirRelatorioEncerramentoContrato", new ExcluirRelatorioEncerramentoContrato(new RelatorioEncerramentoContratoDAO(pool)));
		
		mapaComandos.put("cadastrarSolicitacaoProjetovBSC", new CadastrarSolicitacaoProjetovBSC(new SolicitacaoProjetovBSCDAO(pool)));
		mapaComandos.put("consultarSolicitacaoProjetovBSC", new ConsultarSolicitacaoProjetovBSC(new SolicitacaoProjetovBSCDAO(pool)));
		mapaComandos.put("editarSolicitacaoProjetovBSC", new EditarSolicitacaoProjetovBSC(new SolicitacaoProjetovBSCDAO(pool)));
		mapaComandos.put("atualizarSolicitacaoProjetovBSC", new AtualizarSolicitacaoProjetovBSC(new SolicitacaoProjetovBSCDAO(pool)));
		mapaComandos.put("excluirSolicitacaoProjetovBSC", new ExcluirSolicitacaoProjetovBSC(new SolicitacaoProjetovBSCDAO(pool)));
		
		mapaComandos.put("consultarFilebean", new ConsultarFilebean(new FileDAO(pool)));
		mapaComandos.put("excluirFileBean", new ExcluirFileBean(new FileDAO(pool)));
		mapaComandos.put("consultarFilebeanArquivo", new ConsultarFilebeanArquivo(new FileDAO(pool)));
		
		mapaComandos.put("consultarFilebeanAjuda", new ConsultarFilebeanAjuda(new FileAjudaDAO(pool)));
		mapaComandos.put("excluirFileBeanAjuda", new ExcluirFileBeanAjuda(new FileAjudaDAO(pool)));
		mapaComandos.put("consultarFilebeanArquivoAjuda", new ConsultarFilebeanArquivoAjuda(new FileAjudaDAO(pool)));
		
		mapaComandos.put("consultarFilebeanProjeto", new ConsultarFilebeanProjeto(new FileProjetoDAO(pool)));
		mapaComandos.put("excluirFileBeanProjeto", new ExcluirFileBeanProjeto(new FileProjetoDAO(pool)));
		mapaComandos.put("editarFileBeanProjeto", new EditarFileBeanProjeto(new FileProjetoDAO(pool)));
		mapaComandos.put("atualizarFileBeanProjeto", new AtualizarFileBeanProjeto(new FileProjetoDAO(pool)));
		//mapaComandos.put("consultarFilebeanArquivoAjuda", new ConsultarFilebeanArquivoAjuda(new FileAjudaDAO(pool))); 
		
		mapaComandos.put("cadastrarProjetoInicio", new CadastrarProjetoInicio(new ProjetoInicioDAO(pool)));
		mapaComandos.put("consultarProjetoInicio", new ConsultarProjetoInicio(new ProjetoInicioDAO(pool)));	
		mapaComandos.put("consultarProjetoInicioRamificacao", new ConsultarProjetoInicioRamificacao(new ProjetoInicioDAO(pool)));//configuração da ramificação no cad. projeto	
		mapaComandos.put("atualizarProjetoInicio", new AtualizarProjetoInicio(new ProjetoInicioDAO(pool)));
		mapaComandos.put("editarProjetoInicio", new EditarProjetoInicio(new ProjetoInicioDAO(pool)));				
		mapaComandos.put("excluirProjetoInicio", new ExcluirProjetoInicio(new ProjetoInicioDAO(pool)));
		
		mapaComandos.put("cadastrarEnvolvimentoPessoaProjetoInicio", new CadastrarEnvolvimentoPessoaProjetoInicio(new EnvolvimentoPessoaProjetoInicioDAO(pool)));
		mapaComandos.put("consultarEnvolvimentoPessoaProjetoInicio", new ConsultarEnvolvimentoPessoaProjetoInicio(new EnvolvimentoPessoaProjetoInicioDAO(pool)));
		mapaComandos.put("editarEnvolvimentoPessoaProjetoInicio", new EditarEnvolvimentoPessoaProjetoInicio(new EnvolvimentoPessoaProjetoInicioDAO(pool), new ProjetoInicioDAO(pool), new RecursosHumanosDAO(pool)));
		mapaComandos.put("atualizarEnvolvimentoPessoaProjetoInicio", new AtualizarEnvolvimentoPessoaProjetoInicio(new EnvolvimentoPessoaProjetoInicioDAO(pool)));
		mapaComandos.put("excluirEnvolvimentoPessoaProjetoInicio", new ExcluirEnvolvimentoPessoaProjetoInicio(new EnvolvimentoPessoaProjetoInicioDAO(pool)));
		
		mapaComandos.put("cadastrarMatrizResponsabilidade", new CadastrarMatrizResponsabilidade(new MatrizResponsabilidadeDAO(pool)));
		mapaComandos.put("consultarMatrizResponsabilidade", new ConsultarMatrizResponsabilidade(new MatrizResponsabilidadeDAO(pool)));
		mapaComandos.put("editarMatrizResponsabilidade", new EditarMatrizResponsabilidade(new MatrizResponsabilidadeDAO(pool)));
		mapaComandos.put("atualizarMatrizResponsabilidade", new AtualizarMatrizResponsabilidade(new MatrizResponsabilidadeDAO(pool)));
		mapaComandos.put("excluirMatrizResponsabilidade", new ExcluirMatrizResponsabilidade(new MatrizResponsabilidadeDAO(pool)));
		
		mapaComandos.put("cadastrarListaOcorrencia", new CadastrarListaOcorrencia(new ListaOcorrenciaDAO(pool)));
		mapaComandos.put("consultarListaOcorrencia", new ConsultarListaOcorrencia(new ListaOcorrenciaDAO(pool)));
		mapaComandos.put("editarListaOcorrencia", new EditarListaOcorrencia(new ListaOcorrenciaDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("atualizarListaOcorrencia", new AtualizarListaOcorrencia(new ListaOcorrenciaDAO(pool)));
		mapaComandos.put("excluirListaOcorrencia", new ExcluirListaOcorrencia(new ListaOcorrenciaDAO(pool)));
		
		mapaComandos.put("cadastrarCalendarioEvento", new CadastrarCalendarioEvento(new CalendarioEventoDAO(pool)));
		mapaComandos.put("consultarCalendarioEvento", new ConsultarCalndarioEvento(new CalendarioEventoDAO(pool)));
		mapaComandos.put("editarCalendarioEvento", new EditarCalendarioEvento(new CalendarioEventoDAO(pool)));
		mapaComandos.put("atualizarCalendarioEvento", new AtualizarCalendarioEvento(new CalendarioEventoDAO(pool)));
		mapaComandos.put("excluirCalendarioEvento", new ExcluirCalendarioEvento(new CalendarioEventoDAO(pool)));
		
		mapaComandos.put("cadastrarModeloContrato", new CadastrarModeloContrato(new ModeloContratoDAO(pool)));
		mapaComandos.put("consultarModeloContrato", new ConsultarModeloContrato(new ModeloContratoDAO(pool)));
		mapaComandos.put("editarModeloContrato", new EditarModeloContrato(new ModeloContratoDAO(pool)));
		mapaComandos.put("atualizarModeloContrato", new AtualizarModeloContrato(new ModeloContratoDAO(pool)));
		mapaComandos.put("excluirModeloContrato", new ExcluirModeloContrato(new ModeloContratoDAO(pool)));
		
		mapaComandos.put("cadastrarRfq", new CadastrarRfq(new RfqDAO(pool)));
		mapaComandos.put("consultarRfq", new ConsultarRfq(new RfqDAO(pool)));
		mapaComandos.put("editarRfq", new EditarRfq(new RfqDAO(pool)));
		mapaComandos.put("atualizarRfq", new AtualizarRfq(new RfqDAO(pool)));
		mapaComandos.put("excluirRfq", new ExcluirRfq(new RfqDAO(pool)));
		
		mapaComandos.put("cadastrarPortfolioProjeto", new CadastrarPortfolioProjeto(new PortfolioProjetoDAO(pool)));
		mapaComandos.put("consultarPortfolioProjeto", new ConsultarPortfolioProjeto(new PortfolioProjetoDAO(pool)));
		mapaComandos.put("editarPortfolioProjeto", new EditarPortfolioProjeto(new PortfolioProjetoDAO(pool), new RegistroParteInteressadaDAO(pool), new PlanoGerenciamentoProjetoDAO(pool), new DeclaracaoEscopoDAO(pool), new DicionarioEAPDAO(pool), new RegistroRiscoDAO(pool), new StatusReportDAO(pool)));
		mapaComandos.put("atualizaPortfolioProjeto", new AtualizarPortfolioProjeto(new PortfolioProjetoDAO(pool)));
		mapaComandos.put("excluirPortfolioProjeto", new ExcluirPortfolioProjeto(new PortfolioProjetoDAO(pool)));
		
		mapaComandos.put("cadastrarOrganograma", new CadastrarOrganograma(new OrganogramaDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("consultarOrganograma", new ConsultarOrganograma(new OrganogramaDAO(pool)));
		mapaComandos.put("editarOrganograma", new EditarOrganograma(new OrganogramaDAO(pool)));
		mapaComandos.put("editarOrganogramaStatus", new EditarOrganogramaStatus(new OrganogramaDAO(pool)));		
		mapaComandos.put("atualizarOrganograma", new AtualizarOrganograma(new OrganogramaDAO(pool), new ProjetoInicioDAO(pool)));
		mapaComandos.put("excluirOrganograma", new ExcluirOrganograma(new OrganogramaDAO(pool)));
		
		mapaComandos.put("cadastrarOrganogramaPropriedade", new CadastrarOrganogramaPropriedade(new OrganogramaPropriedadeDAO(pool)));
		mapaComandos.put("consultarOrganogramaPropriedade", new ConsultarOrganogramaPropriedade(new OrganogramaPropriedadeDAO(pool)));
		mapaComandos.put("editarOrganogramaPropriedade", new EditarOrganogramaPropriedade(new OrganogramaPropriedadeDAO(pool)));
		mapaComandos.put("editarOrganogramaPropriedadeStatus", new EditarOrganogramaPropriedadeStatus(new OrganogramaPropriedadeDAO(pool)));		
		mapaComandos.put("atualizarOrganogramaPropriedade", new AtualizarOrganogramaPropriedade(new OrganogramaPropriedadeDAO(pool)));
		mapaComandos.put("excluirOrganogramaPropriedade", new ExcluirOrganogramaPropriedade(new OrganogramaPropriedadeDAO(pool)));
		
		mapaComandos.put("cadastrarUsuario", new CadastrarUsuario(new UsuarioDAO(pool)));
		mapaComandos.put("consultarUsuario", new ConsultarUsuario(new UsuarioDAO(pool)));
		mapaComandos.put("editarUsuario", new EditarUsuario(new UsuarioDAO(pool)));
		mapaComandos.put("atualizarUsuario", new AtualizarUsuario(new UsuarioDAO(pool)));
		mapaComandos.put("excluirUsuario", new ExcluirUsuario(new UsuarioDAO(pool)));
		
		/*Esta sessão esta incompleta. Não estou conseguindo atualizar os dados do textearea*/
		mapaComandos.put("cadastrarDiagramaGantt", new CadastrarDiagramaGantt(new DiagramaGanttDAO(pool)));
		mapaComandos.put("consultarDiagramaGantt", new ConsultarDiagramaGantt(new DiagramaGanttDAO(pool)));
		mapaComandos.put("editarDiagramaGantt", new EditarDiagramaGantt(new DiagramaGanttDAO(pool)));
		mapaComandos.put("atualizarDiagramaGantt", new AtualizarDiagramaGantt(new DiagramaGanttDAO(pool)));
		mapaComandos.put("excluirDiagramaGantt", new ExcluirDiagramaGantt(new DiagramaGanttDAO(pool)));
		
		mapaComandos.put("cadastrarOrganogramaMapa", new CadastrarOrganogramaMapa(new OrganogramaMapaDAO(pool)));
		mapaComandos.put("consultarOrganogramaMapa", new ConsultarOrganogramaMapa(new OrganogramaMapaDAO(pool)));
		mapaComandos.put("editarOrganogramaMapa", new EditarOrganogramaMapa(new OrganogramaMapaDAO(pool)));
		mapaComandos.put("editarOrganogramaMapaStatus", new EditarOrganogramaMapaStatus(new OrganogramaMapaDAO(pool)));
		mapaComandos.put("atualizarOrganogramaMapa", new AtualizarOrganogramaMapa(new OrganogramaMapaDAO(pool)));
		mapaComandos.put("excluirOrganogramaMapa", new ExcluirOrganogramaMapa(new OrganogramaMapaDAO(pool)));
		
		mapaComandos.put("cadastrarFornecedorQualificado", new CadastrarFornecedorQualificado(new FornecedorQualificadoDAO(pool)));
		mapaComandos.put("consultarFornecedorQualificado", new ConsultarFornecedorQualificado(new FornecedorQualificadoDAO(pool)));
		mapaComandos.put("editarFornecedorQualificado", new EditarFornecedorQualificado(new FornecedorQualificadoDAO(pool)));
		mapaComandos.put("atualizarFornecedorQualificado", new AtualizarFornecedorQualificado(new FornecedorQualificadoDAO(pool)));
		mapaComandos.put("excluirFornecedorQualificado", new ExcluirFornecedorQualificado(new FornecedorQualificadoDAO(pool)));
		
		mapaComandos.put("cadastrarTabelaParteInteressada", new CadastrarTabelaParteInteressada(new TabelaParteInteressadaDAO(pool), new RegistroParteInteressadaDAO(pool)));
		mapaComandos.put("consultarTabelaParteInteressada", new ConsultarTabelaParteInteressada(new TabelaParteInteressadaDAO(pool)));
		mapaComandos.put("editarTabelaParteInteressada", new EditarTabelaParteInteressada(new TabelaParteInteressadaDAO(pool), new RegistroParteInteressadaDAO(pool)));
		mapaComandos.put("atualizarTabelaParteInteressada", new AtualizarTabelaParteInteressada(new TabelaParteInteressadaDAO(pool), new RegistroParteInteressadaDAO(pool)));
		mapaComandos.put("excluirTabelaParteInteressada", new ExcluirTabelaParteInteressada(new TabelaParteInteressadaDAO(pool)));
		
		//Cadastrandro o InicarTkcsapcd no TkcsapcdHelper!!!!
		mapaComandos.put("iniciarTkcsapcd", new IniciarTkcsapcd());
				
	}	
	//Unico método, que retorna um objeto
	public InterfaceCommand getCommand() 
	{
		String cmd = resquest.getParameter("cmd");
		if(cmd == null)
			return mapaComandos.get("iniciarTkcsapcd");
		return mapaComandos.get(cmd);
		
		//1ª implementação: return mapaComandos.get(resquest.getParameter("cmd")); Acima a mesma esta modificada, apos a criação do Iniciartkcsapcd.
	}
		
	
}

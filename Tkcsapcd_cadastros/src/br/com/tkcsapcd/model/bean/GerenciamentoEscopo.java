/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "gerenciamentoescopo")
public class GerenciamentoEscopo {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(length = 200, nullable = true)
	private String empresa;
	
	@Column(length = 150, nullable = true)
	private String orgao;
	
	@Column(length = 150, nullable = true)
	private String setor;
	
	@Column(length = 150, nullable = true)
	private String programa;
		
	@Column(length = 150, nullable = true)
	private String gerente;
	
	@Column(length = 150, nullable = true)
	private String funcao;
	
	@Column(length = 150, nullable = true)
	private String aprovado;
	
	@Column(length = 150, nullable = true)
	private String versao;
	
	private Date dataaprovacao;
	
	@Column(length = 1000, nullable = true)
	private String objetivo; 
	
	@Column(length = 1000, nullable = true)
	private String gerenciamento;
	
	@Column(length = 1000, nullable = true)
	private String reunioes_equipe;
	
	@Column(length = 1000, nullable = true)
	private String reunioes_planejamento;
	
	@Column(length = 1000, nullable = true)
	private String reunioes_gerenciais;
	
	@Column(length = 1000, nullable = true)
	private String modificacao_escopo; 
	
	@Column(length = 1000, nullable = true)
	private String licoes;	
	
	@ManyToOne
	@JoinColumn(name="projetoinicio", nullable = false)
	private ProjetoInicio projetoinicio = new ProjetoInicio();
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Date getDataaprovacao() {
		return dataaprovacao;
	}
	public void setDataaprovacao(Date dataaprovacao) {
		this.dataaprovacao = dataaprovacao;
	}
	public ProjetoInicio getProjetoinicio() {
		return projetoinicio;
	}
	public void setProjetoinicio(ProjetoInicio projetoinicio) {
		this.projetoinicio = projetoinicio;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getOrgao() {
		return orgao;
	}
	public void setOrgao(String orgao) {
		this.orgao = orgao;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public String getPrograma() {
		return programa;
	}
	public void setPrograma(String programa) {
		this.programa = programa;
	}
	
	public String getGerente() {
		return gerente;
	}
	public void setGerente(String gerente) {
		this.gerente = gerente;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public String getAprovado() {
		return aprovado;
	}
	public void setAprovado(String aprovado) {
		this.aprovado = aprovado;
	}
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public String getGerenciamento() {
		return gerenciamento;
	}
	public void setGerenciamento(String gerenciamento) {
		this.gerenciamento = gerenciamento;
	}
	public String getReunioes_equipe() {
		return reunioes_equipe;
	}
	public void setReunioes_equipe(String reunioes_equipe) {
		this.reunioes_equipe = reunioes_equipe;
	}
	public String getReunioes_planejamento() {
		return reunioes_planejamento;
	}
	public void setReunioes_planejamento(String reunioes_planejamento) {
		this.reunioes_planejamento = reunioes_planejamento;
	}
	public String getReunioes_gerenciais() {
		return reunioes_gerenciais;
	}
	public void setReunioes_gerenciais(String reunioes_gerenciais) {
		this.reunioes_gerenciais = reunioes_gerenciais;
	}
	public String getModificacao_escopo() {
		return modificacao_escopo;
	}
	public void setModificacao_escopo(String modificacao_escopo) {
		this.modificacao_escopo = modificacao_escopo;
	}
	public String getLicoes() {
		return licoes;
	}
	public void setLicoes(String licoes) {
		this.licoes = licoes;
	}
	
	
	
	
}

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
@Table(name = "registrosolicitacaomudanca")
public class RegistroSolicitacaoMudanca {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(length = 150, nullable = true)
	private String versao;
	
	private Date data;
	
	@Column(length = 200, nullable = false)
	private String autor;
	
	@Column(length = 150, nullable = true)
	private String notarevisao;
	
	@Column(length = 878, nullable = true)
	private String aprovacao;
	
	@Column(length = 150, nullable = true)
	private double referencia;
	
	@Column(length = 150, nullable = false)
	private String prioridade;
	
	@Column(length = 150, nullable = true)
	private String impedeimplantacao;
	
	@Column(length = 150, nullable = true)
	private String solicitacao;	
	
	private Date datasolicitacao;
	
	@Column(length = 878, nullable = true)
	private String descricao;
	
	@Column(length = 878, nullable = true)
	private String justificativa;
	
	private double esforcoestimadohoras;
	
	private double custoestimado;
	
	private double impactoprazodias;
	
	@Column(length = 878, nullable = true)
	private String classificacao;
	
	@Column(length = 878, nullable = true)
	private String responsavel;
	
	@Column(length = 878, nullable = true)
	private String previsao;
	
	@Column(length = 878, nullable = true)
	private String status;
	
	@Column(length = 878, nullable = true)
	private String comentarios;
	
	@ManyToOne
	@JoinColumn(name="solicitacaomudanca", nullable = false)
	private SolicitacaoMudanca solicitacaomudanca = new SolicitacaoMudanca();
	
	@ManyToOne
	@JoinColumn(name="projetoinicio", nullable = false)
	private ProjetoInicio projetoinicio = new ProjetoInicio();	
	
	
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}		
	
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getNotarevisao() {
		return notarevisao;
	}
	public void setNotarevisao(String notarevisao) {
		this.notarevisao = notarevisao;
	}
	public String getAprovacao() {
		return aprovacao;
	}
	public void setAprovacao(String aprovacao) {
		this.aprovacao = aprovacao;
	}
	public double getReferencia() {
		return referencia;
	}
	public void setReferencia(double referencia) {
		this.referencia = referencia;
	}
	public String getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}
	public String getImpedeimplantacao() {
		return impedeimplantacao;
	}
	public void setImpedeimplantacao(String impedeimplantacao) {
		this.impedeimplantacao = impedeimplantacao;
	}
	public String getSolicitacao() {
		return solicitacao;
	}
	public void setSolicitacao(String solicitacao) {
		this.solicitacao = solicitacao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getJustificativa() {
		return justificativa;
	}
	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}
	public double getEsforcoestimadohoras() {
		return esforcoestimadohoras;
	}
	public void setEsforcoestimadohoras(double esforcoestimadohoras) {
		this.esforcoestimadohoras = esforcoestimadohoras;
	}
	public double getCustoestimado() {
		return custoestimado;
	}
	public void setCustoestimado(double custoestimado) {
		this.custoestimado = custoestimado;
	}
	public double getImpactoprazodias() {
		return impactoprazodias;
	}
	public void setImpactoprazodias(double impactoprazodias) {
		this.impactoprazodias = impactoprazodias;
	}
	public String getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getPrevisao() {
		return previsao;
	}
	public void setPrevisao(String previsao) {
		this.previsao = previsao;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Date getDatasolicitacao() {
		return datasolicitacao;
	}
	public void setDatasolicitacao(Date datasolicitacao) {
		this.datasolicitacao = datasolicitacao;
	}
	public SolicitacaoMudanca getSolicitacaomudanca() {
		return solicitacaomudanca;
	}
	public void setSolicitacaomudanca(SolicitacaoMudanca solicitacaomudanca) {
		this.solicitacaomudanca = solicitacaomudanca;
	}
	public ProjetoInicio getProjetoinicio() {
		return projetoinicio;
	}
	public void setProjetoinicio(ProjetoInicio projetoinicio) {
		this.projetoinicio = projetoinicio;
	}
	
	
}

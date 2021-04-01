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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="businessplan")
public class BusinessPlan {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(length = 150, nullable = false)
	private String businessplan;
	
	@Column(length = 50, nullable = false)
	private String versao;
	
	private Date data;
	
	@Column(length = 150, nullable = false)
	private String autor;
	
	@Column(length = 100, nullable = false)
	private String notarevisao;
	
	@Column(length = 300, nullable = true)
	private String aprovacao;
	
	@Column(length = 600, nullable = true)
	private String situacaomercado;
	
	@Column(length = 600, nullable = true)
	private String situacaoservico;
	
	@Column(length = 600, nullable = true)
	private String situacaocompetividade;
	
	@Column(length = 600, nullable = true)
	private String situacaodistribuicao;
	
	@Column(length = 600, nullable = true)
	private String situacaomacro;
	
	@Column(length = 600, nullable = true)
	private String analiseexterno;
	
	@Column(length = 600, nullable = true)
	private String analiseinterno;
	
	@Column(length = 600, nullable = true)
	private String analiserelacionada;
	
	@Column(length = 600, nullable = true)
	private String objetivofinanceiro;
	
	@Column(length = 600, nullable = true)
	private String objetivomarketing;
	
	@Column(length = 600, nullable = true)
	private String cronograma;
	
	@Column(length = 600, nullable = true)
	private String estrategia;
	
	@Column(length = 600, nullable = true)
	private String segmento;
	
	@OneToOne
	@JoinColumn(name="projetoinicio", nullable = false)
	private ProjetoInicio projetoinicio = new ProjetoInicio();
	
	
	public String getBusinessplan() {
		return businessplan;
	}
	public void setBusinessplan(String businessplan) {
		this.businessplan = businessplan;
	}
	
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
	public String getSituacaomercado() {
		return situacaomercado;
	}
	public void setSituacaomercado(String situacaomercado) {
		this.situacaomercado = situacaomercado;
	}
	public String getSituacaoservico() {
		return situacaoservico;
	}
	public void setSituacaoservico(String situacaoservico) {
		this.situacaoservico = situacaoservico;
	}
	public String getSituacaocompetividade() {
		return situacaocompetividade;
	}
	public void setSituacaocompetividade(String situacaocompetividade) {
		this.situacaocompetividade = situacaocompetividade;
	}
	public String getSituacaodistribuicao() {
		return situacaodistribuicao;
	}
	public void setSituacaodistribuicao(String situacaodistribuicao) {
		this.situacaodistribuicao = situacaodistribuicao;
	}
	public String getSituacaomacro() {
		return situacaomacro;
	}
	public void setSituacaomacro(String situacaomacro) {
		this.situacaomacro = situacaomacro;
	}
	public String getAnaliseexterno() {
		return analiseexterno;
	}
	public void setAnaliseexterno(String analiseexterno) {
		this.analiseexterno = analiseexterno;
	}
	public String getAnaliseinterno() {
		return analiseinterno;
	}
	public void setAnaliseinterno(String analiseinterno) {
		this.analiseinterno = analiseinterno;
	}
	public String getAnaliserelacionada() {
		return analiserelacionada;
	}
	public void setAnaliserelacionada(String analiserelacionada) {
		this.analiserelacionada = analiserelacionada;
	}
	public String getObjetivofinanceiro() {
		return objetivofinanceiro;
	}
	public void setObjetivofinanceiro(String objetivofinanceiro) {
		this.objetivofinanceiro = objetivofinanceiro;
	}
	public String getObjetivomarketing() {
		return objetivomarketing;
	}
	public void setObjetivomarketing(String objetivomarketing) {
		this.objetivomarketing = objetivomarketing;
	}
	public String getCronograma() {
		return cronograma;
	}
	public void setCronograma(String cronograma) {
		this.cronograma = cronograma;
	}
	public String getEstrategia() {
		return estrategia;
	}
	public void setEstrategia(String estrategia) {
		this.estrategia = estrategia;
	}
	public String getSegmento() {
		return segmento;
	}
	public void setSegmento(String segmento) {
		this.segmento = segmento;
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
	public ProjetoInicio getProjetoinicio() {
		return projetoinicio;
	}
	public void setProjetoinicio(ProjetoInicio projetoinicio) {
		this.projetoinicio = projetoinicio;
	}
	
	
	
}

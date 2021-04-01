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
@Table(name = "dicionarioeap")
public class DicionarioEAP {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(length = 200, nullable = false)
	private String dicionarioeap;
		
	@Column(length = 150, nullable = true)
	private String versao;
	
	private Date data;
	
	@Column(length = 200, nullable = false)
	private String autor;
	
	@Column(length = 150, nullable = true)
	private String notarevisao;
	
	@Column(length = 500, nullable = true)
	private String aprovacao;
	
	private Integer codigoeap;
	
	@Column(length = 500, nullable = true)
	private String entregapacote;
	
	@Column(length = 500, nullable = true)
	private String descricao;
	
	@Column(length = 500, nullable = true)
	private String criterioaceitacao;
	
	@Column(length = 500, nullable = true)
	private String responsavel;
	
	@Column(length = 500, nullable = true)
	private String aprovado;
	
	@Column(length = 500, nullable = true)
	private String consultado;
	
	@Column(length = 500, nullable = true)
	private String informado;
	
	@Column(length = 500, nullable = true)
	private String trabalhoenvolvido;
	
	@Column(length = 500, nullable = true)
	private String riscos;
	
	@Column(length = 500, nullable = true)
	private String recusos;
	
	@Column(length = 500, nullable = true)
	private String macros;
	
	private double custos;
	
	@Column(length = 500, nullable = true)
	private String previsao;
	
	@Column(length = 500, nullable = true)
	private String informacoes;
	
	private String status;
	
	@Column(length = 500, nullable = true)
	private String comentarios;
	
	@ManyToOne
	@JoinColumn(name="projetoinicio", nullable = false)
	private ProjetoInicio projetoinicio = new ProjetoInicio();	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getDicionarioeap() {
		return dicionarioeap;
	}
	public void setDicionarioeap(String dicionarioeap) {
		this.dicionarioeap = dicionarioeap;
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
	public Integer getCodigoeap() {
		return codigoeap;
	}
	public void setCodigoeap(Integer codigoeap) {
		this.codigoeap = codigoeap;
	}
	public String getEntregapacote() {
		return entregapacote;
	}
	public void setEntregapacote(String entregapacote) {
		this.entregapacote = entregapacote;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCriterioaceitacao() {
		return criterioaceitacao;
	}
	public void setCriterioaceitacao(String criterioaceitacao) {
		this.criterioaceitacao = criterioaceitacao;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getAprovado() {
		return aprovado;
	}
	public void setAprovado(String aprovado) {
		this.aprovado = aprovado;
	}
	public String getConsultado() {
		return consultado;
	}
	public void setConsultado(String consultado) {
		this.consultado = consultado;
	}
	public String getInformado() {
		return informado;
	}
	public void setInformado(String informado) {
		this.informado = informado;
	}
	public String getTrabalhoenvolvido() {
		return trabalhoenvolvido;
	}
	public void setTrabalhoenvolvido(String trabalhoenvolvido) {
		this.trabalhoenvolvido = trabalhoenvolvido;
	}
	public String getRiscos() {
		return riscos;
	}
	public void setRiscos(String riscos) {
		this.riscos = riscos;
	}
	public String getRecusos() {
		return recusos;
	}
	public void setRecusos(String recusos) {
		this.recusos = recusos;
	}
	public String getMacros() {
		return macros;
	}
	public void setMacros(String macros) {
		this.macros = macros;
	}
	public double getCustos() {
		return custos;
	}
	public void setCustos(double custos) {
		this.custos = custos;
	}
	public String getPrevisao() {
		return previsao;
	}
	public void setPrevisao(String previsao) {
		this.previsao = previsao;
	}
	public String getInformacoes() {
		return informacoes;
	}
	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
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

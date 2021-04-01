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
@Table(name = "acompanhamentoprojeto")
public class AcompanhamentoProjeto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(length = 150, nullable = false)
	private String acompanhamentoprojeto;
		
	private Long versao;
	
	private Date data;
	
	@Column(length = 150, nullable = false)
	private String autor;
	
	@Column(length = 150, nullable = true)
	private String notarevisao;
	
	@Column(length = 300, nullable = false)
	private String aprovacao;
	
	@Column(length = 150, nullable = true)
	private String produtoservico;
	
	@Column(length = 150, nullable = true)
	private String situacaoconcluida;
	
	private Date dataplanejada; 
	
	private Date dataefetiva;
	
	private Long atrasoprevisto;
	
	private Double valororcado;

	private Double custoreal;
	
	@Column(length = 1750, nullable = true)
	private String especificacao;
	
	@Column(length = 1750, nullable = true)
	private String nivel;
	
	@Column(length = 1750, nullable = true)
	private String acao;
	
	@Column(length = 1750, nullable = true)
	private String responsavel;
	
	@ManyToOne
	@JoinColumn(name="projetoinicio", nullable = false)
	private ProjetoInicio projetoinicio = new ProjetoInicio();

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getAcompanhamentoprojeto() {
		return acompanhamentoprojeto;
	}

	public void setAcompanhamentoprojeto(String acompanhamentoprojeto) {
		this.acompanhamentoprojeto = acompanhamentoprojeto;
	}

	public Long getVersao() {
		return versao;
	}

	public void setVersao(Long versao) {
		this.versao = versao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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

	public String getProdutoservico() {
		return produtoservico;
	}

	public void setProdutoservico(String produtoservico) {
		this.produtoservico = produtoservico;
	}

	public String getSituacaoconcluida() {
		return situacaoconcluida;
	}

	public void setSituacaoconcluida(String situacaoconcluida) {
		this.situacaoconcluida = situacaoconcluida;
	}

	public Date getDataplanejada() {
		return dataplanejada;
	}

	public void setDataplanejada(Date dataplanejada) {
		this.dataplanejada = dataplanejada;
	}

	public Date getDataefetiva() {
		return dataefetiva;
	}

	public void setDataefetiva(Date dataefetiva) {
		this.dataefetiva = dataefetiva;
	}

	public Long getAtrasoprevisto() {
		return atrasoprevisto;
	}

	public void setAtrasoprevisto(Long atrasoprevisto) {
		this.atrasoprevisto = atrasoprevisto;
	}

	public Double getValororcado() {
		return valororcado;
	}

	public void setValororcado(Double valororcado) {
		this.valororcado = valororcado;
	}

	public Double getCustoreal() {
		return custoreal;
	}

	public void setCustoreal(Double custoreal) {
		this.custoreal = custoreal;
	}

	public String getEspecificacao() {
		return especificacao;
	}

	public void setEspecificacao(String especificacao) {
		this.especificacao = especificacao;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public ProjetoInicio getProjetoinicio() {
		return projetoinicio;
	}

	public void setProjetoinicio(ProjetoInicio projetoinicio) {
		this.projetoinicio = projetoinicio;
	}
	
	 
	
	}

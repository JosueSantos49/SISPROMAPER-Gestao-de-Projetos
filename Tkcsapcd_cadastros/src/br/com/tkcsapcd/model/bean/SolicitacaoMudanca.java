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
@Table(name = "solicitacaomudanca")
public class SolicitacaoMudanca {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long codigo;
	
	@Column(length = 200, nullable = false)
	private String solicitacaomudanca;	
	
	@Column(length = 100)
	private Integer versao;
	
	private Date data;
	
	@Column(length = 200, nullable = false)
	private String autor;
	
	@Column(length = 150, nullable = true)
	private String notarevisao;	
	
	@Column(length = 1750, nullable = true)
	private String aprovacao;
	
	@Column(length = 150, nullable = true)
	private String solicitante;
	
	@Column(length = 150, nullable = false)
	private String prioridade;
	
	@Column(length = 1750, nullable = true)
	private String descricao;
	
	@Column(length = 1750, nullable = true)
	private String justificativa;
	
	@Column(length = 1750, nullable = true)
	private String classificacao;
	
	@ManyToOne
	@JoinColumn(name="projetoinicio", nullable = false)
	private ProjetoInicio projetoinicio = new ProjetoInicio();	
		
	
	public String getSolicitacaomudanca() {
		return solicitacaomudanca;
	}
	public void setSolicitacaomudanca(String solicitacaomudanca) {
		this.solicitacaomudanca = solicitacaomudanca;
	}		
	public Integer getVersao() {
		return versao;
	}
	public void setVersao(Integer versao) {
		this.versao = versao;
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
	public String getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}
	public String getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
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
	public String getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	public ProjetoInicio getProjetoinicio() {
		return projetoinicio;
	}
	public void setProjetoinicio(ProjetoInicio projetoinicio) {
		this.projetoinicio = projetoinicio;
	}
	
}

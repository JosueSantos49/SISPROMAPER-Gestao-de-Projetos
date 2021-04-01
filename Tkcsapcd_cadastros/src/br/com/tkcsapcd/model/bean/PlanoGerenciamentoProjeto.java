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
@Table(name="planogerenciamentoprojeto")
public class PlanoGerenciamentoProjeto {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(length = 150, nullable = false)
	private String planogerenciamentoprojeto;
	
	@Column(length = 150, nullable = true)
	private String versao;
	
	private Date data;
	
	@Column(length = 200, nullable = false)
	private String autor;
	
	private String notarevisao;	
	
	@Column(length = 2000, nullable = true)
	private String aprovacao;	
	
	@Column(length = 2000, nullable = true)
	private String objetivo;	
	
	@Column(length = 2000, nullable = true)
	private String linhabase;
	
	@Column(length = 2000, nullable = true)
	private String organizacao;
	
	@Column(length = 2000, nullable = true)
	private String cronograma;
	
	@Column(length = 2000, nullable = true)
	private String progresso;
	
	@Column(length = 2000, nullable = true)
	private String risco;
	
	@Column(length = 2000, nullable = true)
	private String comunicacao;
	
	@Column(length = 2000, nullable = true)
	private String mudanca;
	
	@OneToOne
	@JoinColumn(name="projetoinicio", nullable = false)
	private ProjetoInicio projetoinicio = new ProjetoInicio();	
	
	public String getPlanogerenciamentoprojeto() {
		return planogerenciamentoprojeto;
	}
	public void setPlanogerenciamentoprojeto(String planogerenciamentoprojeto) {
		this.planogerenciamentoprojeto = planogerenciamentoprojeto;
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
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public String getLinhabase() {
		return linhabase;
	}
	public void setLinhabase(String linhabase) {
		this.linhabase = linhabase;
	}
	public String getOrganizacao() {
		return organizacao;
	}
	public void setOrganizacao(String organizacao) {
		this.organizacao = organizacao;
	}
	public String getCronograma() {
		return cronograma;
	}
	public void setCronograma(String cronograma) {
		this.cronograma = cronograma;
	}
	public String getProgresso() {
		return progresso;
	}
	public void setProgresso(String progresso) {
		this.progresso = progresso;
	}
	public String getRisco() {
		return risco;
	}
	public void setRisco(String risco) {
		this.risco = risco;
	}
	public String getComunicacao() {
		return comunicacao;
	}
	public void setComunicacao(String comunicacao) {
		this.comunicacao = comunicacao;
	}
	public String getMudanca() {
		return mudanca;
	}
	public void setMudanca(String mudanca) {
		this.mudanca = mudanca;
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

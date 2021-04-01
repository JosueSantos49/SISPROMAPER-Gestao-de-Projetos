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
@Table(name = "registrorisco")
public class RegistroRisco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(length = 150, nullable = false)
	private String registrorisco;
	
	@Column(length = 200, nullable = true)
	private String referencia;
	
	@Column(length = 1500, nullable = true)
	private String passos;
	
	@Column(length = 200, nullable = true)
	private String versao;
	
	private Date data;
	
	@Column(length = 200, nullable = true)
	private String autor;
	
	@Column(length = 200, nullable = true)
	private String notarevisao;
	
	@Column(length = 150, nullable = true)
	private Integer severidade;
	
	@Column(length = 1500, nullable = true)
	private String descricao;
	
	@Column(length = 150, nullable = true)
	private String probabilidade;
	
	@Column(length = 150, nullable = true)
	private String impacto;
	
	@Column(length = 1500, nullable = true)
	private String descricaoimpacto;
	
	@Column(length = 150, nullable = true)
	private String categoria;
	
	@Column(length = 150, nullable = true)
	private String acao;
	
	@Column(length = 1500, nullable = true)
	private String descricaoacao;
	
	@Column(length = 150, nullable = true)
	private String responsavel;
	
	@Column(length = 150, nullable = true)
	private String previsao;
	
	@Column(length = 1500, nullable = true)
	private String comentario;
	
	@ManyToOne
	@JoinColumn(name="projetoinicio", nullable = false)
	private ProjetoInicio projetoinicio = new ProjetoInicio();	
		
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
	public String getRegistrorisco() {
		return registrorisco;
	}
	public void setRegistrorisco(String registrorisco) {
		this.registrorisco = registrorisco;
	}
	
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getPassos() {
		return passos;
	}
	public void setPassos(String passos) {
		this.passos = passos;
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
	public Integer getSeveridade() {
		return severidade;
	}
	public void setSeveridade(Integer severidade) {
		this.severidade = severidade;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getProbabilidade() {
		return probabilidade;
	}
	public void setProbabilidade(String probabilidade) {
		this.probabilidade = probabilidade;
	}
	public String getImpacto() {
		return impacto;
	}
	public void setImpacto(String impacto) {
		this.impacto = impacto;
	}
	public String getDescricaoimpacto() {
		return descricaoimpacto;
	}
	public void setDescricaoimpacto(String descricaoimpacto) {
		this.descricaoimpacto = descricaoimpacto;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getAcao() {
		return acao;
	}
	public void setAcao(String acao) {
		this.acao = acao;
	}
	public String getDescricaoacao() {
		return descricaoacao;
	}
	public void setDescricaoacao(String descricaoacao) {
		this.descricaoacao = descricaoacao;
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
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
}

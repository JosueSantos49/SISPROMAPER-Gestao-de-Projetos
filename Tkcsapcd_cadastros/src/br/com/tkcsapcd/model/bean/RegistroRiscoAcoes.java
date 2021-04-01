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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "registroriscoacoes")
public class RegistroRiscoAcoes {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(length = 200, nullable = false)
	private String registroriscoacoes;
	
	@Column(length = 200, nullable = true)
	private String referencia;
	
	@Column(length = 1400, nullable = true)
	private String passos;
	
	@Column(length = 200, nullable = true)
	private String versao;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Column(length = 200, nullable = false)
	private String autor;
	
	@Column(length = 150, nullable = true)
	private String notarevisao;
	
	@Column(length = 150, nullable = true)
	private String prioridade;
	
	@Column(length = 1400, nullable = true)
	private String descricaorisco;
	
	@Column(length = 1400, nullable = true)
	private String descricaoacao; 
	
	@Column(length = 200, nullable = true)
	private String responsavel;
	
	@Column(length = 200, nullable = true)
	private String previsao;
	
	@Column(length = 200, nullable = true)
	private String status;
	
	@Column(length = 1400, nullable = true)
	private String previsaooriginal;
	
	@Column(length = 1400, nullable = true)
	private String comentario;
	
	@ManyToOne
	@JoinColumn(name="registrorisco", nullable = false)
	private RegistroRisco registrorisco = new RegistroRisco();
	
	public String getRegistroriscoacoes() {
		return registroriscoacoes;
	}
	public void setRegistroriscoacoes(String registroriscoacoes) {
		this.registroriscoacoes = registroriscoacoes;
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
	public String getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}
	public String getDescricaorisco() {
		return descricaorisco;
	}
	public void setDescricaorisco(String descricaorisco) {
		this.descricaorisco = descricaorisco;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPrevisaooriginal() {
		return previsaooriginal;
	}
	public void setPrevisaooriginal(String previsaooriginal) {
		this.previsaooriginal = previsaooriginal;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
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
	public RegistroRisco getRegistrorisco() {
		return registrorisco;
	}
	public void setRegistrorisco(RegistroRisco registrorisco) {
		this.registrorisco = registrorisco;
	}
	
	
}

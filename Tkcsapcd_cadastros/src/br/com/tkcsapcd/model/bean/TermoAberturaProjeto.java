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
@Table(name = "termoabertura")
public class TermoAberturaProjeto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(length = 150, nullable = false)
	private String termoaberturaprojeto;
		
	@Column(length = 150, nullable = true)
	private String versao;
	
	private Date data;
	
	@Column(length = 150, nullable = true)
	private String autor;
	
	@Column(length = 150, nullable = true)
	private String notarevisao;
	
	@Column(length = 2000, nullable = true)
	private String aprovacao;
	
	@Column(length = 2000, nullable = true)
	private String objetivo;
	
	@Column(length = 2000, nullable = true)
	private String justificativa;
	
	@Column(length = 2000, nullable = true)
	private String smart;
	
	@Column(length = 2000, nullable = true)
	private String eap;
	
	@Column(length = 2000, nullable = true)
	private String requisito;
	
	@Column(length = 2000, nullable = true)
	private String marco;
	
	@Column(length = 2000, nullable = true)
	private String parteinteressada;
	
	@Column(length = 2000, nullable = true)
	private String restricao;
	
	@Column(length = 2000, nullable = true)
	private String permissao;
	
	@Column(length = 2000, nullable = true)
	private String risco;
	
	@Column(length = 2000, nullable = true)
	private String orcamento;	
	
	@Column(length = 1, nullable = false)
	private String concordo;
		
	@ManyToOne
	@JoinColumn(name="projetoinicio", nullable = false)
	private ProjetoInicio projetoinicio = new ProjetoInicio();	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}	
	public ProjetoInicio getProjetoinicio() {
		return projetoinicio;
	}
	public void setProjetoinicio(ProjetoInicio projetoinicio) {
		this.projetoinicio = projetoinicio;
	}
	public String getConcordo() {
		return concordo;
	}
	public void setConcordo(String concordo) {
		this.concordo = concordo;
	}
	public String getTermoaberturaprojeto() {
		return termoaberturaprojeto;
	}
	public void setTermoaberturaprojeto(String termoaberturaprojeto) {
		this.termoaberturaprojeto = termoaberturaprojeto;
	}
	
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
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
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public String getJustificativa() {
		return justificativa;
	}
	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}
	public String getSmart() {
		return smart;
	}
	public void setSmart(String smart) {
		this.smart = smart;
	}
	public String getEap() {
		return eap;
	}
	public void setEap(String eap) {
		this.eap = eap;
	}
	public String getRequisito() {
		return requisito;
	}
	public void setRequisito(String requisito) {
		this.requisito = requisito;
	}
	public String getMarco() {
		return marco;
	}
	public void setMarco(String marco) {
		this.marco = marco;
	}
	public String getParteinteressada() {
		return parteinteressada;
	}
	public void setParteinteressada(String parteinteressada) {
		this.parteinteressada = parteinteressada;
	}
	public String getRestricao() {
		return restricao;
	}
	public void setRestricao(String restricao) {
		this.restricao = restricao;
	}
	public String getPermissao() {
		return permissao;
	}
	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}
	public String getRisco() {
		return risco;
	}
	public void setRisco(String risco) {
		this.risco = risco;
	}
	public String getOrcamento() {
		return orcamento;
	}
	public void setOrcamento(String orcamento) {
		this.orcamento = orcamento;
	}
	
}

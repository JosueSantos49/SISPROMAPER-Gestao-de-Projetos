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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="businesscase")
public class BusinessCase {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(length = 200, nullable = false)
	private String businesscase;
	
	@Column(length = 150, nullable = true)
	private String versao;
	
	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Column(length = 200, nullable = false)
	private String autor;
	
	@Column(length = 200, nullable = true)
	private String notarevisao;
	
	@Column(length = 2000, nullable = true)
	private String aprovacao;
	
	@Column(length = 2000, nullable = true)
	private String objetivodocumento;
	
	@Column(length = 2000, nullable = true)
	private String objetivo;
	
	@Column(length = 2000, nullable = true)
	private String necessidade;
	
	@Column(length = 2000, nullable = true)
	private String indicadores;
	
	@Column(length = 2000, nullable = true)
	private String previsao;
	
	@Column(length = 2000, nullable = true)
	private String organizacao;
	
	@Column(length = 2000, nullable = true)
	private String analise;
	
	@Column(length = 2000, nullable = true)
	private String partes;
	
	@Column(length = 2000, nullable = true)
	private String orcamento;
	
	@OneToOne
	@JoinColumn(name="projetoinicio", nullable = false)
	private ProjetoInicio projetoinicio = new ProjetoInicio();
			
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getBusinesscase() {
		return businesscase;
	}
	public void setBusinesscase(String businesscase) {
		this.businesscase = businesscase;
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
	public String getObjetivodocumento() {
		return objetivodocumento;
	}
	public void setObjetivodocumento(String objetivodocumento) {
		this.objetivodocumento = objetivodocumento;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public String getNecessidade() {
		return necessidade;
	}
	public void setNecessidade(String necessidade) {
		this.necessidade = necessidade;
	}
	public String getIndicadores() {
		return indicadores;
	}
	public void setIndicadores(String indicadores) {
		this.indicadores = indicadores;
	}
	public String getPrevisao() {
		return previsao;
	}
	public void setPrevisao(String previsao) {
		this.previsao = previsao;
	}
	public String getOrganizacao() {
		return organizacao;
	}
	public void setOrganizacao(String organizacao) {
		this.organizacao = organizacao;
	}
	public String getAnalise() {
		return analise;
	}
	public void setAnalise(String analise) {
		this.analise = analise;
	}
	public String getPartes() {
		return partes;
	}
	public void setPartes(String partes) {
		this.partes = partes;
	}
	public String getOrcamento() {
		return orcamento;
	}
	public void setOrcamento(String orcamento) {
		this.orcamento = orcamento;
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

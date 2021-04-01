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
@Table (name="planogerenciamentorequisito")
public class PlanoGerenciamentoRequisito {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(length = 150, nullable = false)
	private String planogerenciamentorequisito;
	
	@Column(length = 150, nullable = true)
	private String versao;	
	
	private Date data;
	
	@Column(length = 150, nullable = true)
	private String autor;
	
	@Column(length = 150, nullable = true)
	private String notarevisao;
	
	@Column(length = 150, nullable = true)
	private String aprovacao;
	
	@Column(length = 2000, nullable = true)
	private String objetivo;
	
	@Column(length = 2000, nullable = true)
	private String gerenciamento;
	
	@Column(length = 2000, nullable = true)
	private String processo;
	
	@Column(length = 2000, nullable = true)
	private String documento;
	
	@Column(length = 2000, nullable = true)
	private String responsabilidade;
	
	@Column(length = 2000, nullable = true)
	private String configuracao;
	
	@Column(length = 2000, nullable = true)
	private String prioridade;
	
	@Column(length = 2000, nullable = true)
	private String coleta;
	
	@Column(length = 2000, nullable = true)
	private String ratreabilidade;
	
	@Column(length = 2000, nullable = true)
	private String metrica;
	
	@OneToOne
	@JoinColumn(name="projetoinicio", nullable = false)
	private ProjetoInicio projetoinicio = new ProjetoInicio();	
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getPlanogerenciamentorequisito() {
		return planogerenciamentorequisito;
	}
	public void setPlanogerenciamentorequisito(String planogerenciamentorequisito) {
		this.planogerenciamentorequisito = planogerenciamentorequisito;
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
	public ProjetoInicio getProjetoinicio() {
		return projetoinicio;
	}
	public void setProjetoinicio(ProjetoInicio projetoinicio) {
		this.projetoinicio = projetoinicio;
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
	public String getGerenciamento() {
		return gerenciamento;
	}
	public void setGerenciamento(String gerenciamento) {
		this.gerenciamento = gerenciamento;
	}
	public String getProcesso() {
		return processo;
	}
	public void setProcesso(String processo) {
		this.processo = processo;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getResponsabilidade() {
		return responsabilidade;
	}
	public void setResponsabilidade(String responsabilidade) {
		this.responsabilidade = responsabilidade;
	}
	public String getConfiguracao() {
		return configuracao;
	}
	public void setConfiguracao(String configuracao) {
		this.configuracao = configuracao;
	}
	public String getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}
	public String getColeta() {
		return coleta;
	}
	public void setColeta(String coleta) {
		this.coleta = coleta;
	}
	public String getRatreabilidade() {
		return ratreabilidade;
	}
	public void setRatreabilidade(String ratreabilidade) {
		this.ratreabilidade = ratreabilidade;
	}
	public String getMetrica() {
		return metrica;
	}
	public void setMetrica(String metrica) {
		this.metrica = metrica;
	}

	
}

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
@Table(name = "planogerenciamentocronograma")
public class PlanoGerenciamentoCronograma {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(length = 200, nullable = false)
	private String planogerenciamentocronograma;
		
	@Column(length = 150, nullable = true)
	private String versao;
	
	private Date data;
	
	@Column(length = 150, nullable = false)
	private String autor;
	
	@Column(length = 150, nullable = true)
	private String notarevisao;
	
	@Column(length = 300, nullable = true)
	private String aprovacao;
	
	@Column(length = 550, nullable = true)
	private String objetivo;
	
	@Column(length = 550, nullable = true)
	private String metodo;
	
	@Column(length = 550, nullable = true)
	private String processo;
	
	@Column(length = 550, nullable = true)
	private String documento;
	
	@Column(length = 550, nullable = true)
	private String ferramenta;
	
	@Column(length = 550, nullable = true)
	private String papeis;
	
	@Column(length = 550, nullable = true)
	private String plano;
	
	@Column(length = 550, nullable = true)
	private String atividade;
	
	@Column(length = 550, nullable = true)
	private String sequenciar;
	
	@Column(length = 550, nullable = true)
	private String estimarrecuso;
	
	@Column(length = 550, nullable = true)
	private String estimarduracao;
	
	@Column(length = 550, nullable = true)
	private String desenvolver;
	
	@Column(length = 550, nullable = true)
	private String controlar;
	
	@ManyToOne
	@JoinColumn(name="projetoinicio", nullable = false)
	private ProjetoInicio projetoinicio = new ProjetoInicio();
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getPlanogerenciamentocronograma() {
		return planogerenciamentocronograma;
	}
	public void setPlanogerenciamentocronograma(String planogerenciamentocronograma) {
		this.planogerenciamentocronograma = planogerenciamentocronograma;
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
	public String getMetodo() {
		return metodo;
	}
	public void setMetodo(String metodo) {
		this.metodo = metodo;
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
	public String getFerramenta() {
		return ferramenta;
	}
	public void setFerramenta(String ferramenta) {
		this.ferramenta = ferramenta;
	}
	public String getPapeis() {
		return papeis;
	}
	public void setPapeis(String papeis) {
		this.papeis = papeis;
	}
	public String getPlano() {
		return plano;
	}
	public void setPlano(String plano) {
		this.plano = plano;
	}
	public String getAtividade() {
		return atividade;
	}
	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}
	public String getSequenciar() {
		return sequenciar;
	}
	public void setSequenciar(String sequenciar) {
		this.sequenciar = sequenciar;
	}
	public String getEstimarrecuso() {
		return estimarrecuso;
	}
	public void setEstimarrecuso(String estimarrecuso) {
		this.estimarrecuso = estimarrecuso;
	}
	public String getEstimarduracao() {
		return estimarduracao;
	}
	public void setEstimarduracao(String estimarduracao) {
		this.estimarduracao = estimarduracao;
	}
	public String getDesenvolver() {
		return desenvolver;
	}
	public void setDesenvolver(String desenvolver) {
		this.desenvolver = desenvolver;
	}
	public String getControlar() {
		return controlar;
	}
	public void setControlar(String controlar) {
		this.controlar = controlar;
	}
	
	
}

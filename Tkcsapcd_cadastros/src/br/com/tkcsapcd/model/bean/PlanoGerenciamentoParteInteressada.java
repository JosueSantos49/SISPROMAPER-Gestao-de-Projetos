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
@Table(name = "planogerenciamentoparteinteressada")
public class PlanoGerenciamentoParteInteressada {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(length = 200, nullable = false)
	private String planogerenciamentointeressada;
	
	@Column(length = 150, nullable = true)
	private String versao;
	
	private Date data;
	
	@Column(length = 200, nullable = true)
	private String autor;
	
	@Column(length = 150, nullable = true)
	private String notarevisao;
	
	@Column(length = 1000, nullable = true)
	private String aprovacao;
	
	@Column(length = 1000, nullable = true)
	private String objetivo;
	
	@Column(length = 1000, nullable = true)
	private String processo;
	
	@Column(length = 1000, nullable = true)
	private String parteinteressada;
	
	@Column(length = 1000, nullable = true)
	private String gerenciarparte;
	
	@Column(length = 1000, nullable = true)
	private String controlaparte;
	
	@Column(length = 1000, nullable = true)
	private String anexo;
	
	@ManyToOne
	@JoinColumn(name="projetoinicio", nullable = false)
	private ProjetoInicio projetoinicio = new ProjetoInicio();
		
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
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
	public String getPlanogerenciamentointeressada() {
		return planogerenciamentointeressada;
	}
	public void setPlanogerenciamentointeressada(
			String planogerenciamentointeressada) {
		this.planogerenciamentointeressada = planogerenciamentointeressada;
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
	public String getProcesso() {
		return processo;
	}
	public void setProcesso(String processo) {
		this.processo = processo;
	}
	public String getParteinteressada() {
		return parteinteressada;
	}
	public void setParteinteressada(String parteinteressada) {
		this.parteinteressada = parteinteressada;
	}
	public String getGerenciarparte() {
		return gerenciarparte;
	}
	public void setGerenciarparte(String gerenciarparte) {
		this.gerenciarparte = gerenciarparte;
	}
	public String getControlaparte() {
		return controlaparte;
	}
	public void setControlaparte(String controlaparte) {
		this.controlaparte = controlaparte;
	}
	public String getAnexo() {
		return anexo;
	}
	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}
	
	
	
}

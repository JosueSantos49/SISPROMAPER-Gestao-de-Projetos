/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "registroparteinteressada")
public class RegistroParteInteressada {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(length = 200, nullable = false)
	private String registroparteinteressada;
	
	@Column(length = 150, nullable = true)
	private String versao;
	
	@Column(length = 20, nullable = true)
	private String data;
	
	@Column(length = 150, nullable = true)
	private String autor;
	
	@Column(length = 150, nullable = true)
	private String notarevisao;
	
	@Column(length = 2000, nullable = true)
	private String aprovacao;
	
	private Integer codigoparteinteressada;
	
	@Column(length = 2000, nullable = true)
	private Integer importancia;
	
	@Column(length = 2000, nullable = true)
	private String parteinteressada;
	
	@Column(length = 2000, nullable = true)
	private String empresa;
	
	@Column(length = 2000, nullable = true)
	private String funcaoprojeto;
	
	@Column(length = 150, nullable = true)
	private String email;
	
	@Column(length = 30, nullable = true)
	private String celular;
	
	@Column(length = 30, nullable = true)
	private String fone;
	
	@Column(length = 2000, nullable = true)
	private String requisito;
	
	@Column(length = 2000, nullable = true)
	private String responsabilidade;
	
	@Column(length = 2000, nullable = true)
	private String expectativas;
	
	@Column(length = 2000, nullable = true)
	private String poder;
	
	@Column(length = 2000, nullable = true)
	private String interesse;
	
	@Column(length = 2000, nullable = true)
	private String comentario;
	
	@ManyToOne
	@JoinColumn(name="projetoinicio", nullable = false)
	private ProjetoInicio projetoinicio = new ProjetoInicio();	
	
	public String getRegistroparteinteressada() {
		return registroparteinteressada;
	}
	public void setRegistroparteinteressada(String registroparteinteressada) {
		this.registroparteinteressada = registroparteinteressada;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
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
	public Integer getCodigoparteinteressada() {
		return codigoparteinteressada;
	}
	public void setCodigoparteinteressada(Integer codigoparteinteressada) {
		this.codigoparteinteressada = codigoparteinteressada;
	}
	public Integer getImportancia() {
		return importancia;
	}
	public void setImportancia(Integer importancia) {
		this.importancia = importancia;
	}
	public String getParteinteressada() {
		return parteinteressada;
	}
	public void setParteinteressada(String parteinteressada) {
		this.parteinteressada = parteinteressada;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getFuncaoprojeto() {
		return funcaoprojeto;
	}
	public void setFuncaoprojeto(String funcaoprojeto) {
		this.funcaoprojeto = funcaoprojeto;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getRequisito() {
		return requisito;
	}
	public void setRequisito(String requisito) {
		this.requisito = requisito;
	}
	public String getResponsabilidade() {
		return responsabilidade;
	}
	public void setResponsabilidade(String responsabilidade) {
		this.responsabilidade = responsabilidade;
	}
	public String getExpectativas() {
		return expectativas;
	}
	public void setExpectativas(String expectativas) {
		this.expectativas = expectativas;
	}
	public String getPoder() {
		return poder;
	}
	public void setPoder(String poder) {
		this.poder = poder;
	}
	public String getInteresse() {
		return interesse;
	}
	public void setInteresse(String interesse) {
		this.interesse = interesse;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public ProjetoInicio getProjetoinicio() {
		return projetoinicio;
	}
	public void setProjetoinicio(ProjetoInicio projetoinicio) {
		this.projetoinicio = projetoinicio;
	}
	
	
	
}

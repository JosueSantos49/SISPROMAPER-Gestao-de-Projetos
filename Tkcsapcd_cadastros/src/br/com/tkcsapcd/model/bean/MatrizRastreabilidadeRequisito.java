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
import javax.persistence.Table;

@Entity
@Table(name = "matrizrastreabilidaderequisito")
public class MatrizRastreabilidadeRequisito {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private Integer codigomatriz;
	
	@Column(length = 150, nullable = false)
	private String prioridade;
	
	@Column(length = 150, nullable = false)
	private String tipo;
	
	@Column(length = 200, nullable = false)
	private String nome;
	
	@Column(length = 1400, nullable = false)
	private String descricao;
	
	@Column(length = 1400, nullable = false)
	private String justificativa; 
	
	@Column(length = 1400, nullable = false)
	private String criterio;
	
	@Column(length = 150, nullable = false)
	private String solicitante;
	
	@Column(length = 150, nullable = false)
	private String status;
	
	private Date data;
	
	@Column(length = 1400, nullable = false)
	private String eap;
	
	private Integer id;
	
	@Column(length = 1400, nullable = false)
	private String comentario;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Integer getCodigomatriz() {
		return codigomatriz;
	}
	public void setCodigomatriz(Integer codigomatriz) {
		this.codigomatriz = codigomatriz;
	}
	public String getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public String getCriterio() {
		return criterio;
	}
	public void setCriterio(String criterio) {
		this.criterio = criterio;
	}
	public String getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getEap() {
		return eap;
	}
	public void setEap(String eap) {
		this.eap = eap;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
}

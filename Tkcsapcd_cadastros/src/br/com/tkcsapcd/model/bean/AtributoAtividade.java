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
@Table(name = "atributoatividade")
public class AtributoAtividade {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private Long id;
		
	@Column(length = 980, nullable = true)
	private String descricao; 
	
	@Column(length = 980, nullable = true)
	private String predecessora;
	
	@Column(length = 980, nullable = true)
	private String sucessora;
	
	@Column(length = 980, nullable = true)
	private String relacionamento;
	
	@Column(length = 980, nullable = true)
	private String antecipacao;
	
	@Column(length = 980, nullable = true)
	private String recurso;
	
	@Column(length = 980, nullable = true)
	private String data;
	
	@Column(length = 150, nullable = true)
	private String responsavel;
	
	@Column(length = 980, nullable = true)
	private String areageografica;	
	
	@ManyToOne
	@JoinColumn(name="organograma", nullable = false)
	private Organograma organograma = new Organograma();	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	
	public Organograma getOrganograma() {
		return organograma;
	}
	public void setOrganograma(Organograma organograma) {
		this.organograma = organograma;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPredecessora() {
		return predecessora;
	}
	public void setPredecessora(String predecessora) {
		this.predecessora = predecessora;
	}
	public String getSucessora() {
		return sucessora;
	}
	public void setSucessora(String sucessora) {
		this.sucessora = sucessora;
	}
	public String getRelacionamento() {
		return relacionamento;
	}
	public void setRelacionamento(String relacionamento) {
		this.relacionamento = relacionamento;
	}
	public String getAntecipacao() {
		return antecipacao;
	}
	public void setAntecipacao(String antecipacao) {
		this.antecipacao = antecipacao;
	}
	public String getRecurso() {
		return recurso;
	}
	public void setRecurso(String recurso) {
		this.recurso = recurso;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	
	public String getAreageografica() {
		return areageografica;
	}
	public void setAreageografica(String areageografica) {
		this.areageografica = areageografica;
	}	
	
}

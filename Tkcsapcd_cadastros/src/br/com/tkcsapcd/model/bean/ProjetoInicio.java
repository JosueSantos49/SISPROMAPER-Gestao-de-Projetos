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
@Table(name = "projetoinicio")
public class ProjetoInicio {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long codigo;
		
	private Integer codigoprojeto;//Alterar para Long
	
	@Column(length = 150, nullable = false)
	private String projeto;
		
	private Date data;
	
	@Column(length = 150, nullable = true)
	private String atribuiprojeto;
	
	@Column(length = 150, nullable = true)
	private String tipoprojeto;
	
	@Column(length = 2000, nullable = true)
	private String objetivo;
	
	@Column(length = 150, nullable = true)
	private String cliente;
	
	@Column(length = 2000, nullable = true)
	private String programa;	
	
	@Column(length = 300, nullable = true)
	private String area;	
	
	private Double roi;
	
	@Column(length = 2000, nullable = true)
	private String descricao;
		
	private String copia;
			
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Integer getCodigoprojeto() {
		return codigoprojeto;
	}
	public void setCodigoprojeto(Integer codigoprojeto) {
		this.codigoprojeto = codigoprojeto;
	}
		
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getAtribuiprojeto() {
		return atribuiprojeto;
	}
	public void setAtribuiprojeto(String atribuiprojeto) {
		this.atribuiprojeto = atribuiprojeto;
	}
	public String getTipoprojeto() {
		return tipoprojeto;
	}
	public void setTipoprojeto(String tipoprojeto) {
		this.tipoprojeto = tipoprojeto;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getPrograma() {
		return programa;
	}
	public void setPrograma(String programa) {
		this.programa = programa;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Double getRoi() {
		return roi;
	}
	public void setRoi(Double roi) {
		this.roi = roi;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getProjeto() {
		return projeto;
	}
	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}

	public String getCopia() {
		return copia;
	}

	public void setCopia(String copia) {
		this.copia = copia;
	}
	
	
}

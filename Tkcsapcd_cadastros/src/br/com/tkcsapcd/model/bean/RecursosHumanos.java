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
import javax.persistence.Table;

@Entity
@Table(name = "recursoshumanos")
public class RecursosHumanos {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;	
	
	@Column(length = 15, nullable = false)
	private String idRecursosHumanos;
	
	@Column(length = 150, nullable = false)
	private String nome;
	
	@Column(length = 150, nullable = false)
	private String profissao;
	
	@Column(length = 150, nullable = false)
	private String area;
	
	@Column(length = 150, nullable = false)
	private String status;	
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	public String getIdRecursosHumanos() {
		return idRecursosHumanos;
	}
	public void setIdRecursosHumanos(String idRecursosHumanos) {
		this.idRecursosHumanos = idRecursosHumanos;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}

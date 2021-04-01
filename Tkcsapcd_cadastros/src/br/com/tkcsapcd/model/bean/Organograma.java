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
@Table (name="organograma")
public class Organograma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private Date data;
	
	@Column(length = 800, nullable = true)
	private String comentario;
	
	@Column(length = 4000, nullable = false)
	private String mySavedModel;
	
	@Column(length = 200, nullable = false)
	private String descricao;
	
	@OneToOne
	@JoinColumn(name="projetoinicio", nullable = false)
	private ProjetoInicio projetoinicio = new ProjetoInicio();

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getMySavedModel() {
		return mySavedModel;
	}

	public void setMySavedModel(String mySavedModel) {
		this.mySavedModel = mySavedModel;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ProjetoInicio getProjetoinicio() {
		return projetoinicio;
	}

	public void setProjetoinicio(ProjetoInicio projetoinicio) {
		this.projetoinicio = projetoinicio;
	}		
		
		
}

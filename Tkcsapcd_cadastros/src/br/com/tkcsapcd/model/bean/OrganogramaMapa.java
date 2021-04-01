/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.bean;

import java.util.Date;

public class OrganogramaMapa {

	private Integer codigo;
	private Integer codigoprojeto;
	private Date data;
	private String comentario;
	private String mySavedModel;
	private String descricao;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
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
	
	
}

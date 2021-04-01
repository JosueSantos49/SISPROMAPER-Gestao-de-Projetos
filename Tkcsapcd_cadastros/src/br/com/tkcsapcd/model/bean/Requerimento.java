/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.bean;

public class Requerimento {
	
	private Integer codigo;
	private String nome;
	private String descricao;
	private String resumo;
	private String rqfuncional;
	private String rqtecnologico;
	private String rqstatus;
	private String concordo;
	
	public String getConcordo() {
		return concordo;
	}
	public void setConcordo(String concordo) {
		this.concordo = concordo;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public String getRqfuncional() {
		return rqfuncional;
	}
	public void setRqfuncional(String rqfuncional) {
		this.rqfuncional = rqfuncional;
	}
	public String getRqtecnologico() {
		return rqtecnologico;
	}
	public void setRqtecnologico(String rqtecnologico) {
		this.rqtecnologico = rqtecnologico;
	}
	public String getRqstatus() {
		return rqstatus;
	}
	public void setRqstatus(String rqstatus) {
		this.rqstatus = rqstatus;
	}
	
	
}

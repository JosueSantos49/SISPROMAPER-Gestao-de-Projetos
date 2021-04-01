/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.bean;


public class Statuss {
	
	private Integer codigo;
	private String fase;
	private double percentualevolucao;
	private double percentualplanejado;
	private String datastatus;
	private String descricao;
	private String pontospositivos;
	private String pontosnegativos;
	private String tendencia;
	private String datainicio;	
	private String datafim;
	private String Projeto;
	private Integer codigodoprojeto;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getFase() {
		return fase;
	}
	public void setFase(String fase) {
		this.fase = fase;
	}
	public double getPercentualevolucao() {
		return percentualevolucao;
	}
	public void setPercentualevolucao(double percentualevolucao) {
		this.percentualevolucao = percentualevolucao;
	}
	public double getPercentualplanejado() {
		return percentualplanejado;
	}
	public void setPercentualplanejado(double percentualplanejado) {
		this.percentualplanejado = percentualplanejado;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPontospositivos() {
		return pontospositivos;
	}
	public void setPontospositivos(String pontospositivos) {
		this.pontospositivos = pontospositivos;
	}
	public String getPontosnegativos() {
		return pontosnegativos;
	}
	public void setPontosnegativos(String pontosnegativos) {
		this.pontosnegativos = pontosnegativos;
	}
	public String getTendencia() {
		return tendencia;
	}
	public void setTendencia(String tendencia) {
		this.tendencia = tendencia;
	}
	/*
	public Date getDatainicio() {
		return datainicio;
	}
	public void setDatainicio(Date datainicio) {
		this.datainicio = datainicio;
	}
	public Date getDatafim() {
		return datafim;
	}
	public void setDatafim(Date datafim) {
		this.datafim = datafim;
	}
	*/
	public String getDatastatus() {
		return datastatus;
	}
	public void setDatastatus(String datastatus) {
		this.datastatus = datastatus;
	}
	public String getDatainicio() {
		return datainicio;
	}
	public void setDatainicio(String datainicio) {
		this.datainicio = datainicio;
	}
	public String getDatafim() {
		return datafim;
	}
	public void setDatafim(String datafim) {
		this.datafim = datafim;
	}
	public String getProjeto() {
		return Projeto;
	}
	public void setProjeto(String projeto) {
		Projeto = projeto;
	}
	public Integer getCodigodoprojeto() {
		return codigodoprojeto;
	}
	public void setCodigodoprojeto(Integer codigodoprojeto) {
		this.codigodoprojeto = codigodoprojeto;
	}
	
	
}

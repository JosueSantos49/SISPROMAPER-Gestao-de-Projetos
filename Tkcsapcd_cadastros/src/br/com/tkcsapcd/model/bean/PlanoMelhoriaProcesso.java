/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.bean;

public class PlanoMelhoriaProcesso {

	private Integer codigo;
	private String planomelhoriaprocesso;
	private String projeto;
	private Integer codigoprojeto;
	private String versao;
	private String data;
	private String autor;
	private String notarevisao;
	private String objetivo;
	private String limite;
	private String configuracao;
	private String metrica;
	private String meta;
	private String aprovacao;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getPlanomelhoriaprocesso() {
		return planomelhoriaprocesso;
	}
	public void setPlanomelhoriaprocesso(String planomelhoriaprocesso) {
		this.planomelhoriaprocesso = planomelhoriaprocesso;
	}
	public String getProjeto() {
		return projeto;
	}
	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}
	
	public Integer getCodigoprojeto() {
		return codigoprojeto;
	}
	public void setCodigoprojeto(Integer codigoprojeto) {
		this.codigoprojeto = codigoprojeto;
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
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public String getLimite() {
		return limite;
	}
	public void setLimite(String limite) {
		this.limite = limite;
	}
	public String getConfiguracao() {
		return configuracao;
	}
	public void setConfiguracao(String configuracao) {
		this.configuracao = configuracao;
	}
	public String getMetrica() {
		return metrica;
	}
	public void setMetrica(String metrica) {
		this.metrica = metrica;
	}
	public String getMeta() {
		return meta;
	}
	public void setMeta(String meta) {
		this.meta = meta;
	}
	public String getAprovacao() {
		return aprovacao;
	}
	public void setAprovacao(String aprovacao) {
		this.aprovacao = aprovacao;
	}
	
	
}

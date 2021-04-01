/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.bean;

public class DecisoesComprar {

	private Integer codigo;
	private Integer importancia;
	private Integer codigoeap;
	private String itens;
	private String urgencia;
	private String impacto;
	private String motivodecisao;
	private String fornecedores;
	private Integer quantidade;
	private double custo;
	private String previsao;
	private String docaquisicao;
	private String descricao;
	private String tipocontrato;
	private String status;
	private String comentarios;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Integer getImportancia() {
		return importancia;
	}
	public void setImportancia(Integer importancia) {
		this.importancia = importancia;
	}
	public Integer getCodigoeap() {
		return codigoeap;
	}
	public void setCodigoeap(Integer codigoeap) {
		this.codigoeap = codigoeap;
	}
	public String getItens() {
		return itens;
	}
	public void setItens(String itens) {
		this.itens = itens;
	}
	public String getUrgencia() {
		return urgencia;
	}
	public void setUrgencia(String urgencia) {
		this.urgencia = urgencia;
	}
	public String getImpacto() {
		return impacto;
	}
	public void setImpacto(String impacto) {
		this.impacto = impacto;
	}
	public String getMotivodecisao() {
		return motivodecisao;
	}
	public void setMotivodecisao(String motivodecisao) {
		this.motivodecisao = motivodecisao;
	}
	public String getFornecedores() {
		return fornecedores;
	}
	public void setFornecedores(String fornecedores) {
		this.fornecedores = fornecedores;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public double getCusto() {
		return custo;
	}
	public void setCusto(double custo) {
		this.custo = custo;
	}
	public String getPrevisao() {
		return previsao;
	}
	public void setPrevisao(String previsao) {
		this.previsao = previsao;
	}
	public String getDocaquisicao() {
		return docaquisicao;
	}
	public void setDocaquisicao(String docaquisicao) {
		this.docaquisicao = docaquisicao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTipocontrato() {
		return tipocontrato;
	}
	public void setTipocontrato(String tipocontrato) {
		this.tipocontrato = tipocontrato;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
}

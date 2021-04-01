/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.bean;

public class CriterioFornecedor {

	private Integer codigo;
	private String fonecedor;
	private Integer cnpj;
	private String fgts;
	private String inss;
	private String serasa;
	private double faturamento;
	private Integer funcionario;
	private Integer ano;
	private double ativo;
	private String experiencia;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getFonecedor() {
		return fonecedor;
	}
	public void setFonecedor(String fonecedor) {
		this.fonecedor = fonecedor;
	}
	public Integer getCnpj() {
		return cnpj;
	}
	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}
	public String getFgts() {
		return fgts;
	}
	public void setFgts(String fgts) {
		this.fgts = fgts;
	}
	public String getInss() {
		return inss;
	}
	public void setInss(String inss) {
		this.inss = inss;
	}
	public String getSerasa() {
		return serasa;
	}
	public void setSerasa(String serasa) {
		this.serasa = serasa;
	}
	public double getFaturamento() {
		return faturamento;
	}
	public void setFaturamento(double faturamento) {
		this.faturamento = faturamento;
	}
	public Integer getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Integer funcionario) {
		this.funcionario = funcionario;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public double getAtivo() {
		return ativo;
	}
	public void setAtivo(double ativo) {
		this.ativo = ativo;
	}
	public String getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}
}

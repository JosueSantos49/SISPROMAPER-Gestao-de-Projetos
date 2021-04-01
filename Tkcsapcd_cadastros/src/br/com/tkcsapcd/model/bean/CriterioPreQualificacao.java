/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.bean;

public class CriterioPreQualificacao {

	private Integer codigo;
	private String rfp;
	private String objetivo;
	private String projeto;
	private Integer codigoprojeto;
	private String gp;
	private String patrocinador;
	private String area;
	private String participante;
	private String aprovado;
	private String reprovado;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getRfp() {
		return rfp;
	}
	public void setRfp(String rfp) {
		this.rfp = rfp;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public String getProjeto() {
		return projeto;
	}
	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}
	public String getGp() {
		return gp;
	}
	public void setGp(String gp) {
		this.gp = gp;
	}
	public String getPatrocinador() {
		return patrocinador;
	}
	public void setPatrocinador(String patrocinador) {
		this.patrocinador = patrocinador;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getParticipante() {
		return participante;
	}
	public void setParticipante(String participante) {
		this.participante = participante;
	}
	public String getAprovado() {
		return aprovado;
	}
	public void setAprovado(String aprovado) {
		this.aprovado = aprovado;
	}
	public Integer getCodigoprojeto() {
		return codigoprojeto;
	}
	public void setCodigoprojeto(Integer codigoprojeto) {
		this.codigoprojeto = codigoprojeto;
	}
	public String getReprovado() {
		return reprovado;
	}
	public void setReprovado(String reprovado) {
		this.reprovado = reprovado;
	}
}

/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.bean;

public class Metricas {

	private Integer codigo;
	private String idMetricas;
	private String nomeMetrica;
	private String indiceMetrica;
	private String valorReferenciaHora;
	private String valorHoraCalculadaDia;
	
	public String getIdMetricas() {
		return idMetricas;
	}
	public void setIdMetricas(String idMetricas) {
		this.idMetricas = idMetricas;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNomeMetrica() {
		return nomeMetrica;
	}
	public void setNomeMetrica(String nomeMetrica) {
		this.nomeMetrica = nomeMetrica;
	}
	public String getIndiceMetrica() {
		return indiceMetrica;
	}
	public void setIndiceMetrica(String indiceMetrica) {
		this.indiceMetrica = indiceMetrica;
	}
	public String getValorReferenciaHora() {
		return valorReferenciaHora;
	}
	public void setValorReferenciaHora(String valorReferenciaHora) {
		this.valorReferenciaHora = valorReferenciaHora;
	}
	public String getValorHoraCalculadaDia() {
		return valorHoraCalculadaDia;
	}
	public void setValorHoraCalculadaDia(String valorHoraCalculadaDia) {
		this.valorHoraCalculadaDia = valorHoraCalculadaDia;
	}
	
	
}

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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "atareuniao")
public class AtaReuniao {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(length = 100, nullable = false)
	private String ata;
		
	private Date data;
	
	@Column(length = 100, nullable = false)
	private String local;
		
	@Column(length = 1210, nullable = true)
	private String participante;
	
	@Column(length = 1210, nullable = true)
	private String objetivo;
	
	@Column(length = 1210, nullable = true)
	private String topico;
	
	@Column(length = 1210, nullable = true)
	private String acoestomadas;
	
	@Column(length = 1210, nullable = true)
	private String proximareuniao;
	
	@Column(length = 1210, nullable = true)
	private String adicionais;
	
	@Column(length = 200, nullable = false)
	private String aprovacao;
	
	private Long versao;
	
	@ManyToOne
	@JoinColumn(name="projetoinicio", nullable = false)
	private ProjetoInicio projetoinicio = new ProjetoInicio();	
	
	public String getAta() {
		return ata;
	}
	public void setAta(String ata) {
		this.ata = ata;
	}	
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getParticipante() {
		return participante;
	}
	public void setParticipante(String participante) {
		this.participante = participante;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public String getTopico() {
		return topico;
	}
	public void setTopico(String topico) {
		this.topico = topico;
	}
	public String getAcoestomadas() {
		return acoestomadas;
	}
	public void setAcoestomadas(String acoestomadas) {
		this.acoestomadas = acoestomadas;
	}
	public String getProximareuniao() {
		return proximareuniao;
	}
	public void setProximareuniao(String proximareuniao) {
		this.proximareuniao = proximareuniao;
	}
	public String getAdicionais() {
		return adicionais;
	}
	public void setAdicionais(String adicionais) {
		this.adicionais = adicionais;
	}
	public String getAprovacao() {
		return aprovacao;
	}
	public void setAprovacao(String aprovacao) {
		this.aprovacao = aprovacao;
	}
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
	public ProjetoInicio getProjetoinicio() {
		return projetoinicio;
	}
	public void setProjetoinicio(ProjetoInicio projetoinicio) {
		this.projetoinicio = projetoinicio;
	}
	public Long getVersao() {
		return versao;
	}
	public void setVersao(Long versao) {
		this.versao = versao;
	}
	
	
}

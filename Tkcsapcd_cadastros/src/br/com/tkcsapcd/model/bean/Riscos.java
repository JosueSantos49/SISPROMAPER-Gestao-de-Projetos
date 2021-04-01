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
@Table(name = "riscos")
public class Riscos {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(length = 200, nullable = false)
	private String empresa;
	
	@Column(length = 200, nullable = false)
	private String orgao;
	
	@Column(length = 200, nullable = false)
	private String setor;
	
	@Column(length = 200, nullable = false)
	private String programa;
	
	@Column(length = 200, nullable = false)
	private String gerente;
	
	@Column(length = 200, nullable = false)
	private String funcao;
	
	@Column(length = 200, nullable = false)
	private String aprovado;
	
	@Column(length = 150, nullable = true)
	private String versao;	
	
	private Date dataaprovacao;
	
	@Column(length = 1700, nullable = true)
	private String etapa1;
	
	@Column(length = 1700, nullable = true)
	private String etapa2;
	
	@Column(length = 1700, nullable = true)
	private String etapa3;
	
	@Column(length = 1700, nullable = true)
	private String etapa4;
	
	@ManyToOne
	@JoinColumn(name="projetoinicio", nullable = false)
	private ProjetoInicio projetoinicio = new ProjetoInicio();	
	
		
	public ProjetoInicio getProjetoinicio() {
		return projetoinicio;
	}
	public void setProjetoinicio(ProjetoInicio projetoinicio) {
		this.projetoinicio = projetoinicio;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getOrgao() {
		return orgao;
	}
	public void setOrgao(String orgao) {
		this.orgao = orgao;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public String getPrograma() {
		return programa;
	}
	public void setPrograma(String programa) {
		this.programa = programa;
	}
	
	public String getGerente() {
		return gerente;
	}
	public void setGerente(String gerente) {
		this.gerente = gerente;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public String getAprovado() {
		return aprovado;
	}
	public void setAprovado(String aprovado) {
		this.aprovado = aprovado;
	}
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	
	public String getEtapa1() {
		return etapa1;
	}
	public void setEtapa1(String etapa1) {
		this.etapa1 = etapa1;
	}
	public String getEtapa2() {
		return etapa2;
	}
	public void setEtapa2(String etapa2) {
		this.etapa2 = etapa2;
	}
	public String getEtapa3() {
		return etapa3;
	}
	public void setEtapa3(String etapa3) {
		this.etapa3 = etapa3;
	}
	public String getEtapa4() {
		return etapa4;
	}
	public void setEtapa4(String etapa4) {
		this.etapa4 = etapa4;
	}
	public Date getDataaprovacao() {
		return dataaprovacao;
	}
	public void setDataaprovacao(Date dataaprovacao) {
		this.dataaprovacao = dataaprovacao;
	}
}

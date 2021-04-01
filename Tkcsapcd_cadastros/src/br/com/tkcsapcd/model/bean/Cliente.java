/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(length = 200, nullable = false)
	private String nome;
	
	@Column(length = 1, nullable = false)
	private String sexo;
	
	@Column(length = 10, nullable = false) 
	private String nascimento; 
	
	@Column(length = 150, nullable = true)
	private String profissao;
	
	@Column(length = 150, nullable = true)
	private String renda;	
	
	@Column(length = 12, nullable = true)
	private String rg;
	
	@Column(length = 150, nullable = true)
	private String orgaorg;	
	
	@Column(length = 13, nullable = true)
	private String fone;
	
	@Column(length = 14, nullable = true)
	private String celular;
	
	@Column(length = 200, nullable = true)
	private String endereco;
	
	@Column(length = 150, nullable = true)
	private String bairro;
	
	@Column(length = 150, nullable = true)
	private String estado;
	
	@Column(length = 150, nullable = true)
	private String cidade;
	
	@Column(length = 9, nullable = true)
	private String cep;
	
	@Column(length = 14, nullable = true)
	private String cpf;
	
	@Column(length = 18, nullable = true)
	private String cnpj;	
	
	@Column(length = 150, nullable = true)
	private String insest;	
	
	@Column(length = 10, nullable = true)
	private String desde;
	
	@Column(length = 150, nullable = true)
	private String email;
	
	@Column(length = 150, nullable = true)
	private String empresa;
	
	@Column(length = 13, nullable = true)
	private String foneemp;
	
	@Column(length = 150, nullable = true)
	private String referencia;
	
	@Column(length = 13, nullable = true)
	private String foneref;
	
	@Column(length = 200, nullable = true)
	private String auditoria;	
	
	@Column(length = 2000, nullable = true)
	private String obs;
	
	public String getRenda() {
		return renda;
	}
	public void setRenda(String renda) {
		this.renda = renda;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getOrgaorg() {
		return orgaorg;
	}
	public void setOrgaorg(String orgaorg) {
		this.orgaorg = orgaorg;
	}
		
	public String getCnpj() {
		return cnpj;
	}
	
	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	public String getDesde() {
		return desde;
	}
	public void setDesde(String desde) {
		this.desde = desde;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getInsest() {
		return insest;
	}
	public void setInsest(String insest) {
		this.insest = insest;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getFoneemp() {
		return foneemp;
	}
	public void setFoneemp(String foneemp) {
		this.foneemp = foneemp;
	}	
	
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getFoneref() {
		return foneref;
	}
	public void setFoneref(String foneref) {
		this.foneref = foneref;
	}
	public String getAuditoria() {
		return auditoria;
	}
	public void setAuditoria(String auditoria) {
		this.auditoria = auditoria;
	}
		
}

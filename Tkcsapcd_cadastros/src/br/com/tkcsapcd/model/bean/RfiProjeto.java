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
import javax.persistence.Table;

@Entity
@Table(name = "rfiprojeto")
public class RfiProjeto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;	
	
	@Column(length = 150, nullable = true)
	private String nome;
	
	@Column(length = 200, nullable = true)
	private String endereco;
	
	@Column(length = 150, nullable = true)
	private String paginaweb;
	
	@Column(length = 320, nullable = true)
	private String produtoservico;
	
	@Column(length = 320, nullable = true)
	private String mercadocliente;
	
	@Column(length = 320, nullable = true)
	private String estruturapropriedade;
	
	@Column(length = 320, nullable = true)
	private String estruturaempresa;
	
	@Column(length = 150, nullable = true)
	private String anosmercado;
	
	private String localizacao;
	
	@Column(length = 320, nullable = true)
	private String gestaoambiental;
	
	@Column(length = 320, nullable = true)
	private String gestaoqualidade;
	
	@Column(length = 320, nullable = true)
	private String gestaonegocio;
	
	@Column(length = 320, nullable = true)
	private String funcionario;
	
	@Column(length = 320, nullable = true)
	private String producao;
	
	@Column(length = 320, nullable = true)
	private String marketingvendas;
	
	@Column(length = 320, nullable = true)
	private String departamentoqualidade;
	
	@Column(length = 320, nullable = true)
	private String informacaofinanceira;
	
	@Column(length = 320, nullable = true)
	private String volumenegocio;
	
	private String ultimolucroano;
	
	@Column(length = 320, nullable = true)
	private String mercadoacoes;
	
	@Column(length = 200, nullable = true)
	private String pessoacontato;
	
	@Column(length = 30, nullable = true)
	private String telefone;
	
	@Column(length = 150, nullable = true)
	private String email;
	
	@Column(length = 320, nullable = true)
	private String capacidadehoje;
	
	@Column(length = 320, nullable = true)
	private String capacidadeantecipada;
	
	@Column(length = 320, nullable = true)
	private String condicaonaoatendida;
	
	@Column(length = 320, nullable = true)
	private String produtosentregues; 
	
	@Column(length = 320, nullable = true)
	private String clientereferenciacomparaveis;
	
	@Column(length = 320, nullable = true)
	private String clientereferencianaocomparaveis;
	
	@Column(length = 320, nullable = true)
	private String disponivelentrega;
	
	@Column(length = 320, nullable = true)
	private String disponibilidade;
	
	@Column(length = 150, nullable = true)
	private String suportemundial;
	
	private Date data;
	
	private Long cnpj;	
	
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
	public String getPaginaweb() {
		return paginaweb;
	}
	public void setPaginaweb(String paginaweb) {
		this.paginaweb = paginaweb;
	}
	public String getProdutoservico() {
		return produtoservico;
	}
	public void setProdutoservico(String produtoservico) {
		this.produtoservico = produtoservico;
	}
	public String getMercadocliente() {
		return mercadocliente;
	}
	public void setMercadocliente(String mercadocliente) {
		this.mercadocliente = mercadocliente;
	}
	public String getEstruturapropriedade() {
		return estruturapropriedade;
	}
	public void setEstruturapropriedade(String estruturapropriedade) {
		this.estruturapropriedade = estruturapropriedade;
	}
	public String getEstruturaempresa() {
		return estruturaempresa;
	}
	public void setEstruturaempresa(String estruturaempresa) {
		this.estruturaempresa = estruturaempresa;
	}
	public String getAnosmercado() {
		return anosmercado;
	}
	public void setAnosmercado(String anosmercado) {
		this.anosmercado = anosmercado;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public String getGestaoambiental() {
		return gestaoambiental;
	}
	public void setGestaoambiental(String gestaoambiental) {
		this.gestaoambiental = gestaoambiental;
	}
	public String getGestaoqualidade() {
		return gestaoqualidade;
	}
	public void setGestaoqualidade(String gestaoqualidade) {
		this.gestaoqualidade = gestaoqualidade;
	}
	public String getGestaonegocio() {
		return gestaonegocio;
	}
	public void setGestaonegocio(String gestaonegocio) {
		this.gestaonegocio = gestaonegocio;
	}
	public String getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}
	public String getProducao() {
		return producao;
	}
	public void setProducao(String producao) {
		this.producao = producao;
	}
	public String getMarketingvendas() {
		return marketingvendas;
	}
	public void setMarketingvendas(String marketingvendas) {
		this.marketingvendas = marketingvendas;
	}
	public String getDepartamentoqualidade() {
		return departamentoqualidade;
	}
	public void setDepartamentoqualidade(String departamentoqualidade) {
		this.departamentoqualidade = departamentoqualidade;
	}
	public String getInformacaofinanceira() {
		return informacaofinanceira;
	}
	public void setInformacaofinanceira(String informacaofinanceira) {
		this.informacaofinanceira = informacaofinanceira;
	}
	public String getVolumenegocio() {
		return volumenegocio;
	}
	public void setVolumenegocio(String volumenegocio) {
		this.volumenegocio = volumenegocio;
	}
	public String getUltimolucroano() {
		return ultimolucroano;
	}
	public void setUltimolucroano(String ultimolucroano) {
		this.ultimolucroano = ultimolucroano;
	}
	public String getMercadoacoes() {
		return mercadoacoes;
	}
	public void setMercadoacoes(String mercadoacoes) {
		this.mercadoacoes = mercadoacoes;
	}
	public String getPessoacontato() {
		return pessoacontato;
	}
	public void setPessoacontato(String pessoacontato) {
		this.pessoacontato = pessoacontato;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCapacidadehoje() {
		return capacidadehoje;
	}
	public void setCapacidadehoje(String capacidadehoje) {
		this.capacidadehoje = capacidadehoje;
	}
	public String getCapacidadeantecipada() {
		return capacidadeantecipada;
	}
	public void setCapacidadeantecipada(String capacidadeantecipada) {
		this.capacidadeantecipada = capacidadeantecipada;
	}
	public String getCondicaonaoatendida() {
		return condicaonaoatendida;
	}
	public void setCondicaonaoatendida(String condicaonaoatendida) {
		this.condicaonaoatendida = condicaonaoatendida;
	}
	public String getProdutosentregues() {
		return produtosentregues;
	}
	public void setProdutosentregues(String produtosentregues) {
		this.produtosentregues = produtosentregues;
	}
	public String getClientereferenciacomparaveis() {
		return clientereferenciacomparaveis;
	}
	public void setClientereferenciacomparaveis(String clientereferenciacomparaveis) {
		this.clientereferenciacomparaveis = clientereferenciacomparaveis;
	}
	public String getClientereferencianaocomparaveis() {
		return clientereferencianaocomparaveis;
	}
	public void setClientereferencianaocomparaveis(
			String clientereferencianaocomparaveis) {
		this.clientereferencianaocomparaveis = clientereferencianaocomparaveis;
	}
	public String getDisponivelentrega() {
		return disponivelentrega;
	}
	public void setDisponivelentrega(String disponivelentrega) {
		this.disponivelentrega = disponivelentrega;
	}
	public String getDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	public String getSuportemundial() {
		return suportemundial;
	}
	public void setSuportemundial(String suportemundial) {
		this.suportemundial = suportemundial;
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
	public Long getCnpj() {
		return cnpj;
	}
	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}
	
	
}

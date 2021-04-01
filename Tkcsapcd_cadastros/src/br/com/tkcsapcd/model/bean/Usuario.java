/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.bean;

public class Usuario {

	private Integer log_codigo;
	private String log_usuario;
	private String log_senha;
	private String log_nivelacesso;
	private String log_cpf;
	private String log_datacadastro;
	private String nome;
	private String id;
	private String gestorimediato; 
	private String departamento; 
	private String email;
	private String telefone;
	
	public Integer getLog_codigo() {
		return log_codigo;
	}
	public void setLog_codigo(Integer log_codigo) {
		this.log_codigo = log_codigo;
	}
	public String getLog_usuario() {
		return log_usuario;
	}
	public void setLog_usuario(String log_usuario) {
		this.log_usuario = log_usuario;
	}
	public String getLog_senha() {
		return log_senha;
	}
	public void setLog_senha(String log_senha) {
		this.log_senha = log_senha;
	}
	public String getLog_nivelacesso() {
		return log_nivelacesso;
	}
	public void setLog_nivelacesso(String log_nivelacesso) {
		this.log_nivelacesso = log_nivelacesso;
	}
	public String getLog_cpf() {
		return log_cpf;
	}
	public void setLog_cpf(String log_cpf) {
		this.log_cpf = log_cpf;
	}
	public String getLog_datacadastro() {
		return log_datacadastro;
	}
	public void setLog_datacadastro(String log_datacadastro) {
		this.log_datacadastro = log_datacadastro;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGestorimediato() {
		return gestorimediato;
	}
	public void setGestorimediato(String gestorimediato) {
		this.gestorimediato = gestorimediato;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
}

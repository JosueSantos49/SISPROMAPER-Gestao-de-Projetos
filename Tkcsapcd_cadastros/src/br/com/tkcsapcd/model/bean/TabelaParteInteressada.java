package br.com.tkcsapcd.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="tbparteinteressada")
public class TabelaParteInteressada {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(length = 150, nullable = true)
	private String nomegrport;
	
	private String cpfgrport;
	
	@Column(length = 150, nullable = true)
	private String emailgrport;
	
	private Integer fonegrport;
	
	@Column(length = 2000, nullable = true)
	private String outrosport;
	
	@Column(length = 150, nullable = true)
	private String nomegrprograma;
	
	@Column(length = 150, nullable = true)
	private String emailgrprograma;
	
	private Integer fonegrprograma;
	
	@Column(length = 150, nullable = true)
	private String nomegrprojeto;
	
	@Column(length = 150, nullable = true)
	private String emailgrprojeto;
	
	@Column(length = 150, nullable = true)
	private String fonegrprojeto;
	
	@Column(length = 150, nullable = true)
	private String nomeegprojeto;
	
	@Column(length = 150, nullable = true)
	private String emaileqprojeto;
	
	@Column(length = 150, nullable = true)
	private String nomegrfuncional;
	
	@Column(length = 150, nullable = true)
	private String cpfgrfuncional;
	
	@Column(length = 150, nullable = true)
	private String emailgrfuncional;
	
	@Column(length = 150, nullable = true)
	private Integer fonegrfuncional;
	
	@Column(length = 150, nullable = true)
	private String nomepatrocinador;
	
	@Column(length = 150, nullable = true)
	private String cpfpatrocinador;
	
	@Column(length = 150, nullable = true)
	private String  cnpjpatrocinador;
	
	@Column(length = 150, nullable = true)
	private String emailpatrocinador;
	
	@Column(length = 150, nullable = true)
	private Integer  fonepatrocinador;
	
	@Column(length = 150, nullable = true)
	private Double investimento;	
	
	@Column(length = 150, nullable = true)
	private String nomefornecedor;
	
	@Column(length = 150, nullable = true)
	private String cpffornecedor;
	
	@Column(length = 150, nullable = true)
	private String  cnpjfornecedor;
	
	@Column(length = 150, nullable = true)
	private String emailfornecedor;
	
	@Column(length = 150, nullable = true)
	private Integer  fonefornecedor;
	
	@Column(length = 150, nullable = true)
	private Double investimentoforne;	
	
	@Column(length = 150, nullable = true)
	private String nomeequipeproj;
	
	@Column(length = 150, nullable = true)
	private String setorequipeproj;
	
	@ManyToOne
	@JoinColumn(name="registroparteinteressada", nullable = false)
	private RegistroParteInteressada registroParteInteressada = new RegistroParteInteressada();
		
	public String getNomegrport() {
		return nomegrport;
	}
	public void setNomegrport(String nomegrport) {
		this.nomegrport = nomegrport;
	}
	
	public String getEmailgrport() {
		return emailgrport;
	}
	public void setEmailgrport(String emailgrport) {
		this.emailgrport = emailgrport;
	}
	public Integer getFonegrport() {
		return fonegrport;
	}
	public void setFonegrport(Integer fonegrport) {
		this.fonegrport = fonegrport;
	}
	public String getOutrosport() {
		return outrosport;
	}
	public void setOutrosport(String outrosport) {
		this.outrosport = outrosport;
	}
	public String getNomegrprograma() {
		return nomegrprograma;
	}
	public void setNomegrprograma(String nomegrprograma) {
		this.nomegrprograma = nomegrprograma;
	}
	public String getEmailgrprograma() {
		return emailgrprograma;
	}
	public void setEmailgrprograma(String emailgrprograma) {
		this.emailgrprograma = emailgrprograma;
	}
	public Integer getFonegrprograma() {
		return fonegrprograma;
	}
	public void setFonegrprograma(Integer fonegrprograma) {
		this.fonegrprograma = fonegrprograma;
	}
	public String getNomegrprojeto() {
		return nomegrprojeto;
	}
	public void setNomegrprojeto(String nomegrprojeto) {
		this.nomegrprojeto = nomegrprojeto;
	}
	public String getEmailgrprojeto() {
		return emailgrprojeto;
	}
	public void setEmailgrprojeto(String emailgrprojeto) {
		this.emailgrprojeto = emailgrprojeto;
	}
	public String getFonegrprojeto() {
		return fonegrprojeto;
	}
	public void setFonegrprojeto(String fonegrprojeto) {
		this.fonegrprojeto = fonegrprojeto;
	}
	public String getNomeegprojeto() {
		return nomeegprojeto;
	}
	public void setNomeegprojeto(String nomeegprojeto) {
		this.nomeegprojeto = nomeegprojeto;
	}
	public String getEmaileqprojeto() {
		return emaileqprojeto;
	}
	public void setEmaileqprojeto(String emaileqprojeto) {
		this.emaileqprojeto = emaileqprojeto;
	}
	public String getNomegrfuncional() {
		return nomegrfuncional;
	}
	public void setNomegrfuncional(String nomegrfuncional) {
		this.nomegrfuncional = nomegrfuncional;
	}
	
	public String getEmailgrfuncional() {
		return emailgrfuncional;
	}
	public void setEmailgrfuncional(String emailgrfuncional) {
		this.emailgrfuncional = emailgrfuncional;
	}
	
	
	public Integer getFonegrfuncional() {
		return fonegrfuncional;
	}
	public void setFonegrfuncional(Integer fonegrfuncional) {
		this.fonegrfuncional = fonegrfuncional;
	}
	public String getNomepatrocinador() {
		return nomepatrocinador;
	}
	public void setNomepatrocinador(String nomepatrocinador) {
		this.nomepatrocinador = nomepatrocinador;
	}
	
	
	public String getEmailpatrocinador() {
		return emailpatrocinador;
	}
	public void setEmailpatrocinador(String emailpatrocinador) {
		this.emailpatrocinador = emailpatrocinador;
	}
	
	public Integer getFonepatrocinador() {
		return fonepatrocinador;
	}
	public void setFonepatrocinador(Integer fonepatrocinador) {
		this.fonepatrocinador = fonepatrocinador;
	}
	
	public Double getInvestimento() {
		return investimento;
	}
	public void setInvestimento(Double investimento) {
		this.investimento = investimento;
	}
	public String getNomeequipeproj() {
		return nomeequipeproj;
	}
	public void setNomeequipeproj(String nomeequipeproj) {
		this.nomeequipeproj = nomeequipeproj;
	}
	public String getSetorequipeproj() {
		return setorequipeproj;
	}
	public void setSetorequipeproj(String setorequipeproj) {
		this.setorequipeproj = setorequipeproj;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public RegistroParteInteressada getRegistroParteInteressada() {
		return registroParteInteressada;
	}
	public void setRegistroParteInteressada(RegistroParteInteressada registroParteInteressada) {
		this.registroParteInteressada = registroParteInteressada;
	}
	public String getNomefornecedor() {
		return nomefornecedor;
	}
	public void setNomefornecedor(String nomefornecedor) {
		this.nomefornecedor = nomefornecedor;
	}	
	
	public String getCpfgrport() {
		return cpfgrport;
	}
	public void setCpfgrport(String cpfgrport) {
		this.cpfgrport = cpfgrport;
	}
	public String getCpfgrfuncional() {
		return cpfgrfuncional;
	}
	public void setCpfgrfuncional(String cpfgrfuncional) {
		this.cpfgrfuncional = cpfgrfuncional;
	}
	public String getCpfpatrocinador() {
		return cpfpatrocinador;
	}
	public void setCpfpatrocinador(String cpfpatrocinador) {
		this.cpfpatrocinador = cpfpatrocinador;
	}
	public String getCpffornecedor() {
		return cpffornecedor;
	}
	public void setCpffornecedor(String cpffornecedor) {
		this.cpffornecedor = cpffornecedor;
	}
	public String getCnpjpatrocinador() {
		return cnpjpatrocinador;
	}
	public void setCnpjpatrocinador(String cnpjpatrocinador) {
		this.cnpjpatrocinador = cnpjpatrocinador;
	}
	public String getCnpjfornecedor() {
		return cnpjfornecedor;
	}
	public void setCnpjfornecedor(String cnpjfornecedor) {
		this.cnpjfornecedor = cnpjfornecedor;
	}
	public String getEmailfornecedor() {
		return emailfornecedor;
	}
	public void setEmailfornecedor(String emailfornecedor) {
		this.emailfornecedor = emailfornecedor;
	}
	public Integer getFonefornecedor() {
		return fonefornecedor;
	}
	public void setFonefornecedor(Integer fonefornecedor) {
		this.fonefornecedor = fonefornecedor;
	}
	public Double getInvestimentoforne() {
		return investimentoforne;
	}
	public void setInvestimentoforne(Double investimentoforne) {
		this.investimentoforne = investimentoforne;
	}
	
	
}

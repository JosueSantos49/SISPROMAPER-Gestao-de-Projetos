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
@Table(name = "rfq")
public class Rfq {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private Date data;
	
	private Integer numerorfq;
	
	@Column(length = 150, nullable = true)
	private String prazoentrega;
	
	@Column(length = 150, nullable = true)
	private String contatocomercial;
	
	@Column(length = 150, nullable = true)
	private String contatotecnico;
	
	private Date datalimite;
	
	@Column(length = 150, nullable = true)
	private String termopagamento;
	
	@Column(length = 150, nullable = true)
	private String tempogarantia;
	
	@Column(length = 150, nullable = true)
	private String outracondicao;
	
	@Column(length = 150, nullable = true)
	private String empresa;
	
	@Column(length = 200, nullable = true)
	private String endereco;
	
	@Column(length = 200, nullable = true)
	private String cidade;
	
	@Column(length = 200, nullable = true)
	private String estado;
	
	@Column(length = 11, nullable = true)
	private String telefone;	
	
	private Integer codigoitem;
	
	@Column(length = 200, nullable = true)
	private String descricao;
	
	private double frete;
	
	private Double total;
	
	private Integer qtd1;
	private Integer qtd2;
	private Integer qtd3;
	private Integer qtd4;
	private Integer qtd5;
	private Integer qtd6;
	private Integer qtd7;
	private Integer qtd8;
	private Integer qtd9;
	private Integer qtd10;
	private Integer qtd11;
	private Integer qtd12;
	private Integer qtd13;
	private Integer qtd14;
	private Integer qtd15;
	private Integer qtd16;
	private Integer qtd17;
	private Integer qtd18;
	private Integer qtd19;
	private Integer qtd20;	
	
	private double puitem1;
	private double puitem2;
	private double puitem3;
	private double puitem4;
	private double puitem5;
	private double puitem6;
	private double puitem7;
	private double puitem8;
	private double puitem9;
	private double puitem10;
	private double puitem11;
	private double puitem12;
	private double puitem13;
	private double puitem14;
	private double puitem15;
	private double puitem16;
	private double puitem17;
	private double puitem18;
	private double puitem19;
	private double puitem20;
		
	private int codigoitem1;
	private int codigoitem2;
	private int codigoitem3;
	private int codigoitem4;
	private int codigoitem5;
	private int codigoitem6;
	private int codigoitem7;
	private int codigoitem8;
	private int codigoitem9;
	private int codigoitem10;
	private int codigoitem11;
	private int codigoitem12;
	private int codigoitem13;
	private int codigoitem14;
	private int codigoitem15;
	private int codigoitem16;
	private int codigoitem17;
	private int codigoitem18;
	private int codigoitem19;
	private int codigoitem20;
	
	@Column(length = 150, nullable = true)
	private String descricao1;
	
	@Column(length = 150, nullable = true)
	private String descricao2;
	
	@Column(length = 150, nullable = true)
	private String descricao3;
	
	@Column(length = 150, nullable = true)
	private String descricao4;
	
	@Column(length = 150, nullable = true)
	private String descricao5;
	
	@Column(length = 150, nullable = true)
	private String descricao6;
	
	@Column(length = 150, nullable = true)
	private String descricao7;
	
	@Column(length = 150, nullable = true)
	private String descricao8;
	
	@Column(length = 150, nullable = true)
	private String descricao9;
	
	@Column(length = 150, nullable = true)
	private String descricao10;
	
	@Column(length = 150, nullable = true)
	private String descricao11;
	
	@Column(length = 150, nullable = true)
	private String descricao12;
	
	@Column(length = 150, nullable = true)
	private String descricao13;
	
	@Column(length = 150, nullable = true)
	private String descricao14;
	
	@Column(length = 150, nullable = true)
	private String descricao15;
	
	@Column(length = 150, nullable = true)
	private String descricao16;
	
	@Column(length = 150, nullable = true)
	private String descricao17;
	
	@Column(length = 150, nullable = true)
	private String descricao18;
	
	@Column(length = 150, nullable = true)
	private String descricao19;
	
	@Column(length = 150, nullable = true)
	private String descricao20;
	
	
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
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
	public Integer getNumerorfq() {
		return numerorfq;
	}
	public void setNumerorfq(Integer numerorfq) {
		this.numerorfq = numerorfq;
	}
	public String getPrazoentrega() {
		return prazoentrega;
	}
	public void setPrazoentrega(String prazoentrega) {
		this.prazoentrega = prazoentrega;
	}
	public String getContatocomercial() {
		return contatocomercial;
	}
	public void setContatocomercial(String contatocomercial) {
		this.contatocomercial = contatocomercial;
	}
	public String getContatotecnico() {
		return contatotecnico;
	}
	public void setContatotecnico(String contatotecnico) {
		this.contatotecnico = contatotecnico;
	}
	public Date getDatalimite() {
		return datalimite;
	}
	public void setDatalimite(Date datalimite) {
		this.datalimite = datalimite;
	}
	public String getTermopagamento() {
		return termopagamento;
	}
	public void setTermopagamento(String termopagamento) {
		this.termopagamento = termopagamento;
	}
	public String getTempogarantia() {
		return tempogarantia;
	}
	public void setTempogarantia(String tempogarantia) {
		this.tempogarantia = tempogarantia;
	}
	public String getOutracondicao() {
		return outracondicao;
	}
	public void setOutracondicao(String outracondicao) {
		this.outracondicao = outracondicao;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Integer getCodigoitem() {
		return codigoitem;
	}
	public void setCodigoitem(Integer codigoitem) {
		this.codigoitem = codigoitem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getFrete() {
		return frete;
	}
	public void setFrete(double frete) {
		this.frete = frete;
	}
	public double getPuitem1() {
		return puitem1;
	}
	public void setPuitem1(double puitem1) {
		this.puitem1 = puitem1;
	}
	public double getPuitem2() {
		return puitem2;
	}
	public void setPuitem2(double puitem2) {
		this.puitem2 = puitem2;
	}
	public double getPuitem3() {
		return puitem3;
	}
	public void setPuitem3(double puitem3) {
		this.puitem3 = puitem3;
	}
	public double getPuitem4() {
		return puitem4;
	}
	public void setPuitem4(double puitem4) {
		this.puitem4 = puitem4;
	}
	public double getPuitem5() {
		return puitem5;
	}
	public void setPuitem5(double puitem5) {
		this.puitem5 = puitem5;
	}
	public double getPuitem6() {
		return puitem6;
	}
	public void setPuitem6(double puitem6) {
		this.puitem6 = puitem6;
	}
	public double getPuitem7() {
		return puitem7;
	}
	public void setPuitem7(double puitem7) {
		this.puitem7 = puitem7;
	}
	public double getPuitem8() {
		return puitem8;
	}
	public void setPuitem8(double puitem8) {
		this.puitem8 = puitem8;
	}
	public double getPuitem9() {
		return puitem9;
	}
	public void setPuitem9(double puitem9) {
		this.puitem9 = puitem9;
	}
	public double getPuitem10() {
		return puitem10;
	}
	public void setPuitem10(double puitem10) {
		this.puitem10 = puitem10;
	}
	public double getPuitem11() {
		return puitem11;
	}
	public void setPuitem11(double puitem11) {
		this.puitem11 = puitem11;
	}
	public double getPuitem12() {
		return puitem12;
	}
	public void setPuitem12(double puitem12) {
		this.puitem12 = puitem12;
	}
	public double getPuitem13() {
		return puitem13;
	}
	public void setPuitem13(double puitem13) {
		this.puitem13 = puitem13;
	}
	public double getPuitem14() {
		return puitem14;
	}
	public void setPuitem14(double puitem14) {
		this.puitem14 = puitem14;
	}
	public double getPuitem15() {
		return puitem15;
	}
	public void setPuitem15(double puitem15) {
		this.puitem15 = puitem15;
	}
	public double getPuitem16() {
		return puitem16;
	}
	public void setPuitem16(double puitem16) {
		this.puitem16 = puitem16;
	}
	public double getPuitem17() {
		return puitem17;
	}
	public void setPuitem17(double puitem17) {
		this.puitem17 = puitem17;
	}
	public double getPuitem18() {
		return puitem18;
	}
	public void setPuitem18(double puitem18) {
		this.puitem18 = puitem18;
	}
	public double getPuitem19() {
		return puitem19;
	}
	public void setPuitem19(double puitem19) {
		this.puitem19 = puitem19;
	}
	public double getPuitem20() {
		return puitem20;
	}
	public void setPuitem20(double puitem20) {
		this.puitem20 = puitem20;
	}
	public Integer getQtd1() {
		return qtd1;
	}
	public void setQtd1(Integer qtd1) {
		this.qtd1 = qtd1;
	}
	public Integer getQtd2() {
		return qtd2;
	}
	public void setQtd2(Integer qtd2) {
		this.qtd2 = qtd2;
	}
	public Integer getQtd3() {
		return qtd3;
	}
	public void setQtd3(Integer qtd3) {
		this.qtd3 = qtd3;
	}
	public Integer getQtd4() {
		return qtd4;
	}
	public void setQtd4(Integer qtd4) {
		this.qtd4 = qtd4;
	}
	public Integer getQtd5() {
		return qtd5;
	}
	public void setQtd5(Integer qtd5) {
		this.qtd5 = qtd5;
	}
	public Integer getQtd6() {
		return qtd6;
	}
	public void setQtd6(Integer qtd6) {
		this.qtd6 = qtd6;
	}
	public Integer getQtd7() {
		return qtd7;
	}
	public void setQtd7(Integer qtd7) {
		this.qtd7 = qtd7;
	}
	public Integer getQtd8() {
		return qtd8;
	}
	public void setQtd8(Integer qtd8) {
		this.qtd8 = qtd8;
	}
	public Integer getQtd9() {
		return qtd9;
	}
	public void setQtd9(Integer qtd9) {
		this.qtd9 = qtd9;
	}
	public Integer getQtd10() {
		return qtd10;
	}
	public void setQtd10(Integer qtd10) {
		this.qtd10 = qtd10;
	}
	public Integer getQtd11() {
		return qtd11;
	}
	public void setQtd11(Integer qtd11) {
		this.qtd11 = qtd11;
	}
	public Integer getQtd12() {
		return qtd12;
	}
	public void setQtd12(Integer qtd12) {
		this.qtd12 = qtd12;
	}
	public Integer getQtd13() {
		return qtd13;
	}
	public void setQtd13(Integer qtd13) {
		this.qtd13 = qtd13;
	}
	public Integer getQtd14() {
		return qtd14;
	}
	public void setQtd14(Integer qtd14) {
		this.qtd14 = qtd14;
	}
	public Integer getQtd15() {
		return qtd15;
	}
	public void setQtd15(Integer qtd15) {
		this.qtd15 = qtd15;
	}
	public Integer getQtd16() {
		return qtd16;
	}
	public void setQtd16(Integer qtd16) {
		this.qtd16 = qtd16;
	}
	public Integer getQtd17() {
		return qtd17;
	}
	public void setQtd17(Integer qtd17) {
		this.qtd17 = qtd17;
	}
	public Integer getQtd18() {
		return qtd18;
	}
	public void setQtd18(Integer qtd18) {
		this.qtd18 = qtd18;
	}
	public Integer getQtd19() {
		return qtd19;
	}
	public void setQtd19(Integer qtd19) {
		this.qtd19 = qtd19;
	}
	public Integer getQtd20() {
		return qtd20;
	}
	public void setQtd20(Integer qtd20) {
		this.qtd20 = qtd20;
	}
	
	public String getDescricao1() {
		return descricao1;
	}
	public void setDescricao1(String descricao1) {
		this.descricao1 = descricao1;
	}
	public String getDescricao2() {
		return descricao2;
	}
	public void setDescricao2(String descricao2) {
		this.descricao2 = descricao2;
	}
	public String getDescricao3() {
		return descricao3;
	}
	public void setDescricao3(String descricao3) {
		this.descricao3 = descricao3;
	}
	public String getDescricao4() {
		return descricao4;
	}
	public void setDescricao4(String descricao4) {
		this.descricao4 = descricao4;
	}
	public String getDescricao5() {
		return descricao5;
	}
	public void setDescricao5(String descricao5) {
		this.descricao5 = descricao5;
	}
	public String getDescricao6() {
		return descricao6;
	}
	public void setDescricao6(String descricao6) {
		this.descricao6 = descricao6;
	}
	public String getDescricao7() {
		return descricao7;
	}
	public void setDescricao7(String descricao7) {
		this.descricao7 = descricao7;
	}
	public String getDescricao8() {
		return descricao8;
	}
	public void setDescricao8(String descricao8) {
		this.descricao8 = descricao8;
	}
	public String getDescricao9() {
		return descricao9;
	}
	public void setDescricao9(String descricao9) {
		this.descricao9 = descricao9;
	}
	public String getDescricao10() {
		return descricao10;
	}
	public void setDescricao10(String descricao10) {
		this.descricao10 = descricao10;
	}
	public String getDescricao11() {
		return descricao11;
	}
	public void setDescricao11(String descricao11) {
		this.descricao11 = descricao11;
	}
	public String getDescricao12() {
		return descricao12;
	}
	public void setDescricao12(String descricao12) {
		this.descricao12 = descricao12;
	}
	public String getDescricao13() {
		return descricao13;
	}
	public void setDescricao13(String descricao13) {
		this.descricao13 = descricao13;
	}
	public String getDescricao14() {
		return descricao14;
	}
	public void setDescricao14(String descricao14) {
		this.descricao14 = descricao14;
	}
	public String getDescricao15() {
		return descricao15;
	}
	public void setDescricao15(String descricao15) {
		this.descricao15 = descricao15;
	}
	public String getDescricao16() {
		return descricao16;
	}
	public void setDescricao16(String descricao16) {
		this.descricao16 = descricao16;
	}
	public String getDescricao17() {
		return descricao17;
	}
	public void setDescricao17(String descricao17) {
		this.descricao17 = descricao17;
	}
	public String getDescricao18() {
		return descricao18;
	}
	public void setDescricao18(String descricao18) {
		this.descricao18 = descricao18;
	}
	public String getDescricao19() {
		return descricao19;
	}
	public void setDescricao19(String descricao19) {
		this.descricao19 = descricao19;
	}
	public String getDescricao20() {
		return descricao20;
	}
	public void setDescricao20(String descricao20) {
		this.descricao20 = descricao20;
	}
	public int getCodigoitem1() {
		return codigoitem1;
	}
	public void setCodigoitem1(int codigoitem1) {
		this.codigoitem1 = codigoitem1;
	}
	public int getCodigoitem2() {
		return codigoitem2;
	}
	public void setCodigoitem2(int codigoitem2) {
		this.codigoitem2 = codigoitem2;
	}
	public int getCodigoitem3() {
		return codigoitem3;
	}
	public void setCodigoitem3(int codigoitem3) {
		this.codigoitem3 = codigoitem3;
	}
	public int getCodigoitem4() {
		return codigoitem4;
	}
	public void setCodigoitem4(int codigoitem4) {
		this.codigoitem4 = codigoitem4;
	}
	public int getCodigoitem5() {
		return codigoitem5;
	}
	public void setCodigoitem5(int codigoitem5) {
		this.codigoitem5 = codigoitem5;
	}
	public int getCodigoitem6() {
		return codigoitem6;
	}
	public void setCodigoitem6(int codigoitem6) {
		this.codigoitem6 = codigoitem6;
	}
	public int getCodigoitem7() {
		return codigoitem7;
	}
	public void setCodigoitem7(int codigoitem7) {
		this.codigoitem7 = codigoitem7;
	}
	public int getCodigoitem8() {
		return codigoitem8;
	}
	public void setCodigoitem8(int codigoitem8) {
		this.codigoitem8 = codigoitem8;
	}
	public int getCodigoitem9() {
		return codigoitem9;
	}
	public void setCodigoitem9(int codigoitem9) {
		this.codigoitem9 = codigoitem9;
	}
	public int getCodigoitem10() {
		return codigoitem10;
	}
	public void setCodigoitem10(int codigoitem10) {
		this.codigoitem10 = codigoitem10;
	}
	public int getCodigoitem11() {
		return codigoitem11;
	}
	public void setCodigoitem11(int codigoitem11) {
		this.codigoitem11 = codigoitem11;
	}
	public int getCodigoitem12() {
		return codigoitem12;
	}
	public void setCodigoitem12(int codigoitem12) {
		this.codigoitem12 = codigoitem12;
	}
	public int getCodigoitem13() {
		return codigoitem13;
	}
	public void setCodigoitem13(int codigoitem13) {
		this.codigoitem13 = codigoitem13;
	}
	public int getCodigoitem14() {
		return codigoitem14;
	}
	public void setCodigoitem14(int codigoitem14) {
		this.codigoitem14 = codigoitem14;
	}
	public int getCodigoitem15() {
		return codigoitem15;
	}
	public void setCodigoitem15(int codigoitem15) {
		this.codigoitem15 = codigoitem15;
	}
	public int getCodigoitem16() {
		return codigoitem16;
	}
	public void setCodigoitem16(int codigoitem16) {
		this.codigoitem16 = codigoitem16;
	}
	public int getCodigoitem17() {
		return codigoitem17;
	}
	public void setCodigoitem17(int codigoitem17) {
		this.codigoitem17 = codigoitem17;
	}
	public int getCodigoitem18() {
		return codigoitem18;
	}
	public void setCodigoitem18(int codigoitem18) {
		this.codigoitem18 = codigoitem18;
	}
	public int getCodigoitem19() {
		return codigoitem19;
	}
	public void setCodigoitem19(int codigoitem19) {
		this.codigoitem19 = codigoitem19;
	}
	public int getCodigoitem20() {
		return codigoitem20;
	}
	public void setCodigoitem20(int codigoitem20) {
		this.codigoitem20 = codigoitem20;
	}
	
	
	
}

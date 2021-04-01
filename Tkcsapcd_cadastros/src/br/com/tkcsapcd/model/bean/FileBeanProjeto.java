/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.bean;

import java.util.Date;

public class FileBeanProjeto {
	
		//br.com.tkcsapcd.DowloadUploadFileProjeto
		private Long id;
		private String description; 	
		private String name;
	 	private byte[] data;
	 	private String descricao;
	 	private Integer codigoprojeto;
	 	private String comentario;
	 	private Date dataregistro;
	 	private String email;
	 	

	    public FileBeanProjeto() {
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public byte[] getData() {
	        return data;
	    }

	    public void setData(byte[] data) {
	        this.data = data;
	    }

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public Integer getCodigoprojeto() {
			return codigoprojeto;
		}

		public void setCodigoprojeto(Integer codigoprojeto) {
			this.codigoprojeto = codigoprojeto;
		}

		public String getComentario() {
			return comentario;
		}

		public void setComentario(String comentario) {
			this.comentario = comentario;
		}

		public Date getDataregistro() {
			return dataregistro;
		}

		public void setDataregistro(Date dataregistro) {
			this.dataregistro = dataregistro;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		

		
		
		

}

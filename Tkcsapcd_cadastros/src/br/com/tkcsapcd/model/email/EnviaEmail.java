/* 
	Autor: Josué da Conceição Santos
	E-mail: conceicaojosue@outlook.com.br
	Ano: 2015
 */
package br.com.tkcsapcd.model.email;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviaEmail {
	
	private String codigo;
	private String codigoprojeto;
	private String de;
	private String para;
	private String assunto;
	private String mensagem;
	private String lista;
	private String projeto;	
	private String objetivo;
	private String copia;
	private String email;
	private String status;	
	private String obs;
	private String aprovacao;
	private String comentario;
	private String participantes;
	private String descricao;	
	private String file;
	private String emailSessao;
	private static Properties props=null;
	private static Session session = null;
	
	public String getEmailSessao() {
		return emailSessao;
	}

	public void setEmailSessao(String emailSessao) {
		this.emailSessao = emailSessao;
	}

	/*Esta classe é especialista em executar envio de e-mail, onde, cada método executa suas necessidades.
	 * Atenção caso seja necessário configurar a propriedade de acesso ao servidor de hospedagem basta somente definir as portas abaixo
	 de acordo com o host, port e senha de autenticação.
	 * */
	
	/*//Hospedagem Online e Local Funcionando em Produção
	static{
		props = System.getProperties();
		props.put("mail.smtp.host", "sisproweb.com.br");
		//props.put("mail.smtp.port", "25");//servidor online
		props.put("mail.smtp.port", "587");//servidor local
		props.put("mail.smtp.auth", "true");
		session = Session.getInstance(props, new Autenticar("sispro@sisproweb.com.br","josuerj49sispro27") //Seu e-mail e senha, criado no cPanel hospedagem.
		);
	}*/	
	
	/*Enviando email com JavaMail utilizando Gmail*/
	static{
		
		Properties props = new Properties();
		
		 /** Parâmetros de conexão com servidor Gmail */
		//props.put("mail.transport.protocol", "smtp"); //define protocolo de envio como SMTP
		props.put("mail.smtp.host", "smtp.gmail.com");		
		props.put("mail.smtp.socketFactory.port", "587");		
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                     protected PasswordAuthentication getPasswordAuthentication()
                     {
                           return new PasswordAuthentication("jsjosue8@gmail.com","2682065929091988");
                     }
                });

    /** Ativa Debug para sessão */
    session.setDebug(true);//Habilita o LOG das ações executadas durante o envio do email
		
	}	
	
	public boolean enviar(){
		try{
			MimeMessage message = new MimeMessage(session); //cria a mensagem setando o remetente e seus destinatários
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(this.para)); //setamos o 1° destinatario
			message.setFrom(new InternetAddress(this.de));//seta remetente
			message.setSubject(this.assunto);//assunto
			message.addRecipient(Message.RecipientType.CC, new InternetAddress (this.lista));//setando demais destinatários	CC		
			message.setSentDate(new Date());//data			
			message.setContent(this.mensagem,"text/html; charset=ISO-8859-1");//mensagem
			
			/*
			//Criando email com anexo
			//Criando duas variaveis, uma para o corpo e a outra para o anexo
			MimeBodyPart corpo = new MimeBodyPart();
			MimeBodyPart anexo = new MimeBodyPart();
			
			//Setando o texto do e-mail
			corpo.setText("Enviando...");
			
			//Tratando o arquivo;
			File file = new File(this.file); //Caminho do arquivo D:\\sispro_tkcsapcd.sql			
			FileDataSource fds = new FileDataSource(file);   
			anexo.setDataHandler(new DataHandler(fds));
			anexo.setFileName(file.getName());
			
			//Implementando variável para armazenar o corpo e anexo do email
			Multipart mp = new MimeMultipart();
			
			//setando corpo do anexo para variavel anterior
			mp.addBodyPart(corpo);
			mp.addBodyPart(anexo);
			
			//setando a variavel mp corpo construinda do email
			message.setContent(mp);*/
			
			Transport.send(message);
			
			return true;			
		}
		catch (MessagingException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	/*Metodo responsável, por enviar e-mail de confirmação de envio de formulários*/
	public boolean enviarForm(){
		try{
			MimeMessage message = new MimeMessage(session); //cria a mensagem setando o remetente e seus destinatários
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(this.para)); //setamos o 1° destinatario
			//message.setFrom(new InternetAddress(this.de));//seta remetente
			message.setSubject(this.assunto);//assunto
			//message.addRecipient(Message.RecipientType.CC, new InternetAddress (this.lista));//setando demais destinatários	CC		
			message.setSentDate(new Date());//data			
			message.setContent(this.mensagem,"text/html; charset=ISO-8859-1");//mensagem
			
			/*
			//Criando email com anexo
			//Criando duas variaveis, uma para o corpo e a outra para o anexo
			MimeBodyPart corpo = new MimeBodyPart();
			MimeBodyPart anexo = new MimeBodyPart();
			
			//Setando o texto do e-mail
			corpo.setText("Enviando...");
			
			//Tratando o arquivo;
			File file = new File(this.file); //Caminho do arquivo D:\\sispro_tkcsapcd.sql			
			FileDataSource fds = new FileDataSource(file);   
			anexo.setDataHandler(new DataHandler(fds));
			anexo.setFileName(file.getName());
			
			//Implementando variável para armazenar o corpo e anexo do email
			Multipart mp = new MimeMultipart();
			
			//setando corpo do anexo para variavel anterior
			mp.addBodyPart(corpo);
			mp.addBodyPart(anexo);
			
			//setando a variavel mp corpo construinda do email
			message.setContent(mp);*/
			
			Transport.send(message);
			
			return true;			
		}
		catch (MessagingException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	public boolean enviarUsuario(){
		try{
			MimeMessage message = new MimeMessage(session); //cria a mensagem setando o remetente e seus destinatários
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(this.para)); //Para: setamos o 1° destinatario
			//message.setFrom(new InternetAddress(this.de));//seta remetente
			message.setSubject("Confirmação de Cadastro no sistema!");//assunto
			//message.addRecipient(Message.RecipientType.CC, new InternetAddress (this.lista));//setando demais destinatários	CC		
			message.setSentDate(new Date());//data			
			message.setContent("E-mail de confirmação de cadastro no sistema! ","text/html; charset=ISO-8859-1");//mensagem
			
			Transport.send(message);
			
			return true;			
		}
		catch (MessagingException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	public boolean enviarRFP(){
		try{
			MimeMessage message = new MimeMessage(session); //cria a mensagem setando o remetente e seus destinatários
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(this.para)); //setamos o 1° destinatario
			//message.setFrom(new InternetAddress(this.de));//seta remetente
			message.setSubject("Solicitação de Proposta");//assunto
			//message.addRecipient(Message.RecipientType.CC, new InternetAddress (this.lista));//setando demais destinatários			
			message.setSentDate(new Date());			
			message.setContent("Solicitação de proposta registrado com sucesso!","text/html; charset=ISO-8859-1");//mensagem
			Transport.send(message);
			
			return true;			
		}
		catch (MessagingException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	public boolean enviarRFI(){
		try{
			MimeMessage message = new MimeMessage(session); //cria a mensagem setando o remetente e seus destinatários
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(this.para)); //setamos o 1° destinatario
			//message.setFrom(new InternetAddress(this.de));//seta remetente
			message.setSubject("Solicitação de Informação");//assunto
			//message.addRecipient(Message.RecipientType.CC, new InternetAddress (this.lista));//setando demais destinatários			
			message.setSentDate(new Date());			
			message.setContent("Solicitação de Informação registrado com sucesso!","text/html; charset=ISO-8859-1");//mensagem
			Transport.send(message);
			
			return true;			
		}
		catch (MessagingException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	public boolean enviarCliente(){
		try{
			MimeMessage message = new MimeMessage(session); //cria a mensagem setando o remetente e seus destinatários
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(this.para)); //setamos o 1° destinatario
			//message.setFrom(new InternetAddress(this.de));//seta remetente
			message.setSubject("Cadastro de Cliente no Sispromaper!");
			//message.addRecipient(Message.RecipientType.CC, new InternetAddress (this.lista));//setando demais destinatários			
			message.setSentDate(new Date());			
			message.setContent("Olá, cadastro de cliente executado com sucesso!","text/html; charset=ISO-8859-1");
			Transport.send(message);
			
			return true;			
		}
		catch (MessagingException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	public boolean enviarEventoParticipante(){
		try{
			MimeMessage message = new MimeMessage(session); //cria a mensagem setando o remetente e seus destinatários
			//message.setRecipient(Message.RecipientType.TO, new InternetAddress(this.para)); //setamos o 1° destinatario
			//message.setFrom(new InternetAddress(this.de));//seta remetente
			message.setSubject(this.assunto);
			message.addRecipient(Message.RecipientType.CC, new InternetAddress(this.participantes));//setando demais destinatários			
			message.setSentDate(new Date());			
			message.setContent(this.descricao,"text/html; charset=ISO-8859-1");
			Transport.send(message);
			
			return true;			
		}
		catch (MessagingException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	public boolean enviarProjetoInicio(){
		try{
			MimeMessage message = new MimeMessage(session); //cria a mensagem setando o remetente e seus destinatários
			//message.setRecipient(Message.RecipientType.TO, new InternetAddress(this.para)); //setamos o 1° destinatario
			//message.setFrom(new InternetAddress(this.de));//seta remetente
			message.setSubject(this.projeto);					
			message.addRecipient(Message.RecipientType.CC, new InternetAddress (this.copia));//setando demais destinatários
			message.setSentDate(new Date());			
			message.setContent(this.objetivo,"text/html; charset=ISO-8859-1");
				
			Transport.send(message);
			
			return true;			
		}
		catch (MessagingException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	public boolean enviarSolicitacaoCadastro(){
		try{
			MimeMessage message = new MimeMessage(session); //cria a mensagem setando o remetente e seus destinatários
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(this.email)); //setamos o 1° destinatario
			//message.setFrom(new InternetAddress(this.de));//seta remetente
			message.setSubject(this.status);					
			message.addRecipient(Message.RecipientType.CC, new InternetAddress (this.copia));//setando demais destinatários
			message.setSentDate(new Date());			
			message.setContent(this.obs,"text/html; charset=ISO-8859-1");
				
			Transport.send(message);
			
			return true;			
		}
		catch (MessagingException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	public boolean enviarRegistroParteInteressada(){
		try{
			MimeMessage message = new MimeMessage(session); //cria a mensagem setando o remetente e seus destinatários
			//message.setRecipient(Message.RecipientType.TO, new InternetAddress(this.para)); //setamos o 1° destinatario
			//message.setFrom(new InternetAddress(this.de));//seta remetente
			message.setSubject(this.projeto);					
			message.addRecipient(Message.RecipientType.CC, new InternetAddress(this.copia));//setando demais destinatários CC / new InternetAddress(this.copia)
			message.setSentDate(new Date());			
			message.setContent(this.aprovacao,"text/html; charset=ISO-8859-1");//mensagem do e-mail
				
			Transport.send(message);
			
			return true;			
		}
		catch (MessagingException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	public boolean enviarOrganograma(){
		try{
			MimeMessage message = new MimeMessage(session); //cria a mensagem setando o remetente e seus destinatários
			//message.setRecipient(Message.RecipientType.TO, new InternetAddress(this.para)); //setamos o 1° destinatario
			//message.setFrom(new InternetAddress(this.de));//seta remetente
			message.setSubject(this.projeto);					
			message.addRecipient(Message.RecipientType.CC, new InternetAddress(this.copia));//setando demais destinatários CC / new InternetAddress(this.copia)
			message.setSentDate(new Date());			
			message.setContent(this.comentario,"text/html; charset=ISO-8859-1");//mensagem do e-mail
				
			Transport.send(message);
			
			return true;			
		}
		catch (MessagingException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	public boolean enviarSolicitacaoServicoTI(){
		try{
			MimeMessage message = new MimeMessage(session); //cria a mensagem setando o remetente e seus destinatários
			//message.setRecipient(Message.RecipientType.TO, new InternetAddress(this.para)); //setamos o 1° destinatario
			//message.setFrom(new InternetAddress(this.de));//seta remetente
			message.setSubject(this.assunto);					
			message.addRecipient(Message.RecipientType.CC, new InternetAddress(this.copia));//setando demais destinatários CC / new InternetAddress(this.copia)
			message.setSentDate(new Date());			
			message.setContent("Solicitação de Serviço de T.I, cadastrada com sucesso!","text/html; charset=ISO-8859-1");//mensagem do e-mail
				
			Transport.send(message);
			
			return true;			
		}
		catch (MessagingException e) {
			e.printStackTrace();
		}		
		return false;
	}
	

	public String getParticipantes() {
		return participantes;
	}
	public void setParticipantes(String participantes) {
		this.participantes = participantes;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getDe() {
		return de;
	}
	public void setDe(String de) {
		this.de = de;
	}
	public String getPara() {
		return para;
	}
	public void setPara(String para) {
		this.para = para;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}	
	public String getLista() {
		return lista;
	}
	public void setLista(String lista) {
		this.lista = lista;
	}
	public String getProjeto() {
		return projeto;
	}
	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public String getCopia() {
		return copia;
	}
	public void setCopia(String copia) {
		this.copia = copia;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAprovacao() {
		return aprovacao;
	}
	public void setAprovacao(String aprovacao) {
		this.aprovacao = aprovacao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCodigoprojeto() {
		return codigoprojeto;
	}

	public void setCodigoprojeto(String codigoprojeto) {
		this.codigoprojeto = codigoprojeto;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
}

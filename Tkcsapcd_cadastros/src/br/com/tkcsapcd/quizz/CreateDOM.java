/*Armazenar as perguntas do question�rio. Nota que armazenamos as perguntas em 
 * arquivos XML separados, e n�o no banco de dados. 
 
<?xml version="1.0" encoding="UTF-8"?>
<quiz>
  <title>Certifica��o (2016/06/10)</title>
  <totalQuizQuestions>50</totalQuizQuestions>
  <quizDuration>60</quizDuration>
    <questions>   
	
	<question>
		<quizquestion>
		
		</quizquestion>
		<answer></answer>
		<answer></answer>
		<answer></answer>
		<answer></answer>
        <correct></correct>
	</question>
	
    </questions>
</quiz>

Como ler as perguntas armazenados no arquivo XML
Para ler as perguntas a partir do arquivo XML criamos um documento que representa 
o arquivo XML contendo perguntas do quiz. Sempre que o usu�rio clica no bot�o 
seguinte ou anterior a que chamamos o setQuestion (int i) m�todo, dando o �ndice 
de pergunta que queremos ler e ao mesmo tempo a essa pergunta � salvo em um ArrayList
de QuizQuestion.

 * */
package br.com.tkcsapcd.quizz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class CreateDOM {
	
	
	public static Document getDOM(String test) throws SAXException,ParserConfigurationException,IOException, URISyntaxException
	{
		    Document dom=null;
		    File quizFile=null;
		    			
			/*String c1 = System.getProperty("user.home");
			String caminho = c1+"/appservers/apache-tomcat-7x/webapps/Quizzes/";
			System.out.println("Caminho: "+caminho);
			
			quizFile=new File(caminho+test+"-quiz-1.xml");//Produ��o servidor
			System.out.println("quizFile: "+quizFile);*/
			
			quizFile=new File("C:\\quizzes\\"+test+"-quiz-1.xml");//local
	        System.out.println("Question�rio Arquivo caminho absoluto: "+quizFile.getAbsolutePath());
	         
	   DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
	   DocumentBuilder db=dbf.newDocumentBuilder();
	   try{
	        dom=db.parse(quizFile);
	        //System.out.println("CreatDOM dom: "+dom);
	   }catch(FileNotFoundException fileNotFound){
		   System.out.println("Erro: Quiz Arquivo n�o encontrado: "+fileNotFound);
	   }
	   dom.getDocumentElement().normalize();
	   return dom;
	}

}

/*ExamController é o principal controle de onde nós controlamos o exame. Aqui nós salvar seleções do usuário
 *  (o usuário responderam à questão) em um mapa. ExamController também deixa o movimento do usuário através
 *  de perguntas clicando seguinte e anterior botão na extremidade traseira é o ExamController que faz
 *  a função chama para recuperar perguntas e respostas armazenamento do usuário.*/
package br.com.tkcsapcd.quiz.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.com.tkcsapcd.quizz.Exam;
import br.com.tkcsapcd.quizz.QuizQuestion;

/**
 * Servlet implementation class ExamController
 */
@WebServlet("/exam")
public class ExamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		boolean finish=false;
		
		HttpSession session=request.getSession();		
		try
		{
			if(session.getAttribute("currentExam")==null)
		  {  session=request.getSession(); 	
		     String selectedExam=(String)request.getSession().getAttribute("exam"); 
		   
		     Object ob= session.getAttribute("totalNumberOfQuizQuestions");
		     
		     String sob=(String)ob;
			 Exam newExam=new Exam(selectedExam,Integer.parseInt(sob));
			 session.setAttribute("currentExam",newExam);
			 String sq=(String)request.getSession().getAttribute("totalNumberOfQuizQuestions");
			
			 newExam.setTotalNumberOfQuestions(Integer.parseInt(sq));
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss a");
				Date date = new Date();
				String started=dateFormat.format(date);
			  session.setAttribute("started",started);
		  }
		
		}catch(Exception e){e.printStackTrace();}
		
        Exam exam=(Exam)request.getSession().getAttribute("currentExam");		
        
        if(exam.currentQuestion==0){	
			exam.setQuestion(exam.currentQuestion);
		    QuizQuestion q=exam.questionList.get(exam.currentQuestion);	
			session.setAttribute("quest",q);
        }
			
			String action=request.getParameter("action");			
			
			int minute=-1;
			int second=-1;
			/*Atualizando o cronômetro de contagem regressiva na sessão do usuário. Nós recuperar os valores
			  de minuto e segundo parâmetros enviados para o controlador de Exame e atualizá-lo em sessão users.
			*/
			if(request.getParameter("minute")!=null)
			{			
			minute=Integer.parseInt(request.getParameter("minute"));
			second=Integer.parseInt(request.getParameter("second"));
			request.getSession().setAttribute("min",request.getParameter("minute") );
			request.getSession().setAttribute("sec",request.getParameter("second") );
			}
			
			String radio=request.getParameter("answer");
			int selectedRadio=-1;
			exam.selections.put(exam.currentQuestion, selectedRadio);
			if("1".equals(radio))
			{
				selectedRadio=1;
				exam.selections.put(exam.currentQuestion, selectedRadio);
				exam.questionList.get(exam.currentQuestion).setUserSelected(selectedRadio);				
			}
			else if("2".equals(radio))
			{
				selectedRadio=2;
				exam.selections.put(exam.currentQuestion, selectedRadio);
				exam.questionList.get(exam.currentQuestion).setUserSelected(selectedRadio);				
			}
			else if("3".equals(radio))
			{
				selectedRadio=3;
				exam.selections.put(exam.currentQuestion, selectedRadio);
				exam.questionList.get(exam.currentQuestion).setUserSelected(selectedRadio);				
			}
			else if("4".equals(radio))
			{
				selectedRadio=4;
				exam.selections.put(exam.currentQuestion, selectedRadio);
				exam.questionList.get(exam.currentQuestion).setUserSelected(selectedRadio);				
			}						
			if("Next".equals(action)){
				exam.currentQuestion++;
				exam.setQuestion(exam.currentQuestion);
			    QuizQuestion q=exam.questionList.get(exam.currentQuestion);	
			  	session.setAttribute("quest",q);
			}
			else if("Previous".equals(action))
			{   
				System.out.println("Você clicou Botão Anterior");
				exam.currentQuestion--;
				exam.setQuestion(exam.currentQuestion);
			    QuizQuestion q=exam.questionList.get(exam.currentQuestion);	
				session.setAttribute("quest",q);				
			}
			/*O exame será finalizado quando o usuário finalizar ou quando o limite de tempo para o exame é longo.*/
			else if("Finish Exam".equals(action)||( minute==0 && second==0))
			{   finish=true;
			/*Submetendo o Exame e Avaliação Resultado Exame. Quando o usuário clica no botão Concluir, ExamController
			 *chama o método calculateResult () passando o objeto Exame, calculateResult ()*/
				int result=exam.calculateResult(exam,exam.questionList.size());					
				request.setAttribute("result",result);				
				request.getRequestDispatcher("/jsps/result.jsp").forward(request,response);				
			}						
		if(finish!=true){
		request.getRequestDispatcher("/jsps/exam.jsp").forward(request,response);
		}		
	}
}

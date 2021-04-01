/*MainController onde tenha escrito o código para redirecionar o usuário para 
 * a página apropriada de acordo com a url solicitação de entrada.
*/
package br.com.tkcsapcd.quiz.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.Document;

import br.com.tkcsapcd.quizz.CreateDOM;

@WebServlet(urlPatterns = { "/login", "/register", "/takeExam", "/logout" })
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String applicationContextPath = request.getContextPath();

		if (request.getRequestURI().equals(applicationContextPath + "/")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
			dispatcher.forward(request, response);
			
		} else if (request.getRequestURI().equals(applicationContextPath + "/login")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/login.jsp");
			dispatcher.forward(request, response);
		} else if (request.getRequestURI().equals(
				applicationContextPath + "/register")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/register.jsp");
			dispatcher.forward(request, response);
		} else if (request.getRequestURI().equals(applicationContextPath + "/takeExam")) {
			
			request.getSession().setAttribute("currentExam", null);
			request.getSession().setAttribute("totalNumberOfQuizQuestions",null);
			request.getSession().setAttribute("quizDuration",null);
			request.getSession().setAttribute("min",null);
			request.getSession().setAttribute("sec",null);

			String exam = request.getParameter("test");
			request.getSession().setAttribute("exam", exam);

			System.out.println("Sessão MainController: "+request.getSession().getAttribute("login"));
			
			if (request.getSession().getAttribute("login") == null) {
				request.getRequestDispatcher("/login").forward(request,response);
				
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/quizDetails.jsp");
				Document document=null;
				try{
				document=CreateDOM.getDOM(exam);
				System.out.println("MainController document: "+document);
				
				/*
				 Ajuste do temporizador ao iniciar um novo exame Quando o usuário inicia um novo exame, vamos 
				 definir o total das questões e duração do teste na userSession como um atributo.
				 * */
				request.getSession().setAttribute("totalNumberOfQuizQuestions",document.getElementsByTagName("totalQuizQuestions").item(0).getTextContent());
				request.getSession().setAttribute("quizDuration",document.getElementsByTagName("quizDuration").item(0).getTextContent());
				request.getSession().setAttribute("min",document.getElementsByTagName("quizDuration").item(0).getTextContent());
				request.getSession().setAttribute("sec",0);				
				}				
				catch(Exception e){e.printStackTrace();}
				dispatcher.forward(request, response);
			}
		} else if (request.getRequestURI().equals(applicationContextPath + "/logout")) {
			request.getSession().invalidate();
			RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
			dispatcher.forward(request, response);
		}

	}

}

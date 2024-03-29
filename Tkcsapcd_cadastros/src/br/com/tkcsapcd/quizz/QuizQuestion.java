/*QuizQuestion � a classe que representa uma �nica pergunta do question�rio; cada 
 * quest�o ter� um n�mero, declara��o pergunta, op��es e um �ndice de op��o correta.*/
package br.com.tkcsapcd.quizz;

public class QuizQuestion {
	
	int questionNumber;
	String question;
	String questionOptions[];
	int correctOptionIndex;
	int userSelected=-1;	
	
	public int getUserSelected() {
		return userSelected;
	}

	public void setUserSelected(int userSelected) {
		this.userSelected = userSelected;
	}

	public String getQuestion()
	{ 
		return question;
	}
	
	public int getQuestionNumber()
	{
		return questionNumber;
	}
	
	public void setQuestionNumber(int i)
	{
		questionNumber=i;
	}
	
	public int getCorrectOptionIndex()
	{
		return correctOptionIndex;
	}
	
	public String[] getQuestionOptions()
	{
		return questionOptions;
	}
	
	public void setQuestion(String s)
	{
		question=s;
	}
	public void setCorrectOptionIndex(int i)
	{
		correctOptionIndex=i;
	}
	public void setQuestionOptions(String[]s)
	{
		questionOptions=s;
	}
	
	public String toString(){
		String str= questionNumber+"."+getQuestion();
		for(String option:getQuestionOptions()){
			str=str+option+"  ";
		}
		str=str+"\n Correct Answer : "+getCorrectOptionIndex();
		return str;
	}

}

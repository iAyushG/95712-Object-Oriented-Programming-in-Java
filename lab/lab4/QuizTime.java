/*
 * NAME: AYUSH GUPTA
 * Andrew ID: ayushgu2
 * @author ayush
 */

package lab4;

import java.util.Scanner;

public class QuizTime {

	Quiz[] quizzes = { new MathQuiz(), new EnglishQuiz("EnglishQuizWords.txt") };  //Your program must use these two objects. No new quiz objects to be created.
	Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		QuizTime quizTime = new QuizTime();
		quizTime.startQuiz();
	}

	//do not change this method
	void startQuiz() {
		int choice = 0;
		while (true) {
			System.out.println("*** Welcome to QuizTime!***"); 
			System.out.println("1. Math Quiz");
			System.out.println("2. English Quiz");
			System.out.println("3. Exit");
			System.out.println("Enter choice: ");
			choice = input.nextInt(); 
			if (choice == 1 || choice == 2) {
				runQuiz(choice);
			} else {
				System.out.println("Your Math score: " + MathQuiz.score + "/" + MathQuiz.count);
				System.out.println("Your English score: " + EnglishQuiz.score + "/" + EnglishQuiz.count);
				System.out.println("Your total score: " + Quiz.score + "/" + (MathQuiz.count + EnglishQuiz.count));
				break;
			}
		}
	}
	
	/**runQuiz() uses choice to index into quizzes array, and then invokes
	 * createQuestion() and createAnswer() methods.
	 * It then prints the question, takes user input, invokes checkAnswer() to check answer
	 * and then prints whether the answer is Correct or Incorrect.
	 * @param choice
	 */
	void runQuiz(int choice) {
	    Quiz selectedQuiz = quizzes[choice - 1];

	    selectedQuiz.createQuestion();
	    selectedQuiz.createAnswer();

	    System.out.println("What is: " + selectedQuiz.questionString);
	    input.nextLine();

	    String userAnswer = input.nextLine();

	    boolean isCorrect = selectedQuiz.checkAnswer(userAnswer);

	    if (isCorrect) {
	        System.out.println("Correct!");
	    } 
	    else {
	        System.out.println("Incorrect!");
	    }
	}
}
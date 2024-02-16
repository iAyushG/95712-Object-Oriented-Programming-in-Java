/*
 * NAME: AYUSH GUPTA
 * Andrew ID: ayushgu2
 * @author ayush
 */

package lab4;

import java.util.Random;

public class MathQuiz extends Quiz {
	
	Random random = new Random();
	
	int operand1;
	int operand2;
	char operator;
	static int count;
	static int score;
	
	void createQuestion() {
		operand1 = random.nextInt(10);
		operand2 = random.nextInt(10);
		
		char[] operators = {'+', '-', '*'};
		operator = operators[random.nextInt(operators.length)];
		
		questionString = operand1 + "" + operator + operand2;
	}
	
	void createAnswer() {
		int answer = 0;
		
		switch(operator) {
		case '+':
			answer = operand1 + operand2;
			break;
		case '-':
			answer = operand1 - operand2;
			break;
		case '*':
			answer = operand1 * operand2;
			break;
		default:
			break;
		}
		answerString = String.valueOf(answer);
	}
	
	boolean checkAnswer(String answer) {
	    count++;
	    Quiz.count++;

	    int answerInt;

	    if (!answer.isEmpty()) {
	        try {
	            answerInt = Integer.parseInt(answer);

	            boolean isCorrect;

	            if (answerInt == Integer.parseInt(answerString)) {
	                isCorrect = true;
	                score++;
	                Quiz.score++;
	            } 
	            else {
	                isCorrect = false;
	            }

	            return isCorrect;
	        } 
	        catch (NumberFormatException e) {
	            return false;
	        }
	    } 
	    else {
	        return false;
	    }
	}
}
/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 */

package lab1;

import java.util.*;

public class Calculator {	
	String expression; //stores the arithmetic expression input by the user 
	double result=0; //stores the result 

	//do not change this method
	public static void main(String[] args) {	
		Calculator c = new Calculator();
		c.getUserInput();
		c.calculate();
		System.out.printf( " = %f", c.result);
	}

	//get user input to initialize 'expression' variable
	public void getUserInput() {
		//write your code here
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the expression with operands and operators separated by a space:");
		expression = s.nextLine();
		s.close();
	}

	public void calculate() {
	    //write your code here
	    Scanner tokens = new Scanner(expression);
	    tokens.useDelimiter("\\s+");
	    String token;
	    String operator = null;

	    if (!tokens.hasNext()) {
	        result = 0;
	    } 
	    else {
	        token = tokens.next();
	        double number = Double.parseDouble(token);
	        result += number;
	        while (tokens.hasNext()) {
	            token = tokens.next();
	            if (token.matches("[-+/*]")) {
	                operator = token;
	            } 
				else if (token.matches("[+-]?[0-9]+")) {
	                number = Double.parseDouble(token);

	                switch (operator) {
	                    case "+":
	                        result += number;
	                        break;
	                    case "-":
	                        result -= number;
	                        break;
	                    case "*":
	                        result *= number;
	                        break;
	                    case "/":
	                        result /= number;
	                        break;
	                }
	            }
	        }
	    }

	    tokens.close();
	}
}
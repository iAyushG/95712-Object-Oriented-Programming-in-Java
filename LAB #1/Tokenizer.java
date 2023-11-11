import java.util.Scanner;

public class Tokenizer {
	public static void main(String[] args) {
		Tokenizer tokenizer = new Tokenizer();
		tokenizer.tokenize();
	}
	void tokenize() {
		Scanner input = new Scanner(System.in); //scanner attached to keyboard
		System.out.println("Enter something with whitespaces");
		String str = input.nextLine();
		Scanner tokens = new Scanner(str);  //scanner attached to a string
		tokens.useDelimiter("\\s+");
		while (tokens.hasNext()) {
			String token = tokens.next(); //break by whitespaces
			if (token.matches("[0-9]+")) 
				System.out.println(token + ": it's a number");
			else 
				System.out.println(token + ": not a number");
		}
		input.close();
		tokens.close();
	}
}

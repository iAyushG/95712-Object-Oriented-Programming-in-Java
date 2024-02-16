/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 */

package exam2;

import java.util.Scanner;

public class Messenger {

	Message[] messages = {new Caesar(), new Keyword()}; //these objects must be used for encryption / decryption. No new instances of Caesar or Keywold should be created.
	Scanner input = new Scanner(System.in); //to take user inputs

	public static void main(String[] args) {
		Messenger messenger = new Messenger();
		messenger.runMessenger();
	}

	/** runMessenger() prints the menu options, takes user input,
	 * invokes methods from appropriate classes to encrypt or decrypt
	 * messages, and then prints the output
	 */
	void runMessenger() {
		System.out.println("Choose ...");
		System.out.println("1. Caesar encryption");
		System.out.println("2. Keyword encryption");
		System.out.println("3. Caesar decryption");
		System.out.println("4. Keyword decryption");
		int choice = input.nextInt();
		input.nextLine(); //to clear buffer
		
		//write rest of your code here
		
		if (choice == 1 || choice == 2) {
			System.out.println("Enter message to encrypt");
		}
		else if (choice == 3 || choice == 4) {
			System.out.println("Enter message to decrypt");   
		}
		else {
	        System.out.println("Invalid choice. Please select from the given options.");
	        return;
	    }
		
		String message = input.nextLine();
	    String key;
	    System.out.println("Enter key");
	    key = input.nextLine();
	    
	    Message chosenMessage = null;

	    if (choice == 1 || choice == 3) {
	        chosenMessage = messages[0];
	    } 
	    else if (choice == 2 || choice == 4) {
	        chosenMessage = messages[1];
	    }

	    chosenMessage.setMessage(message, key);

	    if (choice == 1 || choice == 2) { 
	        System.out.println("Encrypted message: " + chosenMessage.encrypt());
	    } 
	    else {
	        System.out.println("Decrypted message: " + chosenMessage.decrypt());
	    }
	}
}
/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 */

package hw1;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CCModel {
	Case[] cases;
	String[] fileData;

	/**loadData() takes filename as a parameter,
	 * reads the file and loads all 
	 * data as a String for each row in 
	 * fileData[] array
	 * @param filename
	 */
	void loadData(String filename) {
		//write your code here
	    // Initialize a StringBuilder to store file content
	    StringBuilder fileContent = new StringBuilder();

	    try (Scanner fileScanner = new Scanner(new File(filename))) {
	        // Read each line from the file and append to the StringBuilder
	        while (fileScanner.hasNextLine()) {
	            fileContent.append(fileScanner.nextLine()).append("\n");
	        }
	    } 
	    catch (FileNotFoundException e) {
	        // Handling the exception
	        e.printStackTrace();
	    }

	    // Split the accumulated content into an array of lines
	    fileData = fileContent.toString().split("\n");
	}


	/**loadCases() uses the data stored in fileData array
	 * and creates Case objects for each row.
	 * These cases are loaded into the cases array.
	 * Note that you may have to traverse the fileData array twice
	 * to be able to initialize the cases array's size.
	 */
	void loadCases() {
	    if (fileData != null) {
	    	//write your code here
	        // First pass to determine the size of cases array
	        int numCases = 0;
	        for (String row : fileData) {
	            if (!row.trim().isEmpty()) {
	                numCases++;
	            }
	        }

	        // Initialize cases array
	        cases = new Case[numCases];

	        // Second pass to populate the cases array
	        int index = 0;
	        
	        for (String row : fileData) {
	            if (!row.trim().isEmpty()) {
	                // Since, data in each row is tab-separated
	                String[] rowData = row.split("\t");
	                // Since, rowData contains date, title, case type (in parenthesis), and case number in order
	                String date = rowData[0];
	                String title = rowData[1];
	                String caseType = "";
	                String caseNumber = rowData.length > 2 ? rowData[2] : "";
	                
	                // Finding the location of the last Parenthesis
	                int lastOpenParenthesisLocation = title.lastIndexOf("(");
	                int lastClosedParenthesisLocation = title.lastIndexOf(")");
	                
	                if (lastOpenParenthesisLocation != -1 && lastClosedParenthesisLocation != -1) {
	                    caseType = title.substring(lastOpenParenthesisLocation + 1, lastClosedParenthesisLocation);
	                    title = title.substring(0, lastOpenParenthesisLocation).trim();
	                }

	                // Adding the data into the cases array
	                cases[index++] = new Case(date, title, caseType, caseNumber);
	            }
	        }
	    }
	}
}
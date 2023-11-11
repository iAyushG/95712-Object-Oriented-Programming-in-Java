/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 */

package hw1;

import java.util.Arrays;
import java.util.Scanner;

public class CyberCop {

	public static final String DATAFILE = "data/FTC-cases-TSV.txt";
	CCModel ccModel = new CCModel();
	SearchEngine searchEngine = new SearchEngine();

	Scanner input = new Scanner(System.in);

	/**main() instantiates CyberCop and then invokes dataManager's loadData
	 * and loadCases() methods
	 * It then invokes showMenu to get user input
	 * @param args
	 */
	//Do not change this method
	public static void main(String[] args) {
		CyberCop cyberCop = new CyberCop();
		cyberCop.ccModel.loadData(DATAFILE);
		cyberCop.ccModel.loadCases();
		cyberCop.showMenu();
	}
	
	/**showMenu() shows the menu. 
	 * Based on the user choice, it invokes one of the methods:
	 * printSearchResults(), printCaseTypeSummary(), or printYearwiseSummary()
	 * The program exits when user selects Exit option. 
	 * See the hand-out for the expected layout of menu-UI
	 */
	void showMenu() {
		//write your code here
		
	    int choice; // Variable for choice

	    // Printing the menu
	    System.out.println("*** Welcome to CyberCop! ***");
	    System.out.println("1. Search cases for a company");
	    System.out.println("2. Search cases in a year");
	    System.out.println("3. Search by case number");
	    System.out.println("4. Print Case-type Summary");
	    System.out.println("5. Print Year-wise Summary");
	    System.out.println("6. Exit");

	    choice = input.nextInt(); // Taking input from the user
	    input.nextLine();  // Consume the newline character

	    System.out.println("-----------------------------------------------------------------");

	    // Switch case to run the required menu option/function
	    switch (choice) {
	        case 1:
	            System.out.println("Enter search string");
	            String companySearch = input.nextLine();
	            Case[] companyResults = searchEngine.searchTitle(companySearch, ccModel.cases);
	            printSearchResults(companySearch, companyResults);
	            break;
	        case 2:
	            System.out.println("Enter search year as YYYY");
	            System.out.println("-----------------------------------------------------------------");
	            String yearSearch = input.nextLine();
	            Case[] yearResults = searchEngine.searchYear(yearSearch, ccModel.cases);
	            printSearchResults(yearSearch, yearResults);
	            break;
	        case 3:
	            System.out.println("Enter case number");
	            System.out.println("-----------------------------------------------------------------");
	            String caseNumberSearch = input.nextLine();
	            Case[] caseNumberResults = searchEngine.searchCaseNumber(caseNumberSearch, ccModel.cases);
	            printSearchResults(caseNumberSearch, caseNumberResults);
	            break;
	        case 4:
	            // Call a method to print Case-type Summary
	            printCaseTypeSummary();
	            break;
	        case 5:
	            // Call a method to print Year-wise Summary
	            printYearWiseSummary();
	            break;
	        case 6:
	            System.out.println("Exiting program. Thank you for using CyberCop 1.0!");
	            System.out.println("-----------------------------------------------------------------");
	            return;  // Exit the method
	        default:
	            System.out.println("Invalid choice. Please enter a valid option."); // When the user enters an invalid input.
	    }
	}

	/**printSearchResults() takes the searchString and array of cases as input
	 * and prints them out as per the format provided in the handout
	 * @param searchString
	 * @param cases
	 */
	void printSearchResults(String searchString, Case[] cases) {
	    //write your code here
		// When search returns some results
		if (cases != null) {
			// Printing in the format provided in the hand-out
			System.out.println("-----------------------------------------------------------------");
		    System.out.printf("%d case(s) found for %s%n", cases.length, searchString);
		    System.out.println("-----------------------------------------------------------------");
		    System.out.printf(" #. %-12s %-60s %-30s %25s%n", "Last Update", "Case Title", "Case Type", "Case/File Number");
		    System.out.println("-----------------------------------------------------------------");
		    
		    int i = 1;
		    
		    for (Case result : cases) {
		        System.out.printf(" %d. %-12s %-60s %-30s %25s%n", i++, result.caseDate, result.caseTitle, result.caseType, result.caseNumber);
		    }
		    
		    System.out.println("-----------------------------------------------------------------");
		}
		// When the search returns no results
		else {
			System.out.println("-----------------------------------------------------------------");
		    System.out.printf("Sorry, no search results found for %s%n", searchString);
		    System.out.println("-----------------------------------------------------------------");
		}
	}
	
	/**printCaseTypeSummary() prints a summary of
	 * number of cases of different types as per the 
	 * format given in the handout.
	 */
	void printCaseTypeSummary() {
		//write your code here
		int adminCount = 0; // Variable to count no. of Administrative type cases
		int federalCount = 0; // Variable to count no. of Federal type cases
		int otherCount = 0; // Variable to count no. of Unknown type cases
		
		// Counting the no. of cases of each type
		for (Case caseType : ccModel.cases) {
			if (caseType.caseType.equalsIgnoreCase("Administrative")) {
				adminCount++;
			}
			else if (caseType.caseType.equalsIgnoreCase("Federal")) {
				federalCount++;
			}
			else {
				otherCount++;
			}
		}
		
		// Printing the summary as per the format in the hand-out
		System.out.println("*** Case Type Summary Report ***");
		System.out.printf("No. of Administrative cases: %d%n", adminCount);
		System.out.printf("No. of Federal cases: %d%n", federalCount);
		System.out.printf("No. of Unknown case types: %d%n", otherCount);
		System.out.println("-----------------------------------------------------------------");
	}
	
	/**printYearWiseSummary() prints number of cases in each year
	 * as per the format given in the handout
	 */
	void printYearWiseSummary() {
		//write your code here
		int[] uniqueYears = new int[ccModel.cases.length]; // Variable to get all the unique years present in the dataset
		int uniqueCount = 0; // Variable to count the number of unique years present in the dataset
		
		// Iterating through cases to find the unique years
		for (Case c : ccModel.cases) {
			int year = c.getYear();
			boolean check = false; // Boolean variable to check if the year is already present in the uniqueYears array
			
			// Checking to see if all unique years are in the array
			for (int i = 0; i < uniqueCount; i++) {
				if (uniqueYears[i] == year) {
					check = true;
					break;
				}
			}
			
			// Condition to add year to uniqueYears array if not already present
			if (!check) {
				uniqueYears[uniqueCount++] = year;
			}
		}
		
		// Since, uniqueYears array is longer, we will make a new array that is restricted to the exact number of array elements. NO EXTRAS.
		int[] trimmedUniqueYears = new int[uniqueCount];
		System.arraycopy(uniqueYears, 0, trimmedUniqueYears, 0, uniqueCount); // Copying from uniqueYears array to trimmedUniqueYears array
		
		Arrays.sort(trimmedUniqueYears); // Sorting the array in ascending order
		
		int[][] yearCount = new int[uniqueCount][2]; // A 2D array to store year and the count of cases in that year
		
		// Loop to order the years in descending order
		for (int i = 0; i < uniqueCount; i++) {
			yearCount[i][0] = trimmedUniqueYears[uniqueCount - i - 1];
		}
		
		// Loop to count the number of cases in each year
		for (int i = 0; i < uniqueCount; i++) {
			int count = 0;
			for (Case c : ccModel.cases) {
				int caseYear = c.getYear();
				if (caseYear == yearCount[i][0]) {
					count++;
				}
			}
			yearCount[i][1] = count; // Storing the number of cases in the corresponding array location
		}
		
		// Printing summary as per the format in the hand-out
		System.out.println("\t\t\t*** Year-wise Summary Report ***");
		System.out.println("\t\t\t*** Number of FTC cases per year ***");
		
		for (int i = 0; i < uniqueCount; i++) {
			if (i % 5 != 0) {
				System.out.printf("\t%d: %-2d", yearCount[i][0], yearCount[i][1]);
			}
			else {
				System.out.printf("%n\t%d: %-2d", yearCount[i][0], yearCount[i][1]);
			}
		}
		
		System.out.println("\n-----------------------------------------------------------------");
	}
}
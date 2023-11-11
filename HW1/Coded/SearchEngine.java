/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 */

package hw1;

public class SearchEngine {
	
	/**searchTitle() takes a searchString and array of cases,
	 * searches for cases with searchString in their title,
	 * and if found, returns them in another array of cases.
	 * If no match is found, it returns null.
	 * Search is case-insensitive
	 * @param searchString
	 * @param cases
	 * @return
	 */
	Case[] searchTitle(String searchString, Case[] cases) {
		//write your code here
		// Checking for null
		if (searchString == null || cases == null) {
			return null;
		}
		
		searchString = searchString.toLowerCase(); // Case-insensitive search

		int count = 0;

		// Count matching cases
		for (Case legalCase : cases) {
		    if (legalCase != null && legalCase.caseTitle != null && legalCase.caseTitle.toLowerCase().contains(searchString)) {
		        count++;
		    }
		}

		if (count == 0) {
			return null; // No matches found
		}

		// Create an array to store matching cases
		Case[] result = new Case[count];
		int index = 0;

		// Fill the result array with matching cases
		for (Case legalCase : cases) {
		    if (legalCase != null && legalCase.caseTitle != null && legalCase.caseTitle.toLowerCase().contains(searchString)) {
		        result[index++] = legalCase;
		    }
		}

		return result; // Returning the result
	}

	
	/**searchYear() takes year in YYYY format as search string,
	 * searches for cases that have the same year in their date,
	 * and returns them in another array of cases.
	 * If not found, it returns null.
	 * @param year
	 * @param cases
	 * @return
	 */
	Case[] searchYear(String year, Case[] cases) {
		//write your code here
		// Checking for null
		if (year == null || cases == null) {
			return null;
		}
		
		int count = 0;

		// Count matching cases
		for (Case legalCase : cases) {
			if (legalCase != null && String.valueOf(legalCase.getYear()) != null && String.valueOf(legalCase.getYear()).equals(year)) {
				count++;
			}
		}

		if (count == 0) {
			return null; // No matches found
		}

		// Create an array to store matching cases
		Case[] result = new Case[count];
		int index = 0;

		// Fill the result array with matching cases
		for (Case legalCase : cases) {
			if (legalCase != null && String.valueOf(legalCase.getYear()) != null && String.valueOf(legalCase.getYear()).equals(year)) {
				result[index++] = legalCase;
			}
		}

		return result; // Returning the result
	}
	
	/**searchCaseNumber() takes a caseNumber,
	 * searches for those cases that contain that caseNumber, 
	 * and returns an array of cases that match the search.
	 * If not found, it returns null.
	 * Search is case-insensitive.
	 * @param caseNumber
	 * @param cases
	 * @return
	 */
	Case[] searchCaseNumber(String caseNumber, Case[] cases) {
		//write your code here
		// Checking for null
	    if (caseNumber == null || cases == null) {
	        return null;
	    }

	    caseNumber = caseNumber.toLowerCase(); // Case-insensitive search

	    int count = 0;

	    // Count matching cases
	    for (Case legalCase : cases) {
	        // Checking if caseNumber or legalCase.caseNumber is null before calling toLowerCase()
	        if (legalCase.caseNumber != null && legalCase.caseNumber.toLowerCase().contains(caseNumber)) {
	            count++;
	        }
	    }

	    if (count == 0) {
	        return null; // No matches found
	    }

	    // Create an array to store matching cases
	    Case[] result = new Case[count];
	    int index = 0;

	    // Fill the result array with matching cases
	    for (Case legalCase : cases) {
	        // Checking if caseNumber or legalCase.caseNumber is null before calling toLowerCase()
	        if (legalCase.caseNumber != null && legalCase.caseNumber.toLowerCase().contains(caseNumber)) {
	            result[index++] = legalCase;
	        }
	    }

	    return result; // Returning the result
	}
}
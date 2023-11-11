/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 */

package hw1;

// Case class representing a legal case
public class Case {
    String caseDate; // Date in YYYY-MM-DD format
    String caseTitle; // Title of the case
    String caseType; // Type or category of the case
    String caseNumber; // Case number identifier

    // Constructor to initialize the Case object with provided values
    Case(String caseDate, String caseTitle, String caseType, String caseNumber) {
        // Write your code here
        this.caseDate = caseDate;
        this.caseTitle = caseTitle;
        this.caseType = caseType;
        this.caseNumber = caseNumber;
    }

    /** 
     * getYear() is an optional method to extract the year
     * from the caseDate. It can be useful 
     * for printing year-wise summary. 
     * @return The year extracted from the caseDate
     */
    int getYear() {
        // Write your code here
        // Splitting the date string using "-" as a delimiter
        String[] dateParts = caseDate.split("-");
        
        // Checking if there is at least one part in the date
        if (dateParts.length >= 1) {
            try {
                // Parsing the first part as an integer (parsing the year)
                int year = Integer.parseInt(dateParts[0]);
                return year;
            } 
            catch (NumberFormatException e) {
                // Handling the case where the parsing fails
                e.printStackTrace();
            }
        }
        
        // Return 0 if the date format is unexpected or parsing fails
        return 0;
    }
}
/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 * 
 * Author: iAyushGupta
 */

package hw3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSVCaseReader extends CaseReader {

    CSVCaseReader(String filename) {
        super(filename); // Constructor initializes the parent class with the provided filename
    }

    /**
     * Reads cases from a CSV file. Each row in the CSV file is converted to a Case object.
     * @return A list of Case objects.
     */
    @Override
    List<Case> readCases() {
        List<Case> caseList = new ArrayList<>();
        CSVFormat csvFormat = CSVFormat.DEFAULT.withFirstRecordAsHeader(); // CSV format with the first record as header

        try {
            // Parse the file using CSVParser
            CSVParser csvParser = CSVParser.parse(new FileReader(filename), csvFormat);
            
            // Iterating over records and creating Case objects
            for (CSVRecord csvRecord : csvParser) {
                Case c = new Case(csvRecord.get(0), 
                		          csvRecord.get(1), 
                		          csvRecord.get(2), 
                                  csvRecord.get(3), 
                                  csvRecord.get(4), 
                                  csvRecord.get(5), 
                                  csvRecord.get(6));
                caseList.add(c);
            }
        } 
        catch (FileNotFoundException fnfe) { 
            fnfe.printStackTrace(); // Handle file not found exceptions
        } 
        catch (IOException ioe) { 
            ioe.printStackTrace(); // Handle IO exceptions
        }
        
        return caseList;
    }
}
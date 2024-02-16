/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 * 
 * Author: iAyushGupta
 */

package hw3;

/**
 * Factory class for creating instances of CaseReader.
 * It determines the type of reader to instantiate based on the file extension.
 */
public class CaseReaderFactory {
    
    /**
     * Creates and returns an instance of a CaseReader.
     * It decides whether to create a CSVCaseReader or TSVCaseReader based on the file extension.
     * @param filename The name of the file to be read.
     * @return CaseReader instance suitable for the file type.
     */
    public CaseReader createReader(String filename) { 
        if (filename.contains(".tsv")) {
            return new TSVCaseReader(filename); // Creates a TSVCaseReader for .tsv files
        } 
        else {
            return new CSVCaseReader(filename); // Defaults to CSVCaseReader for .csv files
        }
    }
}
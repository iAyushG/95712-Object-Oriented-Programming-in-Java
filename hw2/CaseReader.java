/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 */

package hw2;

import java.util.List;

/**CaseReader class is used by CaseReaderFactory 
 * to initialize the data file to be read. 
 * Its readCases() method is implemented by 
 * CSVCaseReader and TSVCaseReader classes
 */
public abstract class CaseReader {

	String filename;

	// constructor
	CaseReader(String filename) {
		this.filename = filename;
	}

	// abstract list
	abstract List<Case> readCases();
}
/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 */

package hw2;

public class CaseReaderFactory {
	
	// returns an appropriate caseReader
	public CaseReader createReader(String filename) { 
		if (filename.contains(".tsv")) {
			return new TSVCaseReader(filename);
		} 
		else {
			return new CSVCaseReader(filename);
		}
	}
}
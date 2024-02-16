/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 */

package hw2;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TSVCaseReader extends CaseReader { 

	TSVCaseReader(String filename) {
		super(filename);
	}

	//implements readCases method and returns caseList
	@Override
	List<Case> readCases() {
		
		List<Case> caseList = new ArrayList<>();
		
		try {
			File file = new File(filename);
			Scanner sc = new Scanner(file);
			String line;
			String[] tokens;
			
			while (sc.hasNext()) {
				line = sc.nextLine();
				// using tab space as a delimiter since it is a TSV File
				tokens = line.split("\t");
				Case c = new Case(tokens[0], 
						          tokens[1], 
						          tokens[2], 
						          tokens[3], 
						          tokens[4], 
						          tokens[5], 
						          tokens[6]);
				caseList.add(c);
			}
			
			sc.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return caseList;
	}
}
package hw3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

public class CCModel {
	ObservableList<Case> caseList = FXCollections.observableArrayList(); // a list of case objects
	ObservableMap<String, Case> caseMap = FXCollections.observableHashMap(); // map with caseNumber as key and Case as
																				// value

	ObservableMap<String, List<Case>> yearMap = FXCollections.observableHashMap(); // map with each year as a key and a
																					// list of all cases dated in that
																					// year as value.

	ObservableList<String> yearList = FXCollections.observableArrayList(); // list of years to populate the yearComboBox
																			// in ccView

	/**
	 * readCases() performs the following functions: It creates an instance of
	 * CaseReaderFactory, invokes its createReader() method by passing the filename
	 * to it, and invokes the caseReader's readCases() method. The caseList returned
	 * by readCases() is sorted in the order of caseDate for initial display in
	 * caseTableView. Finally, it loads caseMap with cases in caseList. This caseMap
	 * will be used to make sure that no duplicate cases are added to data
	 * 
	 * @param filename
	 */
	void readCases(String filename) {
		// build caseList
		CaseReader caseReader = new CaseReaderFactory().createReader(filename);
		List<Case> tempList = caseReader.readCases();
		Collections.sort(tempList);
		caseList.addAll(tempList);

		// build caseMap
		for (Case c : caseList) {
			caseMap.put(c.getCaseNumber(), c);
		}
	}

	/**
	 * buildYearMapAndList() performs the following functions: 1. It builds yearMap
	 * that will be used for analysis purposes in Cyber Cop 3.0 2. It creates
	 * yearList which will be used to populate yearComboBox in ccView Note that
	 * yearList can be created simply by using the keySet of yearMap.
	 */
	void buildYearMapAndList() {
		for (Case c : caseList) {
			String date = c.getCaseDate();
			String year = date.split("-")[0];
			List<Case> yearCaseList;

			// build yearMap
			if (yearMap.containsKey(year)) {
				yearMap.get(year).add(c);
			} else {
				// build yearList;
				yearList.add(year);
				yearCaseList = new ArrayList<Case>();
				yearCaseList.add(c);
				yearMap.put(year, yearCaseList);
			}
		}
	}

	/**
	 * searchCases() takes search criteria and iterates through the caseList to find
	 * the matching cases. It returns a list of matching cases.
	 */
	ObservableList<Case> searchCases(String title, String caseType, String year, String caseNumber) {
		ObservableList<Case> matchCases = FXCollections.observableArrayList();
		for (Case c : caseList) {
			String cYear = c.getCaseDate().split("-")[0];
			boolean found = true;

			if (title != null) {
				found = c.getCaseTitle().toLowerCase().contains(title.toLowerCase());
			}
			if (caseType != null) {
				found &= c.getCaseType().equalsIgnoreCase(caseType);
			}
			if (year != null) {
				found &= cYear.equalsIgnoreCase(year);
			}
			if (caseNumber != null) {
				found &= c.getCaseNumber().contains(caseNumber);
			}

			if (found) {
				matchCases.add(c);
			}
		}
		return matchCases;
	}

//	void clear() {
//		ObservableList<Case> caseList = FXCollections.observableArrayList(); // a list of case objects
//		ObservableMap<String, Case> caseMap = FXCollections.observableHashMap(); // map with caseNumber as key and Case
//																					// as value
//		ObservableMap<String, List<Case>> yearMap = FXCollections.observableHashMap(); // map with each year as a key
//																						// and a list of all cases dated
//																						// in that year as value.
//		ObservableList<String> yearList = FXCollections.observableArrayList(); // list of years to populate the
//																				// yearComboBox in ccView
//	}

	// add a new case in CCModel, return false if fail
	boolean addCase(Case c) {
		if (c.getCaseDate().isBlank() || c.getCaseTitle().isBlank() || c.getCaseType().isBlank() || c.getCaseNumber().isBlank() || caseNumberExists(c.getCaseNumber())) {
			return false;
		}

		caseList.add(c);
		caseMap.put(c.getCaseNumber(), c);
		String date = c.getCaseDate();
		String year = date.split("-")[0];

		// build yearMap
		if (yearMap.containsKey(year)) {
			yearMap.get(year).add(c);
		} else {
			// build yearList;
			yearList.add(year);
			List<Case> yearCaseList = new ArrayList<Case>();
			yearCaseList.add(c);
			yearMap.put(year, yearCaseList);
		}

		return true;
	}

	boolean deleteCase(Case c) {
		if (!caseNumberExists(c.getCaseNumber())) {
			return false;
		}

		caseList.remove(c);
		caseMap.remove(c.getCaseNumber());
		String date = c.getCaseDate();
		String year = date.split("-")[0];

		// if this case is the only case in this year, remove the yearlist
		if (yearMap.get(year).size() == 1) {
			yearMap.remove(year);
			yearList.remove(year);
		} else {
			yearMap.get(year).remove(c);
		}

		return true;
	}

	boolean modifyCase(Case before, Case after) {
		if (after.getCaseDate().isBlank() || after.getCaseTitle().isBlank() || after.getCaseType().isBlank() || after.getCaseNumber().isBlank()) {
			return false;
		}

		if (caseNumberExists(after.getCaseNumber()) && before.getCaseNumber() != after.getCaseNumber()) {
			return false;
		}

		deleteCase(before);
		addCase(after);
		return true;
	}

	boolean writeCases(String filename) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename));) {
			for (Case c : caseList) {
				bw.write(String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\n", c.getCaseDate(), c.getCaseTitle(),
						c.getCaseType(), c.getCaseNumber(), c.getCaseLink(), c.getCaseCategory(), c.getCaseNotes()));
			}
		} catch (IOException e) {
			return false;
		}

		return true;
	}

	boolean caseNumberExists(String CaseNumber) {
		return caseMap.containsKey(CaseNumber);
	}
}
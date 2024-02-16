/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 */

package hw2;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class Case implements Comparable<Case> {
	
	private final StringProperty caseDate;
	private final StringProperty caseTitle;
	private final StringProperty caseType;
	private final StringProperty caseNumber;
	private final StringProperty caseLink;
	private final StringProperty caseCategory;
	private final StringProperty caseNotes;

	// constructor
	public Case(String caseDate, String caseTitle, String caseType, String caseNumber, String caseLink, String caseCategory, String caseNotes) {
        this.caseDate = new SimpleStringProperty(caseDate);
        this.caseTitle = new SimpleStringProperty(caseTitle);
        this.caseType = new SimpleStringProperty(caseType);
        this.caseNumber = new SimpleStringProperty(caseNumber);
        this.caseLink = new SimpleStringProperty(caseLink);
        this.caseCategory = new SimpleStringProperty(caseCategory);
        this.caseNotes = new SimpleStringProperty(caseNotes);
    }

	// Getters and setters for caseDate
    public String getCaseDate() {
        return caseDate.get();
    }

    public void setCaseDate(String caseDate) {
        this.caseDate.set(caseDate);
    }

    public StringProperty caseDateProperty() {
        return caseDate;
    }

    // Getters and setters for caseTitle
    public String getCaseTitle() {
        return caseTitle.get();
    }

    public void setCaseTitle(String caseTitle) {
        this.caseTitle.set(caseTitle);
    }

    public StringProperty caseTitleProperty() {
        return caseTitle;
    }

    // Getters and setters for caseType
    public String getCaseType() {
        return caseType.get();
    }

    public void setCaseType(String caseType) {
        this.caseType.set(caseType);
    }

    public StringProperty caseTypeProperty() {
        return caseType;
    }

    // Getters and setters for caseNumber
    public String getCaseNumber() {
        return caseNumber.get();
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber.set(caseNumber);
    }

    public StringProperty caseNumberProperty() {
        return caseNumber;
    }

    // Getters and setters for caseLink
    public String getCaseLink() {
        return caseLink.get();
    }

    public void setCaseLink(String caseLink) {
        this.caseLink.set(caseLink);
    }

    public StringProperty caseLinkProperty() {
        return caseLink;
    }

    // Getters and setters for caseCategory
    public String getCaseCategory() {
        return caseCategory.get();
    }

    public void setCaseCategory(String caseCategory) {
        this.caseCategory.set(caseCategory);
    }

    public StringProperty caseCategoryProperty() {
        return caseCategory;
    }

    // Getters and setters for caseNotes
    public String getCaseNotes() {
        return caseNotes.get();
    }

    public void setCaseNotes(String caseNotes) {
        this.caseNotes.set(caseNotes);
    }

    public StringProperty caseNotesProperty() {
        return caseNotes;
    }

    // to get a reverse list based on CaseDate
	@Override
	public int compareTo(Case o) {
		return o.getCaseDate().compareTo(getCaseDate());
	}

	// returns the CaseNumber
	@Override
	public String toString() {
		return getCaseNumber();
	}
}
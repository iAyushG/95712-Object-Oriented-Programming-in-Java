/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 * 
 * Author: iAyushGupta
 */

package hw3;

import javafx.scene.Scene;
import javafx.stage.Stage;
import java.time.LocalDate;

/**
 * ModifyCaseView class extends CaseView to provide a GUI for modifying existing cases.
 * It includes a Stage with GUI controls specifically for case modification.
 */
public class ModifyCaseView extends CaseView {

    /**
     * Constructor for ModifyCaseView.
     * Calls the superclass constructor with the header for the view.
     * 
     * @param header The header text for the Modify Case view.
     */
    ModifyCaseView(String header) {
        super(header); // Initialize with the superclass constructor
    }

    /**
     * Builds and returns a Stage with GUI controls for modifying an existing case.
     * It populates the controls with data from the current case and sets up the layout.
     * 
     * @return A Stage object configured for case modification.
     */
    @Override
    Stage buildView() { 
        // Retrieve the current case for modification
        Case currentCase = CyberCop.currentCase;
        
        // Populate GUI controls with current case data
        titleTextField.setText(currentCase.getCaseTitle());
        caseTypeTextField.setText(currentCase.getCaseType());
        caseDatePicker.setValue(LocalDate.parse(currentCase.getCaseDate()));
        caseNumberTextField.setText(currentCase.getCaseNumber());
        categoryTextField.setText(currentCase.getCaseCategory());
        caseLinkTextField.setText(currentCase.getCaseLink());
        caseNotesTextArea.setText(currentCase.getCaseNotes());

        // Create a new Scene for the modification view
        Scene scene = new Scene(updateCaseGridPane, CASE_WIDTH, CASE_HEIGHT);
        updateButton.setText("Modify Case"); // Set the text for the update button
        stage.setScene(scene); // Set the scene for the stage

        return stage; // Return the configured stage
    }
}
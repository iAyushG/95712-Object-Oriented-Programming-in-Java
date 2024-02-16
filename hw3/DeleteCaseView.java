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
 * DeleteCaseView class extends CaseView to provide a GUI for deleting cases.
 * It includes a Stage with GUI controls specifically for case deletion.
 */
public class DeleteCaseView extends CaseView {

    /**
     * Constructor for DeleteCaseView.
     * Calls the superclass constructor with the header for the view.
     * 
     * @param header The header text for the Delete Case view.
     */
    DeleteCaseView(String header) {
        super(header); // Initialize with the superclass constructor
    }

    /**
     * Builds and returns a Stage with GUI controls for displaying an existing case to be deleted.
     * It populates the controls with data from the current case and sets up the layout.
     * 
     * @return A Stage object configured for case deletion.
     */
    @Override
    Stage buildView() { 
        // Retrieve the current case to be deleted
        Case currentCase = CyberCop.currentCase;
        
        // Populate GUI controls with current case data
        titleTextField.setText(currentCase.getCaseTitle());
        caseTypeTextField.setText(currentCase.getCaseType());
        caseDatePicker.setValue(LocalDate.parse(currentCase.getCaseDate()));
        caseNumberTextField.setText(currentCase.getCaseNumber());
        categoryTextField.setText(currentCase.getCaseCategory());
        caseLinkTextField.setText(currentCase.getCaseLink());
        caseNotesTextArea.setText(currentCase.getCaseNotes());

        // Create a new Scene for the deletion view
        Scene scene = new Scene(updateCaseGridPane, CASE_WIDTH, CASE_HEIGHT);
        updateButton.setText("Delete Case"); // Set the text for the delete button
        stage.setScene(scene); // Set the scene for the stage

        return stage; // Return the configured stage
    }
}
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
 * AddCaseView class extends CaseView to provide a GUI for adding new cases.
 * It includes a Stage with GUI controls specifically for adding new case entries.
 */
public class AddCaseView extends CaseView {

    /**
     * Constructor for AddCaseView.
     * Calls the superclass constructor with the header for the view.
     * 
     * @param header The header text for the Add Case view.
     */
    AddCaseView(String header) {
        super(header); // Calling the superclass constructor
    }

    /**
     * Builds and returns a Stage with GUI controls for adding a new case.
     * It sets up the layout and initializes the controls for case addition.
     * 
     * @return A Stage object configured for adding a new case.
     */
    @Override
    Stage buildView() {
        // Set the default value of the date picker to the current date
        caseDatePicker.setValue(LocalDate.now());
        
        // Create a new Scene object for the case addition view
        Scene scene = new Scene(updateCaseGridPane, CASE_WIDTH, CASE_HEIGHT);
        updateButton.setText("Add Case"); // Set the text for the update button
        stage.setScene(scene); // Set the newly created scene for the stage

        return stage; // Return the configured stage
    }
}
/*
 * NAME: AYUSH GUPTA
 * ANDREW ID: ayushgu2
 */

package hw2;

import javafx.scene.Scene;
import javafx.stage.Stage;
import java.time.LocalDate;

public class AddCaseView extends CaseView {

	// constructor
	AddCaseView(String header) {
		super(header);
	}

	// returns a Stage with empty GUI controls for a case
	@Override
	Stage buildView() { 
		caseDatePicker.setValue(LocalDate.now()); // show current date
		
		Scene scene = new Scene(updateCaseGridPane, CASE_WIDTH, CASE_HEIGHT);
		updateButton.setText("Add Case");
		
		stage.setScene(scene);

		return stage;
	}
}
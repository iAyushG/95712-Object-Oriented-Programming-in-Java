package practice11;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**PickASeries has three buttons in an array named buttons[] declared in setScene() method.
 * buttons[0] is for Prime, buttons[1] is for Fibonacci, and buttons[2] is for [Factorial].
 * You need to attach event handlers to these buttons. 
 * These handlers must use the three objects defined in setupData() method : 
 * series[0] for Prime, series[1] for Fibonacci, and series[2] for Factorial
 * 
 */
public class PickASeries extends Application{
	TextField inputText = new TextField("0");  //will take user input
	Label resultLabel = new Label("Enter a number and pick a Series");  //will display the result
	Series[] series = new Series[3];  //holds the series objects - Prime, Fibonacci, and Factorial

	public static void main(String[] args) {
		launch(args);
	}
	
	//DO NOT CHANGE THIS METHOD
	@Override
	public void start(Stage primaryStage) throws Exception {
		setupData();
		Scene scene = new Scene(setupScreen(), 600, 225);
		primaryStage.setTitle("Pick a Series");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	//DO NOT CHANGE THIS METHOD
	void setupData() {
		series[0] = new Prime();
		series[1] = new Fibonacci();
		series[2] = new Factorial();
	}

	
	BorderPane setupScreen() {
		Button[] buttons = new Button[3]; //to be tied to handlers
		
		//setup various GUI components
		BorderPane root = new BorderPane();
		String[] options = {"Primes", "Fibonaccis", "Factorials"};
		Background background = new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY));
		GridPane seriesGrid = new GridPane();	
		GridPane inputGrid = new GridPane();
		root.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		Label inputLabel = new Label("Which number in the series?");
		inputLabel.setBackground(background);
		inputLabel.setFont(Font.font(20));
		inputLabel.setPrefSize(300, 75);
		inputText.setFont(Font.font(20));
		inputText.setAlignment(Pos.CENTER);
		inputText.setPrefSize(300, 75);
		inputGrid.add(inputLabel, 0, 0);
		inputGrid.add(inputText, 1, 0);
		inputGrid.setStyle("-fx-border-color: grey");
		seriesGrid.setStyle("-fx-border-color: grey");
		resultLabel.setFont(Font.font(20));
		resultLabel.setPrefSize(600,100);
		resultLabel.setBackground(background);
		resultLabel.setAlignment(Pos.CENTER);
		BorderPane.setAlignment(resultLabel, Pos.CENTER);

		//setup the buttons
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new Button(options[i]);
			buttons[i].setPrefSize(200, 50);
			buttons[i].setFont(Font.font(20));
			buttons[i].setWrapText(true);
			seriesGrid.add(buttons[i],  i, 0);
		}
		
		PrimeButtonHandler primeHandler = new PrimeButtonHandler();
		FibonacciButtonHandler fibonacciHandler = new FibonacciButtonHandler();
		FactorialButtonHandler factorialHandler = new FactorialButtonHandler();
		
		buttons[0].setOnAction(primeHandler);
		buttons[1].setOnAction(fibonacciHandler);
		buttons[2].setOnAction(factorialHandler);
		
		//set up root
		root.setTop(seriesGrid);	
		root.setCenter(inputGrid);
		root.setBottom(resultLabel);
		return root;
	}
	
	class PrimeButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
			String number = inputText.getText();
			int n = Integer.parseInt(number);
			
			int prime = series[0].getNthNumber(n);
			
			if (prime == -1) {
				resultLabel.setText("Enter a valid input. Enter an integer greater than 0.");
			}
			else if (n % 10 == 1 && n != 11) {
				resultLabel.setText("The " + n + "st number in Primes is: " + prime);
			}
			else if (n % 10 == 2 && n != 12) {
				resultLabel.setText("The " + n + "nd number in Primes is: " + prime);
			}
			else {
				resultLabel.setText("The " + n + "th number in Primes is: " + prime);
			}
		}
	}
	
	class FibonacciButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
			String number = inputText.getText();
			int n = Integer.parseInt(number);
			
			int fibonacci = series[1].getNthNumber(n);
			
			if (n < 0) {
				resultLabel.setText("Enter a valid input. Enter an integer greater than or equal to 0.");
			}
			else if (n % 10 == 1 && n != 11) {
				resultLabel.setText("The " + n + "st number in Fibonacci is: " + fibonacci);
			}
			else if (n % 10 == 2 && n != 12) {
				resultLabel.setText("The " + n + "nd number in Fibonacci is: " + fibonacci);
			}
			else {
				resultLabel.setText("The " + n + "th number in Fibonacci is: " + fibonacci);
			}
		}
	}
	
	class FactorialButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
			String number = inputText.getText();
			int n = Integer.parseInt(number);
			
			int factorial = series[2].getNthNumber(n);
			
			if (n < 0) {
				resultLabel.setText("Enter a valid input. Enter an integer greater than or equal to 0.");
			}
			else if (n % 10 == 1 && n != 11) {
				resultLabel.setText("The " + n + "st number in Factorials is: " + factorial);
			}
			else if (n % 10 == 2 && n != 12) {
				resultLabel.setText("The " + n + "nd number in Factorials is: " + factorial);
			}
			else {
				resultLabel.setText("The " + n + "th number in Factorials is: " + factorial);
			}
		}
	}
}

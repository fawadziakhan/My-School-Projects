package calculatorgui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CalculatorGUI extends Application {
  private TextField tfNum1 = new TextField();
  private TextField tfOperation = new TextField();
  private TextField tfNum2 = new TextField();
  private TextField tfAnswer = new TextField();
  private Button btCalculate = new Button("Calculate");
  private Button btClear = new Button("Clear");
  String firstDigit;
  String secondDigit;
  String sign;
  int num1;
  int num2;
  boolean digitFlag;
  boolean signFlag;
  
  // create an alert
  Alert a = new Alert(AlertType.NONE);
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create UI
    GridPane gridPane = new GridPane();
    gridPane.setHgap(5);
    gridPane.setVgap(5);
    gridPane.add(new Label("Number 1:"), 0, 0);
    gridPane.add(tfNum1, 1, 0);
    gridPane.add(new Label("Sign"), 0, 1);
    gridPane.add(tfOperation, 1, 1);
    gridPane.add(new Label("Number2"), 0, 2);
    gridPane.add(tfNum2, 1, 2);
    gridPane.add(new Label("Answer"), 0, 3);
    gridPane.add(tfAnswer, 1, 3);
    gridPane.add(btCalculate, 1, 5);
	gridPane.add(btClear, 2, 5);

    // Set properties for UI
    gridPane.setAlignment(Pos.CENTER);
    tfNum1.setAlignment(Pos.BOTTOM_RIGHT);
    tfOperation.setAlignment(Pos.BOTTOM_RIGHT);
    tfNum2.setAlignment(Pos.BOTTOM_RIGHT);
    tfAnswer.setAlignment(Pos.BOTTOM_RIGHT);
    tfAnswer.setEditable(false);
    GridPane.setHalignment(btCalculate, HPos.RIGHT);
	GridPane.setHalignment(btClear, HPos.RIGHT);

    // Process events
    btCalculate.setOnAction(e -> calculateAnswer());
	btClear.setOnAction(e -> clearFields());

    // Create a scene and place it in the stage
    Scene scene = new Scene(gridPane, 400, 250);
    primaryStage.setTitle("Simple English Language Calculator"); // Set title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }
    
  private void calculateAnswer() {
    // Get values from text fields
    firstDigit = tfNum1.getText();
	sign = tfOperation.getText();
	secondDigit = tfNum2.getText();
	
	//Checks to make sure user entered single digits only
    if ((firstDigit.length() > 1 || secondDigit.length() > 1)){
        //Program ends if incorrect entry
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Error");
        alert.setContentText("Please, enter single digits only");

        alert.showAndWait();
        System.exit(1);
    }
	
	//sets flag to make sure user enters numerical values only
    digitFlag = (firstDigit.matches("\\d")) && (secondDigit.matches("\\d"));
    if (digitFlag == false){
        //Program ends if incorrect entry
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Error");
        alert.setContentText("Please, enter numerical values only");

        alert.showAndWait();
        System.exit(1);
        
    }
	
	//sets flag to make sure user enters the correct math signs
    signFlag = sign.matches("[+-/*^]");
    if (signFlag == false){
        //Program ends if incorrect entry
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Error");
        alert.setContentText("Please, enter correct math sign");

        alert.showAndWait();
        System.exit(1);
         
    }
	
	//Checks to make sure user did not enter 0 as the divisor
	if (sign.equals("/") && secondDigit.equals("0")){
	    //btCalculate.setOnAction(event1);
	    //Program ends if incorrect entry
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Error");
            alert.setContentText("Zero Divide");

            alert.showAndWait();
            System.exit(1);
            
    }
	
	//Depending on what math sign user enters, the main method creates an instance of the appropriate
    //math class, and uses that class's methods to perform the required calculations. This is done via
    //a switch statement.
	switch (sign) {
	    case "+": num1 = Integer.parseInt(firstDigit);
	              num2 = Integer.parseInt(secondDigit);
                  //Create instance of Addition class
		          Addition add = new Addition(num1, num2);
		          add.addNumbers();
		          int sum = add.getSum();
		          tfAnswer.setText(String.valueOf(num1) + " plus " + String.valueOf(num2) + " is " + String.valueOf(sum));
		          break;
	    case "-": num1 = Integer.parseInt(firstDigit);
	              num2 = Integer.parseInt(secondDigit);
                  //Create instance of Subtraction class
		          Subtraction subtract = new Subtraction(num1, num2);
		          subtract.subtractNumbers();
		          int difference = subtract.getDifference();
		          tfAnswer.setText(String.valueOf(num1) + " minus " + String.valueOf(num2) + " is " + String.valueOf(difference));
		          break;
	    case "*": num1 = Integer.parseInt(firstDigit);
	              num2 = Integer.parseInt(secondDigit);
                  //Create instance of multiplication class
		          Multiplication multiply = new Multiplication(num1, num2);
		          multiply.multiplyNumbers();
		          int product = multiply.getProduct();
		          tfAnswer.setText(String.valueOf(num1) + " multiplied by " + String.valueOf(num2) + " is " + String.valueOf(product));
		          break;
	    case "/": num1 = Integer.parseInt(firstDigit);
	              num2 = Integer.parseInt(secondDigit);
                  //Create instance of Division class
		          Division divide = new Division(num1, num2);
                  divide.divideNumbers();
		          int quotient = divide.getQuotient();
		          tfAnswer.setText(String.valueOf(num1) + " divided by " + String.valueOf(num2) + " is " + String.valueOf(quotient));
		          break;
	    case "^": num1 = Integer.parseInt(firstDigit);
	              num2 = Integer.parseInt(secondDigit);
                  //Create instance of the Exponentiation class
		          Exponentiation raise = new Exponentiation(num1, num2);
		          raise.raisePower();
		          double exponential = raise.getExponential();
		          tfAnswer.setText(String.valueOf(num1) + " to the power " + String.valueOf(num2) + " is " + String.valueOf(exponential));
		          break;
	    default: System.out.println("Error: invalid entry");
	             //Program ends if incorrect entry 
                 System.exit(1);
	}
  }
  
  private void clearFields(){
	  tfNum1.clear();
	  tfOperation.clear();
	  tfNum2.clear();
	  tfAnswer.clear();
  }
	  
  
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
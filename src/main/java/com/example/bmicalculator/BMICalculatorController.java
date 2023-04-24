package com.example.bmicalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class BMICalculatorController {

    String radioButton = null;
    double bmi;

    @FXML
    private RadioButton EnglishButton;

    @FXML
    private RadioButton MetricButton;

    @FXML
    private ToggleGroup UnitButtons;

    @FXML
    private Label bmiLabel;

    @FXML
    private TextField bmiTextField;

    @FXML
    private Button calculateButton;

    @FXML
    private Label heightLabel;

    @FXML
    private TextField heightTextField;

    @FXML
    private Label valueLabel;

    @FXML
    private TextField valueTextField;

    @FXML
    private Label weightLabel;

    @FXML
    private TextField weightTextField;

    @FXML
    void calculateButtonPressed(ActionEvent event) {
        try{
            double height = Double.parseDouble(heightTextField.getText());
            double weight = Double.parseDouble(weightTextField.getText());

            if(radioButton == "Metric"){
                bmi = weight / Math.pow(height, 2);
            }
            else{
                bmi = (weight / Math.pow(height, 2)) * 703;
            }

            if(bmi < 18.5){
                valueTextField.setText("Underweight");
            } else if ((18.5 <= bmi && bmi <= 24.9)) {
                valueTextField.setText("Normal");
            } else if (25 <= bmi && bmi <= 29.9) {
                valueTextField.setText("Overweight");
            } else{
                valueTextField.setText("Obese");
            }

            bmiTextField.setText(String.valueOf(bmi));
        }
        catch (Exception ex){
            weightTextField.setText("Enter amount");
            weightTextField.selectAll();
            weightTextField.requestFocus();

            heightTextField.setText("Enter amount");
            heightTextField.selectAll();
            heightTextField.requestFocus();
        }
    }

    @FXML
    void getUnits(ActionEvent event) {
        if(MetricButton.isSelected()){
            radioButton = "Metric";
        }
        else{
            radioButton = "English";
        }
    }

}

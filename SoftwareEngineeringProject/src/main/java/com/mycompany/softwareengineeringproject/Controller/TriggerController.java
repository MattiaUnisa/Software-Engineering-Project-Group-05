/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.softwareengineeringproject.Controller;

import com.mycompany.softwareengineeringproject.Model.*;
import java.time.LocalTime;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

/**
 *
 * @author Lenovo
 */
public class TriggerController {
    
    @FXML
    private ComboBox<String> triggerComboBox;

    @FXML
    private Spinner<Integer> hourSpinner;

    @FXML
    private Spinner<Integer> minuteSpinner;
    
    private Trigger trigger = null;
    
    //initialize the combobox and add the created triggers
    public void initialize() {
        
    
    triggerComboBox.getItems().addAll(
        "Choose Trigger",
        "TimeTrigger"                //Triggers are added to the combobox as strings
    );
    
    triggerComboBox.getSelectionModel().select("Choose Trigger");  //the default string selected is Choose Trigger
    
    hourSpinner.setValueFactory(    //Function used to set the value of the Spinner
            new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 0)  //Object that manages values in the Spinner, the first is the min value, the second is the max value and the third is the first value
        );

        minuteSpinner.setValueFactory(
            new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0)
        );

}
    
    @FXML  //When the trigger is selected, fields for entering useful elements are shown
    private void onTriggerSelected() {
        String selected = triggerComboBox.getValue();  //I capture the selected trigger as a string
        
        if (selected.equals("TimeTrigger")) {
            hourSpinner.setVisible(true);    //show the hour selector when the TimeTrigger is selected
            minuteSpinner.setVisible(true);  //show the minute selector when the TimeTrigger is selected
        }else{
            hourSpinner.setVisible(false); //hide the hour selector when the TimeTrigger is not selected
            minuteSpinner.setVisible(false); //hide the minute selector when the TimeTrigger is not selected
        }
        
    }
    
    public Trigger buildTrigger() {
        String selectedTrigger = triggerComboBox.getValue();  //String selected is 
        
         if (selectedTrigger == null || selectedTrigger.equals("Choose Trigger")) return null; //if there isn't selected triggere or the String Choose Trigger return null

        if (selectedTrigger.equals("TimeTrigger")) {  //Take the value selected in the ComboBox
            int hour = hourSpinner.getValue();  //take the int hour value
            int minute = minuteSpinner.getValue(); //take the int minute value
            LocalTime time = LocalTime.of(hour, minute); //create a variable that we use to create the TimeTrigger
            trigger = TriggerFactory.createTimeTrigger(time);
        }
        return trigger;
    }
    
}

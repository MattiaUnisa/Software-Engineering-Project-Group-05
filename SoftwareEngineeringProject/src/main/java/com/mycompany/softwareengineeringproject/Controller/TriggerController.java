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
    
    triggerComboBox.getSelectionModel().select("Choose Trigger");
    
    hourSpinner.setValueFactory(
            new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 0)
        );

        minuteSpinner.setValueFactory(
            new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0)
        );

}
    
    @FXML  //When the trigger is selected, fields for entering useful elements are shown
    private void onTriggerSelected() {
        String selected = triggerComboBox.getValue();  //I capture the selected trigger as a string
        
        if (selected.equals("TimeTrigger")) {
            hourSpinner.setVisible(true);    //show the hour selector
            minuteSpinner.setVisible(true);  //show the minute selector
        }else{
            hourSpinner.setVisible(false);
            minuteSpinner.setVisible(false);
        }
        
        if (selected == null || selected.equals("Choose Trigger")) {
        return;
        }
        
    }
    
    public Trigger buildTrigger() {
        String selectedTrigger = triggerComboBox.getValue();
        
         if (selectedTrigger == null || selectedTrigger.equals("Choose Trigger")) return null;

        if (selectedTrigger.equals("TimeTrigger")) {  //If the string matches, the trigger is fired.
            int hour = hourSpinner.getValue();
            int minute = minuteSpinner.getValue();
            LocalTime time = LocalTime.of(hour, minute);
            trigger = TriggerFactory.createTimeTrigger(time);
        }
        return trigger;
    }
    
}

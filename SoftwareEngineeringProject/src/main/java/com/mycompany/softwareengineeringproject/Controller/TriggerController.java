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
    
    private Trigger createdTrigger;
    
    //initialize the combobox and add the created triggers
    public void initialize() {
    triggerComboBox.getItems().addAll(
        "TimeTrigger"                //Triggers are added to the combobox as strings
    );
}
    
    @FXML  //When the trigger is selected, fields for entering useful elements are shown
    private void onTriggerSelected() {
        String selected = triggerComboBox.getValue();  //I capture the selected trigger as a string
    
        if (selected.equals("TimeTrigger")) {
            hourSpinner.setVisible(true);    //show the hour selector
            minuteSpinner.setVisible(true);  //show the minute selector
        }
    }
    
    public Trigger buildTrigger() {
        //String name = ruleNameField.getText();
        String selectedTrigger = triggerComboBox.getValue();
        
        if (selectedTrigger == null) return null;

        Trigger trigger = null;

        if (selectedTrigger.equals("TimeTrigger")) {  //If the string matches, the trigger is fired.
            int hour = hourSpinner.getValue();
            int minute = minuteSpinner.getValue();
            LocalTime time = LocalTime.of(hour, minute);
            trigger = TriggerFactory.createTimeTrigger(time);
        }
        return trigger;
    }
    
}

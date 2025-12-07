/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.softwareengineeringproject.Controller;

import com.mycompany.softwareengineeringproject.Model.Trigger;
import com.mycompany.softwareengineeringproject.Model.TriggerFactory;
import java.time.LocalTime;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

/**
 *
 * @author matda
 */
public class TimeTriggerController implements TriggerControllerInterface{
    
    @FXML
    private Spinner<Integer> hourSpinner;

    @FXML
    private Spinner<Integer> minuteSpinner;
    
    public void initialize(){
        
    hourSpinner.setValueFactory(    //Function used to set the value of the Spinner
        new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 0)  //Object that manages values in the Spinner, the first is the min value, the second is the max value and the third is the first value
    );

    minuteSpinner.setValueFactory(
        new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0)
    );
    }
    
    @Override
    public Trigger buildTrigger(){
        int hour = hourSpinner.getValue();  //take the int hour value
        int minute = minuteSpinner.getValue(); //take the int minute value
        LocalTime time = LocalTime.of(hour, minute); //create a variable that we use to create the TimeTrigger
        return TriggerFactory.createTimeTrigger(time);
    }
    
}

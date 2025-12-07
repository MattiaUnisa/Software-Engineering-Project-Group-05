/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.softwareengineeringproject.Controller;

import com.mycompany.softwareengineeringproject.Model.*;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Lenovo
 */
public class TriggerController {
    
    @FXML
    private ComboBox<String> triggerComboBox;
    
    @FXML
    private StackPane dynamicContainer;
    
    private TriggerControllerInterface trigger;
    
    //initialize the combobox and add the created triggers
    public void initialize() {
        
    //Triggers are added to the combobox as strings
    triggerComboBox.getItems().addAll(
        "Choose Trigger",
        "TimeTrigger"                
    );
    
    //the default string selected is Choose Trigger
    triggerComboBox.getSelectionModel().select("Choose Trigger");  
    
    }
    
    //When the trigger is selected, fields for entering useful elements are shown through their fmxl files
    @FXML  
    private void onTriggerSelected() throws IOException {
        
        //We capture the selected trigger as a string
        String selectedTrigger = triggerComboBox.getValue();  
        
        dynamicContainer.getChildren().clear(); 
        trigger = null;
        
        if (selectedTrigger == null || selectedTrigger.equals("Choose Trigger")) { //if there isn't a valid selection we will do nothing
            return; 
        }
        
        String fxmlPath = "/" + selectedTrigger + ".fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent triggerUI = loader.load();
        
        trigger = loader.getController();
        dynamicContainer.getChildren().add(triggerUI);
        
    }
    
    public Trigger buildTrigger() {
    
        if (trigger!= null){
            return trigger.buildTrigger();
        }
        return null;
    }
    
}

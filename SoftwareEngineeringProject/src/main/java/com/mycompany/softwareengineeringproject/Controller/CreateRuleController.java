package com.mycompany.softwareengineeringproject.Controller;

import com.mycompany.softwareengineeringproject.App;
import com.mycompany.softwareengineeringproject.Model.Trigger;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class CreateRuleController {

    @FXML 
    private TextField nameField;
    
    @FXML
    private TriggerController triggerSectionController;
    /**
     * Gestisce il click sulla freccia "Indietro".
     * Torna alla schermata Home senza salvare nulla.
     */
    @FXML
    private void onBackClick() throws IOException {
        App.setRoot("home");
    }


    @FXML
    private void onSaveClick() throws IOException {
        String name = nameField.getText();
        
        Trigger trigger = triggerSectionController.buildTrigger();

        if (trigger == null) {
            System.out.println("Select a trigger first!");
            return;
        }
        
        // Validation of the name
        if (name == null || name.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore");
            alert.setHeaderText("Name missing");
            alert.setContentText("Please insert a name for the rule.");
            alert.showAndWait();
            return; // Interrompe l'esecuzione se il nome manca
        }

        // TO DO
        
        App.setRoot("home");
    }
}
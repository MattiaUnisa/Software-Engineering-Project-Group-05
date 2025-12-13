package com.mycompany.softwareengineeringproject.Controller;

import com.mycompany.softwareengineeringproject.Model.Action;
import com.mycompany.softwareengineeringproject.Model.NotificationAction;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NotificationController implements ActionControllerInterface {

    @FXML
    private TextField messageField;

    @Override
    public Action buildAction() {
        String msg = (messageField != null) ? messageField.getText() : "";
        if (msg == null) msg = "";
        return new NotificationAction(msg);
    }
}

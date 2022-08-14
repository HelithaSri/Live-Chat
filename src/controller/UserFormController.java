package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * @author Helitha Sri
 * @created 8/14/2022 - 11:18 AM
 * @project Live Chat
 */

public class UserFormController {
    public TextField txtMsgInput;
    public TextArea txtMsgDisplay;

    public void btnClose(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void btnMinimize(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        // is stage minimizable into task bar. (true | false)
        stage.setIconified(true);
    }

    public void btnSend(ActionEvent actionEvent) {
        
    }
}

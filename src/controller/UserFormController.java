package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.ClientConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

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

    public void btnSend(ActionEvent actionEvent) throws IOException {
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println(txtMsgInput.getText());
        txtMsgDisplay.appendText("laki : "+txtMsgInput.getText().trim()+"\n");
        printWriter.flush();
    }

    Socket socket = null;
    public void initialize() throws IOException {
            socket = new Socket("localhost", 5000);


    }

    /*public void broadcast(String message) {
        for (ClientConnection clientConnection : this.connectionList) {
            clientConnection.sendMessage(message);
        }
    }*/
}

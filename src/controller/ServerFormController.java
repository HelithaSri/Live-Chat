package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.ClientConnection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author Helitha Sri
 * @created 8/15/2022 - 3:39 PM
 * @project Live Chat
 */

public class ServerFormController implements Initializable {

    public TextField txtMsgInput;
    public TextArea txtMsgDisplay;
    List<ClientConnection> connectionList = new ArrayList<>();
    ServerSocket serverSocket;
    public void btnSend(ActionEvent actionEvent) {
    }

    public void btnClose(ActionEvent actionEvent) {
        /*if (serverSocket != null) {
            serverSocket.close();
        }*/
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void btnMinimize(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        // is stage minimizable into task bar. (true | false)
        stage.setIconified(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new Thread(()->{
            try {
                serverSocket = new ServerSocket(5000);
                System.out.println("started");
                while (true){
                    Socket accept = serverSocket.accept();
                    System.out.println("Connect new");
                    ClientConnection connection = new ClientConnection(accept, this);
                    connectionList.add(connection);

                    Thread thread = new Thread(connection);
                    thread.start();

                    /*InputStreamReader inputStreamReader = new InputStreamReader(accept.getInputStream());
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String readLine = bufferedReader.readLine();
                    System.out.println(readLine);*/

                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();
    }

    public void broadcast(String message) {
        for (ClientConnection clientConnection : this.connectionList) {
            clientConnection.sendMessage(message);
        }
    }
}
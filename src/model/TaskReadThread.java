package model;

import controller.UserFormController;
import javafx.application.Platform;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author Helitha Sri
 * @created 8/15/2022 - 4:40 PM
 * @project Live Chat
 */

public class TaskReadThread implements Runnable{

    Socket socket;
    UserFormController client;
    BufferedReader reader;

    @Override
    public void run() {
        while(true){
            try{
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message = reader.readLine();

                /*InputStreamReader inputStreamReader = new InputStreamReader(accept.getInputStream());
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String readLine = bufferedReader.readLine();
                    System.out.println(readLine);*/

                Platform.runLater(()->{
                    System.out.println("message : "+message);
                    client.txtMsgDisplay.appendText(message+"\n");
                });

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

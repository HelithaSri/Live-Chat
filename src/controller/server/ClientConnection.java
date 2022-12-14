package controller.server;

import controller.server.ServerFormController;

import java.io.*;
import java.net.Socket;

/**
 * @author Helitha Sri
 * @created 8/15/2022 - 3:18 PM
 * @project Live Chat
 */

public class ClientConnection implements Runnable {

    private final Socket accept;
    private final ServerFormController server;

    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
//    private PrintWriter printWriter;


    public ClientConnection(Socket socket, ServerFormController server) {
        this.accept = socket;
        this.server = server;

    }

    @Override
    public void run() {

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(accept.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            while (true) {
                String readLine = bufferedReader.readLine();
                System.out.println("Line : " + readLine);
                server.broadcast(readLine);
                server.txtMsgDisplay.appendText(readLine + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                accept.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

    }

    //send message back to client
    public void sendMessage(String message) {
        try {
            PrintWriter printWriter = new PrintWriter(accept.getOutputStream());
            printWriter.println(message);
            System.out.println("He hee : "+message);
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

package ru.fda.chat;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    TextArea textChat;

    @FXML
    TextField message;

    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            socket = new Socket("localhost", 8189);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            Thread t = new Thread(() -> {
                try {
                    while (true) {
                        String message = in.readUTF();
                        textChat.appendText(message + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        } catch (IOException e) {
            throw new RuntimeException("Unable to connect to server [ localhost:8189 ]");
        }
    }

    public void clickSend() {
        try {
            out.writeUTF(message.getText());
            message.clear();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Невозможно отправить сообщение", ButtonType.OK);
            alert.showAndWait();
        }
    }
}

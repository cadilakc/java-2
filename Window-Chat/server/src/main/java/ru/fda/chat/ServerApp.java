package ru.fda.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Сервер запущен на порту 8189. Ожидает подключения клиента...");
            Socket socket = serverSocket.accept();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Клиент подключен");
            int counter = 0;
            String status = "/stat";
            String message;
            while (true) {
                message = in.readUTF();
                if (message != null) {
                    counter++;
                }
                if (message.equals(status)) {
                    out.writeUTF("Количество сообщений - " + (counter - 1));
                }
                System.out.println(message);
                if (!message.equals(status)) {
                    out.writeUTF("ECHO " + message);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

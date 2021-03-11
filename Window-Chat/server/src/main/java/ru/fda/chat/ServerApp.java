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

            while (true) {
                String message = in.readUTF();
                System.out.println(message);
                out.writeUTF("ECHO " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

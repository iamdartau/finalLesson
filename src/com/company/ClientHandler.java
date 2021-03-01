package com.company;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler extends Thread {
    private Socket socket;
    private int id;

    public ClientHandler(Socket socket, int id) {
        this.socket = socket;
        this.id = id;
    }

    public void run() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            PackageData data = null;
            PackageData response = null;
            while ((data = (PackageData) inputStream.readObject()) != null) {
                if (data.getOperationType().equalsIgnoreCase("list")) {
                    DAO dao = new DaoImpl();
                    response = new PackageData("list",dao.getStudensts(),null);
                }
                outputStream.writeObject(response);
                outputStream.reset();
            }
        } catch (Exception e) {

        }
    }
}

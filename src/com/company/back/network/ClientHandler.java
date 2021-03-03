package com.company.back.network;

import com.company.back.backendlogic.DAO;
import com.company.back.backendlogic.DaoImpl;
import com.company.back.models.PackageData;

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
            PackageData data;
            PackageData response = null;
            DAO dao = new DaoImpl();
            while ((data = (PackageData) inputStream.readObject()) != null) {
                if (data.getOperationType().equalsIgnoreCase("list")) {
                    response = new PackageData("list",dao.getStudensts(),null);
                }else if (data.getOperationType().equalsIgnoreCase("add")){
                    dao.addStident(data.getStudent());
                }
                outputStream.writeObject(response);
                outputStream.reset();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.company;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.UnmarshalException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        Students students = new Students("newName", "NesSurname", 89);
        DAO dao = new DaoImpl();
        dao.addStident(students);

        Scanner in = new Scanner(System.in);
        try {
            Socket socket = new Socket("127.0.0.1", 9889);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            PackageData data;
            while (true) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

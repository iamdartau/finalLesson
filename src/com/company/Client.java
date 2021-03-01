package com.company;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            Socket socket = new Socket("127.0.0.1", 9889);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            PackageData data;
            while (true) {
                System.out.println("1 list");
                System.out.println("2 add");
                System.out.println("0 end");
                String choice = scanner.next();
                if (choice.equalsIgnoreCase("list")) {
                    data = new PackageData(choice, null, null);
                    outputStream.writeObject(data);
                    outputStream.reset();
                    PackageData list;
                    if ((list = (PackageData) inputStream.readObject()) != null) {
                        System.out.println(list.getStudents());
                    }
                    outputStream.reset();
                } else if (choice.equalsIgnoreCase("add")) {
                    System.out.println("name");
                    String name = scanner.next();
                    System.out.println("surname");
                    String surname = scanner.next();
                    System.out.println("age");
                    int age = scanner.nextInt();
                    Students student = new Students(name,surname,age);
                    data = new PackageData(choice,null,student);
                    outputStream.writeObject(data);
                    outputStream.reset();
                } else if (choice.equalsIgnoreCase("end")) {
                    System.exit(0);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.example.casestudy.CaseStudy.Lesson3_Have_MySQL;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        //Ket noi CSDL;
        ConnectJDBC jdbc = new ConnectJDBC();
        Connection connection = jdbc.conn();

        //Cac thong tin ket noi;
        String host = "localhost";
        int port = 2608;
        Scanner scanner = new Scanner(System.in);

        //Hien thi tin nhan truoc do;
        showDatabase();

        //Tao lien ket Server;
        try {
            Socket socketCLient = new Socket(host, port);
//            System.out.println("Connect Server");
            do {
                //Doc tin nhan cua client
                InputStream inputStream = socketCLient.getInputStream();
                byte[] buffer = new byte[1024];
                int byteReads = inputStream.read(buffer);
                String messServer = new String(buffer, 0, byteReads);
                System.out.println("Server : " + messServer);

                if (messServer.equalsIgnoreCase("exit") || messServer.equalsIgnoreCase("bye bye")) {
                    socketCLient.close();
                    System.out.println("\nServer Offline !!!");
                    break;
                }

                //CLient viet tin nhan;
                System.out.print("Client : ");
                String messCLient = scanner.nextLine();
                OutputStream outputStream = socketCLient.getOutputStream();
                outputStream.write(messCLient.getBytes());

                //Them tin nhan cua client vao database;
                addDatabase("Client", messCLient);

                if (messCLient.equalsIgnoreCase("exit") || messCLient.equalsIgnoreCase("bye bye")) {
                    socketCLient.close();
                    System.out.println("\nCLient Offline !!!");
                    break;
                }

            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Them tin nhan vao database;
    public static void addDatabase(String peopleWrite, String mess) {
        String sql = "INSERT INTO mess(tennguoinhan, tinnhan) VALUES (?, ?)";
        try {
            Connection connection = ConnectJDBC.conn();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, peopleWrite);
            statement.setString(2, mess);

            statement.executeUpdate();
            if (mess.equalsIgnoreCase("exit") || mess.equalsIgnoreCase("bye bye")) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //HIen thi tin nhan luu truoc do;
    public static void showDatabase() {
        String sql = "SELECT tennguoinhan, tinnhan FROM mess";
        try {
            Connection connection = ConnectJDBC.conn();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println(resultSet.getString("tennguoinhan") + " : " + resultSet.getString("tinnhan"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

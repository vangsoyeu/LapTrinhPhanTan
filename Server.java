package com.example.casestudy.CaseStudy.Lesson3_Have_MySQL;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        //Ket noi CSDL;
        ConnectJDBC jdbc = new ConnectJDBC();
        Connection connection = jdbc.conn();

        //Thong tin ketnoi;
        int port = 2608;
        Scanner scanner = new Scanner(System.in);

        //Hien thi cac tinh nhan truoc do;
        showDatabase();

        try {
            ServerSocket socketServer = new ServerSocket(port);
//            System.out.println("Server started");

            Socket socket = socketServer.accept();
//            System.out.println("Socket connected to server " + socket.getPort());
            do {
                System.out.print("Server : ");
                String messServer = scanner.nextLine();
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(messServer.getBytes());

                addDatabase(connection, "Server", messServer);

                if (messServer.equalsIgnoreCase("exit") || messServer.equalsIgnoreCase("bye bye")) {
                    socket.close();
                    socketServer.close();
                    System.out.println("\n\nDa ngat ket noi voi Client !!!");
                    break;
                }

                InputStream inputStream = socket.getInputStream();
                byte[] buffer = new byte[1024];
                int byteReads = inputStream.read(buffer);
                String mess = new String(buffer, 0, byteReads);
                System.out.println("Client : " + mess);

                if (mess.equalsIgnoreCase("exit") || mess.equalsIgnoreCase("bye bye")) {
                    socket.close();
                    socketServer.close();
                    System.out.println("\n\nClient da thoat !!!");
                    break;
                }
            } while (true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addDatabase(Connection conn, String peopleWrite, String mess) {
        String sql = "INSERT INTO mess(tennguoinhan, tinnhan) VALUES (?, ?)";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, peopleWrite);
            statement.setString(2, mess);

            statement.executeUpdate();

            if (mess.equalsIgnoreCase("exit") || mess.equalsIgnoreCase("bye bye")) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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

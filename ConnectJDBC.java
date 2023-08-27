package com.example.casestudy.CaseStudy.Lesson3_Have_MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectJDBC {
    private static String accout = "root";
    private static String pass = "anhnam2005";
    private static String hostname = "localhost:3306";
    private static String nameDatabase = "messengersql";
    static String pathMySQL = "jdbc:mysql://" + hostname + "/" + nameDatabase;

    public static Connection conn() {
        try {
            Connection connection = DriverManager.getConnection(pathMySQL, accout, pass);
            System.out.println("Ket noi MySQL thanh cong !!!!");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

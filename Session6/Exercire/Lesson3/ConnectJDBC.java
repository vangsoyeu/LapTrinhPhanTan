package Session6.Exercire.Lesson3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Lesson 1:
public class ConnectJDBC {
    private String accout = "root";
    private String pass = "anhnam2005";
    private String connectionURL = "jdbc:mysql://localhost:3306/product_manager_database";

    public Connection connect () throws SQLException {
        Connection connection = null;

        connection = DriverManager.getConnection(connectionURL, accout, pass);
        System.out.println("Ket noi thanh cong");
        return connection;
    }
}

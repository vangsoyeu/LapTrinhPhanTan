package Session6.Exercire.Lesson5;

import Session6.Exercire.Lesson1.ConnectJDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataQuery {
    public static void main(String[] args) throws SQLException {
        Session6.Exercire.Lesson1.ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection connection= connectJDBC.connect();

//      Truy xuất dữ liệu
        getAllProducts(connection);
    }

    public static void getAllProducts(Connection connection) throws SQLException {
        String query = "SELECT * FROM products";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double price = resultSet.getDouble("price");
            String manufacturer = resultSet.getString("manufacturer");
            boolean status = resultSet.getBoolean("statuss");

            String statusDescription = "hết hàng";
            if (status) {
                statusDescription = "còn hàng";
            }

            // Lấy các trường dữ liệu khác nếu cần thiết
            System.out.println("ID: " + id + " - Name: " + name + " - Price: " + price + " - Manufacturer: " + manufacturer + " - Status: " + statusDescription);
            System.out.println("----------------------------------------------------------------------------------------");
        }
    }
}

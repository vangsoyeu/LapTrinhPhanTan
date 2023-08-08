package Session6.Exercire.Lesson2;

import Session6.Exercire.Lesson1.ConnectJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddNewDataToDatabase {
    public static void main(String[] args) throws SQLException {
        Session6.Exercire.Lesson1.ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection connection= connectJDBC.connect();

//      Thêm 1 dữ liệu vào bảng database:
        insertProduct(connection);
    }

    public static void insertProduct(Connection connectionJDBC) throws SQLException {
        String query = "insert into products (name, price, detail, manufacturer, numbers, statuss) value (?,?,?,?,?,?)";

        PreparedStatement preparedStatement = null;
        preparedStatement = connectionJDBC.prepareStatement(query);

        preparedStatement.setString(1, "Macbook Pro Minions");
        preparedStatement.setDouble(2, 30000000);
        preparedStatement.setString(3, "Laptop có thiết kế sang trọng, hiệu năng cao");
        preparedStatement.setString(4, "Apple");
        preparedStatement.setInt(5, 14);
        preparedStatement.setBoolean(6, true);

        int row = preparedStatement.executeUpdate();
        if (row != 0) System.out.println("Thêm thành công !");

        connectionJDBC.close();
    }
}

package Session6.Exercire.Lesson3;

import Session6.Exercire.Lesson1.ConnectJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDataIntoDatabase {
    public static void main(String[] args) throws SQLException {
        Session6.Exercire.Lesson1.ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection connection= connectJDBC.connect();

//      Câp nhật dữ liệu:
//        updateDetail(connection);
//        updateManufacturerAndPrice(connection);
//        updateNumbersAndStatus(connection);
    }

    public static void updateDetail(Connection connection) throws SQLException {
        String query = "update products set detail=? where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, "dữ liệu mới");
        preparedStatement.setInt(2, 4);
        int row = preparedStatement.executeUpdate();
        if (row != 0) System.out.println("Cập nhật thành công !!");

        connection.close();
    }

    public static void updateManufacturerAndPrice(Connection connection) throws SQLException {
        String query = "update products set manufacturer=?, price=? where id=?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, "apple");
        statement.setDouble(2, 12000000.0);
        statement.setInt(3, 2);

        int row = statement.executeUpdate();
        if (row != 0) System.out.println("Cập nhật thành công !!");

        connection.close();
    }

    public static void updateNumbersAndStatus(Connection connection) throws SQLException {
        String query = "update products set numbers=?, statuss=? where id=?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setInt(1, 20);
        statement.setBoolean(2, false);
        statement.setInt(3, 6);

        int row = statement.executeUpdate();
        if (row != 0) System.out.println("Cập nhật thành công !!");

        connection.close();
    }
}

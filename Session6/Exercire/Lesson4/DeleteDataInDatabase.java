package Session6.Exercire.Lesson4;

import Session6.Exercire.Lesson1.ConnectJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDataInDatabase {
    public static void main(String[] args) throws SQLException {
        Session6.Exercire.Lesson1.ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection connection= connectJDBC.connect();

//      Xóa dữ liệu
        deleteProducts(connection);
    }

    public static void deleteProducts(Connection connection) throws SQLException {
        String query = "delete from products where id = ?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setInt(1, 4);

        int row = statement.executeUpdate();
        if (row != 0) System.out.println("Xóa thành công !!");

        connection.close();
    }
}

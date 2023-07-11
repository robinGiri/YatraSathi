package service;

import java.sql.*;
import database.DbConnection;

public class UserCountService {
    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;
    private DbConnection dbConnection = new DbConnection();

    public int getUserCount() {
        connection = dbConnection.connection;
        String query = "SELECT COUNT(*) AS userCount FROM user";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("userCount");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public static void main(String[] args) {
        UserCountService userCountService = new UserCountService();
        int userCount = userCountService.getUserCount();
        System.out.println("Total user count: " + userCount);
    }
}

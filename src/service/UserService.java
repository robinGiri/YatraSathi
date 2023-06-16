package service;

import java.sql.*;
import database.DbConnection;
import model.User;
import java.util.*;

public class UserService {
    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;
    private DbConnection dbConnection = new DbConnection();

    // It checks the table and creates a new table if it does not exist
    public boolean checkTableUser() {
        connection = dbConnection.connection;
        String query = "CREATE TABLE IF NOT EXISTS user (" +
                "userId INT AUTO_INCREMENT PRIMARY KEY , " +
                "userName VARCHAR(50), " +
                "email VARCHAR(50), " +
                "password VARCHAR(50), " +
                "address VARCHAR(100), " +
                "contact VARCHAR(20), " +
                "subscriptionId INT, " +
                "rentalId INT, " +
                "isUser BOOLEAN)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    // Create user
    public boolean createUser(User user) {
        checkTableUser();
        connection = dbConnection.connection;
        String query = "INSERT INTO user( userName, email, password, address, contact, subscriptionId, rentalId, isUser) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setString(5, user.getContact());
            preparedStatement.setInt(6, user.getSubscriptionId());
            preparedStatement.setInt(7, user.getRentalId());
            preparedStatement.setBoolean(8, user.isUser());
            int status = preparedStatement.executeUpdate();
            System.out.println(status);
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean updateUser(User user) {
        connection = dbConnection.connection;
        String query = "UPDATE user SET userName = ?,email = ?, password = ?, address = ?, contact = ?, " +
                "subscriptionId = ?, rentalId = ?, isUser = ? WHERE userId = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setString(5, user.getContact());
            preparedStatement.setInt(6, user.getSubscriptionId());
            preparedStatement.setInt(7, user.getRentalId());
            preparedStatement.setBoolean(8, user.isUser());
            preparedStatement.setInt(9, user.getUserId());
            int status = preparedStatement.executeUpdate();
            System.out.println(status);
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean deleteUser(User user) {
        connection = dbConnection.connection;
        String query = "DELETE FROM user WHERE userId = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user.getUserId());
            int status = preparedStatement.executeUpdate();
            System.out.println(status);
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public ArrayList<User> listUsers() {
        ArrayList<User> userList = new ArrayList<User>();
        connection = dbConnection.connection;
        String query = "SELECT * FROM user";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("userId");
                String userName = resultSet.getString("userName");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String address = resultSet.getString("address");
                String contact = resultSet.getString("contact");
                int subscriptionId = resultSet.getInt("subscriptionId");
                int rentalId = resultSet.getInt("rentalId");
                boolean isUser = resultSet.getBoolean("isUser");
                User user = new User(userId, userName,email, password, address, contact, subscriptionId, rentalId, isUser);
                userList.add(user);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userList;
    }
   
}

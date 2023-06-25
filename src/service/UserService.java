package service;

import java.sql.*;
import database.DbConnection;
import model.User;
import java.util.*;
import java.sql.Date;

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
                "dateOfJoin DATE," +
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
        String query = "INSERT INTO user( userName, email, password,dateOfJoin, address, contact, subscriptionId, rentalId, isUser) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setDate(4, user.getDateOfJoin());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setString(6, user.getContact());
            preparedStatement.setInt(7, user.getSubscriptionId());
            preparedStatement.setInt(8, user.getRentalId());
            preparedStatement.setBoolean(9, user.getisUser());
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
        String query = "UPDATE user SET userName = ?,email = ?, password = ?,dateOfJoin = ?, address = ?, contact = ?, " +
                "subscriptionId = ?, rentalId = ?, isUser = ? WHERE userId = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setDate(4, user.getDateOfJoin());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setString(6, user.getContact());
            preparedStatement.setInt(7, user.getSubscriptionId());
            preparedStatement.setInt(8, user.getRentalId());
            preparedStatement.setBoolean(9, user.getisUser());
            preparedStatement.setInt(10, user.getUserId());
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
                Date dateOfJoin = resultSet.getDate("dateOfJoin");
                String address = resultSet.getString("address");
                String contact = resultSet.getString("contact");
                int subscriptionId = resultSet.getInt("subscriptionId");
                int rentalId = resultSet.getInt("rentalId");
                boolean isUser = resultSet.getBoolean("isUser");
                User user = new User(userId, userName,email, password, dateOfJoin, address, contact, subscriptionId, rentalId, isUser);
                userList.add(user);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userList;
    }
    
    public static void main(String[] args) {
        UserService userService = new UserService();

        User user1 = new User("John Doe", "johndoe@example.com", "password123", Date.valueOf("2021-01-01"), "123 Main St", "1234567890", 1, 1, true);
        User user2 = new User("Jane Smith", "janesmith@example.com", "password456", Date.valueOf("2021-01-02"), "456 Elm St", "0987654321", 2, 2, false);
        User user3 = new User("Michael Johnson", "michaeljohnson@example.com", "pass789", Date.valueOf("2021-01-03"), "789 Oak St", "9876543210", 3, 3, true);
        User user4 = new User("Emily Davis", "emilydavis@example.com", "pass321", Date.valueOf("2023-06-16"), "321 Pine St", "0123456789", 1, 4, true);
        User user5 = new User("William Wilson", "williamwilson@example.com", "pass654", Date.valueOf("2021-01-05"), "654 Cedar St", "9876543210", 2, 5, true);
        User user6 = new User("Olivia Brown", "oliviabrown@example.com", "pass987", Date.valueOf("2021-01-06"), "987 Elm St", "0123456789", 3, 6, false);
        User user7 = new User("James Taylor", "jamestaylor@example.com", "pass123", Date.valueOf("2023-06-07"), "123 Oak St", "1234567890", 1, 7, true);
        User user8 = new User("Sophia Martinez", "sophiamartinez@example.com", "pass456", Date.valueOf("2021-01-08"), "456 Pine St", "0987654321", 2, 8, true);
        User user9 = new User("Benjamin Anderson", "benjaminanderson@example.com", "pass789", Date.valueOf("2021-01-09"), "789 Cedar St", "9876543210", 3, 9, true);
        User user10 = new User("Ava Thomas", "avathomas@example.com", "pass321", Date.valueOf("2021-01-10"), "321 Elm St", "0123456789", 1, 10, true);
        User user11 = new User("Daniel Moore", "danielmoore@example.com", "pass654", Date.valueOf("2023-06-11"), "654 Oak St", "9876543210", 2, 11, false);
        User user12 = new User("Mia Garcia", "miagarcia@example.com", "pass987", Date.valueOf("2021-01-12"), "987 Pine St", "0123456789", 3, 12, true);
        User user13 = new User("David Clark", "davidclark@example.com", "pass123", Date.valueOf("2021-01-13"), "123 Cedar St", "1234567890", 1, 13, true);
        User user14 = new User("Abigail Lewis", "abigaillewis@example.com", "pass456", Date.valueOf("2023-06-14"), "456 Elm St", "0987654321", 2, 14, true);
        User user15 = new User("Sofia Lee", "sofialee@example.com", "pass789", Date.valueOf("2021-01-15"), "789 Oak St", "9876543210", 3, 15, true);

        userService.createUser(user1);
        userService.createUser(user2);
        userService.createUser(user3);
        userService.createUser(user4);
        userService.createUser(user5);
        userService.createUser(user6);
        userService.createUser(user7);
        userService.createUser(user8);
        userService.createUser(user9);
        userService.createUser(user10);
        userService.createUser(user11);
        userService.createUser(user12);
        userService.createUser(user13);
        userService.createUser(user14);
        userService.createUser(user15);
    }
}

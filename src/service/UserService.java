package service;

import java.sql.*;
import database.DbConnection;
import model.User;
import java.util.*;
import java.sql.Date;

public class UserService implements  IUserService{
    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;
    private final DbConnection dbConnection = new DbConnection();

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
                "subscription VARCHAR(50), " +
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
    @Override
    public boolean createUser(User user) {
        checkTableUser();
        connection = dbConnection.connection;
        String query = "INSERT INTO user( userName, email, password,dateOfJoin, address, contact, subscription,isUser) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setDate(4, user.getDateOfJoin());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setString(6, user.getContact());
            preparedStatement.setString(7, user.getSubscription());
            preparedStatement.setBoolean(8, user.getisUser());
            int status = preparedStatement.executeUpdate();
            System.out.println(status);
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
    public boolean updateUser(User user) {
        connection = dbConnection.connection;
        String query = "UPDATE user SET userName = ?,email = ?, password = ?, address = ?, contact = ?, " +
                "subscription = ?, isUser = ? WHERE userId = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setString(5, user.getContact());
            preparedStatement.setString(6, user.getSubscription());
            preparedStatement.setBoolean(7, user.getisUser());
            preparedStatement.setInt(8,user.getUserId());

            int status = preparedStatement.executeUpdate();
            System.out.println(status);
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    @Override
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
    @Override
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
                String subscription = resultSet.getString("subscription");
                boolean isUser = resultSet.getBoolean("isUser");
                User user = new User(userId,userName,email, password, dateOfJoin, address, contact, subscription, isUser);
                userList.add(user);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userList;
    }
    @Override
    public User selectUserID(int userId) {
        connection = dbConnection.connection;
        String query = "SELECT * FROM user WHERE userId = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setUserName(resultSet.getString("userName"));
                user.setEmail(resultSet.getString("email"));
                user.setDateOfJoin(resultSet.getDate("dateOfJoin"));
                user.setContact(resultSet.getString("contact"));
                user.setisUser(resultSet.getBoolean("isUser"));
                user.setAddress(resultSet.getString("address"));
                user.setSubscription(resultSet.getString("subscription"));
                return user;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
        
    }
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.checkTableUser();
    }
}

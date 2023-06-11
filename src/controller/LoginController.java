package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.DbConnection;

public class LoginController {
    private DbConnection dbConnection = new DbConnection();
    private Connection connection;
    private PreparedStatement preparedStatement;

    public boolean login(String username, String password) {
        System.out.println(username);
        System.out.println(password);
        connection = dbConnection.connection;
        String query = "SELECT password FROM users WHERE name = ?";        
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(0, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                if(resultSet.getString("password").equals(password)){
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.DbConnection;
import model.Admin;

public class AdminService {
    private DbConnection dbConnection = new DbConnection();
    private Connection connection;
    private PreparedStatement preparedStatement;

    public boolean register(Admin admin){
        connection = dbConnection.connection;
        String query = "insert into users (username, pass, email) values (?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, admin.getName());
            preparedStatement.setString(2, admin.getPassword());
            preparedStatement.setString(3, admin.getEmail());
            int status = preparedStatement.executeUpdate();

            if(status > 0){
                return(true);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return(false);
    }
}


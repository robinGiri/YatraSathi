package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import database.DbConnection;

public class RegisterController {
    private DbConnection dbConnection = new DbConnection();
    private Connection connection;
    private PreparedStatement preparedStatement;

    public Boolean register(String username, String password, String email) {

        connection = dbConnection.connection;
        String query = "insert into users (username, pass, email) values (?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
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

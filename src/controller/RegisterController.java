package controller;

import java.sql.*;
import database.DbConnection;

public class RegisterController {
    private DbConnection dbConnection = new DbConnection();
    private Connection connection;
    private PreparedStatement preparedStatement;
    
    
    public boolean checkTable(){
        connection = dbConnection.connection;
        String query ="CREATE TABLE IF NOT EXISTS users (username INT, pass VARCHAR(50), email VARCHAR(25))";
        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            return (true);  
          }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return(false);       
    }
    

    public Boolean register(String username, String password, String email) {
        
        checkTable();

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
    
//    public static void main(String [] args){
//        RegisterController rc = new RegisterController();
//        System.out.println(rc.checkTable());
//        
//    }
    

}

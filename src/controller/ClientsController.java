package controller;
import java.sql.*;
import database.DbConnection;

public class ClientsController {
     private DbConnection dbConnection = new DbConnection();
     private Connection connection;
     private PreparedStatement preparedStatement;
     private ResultSet resultSet;
     
    //create the table if not created in database;
    public boolean CheckTable(){
        connection = dbConnection.connection;
         String query = "CREATE TABLE IF NOT EXISTS clients (" +
                "customerId INT PRIMARY KEY, " +
                "customerName VARCHAR(50), " +
                "address VARCHAR(50), " +
                "contact VARCHAR(15), " +
                "subscriptionId INT, " +
                "rentalId INT)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            return(true);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return(false);
        
    }
    // load all clients
    public void loadClients(){
        connection = dbConnection.connection;
        String query = "SELECT * FROM clients";
        try{
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("customerName"));
                
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            
        } 
    }
    

    // load client by id
public void loadClientsById(int customerId){
        connection = dbConnection.connection;
        String query = "SELECT customerName FROM clients where customerId = ? ";
        try{
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(customerId));
        resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("customerName"));
                
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            
        } 
    }

    // add client
public void addClients(int customerId,String customerName, String address, String contact, int subscriptionId, int rentalId){
        connection = dbConnection.connection;
        String query = "INSERT INTO clients ( customerId, customerName, address, contact, subscriptionId, rentalId) values(?,?,?,?,?,?) ";
        try{
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(customerId));
        preparedStatement.setString(2,customerName);
        preparedStatement.setString(3,address);
        preparedStatement.setString(4, contact);
        preparedStatement.setString(5, String.valueOf(subscriptionId));
        preparedStatement.setString(6, String.valueOf(rentalId));
        preparedStatement.execute();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            
        } 
    }

    // update client
    public void updateClient(int customerId, String customerName, String address, String contact, int subscriptionId, int rentalId) {
        connection = dbConnection.connection;
        String query = "UPDATE clients SET customerName = ?, address = ?, contact = ?, subscriptionId = ?, rentalId = ? WHERE customerId = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, customerName);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, contact);
            preparedStatement.setInt(4, subscriptionId);
            preparedStatement.setInt(5, rentalId);
            preparedStatement.setInt(6, customerId);
            preparedStatement.executeUpdate();
        System.out.println("Client information updated successfully.");
    } catch (SQLException e) {
        System.out.println("An error occurred while updating client information: " + e.getMessage());
    }
}

    // delete client
    public void deleteClient(int customerId) {
    connection = dbConnection.connection;
    String query = "DELETE FROM clients WHERE customerId = ?";
    try {
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, customerId);
        preparedStatement.executeUpdate();
        System.out.println("Client with customerId " + customerId + " deleted successfully.");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}
    public static void main(String[] args) {
        //ClientsController clientsController = new ClientsController(); 
        //clientsController.CheckTable();
        //clientsController.loadClients();
        //clientsController.loadClientsById(3);
        //clientsController.addClients(4, "Sarah Adams", "567 Pine St", "111-222-3333", 104, 204);
        //clientsController.addClients(5, "Robert Williams", "890 Cedar St", "444-555-6666", 105, 205);
        //clientsController.updateClient(1, "John Doe", "123 Main St", "123-456-7890", 101, 201);
        //clientsController.deleteClient(3);
    }
    
}

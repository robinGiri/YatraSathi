package service;    

import database.DbConnection;
import model.Owner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OwnerService {
    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;
    private DbConnection dbConnection = new DbConnection();

    // It checks the table and creates a new table if it does not exist
    public boolean checkTableOwner() {
        connection = dbConnection.connection;
        String query = "CREATE TABLE IF NOT EXISTS owner (" +
                "owner_id INT AUTO_INCREMENT PRIMARY KEY, " +
                "owner_name VARCHAR(50), " +
                "address VARCHAR(100), " +
                "contact VARCHAR(20), " +
                "username VARCHAR(50), " +
                "password VARCHAR(50), " +
                "admin_id INT, " +
                "account_status VARCHAR(20))";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Create owner
    public boolean createOwner(Owner owner) {
        checkTableOwner();
        connection = dbConnection.connection;
        String query = "INSERT INTO owner (owner_name, address, contact, username, password, admin_id, account_status) "
                +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, owner.getOwnerName());
            preparedStatement.setString(2, owner.getAddress());
            preparedStatement.setString(3, owner.getContact());
            preparedStatement.setString(4, owner.getUsername());
            preparedStatement.setString(5, owner.getPassword());
            preparedStatement.setInt(6, owner.getAdminId());
            preparedStatement.setString(7, owner.getAccountStatus());
            int status = preparedStatement.executeUpdate();
            return status > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateOwner(Owner owner) {
        connection = dbConnection.connection;
        String query = "UPDATE owner SET owner_name = ?, address = ?, contact = ?, " +
                "username = ?, password = ?, admin_id = ?, account_status = ? WHERE owner_id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, owner.getOwnerName());
            preparedStatement.setString(2, owner.getAddress());
            preparedStatement.setString(3, owner.getContact());
            preparedStatement.setString(4, owner.getUsername());
            preparedStatement.setString(5, owner.getPassword());
            preparedStatement.setInt(6, owner.getAdminId());
            preparedStatement.setString(7, owner.getAccountStatus());
            preparedStatement.setInt(8, owner.getOwnerId());
            int status = preparedStatement.executeUpdate();
            return status > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteOwner(Owner owner) {
        connection = dbConnection.connection;
        String query = "DELETE FROM owner WHERE owner_id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, owner.getOwnerId());
            int status = preparedStatement.executeUpdate();
            return status > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Owner> listOwners() {
        ArrayList<Owner> ownerList = new ArrayList<>();
        connection = dbConnection.connection;
        String query = "SELECT * FROM owner";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int owner_id = resultSet.getInt("owner_id");
                String owner_name = resultSet.getString("owner_name");
                String address = resultSet.getString("address");
                String contact = resultSet.getString("contact");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                int admin_id = resultSet.getInt("admin_id");
                String account_status = resultSet.getString("account_status");
                Owner owner = new Owner(owner_id, owner_name, address, contact, username, password, admin_id,
                        account_status);
                ownerList.add(owner);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ownerList;
    }

    public static void main(String[] args) {
        OwnerService ownerService = new OwnerService();

        Owner owner1 = new Owner(0, "Ukran Tandukar", "Maitidevi", "9847344775", "Kraken", "password", 1, "active");
        Owner owner2 = new Owner(0, "Sandesh Khatiwada", "Kapan", "9876543210", "Sandy", "newpassword", 2, "inactive");
        ownerService.createOwner(owner1);
        ownerService.createOwner(owner2);

    }

}

package service;

import database.DbConnection;
import model.Driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DriverService implements IDriverService{
    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;
    private DbConnection dbConnection = new DbConnection();

    // It checks the table and creates a new table if it does not exist
    public boolean checkTableDriver() {
        connection = dbConnection.connection;
        String query = "CREATE TABLE IF NOT EXISTS driver (" +
                "driver_id INT AUTO_INCREMENT PRIMARY KEY, " +
                "driver_name VARCHAR(50), " +
                "joined_date DATE, " +
                "driver_commision VARCHAR(50), " +
                "driver_contact VARCHAR(20))";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Create driver
    public boolean createDriver(Driver driver) {
        checkTableDriver();
        connection = dbConnection.connection;
        String query = "INSERT INTO driver (driver_name, joined_date, driver_commision, driver_contact) " +
                "VALUES (?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, driver.getDriver_name());
            preparedStatement.setDate(2, driver.getJoined_date());
            preparedStatement.setString(3, driver.getDriver_commision());
            preparedStatement.setString(4, driver.getDriver_contact());
            int status = preparedStatement.executeUpdate();
            return status > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateDriver(Driver driver) {
        connection = dbConnection.connection;
        String query = "UPDATE driver SET driver_name = ?, joined_date = ?, driver_commision = ?, " +
                "driver_contact = ? WHERE driver_id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, driver.getDriver_name());
            preparedStatement.setDate(2, driver.getJoined_date());
            preparedStatement.setString(3, driver.getDriver_commision());
            preparedStatement.setString(4, driver.getDriver_contact());
            preparedStatement.setInt(5, driver.getDriver_id());
            int status = preparedStatement.executeUpdate();
            return status > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteDriver(Driver driver) {
        connection = dbConnection.connection;
        String query = "DELETE FROM driver WHERE driver_id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, driver.getDriver_id());
            int status = preparedStatement.executeUpdate();
            return status > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Driver> listDrivers() {
        ArrayList<Driver> driverList = new ArrayList<>();
        connection = dbConnection.connection;
        String query = "SELECT * FROM driver";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int driver_id = resultSet.getInt("driver_id");
                String driver_name = resultSet.getString("driver_name");
                java.sql.Date joined_date = resultSet.getDate("joined_date");
                String driver_commision = resultSet.getString("driver_commision");
                String driver_contact = resultSet.getString("driver_contact");
                Driver driver = new Driver(driver_id, driver_name, joined_date, driver_commision, driver_contact);
                driverList.add(driver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return driverList;
    }
    public static void main(String[] args) {

    DriverService driverService = new DriverService();


    Driver driver1 = new Driver(0, "Ukran Tandukar", new java.sql.Date(System.currentTimeMillis()), "10%", "9847344775");
    Driver driver2 = new Driver(0, "Sandesh Khatiwada", new java.sql.Date(System.currentTimeMillis()), "15%", "9876543210");
    
    driverService.createDriver(driver1);
    driverService.createDriver(driver2);
}

}
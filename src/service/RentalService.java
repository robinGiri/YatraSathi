package service;

import java.sql.*;
import database.DbConnection;
import model.Rental;
import java.util.ArrayList;

public class RentalService {
    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;
    private DbConnection dbConnection = new DbConnection();

    // Check if the rental table exists, create it if not
    public boolean checkTableRental() {
        connection = dbConnection.connection;
        String query = "CREATE TABLE IF NOT EXISTS rental (" +
                "rentalId INT PRIMARY KEY, " +
                "rentalDateTime DATE, " +
                "returnDateTime DATE, " +
                "totalPrice INT, " +
                "ownerId INT, " +
                "carId INT, " +
                "categoryId INT, " +
                "customerId INT, " +
                "rentalStatus VARCHAR(50), " +
                "pickup VARCHAR(50), " +
                "dropOff VARCHAR(50), " +
                "driverId INT, " +
                "paymentId INT)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    // Create a rental
    public boolean createRental(Rental rental) {
        checkTableRental();
        connection = dbConnection.connection;
        String query = "INSERT INTO rental(rentalId, rentalDateTime, returnDateTime, totalPrice, ownerId, carId, " +
                "categoryId, customerId, rentalStatus, pickup, dropOff, driverId, paymentId) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, rental.getRental_id());
            preparedStatement.setDate(2, rental.getRental_datetime());
            preparedStatement.setDate(3, rental.getReturn_datetime());
            preparedStatement.setInt(4, rental.getTotal_price());
            preparedStatement.setInt(5, rental.getOwner_id());
            preparedStatement.setInt(6, rental.getCar_id());
            preparedStatement.setInt(7, rental.getCategory_id());
            preparedStatement.setInt(8, rental.getCustomer_id());
            preparedStatement.setString(9, rental.getRental_status());
            preparedStatement.setString(10, rental.getPickup());
            preparedStatement.setString(11, rental.getDropoff());
            preparedStatement.setInt(12, rental.getDriver_id());
            preparedStatement.setInt(13, rental.getPayment_id());

            int status = preparedStatement.executeUpdate();
            return (status > 0);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean updateRental(Rental rental) {
        connection = dbConnection.connection;
        String query = "UPDATE rental SET rentalDateTime = ?, returnDateTime = ?, totalPrice = ?, " +
                "ownerId = ?, carId = ?, categoryId = ?, customerId = ?, rentalStatus = ?, pickup = ?, " +
                "dropOff = ?, driverId = ?, paymentId = ? WHERE rentalId = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, rental.getRental_datetime());
            preparedStatement.setDate(2, rental.getReturn_datetime());
            preparedStatement.setInt(3, rental.getTotal_price());
            preparedStatement.setInt(4, rental.getOwner_id());
            preparedStatement.setInt(5, rental.getCar_id());
            preparedStatement.setInt(6, rental.getCategory_id());
            preparedStatement.setInt(7, rental.getCustomer_id());
            preparedStatement.setString(8, rental.getRental_status());
            preparedStatement.setString(9, rental.getPickup());
            preparedStatement.setString(10, rental.getDropoff());
            preparedStatement.setInt(11, rental.getDriver_id());
            preparedStatement.setInt(12, rental.getPayment_id());
            preparedStatement.setInt(13, rental.getRental_id());

            int status = preparedStatement.executeUpdate();
            return (status > 0);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean deleteRental(int rentalId) {
        connection = dbConnection.connection;
        String query = "DELETE FROM rental WHERE rentalId = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, rentalId);
            int status = preparedStatement.executeUpdate();
            return (status > 0);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public ArrayList<Rental> listRentals() {
        ArrayList<Rental> rentalsList = new ArrayList<>();
        connection = dbConnection.connection;
        String query = "SELECT * FROM rental";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int rentalId = resultSet.getInt("rentalId");
                Date rentalDateTime = resultSet.getDate("rentalDateTime");
                Date returnDateTime = resultSet.getDate("returnDateTime");
                int totalPrice = resultSet.getInt("totalPrice");
                int ownerId = resultSet.getInt("ownerId");
                int carId = resultSet.getInt("carId");
                int categoryId = resultSet.getInt("categoryId");
                int customerId = resultSet.getInt("customerId");
                String rentalStatus = resultSet.getString("rentalStatus");
                String pickup = resultSet.getString("pickup");
                String dropoff = resultSet.getString("dropOff");
                int driverId = resultSet.getInt("driverId");
                int paymentId = resultSet.getInt("paymentId");

                Rental rental = new Rental(rentalId, rentalDateTime, returnDateTime, totalPrice, ownerId, carId,
                        categoryId, customerId, rentalStatus, pickup, dropoff, driverId, paymentId);
                rentalsList.add(rental);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rentalsList;
    }
}

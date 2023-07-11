package service;

import java.sql.*;
import database.DbConnection;
import model.Rental;
import java.util.ArrayList;

public class RentalService implements IRentalService {
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
                "returnDateTime DATE" +
                "carId INT, " +
                "customerId INT, " +
                "pickup VARCHAR(50), " +
                "dropOff VARCHAR(50)" + ")";
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
        String query = "INSERT INTO rental(rentalId, rentalDateTime,returnDateTime,carId, " +
                "categoryId, customerId, pickup, dropOff) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, rental.getRental_id());
            preparedStatement.setDate(2, rental.getRental_datetime());
            preparedStatement.setDate(4, rental.getReturn_datetime());
            preparedStatement.setInt(5, rental.getCar_id());
            preparedStatement.setInt(6, rental.getCustomer_id());
            preparedStatement.setString(7, rental.getPickup());
            preparedStatement.setString(8, rental.getDropoff());

            int status = preparedStatement.executeUpdate();
            return (status > 0);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Rental getRentalById(int rentalId) {
        connection = dbConnection.connection;
        String query = "SELECT * FROM rental WHERE rentalId = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, rentalId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Rental rental = new Rental();
                rental.setRental_id(resultSet.getInt("rentalId"));
                rental.setRental_datetime(resultSet.getDate("rentalDateTime"));
                rental.setReturn_datetime(resultSet.getDate("returnDateTime"));
                rental.setCar_id(resultSet.getInt("carId"));
                rental.setCustomer_id(resultSet.getInt("customerId"));
                rental.setPickup(resultSet.getString("pickup"));
                rental.setDropoff(resultSet.getString("dropoff"));

                return rental;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean updateRental(Rental rental) {
        connection = dbConnection.connection;
        String query = "UPDATE rental SET rentalDateTime = ?, returnDateTime = ?," +
                "carId = ?, customerId = ?, pickup = ?, " +
                "dropOff = ? WHERE rentalId = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, rental.getRental_datetime());
            preparedStatement.setDate(2, rental.getReturn_datetime());
            preparedStatement.setInt(3, rental.getCar_id());
            preparedStatement.setInt(4, rental.getCustomer_id());
            preparedStatement.setString(5, rental.getPickup());
            preparedStatement.setString(6, rental.getDropoff());
            preparedStatement.setInt(7, rental.getRental_id());

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
                int carId = resultSet.getInt("carId");
                int customerId = resultSet.getInt("customerId");
                String pickup = resultSet.getString("pickup");
                String dropoff = resultSet.getString("dropOff");

                Rental rental = new Rental(rentalId, rentalDateTime, returnDateTime, carId, customerId, pickup,
                        dropoff);
                rentalsList.add(rental);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rentalsList;
    }

}

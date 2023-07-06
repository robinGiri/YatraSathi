package service;

import java.sql.*;
import database.DbConnection;
import model.Rental;
import java.util.ArrayList;
import model.Car;

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
        String query = "INSERT INTO rental(rentalId, rentalDateTime, totalPrice, ownerId, carId, " +
                "categoryId, customerId, rentalStatus, pickup, dropOff, driverId, paymentId) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, rental.getRental_id());
            preparedStatement.setDate(2, rental.getRental_datetime());
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
                rental.setTotal_price(resultSet.getInt("totalPrice"));
                rental.setOwner_id(resultSet.getInt("ownerId"));
                rental.setCar_id(resultSet.getInt("carId"));
                rental.setCategory_id(resultSet.getInt("categoryId"));
                rental.setCustomer_id(resultSet.getInt("customerId"));
                rental.setRental_status(resultSet.getString("rentalStatus"));
                rental.setPickup(resultSet.getString("pickup"));
                rental.setDropoff(resultSet.getString("dropoff"));
                rental.setDriver_id(resultSet.getInt("driverId"));
                rental.setPayment_id(resultSet.getInt("paymentId"));

                return rental;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

            

    public boolean updateRental(Rental rental) {
        connection = dbConnection.connection;
        String query = "UPDATE rental SET rentalDateTime = ?, totalPrice = ?, " +
                "ownerId = ?, carId = ?, categoryId = ?, customerId = ?, rentalStatus = ?, pickup = ?, " +
                "dropOff = ?, driverId = ?, paymentId = ? WHERE rentalId = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, rental.getRental_datetime());
            preparedStatement.setInt(2, rental.getTotal_price());
            preparedStatement.setInt(3, rental.getOwner_id());
            preparedStatement.setInt(4, rental.getCar_id());
            preparedStatement.setInt(5, rental.getCategory_id());
            preparedStatement.setInt(6, rental.getCustomer_id());
            preparedStatement.setString(7, rental.getRental_status());
            preparedStatement.setString(8, rental.getPickup());
            preparedStatement.setString(9, rental.getDropoff());
            preparedStatement.setInt(10, rental.getDriver_id());
            preparedStatement.setInt(11, rental.getPayment_id());
            preparedStatement.setInt(12, rental.getRental_id());

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

                Rental rental = new Rental(rentalId, rentalDateTime, totalPrice, ownerId, carId,
                        categoryId, customerId, rentalStatus, pickup, dropoff, driverId, paymentId);
                rentalsList.add(rental);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rentalsList;
    }
        public static void main(String[] args) {
        RentalService rentalService = new RentalService();
       
        Rental rental1 = new Rental(1, new java.sql.Date(System.currentTimeMillis()), 200, 1, 1, 1, 1,
                "Completed", "Location1", "Location2", 1, 1);
        Rental rental2 = new Rental(2, new java.sql.Date(System.currentTimeMillis()), 150, 2, 2, 2, 2,
                "Pending", "Location3", "Location4", 2, 2);

        
        rentalService.createRental(rental1);
        rentalService.createRental(rental2);
}
        
}

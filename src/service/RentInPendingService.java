package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.DbConnection;

public class RentInPendingService {
    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;
    private DbConnection dbConnection = new DbConnection();

    public int countRentalsInPending() {
        connection = dbConnection.connection;
        int count = 0;

        String query = "SELECT COUNT(rentalId) AS NumberOfRentsPending FROM rental WHERE rentalStatus = 'Pending'";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt("NumberOfRentsPending");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeResources();
        }

        return count;
    }

    private void closeResources() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error while closing resources: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        RentInPendingService rentInPendingService = new RentInPendingService();
        int numberOfRentsPending = rentInPendingService.countRentalsInPending();
        System.out.println("Number of rentals in pending status: " + numberOfRentsPending);
    }
}

package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.DbConnection;

public class RentsCountService {
    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;
    private DbConnection dbConnection = new DbConnection();

    public int countRentedCars() {
        connection = dbConnection.connection;
        int count = 0;

        String query = "SELECT COUNT(*) AS NumberOfRentedCars FROM rental";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt("NumberOfRentedCars");
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
        RentsCountService carRentalCountService = new RentsCountService();
        int numberOfRentedCars = carRentalCountService.countRentedCars();
        System.out.println("Number of rented cars: " + numberOfRentedCars);
    }
}


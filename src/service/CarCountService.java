package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.DbConnection;

public class CarCountService {
    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;
    private DbConnection dbConnection = new DbConnection();

    public int countAvailableCars() {
        connection = dbConnection.connection;
        int count = 0;

        String query = "SELECT COUNT(carId) AS NumberOfCar FROM car WHERE carStatus = 'Available'";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt("NumberOfCar");
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
        CarCountService carCountService = new CarCountService();
        int numberOfAvailableCars = carCountService.countAvailableCars();
        System.out.println("Number of available cars: " + numberOfAvailableCars);

    }

}

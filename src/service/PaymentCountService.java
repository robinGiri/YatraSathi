package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.DbConnection;

public class PaymentCountService {
    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;
    private DbConnection dbConnection = new DbConnection();

    public double countTotalPaymentAmount() {
        connection = dbConnection.connection;
        double totalAmount = 0.0;

        String query = "SELECT SUM(paymentAmount) AS TotalPaymentAmount FROM payment";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                totalAmount = resultSet.getDouble("TotalPaymentAmount");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeResources();
        }

        return totalAmount;
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

}

package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.DbConnection;
import java.time.LocalDate;
import java.time.YearMonth;

public class CurrentMonthPaymentCountService {
    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;
    private DbConnection dbConnection = new DbConnection();

    public double countCurrentMonthPaymentAmount() {
        connection = dbConnection.connection;
        double totalAmount = 0.0;
        
        LocalDate currentDate = LocalDate.now();
        YearMonth currentMonth = YearMonth.from(currentDate);

        String query = "SELECT SUM(paymentAmount) AS TotalPaymentAmount FROM payment WHERE YEAR(paymentDate) = ? AND MONTH(paymentDate) = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, currentMonth.getYear());
            preparedStatement.setInt(2, currentMonth.getMonthValue());
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

    public static void main(String[] args) {
        CurrentMonthPaymentCountService paymentCountService = new CurrentMonthPaymentCountService();
        double currentMonthPaymentAmount = paymentCountService.countCurrentMonthPaymentAmount();
        System.out.println("Payment amount for the current month: " + currentMonthPaymentAmount);

    }
}

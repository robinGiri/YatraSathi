package service;

import model.Payment;
import java.sql.*;
import java.util.ArrayList;
import database.DbConnection;

public class PaymentService {
    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;
    private DbConnection dbConnection = new DbConnection();

    // Check if the payment table exists, create it if not
    public boolean checkTablePayment() {
        connection = dbConnection.connection;
        String query = "CREATE TABLE IF NOT EXISTS payment (" +
                "paymentId INT PRIMARY KEY, " +
                "rentalId INT, " +
                "paymentAmount DOUBLE, " +
                "paymentDate DATE, " +
                "adminId INT)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    // Create a payment
    public boolean createPayment(Payment payment) {
        checkTablePayment();
        connection = dbConnection.connection;
        String query = "INSERT INTO payment(paymentId, rentalId, paymentAmount, paymentDate, adminId) " +
                "VALUES (?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, payment.getPaymentId());
            preparedStatement.setInt(2, payment.getRentalId());
            preparedStatement.setDouble(3, payment.getPaymentAmount());
            preparedStatement.setDate(4, new java.sql.Date(payment.getPaymentDate().getTime()));
            preparedStatement.setInt(5, payment.getAdminId());

            int status = preparedStatement.executeUpdate();
            return (status > 0);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean updatePayment(Payment payment) {
        connection = dbConnection.connection;
        String query = "UPDATE payment SET rentalId = ?, paymentAmount = ?, paymentDate = ?, adminId = ? " +
                "WHERE paymentId = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, payment.getRentalId());
            preparedStatement.setDouble(2, payment.getPaymentAmount());
            preparedStatement.setDate(3, new java.sql.Date(payment.getPaymentDate().getTime()));
            preparedStatement.setInt(4, payment.getAdminId());
            preparedStatement.setInt(5, payment.getPaymentId());

            int status = preparedStatement.executeUpdate();
            return (status > 0);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean deletePayment(int paymentId) {
        connection = dbConnection.connection;
        String query = "DELETE FROM payment WHERE paymentId = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, paymentId);

            int status = preparedStatement.executeUpdate();
            return (status > 0);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public ArrayList<Payment> listPayments() {
        ArrayList<Payment> paymentList = new ArrayList<>();
        connection = dbConnection.connection;
        String query = "SELECT * FROM payment";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int paymentId = resultSet.getInt("paymentId");
                int rentalId = resultSet.getInt("rentalId");
                double paymentAmount = resultSet.getDouble("paymentAmount");
                Date paymentDate = resultSet.getDate("paymentDate");
                int adminId = resultSet.getInt("adminId");

                Payment payment = new Payment(paymentId, rentalId, paymentAmount, paymentDate, adminId);
                paymentList.add(payment);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return paymentList;
    }

}

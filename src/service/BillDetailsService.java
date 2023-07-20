package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import database.DbConnection;
import model.BillDetails;

public class BillDetailsService {
    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;
    private DbConnection dbConnection = new DbConnection();

    // Retrieve bill details by bill number
    public BillDetails getBillDetailsByBillNumber(int billNumber) {
        connection = dbConnection.connection;
        String query = "SELECT b.billNo, b.date AS billDate, u.userName AS customerName, c.carId AS carNo, c.carName, " +
                "c.rate AS carRate, r.rentalDateTime AS rentalDate, r.returnDateTime AS returnDate, " +
                "(DATEDIFF(r.returnDateTime, r.rentalDateTime) * c.rate) AS totalAmount, " +
                "(DATEDIFF(r.returnDateTime, r.rentalDateTime) * c.rate) * " +
                "CASE " +
                "    WHEN u.subscription = 'platinum' THEN 0.2 " +
                "    WHEN u.subscription = 'gold' THEN 0.1 " +
                "    WHEN u.subscription = 'silver' THEN 0.05 " +
                "    ELSE 0 " +
                "END AS discountAmount, " +
                "(DATEDIFF(r.returnDateTime, r.rentalDateTime) * c.rate) - " +
                "((DATEDIFF(r.returnDateTime, r.rentalDateTime) * c.rate) * " +
                "CASE " +
                "    WHEN u.subscription = 'platinum' THEN 0.2 " +
                "    WHEN u.subscription = 'gold' THEN 0.1 " +
                "    WHEN u.subscription = 'silver' THEN 0.05 " +
                "    ELSE 0 " +
                "END) AS total, " +
                "(DATEDIFF(r.returnDateTime, r.rentalDateTime) * c.rate) - " +
                "((DATEDIFF(r.returnDateTime, r.rentalDateTime) * c.rate) * " +
                "CASE " +
                "    WHEN u.subscription = 'platinum' THEN 0.2 " +
                "    WHEN u.subscription = 'gold' THEN 0.1 " +
                "    WHEN u.subscription = 'silver' THEN 0.05 " +
                "    ELSE 0 " +
                "END) AS total_after_discount " +
                "FROM bill b " +
                "JOIN car c ON b.carId = c.carId " +
                "JOIN rental r ON b.rentalId = r.rentalId " +
                "JOIN user u ON b.customerId = u.userId " +
                "WHERE b.billNo = ?";
        
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, billNumber);
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                BillDetails billDetails = new BillDetails();
                billDetails.setBillNo(resultSet.getInt("billNo"));
                billDetails.setBillDate(resultSet.getDate("billDate"));
                billDetails.setCustomerName(resultSet.getString("customerName"));
                billDetails.setCarNo(resultSet.getInt("carNo"));
                billDetails.setCarName(resultSet.getString("carName"));
                billDetails.setCarRate(resultSet.getInt("carRate"));
                billDetails.setRentalDate(resultSet.getDate("rentalDate"));
                billDetails.setReturnDate(resultSet.getDate("returnDate"));
                billDetails.setTotalAmount(resultSet.getInt("totalAmount"));
                billDetails.setDiscountAmount(resultSet.getInt("discountAmount"));
                billDetails.setTotal(resultSet.getInt("total"));
                billDetails.setTotalAfterDiscount(resultSet.getInt("total_after_discount"));
                return billDetails;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
       public ArrayList<BillDetails> getBillDetails() {
        ArrayList<BillDetails> billDetailsList = new ArrayList<>();
        connection = dbConnection.connection;
        String query = "SELECT b.billNo, b.date AS billDate, u.userName AS customerName, c.carId AS carNo, c.carName, " +
                "c.rate AS carRate, r.rentalDateTime AS rentalDate, r.returnDateTime AS returnDate, " +
                "(DATEDIFF(r.returnDateTime, r.rentalDateTime) * c.rate) AS totalAmount, " +
                "(DATEDIFF(r.returnDateTime, r.rentalDateTime) * c.rate) * " +
                "CASE " +
                "    WHEN u.subscription = 'platinum' THEN 0.2 " +
                "    WHEN u.subscription = 'gold' THEN 0.1 " +
                "    WHEN u.subscription = 'silver' THEN 0.05 " +
                "    ELSE 0 " +
                "END AS discountAmount, " +
                "(DATEDIFF(r.returnDateTime, r.rentalDateTime) * c.rate) - " +
                "((DATEDIFF(r.returnDateTime, r.rentalDateTime) * c.rate) * " +
                "CASE " +
                "    WHEN u.subscription = 'platinum' THEN 0.2 " +
                "    WHEN u.subscription = 'gold' THEN 0.1 " +
                "    WHEN u.subscription = 'silver' THEN 0.05 " +
                "    ELSE 0 " +
                "END) AS total, " +
                "(DATEDIFF(r.returnDateTime, r.rentalDateTime) * c.rate) - " +
                "((DATEDIFF(r.returnDateTime, r.rentalDateTime) * c.rate) * " +
                "CASE " +
                "    WHEN u.subscription = 'platinum' THEN 0.2 " +
                "    WHEN u.subscription = 'gold' THEN 0.1 " +
                "    WHEN u.subscription = 'silver' THEN 0.05 " +
                "    ELSE 0 " +
                "END) AS total_after_discount " +
                "FROM bill b " +
                "JOIN car c ON b.carId = c.carId " +
                "JOIN rental r ON b.rentalId = r.rentalId " +
                "JOIN user u ON b.customerId = u.userId";
        
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                BillDetails billDetails = new BillDetails();
                billDetails.setBillNo(resultSet.getInt("billNo"));
                billDetails.setBillDate(resultSet.getDate("billDate"));
                billDetails.setCustomerName(resultSet.getString("customerName"));
                billDetails.setCarNo(resultSet.getInt("carNo"));
                billDetails.setCarName(resultSet.getString("carName"));
                billDetails.setCarRate(resultSet.getInt("carRate"));
                billDetails.setRentalDate(resultSet.getDate("rentalDate"));
                billDetails.setReturnDate(resultSet.getDate("returnDate"));
                billDetails.setTotalAmount(resultSet.getInt("totalAmount"));
                billDetails.setDiscountAmount(resultSet.getInt("discountAmount"));
                billDetails.setTotal(resultSet.getInt("total"));
                billDetails.setTotalAfterDiscount(resultSet.getInt("total_after_discount"));
                billDetailsList.add(billDetails);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return billDetailsList;
    }
}

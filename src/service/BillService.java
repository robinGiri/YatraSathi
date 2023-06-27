package service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import database.DbConnection;
import model.Bill;

public class BillService implements IBillService {
    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;
    private DbConnection dbConnection = new DbConnection();

    // Create the bill table if it does not exist
    private void createBillTable() {
        connection = dbConnection.connection;
        String query = "CREATE TABLE IF NOT EXISTS bill (" +
                "rental_id INT, " +
                "admin_id INT, " +
                "payment_id INT PRIMARY KEY AUTO_INCREMENT, " +
                "payment_date DATE, " +
                "payment_amount DECIMAL(10,2))";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Create a new bill
    public boolean createBill(Bill bill) {
        createBillTable();
        connection = dbConnection.connection;
        String query = "INSERT INTO bill (rental_id, admin_id, payment_date, payment_amount) VALUES (?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, bill.getRentalId());
            preparedStatement.setInt(2, bill.getAdminId());
            preparedStatement.setDate(3, new java.sql.Date(bill.getPaymentDate().getTime()));
            preparedStatement.setDouble(4, bill.getPaymentAmount());
            int status = preparedStatement.executeUpdate();
            return status > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Update an existing bill
    public boolean updateBill(Bill bill) {
        connection = dbConnection.connection;
        String query = "UPDATE bill SET rental_id = ?, admin_id = ?, payment_date = ?, payment_amount = ? WHERE payment_id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, bill.getRentalId());
            preparedStatement.setInt(2, bill.getAdminId());
            preparedStatement.setDate(3, new java.sql.Date(bill.getPaymentDate().getTime()));
            preparedStatement.setDouble(4, bill.getPaymentAmount());
            preparedStatement.setInt(5, bill.getPaymentId());
            int status = preparedStatement.executeUpdate();
            return status > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete a bill
    public boolean deleteBill(Bill bill) {
        connection = dbConnection.connection;
        String query = "DELETE FROM bill WHERE payment_id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, bill.getPaymentId());
            int status = preparedStatement.executeUpdate();
            return status > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Get a list of all bills
    public ArrayList<Bill> listBills() {
        ArrayList<Bill> billList = new ArrayList<>();
        connection = dbConnection.connection;
        String query = "SELECT * FROM bill";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int rentalId = resultSet.getInt("rental_id");
                int adminId = resultSet.getInt("admin_id");
                int paymentId = resultSet.getInt("payment_id");
                Date paymentDate = resultSet.getDate("payment_date");
                double paymentAmount = resultSet.getDouble("payment_amount");
                Bill bill = new Bill(rentalId, adminId, paymentId, paymentDate, paymentAmount);
                billList.add(bill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return billList;
    }

    public static void main(String[] args) {
        BillService billService = new BillService();

        // Example usage
        Bill bill1 = new Bill(1, 1, 1, new Date(), 100.0);
        Bill bill2 = new Bill(2, 1, 2, new Date(), 200.0);
        billService.createBill(bill1);
        billService.createBill(bill2);

        List<Bill> bills = billService.listBills();
        for (Bill bill : bills) {
            System.out.println("Rental ID: " + bill.getRentalId());
            System.out.println("Admin ID: " + bill.getAdminId());
            System.out.println("Payment ID: " + bill.getPaymentId());
            System.out.println("Payment Date: " + bill.getPaymentDate());
            System.out.println("Payment Amount: " + bill.getPaymentAmount());
            System.out.println("-------------------------");
        }
    }
}

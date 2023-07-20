package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import database.DbConnection;
import java.time.LocalDate;
import model.Bill;

public class BillService implements IBillService {
    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;
    private DbConnection dbConnection = new DbConnection();

    private boolean checkTableBill() {
        connection = dbConnection.connection;
        String query = "CREATE TABLE IF NOT EXISTS bill ("
                        +"billNo INT PRIMARY KEY auto_increment,"
                        +"date DATE,"
                        +"carId INT,"
                        +"rentalId INT,"
                        +"customerId INT,"
                        +"FOREIGN KEY (carId) REFERENCES car(carId),"
                        +"FOREIGN KEY (rentalId) REFERENCES rental(rentalId)," 
                        +"FOREIGN KEY (customerId) REFERENCES clients(customerId))";
                                                       
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    // Create a bill
    public boolean createBill(Bill bill) {
        checkTableBill();
        connection = dbConnection.connection;
        String query = "INSERT INTO bill(date, carId, rentalId, customerId) VALUES (?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, bill.getDate());
            preparedStatement.setInt(2, bill.getCarId());
            preparedStatement.setInt(3, bill.getRentalId());
            preparedStatement.setInt(4, bill.getCustomerId());

            int status = preparedStatement.executeUpdate();
            return (status > 0);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Bill getBillById(int billno) {
        connection = dbConnection.connection;
        String query = "SELECT * FROM bill WHERE billno= ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, billno);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Bill bill = new Bill();
                bill.setRentalId(resultSet.getInt("rentalId"));
                bill.setBillNo(resultSet.getInt("billNo"));
                bill.setCustomerId(resultSet.getInt("customerId"));
                bill.setDate(resultSet.getDate("date"));

                return bill;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean updateBill(Bill bill) {
        connection = dbConnection.connection;
        String query = "UPDATE bill SET date = ?, carId = ?, rentalId = ?, customerId = ? WHERE billNo = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, new java.sql.Date(bill.getDate().getTime()));
            preparedStatement.setInt(2, bill.getCarId());
            preparedStatement.setInt(3, bill.getRentalId());
            preparedStatement.setInt(4, bill.getCustomerId());
            preparedStatement.setInt(5, bill.getBillNo());

            int status = preparedStatement.executeUpdate();
            return (status > 0);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean deleteBill(int billNo) {
        connection = dbConnection.connection;
        String query = "DELETE FROM bill WHERE billNo = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, billNo);

            int status = preparedStatement.executeUpdate();
            return (status > 0);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public ArrayList<Bill> listBills() {
        ArrayList<Bill> billsList = new ArrayList<Bill>();
        connection = dbConnection.connection;
        String query = "SELECT * FROM bill";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int billNo = resultSet.getInt("billNo");
                Date date = resultSet.getDate("date");
                int carId = resultSet.getInt("carId");
                int rentalId = resultSet.getInt("rentalId");
                int customerId = resultSet.getInt("customerId");
                Bill bill = new Bill();
                bill.setBillNo(billNo);
                bill.setDate(date);
                bill.setCarId(carId);
                bill.setCustomerId(customerId);
                bill.setRentalId(rentalId);
                billsList.add(bill);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return billsList;
    }
    public void printList(){
        for (Bill bill : listBills()){
            System.out.println(bill.getBillNo());
        }
    }


}

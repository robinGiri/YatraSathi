package service;

import database.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.MonthlyIncome;

public class HomeService {
    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;
    private DbConnection dbConnection = new DbConnection();

    public ArrayList<MonthlyIncome> calculateTotalIncome() {
        ArrayList<MonthlyIncome> incomeList = new ArrayList<>();
        connection = dbConnection.connection;
        String query = """
                SELECT
                    MONTH(b.date) AS month,
                    SUM(DATEDIFF(r.returnDateTime, r.rentalDateTime) * c.rate) AS totalAmount,
                    SUM((DATEDIFF(r.returnDateTime, r.rentalDateTime) * c.rate) *
                        CASE
                            WHEN u.subscription = 'platinum' THEN 0.2
                            WHEN u.subscription = 'gold' THEN 0.1
                            WHEN u.subscription = 'silver' THEN 0.05
                            ELSE 0
                        END) AS totalDiscount,
                    SUM((DATEDIFF(r.returnDateTime, r.rentalDateTime) * c.rate) -
                        ((DATEDIFF(r.returnDateTime, r.rentalDateTime) * c.rate) *
                        CASE
                            WHEN u.subscription = 'platinum' THEN 0.2
                            WHEN u.subscription = 'gold' THEN 0.1
                            WHEN u.subscription = 'silver' THEN 0.05
                            ELSE 0
                        END)) AS totalAfterDiscount,
                    COUNT(*) AS numberOfBills
                FROM
                    bill b
                JOIN
                    car c ON b.carId = c.carId
                JOIN
                    rental r ON b.rentalId = r.rentalId
                JOIN
                    user u ON b.customerId = u.userId
                GROUP BY
                    MONTH(b.date)
                ORDER BY
                    MONTH(b.date);""";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                MonthlyIncome income = new MonthlyIncome(
                    resultSet.getInt("month"),
                    resultSet.getDouble("totalAmount"),
                    resultSet.getDouble("totalDiscount"),
                    resultSet.getDouble("totalAfterDiscount"),
                    resultSet.getInt("numberOfBills")
                );
                incomeList.add(income);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return incomeList;
    }
    public static void main(String[] args) {
        HomeService homeService = new HomeService();
        ArrayList<MonthlyIncome> incomeList = homeService.calculateTotalIncome();

        // Display the monthly income data
        for (MonthlyIncome income : incomeList) {
            System.out.println("Month: " + income.getMonth());
            System.out.println("Total Amount: " + income.getTotalAmount());
            System.out.println("Total Discount: " + income.getTotalDiscount());
            System.out.println("Total After Discount: " + income.getTotalAfterDiscount());
            System.out.println("Number of Bills: " + income.getNumberOfBills());
            System.out.println("------------------------------");
        }
    }
}

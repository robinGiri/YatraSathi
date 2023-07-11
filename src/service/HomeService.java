package service;

import database.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Income;

public class HomeService {
    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;
    private DbConnection dbConnection = new DbConnection();

    public ArrayList<Income> calculateTotalIncome() {
        ArrayList<Income> incomeList = new ArrayList<>();
        connection = dbConnection.connection;
        String query = """
                SELECT YEAR(rentalDateTime) AS rental_year, MONTH(rentalDateTime) AS rental_month, SUM(totalPrice) AS total_income
                FROM rental
                GROUP BY rental_year, rental_month
                ORDER BY rental_year, rental_month;""";
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Income income = new Income(resultSet.getInt("rental_year"), resultSet.getInt("rental_month"),
                        resultSet.getDouble("total_income"));
                incomeList.add(income);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return incomeList;
    }
}
